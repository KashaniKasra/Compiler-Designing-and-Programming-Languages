package main.ast.nodes.node;

import main.ast.nodes.node.design.Designator;
import main.ast.nodes.node.initial.Initializer;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class DesignationInitializer extends Node {
    private ArrayList<Designator> designations = new ArrayList<Designator>();
    private Initializer initializer;

    public DesignationInitializer(ArrayList<Designator> designations, Initializer initializer) {
        this.designations = designations;
        this.initializer = initializer;
    }

    public void addDesignator(Designator designator) { this.designations.add(designator); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<Designator> getDesignations() { return designations; }

    public void setDesignations(ArrayList<Designator> designations) { this.designations = designations; }

    public Initializer getInitializer() { return initializer; }

    public void setInitializer(Initializer initializer) { this.initializer = initializer; }
}