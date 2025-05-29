package main.ast.nodes.expr;

import main.ast.nodes.expr.operator.UnaryOperator;
import main.visitor.IVisitor;

public class UnaryCastExpression extends Expression {
    private UnaryOperator operator;
    private Expression expression;

    public UnaryCastExpression(UnaryOperator operator, Expression expression) {
        this.operator = operator;
        this.expression = expression;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public UnaryOperator getOperator() { return operator; }

    public void setOperator(UnaryOperator operator) { this.operator = operator; }


    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}