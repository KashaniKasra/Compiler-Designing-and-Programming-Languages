package main.symbolTable.item;

import main.ast.nodes.node.FunctionDefinition;

public class FunctionDefinitionSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "FunctionDefinition_";
    private FunctionDefinition functionDefinition;

    public FunctionDefinitionSymbolTableItem(FunctionDefinition functionDefinition) { this.functionDefinition = functionDefinition; }

    @Override
    public String getKey() { return START_KEY + this.functionDefinition.getFunctionName(); }

    public FunctionDefinition getFunctionDefinition() {
        return functionDefinition;
    }

    public void setFunctionDefinition(FunctionDefinition functionDefinition) { this.functionDefinition = functionDefinition; }
}