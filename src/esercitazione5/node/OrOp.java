package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public class OrOp extends Node implements Operator{

    public OrOp(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }

    @Override
    public <T> T accept(Visitor v) {
         return v.visit(this);
    }

    private Expr left, right;
}
