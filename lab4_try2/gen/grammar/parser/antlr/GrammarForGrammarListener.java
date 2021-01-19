// Generated from /data/Projects/GitProjects/mt-course/lab4_try2/src/main/java/antlr/GrammarForGrammar.g4 by ANTLR 4.9
package grammar.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarForGrammarParser}.
 */
public interface GrammarForGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarParser#grammar_file}.
	 * @param ctx the parse tree
	 */
	void enterGrammar_file(GrammarForGrammarParser.Grammar_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarParser#grammar_file}.
	 * @param ctx the parse tree
	 */
	void exitGrammar_file(GrammarForGrammarParser.Grammar_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarParser#grammar_rule}.
	 * @param ctx the parse tree
	 */
	void enterGrammar_rule(GrammarForGrammarParser.Grammar_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarParser#grammar_rule}.
	 * @param ctx the parse tree
	 */
	void exitGrammar_rule(GrammarForGrammarParser.Grammar_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarParser#non_term_rule}.
	 * @param ctx the parse tree
	 */
	void enterNon_term_rule(GrammarForGrammarParser.Non_term_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarParser#non_term_rule}.
	 * @param ctx the parse tree
	 */
	void exitNon_term_rule(GrammarForGrammarParser.Non_term_ruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code terminalRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 */
	void enterTerminalRule(GrammarForGrammarParser.TerminalRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code terminalRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 */
	void exitTerminalRule(GrammarForGrammarParser.TerminalRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nonTerminalRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalRule(GrammarForGrammarParser.NonTerminalRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonTerminalRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalRule(GrammarForGrammarParser.NonTerminalRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 */
	void enterAttributeRule(GrammarForGrammarParser.AttributeRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 */
	void exitAttributeRule(GrammarForGrammarParser.AttributeRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarParser#term_rule}.
	 * @param ctx the parse tree
	 */
	void enterTerm_rule(GrammarForGrammarParser.Term_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarParser#term_rule}.
	 * @param ctx the parse tree
	 */
	void exitTerm_rule(GrammarForGrammarParser.Term_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarParser#synth_attr_desc}.
	 * @param ctx the parse tree
	 */
	void enterSynth_attr_desc(GrammarForGrammarParser.Synth_attr_descContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarParser#synth_attr_desc}.
	 * @param ctx the parse tree
	 */
	void exitSynth_attr_desc(GrammarForGrammarParser.Synth_attr_descContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarParser#inherit_attr_desc}.
	 * @param ctx the parse tree
	 */
	void enterInherit_attr_desc(GrammarForGrammarParser.Inherit_attr_descContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarParser#inherit_attr_desc}.
	 * @param ctx the parse tree
	 */
	void exitInherit_attr_desc(GrammarForGrammarParser.Inherit_attr_descContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simple_non_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#non_terminal}.
	 * @param ctx the parse tree
	 */
	void enterSimple_non_terminal(GrammarForGrammarParser.Simple_non_terminalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simple_non_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#non_terminal}.
	 * @param ctx the parse tree
	 */
	void exitSimple_non_terminal(GrammarForGrammarParser.Simple_non_terminalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignment_non_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#non_terminal}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_non_terminal(GrammarForGrammarParser.Assignment_non_terminalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignment_non_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#non_terminal}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_non_terminal(GrammarForGrammarParser.Assignment_non_terminalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignment_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_terminal(GrammarForGrammarParser.Assignment_terminalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignment_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_terminal(GrammarForGrammarParser.Assignment_terminalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simple_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterSimple_terminal(GrammarForGrammarParser.Simple_terminalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simple_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitSimple_terminal(GrammarForGrammarParser.Simple_terminalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterEpsilon(GrammarForGrammarParser.EpsilonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitEpsilon(GrammarForGrammarParser.EpsilonContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarForGrammarParser#non_term_description}.
	 * @param ctx the parse tree
	 */
	void enterNon_term_description(GrammarForGrammarParser.Non_term_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarForGrammarParser#non_term_description}.
	 * @param ctx the parse tree
	 */
	void exitNon_term_description(GrammarForGrammarParser.Non_term_descriptionContext ctx);
}