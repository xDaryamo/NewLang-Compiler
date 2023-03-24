package esercitazione5.visitor;

import com.google.common.escape.ArrayBasedUnicodeEscaper;
import esercitazione5.node.*;

import java.util.ArrayList;

public class TypeSystem {

    public TypeSystem(ArrayList<String> stringTab) {
        this.stringTab = stringTab;
    }
    private Type funReturnType = null;

    private ArrayList<String> stringTab;

    public void setFunReturnType(Type funReturnType) {
        this.funReturnType = funReturnType;
    }

    public Type opFunCheck(String funOp, Node fun){

        if(funOp.equalsIgnoreCase("funDecl")) {

            FunDecl decl = (FunDecl) fun;
            if(funReturnType != Type.VOID) {
                ArrayList<Stat> stats = ((FunDecl) fun).getBody().getL2();
                boolean returnFlag = false;
                for(Stat st : stats) {
                    if (st instanceof ReturnStat) {
                        returnFlag = true;
                        break;
                    }
                }

                if(!returnFlag)
                    throw new RuntimeException("Missing return statement!");

            }

            return Type.NOTYPE;

        }

        if(funOp.equalsIgnoreCase("funCall")) {

            FunCall call = (FunCall) fun;

            TabEntry funEntry = call.getCurrent_ref().findEntry(call.getId().getIdentifier());
            Signature signature = (Signature) funEntry.getParams();
            ArrayList<TabEntry> args = signature.getArguments();

            if(args.size() != call.getParams().size())
                throw new RuntimeException("The number fo arguments of function " + stringTab.get(call.getId().getIdentifier())
                        + " does not match the number of formal parameters of function signature!");

            int bound = call.getParams().size() - 1;

            for(int i = 0; i < call.getParams().size(); i++) {

                Expr expr = call.getParams().get(i);
                TabEntry t = args.get(bound);

                Variable v = (Variable) t.getParams();
                if (v.isByReference() && !(expr instanceof Id))
                    throw new RuntimeException("The output parameter is not an identifier!");

                bound--;

            }

            int index = 0;

            for(TabEntry t : args){

                Variable v = (Variable) t.getParams();

                if(!Type.compatibility(v.getType(), ((Node)call.getParams().get(index)).getTypeNode()))
                    throw new RuntimeException("Type System Compatibility Error");

                index++;
            }

            return signature.getReturnType();

        }

        throw new RuntimeException("Type System Error");
    }

