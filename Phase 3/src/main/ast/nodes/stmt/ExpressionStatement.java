package main.ast.nodes.stmt;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

public class ExpressionStatement extends Statement {
    private Expression expression;

    public ExpressionStatement() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}