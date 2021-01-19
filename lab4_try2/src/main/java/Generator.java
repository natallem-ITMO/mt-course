import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import grammar.parser.antlr.*;
import grammar.visitor.antlr.GrammarVisitor;

public class Generator {

    private final static List<String> file_names = List.of("PythonFunctionGrammar.g", "CalculatorGrammar.g");
    private final static List<String> result_dirs = List.of("lab2_generated/", "expression_generated/");
    private final static int choice = 1;

    public static void main(String[] args) throws Exception {
        String path_from_current_dir = "/src/resources/";
        GrammarForGrammarLexer lexer = new GrammarForGrammarLexer(
                CharStreams.fromPath(
                        Path.of(
                                System.getProperty("user.dir") + path_from_current_dir + file_names.get(choice)),
                        StandardCharsets.UTF_8));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarForGrammarParser parser = new GrammarForGrammarParser(tokens);
        ParseTree tree = parser.grammar_file();
        GrammarVisitor visitor = new GrammarVisitor();
        visitor.visit(tree);
        visitor.calc_first_follow();
        String directory_to_write = System.getProperty("user.dir") + "/src/results/" + result_dirs.get(choice);
        generate_lexer(directory_to_write, visitor);
        generate_parser(directory_to_write, visitor);
        int x = 10;
    }

