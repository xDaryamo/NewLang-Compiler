package esercitazione5.tester;
import esercitazione5.Lexer;
import esercitazione5.node.Program;
import esercitazione5.parser;
import esercitazione5.visitor.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class TypeEnvironmentScopingTester {
    public static void main(String[] args) throws Exception {

        FileWriter fileWriter = new FileWriter("./tests/output.xml");

        String file = args[0];
        Lexer lexer = new Lexer(new FileReader(file));
        parser p = new parser(lexer);

        Program pr = (Program) p.parse().value;

        ScopingVisitor visitor = new ScopingVisitor((ArrayList<String>) lexer.identifiersTable);
        ScopingViewVisitor scopingViewVisitor = new ScopingViewVisitor(fileWriter, (ArrayList<String>) lexer.identifiersTable);

        pr.accept(visitor);
        pr.accept(scopingViewVisitor);
    }
}