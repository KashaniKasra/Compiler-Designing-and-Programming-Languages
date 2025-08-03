package main.ast.nodes.node.type;

import main.visitor.IVisitor;

public class Consts extends Type {
    public Consts() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }
}