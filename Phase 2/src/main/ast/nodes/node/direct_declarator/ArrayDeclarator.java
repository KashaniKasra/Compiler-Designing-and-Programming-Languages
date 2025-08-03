package main.ast.nodes.node.direct_declarator;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

public class ArrayDeclarator extends DirectDeclarator {
    private DirectDeclarator directDeclarator;
    private Expression expression;

    public ArrayDeclarator(DirectDeclarator directDeclarator) { this.directDeclarator = directDeclarator; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public DirectDeclarator getDirectDeclarator() { return directDeclarator; }

    public void setDirectDeclarator(DirectDeclarator directDeclarator) { this.directDeclarator = directDeclarator; }

    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}