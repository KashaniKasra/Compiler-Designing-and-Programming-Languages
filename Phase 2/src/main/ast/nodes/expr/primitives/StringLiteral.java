package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class StringLiteral extends Expression {
    private ArrayList<String> names = new ArrayList<String>();

    public StringLiteral() {}

    public void addName(String name) { this.names.add(name); }

    public String mergeNames() {
        String ans = "";

        for (String name : names)
            ans += " " + name;

        return ans;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<String> getNames() { return names; }

    public void setNames(ArrayList<String> names) { this.names = names; }
}