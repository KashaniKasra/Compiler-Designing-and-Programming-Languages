package main.ast.nodes.expr;

import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class FunctionCallExpression extends Expression {
    private Expression name;
    private ArrayList<Expression> parameters = new ArrayList<Expression>();
    private SymbolTable symbolTable;

    public FunctionCallExpression(Expression name) { this.name = name; }

    public void addParameter(Expression parameter) { this.parameters.add(parameter); }

    public void deleteParameter(int index) { this.parameters.remove(index); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getName() { return name; }

    public void setName(Expression name) { this.name = name; }

    public ArrayList<Expression> getParameters() { return parameters; }

    public void setParameters(ArrayList<Expression> parameters) { this.parameters = parameters; }

    public SymbolTable getSymbolTable() { return symbolTable; }

    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }
}