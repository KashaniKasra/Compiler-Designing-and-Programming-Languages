package main.ast.nodes.node.type;

import main.visitor.IVisitor;

public class TypeSpecifier extends Type {
    private String type;

    public TypeSpecifier(String type) { this.type = type; }

    public void addType(String type) { this.type = this.type + " " + type; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}