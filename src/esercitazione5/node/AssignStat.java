package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class AssignStat extends Node implements Stat{

    public AssignStat(ArrayList<Id> l1, ArrayList<Expr> l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public ArrayList<Id> getL1() {
        return l1;
    }

    public ArrayList<Expr> getL2() {
        return l2;
    }

    private final ArrayList<Id> l1;
    private final ArrayList<Expr> l2;
}
