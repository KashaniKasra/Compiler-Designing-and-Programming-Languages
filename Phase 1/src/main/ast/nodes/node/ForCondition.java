package main.ast.nodes.node;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class ForCondition extends Node {
    private Node initial;
    private ArrayList<Expression> conditions = new ArrayList<Expression>();
    private ArrayList<Expression> updates = new ArrayList<Expression>();

    public ForCondition() {}

    public void addCondition(Expression condition) { this.conditions.add(condition); }

    public void addUpdate(Expression update) { this.updates.add(update); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Node getInitial() { return initial; }

    public void setInitial(Node initial) { this.initial = initial; }

    public ArrayList<Expression> getConditions() { return conditions; }

    public void setConditions(ArrayList<Expression> conditions) { this.conditions = conditions; }

    public ArrayList<Expression> getUpdates() { return updates; }

    public void setUpdates(ArrayList<Expression> updates) { this.updates = updates; }
}