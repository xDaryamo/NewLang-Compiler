package esercitazione5.node;

import esercitazione5.visitor.Visitor;

public interface Expr {
    public <T> T accept(Visitor<T> v);
}
