package esercitazione5.tester;
import esercitazione5.Lexer;
import esercitazione5.node.Program;
import esercitazione5.parser;
import esercitazione5.visitor.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) throws Exception {

        FileWriter fileWriterScope = new FileWriter(args[1]+"Scope.xml");
        FileWriter fileWriterType = new FileWriter(args[1]+"Type.xml");
        FileWriter fileWriterC = new FileWriter(args[1]+".c");

        String file = args[0];
        Lexer lexer = new Lexer(new FileReader(file));
        parser p = new parser(lexer);

        Program pr = (Program) p.parse().value;

        ScopingVisitor visitor = new ScopingVisitor((ArrayList<String>) lexer.identifiersTable);
        pr.accept(visitor);

        TypeCheckingVisitor typeCheckingVisitor = new TypeCheckingVisitor();
        pr.accept(typeCheckingVisitor);

        ScopingViewVisitor scopingViewVisitor =
                new ScopingViewVisitor(fileWriterScope, (ArrayList<String>) lexer.identifiersTable);

        pr.accept(scopingViewVisitor);

        TypeCheckingViewVisitor typeCheckingViewVisitor =
                new TypeCheckingViewVisitor(fileWriterType, (ArrayList<String>) lexer.identifiersTable);

        pr.accept(typeCheckingViewVisitor);

        CodeGenVisitor codeGenVisitor = new CodeGenVisitor((ArrayList<String>) lexer.identifiersTable);
        String cProgram = pr.accept(codeGenVisitor);
        fileWriterC.append(cProgram);

        fileWriterScope.close();
        fileWriterType.close();
        fileWriterC.close();
    }
}