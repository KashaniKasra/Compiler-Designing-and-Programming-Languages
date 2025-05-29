package main.ast.nodes.node;

import main.ast.nodes.node.direct_abstract_declarator.DirectAbstractDeclarator;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class AbstractDeclarator extends Node {
    private Pointer pointer;
    private DirectAbstractDeclarator directAbstractDeclarator;

    public AbstractDeclarator() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Pointer getPointer() { return pointer; }

    public void setPointer(Pointer pointer) { this.pointer = pointer; }

    public DirectAbstractDeclarator getDirectAbstractDeclarator() { return directAbstractDeclarator; }

    public void setDirectAbstractDeclarator(DirectAbstractDeclarator directAbstractDeclarator) { this.directAbstractDeclarator = directAbstractDeclarator; }
}