package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class IfStat extends Node implements Stat{

    public IfStat(Body els, Body body, Expr e) {
        this.els = els;
        this.body = body;
        this.e = e;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    public Body getEls() {
        return els;
    }

    public Body getBody() {
        return body;
    }

    public Expr getE() {
        return e;
    }

    private Body els, body;
    private Expr e;
}
