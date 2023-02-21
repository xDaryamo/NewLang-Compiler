package esercitazione5.visitor;

import esercitazione5.node.Id;

import java.util.Objects;

public class TabEntry {

    public TabEntry(Id id, Params params) {
        this.id = id;
        this.params = params;
    }

    public TabEntry(Integer etr) {
        this.id = new Id(etr);
    }

    public Params getParams() {
        return params;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }


    public void setParams(Params params) {
        this.params = params;
    }

    @Override
    public String toString() {

        return "TabEntry[" +
                "id=" + id +
                ", params=" + params +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabEntry tabEntry = (TabEntry) o;

        return (Objects.equals(id, tabEntry.id))
                && (Objects.equals(params, tabEntry.params));

    }

    @Override
    public int hashCode() {
        return 0;
    }

    private Id id;
    private Params params;

}
