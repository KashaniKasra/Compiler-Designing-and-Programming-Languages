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

import java.util.HashSet;
import java.util.Set;

/* GOALs:
 *   1. print out scope changes each time a new scope starts
 *   2. print the identifier if it is initialized
 *   3. print the identifier if it is used
 *   4. print out the name of the function when it is defined
 *   5. print out the name of the function when it is used
 */

public class TestVisitor extends Visitor<Void> {
    private Set<Integer> printedLines = new HashSet<>();

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

    private void extractRootExpression(Expression expr) {
        int line = expr.getLine();

        if (printedLines.contains(line))
            return;

        if (expr instanceof Identifier id) {
            System.out.println("Line " + id.getLine() + ": Expr " + id.getName());
            printedLines.add(line);
        }
        else if (expr instanceof StringLiteral s) {
            System.out.println("Line " + s.getLine() + ": Expr " + s.mergeNames());
            printedLines.add(line);
        }
        else if (expr instanceof IntegerConstant ic) {
            System.out.println("Line " + ic.getLine() + ": Expr " + ic.getValue());
            printedLines.add(line);
        }
        else if (expr instanceof FloatingConstant fc) {
            System.out.println("Line " + fc.getLine() + ": Expr " + fc.getValue());
            printedLines.add(line);
        }
        else if (expr instanceof CharacterConstant cc) {
            System.out.println("Line " + cc.getLine() + ": Expr " + cc.getValue());
            printedLines.add(line);
        }
        else if (expr instanceof ParanthesisExpression pe)
            extractRootExpression(pe.getExpression());
        else if (expr instanceof CompoundExpression ce) {
            System.out.println("Line " + ce.getLine() + ": Expr functionCall");
            printedLines.add(line);
        }
        else if (expr instanceof ArrayExpression ae)
            extractRootExpression(ae.getName());
        else if (expr instanceof FunctionCallExpression fe)
            extractRootExpression(fe.getName());
        else if (expr instanceof UnaryExpression ue) {
            System.out.println("Line " + ue.getLine() + ": Expr " + ue.getOperator().toString());
            printedLines.add(line);
        }
        else if (expr instanceof UnaryCastExpression uce) {
            System.out.println("Line " + uce.getLine() + ": Expr " + uce.getOperator().toString());
            printedLines.add(line);
        }
        else if (expr instanceof SizeofTypeNameExpression stne) {
            System.out.println("Line " + stne.getLine() + ": Expr sizeof");
            printedLines.add(line);
        }
        else if (expr instanceof NestedUnaryExpression nue) {
            if (!nue.getOperators().isEmpty())
                System.out.println("Line " + nue.getLine() + ": Expr " + nue.getOperators().get(0).toString());
            else
                extractRootExpression(nue.getOperand());
            printedLines.add(line);
        }
        else if (expr instanceof CastExpression ce) {
            System.out.println("Line " + ce.getLine() + ": Expr cast");
            printedLines.add(line);
        }
        else if (expr instanceof BinaryExpression be) {
            System.out.println("Line " + be.getLine() + ": Expr " + be.getOperator().toString());
            printedLines.add(line);
        }
        else if (expr instanceof QuestionColonExpression qce)
            extractRootExpression(qce.getCondition());
        else if (expr instanceof AssignmentExpression ae) {
            System.out.println("Line " + ae.getLine() + ": Expr " + ae.getOperator().toString());
            printedLines.add(line);
        }
        else if (expr instanceof CommaExpression ce) {
            System.out.println("Line " + ce.getLine() + ": Expr ,");
            printedLines.add(line);
        }
    }

    private int extractStatementCount(Statement stmt) {
        int count = 0;

        if (stmt instanceof CompoundStatement cs)
            if (cs.getBlockItems() != null)
                for (Node blockItem : cs.getBlockItems())
                    if (blockItem != null)
                        count ++;
        else if (stmt instanceof ExpressionStatement es)
            count ++;
        else if (stmt instanceof SelectionStatement ss)
            count ++;
        else if (stmt instanceof IterationStatement is)
            count ++;
        else if (stmt instanceof JumpStatement js)
            count ++;

        return count;
    }

