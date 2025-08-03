package main.ast.nodes.node;

import main.visitor.IVisitor;

public abstract class Node {
    private int line;

    public void setLine(int line) { this.line = line; }

    public int getLine() { return this.line; }

    public abstract <T> T accept(IVisitor<T> visitor);
}