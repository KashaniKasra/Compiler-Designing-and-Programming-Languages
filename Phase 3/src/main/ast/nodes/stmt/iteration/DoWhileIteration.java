package main.ast.nodes.stmt.iteration;

import main.ast.nodes.expr.Expression;
import main.ast.nodes.stmt.Statement;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class DoWhileIteration extends IterationStatement {
    private Statement bodyStatement;
    private Expression condition;
    private SymbolTable symbolTable;

    public DoWhileIteration(Statement bodyStatement, Expression condition) {
        this.bodyStatement = bodyStatement;
        this.condition = condition;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Statement getBodyStatement() { return bodyStatement; }

    public void setBodyStatement(Statement bodyStatement) { this.bodyStatement = bodyStatement; }

    public Expression getCondition() { return condition; }

    public void setCondition(Expression condition) { this.condition = condition; }

    public SymbolTable getSymbolTable() { return symbolTable; }

    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }
}