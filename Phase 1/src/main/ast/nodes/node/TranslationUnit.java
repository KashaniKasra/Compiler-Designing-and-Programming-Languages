package main.ast.nodes.node;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class TranslationUnit extends Node {
    private ArrayList<ExternalDeclaration> externalDeclarations = new ArrayList<ExternalDeclaration>();

    public TranslationUnit() {}

    public void addExternalDeclaration(ExternalDeclaration externalDeclaration) { this.externalDeclarations.add(externalDeclaration); }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<ExternalDeclaration> getExternalDeclarations() {
        return externalDeclarations;
    }

    public void setExternalDeclarations(ArrayList<ExternalDeclaration> externalDeclarations) { this.externalDeclarations = externalDeclarations; }
}