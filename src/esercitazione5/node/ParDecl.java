package esercitazione5.node;

import esercitazione5.visitor.Params;
import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class ParDecl extends Node implements Expr, Params {

    public ParDecl(Type t, boolean flag, ArrayList<Id> l) {
        this.t = t;
        this.flag = flag;
        this.l = l;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    public Type getT() {
        return t;
    }

    public boolean getFlag() {
        return flag;
    }

    public ArrayList<Id> getL() {
        return l;
    }

    private Type t;
    private boolean flag;
    private ArrayList<Id> l;
}
