package main.visitor;

import main.ast.nodes.expr.*;
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

import java.util.*;

record ParamDelete(FunctionCallExpression funcCall, int index) {}

public class UnusedRemover extends Visitor<Void> {
    public static ArrayList<String> unused_logs = new ArrayList<String>();
    public static ArrayList<FunctionCallExpression> functionCallExpressions = NameAnalyzer.functionCallExpressions;
    public static Map<String, ArrayList<String>> callMap = NameAnalyzer.callMap;

    private Set<String> getReachablesFromMain() {
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("main");

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                if (callMap.containsKey(current))
                    for (String callee : callMap.get(current))
                        stack.push(callee);
            }
        }

        return visited;
    }

    @Override
    public Void visit(CompilationUnit compilationUnit) {
        if (compilationUnit.getTranslationUnit() != null)
            compilationUnit.getTranslationUnit().accept(this);

        return null;
    }

    @Override
    public Void visit(TranslationUnit translationUnit) {
        Set<String> reachableFunctions = getReachablesFromMain();

        if (translationUnit.getExternalDeclarations() != null)
            for (ExternalDeclaration externalDeclaration : translationUnit.getExternalDeclarations())
                if (externalDeclaration != null)
                    if (externalDeclaration.getNode() != null)
                        if (externalDeclaration.getNode() instanceof FunctionDefinition) {
                            if (reachableFunctions.contains(((FunctionDefinition) externalDeclaration.getNode()).getFunctionName()))
                                externalDeclaration.getNode().setIsUsed(true);
                            else
                                externalDeclaration.getNode().setIsUsed(false);
                        }

        ArrayList<ExternalDeclaration> deleteds = new ArrayList<ExternalDeclaration>();

        if (translationUnit.getExternalDeclarations() != null)
            for (ExternalDeclaration externalDeclaration : translationUnit.getExternalDeclarations())
                if (externalDeclaration != null)
                    if (externalDeclaration.getNode() != null) {
                        if (!externalDeclaration.getNode().getIsUsed()) {
                            if (externalDeclaration.getNode() instanceof FunctionDefinition) {
                                String msg = "Line:" + externalDeclaration.getLine() + " FUNCTION " + ((FunctionDefinition) externalDeclaration.getNode()).getFunctionName() + " is unused";
                                unused_logs.add(msg);
                                deleteds.add(externalDeclaration);
                            }
                            else if (externalDeclaration.getNode() instanceof Declaration) {
                                String msg = "Line:" + externalDeclaration.getLine() + " GLOBAL " + ((TypeSpecifier) ((Declaration)externalDeclaration.getNode()).getTypeSpecifiers().get(((Declaration)externalDeclaration.getNode()).getTypeSpecifiers().size() - 1).getType()).getType() + " is unused";
                                unused_logs.add(msg);
                                deleteds.add(externalDeclaration);
                            }
                        }
                        else if (externalDeclaration.getNode().getIsUsed())
                            externalDeclaration.getNode().setIsUsed(false);
                    }

        for(ExternalDeclaration externalDeclaration: deleteds)
            translationUnit.deleteExternalDeclaration(externalDeclaration);

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
        ArrayList<ParameterDeclaration> parameter_deleteds = new ArrayList<ParameterDeclaration>();
        ArrayList<ParamDelete> called_deleteds = new ArrayList<ParamDelete>();
        int parameterIndex = 0;

        if (functionDefinition.getDeclarator() != null)
            if (functionDefinition.getDeclarator().getDirectDeclarator() != null)
                if (((FunctionDeclarator)functionDefinition.getDeclarator().getDirectDeclarator()).getParameters() != null)
                    for (ParameterDeclaration parameterDeclaration : ((FunctionDeclarator)functionDefinition.getDeclarator().getDirectDeclarator()).getParameters()) {
                        if (parameterDeclaration != null) {
                            if (!parameterDeclaration.getIsUsed()) {
                                String msg = "Line:" + functionDefinition.getLine() + " PARAMETER " + ((TypeSpecifier) parameterDeclaration.getTypeSpecifiers().get(parameterDeclaration.getTypeSpecifiers().size() - 1).getType()).getType() + " is unused";
                                unused_logs.add(msg);
                                parameter_deleteds.add(parameterDeclaration);

                                if (functionCallExpressions != null)
                                    for (FunctionCallExpression functionCallExpression : functionCallExpressions)
                                        if (functionCallExpression != null) {
                                            if ((((Identifier) functionCallExpression.getName()).getName() + "_" + Integer.toString(functionCallExpression.getParameters().size())).equals(functionDefinition.getFunctionName())) {
                                                String msg2 = "Line:" + functionCallExpression.getLine() + " CALLED_PARAMETER " + parameterIndex + " is unused";
                                                unused_logs.add(msg2);
                                                called_deleteds.add(new ParamDelete(functionCallExpression, parameterIndex));
                                            }
                                        }
                            }
                            else if (parameterDeclaration.getIsUsed())
                                parameterDeclaration.setIsUsed(false);
                        }

                        parameterIndex ++;
                    }

        for(ParameterDeclaration parameterDeclaration: parameter_deleteds)
            functionDefinition.deleteParameterDeclaration(parameterDeclaration);

        called_deleteds.sort((a, b) -> Integer.compare(b.index(), a.index()));
        for (ParamDelete paramDelete : called_deleteds)
            paramDelete.funcCall().deleteParameter(paramDelete.index());

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

        return null;
    }

    @Override
    public Void visit(Declaration declaration) {
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
        ArrayList<Declaration> deleteds = new ArrayList<Declaration>();

        if (compoundStatement.getBlockItems() != null)
            for (Node blockItem : compoundStatement.getBlockItems())
                if (blockItem != null)
                    if (blockItem instanceof Declaration) {
                        if (!((Declaration)blockItem).getIsUsed()) {
                            String msg = "Line:" + blockItem.getLine() + " VARIABLE " + ((TypeSpecifier) ((Declaration) blockItem).getTypeSpecifiers().get(((Declaration) blockItem).getTypeSpecifiers().size() - 1).getType()).getType() + " is unused";
                            unused_logs.add(msg);
                            deleteds.add(((Declaration) blockItem));
                        }
                        else if (((Declaration)blockItem).getIsUsed())
                            ((Declaration)blockItem).setIsUsed(false);
                    }

        for(Declaration declaration: deleteds)
            compoundStatement.deleteDeclaration(declaration);

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
        if (selectionStatement.getCondition() != null)
            selectionStatement.getCondition().accept(this);

        if (selectionStatement.getBodyStatement() != null)
            selectionStatement.getBodyStatement().accept(this);

        if (selectionStatement.getElseIfConditions() != null)
            for (Expression elseIfCondition : selectionStatement.getElseIfConditions())
                if (elseIfCondition != null)
                    elseIfCondition.accept(this);

        if (selectionStatement.getElseIfBodyStatements() != null)
            for (Statement elseIfBodyStatement : selectionStatement.getElseIfBodyStatements())
                if (elseIfBodyStatement != null)
                    elseIfBodyStatement.accept(this);

        if (selectionStatement.getElseStatement() != null)
            selectionStatement.getElseStatement().accept(this);

        return null;
    }

    @Override
    public Void visit(WhileIteration whileIteration) {
        if (whileIteration.getCondition() != null)
            whileIteration.getCondition().accept(this);

        if (whileIteration.getBodyStatement() != null)
            whileIteration.getBodyStatement().accept(this);

        return null;
    }

    @Override
    public Void visit(DoWhileIteration doWhileIteration) {
        if (doWhileIteration.getBodyStatement() != null)
            doWhileIteration.getBodyStatement().accept(this);

        if (doWhileIteration.getCondition() != null)
            doWhileIteration.getCondition().accept(this);

        return null;
    }

    @Override
    public Void visit(ForIteration forIteration) {
        if (forIteration.getForCondition() != null)
            forIteration.getForCondition().accept(this);

        if (forIteration.getBodyStatement() != null)
            forIteration.getBodyStatement().accept(this);

        return null;
    }

    @Override
    public Void visit(ForCondition forCondition) {
        if (forCondition.getInitial() != null)
            if (forCondition.getInitial() instanceof Declaration) {
                if (!forCondition.getInitial().getIsUsed()) {
                    String msg = "Line:" + forCondition.getInitial().getLine() + " FOR_VARIABLE " + ((TypeSpecifier) ((Declaration) forCondition.getInitial()).getTypeSpecifiers().get(((Declaration) forCondition.getInitial()).getTypeSpecifiers().size() - 1).getType()).getType() + " is unused";
                    unused_logs.add(msg);
                    forCondition.deleteInitial();
                }
                else if (forCondition.getInitial().getIsUsed())
                    forCondition.getInitial().setIsUsed(false);
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
    public Void visit(Identifier identifier) { return null; }

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
        if (functionCallExpression.getName() != null)
            functionCallExpression.getName().accept(this);

        if (functionCallExpression.getParameters() != null)
            for (Expression parameter : functionCallExpression.getParameters())
                if (parameter != null)
                    parameter.accept(this);

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