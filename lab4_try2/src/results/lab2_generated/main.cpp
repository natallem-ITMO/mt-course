#include "lexical_analyzer.h"
#include "parser.h"
#include <gtest/gtest.h>
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

void try_parse(parser &p, const std::string &input) {
    std::istringstream stream(input);
    std::ostringstream ostream;
    node *parsed_node = p.parse(stream);
    delete parsed_node;
}

TEST(parser, expression_correct_text) {
    parser p;
    test(p, "def name()=");
    test(p, "def name(x1)=");
    test(p, "def n324jlk(x1,xdsff2)=");
    test(p, "def jfkd3kl(xsdf,esf2dsfd,sdf)=");
    test(p, "def name(...)=");
    test(p, "def jekkfds(adsf,...)=");
    test(p, "def name(adsf,sdfsdf,dsfsf,c4,c323,...)=");
}


TEST(parser, expression_correct_blank_test) {
    parser p;
    test(p, "  def name       ()=", "def name()=");
    test(p, "  def name       (     )      =", "def name()=");
    test(p, "def name(    x1 ,xdsff2)     =","def name(x1,xdsff2)=");
    test(p, "def name(    x1 , xdsff2,   d )     =","def name(x1,xdsff2,d)=");
    test(p,  "  def name  (   ...)=", "def name(...)=");
    test(p,  "    def   name         (adsf   ,...)     =", "def   name(adsf,...)=");
}


TEST(parser, expression_incorrect_input) {
    std::vector<std::tuple<std::string, std::string, int>> simple_examples = {
//            {"10sdf",  "Illegal character 1",    0},
            {"def",  "not expected token EOFT at position",    3},
            {"name",  "not expected token NAME at position",    4},
            {"defname",  "not expected token NAME at position",    7},
            {"def 1sdf",  "Illegal character 1",    4},
            {"def name(",  "not expected token EOFT at position",    9},
            {"def name ...",  "not expected token POINTS at position",    12},
            {"def name(...",  "not expected token EOFT at position",    12},
            {"def name(..., x",  "not expected token COMMA at position",    13},
            {"def name(x ,",  "not expected token EOFT at position",    12},
            {"def name(x ,... ) ",  "not expected token EOFT at position",    18},
            {"def name(x ,... ) = ...",  "not expected token POINTS at position",    23},
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