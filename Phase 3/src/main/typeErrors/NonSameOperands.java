package main.typeErrors;

public class NonSameOperands extends TypeError {
    public NonSameOperands(int line){
        this.line = line;
    }

    public String getErrorMessage() { return "Line:" + this.line + " -> type mismatch in expression"; }
}