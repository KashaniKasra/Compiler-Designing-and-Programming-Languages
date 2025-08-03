package main.ast.nodes.stmt;

import main.ast.nodes.node.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class CompoundStatement extends Statement {
    private ArrayList<Node> blockItems = new ArrayList<Node>();

    public CompoundStatement() {}

    public void addBlockItem(Node blockItem) { this.blockItems.add(blockItem); }

    public void deleteDeclaration(Node declaration) { this.blockItems.remove(declaration); }

    public void deleteBlockItem(Node blockItem) { this.blockItems.remove(blockItem); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<Node> getBlockItems() { return blockItems; }

    public void setBlockItems(ArrayList<Node> blockItems) { this.blockItems = blockItems; }
}