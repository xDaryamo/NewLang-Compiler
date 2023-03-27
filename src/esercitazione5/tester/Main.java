package esercitazione5.tester;

import esercitazione5.Lexer;
import esercitazione5.node.Program;
import esercitazione5.parser;
import esercitazione5.visitor.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.err.println("Missing file argument");
            System.exit(1);
        }

        File fileC = new File(args[0]+".c");

        String c_out_d = "test_files/c_out";
        Path c_path = Path.of(c_out_d, String.valueOf(fileC));

        FileWriter fileWriterC = new FileWriter(c_path.toString());

        String file = args[0];
        Lexer lexer = new Lexer(new FileReader(file));

        parser p = new parser(lexer);

        try {
            Program pr = (Program) p.parse().value;

            ScopingVisitor visitor = new ScopingVisitor((ArrayList<String>) lexer.identifiersTable);

            pr.accept(visitor);

            TypeCheckingVisitor typeCheckingVisitor = new TypeCheckingVisitor((ArrayList<String>) lexer.identifiersTable);
            pr.accept(typeCheckingVisitor);

            CodeGenVisitor codeGenVisitor = new CodeGenVisitor((ArrayList<String>) lexer.identifiersTable);
            String cProgram = pr.accept(codeGenVisitor);
            fileWriterC.append(cProgram);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();

            fileWriterC.close();
            ;
            fileC.delete();

            System.exit(-1);
        }

        fileWriterC.close();
    }
}
