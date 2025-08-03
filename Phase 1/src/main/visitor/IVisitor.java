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

public interface IVisitor<T> {
    T visit(CompilationUnit compilationUnit);

    T visit(TranslationUnit translationUnit);

    T visit(ExternalDeclaration externalDeclaration);

    T visit(FunctionDefinition functionDefinition);

    T visit(Declaration declaration);

    T visit(Pointer pointer);

    T visit(TypeSpecifier typeSpecifier);

    T visit(Typedefs typedefs);

    T visit(Consts consts);

    T visit(InitDeclarator initDeclarator);

    T visit(Declarator declarator);

    T visit(DeclarationSpecifier declarationSpecifier);

    T visit(IdentifierDeclarator identifierDeclarator);

    T visit(NestedDeclarator nestedDeclarator);

    T visit(ArrayDeclarator arrayDeclarator);

    T visit(FunctionDeclarator functionDeclarator);

    T visit(ParameterDeclaration parameterDeclaration);

    T visit(AbstractDeclarator abstractDeclarator);

    T visit(ExpressionAbstractDeclarator expressionAbstractDeclarator);

    T visit(NestedAbstractDeclarator nestedAbstractDeclarator);

    T visit(ArrayAbstractDeclarator arrayAbstractDeclarator);

    T visit(FunctionAbstractDeclarator functionAbstractDeclarator);

    T visit(DesignationInitializer designationInitializer);

    T visit(ExpressionInitializer expressionInitializer);

    T visit(NestedInitializer nestedInitializer);

    T visit(ExpressionDesignator expressionDesignator);

    T visit(IdentifierDesignator identifierDesignator);

    T visit(TypeName typeName);

    T visit(CompoundStatement compoundStatement);

    T visit(ExpressionStatement expressionStatement);

    T visit(SelectionStatement selectionStatement);

    T visit(WhileIteration whileIteration);

    T visit(DoWhileIteration doWhileIteration);

    T visit(ForIteration forIteration);

    T visit(ForCondition forCondition);

    T visit(ContinueJump continueJump);

    T visit(BreakJump breakJump);

    T visit(ReturnJump returnJump);

    T visit(Identifier identifier);

    T visit(IntegerConstant integerConstant);

    T visit(FloatingConstant floatingConstant);

    T visit(CharacterConstant characterConstant);

    T visit(StringLiteral stringLiteral);

    T visit(ParanthesisExpression paranthesisExpression);

    T visit(CompoundExpression compoundExpression);

    T visit(ArrayExpression arrayExpression);

    T visit(FunctionCallExpression functionCallExpression);

    T visit(UnaryExpression unaryExpression);

    T visit(BinaryExpression binaryExpression);

    T visit(NestedUnaryExpression nestedUnaryExpression);

    T visit(CastExpression castExpression);

    T visit(UnaryCastExpression unaryCastExpression);

    T visit(SizeofTypeNameExpression sizeofTypeNameExpression);

    T visit(QuestionColonExpression questionColonExpression);

    T visit(AssignmentExpression assignmentExpression);

    T visit(CommaExpression commaExpression);
}