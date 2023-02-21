package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class ParDecl extends Node implements Expr{

    public ParDecl(Type t, int flag, ArrayList<Id> l) {
        this.t = t;
        this.flag = flag;
        this.l = l;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public Type getT() {
        return t;
    }

    public int getFlag() {
        return flag;
    }

    public ArrayList<Id> getL() {
        return l;
    }

    private Type t;
    private int flag;
    private ArrayList<Id> l;
}
