package main.ast.nodes.stmt;

import main.ast.nodes.expr.Expression;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class SelectionStatement extends Statement {
    private Expression condition;
    private Statement bodyStatement;
    private ArrayList<Expression> elseIfConditions = new ArrayList<Expression>();
    private ArrayList<Statement> elseIfBodyStatements = new ArrayList<Statement>();
    private Statement elseStatement;
    private int ifLine;
    private int elseLine;
    private ArrayList<Integer> elseIfLines = new ArrayList<Integer>();
    private SymbolTable symbolTable;

    public SelectionStatement(Expression condition, Statement bodyStatement) {
        this.condition = condition;
        this.bodyStatement = bodyStatement;
    }

    public void addElseIfCondition(Expression elseIfCondition) { this.elseIfConditions.add(elseIfCondition); }

    public void addElseIfBodyStatement(Statement elseIfBodyStatement) { this.elseIfBodyStatements.add(elseIfBodyStatement); }

    public void addElseIfLine(int elseIfLine) { this.elseIfLines.add(elseIfLine); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public Expression getCondition() { return condition; }

    public void setCondition(Expression condition) { this.condition = condition; }

    public Statement getBodyStatement() { return bodyStatement; }

    public void setBodyStatement(Statement bodyStatement) { this.bodyStatement = bodyStatement; }

    public ArrayList<Expression> getElseIfConditions() { return elseIfConditions; }

    public void setElseIfConditions(ArrayList<Expression> elseIfConditions) { this.elseIfConditions = elseIfConditions; }

    public ArrayList<Statement> getElseIfBodyStatements() { return elseIfBodyStatements; }

    public void setElseIfBodyStatements(ArrayList<Statement> elseIfBodyStatements) { this.elseIfBodyStatements = elseIfBodyStatements; }

    public Statement getElseStatement() { return elseStatement; }

    public void setElseStatement(Statement elseStatement) { this.elseStatement = elseStatement; }

    public int getIfLine() { return ifLine; }

    public void setIfLine(int ifLine) { this.ifLine = ifLine; }

    public int getElseLine() { return elseLine; }

    public void setElseLine(int elseLine) { this.elseLine = elseLine; }

    public ArrayList<Integer> getElseIfLines() { return elseIfLines; }

    public void setElseIfLines(ArrayList<Integer> elseIfLines) { this.elseIfLines = elseIfLines; }

    public SymbolTable getSymbolTable() { return symbolTable; }

    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }
}