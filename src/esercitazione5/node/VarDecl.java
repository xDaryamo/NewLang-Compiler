package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class VarDecl extends Node implements Expr, Decl{

    public VarDecl(Type t, ArrayList<? extends IdInitBase> l) {
        this.t = t;
        this.l = l;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public Type getT() {
        return t;
    }

    public ArrayList<? extends IdInitBase> getL() {
        return l;
    }

    private Type t;
    private ArrayList<? extends IdInitBase> l;

}
