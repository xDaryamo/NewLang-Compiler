package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class WhileStat extends Node implements Stat{

    public WhileStat(Expr e, Body body) {
        this.e = e;
        this.body = body;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public Expr getE() {
        return e;
    }

    public Body getBody() {
        return body;
    }

    private final Expr e;
    private final Body body;
}
