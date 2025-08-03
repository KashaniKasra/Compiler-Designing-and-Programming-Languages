package main.ast.nodes.expr;

import main.visitor.IVisitor;

public class ArrayExpression extends Expression {
    private Expression name;
    private Expression index;

    public ArrayExpression(Expression name, Expression index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getName() { return name; }

    public void setName(Expression name) { this.name = name; }

    public Expression getIndex() { return index; }

    public void setIndex(Expression index) { this.index = index; }
}