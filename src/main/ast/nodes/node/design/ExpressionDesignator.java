package main.ast.nodes.node.design;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

public class ExpressionDesignator extends Designator {
    private Expression expression;

    public ExpressionDesignator(Expression expression) { this.expression = expression; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}