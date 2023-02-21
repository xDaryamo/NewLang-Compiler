package esercitazione5.visitor;

import java.util.ArrayList;
import java.util.List;

public interface SymTab {

    public TabEntry findEntry(Integer k);

    public SymTab addEntry(Integer k, TabEntry tabEntry);

    public boolean isInScope(Integer k);

    public String printTab();

    public void free();

    public SymTab getOuterLayer();

    public ArrayList<String> getSymList();
}
