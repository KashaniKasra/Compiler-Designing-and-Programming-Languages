package main.visitor;

import main.ast.nodes.VariableInfo;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.AssignmentOperator;
import main.ast.nodes.expr.primitives.*;
import main.ast.nodes.expr.primitives.constants.*;
import main.ast.nodes.node.*;
import main.ast.nodes.node.design.*;
import main.ast.nodes.node.direct_abstract_declarator.*;
import main.ast.nodes.node.direct_declarator.*;
import main.ast.nodes.node.initial.*;
import main.ast.nodes.node.type.*;
import main.ast.nodes.stmt.*;
import main.ast.nodes.stmt.iteration.*;
import main.ast.nodes.stmt.jump.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.item.*;

import java.util.*;

public class VulnAnalysis extends Visitor<Void> {
    private String currCallerFunc;
    private ArrayList<FunctionDefinition> functionDefinitions = new ArrayList<FunctionDefinition>();
    private ArrayList<Declaration> malloc_declarations = new ArrayList<Declaration>();
    private boolean initialize_flag = true;
    public static ArrayList<String> vuln_analysis_logs = new ArrayList<String >();
    public static ArrayList<FunctionCallExpression> functionCallExpressions = new ArrayList<FunctionCallExpression>();
    public static Map<String, ArrayList<FunctionCallExpression>> callMap = new HashMap<>();
    public static boolean isFirstTime = true;

    private String extractFunctionName(DirectDeclarator dd) {
        if (dd instanceof IdentifierDeclarator)
            return ((IdentifierDeclarator)dd).getId();
        else if (dd instanceof FunctionDeclarator)
            return extractFunctionName(((FunctionDeclarator)dd).getDirectDeclarator());
        else if (dd instanceof ArrayDeclarator)
            return extractFunctionName(((ArrayDeclarator)dd).getDirectDeclarator());
        else if (dd instanceof NestedDeclarator)
            return extractFunctionName(((NestedDeclarator)dd).getDeclarator().getDirectDeclarator());

        return null;
    }

    private FunctionDefinition findFunctionDefinition(String funcName) {
        for (FunctionDefinition functionDefinition : functionDefinitions)
            if (functionDefinition != null)
                if (functionDefinition.getFunctionName().equals(funcName))
                    return functionDefinition;

        return null;
    }

    private int extractParameterNumber(FunctionDefinition functionDefinition, String parameterName) {
        int parameterNumber = 0;
        ArrayList<ParameterDeclaration> parameters = ((FunctionDeclarator)functionDefinition.getDeclarator().getDirectDeclarator()).getParameters();

        for (ParameterDeclaration parameter : parameters) {
            String varName;
            if (parameter.getDeclarator() == null)
                varName = ((TypeSpecifier)parameter.getTypeSpecifiers().get(parameter.getTypeSpecifiers().size() - 1).getType()).getType();
            else
                varName = ((IdentifierDeclarator)parameter.getDeclarator().getDirectDeclarator()).getId();

            if (varName.equals(parameterName))
                return parameterNumber;
            else
                parameterNumber ++;
        }

        return -1;
    }

    private void makeParametersFree() {
        Deque<AbstractMap.SimpleEntry<String, Integer>> stack = new ArrayDeque<>();

        for (FunctionDefinition functionDefinition : functionDefinitions)
            if (functionDefinition != null)
                if (!functionDefinition.getFreeParameters().isEmpty())
                    for (int parameterNumber : functionDefinition.getFreeParameters())
                        stack.push(new AbstractMap.SimpleEntry<>(functionDefinition.getFunctionName(), parameterNumber));

        while (!stack.isEmpty()) {
            AbstractMap.SimpleEntry<String, Integer> current = stack.pop();
            String functionName = current.getKey();
            int parameterNumber = current.getValue();

            for (String callerName : callMap.keySet())
                for (FunctionCallExpression callee : callMap.get(callerName)) {
                    String calleeName = ((Identifier)callee.getName()).getName() + "_" + Integer.toString(callee.getParameters().size());

                    if (calleeName.equals(functionName)) {
                        try {
                            String parameterName = ((Identifier) callee.getParameters().get(parameterNumber)).getName();
                            VariableDeclarationSymbolTableItem var_item = (VariableDeclarationSymbolTableItem)callee.getSymbolTable().getItem(VariableDeclarationSymbolTableItem.START_KEY + parameterName);

                            if (var_item.getVariableInfo().getDeclaration() instanceof Declaration)
                                ((Declaration)var_item.getVariableInfo().getDeclaration()).setIsFree(true);
                            else if (var_item.getVariableInfo().getDeclaration() instanceof ParameterDeclaration) {
                                int parameterNumber_new = extractParameterNumber(findFunctionDefinition(callerName), parameterName);
                                stack.push(new AbstractMap.SimpleEntry<>(callerName, parameterNumber_new));
                            }
                        } catch(ItemNotFoundException e) {

                        }
                    }
                }
        }
    }

    private void checkFree() {
        for (Declaration declaration : malloc_declarations)
            if (!declaration.getIsFree()) {
                String msg = "Line:" + declaration.getLine() + " -> memory not deallocated ";
                vuln_analysis_logs.add(msg);
            }

    }

