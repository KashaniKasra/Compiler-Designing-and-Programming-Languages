package main.visitor;

import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.operator.UnaryOperator;
import main.ast.nodes.expr.primitives.Identifier;
import main.ast.nodes.expr.primitives.StringLiteral;
import main.ast.nodes.expr.primitives.constants.CharacterConstant;
import main.ast.nodes.expr.primitives.constants.FloatingConstant;
import main.ast.nodes.expr.primitives.constants.IntegerConstant;
import main.ast.nodes.node.Declaration;
import main.ast.nodes.node.FunctionDefinition;
import main.ast.nodes.node.ParameterDeclaration;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FunctionDefinitionSymbolTableItem;
import main.symbolTable.item.VariableDeclarationSymbolTableItem;
import main.types.*;

public class ExpressionTypeEvaluator extends Visitor<Types> {
    private SymbolTable curr_SymbolTable;

    public ExpressionTypeEvaluator() {}

    public void setCurrSymbolTable(SymbolTable curr_SymbolTable) { this.curr_SymbolTable = curr_SymbolTable; }

    @Override
    public Types visit(UnaryExpression unaryExpression) {
        Types operand_type = unaryExpression.getOperand().accept(this);
        Types final_type = new NonType();

        UnaryOperator unaryOperator = unaryExpression.getOperator();
        switch (unaryOperator) {
            case POST_INC, POST_DEC, PRE_INC, PRE_DEC:
                if (operand_type instanceof NonType || operand_type instanceof BoolType || operand_type instanceof StringType || operand_type instanceof VoidType)
                    final_type = new NonType();
                else
                    final_type = operand_type;
                break;
            case SIZEOF:
                if (operand_type instanceof NonType)
                    final_type = new NonType();
                else
                    final_type = new IntType();
                break;
            case STAR:
                if (operand_type instanceof NonType || operand_type instanceof VoidType || operand_type instanceof StringType)
                    final_type = new NonType();
                else
                    final_type = operand_type;
                break;
            case AND, PLUS, MINUS, TILDE, NOT:
                if (operand_type instanceof NonType || operand_type instanceof BoolType || operand_type instanceof CharType || operand_type instanceof StringType || operand_type instanceof VoidType)
                    final_type = new NonType();
                else
                    final_type = operand_type;
                break;
        }

        return final_type;
    }