    @Override
    public Void visit(CompilationUnit compilationUnit) {
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
        Declarator declarator = functionDefinition.getDeclarator();
        if (declarator != null) {
            DirectDeclarator directDeclarator = declarator.getDirectDeclarator();
            String functionName = extractFunctionName(directDeclarator);
            if (functionName != null)
                System.out.println("Line " + functionDefinition.getLine() + ": Stmt function " + functionName + " = " + extractStatementCount(functionDefinition.getCompoundStatement()));
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
        System.out.println("Line " + selectionStatement.getIfLine() + ": Stmt selection = " + extractStatementCount(selectionStatement.getBodyStatement()));

        if (selectionStatement.getCondition() != null)
            selectionStatement.getCondition().accept(this);

        if (selectionStatement.getBodyStatement() != null)
            selectionStatement.getBodyStatement().accept(this);

        if (selectionStatement.getElseStatement() != null) {
            selectionStatement.getElseStatement().accept(this);
            if (!(selectionStatement.getElseStatement() instanceof SelectionStatement))
                System.out.println("Line " + selectionStatement.getElseLine() + ": Stmt selection = " + extractStatementCount(selectionStatement.getElseStatement()));
        }

        return null;
    }

    @Override
    public Void visit(WhileIteration whileIteration) {
        System.out.println("Line " + whileIteration.getLine() + ": Stmt while = " + extractStatementCount(whileIteration.getBodyStatement()));

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
        System.out.println("Line " + forIteration.getLine() + ": Stmt for = " + extractStatementCount(forIteration.getBodyStatement()));

        if (forIteration.getForCondition() != null)
            forIteration.getForCondition().accept(this);

        if (forIteration.getBodyStatement() != null)
            forIteration.getBodyStatement().accept(this);

        return null;
    }

    @Override
    public Void visit(ForCondition forCondition) {
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
        extractRootExpression(identifier);

        return null;
    }

    @Override
    public Void visit(IntegerConstant integerConstant)  {
        extractRootExpression(integerConstant);

        return null;
    }

    @Override
    public Void visit(FloatingConstant floatingConstant)  {
        extractRootExpression(floatingConstant);

        return null;
    }

    @Override
    public Void visit(CharacterConstant characterConstant)  {
        extractRootExpression(characterConstant);

        return null;
    }

    @Override
    public Void visit(StringLiteral stringLiteral) {
        extractRootExpression(stringLiteral);

        return null;
    }

    @Override
    public Void visit(ParanthesisExpression paranthesisExpression) {
        extractRootExpression(paranthesisExpression);

        if (paranthesisExpression.getExpression() != null)
            paranthesisExpression.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(CompoundExpression compoundExpression) {
        extractRootExpression(compoundExpression);

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
        extractRootExpression(arrayExpression);

        if (arrayExpression.getName() != null)
            arrayExpression.getName().accept(this);

        if (arrayExpression.getIndex() != null)
            arrayExpression.getIndex().accept(this);

        return null;
    }

    @Override
    public Void visit(FunctionCallExpression functionCallExpression) {
        extractRootExpression(functionCallExpression);

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
        extractRootExpression(unaryExpression);

        if (unaryExpression.getOperand() != null)
            unaryExpression.getOperand().accept(this);

        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        extractRootExpression(binaryExpression);

        if (binaryExpression.getLeft() != null)
            binaryExpression.getLeft().accept(this);

        if (binaryExpression.getRight() != null)
            binaryExpression.getRight().accept(this);

        return null;
    }

    @Override
    public Void visit(NestedUnaryExpression nestedUnaryExpression) {
        extractRootExpression(nestedUnaryExpression);

        if (nestedUnaryExpression.getOperand() != null)
            nestedUnaryExpression.getOperand().accept(this);

        return null;
    }

    @Override
    public Void visit(CastExpression castExpression) {
        extractRootExpression(castExpression);

        if (castExpression.getTypeName() != null)
            castExpression.getTypeName().accept(this);

        if (castExpression.getExpression() != null)
            castExpression.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(UnaryCastExpression unaryCastExpression) {
        extractRootExpression(unaryCastExpression);

        if (unaryCastExpression.getExpression() != null)
            unaryCastExpression.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(SizeofTypeNameExpression sizeofTypeNameExpression) {
        extractRootExpression(sizeofTypeNameExpression);

        if (sizeofTypeNameExpression.getTypeName() != null)
            sizeofTypeNameExpression.getTypeName().accept(this);

        return null;
    }

    @Override
    public Void visit(QuestionColonExpression questionColonExpression) {
        extractRootExpression(questionColonExpression);

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
        extractRootExpression(assignmentExpression);

        if (assignmentExpression.getLeft() != null)
            assignmentExpression.getLeft().accept(this);

        if (assignmentExpression.getRight() != null)
            assignmentExpression.getRight().accept(this);

        return null;
    }

    @Override
    public Void visit(CommaExpression commaExpression) {
        extractRootExpression(commaExpression);

        if (commaExpression.getExpressions() != null)
            for (Expression expression : commaExpression.getExpressions())
                if (expression != null)
                    expression.accept(this);

        return null;
    }
}