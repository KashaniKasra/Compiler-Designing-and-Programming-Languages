package main.ast.nodes.expr;

import main.ast.nodes.node.DesignationInitializer;
import main.ast.nodes.node.TypeName;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class CompoundExpression extends Expression {
    private TypeName typeName;
    private ArrayList<DesignationInitializer> designationInitializers = new ArrayList<DesignationInitializer>();

    public CompoundExpression(TypeName typeName, ArrayList<DesignationInitializer> designationInitializers) {
        this.typeName = typeName;
        this.designationInitializers = designationInitializers;
    }

    public void addDesignationInitializer(DesignationInitializer designationInitializer) { this.designationInitializers.add(designationInitializer); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public TypeName getTypeName() { return typeName; }

    public void setTypeName(TypeName typeName) { this.typeName = typeName; }

    public ArrayList<DesignationInitializer> getDesignationInitializers() { return designationInitializers; }

    public void setDesignationInitializers(ArrayList<DesignationInitializer> designationInitializers) { this.designationInitializers = designationInitializers; }
}