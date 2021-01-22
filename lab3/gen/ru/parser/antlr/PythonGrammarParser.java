// Generated from B:/Projects/GitProjects/mt-course/lab3/src/main/java/antlr\PythonGrammar.g4 by ANTLR 4.9
package ru.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PythonGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, MUL=6, DIV=7, ADD=8, SUB=9, NEQ=10, 
		GTE=11, LTE=12, GT=13, LT=14, DEQ=15, EQ=16, AND=17, OR=18, NOT=19, FOR=20, 
		WHILE=21, IF=22, ELSE=23, TRUE=24, FALSE=25, ID=26, NUMBER=27, COMMA=28, 
		LPAREN=29, RPAREN=30, COLON=31, NEWLINE=32, SKIP_=33, INDENT=34, DEDENT=35;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_simple_stmt = 2, RULE_compound_stmt = 3, 
		RULE_if_stmt = 4, RULE_while_stmt = 5, RULE_for_stmt = 6, RULE_range_list = 7, 
		RULE_suite = 8, RULE_command = 9, RULE_print_command = 10, RULE_read_command = 11, 
		RULE_assignment = 12, RULE_arithm_expr = 13, RULE_condition = 14, RULE_name = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "simple_stmt", "compound_stmt", "if_stmt", "while_stmt", 
			"for_stmt", "range_list", "suite", "command", "print_command", "read_command", 
			"assignment", "arithm_expr", "condition", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'in'", "'range'", "'print'", "'int'", "'input'", "'*'", "'/'", 
			"'+'", "'-'", "'!='", "'>='", "'<='", "'>'", "'<'", "'=='", "'='", "'and'", 
			"'or'", "'not'", "'for'", "'while'", "'if'", "'else'", "'True'", "'False'", 
			null, null, "','", "'('", "')'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", "NEQ", 
			"GTE", "LTE", "GT", "LT", "DEQ", "EQ", "AND", "OR", "NOT", "FOR", "WHILE", 
			"IF", "ELSE", "TRUE", "FALSE", "ID", "NUMBER", "COMMA", "LPAREN", "RPAREN", 
			"COLON", "NEWLINE", "SKIP_", "INDENT", "DEDENT"
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
	public String getGrammarFileName() { return "PythonGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PythonGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PythonGrammarParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(PythonGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PythonGrammarParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << ID) | (1L << NUMBER) | (1L << LPAREN) | (1L << NEWLINE))) != 0)) {
				{
				setState(34);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
				case FOR:
				case WHILE:
				case IF:
				case ID:
				case NUMBER:
				case LPAREN:
					{
					setState(32);
					stmt();
					}
					break;
				case NEWLINE:
					{
					setState(33);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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

	public static class StmtContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case ID:
			case NUMBER:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				simple_stmt();
				}
				break;
			case FOR:
			case WHILE:
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				compound_stmt();
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

	public static class Simple_stmtContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(PythonGrammarParser.NEWLINE, 0); }
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Arithm_exprContext arithm_expr() {
			return getRuleContext(Arithm_exprContext.class,0);
		}
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterSimple_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitSimple_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitSimple_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simple_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(45);
				command();
				}
				break;
			case 2:
				{
				setState(46);
				assignment();
				}
				break;
			case 3:
				{
				setState(47);
				arithm_expr(0);
				}
				break;
			}
			setState(50);
			match(NEWLINE);
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitCompound_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitCompound_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compound_stmt);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				while_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				for_stmt();
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PythonGrammarParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(PythonGrammarParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PythonGrammarParser.COLON, i);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PythonGrammarParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(IF);
			setState(58);
			condition(0);
			setState(59);
			match(COLON);
			setState(60);
			suite();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(61);
				match(ELSE);
				setState(62);
				match(COLON);
				setState(63);
				suite();
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

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PythonGrammarParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonGrammarParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(WHILE);
			setState(67);
			condition(0);
			setState(68);
			match(COLON);
			setState(69);
			suite();
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

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(PythonGrammarParser.FOR, 0); }
		public TerminalNode ID() { return getToken(PythonGrammarParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(PythonGrammarParser.LPAREN, 0); }
		public Range_listContext range_list() {
			return getRuleContext(Range_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PythonGrammarParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(PythonGrammarParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(FOR);
			setState(72);
			match(ID);
			setState(73);
			match(T__0);
			setState(74);
			match(T__1);
			setState(75);
			match(LPAREN);
			setState(76);
			range_list();
			setState(77);
			match(RPAREN);
			setState(78);
			match(COLON);
			setState(79);
			suite();
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

	public static class Range_listContext extends ParserRuleContext {
		public Range_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_list; }
	 
		public Range_listContext() { }
		public void copyFrom(Range_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RangeThreeNumbersContext extends Range_listContext {
		public List<TerminalNode> COMMA() { return getTokens(PythonGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonGrammarParser.COMMA, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(PythonGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(PythonGrammarParser.NUMBER, i);
		}
		public List<TerminalNode> ID() { return getTokens(PythonGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PythonGrammarParser.ID, i);
		}
		public RangeThreeNumbersContext(Range_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterRangeThreeNumbers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitRangeThreeNumbers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitRangeThreeNumbers(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RangeOneNumberContext extends Range_listContext {
		public TerminalNode NUMBER() { return getToken(PythonGrammarParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(PythonGrammarParser.ID, 0); }
		public RangeOneNumberContext(Range_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterRangeOneNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitRangeOneNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitRangeOneNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RangeTwoNumbersContext extends Range_listContext {
		public TerminalNode COMMA() { return getToken(PythonGrammarParser.COMMA, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(PythonGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(PythonGrammarParser.NUMBER, i);
		}
		public List<TerminalNode> ID() { return getTokens(PythonGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PythonGrammarParser.ID, i);
		}
		public RangeTwoNumbersContext(Range_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterRangeTwoNumbers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitRangeTwoNumbers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitRangeTwoNumbers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Range_listContext range_list() throws RecognitionException {
		Range_listContext _localctx = new Range_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_range_list);
		int _la;
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new RangeOneNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				_localctx = new RangeTwoNumbersContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(83);
				match(COMMA);
				setState(84);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new RangeThreeNumbersContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(86);
				match(COMMA);
				setState(87);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(88);
				match(COMMA);
				setState(89);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class SuiteContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PythonGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(PythonGrammarParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(PythonGrammarParser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_suite);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case ID:
			case NUMBER:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(NEWLINE);
				setState(94);
				match(INDENT);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					stmt();
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << ID) | (1L << NUMBER) | (1L << LPAREN))) != 0) );
				setState(100);
				match(DEDENT);
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

	public static class CommandContext extends ParserRuleContext {
		public Print_commandContext print_command() {
			return getRuleContext(Print_commandContext.class,0);
		}
		public Read_commandContext read_command() {
			return getRuleContext(Read_commandContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_command);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				print_command();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				read_command();
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

	public static class Print_commandContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(PythonGrammarParser.LPAREN, 0); }
		public Arithm_exprContext arithm_expr() {
			return getRuleContext(Arithm_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PythonGrammarParser.RPAREN, 0); }
		public Print_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterPrint_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitPrint_command(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitPrint_command(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_commandContext print_command() throws RecognitionException {
		Print_commandContext _localctx = new Print_commandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_print_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__2);
			setState(109);
			match(LPAREN);
			setState(110);
			arithm_expr(0);
			setState(111);
			match(RPAREN);
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

	public static class Read_commandContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(PythonGrammarParser.EQ, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(PythonGrammarParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PythonGrammarParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PythonGrammarParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PythonGrammarParser.RPAREN, i);
		}
		public Read_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterRead_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitRead_command(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitRead_command(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_commandContext read_command() throws RecognitionException {
		Read_commandContext _localctx = new Read_commandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_read_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			name();
			setState(114);
			match(EQ);
			setState(115);
			match(T__3);
			setState(116);
			match(LPAREN);
			setState(117);
			match(T__4);
			setState(118);
			match(LPAREN);
			setState(119);
			match(RPAREN);
			setState(120);
			match(RPAREN);
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

	public static class AssignmentContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(PythonGrammarParser.EQ, 0); }
		public Arithm_exprContext arithm_expr() {
			return getRuleContext(Arithm_exprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			name();
			setState(123);
			match(EQ);
			setState(124);
			arithm_expr(0);
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

	public static class Arithm_exprContext extends ParserRuleContext {
		public Arithm_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_expr; }
	 
		public Arithm_exprContext() { }
		public void copyFrom(Arithm_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryExpressionContext extends Arithm_exprContext {
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(PythonGrammarParser.ADD, 0); }
		public TerminalNode MUL() { return getToken(PythonGrammarParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PythonGrammarParser.DIV, 0); }
		public TerminalNode SUB() { return getToken(PythonGrammarParser.SUB, 0); }
		public BinaryExpressionContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExpressionContext extends Arithm_exprContext {
		public TerminalNode NUMBER() { return getToken(PythonGrammarParser.NUMBER, 0); }
		public NumberExpressionContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitNumberExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitNumberExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InBracketExpressionContext extends Arithm_exprContext {
		public TerminalNode LPAREN() { return getToken(PythonGrammarParser.LPAREN, 0); }
		public Arithm_exprContext arithm_expr() {
			return getRuleContext(Arithm_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PythonGrammarParser.RPAREN, 0); }
		public InBracketExpressionContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterInBracketExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitInBracketExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitInBracketExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableExpressionContext extends Arithm_exprContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public VariableExpressionContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithm_exprContext arithm_expr() throws RecognitionException {
		return arithm_expr(0);
	}

	private Arithm_exprContext arithm_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithm_exprContext _localctx = new Arithm_exprContext(_ctx, _parentState);
		Arithm_exprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_arithm_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(127);
				name();
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(NUMBER);
				}
				break;
			case LPAREN:
				{
				_localctx = new InBracketExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				{
				setState(129);
				match(LPAREN);
				setState(130);
				arithm_expr(0);
				setState(131);
				match(RPAREN);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryExpressionContext(new Arithm_exprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_arithm_expr);
					setState(135);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(136);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << ADD) | (1L << SUB))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(137);
					arithm_expr(3);
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryConditionContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PythonGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(PythonGrammarParser.OR, 0); }
		public BinaryConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterBinaryCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitBinaryCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitBinaryCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueConditionContext extends ConditionContext {
		public TerminalNode TRUE() { return getToken(PythonGrammarParser.TRUE, 0); }
		public TrueConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterTrueCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitTrueCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitTrueCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotConditionContext extends ConditionContext {
		public TerminalNode NOT() { return getToken(PythonGrammarParser.NOT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public NotConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterNotCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitNotCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitNotCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonConditionContext extends ConditionContext {
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public TerminalNode DEQ() { return getToken(PythonGrammarParser.DEQ, 0); }
		public TerminalNode NEQ() { return getToken(PythonGrammarParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(PythonGrammarParser.GT, 0); }
		public TerminalNode GTE() { return getToken(PythonGrammarParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(PythonGrammarParser.LTE, 0); }
		public TerminalNode LT() { return getToken(PythonGrammarParser.LT, 0); }
		public ComparisonConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterComparisonCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitComparisonCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitComparisonCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InBracketConditionContext extends ConditionContext {
		public TerminalNode LPAREN() { return getToken(PythonGrammarParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PythonGrammarParser.RPAREN, 0); }
		public InBracketConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterInBracketCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitInBracketCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitInBracketCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseConditionContext extends ConditionContext {
		public TerminalNode FALSE() { return getToken(PythonGrammarParser.FALSE, 0); }
		public FalseConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterFalseCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitFalseCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitFalseCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new TrueConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(144);
				match(TRUE);
				}
				break;
			case 2:
				{
				_localctx = new FalseConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(FALSE);
				}
				break;
			case 3:
				{
				_localctx = new NotConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				match(NOT);
				setState(147);
				condition(4);
				}
				break;
			case 4:
				{
				_localctx = new ComparisonConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				arithm_expr(0);
				setState(149);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEQ) | (1L << GTE) | (1L << LTE) | (1L << GT) | (1L << LT) | (1L << DEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(150);
				arithm_expr(0);
				}
				break;
			case 5:
				{
				_localctx = new InBracketConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(LPAREN);
				setState(153);
				condition(0);
				setState(154);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryConditionContext(new ConditionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(158);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(159);
					_la = _input.LA(1);
					if ( !(_la==AND || _la==OR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(160);
					condition(4);
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PythonGrammarParser.ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonGrammarListener ) ((PythonGrammarListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonGrammarVisitor ) return ((PythonGrammarVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(ID);
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
		case 13:
			return arithm_expr_sempred((Arithm_exprContext)_localctx, predIndex);
		case 14:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithm_expr_sempred(Arithm_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00ab\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\7"+
		"\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\5\4\63\n\4"+
		"\3\4\3\4\3\5\3\5\3\5\5\5:\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6C\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t]\n\t\3\n\3\n\3\n\3\n\6\nc\n\n\r\n\16\nd\3\n"+
		"\3\n\5\ni\n\n\3\13\3\13\5\13m\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u0088\n\17\3\17\3\17\3\17\7\17\u008d\n\17\f\17\16\17\u0090"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u009f\n\20\3\20\3\20\3\20\7\20\u00a4\n\20\f\20\16\20\u00a7\13\20"+
		"\3\21\3\21\3\21\2\4\34\36\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2"+
		"\6\3\2\34\35\3\2\b\13\3\2\f\21\3\2\23\24\2\u00af\2&\3\2\2\2\4-\3\2\2\2"+
		"\6\62\3\2\2\2\b9\3\2\2\2\n;\3\2\2\2\fD\3\2\2\2\16I\3\2\2\2\20\\\3\2\2"+
		"\2\22h\3\2\2\2\24l\3\2\2\2\26n\3\2\2\2\30s\3\2\2\2\32|\3\2\2\2\34\u0087"+
		"\3\2\2\2\36\u009e\3\2\2\2 \u00a8\3\2\2\2\"%\5\4\3\2#%\7\"\2\2$\"\3\2\2"+
		"\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)*\7\2"+
		"\2\3*\3\3\2\2\2+.\5\6\4\2,.\5\b\5\2-+\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\63"+
		"\5\24\13\2\60\63\5\32\16\2\61\63\5\34\17\2\62/\3\2\2\2\62\60\3\2\2\2\62"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\65\7\"\2\2\65\7\3\2\2\2\66:\5\n\6\2\67:\5"+
		"\f\7\28:\5\16\b\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\t\3\2\2\2;<\7\30"+
		"\2\2<=\5\36\20\2=>\7!\2\2>B\5\22\n\2?@\7\31\2\2@A\7!\2\2AC\5\22\n\2B?"+
		"\3\2\2\2BC\3\2\2\2C\13\3\2\2\2DE\7\27\2\2EF\5\36\20\2FG\7!\2\2GH\5\22"+
		"\n\2H\r\3\2\2\2IJ\7\26\2\2JK\7\34\2\2KL\7\3\2\2LM\7\4\2\2MN\7\37\2\2N"+
		"O\5\20\t\2OP\7 \2\2PQ\7!\2\2QR\5\22\n\2R\17\3\2\2\2S]\t\2\2\2TU\t\2\2"+
		"\2UV\7\36\2\2V]\t\2\2\2WX\t\2\2\2XY\7\36\2\2YZ\t\2\2\2Z[\7\36\2\2[]\t"+
		"\2\2\2\\S\3\2\2\2\\T\3\2\2\2\\W\3\2\2\2]\21\3\2\2\2^i\5\6\4\2_`\7\"\2"+
		"\2`b\7$\2\2ac\5\4\3\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2"+
		"\2fg\7%\2\2gi\3\2\2\2h^\3\2\2\2h_\3\2\2\2i\23\3\2\2\2jm\5\26\f\2km\5\30"+
		"\r\2lj\3\2\2\2lk\3\2\2\2m\25\3\2\2\2no\7\5\2\2op\7\37\2\2pq\5\34\17\2"+
		"qr\7 \2\2r\27\3\2\2\2st\5 \21\2tu\7\22\2\2uv\7\6\2\2vw\7\37\2\2wx\7\7"+
		"\2\2xy\7\37\2\2yz\7 \2\2z{\7 \2\2{\31\3\2\2\2|}\5 \21\2}~\7\22\2\2~\177"+
		"\5\34\17\2\177\33\3\2\2\2\u0080\u0081\b\17\1\2\u0081\u0088\5 \21\2\u0082"+
		"\u0088\7\35\2\2\u0083\u0084\7\37\2\2\u0084\u0085\5\34\17\2\u0085\u0086"+
		"\7 \2\2\u0086\u0088\3\2\2\2\u0087\u0080\3\2\2\2\u0087\u0082\3\2\2\2\u0087"+
		"\u0083\3\2\2\2\u0088\u008e\3\2\2\2\u0089\u008a\f\4\2\2\u008a\u008b\t\3"+
		"\2\2\u008b\u008d\5\34\17\5\u008c\u0089\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\35\3\2\2\2\u0090\u008e\3\2\2"+
		"\2\u0091\u0092\b\20\1\2\u0092\u009f\7\32\2\2\u0093\u009f\7\33\2\2\u0094"+
		"\u0095\7\25\2\2\u0095\u009f\5\36\20\6\u0096\u0097\5\34\17\2\u0097\u0098"+
		"\t\4\2\2\u0098\u0099\5\34\17\2\u0099\u009f\3\2\2\2\u009a\u009b\7\37\2"+
		"\2\u009b\u009c\5\36\20\2\u009c\u009d\7 \2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u0091\3\2\2\2\u009e\u0093\3\2\2\2\u009e\u0094\3\2\2\2\u009e\u0096\3\2"+
		"\2\2\u009e\u009a\3\2\2\2\u009f\u00a5\3\2\2\2\u00a0\u00a1\f\5\2\2\u00a1"+
		"\u00a2\t\5\2\2\u00a2\u00a4\5\36\20\6\u00a3\u00a0\3\2\2\2\u00a4\u00a7\3"+
		"\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\37\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00a9\7\34\2\2\u00a9!\3\2\2\2\20$&-\629B\\dhl\u0087"+
		"\u008e\u009e\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}