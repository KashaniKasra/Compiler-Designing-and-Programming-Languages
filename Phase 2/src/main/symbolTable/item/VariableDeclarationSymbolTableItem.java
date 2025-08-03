package main.symbolTable.item;

import main.ast.nodes.VariableInfo;

public class VariableDeclarationSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "VariableDeclaration_";
    private VariableInfo variableInfo;

    public VariableDeclarationSymbolTableItem(VariableInfo variableInfo) { this.variableInfo = variableInfo; }

    @Override
    public String getKey() { return START_KEY + this.variableInfo.getName(); }

    public VariableInfo getVariableInfo() { return variableInfo; }

    public void setVariableInfo(VariableInfo variableInfo) { this.variableInfo = variableInfo; }
}