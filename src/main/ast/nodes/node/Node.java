package main.ast.nodes.node;

import main.visitor.IVisitor;

public abstract class Node {
    private int line;
    private boolean isUsed = false;

    public abstract <T> T accept(IVisitor<T> visitor);

    public int getLine() { return this.line; }

    public void setLine(int line) { this.line = line; }

    public boolean getIsUsed() { return isUsed; }

    public void setIsUsed(boolean isUsed) { this.isUsed = isUsed; }
}