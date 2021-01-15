// Generated from B:/Projects/GitProjects/mt-course/lab3/src/main/java/antlr\PythonGrammar.g4 by ANTLR 4.9
package ru.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PythonGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PythonGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PythonGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(PythonGrammarParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmt(PythonGrammarParser.Simple_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_stmt(PythonGrammarParser.Compound_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(PythonGrammarParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(PythonGrammarParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(PythonGrammarParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rangeOneNumber}
	 * labeled alternative in {@link PythonGrammarParser#range_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeOneNumber(PythonGrammarParser.RangeOneNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rangeTwoNumbers}
	 * labeled alternative in {@link PythonGrammarParser#range_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeTwoNumbers(PythonGrammarParser.RangeTwoNumbersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(PythonGrammarParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(PythonGrammarParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#print_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_command(PythonGrammarParser.Print_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#read_command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_command(PythonGrammarParser.Read_commandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PythonGrammarParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(PythonGrammarParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(PythonGrammarParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inBracketExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInBracketExpression(PythonGrammarParser.InBracketExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(PythonGrammarParser.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryCondition(PythonGrammarParser.BinaryConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueCondition(PythonGrammarParser.TrueConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(PythonGrammarParser.NotConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonCondition(PythonGrammarParser.ComparisonConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inBracketCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInBracketCondition(PythonGrammarParser.InBracketConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseCondition(PythonGrammarParser.FalseConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PythonGrammarParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(PythonGrammarParser.NameContext ctx);
}