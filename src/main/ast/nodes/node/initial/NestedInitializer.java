package main.ast.nodes.node.initial;

import main.ast.nodes.node.DesignationInitializer;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class NestedInitializer extends Initializer {
    private ArrayList<DesignationInitializer> initializers = new ArrayList<DesignationInitializer>();

    public NestedInitializer(ArrayList<DesignationInitializer> initializers) { this.initializers = initializers; }

    public void addInitializer(DesignationInitializer initializer) { this.initializers.add(initializer); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<DesignationInitializer> getInitializers() { return initializers; }

    public void setInitializers(ArrayList<DesignationInitializer> initializers) { this.initializers = initializers; }
}