package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class ForStat extends Node implements Stat{

    public ForStat(Integer c1, Integer c2, Id id, Body body) {
        this.c1 = c1;
        this.c2 = c2;
        this.id = id;
        this.body = body;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    public Integer getC1() {
        return c1;
    }

    public Integer getC2() {
        return c2;
    }

    public Id getId() {
        return id;
    }

    public Body getBody() {
        return body;
    }

    private final Integer c1;
    private final Integer c2;
    private final Id id;
    private final Body body;
}
