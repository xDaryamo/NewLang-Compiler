package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public abstract class IdInitBase extends Node implements Expr{
    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }
}
