package main.ast.nodes.stmt.iteration;

import main.ast.nodes.node.ForCondition;
import main.ast.nodes.stmt.Statement;
import main.visitor.IVisitor;

public class ForIteration extends IterationStatement {
    private ForCondition forCondition;
    private Statement bodyStatement;

    public ForIteration(ForCondition forCondition, Statement bodyStatement) {
        this.forCondition = forCondition;
        this.bodyStatement = bodyStatement;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ForCondition getForCondition() { return forCondition; }

    public void setForCondition(ForCondition forCondition) { this.forCondition = forCondition; }

    public Statement getBodyStatement() { return bodyStatement; }

    public void setBodyStatement(Statement bodyStatement) { this.bodyStatement = bodyStatement; }
}