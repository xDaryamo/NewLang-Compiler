package esercitazione5.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashSymTab implements SymTab {

    public HashSymTab() {
        this.outerLayer = null;
        this.symMap = new HashMap<>();
    }

    public HashSymTab(SymTab outerLayer) {

        this.outerLayer = outerLayer;
        this.symMap = new HashMap<>();
    }

    @Override
    public TabEntry findEntry(Integer k) {

        TabEntry etr = symMap.get(k);

        if(etr == null && outerLayer != null){
            return outerLayer.findEntry(k);
        }

        return etr;
    }

    @Override
    public boolean isInScope(Integer k) {

        return symMap.containsKey(k);
    }

    @Override
    public SymTab addEntry(Integer k, TabEntry tabEntry) {

        symMap.put(k, tabEntry);

        return this;
    }

    @Override
    public String printTab() {

        if(outerLayer==null)
            return "SymTabHashMap:\n"+ symMap.toString();

        else return outerLayer.printTab() + "\nSymTabHashMap:\n"+ symMap.toString();
    }

    @Override
    public void free() {
        symMap.clear();
    }

    public void setOuterLayer(SymTab outerLayer) {
        this.outerLayer = outerLayer;
    }

    public void setSymMap(HashMap<Integer, TabEntry> symMap) {
        this.symMap = symMap;
    }

    @Override
    public SymTab getOuterLayer() {
        return outerLayer;
    }
    @Override
    public ArrayList<String> getSymList() {
        ArrayList<String> out = new ArrayList<>();

        for(Integer k: symMap.keySet())
            for(TabEntry t: symMap.values())
                out.add(t.toString());

        return out;
    }
    public HashMap<Integer, TabEntry> getSymMap() {
        return symMap;
    }
    private SymTab outerLayer;
    private HashMap<Integer, TabEntry> symMap;
}