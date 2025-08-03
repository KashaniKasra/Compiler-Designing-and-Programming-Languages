package main.ast.nodes.stmt.jump;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

public class ReturnJump extends JumpStatement {
    private Expression expression;

    public ReturnJump() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}