package esercitazione5.visitor;

import esercitazione5.node.*;

public class TypeCheckingVisitor implements Visitor<Void>{

    public TypeCheckingVisitor() {
        this.typeSystem = new TypeSystem();
    }

    private final TypeSystem typeSystem;

    @Override
    public Void visit(TrueC trueC) {

        trueC.setTypeNode(Type.BOOLEAN);
        return null;
    }

    @Override
    public Void visit(FalseC falseC) {

        falseC.setTypeNode(Type.BOOLEAN);
        return null;
    }

    @Override
    public Void visit(IntegerC integerC) {

        integerC.setTypeNode(Type.INTEGER);
        return null;
    }

    @Override
    public Void visit(RealC realC) {

        realC.setTypeNode(Type.FLOAT);
        return null;
    }

    @Override
    public Void visit(CharC charC) {

        charC.setTypeNode(Type.CHAR);
        return null;
    }

    @Override
    public Void visit(StringC stringC) {

        stringC.setTypeNode(Type.STRING);
        return null;
    }

    @Override
    public Void visit(Id id) {

        id.setTypeNode(typeSystem.opIdCheck("Id", id));
        return null;
    }

    @Override
    public Void visit(AddOp addOp) {

        addOp.getLeft().accept(this);
        addOp.getRight().accept(this);
        addOp.setTypeNode(typeSystem.opCheckDoubleArguments("addOp",
                ((Node)addOp.getLeft()).getTypeNode(), ((Node)addOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(SubOp subOp) {

        subOp.getLeft().accept(this);
        subOp.getRight().accept(this);
        subOp.setTypeNode(typeSystem.opCheckDoubleArguments("subOp",
                ((Node)subOp.getLeft()).getTypeNode(), ((Node)subOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(TimesOp timesOp) {

        timesOp.getLeft().accept(this);
        timesOp.getRight().accept(this);
        timesOp.setTypeNode(typeSystem.opCheckDoubleArguments("timesOp",
                ((Node)timesOp.getLeft()).getTypeNode(), ((Node)timesOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(DivOp divOp) {

        divOp.getLeft().accept(this);
        divOp.getRight().accept(this);
        divOp.setTypeNode(typeSystem.opCheckDoubleArguments("divOp",
                ((Node)divOp.getLeft()).getTypeNode(), ((Node)divOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(PowOp powOp) {

        powOp.getLeft().accept(this);
        powOp.getRight().accept(this);
        powOp.setTypeNode(typeSystem.opCheckDoubleArguments("powOp",
                ((Node)powOp.getLeft()).getTypeNode(), ((Node)powOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(ConcatOp concatOp) {

        concatOp.getLeft().accept(this);
        concatOp.getRight().accept(this);
        concatOp.setTypeNode(typeSystem.opCheckDoubleArguments("concatOp",
                ((Node)concatOp.getLeft()).getTypeNode(), ((Node)concatOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(AndOp andOp) {

        andOp.getLeft().accept(this);
        andOp.getRight().accept(this);
        andOp.setTypeNode(typeSystem.opCheckDoubleArguments("andOp",
                ((Node)andOp.getLeft()).getTypeNode(), ((Node)andOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(OrOp orOp) {

        orOp.getLeft().accept(this);
        orOp.getRight().accept(this);
        orOp.setTypeNode(typeSystem.opCheckDoubleArguments("orOp",
                ((Node)orOp.getLeft()).getTypeNode(), ((Node)orOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(NotOp notOp) {

        notOp.getArg().accept(this);
        notOp.setTypeNode(typeSystem.opCheckMonoArgument("notOp", ((Node)notOp.getArg()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(GtOp gtOp) {

        gtOp.getLeft().accept(this);
        gtOp.getRight().accept(this);
        gtOp.setTypeNode(typeSystem.opCheckDoubleArguments("gtOp",
                ((Node)gtOp.getLeft()).getTypeNode(), ((Node)gtOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(GeOp geOp) {

        geOp.getLeft().accept(this);
        geOp.getRight().accept(this);
        geOp.setTypeNode(typeSystem.opCheckDoubleArguments("geOp",
                ((Node)geOp.getLeft()).getTypeNode(), ((Node)geOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(LtOp ltOp) {

        ltOp.getLeft().accept(this);
        ltOp.getRight().accept(this);
        ltOp.setTypeNode(typeSystem.opCheckDoubleArguments("ltOp",
                ((Node)ltOp.getLeft()).getTypeNode(), ((Node)ltOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(LeOp leOp) {

        leOp.getLeft().accept(this);
        leOp.getRight().accept(this);
        leOp.setTypeNode(typeSystem.opCheckDoubleArguments("leOp",
                ((Node)leOp.getLeft()).getTypeNode(), ((Node)leOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(EqOp eqOp) {

        eqOp.getLeft().accept(this);
        eqOp.getRight().accept(this);
        eqOp.setTypeNode(typeSystem.opCheckDoubleArguments("eqOp",
                ((Node)eqOp.getLeft()).getTypeNode(), ((Node)eqOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(NeOp neOp) {

        neOp.getLeft().accept(this);
        neOp.getRight().accept(this);
        neOp.setTypeNode(typeSystem.opCheckDoubleArguments("neOp",
                ((Node)neOp.getLeft()).getTypeNode(), ((Node)neOp.getRight()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(UMinOp uMinOp) {

        uMinOp.getArg().accept(this);
        uMinOp.setTypeNode(typeSystem.opCheckMonoArgument("UMinOp", ((Node)uMinOp.getArg()).getTypeNode()));

        return null;
    }

    @Override
    public Void visit(FunCall funCall) {

        funCall.getId().accept(this);

        for(Expr expr: funCall.getParams()) {

            if(expr instanceof FunCall)
                throw new RuntimeException("A parameter cannot be a function!");

            expr.accept(this);
        }


        funCall.setTypeNode(typeSystem.opFunCheck("funCall", funCall));

        return null;
    }

    @Override
    public Void visit(AssignStat assignStat) {

        for(Id id: assignStat.getL1())
            id.accept(this);

        for(Expr expr: assignStat.getL2())
            expr.accept(this);

        assignStat.setTypeNode(typeSystem.opConstructCheck("assignStat", assignStat));
        return null;
    }

    @Override
    public Void visit(WriteStat writeStat) {

        for(Expr expr: writeStat.getL())
            expr.accept(this);

        writeStat.setTypeNode(typeSystem.opConstructCheck("writeStat", writeStat));
        return null;
    }

    @Override
    public Void visit(ReadStat readStat) {

        for(Id id: readStat.getL())
            id.accept(this);

        readStat.setTypeNode(typeSystem.opConstructCheck("readStat", readStat));

        return null;
    }

    @Override
    public Void visit(ForStat forStat) {

        forStat.getId().accept(this);
        forStat.getBody().accept(this);

        forStat.setTypeNode(typeSystem.opConstructCheck("forStat", forStat));
        return null;
    }

    @Override
    public Void visit(WhileStat whileStat) {

        whileStat.getE().accept(this);

        whileStat.getBody().accept(this);

        whileStat.setTypeNode(typeSystem.opConstructCheck("whileStat", whileStat));
        return null;
    }

    @Override
    public Void visit(IfStat ifStat) {

        ifStat.getE().accept(this);
        ifStat.getBody().accept(this);
        if(ifStat.getEls()!=null)
            ifStat.getEls().accept(this);
        ifStat.setTypeNode(typeSystem.opConstructCheck("ifStat", ifStat));
        return null;
    }

    @Override
    public Void visit(ReturnStat returnStat) {

        returnStat.getE().accept(this);
        returnStat.setTypeNode(typeSystem.opConstructCheck("returnStat", returnStat));
        return null;
    }

    @Override
    public Void visit(ParDecl parDecl) {

        for(Id id: parDecl.getL())
            id.accept(this);

        parDecl.setTypeNode(typeSystem.opParDeclCheck("parDecl", parDecl));
        return null;
    }

    @Override
    public Void visit(Body body) {

        for(VarDecl v: body.getL1())
            v.accept(this);

        for(Stat st: body.getL2())
            st.accept(this);

        body.setTypeNode(Type.NOTYPE);

        return null;
    }

    @Override
    public Void visit(FunDecl funDecl) {

        typeSystem.setFunReturnType(funDecl.getT());

        funDecl.getId().accept(this);

        funDecl.getBody().accept(this);

        if(!funDecl.getBody().getTypeNode().name().equalsIgnoreCase(Type.NOTYPE.name()))
            throw new RuntimeException("Type System Error");

        for(ParDecl p: funDecl.getL()) {
            p.accept(this);
            if (!p.getTypeNode().name().equalsIgnoreCase(Type.NOTYPE.name()))
                throw new RuntimeException("Type System Error");
        }

        funDecl.setTypeNode(typeSystem.opFunCheck("funDecl", funDecl));

        return null;
    }

    @Override
    public Void visit(VarDecl varDecl) {

        for(IdInitBase idInit : varDecl.getL())
        {
            idInit.accept(this);
            if(!Type.compatibility(varDecl.getT(), idInit.getTypeNode()))
                throw new IllegalStateException("Type System Error");

        }

        varDecl.setTypeNode(Type.NOTYPE);
        return null;
    }

    @Override
    public Void visit(IdInitObbl idInitObbl) {

        idInitObbl.getId().accept(this);

        idInitObbl.setTypeNode(typeSystem.opIdInitObbl("idInitObbl", idInitObbl));

        return null;
    }

    @Override
    public Void visit(IdInitStmt idInitStmt) {

        idInitStmt.getId().accept(this);

        if(idInitStmt.getExpr() != null)
        {
            idInitStmt.getExpr().accept(this);
            if(!Type.compatibility(idInitStmt.getId().getTypeNode(), ((Node)idInitStmt.getExpr()).getTypeNode() ))
                throw new IllegalStateException("Expr Type Mismatch Error");

        }

        idInitStmt.setTypeNode(idInitStmt.getId().getTypeNode());

        return null;
    }

    @Override
    public Void visit(Program program) {

        for(Decl decl : program.getL())
        {
            if(decl instanceof FunDecl)
                ((FunDecl)decl).accept(this);

           else ((VarDecl)decl).accept(this);
        }

        program.setTypeNode(Type.NOTYPE);
        return null;
    }

}
