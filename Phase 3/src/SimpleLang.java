import main.ast.nodes.Converter;
import main.ast.nodes.node.CompilationUnit;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.symbolTable.SymbolTable;
import main.typeErrors.TypeError;
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

        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(compilationUnit);

        if (!NameAnalyzer.name_analysis_logs.isEmpty())
            for (String msg : NameAnalyzer.name_analysis_logs)
                System.out.println(msg);
        else {
            VulnAnalysis vulnAnalysis = new VulnAnalysis();
            vulnAnalysis.visit(compilationUnit);

            for (String msg : VulnAnalysis.vuln_analysis_logs)
                System.out.println(msg);

            TypeChecker typeChecker = new TypeChecker();
            typeChecker.visit(compilationUnit);

            for (TypeError typeError : TypeChecker.type_errors)
                System.out.println(typeError.getErrorMessage());
        }

        SymbolTable.root.hashCode();

        System.out.println();
    }
}