    public Type opConstructCheck(String construct, Node n){

        if(construct.equalsIgnoreCase("whileStat")){

            WhileStat stat = (WhileStat)n;

            if( ((Node)stat.getE()).getTypeNode().name().equalsIgnoreCase(String.valueOf(Type.BOOLEAN))
                    && stat.getBody().getTypeNode().name().equalsIgnoreCase(String.valueOf(Type.NOTYPE)))
                return Type.NOTYPE;

        }

        if(construct.equalsIgnoreCase("forStat")){

            ForStat stat = (ForStat)n;

            if(stat.getBody().getTypeNode().name().equalsIgnoreCase(String.valueOf(Type.NOTYPE)))
                return Type.NOTYPE;

        }

        if(construct.equalsIgnoreCase("ifStat")){

            IfStat stat = (IfStat)n;

            if(stat.getEls()==null)
                if(( ((Node)stat.getE()).getTypeNode().name().equalsIgnoreCase(String.valueOf(Type.BOOLEAN))
                        && stat.getBody().getTypeNode().name().equalsIgnoreCase(String.valueOf(Type.NOTYPE))))
                    return Type.NOTYPE;

            if(( ((Node)stat.getE()).getTypeNode().name().equalsIgnoreCase(String.valueOf(Type.BOOLEAN))
                    && stat.getBody().getTypeNode().name().equalsIgnoreCase(String.valueOf(Type.NOTYPE))
                    && stat.getEls().getTypeNode().name().equalsIgnoreCase(String.valueOf(Type.NOTYPE))))
                return Type.NOTYPE;

        }

        if(construct.equalsIgnoreCase("assignStat")){

            AssignStat stat = (AssignStat)n;

            for(Id id: stat.getL1())
                for(Expr expr: stat.getL2())
                    if(id.getTypeNode().name().equalsIgnoreCase(((Node)expr).getTypeNode().name()))
                        return Type.NOTYPE;

        }

        if(construct.equalsIgnoreCase("writeStat")){

            WriteStat stat = (WriteStat)n;

            for(Expr expr: stat.getL()) {
                if (expr instanceof FunDecl)
                    throw new RuntimeException("It is not possible to print a function");
                if ( ((Node)expr).getTypeNode().name().equalsIgnoreCase(Type.VAR.name())
                        || ((Node)expr).getTypeNode().name().equalsIgnoreCase(Type.VOID.name()) )
                    throw new RuntimeException("Type System Error");
            }

            return Type.NOTYPE;

        }

        if(construct.equalsIgnoreCase("readStat")){

            ReadStat stat = (ReadStat)n;

            for(Expr expr: stat.getL()) {
                if (expr instanceof FunDecl)
                    throw new RuntimeException("It is not possible to read a function");
                if ( ((Node)expr).getTypeNode().name().equalsIgnoreCase(Type.VAR.name())
                        || ((Node)expr).getTypeNode().name().equalsIgnoreCase(Type.VOID.name()) )
                    throw new RuntimeException("Type System Error");
            }

            return Type.NOTYPE;

        }

        if(construct.equalsIgnoreCase("returnStat")) {

            ReturnStat stat = (ReturnStat)n;

            if((stat.getE() == null) && !(funReturnType.name().equalsIgnoreCase(Type.VOID.name())))
                throw new RuntimeException("The return type of function isn't void!");

            if( ((Node)stat.getE()).getTypeNode().name().equalsIgnoreCase(Type.VAR.name()))
                throw new RuntimeException("Type System Error");

            if( !(Type.compatibility( ((Node)stat.getE() ).getTypeNode(), funReturnType)) )
                throw new RuntimeException("Type Mismatch Error");

            if( stat.getE() != null
                    && funReturnType.name().equalsIgnoreCase(Type.VOID.name()))
                throw new RuntimeException("Type System Error");

            return funReturnType;
        }

        if(construct.equalsIgnoreCase("letStat")){

            LetStat letStat = (LetStat) n;

            for(VarDecl varDecl: letStat.getVarDecls())
                if(! (varDecl.getTypeNode()==Type.NOTYPE)){
                    throw new RuntimeException("Type System Error");
                }

            if(!(letStat.getGoWhenStat1().getTypeNode()==Type.NOTYPE))
                throw new RuntimeException("Type System Error");

            if(!(letStat.getGoWhenStat2().getTypeNode()==Type.NOTYPE))
                throw new RuntimeException("Type System Error");

            if(!(letStat.getOtherwiseStat().getTypeNode()==Type.NOTYPE))
                throw new RuntimeException("Type System Error");

            return Type.NOTYPE;
        }

        if(construct.equalsIgnoreCase("goWhenStat")){

            GoWhenStat stat = (GoWhenStat) n;

            if(! ( ((Node)stat.getCondition()).getTypeNode() == Type.BOOLEAN ))
                throw new RuntimeException("Type System Error");

            for(Stat t: stat.getStats())
                if(! (((Node)t).getTypeNode() == Type.NOTYPE )){
                    throw new RuntimeException("Type System Error");
                }

            return Type.NOTYPE;

        }

        if(construct.equalsIgnoreCase("otherWiseStat")){

            OtherwiseStat stat = (OtherwiseStat) n;

            for(Stat t: stat.getStats())
                if(! (((Node)t).getTypeNode() == Type.NOTYPE )){
                    throw new RuntimeException("Type System Error");
                }

            return Type.NOTYPE;
        }

        throw new RuntimeException("Type System Error");
    }

    public Type opCheckMonoArgument(String op, Type x){

        if(op.equalsIgnoreCase("notOp")){
            if(x==Type.BOOLEAN)
                return x;
        }

        else if(op.equalsIgnoreCase("UMinOp")){
            if(x==Type.INTEGER || x==Type.FLOAT)
                return x;
        }

        throw new RuntimeException("Type Error");
    }

