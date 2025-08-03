package main.ast.nodes.expr.operator;

public enum UnaryOperator {
    POST_INC, POST_DEC, PRE_INC, PRE_DEC, SIZEOF, AND, STAR, PLUS, MINUS, TILDE, NOT;

    @Override
    public String toString() {
        return switch (this) {
            case POST_INC -> "++";
            case POST_DEC -> "--";
            case PRE_INC -> "++";
            case PRE_DEC -> "--";
            case SIZEOF -> "sizeof";
            case AND -> "&";
            case STAR -> "*";
            case PLUS -> "+";
            case MINUS -> "-";
            case TILDE -> "~";
            case NOT -> "!";
        };
    }
}