    private ArrayList<String> extractScannedNames(List<Expression> parameters) {
        ArrayList<String> scannedNames = new ArrayList<String>();

        for (Expression parameter : parameters)
            if (parameter != null)
                if (parameter instanceof NestedUnaryExpression)
                    scannedNames.add(((Identifier)((UnaryCastExpression)((NestedUnaryExpression)parameter).getOperand()).getExpression()).getName());

        return scannedNames;
    }

    private boolean haveScannedVar(Expression expression, SymbolTable symbolTable) {
        if (expression instanceof Identifier identifier) {
            try {
                VariableDeclarationSymbolTableItem var_item = (VariableDeclarationSymbolTableItem)symbolTable.getItem(VariableDeclarationSymbolTableItem.START_KEY + identifier.getName());
                if (var_item.getVariableInfo().getIsScan())
                    return true;
            } catch(ItemNotFoundException e) {

            }
        }
        else if (expression instanceof FunctionCallExpression || expression instanceof ConstantVal || expression instanceof StringLiteral || expression instanceof SizeofTypeNameExpression)
            return false;
        else if (expression instanceof UnaryExpression unaryExpression)
            return haveScannedVar(unaryExpression.getOperand(), symbolTable);
        else if (expression instanceof ParanthesisExpression paranthesisExpression)
            return haveScannedVar(paranthesisExpression.getExpression(), symbolTable);
        else if (expression instanceof ArrayExpression arrayExpression)
            return haveScannedVar(arrayExpression.getIndex(), symbolTable);
        else if (expression instanceof BinaryExpression binaryExpression)
            return haveScannedVar(binaryExpression.getLeft(), symbolTable) || haveScannedVar(binaryExpression.getRight(), symbolTable);
        else if (expression instanceof QuestionColonExpression questionColonExpression)
            return haveScannedVar(questionColonExpression.getTrueBody(), symbolTable) || haveScannedVar(questionColonExpression.getFalseBody(), symbolTable);
        else if (expression instanceof CastExpression castExpression)
            return haveScannedVar(castExpression.getExpression(), symbolTable);
        else if (expression instanceof NestedUnaryExpression nestedUnaryExpression) {
            return haveScannedVar(nestedUnaryExpression.getOperand(), symbolTable);
        }

        return false;
    }

    private boolean haveUninitializedVar(Expression expression, SymbolTable symbolTable) {
        if (expression instanceof Identifier identifier) {
            try {
                VariableDeclarationSymbolTableItem var_item = (VariableDeclarationSymbolTableItem)symbolTable.getItem(VariableDeclarationSymbolTableItem.START_KEY + identifier.getName());
                if (!var_item.getVariableInfo().getIsInitialized())
                    return true;
            } catch(ItemNotFoundException e) {

            }
        }
        else if (expression instanceof FunctionCallExpression functionCallExpression) {
            if (functionCallExpression.getParameters() == null || functionCallExpression.getParameters().isEmpty())
                return false;
            else
                for (Expression parameter : functionCallExpression.getParameters())
                    if (!(parameter instanceof Identifier))
                        if (haveUninitializedVar(parameter, symbolTable))
                            return true;
        }
        else if (expression instanceof ConstantVal || expression instanceof StringLiteral || expression instanceof SizeofTypeNameExpression)
            return false;
        else if (expression instanceof UnaryExpression unaryExpression)
            return haveUninitializedVar(unaryExpression.getOperand(), symbolTable);
        else if (expression instanceof ParanthesisExpression paranthesisExpression)
            return haveUninitializedVar(paranthesisExpression.getExpression(), symbolTable);
        else if (expression instanceof ArrayExpression arrayExpression)
            return haveUninitializedVar(arrayExpression.getIndex(), symbolTable);
        else if (expression instanceof BinaryExpression binaryExpression)
            return haveUninitializedVar(binaryExpression.getLeft(), symbolTable) || haveUninitializedVar(binaryExpression.getRight(), symbolTable);
        else if (expression instanceof QuestionColonExpression questionColonExpression)
            return haveUninitializedVar(questionColonExpression.getTrueBody(), symbolTable) || haveUninitializedVar(questionColonExpression.getFalseBody(), symbolTable);
        else if (expression instanceof CastExpression castExpression)
            return haveUninitializedVar(castExpression.getExpression(), symbolTable);
        else if (expression instanceof NestedUnaryExpression nestedUnaryExpression) {
            return haveUninitializedVar(nestedUnaryExpression.getOperand(), symbolTable);
        }

        return false;
    }

    @Override
    public Void visit(CompilationUnit compilationUnit) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;

        compilationUnit.setSymbolTable(SymbolTable.top);

        if (compilationUnit.getTranslationUnit() != null)
            compilationUnit.getTranslationUnit().accept(this);

        makeParametersFree();
        checkFree();

