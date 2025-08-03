package main.ast.nodes.node.initial;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

public class ExpressionInitializer extends Initializer {
    private Expression expression;

    public ExpressionInitializer(Expression expression) { this.expression = expression; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}