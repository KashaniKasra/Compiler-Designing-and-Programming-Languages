package main.typeErrors;

public abstract class TypeError {
    protected int line;

    public abstract String getErrorMessage();

    public int getLine() {
        return line;
    }
}