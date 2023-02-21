package esercitazione5.tester;
import esercitazione5.Lexer;
import esercitazione5.node.Program;
import esercitazione5.parser;
import esercitazione5.visitor.*;
import java.io.FileReader;
import java.io.FileWriter;

public class Tester {
    public static void main(String[] args) throws Exception {

        String file = args[0];
        Lexer lexer = new Lexer(new FileReader(file));
        parser p = new parser(lexer);
        FileWriter fileWriter = new FileWriter("tests/output.xml");

        Program pr = (Program) p.parse().value;

        SymTab symTab = new ListSymTab();
        symTab.addValues(lexer.identifiersTable);

        CodeGenVisitor visitor = new CodeGenVisitor(fileWriter, symTab);

        pr.accept(visitor);

        System.out.println("Debug parsing con with output in file \"tests/output.xml\"");
        fileWriter.close();
    }
}