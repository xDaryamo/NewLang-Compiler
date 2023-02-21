package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class RealC extends Node implements Expr{

    public RealC(Object c){
        this.constant = (float) c;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    public float getConstant() {
        return constant;
    }

    private float constant;
}
