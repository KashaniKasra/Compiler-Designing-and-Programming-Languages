package main.ast.nodes.expr;

import main.visitor.IVisitor;

import java.util.ArrayList;

public class CommaExpression extends Expression {
    private ArrayList<Expression> expressions = new ArrayList<Expression>();

    public CommaExpression() {}

    public void addExpression(Expression expression) { this.expressions.add(expression); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<Expression> getExpressions() { return expressions; }

    public void setExpressions(ArrayList<Expression> expressions) { this.expressions = expressions; }
}