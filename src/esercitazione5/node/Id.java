package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class Id extends Node implements Expr{

    public Id(Integer id) {
        this.identifier = id;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    private final Integer identifier;

}
