package esercitazione5.visitor;

import esercitazione5.node.*;
import java.util.ArrayList;
import java.util.Stack;

public class ScopingVisitor implements Visitor{

    public ScopingVisitor(ArrayList<String> stringTab) {
        this.stringTab = stringTab;
        this.symTabStack = new Stack<>();
    }

    public void openScope(){

        SymTab crScope = null, nwScope;

        if(!symTabStack.isEmpty()) {
            crScope = symTabStack.peek();
        }

        nwScope = new HashSymTab(crScope);
        
        symTabStack.push(nwScope);
    }

    public void addToScope(Integer key, TabEntry entry){

        if (symTabStack.isEmpty()) {
            throw new RuntimeException(
                    "Type environment visitor tried to add " + stringTab.get(key) + " to a non existing scope!");
        }

        SymTab crScope = symTabStack.peek();

        if (crScope.isInScope(key)) {
            throw new RuntimeException(
                    "Type environment visitor tried to add " + stringTab.get(key)
                            + " to current scope but it already contained the name!");
        }

        crScope.addEntry(key, entry);
    }

    public void closeScope(){
        if (symTabStack.isEmpty()) {
            throw new RuntimeException(
                    "Type environment visitor tried to close current scope but scope is empty!");
        }

        symTabStack.pop();
    }

    public SymTab getCurrentScope(){
        if (symTabStack.isEmpty()) {
            throw new IllegalStateException(
                    "Type environment visitor tried to retrieve current scope but scope does not exist!");
        }

        return symTabStack.peek();
    }

    @Override
    public <T> T visit(TrueC trueC) {
        trueC.setCurrent_ref(getCurrentScope());
        return null;
    }

    @Override
    public <T> T visit(FalseC falseC) {
        falseC.setCurrent_ref(getCurrentScope());
        return null;
    }

    @Override
    public <T> T visit(IntegerC integerC) {
        integerC.setCurrent_ref(getCurrentScope());
        return null;
    }

    @Override
    public <T> T visit(RealC realC) {
        realC.setCurrent_ref(getCurrentScope());
        return null;
    }

    @Override
    public <T> T visit(CharC charC) {
        charC.setCurrent_ref(getCurrentScope());
        return null;
    }

    @Override
    public <T> T visit(StringC stringC) {
        stringC.setCurrent_ref(getCurrentScope());
        return null;
    }

    @Override
    public <T> T visit(Id id) {
        id.setCurrent_ref(getCurrentScope());
        return null;
    }

    @Override
    public <T> T visit(AddOp addOp) {

        addOp.setCurrent_ref(getCurrentScope());
        addOp.getLeft().accept(this);
        addOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(SubOp subOp) {
        subOp.setCurrent_ref(getCurrentScope());
        subOp.getLeft().accept(this);
        subOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(TimesOp timesOp) {
        timesOp.setCurrent_ref(getCurrentScope());
        timesOp.getLeft().accept(this);
        timesOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(DivOp divOp) {
        divOp.setCurrent_ref(getCurrentScope());
        divOp.getLeft().accept(this);
        divOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(PowOp powOp) {
        powOp.setCurrent_ref(getCurrentScope());
        powOp.getLeft().accept(this);
        powOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(ConcatOp concatOp) {
        concatOp.setCurrent_ref(getCurrentScope());
        concatOp.getLeft().accept(this);
        concatOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(AndOp andOp) {
        andOp.setCurrent_ref(getCurrentScope());
        andOp.getLeft().accept(this);
        andOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(OrOp orOp) {
        orOp.setCurrent_ref(getCurrentScope());
        orOp.getLeft().accept(this);
        orOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(NotOp notOp) {
        notOp.setCurrent_ref(getCurrentScope());
        notOp.getArg().accept(this);
        return null;
    }

    @Override
    public <T> T visit(GtOp gtOp) {
        gtOp.setCurrent_ref(getCurrentScope());
        gtOp.getLeft().accept(this);
        gtOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(GeOp geOp) {
        geOp.setCurrent_ref(getCurrentScope());
        geOp.getLeft().accept(this);
        geOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(LtOp ltOp) {
        ltOp.setCurrent_ref(getCurrentScope());
        ltOp.getLeft().accept(this);
        ltOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(LeOp leOp) {
        leOp.setCurrent_ref(getCurrentScope());
        leOp.getLeft().accept(this);
        leOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(EqOp eqOp) {
        eqOp.setCurrent_ref(getCurrentScope());
        eqOp.getLeft().accept(this);
        eqOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(NeOp neOp) {
        neOp.setCurrent_ref(getCurrentScope());
        neOp.getLeft().accept(this);
        neOp.getRight().accept(this);
        return null;
    }

    @Override
    public <T> T visit(UMinOp uMinOp) {
        uMinOp.setCurrent_ref(getCurrentScope());
        uMinOp.getArg().accept(this);
        return null;
    }

    @Override
    public <T> T visit(FunCall funCall) {
        funCall.setCurrent_ref(getCurrentScope());
        funCall.getId().accept(this);
        for(Expr expr: funCall.getParams()){
            expr.accept(this);
        }
        return null;
    }

    @Override
    public <T> T visit(AssignStat assignStat) {
        return null;
    }

    @Override
    public <T> T visit(WriteStat writeStat) {
        return null;
    }

    @Override
    public <T> T visit(ReadStat readStat) {
        return null;
    }

    @Override
    public <T> T visit(ForStat forStat) {
        return null;
    }

    @Override
    public <T> T visit(WhileStat whileStat) {
        return null;
    }

    @Override
    public <T> T visit(IfStat ifStat) {
        return null;
    }

    @Override
    public <T> T visit(ReturnStat returnStat) {
        return null;
    }

    @Override
    public <T> T visit(ParDecl parDecl) {
        return null;
    }

    @Override
    public <T> T visit(Body body) {
        return null;
    }

    @Override
    public <T> T visit(FunDecl funDecl) {
        return null;
    }

    @Override
    public <T> T visit(VarDecl varDecl) {
        return null;
    }

    @Override
    public <T> T visit(IdInitBase idInitBase) {
        return null;
    }

    @Override
    public <T> T visit(Program program) {
        return null;
    }

    private ArrayList<String> stringTab;
    private Stack<SymTab> symTabStack;
}
