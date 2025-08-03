package main.ast.nodes.stmt.jump;

import main.visitor.IVisitor;

public class BreakJump extends JumpStatement {
    public BreakJump() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }
}