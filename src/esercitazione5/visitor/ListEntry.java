package esercitazione5.visitor;

import java.util.Objects;

public class ListEntry {

    public ListEntry(Integer key, TabEntry entry) {
        this.key = key;
        this.entry = entry;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public TabEntry getEntry() {
        return entry;
    }

    public void setEntry(TabEntry entry) {
        this.entry = entry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListEntry listEntry = (ListEntry) o;

        if (!Objects.equals(key, listEntry.key)) return false;
        return Objects.equals(entry, listEntry.entry);
    }

    @Override
    public String toString() {
        return "ListEntry[" +
                "key=" + key +
                ", entry=" + entry +
                ']';
    }

    private Integer key;
    private TabEntry entry;
}
