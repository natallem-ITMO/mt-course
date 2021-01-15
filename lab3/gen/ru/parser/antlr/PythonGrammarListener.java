// Generated from B:/Projects/GitProjects/mt-course/lab3/src/main/java/antlr\PythonGrammar.g4 by ANTLR 4.9
package ru.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonGrammarParser}.
 */
public interface PythonGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PythonGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PythonGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(PythonGrammarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(PythonGrammarParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt(PythonGrammarParser.Simple_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt(PythonGrammarParser.Simple_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(PythonGrammarParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(PythonGrammarParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(PythonGrammarParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(PythonGrammarParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(PythonGrammarParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(PythonGrammarParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(PythonGrammarParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(PythonGrammarParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rangeOneNumber}
	 * labeled alternative in {@link PythonGrammarParser#range_list}.
	 * @param ctx the parse tree
	 */
	void enterRangeOneNumber(PythonGrammarParser.RangeOneNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rangeOneNumber}
	 * labeled alternative in {@link PythonGrammarParser#range_list}.
	 * @param ctx the parse tree
	 */
	void exitRangeOneNumber(PythonGrammarParser.RangeOneNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rangeTwoNumbers}
	 * labeled alternative in {@link PythonGrammarParser#range_list}.
	 * @param ctx the parse tree
	 */
	void enterRangeTwoNumbers(PythonGrammarParser.RangeTwoNumbersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rangeTwoNumbers}
	 * labeled alternative in {@link PythonGrammarParser#range_list}.
	 * @param ctx the parse tree
	 */
	void exitRangeTwoNumbers(PythonGrammarParser.RangeTwoNumbersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(PythonGrammarParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(PythonGrammarParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(PythonGrammarParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(PythonGrammarParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#print_command}.
	 * @param ctx the parse tree
	 */
	void enterPrint_command(PythonGrammarParser.Print_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#print_command}.
	 * @param ctx the parse tree
	 */
	void exitPrint_command(PythonGrammarParser.Print_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#read_command}.
	 * @param ctx the parse tree
	 */
	void enterRead_command(PythonGrammarParser.Read_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#read_command}.
	 * @param ctx the parse tree
	 */
	void exitRead_command(PythonGrammarParser.Read_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PythonGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PythonGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(PythonGrammarParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(PythonGrammarParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(PythonGrammarParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(PythonGrammarParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inBracketExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterInBracketExpression(PythonGrammarParser.InBracketExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inBracketExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitInBracketExpression(PythonGrammarParser.InBracketExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(PythonGrammarParser.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link PythonGrammarParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(PythonGrammarParser.VariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(PythonGrammarParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(PythonGrammarParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterBinaryCondition(PythonGrammarParser.BinaryConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitBinaryCondition(PythonGrammarParser.BinaryConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterTrueCondition(PythonGrammarParser.TrueConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitTrueCondition(PythonGrammarParser.TrueConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterNotCondition(PythonGrammarParser.NotConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitNotCondition(PythonGrammarParser.NotConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterComparisonCondition(PythonGrammarParser.ComparisonConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitComparisonCondition(PythonGrammarParser.ComparisonConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inBracketCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterInBracketCondition(PythonGrammarParser.InBracketConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inBracketCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitInBracketCondition(PythonGrammarParser.InBracketConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterFalseCondition(PythonGrammarParser.FalseConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseCondition}
	 * labeled alternative in {@link PythonGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitFalseCondition(PythonGrammarParser.FalseConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(PythonGrammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(PythonGrammarParser.NameContext ctx);
}