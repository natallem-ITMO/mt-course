// Generated from /data/Projects/GitProjects/mt-course/lab4_try2/src/main/java/antlr/GrammarForGrammar.g4 by ANTLR 4.9
package grammar.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarForGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TERMINAL=12, NOT_TERMINAL=13, ANY_NAME=14, NAME=15, 
		WS=16, NL=17, ANY_CODE=18;
	public static final int
		RULE_grammar_file = 0, RULE_grammar_rule = 1, RULE_non_term_rule = 2, 
		RULE_non_term_right_part = 3, RULE_term_rule = 4, RULE_synth_attr_desc = 5, 
		RULE_inherit_attr_desc = 6, RULE_non_terminal = 7, RULE_terminal = 8, 
		RULE_non_term_description = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"grammar_file", "grammar_rule", "non_term_rule", "non_term_right_part", 
			"term_rule", "synth_attr_desc", "inherit_attr_desc", "non_terminal", 
			"terminal", "non_term_description"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'->'", "'#'", "'skip'", "'['", "'return'", "';'", "']'", "'[['", 
			"']]'", "'='", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"TERMINAL", "NOT_TERMINAL", "ANY_NAME", "NAME", "WS", "NL", "ANY_CODE"
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
	public String getGrammarFileName() { return "GrammarForGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarForGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Grammar_fileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarForGrammarParser.EOF, 0); }
		public List<Grammar_ruleContext> grammar_rule() {
			return getRuleContexts(Grammar_ruleContext.class);
		}
		public Grammar_ruleContext grammar_rule(int i) {
			return getRuleContext(Grammar_ruleContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(GrammarForGrammarParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(GrammarForGrammarParser.NL, i);
		}
		public Grammar_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammar_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterGrammar_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitGrammar_file(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitGrammar_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Grammar_fileContext grammar_file() throws RecognitionException {
		Grammar_fileContext _localctx = new Grammar_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_grammar_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(24);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TERMINAL:
				case NOT_TERMINAL:
				case NAME:
					{
					setState(20);
					grammar_rule();
					setState(21);
					match(NL);
					}
					break;
				case NL:
					{
					setState(23);
					match(NL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERMINAL) | (1L << NOT_TERMINAL) | (1L << NAME) | (1L << NL))) != 0) );
			setState(28);
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

	public static class Grammar_ruleContext extends ParserRuleContext {
		public Non_term_ruleContext non_term_rule() {
			return getRuleContext(Non_term_ruleContext.class,0);
		}
		public Term_ruleContext term_rule() {
			return getRuleContext(Term_ruleContext.class,0);
		}
		public Non_term_descriptionContext non_term_description() {
			return getRuleContext(Non_term_descriptionContext.class,0);
		}
		public Grammar_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammar_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterGrammar_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitGrammar_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitGrammar_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Grammar_ruleContext grammar_rule() throws RecognitionException {
		Grammar_ruleContext _localctx = new Grammar_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammar_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(30);
				non_term_rule();
				}
				break;
			case 2:
				{
				setState(31);
				term_rule();
				}
				break;
			case 3:
				{
				setState(32);
				non_term_description();
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

	public static class Non_term_ruleContext extends ParserRuleContext {
		public Non_terminalContext non_terminal() {
			return getRuleContext(Non_terminalContext.class,0);
		}
		public List<Non_term_right_partContext> non_term_right_part() {
			return getRuleContexts(Non_term_right_partContext.class);
		}
		public Non_term_right_partContext non_term_right_part(int i) {
			return getRuleContext(Non_term_right_partContext.class,i);
		}
		public Non_term_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_term_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterNon_term_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitNon_term_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitNon_term_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_term_ruleContext non_term_rule() throws RecognitionException {
		Non_term_ruleContext _localctx = new Non_term_ruleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_non_term_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			non_terminal();
			setState(36);
			match(T__0);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				non_term_right_part();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << TERMINAL) | (1L << NOT_TERMINAL) | (1L << NAME) | (1L << ANY_CODE))) != 0) );
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

	public static class Non_term_right_partContext extends ParserRuleContext {
		public Non_term_right_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_term_right_part; }
	 
		public Non_term_right_partContext() { }
		public void copyFrom(Non_term_right_partContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TerminalRuleContext extends Non_term_right_partContext {
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public TerminalRuleContext(Non_term_right_partContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterTerminalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitTerminalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitTerminalRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NonTerminalRuleContext extends Non_term_right_partContext {
		public Non_terminalContext non_terminal() {
			return getRuleContext(Non_terminalContext.class,0);
		}
		public NonTerminalRuleContext(Non_term_right_partContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterNonTerminalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitNonTerminalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitNonTerminalRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeRuleContext extends Non_term_right_partContext {
		public TerminalNode ANY_CODE() { return getToken(GrammarForGrammarParser.ANY_CODE, 0); }
		public AttributeRuleContext(Non_term_right_partContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterAttributeRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitAttributeRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitAttributeRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_term_right_partContext non_term_right_part() throws RecognitionException {
		Non_term_right_partContext _localctx = new Non_term_right_partContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_non_term_right_part);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new TerminalRuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				terminal();
				}
				break;
			case 2:
				_localctx = new NonTerminalRuleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				non_terminal();
				}
				break;
			case 3:
				_localctx = new AttributeRuleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				match(ANY_CODE);
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

	public static class Term_ruleContext extends ParserRuleContext {
		public TerminalNode TERMINAL() { return getToken(GrammarForGrammarParser.TERMINAL, 0); }
		public TerminalNode ANY_CODE() { return getToken(GrammarForGrammarParser.ANY_CODE, 0); }
		public Term_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterTerm_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitTerm_rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitTerm_rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term_ruleContext term_rule() throws RecognitionException {
		Term_ruleContext _localctx = new Term_ruleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(TERMINAL);
			setState(48);
			match(T__0);
			setState(49);
			match(ANY_CODE);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(50);
				match(T__1);
				setState(51);
				match(T__2);
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

	public static class Synth_attr_descContext extends ParserRuleContext {
		public List<TerminalNode> TERMINAL() { return getTokens(GrammarForGrammarParser.TERMINAL); }
		public TerminalNode TERMINAL(int i) {
			return getToken(GrammarForGrammarParser.TERMINAL, i);
		}
		public List<TerminalNode> NOT_TERMINAL() { return getTokens(GrammarForGrammarParser.NOT_TERMINAL); }
		public TerminalNode NOT_TERMINAL(int i) {
			return getToken(GrammarForGrammarParser.NOT_TERMINAL, i);
		}
		public List<TerminalNode> ANY_NAME() { return getTokens(GrammarForGrammarParser.ANY_NAME); }
		public TerminalNode ANY_NAME(int i) {
			return getToken(GrammarForGrammarParser.ANY_NAME, i);
		}
		public Synth_attr_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synth_attr_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterSynth_attr_desc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitSynth_attr_desc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitSynth_attr_desc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Synth_attr_descContext synth_attr_desc() throws RecognitionException {
		Synth_attr_descContext _localctx = new Synth_attr_descContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_synth_attr_desc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__3);
			setState(55);
			match(T__4);
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERMINAL) | (1L << NOT_TERMINAL) | (1L << ANY_NAME))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(57);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERMINAL) | (1L << NOT_TERMINAL) | (1L << ANY_NAME))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(58);
				match(T__5);
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERMINAL) | (1L << NOT_TERMINAL) | (1L << ANY_NAME))) != 0) );
			setState(63);
			match(T__6);
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

	public static class Inherit_attr_descContext extends ParserRuleContext {
		public List<TerminalNode> TERMINAL() { return getTokens(GrammarForGrammarParser.TERMINAL); }
		public TerminalNode TERMINAL(int i) {
			return getToken(GrammarForGrammarParser.TERMINAL, i);
		}
		public List<TerminalNode> NOT_TERMINAL() { return getTokens(GrammarForGrammarParser.NOT_TERMINAL); }
		public TerminalNode NOT_TERMINAL(int i) {
			return getToken(GrammarForGrammarParser.NOT_TERMINAL, i);
		}
		public List<TerminalNode> ANY_NAME() { return getTokens(GrammarForGrammarParser.ANY_NAME); }
		public TerminalNode ANY_NAME(int i) {
			return getToken(GrammarForGrammarParser.ANY_NAME, i);
		}
		public Inherit_attr_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inherit_attr_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterInherit_attr_desc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitInherit_attr_desc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitInherit_attr_desc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inherit_attr_descContext inherit_attr_desc() throws RecognitionException {
		Inherit_attr_descContext _localctx = new Inherit_attr_descContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inherit_attr_desc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__7);
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERMINAL) | (1L << NOT_TERMINAL) | (1L << ANY_NAME))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(67);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERMINAL) | (1L << NOT_TERMINAL) | (1L << ANY_NAME))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(68);
				match(T__5);
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TERMINAL) | (1L << NOT_TERMINAL) | (1L << ANY_NAME))) != 0) );
			setState(73);
			match(T__8);
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

	public static class Non_terminalContext extends ParserRuleContext {
		public Non_terminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_terminal; }
	 
		public Non_terminalContext() { }
		public void copyFrom(Non_terminalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Assignment_non_terminalContext extends Non_terminalContext {
		public TerminalNode NAME() { return getToken(GrammarForGrammarParser.NAME, 0); }
		public TerminalNode NOT_TERMINAL() { return getToken(GrammarForGrammarParser.NOT_TERMINAL, 0); }
		public Assignment_non_terminalContext(Non_terminalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterAssignment_non_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitAssignment_non_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitAssignment_non_terminal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Simple_non_terminalContext extends Non_terminalContext {
		public TerminalNode NOT_TERMINAL() { return getToken(GrammarForGrammarParser.NOT_TERMINAL, 0); }
		public Simple_non_terminalContext(Non_terminalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterSimple_non_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitSimple_non_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitSimple_non_terminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_terminalContext non_terminal() throws RecognitionException {
		Non_terminalContext _localctx = new Non_terminalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_non_terminal);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT_TERMINAL:
				_localctx = new Simple_non_terminalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(NOT_TERMINAL);
				}
				break;
			case NAME:
				_localctx = new Assignment_non_terminalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(NAME);
				setState(77);
				match(T__9);
				setState(78);
				match(NOT_TERMINAL);
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

	public static class TerminalContext extends ParserRuleContext {
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
	 
		public TerminalContext() { }
		public void copyFrom(TerminalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EpsilonContext extends TerminalContext {
		public EpsilonContext(TerminalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterEpsilon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitEpsilon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitEpsilon(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Simple_terminalContext extends TerminalContext {
		public TerminalNode TERMINAL() { return getToken(GrammarForGrammarParser.TERMINAL, 0); }
		public Simple_terminalContext(TerminalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterSimple_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitSimple_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitSimple_terminal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assignment_terminalContext extends TerminalContext {
		public TerminalNode NAME() { return getToken(GrammarForGrammarParser.NAME, 0); }
		public TerminalNode TERMINAL() { return getToken(GrammarForGrammarParser.TERMINAL, 0); }
		public Assignment_terminalContext(TerminalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterAssignment_terminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitAssignment_terminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitAssignment_terminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_terminal);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				_localctx = new Assignment_terminalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(NAME);
				setState(82);
				match(T__9);
				setState(83);
				match(TERMINAL);
				}
				break;
			case TERMINAL:
				_localctx = new Simple_terminalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(TERMINAL);
				}
				break;
			case T__10:
				_localctx = new EpsilonContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				match(T__10);
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

	public static class Non_term_descriptionContext extends ParserRuleContext {
		public TerminalNode NOT_TERMINAL() { return getToken(GrammarForGrammarParser.NOT_TERMINAL, 0); }
		public Synth_attr_descContext synth_attr_desc() {
			return getRuleContext(Synth_attr_descContext.class,0);
		}
		public Inherit_attr_descContext inherit_attr_desc() {
			return getRuleContext(Inherit_attr_descContext.class,0);
		}
		public Non_term_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_term_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).enterNon_term_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarForGrammarListener ) ((GrammarForGrammarListener)listener).exitNon_term_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarForGrammarVisitor ) return ((GrammarForGrammarVisitor<? extends T>)visitor).visitNon_term_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_term_descriptionContext non_term_description() throws RecognitionException {
		Non_term_descriptionContext _localctx = new Non_term_descriptionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_non_term_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(NOT_TERMINAL);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(89);
				synth_attr_desc();
				}
			}

			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(92);
				inherit_attr_desc();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24b\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\2\6\2\33\n\2\r\2\16\2\34\3\2\3\2\3\3\3\3\3\3\5\3$\n\3\3\4"+
		"\3\4\3\4\6\4)\n\4\r\4\16\4*\3\5\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\5\6\67\n\6\3\7\3\7\3\7\3\7\3\7\6\7>\n\7\r\7\16\7?\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\6\bH\n\b\r\b\16\bI\3\b\3\b\3\t\3\t\3\t\3\t\5\tR\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\5\nY\n\n\3\13\3\13\5\13]\n\13\3\13\5\13`\n\13\3\13\2\2\f\2\4\6"+
		"\b\n\f\16\20\22\24\2\3\3\2\16\20\2f\2\32\3\2\2\2\4#\3\2\2\2\6%\3\2\2\2"+
		"\b/\3\2\2\2\n\61\3\2\2\2\f8\3\2\2\2\16C\3\2\2\2\20Q\3\2\2\2\22X\3\2\2"+
		"\2\24Z\3\2\2\2\26\27\5\4\3\2\27\30\7\23\2\2\30\33\3\2\2\2\31\33\7\23\2"+
		"\2\32\26\3\2\2\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2"+
		"\2\35\36\3\2\2\2\36\37\7\2\2\3\37\3\3\2\2\2 $\5\6\4\2!$\5\n\6\2\"$\5\24"+
		"\13\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2%&\5\20\t\2&(\7\3\2\2\'"+
		")\5\b\5\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\7\3\2\2\2,\60\5\22"+
		"\n\2-\60\5\20\t\2.\60\7\24\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\t\3\2"+
		"\2\2\61\62\7\16\2\2\62\63\7\3\2\2\63\66\7\24\2\2\64\65\7\4\2\2\65\67\7"+
		"\5\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\13\3\2\2\289\7\6\2\29=\7\7\2\2:"+
		";\t\2\2\2;<\t\2\2\2<>\7\b\2\2=:\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2"+
		"@A\3\2\2\2AB\7\t\2\2B\r\3\2\2\2CG\7\n\2\2DE\t\2\2\2EF\t\2\2\2FH\7\b\2"+
		"\2GD\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\13\2\2L\17\3"+
		"\2\2\2MR\7\17\2\2NO\7\21\2\2OP\7\f\2\2PR\7\17\2\2QM\3\2\2\2QN\3\2\2\2"+
		"R\21\3\2\2\2ST\7\21\2\2TU\7\f\2\2UY\7\16\2\2VY\7\16\2\2WY\7\r\2\2XS\3"+
		"\2\2\2XV\3\2\2\2XW\3\2\2\2Y\23\3\2\2\2Z\\\7\17\2\2[]\5\f\7\2\\[\3\2\2"+
		"\2\\]\3\2\2\2]_\3\2\2\2^`\5\16\b\2_^\3\2\2\2_`\3\2\2\2`\25\3\2\2\2\16"+
		"\32\34#*/\66?IQX\\_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}