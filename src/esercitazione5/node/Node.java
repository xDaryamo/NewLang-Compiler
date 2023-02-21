package esercitazione5.node;

import esercitazione5.visitor.SymTab;

public abstract class Node {

    public SymTab getCurrent_ref() {
        return current_ref;
    }

    public void setCurrent_ref(SymTab current_ref) {
        this.current_ref = current_ref;
    }

    public Type getTypeNode() {
        return typeNode;
    }

    public void setTypeNode(Type typeNode) {
        this.typeNode = typeNode;
    }

    private SymTab current_ref;
    private Type typeNode;
}
