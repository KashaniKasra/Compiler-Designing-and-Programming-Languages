package main.ast.nodes.stmt.iteration;

import main.ast.nodes.expr.Expression;
import main.ast.nodes.stmt.Statement;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class WhileIteration extends IterationStatement {
    private Expression condition;
    private Statement bodyStatement;
    private SymbolTable symbolTable;

    public WhileIteration(Expression condition, Statement bodyStatement) {
        this.condition = condition;
        this.bodyStatement = bodyStatement;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getCondition() { return condition; }

    public void setCondition(Expression condition) { this.condition = condition; }

    public Statement getBodyStatement() { return bodyStatement; }

    public void setBodyStatement(Statement bodyStatement) { this.bodyStatement = bodyStatement; }

    public SymbolTable getSymbolTable() { return symbolTable; }

    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }
}