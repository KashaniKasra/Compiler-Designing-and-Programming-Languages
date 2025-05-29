package main.ast.nodes.stmt.jump;

import main.visitor.IVisitor;

public class ContinueJump extends JumpStatement {
    public ContinueJump() {}

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }
}