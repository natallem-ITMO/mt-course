import ru.parser.antlr.*;
import ru.parser.visitor.PythonGrammarVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private final static List<String> file_names = List.of("greatest_common_divisor", "fibonacci");
    private final static int choice = 1;

    public static void main(String[] args) throws Exception {

        PythonGrammarLexer lexer = new PythonGrammarLexer(
                CharStreams.fromPath(
                        Path.of(
                                "B:\\Projects\\GitProjects\\mt-course\\lab3\\src\\main\\resources\\" + file_names.get(choice) + ".py"),
                        StandardCharsets.UTF_8));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PythonGrammarParser parser = new PythonGrammarParser(tokens);
        ParseTree tree = parser.program();
        PythonGrammarVisitor visitor = new PythonGrammarVisitor();
        StringBuilder result = visitor.visit(tree);
        BufferedWriter writer = new BufferedWriter
                (new FileWriter(
                        "B:\\Projects\\GitProjects\\mt-course\\lab3\\src\\main\\resources\\" + file_names.get(choice) + ".c"));
        writer.write(result.toString());
        writer.close();
    }
}