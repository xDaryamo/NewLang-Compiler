package esercitazione5.visitor;

import esercitazione5.node.*;
import java.util.ArrayList;
import java.util.Stack;

public class ScopingVisitor implements Visitor{

    public ScopingVisitor(ArrayList<String> stringTab) {
        this.stringTab = stringTab;
        this.symTabStack = new Stack<>();
    }

    public void openScope() {

        SymTab crScope = null;
        SymTab nwScope;

        if(!symTabStack.isEmpty()) {
            crScope = symTabStack.peek();
            nwScope = new HashSymTab(crScope);
        }

        else nwScope = new HashSymTab();

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

        assignStat.setCurrent_ref(getCurrentScope());

        for (Expr ex : assignStat.getL1()) {
            ex.accept(this);
        }

        for (Expr ex : assignStat.getL2()) {
            ex.accept(this);
        }

        return null;
    }

    @Override
    public <T> T visit(WriteStat writeStat) {

        writeStat.setCurrent_ref(getCurrentScope());

        for (Expr ex : writeStat.getL()) {
            ex.accept(this);
        }

        return null;
    }

    @Override
    public <T> T visit(ReadStat readStat) {

        readStat.setCurrent_ref(getCurrentScope());

        for (Expr ex : readStat.getL()) {
            ex.accept(this);
        }

        return null;
    }

    @Override
    public <T> T visit(ForStat forStat) {

        forStat.setCurrent_ref(getCurrentScope());

        openScope();
        addToScope(forStat.getId().getIdentifier(),
                new TabEntry(forStat.getId(), new Variable(Type.INTEGER, false)));
        forStat.getId().accept(this);
        forStat.getBody().accept(this);
        closeScope();

        return null;
    }

    @Override
    public <T> T visit(WhileStat whileStat) {

        whileStat.setCurrent_ref(getCurrentScope());
        whileStat.getE().accept(this);
        openScope();
        whileStat.getBody().accept(this);
        closeScope();

        return null;
    }

    @Override
    public <T> T visit(IfStat ifStat) {

        ifStat.setCurrent_ref(getCurrentScope());
        ifStat.getE().accept(this);

        openScope();
        ifStat.getBody().accept(this);
        closeScope();

        if (ifStat.getEls() != null) {
            openScope();
            ifStat.getEls().accept(this);
            closeScope();
        }

        return null;
    }

    @Override
    public <T> T visit(ReturnStat returnStat) {

        returnStat.setCurrent_ref(getCurrentScope());

        if (returnStat.getE() != null) {
            returnStat.getE().accept(this);
        }

        return null;
    }

    @Override
    public <T> T visit(ParDecl parDecl) {

        parDecl.setCurrent_ref(getCurrentScope());

        for (Id ex : parDecl.getL()) {
            ex.accept(this);
            addToScope(ex.getIdentifier(), new TabEntry(ex, new Variable(parDecl.getT(), parDecl.getFlag())));
        }

        return null;
    }

    @Override
    public <T> T visit(Body body) {

        body.setCurrent_ref(getCurrentScope());

        for (VarDecl v : body.getL1()) {
            v.accept(this);
        }
        for (Stat st : body.getL2()) {
            st.accept(this);
        }

        return null;
    }

    @Override
    public <T> T visit(FunDecl funDecl) {

        funDecl.getId().accept(this);

        ArrayList<TabEntry> args = new ArrayList<>();

        funDecl.setCurrent_ref(getCurrentScope());

        openScope();

        for (ParDecl prDcl : funDecl.getL()) {
            prDcl.accept(this);
        }

        funDecl.getBody().accept(this);

        closeScope();

        for(ParDecl parDecl: funDecl.getL())
            for(Id id: parDecl.getL())
                args.add(new TabEntry(id, new Variable(parDecl.getT(), parDecl.getFlag() )));

        addToScope(funDecl.getId().getIdentifier(), new TabEntry(funDecl.getId(),
                new Signature(funDecl.getT(), args)));

        return null;
    }

    @Override
    public <T> T visit(VarDecl varDecl) {

        varDecl.setCurrent_ref(getCurrentScope());
        Type type = varDecl.getT();

        for (IdInitBase idInit : varDecl.getL())
        {
            if(varDecl.getT().name().equalsIgnoreCase(String.valueOf(Type.VAR)))
            {
                IdInitObbl idInitObbl= (IdInitObbl) idInit;

                if(idInitObbl.getCnst() instanceof Integer){
                    type = Type.INTEGER;}
                if(idInitObbl.getCnst() instanceof Float)
                    type =Type.FLOAT;
                if(idInitObbl.getCnst() instanceof String)
                    type =Type.STRING;
                if(idInitObbl.getCnst() instanceof Character)
                    type =Type.CHAR;
                if(idInitObbl.getCnst() instanceof Boolean)
                    type=Type.BOOLEAN;

                addToScope( (idInitObbl.getId().getIdentifier()),
                        new TabEntry(idInitObbl.getId(), new Variable(type, false)));

                idInitObbl.accept(this);
            }

            else {

                IdInitStmt idInitStmt = (IdInitStmt)idInit;
                addToScope( (idInitStmt.getId().getIdentifier()),
                        new TabEntry(idInitStmt.getId(), new Variable(type, false)));

                idInitStmt.accept(this);
            }

        }

        return null;
    }
    @Override
    public <T> T visit(IdInitObbl idInitObbl) {

        idInitObbl.setCurrent_ref(getCurrentScope());
        idInitObbl.getId().accept(this);

        return null;
    }

    @Override
    public <T> T visit(IdInitStmt idInitStmt) {
        idInitStmt.setCurrent_ref(getCurrentScope());

        idInitStmt.getId().accept(this);

        if(idInitStmt.getExpr()!=null)
            idInitStmt.getExpr().accept(this);

        return null;
    }

    @Override
    public <T> T visit(Program program) {

        openScope();
        program.setCurrent_ref(getCurrentScope());

        for (Decl decl : program.getL()) {
            if(decl instanceof FunDecl)
                ((FunDecl)decl).accept(this);

            else ((VarDecl)decl).accept(this);
        }

        closeScope();

        return null;
    }

    public void printScopes(){

        for(SymTab symTab: symTabStack)
            System.out.println(symTab.printTab());
    }

    public Stack<SymTab> getSymTabStack() {
        return symTabStack;
    }

    private ArrayList<String> stringTab;
    private Stack<SymTab> symTabStack;
}
