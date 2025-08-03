package main.ast.nodes.node;

import main.visitor.IVisitor;

public class ExternalDeclaration extends Node {
    private Node node;

    public ExternalDeclaration(Node node) { this.node = node; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Node getNode() { return node; }

    public void setNode(Node node) { this.node = node; }
}