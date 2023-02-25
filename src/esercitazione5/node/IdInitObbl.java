package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class IdInitObbl extends IdInitBase {

    public IdInitObbl(Id id, Object cnst) {
        this.id = id;
        this.cnst = cnst;
    }

    public Id getId() {
        return id;
    }

    public Object getCnst() {
        return cnst;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }

    private Id id;
    private Object cnst;

}
