package main.ast.nodes.expr.primitives.constants;

import main.visitor.IVisitor;

public class IntegerConstant extends ConstantVal {
    private int value;

    public IntegerConstant(int value) { this.value = value; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }
}