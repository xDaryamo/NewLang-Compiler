package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class Program extends Node implements Expr{

    public Program(ArrayList<Decl> l1, FunDecl f, ArrayList<Decl> l2) {
        this.l1 = l1;
        this.f = f;
        this.l2 = l2;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public ArrayList<Decl> getL1() {
        return l1;
    }

    public FunDecl getF() {
        return f;
    }

    public ArrayList<Decl> getL2() {
        return l2;
    }

    private ArrayList<Decl> l1, l2;
    private FunDecl f;
}
