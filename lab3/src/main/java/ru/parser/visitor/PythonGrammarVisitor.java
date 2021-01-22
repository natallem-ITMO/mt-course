package ru.parser.visitor;

import org.antlr.v4.runtime.tree.ParseTree;
import ru.parser.antlr.*;

import java.util.*;

public class PythonGrammarVisitor extends PythonGrammarBaseVisitor<StringBuilder> {
    private static final HashSet<String> variables = new HashSet<>();
    private static int depth = 1;
    private static String beginRange = "0";
    private static String stepRange = "1";
    private static String endRange = "0";
    public static Map<String, String> logicOperations;

    static {
        logicOperations = new HashMap<>();
        logicOperations.put("and", "&&");
        logicOperations.put("or", "||");
        logicOperations.put("not", "!");
    }

    private void visit(ParseTree parseTree, StringBuilder stringBuilder, String append) {
        StringBuilder result = parseTree.accept(this);
        if (result == null)
            return;
        stringBuilder.append(result).append(append);
        if (append.endsWith("\n")) {
            stringBuilder.append("\t".repeat(depth));
        }
    }

    private void visit(ParseTree parseTree, StringBuilder stringBuilder) {
        StringBuilder result = parseTree.accept(this);
        if (result == null)
            return;
        stringBuilder.append(result);
    }

