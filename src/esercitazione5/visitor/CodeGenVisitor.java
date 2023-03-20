package esercitazione5.visitor;

import esercitazione5.node.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CodeGenVisitor implements Visitor<String>{

    public CodeGenVisitor(ArrayList<String> stringTab) {
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

        Type leftT = ((Node)concatOp.getLeft()).getTypeNode();
        Type rightT = ((Node)concatOp.getRight()).getTypeNode();
        String left = concatOp.getLeft().accept(this);
        String right = concatOp.getRight().accept(this);

        return "string_concat(" + objectToCString(left, leftT) + ", " + objectToCString(right, rightT) + ")";
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

        StringBuilder funName = new StringBuilder(stringTab.get(funId.getIdentifier()));

        funName.append("(");

        TabEntry funEntry = funCall.getCurrent_ref().findEntry(funCall.getId().getIdentifier());
        Signature signature = (Signature) funEntry.getParams();

        int index = 0;
        ArrayList<TabEntry> funArgs = signature.getArguments();

        for(int i = funCall.getParams().size() - 1; i >= 0 ; i--) {

            Id id = (Id) funCall.getParams().get(i);
            TabEntry tabEntry = id.getCurrent_ref().findEntry(id.getIdentifier());
            Variable variable = (Variable) tabEntry.getParams();

            TabEntry formalParam = funArgs.get(index);
            Variable formalParamSpecs = (Variable) formalParam.getParams();

            String variableName = id.accept(this);

            if(formalParamSpecs.isByReference() && !variable.isByReference()){
                variableName = "&" + variableName;
            }

            index++;

            funName.append(variableName).append(",");

        }

        if(funName.charAt(funName.length() - 1)==',')
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
            String exprValue = expr.accept(this);

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


        for(Expr e : writeStat.getL()) {
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

                String buffer = "char* buffer = (char*) malloc((1024*5)*sizeof(char) );\n";
                result.append(buffer);
                result.append("scanf(\"%s\", &buffer);\n");
                String alloc = varName + "= (char*) malloc( (strlen(buffer) + 1) )*sizeof(char) );\n";
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

        return "return " + returnStat.getE().accept(this) + ";";
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


        for (VarDecl varDecl : body.getL1()) {
            String declString = varDecl.accept(this);
            declarations.append(declString);
        }

        for (Stat stat : body.getL2()) {
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

        for (IdInitBase init : varDecl.getL()) {

           result.append(init.accept(this));
        }

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
        cProgram.append(buildHeader());

        for(Decl decl : program.getL())
            if(decl instanceof FunDecl d)
                cProgram.append(setPrototype(d));

        cProgram.append("\n");

        for(Decl decl : program.getL())
            if(decl instanceof VarDecl)
               cProgram.append( ((VarDecl)decl).accept(this) ).append("\n");

            else cProgram.append( ((FunDecl)decl).accept(this) ).append("\n");

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
            
            #define BUFFER_SIZE  (1024*4)
        
            """);

        //funzioni helper
        header.append("""
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
            funName = funName + "1";
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
