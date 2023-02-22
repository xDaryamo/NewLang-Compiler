package esercitazione5.visitor;

import esercitazione5.node.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScopingViewVisitor implements Visitor{

    public ScopingViewVisitor(FileWriter fileWriter, ArrayList<String> stringTab){
        this.fileWriter = fileWriter;
        this.stringTab = stringTab;
    }

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

        try {
            fileWriter.append("<AddOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        addOp.getLeft().accept(this);
        addOp.getRight().accept(this);

        try {
            fileWriter.append("<TypeEnv>\n");
            fileWriter.append(addOp.getCurrent_ref().printTab()).append("\n");
            fileWriter.append("</TypeEnv>\n");
            fileWriter.append("</AddOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public <T> T visit(SubOp subOp) {

        try {
            fileWriter.append("<SubOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        subOp.getLeft().accept(this);
        subOp.getRight().accept(this);

        try {
            fileWriter.append("<TypeEnv>\n");
            fileWriter.append(subOp.getCurrent_ref().printTab()).append("\n");
            fileWriter.append("</TypeEnv>\n");
            fileWriter.append("</SubOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public <T> T visit(TimesOp timesOp) {

        try {
            fileWriter.append("<TimesOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        timesOp.getLeft().accept(this);
        timesOp.getRight().accept(this);

        try {
            fileWriter.append("<TypeEnv>\n");
            fileWriter.append(timesOp.getCurrent_ref().printTab()).append("\n");
            fileWriter.append("</TypeEnv>\n");
            fileWriter.append("</TimesOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public <T> T visit(DivOp divOp) {

        try {
            fileWriter.append("<DivOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        divOp.getLeft().accept(this);
        divOp.getRight().accept(this);

        try {
            fileWriter.append("<TypeEnv>\n");
            fileWriter.append(divOp.getCurrent_ref().printTab()).append("\n");
            fileWriter.append("</TypeEnv>\n");
            fileWriter.append("</TimesOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public <T> T visit(PowOp powOp) {

        try {
            fileWriter.append("<PowOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        powOp.getLeft().accept(this);
        powOp.getRight().accept(this);

        try {
            fileWriter.append("<TypeEnv>\n");
            fileWriter.append(powOp.getCurrent_ref().printTab()).append("\n");
            fileWriter.append("</TypeEnv>\n");
            fileWriter.append("</PowOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public <T> T visit(ConcatOp concatOp) {
        try {
            fileWriter.append("<ConcatOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        concatOp.getLeft().accept(this);
        concatOp.getRight().accept(this);

        try {
            fileWriter.append("<TypeEnv>\n");
            fileWriter.append(concatOp.getCurrent_ref().printTab()).append("\n");
            fileWriter.append("</TypeEnv>\n");
            fileWriter.append("</ConcatOp>\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    private FileWriter fileWriter;
    private ArrayList<String> stringTab;
}
