package main.ast.nodes.expr;

import main.ast.nodes.expr.operator.AssignmentOperator;
import main.visitor.IVisitor;

public class AssignmentExpression extends Expression {
    private Expression left;
    private AssignmentOperator operator;
    private Expression right;

    public AssignmentExpression(Expression left, AssignmentOperator operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public AssignmentOperator getOperator() {
        return operator;
    }

    public void setOperator(AssignmentOperator operator) {
        this.operator = operator;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
}