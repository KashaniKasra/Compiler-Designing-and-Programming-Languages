package main.ast.nodes.node.direct_abstract_declarator;

import main.ast.nodes.node.ParameterDeclaration;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class FunctionAbstractDeclarator extends DirectAbstractDeclarator {
    private DirectAbstractDeclarator directAbstractDeclarator;
    private ArrayList<ParameterDeclaration> parameters = new ArrayList<ParameterDeclaration>();

    public FunctionAbstractDeclarator(DirectAbstractDeclarator directAbstractDeclarator) { this.directAbstractDeclarator = directAbstractDeclarator; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public DirectAbstractDeclarator getDirectAbstractDeclarator() { return directAbstractDeclarator; }

    public void setDirectAbstractDeclarator(DirectAbstractDeclarator directAbstractDeclarator) { this.directAbstractDeclarator = directAbstractDeclarator; }

    public ArrayList<ParameterDeclaration> getParameters() { return parameters; }

    public void setParameters(ArrayList<ParameterDeclaration> parameters) { this.parameters = parameters; }
}