    @Override
    public Types visit(BinaryExpression binaryExpression) {
        Types left_type = binaryExpression.getLeft().accept(this);
        Types right_type = binaryExpression.getRight().accept(this);
        Types final_type = new NonType();

        BinaryOperator binaryOperator = binaryExpression.getOperator();
        switch (binaryOperator) {
            case STAR, DIV:
                if (left_type instanceof BoolType || left_type instanceof CharType || left_type instanceof StringType || left_type instanceof VoidType || left_type instanceof NonType || right_type instanceof BoolType || right_type instanceof CharType || right_type instanceof StringType || right_type instanceof VoidType || right_type instanceof NonType)
                    final_type = new NonType();
                else if (left_type instanceof DoubleType || right_type instanceof DoubleType)
                    final_type = new DoubleType();
                else if (left_type instanceof FloatType || right_type instanceof FloatType)
                    final_type = new FloatType();
                else if (left_type instanceof LongType || right_type instanceof LongType)
                    final_type = new LongType();
                else if (left_type instanceof UnsignedType || right_type instanceof UnsignedType)
                    final_type = new UnsignedType();
                else
                    final_type = new IntType();
                break;
            case PLUS, MINUS:
                if (left_type instanceof BoolType || left_type instanceof VoidType || left_type instanceof NonType || right_type instanceof BoolType || right_type instanceof VoidType || right_type instanceof NonType)
                    final_type = new NonType();
                else if ((left_type instanceof StringType && right_type instanceof StringType) || (left_type instanceof StringType && right_type instanceof CharType) || (left_type instanceof CharType && right_type instanceof StringType))
                    final_type = new StringType();
                else if ((left_type instanceof CharType && right_type instanceof CharType) || (left_type instanceof CharType && right_type instanceof IntType) || (left_type instanceof IntType && right_type instanceof CharType))
                    final_type = new CharType();
                else if (left_type instanceof CharType || left_type instanceof StringType || right_type instanceof CharType || right_type instanceof StringType)
                    final_type = new NonType();
                else if (left_type instanceof DoubleType || right_type instanceof DoubleType)
                    final_type = new DoubleType();
                else if (left_type instanceof FloatType || right_type instanceof FloatType)
                    final_type = new FloatType();
                else if (left_type instanceof LongType || right_type instanceof LongType)
                    final_type = new LongType();
                else if (left_type instanceof UnsignedType || right_type instanceof UnsignedType)
                    final_type = new UnsignedType();
                else
                    final_type = new IntType();
                break;
            case MOD, AND, XOR, OR:
                if (left_type instanceof BoolType || left_type instanceof FloatType || left_type instanceof DoubleType || left_type instanceof CharType || left_type instanceof StringType || left_type instanceof VoidType || left_type instanceof NonType || right_type instanceof BoolType || right_type instanceof FloatType || right_type instanceof DoubleType || right_type instanceof CharType || right_type instanceof StringType || right_type instanceof VoidType || right_type instanceof NonType)
                    final_type = new NonType();
                else if (left_type instanceof LongType || right_type instanceof LongType)
                    final_type = new LongType();
                else if (left_type instanceof UnsignedType || right_type instanceof UnsignedType)
                    final_type = new UnsignedType();
                else
                    final_type = new IntType();
                break;
            case LEFT_SHIFT, RIGHT_SHIFT:
                if (left_type instanceof FloatType || left_type instanceof DoubleType || left_type instanceof CharType || left_type instanceof StringType || left_type instanceof VoidType || left_type instanceof NonType || left_type instanceof BoolType || right_type instanceof FloatType || right_type instanceof DoubleType || right_type instanceof CharType || right_type instanceof StringType || right_type instanceof VoidType || right_type instanceof NonType || right_type instanceof BoolType)
                    final_type = new NonType();
                else if (left_type instanceof IntType || left_type instanceof ShortType || left_type instanceof SignedType)
                    final_type = new IntType();
                else if (left_type instanceof LongType)
                    final_type = new LongType();
                else if (left_type instanceof UnsignedType)
                    final_type = new UnsignedType();
                break;
            case LESS, GREATER, LESS_EQUAL, GREATER_EQUAL, EQUAL, NOT_EQUAL:
                if (left_type instanceof VoidType || left_type instanceof NonType || right_type instanceof VoidType || right_type instanceof NonType ||
                    (left_type instanceof StringType && !(right_type instanceof StringType)) ||
                    (right_type instanceof StringType && !(left_type instanceof StringType)))
                    final_type = new NonType();
                else
                    final_type = new BoolType();
                break;
            case AND_AND, OR_OR:
                if (left_type instanceof CharType || right_type instanceof CharType ||
                        left_type instanceof StringType || right_type instanceof StringType ||
                        left_type instanceof VoidType || right_type instanceof VoidType ||
                        left_type instanceof NonType || right_type instanceof NonType)
                    final_type = new NonType();
                else
                    final_type = new BoolType();
                break;
        }

        return final_type;
    }

    @Override
    public Types visit(Identifier identifier) {
        String varName = identifier.getName();
        Types final_type = new NonType();

        try {
            VariableDeclarationSymbolTableItem var_item = (VariableDeclarationSymbolTableItem)curr_SymbolTable.getItem(VariableDeclarationSymbolTableItem.START_KEY + varName);
            if (var_item.getVariableInfo().getDeclaration() instanceof Declaration declaration)
                final_type = declaration.getType();
            else if (var_item.getVariableInfo().getDeclaration() instanceof ParameterDeclaration parameterDeclaration)
                final_type = parameterDeclaration.getType();
        } catch (ItemNotFoundException e) {

        }

        return final_type;
    }

    @Override
    public Types visit(FunctionCallExpression functionCallExpression) {
        int parametersCount = functionCallExpression.getParameters().size();
        String funcName = ((Identifier)functionCallExpression.getName()).getName();
        Types final_type = new NonType();

        try {
            FunctionDefinitionSymbolTableItem func_item = (FunctionDefinitionSymbolTableItem)curr_SymbolTable.getItem(FunctionDefinitionSymbolTableItem.START_KEY + funcName + "_" + Integer.toString(parametersCount));
            final_type = func_item.getFunctionDefinition().getReturnType();
        } catch (ItemNotFoundException e) {

        }

        return final_type;
    }

    @Override
    public Types visit(ParanthesisExpression paranthesisExpression) {
        if (paranthesisExpression != null)
            return paranthesisExpression.getExpression().accept(this);

        return null;
    }

    @Override
    public Types visit(FunctionDefinition functionDefinition) { return functionDefinition.getReturnType(); }

    @Override
    public Types visit(IntegerConstant integerConstant) { return new ShortType(); }

    @Override
    public Types visit(FloatingConstant floatingConstant)  { return new FloatType(); }

    @Override
    public Types visit(CharacterConstant characterConstant)  { return new CharType(); }

    @Override
    public Types visit(StringLiteral stringLiteral) { return new StringType(); }
}