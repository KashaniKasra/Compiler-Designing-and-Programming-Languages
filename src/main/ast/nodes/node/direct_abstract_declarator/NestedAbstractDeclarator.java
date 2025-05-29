package main.ast.nodes.node.direct_abstract_declarator;

import main.ast.nodes.node.AbstractDeclarator;
import main.ast.nodes.node.ParameterDeclaration;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class NestedAbstractDeclarator extends DirectAbstractDeclarator {
    private AbstractDeclarator abstractDeclarator;
    private ArrayList<ParameterDeclaration> parameters = new ArrayList<ParameterDeclaration>();

    public NestedAbstractDeclarator() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public AbstractDeclarator getAbstractDeclarator() { return abstractDeclarator; }

    public void setAbstractDeclarator(AbstractDeclarator abstractDeclarator) { this.abstractDeclarator = abstractDeclarator; }

    public ArrayList<ParameterDeclaration> getParameters() { return parameters; }

    public void setParameters(ArrayList<ParameterDeclaration> parameters) { this.parameters = parameters; }
}