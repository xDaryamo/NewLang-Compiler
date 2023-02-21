package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class UMinOp extends Node implements Operator{

    public UMinOp(Expr arg) {
        this.arg = arg;
    }

    public Expr getArg() {
        return arg;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    private Expr arg;
}
