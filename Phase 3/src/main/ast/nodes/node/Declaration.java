package main.ast.nodes.node;

import main.types.Types;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class Declaration extends Node {
    private ArrayList<DeclarationSpecifier> typeSpecifiers = new ArrayList<DeclarationSpecifier>();
    private ArrayList<InitDeclarator> initDeclarators = new ArrayList<InitDeclarator>();
    private boolean is_free = false;
    private Types type;

    public Declaration(ArrayList<DeclarationSpecifier> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public void addTypeSpecifier(DeclarationSpecifier typeSpecifier) { this.typeSpecifiers.add(typeSpecifier); }

    public void addInitDeclarator(InitDeclarator initDeclarator) { this.initDeclarators.add(initDeclarator); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<DeclarationSpecifier> getTypeSpecifiers() { return typeSpecifiers; }

    public void setTypeSpecifiers(ArrayList<DeclarationSpecifier> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public ArrayList<InitDeclarator> getInitDeclarators() { return initDeclarators; }

    public void setInitDeclarators(ArrayList<InitDeclarator> initDeclarators) { this.initDeclarators = initDeclarators; }

    public boolean getIsFree() { return is_free; }

    public void setIsFree(boolean is_free) { this.is_free = is_free; }

    public Types getType() { return type; }

    public void setType(Types type) { this.type = type; }
}