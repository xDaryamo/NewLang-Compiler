package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class NotOp extends Node implements Operator{

    public NotOp(Expr arg) {
        this.arg = arg;
    }

    public Expr getArg() {
        return arg;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    private Expr arg;
}
