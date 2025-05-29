package main.ast.nodes.node;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class ParameterDeclaration extends Node {
    private ArrayList<DeclarationSpecifier> typeSpecifiers = new ArrayList<DeclarationSpecifier>();
    private Declarator declarator;
    private AbstractDeclarator abstractDeclarator;

    public ParameterDeclaration(ArrayList<DeclarationSpecifier> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public void addTypeSpecifier(DeclarationSpecifier typeSpecifier) { this.typeSpecifiers.add(typeSpecifier); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<DeclarationSpecifier> getTypeSpecifiers() { return typeSpecifiers; }

    public void setTypeSpecifiers(ArrayList<DeclarationSpecifier> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public Declarator getDeclarator() { return declarator; }

    public void setDeclarator(Declarator declarator) { this.declarator = declarator; }

    public AbstractDeclarator getAbstractDeclarator() { return abstractDeclarator; }

    public void setAbstractDeclarator(AbstractDeclarator directAbstractDeclarator) { this.abstractDeclarator = abstractDeclarator; }
}