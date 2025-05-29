package main.ast.nodes.node;

import main.ast.nodes.node.direct_declarator.DirectDeclarator;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class Declarator extends Node {
    private Pointer pointer;
    private DirectDeclarator directDeclarator;

    public Declarator() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Pointer getPointer() { return pointer; }

    public void setPointer(Pointer pointer) { this.pointer = pointer; }

    public DirectDeclarator getDirectDeclarator() { return directDeclarator; }

    public void setDirectDeclarator(DirectDeclarator directDeclarator) { this.directDeclarator = directDeclarator; }
}