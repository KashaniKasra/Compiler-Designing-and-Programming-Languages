package main.ast.nodes.node;

import main.ast.nodes.node.type.Type;
import main.visitor.IVisitor;

public class DeclarationSpecifier extends Node {
    private Type type;

    public DeclarationSpecifier(Type type) { this.type = type; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Type getType() { return type; }

    public void setType(Type type) { this.type = type; }
}