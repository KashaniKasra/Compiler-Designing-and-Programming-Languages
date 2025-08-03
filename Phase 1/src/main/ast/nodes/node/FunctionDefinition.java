package main.ast.nodes.node;

import main.ast.nodes.stmt.CompoundStatement;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class FunctionDefinition extends Node {
    private ArrayList<DeclarationSpecifier> typeSpecifiers = new ArrayList<DeclarationSpecifier>();
    private Declarator declarator;
    private ArrayList<Declaration> declarations = new ArrayList<Declaration>();
    private CompoundStatement compoundStatement;

    public FunctionDefinition() {}

    public void addTypeSpecifier(DeclarationSpecifier typeSpecifier) { this.typeSpecifiers.add(typeSpecifier); }

    public void addDeclaration(Declaration declaration) { this.declarations.add(declaration); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<DeclarationSpecifier> getTypeSpecifiers() { return typeSpecifiers; }

    public void setTypeSpecifiers(ArrayList<DeclarationSpecifier> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public Declarator getDeclarator() { return declarator; }

    public void setDeclarator(Declarator declarator) { this.declarator = declarator; }

    public ArrayList<Declaration> getDeclarations() { return declarations; }

    public void setDeclarations(ArrayList<Declaration> declarations) { this.declarations = declarations; }

    public CompoundStatement getCompoundStatement() { return compoundStatement; }

    public void setCompoundStatement(CompoundStatement compoundStatement) { this.compoundStatement = compoundStatement; }
}