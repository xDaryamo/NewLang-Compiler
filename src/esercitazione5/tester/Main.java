package esercitazione5.tester;

import esercitazione5.Lexer;
import esercitazione5.node.Program;
import esercitazione5.parser;
import esercitazione5.visitor.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/*classe creata a parte per testare le funzionalità di CI*/
public class Main {

    public static void main(String[] args) throws Exception {

        /*check file argument*/
        if (args.length == 0) {
            System.err.println("Missing file argument");
            System.exit(1);
        }

        Path input_path = Paths.get(args[0]);

        String file = input_path.getFileName().toString();

        int dot = file.lastIndexOf(".");
        String c_file = file.substring(0, dot);

        String fileC = c_file + ".c";

        String c_out_d = "test_files/c_out";
        Path c_path = Path.of(c_out_d, fileC);

        FileWriter fileWriterC = new FileWriter(c_path.toString());

        Lexer lexer = new Lexer(new FileReader(input_path.toString()));

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

            fileWriterC.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }

    }
}
