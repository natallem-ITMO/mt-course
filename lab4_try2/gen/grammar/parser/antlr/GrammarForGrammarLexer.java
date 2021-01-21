// Generated from /data/Projects/GitProjects/mt-course/lab4_try2/src/main/java/antlr/GrammarForGrammar.g4 by ANTLR 4.9
package grammar.parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarForGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TERMINAL=12, NOT_TERMINAL=13, ANY_NAME=14, NAME=15, 
		WS=16, NL=17, ANY_CODE=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "TERMINAL", "NOT_TERMINAL", "ANY_NAME", "NAME", "WS", 
			"NL", "ANY_CODE"
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


	public GrammarForGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GrammarForGrammar.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\7\rK\n\r\f\r\16\rN\13\r\3\16\3\16\7\16R\n\16\f\16\16\16U"+
		"\13\16\3\17\3\17\7\17Y\n\17\f\17\16\17\\\13\17\3\20\3\20\3\20\3\21\6\21"+
		"b\n\21\r\21\16\21c\3\21\3\21\3\22\5\22i\n\22\3\22\3\22\3\23\3\23\6\23"+
		"o\n\23\r\23\16\23p\3\23\3\23\3p\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\n\3\2C\\\5"+
		"\2\62;C\\aa\3\2c|\5\2\62;aac|\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\""+
		"\3\2\177\177\2y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5*\3\2\2\2\7,\3\2\2\2\t\61\3"+
		"\2\2\2\13\63\3\2\2\2\r:\3\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23A\3\2\2\2\25"+
		"D\3\2\2\2\27F\3\2\2\2\31H\3\2\2\2\33O\3\2\2\2\35V\3\2\2\2\37]\3\2\2\2"+
		"!a\3\2\2\2#h\3\2\2\2%l\3\2\2\2\'(\7/\2\2()\7@\2\2)\4\3\2\2\2*+\7%\2\2"+
		"+\6\3\2\2\2,-\7u\2\2-.\7m\2\2./\7k\2\2/\60\7r\2\2\60\b\3\2\2\2\61\62\7"+
		"]\2\2\62\n\3\2\2\2\63\64\7t\2\2\64\65\7g\2\2\65\66\7v\2\2\66\67\7w\2\2"+
		"\678\7t\2\289\7p\2\29\f\3\2\2\2:;\7=\2\2;\16\3\2\2\2<=\7_\2\2=\20\3\2"+
		"\2\2>?\7]\2\2?@\7]\2\2@\22\3\2\2\2AB\7_\2\2BC\7_\2\2C\24\3\2\2\2DE\7?"+
		"\2\2E\26\3\2\2\2FG\7`\2\2G\30\3\2\2\2HL\t\2\2\2IK\t\3\2\2JI\3\2\2\2KN"+
		"\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\32\3\2\2\2NL\3\2\2\2OS\t\4\2\2PR\t\5\2\2"+
		"QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\34\3\2\2\2US\3\2\2\2VZ\t\6\2"+
		"\2WY\t\7\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\36\3\2\2\2\\Z\3"+
		"\2\2\2]^\7&\2\2^_\5\35\17\2_ \3\2\2\2`b\t\b\2\2a`\3\2\2\2bc\3\2\2\2ca"+
		"\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\b\21\2\2f\"\3\2\2\2gi\7\17\2\2hg\3\2\2"+
		"\2hi\3\2\2\2ij\3\2\2\2jk\7\f\2\2k$\3\2\2\2ln\7}\2\2mo\n\t\2\2nm\3\2\2"+
		"\2op\3\2\2\2pq\3\2\2\2pn\3\2\2\2qr\3\2\2\2rs\7\177\2\2s&\3\2\2\2\t\2L"+
		"SZchp\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}