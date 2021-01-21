package grammar.visitor.antlr;

import grammar.parser.antlr.GrammarForGrammarBaseVisitor;
import grammar.parser.antlr.GrammarForGrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashSet;
import java.util.*;
import java.util.regex.Pattern;

public class GrammarVisitor extends GrammarForGrammarBaseVisitor<GrammarVisitor> {


    public class NonTerminalRule {

        public String non_terminal_name = "";
        public String non_terminal_var_name = "";
        public List<String> right_part = new ArrayList<>();
        public List<String> vars_and_types = new ArrayList<>();
        public List<String> pure_rule = new ArrayList<>();
        public Set<String> FIRST = new HashSet<>();
    }

    public Map<String, String> term_reg_expr_map = new HashMap<>();
    public Set<String> skip_terms = new HashSet<>();
    public Map<String, Set<String>> FIRST = new HashMap<>();
    public Map<String, Set<String>> FOLLOW = new HashMap<>();
    public List<NonTerminalRule> all_rules = new ArrayList<>();
    public Map<String, List<String>> inherit_attributes = new HashMap<>();
    public Map<String, List<String>> synth_attributes = new HashMap<>();
    public Map<String, List<NonTerminalRule>> non_terminal_rules = new HashMap<>();
    public String begin_non_term;
    NonTerminalRule cur_rule = null;
    String cur_token_name = "";
    String cur_var_name = "";

    public void calc_first_follow() {
        find_FIRST();
        find_FOLLOW();
        for (NonTerminalRule rule : all_rules) {
            for (int i = 0; i < rule.pure_rule.size(); i++) {
                String cur_token = rule.pure_rule.get(i);
                if (cur_token.equals("^")) {
                    rule.FIRST.addAll(FOLLOW.get(rule.non_terminal_name));
                    break;
                }
                if (isTerminal(cur_token)) {
                    rule.FIRST.add(rule.pure_rule.get(0));
                    break;
                }
                rule.FIRST.addAll(FIRST.get(cur_token));
                if (!rule.FIRST.remove("^")) {
                    break;
                } else if (i == rule.pure_rule.size() - 1) {
                    rule.FIRST.addAll(FOLLOW.get(rule.non_terminal_name));
                }
            }
        }
        int x = 10;
    }


