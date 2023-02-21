package esercitazione5.visitor;

import esercitazione5.node.Type;

public class Variable implements Params{

    public Variable(Type type, boolean byReference) {
        this.type = type;
        this.byReference = byReference;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isByReference() {
        return byReference;
    }

    public void setByReference(boolean byReference) {
        this.byReference = byReference;
    }

    @Override
    public String toString() {

        return "Variable[" +
                "type=" + type +
                ", byReference=" + byReference +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable that = (Variable) o;

        return (type.name().equalsIgnoreCase(that.type.name()))
                && (byReference == that.byReference);
    }

    private Type type;
    private boolean byReference;
}
