package main.ast.nodes.expr.primitives.constants;

import main.visitor.IVisitor;

public class FloatingConstant extends ConstantVal {
    private double value;

    public FloatingConstant(String text) { this.value = Double.parseDouble(text);; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public double getValue() { return value; }

    public void setValue(double value) { this.value = value; }
}