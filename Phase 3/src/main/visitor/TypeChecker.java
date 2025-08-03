package main.visitor;

import main.ast.nodes.VariableInfo;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.primitives.*;
import main.ast.nodes.expr.primitives.constants.*;
import main.ast.nodes.node.*;
import main.ast.nodes.node.design.*;
import main.ast.nodes.node.direct_abstract_declarator.*;
import main.ast.nodes.node.direct_declarator.*;
import main.ast.nodes.node.initial.*;
import main.ast.nodes.node.type.*;
import main.ast.nodes.node.type.Type;
import main.ast.nodes.stmt.*;
import main.ast.nodes.stmt.iteration.*;
import main.ast.nodes.stmt.jump.*;
import main.symbolTable.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.item.*;
import main.typeErrors.ArgumentTypeMismatch;
import main.typeErrors.NonSameOperands;
import main.typeErrors.ReturnTypeMismatch;
import main.typeErrors.TypeError;
import main.types.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TypeChecker extends Visitor<Void> {
    private final ArrayList<String> builtInFuncs = new ArrayList<>(Arrays.asList("printf", "scanf", "malloc", "free"));
    private String currCallerFunc;
    private ExpressionTypeEvaluator expression_type_evaluator = new ExpressionTypeEvaluator();
    private Types currFuncType = new NonType();
    public static ArrayList<TypeError> type_errors = new ArrayList<>();
    public static ArrayList<FunctionCallExpression> functionCallExpressions = new ArrayList<FunctionCallExpression>();
    public static Map<String, ArrayList<String>> callMap = new HashMap<>();
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

    private Types findType(String type) {
        return switch (type) {
            case "int" -> new IntType();
            case "double" -> new DoubleType();
            case "float" -> new FloatType();
            case "bool" -> new BoolType();
            case "char" -> new CharType();
            case "string" -> new StringType();
            case "long" -> new LongType();
            case "short" -> new ShortType();
            case "signed" -> new SignedType();
            case "unsigned" -> new UnsignedType();
            case "void" -> new VoidType();
            default -> new NonType();
        };
    }

    private boolean isSubtype(Types small, Types big) {
         return (small.getClass() == big.getClass()) ||
                 (big instanceof IntType && small instanceof ShortType) || (big instanceof IntType && small instanceof CharType) ||
                 (big instanceof DoubleType && small instanceof IntType) ||(big instanceof DoubleType && small instanceof FloatType) ||
                 (big instanceof DoubleType && small instanceof CharType) || (big instanceof DoubleType && small instanceof ShortType) ||
                 (big instanceof DoubleType && small instanceof LongType) || (big instanceof FloatType && small instanceof IntType) ||
                 (big instanceof FloatType && small instanceof ShortType) || (big instanceof FloatType && small instanceof CharType) ||
                 (big instanceof StringType && small instanceof CharType) || (big instanceof LongType && small instanceof IntType) ||
                 (big instanceof LongType && small instanceof CharType) || (big instanceof LongType && small instanceof ShortType ||
                 (big instanceof BoolType && small instanceof IntType) || (big instanceof BoolType && small instanceof DoubleType) ||
                 (big instanceof BoolType && small instanceof FloatType) || (big instanceof BoolType && small instanceof LongType) ||
                 (big instanceof BoolType && small instanceof ShortType) || (big instanceof BoolType && small instanceof SignedType) ||
                 (big instanceof BoolType && small instanceof UnsignedType));
    }

    @Override
    public Void visit(CompilationUnit compilationUnit) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;

        compilationUnit.setSymbolTable(SymbolTable.top);

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

        if (compilationUnit.getTranslationUnit() != null)
            compilationUnit.getTranslationUnit().accept(this);

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

        ArrayList<DeclarationSpecifier> types = functionDefinition.getTypeSpecifiers();
        String type_str;
        if (types.get(0).getType() instanceof Consts)
            type_str = ((TypeSpecifier)types.get(1).getType()).getType();
        else
            type_str = ((TypeSpecifier)types.get(0).getType()).getType();
        functionDefinition.setReturnType(findType(type_str));

        currFuncType = functionDefinition.getReturnType();

        for (ParameterDeclaration parameter : parameters) {
            if (parameter.getDeclarator() == null) {
                ArrayList<DeclarationSpecifier> typeSpecifiers = new ArrayList<DeclarationSpecifier>(parameter.getTypeSpecifiers().subList(0, parameter.getTypeSpecifiers().size() - 1));
                String varName = ((TypeSpecifier)parameter.getTypeSpecifiers().get(parameter.getTypeSpecifiers().size() - 1).getType()).getType();
                Initializer initializer = null;
                boolean is_initialized = false;
                boolean have_pointer = false;

                VariableInfo variableInfo = new VariableInfo(typeSpecifiers, varName, initializer, parameter, is_initialized, have_pointer);
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
                VariableDeclarationSymbolTableItem varDec_item = new VariableDeclarationSymbolTableItem(variableInfo);
                try {
                    SymbolTable.top.put(varDec_item);
                } catch (ItemAlreadyExistsException e) {

                }
            }
        }

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

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
                        if (initDeclarator.getDeclarator().getPointer() != null)
                            have_pointer = true;

        String type_str;
        if (declarationSpecifiers.get(0).getType() instanceof Consts)
            type_str = ((TypeSpecifier)declarationSpecifiers.get(1).getType()).getType();
        else
            type_str = ((TypeSpecifier)declarationSpecifiers.get(0).getType()).getType();
        declaration.setType(findType(type_str));

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
                boolean is_initialized = false;

                VariableInfo variableInfo = new VariableInfo(typeSpecifiers, name, initializer, declaration, is_initialized, have_pointer);

                VariableDeclarationSymbolTableItem varDec_item = new VariableDeclarationSymbolTableItem(variableInfo);
                try {
                    SymbolTable.top.put(varDec_item);
                    expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

                    Types left_type = declaration.getType();
                    Types right_type = ((ExpressionInitializer)initDeclarator.getInitializer()).getExpression().accept(this.expression_type_evaluator);
                    if (!have_pointer && !(right_type instanceof NonType))
                        if (!isSubtype(right_type, left_type))
                            type_errors.add(new NonSameOperands(declaration.getLine()));
                } catch (ItemAlreadyExistsException e) {

                }
            }
        }

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

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
        if (initDeclarator.getDeclarator() != null)
            initDeclarator.getDeclarator().accept(this);

        if (initDeclarator.getInitializer() != null)
            initDeclarator.getInitializer().accept(this);

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
        ArrayList<DeclarationSpecifier> types = parameterDeclaration.getTypeSpecifiers();
        String type_str;
        if (types.get(0).getType() instanceof Consts)
            type_str = ((TypeSpecifier)types.get(1).getType()).getType();
        else
            type_str = ((TypeSpecifier)types.get(0).getType()).getType();
        parameterDeclaration.setType(findType(type_str));

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

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

        if (selectionStatement.getCondition() != null)
            selectionStatement.getCondition().accept(this);

        if (selectionStatement.getBodyStatement() != null)
            selectionStatement.getBodyStatement().accept(this);

        SymbolTable.pop();

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

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

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

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

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

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

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

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

        expression_type_evaluator.setCurrSymbolTable(SymbolTable.top);

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
        Types return_type;
        if (returnJump.getExpression() != null)
            return_type = returnJump.getExpression().accept(this.expression_type_evaluator);
        else
            return_type = new VoidType();

        if (!isSubtype(return_type, currFuncType))
            type_errors.add(new ReturnTypeMismatch(returnJump.getLine()));

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
        ArrayList<Expression> parameters = functionCallExpression.getParameters();
        int parametersCount = parameters.size();
        String funcName = ((Identifier)functionCallExpression.getName()).getName();

        if (!builtInFuncs.contains(funcName)) {
            try {
                FunctionDefinitionSymbolTableItem func_item = (FunctionDefinitionSymbolTableItem)SymbolTable.top.getItem(FunctionDefinitionSymbolTableItem.START_KEY + funcName + "_" + Integer.toString(parametersCount));
                int parameterIndex = 0;
                for (Expression parameter : parameters) {
                    Types parameter_type = parameter.accept(this.expression_type_evaluator);
                    if (!isSubtype(parameter_type, ((FunctionDeclarator)func_item.getFunctionDefinition().getDeclarator().getDirectDeclarator()).getParameters().get(parameterIndex).getType()))
                        type_errors.add(new ArgumentTypeMismatch(functionCallExpression.getLine()));

                    parameterIndex ++;
                }

                if (funcName.equals("main")) {
                    SymbolTable.top.getItem(FunctionDefinitionSymbolTableItem.START_KEY + funcName);
                    functionCallExpressions.add(functionCallExpression);
                    callMap.putIfAbsent(currCallerFunc, new ArrayList<>());
                    callMap.get(currCallerFunc).add(funcName);
                }
                else {
                    SymbolTable.top.getItem(FunctionDefinitionSymbolTableItem.START_KEY + funcName + "_" + Integer.toString(parametersCount));
                    functionCallExpressions.add(functionCallExpression);
                    callMap.putIfAbsent(currCallerFunc, new ArrayList<>());
                    callMap.get(currCallerFunc).add(funcName + "_" + Integer.toString(parametersCount));
                }
            } catch (ItemNotFoundException e) {

            }
        }

