package esercitazione5.visitor;

import esercitazione5.node.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TypeCheckingViewVisitor implements Visitor<Void>{

    public TypeCheckingViewVisitor(FileWriter fileWriter, ArrayList<String> stringTab) {
        this.fileWriter = fileWriter;
        this.stringTab = stringTab;
    }

    private FileWriter fileWriter;
    private ArrayList<String> stringTab;

    @Override
    public Void visit(TrueC trueC) {

        try {
            fileWriter.append("<TrueC>\n");
            fileWriter.append("<Boolean value =").append('"')
                    .append(String.valueOf(trueC.getTrue())).append('"').append("/>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(trueC.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</TrueC>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(FalseC falseC) {

        try {
            fileWriter.append("<FalseC>\n");
            fileWriter.append("<Boolean value =").append('"')
                    .append(String.valueOf(falseC.getFalse())).append('"').append("/>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(falseC.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</FalseC>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(IntegerC integerC) {

        try {
            fileWriter.append("<IntegerC>\n");
            fileWriter.append("<Integer value =").append('"')
                    .append(String.valueOf(integerC.getConstant())).append('"').append("/>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.append("<Type>\n");
            if(integerC.getCurrent_ref()!=null)
                fileWriter.append(integerC.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</IntegerC>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(RealC realC) {

        try {
            fileWriter.append("<RealC>\n");
            fileWriter.append("<Float value =").append('"')
                    .append(String.valueOf(realC.getConstant())).append('"').append("/>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(realC.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</RealC>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(CharC charC) {

        try {
            fileWriter.append("<CharC>\n");
            fileWriter.append("<Char value =").append('"')
                    .append(String.valueOf(charC.getConstant())).append('"').append("/>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(charC.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</CharC>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(StringC stringC) {

        try {
            fileWriter.append("<StringC>\n");
            fileWriter.append("<String value =").append('"').append(stringC.getConstant()).append('"').append("/>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(stringC.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</StringC>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(Id id) {

        try {
            fileWriter.append("<Identifier>\n");
            fileWriter.append("<Identifier value =").append('"')
                    .append(String.valueOf(stringTab.get(id.getIdentifier()))).append('"').append("/>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.append("<Type>\n");
            if(id.getCurrent_ref()!=null)
                fileWriter.append(id.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</Identifier>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(AddOp addOp) {

        try {
            fileWriter.append("<AddOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        addOp.getLeft().accept(this);
        addOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(addOp.getCurrent_ref()!=null)
                fileWriter.append(addOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</AddOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(SubOp subOp) {

        try {
            fileWriter.append("<SubOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        subOp.getLeft().accept(this);
        subOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(subOp.getCurrent_ref()!=null)
                fileWriter.append(subOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</SubOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(TimesOp timesOp) {

        try {
            fileWriter.append("<TimesOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        timesOp.getLeft().accept(this);
        timesOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(timesOp.getCurrent_ref()!=null)
                fileWriter.append(timesOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</TimesOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(DivOp divOp) {

        try {
            fileWriter.append("<DivOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        divOp.getLeft().accept(this);
        divOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(divOp.getCurrent_ref()!=null)
                fileWriter.append(divOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</DivOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(PowOp powOp) {

        try {
            fileWriter.append("<PowOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        powOp.getLeft().accept(this);
        powOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(powOp.getCurrent_ref()!=null)
                fileWriter.append(powOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</PowOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(ConcatOp concatOp) {

        try {
            fileWriter.append("<ConcatOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        concatOp.getLeft().accept(this);
        concatOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(concatOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</ConcatOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(AndOp andOp) {

        try {
            fileWriter.append("<AndOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        andOp.getLeft().accept(this);
        andOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(andOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</AndOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(OrOp orOp) {

        try {
            fileWriter.append("<OrOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        orOp.getLeft().accept(this);
        orOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(orOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</OrOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(NotOp notOp) {

        try {
            fileWriter.append("<NotOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        notOp.getArg().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(notOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</NotOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(GtOp gtOp) {

        try {
            fileWriter.append("<GtOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        gtOp.getLeft().accept(this);
        gtOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(gtOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</GtOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(GeOp geOp) {

        try {
            fileWriter.append("<GeOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        geOp.getLeft().accept(this);
        geOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(geOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</GeOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(LtOp ltOp) {

        try {
            fileWriter.append("<LtOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ltOp.getLeft().accept(this);
        ltOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(ltOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</LtOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(LeOp leOp) {

        try {
            fileWriter.append("<LeOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        leOp.getLeft().accept(this);
        leOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(leOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</LeOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(EqOp eqOp) {

        try {
            fileWriter.append("<EqOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        eqOp.getLeft().accept(this);
        eqOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(eqOp.getCurrent_ref()!=null)
                fileWriter.append(eqOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</EqOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(NeOp neOp) {

        try {
            fileWriter.append("<NeOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        neOp.getLeft().accept(this);
        neOp.getRight().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(neOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</NeOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(UMinOp uMinOp) {

        try {
            fileWriter.append("<UMinusOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        uMinOp.getArg().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(uMinOp.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</UMinusOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(FunCall funCall) {

        try {
            fileWriter.append("<FunCallOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        funCall.getId().accept(this);

        for (Expr p : funCall.getParams())
            p.accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(funCall.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</FunCallOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(AssignStat assignStat) {

        try {
            fileWriter.append("<AssignStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Id id: assignStat.getL1())
            id.accept(this);

        for (Expr p : assignStat.getL2())
            p.accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(assignStat.getCurrent_ref()!=null)
                fileWriter.append(assignStat.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</AssignStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(WriteStat writeStat) {


        try {
            fileWriter.append("<WriteStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Expr p: writeStat.getL())
            p.accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(writeStat.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</WriteStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(ReadStat readStat) {

        try {
            fileWriter.append("<ReadStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Id id : readStat.getL())
            id.accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(readStat.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</ReadStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(ForStat forStat) {

        try {
            fileWriter.append("<ForStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        forStat.getId().accept(this);
        forStat.getBody().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(forStat.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</ForStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(WhileStat whileStat) {


        try {
            fileWriter.append("<WhileStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        whileStat.getE().accept(this);
        whileStat.getBody().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(whileStat.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</WhileStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(IfStat ifStat) {

        try {
            fileWriter.append("<IfStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ifStat.getE().accept(this);
        ifStat.getBody().accept(this);

        if(ifStat.getEls()!=null)
            ifStat.getEls().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(ifStat.getCurrent_ref()!=null)
                fileWriter.append(ifStat.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</IfStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(ReturnStat returnStat) {

        try {
            fileWriter.append("<ReturnStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        returnStat.getE().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(returnStat.getCurrent_ref()!=null)
                fileWriter.append(returnStat.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</ReturnStat>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(ParDecl parDecl) {

        try {
            fileWriter.append("<ParDecl>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Id id : parDecl.getL())
            id.accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(parDecl.getCurrent_ref()!=null)
                fileWriter.append(parDecl.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</ParDecl>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(Body body) {

        try {
            fileWriter.append("<Body>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(VarDecl v: body.getL1())
            v.accept(this);

        for(Stat st: body.getL2())
            st.accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(body.getCurrent_ref()!=null)
                fileWriter.append(body.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</Body>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(FunDecl funDecl) {

        try {
            fileWriter.append("<FunDecl>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        funDecl.getId().accept(this);

        for(ParDecl decl: funDecl.getL())
            decl.accept(this);

        funDecl.getBody().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(funDecl.getCurrent_ref()!=null)
                fileWriter.append(funDecl.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</FunDecl>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(VarDecl varDecl) {

        try {
            fileWriter.append("<VarDecl>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(IdInitBase idInitBase : varDecl.getL())
            idInitBase.accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(varDecl.getCurrent_ref()!=null)
                fileWriter.append(varDecl.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</VarDecl>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(IdInitObbl idInitObbl) {

        try {
            fileWriter.append("<IdInitObbl>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        idInitObbl.getId().accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(idInitObbl.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</IdInitObbl>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(IdInitStmt idInitStmt) {

        try {
            fileWriter.append("<IdInitStmt>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        idInitStmt.getId().accept(this);

        try {
            fileWriter.append("<Type>\n");
            if(idInitStmt.getCurrent_ref()!=null)
                fileWriter.append(idInitStmt.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</IdInitStmt>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Void visit(Program program) {

        try {
            fileWriter.append("<Program>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Decl decl: program.getL())
            if(decl instanceof FunDecl)
                ((FunDecl)decl).accept(this);

            else ((VarDecl)decl).accept(this);

        try {
            fileWriter.append("<Type>\n");
            fileWriter.append(program.getTypeNode().name()).append("\n");
            fileWriter.append("</Type>\n");
            fileWriter.append("</Program>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
