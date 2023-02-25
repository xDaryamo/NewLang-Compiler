package esercitazione5.node;

import esercitazione5.visitor.Visitor;

import java.util.ArrayList;

public class ReadStat extends Node implements Stat{

    public ReadStat(ArrayList<Id> l) {
        this.l = l;
    }

    public ReadStat(ArrayList<Id> l, String s) {
        this.l = l;
        this.s = s;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    public ArrayList<Id> getL() {
        return l;
    }

    public String getS() {
        return s;
    }

    private ArrayList<Id> l;
    private String s;
}
