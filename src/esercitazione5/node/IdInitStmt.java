package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class IdInitStmt extends IdInitBase{

    public IdInitStmt(Id id) {
        this.id = id;
    }

    public IdInitStmt(Id id, Expr expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    public Id getId() {
        return id;
    }

    public Expr getExpr() {
        return expr;
    }

    private Id id;
    private Expr expr;
}
