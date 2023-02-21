package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class FunDecl extends Node implements Expr, Decl{

    public FunDecl(Id id, ArrayList<ParDecl> l, Type t, Body b) {
        this.id = id;
        this.l = l;
        this.t = t;
        this.body = b;
        this.isMain = false;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public ArrayList<ParDecl> getL() {
        return l;
    }

    public Type getT() {
        return t;
    }

    public Body getBody() {
        return body;
    }

    public void checkM(){
        this.isMain = true;
    }

    public boolean isMain() {
        return isMain;
    }

    public Id getId() {
        return id;
    }

    private ArrayList<ParDecl> l;
    private Type t;
    private Body body;

    private Id id;

    private boolean isMain;
}
