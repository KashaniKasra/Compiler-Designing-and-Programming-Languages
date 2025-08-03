package main.ast.nodes.expr.operator;

public enum BinaryOperator {
    STAR, DIV, MOD, PLUS, MINUS, LEFT_SHIFT, RIGHT_SHIFT, LESS, GREATER, LESS_EQUAL, GREATER_EQUAL, EQUAL, NOT_EQUAL, AND, XOR, OR, AND_AND, OR_OR;

    @Override
    public String toString() {
        return switch (this) {
            case STAR -> "*";
            case DIV -> "/";
            case MOD -> "%";
            case PLUS -> "+";
            case MINUS -> "-";
            case LEFT_SHIFT -> "<<";
            case RIGHT_SHIFT -> ">>";
            case LESS -> "<";
            case GREATER -> ">";
            case LESS_EQUAL -> "<=";
            case GREATER_EQUAL -> ">=";
            case EQUAL -> "==";
            case NOT_EQUAL -> "!=";
            case AND -> "&";
            case XOR -> "^";
            case OR -> "|";
            case AND_AND -> "&&";
            case OR_OR -> "||";
        };
    }
}