    private void find_FIRST() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (NonTerminalRule rule : all_rules) {
                String cur_non_terminal = rule.non_terminal_name;
                Set<String> token = getFirst(rule.pure_rule);
                if (FIRST.get(cur_non_terminal).addAll(token)) {
                    changed = true;
                }
            }
        }
    }

    private void find_FOLLOW() {
        boolean changed = true;
        FOLLOW.get(begin_non_term).add("EOFT");
        while (changed) {
            changed = false;
            for (NonTerminalRule rule : all_rules) {
                for (int i = 0; i < rule.pure_rule.size(); i++) {
                    String cur_non_terminal = rule.pure_rule.get(i);
                    if (isTerminal(cur_non_terminal) || cur_non_terminal.equals("^")) {
                        continue;
                    }

                    if (i + 1 == rule.pure_rule.size()) {
                        if (FOLLOW.get(cur_non_terminal).addAll(FOLLOW.get(rule.non_terminal_name))) {
                            changed = true;
                        }
                    } else {
                        String second = rule.pure_rule.get(i + 1);
                        Set<String> cur_value = new HashSet<>();
                        if (isTerminal(second) || second.equals("^")) {
                            cur_value.add(second);
                        } else {
                            cur_value.addAll(FIRST.get(second));
                        }
                        if (cur_value.remove("^")) {
                            cur_value.addAll(FOLLOW.get(rule.non_terminal_name));
                        }
                        if (FOLLOW.get(cur_non_terminal).addAll(cur_value)) {
                            changed = true;
                        }
                    }
                }
            }
        }
    }


    private Set<String> getFirst(List<String> rule) {
        String first = rule.get(0);
        Set<String> res = new HashSet<>();
        if (first.equals("^")) {
            res.add("^");
            return res;
        }
        if (isTerminal(first)) {
            res.add(first);
            return res;
        }
        if (rule.size() == 1) {
            return FIRST.get(first);
        }
        res.addAll(FIRST.get(first));
        if (res.remove("^")) {
            String second = rule.get(1);
            res.addAll(FIRST.get(second));
            return res;
        } else {
            return res;
        }
    }

    public static boolean isTerminal(String string) {
        return Pattern.compile("[A-Z][A-Z0-9_]*").matcher(string).matches();
    }

    void visit_(ParseTree tree) {
        tree.accept(this);
    }

    void visit_(List<ParseTree> trees) {
        for (ParseTree tree : trees) {
            visit_(tree);
        }
    }

    @Override
    public GrammarVisitor visitGrammar_file(GrammarForGrammarParser.Grammar_fileContext ctx) {
        visit_(ctx.children);
        return this;
    }

    @Override
    public GrammarVisitor visitGrammar_rule(GrammarForGrammarParser.Grammar_ruleContext ctx) {
        ctx.children.get(0).accept(this);
        return this;
    }

    @Override
    public GrammarVisitor visitTerminalRule(GrammarForGrammarParser.TerminalRuleContext ctx) {
        ctx.children.get(0).accept(this);
        if (cur_token_name.equals("EOF")) {
            cur_token_name += "T";
            begin_non_term = cur_rule.non_terminal_name;
        }
        cur_rule.right_part.add(cur_token_name);
        if (cur_var_name.isEmpty()) {
            cur_rule.vars_and_types.add("_" + cur_rule.vars_and_types.size());
        } else {
            cur_rule.vars_and_types.add(cur_var_name);
        }
        cur_rule.pure_rule.add(cur_token_name);
        return this;
    }

    @Override
    public GrammarVisitor visitNonTerminalRule(GrammarForGrammarParser.NonTerminalRuleContext ctx) {
        ctx.children.get(0).accept(this);
        cur_rule.right_part.add(cur_token_name);
        if (cur_var_name.isEmpty()) {
            cur_rule.vars_and_types.add("_" + cur_rule.vars_and_types.size());
        } else {
            cur_rule.vars_and_types.add(cur_var_name);
        }
        cur_rule.pure_rule.add(cur_token_name);
        return this;
    }

    @Override
    public GrammarVisitor visitAttributeRule(GrammarForGrammarParser.AttributeRuleContext ctx) {
        cur_rule.right_part.add(ctx.children.get(0).toString());
        cur_rule.vars_and_types.add("!");
        return this;
    }

    @Override
    public GrammarVisitor visitNon_term_rule(GrammarForGrammarParser.Non_term_ruleContext ctx) {
        ctx.children.get(0).accept(this);
        NonTerminalRule rule = new NonTerminalRule();
        rule.non_terminal_name = cur_token_name;
        if (cur_var_name.isEmpty()) {
            rule.non_terminal_var_name = "_";
        } else {
            rule.non_terminal_var_name = cur_var_name;
        }

        cur_rule = rule;
        for (int i = 2; i < ctx.children.size(); i++) {
            ctx.children.get(i).accept(this);
        }
        all_rules.add(cur_rule);
        non_terminal_rules.computeIfAbsent(rule.non_terminal_name, (x) -> new ArrayList<>());
        non_terminal_rules.get(rule.non_terminal_name).add(rule);
        cur_rule = null;
        return this;
    }

    @Override
    public GrammarVisitor visitTerm_rule(GrammarForGrammarParser.Term_ruleContext ctx) {
        String regex = ctx.children.get(2).toString();
        term_reg_expr_map.put(ctx.children.get(0).toString(), "^" + regex.substring(1, regex.length() - 1).replaceAll("\\\\", "\\\\\\\\"));
        if (ctx.children.size() > 3) {
            skip_terms.add(ctx.children.get(0).toString());
        }
        return this;
    }

    @Override
    public GrammarVisitor visitNon_term_description(GrammarForGrammarParser.Non_term_descriptionContext ctx) {
        cur_token_name = ctx.children.get(0).toString();
        visit_(ctx.children);
        return this;
    }

    @Override
    public GrammarVisitor visitSynth_attr_desc(GrammarForGrammarParser.Synth_attr_descContext ctx) {
        List<String> cur_attr = new ArrayList<>();
        for (int i = 2; i < ctx.children.size() - 1; i += 3) {
            cur_attr.add(ctx.children.get(i).toStringTree() + " " + ctx.children.get(i + 1).toStringTree() + ctx.children.get(i + 2).toStringTree());
        }
        synth_attributes.put(cur_token_name, cur_attr);
        return this;
    }

    @Override
    public GrammarVisitor visitInherit_attr_desc(GrammarForGrammarParser.Inherit_attr_descContext ctx) {
        List<String> cur_attr = new ArrayList<>();
        for (int i = 1; i < ctx.children.size() - 1; i += 3) {
            cur_attr.add(ctx.children.get(i).toStringTree() + " " + ctx.children.get(i + 1).toStringTree() + ctx.children.get(i + 2).toStringTree());
        }
        inherit_attributes.put(cur_token_name, cur_attr);
        return this;
    }

    @Override
    public GrammarVisitor visitAssignment_terminal(GrammarForGrammarParser.Assignment_terminalContext ctx) {
        cur_var_name = ctx.children.get(0).toString();
        cur_var_name = cur_var_name.substring(1, cur_var_name.length());
        cur_token_name = ctx.children.get(2).toString();
        return this;
    }

    @Override
    public GrammarVisitor visitSimple_terminal(GrammarForGrammarParser.Simple_terminalContext ctx) {
        cur_token_name = ctx.children.get(0).toString();
        cur_var_name = "";
        return this;
    }


    @Override
    public GrammarVisitor visitEpsilon(GrammarForGrammarParser.EpsilonContext ctx) {
        cur_token_name = ctx.children.get(0).toString();
        cur_var_name = "";
        return this;
    }

    @Override
    public GrammarVisitor visitAssignment_non_terminal(GrammarForGrammarParser.Assignment_non_terminalContext ctx) {
        cur_var_name = ctx.children.get(0).toString();
        cur_var_name = cur_var_name.substring(1, cur_var_name.length());
        cur_token_name = ctx.children.get(2).toString();
        FIRST.computeIfAbsent(cur_token_name, (x) -> new HashSet<>());
        FOLLOW.computeIfAbsent(cur_token_name, (x) -> new HashSet<>());
        return this;
    }

    @Override
    public GrammarVisitor visitSimple_non_terminal(GrammarForGrammarParser.Simple_non_terminalContext ctx) {
        cur_token_name = ctx.children.get(0).toString();
        cur_var_name = "";
        FIRST.computeIfAbsent(cur_token_name, (x) -> new HashSet<>());
        FOLLOW.computeIfAbsent(cur_token_name, (x) -> new HashSet<>());
        return this;
    }
}
