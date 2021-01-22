// Generated from B:/Projects/GitProjects/mt-course/lab3/src/main/java/antlr\PythonGrammar.g4 by ANTLR 4.9
package ru.parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PythonGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, MUL=6, DIV=7, ADD=8, SUB=9, NEQ=10, 
		GTE=11, LTE=12, GT=13, LT=14, DEQ=15, EQ=16, AND=17, OR=18, NOT=19, FOR=20, 
		WHILE=21, IF=22, ELSE=23, TRUE=24, FALSE=25, ID=26, NUMBER=27, COMMA=28, 
		LPAREN=29, RPAREN=30, COLON=31, NEWLINE=32, SKIP_=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "MUL", "DIV", "ADD", "SUB", "NEQ", 
			"GTE", "LTE", "GT", "LT", "DEQ", "EQ", "AND", "OR", "NOT", "FOR", "WHILE", 
			"IF", "ELSE", "TRUE", "FALSE", "ID", "NUMBER", "COMMA", "LPAREN", "RPAREN", 
			"COLON", "NEWLINE", "SPACES", "SKIP_"
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
			"COLON", "NEWLINE", "SKIP_"
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


	  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
	  private java.util.Stack<Integer> indents = new java.util.Stack<>();
	  private int opened = 0;
	  private Token lastToken = null;
	  @Override
	  public void emit(Token t) {
	    super.setToken(t);
	    tokens.offer(t);
	  }

	  @Override
	  public Token nextToken() {
	    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
	      for (int i = tokens.size() - 1; i >= 0; i--) {
	        if (tokens.get(i).getType() == EOF) {
	          tokens.remove(i);
	        }
	      }

	      this.emit(commonToken(PythonGrammarParser.NEWLINE, "\n"));

	      while (!indents.isEmpty()) {
	        this.emit(createDedent());
	        indents.pop();
	      }

	      this.emit(commonToken(PythonGrammarParser.EOF, "<EOF>"));
	    }

	    Token next = super.nextToken();

	    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
	      this.lastToken = next;
	    }

	    return tokens.isEmpty() ? next : tokens.poll();
	  }

	  private Token createDedent() {
	    CommonToken dedent = commonToken(PythonGrammarParser.DEDENT, "");
	    dedent.setLine(this.lastToken.getLine());
	    return dedent;
	  }

	  private CommonToken commonToken(int type, String text) {
	    int stop = this.getCharIndex() - 1;
	    int start = text.isEmpty() ? stop : stop - text.length() + 1;
	    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
	  }

	  static int getIndentationCount(String spaces) {
	    int count = 0;
	    for (char ch : spaces.toCharArray()) {
	      switch (ch) {
	        case '\t':
	          count += 8 - (count % 8);
	          break;
	        default:
	          count++;
	      }
	    }

	    return count;
	  }

	  boolean atStartOfInput() {
	    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
	  }


	public PythonGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PythonGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 31:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			     String newLine = getText().replaceAll("[^\r\n\f]+", "");
			     String spaces = getText().replaceAll("[\r\n\f]+", "");

			     int next = _input.LA(1);
			     int nextnext = _input.LA(2);
			     if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
			       skip();
			     }
			     else {
			       emit(commonToken(NEWLINE, newLine));
			       int indent = getIndentationCount(spaces);
			       int previous = indents.isEmpty() ? 0 : indents.peek();
			       if (indent == previous) {
			         skip();
			       }
			       else if (indent > previous) {
			         indents.push(indent);
			         emit(commonToken(PythonGrammarParser.INDENT, spaces));
			       }
			       else {
			         while(!indents.isEmpty() && indents.peek() > indent) {
			           this.emit(createDedent());
			           indents.pop();
			         }
			       }
			     }
			   
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 31:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00d9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\7\33\u00a5\n\33\f\33\16\33\u00a8\13\33\3\34"+
		"\6\34\u00ab\n\34\r\34\16\34\u00ac\3\34\3\34\6\34\u00b1\n\34\r\34\16\34"+
		"\u00b2\5\34\u00b5\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\5"+
		"!\u00c2\n!\3!\3!\5!\u00c6\n!\3!\5!\u00c9\n!\5!\u00cb\n!\3!\3!\3\"\6\""+
		"\u00d0\n\"\r\"\16\"\u00d1\3#\3#\5#\u00d6\n#\3#\3#\2\2$\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C\2E#\3\2"+
		"\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\13\13\"\"\2\u00e1\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5J\3\2\2\2\7P\3\2\2\2\tV"+
		"\3\2\2\2\13Z\3\2\2\2\r`\3\2\2\2\17b\3\2\2\2\21d\3\2\2\2\23f\3\2\2\2\25"+
		"h\3\2\2\2\27k\3\2\2\2\31n\3\2\2\2\33q\3\2\2\2\35s\3\2\2\2\37u\3\2\2\2"+
		"!x\3\2\2\2#z\3\2\2\2%~\3\2\2\2\'\u0081\3\2\2\2)\u0085\3\2\2\2+\u0089\3"+
		"\2\2\2-\u008f\3\2\2\2/\u0092\3\2\2\2\61\u0097\3\2\2\2\63\u009c\3\2\2\2"+
		"\65\u00a2\3\2\2\2\67\u00aa\3\2\2\29\u00b6\3\2\2\2;\u00b8\3\2\2\2=\u00ba"+
		"\3\2\2\2?\u00bc\3\2\2\2A\u00ca\3\2\2\2C\u00cf\3\2\2\2E\u00d5\3\2\2\2G"+
		"H\7k\2\2HI\7p\2\2I\4\3\2\2\2JK\7t\2\2KL\7c\2\2LM\7p\2\2MN\7i\2\2NO\7g"+
		"\2\2O\6\3\2\2\2PQ\7r\2\2QR\7t\2\2RS\7k\2\2ST\7p\2\2TU\7v\2\2U\b\3\2\2"+
		"\2VW\7k\2\2WX\7p\2\2XY\7v\2\2Y\n\3\2\2\2Z[\7k\2\2[\\\7p\2\2\\]\7r\2\2"+
		"]^\7w\2\2^_\7v\2\2_\f\3\2\2\2`a\7,\2\2a\16\3\2\2\2bc\7\61\2\2c\20\3\2"+
		"\2\2de\7-\2\2e\22\3\2\2\2fg\7/\2\2g\24\3\2\2\2hi\7#\2\2ij\7?\2\2j\26\3"+
		"\2\2\2kl\7@\2\2lm\7?\2\2m\30\3\2\2\2no\7>\2\2op\7?\2\2p\32\3\2\2\2qr\7"+
		"@\2\2r\34\3\2\2\2st\7>\2\2t\36\3\2\2\2uv\7?\2\2vw\7?\2\2w \3\2\2\2xy\7"+
		"?\2\2y\"\3\2\2\2z{\7c\2\2{|\7p\2\2|}\7f\2\2}$\3\2\2\2~\177\7q\2\2\177"+
		"\u0080\7t\2\2\u0080&\3\2\2\2\u0081\u0082\7p\2\2\u0082\u0083\7q\2\2\u0083"+
		"\u0084\7v\2\2\u0084(\3\2\2\2\u0085\u0086\7h\2\2\u0086\u0087\7q\2\2\u0087"+
		"\u0088\7t\2\2\u0088*\3\2\2\2\u0089\u008a\7y\2\2\u008a\u008b\7j\2\2\u008b"+
		"\u008c\7k\2\2\u008c\u008d\7n\2\2\u008d\u008e\7g\2\2\u008e,\3\2\2\2\u008f"+
		"\u0090\7k\2\2\u0090\u0091\7h\2\2\u0091.\3\2\2\2\u0092\u0093\7g\2\2\u0093"+
		"\u0094\7n\2\2\u0094\u0095\7u\2\2\u0095\u0096\7g\2\2\u0096\60\3\2\2\2\u0097"+
		"\u0098\7V\2\2\u0098\u0099\7t\2\2\u0099\u009a\7w\2\2\u009a\u009b\7g\2\2"+
		"\u009b\62\3\2\2\2\u009c\u009d\7H\2\2\u009d\u009e\7c\2\2\u009e\u009f\7"+
		"n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1\64\3\2\2\2\u00a2\u00a6"+
		"\t\2\2\2\u00a3\u00a5\t\3\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\66\3\2\2\2\u00a8\u00a6\3\2\2"+
		"\2\u00a9\u00ab\t\4\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b4\3\2\2\2\u00ae\u00b0\7\60\2\2"+
		"\u00af\u00b1\t\4\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b58\3\2\2\2\u00b6\u00b7\7.\2\2\u00b7:\3\2\2\2\u00b8"+
		"\u00b9\7*\2\2\u00b9<\3\2\2\2\u00ba\u00bb\7+\2\2\u00bb>\3\2\2\2\u00bc\u00bd"+
		"\7<\2\2\u00bd@\3\2\2\2\u00be\u00bf\6!\2\2\u00bf\u00cb\5C\"\2\u00c0\u00c2"+
		"\7\17\2\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2"+
		"\u00c3\u00c6\7\f\2\2\u00c4\u00c6\4\16\17\2\u00c5\u00c1\3\2\2\2\u00c5\u00c4"+
		"\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c9\5C\"\2\u00c8\u00c7\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00be\3\2\2\2\u00ca\u00c5\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b!\2\2\u00cdB\3\2\2\2\u00ce\u00d0"+
		"\t\5\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2D\3\2\2\2\u00d3\u00d6\5C\"\2\u00d4\u00d6\5A!\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\b#"+
		"\3\2\u00d8F\3\2\2\2\r\2\u00a6\u00ac\u00b2\u00b4\u00c1\u00c5\u00c8\u00ca"+
		"\u00d1\u00d5\4\3!\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}