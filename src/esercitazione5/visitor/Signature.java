package esercitazione5.visitor;

import esercitazione5.node.Type;

import java.util.ArrayList;
import java.util.Objects;

public class Signature implements Params{

    public Signature(Type returnType, ArrayList<Params> arguments) {
        this.returnType = returnType;
        this.arguments = arguments;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public ArrayList<Params> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<Params> arguments) {
        this.arguments = arguments;
    }


    @Override
    public String toString() {
        return "Signature[" +
                ", returnType=" + returnType +
                ", arguments=" + arguments +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Signature signature = (Signature) o;

        return (returnType.name().equalsIgnoreCase(signature.getReturnType().name()))
                && Objects.equals(arguments, signature.arguments);
    }

    private Type returnType;
    private ArrayList<Params> arguments;
}
