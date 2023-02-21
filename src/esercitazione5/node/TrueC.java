package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class TrueC extends Node implements Expr{

    public TrueC() {
        this.constant = true;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public boolean getTrue() {
        return constant;
    }

    private final boolean constant;
}
