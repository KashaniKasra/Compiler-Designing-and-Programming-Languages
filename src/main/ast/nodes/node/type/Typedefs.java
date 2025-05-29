package main.ast.nodes.node.type;

import main.visitor.IVisitor;

public class Typedefs extends Type {
    public Typedefs() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }
}