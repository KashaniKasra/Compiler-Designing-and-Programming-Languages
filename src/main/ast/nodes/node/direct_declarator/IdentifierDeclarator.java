package main.ast.nodes.node.direct_declarator;

import main.visitor.IVisitor;

public class IdentifierDeclarator extends DirectDeclarator {
    private String id;

    public IdentifierDeclarator(String id) { this.id = id; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}