        return null;
    }

    @Override
    public Void visit(TranslationUnit translationUnit) {
        if (translationUnit.getExternalDeclarations() != null)
            for (ExternalDeclaration externalDeclaration : translationUnit.getExternalDeclarations())
                if (externalDeclaration != null)
                    externalDeclaration.accept(this);

        return null;
    }

    @Override
    public Void visit(ExternalDeclaration externalDeclaration) {
        if (externalDeclaration.getNode() != null)
            if (externalDeclaration.getNode() instanceof FunctionDefinition)
                functionDefinitions.add((FunctionDefinition)externalDeclaration.getNode());

        if (externalDeclaration.getNode() != null)
            externalDeclaration.getNode().accept(this);

        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition) {
        if (functionDefinition.getTypeSpecifiers() != null)
            for (DeclarationSpecifier declarationSpecifier : functionDefinition.getTypeSpecifiers())
                if (declarationSpecifier != null)
                    if (declarationSpecifier.getType() instanceof TypeSpecifier) {
                        try {
                            TypedefSymbolTableItem typedef_item = (TypedefSymbolTableItem) SymbolTable.top.getItem(TypedefSymbolTableItem.START_KEY + ((TypeSpecifier) declarationSpecifier.getType()).getType());
                            ((TypeSpecifier) declarationSpecifier.getType()).setType(typedef_item.getOriginalType());
                        } catch (ItemNotFoundException e) {

                        }
                    }

        if (functionDefinition.getDeclarator() != null)
            if (functionDefinition.getDeclarator().getDirectDeclarator() != null)
                if (functionDefinition.getDeclarator().getDirectDeclarator() instanceof FunctionDeclarator)
                    for (ParameterDeclaration parameterDeclaration : ((FunctionDeclarator) functionDefinition.getDeclarator().getDirectDeclarator()).getParameters())
                        if (parameterDeclaration != null)
                            for (DeclarationSpecifier declarationSpecifier : parameterDeclaration.getTypeSpecifiers())
                                if (declarationSpecifier != null)
                                    if (declarationSpecifier.getType() != null)
                                        if (declarationSpecifier.getType() instanceof TypeSpecifier) {
                                            try {
                                                TypedefSymbolTableItem typedef_item = (TypedefSymbolTableItem) SymbolTable.top.getItem(TypedefSymbolTableItem.START_KEY + ((TypeSpecifier) declarationSpecifier.getType()).getType());
                                                ((TypeSpecifier) declarationSpecifier.getType()).setType(typedef_item.getOriginalType());
                                            } catch (ItemNotFoundException e) {

                                            }
                                        }

        ArrayList<ParameterDeclaration> parameters = new ArrayList<ParameterDeclaration>();
        Declarator declarator = functionDefinition.getDeclarator();

        if (declarator != null) {
            DirectDeclarator directDeclarator = declarator.getDirectDeclarator();

            String functionName = extractFunctionName(directDeclarator);
            int parametersCount = functionDefinition.computeParametersCount();
            if (functionName != null) {
                if (functionName.equals("main")) {
                    functionDefinition.setFunctionName(functionName);
                    functionDefinition.setIsUsed(true);
                    currCallerFunc = functionName;
                }
                else {
                    functionDefinition.setFunctionName(functionName + "_" + Integer.toString(parametersCount));
                    currCallerFunc= functionName + "_" + Integer.toString(parametersCount);
                }

                functionDefinition.setOriginalFunctionName(functionName);
            }

            parameters = ((FunctionDeclarator)directDeclarator).getParameters();
        }

        FunctionDefinitionSymbolTableItem funcDec_item = new FunctionDefinitionSymbolTableItem(functionDefinition);
        try {
            SymbolTable.top.put(funcDec_item);
        } catch (ItemAlreadyExistsException e) {

        }

        SymbolTable func_dec_symbol_table = new SymbolTable(SymbolTable.top);
        functionDefinition.setSymbolTable(func_dec_symbol_table);
        SymbolTable.push(func_dec_symbol_table);

        for (ParameterDeclaration parameter : parameters) {
            if (parameter.getDeclarator() == null) {
                ArrayList<DeclarationSpecifier> typeSpecifiers = new ArrayList<DeclarationSpecifier>(parameter.getTypeSpecifiers().subList(0, parameter.getTypeSpecifiers().size() - 1));
                String varName = ((TypeSpecifier)parameter.getTypeSpecifiers().get(parameter.getTypeSpecifiers().size() - 1).getType()).getType();
                Initializer initializer = null;
                boolean is_initialized = false;
                boolean have_pointer = false;

                VariableInfo variableInfo = new VariableInfo(typeSpecifiers, varName, initializer, parameter, is_initialized, have_pointer);
                variableInfo.setIsInitialized(true);
                VariableDeclarationSymbolTableItem varDec_item = new VariableDeclarationSymbolTableItem(variableInfo);
                try {
                    SymbolTable.top.put(varDec_item);
                } catch (ItemAlreadyExistsException e) {

                }
            }
            else {
                ArrayList<DeclarationSpecifier> typeSpecifiers = parameter.getTypeSpecifiers();
                String varName = ((IdentifierDeclarator)parameter.getDeclarator().getDirectDeclarator()).getId();
                Initializer initializer = null;
                boolean is_initialized = false;
                boolean have_pointer = false;

                VariableInfo variableInfo = new VariableInfo(typeSpecifiers, varName, initializer, parameter, is_initialized, have_pointer);
                variableInfo.setIsInitialized(true);
                VariableDeclarationSymbolTableItem varDec_item = new VariableDeclarationSymbolTableItem(variableInfo);
                try {
                    SymbolTable.top.put(varDec_item);
                } catch (ItemAlreadyExistsException e) {

                }
            }
        }

        if (functionDefinition.getTypeSpecifiers() != null)
            for (DeclarationSpecifier declarationSpecifier : functionDefinition.getTypeSpecifiers())
                if (declarationSpecifier != null)
                    declarationSpecifier.accept(this);

        if (functionDefinition.getDeclarator() != null)
            functionDefinition.getDeclarator().accept(this);

        if (functionDefinition.getDeclarations() != null)
            for (Declaration declaration : functionDefinition.getDeclarations())
                if (declaration != null)
                    declaration.accept(this);

        if (functionDefinition.getCompoundStatement() != null)
            functionDefinition.getCompoundStatement().accept(this);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(Declaration declaration) {
        if (declaration.getTypeSpecifiers() != null)
            if (declaration.getTypeSpecifiers().get(0) != null)
                if (declaration.getTypeSpecifiers().get(0).getType() != null) {
                    if (declaration.getTypeSpecifiers().get(0).getType() instanceof Typedefs) {
                        String new_type = ((TypeSpecifier)declaration.getTypeSpecifiers().get(declaration.getTypeSpecifiers().size() - 1).getType()).getType();
                        String original_type = ((TypeSpecifier)declaration.getTypeSpecifiers().get(1).getType()).getType();

                        TypedefSymbolTableItem typedef_item = new TypedefSymbolTableItem(new_type, original_type);
                        try {
                            SymbolTable.top.put(typedef_item);
                        } catch (ItemAlreadyExistsException e) {

                        }
                    }
                    else
                        for (DeclarationSpecifier declarationSpecifier : declaration.getTypeSpecifiers())
                            if (declarationSpecifier != null)
                                if (declarationSpecifier.getType() instanceof TypeSpecifier) {
                                    try {
                                        TypedefSymbolTableItem typedef_item = (TypedefSymbolTableItem) SymbolTable.top.getItem(TypedefSymbolTableItem.START_KEY + ((TypeSpecifier) declarationSpecifier.getType()).getType());
                                        ((TypeSpecifier) declarationSpecifier.getType()).setType(typedef_item.getOriginalType());
                                    } catch (ItemNotFoundException e) {

                                    }
                                }
                }

        ArrayList<DeclarationSpecifier> declarationSpecifiers = declaration.getTypeSpecifiers();
        ArrayList<InitDeclarator> initDeclarators = declaration.getInitDeclarators();
        boolean have_pointer = false;

        if (initDeclarators != null && !initDeclarators.isEmpty())
            for (InitDeclarator initDeclarator : initDeclarators)
                if (initDeclarator != null)
                    if (initDeclarator.getDeclarator() != null)
                        if (initDeclarator.getDeclarator().getPointer() != null) {
                            have_pointer = true;
                            malloc_declarations.add(declaration);
                        }

        if (initDeclarators == null || initDeclarators.isEmpty()) {
            ArrayList<DeclarationSpecifier> typeSpecifiers = new ArrayList<DeclarationSpecifier>(declarationSpecifiers.subList(0, declarationSpecifiers.size() - 1));
            String name = ((TypeSpecifier)declarationSpecifiers.get(declarationSpecifiers.size() - 1).getType()).getType();
            Initializer initializer = null;
            boolean is_initialized = false;

            VariableInfo variableInfo = new VariableInfo(typeSpecifiers, name, initializer, declaration, is_initialized, have_pointer);

            VariableDeclarationSymbolTableItem varDec_item = new VariableDeclarationSymbolTableItem(variableInfo);
            try {
                SymbolTable.top.put(varDec_item);
            } catch (ItemAlreadyExistsException e) {

            }
        }
        else if (initDeclarators != null && !initDeclarators.isEmpty() && initDeclarators.get(initDeclarators.size() - 1).getInitializer() == null) {
            ArrayList<DeclarationSpecifier> typeSpecifiers = declarationSpecifiers;
            String name = ((IdentifierDeclarator)((ArrayDeclarator)initDeclarators.get(initDeclarators.size() - 1).getDeclarator().getDirectDeclarator()).getDirectDeclarator()).getId();
            Initializer initializer = null;
            boolean is_initialized = false;

            VariableInfo variableInfo = new VariableInfo(typeSpecifiers, name, initializer, declaration, is_initialized, have_pointer);

            VariableDeclarationSymbolTableItem varDec_item = new VariableDeclarationSymbolTableItem(variableInfo);
            try {
                SymbolTable.top.put(varDec_item);
            } catch (ItemAlreadyExistsException e) {

            }
        }
        else {
            for (InitDeclarator initDeclarator : initDeclarators) {
                ArrayList<DeclarationSpecifier> typeSpecifiers = declarationSpecifiers;
                String name = null;
                if (initDeclarator.getDeclarator().getDirectDeclarator() instanceof IdentifierDeclarator)
                    name = ((IdentifierDeclarator)initDeclarator.getDeclarator().getDirectDeclarator()).getId();
                else if (initDeclarator.getDeclarator().getDirectDeclarator() instanceof ArrayDeclarator)
                    name = ((IdentifierDeclarator)((ArrayDeclarator)initDeclarator.getDeclarator().getDirectDeclarator()).getDirectDeclarator()).getId();

                Initializer initializer = initDeclarator.getInitializer();
                boolean is_initialized = (initializer != null);

                VariableInfo variableInfo = new VariableInfo(typeSpecifiers, name, initializer, declaration, is_initialized, have_pointer);

                VariableDeclarationSymbolTableItem varDec_item = new VariableDeclarationSymbolTableItem(variableInfo);
                try {
                    SymbolTable.top.put(varDec_item);
                } catch (ItemAlreadyExistsException e) {

                }
            }
        }

        if (declaration.getTypeSpecifiers() != null)
            for (DeclarationSpecifier typeSpecifier : declaration.getTypeSpecifiers())
                if (typeSpecifier != null)
                    typeSpecifier.accept(this);

        if (declaration.getInitDeclarators() != null)
            for (InitDeclarator initDeclarator : declaration.getInitDeclarators())
                if (initDeclarator != null)
                    initDeclarator.accept(this);

        return null;
    }

    @Override
    public Void visit(Pointer pointer) { return null; }

    @Override
    public Void visit(TypeSpecifier typeSpecifier) { return null; }

    @Override
    public Void visit(Typedefs typedefs) { return null; }

    @Override
    public Void visit(Consts consts) { return null; }

    @Override
    public Void visit(InitDeclarator initDeclarator) {
        if (initDeclarator.getInitializer() != null)
            if (initDeclarator.getDeclarator() != null)
                if (haveScannedVar(((ExpressionInitializer)initDeclarator.getInitializer()).getExpression(), SymbolTable.top)) {
                    try {
                        VariableDeclarationSymbolTableItem item = (VariableDeclarationSymbolTableItem) SymbolTable.top.getItem(VariableDeclarationSymbolTableItem.START_KEY + ((IdentifierDeclarator) initDeclarator.getDeclarator().getDirectDeclarator()).getId());
                        item.getVariableInfo().setIsScan(true);
                    } catch(ItemNotFoundException e) {

                    }
                }

        if (initDeclarator.getInitializer() != null)
            initDeclarator.getInitializer().accept(this);

        if (initDeclarator.getDeclarator() != null)
            initDeclarator.getDeclarator().accept(this);

        return null;
    }

    @Override
    public Void visit(Declarator declarator) {
        if (declarator.getPointer() != null)
            declarator.getPointer().accept(this);

        if (declarator.getDirectDeclarator() != null)
            declarator.getDirectDeclarator().accept(this);

        return null;
    }

    @Override
    public Void visit(DeclarationSpecifier declarationSpecifier) {
        if (declarationSpecifier.getType() != null)
            declarationSpecifier.getType().accept(this);

        return null;
    }

    @Override
    public Void visit(IdentifierDeclarator identifierDeclarator) { return null; }

    @Override
    public Void visit(NestedDeclarator nestedDeclarator) {
        if (nestedDeclarator.getDeclarator() != null)
            nestedDeclarator.getDeclarator().accept(this);

        return null;
    }

    @Override
    public Void visit(ArrayDeclarator arrayDeclarator) {
        if (arrayDeclarator.getDirectDeclarator() != null)
            arrayDeclarator.getDirectDeclarator().accept(this);

        if (arrayDeclarator.getExpression() != null)
            arrayDeclarator.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(FunctionDeclarator functionDeclarator) {
        if (functionDeclarator.getDirectDeclarator() != null)
            functionDeclarator.getDirectDeclarator().accept(this);

        if (functionDeclarator.getParameters() != null)
            for (ParameterDeclaration parameter : functionDeclarator.getParameters())
                if (parameter != null)
                    parameter.accept(this);

        return null;
    }

    @Override
    public Void visit(ParameterDeclaration parameterDeclaration) {
        if (parameterDeclaration.getTypeSpecifiers() != null)
            for (DeclarationSpecifier typeSpecifier : parameterDeclaration.getTypeSpecifiers())
                if (typeSpecifier != null)
                    typeSpecifier.accept(this);

        if (parameterDeclaration.getDeclarator() != null)
            parameterDeclaration.getDeclarator().accept(this);

        if (parameterDeclaration.getAbstractDeclarator() != null)
            parameterDeclaration.getAbstractDeclarator().accept(this);

        return null;
    }

    @Override
    public Void visit(AbstractDeclarator abstractDeclarator) {
        if (abstractDeclarator.getPointer() != null)
            abstractDeclarator.getPointer().accept(this);

        if (abstractDeclarator.getDirectAbstractDeclarator() != null)
            abstractDeclarator.getDirectAbstractDeclarator().accept(this);

        return null;
    }

    @Override
    public Void visit(ExpressionAbstractDeclarator expressionAbstractDeclarator) {
        if (expressionAbstractDeclarator.getExpression() != null)
            expressionAbstractDeclarator.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(NestedAbstractDeclarator nestedAbstractDeclarator) {
        if (nestedAbstractDeclarator.getAbstractDeclarator() != null)
            nestedAbstractDeclarator.getAbstractDeclarator().accept(this);

        if (nestedAbstractDeclarator.getParameters() != null)
            for (ParameterDeclaration parameter : nestedAbstractDeclarator.getParameters())
                if (parameter != null)
                    parameter.accept(this);

        return null;
    }

    @Override
    public Void visit(ArrayAbstractDeclarator arrayAbstractDeclarator) {
        if (arrayAbstractDeclarator.getDirectAbstractDeclarator() != null)
            arrayAbstractDeclarator.getDirectAbstractDeclarator().accept(this);

        if (arrayAbstractDeclarator.getExpression() != null)
            arrayAbstractDeclarator.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(FunctionAbstractDeclarator functionAbstractDeclarator) {
        if (functionAbstractDeclarator.getDirectAbstractDeclarator() != null)
            functionAbstractDeclarator.getDirectAbstractDeclarator().accept(this);

        if (functionAbstractDeclarator.getParameters() != null)
            for (ParameterDeclaration parameter : functionAbstractDeclarator.getParameters())
                if (parameter != null)
                    parameter.accept(this);

        return null;
    }

    @Override
    public Void visit(DesignationInitializer designationInitializer) {
        if (designationInitializer.getDesignations() != null)
            for (Designator designation : designationInitializer.getDesignations())
                if (designation != null)
                    designation.accept(this);

        if (designationInitializer.getInitializer() != null)
            designationInitializer.getInitializer().accept(this);

        return null;
    }

    @Override
    public Void visit(ExpressionInitializer expressionInitializer) {
        if (expressionInitializer.getExpression() != null)
            expressionInitializer.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(NestedInitializer nestedInitializer) {
        if (nestedInitializer.getInitializers() != null)
            for (DesignationInitializer initializer : nestedInitializer.getInitializers())
                if (initializer != null)
                    initializer.accept(this);

        return null;
    }

    @Override
    public Void visit(ExpressionDesignator expressionDesignator) {
        if (expressionDesignator.getExpression() != null)
            expressionDesignator.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(IdentifierDesignator identifierDesignator) { return null; }

    @Override
    public Void visit(TypeName typeName) {
        if (typeName.getTypeSpecifiers() != null)
            for (Type typeSpecifier : typeName.getTypeSpecifiers())
                if (typeSpecifier != null)
                    typeSpecifier.accept(this);

        if (typeName.getAbstractDeclarator() != null)
            typeName.getAbstractDeclarator().accept(this);

        return null;
    }

    @Override
    public Void visit(CompoundStatement compoundStatement) {
        if (compoundStatement.getBlockItems() != null)
            for (Node blockItem : compoundStatement.getBlockItems())
                if (blockItem != null)
                    blockItem.accept(this);

        return null;
    }

    @Override
    public Void visit(ExpressionStatement expressionStatement) {
        if (expressionStatement.getExpression() != null)
            expressionStatement.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(SelectionStatement selectionStatement) {
        SymbolTable if_symbol_table = new SymbolTable(SymbolTable.top);
        selectionStatement.setSymbolTable(if_symbol_table);
        SymbolTable.push(if_symbol_table);

        if (selectionStatement.getCondition() != null)
            selectionStatement.getCondition().accept(this);

        if (selectionStatement.getBodyStatement() != null)
            selectionStatement.getBodyStatement().accept(this);

        SymbolTable.pop();

        if (selectionStatement.getElseIfConditions() != null)
            for (Expression elseIfCondition : selectionStatement.getElseIfConditions())
                if (elseIfCondition != null)
                    elseIfCondition.accept(this);

        if (selectionStatement.getElseIfBodyStatements() != null)
            for (Statement elseIfBodyStatement : selectionStatement.getElseIfBodyStatements())
                if (elseIfBodyStatement != null) {
                    SymbolTable elseIf_symbol_table = new SymbolTable(SymbolTable.top);
                    selectionStatement.setSymbolTable(elseIf_symbol_table);
                    SymbolTable.push(elseIf_symbol_table);

                    elseIfBodyStatement.accept(this);

                    SymbolTable.pop();
                }

        if (selectionStatement.getElseStatement() != null) {
            SymbolTable else_symbol_table = new SymbolTable(SymbolTable.top);
            selectionStatement.setSymbolTable(else_symbol_table);
            SymbolTable.push(else_symbol_table);

            selectionStatement.getElseStatement().accept(this);

            SymbolTable.pop();
        }

        return null;
    }

    @Override
    public Void visit(WhileIteration whileIteration) {
        SymbolTable while_symbol_table = new SymbolTable(SymbolTable.top);
        whileIteration.setSymbolTable(while_symbol_table);
        SymbolTable.push(while_symbol_table);

        if (whileIteration.getCondition() != null)
            whileIteration.getCondition().accept(this);

        if (whileIteration.getBodyStatement() != null)
            whileIteration.getBodyStatement().accept(this);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(DoWhileIteration doWhileIteration) {
        SymbolTable do_while_symbol_table = new SymbolTable(SymbolTable.top);
        doWhileIteration.setSymbolTable(do_while_symbol_table);
        SymbolTable.push(do_while_symbol_table);

        if (doWhileIteration.getBodyStatement() != null)
            doWhileIteration.getBodyStatement().accept(this);

        if (doWhileIteration.getCondition() != null)
            doWhileIteration.getCondition().accept(this);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(ForIteration forIteration) {
        SymbolTable for_symbol_table = new SymbolTable(SymbolTable.top);
        forIteration.setSymbolTable(for_symbol_table);
        SymbolTable.push(for_symbol_table);

        if (forIteration.getForCondition() != null)
            forIteration.getForCondition().accept(this);

        if (forIteration.getBodyStatement() != null)
            forIteration.getBodyStatement().accept(this);

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(ForCondition forCondition) {
        if (forCondition.getInitial() != null)
            if (forCondition.getInitial() instanceof Declaration)
                for (DeclarationSpecifier declarationSpecifier : ((Declaration) forCondition.getInitial()).getTypeSpecifiers())
                    if (declarationSpecifier != null)
                        if (declarationSpecifier.getType() instanceof TypeSpecifier) {
                            try {
                                TypedefSymbolTableItem typedef_item = (TypedefSymbolTableItem) SymbolTable.top.getItem(TypedefSymbolTableItem.START_KEY + ((TypeSpecifier) declarationSpecifier.getType()).getType());
                                ((TypeSpecifier) declarationSpecifier.getType()).setType(typedef_item.getOriginalType());
                            } catch (ItemNotFoundException e) {

                            }
                        }

        if (forCondition.getInitial() != null)
            forCondition.getInitial().accept(this);

        if (forCondition.getConditions() != null)
            for (Expression condition : forCondition.getConditions())
                if (condition != null)
                    condition.accept(this);

        if (forCondition.getUpdates() != null)
            for (Expression update : forCondition.getUpdates())
                if (update != null)
                    update.accept(this);

        return null;
    }

    @Override
    public Void visit(ContinueJump continueJump) { return null; }

    @Override
    public Void visit(BreakJump breakJump) { return null; }

    @Override
    public Void visit(ReturnJump returnJump) {
        if (returnJump.getExpression() != null)
            returnJump.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        String varName = identifier.getName();

        try {
            VariableDeclarationSymbolTableItem item = (VariableDeclarationSymbolTableItem)SymbolTable.top.getItem(VariableDeclarationSymbolTableItem.START_KEY + varName);
            if (!isFirstTime)
                item.getVariableInfo().getDeclaration().setIsUsed(true);
            if (!item.getVariableInfo().getIsInitialized() && initialize_flag) {
                String msg = "Line:" + identifier.getLine() + " -> uninitialized variable used";
                vuln_analysis_logs.add(msg);
            }
            initialize_flag = true;
        } catch (ItemNotFoundException e) {

        }


        return null;
    }

    @Override
    public Void visit(IntegerConstant integerConstant) { return null; }

    @Override
    public Void visit(FloatingConstant floatingConstant)  { return null; }

    @Override
    public Void visit(CharacterConstant characterConstant)  { return null; }

    @Override
    public Void visit(StringLiteral stringLiteral) { return null; }

    @Override
    public Void visit(ParanthesisExpression paranthesisExpression) {
        if (paranthesisExpression.getExpression() != null)
            paranthesisExpression.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(CompoundExpression compoundExpression) {
        if (compoundExpression.getTypeName() != null)
            compoundExpression.getTypeName().accept(this);

        if (compoundExpression.getDesignationInitializers() != null)
            for (DesignationInitializer designationInitializer : compoundExpression.getDesignationInitializers())
                if (designationInitializer != null)
                    designationInitializer.accept(this);

        return null;
    }

    @Override
    public Void visit(ArrayExpression arrayExpression) {
        if (arrayExpression.getName() != null)
            arrayExpression.getName().accept(this);

        if (arrayExpression.getIndex() != null)
            arrayExpression.getIndex().accept(this);

        return null;
    }

    @Override
    public Void visit(FunctionCallExpression functionCallExpression) {
        functionCallExpression.setSymbolTable(SymbolTable.top);

        ArrayList<Expression> parameters = functionCallExpression.getParameters();
        int parametersCount = parameters.size();
        String funcName = ((Identifier)functionCallExpression.getName()).getName();

        if (!funcName.equals("printf"))
            for (Expression expression : parameters)
                if (!(expression instanceof Identifier))
                    if (haveUninitializedVar(expression, SymbolTable.top)) {
                        String msg = "Line:" + expression.getLine() + " -> uninitialized variable used";
                        vuln_analysis_logs.add(msg);
                    }

        try {
            if (funcName.equals("main")) {
                SymbolTable.top.getItem(FunctionDefinitionSymbolTableItem.START_KEY + funcName);
                functionCallExpressions.add(functionCallExpression);
                callMap.putIfAbsent(currCallerFunc, new ArrayList<>());
                callMap.get(currCallerFunc).add(functionCallExpression);
            }
            else if (funcName.equals("free")) {
                String parameterName = ((Identifier)parameters.get(parameters.size() - 1)).getName();
                VariableDeclarationSymbolTableItem var_item = (VariableDeclarationSymbolTableItem)SymbolTable.top.getItem(VariableDeclarationSymbolTableItem.START_KEY + parameterName);
                if (var_item.getVariableInfo().getDeclaration() instanceof Declaration)
                    ((Declaration)var_item.getVariableInfo().getDeclaration()).setIsFree(true);
                else if (var_item.getVariableInfo().getDeclaration() instanceof ParameterDeclaration) {
                    FunctionDefinitionSymbolTableItem func_item = (FunctionDefinitionSymbolTableItem)SymbolTable.top.getItem(FunctionDefinitionSymbolTableItem.START_KEY + currCallerFunc);
                    int parameterNumber = extractParameterNumber(func_item.getFunctionDefinition(), parameterName);
                    func_item.getFunctionDefinition().addFreeParameter(parameterNumber);
                }
            }
            else if (funcName.equals("scanf")) {
                ArrayList<String> scannedNames = extractScannedNames(parameters.subList(1, parameters.size()));
                for (String scannedName : scannedNames) {
                    VariableDeclarationSymbolTableItem scan_item = (VariableDeclarationSymbolTableItem) SymbolTable.top.getItem(VariableDeclarationSymbolTableItem.START_KEY + scannedName);
                    scan_item.getVariableInfo().setIsInitialized(true);
                    scan_item.getVariableInfo().setIsScan(true);
                }
            }
            else if (funcName.equals("malloc")) {
                if (haveUninitializedVar(parameters.get(0), SymbolTable.top)) {
                    String msg = "Line:" + parameters.get(0).getLine() + " -> uninitialized variable used";
                    vuln_analysis_logs.add(msg);
                }
                if (haveScannedVar(parameters.get(0), SymbolTable.top)) {
                    String msg = "Line:" + parameters.get(0).getLine() + " -> user-controlled value used in malloc";
                    vuln_analysis_logs.add(msg);
                }
            }
            else if (funcName.equals("printf")) {
                for (Expression expression : parameters) {
                    if (expression instanceof Identifier identifier) {
                        VariableDeclarationSymbolTableItem id_item = (VariableDeclarationSymbolTableItem) SymbolTable.top.getItem(VariableDeclarationSymbolTableItem.START_KEY + identifier.getName());
                        if (!id_item.getVariableInfo().getIsInitialized()) {
                            String msg = "Line:" + expression.getLine() + " -> uninitialized variable used";
                            vuln_analysis_logs.add(msg);
                        }
                    }
                    else if (haveUninitializedVar(expression, SymbolTable.top)) {
                        String msg = "Line:" + expression.getLine() + " -> uninitialized variable used";
                        vuln_analysis_logs.add(msg);
                    }
                }
            }
            else {
                SymbolTable.top.getItem(FunctionDefinitionSymbolTableItem.START_KEY + funcName + "_" + Integer.toString(parametersCount));
                functionCallExpressions.add(functionCallExpression);
                callMap.putIfAbsent(currCallerFunc, new ArrayList<>());
                callMap.get(currCallerFunc).add(functionCallExpression);
            }
        } catch (ItemNotFoundException e) {

        }

//        if (functionCallExpression.getName() != null)
//            functionCallExpression.getName().accept(this);

        if (functionCallExpression.getParameters() != null)
            for (Expression parameter : functionCallExpression.getParameters())
                if (parameter != null) {
                    initialize_flag = false;
                    parameter.accept(this);
                }

        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        if (unaryExpression.getOperand() != null)
            unaryExpression.getOperand().accept(this);

        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        if (binaryExpression.getLeft() != null)
            binaryExpression.getLeft().accept(this);

        if (binaryExpression.getRight() != null)
            binaryExpression.getRight().accept(this);

        return null;
    }

    @Override
    public Void visit(NestedUnaryExpression nestedUnaryExpression) {
        if (nestedUnaryExpression.getOperand() != null)
            nestedUnaryExpression.getOperand().accept(this);

        return null;
    }

    @Override
    public Void visit(CastExpression castExpression) {
        if (castExpression.getTypeName() != null)
            castExpression.getTypeName().accept(this);

        if (castExpression.getExpression() != null)
            castExpression.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(UnaryCastExpression unaryCastExpression) {
        if (unaryCastExpression.getExpression() != null)
            unaryCastExpression.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(SizeofTypeNameExpression sizeofTypeNameExpression) {
        if (sizeofTypeNameExpression.getTypeName() != null)
            sizeofTypeNameExpression.getTypeName().accept(this);

        return null;
    }

    @Override
    public Void visit(QuestionColonExpression questionColonExpression) {
        if (questionColonExpression.getCondition() != null)
            questionColonExpression.getCondition().accept(this);

        if (questionColonExpression.getTrueBody() != null)
            questionColonExpression.getTrueBody().accept(this);

        if (questionColonExpression.getFalseBody() != null)
            questionColonExpression.getFalseBody().accept(this);

        return null;
    }

    @Override
    public Void visit(AssignmentExpression assignmentExpression) {
        if (assignmentExpression.getLeft() != null)
            if (assignmentExpression.getOperator() != null)
                if (assignmentExpression.getOperator() == AssignmentOperator.ASSIGN)
                    try {
                        VariableDeclarationSymbolTableItem item = (VariableDeclarationSymbolTableItem)SymbolTable.top.getItem(VariableDeclarationSymbolTableItem.START_KEY + ((Identifier)assignmentExpression.getLeft()).getName());
                        item.getVariableInfo().setIsInitialized(true);
                    } catch (ItemNotFoundException e) {

                    }

        if (assignmentExpression.getRight() != null)
            if (assignmentExpression.getLeft() != null)
                if (haveScannedVar(assignmentExpression.getRight(), SymbolTable.top)) {
                    try {
                        VariableDeclarationSymbolTableItem item = (VariableDeclarationSymbolTableItem)SymbolTable.top.getItem(VariableDeclarationSymbolTableItem.START_KEY + ((Identifier)assignmentExpression.getLeft()).getName());
                        item.getVariableInfo().setIsScan(true);
                    } catch(ItemNotFoundException e) {

                    }
                }


        if (assignmentExpression.getRight() != null)
            assignmentExpression.getRight().accept(this);

        if (assignmentExpression.getLeft() != null)
            assignmentExpression.getLeft().accept(this);

        return null;
    }

    @Override
    public Void visit(CommaExpression commaExpression) {
        if (commaExpression.getExpressions() != null)
            for (Expression expression : commaExpression.getExpressions())
                if (expression != null)
                    expression.accept(this);

        return null;
    }
}