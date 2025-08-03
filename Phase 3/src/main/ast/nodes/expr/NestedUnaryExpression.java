package main.ast.nodes.expr;

import main.ast.nodes.expr.operator.UnaryOperator;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class NestedUnaryExpression extends Expression {
    private ArrayList<UnaryOperator> operators = new ArrayList<UnaryOperator>();
    private Expression operand;

    public NestedUnaryExpression(ArrayList<UnaryOperator> operators, Expression operand) {
        this.operators = operators;
        this.operand = operand;
    }

    public void addOperator(UnaryOperator operator) { this.operators.add(operator); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<UnaryOperator> getOperators() { return operators; }

    public void setOperators(ArrayList<UnaryOperator> operators) { this.operators = operators; }

    public Expression getOperand() { return operand; }

    public void setOperand(Expression operand) { this.operand = operand; }
}