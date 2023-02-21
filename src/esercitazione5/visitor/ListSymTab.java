package esercitazione5.visitor;

import esercitazione5.node.Id;

import java.util.ArrayList;
import java.util.List;

public class ListSymTab implements SymTab{

    public ListSymTab() {
        this.outerLayer = null;
        this.list = new ArrayList<>();
    }

    public ListSymTab(SymTab outerLayer, List<ListEntry> list) {
        this.outerLayer = outerLayer;
        this.list = list;
    }

    public ListSymTab(SymTab outerLayer) {
        this.outerLayer = outerLayer;
        this.list = new ArrayList<>();
    }

    @Override
    public TabEntry findEntry(Integer k) {

        TabEntry out = null;

        for(ListEntry le: list){
            if(le.getKey() == k)
                out = le.getEntry();
        }

        return  out;
    }

    @Override
    public SymTab addEntry(Integer k,TabEntry tabEntry) {

        list.add(new ListEntry(k, tabEntry));
        return this;
    }

    @Override
    public boolean isInScope(Integer k) {
        boolean out = false;

        for(ListEntry le: list){
            if(le.getKey() == k)
                out = true;
        }

        return  out;
    }

    @Override
    public String printTab() {
        if(outerLayer==null)
            return "\nSymTabList:\n"+ list.toString();

        else return outerLayer.printTab() + "\nSymTabList:\n"+ list.toString();
    }

    @Override
    public void free() {
        list.clear();
    }

    @Override
    public SymTab getOuterLayer() {
        return outerLayer;
    }

    public List<ListEntry> getList() {
        return list;
    }

    public void setList(List<ListEntry> list) {
        this.list = list;
    }

    public void setOuterLayer(SymTab outerLayer) {
        this.outerLayer = outerLayer;
    }

    @Override
    public ArrayList<String> getSymList(){
        out = new ArrayList<>();

        for (ListEntry t: list) {
            out.add(t.getEntry().toString());
        }

        return  out;
    }

    private List<ListEntry> list;
    private SymTab outerLayer;
    private ArrayList<String> out;
}