    public Type opCheckDoubleArguments(String op, Type x, Type y){

        if(op.equalsIgnoreCase("concatOp")){

            if((x!=Type.VAR && x!=Type.VOID) && (y!=Type.VAR && y!=Type.VOID)){
                return Type.STRING;
            }
        }

        else if(op.equalsIgnoreCase("andOp") || op.equalsIgnoreCase("orOp")){

            if(x==Type.BOOLEAN && y==Type.BOOLEAN)
                return Type.BOOLEAN;
        }

        else if(op.equalsIgnoreCase("eqOp") || op.equalsIgnoreCase("neOp")){

            if(x==Type.BOOLEAN && y==Type.BOOLEAN)
                return Type.BOOLEAN;

            if(x==Type.INTEGER && y==Type.FLOAT)
                return Type.BOOLEAN;

            if(x==Type.INTEGER && y==Type.INTEGER)
                return Type.BOOLEAN;

            if(x==Type.FLOAT && y==Type.FLOAT)
                return Type.BOOLEAN;

            if(x==Type.CHAR && y==Type.CHAR)
                return Type.BOOLEAN;

            if(x==Type.STRING && y==Type.STRING)
                return Type.BOOLEAN;

            if(x==Type.FLOAT && y==Type.INTEGER)
                return Type.BOOLEAN;

        }

        else if(op.equalsIgnoreCase("ltOp") || op.equalsIgnoreCase("leOp")
                || op.equalsIgnoreCase("gtOp") || op.equalsIgnoreCase("geOp")){

            if(x==Type.INTEGER && y==Type.INTEGER)
                return Type.BOOLEAN;


            if(x==Type.FLOAT && y==Type.FLOAT)
                return Type.BOOLEAN;

            if(x==Type.INTEGER && y==Type.FLOAT)
                return Type.BOOLEAN;

            if(x==Type.FLOAT && y==Type.INTEGER)
                return Type.BOOLEAN;

        }

        else if(op.equalsIgnoreCase("addOp") || op.equalsIgnoreCase("subOp")
                || op.equalsIgnoreCase("timesOp") || op.equalsIgnoreCase("powOp")
                || op.equalsIgnoreCase("divOp")){

            if(x==Type.FLOAT && y==Type.INTEGER)
                return Type.FLOAT;

            if(x==Type.FLOAT && y==Type.FLOAT)
                return Type.FLOAT;

            if(x==Type.INTEGER && y==Type.INTEGER)
                return Type.INTEGER;

            if(x==Type.INTEGER && y==Type.FLOAT)
                return Type.FLOAT;
        }

        throw new RuntimeException("Type Error");
    }

    public Type opParDeclCheck(String op, ParDecl parDecl) {

        if(op.equalsIgnoreCase("ParDecl")) {

            for(Id id : parDecl.getL())
            {
                if(id.getTypeNode()!=parDecl.getT())
                    throw new IllegalStateException("Type System Error");
            }

            return Type.NOTYPE;

        }

        throw new RuntimeException("Type System Error");
    }

    public Type opIdCheck(String op, Id id) {

        if(op.equalsIgnoreCase("Id")) {

            TabEntry entry = id.getCurrent_ref().findEntry(id.getIdentifier());

            if (entry == null)
                throw new RuntimeException("TypeChecking visitor tried to find the name: "
                        + stringTab.get(id.getIdentifier()) + " but there is no such declaration");

            Type returnedType = null;
            
            if(entry.getParams() instanceof Variable)
                returnedType = ((Variable) entry.getParams()).getType();
            
            if(entry.getParams() instanceof Signature)
                returnedType = ((Signature) entry.getParams()).getReturnType();

            return returnedType;
        }

        throw new RuntimeException("Type System Error");
    }

    public Type opIdInitObbl(String op, IdInitObbl idInitObbl) {

        if(op.equalsIgnoreCase("idInitObbl")) {

            Type type = idInitObbl.getId().getTypeNode();

            Type typeCompare = Type.VOID;

            if (idInitObbl.getCnst() instanceof String)
                typeCompare = Type.STRING;
            if (idInitObbl.getCnst() instanceof Character)
                typeCompare = Type.CHAR;
            if (idInitObbl.getCnst() instanceof Boolean)
                typeCompare = Type.BOOLEAN;
            if (idInitObbl.getCnst() instanceof Integer)
                typeCompare = Type.INTEGER;
            if (idInitObbl.getCnst() instanceof Float)
                typeCompare = Type.FLOAT;

            if (!Type.compatibility(type, typeCompare)) {
                throw new IllegalStateException("Type and identifier do not own a compatible typing!");

            }

            return type;

        }

        throw new IllegalStateException("Type System Error");
    }

}
