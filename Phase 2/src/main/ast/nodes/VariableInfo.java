package main.ast.nodes;

import main.ast.nodes.node.Node;
import main.ast.nodes.node.DeclarationSpecifier;
import main.ast.nodes.node.initial.Initializer;

import java.util.ArrayList;

public class VariableInfo {
    private ArrayList<DeclarationSpecifier> typeSpecifiers = new ArrayList<DeclarationSpecifier>();
    private String name;
    private Initializer initializer;
    private Node declaration;

    public VariableInfo(ArrayList<DeclarationSpecifier> typeSpecifiers, String name, Initializer initializer, Node declaration) {
        this.typeSpecifiers = typeSpecifiers;
        this.name = name;
        this.initializer = initializer;
        this.declaration = declaration;
    }

    public ArrayList<DeclarationSpecifier> getTypeSpecifiers() { return typeSpecifiers; }

    public void setTypeSpecifiers(ArrayList<DeclarationSpecifier> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Initializer getInitializer() { return initializer; }

    public void setInitializer(Initializer initializer) { this.initializer = initializer; }

    public Node getDeclaration() { return declaration; }

    public void setDeclaration(Node declaration) { this.declaration = declaration; }
}