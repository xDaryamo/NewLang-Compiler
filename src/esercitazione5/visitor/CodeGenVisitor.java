package esercitazione5.visitor;

import esercitazione5.node.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CodeGenVisitor implements Visitor<String>{

    public CodeGenVisitor(FileWriter file, ArrayList<String> stringTab) {
        this.file = file;
        this.stringTab = stringTab;
    }

    @Override
    public String visit(TrueC trueC) {
        return "1";
    }

    @Override
    public String visit(FalseC falseC) {
        return "0";
    }

    @Override
    public String visit(IntegerC integerC) {
        return Integer.valueOf(integerC.getConstant()).toString();
    }

    @Override
    public String visit(RealC realC) {
        return Float.valueOf(realC.getConstant()).toString();
    }

    @Override
    public String visit(CharC charC) {
        return "'" + Character.valueOf(charC.getConstant()).toString() +  "'";
    }

    @Override
    public String visit(StringC stringC) {
        return "\"" + stringC.getConstant() +  "\"";
    }

    @Override
    public String visit(Id id) {


        String identifier = stringTab.get(id.getIdentifier());
        TabEntry entry = id.getCurrent_ref().findEntry(id.getIdentifier());
        Variable v = (Variable) entry.getParams();
        boolean out = v.isByReference();

        if(out)
            return "*"+identifier;
        else
            return identifier;
    }

    @Override
    public String visit(AddOp addOp) {
        String left = addOp.getLeft().accept(this);
        String right = addOp.getRight().accept(this);

        return left + " + " + right;
    }

    @Override
    public String visit(SubOp subOp) {
        String left = subOp.getLeft().accept(this);
        String right = subOp.getRight().accept(this);

        return left + " - " + right;
    }

    @Override
    public String visit(TimesOp timesOp) {
        String left = timesOp.getLeft().accept(this);
        String right = timesOp.getRight().accept(this);

        return left + " * " + right;
    }

    @Override
    public String visit(DivOp divOp) {
        String left = divOp.getLeft().accept(this);
        String right = divOp.getRight().accept(this);

        return left + " / " + right;
    }

    @Override
    public String visit(PowOp powOp) {
        String left = powOp.getLeft().accept(this);
        String right = powOp.getRight().accept(this);

        return "pow(" + left + ", " + right + ")";
    }

    @Override
    public String visit(ConcatOp concatOp) {
        String left = concatOp.getLeft().accept(this);
        String right = concatOp.getRight().accept(this);

        return "string_concat(" + left + ", " + right + ")";
    }

    @Override
    public String visit(AndOp andOp) {
        String left = andOp.getLeft().accept(this);
        String right = andOp.getRight().accept(this);

        return left + " && " + right;
    }

    @Override
    public String visit(OrOp orOp) {
        String left = orOp.getLeft().accept(this);
        String right = orOp.getRight().accept(this);

        return left + " || " + right;
    }

    @Override
    public String visit(NotOp notOp) {
        String arg = notOp.getArg().accept(this);

        return "!" + arg;
    }

    @Override
    public String visit(GtOp gtOp) {
        String left = gtOp.getLeft().accept(this);
        String right = gtOp.getRight().accept(this);

        return left + " > " + right;
    }

    @Override
    public String visit(GeOp geOp) {
        String left = geOp.getLeft().accept(this);
        String right = geOp.getRight().accept(this);

        return left + " >= " + right;
    }

    @Override
    public String visit(LtOp ltOp) {
        String left = ltOp.getLeft().accept(this);
        String right = ltOp.getRight().accept(this);

        return left + " < " + right;
    }

    @Override
    public String visit(LeOp leOp) {
        String left = leOp.getLeft().accept(this);
        String right = leOp.getRight().accept(this);

        return left + " <= " + right;
    }

    @Override
    public String visit(EqOp eqOp) {
        String left = eqOp.getLeft().accept(this);
        String right = eqOp.getRight().accept(this);

        Type type =((Node) eqOp.getLeft()).getTypeNode();

        if (type.name().equalsIgnoreCase(Type.STRING.name()))
            return "strcmp(" + left + ", " + right + ") == 0";

        return left + " == " + right;
    }

    @Override
    public String visit(NeOp neOp) {
        String left = neOp.getLeft().accept(this);
        String right = neOp.getRight().accept(this);

        Type type =((Node) neOp.getLeft()).getTypeNode();

        if (type.name().equalsIgnoreCase(Type.STRING.name()))
            return "strcmp(" + left + ", " + right + ") != 0";

        return left + " != " + right;
    }

    @Override
    public String visit(UMinOp uMinOp) {
        String arg = uMinOp.getArg().accept(this);

        return "-(" + arg + ")";
    }

    @Override
    public String visit(FunCall funCall) {

        Id funId = funCall.getId();
        ArrayList<Expr> funParams = funCall.getParams();

        String funName = stringTab.get(funId.getIdentifier());

        funName = funName + "(";

        for(Expr e: funParams) {

            Id id = (Id) e;
            TabEntry tabEntry = id.getCurrent_ref().findEntry(id.getIdentifier());
            Variable variable = (Variable) tabEntry.getParams();
            Type type = variable.getType();

            String variableName = id.accept(this);

            if(variable.isByReference()){
                variableName = "&" + variableName;
            }

            funName = funName + getCType(type) + " " + variableName + ",";

        }

        if(funName.charAt(funName.length() - 1)==',')
            funName = funName.substring(0, funName.length() - 1);

        funName = funName + ");";

        return funName;
    }

    @Override
    public String visit(AssignStat assignStat) {

        String assign = null;

        for(int i = 0; i < assignStat.getL1().size(); i++){

            Id id = assignStat.getL1().get(i);
            Expr expr = assignStat.getL2().get(i);

            String idName = id.accept(this);
            String exprValue = expr.accept(this);

            assign = idName + " = " + exprValue + ",";

        }

        if(assign==null)
            return "";

        if(assign.charAt(assign.length() - 1)==',')
            assign = assign.substring(0, assign.length() - 1);

        assign = assign + ";";

        return assign;
    }

    @Override
    public String visit(WriteStat writeStat) {
        return null;
    }

    @Override
    public String visit(ReadStat readStat) {
        return null;
    }

    @Override
    public String visit(ForStat forStat) {
        return null;
    }

    @Override
    public String visit(WhileStat whileStat) {
        return null;
    }

    @Override
    public String visit(IfStat ifStat) {
        return null;
    }

    @Override
    public String visit(ReturnStat returnStat) {
        return null;
    }

    @Override
    public String visit(ParDecl parDecl) {
        return null;
    }

    @Override
    public String visit(Body body) {
        return null;
    }

    @Override
    public String visit(FunDecl funDecl) {
        return null;
    }

    @Override
    public String visit(VarDecl varDecl) {
        return null;
    }

    @Override
    public String visit(IdInitObbl idInitObbl) {
        return null;
    }

    @Override
    public String visit(IdInitStmt idInitStmt) {
        return null;
    }

    @Override
    public String visit(Program program) {
        return null;
    }

    private String getCType(Type t){

        String returnType = null;

        switch (t) {

            case STRING : returnType = "char*";

            case CHAR: returnType = "char";

            case FLOAT: returnType = "float";

            case INTEGER: returnType = "int";

            case VOID: returnType = "void";

        }

        return returnType;
    }

    private FileWriter file;
    private ArrayList<String> stringTab;
}
