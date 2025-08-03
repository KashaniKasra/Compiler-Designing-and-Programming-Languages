package main.ast.nodes.expr.primitives.constants;

import main.visitor.IVisitor;

public class CharacterConstant extends ConstantVal {
    private String value;

    public CharacterConstant(String value) { this.value = value; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }
}