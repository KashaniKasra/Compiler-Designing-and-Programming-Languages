import main.ast.nodes.Converter;
import main.ast.nodes.node.CompilationUnit;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.symbolTable.SymbolTable;
import main.visitor.*;
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

        NameAnalyzer nameAnalyzer1 = new NameAnalyzer();
        nameAnalyzer1.visit(compilationUnit);

        NameAnalyzer.isFirstTime = false;

        if (!NameAnalyzer.name_analysis_logs.isEmpty())
            for (String msg : NameAnalyzer.name_analysis_logs)
                System.out.println(msg);
        else {
            AfterReturnRemover afterReturnRemover = new AfterReturnRemover();
            afterReturnRemover.visit(compilationUnit);

            NoSideEffectRemover noSideEffectRemover = new NoSideEffectRemover();
            noSideEffectRemover.visit(compilationUnit);

            while (true) {
                NameAnalyzer.functionCallExpressions.clear();
                NameAnalyzer.callMap.clear();
                UnusedRemover.functionCallExpressions.clear();
                UnusedRemover.callMap.clear();
                UnusedRemover.unused_logs.clear();

                NameAnalyzer nameAnalyzer = new NameAnalyzer();
                nameAnalyzer.visit(compilationUnit);

                UnusedRemover unusedRemover = new UnusedRemover();
                unusedRemover.visit(compilationUnit);

                if (UnusedRemover.unused_logs.isEmpty()) {
                    TestVisitor testVisitor = new TestVisitor();
                    testVisitor.visit(compilationUnit);

                    break;
                }
            }
        }

        SymbolTable.root.hashCode();

        System.out.println();
    }
}