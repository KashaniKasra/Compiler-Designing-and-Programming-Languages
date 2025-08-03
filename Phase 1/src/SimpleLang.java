import main.ast.nodes.Converter;
import main.ast.nodes.node.CompilationUnit;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.TestVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        CharStream reader = CharStreams.fromFileName(args[0]);

        String input = reader.toString();
        Converter converter = new Converter();
        String codeC = converter.ConvertCPY(input);
        CharStream readerC = CharStreams.fromString(codeC);

        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(readerC);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);

        CompilationUnit compilationUnit = flParser.compilationUnit().compilationUnitRet;

        System.out.println();

        TestVisitor my_visitor = new TestVisitor();
        my_visitor.visit(compilationUnit);
    }
}