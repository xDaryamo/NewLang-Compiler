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

        FileWriter fileWriterScope = new FileWriter("./tests/outputScope.xml");
        FileWriter fileWriterType = new FileWriter("./tests/outputType.xml");

        String file = args[0];
        Lexer lexer = new Lexer(new FileReader(file));
        parser p = new parser(lexer);

        Program pr = (Program) p.debug_parse().value;

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

        fileWriterScope.close();
        fileWriterType.close();
    }
}