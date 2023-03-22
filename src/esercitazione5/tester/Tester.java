package esercitazione5.tester;
import esercitazione5.Lexer;
import esercitazione5.node.Program;
import esercitazione5.parser;
import esercitazione5.visitor.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) throws Exception {

        File fileScope = new File(args[1]+"Scope.xml");
        File fileType = new File(args[1]+"Type.xml");
        File fileC = new File(args[1]+".c");

        FileWriter fileWriterScope = new FileWriter(fileScope);
        FileWriter fileWriterType = new FileWriter(fileType);
        FileWriter fileWriterC = new FileWriter(fileC);

        String file = args[0];
        Lexer lexer = new Lexer(new FileReader(file));

        parser p = new parser(lexer);

        try {
            Program pr = (Program) p.parse().value;

            ScopingVisitor visitor = new ScopingVisitor((ArrayList<String>) lexer.identifiersTable);

            pr.accept(visitor);

            TypeCheckingVisitor typeCheckingVisitor = new TypeCheckingVisitor((ArrayList<String>) lexer.identifiersTable);
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            fileWriterScope.close();
            fileWriterType.close();
            fileWriterC.close();

            fileScope.delete();
            fileType.delete();
            fileC.delete();

            System.exit(-1);
        }

        fileWriterScope.close();
        fileWriterType.close();
        fileWriterC.close();
    }
}