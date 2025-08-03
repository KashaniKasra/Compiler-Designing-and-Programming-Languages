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
    private boolean is_initialized;
    private boolean have_pointer;
    private boolean is_scan;

    public VariableInfo(ArrayList<DeclarationSpecifier> typeSpecifiers, String name, Initializer initializer, Node declaration, boolean is_initialized, boolean have_pointer) {
        this.typeSpecifiers = typeSpecifiers;
        this.name = name;
        this.initializer = initializer;
        this.declaration = declaration;
        this.is_initialized = is_initialized;
        this.have_pointer = have_pointer;
        this.is_scan = false;
    }

    public ArrayList<DeclarationSpecifier> getTypeSpecifiers() { return typeSpecifiers; }

    public void setTypeSpecifiers(ArrayList<DeclarationSpecifier> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Initializer getInitializer() { return initializer; }

    public void setInitializer(Initializer initializer) { this.initializer = initializer; }

    public Node getDeclaration() { return declaration; }

    public void setDeclaration(Node declaration) { this.declaration = declaration; }

    public boolean getIsInitialized() { return is_initialized; }

    public void setIsInitialized(boolean is_initialized) { this.is_initialized = is_initialized; }

    public boolean getHavePointer() { return have_pointer; }

    public void setHavePointer(boolean have_pointer) { this.have_pointer = have_pointer; }

    public boolean getIsScan() { return is_scan; }

    public void setIsScan(boolean is_scan) { this.is_scan = is_scan; }
}