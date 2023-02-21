package esercitazione5.node;

public class IdInitStmt extends IdInitBase{

    public IdInitStmt(Id id) {
        this.id = id;
    }

    public IdInitStmt(Id id, Expr expr) {
        this.id = id;
        this.expr = expr;
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
