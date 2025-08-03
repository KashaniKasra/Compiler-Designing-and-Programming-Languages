// Generated from C:/Users/Asus/Desktop/University/term 6/Compiler Design and Programming Languages/Final project/Phase1/phase-1-ce-KashaniKasra/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import main.ast.nodes.expr.*;
    import main.ast.nodes.expr.operator.*;
    import main.ast.nodes.expr.primitives.*;
    import main.ast.nodes.expr.primitives.constants.*;
    import main.ast.nodes.node.*;
    import main.ast.nodes.node.design.*;
    import main.ast.nodes.node.direct_abstract_declarator.*;
    import main.ast.nodes.node.direct_declarator.*;
    import main.ast.nodes.node.initial.*;
    import main.ast.nodes.node.type.*;
    import main.ast.nodes.stmt.*;
    import main.ast.nodes.stmt.iteration.*;
    import main.ast.nodes.stmt.jump.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Break=1, Char=2, Const=3, Continue=4, Do=5, Double=6, Else=7, Float=8, 
		For=9, If=10, Int=11, Long=12, Return=13, Short=14, Signed=15, Sizeof=16, 
		Switch=17, Typedef=18, Unsigned=19, Void=20, While=21, Bool=22, LeftParen=23, 
		RightParen=24, LeftBracket=25, RightBracket=26, LeftBrace=27, RightBrace=28, 
		Less=29, LessEqual=30, Greater=31, GreaterEqual=32, LeftShift=33, RightShift=34, 
		Plus=35, PlusPlus=36, Minus=37, MinusMinus=38, Star=39, Div=40, Mod=41, 
		And=42, Or=43, AndAnd=44, OrOr=45, Xor=46, Not=47, Tilde=48, Question=49, 
		Colon=50, Semi=51, Comma=52, Assign=53, StarAssign=54, DivAssign=55, ModAssign=56, 
		PlusAssign=57, MinusAssign=58, LeftShiftAssign=59, RightShiftAssign=60, 
		AndAssign=61, XorAssign=62, OrAssign=63, Equal=64, NotEqual=65, Arrow=66, 
		Dot=67, Identifier=68, Constant=69, DigitSequence=70, StringLiteral=71, 
		MultiLineMacro=72, Directive=73, Whitespace=74, Newline=75, BlockComment=76, 
		LineComment=77;
	public static final int
		RULE_compilationUnit = 0, RULE_translationUnit = 1, RULE_externalDeclaration = 2, 
		RULE_functionDefinition = 3, RULE_declarationList = 4, RULE_expression = 5, 
		RULE_argumentExpressionList = 6, RULE_unaryOperator = 7, RULE_castExpression = 8, 
		RULE_assignmentOperator = 9, RULE_declaration = 10, RULE_declarationSpecifiers = 11, 
		RULE_declarationSpecifier = 12, RULE_initDeclaratorList = 13, RULE_initDeclarator = 14, 
		RULE_typeSpecifier = 15, RULE_specifierQualifierList = 16, RULE_declarator = 17, 
		RULE_directDeclarator = 18, RULE_pointer = 19, RULE_parameterList = 20, 
		RULE_parameterDeclaration = 21, RULE_identifierList = 22, RULE_typeName = 23, 
		RULE_abstractDeclarator = 24, RULE_directAbstractDeclarator = 25, RULE_initializer = 26, 
		RULE_initializerList = 27, RULE_designation = 28, RULE_designator = 29, 
		RULE_statement = 30, RULE_compoundStatement = 31, RULE_blockItem = 32, 
		RULE_expressionStatement = 33, RULE_selectionStatement = 34, RULE_iterationStatement = 35, 
		RULE_forCondition = 36, RULE_forDeclaration = 37, RULE_forExpression = 38, 
		RULE_jumpStatement = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "translationUnit", "externalDeclaration", "functionDefinition", 
			"declarationList", "expression", "argumentExpressionList", "unaryOperator", 
			"castExpression", "assignmentOperator", "declaration", "declarationSpecifiers", 
			"declarationSpecifier", "initDeclaratorList", "initDeclarator", "typeSpecifier", 
			"specifierQualifierList", "declarator", "directDeclarator", "pointer", 
			"parameterList", "parameterDeclaration", "identifierList", "typeName", 
			"abstractDeclarator", "directAbstractDeclarator", "initializer", "initializerList", 
			"designation", "designator", "statement", "compoundStatement", "blockItem", 
			"expressionStatement", "selectionStatement", "iterationStatement", "forCondition", 
			"forDeclaration", "forExpression", "jumpStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'break'", "'char'", "'const'", "'continue'", "'do'", "'double'", 
			"'else'", "'float'", "'for'", "'if'", "'int'", "'long'", "'return'", 
			"'short'", "'signed'", "'sizeof'", "'switch'", "'typedef'", "'unsigned'", 
			"'void'", "'while'", "'bool'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", 
			"'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", 
			"'?'", "':'", "';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", 
			"'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Break", "Char", "Const", "Continue", "Do", "Double", "Else", "Float", 
			"For", "If", "Int", "Long", "Return", "Short", "Signed", "Sizeof", "Switch", 
			"Typedef", "Unsigned", "Void", "While", "Bool", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", 
			"Minus", "MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", 
			"Xor", "Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", 
			"StarAssign", "DivAssign", "ModAssign", "PlusAssign", "MinusAssign", 
			"LeftShiftAssign", "RightShiftAssign", "AndAssign", "XorAssign", "OrAssign", 
			"Equal", "NotEqual", "Arrow", "Dot", "Identifier", "Constant", "DigitSequence", 
			"StringLiteral", "MultiLineMacro", "Directive", "Whitespace", "Newline", 
			"BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public CompilationUnit compilationUnitRet;
		public TranslationUnitContext t;
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier) {
				{
				setState(80);
				((CompilationUnitContext)_localctx).t = translationUnit();
				 ((CompilationUnitContext)_localctx).compilationUnitRet =  new CompilationUnit(((CompilationUnitContext)_localctx).t.translationUnitRet); 
				}
			}

			setState(85);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TranslationUnitContext extends ParserRuleContext {
		public TranslationUnit translationUnitRet;
		public ExternalDeclarationContext e;
		public List<ExternalDeclarationContext> externalDeclaration() {
			return getRuleContexts(ExternalDeclarationContext.class);
		}
		public ExternalDeclarationContext externalDeclaration(int i) {
			return getRuleContext(ExternalDeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTranslationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTranslationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((TranslationUnitContext)_localctx).translationUnitRet =  new TranslationUnit(); 
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
				((TranslationUnitContext)_localctx).e = externalDeclaration();
				 _localctx.translationUnitRet.addExternalDeclaration(((TranslationUnitContext)_localctx).e.externalDeclarationRet); 
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExternalDeclarationContext extends ParserRuleContext {
		public ExternalDeclaration externalDeclarationRet;
		public FunctionDefinitionContext f;
		public DeclarationContext d;
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExternalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExternalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExternalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_externalDeclaration);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				((ExternalDeclarationContext)_localctx).f = functionDefinition();
				 ((ExternalDeclarationContext)_localctx).externalDeclarationRet =  new ExternalDeclaration(((ExternalDeclarationContext)_localctx).f.functionDefinitionRet); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				((ExternalDeclarationContext)_localctx).d = declaration();
				 ((ExternalDeclarationContext)_localctx).externalDeclarationRet =  new ExternalDeclaration(((ExternalDeclarationContext)_localctx).d.declarationRet); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition functionDefinitionRet;
		public DeclarationSpecifiersContext ds;
		public DeclaratorContext d;
		public DeclarationListContext dl;
		public CompoundStatementContext c;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionDefinitionContext)_localctx).functionDefinitionRet =  new FunctionDefinition();
			        boolean isFirst = true; 
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(105);
				((FunctionDefinitionContext)_localctx).ds = declarationSpecifiers();
				 _localctx.functionDefinitionRet.setTypeSpecifiers(((FunctionDefinitionContext)_localctx).ds.declarationSpecifiersRet);
				                                  _localctx.functionDefinitionRet.setLine(((FunctionDefinitionContext)_localctx).ds.declarationSpecifiersRet.get(0).getLine());
				                                  isFirst = false; 
				}
				break;
			}
			setState(110);
			((FunctionDefinitionContext)_localctx).d = declarator();
			 _localctx.functionDefinitionRet.setDeclarator(((FunctionDefinitionContext)_localctx).d.declaratorRet);
			                     if (isFirst) _localctx.functionDefinitionRet.setLine(((FunctionDefinitionContext)_localctx).d.declaratorRet.getLine()); 
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
				{
				setState(112);
				((FunctionDefinitionContext)_localctx).dl = declarationList();
				 _localctx.functionDefinitionRet.setDeclarations(((FunctionDefinitionContext)_localctx).dl.declarationListRet); 
				}
			}

			setState(117);
			((FunctionDefinitionContext)_localctx).c = compoundStatement();
			 _localctx.functionDefinitionRet.setCompoundStatement(((FunctionDefinitionContext)_localctx).c.compoundStatementRet); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationListContext extends ParserRuleContext {
		public ArrayList<Declaration> declarationListRet;
		public DeclarationContext d;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationListContext)_localctx).declarationListRet =  new ArrayList<Declaration>(); 
			setState(124); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(121);
				((DeclarationListContext)_localctx).d = declaration();
				 _localctx.declarationListRet.add(((DeclarationListContext)_localctx).d.declarationRet); 
				}
				}
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public ExpressionContext e1;
		public ExpressionContext e;
		public Token id;
		public Token co;
		public Token s;
		public Token l;
		public TypeNameContext t;
		public InitializerListContext i;
		public UnaryOperatorContext u;
		public CastExpressionContext c;
		public ExpressionContext e2;
		public ExpressionContext e3;
		public AssignmentOperatorContext ass;
		public ArgumentExpressionListContext a;
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(SimpleLangParser.Constant, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(SimpleLangParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(SimpleLangParser.StringLiteral, i);
		}
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLangParser.Comma, 0); }
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public List<TerminalNode> Sizeof() { return getTokens(SimpleLangParser.Sizeof); }
		public TerminalNode Sizeof(int i) {
			return getToken(SimpleLangParser.Sizeof, i);
		}
		public List<TerminalNode> PlusPlus() { return getTokens(SimpleLangParser.PlusPlus); }
		public TerminalNode PlusPlus(int i) {
			return getToken(SimpleLangParser.PlusPlus, i);
		}
		public List<TerminalNode> MinusMinus() { return getTokens(SimpleLangParser.MinusMinus); }
		public TerminalNode MinusMinus(int i) {
			return getToken(SimpleLangParser.MinusMinus, i);
		}
		public TerminalNode Star() { return getToken(SimpleLangParser.Star, 0); }
		public TerminalNode Div() { return getToken(SimpleLangParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SimpleLangParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(SimpleLangParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(SimpleLangParser.RightShift, 0); }
		public TerminalNode Less() { return getToken(SimpleLangParser.Less, 0); }
		public TerminalNode Greater() { return getToken(SimpleLangParser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(SimpleLangParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(SimpleLangParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(SimpleLangParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(SimpleLangParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public TerminalNode Xor() { return getToken(SimpleLangParser.Xor, 0); }
		public TerminalNode Or() { return getToken(SimpleLangParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(SimpleLangParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(SimpleLangParser.OrOr, 0); }
		public TerminalNode Question() { return getToken(SimpleLangParser.Question, 0); }
		public TerminalNode Colon() { return getToken(SimpleLangParser.Colon, 0); }
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(129);
				((ExpressionContext)_localctx).id = match(Identifier);
				 ((ExpressionContext)_localctx).expressionRet =  new Identifier((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null));
				                    _localctx.expressionRet.setLine((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getLine():0)); 
				}
				break;
			case 2:
				{
				setState(131);
				((ExpressionContext)_localctx).co = match(Constant);
				 String text = ((ExpressionContext)_localctx).co.getText();
				                  if (text.startsWith("\'") && text.endsWith("\'")) {
				                      ((ExpressionContext)_localctx).expressionRet =  new CharacterConstant((((ExpressionContext)_localctx).co!=null?((ExpressionContext)_localctx).co.getText():null));
				                  } else if (text.contains(".") || text.contains("p") || text.contains("P") || ((text.contains("e") || text.contains("E")) && !text.contains("x") && !text.contains("X"))) {
				                      ((ExpressionContext)_localctx).expressionRet =  new FloatingConstant((((ExpressionContext)_localctx).co!=null?((ExpressionContext)_localctx).co.getText():null));
				                  } else {
				                      ((ExpressionContext)_localctx).expressionRet =  new IntegerConstant((((ExpressionContext)_localctx).co!=null?Integer.valueOf(((ExpressionContext)_localctx).co.getText()):0));
				                  }
				                  _localctx.expressionRet.setLine((((ExpressionContext)_localctx).co!=null?((ExpressionContext)_localctx).co.getLine():0)); 
				}
				break;
			case 3:
				{
				 ((ExpressionContext)_localctx).expressionRet =  new StringLiteral();
				      boolean isFirst = true; 
				setState(136); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(134);
						((ExpressionContext)_localctx).s = match(StringLiteral);
						 ((StringLiteral)_localctx.expressionRet).addName((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null));
						                         if (isFirst) {
						                            _localctx.expressionRet.setLine((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getLine():0));
						                            isFirst = false;
						                         } 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(138); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				setState(140);
				((ExpressionContext)_localctx).l = match(LeftParen);
				setState(141);
				((ExpressionContext)_localctx).e = expression(0);
				setState(142);
				match(RightParen);
				 ((ExpressionContext)_localctx).expressionRet =  new ParanthesisExpression(((ExpressionContext)_localctx).e.expressionRet);
				                                          _localctx.expressionRet.setLine((((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getLine():0)); 
				}
				break;
			case 5:
				{
				setState(145);
				((ExpressionContext)_localctx).l = match(LeftParen);
				setState(146);
				((ExpressionContext)_localctx).t = typeName();
				setState(147);
				match(RightParen);
				setState(148);
				match(LeftBrace);
				setState(149);
				((ExpressionContext)_localctx).i = initializerList();
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(150);
					match(Comma);
					}
				}

				setState(153);
				match(RightBrace);
				 ((ExpressionContext)_localctx).expressionRet =  new CompoundExpression(((ExpressionContext)_localctx).t.typeNameRet, ((ExpressionContext)_localctx).i.initializerListRet);
				                                                                                      _localctx.expressionRet.setLine((((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getLine():0)); 
				}
				break;
			case 6:
				{
				 ArrayList<UnaryOperator> ops = new ArrayList<UnaryOperator>();
				      Expression expr = null;
				      boolean isFirst = true;
				       int line = -1; 
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(163);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PlusPlus:
							{
							setState(157);
							((ExpressionContext)_localctx).l = match(PlusPlus);
							 ops.add(UnaryOperator.PRE_INC);
							                  if (isFirst) {
							                    line = (((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getLine():0);
							                    isFirst = false;
							                  } 
							}
							break;
						case MinusMinus:
							{
							setState(159);
							((ExpressionContext)_localctx).l = match(MinusMinus);
							 ops.add(UnaryOperator.PRE_DEC);
							                  if (isFirst) {
							                    line = (((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getLine():0);
							                    isFirst = false;
							                  } 
							}
							break;
						case Sizeof:
							{
							setState(161);
							((ExpressionContext)_localctx).l = match(Sizeof);
							 ops.add(UnaryOperator.SIZEOF);
							                  if (isFirst) {
							                    line = (((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getLine():0);
							                    isFirst = false;
							                  } 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(167);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(205);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(168);
					((ExpressionContext)_localctx).id = match(Identifier);
					 expr = new Identifier((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null));
					                      if (isFirst) expr.setLine((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getLine():0)); 
					}
					break;
				case 2:
					{
					setState(170);
					((ExpressionContext)_localctx).co = match(Constant);
					 String text = ((ExpressionContext)_localctx).co.getText();
					                      if (text.startsWith("\'") && text.endsWith("\'")) {
					                          expr = new CharacterConstant((((ExpressionContext)_localctx).co!=null?((ExpressionContext)_localctx).co.getText():null));
					                      } else if (text.contains(".") || text.contains("p") || text.contains("P") || ((text.contains("e") || text.contains("E")) && !text.contains("x") && !text.contains("X"))) {
					                          expr = new FloatingConstant((((ExpressionContext)_localctx).co!=null?((ExpressionContext)_localctx).co.getText():null));
					                      } else {
					                          expr = new IntegerConstant((((ExpressionContext)_localctx).co!=null?Integer.valueOf(((ExpressionContext)_localctx).co.getText()):0));
					                      }
					                      if (isFirst) expr.setLine((((ExpressionContext)_localctx).co!=null?((ExpressionContext)_localctx).co.getLine():0)); 
					}
					break;
				case 3:
					{
					 expr = new StringLiteral();
					           boolean isFirst2 = true; 
					setState(175); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(173);
							((ExpressionContext)_localctx).s = match(StringLiteral);
							 ((StringLiteral)expr).addName((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null));
							                              if (isFirst && isFirst2) {
							                                  expr.setLine((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getLine():0));
							                                  isFirst2 = false;
							                               } 
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(177); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				case 4:
					{
					setState(179);
					((ExpressionContext)_localctx).l = match(LeftParen);
					setState(180);
					((ExpressionContext)_localctx).e = expression(0);
					setState(181);
					match(RightParen);
					 expr = new ParanthesisExpression(((ExpressionContext)_localctx).e.expressionRet);
					                                             if (isFirst) expr.setLine((((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getLine():0)); 
					}
					break;
				case 5:
					{
					setState(184);
					((ExpressionContext)_localctx).l = match(LeftParen);
					setState(185);
					((ExpressionContext)_localctx).t = typeName();
					setState(186);
					match(RightParen);
					setState(187);
					match(LeftBrace);
					setState(188);
					((ExpressionContext)_localctx).i = initializerList();
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(189);
						match(Comma);
						}
					}

					setState(192);
					match(RightBrace);
					 expr = new CompoundExpression(((ExpressionContext)_localctx).t.typeNameRet, ((ExpressionContext)_localctx).i.initializerListRet);
					                                                                                          if (isFirst) expr.setLine((((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getLine():0)); 
					}
					break;
				case 6:
					{
					setState(195);
					((ExpressionContext)_localctx).u = unaryOperator();
					setState(196);
					((ExpressionContext)_localctx).c = castExpression();
					 expr = new UnaryCastExpression(((ExpressionContext)_localctx).u.unaryOperatorRet, ((ExpressionContext)_localctx).c.castExpressionRet);
					                                           if (isFirst) expr.setLine((((ExpressionContext)_localctx).u!=null?(((ExpressionContext)_localctx).u.start):null).getLine()); 
					}
					break;
				case 7:
					{
					setState(199);
					((ExpressionContext)_localctx).s = match(Sizeof);
					setState(200);
					match(LeftParen);
					setState(201);
					((ExpressionContext)_localctx).t = typeName();
					setState(202);
					match(RightParen);
					 expr = new SizeofTypeNameExpression(((ExpressionContext)_localctx).t.typeNameRet);
					                                                   if (isFirst) expr.setLine((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getLine():0)); 
					}
					break;
				}
				 if (!isFirst) expr.setLine(line);
				        ((ExpressionContext)_localctx).expressionRet =  new NestedUnaryExpression(ops, expr);
				        _localctx.expressionRet.setLine(expr.getLine()); 
				}
				break;
			case 7:
				{
				setState(208);
				((ExpressionContext)_localctx).l = match(LeftParen);
				setState(209);
				((ExpressionContext)_localctx).t = typeName();
				setState(210);
				match(RightParen);
				setState(211);
				((ExpressionContext)_localctx).c = castExpression();
				 ((ExpressionContext)_localctx).expressionRet =  new CastExpression(((ExpressionContext)_localctx).t.typeNameRet, ((ExpressionContext)_localctx).c.castExpressionRet);
				                                                         _localctx.expressionRet.setLine((((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getLine():0)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(336);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						 BinaryOperator op = null; 
						setState(224);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Star:
							{
							setState(218);
							match(Star);
							 op = BinaryOperator.STAR; 
							}
							break;
						case Div:
							{
							setState(220);
							match(Div);
							 op = BinaryOperator.DIV; 
							}
							break;
						case Mod:
							{
							setState(222);
							match(Mod);
							 op = BinaryOperator.MOD; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(226);
						((ExpressionContext)_localctx).e2 = expression(13);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, op, ((ExpressionContext)_localctx).e2.expressionRet);
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						 BinaryOperator op = null; 
						setState(235);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Plus:
							{
							setState(231);
							match(Plus);
							 op = BinaryOperator.PLUS; 
							}
							break;
						case Minus:
							{
							setState(233);
							match(Minus);
							 op = BinaryOperator.MINUS; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(237);
						((ExpressionContext)_localctx).e2 = expression(12);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, op, ((ExpressionContext)_localctx).e2.expressionRet);
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(240);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						 BinaryOperator op = null; 
						setState(246);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LeftShift:
							{
							setState(242);
							match(LeftShift);
							 op = BinaryOperator.LEFT_SHIFT; 
							}
							break;
						case RightShift:
							{
							setState(244);
							match(RightShift);
							 op = BinaryOperator.RIGHT_SHIFT; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(248);
						((ExpressionContext)_localctx).e2 = expression(11);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, op, ((ExpressionContext)_localctx).e2.expressionRet);
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(251);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						 BinaryOperator op = null; 
						setState(261);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Less:
							{
							setState(253);
							match(Less);
							 op = BinaryOperator.LESS; 
							}
							break;
						case Greater:
							{
							setState(255);
							match(Greater);
							 op = BinaryOperator.GREATER; 
							}
							break;
						case LessEqual:
							{
							setState(257);
							match(LessEqual);
							 op = BinaryOperator.LESS_EQUAL; 
							}
							break;
						case GreaterEqual:
							{
							setState(259);
							match(GreaterEqual);
							 op = BinaryOperator.GREATER_EQUAL; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(263);
						((ExpressionContext)_localctx).e2 = expression(10);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, op, ((ExpressionContext)_localctx).e2.expressionRet);
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(266);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						 BinaryOperator op = null; 
						setState(272);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Equal:
							{
							setState(268);
							match(Equal);
							 op = BinaryOperator.EQUAL; 
							}
							break;
						case NotEqual:
							{
							setState(270);
							match(NotEqual);
							 op = BinaryOperator.NOT_EQUAL; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(274);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, op, ((ExpressionContext)_localctx).e2.expressionRet);
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(278);
						match(And);
						setState(279);
						((ExpressionContext)_localctx).e2 = expression(8);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, BinaryOperator.AND, ((ExpressionContext)_localctx).e2.expressionRet);
						                                                _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(283);
						match(Xor);
						setState(284);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, BinaryOperator.XOR, ((ExpressionContext)_localctx).e2.expressionRet);
						                                                _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(287);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(288);
						match(Or);
						setState(289);
						((ExpressionContext)_localctx).e2 = expression(6);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, BinaryOperator.OR, ((ExpressionContext)_localctx).e2.expressionRet);
						                                               _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(293);
						match(AndAnd);
						setState(294);
						((ExpressionContext)_localctx).e2 = expression(5);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, BinaryOperator.AND_AND, ((ExpressionContext)_localctx).e2.expressionRet);
						                                                   _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(298);
						match(OrOr);
						setState(299);
						((ExpressionContext)_localctx).e2 = expression(4);
						 ((ExpressionContext)_localctx).expressionRet =  new BinaryExpression(((ExpressionContext)_localctx).e1.expressionRet, BinaryOperator.OR_OR, ((ExpressionContext)_localctx).e2.expressionRet);
						                                                 _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(302);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(303);
						match(Question);
						setState(304);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(305);
						match(Colon);
						setState(306);
						((ExpressionContext)_localctx).e3 = expression(3);
						 ((ExpressionContext)_localctx).expressionRet =  new QuestionColonExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet, ((ExpressionContext)_localctx).e3.expressionRet);
						                                                                         _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(310);
						((ExpressionContext)_localctx).ass = assignmentOperator();
						setState(311);
						((ExpressionContext)_localctx).e2 = expression(2);
						 ((ExpressionContext)_localctx).expressionRet =  new AssignmentExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).ass.assignmentOperatorRet, ((ExpressionContext)_localctx).e2.expressionRet);
						                                                                   _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(314);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(315);
						match(LeftBracket);
						setState(316);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(317);
						match(RightBracket);
						 ((ExpressionContext)_localctx).expressionRet =  new ArrayExpression(((ExpressionContext)_localctx).e1.expressionRet, ((ExpressionContext)_localctx).e2.expressionRet);
						                                                                     _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(320);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						 ((ExpressionContext)_localctx).expressionRet =  new FunctionCallExpression(((ExpressionContext)_localctx).e1.expressionRet); 
						setState(322);
						match(LeftParen);
						 _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e1.expressionRet.getLine()); 
						setState(327);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(324);
							((ExpressionContext)_localctx).a = argumentExpressionList();
							 ((FunctionCallExpression)_localctx.expressionRet).setParameters(((ExpressionContext)_localctx).a.argumentExpressionListRet); 
							}
						}

						setState(329);
						match(RightParen);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(331);
						match(PlusPlus);
						 ((ExpressionContext)_localctx).expressionRet =  new UnaryExpression(((ExpressionContext)_localctx).e.expressionRet, UnaryOperator.POST_INC);
						                                      _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e.expressionRet.getLine()); 
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(334);
						match(MinusMinus);
						 ((ExpressionContext)_localctx).expressionRet =  new UnaryExpression(((ExpressionContext)_localctx).e.expressionRet, UnaryOperator.POST_DEC);
						                                        _localctx.expressionRet.setLine(((ExpressionContext)_localctx).e.expressionRet.getLine()); 
						}
						break;
					}
					} 
				}
				setState(340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public ArrayList<Expression> argumentExpressionListRet;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitArgumentExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitArgumentExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentExpressionListContext)_localctx).argumentExpressionListRet =  new ArrayList<Expression>(); 
			setState(342);
			((ArgumentExpressionListContext)_localctx).e1 = expression(0);
			 _localctx.argumentExpressionListRet.add(((ArgumentExpressionListContext)_localctx).e1.expressionRet); 
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(344);
				match(Comma);
				setState(345);
				((ArgumentExpressionListContext)_localctx).e2 = expression(0);
				 _localctx.argumentExpressionListRet.add(((ArgumentExpressionListContext)_localctx).e2.expressionRet); 
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorContext extends ParserRuleContext {
		public UnaryOperator unaryOperatorRet;
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public TerminalNode Star() { return getToken(SimpleLangParser.Star, 0); }
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(SimpleLangParser.Tilde, 0); }
		public TerminalNode Not() { return getToken(SimpleLangParser.Not, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unaryOperator);
		try {
			setState(365);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				match(And);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.AND; 
				}
				break;
			case Star:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				match(Star);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.STAR; 
				}
				break;
			case Plus:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				match(Plus);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.PLUS; 
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 4);
				{
				setState(359);
				match(Minus);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.MINUS; 
				}
				break;
			case Tilde:
				enterOuterAlt(_localctx, 5);
				{
				setState(361);
				match(Tilde);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.TILDE; 
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 6);
				{
				setState(363);
				match(Not);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.NOT; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends ParserRuleContext {
		public Expression castExpressionRet;
		public Token l;
		public TypeNameContext t;
		public CastExpressionContext c;
		public ExpressionContext e;
		public Token d;
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(SimpleLangParser.DigitSequence, 0); }
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_castExpression);
		try {
			setState(378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				((CastExpressionContext)_localctx).l = match(LeftParen);
				setState(368);
				((CastExpressionContext)_localctx).t = typeName();
				setState(369);
				match(RightParen);
				setState(370);
				((CastExpressionContext)_localctx).c = castExpression();
				 ((CastExpressionContext)_localctx).castExpressionRet =  new CastExpression(((CastExpressionContext)_localctx).t.typeNameRet, ((CastExpressionContext)_localctx).c.castExpressionRet);
				                                                         _localctx.castExpressionRet.setLine((((CastExpressionContext)_localctx).l!=null?((CastExpressionContext)_localctx).l.getLine():0)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				((CastExpressionContext)_localctx).e = expression(0);
				 ((CastExpressionContext)_localctx).castExpressionRet =  ((CastExpressionContext)_localctx).e.expressionRet;
				                   _localctx.castExpressionRet.setLine(((CastExpressionContext)_localctx).e.expressionRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				((CastExpressionContext)_localctx).d = match(DigitSequence);
				 ((CastExpressionContext)_localctx).castExpressionRet =  new IntegerConstant((((CastExpressionContext)_localctx).d!=null?Integer.valueOf(((CastExpressionContext)_localctx).d.getText()):0));
				                      _localctx.castExpressionRet.setLine((((CastExpressionContext)_localctx).d!=null?((CastExpressionContext)_localctx).d.getLine():0)); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperator assignmentOperatorRet;
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(SimpleLangParser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(SimpleLangParser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(SimpleLangParser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(SimpleLangParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(SimpleLangParser.MinusAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(SimpleLangParser.LeftShiftAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(SimpleLangParser.RightShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(SimpleLangParser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(SimpleLangParser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(SimpleLangParser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentOperator);
		try {
			setState(402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				match(Assign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.ASSIGN; 
				}
				break;
			case StarAssign:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				match(StarAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.STAR_ASSIGN; 
				}
				break;
			case DivAssign:
				enterOuterAlt(_localctx, 3);
				{
				setState(384);
				match(DivAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.DIV_ASSIGN; 
				}
				break;
			case ModAssign:
				enterOuterAlt(_localctx, 4);
				{
				setState(386);
				match(ModAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.MOD_ASSIGN; 
				}
				break;
			case PlusAssign:
				enterOuterAlt(_localctx, 5);
				{
				setState(388);
				match(PlusAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.PLUS_ASSIGN; 
				}
				break;
			case MinusAssign:
				enterOuterAlt(_localctx, 6);
				{
				setState(390);
				match(MinusAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.MINUS_ASSIGN; 
				}
				break;
			case LeftShiftAssign:
				enterOuterAlt(_localctx, 7);
				{
				setState(392);
				match(LeftShiftAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.LEFT_SHIFT_ASSIGN; 
				}
				break;
			case RightShiftAssign:
				enterOuterAlt(_localctx, 8);
				{
				setState(394);
				match(RightShiftAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.RIGHT_SHIFT_ASSIGN; 
				}
				break;
			case AndAssign:
				enterOuterAlt(_localctx, 9);
				{
				setState(396);
				match(AndAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.AND_ASSIGN; 
				}
				break;
			case XorAssign:
				enterOuterAlt(_localctx, 10);
				{
				setState(398);
				match(XorAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.XOR_ASSIGN; 
				}
				break;
			case OrAssign:
				enterOuterAlt(_localctx, 11);
				{
				setState(400);
				match(OrAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.OR_ASSIGN; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Declaration declarationRet;
		public DeclarationSpecifiersContext d;
		public InitDeclaratorListContext i;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			((DeclarationContext)_localctx).d = declarationSpecifiers();
			 ((DeclarationContext)_localctx).declarationRet =  new Declaration(((DeclarationContext)_localctx).d.declarationSpecifiersRet);
			                                _localctx.declarationRet.setLine(((DeclarationContext)_localctx).d.declarationSpecifiersRet.get(0).getLine()); 
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(406);
				((DeclarationContext)_localctx).i = initDeclaratorList();
				 _localctx.declarationRet.setInitDeclarators(((DeclarationContext)_localctx).i.initDeclaratorListRet); 
				}
			}

			setState(411);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public ArrayList<DeclarationSpecifier> declarationSpecifiersRet;
		public DeclarationSpecifierContext d;
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationSpecifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationSpecifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationSpecifiersContext)_localctx).declarationSpecifiersRet =  new ArrayList<DeclarationSpecifier>(); 
			setState(417); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(414);
					((DeclarationSpecifiersContext)_localctx).d = declarationSpecifier();
					 _localctx.declarationSpecifiersRet.add(((DeclarationSpecifiersContext)_localctx).d.declarationSpecifierRet); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(419); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifierContext extends ParserRuleContext {
		public DeclarationSpecifier declarationSpecifierRet;
		public Token ty;
		public TypeSpecifierContext ts;
		public Token co;
		public TerminalNode Typedef() { return getToken(SimpleLangParser.Typedef, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Const() { return getToken(SimpleLangParser.Const, 0); }
		public DeclarationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifierContext declarationSpecifier() throws RecognitionException {
		DeclarationSpecifierContext _localctx = new DeclarationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declarationSpecifier);
		try {
			setState(428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Typedef:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				((DeclarationSpecifierContext)_localctx).ty = match(Typedef);
				 Typedefs t = new Typedefs();
				                ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier(t);
				                _localctx.declarationSpecifierRet.setLine((((DeclarationSpecifierContext)_localctx).ty!=null?((DeclarationSpecifierContext)_localctx).ty.getLine():0)); 
				}
				break;
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				((DeclarationSpecifierContext)_localctx).ts = typeSpecifier();
				 ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier(((DeclarationSpecifierContext)_localctx).ts.typeSpecifierRet);
				                         _localctx.declarationSpecifierRet.setLine(((DeclarationSpecifierContext)_localctx).ts.typeSpecifierRet.getLine()); 
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				((DeclarationSpecifierContext)_localctx).co = match(Const);
				 Consts c = new Consts();
				              ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier(c);
				              _localctx.declarationSpecifierRet.setLine((((DeclarationSpecifierContext)_localctx).co!=null?((DeclarationSpecifierContext)_localctx).co.getLine():0)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorListContext extends ParserRuleContext {
		public ArrayList<InitDeclarator> initDeclaratorListRet;
		public InitDeclaratorContext i1;
		public InitDeclaratorContext i2;
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InitDeclaratorListContext)_localctx).initDeclaratorListRet =  new ArrayList<InitDeclarator>(); 
			setState(431);
			((InitDeclaratorListContext)_localctx).i1 = initDeclarator();
			 _localctx.initDeclaratorListRet.add(((InitDeclaratorListContext)_localctx).i1.initDeclaratorRet); 
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(433);
				match(Comma);
				setState(434);
				((InitDeclaratorListContext)_localctx).i2 = initDeclarator();
				 _localctx.initDeclaratorListRet.add(((InitDeclaratorListContext)_localctx).i2.initDeclaratorRet); 
				}
				}
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorContext extends ParserRuleContext {
		public InitDeclarator initDeclaratorRet;
		public DeclaratorContext d;
		public InitializerContext i;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			((InitDeclaratorContext)_localctx).d = declarator();
			 ((InitDeclaratorContext)_localctx).initDeclaratorRet =  new InitDeclarator(((InitDeclaratorContext)_localctx).d.declaratorRet);
			                     _localctx.initDeclaratorRet.setLine(((InitDeclaratorContext)_localctx).d.declaratorRet.getLine()); 
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(444);
				match(Assign);
				setState(445);
				((InitDeclaratorContext)_localctx).i = initializer();
				 _localctx.initDeclaratorRet.setInitializer(((InitDeclaratorContext)_localctx).i.initializerRet); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public TypeSpecifier typeSpecifierRet;
		public Token v;
		public Token c;
		public Token s;
		public Token i;
		public Token l;
		public Token f;
		public Token d;
		public Token u;
		public Token b;
		public Token id;
		public TerminalNode Void() { return getToken(SimpleLangParser.Void, 0); }
		public TerminalNode Char() { return getToken(SimpleLangParser.Char, 0); }
		public TerminalNode Short() { return getToken(SimpleLangParser.Short, 0); }
		public TerminalNode Int() { return getToken(SimpleLangParser.Int, 0); }
		public TerminalNode Long() { return getToken(SimpleLangParser.Long, 0); }
		public TerminalNode Float() { return getToken(SimpleLangParser.Float, 0); }
		public TerminalNode Double() { return getToken(SimpleLangParser.Double, 0); }
		public TerminalNode Signed() { return getToken(SimpleLangParser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(SimpleLangParser.Unsigned, 0); }
		public TerminalNode Bool() { return getToken(SimpleLangParser.Bool, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeSpecifier);
		try {
			setState(472);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(450);
				((TypeSpecifierContext)_localctx).v = match(Void);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).v!=null?((TypeSpecifierContext)_localctx).v.getText():null));
				               _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).v!=null?((TypeSpecifierContext)_localctx).v.getLine():0)); 
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				((TypeSpecifierContext)_localctx).c = match(Char);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).c!=null?((TypeSpecifierContext)_localctx).c.getText():null));
				               _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).c!=null?((TypeSpecifierContext)_localctx).c.getLine():0)); 
				}
				break;
			case Short:
				enterOuterAlt(_localctx, 3);
				{
				setState(454);
				((TypeSpecifierContext)_localctx).s = match(Short);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).s!=null?((TypeSpecifierContext)_localctx).s.getText():null));
				                _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).s!=null?((TypeSpecifierContext)_localctx).s.getLine():0)); 
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 4);
				{
				setState(456);
				((TypeSpecifierContext)_localctx).i = match(Int);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).i!=null?((TypeSpecifierContext)_localctx).i.getText():null));
				               _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).i!=null?((TypeSpecifierContext)_localctx).i.getLine():0)); 
				}
				break;
			case Long:
				enterOuterAlt(_localctx, 5);
				{
				setState(458);
				((TypeSpecifierContext)_localctx).l = match(Long);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).l!=null?((TypeSpecifierContext)_localctx).l.getText():null));
				               _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).l!=null?((TypeSpecifierContext)_localctx).l.getLine():0)); 
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 6);
				{
				setState(460);
				((TypeSpecifierContext)_localctx).f = match(Float);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).f!=null?((TypeSpecifierContext)_localctx).f.getText():null));
				                _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).f!=null?((TypeSpecifierContext)_localctx).f.getLine():0)); 
				}
				break;
			case Double:
				enterOuterAlt(_localctx, 7);
				{
				setState(462);
				((TypeSpecifierContext)_localctx).d = match(Double);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).d!=null?((TypeSpecifierContext)_localctx).d.getText():null));
				                 _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).d!=null?((TypeSpecifierContext)_localctx).d.getLine():0)); 
				}
				break;
			case Signed:
				enterOuterAlt(_localctx, 8);
				{
				setState(464);
				((TypeSpecifierContext)_localctx).s = match(Signed);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).s!=null?((TypeSpecifierContext)_localctx).s.getText():null));
				                 _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).s!=null?((TypeSpecifierContext)_localctx).s.getLine():0)); 
				}
				break;
			case Unsigned:
				enterOuterAlt(_localctx, 9);
				{
				setState(466);
				((TypeSpecifierContext)_localctx).u = match(Unsigned);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).u!=null?((TypeSpecifierContext)_localctx).u.getText():null));
				                   _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).u!=null?((TypeSpecifierContext)_localctx).u.getLine():0)); 
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 10);
				{
				setState(468);
				((TypeSpecifierContext)_localctx).b = match(Bool);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).b!=null?((TypeSpecifierContext)_localctx).b.getText():null));
				               _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).b!=null?((TypeSpecifierContext)_localctx).b.getLine():0)); 
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 11);
				{
				setState(470);
				((TypeSpecifierContext)_localctx).id = match(Identifier);
				 ((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).id!=null?((TypeSpecifierContext)_localctx).id.getText():null));
				                      _localctx.typeSpecifierRet.setLine((((TypeSpecifierContext)_localctx).id!=null?((TypeSpecifierContext)_localctx).id.getLine():0)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public ArrayList<Type> specifierQualifierListRet;
		public TypeSpecifierContext t;
		public SpecifierQualifierListContext s;
		public TerminalNode Const() { return getToken(SimpleLangParser.Const, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSpecifierQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSpecifierQualifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSpecifierQualifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_specifierQualifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((SpecifierQualifierListContext)_localctx).specifierQualifierListRet =  new ArrayList<Type>(); 
			setState(480);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				{
				setState(475);
				((SpecifierQualifierListContext)_localctx).t = typeSpecifier();
				 _localctx.specifierQualifierListRet.add(((SpecifierQualifierListContext)_localctx).t.typeSpecifierRet); 
				}
				break;
			case Const:
				{
				setState(478);
				match(Const);
				 Consts c = new Consts();
				                 _localctx.specifierQualifierListRet.add(c); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5822796L) != 0) || _la==Identifier) {
				{
				setState(482);
				((SpecifierQualifierListContext)_localctx).s = specifierQualifierList();
				 for (Type t : ((SpecifierQualifierListContext)_localctx).s.specifierQualifierListRet) _localctx.specifierQualifierListRet.add(t); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public Declarator declaratorRet;
		public PointerContext p;
		public DirectDeclaratorContext d;
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclaratorContext)_localctx).declaratorRet =  new Declarator();
			        boolean isFirst = true; 
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(488);
				((DeclaratorContext)_localctx).p = pointer();
				 ((Declarator)_localctx.declaratorRet).setPointer(((DeclaratorContext)_localctx).p.pointerRet);
				                    _localctx.declaratorRet.setLine(((DeclaratorContext)_localctx).p.pointerRet.getLine());
				                    isFirst = false; 
				}
			}

			setState(493);
			((DeclaratorContext)_localctx).d = directDeclarator(0);
			 _localctx.declaratorRet.setDirectDeclarator(((DeclaratorContext)_localctx).d.directDeclaratorRet);
			                           if (isFirst) _localctx.declaratorRet.setLine(((DeclaratorContext)_localctx).d.directDeclaratorRet.getLine()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectDeclaratorContext extends ParserRuleContext {
		public DirectDeclarator directDeclaratorRet;
		public DirectDeclaratorContext dd1;
		public DirectDeclaratorContext dd2;
		public Token id;
		public Token l;
		public DeclaratorContext d;
		public ExpressionContext e;
		public ParameterListContext p;
		public IdentifierListContext i;
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDirectDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDirectDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDirectDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		return directDeclarator(0);
	}

	private DirectDeclaratorContext directDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, _parentState);
		DirectDeclaratorContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_directDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(497);
				((DirectDeclaratorContext)_localctx).id = match(Identifier);
				 ((DirectDeclaratorContext)_localctx).directDeclaratorRet =  new IdentifierDeclarator((((DirectDeclaratorContext)_localctx).id!=null?((DirectDeclaratorContext)_localctx).id.getText():null));
				                      _localctx.directDeclaratorRet.setLine((((DirectDeclaratorContext)_localctx).id!=null?((DirectDeclaratorContext)_localctx).id.getLine():0)); 
				}
				break;
			case LeftParen:
				{
				setState(499);
				((DirectDeclaratorContext)_localctx).l = match(LeftParen);
				setState(500);
				((DirectDeclaratorContext)_localctx).d = declarator();
				setState(501);
				match(RightParen);
				 ((DirectDeclaratorContext)_localctx).directDeclaratorRet =  new NestedDeclarator(((DirectDeclaratorContext)_localctx).d.declaratorRet);
				                                            _localctx.directDeclaratorRet.setLine((((DirectDeclaratorContext)_localctx).l!=null?((DirectDeclaratorContext)_localctx).l.getLine():0)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(531);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(529);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.dd1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(506);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						 ((DirectDeclaratorContext)_localctx).directDeclaratorRet =  new ArrayDeclarator(((DirectDeclaratorContext)_localctx).dd1.directDeclaratorRet);
						                                       _localctx.directDeclaratorRet.setLine(((DirectDeclaratorContext)_localctx).dd1.directDeclaratorRet.getLine()); 
						setState(508);
						match(LeftBracket);
						setState(512);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(509);
							((DirectDeclaratorContext)_localctx).e = expression(0);
							 ((ArrayDeclarator)_localctx.directDeclaratorRet).setExpression(((DirectDeclaratorContext)_localctx).e.expressionRet); 
							}
						}

						setState(514);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.dd2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(515);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						 ((DirectDeclaratorContext)_localctx).directDeclaratorRet =  new FunctionDeclarator(((DirectDeclaratorContext)_localctx).dd2.directDeclaratorRet);
						                                       _localctx.directDeclaratorRet.setLine(((DirectDeclaratorContext)_localctx).dd2.directDeclaratorRet.getLine()); 
						setState(517);
						match(LeftParen);
						setState(526);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
						case 1:
							{
							setState(518);
							((DirectDeclaratorContext)_localctx).p = parameterList();
							 ((FunctionDeclarator)_localctx.directDeclaratorRet).setParameters(((DirectDeclaratorContext)_localctx).p.parameterListRet); 
							}
							break;
						case 2:
							{
							setState(524);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Identifier) {
								{
								setState(521);
								((DirectDeclaratorContext)_localctx).i = identifierList();
								 ((FunctionDeclarator)_localctx.directDeclaratorRet).setIdentifiers(((DirectDeclaratorContext)_localctx).i.identifierListRet); 
								}
							}

							}
							break;
						}
						setState(528);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(533);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerContext extends ParserRuleContext {
		public Pointer pointerRet;
		public Token s;
		public Token c;
		public List<TerminalNode> Star() { return getTokens(SimpleLangParser.Star); }
		public TerminalNode Star(int i) {
			return getToken(SimpleLangParser.Star, i);
		}
		public List<TerminalNode> Const() { return getTokens(SimpleLangParser.Const); }
		public TerminalNode Const(int i) {
			return getToken(SimpleLangParser.Const, i);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((PointerContext)_localctx).pointerRet =  new Pointer();
			        boolean isFirst = true; 
			setState(545); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(535);
				((PointerContext)_localctx).s = match(Star);
				 _localctx.pointerRet.addPointer((((PointerContext)_localctx).s!=null?((PointerContext)_localctx).s.getText():null));
				                if (isFirst) {
				                    _localctx.pointerRet.setLine((((PointerContext)_localctx).s!=null?((PointerContext)_localctx).s.getLine():0));
				                    isFirst = false;
				                } 
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Const) {
					{
					setState(539); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(537);
						((PointerContext)_localctx).c = match(Const);
						 _localctx.pointerRet.addPointer((((PointerContext)_localctx).c!=null?((PointerContext)_localctx).c.getText():null)); 
						}
						}
						setState(541); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==Const );
					}
				}

				}
				}
				setState(547); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Star );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public ArrayList<ParameterDeclaration> parameterListRet;
		public ParameterDeclarationContext p1;
		public ParameterDeclarationContext p2;
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParameterListContext)_localctx).parameterListRet =  new ArrayList<ParameterDeclaration>(); 
			setState(550);
			((ParameterListContext)_localctx).p1 = parameterDeclaration();
			 _localctx.parameterListRet.add(((ParameterListContext)_localctx).p1.parameterDeclarationRet); 
			setState(558);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(552);
				match(Comma);
				setState(553);
				((ParameterListContext)_localctx).p2 = parameterDeclaration();
				 _localctx.parameterListRet.add(((ParameterListContext)_localctx).p2.parameterDeclarationRet); 
				}
				}
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public ParameterDeclaration parameterDeclarationRet;
		public DeclarationSpecifiersContext ds;
		public DeclaratorContext d;
		public AbstractDeclaratorContext a;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			((ParameterDeclarationContext)_localctx).ds = declarationSpecifiers();
			 ((ParameterDeclarationContext)_localctx).parameterDeclarationRet =  new ParameterDeclaration(((ParameterDeclarationContext)_localctx).ds.declarationSpecifiersRet);
			                                 _localctx.parameterDeclarationRet.setLine(((ParameterDeclarationContext)_localctx).ds.declarationSpecifiersRet.get(0).getLine()); 
			setState(571);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(563);
				((ParameterDeclarationContext)_localctx).d = declarator();
				 _localctx.parameterDeclarationRet.setDeclarator(((ParameterDeclarationContext)_localctx).d.declaratorRet); 
				}
				break;
			case 2:
				{
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
					{
					setState(566);
					((ParameterDeclarationContext)_localctx).a = abstractDeclarator();
					 _localctx.parameterDeclarationRet.setAbstractDeclarator(((ParameterDeclarationContext)_localctx).a.abstractDeclaratorRet); 
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierListContext extends ParserRuleContext {
		public ArrayList<String> identifierListRet;
		public Token id1;
		public Token id2;
		public List<TerminalNode> Identifier() { return getTokens(SimpleLangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLangParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((IdentifierListContext)_localctx).identifierListRet =  new ArrayList<String>(); 
			setState(574);
			((IdentifierListContext)_localctx).id1 = match(Identifier);
			 _localctx.identifierListRet.add((((IdentifierListContext)_localctx).id1!=null?((IdentifierListContext)_localctx).id1.getText():null)); 
			setState(581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(576);
				match(Comma);
				setState(577);
				((IdentifierListContext)_localctx).id2 = match(Identifier);
				 _localctx.identifierListRet.add((((IdentifierListContext)_localctx).id2!=null?((IdentifierListContext)_localctx).id2.getText():null)); 
				}
				}
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public TypeName typeNameRet;
		public SpecifierQualifierListContext s;
		public AbstractDeclaratorContext a;
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			((TypeNameContext)_localctx).s = specifierQualifierList();
			 ((TypeNameContext)_localctx).typeNameRet =  new TypeName(((TypeNameContext)_localctx).s.specifierQualifierListRet);
			                                 _localctx.typeNameRet.setLine(((TypeNameContext)_localctx).s.specifierQualifierListRet.get(0).getLine()); 
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
				{
				setState(586);
				((TypeNameContext)_localctx).a = abstractDeclarator();
				 _localctx.typeNameRet.setAbstractDeclarator(((TypeNameContext)_localctx).a.abstractDeclaratorRet); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public AbstractDeclarator abstractDeclaratorRet;
		public PointerContext p1;
		public PointerContext p2;
		public DirectAbstractDeclaratorContext d;
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_abstractDeclarator);
		int _la;
		try {
			setState(604);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((AbstractDeclaratorContext)_localctx).abstractDeclaratorRet =  new AbstractDeclarator(); 
				setState(592);
				((AbstractDeclaratorContext)_localctx).p1 = pointer();
				 ((AbstractDeclarator)_localctx.abstractDeclaratorRet).setPointer(((AbstractDeclaratorContext)_localctx).p1.pointerRet);
				                   _localctx.abstractDeclaratorRet.setLine(((AbstractDeclaratorContext)_localctx).p1.pointerRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				 ((AbstractDeclaratorContext)_localctx).abstractDeclaratorRet =  new AbstractDeclarator();
				        boolean isFirst = true; 
				setState(599);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(596);
					((AbstractDeclaratorContext)_localctx).p2 = pointer();
					 ((AbstractDeclarator)_localctx.abstractDeclaratorRet).setPointer(((AbstractDeclaratorContext)_localctx).p2.pointerRet);
					                    _localctx.abstractDeclaratorRet.setLine(((AbstractDeclaratorContext)_localctx).p2.pointerRet.getLine());
					                    isFirst = false; 
					}
				}

				setState(601);
				((AbstractDeclaratorContext)_localctx).d = directAbstractDeclarator(0);
				 _localctx.abstractDeclaratorRet.setDirectAbstractDeclarator(((AbstractDeclaratorContext)_localctx).d.directAbstractDeclaratorRet);
				                                   if (isFirst) _localctx.abstractDeclaratorRet.setLine(((AbstractDeclaratorContext)_localctx).d.directAbstractDeclaratorRet.getLine()); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectAbstractDeclaratorContext extends ParserRuleContext {
		public DirectAbstractDeclarator directAbstractDeclaratorRet;
		public DirectAbstractDeclaratorContext dd1;
		public DirectAbstractDeclaratorContext dd2;
		public Token l;
		public ExpressionContext e1;
		public AbstractDeclaratorContext a;
		public ParameterListContext pl1;
		public ExpressionContext e2;
		public ParameterListContext pl2;
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public DirectAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAbstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDirectAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDirectAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDirectAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectAbstractDeclaratorContext directAbstractDeclarator() throws RecognitionException {
		return directAbstractDeclarator(0);
	}

	private DirectAbstractDeclaratorContext directAbstractDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectAbstractDeclaratorContext _localctx = new DirectAbstractDeclaratorContext(_ctx, _parentState);
		DirectAbstractDeclaratorContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_directAbstractDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				{
				 ((DirectAbstractDeclaratorContext)_localctx).directAbstractDeclaratorRet =  new ExpressionAbstractDeclarator(); 
				setState(608);
				((DirectAbstractDeclaratorContext)_localctx).l = match(LeftBracket);
				setState(612);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(609);
					((DirectAbstractDeclaratorContext)_localctx).e1 = expression(0);
					 ((ExpressionAbstractDeclarator)_localctx.directAbstractDeclaratorRet).setExpression(((DirectAbstractDeclaratorContext)_localctx).e1.expressionRet); 
					}
				}

				setState(614);
				match(RightBracket);
				 _localctx.directAbstractDeclaratorRet.setLine((((DirectAbstractDeclaratorContext)_localctx).l!=null?((DirectAbstractDeclaratorContext)_localctx).l.getLine():0)); 
				}
				break;
			case LeftParen:
				{
				 ((DirectAbstractDeclaratorContext)_localctx).directAbstractDeclaratorRet =  new NestedAbstractDeclarator(); 
				setState(617);
				((DirectAbstractDeclaratorContext)_localctx).l = match(LeftParen);
				setState(626);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
				case LeftBracket:
				case Star:
					{
					setState(618);
					((DirectAbstractDeclaratorContext)_localctx).a = abstractDeclarator();
					 ((NestedAbstractDeclarator)_localctx.directAbstractDeclaratorRet).setAbstractDeclarator(((DirectAbstractDeclaratorContext)_localctx).a.abstractDeclaratorRet); 
					}
					break;
				case Char:
				case Const:
				case Double:
				case Float:
				case Int:
				case Long:
				case Short:
				case Signed:
				case Typedef:
				case Unsigned:
				case Void:
				case Bool:
				case RightParen:
				case Identifier:
					{
					setState(624);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
						{
						setState(621);
						((DirectAbstractDeclaratorContext)_localctx).pl1 = parameterList();
						 ((NestedAbstractDeclarator)_localctx.directAbstractDeclaratorRet).setParameters(((DirectAbstractDeclaratorContext)_localctx).pl1.parameterListRet); 
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(628);
				match(RightParen);
				 _localctx.directAbstractDeclaratorRet.setLine((((DirectAbstractDeclaratorContext)_localctx).l!=null?((DirectAbstractDeclaratorContext)_localctx).l.getLine():0)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(654);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(652);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.dd1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(632);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						 ((DirectAbstractDeclaratorContext)_localctx).directAbstractDeclaratorRet =  new ArrayAbstractDeclarator(((DirectAbstractDeclaratorContext)_localctx).dd1.directAbstractDeclaratorRet); 
						setState(634);
						match(LeftBracket);
						setState(638);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(635);
							((DirectAbstractDeclaratorContext)_localctx).e2 = expression(0);
							 ((ArrayAbstractDeclarator)_localctx.directAbstractDeclaratorRet).setExpression(((DirectAbstractDeclaratorContext)_localctx).e2.expressionRet); 
							}
						}

						setState(640);
						match(RightBracket);
						 _localctx.directAbstractDeclaratorRet.setLine(((DirectAbstractDeclaratorContext)_localctx).dd1.directAbstractDeclaratorRet.getLine()); 
						}
						break;
					case 2:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.dd2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(642);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						 ((DirectAbstractDeclaratorContext)_localctx).directAbstractDeclaratorRet =  new FunctionAbstractDeclarator(((DirectAbstractDeclaratorContext)_localctx).dd2.directAbstractDeclaratorRet); 
						setState(644);
						match(LeftParen);
						setState(648);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
							{
							setState(645);
							((DirectAbstractDeclaratorContext)_localctx).pl2 = parameterList();
							 ((FunctionAbstractDeclarator)_localctx.directAbstractDeclaratorRet).setParameters(((DirectAbstractDeclaratorContext)_localctx).pl2.parameterListRet); 
							}
						}

						setState(650);
						match(RightParen);
						 _localctx.directAbstractDeclaratorRet.setLine(((DirectAbstractDeclaratorContext)_localctx).dd2.directAbstractDeclaratorRet.getLine()); 
						}
						break;
					}
					} 
				}
				setState(656);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public Initializer initializerRet;
		public ExpressionContext e;
		public Token l;
		public InitializerListContext i;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLangParser.Comma, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_initializer);
		int _la;
		try {
			setState(668);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(657);
				((InitializerContext)_localctx).e = expression(0);
				 ((InitializerContext)_localctx).initializerRet =  new ExpressionInitializer(((InitializerContext)_localctx).e.expressionRet);
				                     _localctx.initializerRet.setLine(((InitializerContext)_localctx).e.expressionRet.getLine()); 
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(660);
				((InitializerContext)_localctx).l = match(LeftBrace);
				setState(661);
				((InitializerContext)_localctx).i = initializerList();
				setState(663);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(662);
					match(Comma);
					}
				}

				setState(665);
				match(RightBrace);
				 ((InitializerContext)_localctx).initializerRet =  new NestedInitializer(((InitializerContext)_localctx).i.initializerListRet);
				                                                        _localctx.initializerRet.setLine((((InitializerContext)_localctx).l!=null?((InitializerContext)_localctx).l.getLine():0)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerListContext extends ParserRuleContext {
		public ArrayList<DesignationInitializer> initializerListRet;
		public DesignationContext d1;
		public InitializerContext i1;
		public DesignationContext d2;
		public InitializerContext i2;
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public List<DesignationContext> designation() {
			return getRuleContexts(DesignationContext.class);
		}
		public DesignationContext designation(int i) {
			return getRuleContext(DesignationContext.class,i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((InitializerListContext)_localctx).initializerListRet =  new ArrayList<DesignationInitializer>();
			        ArrayList<Designator> desig1 = new ArrayList<Designator>(); 
			setState(674);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket || _la==Dot) {
				{
				setState(671);
				((InitializerListContext)_localctx).d1 = designation();
				 desig1 = ((InitializerListContext)_localctx).d1.designationRet; 
				}
			}

			setState(676);
			((InitializerListContext)_localctx).i1 = initializer();
			 DesignationInitializer tuple1 = new DesignationInitializer(desig1, ((InitializerListContext)_localctx).i1.initializerRet);
			                       _localctx.initializerListRet.add(tuple1); 
			setState(690);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					 ArrayList<Designator> desig2 = new ArrayList<Designator>(); 
					setState(679);
					match(Comma);
					setState(683);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LeftBracket || _la==Dot) {
						{
						setState(680);
						((InitializerListContext)_localctx).d2 = designation();
						 desig2 = ((InitializerListContext)_localctx).d2.designationRet; 
						}
					}

					setState(685);
					((InitializerListContext)_localctx).i2 = initializer();
					 DesignationInitializer tuple2 = new DesignationInitializer(desig2, ((InitializerListContext)_localctx).i2.initializerRet);
					                        _localctx.initializerListRet.add(tuple2); 
					}
					} 
				}
				setState(692);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignationContext extends ParserRuleContext {
		public ArrayList<Designator> designationRet;
		public DesignatorContext d;
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public List<DesignatorContext> designator() {
			return getRuleContexts(DesignatorContext.class);
		}
		public DesignatorContext designator(int i) {
			return getRuleContext(DesignatorContext.class,i);
		}
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_designation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DesignationContext)_localctx).designationRet =  new ArrayList<Designator>(); 
			setState(697); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(694);
				((DesignationContext)_localctx).d = designator();
				 _localctx.designationRet.add(((DesignationContext)_localctx).d.designatorRet); 
				}
				}
				setState(699); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LeftBracket || _la==Dot );
			setState(701);
			match(Assign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignatorContext extends ParserRuleContext {
		public Designator designatorRet;
		public Token l;
		public ExpressionContext e;
		public Token d;
		public Token id;
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(SimpleLangParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_designator);
		try {
			setState(711);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(703);
				((DesignatorContext)_localctx).l = match(LeftBracket);
				setState(704);
				((DesignatorContext)_localctx).e = expression(0);
				setState(705);
				match(RightBracket);
				 ((DesignatorContext)_localctx).designatorRet =  new ExpressionDesignator(((DesignatorContext)_localctx).e.expressionRet);
				                                                _localctx.designatorRet.setLine((((DesignatorContext)_localctx).l!=null?((DesignatorContext)_localctx).l.getLine():0)); 
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(708);
				((DesignatorContext)_localctx).d = match(Dot);
				setState(709);
				((DesignatorContext)_localctx).id = match(Identifier);
				 ((DesignatorContext)_localctx).designatorRet =  new IdentifierDesignator((((DesignatorContext)_localctx).id!=null?((DesignatorContext)_localctx).id.getText():null));
				                            _localctx.designatorRet.setLine((((DesignatorContext)_localctx).d!=null?((DesignatorContext)_localctx).d.getLine():0)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement statementRet;
		public CompoundStatementContext c;
		public ExpressionStatementContext e;
		public SelectionStatementContext s;
		public IterationStatementContext i;
		public JumpStatementContext j;
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_statement);
		try {
			setState(728);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(713);
				((StatementContext)_localctx).c = compoundStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).c.compoundStatementRet; 
				}
				break;
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Semi:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(716);
				((StatementContext)_localctx).e = expressionStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).e.expressionStatementRet; 
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(719);
				((StatementContext)_localctx).s = selectionStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).s.selectionStatementRet; 
				}
				break;
			case Do:
			case For:
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(722);
				((StatementContext)_localctx).i = iterationStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).i.iterationStatementRet; 
				}
				break;
			case Break:
			case Continue:
			case Return:
				enterOuterAlt(_localctx, 5);
				{
				setState(725);
				((StatementContext)_localctx).j = jumpStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).j.jumpStatementRet; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public CompoundStatement compoundStatementRet;
		public Token l;
		public BlockItemContext b;
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((CompoundStatementContext)_localctx).compoundStatementRet =  new CompoundStatement(); 
			setState(731);
			((CompoundStatementContext)_localctx).l = match(LeftBrace);
			setState(739);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 11L) != 0)) {
				{
				setState(735); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(732);
					((CompoundStatementContext)_localctx).b = blockItem();
					 ((CompoundStatement)_localctx.compoundStatementRet).addBlockItem(((CompoundStatementContext)_localctx).b.blockItemRet); 
					}
					}
					setState(737); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 11L) != 0) );
				}
			}

			setState(741);
			match(RightBrace);
			 _localctx.compoundStatementRet.setLine((((CompoundStatementContext)_localctx).l!=null?((CompoundStatementContext)_localctx).l.getLine():0)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockItemContext extends ParserRuleContext {
		public Node blockItemRet;
		public StatementContext s;
		public DeclarationContext d;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_blockItem);
		try {
			setState(750);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(744);
				((BlockItemContext)_localctx).s = statement();
				 ((BlockItemContext)_localctx).blockItemRet =  ((BlockItemContext)_localctx).s.statementRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(747);
				((BlockItemContext)_localctx).d = declaration();
				 ((BlockItemContext)_localctx).blockItemRet =  ((BlockItemContext)_localctx).d.declarationRet; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionStatement expressionStatementRet;
		public ExpressionContext e;
		public Token s;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ExpressionStatementContext)_localctx).expressionStatementRet =  new ExpressionStatement();
			        boolean isFirst = true; 
			setState(756);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(753);
				((ExpressionStatementContext)_localctx).e = expression(0);
				 _localctx.expressionStatementRet.setExpression(((ExpressionStatementContext)_localctx).e.expressionRet);
				                      _localctx.expressionStatementRet.setLine(((ExpressionStatementContext)_localctx).e.expressionRet.getLine());
				                      isFirst = false; 
				}
			}

			setState(758);
			((ExpressionStatementContext)_localctx).s = match(Semi);
			 if (isFirst) _localctx.expressionStatementRet.setLine((((ExpressionStatementContext)_localctx).s!=null?((ExpressionStatementContext)_localctx).s.getLine():0)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectionStatementContext extends ParserRuleContext {
		public SelectionStatement selectionStatementRet;
		public Token i;
		public ExpressionContext e;
		public StatementContext s1;
		public Token el;
		public StatementContext s2;
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode If() { return getToken(SimpleLangParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(SimpleLangParser.Else, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			((SelectionStatementContext)_localctx).i = match(If);
			setState(762);
			match(LeftParen);
			setState(763);
			((SelectionStatementContext)_localctx).e = expression(0);
			setState(764);
			match(RightParen);
			setState(765);
			((SelectionStatementContext)_localctx).s1 = statement();
			 ((SelectionStatementContext)_localctx).selectionStatementRet =  new SelectionStatement(((SelectionStatementContext)_localctx).e.expressionRet, ((SelectionStatementContext)_localctx).s1.statementRet);
			                                                            _localctx.selectionStatementRet.setIfLine((((SelectionStatementContext)_localctx).i!=null?((SelectionStatementContext)_localctx).i.getLine():0)); 
			setState(771);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(767);
				((SelectionStatementContext)_localctx).el = match(Else);
				setState(768);
				((SelectionStatementContext)_localctx).s2 = statement();
				 _localctx.selectionStatementRet.setElseStatement(((SelectionStatementContext)_localctx).s2.statementRet);
				                              _localctx.selectionStatementRet.setElseLine((((SelectionStatementContext)_localctx).el!=null?((SelectionStatementContext)_localctx).el.getLine():0)); 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IterationStatementContext extends ParserRuleContext {
		public IterationStatement iterationStatementRet;
		public Token w;
		public ExpressionContext e;
		public StatementContext s;
		public Token d;
		public Token fo;
		public ForConditionContext f;
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TerminalNode While() { return getToken(SimpleLangParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public TerminalNode Do() { return getToken(SimpleLangParser.Do, 0); }
		public TerminalNode For() { return getToken(SimpleLangParser.For, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_iterationStatement);
		try {
			setState(796);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(773);
				((IterationStatementContext)_localctx).w = match(While);
				setState(774);
				match(LeftParen);
				setState(775);
				((IterationStatementContext)_localctx).e = expression(0);
				setState(776);
				match(RightParen);
				setState(777);
				((IterationStatementContext)_localctx).s = statement();
				 ((IterationStatementContext)_localctx).iterationStatementRet =  new WhileIteration(((IterationStatementContext)_localctx).e.expressionRet, ((IterationStatementContext)_localctx).s.statementRet);
				                                                              _localctx.iterationStatementRet.setLine((((IterationStatementContext)_localctx).w!=null?((IterationStatementContext)_localctx).w.getLine():0)); 
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(780);
				((IterationStatementContext)_localctx).d = match(Do);
				setState(781);
				((IterationStatementContext)_localctx).s = statement();
				setState(782);
				match(While);
				setState(783);
				match(LeftParen);
				setState(784);
				((IterationStatementContext)_localctx).e = expression(0);
				setState(785);
				match(RightParen);
				setState(786);
				match(Semi);
				 ((IterationStatementContext)_localctx).iterationStatementRet =  new DoWhileIteration(((IterationStatementContext)_localctx).s.statementRet, ((IterationStatementContext)_localctx).e.expressionRet);
				                                                                      _localctx.iterationStatementRet.setLine((((IterationStatementContext)_localctx).d!=null?((IterationStatementContext)_localctx).d.getLine():0)); 
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(789);
				((IterationStatementContext)_localctx).fo = match(For);
				setState(790);
				match(LeftParen);
				setState(791);
				((IterationStatementContext)_localctx).f = forCondition();
				setState(792);
				match(RightParen);
				setState(793);
				((IterationStatementContext)_localctx).s = statement();
				 ((IterationStatementContext)_localctx).iterationStatementRet =  new ForIteration(((IterationStatementContext)_localctx).f.forConditionRet, ((IterationStatementContext)_localctx).s.statementRet);
				                                                               _localctx.iterationStatementRet.setLine((((IterationStatementContext)_localctx).fo!=null?((IterationStatementContext)_localctx).fo.getLine():0)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForConditionContext extends ParserRuleContext {
		public ForCondition forConditionRet;
		public ForDeclarationContext fd;
		public ExpressionContext e;
		public ForExpressionContext fe1;
		public ForExpressionContext fe2;
		public List<TerminalNode> Semi() { return getTokens(SimpleLangParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(SimpleLangParser.Semi, i);
		}
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public List<ForExpressionContext> forExpression() {
			return getRuleContexts(ForExpressionContext.class);
		}
		public ForExpressionContext forExpression(int i) {
			return getRuleContext(ForExpressionContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_forCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ForConditionContext)_localctx).forConditionRet =  new ForCondition();
			        boolean isFirst = true; 
			setState(807);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(799);
				((ForConditionContext)_localctx).fd = forDeclaration();
				 _localctx.forConditionRet.setInitial(((ForConditionContext)_localctx).fd.forDeclarationRet);
				                           _localctx.forConditionRet.setLine(((ForConditionContext)_localctx).fd.forDeclarationRet.getLine());
				                           isFirst = false; 
				}
				break;
			case 2:
				{
				setState(805);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(802);
					((ForConditionContext)_localctx).e = expression(0);
					 _localctx.forConditionRet.setInitial(((ForConditionContext)_localctx).e.expressionRet);
					                         _localctx.forConditionRet.setLine(((ForConditionContext)_localctx).e.expressionRet.getLine());
					                         isFirst = false; 
					}
				}

				}
				break;
			}
			setState(809);
			match(Semi);
			setState(813);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(810);
				((ForConditionContext)_localctx).fe1 = forExpression();
				 _localctx.forConditionRet.setConditions(((ForConditionContext)_localctx).fe1.forExpressionRet);
				                           if (isFirst) {
				                            _localctx.forConditionRet.setLine(((ForConditionContext)_localctx).fe1.forExpressionRet.get(0).getLine());
				                            isFirst = false;
				                           } 
				}
			}

			setState(815);
			match(Semi);
			setState(819);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(816);
				((ForConditionContext)_localctx).fe2 = forExpression();
				 _localctx.forConditionRet.setUpdates(((ForConditionContext)_localctx).fe2.forExpressionRet);
				                           if (isFirst) {
				                               _localctx.forConditionRet.setLine(((ForConditionContext)_localctx).fe1.forExpressionRet.get(0).getLine());
				                               isFirst = false;
				                           } 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForDeclarationContext extends ParserRuleContext {
		public Declaration forDeclarationRet;
		public DeclarationSpecifiersContext d;
		public InitDeclaratorListContext i;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_forDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			((ForDeclarationContext)_localctx).d = declarationSpecifiers();
			 ((ForDeclarationContext)_localctx).forDeclarationRet =  new Declaration(((ForDeclarationContext)_localctx).d.declarationSpecifiersRet);
			                                _localctx.forDeclarationRet.setLine(((ForDeclarationContext)_localctx).d.declarationSpecifiersRet.get(0).getLine()); 
			setState(826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(823);
				((ForDeclarationContext)_localctx).i = initDeclaratorList();
				 _localctx.forDeclarationRet.setInitDeclarators(((ForDeclarationContext)_localctx).i.initDeclaratorListRet); 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForExpressionContext extends ParserRuleContext {
		public ArrayList<Expression> forExpressionRet;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ForExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExpressionContext forExpression() throws RecognitionException {
		ForExpressionContext _localctx = new ForExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ForExpressionContext)_localctx).forExpressionRet =  new ArrayList<Expression>(); 
			setState(829);
			((ForExpressionContext)_localctx).e1 = expression(0);
			 _localctx.forExpressionRet.add(((ForExpressionContext)_localctx).e1.expressionRet); 
			setState(837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(831);
				match(Comma);
				setState(832);
				((ForExpressionContext)_localctx).e2 = expression(0);
				 _localctx.forExpressionRet.add(((ForExpressionContext)_localctx).e2.expressionRet); 
				}
				}
				setState(839);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatement jumpStatementRet;
		public Token c;
		public Token b;
		public Token r;
		public ExpressionContext e;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public TerminalNode Continue() { return getToken(SimpleLangParser.Continue, 0); }
		public TerminalNode Break() { return getToken(SimpleLangParser.Break, 0); }
		public TerminalNode Return() { return getToken(SimpleLangParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				{
				setState(840);
				((JumpStatementContext)_localctx).c = match(Continue);
				 ((JumpStatementContext)_localctx).jumpStatementRet =  new ContinueJump();
				                    _localctx.jumpStatementRet.setLine((((JumpStatementContext)_localctx).c!=null?((JumpStatementContext)_localctx).c.getLine():0)); 
				}
				break;
			case Break:
				{
				setState(842);
				((JumpStatementContext)_localctx).b = match(Break);
				 ((JumpStatementContext)_localctx).jumpStatementRet =  new BreakJump();
				                   _localctx.jumpStatementRet.setLine((((JumpStatementContext)_localctx).b!=null?((JumpStatementContext)_localctx).b.getLine():0)); 
				}
				break;
			case Return:
				{
				setState(844);
				((JumpStatementContext)_localctx).r = match(Return);
				 ((JumpStatementContext)_localctx).jumpStatementRet =  new ReturnJump();
				                    _localctx.jumpStatementRet.setLine((((JumpStatementContext)_localctx).r!=null?((JumpStatementContext)_localctx).r.getLine():0)); 
				setState(849);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(846);
					((JumpStatementContext)_localctx).e = expression(0);
					 ((ReturnJump)_localctx.jumpStatementRet).setExpression(((JumpStatementContext)_localctx).e.expressionRet); 
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(853);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 18:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 25:
			return directAbstractDeclarator_sempred((DirectAbstractDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 18);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		case 15:
			return precpred(_ctx, 15);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directAbstractDeclarator_sempred(DirectAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001M\u0358\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000T\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001\\\b"+
		"\u0001\u000b\u0001\f\u0001]\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002g\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003m\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003t\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0004\u0004}\b\u0004\u000b\u0004\f\u0004~\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005\u0089\b\u0005\u000b\u0005\f\u0005\u008a\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0098"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00a4"+
		"\b\u0005\n\u0005\f\u0005\u00a7\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u00b0\b\u0005"+
		"\u000b\u0005\f\u0005\u00b1\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00bf\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00ce\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00d7\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00e1\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00ec\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00f7\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0106\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u0111\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0148\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0151\b\u0005\n\u0005"+
		"\f\u0005\u0154\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u015d\b\u0006\n\u0006"+
		"\f\u0006\u0160\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u016e\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u017b\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0193\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u019a\b\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u01a2\b\u000b\u000b\u000b"+
		"\f\u000b\u01a3\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u01ad\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u01b6\b\r\n\r\f\r\u01b9\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01c1\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01d9\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u01e1\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01e6\b"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01ec"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u01f9\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0201\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u020d\b\u0012\u0003\u0012\u020f\b\u0012"+
		"\u0001\u0012\u0005\u0012\u0212\b\u0012\n\u0012\f\u0012\u0215\t\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u021c"+
		"\b\u0013\u000b\u0013\f\u0013\u021d\u0003\u0013\u0220\b\u0013\u0004\u0013"+
		"\u0222\b\u0013\u000b\u0013\f\u0013\u0223\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u022d"+
		"\b\u0014\n\u0014\f\u0014\u0230\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u023a\b\u0015\u0003\u0015\u023c\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0244\b\u0016\n"+
		"\u0016\f\u0016\u0247\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u024e\b\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u0258\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u025d"+
		"\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u0265\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u0271\b\u0019\u0003\u0019\u0273\b\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0277\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u027f\b\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0289\b\u0019\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u028d\b\u0019\n\u0019\f\u0019\u0290\t\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0298\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u029d\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u02a3\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u02ac\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u02b1"+
		"\b\u001b\n\u001b\f\u001b\u02b4\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0004\u001c\u02ba\b\u001c\u000b\u001c\f\u001c\u02bb\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u02c8\b\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u02d9\b\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0004\u001f\u02e0\b\u001f\u000b"+
		"\u001f\f\u001f\u02e1\u0003\u001f\u02e4\b\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u02ef\b"+
		" \u0001!\u0001!\u0001!\u0001!\u0003!\u02f5\b!\u0001!\u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0003\"\u0304\b\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#"+
		"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u031d\b#\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u0326\b$\u0003$\u0328\b$\u0001"+
		"$\u0001$\u0001$\u0001$\u0003$\u032e\b$\u0001$\u0001$\u0001$\u0001$\u0003"+
		"$\u0334\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u033b\b%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u0344\b&\n&\f&\u0347\t&\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003"+
		"\'\u0352\b\'\u0003\'\u0354\b\'\u0001\'\u0001\'\u0001\'\u0000\u0003\n$"+
		"2(\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLN\u0000\u0000\u03ba\u0000S\u0001\u0000"+
		"\u0000\u0000\u0002W\u0001\u0000\u0000\u0000\u0004f\u0001\u0000\u0000\u0000"+
		"\u0006h\u0001\u0000\u0000\u0000\bx\u0001\u0000\u0000\u0000\n\u00d6\u0001"+
		"\u0000\u0000\u0000\f\u0155\u0001\u0000\u0000\u0000\u000e\u016d\u0001\u0000"+
		"\u0000\u0000\u0010\u017a\u0001\u0000\u0000\u0000\u0012\u0192\u0001\u0000"+
		"\u0000\u0000\u0014\u0194\u0001\u0000\u0000\u0000\u0016\u019d\u0001\u0000"+
		"\u0000\u0000\u0018\u01ac\u0001\u0000\u0000\u0000\u001a\u01ae\u0001\u0000"+
		"\u0000\u0000\u001c\u01ba\u0001\u0000\u0000\u0000\u001e\u01d8\u0001\u0000"+
		"\u0000\u0000 \u01da\u0001\u0000\u0000\u0000\"\u01e7\u0001\u0000\u0000"+
		"\u0000$\u01f8\u0001\u0000\u0000\u0000&\u0216\u0001\u0000\u0000\u0000("+
		"\u0225\u0001\u0000\u0000\u0000*\u0231\u0001\u0000\u0000\u0000,\u023d\u0001"+
		"\u0000\u0000\u0000.\u0248\u0001\u0000\u0000\u00000\u025c\u0001\u0000\u0000"+
		"\u00002\u0276\u0001\u0000\u0000\u00004\u029c\u0001\u0000\u0000\u00006"+
		"\u029e\u0001\u0000\u0000\u00008\u02b5\u0001\u0000\u0000\u0000:\u02c7\u0001"+
		"\u0000\u0000\u0000<\u02d8\u0001\u0000\u0000\u0000>\u02da\u0001\u0000\u0000"+
		"\u0000@\u02ee\u0001\u0000\u0000\u0000B\u02f0\u0001\u0000\u0000\u0000D"+
		"\u02f9\u0001\u0000\u0000\u0000F\u031c\u0001\u0000\u0000\u0000H\u031e\u0001"+
		"\u0000\u0000\u0000J\u0335\u0001\u0000\u0000\u0000L\u033c\u0001\u0000\u0000"+
		"\u0000N\u0353\u0001\u0000\u0000\u0000PQ\u0003\u0002\u0001\u0000QR\u0006"+
		"\u0000\uffff\uffff\u0000RT\u0001\u0000\u0000\u0000SP\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0005\u0000"+
		"\u0000\u0001V\u0001\u0001\u0000\u0000\u0000W[\u0006\u0001\uffff\uffff"+
		"\u0000XY\u0003\u0004\u0002\u0000YZ\u0006\u0001\uffff\uffff\u0000Z\\\u0001"+
		"\u0000\u0000\u0000[X\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\u0003\u0001\u0000"+
		"\u0000\u0000_`\u0003\u0006\u0003\u0000`a\u0006\u0002\uffff\uffff\u0000"+
		"ag\u0001\u0000\u0000\u0000bc\u0003\u0014\n\u0000cd\u0006\u0002\uffff\uffff"+
		"\u0000dg\u0001\u0000\u0000\u0000eg\u00053\u0000\u0000f_\u0001\u0000\u0000"+
		"\u0000fb\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000g\u0005\u0001"+
		"\u0000\u0000\u0000hl\u0006\u0003\uffff\uffff\u0000ij\u0003\u0016\u000b"+
		"\u0000jk\u0006\u0003\uffff\uffff\u0000km\u0001\u0000\u0000\u0000li\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"no\u0003\"\u0011\u0000os\u0006\u0003\uffff\uffff\u0000pq\u0003\b\u0004"+
		"\u0000qr\u0006\u0003\uffff\uffff\u0000rt\u0001\u0000\u0000\u0000sp\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"uv\u0003>\u001f\u0000vw\u0006\u0003\uffff\uffff\u0000w\u0007\u0001\u0000"+
		"\u0000\u0000x|\u0006\u0004\uffff\uffff\u0000yz\u0003\u0014\n\u0000z{\u0006"+
		"\u0004\uffff\uffff\u0000{}\u0001\u0000\u0000\u0000|y\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001"+
		"\u0000\u0000\u0000\u007f\t\u0001\u0000\u0000\u0000\u0080\u0081\u0006\u0005"+
		"\uffff\uffff\u0000\u0081\u0082\u0005D\u0000\u0000\u0082\u00d7\u0006\u0005"+
		"\uffff\uffff\u0000\u0083\u0084\u0005E\u0000\u0000\u0084\u00d7\u0006\u0005"+
		"\uffff\uffff\u0000\u0085\u0088\u0006\u0005\uffff\uffff\u0000\u0086\u0087"+
		"\u0005G\u0000\u0000\u0087\u0089\u0006\u0005\uffff\uffff\u0000\u0088\u0086"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u00d7"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0017\u0000\u0000\u008d\u008e"+
		"\u0003\n\u0005\u0000\u008e\u008f\u0005\u0018\u0000\u0000\u008f\u0090\u0006"+
		"\u0005\uffff\uffff\u0000\u0090\u00d7\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005\u0017\u0000\u0000\u0092\u0093\u0003.\u0017\u0000\u0093\u0094\u0005"+
		"\u0018\u0000\u0000\u0094\u0095\u0005\u001b\u0000\u0000\u0095\u0097\u0003"+
		"6\u001b\u0000\u0096\u0098\u00054\u0000\u0000\u0097\u0096\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0005\u001c\u0000\u0000\u009a\u009b\u0006\u0005\uffff"+
		"\uffff\u0000\u009b\u00d7\u0001\u0000\u0000\u0000\u009c\u00a5\u0006\u0005"+
		"\uffff\uffff\u0000\u009d\u009e\u0005$\u0000\u0000\u009e\u00a4\u0006\u0005"+
		"\uffff\uffff\u0000\u009f\u00a0\u0005&\u0000\u0000\u00a0\u00a4\u0006\u0005"+
		"\uffff\uffff\u0000\u00a1\u00a2\u0005\u0010\u0000\u0000\u00a2\u00a4\u0006"+
		"\u0005\uffff\uffff\u0000\u00a3\u009d\u0001\u0000\u0000\u0000\u00a3\u009f"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6\u00cd\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005D\u0000\u0000\u00a9\u00ce\u0006"+
		"\u0005\uffff\uffff\u0000\u00aa\u00ab\u0005E\u0000\u0000\u00ab\u00ce\u0006"+
		"\u0005\uffff\uffff\u0000\u00ac\u00af\u0006\u0005\uffff\uffff\u0000\u00ad"+
		"\u00ae\u0005G\u0000\u0000\u00ae\u00b0\u0006\u0005\uffff\uffff\u0000\u00af"+
		"\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2"+
		"\u00ce\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0017\u0000\u0000\u00b4"+
		"\u00b5\u0003\n\u0005\u0000\u00b5\u00b6\u0005\u0018\u0000\u0000\u00b6\u00b7"+
		"\u0006\u0005\uffff\uffff\u0000\u00b7\u00ce\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0005\u0017\u0000\u0000\u00b9\u00ba\u0003.\u0017\u0000\u00ba\u00bb"+
		"\u0005\u0018\u0000\u0000\u00bb\u00bc\u0005\u001b\u0000\u0000\u00bc\u00be"+
		"\u00036\u001b\u0000\u00bd\u00bf\u00054\u0000\u0000\u00be\u00bd\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0005\u001c\u0000\u0000\u00c1\u00c2\u0006\u0005"+
		"\uffff\uffff\u0000\u00c2\u00ce\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003"+
		"\u000e\u0007\u0000\u00c4\u00c5\u0003\u0010\b\u0000\u00c5\u00c6\u0006\u0005"+
		"\uffff\uffff\u0000\u00c6\u00ce\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005"+
		"\u0010\u0000\u0000\u00c8\u00c9\u0005\u0017\u0000\u0000\u00c9\u00ca\u0003"+
		".\u0017\u0000\u00ca\u00cb\u0005\u0018\u0000\u0000\u00cb\u00cc\u0006\u0005"+
		"\uffff\uffff\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000\u00cd\u00a8\u0001"+
		"\u0000\u0000\u0000\u00cd\u00aa\u0001\u0000\u0000\u0000\u00cd\u00ac\u0001"+
		"\u0000\u0000\u0000\u00cd\u00b3\u0001\u0000\u0000\u0000\u00cd\u00b8\u0001"+
		"\u0000\u0000\u0000\u00cd\u00c3\u0001\u0000\u0000\u0000\u00cd\u00c7\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d7\u0006"+
		"\u0005\uffff\uffff\u0000\u00d0\u00d1\u0005\u0017\u0000\u0000\u00d1\u00d2"+
		"\u0003.\u0017\u0000\u00d2\u00d3\u0005\u0018\u0000\u0000\u00d3\u00d4\u0003"+
		"\u0010\b\u0000\u00d4\u00d5\u0006\u0005\uffff\uffff\u0000\u00d5\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d6\u0080\u0001\u0000\u0000\u0000\u00d6\u0083\u0001"+
		"\u0000\u0000\u0000\u00d6\u0085\u0001\u0000\u0000\u0000\u00d6\u008c\u0001"+
		"\u0000\u0000\u0000\u00d6\u0091\u0001\u0000\u0000\u0000\u00d6\u009c\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d0\u0001\u0000\u0000\u0000\u00d7\u0152\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\n\f\u0000\u0000\u00d9\u00e0\u0006\u0005"+
		"\uffff\uffff\u0000\u00da\u00db\u0005\'\u0000\u0000\u00db\u00e1\u0006\u0005"+
		"\uffff\uffff\u0000\u00dc\u00dd\u0005(\u0000\u0000\u00dd\u00e1\u0006\u0005"+
		"\uffff\uffff\u0000\u00de\u00df\u0005)\u0000\u0000\u00df\u00e1\u0006\u0005"+
		"\uffff\uffff\u0000\u00e0\u00da\u0001\u0000\u0000\u0000\u00e0\u00dc\u0001"+
		"\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0003\n\u0005\r\u00e3\u00e4\u0006\u0005"+
		"\uffff\uffff\u0000\u00e4\u0151\u0001\u0000\u0000\u0000\u00e5\u00e6\n\u000b"+
		"\u0000\u0000\u00e6\u00eb\u0006\u0005\uffff\uffff\u0000\u00e7\u00e8\u0005"+
		"#\u0000\u0000\u00e8\u00ec\u0006\u0005\uffff\uffff\u0000\u00e9\u00ea\u0005"+
		"%\u0000\u0000\u00ea\u00ec\u0006\u0005\uffff\uffff\u0000\u00eb\u00e7\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ee\u0003\n\u0005\f\u00ee\u00ef\u0006\u0005"+
		"\uffff\uffff\u0000\u00ef\u0151\u0001\u0000\u0000\u0000\u00f0\u00f1\n\n"+
		"\u0000\u0000\u00f1\u00f6\u0006\u0005\uffff\uffff\u0000\u00f2\u00f3\u0005"+
		"!\u0000\u0000\u00f3\u00f7\u0006\u0005\uffff\uffff\u0000\u00f4\u00f5\u0005"+
		"\"\u0000\u0000\u00f5\u00f7\u0006\u0005\uffff\uffff\u0000\u00f6\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0003\n\u0005\u000b\u00f9\u00fa\u0006\u0005"+
		"\uffff\uffff\u0000\u00fa\u0151\u0001\u0000\u0000\u0000\u00fb\u00fc\n\t"+
		"\u0000\u0000\u00fc\u0105\u0006\u0005\uffff\uffff\u0000\u00fd\u00fe\u0005"+
		"\u001d\u0000\u0000\u00fe\u0106\u0006\u0005\uffff\uffff\u0000\u00ff\u0100"+
		"\u0005\u001f\u0000\u0000\u0100\u0106\u0006\u0005\uffff\uffff\u0000\u0101"+
		"\u0102\u0005\u001e\u0000\u0000\u0102\u0106\u0006\u0005\uffff\uffff\u0000"+
		"\u0103\u0104\u0005 \u0000\u0000\u0104\u0106\u0006\u0005\uffff\uffff\u0000"+
		"\u0105\u00fd\u0001\u0000\u0000\u0000\u0105\u00ff\u0001\u0000\u0000\u0000"+
		"\u0105\u0101\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0108\u0003\n\u0005\n\u0108"+
		"\u0109\u0006\u0005\uffff\uffff\u0000\u0109\u0151\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\n\b\u0000\u0000\u010b\u0110\u0006\u0005\uffff\uffff\u0000"+
		"\u010c\u010d\u0005@\u0000\u0000\u010d\u0111\u0006\u0005\uffff\uffff\u0000"+
		"\u010e\u010f\u0005A\u0000\u0000\u010f\u0111\u0006\u0005\uffff\uffff\u0000"+
		"\u0110\u010c\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000"+
		"\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0113\u0003\n\u0005\t\u0113"+
		"\u0114\u0006\u0005\uffff\uffff\u0000\u0114\u0151\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\n\u0007\u0000\u0000\u0116\u0117\u0005*\u0000\u0000\u0117"+
		"\u0118\u0003\n\u0005\b\u0118\u0119\u0006\u0005\uffff\uffff\u0000\u0119"+
		"\u0151\u0001\u0000\u0000\u0000\u011a\u011b\n\u0006\u0000\u0000\u011b\u011c"+
		"\u0005.\u0000\u0000\u011c\u011d\u0003\n\u0005\u0007\u011d\u011e\u0006"+
		"\u0005\uffff\uffff\u0000\u011e\u0151\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\n\u0005\u0000\u0000\u0120\u0121\u0005+\u0000\u0000\u0121\u0122\u0003"+
		"\n\u0005\u0006\u0122\u0123\u0006\u0005\uffff\uffff\u0000\u0123\u0151\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\n\u0004\u0000\u0000\u0125\u0126\u0005,"+
		"\u0000\u0000\u0126\u0127\u0003\n\u0005\u0005\u0127\u0128\u0006\u0005\uffff"+
		"\uffff\u0000\u0128\u0151\u0001\u0000\u0000\u0000\u0129\u012a\n\u0003\u0000"+
		"\u0000\u012a\u012b\u0005-\u0000\u0000\u012b\u012c\u0003\n\u0005\u0004"+
		"\u012c\u012d\u0006\u0005\uffff\uffff\u0000\u012d\u0151\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\n\u0002\u0000\u0000\u012f\u0130\u00051\u0000\u0000"+
		"\u0130\u0131\u0003\n\u0005\u0000\u0131\u0132\u00052\u0000\u0000\u0132"+
		"\u0133\u0003\n\u0005\u0003\u0133\u0134\u0006\u0005\uffff\uffff\u0000\u0134"+
		"\u0151\u0001\u0000\u0000\u0000\u0135\u0136\n\u0001\u0000\u0000\u0136\u0137"+
		"\u0003\u0012\t\u0000\u0137\u0138\u0003\n\u0005\u0002\u0138\u0139\u0006"+
		"\u0005\uffff\uffff\u0000\u0139\u0151\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\n\u0012\u0000\u0000\u013b\u013c\u0005\u0019\u0000\u0000\u013c\u013d\u0003"+
		"\n\u0005\u0000\u013d\u013e\u0005\u001a\u0000\u0000\u013e\u013f\u0006\u0005"+
		"\uffff\uffff\u0000\u013f\u0151\u0001\u0000\u0000\u0000\u0140\u0141\n\u0011"+
		"\u0000\u0000\u0141\u0142\u0006\u0005\uffff\uffff\u0000\u0142\u0143\u0005"+
		"\u0017\u0000\u0000\u0143\u0147\u0006\u0005\uffff\uffff\u0000\u0144\u0145"+
		"\u0003\f\u0006\u0000\u0145\u0146\u0006\u0005\uffff\uffff\u0000\u0146\u0148"+
		"\u0001\u0000\u0000\u0000\u0147\u0144\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u0151"+
		"\u0005\u0018\u0000\u0000\u014a\u014b\n\u0010\u0000\u0000\u014b\u014c\u0005"+
		"$\u0000\u0000\u014c\u0151\u0006\u0005\uffff\uffff\u0000\u014d\u014e\n"+
		"\u000f\u0000\u0000\u014e\u014f\u0005&\u0000\u0000\u014f\u0151\u0006\u0005"+
		"\uffff\uffff\u0000\u0150\u00d8\u0001\u0000\u0000\u0000\u0150\u00e5\u0001"+
		"\u0000\u0000\u0000\u0150\u00f0\u0001\u0000\u0000\u0000\u0150\u00fb\u0001"+
		"\u0000\u0000\u0000\u0150\u010a\u0001\u0000\u0000\u0000\u0150\u0115\u0001"+
		"\u0000\u0000\u0000\u0150\u011a\u0001\u0000\u0000\u0000\u0150\u011f\u0001"+
		"\u0000\u0000\u0000\u0150\u0124\u0001\u0000\u0000\u0000\u0150\u0129\u0001"+
		"\u0000\u0000\u0000\u0150\u012e\u0001\u0000\u0000\u0000\u0150\u0135\u0001"+
		"\u0000\u0000\u0000\u0150\u013a\u0001\u0000\u0000\u0000\u0150\u0140\u0001"+
		"\u0000\u0000\u0000\u0150\u014a\u0001\u0000\u0000\u0000\u0150\u014d\u0001"+
		"\u0000\u0000\u0000\u0151\u0154\u0001\u0000\u0000\u0000\u0152\u0150\u0001"+
		"\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u000b\u0001"+
		"\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0155\u0156\u0006"+
		"\u0006\uffff\uffff\u0000\u0156\u0157\u0003\n\u0005\u0000\u0157\u015e\u0006"+
		"\u0006\uffff\uffff\u0000\u0158\u0159\u00054\u0000\u0000\u0159\u015a\u0003"+
		"\n\u0005\u0000\u015a\u015b\u0006\u0006\uffff\uffff\u0000\u015b\u015d\u0001"+
		"\u0000\u0000\u0000\u015c\u0158\u0001\u0000\u0000\u0000\u015d\u0160\u0001"+
		"\u0000\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001"+
		"\u0000\u0000\u0000\u015f\r\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000"+
		"\u0000\u0000\u0161\u0162\u0005*\u0000\u0000\u0162\u016e\u0006\u0007\uffff"+
		"\uffff\u0000\u0163\u0164\u0005\'\u0000\u0000\u0164\u016e\u0006\u0007\uffff"+
		"\uffff\u0000\u0165\u0166\u0005#\u0000\u0000\u0166\u016e\u0006\u0007\uffff"+
		"\uffff\u0000\u0167\u0168\u0005%\u0000\u0000\u0168\u016e\u0006\u0007\uffff"+
		"\uffff\u0000\u0169\u016a\u00050\u0000\u0000\u016a\u016e\u0006\u0007\uffff"+
		"\uffff\u0000\u016b\u016c\u0005/\u0000\u0000\u016c\u016e\u0006\u0007\uffff"+
		"\uffff\u0000\u016d\u0161\u0001\u0000\u0000\u0000\u016d\u0163\u0001\u0000"+
		"\u0000\u0000\u016d\u0165\u0001\u0000\u0000\u0000\u016d\u0167\u0001\u0000"+
		"\u0000\u0000\u016d\u0169\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000"+
		"\u0000\u0000\u016e\u000f\u0001\u0000\u0000\u0000\u016f\u0170\u0005\u0017"+
		"\u0000\u0000\u0170\u0171\u0003.\u0017\u0000\u0171\u0172\u0005\u0018\u0000"+
		"\u0000\u0172\u0173\u0003\u0010\b\u0000\u0173\u0174\u0006\b\uffff\uffff"+
		"\u0000\u0174\u017b\u0001\u0000\u0000\u0000\u0175\u0176\u0003\n\u0005\u0000"+
		"\u0176\u0177\u0006\b\uffff\uffff\u0000\u0177\u017b\u0001\u0000\u0000\u0000"+
		"\u0178\u0179\u0005F\u0000\u0000\u0179\u017b\u0006\b\uffff\uffff\u0000"+
		"\u017a\u016f\u0001\u0000\u0000\u0000\u017a\u0175\u0001\u0000\u0000\u0000"+
		"\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u0011\u0001\u0000\u0000\u0000"+
		"\u017c\u017d\u00055\u0000\u0000\u017d\u0193\u0006\t\uffff\uffff\u0000"+
		"\u017e\u017f\u00056\u0000\u0000\u017f\u0193\u0006\t\uffff\uffff\u0000"+
		"\u0180\u0181\u00057\u0000\u0000\u0181\u0193\u0006\t\uffff\uffff\u0000"+
		"\u0182\u0183\u00058\u0000\u0000\u0183\u0193\u0006\t\uffff\uffff\u0000"+
		"\u0184\u0185\u00059\u0000\u0000\u0185\u0193\u0006\t\uffff\uffff\u0000"+
		"\u0186\u0187\u0005:\u0000\u0000\u0187\u0193\u0006\t\uffff\uffff\u0000"+
		"\u0188\u0189\u0005;\u0000\u0000\u0189\u0193\u0006\t\uffff\uffff\u0000"+
		"\u018a\u018b\u0005<\u0000\u0000\u018b\u0193\u0006\t\uffff\uffff\u0000"+
		"\u018c\u018d\u0005=\u0000\u0000\u018d\u0193\u0006\t\uffff\uffff\u0000"+
		"\u018e\u018f\u0005>\u0000\u0000\u018f\u0193\u0006\t\uffff\uffff\u0000"+
		"\u0190\u0191\u0005?\u0000\u0000\u0191\u0193\u0006\t\uffff\uffff\u0000"+
		"\u0192\u017c\u0001\u0000\u0000\u0000\u0192\u017e\u0001\u0000\u0000\u0000"+
		"\u0192\u0180\u0001\u0000\u0000\u0000\u0192\u0182\u0001\u0000\u0000\u0000"+
		"\u0192\u0184\u0001\u0000\u0000\u0000\u0192\u0186\u0001\u0000\u0000\u0000"+
		"\u0192\u0188\u0001\u0000\u0000\u0000\u0192\u018a\u0001\u0000\u0000\u0000"+
		"\u0192\u018c\u0001\u0000\u0000\u0000\u0192\u018e\u0001\u0000\u0000\u0000"+
		"\u0192\u0190\u0001\u0000\u0000\u0000\u0193\u0013\u0001\u0000\u0000\u0000"+
		"\u0194\u0195\u0003\u0016\u000b\u0000\u0195\u0199\u0006\n\uffff\uffff\u0000"+
		"\u0196\u0197\u0003\u001a\r\u0000\u0197\u0198\u0006\n\uffff\uffff\u0000"+
		"\u0198\u019a\u0001\u0000\u0000\u0000\u0199\u0196\u0001\u0000\u0000\u0000"+
		"\u0199\u019a\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000"+
		"\u019b\u019c\u00053\u0000\u0000\u019c\u0015\u0001\u0000\u0000\u0000\u019d"+
		"\u01a1\u0006\u000b\uffff\uffff\u0000\u019e\u019f\u0003\u0018\f\u0000\u019f"+
		"\u01a0\u0006\u000b\uffff\uffff\u0000\u01a0\u01a2\u0001\u0000\u0000\u0000"+
		"\u01a1\u019e\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000"+
		"\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000"+
		"\u01a4\u0017\u0001\u0000\u0000\u0000\u01a5\u01a6\u0005\u0012\u0000\u0000"+
		"\u01a6\u01ad\u0006\f\uffff\uffff\u0000\u01a7\u01a8\u0003\u001e\u000f\u0000"+
		"\u01a8\u01a9\u0006\f\uffff\uffff\u0000\u01a9\u01ad\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ab\u0005\u0003\u0000\u0000\u01ab\u01ad\u0006\f\uffff\uffff\u0000"+
		"\u01ac\u01a5\u0001\u0000\u0000\u0000\u01ac\u01a7\u0001\u0000\u0000\u0000"+
		"\u01ac\u01aa\u0001\u0000\u0000\u0000\u01ad\u0019\u0001\u0000\u0000\u0000"+
		"\u01ae\u01af\u0006\r\uffff\uffff\u0000\u01af\u01b0\u0003\u001c\u000e\u0000"+
		"\u01b0\u01b7\u0006\r\uffff\uffff\u0000\u01b1\u01b2\u00054\u0000\u0000"+
		"\u01b2\u01b3\u0003\u001c\u000e\u0000\u01b3\u01b4\u0006\r\uffff\uffff\u0000"+
		"\u01b4\u01b6\u0001\u0000\u0000\u0000\u01b5\u01b1\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b9\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000"+
		"\u01b7\u01b8\u0001\u0000\u0000\u0000\u01b8\u001b\u0001\u0000\u0000\u0000"+
		"\u01b9\u01b7\u0001\u0000\u0000\u0000\u01ba\u01bb\u0003\"\u0011\u0000\u01bb"+
		"\u01c0\u0006\u000e\uffff\uffff\u0000\u01bc\u01bd\u00055\u0000\u0000\u01bd"+
		"\u01be\u00034\u001a\u0000\u01be\u01bf\u0006\u000e\uffff\uffff\u0000\u01bf"+
		"\u01c1\u0001\u0000\u0000\u0000\u01c0\u01bc\u0001\u0000\u0000\u0000\u01c0"+
		"\u01c1\u0001\u0000\u0000\u0000\u01c1\u001d\u0001\u0000\u0000\u0000\u01c2"+
		"\u01c3\u0005\u0014\u0000\u0000\u01c3\u01d9\u0006\u000f\uffff\uffff\u0000"+
		"\u01c4\u01c5\u0005\u0002\u0000\u0000\u01c5\u01d9\u0006\u000f\uffff\uffff"+
		"\u0000\u01c6\u01c7\u0005\u000e\u0000\u0000\u01c7\u01d9\u0006\u000f\uffff"+
		"\uffff\u0000\u01c8\u01c9\u0005\u000b\u0000\u0000\u01c9\u01d9\u0006\u000f"+
		"\uffff\uffff\u0000\u01ca\u01cb\u0005\f\u0000\u0000\u01cb\u01d9\u0006\u000f"+
		"\uffff\uffff\u0000\u01cc\u01cd\u0005\b\u0000\u0000\u01cd\u01d9\u0006\u000f"+
		"\uffff\uffff\u0000\u01ce\u01cf\u0005\u0006\u0000\u0000\u01cf\u01d9\u0006"+
		"\u000f\uffff\uffff\u0000\u01d0\u01d1\u0005\u000f\u0000\u0000\u01d1\u01d9"+
		"\u0006\u000f\uffff\uffff\u0000\u01d2\u01d3\u0005\u0013\u0000\u0000\u01d3"+
		"\u01d9\u0006\u000f\uffff\uffff\u0000\u01d4\u01d5\u0005\u0016\u0000\u0000"+
		"\u01d5\u01d9\u0006\u000f\uffff\uffff\u0000\u01d6\u01d7\u0005D\u0000\u0000"+
		"\u01d7\u01d9\u0006\u000f\uffff\uffff\u0000\u01d8\u01c2\u0001\u0000\u0000"+
		"\u0000\u01d8\u01c4\u0001\u0000\u0000\u0000\u01d8\u01c6\u0001\u0000\u0000"+
		"\u0000\u01d8\u01c8\u0001\u0000\u0000\u0000\u01d8\u01ca\u0001\u0000\u0000"+
		"\u0000\u01d8\u01cc\u0001\u0000\u0000\u0000\u01d8\u01ce\u0001\u0000\u0000"+
		"\u0000\u01d8\u01d0\u0001\u0000\u0000\u0000\u01d8\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d8\u01d4\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000"+
		"\u0000\u01d9\u001f\u0001\u0000\u0000\u0000\u01da\u01e0\u0006\u0010\uffff"+
		"\uffff\u0000\u01db\u01dc\u0003\u001e\u000f\u0000\u01dc\u01dd\u0006\u0010"+
		"\uffff\uffff\u0000\u01dd\u01e1\u0001\u0000\u0000\u0000\u01de\u01df\u0005"+
		"\u0003\u0000\u0000\u01df\u01e1\u0006\u0010\uffff\uffff\u0000\u01e0\u01db"+
		"\u0001\u0000\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e1\u01e5"+
		"\u0001\u0000\u0000\u0000\u01e2\u01e3\u0003 \u0010\u0000\u01e3\u01e4\u0006"+
		"\u0010\uffff\uffff\u0000\u01e4\u01e6\u0001\u0000\u0000\u0000\u01e5\u01e2"+
		"\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6!\u0001"+
		"\u0000\u0000\u0000\u01e7\u01eb\u0006\u0011\uffff\uffff\u0000\u01e8\u01e9"+
		"\u0003&\u0013\u0000\u01e9\u01ea\u0006\u0011\uffff\uffff\u0000\u01ea\u01ec"+
		"\u0001\u0000\u0000\u0000\u01eb\u01e8\u0001\u0000\u0000\u0000\u01eb\u01ec"+
		"\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ee"+
		"\u0003$\u0012\u0000\u01ee\u01ef\u0006\u0011\uffff\uffff\u0000\u01ef#\u0001"+
		"\u0000\u0000\u0000\u01f0\u01f1\u0006\u0012\uffff\uffff\u0000\u01f1\u01f2"+
		"\u0005D\u0000\u0000\u01f2\u01f9\u0006\u0012\uffff\uffff\u0000\u01f3\u01f4"+
		"\u0005\u0017\u0000\u0000\u01f4\u01f5\u0003\"\u0011\u0000\u01f5\u01f6\u0005"+
		"\u0018\u0000\u0000\u01f6\u01f7\u0006\u0012\uffff\uffff\u0000\u01f7\u01f9"+
		"\u0001\u0000\u0000\u0000\u01f8\u01f0\u0001\u0000\u0000\u0000\u01f8\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f9\u0213\u0001\u0000\u0000\u0000\u01fa\u01fb"+
		"\n\u0002\u0000\u0000\u01fb\u01fc\u0006\u0012\uffff\uffff\u0000\u01fc\u0200"+
		"\u0005\u0019\u0000\u0000\u01fd\u01fe\u0003\n\u0005\u0000\u01fe\u01ff\u0006"+
		"\u0012\uffff\uffff\u0000\u01ff\u0201\u0001\u0000\u0000\u0000\u0200\u01fd"+
		"\u0001\u0000\u0000\u0000\u0200\u0201\u0001\u0000\u0000\u0000\u0201\u0202"+
		"\u0001\u0000\u0000\u0000\u0202\u0212\u0005\u001a\u0000\u0000\u0203\u0204"+
		"\n\u0001\u0000\u0000\u0204\u0205\u0006\u0012\uffff\uffff\u0000\u0205\u020e"+
		"\u0005\u0017\u0000\u0000\u0206\u0207\u0003(\u0014\u0000\u0207\u0208\u0006"+
		"\u0012\uffff\uffff\u0000\u0208\u020f\u0001\u0000\u0000\u0000\u0209\u020a"+
		"\u0003,\u0016\u0000\u020a\u020b\u0006\u0012\uffff\uffff\u0000\u020b\u020d"+
		"\u0001\u0000\u0000\u0000\u020c\u0209\u0001\u0000\u0000\u0000\u020c\u020d"+
		"\u0001\u0000\u0000\u0000\u020d\u020f\u0001\u0000\u0000\u0000\u020e\u0206"+
		"\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020f\u0210"+
		"\u0001\u0000\u0000\u0000\u0210\u0212\u0005\u0018\u0000\u0000\u0211\u01fa"+
		"\u0001\u0000\u0000\u0000\u0211\u0203\u0001\u0000\u0000\u0000\u0212\u0215"+
		"\u0001\u0000\u0000\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0213\u0214"+
		"\u0001\u0000\u0000\u0000\u0214%\u0001\u0000\u0000\u0000\u0215\u0213\u0001"+
		"\u0000\u0000\u0000\u0216\u0221\u0006\u0013\uffff\uffff\u0000\u0217\u0218"+
		"\u0005\'\u0000\u0000\u0218\u021f\u0006\u0013\uffff\uffff\u0000\u0219\u021a"+
		"\u0005\u0003\u0000\u0000\u021a\u021c\u0006\u0013\uffff\uffff\u0000\u021b"+
		"\u0219\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000\u021d"+
		"\u021b\u0001\u0000\u0000\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e"+
		"\u0220\u0001\u0000\u0000\u0000\u021f\u021b\u0001\u0000\u0000\u0000\u021f"+
		"\u0220\u0001\u0000\u0000\u0000\u0220\u0222\u0001\u0000\u0000\u0000\u0221"+
		"\u0217\u0001\u0000\u0000\u0000\u0222\u0223\u0001\u0000\u0000\u0000\u0223"+
		"\u0221\u0001\u0000\u0000\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224"+
		"\'\u0001\u0000\u0000\u0000\u0225\u0226\u0006\u0014\uffff\uffff\u0000\u0226"+
		"\u0227\u0003*\u0015\u0000\u0227\u022e\u0006\u0014\uffff\uffff\u0000\u0228"+
		"\u0229\u00054\u0000\u0000\u0229\u022a\u0003*\u0015\u0000\u022a\u022b\u0006"+
		"\u0014\uffff\uffff\u0000\u022b\u022d\u0001\u0000\u0000\u0000\u022c\u0228"+
		"\u0001\u0000\u0000\u0000\u022d\u0230\u0001\u0000\u0000\u0000\u022e\u022c"+
		"\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f)\u0001"+
		"\u0000\u0000\u0000\u0230\u022e\u0001\u0000\u0000\u0000\u0231\u0232\u0003"+
		"\u0016\u000b\u0000\u0232\u023b\u0006\u0015\uffff\uffff\u0000\u0233\u0234"+
		"\u0003\"\u0011\u0000\u0234\u0235\u0006\u0015\uffff\uffff\u0000\u0235\u023c"+
		"\u0001\u0000\u0000\u0000\u0236\u0237\u00030\u0018\u0000\u0237\u0238\u0006"+
		"\u0015\uffff\uffff\u0000\u0238\u023a\u0001\u0000\u0000\u0000\u0239\u0236"+
		"\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000\u023a\u023c"+
		"\u0001\u0000\u0000\u0000\u023b\u0233\u0001\u0000\u0000\u0000\u023b\u0239"+
		"\u0001\u0000\u0000\u0000\u023c+\u0001\u0000\u0000\u0000\u023d\u023e\u0006"+
		"\u0016\uffff\uffff\u0000\u023e\u023f\u0005D\u0000\u0000\u023f\u0245\u0006"+
		"\u0016\uffff\uffff\u0000\u0240\u0241\u00054\u0000\u0000\u0241\u0242\u0005"+
		"D\u0000\u0000\u0242\u0244\u0006\u0016\uffff\uffff\u0000\u0243\u0240\u0001"+
		"\u0000\u0000\u0000\u0244\u0247\u0001\u0000\u0000\u0000\u0245\u0243\u0001"+
		"\u0000\u0000\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246-\u0001\u0000"+
		"\u0000\u0000\u0247\u0245\u0001\u0000\u0000\u0000\u0248\u0249\u0003 \u0010"+
		"\u0000\u0249\u024d\u0006\u0017\uffff\uffff\u0000\u024a\u024b\u00030\u0018"+
		"\u0000\u024b\u024c\u0006\u0017\uffff\uffff\u0000\u024c\u024e\u0001\u0000"+
		"\u0000\u0000\u024d\u024a\u0001\u0000\u0000\u0000\u024d\u024e\u0001\u0000"+
		"\u0000\u0000\u024e/\u0001\u0000\u0000\u0000\u024f\u0250\u0006\u0018\uffff"+
		"\uffff\u0000\u0250\u0251\u0003&\u0013\u0000\u0251\u0252\u0006\u0018\uffff"+
		"\uffff\u0000\u0252\u025d\u0001\u0000\u0000\u0000\u0253\u0257\u0006\u0018"+
		"\uffff\uffff\u0000\u0254\u0255\u0003&\u0013\u0000\u0255\u0256\u0006\u0018"+
		"\uffff\uffff\u0000\u0256\u0258\u0001\u0000\u0000\u0000\u0257\u0254\u0001"+
		"\u0000\u0000\u0000\u0257\u0258\u0001\u0000\u0000\u0000\u0258\u0259\u0001"+
		"\u0000\u0000\u0000\u0259\u025a\u00032\u0019\u0000\u025a\u025b\u0006\u0018"+
		"\uffff\uffff\u0000\u025b\u025d\u0001\u0000\u0000\u0000\u025c\u024f\u0001"+
		"\u0000\u0000\u0000\u025c\u0253\u0001\u0000\u0000\u0000\u025d1\u0001\u0000"+
		"\u0000\u0000\u025e\u025f\u0006\u0019\uffff\uffff\u0000\u025f\u0260\u0006"+
		"\u0019\uffff\uffff\u0000\u0260\u0264\u0005\u0019\u0000\u0000\u0261\u0262"+
		"\u0003\n\u0005\u0000\u0262\u0263\u0006\u0019\uffff\uffff\u0000\u0263\u0265"+
		"\u0001\u0000\u0000\u0000\u0264\u0261\u0001\u0000\u0000\u0000\u0264\u0265"+
		"\u0001\u0000\u0000\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u0267"+
		"\u0005\u001a\u0000\u0000\u0267\u0277\u0006\u0019\uffff\uffff\u0000\u0268"+
		"\u0269\u0006\u0019\uffff\uffff\u0000\u0269\u0272\u0005\u0017\u0000\u0000"+
		"\u026a\u026b\u00030\u0018\u0000\u026b\u026c\u0006\u0019\uffff\uffff\u0000"+
		"\u026c\u0273\u0001\u0000\u0000\u0000\u026d\u026e\u0003(\u0014\u0000\u026e"+
		"\u026f\u0006\u0019\uffff\uffff\u0000\u026f\u0271\u0001\u0000\u0000\u0000"+
		"\u0270\u026d\u0001\u0000\u0000\u0000\u0270\u0271\u0001\u0000\u0000\u0000"+
		"\u0271\u0273\u0001\u0000\u0000\u0000\u0272\u026a\u0001\u0000\u0000\u0000"+
		"\u0272\u0270\u0001\u0000\u0000\u0000\u0273\u0274\u0001\u0000\u0000\u0000"+
		"\u0274\u0275\u0005\u0018\u0000\u0000\u0275\u0277\u0006\u0019\uffff\uffff"+
		"\u0000\u0276\u025e\u0001\u0000\u0000\u0000\u0276\u0268\u0001\u0000\u0000"+
		"\u0000\u0277\u028e\u0001\u0000\u0000\u0000\u0278\u0279\n\u0002\u0000\u0000"+
		"\u0279\u027a\u0006\u0019\uffff\uffff\u0000\u027a\u027e\u0005\u0019\u0000"+
		"\u0000\u027b\u027c\u0003\n\u0005\u0000\u027c\u027d\u0006\u0019\uffff\uffff"+
		"\u0000\u027d\u027f\u0001\u0000\u0000\u0000\u027e\u027b\u0001\u0000\u0000"+
		"\u0000\u027e\u027f\u0001\u0000\u0000\u0000\u027f\u0280\u0001\u0000\u0000"+
		"\u0000\u0280\u0281\u0005\u001a\u0000\u0000\u0281\u028d\u0006\u0019\uffff"+
		"\uffff\u0000\u0282\u0283\n\u0001\u0000\u0000\u0283\u0284\u0006\u0019\uffff"+
		"\uffff\u0000\u0284\u0288\u0005\u0017\u0000\u0000\u0285\u0286\u0003(\u0014"+
		"\u0000\u0286\u0287\u0006\u0019\uffff\uffff\u0000\u0287\u0289\u0001\u0000"+
		"\u0000\u0000\u0288\u0285\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000"+
		"\u0000\u0000\u0289\u028a\u0001\u0000\u0000\u0000\u028a\u028b\u0005\u0018"+
		"\u0000\u0000\u028b\u028d\u0006\u0019\uffff\uffff\u0000\u028c\u0278\u0001"+
		"\u0000\u0000\u0000\u028c\u0282\u0001\u0000\u0000\u0000\u028d\u0290\u0001"+
		"\u0000\u0000\u0000\u028e\u028c\u0001\u0000\u0000\u0000\u028e\u028f\u0001"+
		"\u0000\u0000\u0000\u028f3\u0001\u0000\u0000\u0000\u0290\u028e\u0001\u0000"+
		"\u0000\u0000\u0291\u0292\u0003\n\u0005\u0000\u0292\u0293\u0006\u001a\uffff"+
		"\uffff\u0000\u0293\u029d\u0001\u0000\u0000\u0000\u0294\u0295\u0005\u001b"+
		"\u0000\u0000\u0295\u0297\u00036\u001b\u0000\u0296\u0298\u00054\u0000\u0000"+
		"\u0297\u0296\u0001\u0000\u0000\u0000\u0297\u0298\u0001\u0000\u0000\u0000"+
		"\u0298\u0299\u0001\u0000\u0000\u0000\u0299\u029a\u0005\u001c\u0000\u0000"+
		"\u029a\u029b\u0006\u001a\uffff\uffff\u0000\u029b\u029d\u0001\u0000\u0000"+
		"\u0000\u029c\u0291\u0001\u0000\u0000\u0000\u029c\u0294\u0001\u0000\u0000"+
		"\u0000\u029d5\u0001\u0000\u0000\u0000\u029e\u02a2\u0006\u001b\uffff\uffff"+
		"\u0000\u029f\u02a0\u00038\u001c\u0000\u02a0\u02a1\u0006\u001b\uffff\uffff"+
		"\u0000\u02a1\u02a3\u0001\u0000\u0000\u0000\u02a2\u029f\u0001\u0000\u0000"+
		"\u0000\u02a2\u02a3\u0001\u0000\u0000\u0000\u02a3\u02a4\u0001\u0000\u0000"+
		"\u0000\u02a4\u02a5\u00034\u001a\u0000\u02a5\u02b2\u0006\u001b\uffff\uffff"+
		"\u0000\u02a6\u02a7\u0006\u001b\uffff\uffff\u0000\u02a7\u02ab\u00054\u0000"+
		"\u0000\u02a8\u02a9\u00038\u001c\u0000\u02a9\u02aa\u0006\u001b\uffff\uffff"+
		"\u0000\u02aa\u02ac\u0001\u0000\u0000\u0000\u02ab\u02a8\u0001\u0000\u0000"+
		"\u0000\u02ab\u02ac\u0001\u0000\u0000\u0000\u02ac\u02ad\u0001\u0000\u0000"+
		"\u0000\u02ad\u02ae\u00034\u001a\u0000\u02ae\u02af\u0006\u001b\uffff\uffff"+
		"\u0000\u02af\u02b1\u0001\u0000\u0000\u0000\u02b0\u02a6\u0001\u0000\u0000"+
		"\u0000\u02b1\u02b4\u0001\u0000\u0000\u0000\u02b2\u02b0\u0001\u0000\u0000"+
		"\u0000\u02b2\u02b3\u0001\u0000\u0000\u0000\u02b37\u0001\u0000\u0000\u0000"+
		"\u02b4\u02b2\u0001\u0000\u0000\u0000\u02b5\u02b9\u0006\u001c\uffff\uffff"+
		"\u0000\u02b6\u02b7\u0003:\u001d\u0000\u02b7\u02b8\u0006\u001c\uffff\uffff"+
		"\u0000\u02b8\u02ba\u0001\u0000\u0000\u0000\u02b9\u02b6\u0001\u0000\u0000"+
		"\u0000\u02ba\u02bb\u0001\u0000\u0000\u0000\u02bb\u02b9\u0001\u0000\u0000"+
		"\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001\u0000\u0000"+
		"\u0000\u02bd\u02be\u00055\u0000\u0000\u02be9\u0001\u0000\u0000\u0000\u02bf"+
		"\u02c0\u0005\u0019\u0000\u0000\u02c0\u02c1\u0003\n\u0005\u0000\u02c1\u02c2"+
		"\u0005\u001a\u0000\u0000\u02c2\u02c3\u0006\u001d\uffff\uffff\u0000\u02c3"+
		"\u02c8\u0001\u0000\u0000\u0000\u02c4\u02c5\u0005C\u0000\u0000\u02c5\u02c6"+
		"\u0005D\u0000\u0000\u02c6\u02c8\u0006\u001d\uffff\uffff\u0000\u02c7\u02bf"+
		"\u0001\u0000\u0000\u0000\u02c7\u02c4\u0001\u0000\u0000\u0000\u02c8;\u0001"+
		"\u0000\u0000\u0000\u02c9\u02ca\u0003>\u001f\u0000\u02ca\u02cb\u0006\u001e"+
		"\uffff\uffff\u0000\u02cb\u02d9\u0001\u0000\u0000\u0000\u02cc\u02cd\u0003"+
		"B!\u0000\u02cd\u02ce\u0006\u001e\uffff\uffff\u0000\u02ce\u02d9\u0001\u0000"+
		"\u0000\u0000\u02cf\u02d0\u0003D\"\u0000\u02d0\u02d1\u0006\u001e\uffff"+
		"\uffff\u0000\u02d1\u02d9\u0001\u0000\u0000\u0000\u02d2\u02d3\u0003F#\u0000"+
		"\u02d3\u02d4\u0006\u001e\uffff\uffff\u0000\u02d4\u02d9\u0001\u0000\u0000"+
		"\u0000\u02d5\u02d6\u0003N\'\u0000\u02d6\u02d7\u0006\u001e\uffff\uffff"+
		"\u0000\u02d7\u02d9\u0001\u0000\u0000\u0000\u02d8\u02c9\u0001\u0000\u0000"+
		"\u0000\u02d8\u02cc\u0001\u0000\u0000\u0000\u02d8\u02cf\u0001\u0000\u0000"+
		"\u0000\u02d8\u02d2\u0001\u0000\u0000\u0000\u02d8\u02d5\u0001\u0000\u0000"+
		"\u0000\u02d9=\u0001\u0000\u0000\u0000\u02da\u02db\u0006\u001f\uffff\uffff"+
		"\u0000\u02db\u02e3\u0005\u001b\u0000\u0000\u02dc\u02dd\u0003@ \u0000\u02dd"+
		"\u02de\u0006\u001f\uffff\uffff\u0000\u02de\u02e0\u0001\u0000\u0000\u0000"+
		"\u02df\u02dc\u0001\u0000\u0000\u0000\u02e0\u02e1\u0001\u0000\u0000\u0000"+
		"\u02e1\u02df\u0001\u0000\u0000\u0000\u02e1\u02e2\u0001\u0000\u0000\u0000"+
		"\u02e2\u02e4\u0001\u0000\u0000\u0000\u02e3\u02df\u0001\u0000\u0000\u0000"+
		"\u02e3\u02e4\u0001\u0000\u0000\u0000\u02e4\u02e5\u0001\u0000\u0000\u0000"+
		"\u02e5\u02e6\u0005\u001c\u0000\u0000\u02e6\u02e7\u0006\u001f\uffff\uffff"+
		"\u0000\u02e7?\u0001\u0000\u0000\u0000\u02e8\u02e9\u0003<\u001e\u0000\u02e9"+
		"\u02ea\u0006 \uffff\uffff\u0000\u02ea\u02ef\u0001\u0000\u0000\u0000\u02eb"+
		"\u02ec\u0003\u0014\n\u0000\u02ec\u02ed\u0006 \uffff\uffff\u0000\u02ed"+
		"\u02ef\u0001\u0000\u0000\u0000\u02ee\u02e8\u0001\u0000\u0000\u0000\u02ee"+
		"\u02eb\u0001\u0000\u0000\u0000\u02efA\u0001\u0000\u0000\u0000\u02f0\u02f4"+
		"\u0006!\uffff\uffff\u0000\u02f1\u02f2\u0003\n\u0005\u0000\u02f2\u02f3"+
		"\u0006!\uffff\uffff\u0000\u02f3\u02f5\u0001\u0000\u0000\u0000\u02f4\u02f1"+
		"\u0001\u0000\u0000\u0000\u02f4\u02f5\u0001\u0000\u0000\u0000\u02f5\u02f6"+
		"\u0001\u0000\u0000\u0000\u02f6\u02f7\u00053\u0000\u0000\u02f7\u02f8\u0006"+
		"!\uffff\uffff\u0000\u02f8C\u0001\u0000\u0000\u0000\u02f9\u02fa\u0005\n"+
		"\u0000\u0000\u02fa\u02fb\u0005\u0017\u0000\u0000\u02fb\u02fc\u0003\n\u0005"+
		"\u0000\u02fc\u02fd\u0005\u0018\u0000\u0000\u02fd\u02fe\u0003<\u001e\u0000"+
		"\u02fe\u0303\u0006\"\uffff\uffff\u0000\u02ff\u0300\u0005\u0007\u0000\u0000"+
		"\u0300\u0301\u0003<\u001e\u0000\u0301\u0302\u0006\"\uffff\uffff\u0000"+
		"\u0302\u0304\u0001\u0000\u0000\u0000\u0303\u02ff\u0001\u0000\u0000\u0000"+
		"\u0303\u0304\u0001\u0000\u0000\u0000\u0304E\u0001\u0000\u0000\u0000\u0305"+
		"\u0306\u0005\u0015\u0000\u0000\u0306\u0307\u0005\u0017\u0000\u0000\u0307"+
		"\u0308\u0003\n\u0005\u0000\u0308\u0309\u0005\u0018\u0000\u0000\u0309\u030a"+
		"\u0003<\u001e\u0000\u030a\u030b\u0006#\uffff\uffff\u0000\u030b\u031d\u0001"+
		"\u0000\u0000\u0000\u030c\u030d\u0005\u0005\u0000\u0000\u030d\u030e\u0003"+
		"<\u001e\u0000\u030e\u030f\u0005\u0015\u0000\u0000\u030f\u0310\u0005\u0017"+
		"\u0000\u0000\u0310\u0311\u0003\n\u0005\u0000\u0311\u0312\u0005\u0018\u0000"+
		"\u0000\u0312\u0313\u00053\u0000\u0000\u0313\u0314\u0006#\uffff\uffff\u0000"+
		"\u0314\u031d\u0001\u0000\u0000\u0000\u0315\u0316\u0005\t\u0000\u0000\u0316"+
		"\u0317\u0005\u0017\u0000\u0000\u0317\u0318\u0003H$\u0000\u0318\u0319\u0005"+
		"\u0018\u0000\u0000\u0319\u031a\u0003<\u001e\u0000\u031a\u031b\u0006#\uffff"+
		"\uffff\u0000\u031b\u031d\u0001\u0000\u0000\u0000\u031c\u0305\u0001\u0000"+
		"\u0000\u0000\u031c\u030c\u0001\u0000\u0000\u0000\u031c\u0315\u0001\u0000"+
		"\u0000\u0000\u031dG\u0001\u0000\u0000\u0000\u031e\u0327\u0006$\uffff\uffff"+
		"\u0000\u031f\u0320\u0003J%\u0000\u0320\u0321\u0006$\uffff\uffff\u0000"+
		"\u0321\u0328\u0001\u0000\u0000\u0000\u0322\u0323\u0003\n\u0005\u0000\u0323"+
		"\u0324\u0006$\uffff\uffff\u0000\u0324\u0326\u0001\u0000\u0000\u0000\u0325"+
		"\u0322\u0001\u0000\u0000\u0000\u0325\u0326\u0001\u0000\u0000\u0000\u0326"+
		"\u0328\u0001\u0000\u0000\u0000\u0327\u031f\u0001\u0000\u0000\u0000\u0327"+
		"\u0325\u0001\u0000\u0000\u0000\u0328\u0329\u0001\u0000\u0000\u0000\u0329"+
		"\u032d\u00053\u0000\u0000\u032a\u032b\u0003L&\u0000\u032b\u032c\u0006"+
		"$\uffff\uffff\u0000\u032c\u032e\u0001\u0000\u0000\u0000\u032d\u032a\u0001"+
		"\u0000\u0000\u0000\u032d\u032e\u0001\u0000\u0000\u0000\u032e\u032f\u0001"+
		"\u0000\u0000\u0000\u032f\u0333\u00053\u0000\u0000\u0330\u0331\u0003L&"+
		"\u0000\u0331\u0332\u0006$\uffff\uffff\u0000\u0332\u0334\u0001\u0000\u0000"+
		"\u0000\u0333\u0330\u0001\u0000\u0000\u0000\u0333\u0334\u0001\u0000\u0000"+
		"\u0000\u0334I\u0001\u0000\u0000\u0000\u0335\u0336\u0003\u0016\u000b\u0000"+
		"\u0336\u033a\u0006%\uffff\uffff\u0000\u0337\u0338\u0003\u001a\r\u0000"+
		"\u0338\u0339\u0006%\uffff\uffff\u0000\u0339\u033b\u0001\u0000\u0000\u0000"+
		"\u033a\u0337\u0001\u0000\u0000\u0000\u033a\u033b\u0001\u0000\u0000\u0000"+
		"\u033bK\u0001\u0000\u0000\u0000\u033c\u033d\u0006&\uffff\uffff\u0000\u033d"+
		"\u033e\u0003\n\u0005\u0000\u033e\u0345\u0006&\uffff\uffff\u0000\u033f"+
		"\u0340\u00054\u0000\u0000\u0340\u0341\u0003\n\u0005\u0000\u0341\u0342"+
		"\u0006&\uffff\uffff\u0000\u0342\u0344\u0001\u0000\u0000\u0000\u0343\u033f"+
		"\u0001\u0000\u0000\u0000\u0344\u0347\u0001\u0000\u0000\u0000\u0345\u0343"+
		"\u0001\u0000\u0000\u0000\u0345\u0346\u0001\u0000\u0000\u0000\u0346M\u0001"+
		"\u0000\u0000\u0000\u0347\u0345\u0001\u0000\u0000\u0000\u0348\u0349\u0005"+
		"\u0004\u0000\u0000\u0349\u0354\u0006\'\uffff\uffff\u0000\u034a\u034b\u0005"+
		"\u0001\u0000\u0000\u034b\u0354\u0006\'\uffff\uffff\u0000\u034c\u034d\u0005"+
		"\r\u0000\u0000\u034d\u0351\u0006\'\uffff\uffff\u0000\u034e\u034f\u0003"+
		"\n\u0005\u0000\u034f\u0350\u0006\'\uffff\uffff\u0000\u0350\u0352\u0001"+
		"\u0000\u0000\u0000\u0351\u034e\u0001\u0000\u0000\u0000\u0351\u0352\u0001"+
		"\u0000\u0000\u0000\u0352\u0354\u0001\u0000\u0000\u0000\u0353\u0348\u0001"+
		"\u0000\u0000\u0000\u0353\u034a\u0001\u0000\u0000\u0000\u0353\u034c\u0001"+
		"\u0000\u0000\u0000\u0354\u0355\u0001\u0000\u0000\u0000\u0355\u0356\u0005"+
		"3\u0000\u0000\u0356O\u0001\u0000\u0000\u0000QS]fls~\u008a\u0097\u00a3"+
		"\u00a5\u00b1\u00be\u00cd\u00d6\u00e0\u00eb\u00f6\u0105\u0110\u0147\u0150"+
		"\u0152\u015e\u016d\u017a\u0192\u0199\u01a3\u01ac\u01b7\u01c0\u01d8\u01e0"+
		"\u01e5\u01eb\u01f8\u0200\u020c\u020e\u0211\u0213\u021d\u021f\u0223\u022e"+
		"\u0239\u023b\u0245\u024d\u0257\u025c\u0264\u0270\u0272\u0276\u027e\u0288"+
		"\u028c\u028e\u0297\u029c\u02a2\u02ab\u02b2\u02bb\u02c7\u02d8\u02e1\u02e3"+
		"\u02ee\u02f4\u0303\u031c\u0325\u0327\u032d\u0333\u033a\u0345\u0351\u0353";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}