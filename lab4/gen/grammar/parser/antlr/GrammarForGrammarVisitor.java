// Generated from /data/Projects/GitProjects/mt-course/lab4_try2/src/main/java/antlr/GrammarForGrammar.g4 by ANTLR 4.9
package grammar.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarForGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarForGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarParser#grammar_file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrammar_file(GrammarForGrammarParser.Grammar_fileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarParser#grammar_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrammar_rule(GrammarForGrammarParser.Grammar_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarParser#non_term_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_term_rule(GrammarForGrammarParser.Non_term_ruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code terminalRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminalRule(GrammarForGrammarParser.TerminalRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nonTerminalRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonTerminalRule(GrammarForGrammarParser.NonTerminalRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeRule}
	 * labeled alternative in {@link GrammarForGrammarParser#non_term_right_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeRule(GrammarForGrammarParser.AttributeRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarParser#term_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_rule(GrammarForGrammarParser.Term_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarParser#synth_attr_desc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynth_attr_desc(GrammarForGrammarParser.Synth_attr_descContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarParser#inherit_attr_desc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInherit_attr_desc(GrammarForGrammarParser.Inherit_attr_descContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simple_non_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#non_terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_non_terminal(GrammarForGrammarParser.Simple_non_terminalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignment_non_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#non_terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_non_terminal(GrammarForGrammarParser.Assignment_non_terminalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignment_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_terminal(GrammarForGrammarParser.Assignment_terminalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simple_terminal}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_terminal(GrammarForGrammarParser.Simple_terminalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link GrammarForGrammarParser#terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpsilon(GrammarForGrammarParser.EpsilonContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarForGrammarParser#non_term_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_term_description(GrammarForGrammarParser.Non_term_descriptionContext ctx);
}