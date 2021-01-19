#include "lexical_analyzer.h"
#include "parser.h"
#include <gtest/gtest.h>
#include <iostream>
#include <map>
#include <random>
#include <tuple>
#include <vector>

void test(parser &p, const std::string &input, const std::string &expected) {
    std::istringstream stream(input);
    std::ostringstream ostream;
    node *parsed_node = p.parse(stream);
    ostream << *parsed_node;
    std::string actual = ostream.str();
    delete parsed_node;
    EXPECT_EQ(actual, expected);
}

void test(parser &p, const std::string &input) {
    test(p, input, input);
}

void test(parser &p, const std::string &input, int expected) {
    std::istringstream stream(input);
    std::ostringstream ostream;
    input_node *parsed_node = dynamic_cast<input_node *>(p.parse(stream));
    EXPECT_EQ(parsed_node->val, expected);
    delete parsed_node;
}

void try_parse(parser &p, const std::string &input) {
    std::istringstream stream(input);
    std::ostringstream ostream;
    node *parsed_node = p.parse(stream);
    delete parsed_node;
}


TEST(parser, expression_correct_text) {
    parser p;
    test(p, "123");
    test(p, "-123");
    test(p, "-123+123");
    test(p, "-123-342");
    test(p, "-123/342");
    test(p, "-123*342");
    test(p, "-123-342-1-1-1");
    test(p, "-1--1");
    test(p, "1+1+1+1+(1+1)");
    test(p, "1*(23/34)*2--3*(3*2-2)");
}

TEST(parser, expression_correct_blank_test) {
    parser p;
    test(p, "123  ", "123");
    test(p, "-   123  ", "-123");
    test(p, "   -   123  ", "-123");
    test(p, "  - 123+   123  ", "-123+123");
    test(p, "1*(  23 /34   )*2   --3      *(   3*2-2)  ", "1*(23/34)*2--3*(3*2-2)");
}

TEST(parser, expression_correct_value) {
    parser p;
    test(p, "123", 123);
    test(p, "-123", -123);
    test(p, "-123+123", 0);
    test(p, "-123-342", -465);
    test(p, "-123/342", 0);
    test(p, "-123*342", -42066);
    test(p, "-123-342-1-1-1", -468);
    test(p, "-1--1", 0);
    test(p, "1+1+1+1+(1+1)", 6);
    test(p, "1*(23/34)*2--3*(3*2-2)", 12);
}

TEST(parser, expression_incorrect_input) {
    std::vector<std::tuple<std::string, std::string, int>> simple_examples = {
            {"10 10",  "not expected token NUM at position",    5},
            {"10+",    "not expected token EOFT at position",   3},
            {"(10+",   "not expected token EOFT at position",   4},
            {"(++",    "not expected token PLUS at position",   2},
            {")",      "not expected token RPAREN at position", 1},
            {"(1**2)", "not expected token MUL at position",    4},
            {"1---3",  "not expected token MINUS at position",  4},
            {"()",     "not expected token RPAREN at position", 2},
    };
    int couter = 0;
    for (auto &t : simple_examples) {
        couter++;
        try {
            parser p;
            try_parse(p, std::get<0>(t));
            FAIL() << couter << " parse_and_put_in_string(" <<
                   std::get<0>(t)
                   << ")  should throw a parser exception\n";
        } catch (
                parser_exception &exception
        ) {
            EXPECT_EQ(std::string(exception.what()),
                      std::get<1>(t));
            EXPECT_EQ(exception.getPos(), std::get<2>(t));
        }
    }
}

int main(int argc, char **argv) {
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}