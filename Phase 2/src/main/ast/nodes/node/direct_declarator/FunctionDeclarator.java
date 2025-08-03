package main.ast.nodes.node.direct_declarator;

import main.ast.nodes.node.ParameterDeclaration;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class FunctionDeclarator extends DirectDeclarator {
    private DirectDeclarator directDeclarator;
    private ArrayList<ParameterDeclaration> parameters = new ArrayList<ParameterDeclaration>();
    private ArrayList<String> identifiers = new ArrayList<String>();

    public FunctionDeclarator(DirectDeclarator directDeclarator) { this.directDeclarator = directDeclarator; }

    public void addParameter(ParameterDeclaration parameter) { this.parameters.add(parameter); }

    public void addIdentifier(String identifier) { this.identifiers.add(identifier); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public DirectDeclarator getDirectDeclarator() { return directDeclarator; }

    public void setDirectDeclarator(DirectDeclarator directDeclarator) { this.directDeclarator = directDeclarator; }

    public ArrayList<ParameterDeclaration> getParameters() { return parameters; }

    public void setParameters(ArrayList<ParameterDeclaration> parameters) { this.parameters = parameters; }

    public ArrayList<String> getIdentifiers() { return identifiers; }

    public void setIdentifiers(ArrayList<String> identifiers) { this.identifiers = identifiers; }
}