package main.ast.nodes.expr;

import main.visitor.IVisitor;

public class QuestionColonExpression extends Expression {
    private Expression condition;
    private Expression trueBody;
    private Expression falseBody;

    public QuestionColonExpression(Expression condition, Expression trueBody, Expression falseBody) {
        this.condition = condition;
        this.trueBody = trueBody;
        this.falseBody = falseBody;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getCondition() { return condition; }

    public void setCondition(Expression condition) { this.condition = condition; }

    public Expression getTrueBody() { return trueBody; }

    public void setTrueBody(Expression trueBody) { this.trueBody = trueBody; }

    public Expression getFalseBody() { return falseBody; }

    public void setFalseBody(Expression falseBody) { this.falseBody = falseBody; }
}
