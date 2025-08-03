package main.ast.nodes.node;

import main.ast.nodes.node.type.Type;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class TypeName extends Node {
    private ArrayList<Type> typeSpecifiers = new ArrayList<Type>();
    private AbstractDeclarator abstractDeclarator;

    public TypeName(ArrayList<Type> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public void addTypeSpecifier(Type typeSpecifier) { this.typeSpecifiers.add(typeSpecifier); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<Type> getTypeSpecifiers() { return typeSpecifiers; }

    public void setTypeSpecifiers(ArrayList<Type> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public AbstractDeclarator getAbstractDeclarator() { return abstractDeclarator; }

    public void setAbstractDeclarator(AbstractDeclarator abstractDeclarator) { this.abstractDeclarator = abstractDeclarator; }
}