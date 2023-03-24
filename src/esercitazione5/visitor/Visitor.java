package esercitazione5.visitor;

import esercitazione5.node.*;

public interface Visitor<T> {
    public  T visit(TrueC trueC);
    public  T visit(FalseC falseC);
    public  T visit(IntegerC integerC);
    public  T visit(RealC realC);
    public  T visit(CharC charC);
    public  T visit(StringC stringC);
    public  T visit(Id id);
    public  T visit(AddOp addOp);
    public  T visit(SubOp subOp);
    public  T visit(TimesOp timesOp);
    public  T visit(DivOp divOp);
    public  T visit(PowOp powOp);
    public  T visit(ConcatOp concatOp);
    public  T visit(AndOp andOp);
    public  T visit(OrOp orOp);
    public  T visit(NotOp notOp);
    public  T visit(GtOp gtOp);
    public  T visit(GeOp geOp);
    public  T visit(LtOp ltOp);
    public  T visit(LeOp leOp);
    public  T visit(EqOp eqOp);
    public  T visit(NeOp neOp);
    public  T visit(UMinOp uMinOp);
    public  T visit(FunCall funCall);
    public  T visit(AssignStat assignStat);
    public  T visit(WriteStat writeStat);
    public  T visit(ReadStat readStat);
    public  T visit(ForStat forStat);
    public  T visit(WhileStat whileStat);
    public  T visit(IfStat ifStat);
    public  T visit(ReturnStat returnStat);
    public  T visit(ParDecl parDecl);
    public  T visit(Body body);
    public  T visit(FunDecl funDecl);
    public  T visit(VarDecl varDecl);
    public  T visit(IdInitObbl idInitObbl);
    public  T visit(IdInitStmt idInitStmt);
    public  T visit(Program program);
    public T visit(GoWhenStat goWhenStat);
    public T visit(OtherwiseStat otherwiseStat);
    public T visit(LetStat letStat);
}
