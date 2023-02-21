package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class WriteStat extends Node implements Stat{

    public WriteStat(ArrayList<Expr> l, int ln) {
        this.l = l;
        this.ln = ln;
    }

    public int getLn() {
        return ln;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public ArrayList<Expr> getL() {
        return l;
    }

    private ArrayList<Expr> l;
    private final int ln;
}
