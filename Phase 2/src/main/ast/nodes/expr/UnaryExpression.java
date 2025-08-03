package main.ast.nodes.expr;

import main.ast.nodes.expr.operator.UnaryOperator;
import main.visitor.IVisitor;

public class UnaryExpression extends Expression {
    private Expression operand;
    private UnaryOperator operator;

    public UnaryExpression(Expression operand, UnaryOperator operator) {
        this.operand = operand;
        this.operator = operator;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getOperand() { return operand; }

    public void setOperand(Expression operand) { this.operand = operand; }

    public UnaryOperator getOperator() { return operator; }

    public void setOperator(UnaryOperator operator) { this.operator = operator; }
}