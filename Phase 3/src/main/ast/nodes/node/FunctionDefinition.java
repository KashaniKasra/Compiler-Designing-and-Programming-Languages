package main.ast.nodes.node;

import main.ast.nodes.node.direct_declarator.FunctionDeclarator;
import main.ast.nodes.stmt.CompoundStatement;
import main.symbolTable.SymbolTable;
import main.types.Types;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class FunctionDefinition extends Node {
    private ArrayList<DeclarationSpecifier> typeSpecifiers = new ArrayList<DeclarationSpecifier>();
    private Declarator declarator;
    private ArrayList<Declaration> declarations = new ArrayList<Declaration>();
    private CompoundStatement compoundStatement;
    private String functionName;
    private String originalFunctionName;
    private SymbolTable symbolTable;
    private ArrayList<Integer> free_parameters = new ArrayList<Integer>();
    private Types returnType;

    public FunctionDefinition() {}

    public void addTypeSpecifier(DeclarationSpecifier typeSpecifier) { this.typeSpecifiers.add(typeSpecifier); }

    public void addDeclaration(Declaration declaration) { this.declarations.add(declaration); }

    public void deleteParameterDeclaration(ParameterDeclaration parameterDeclaration) { ((FunctionDeclarator)this.declarator.getDirectDeclarator()).getParameters().remove(parameterDeclaration); }

    public void addFreeParameter(int free_parameter) { this.free_parameters.add(free_parameter); }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public ArrayList<DeclarationSpecifier> getTypeSpecifiers() { return typeSpecifiers; }

    public void setTypeSpecifiers(ArrayList<DeclarationSpecifier> typeSpecifiers) { this.typeSpecifiers = typeSpecifiers; }

    public Declarator getDeclarator() { return declarator; }

    public void setDeclarator(Declarator declarator) { this.declarator = declarator; }

    public ArrayList<Declaration> getDeclarations() { return declarations; }

    public void setDeclarations(ArrayList<Declaration> declarations) { this.declarations = declarations; }

    public CompoundStatement getCompoundStatement() { return compoundStatement; }

    public void setCompoundStatement(CompoundStatement compoundStatement) { this.compoundStatement = compoundStatement; }

    public String getFunctionName() { return functionName; }

    public void setFunctionName(String functionName) { this.functionName = functionName; }

    public String getOriginalFunctionName() { return originalFunctionName; }

    public void setOriginalFunctionName(String originalFunctionName) { this.originalFunctionName = originalFunctionName; }

    public SymbolTable getSymbolTable() { return symbolTable; }

    public void setSymbolTable(SymbolTable symbolTable) { this.symbolTable = symbolTable; }

    public int computeParametersCount() { return ((FunctionDeclarator)this.getDeclarator().getDirectDeclarator()).getParameters().size(); }

    public ArrayList<Integer> getFreeParameters() { return free_parameters; }

    public void setFreeParameters(ArrayList<Integer> free_parameters) { this.free_parameters = free_parameters; }

    public Types getReturnType() { return returnType; }

    public void setReturnType(Types returnType) { this.returnType = returnType; }
}