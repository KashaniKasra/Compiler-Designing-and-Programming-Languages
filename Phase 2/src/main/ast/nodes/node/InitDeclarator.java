package main.ast.nodes.node;

import main.ast.nodes.node.initial.Initializer;
import main.visitor.IVisitor;

public class InitDeclarator extends Node {
    private Declarator declarator;
    private Initializer initializer;

    public InitDeclarator(Declarator declarator) { this.declarator = declarator; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Declarator getDeclarator() { return declarator; }

    public void setDeclarator(Declarator declarator) { this.declarator = declarator; }

    public Initializer getInitializer() { return initializer; }

    public void setInitializer(Initializer initializer) { this.initializer = initializer; }
}