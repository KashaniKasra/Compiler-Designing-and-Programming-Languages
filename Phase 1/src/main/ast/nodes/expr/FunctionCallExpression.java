package main.ast.nodes.expr;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class FunctionCallExpression extends Expression {
    private Expression name;
    private ArrayList<Expression> parameters = new ArrayList<Expression>();

    public FunctionCallExpression(Expression name) { this.name = name; }

    public void addParameter(Expression parameter) { this.parameters.add(parameter); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getName() { return name; }

    public void setName(Expression name) { this.name = name; }

    public ArrayList<Expression> getParameters() { return parameters; }

    public void setParameters(ArrayList<Expression> parameters) { this.parameters = parameters; }
}