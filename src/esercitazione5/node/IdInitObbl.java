package esercitazione5.node;

public class IdInitObbl extends IdInitBase {

    public IdInitObbl(Id id, Object cnst) {
        this.id = id;
        this.cnst = cnst;
    }

    public Id getId() {
        return id;
    }

    public Object getCnst() {
        return cnst;
    }

    private Id id;
    private Object cnst;

}
