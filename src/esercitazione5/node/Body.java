package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class Body extends Node implements Expr{

    public Body(ArrayList<VarDecl> l1, ArrayList<Stat> l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public ArrayList<VarDecl> getL1() {
        return l1;
    }

    public ArrayList<Stat> getL2() {
        return l2;
    }

    private ArrayList<VarDecl> l1;
    private ArrayList<Stat> l2;
}
