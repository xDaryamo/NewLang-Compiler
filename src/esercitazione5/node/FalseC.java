package esercitazione5.node;

import esercitazione5.visitor.Visitor;
public class FalseC extends Node implements Expr {

    public FalseC() {
        this.constant = false;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    public boolean getFalse() {
        return constant;
    }

    private final boolean constant;
}
