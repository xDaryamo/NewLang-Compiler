package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class CharC extends Node implements Expr{

    public CharC(Object c) {
        this.constant = (char)c;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public char getConstant() {
        return constant;
    }

    private final char constant;
}
