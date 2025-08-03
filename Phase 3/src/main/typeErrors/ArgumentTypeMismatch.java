package main.typeErrors;

public class ArgumentTypeMismatch extends TypeError {
    public ArgumentTypeMismatch(int line){
        this.line = line;
    }

    public String getErrorMessage() { return "Line:" + this.line + " -> argument type mismatch"; }
}