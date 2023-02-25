package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class ReturnStat extends Node implements Stat{

    public ReturnStat(){}

    public ReturnStat(Expr e) {
        this.e = e;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    public Expr getE() {
        return e;
    }

    private Expr e;
}
