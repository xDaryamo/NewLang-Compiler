package esercitazione5.visitor;

import esercitazione5.node.*;

public interface Visitor {
    public <T> T visit(TrueC trueC);
    public <T> T visit(FalseC falseC);
    public <T> T visit(IntegerC integerC);
    public <T> T visit(RealC realC);
    public <T> T visit(CharC charC);
    public <T> T visit(StringC stringC);
    public <T> T visit(Id id);
    public <T> T visit(AddOp addOp);
    public <T> T visit(SubOp subOp);
    public <T> T visit(TimesOp timesOp);
    public <T> T visit(DivOp divOp);
    public <T> T visit(PowOp powOp);
    public <T> T visit(ConcatOp concatOp);
    public <T> T visit(AndOp andOp);
    public <T> T visit(OrOp orOp);
    public <T> T visit(NotOp notOp);
    public <T> T visit(GtOp gtOp);
    public <T> T visit(GeOp geOp);
    public <T> T visit(LtOp ltOp);
    public <T> T visit(LeOp leOp);
    public <T> T visit(EqOp eqOp);
    public <T> T visit(NeOp neOp);
    public <T> T visit(UMinOp uMinOp);
    public <T> T visit(FunCall funCall);
    public <T> T visit(AssignStat assignStat);
    public <T> T visit(WriteStat writeStat);
    public <T> T visit(ReadStat readStat);
    public <T> T visit(ForStat forStat);
    public <T> T visit(WhileStat whileStat);
    public <T> T visit(IfStat ifStat);
    public <T> T visit(ReturnStat returnStat);
    public <T> T visit(ParDecl parDecl);
    public <T> T visit(Body body);
    public <T> T visit(FunDecl funDecl);
    public <T> T visit(VarDecl varDecl);
    public <T> T visit(IdInitObbl idInitObbl);
    public <T> T visit(IdInitStmt idInitStmt);
    public <T> T visit(Program program);
}
