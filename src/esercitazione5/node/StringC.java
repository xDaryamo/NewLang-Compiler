package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class StringC extends Node implements Expr{

    public StringC(Object constant) {
        this.constant = (String) constant;
    }

    public String getString() {
        return constant;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    private final String constant;

}
