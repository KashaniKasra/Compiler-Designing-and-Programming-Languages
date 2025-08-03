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

/* GOALs:
 *   1. print out scope changes each time a new scope starts
 *   2. print the identifier if it is initialized
 *   3. print the identifier if it is used
 *   4. print out the name of the function when it is defined
 *   5. print out the name of the function when it is used
 */

public abstract class Visitor<T> implements IVisitor<T> {
    @Override
    public T visit(CompilationUnit compilationUnit) { return null; }

    @Override
    public T visit(TranslationUnit translationUnit) { return null; }

    @Override
    public T visit(ExternalDeclaration externalDeclaration) { return null; }

    @Override
    public T visit(FunctionDefinition functionDefinition) { return null; }

    @Override
    public T visit(Declaration declaration) { return null; }

    @Override
    public T visit(Pointer pointer) { return null; }

    @Override
    public T visit(TypeSpecifier typeSpecifier) { return null; }

    @Override
    public T visit(Typedefs typedefs) { return null; }

    @Override
    public T visit(Consts consts) { return null; }

    @Override
    public T visit(InitDeclarator initDeclarator) { return null; }

    @Override
    public T visit(Declarator declarator) { return null; }

    @Override
    public T visit(DeclarationSpecifier declarationSpecifier) { return null; }

    @Override
    public T visit(IdentifierDeclarator identifierDeclarator) { return null; }

    @Override
    public T visit(NestedDeclarator nestedDeclarator) { return null; }

    @Override
    public T visit(ArrayDeclarator arrayDeclarator) { return null; }

    @Override
    public T visit(FunctionDeclarator functionDeclarator) { return null; }

    @Override
    public T visit(ParameterDeclaration parameterDeclaration) { return null; }

    @Override
    public T visit(AbstractDeclarator abstractDeclarator) { return null; }

    @Override
    public T visit(ExpressionAbstractDeclarator expressionAbstractDeclarator) { return null; }

    @Override
    public T visit(NestedAbstractDeclarator nestedAbstractDeclarator) { return null; }

    @Override
    public T visit(ArrayAbstractDeclarator arrayAbstractDeclarator) { return null; }

    @Override
    public T visit(FunctionAbstractDeclarator functionAbstractDeclarator) { return null; }

    @Override
    public T visit(DesignationInitializer designationInitializer) { return null; }

    @Override
    public T visit(ExpressionInitializer expressionInitializer) { return null; }

    @Override
    public T visit(NestedInitializer nestedInitializer) { return null; }

    @Override
    public T visit(ExpressionDesignator expressionDesignator) { return null; }

    @Override
    public T visit(IdentifierDesignator identifierDesignator) { return null; }

    @Override
    public T visit(TypeName typeName) { return null; }

    @Override
    public T visit(CompoundStatement compoundStatement) { return null; }

    @Override
    public T visit(ExpressionStatement expressionStatement) { return null; }

    @Override
    public T visit(SelectionStatement selectionStatement) { return null; }

    @Override
    public T visit(WhileIteration whileIteration) { return null; }

    @Override
    public T visit(DoWhileIteration doWhileIteration) { return null; }

    @Override
    public T visit(ForIteration forIteration) { return null; }

    @Override
    public T visit(ForCondition forCondition) { return null; }

    @Override
    public T visit(ContinueJump continueJump) { return null; }

    @Override
    public T visit(BreakJump breakJump) { return null; }

    @Override
    public T visit(ReturnJump returnJump) { return null; }

    @Override
    public T visit(Identifier identifier) { return null; }

    @Override
    public T visit(IntegerConstant integerConstant)  { return null;}

    @Override
    public T visit(FloatingConstant floatingConstant)  { return null; }

    @Override
    public T visit(CharacterConstant characterConstant)  { return null; }

    @Override
    public T visit(StringLiteral stringLiteral) { return null; }

    @Override
    public T visit(ParanthesisExpression paranthesisExpression) { return null; }

    @Override
    public T visit(CompoundExpression compoundExpression) { return null; }

    @Override
    public T visit(ArrayExpression arrayExpression) { return null; }

    @Override
    public T visit(FunctionCallExpression functionCallExpression) { return null; }

    @Override
    public T visit(UnaryExpression unaryExpression) { return null; }

    @Override
    public T visit(BinaryExpression binaryExpression) { return null; }

    @Override
    public T visit(NestedUnaryExpression nestedUnaryExpression) { return null; }

    @Override
    public T visit(CastExpression castExpression) { return null; }

    @Override
    public T visit(UnaryCastExpression unaryCastExpression) { return null; }

    @Override
    public T visit(SizeofTypeNameExpression sizeofTypeNameExpression) { return null; }

    @Override
    public T visit(QuestionColonExpression questionColonExpression) { return null; }

    @Override
    public T visit(AssignmentExpression assignmentExpression) { return null; }

    @Override
    public T visit(CommaExpression commaExpression) { return null; }
}