package main.ast.nodes.expr.operator;

public enum AssignmentOperator {
    ASSIGN, STAR_ASSIGN, DIV_ASSIGN, MOD_ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN, LEFT_SHIFT_ASSIGN, RIGHT_SHIFT_ASSIGN, AND_ASSIGN, XOR_ASSIGN, OR_ASSIGN;

    @Override
    public String toString() {
        return switch (this) {
            case ASSIGN -> "=";
            case STAR_ASSIGN -> "*=";
            case DIV_ASSIGN -> "/=";
            case MOD_ASSIGN -> "%=";
            case PLUS_ASSIGN -> "+=";
            case MINUS_ASSIGN -> "-=";
            case LEFT_SHIFT_ASSIGN -> "<<=";
            case RIGHT_SHIFT_ASSIGN -> ">>=";
            case AND_ASSIGN -> "&=";
            case XOR_ASSIGN -> "^=";
            case OR_ASSIGN -> "|=";
        };
    }
}