package main.ast.nodes.node;

import main.visitor.IVisitor;

public class CompilationUnit extends Node {
    private TranslationUnit translationUnit;

    public CompilationUnit(TranslationUnit translationUnit) { this.translationUnit = translationUnit; }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public main.ast.nodes.node.TranslationUnit getTranslationUnit() {
        return translationUnit;
    }

    public void setTranslationUnit(main.ast.nodes.node.TranslationUnit translationUnit) { this.translationUnit = translationUnit; }
}