//        if (functionCallExpression.getName() != null)
//            functionCallExpression.getName().accept(this);

        if (functionCallExpression.getParameters() != null)
            for (Expression parameter : functionCallExpression.getParameters())
                if (parameter != null)
                    parameter.accept(this);

        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        Types unary_type = unaryExpression.accept(this.expression_type_evaluator);
        if (unary_type instanceof NonType)
            this.type_errors.add(new NonSameOperands(unaryExpression.getLine()));

        if (unaryExpression.getOperand() != null)
            unaryExpression.getOperand().accept(this);

        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        Types binary_type = binaryExpression.accept(this.expression_type_evaluator);
        if (binary_type instanceof NonType)
            this.type_errors.add(new NonSameOperands(binaryExpression.getLine()));

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
        Types left_type = assignmentExpression.getLeft().accept(this.expression_type_evaluator);
        Types right_type = assignmentExpression.getRight().accept(this.expression_type_evaluator);
        if (!isSubtype(right_type, left_type) && !(right_type instanceof NonType))
            this.type_errors.add(new NonSameOperands(assignmentExpression.getLine()));

        if (assignmentExpression.getLeft() != null)
            assignmentExpression.getLeft().accept(this);

        if (assignmentExpression.getRight() != null)
            assignmentExpression.getRight().accept(this);

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