    private StringBuilder visit(List<ParseTree> trees, String append) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ParseTree tree : trees) {
            visit(tree, stringBuilder, append);
        }
        return stringBuilder;
    }

    private StringBuilder visit(List<ParseTree> trees) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ParseTree tree : trees) {
            visit(tree, stringBuilder);
        }
        return stringBuilder;
    }


    @Override
    public StringBuilder visitProgram(PythonGrammarParser.ProgramContext ctx) {
        StringBuilder builder = new StringBuilder("#include <stdio.h>" + System.lineSeparator() +
                "#include <stdbool.h>" + System.lineSeparator() + System.lineSeparator());
        StringBuilder program = visit(ctx.children, System.lineSeparator());
        variables.forEach(x -> builder.append("int ").append(x).append(';').append(System.lineSeparator()));
        builder.append(System.lineSeparator())
                .append("int main()").append(System.lineSeparator())
                .append("{").append(System.lineSeparator()).append("\t".repeat(depth))
                .append(program)
                .append("return 0;").append(System.lineSeparator())
                .append("}").append(System.lineSeparator())
                .append(System.lineSeparator());
        return builder;
    }

    @Override
    public StringBuilder visitStmt(PythonGrammarParser.StmtContext ctx) {
        return visit(ctx.children);
    }

    @Override
    public StringBuilder visitSimple_stmt(PythonGrammarParser.Simple_stmtContext ctx) {
        return visit(ctx.children, ";");
    }

    @Override
    public StringBuilder visitNumberExpression(PythonGrammarParser.NumberExpressionContext ctx) {
        return new StringBuilder(ctx.children.get(0).toString());
    }

    @Override
    public StringBuilder visitName(PythonGrammarParser.NameContext ctx) {
        String varName = ctx.children.get(0).toString();
        variables.add(varName);
        return new StringBuilder(varName);
    }

    @Override
    public StringBuilder visitVariableExpression(PythonGrammarParser.VariableExpressionContext ctx) {
        return visit(ctx.children);
    }

    @Override
    public StringBuilder visitBinaryExpression(PythonGrammarParser.BinaryExpressionContext ctx) {
        StringBuilder res = new StringBuilder();
        visit(ctx.children.get(0), res);
        res.append(ctx.children.get(1).toString());
        visit(ctx.children.get(2), res);
        return res;
    }

    @Override
    public StringBuilder visitInBracketExpression(PythonGrammarParser.InBracketExpressionContext ctx) {
        return visit(ctx.children).insert(0, "(").append(")");
    }

    @Override
    public StringBuilder visitAssignment(PythonGrammarParser.AssignmentContext ctx) {
        StringBuilder res = new StringBuilder();
        visit(ctx.children.get(0), res);
        res.append(" = ");
        visit(ctx.children.get(2), res);
        return res;
    }

    @Override
    public StringBuilder visitCommand(PythonGrammarParser.CommandContext ctx) {
        return visit(ctx.children);
    }

    @Override
    public StringBuilder visitPrint_command(PythonGrammarParser.Print_commandContext ctx) {
        StringBuilder res = new StringBuilder("printf(\"%d\\n\",");
        visit(ctx.children.get(2), res, ")");
        return res;
    }

    @Override
    public StringBuilder visitRead_command(PythonGrammarParser.Read_commandContext ctx) {
        StringBuilder res = new StringBuilder("scanf(\"%d\", &");
        visit(ctx.children.get(0), res, ")");
        return res;
    }

    @Override
    public StringBuilder visitTrueCondition(PythonGrammarParser.TrueConditionContext ctx) {
        return new StringBuilder("true");
    }

    @Override
    public StringBuilder visitFalseCondition(PythonGrammarParser.FalseConditionContext ctx) {
        return new StringBuilder("false");
    }

    @Override
    public StringBuilder visitBinaryCondition(PythonGrammarParser.BinaryConditionContext ctx) {
        StringBuilder res = new StringBuilder();
        visit(ctx.children.get(0), res, logicOperations.get(ctx.children.get(1).toString()));
        visit(ctx.children.get(2), res);
        return res;
    }

    @Override
    public StringBuilder visitNotCondition(PythonGrammarParser.NotConditionContext ctx) {
        StringBuilder res = visit(ctx.children);
        return res.insert(0, "!(").append(")");
    }

    @Override
    public StringBuilder visitComparisonCondition(PythonGrammarParser.ComparisonConditionContext ctx) {
        StringBuilder res = new StringBuilder();
        visit(ctx.children.get(0), res, ctx.children.get(1).toString());
        visit(ctx.children.get(2), res);
        return res;
    }

    @Override
    public StringBuilder visitInBracketCondition(PythonGrammarParser.InBracketConditionContext ctx) {
        return visit(ctx.children).insert(0, "(").append(")");
    }

    @Override
    public StringBuilder visitCompound_stmt(PythonGrammarParser.Compound_stmtContext ctx) {
        return visit(ctx.children);
    }

    @Override
    public StringBuilder visitSuite(PythonGrammarParser.SuiteContext ctx) {
        return visit(ctx.children, System.lineSeparator());
    }

    @Override
    public StringBuilder visitWhile_stmt(PythonGrammarParser.While_stmtContext ctx) {
        StringBuilder builder = new StringBuilder("while (");
        visit(ctx.children.get(1), builder);
        ++depth;
        builder.append(") {").append(System.lineSeparator()).append("\t".repeat(depth));
        visit(ctx.children.get(3), builder);
        --depth;
        builder.setLength(builder.length() - 1);
        builder.append("}");
        return builder;
    }


    @Override
    public StringBuilder visitIf_stmt(PythonGrammarParser.If_stmtContext ctx) {
        StringBuilder builder = new StringBuilder("if (");
        visit(ctx.children.get(1), builder);
        ++depth;
        builder.append(") {").append(System.lineSeparator()).append("\t".repeat(depth));
        visit(ctx.children.get(3), builder);
        if (ctx.children.size() > 4) {
            builder.setLength(builder.length() - 1);
            builder.append("} else {").append(System.lineSeparator()).append("\t".repeat(depth));
            visit(ctx.children.get(6), builder);
        }
        --depth;
        builder.setLength(builder.length() - 1);
        builder.append("}");
        return builder;
    }

    @Override
    public StringBuilder visitFor_stmt(PythonGrammarParser.For_stmtContext ctx) {
        String name = ctx.children.get(1).toString();
        boolean contained = true;
        if (!variables.contains(name)) {
            contained = false;
            variables.add(name);
        }
        visit(ctx.children.get(5));
        ++depth;
        StringBuilder builder = new StringBuilder("for (int ");
        builder.append(name).append("=").append(beginRange).append("; ")
                .append(name).append("<").append(endRange).append("; ")
                .append(name).append("+=").append(stepRange).append(") {")
                .append(System.lineSeparator()).append("\t".repeat(depth));
        visit(ctx.children.get(8), builder);
        --depth;
        builder.setLength(builder.length() - 1);
        builder.append("}");
        if (!contained) {
            variables.remove(name);
        }
        return builder;
    }

    @Override
    public StringBuilder visitRangeOneNumber(PythonGrammarParser.RangeOneNumberContext ctx) {
        beginRange = "0";
        stepRange = "1";
        endRange = ctx.children.get(0).toString();
        return new StringBuilder();
    }

    @Override
    public StringBuilder visitRangeTwoNumbers(PythonGrammarParser.RangeTwoNumbersContext ctx) {
        beginRange = ctx.children.get(0).toString();
        stepRange = "1";
        endRange = ctx.children.get(2).toString();
        return new StringBuilder();
    }

    @Override
    public StringBuilder visitRangeThreeNumbers(PythonGrammarParser.RangeThreeNumbersContext ctx) {
        beginRange = ctx.children.get(0).toString();
        stepRange =  ctx.children.get(4).toString();
        endRange = ctx.children.get(2).toString();
        return new StringBuilder();
    }
}
