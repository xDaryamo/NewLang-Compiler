package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class FunCall extends Node implements Expr, Stat{

    public FunCall(Id id) {
        this.id = id;
        params = new ArrayList<>();
    }

    public FunCall(Id id, ArrayList<Expr> params) {
        this.id = id;
        this.params = params;
    }

    public Id getId() {
        return id;
    }

    public ArrayList<Expr> getParams() {
        return params;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    private Id id;
    private ArrayList<Expr> params;
}
