package main.ast.nodes.node;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class Pointer extends Node {
    ArrayList<String> pointers = new ArrayList<String>();

    public Pointer() {}

    public void addPointer(String pointer) { this.pointers.add(pointer); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<String> getPointers() { return pointers; }

    public void setPointers(ArrayList<String> pointers) { this.pointers = pointers; }
}