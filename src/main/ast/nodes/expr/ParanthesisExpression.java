package main.ast.nodes.expr;

import main.visitor.IVisitor;

public class ParanthesisExpression extends Expression {
    private Expression expression;

    public ParanthesisExpression(Expression expression) { this.expression = expression; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}