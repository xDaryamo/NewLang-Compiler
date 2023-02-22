package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class Program extends Node implements Expr{

    public Program(ArrayList<Decl> l) {
        this.l = l;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public ArrayList<Decl> getL() {
        return l;
    }

    private ArrayList<Decl> l;

}
