package main.ast.nodes.expr;

import main.ast.nodes.node.TypeName;
import main.visitor.IVisitor;

public class CastExpression extends Expression {
    private TypeName typeName;
    private Expression expression;

    public CastExpression(TypeName typeName, Expression expression) {
        this.typeName = typeName;
        this.expression = expression;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this); }

    public TypeName getTypeName() { return typeName; }

    public void setTypeName(TypeName typeName) { this.typeName = typeName; }

    public Expression getExpression() { return expression; }

    public void setExpression(Expression expression) { this.expression = expression; }
}