package esercitazione5.visitor;

import esercitazione5.node.*;
import org.apache.tools.ant.taskdefs.condition.Or;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class CodeGenVisitor implements Visitor<String>{

    private StringBuilder globalsVarAssign;
    public CodeGenVisitor(ArrayList<String> stringTab) {
        this.stringTab = stringTab;
        globalsVarAssign = new StringBuilder();
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

        String left, right;

        if(addOp.getLeft() instanceof FunCall){

            left = addOp.getLeft().accept(this).substring(0, addOp.getLeft().accept(this).lastIndexOf(";"));
        }

        else left = addOp.getLeft().accept(this);

        if(addOp.getRight() instanceof FunCall){

            right = addOp.getRight().accept(this).substring(0, addOp.getRight().accept(this).lastIndexOf(";"));
        }

        else right = addOp.getRight().accept(this);

        return left + " + " + right;
    }

    @Override
    public String visit(SubOp subOp) {

        String left, right;

        if(subOp.getLeft() instanceof FunCall){

            left = subOp.getLeft().accept(this).substring(0, subOp.getLeft().accept(this).lastIndexOf(";"));
        }

        else left = subOp.getLeft().accept(this);

        if(subOp.getRight() instanceof FunCall){

            right = subOp.getRight().accept(this).substring(0, subOp.getRight().accept(this).lastIndexOf(";"));
        }

        else right = subOp.getRight().accept(this);

        return left + " - " + right;
    }

    @Override
    public String visit(TimesOp timesOp) {

        String left, right;

        if(timesOp.getLeft() instanceof FunCall){

            left = timesOp.getLeft().accept(this).substring(0, timesOp.getLeft().accept(this).lastIndexOf(";"));
        }

        else left = timesOp.getLeft().accept(this);

        if(timesOp.getRight() instanceof FunCall){

            right = timesOp.getRight().accept(this).substring(0, timesOp.getRight().accept(this).lastIndexOf(";"));
        }

        else right = timesOp.getRight().accept(this);

        return left + " * " + right;
    }

    @Override
    public String visit(DivOp divOp) {

        String left, right;

        if(divOp.getLeft() instanceof FunCall){

            left = divOp.getLeft().accept(this).substring(0, divOp.getLeft().accept(this).lastIndexOf(";"));
        }

        else left = divOp.getLeft().accept(this);

        if(divOp.getRight() instanceof FunCall){

            right = divOp.getRight().accept(this).substring(0, divOp.getRight().accept(this).lastIndexOf(";"));
        }

        else right = divOp.getRight().accept(this);

        return left + " / " + right;
    }

    @Override
    public String visit(PowOp powOp) {

        String left, right;

        if(powOp.getLeft() instanceof FunCall){

            left = powOp.getLeft().accept(this).substring(0, powOp.getLeft().accept(this).lastIndexOf(";"));
        }

        else left = powOp.getLeft().accept(this);

        if(powOp.getRight() instanceof FunCall){

            right = powOp.getRight().accept(this).substring(0, powOp.getRight().accept(this).lastIndexOf(";"));
        }

        else right = powOp.getRight().accept(this);

        return "pow(" + left + ", " + right + ")";
    }

    @Override
    public String visit(ConcatOp concatOp) {

        Type leftT = ((Node)concatOp.getLeft()).getTypeNode();
        Type rightT = ((Node)concatOp.getRight()).getTypeNode();
        String left = concatOp.getLeft().accept(this);
        String right = concatOp.getRight().accept(this);

        return "string_concat(" + objectToCString(left, leftT) + ", " + objectToCString(right, rightT) + ")";
    }

    @Override
    public String visit(AndOp andOp) {

        String left, right;

        if(andOp.getLeft() instanceof FunCall){

            left = andOp.getLeft().accept(this).substring(0, andOp.getLeft().accept(this).lastIndexOf(";"));
        }

        else left = andOp.getLeft().accept(this);

        if(andOp.getRight() instanceof FunCall){

            right = andOp.getRight().accept(this).substring(0, andOp.getRight().accept(this).lastIndexOf(";"));
        }

        else right = andOp.getRight().accept(this);

        return left + " && " + right;
    }

    @Override
    public String visit(OrOp orOp) {

        String left, right;

        if(orOp.getLeft() instanceof FunCall){

            left = orOp.getLeft().accept(this).substring(0, orOp.getLeft().accept(this).lastIndexOf(";"));
        }

        else left = orOp.getLeft().accept(this);

        if(orOp.getRight() instanceof FunCall){

            right = orOp.getRight().accept(this).substring(0, orOp.getRight().accept(this).lastIndexOf(";"));
        }

        else right = orOp.getRight().accept(this);

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

        StringBuilder funName = new StringBuilder(stringTab.get(funId.getIdentifier()));

        funName.append("(");

        TabEntry funEntry = funCall.getCurrent_ref().findEntry(funCall.getId().getIdentifier());
        Signature signature = (Signature) funEntry.getParams();

        int index = 0;
        ArrayList<TabEntry> funArgs = signature.getArguments();

        for(int i = funCall.getParams().size() - 1; i >= 0 ; i--) {

            /*check constants*/
            if(funCall.getParams().get(i) instanceof StringC stringC){
                funName.append("\"").append(stringC.getConstant()).append("\"");
            }

            else if(funCall.getParams().get(i) instanceof IntegerC integerC){
                funName.append(integerC.getConstant()).append(",");
            }

            else if(funCall.getParams().get(i) instanceof RealC realC){
                funName.append(realC.getConstant()).append(",");
            }

            else if(funCall.getParams().get(i) instanceof CharC charC){
                funName.append("'").append(charC.getConstant()).append("'").append(",");
            }

            else if(funCall.getParams().get(i) instanceof FalseC falseC){
                funName.append(falseC.getFalse()).append(",");
            }

            else if(funCall.getParams().get(i) instanceof TrueC trueC){
                funName.append(trueC.getTrue()).append(",");
            }

            else if(funCall.getParams().get(i) instanceof Id){

                Id id = (Id) funCall.getParams().get(i);
                TabEntry tabEntry = id.getCurrent_ref().findEntry(id.getIdentifier());
                Variable variable = (Variable) tabEntry.getParams();

                TabEntry formalParam = funArgs.get(index);
                Variable formalParamSpecs = (Variable) formalParam.getParams();

                String variableName = id.accept(this);

                if (formalParamSpecs.isByReference() && !variable.isByReference()) {
                    variableName = "&" + variableName;
                }

                funName.append(variableName).append(",");
            }

            else if(funCall.getParams().get(i) instanceof AndOp ||
                    funCall.getParams().get(i) instanceof OrOp ||
                    funCall.getParams().get(i) instanceof SubOp ||
                    funCall.getParams().get(i) instanceof AddOp ||
                    funCall.getParams().get(i) instanceof DivOp ||
                    funCall.getParams().get(i) instanceof TimesOp ||
                    funCall.getParams().get(i) instanceof PowOp ||
                    funCall.getParams().get(i) instanceof NotOp)
                funName.append( funCall.getParams().get(i).accept(this) );

            else funName.append( funCall.getParams().get(i).accept(this) );

            index++;

        }

        if(funName.charAt(funName.length() - 1)==',')
            funName = new StringBuilder(funName.substring(0, funName.length() - 1));

        if( (funName.charAt(funName.length() - 1) == ';'))
            funName = new StringBuilder(funName.substring(0, funName.length() - 1));

        funName.append(");");

        return funName.toString();
    }

    @Override
    public String visit(AssignStat assignStat) {

        String assign = null;

        for(int i = 0; i < assignStat.getL1().size(); i++){

            Id id = assignStat.getL1().get(i);
            Expr expr = assignStat.getL2().get(i);

            String idName = id.accept(this);
            String exprValue;

            if(expr instanceof FunCall) {
                int lastsemi = expr.accept(this).lastIndexOf(";");
                exprValue = expr.accept(this).substring(0, lastsemi);
            }

            else exprValue = expr.accept(this);

            assign = idName + " = " + exprValue + ",";

        }

        if(assign==null)
            return "";

        if(assign.charAt(assign.length() - 1)==',')
            assign = assign.substring(0, assign.length() - 1);

        if(!(assign.charAt(assign.length() - 1) == ';'))
            assign = assign + ";";

        return assign;
    }

    @Override
    public String visit(WriteStat writeStat) {

        String printArgs = "";
        String printString = "printf(\"";

        int index;

        for(index = writeStat.getL().size() - 1; index >= 0; index--) {

            Expr e = writeStat.getL().get(index);
            String expr = e.accept(this);
            Type type = ((Node) e).getTypeNode();

            if (e instanceof TrueC)
                expr = "true";
            else if (e instanceof FalseC)
                expr = "false";

            String stringSpecifier = getStringSpecifier(type);

            printString = printString + stringSpecifier;
            printArgs = printArgs + expr + ',';
        }

        printArgs = printArgs.substring(0, printArgs.length() - 1);

        if(writeStat.getLn()==1)
            printString = printString + "\\n";


        printString = printString + "\"," + printArgs + ");";

        return printString;

    }

    @Override
    public String visit(ReadStat readStat) {

        StringBuilder result = new StringBuilder();

        if(readStat.getS()!=null) {
            String message = readStat.getS();
            result.append("printf(\"").append(message).append("\");\n");
        }

        for(Id id: readStat.getL()) {

            Type type = id.getTypeNode();
            String varName = id.accept(this);

            if(type.name().equalsIgnoreCase(Type.STRING.name())) {

                String buffer = "buffer = (char*) malloc((1024*5)*sizeof(char) );\n";
                result.append(buffer);
                result.append("scanf(\"%s\", buffer);\n");
                String alloc = varName + "= (char*) malloc( (strlen(buffer) + 1) *sizeof(char) );\n";
                alloc = alloc + "strcpy(" + varName + ",buffer);\n free(buffer);\n";
                result.append(alloc);
            }

            if(type.name().equalsIgnoreCase(Type.BOOLEAN.name())
                || type.name().equalsIgnoreCase(Type.INTEGER.name())) {
                result.append("scanf(\"%d\", ").append("&").append(varName).append(");");
            }

            if(type.name().equalsIgnoreCase(Type.FLOAT.name())) {
                result.append("scanf(\"%f\", ").append("&").append(varName).append(");");
            }

            if(type.name().equalsIgnoreCase(Type.CHAR.name())) {
                result.append("scanf(\"%c\", ").append("&").append(varName).append(");");
            }

        }

        return result.toString();
    }

    @Override
    public String visit(ForStat forStat) {
        String body = forStat.getBody().accept(this);
        String index = forStat.getId().accept(this);
        Integer start = forStat.getC1();
        Integer end = forStat.getC2();

        String indexUpdate = stringTab.get(forStat.getId().getIdentifier());
        String condition= index;
        if (start <= end) {
            indexUpdate += "++";
            condition+= "<=" + end;
        } else {
            indexUpdate += "--";
            condition+= ">=" + end;
        }
        return "for(int " + index + "=" + start + ";" + condition + ";" + indexUpdate + "){\n" + body + "\n}\n";
    }

    @Override
    public String visit(WhileStat whileStat) {
        String condition = whileStat.getE().accept(this);
        String body = whileStat.getBody().accept(this);

        return "while(" + condition + "){\n" + body + "\n}\n";
    }

    @Override
    public String visit(IfStat ifStat) {

        String condition = ifStat.getE().accept(this);
        String body = ifStat.getBody().accept(this);

        if(ifStat.getEls()!=null) {
            String elseBody = ifStat.getEls().accept(this);
            return "if(" + condition + "){\n" + body + "}\n" + "else{" + elseBody + "}\n";
        }

        return "if(" + condition + "){\n" + body + "}\n";
    }

    @Override
    public String visit(ReturnStat returnStat) {

        if (returnStat.getE() == null)
            return "return;";

        if(returnStat.getE() instanceof FunCall){

            String returnSt = returnStat.getE().accept(this).substring(0, returnStat.getE().accept(this).lastIndexOf(";"));
            return returnSt;
        }

        return "return " + returnStat.getE().accept(this) +";";
    }

    @Override
    public String visit(ParDecl parDecl) {

        StringBuilder params = new StringBuilder();

        for(int i = 0; i < parDecl.getL().size(); i++)
        {
            Id id = parDecl.getL().get(i);
            TabEntry entry = id.getCurrent_ref().findEntry(id.getIdentifier());
            Variable variable = (Variable) entry.getParams();

            String varName = stringTab.get(id.getIdentifier());
            String type = getCType(variable.getType());

            if(variable.isByReference())
                type = type + "*";

            params.append(type).append(" ").append(varName).append(",");

        }

        return params.toString();
    }

    @Override
    public String visit(Body body) {

        StringBuilder declarations = new StringBuilder();

        StringBuilder statements = new StringBuilder();


        int index;

        for (index = body.getL1().size() -1; index >=0; index--) {
            VarDecl varDecl = body.getL1().get(index);
            String[] temp = varDecl.accept(this).split("@");

            declarations.append(temp[0]);
            if(temp.length>1)
                statements.append(temp[1]);

        }

        for (index = body.getL2().size() -1; index >=0; index--) {
            Stat stat = body.getL2().get(index);
            String stmtString = stat.accept(this);
            statements.append(stmtString).append("\n");
        }

        return declarations + "\n" + statements + "\n";
    }

    @Override
    public String visit(FunDecl funDecl) {

        StringBuilder result = new StringBuilder();
        TabEntry funEntry = funDecl.getCurrent_ref().findEntry(funDecl.getId().getIdentifier());
        Signature funSignature = (Signature) funEntry.getParams();

        //main function case
        if(funDecl.isMain()) {


            result.append("""
                void main(int argc, char *argv[]) 
                {
                    
                """);
            int index = 1;

            //
            StringBuilder funParams = new StringBuilder();

            for(ParDecl p: funDecl.getL()) {
                Type type = p.getT();

                for(Id id: p.getL()) {
                    funParams.append(stringToCType("argv["+index+"]", type)+",");
                    index++;
                }
            }
            if (funDecl.getL().size()!=0)
                funParams = new StringBuilder(funParams.substring(0, funParams.length() - 1));


            result.append("if(argc<"+index+")\n");
            result.append("""
                {
                    printf("missing argument\\n");
                    exit(-1);
                }
                
                """);
            result.append(globalsVarAssign).append("\n");

            String funNewLangName = stringTab.get(funDecl.getId().getIdentifier());
            result.append(funNewLangName).append("(").append(funParams).append(");\n").append("}\n\n");

        }

        String funType = getCType(funSignature.getReturnType());
        result.append(funType).append(" ");

        String funName = stringTab.get(funDecl.getId().getIdentifier());
        result.append(funName).append("(");

        StringBuilder funParams = new StringBuilder();
        funParams.append(" ");

        for(ParDecl p: funDecl.getL()) {

            String par = p.accept(this);
            funParams.append(par);
        }

        funParams = new StringBuilder(funParams.substring(0, funParams.length() - 1));

        funParams.append("){\n");

        result.append(funParams);

        String body = funDecl.getBody().accept(this);
        result.append(body).append("}\n");

        return result.toString();
    }

    @Override
    public String visit(VarDecl varDecl) {

        StringBuilder result = new StringBuilder();
        StringBuilder varDeclarations = new StringBuilder();
        StringBuilder varAssign = new StringBuilder();

        int index;
        for (index = 0; index < varDecl.getL().size(); index++) {
            IdInitBase init = varDecl.getL().get(index);
            String[] temp = init.accept(this).split(" ");

            if(init instanceof IdInitStmt && ((IdInitStmt)init).getExpr() != null)
                varDeclarations.append(temp[0]).append(" ").append(temp[1]).append(";").append("\n");
            else if(init instanceof IdInitObbl)
                varDeclarations.append(temp[0]).append(" ").append(temp[1]).append(";").append("\n");
            else
                varDeclarations.append(temp[0]).append(" ").append(temp[1]).append("\n");

            if (init instanceof IdInitStmt && temp.length >= 3 && !(((IdInitStmt) init).getExpr() instanceof FunCall)) {
                varAssign.append(temp[1]).append(" ").append(temp[2]).append(" ").append(temp[3]).append("\n");
            }

            if (init instanceof IdInitStmt && temp.length >= 3 && ((IdInitStmt) init).getExpr() instanceof FunCall) {
                temp[3] = temp[3].substring(0, temp[3].lastIndexOf(";"));
                varAssign.append(temp[1]).append(" ").append(temp[2]).append(" ").append(temp[3]).append("\n");
            }

            if(temp.length >= 3 && init instanceof IdInitObbl){
                varAssign.append(temp[1]).append(" ").append(temp[2]).append(" ").append(temp[3]).append("\n");
            }
        }

        result.append(varDeclarations);
        result.append("@");
        result.append(varAssign);

        return result.toString();
    }

    @Override
    public String visit(IdInitObbl idInitObbl) {

        String varName = idInitObbl.getId().accept(this);
        String val = objectToCType(idInitObbl.getCnst());

        return getCType(idInitObbl.getId().getTypeNode()) + " " + varName + " = " + val + ";\n";
    }
    @Override
    public String visit(IdInitStmt idInitStmt) {

        String varName = idInitStmt.getId().accept(this);
        String expr;

        if(idInitStmt.getExpr()!=null)
            expr = " = " + idInitStmt.getExpr().accept(this);
        else expr = "";


        return getCType(idInitStmt.getId().getTypeNode()) + " " + varName + expr + ";\n";
    }

    @Override
    public String visit(Program program) {

        StringBuilder cProgram = new StringBuilder();
        StringBuilder varDeclarations = new StringBuilder();
        StringBuilder varAssign = new StringBuilder();
        cProgram.append(buildHeader());

        for(Decl decl : program.getL())
            if(decl instanceof FunDecl d)
                cProgram.append(setPrototype(d));

        cProgram.append("\n");

        for(Decl decl : program.getL())
            if(decl instanceof VarDecl){
                String[] temp = ((VarDecl)decl).accept(this).split("@");
                varDeclarations.append(temp[0]).append("\n");
                if(temp.length>1)
                    varAssign.append(temp[1]).append("\n");
            }

        cProgram.append(varDeclarations);

        globalsVarAssign.append(varAssign);

        for(Decl decl : program.getL())
            if(decl instanceof FunDecl)
                cProgram.append( ((FunDecl)decl).accept(this) ).append("\n");

        return cProgram.toString();
    }



    //metodi privati utility
    private String getStringSpecifier(Type t) {

        switch (t) {
            case INTEGER:
                return "%d";
            case FLOAT:
                return "%f";
            case BOOLEAN, STRING:
                return "%s";
            case CHAR:
                return "%c";
            default:
                return "";
        }
    }

    private String objectToCType(Object cnst) {

        String returnExpr = null;

        if(cnst instanceof String s) {
            returnExpr = "\"" + s + "\"";
        }

        if(cnst instanceof Float f)
            returnExpr = f.toString();

        if(cnst instanceof Integer i)
            returnExpr = i.toString();

        if(cnst instanceof Character c)
            returnExpr = c.toString();

        if(cnst instanceof Boolean b) {

            if(b)
                returnExpr = "1";

            else returnExpr = "0";
        }

        return returnExpr;
    }

    private String getCType(Type t){


        switch (t) {

            case STRING : return "char*";

            case CHAR: return "char";

            case FLOAT: return "float";

            case INTEGER, BOOLEAN: return "int";

            case VOID: return "void";

            default: return "";

        }

    }

    private String objectToCString(String expression, Type type) {
        switch (type) {
            case INTEGER: return "int2str(" + expression + ")";
            case CHAR: return "char2str(" + expression +  ")";
            case FLOAT: return "float2str(" + expression +  ")";
            case BOOLEAN: return "bool2str(" + expression +  ")";
            case STRING: return expression;
            default: return "";

        }

    }

    private String stringToCType(String expression, Type type){
        switch (type) {
            case INTEGER: return "atoi(" + expression + ")";
            case CHAR: return expression+"[0]";
            case FLOAT: return "atof(" + expression +  ")";
            case BOOLEAN:
                if(expression.equals("true"))
                    return "atoi(1)";
                else
                    return "atoi(0)";
            case STRING: return expression;
            default: return "";

        }
    }

    private String buildHeader() {

        StringBuilder header = new StringBuilder();


        header.append("""
            #include <stdio.h>
            #include <stdlib.h>
            #include <string.h>
            #include <math.h>
            
            #define BUFFER_SIZE  1024*4
        
            """);

        //funzioni helper
        header.append("""
            
            char* buffer;
            
            char* string_concat(char* s1, char* s2)
            {
                char* ns = malloc(strlen(s1) + strlen(s2) + 1);
                strcpy(ns, s1);
                strcat(ns, s2);
                return ns;
            }
            
            """);

        header.append("""
            char* int2str(int n)
            {
                char buffer[BUFFER_SIZE];
                int len = sprintf(buffer,"%d",n);
                char *ns = malloc(len + 1);
                sprintf(ns,"%d",n);
                return ns;
            }
                
            """);


        header.append("""
            char* char2str(char c)
            {
                char *ns = malloc(2);
                sprintf(ns, "%c", c);
                return ns;
            }
            
            """);

        header.append("""
            char* float2str(float f)
            {
                char buffer[BUFFER_SIZE];
                int len = sprintf(buffer,"%f", f);
                char *ns = malloc(len + 1);
                sprintf(ns, "%f", f);
                return ns;
            }
            
        """);

        header.append("""
            char* bool2str(int b)
            {
                char* ns = NULL;
                if(b)
                {
                    ns = malloc(5);
                    strcpy(ns, "true");
                }
                else
                {
                    ns = malloc(6);
                    strcpy(ns, "false");
                }
                return ns;
            }
            
            """);




        return header.toString();
    }



    private String setPrototype(FunDecl funDecl){

        StringBuilder result = new StringBuilder();

        TabEntry funEntry = funDecl.getCurrent_ref().findEntry(funDecl.getId().getIdentifier());
        Signature funSignature = (Signature) funEntry.getParams();

        String funType = getCType(funSignature.getReturnType());
        result.append(funType).append(" ");

        String funName = stringTab.get(funDecl.getId().getIdentifier());


        if(!funDecl.isMain() && funName.equals("main")) {
            Random rand = new Random();
            do {
                funName = funName + rand.nextInt(100);
            }while (stringTab.get(funDecl.getId().getIdentifier()).equals(funName));

            stringTab.set(funDecl.getId().getIdentifier(), funName);
        }

        result.append(funName).append("(");

        StringBuilder funParams = new StringBuilder();

        for(ParDecl p: funDecl.getL()) {

            String par = p.accept(this);
            funParams.append(par);
        }

        if(funDecl.getL().size()!=0)
            funParams = new StringBuilder(funParams.substring(0, funParams.length() - 1));

        funParams.append(");\n");

        result.append(funParams);

        return result.toString();
    }



    private ArrayList<String> stringTab;
}
