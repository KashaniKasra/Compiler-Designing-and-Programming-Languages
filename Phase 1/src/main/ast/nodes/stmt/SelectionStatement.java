package main.ast.nodes.stmt;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

public class SelectionStatement extends Statement {
    private Expression condition;
    private Statement bodyStatement;
    private Statement elseStatement;
    private int ifLine;
    private int elseLine;

    public SelectionStatement(Expression condition, Statement bodyStatement) {
        this.condition = condition;
        this.bodyStatement = bodyStatement;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getCondition() { return condition; }

    public void setCondition(Expression condition) { this.condition = condition; }

    public Statement getBodyStatement() { return bodyStatement; }

    public void setBodyStatement(Statement bodyStatement) { this.bodyStatement = bodyStatement; }

    public Statement getElseStatement() { return elseStatement; }

    public void setElseStatement(Statement elseStatement) { this.elseStatement = elseStatement; }

    public int getIfLine() { return ifLine; }

    public void setIfLine(int ifLine) { this.ifLine = ifLine; }

    public int getElseLine() { return elseLine; }

    public void setElseLine(int elseLine) { this.elseLine = elseLine; }
}