    private static void generate_parser(String directory_to_write, GrammarVisitor visitor) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(directory_to_write + "parser.h"));
        String result = new String("" +
                "#pragma once\n" +
                "#include <initializer_list>\n" +
                "#include <set>\n" +
                "#include <memory>\n" +
                "#include \"lexical_analyzer.h\"\n" +
                "\n" +
                "using namespace std;\n" +
                "\n" +
                "struct node {\n" +
                "    node() = default;;\n" +
                "\n" +
                "    explicit node(std::string &&node_) :\n" +
                "            node_name(std::move(node_)) {}\n" +
                "\n" +
                "    virtual  ~node() {\n" +
                "        for (auto t : children) {\n" +
                "            delete t;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    friend bool operator==(const node &, const node &);\n" +
                "\n" +
                "    std::string value;\n" +
                "    std::string node_name;\n" +
                "    std::vector<node *> children;\n" +
                "};\n" +
                "\n" +
                "inline bool operator==(const node &lhs, const node &rhs) {\n" +
                "    return lhs.value == rhs.value && lhs.children == rhs.children && lhs.node_name == rhs.node_name;\n" +
                "}\n" +
                "\n" +
                "inline bool operator!=(const node &lhs, const node &rhs) {\n" +
                "    return !(lhs == rhs);\n" +
                "}\n" +
                "std::ostream &operator<<(std::ostream &os, const node &dt) {\n" +
                "    if (dt.children.empty()) {\n" +
                "        os << dt.value;\n" +
                "    } else {\n" +
                "        for (auto i : dt.children) {\n" +
                "            os << *i;\n" +
                "        }\n" +
                "    }\n" +
                "    return os;\n" +
                "}\n" +
                "\n" +
                getAllNodeStruct(visitor)) +
                "\n" +
                "set<token> skipped_tokens = {" + String.join(", ", visitor.skip_terms) + "};\n" +
                "\n" +
                "struct parser {\n" +
                "    lexical_analyzer *lex_analyzer = nullptr;\n" +
                "\n" +
                "    ~parser() {\n" +
                "        if (lex_analyzer != nullptr) {\n" +
                "            delete lex_analyzer;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    void check_no_token() noexcept(false) {\n" +
                "        if (skipped_tokens.contains(lex_analyzer->get_token())) {\n" +
                "            lex_analyzer->nextToken();\n" +
                "            return;\n" +
                "        }\n" +
                "        throw parser_exception(\"not expected token \" + token_string_map[lex_analyzer->get_token()] + \" at position\",\n" +
                "                               lex_analyzer->get_cur_position());\n" +
                "    }\n" +
                "\n" +
                "    node *parse(std::istream &source) noexcept(false) {\n" +
                "        lex_analyzer = new lexical_analyzer(source);\n" +
                "        lex_analyzer->nextToken();\n" +
                "        unique_ptr<"+visitor.begin_non_term+"_node> ptr = make_unique<"+visitor.begin_non_term+"_node>();\n" +
                "        input(ptr.get());\n" +
                "        delete lex_analyzer;\n"  +
                "        lex_analyzer = nullptr;\n"+
                "        "+visitor.begin_non_term+"_node * result = ptr.release();\n" +
                "        return result;\n" +
                "    }\n" +
                "\n" +
                getAllNonTermRules(visitor) +
                "};\n";


        writer.write(result);
        writer.close();
    }

    private static String getAllNonTermRules(GrammarVisitor visitor) {
        return visitor.non_terminal_rules.entrySet().stream().map(x -> {

            return getParserNonTermRule(x.getKey(), x.getValue());
        }).collect(Collectors.joining("\n"));

    }

    private static String getParserNonTermRule(String key, List<GrammarVisitor.NonTerminalRule> value) {
        if (key.equals("e1")) {
            int x = 10;
        }
        String result =
                "    void "+key+"("+key+"_node *cur_node) {\n" +
                        "        while (true) {\n" +

                        value.stream().map((GrammarVisitor.NonTerminalRule x) ->
                        {
                            StringBuilder res = new StringBuilder("            if (" + x.FIRST.stream().map(y -> "lex_analyzer->get_token() == " + y)
                                    .collect(Collectors.joining(" || ")) + ") {\n");
                            res.append("                " + key + "_node &" + x.non_terminal_var_name + " = *cur_node;\n");
                            for (int i = 0; i < x.right_part.size(); i++) {
                                if (x.vars_and_types.get(i).equals("!")) {
                                    continue;
                                }
                                if (x.right_part.get(i).equals("^")) {
                                } else if (GrammarVisitor.isTerminal(x.right_part.get(i))) {
                                    res.append("                unique_ptr<node> ").append(x.vars_and_types.get(i))
                                            .append("ptr = std::make_unique<node>(\"").append(x.right_part.get(i))
                                            .append("\");\n").append("                node &").append(x.vars_and_types.get(i))
                                            .append(" = *").append(x.vars_and_types.get(i)).append("ptr;\n");
                                } else {
                                    String non_terminal = x.right_part.get(i);
                                    String name = x.vars_and_types.get(i);
                                    String ptr_name = name + "ptr";
                                    res.append("                unique_ptr<")
                                            .append(non_terminal).append("_node> ").append(ptr_name)
                                            .append(" = std::make_unique<").append(non_terminal)
                                            .append("_node>();\n")
                                            .append("                ").append(non_terminal).append("_node &")
                                            .append(name).append(" = *").append(ptr_name).append(";\n");
                                }
                            }

                            for (int i = 0; i < x.right_part.size(); i++) {
                                res.append("\n");
                                if (x.vars_and_types.get(i).equals("!")) {
                                    res.append("                " + x.right_part.get(i) + "\n");
                                    continue;
                                }
                                if (x.right_part.get(i).equals("^")) {
                                    continue;
                                }
                                if (GrammarVisitor.isTerminal(x.right_part.get(i))) {
                                    res.append(
                                            "                while (true) {\n" +
                                                    "                    if (lex_analyzer->get_token() == " + x.right_part.get(i) + ") {\n" +
                                                    "                        " + x.vars_and_types.get(i) + ".value = lex_analyzer->get_value_string();\n" +
                                                    "                        " + x.vars_and_types.get(i) + "ptr.release();\n" +
                                                    "                        " + x.non_terminal_var_name + ".children.push_back(&" + x.vars_and_types.get(i) + ");\n" +
                                                    "                        lex_analyzer->nextToken();\n" +
                                                    "                        break;\n" +
                                                    "                    }\n" +
                                                    "                    check_no_token();\n" +
                                                    "                }\n");
                                } else {
                                    res.append(
                                            "                " + x.right_part.get(i) + "(&" + x.vars_and_types.get(i) + ");\n" +
                                                    "                " + x.vars_and_types.get(i) + "ptr.release();\n" +
                                                    "                " + x.non_terminal_var_name + ".children.push_back(&" + x.vars_and_types.get(i) + ");\n");
                                }
                            }
                            res.append("                return;\n" +
                                    "            }\n");
                            return res.toString();

                        }).collect(Collectors.joining("\n"));
        return result +
                "            check_no_token();\n" +
                "        }\n" +
                "\n" +
                "    }\n";
    }

    private static String getAllNodeStruct(GrammarVisitor visitor) {
        return visitor.non_terminal_rules.keySet().stream().map((String x) ->
        {
            String inherit = "";
            if (visitor.inherit_attributes.get(x) != null) {
                inherit = "    " + String.join("\n    ", visitor.inherit_attributes.get(x)) + "\n\n";
            }
            String synth = "";
            if (visitor.synth_attributes.get(x) != null) {
                synth = "    " + String.join("\n    ", visitor.synth_attributes.get(x)) + "\n";
            }
            return "struct " + x + "_node : public node {\n" +
                    "    " + x + "_node() : node(\"" + x + "\") {};\n" +
                    "\n" +
                    "    ~" + x + "_node() override = default;\n" +
                    inherit + synth +
                    "};";
        }).collect(Collectors.joining("\n\n"));
    }

    private static void generate_lexer(String directory_to_write, GrammarVisitor visitor) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(directory_to_write + "lexical_analyzer.h"));

        String result = "" +
                "#pragma once\n" +
                "\n" +
                "#include <regex>\n" +
                "#include <map>\n" +
                "#include <string>\n" +
                "\n" +
                "enum token {\n" +
                "    " + getEnumsEnumeration(visitor) + "\n" +
                "};\n" +
                "\n" +
                "std::map<token, std::string> reg_expr_map = {\n" +
                getEnumsRegExpr(visitor) +
                "};\n" +
                "\n" +
                "std::map<token, std::string> token_string_map = {\n" +
                getEnumsNames(visitor) +
                "\n" +
                "};\n" +
                "\n" +
                "\n" +
                "struct parser_exception : std::exception {\n" +
                "    explicit parser_exception(std::string message, size_t pos)\n" +
                "            : msg_(std::move(message)), pos(pos) {}\n" +
                "\n" +
                "    virtual ~parser_exception() noexcept {}\n" +
                "\n" +
                "    virtual const char *what() const noexcept { return msg_.c_str(); }\n" +
                "\n" +
                "    size_t getPos() const {\n" +
                "        return pos;\n" +
                "    }\n" +
                "\n" +
                "private:\n" +
                "    std::string msg_;\n" +
                "    size_t pos;\n" +
                "};\n" +
                "\n" +
                "struct lexical_analyzer {\n" +
                "\n" +
                "    lexical_analyzer(std::istream &source) noexcept(false)\n" +
                "            : source(source), cur_position(0) {\n" +
                "        nextChar();\n" +
                "    }\n" +
                "\n" +
                "    void nextToken() noexcept(false) {\n" +
                "        if (cur_read_part.empty() && cur_char == EOF) {\n" +
                "            cur_token = EOFT;\n" +
                "            cur_value_string = \"\";\n" +
                "            return;\n" +
                "        }\n" +
                "        if (cur_read_part.size() < max_token_size) {\n" +
                "            complete_cur_read_part();\n" +
                "        }\n" +
                "        if (cur_read_part.empty()) {\n" +
                "            throw parser_exception(\"Cannot get char from input stream\", cur_position);\n" +
                "        }\n" +
                "        size_t max_prefix = 0;\n" +
                "        token max_token;\n" +
                "        for (std::pair<const token, std::string> &reg_expr_pair : reg_expr_map) {\n" +
                "            auto cur_regex = std::regex(reg_expr_pair.second);\n" +
                "            std::smatch sm;\n" +
                "            regex_search(cur_read_part, sm, cur_regex);\n" +
                "            if (sm.length() == 0)\n" +
                "                continue;\n" +
                "            size_t cur_match_size = sm[0].length();\n" +
                "            if (cur_match_size != 0 && cur_match_size == max_prefix) {\n" +
                "                throw parser_exception(\"Two regexp suits one prefix : reg_expr1=\"\n" +
                "                                       + reg_expr_map[max_token] + \" reg_expr2=\" + reg_expr_pair.second +\n" +
                "                                       \" on string \" + sm[0].str(), get_cur_position());\n" +
                "            } else if (cur_match_size > max_prefix) {\n" +
                "                max_token = reg_expr_pair.first;\n" +
                "                max_prefix = cur_match_size;\n" +
                "            }\n" +
                "        }\n" +
                "        if (max_prefix == 0) {\n" +
                "            throw parser_exception(\"Illegal character \" + std::string(1, cur_read_part[0]),\n" +
                "                                   get_cur_position());\n" +
                "        } else {\n" +
                "            cur_value_string = cur_read_part.substr(0, max_prefix);\n" +
                "            cur_read_part.erase(0, cur_value_string.size());\n" +
                "            cur_token = max_token;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    char get_char() { return cur_char; }\n" +
                "\n" +
                "    token get_token() { return cur_token; }\n" +
                "\n" +
                "    std::string get_value_string() { return cur_value_string; }\n" +
                "\n" +
                "    size_t get_cur_position() {\n" +
                "        return cur_position - cur_read_part.length();\n" +
                "    }\n\n" +
                "private:\n" +
                "    void nextChar() noexcept(false) {\n" +
                "        ++cur_position;\n" +
                "        try {\n" +
                "            cur_char = source.get();\n" +
                "            if (cur_char == EOF){\n" +
                "                --cur_position;\n" +
                "            }\n"+
                "        } catch (std::ios_base::failure &fail) {\n" +
                "            throw parser_exception(fail.what(), cur_position);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    void complete_cur_read_part() {\n" +
                "        while (cur_char != EOF && cur_read_part.size() < max_token_size) {\n" +
                "            cur_read_part += cur_char;\n" +
                "            nextChar();\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    std::istream &source;\n" +
                "    char cur_char;\n" +
                "    token cur_token;\n" +
                "    std::string cur_value_string;\n" +
                "    std::string cur_read_part;\n" +
                "    size_t max_token_size = 100;\n" +
                "public:\n" +
                "    size_t cur_position;\n" +
                "};";
        writer.write(result);
        writer.close();
    }

    private static String getEnumsNames(GrammarVisitor visitor) {
        return visitor.term_reg_expr_map.keySet().stream().map(
                k -> "        {" + k + ", \"" + k + "\"}"
        ).collect(Collectors.joining(",\n")) + ",\n" +
                "        {EOFT, \"EOFT\"}";
    }

    private static String getEnumsRegExpr(GrammarVisitor visitor) {
        return visitor.term_reg_expr_map.entrySet().stream().map(
                k -> "        {" + k.getKey() + ", \"" + k.getValue() + "\"}"
        ).collect(Collectors.joining(",\n"));
    }

    private static String getEnumsEnumeration(GrammarVisitor visitor) {
        return String.join(", ", visitor.term_reg_expr_map.keySet()) + ", EOFT";
    }
}
