package main.typeErrors;

public class ReturnTypeMismatch extends TypeError {
    public ReturnTypeMismatch(int line){
        this.line = line;
    }

    public String getErrorMessage() { return "Line:" + this.line + " -> return type mismatch"; }
}