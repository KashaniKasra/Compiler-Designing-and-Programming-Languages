package main.ast.nodes.node.direct_declarator;

import main.ast.nodes.node.Declarator;
import main.visitor.IVisitor;

public class NestedDeclarator extends DirectDeclarator {
    private Declarator declarator;

    public NestedDeclarator(Declarator declarator) { this.declarator = declarator; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Declarator getDeclarator() { return declarator; }

    public void setDeclarator(Declarator declarator) { this.declarator = declarator; }
}