package main.ast.nodes.node.design;

import main.visitor.IVisitor;

public class IdentifierDesignator extends Designator {
    private String identifier;

    public IdentifierDesignator(String identifier) { this.identifier = identifier; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public String getIdentifier() { return identifier; }

    public void setIdentifier(String identifier) { this.identifier = identifier; }
}