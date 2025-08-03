package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

public class Identifier extends Expression {
    private String name;

    public Identifier(String name) { this.name = name; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}