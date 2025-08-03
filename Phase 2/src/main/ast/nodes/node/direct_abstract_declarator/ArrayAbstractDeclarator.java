package main.ast.nodes.node.direct_abstract_declarator;

import main.ast.nodes.expr.Expression;
import main.visitor.IVisitor;

public class ArrayAbstractDeclarator extends DirectAbstractDeclarator {
    private DirectAbstractDeclarator directAbstractDeclarator;
    private Expression expression;

    public ArrayAbstractDeclarator(DirectAbstractDeclarator directAbstractDeclarator) { this.directAbstractDeclarator = directAbstractDeclarator; }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public DirectAbstractDeclarator getDirectAbstractDeclarator() { return directAbstractDeclarator; }

    public void setDirectAbstractDeclarator(DirectAbstractDeclarator directAbstractDeclarator) { this.directAbstractDeclarator = directAbstractDeclarator; }

    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}