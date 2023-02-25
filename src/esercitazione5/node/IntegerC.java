package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class IntegerC extends Node implements Expr{

    public IntegerC(Object c){
        this.constant = (Integer) c;
    }

    public int getConstant() {
        return constant;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
         return v.visit(this);
    }

    private Integer constant;

}
