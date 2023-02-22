package esercitazione5.visitor;

import esercitazione5.node.*;

public class TypeCheckingVisitor implements Visitor{
    @Override
    public <T> T visit(TrueC trueC) {
        return null;
    }

    @Override
    public <T> T visit(FalseC falseC) {
        return null;
    }

    @Override
    public <T> T visit(IntegerC integerC) {
        return null;
    }

    @Override
    public <T> T visit(RealC realC) {
        return null;
    }

    @Override
    public <T> T visit(CharC charC) {
        return null;
    }

    @Override
    public <T> T visit(StringC stringC) {
        return null;
    }

    @Override
    public <T> T visit(Id id) {
        return null;
    }

    @Override
    public <T> T visit(AddOp addOp) {
        return null;
    }

    @Override
    public <T> T visit(SubOp subOp) {
        return null;
    }

    @Override
    public <T> T visit(TimesOp timesOp) {
        return null;
    }

    @Override
    public <T> T visit(DivOp divOp) {
        return null;
    }

    @Override
    public <T> T visit(PowOp powOp) {
        return null;
    }

    @Override
    public <T> T visit(ConcatOp concatOp) {
        return null;
    }

    @Override
    public <T> T visit(AndOp andOp) {
        return null;
    }

    @Override
    public <T> T visit(OrOp orOp) {
        return null;
    }

    @Override
    public <T> T visit(NotOp notOp) {
        return null;
    }

    @Override
    public <T> T visit(GtOp gtOp) {
        return null;
    }

    @Override
    public <T> T visit(GeOp geOp) {
        return null;
    }

    @Override
    public <T> T visit(LtOp ltOp) {
        return null;
    }

    @Override
    public <T> T visit(LeOp leOp) {
        return null;
    }

    @Override
    public <T> T visit(EqOp eqOp) {
        return null;
    }

    @Override
    public <T> T visit(NeOp neOp) {
        return null;
    }

    @Override
    public <T> T visit(UMinOp uMinOp) {
        return null;
    }

    @Override
    public <T> T visit(FunCall funCall) {
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
    public <T> T visit(IdInitObbl idInitObbl) {
        return null;
    }

    @Override
    public <T> T visit(IdInitStmt idInitStmt) {
        return null;
    }

    @Override
    public <T> T visit(Program program) {
        return null;
    }
}
