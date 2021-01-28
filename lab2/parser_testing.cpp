#include "lexical_analyzer.h"
#include "parser.h"
#include <gtest/gtest.h>
#include <iostream>
#include <map>
#include <random>
#include <tuple>
#include <vector>

std::pair<std::vector<token>, std::vector<std::string>> get_tokens(std::string str) noexcept(false) {
    std::istringstream stream(str);
    lexical_analyzer analyzer(stream);
    analyzer.nextToken();
    std::vector<token> tokens;
    std::vector<std::string> names;
    token my_token = analyzer.get_token();
    while (my_token != END) {
        tokens.push_back(my_token);
        if (my_token == NAME) {
            names.push_back(analyzer.get_name());
        }
        analyzer.nextToken();
        my_token = analyzer.get_token();
    }
    tokens.push_back(my_token);
    return {tokens, names};
}

std::string
blank_concat(std::mt19937 &gen, int min_blank_number, int max_blank_number, const std::vector<std::string> &strings,
             const std::vector<int> &blanks) {
    std::uniform_int_distribution<> space_distribution(min_blank_number, max_blank_number);
    std::string cur_string;
    for (int i = 0; i < strings.size(); i++) {
        int random_number = space_distribution(gen);
        cur_string.append(std::max(blanks[i], random_number), ' ');
        cur_string.append(strings[i]);
    }
    cur_string.append(std::max(blanks[blanks.size() - 1], space_distribution(gen)), ' ');
    return cur_string;
}

std::string blank_concat(const std::vector<std::string> &strings,
                         const std::vector<int> &blanks) {
    std::string cur_string;
    for (int i = 0; i < strings.size(); i++) {
        cur_string.append(blanks[i], ' ');
        cur_string.append(strings[i]);
    }
    cur_string.append(blanks[blanks.size() - 1], ' ');
    return cur_string;
}

std::vector<char> spoiling_chars = {'#', '@', '\'', '\"', '&'};


TEST(lexical_analyzer, simple_base_tests) {
    std::vector<std::tuple<std::vector<std::string>, std::vector<token>, std::vector<int>>> vec = {
            {{},                                                    {END},                                                                 {0}},
            {{"def"},                                               {DEF,     END},                                                        {0, 0}},
            {{"def", "name"},                                       {DEF,     NAME,    END},                                               {0, 1, 0}},
            {{"def", "name", "("},                                  {DEF,     NAME,    L_PAREN, END},                                      {0, 1, 0, 0}},
            {{"def", "name", "(", ")"},                             {DEF,     NAME,    L_PAREN, R_PAREN, END},                             {0, 1, 0, 0, 0}},
            {{"def", "name", "(", ")",     "="},                    {DEF,     NAME,    L_PAREN, R_PAREN, EQ,      END},                    {0, 1, 0, 0, 0, 0}},
            {{"def", "name", "(", "name1", ")", "="},               {DEF,     NAME,    L_PAREN, NAME,    R_PAREN, EQ,   END},              {0, 1, 0, 0, 0, 0, 0}},
            {{"def", "name", "(", "name1", ",", "name2", ")", "="}, {DEF,     NAME,    L_PAREN, NAME,    COMMA,   NAME, R_PAREN, EQ, END}, {0, 1, 0, 0, 0, 0, 0, 0, 0}},
            {{"def", "def",  "def"},                                {DEF,     DEF,     DEF,     END},                                      {0, 1, 1, 0}},
            {{",",   "def",  "def"},                                {COMMA,   DEF,     DEF,     END},                                      {0, 0, 1, 0}},
            {{",",   "def1", "def"},                                {COMMA,   NAME,    DEF,     END},                                      {0, 0, 1, 0}},
            {{",",   "def1", "def"},                                {COMMA,   NAME,    END},                                               {0, 0, 0, 0}},
            {{"===="},                                              {EQ,      EQ,      EQ,      EQ,      END},                             {0, 0}},
            {{"(",   ")",    "(", ")"},                             {L_PAREN, R_PAREN, L_PAREN, R_PAREN, END},                             {0, 0, 0, 0, 0}},

    };
    for (auto &p : vec) {
        EXPECT_EQ(std::get<1>(p), get_tokens(blank_concat(std::get<0>(p), std::get<2>(p))).first);
    }
}

std::vector<int> letters_codes = []() -> std::vector<int> {
    std::vector<int> result;
    for (int i = 'a'; i <= 'z'; i++) {
        result.push_back(i);
    }
    for (int i = 'A'; i <= 'Z'; i++) {
        result.push_back(i);
    }
    result.push_back('_');
    return result;
}();

std::vector<int> letters_and_digits_codes = []() -> std::vector<int> {
    std::vector<int> result;
    for (int i = 'a'; i <= 'z'; i++) {
        result.push_back(i);
    }
    for (int i = 'A'; i <= 'Z'; i++) {
        result.push_back(i);
    }
    result.push_back('_');
    for (int i = '0'; i <= '9'; i++) {
        result.push_back(i);
    }
    return result;
}();

bool is_name_token(token &token) {
    return (token == DEF || token == NAME);
}

std::vector<token> get_random_tokens(std::mt19937 &gen, int number_of_tokens) {
    std::vector<token> result;
    result.reserve(number_of_tokens);
    std::uniform_int_distribution<> distribution(0, token::size - 2);// не берем END токен
    for (int i = 0; i < number_of_tokens; i++) {
        result.push_back(token(distribution(gen)));
    }
    result.push_back(END);
    return result;
}

std::vector<token> get_random_correct_tokens(int number_of_args) {
    std::vector<token> result = {DEF, NAME, L_PAREN};
    if (number_of_args > 0) {
        result.push_back(NAME);
    }
    for (int i = 2; i <= number_of_args; i++) {
        result.push_back(COMMA);
        result.push_back(NAME);
    }
    result.push_back(R_PAREN);
    result.push_back(EQ);
    result.push_back(END);
    return result;
}

std::string get_random_name(std::mt19937 &gen, int size) {
    std::uniform_int_distribution<> letters_distribution(0, letters_codes.size() - 1);// не берем END токен
    std::uniform_int_distribution<> letters_and_digits_distribution(0, letters_and_digits_codes.size() -
                                                                       1);// не берем END токен
    std::string result;
    result += (char) letters_codes[letters_distribution(gen)];
    for (int i = 2; i <= size; i++) {
        result += (char) (letters_and_digits_codes[letters_and_digits_distribution(gen)]);
    }
    return result;
}

std::tuple<std::vector<std::string>, std::vector<int>, std::vector<std::string>>
get_random_token_representation(std::mt19937 &gen, int min_name_length, int max_name_length,
                                std::vector<token> &tokens, bool correct_names = true) {
    std::uniform_int_distribution<> name_length_distribution(min_name_length, max_name_length);

    std::vector<std::string> strings;
    strings.reserve(tokens.size());
    std::vector<int> blanks;
    blanks.reserve(tokens.size() + 1);
    std::vector<std::string> names;

    for (int i = 0; i < tokens.size() - 1; i++) {
        token cur_token = tokens[i];
        switch (cur_token) {
            case DEF:
                strings.emplace_back("def");
                break;
            case L_PAREN:
                strings.emplace_back("(");
                break;
            case R_PAREN:
                strings.emplace_back(")");
                break;
            case COMMA:
                strings.emplace_back(",");
                break;
            case EQ:
                strings.emplace_back("=");
                break;
            case POINTS:
                strings.emplace_back("...");
                break;
            case NAME:
                std::string name = get_random_name(gen, name_length_distribution(gen));
                if (!correct_names) {
                    name = std::to_string(std::uniform_int_distribution<>(0, 10000)(gen)) + name;
                }
                strings.push_back(name);
                names.push_back(name);
                break;
        }
        if (is_name_token(cur_token) && i > 0 && is_name_token(tokens[i - 1])) {
            blanks.push_back(1);
        } else {
            blanks.push_back(0);
        }
    }
    blanks.push_back(0);
    return {strings, blanks, names};
}

TEST(lexical_analyzer, random_base_tests) {
    const int NUMBER_OF_RUNS = 1000;
    const int MAX_TOKEN_NUMBER = 1000;
    const int MIN_TOKEN_NUMBER = 1;
    const int MAX_NAME_LENGTH = 20;
    const int MIN_NAME_LENGTH = 1;

    std::uniform_int_distribution<> token_distribution(MIN_TOKEN_NUMBER, MAX_TOKEN_NUMBER);

    std::mt19937 gen(time(0));
    for (int i = 0; i < NUMBER_OF_RUNS; ++i) {
        std::vector<token> expected_tokens = get_random_tokens(gen, token_distribution(gen));
        auto[strings, blanks, expected_names] = get_random_token_representation(gen, MIN_NAME_LENGTH, MAX_NAME_LENGTH,
                                                                                expected_tokens);
        auto[actual_tokens, actual_names] = get_tokens(blank_concat(strings, blanks));
        EXPECT_EQ(expected_tokens, actual_tokens);
        EXPECT_EQ(expected_names, actual_names);
    }
}

TEST(lexical_analyzer, random_blank_tests) {
    const int NUMBER_OF_RUNS = 1000;
    const int MAX_TOKEN_NUMBER = 1000;
    const int MIN_TOKEN_NUMBER = 1;
    const int MAX_NAME_LENGTH = 20;
    const int MIN_NAME_LENGTH = 1;
    const int MAX_SPACE_NUMBER = 15;
    const int MIN_SPACE_NUMBER = 0;

    std::uniform_int_distribution<> token_distribution(MIN_TOKEN_NUMBER, MAX_TOKEN_NUMBER);

    std::mt19937 gen(time(0));
    for (int i = 0; i < NUMBER_OF_RUNS; ++i) {
        std::vector<token> expected_tokens = get_random_tokens(gen, token_distribution(gen));
        auto[strings, blanks, expected_names] = get_random_token_representation(gen, MIN_NAME_LENGTH, MAX_NAME_LENGTH,
                                                                                expected_tokens);
        auto[actual_tokens, actual_names] = get_tokens(
                blank_concat(gen, MIN_SPACE_NUMBER, MAX_SPACE_NUMBER, strings, blanks));
        EXPECT_EQ(expected_tokens, actual_tokens);
        EXPECT_EQ(expected_names, actual_names);
    }
}


std::tuple<std::string, char, int> spoil_string(std::mt19937 &gen, std::string &basicString) {
    std::uniform_int_distribution<> string_pos_distribution(0, basicString.size());
    std::uniform_int_distribution<> spoiling_char_distribution(0, spoiling_chars.size() - 1);
    int position = string_pos_distribution(gen);
    char spoil_char = spoiling_chars[spoiling_char_distribution(gen)];
    std::string result;

    if (position == 0) {
        result = spoil_char + basicString;
    } else if (position == basicString.size()) {
        result = basicString + spoil_char;
    } else {
        result = basicString.substr(0, position) + spoil_char + basicString.substr(position, std::string::npos);
    }
    return {result, spoil_char, position};
}

TEST(lexical_analyzer, unknown_symbol_parser_excepion) {
    const int NUMBER_OF_RUNS = 5000;
    const int MAX_TOKEN_NUMBER = 10;
    const int MIN_TOKEN_NUMBER = 1;
    const int MAX_NAME_LENGTH = 10;
    const int MIN_NAME_LENGTH = 1;
    const int MAX_SPACE_NUMBER = 10;
    const int MIN_SPACE_NUMBER = 0;

    std::uniform_int_distribution<> token_distribution(MIN_TOKEN_NUMBER, MAX_TOKEN_NUMBER);

    std::mt19937 gen(time(0));
    for (int i = 0; i < NUMBER_OF_RUNS; ++i) {
        std::vector<token> expected_tokens = get_random_tokens(gen, token_distribution(gen));
        auto[strings, blanks, expected_names] = get_random_token_representation(gen, MIN_NAME_LENGTH, MAX_NAME_LENGTH,
                                                                                expected_tokens);
        std::string correct_input = blank_concat(gen, MIN_SPACE_NUMBER, MAX_SPACE_NUMBER, strings, blanks);
        std::tuple<std::string, char, int> incorrect_input = spoil_string(gen, correct_input);
        try {
            get_tokens(std::get<0>(incorrect_input));
            FAIL() << "get_tokens(incorrect_input) should throw a parser exception\n";
        } catch (parser_exception &exception) {
            EXPECT_EQ(std::string(exception.what()),
                      "Illegal character " + std::string(1, std::get<1>(incorrect_input)));
            EXPECT_EQ(exception.getPos(), std::get<2>(incorrect_input) + 1);
        }
    }
}


TEST(lexical_analyzer, incorrect_name_parser_excepion) {
    const int NUMBER_OF_RUNS = 5000;
    const int MAX_TOKEN_NUMBER = 10;
    const int MIN_TOKEN_NUMBER = 1;
    const int MAX_NAME_LENGTH = 10;
    const int MIN_NAME_LENGTH = 1;
    const int MAX_SPACE_NUMBER = 10;
    const int MIN_SPACE_NUMBER = 0;

    std::uniform_int_distribution<> token_distribution(MIN_TOKEN_NUMBER, MAX_TOKEN_NUMBER);

    std::mt19937 gen(time(0));
    int counter = 0;
    while (counter != NUMBER_OF_RUNS) {
        std::vector<token> expected_tokens = get_random_tokens(gen, token_distribution(gen));
        if (std::find(expected_tokens.begin(), expected_tokens.end(), NAME) == expected_tokens.end()) {
            continue;
        }
        ++counter;
        auto[strings, blanks, expected_names] = get_random_token_representation(gen, MIN_NAME_LENGTH, MAX_NAME_LENGTH,
                                                                                expected_tokens, false);
        std::string correct_input = blank_concat(gen, MIN_SPACE_NUMBER, MAX_SPACE_NUMBER, strings, blanks);
        try {
            get_tokens(correct_input);
            FAIL() << "get_tokens(incorrect_input) should throw a parser exception\n";
        } catch (parser_exception &exception) {
            EXPECT_EQ(std::string(exception.what()),
                      "Illegal character " + std::string(1, expected_names[0][0]));
        }
    }
}

std::string parse_and_put_in_string(const std::string &str, parser &p) {
    std::string res;
    std::istringstream stream(str);
    tree *root = p.parse(stream);
    std::ostringstream ostream;
    ostream << *root;

    std::string df = ostream.str();
    delete root;
    return df;
}

void create_graph(const std::string& file_name, parser &p,
                  std::string &str) {
    std::string res;
    std::istringstream stream(str);
    tree *root = p.parse(stream);
    std::ofstream fout("graphs/" + file_name);
    fout << "digraph G {\n";
    root->create_graph(fout);
    fout << "}\n";
    delete root;
}

TEST(parser, simple_base_examples) {
    parser p;
    std::vector<std::string> simple_examples = {
            "def hello ( ) = ",
            "def hello1 ( hi1 ) = ",
            "def hello2 ( hi1 , hi2 ) = ",
            "def hello3 ( hi1 , hi2 , hi3 ) = ",
            "def hello4 ( hi1 , hi2 , hi3 , hi4 ) = ",
            "def helloV ( ... ) = ",
            "def helloV ( arg1 , ... ) = ",
            "def helloV ( arg1 , arg2 , ... ) = ",
            "def helloV ( arg1 , arg2 , arg3 , arg4 , ... ) = ",
    };
    for (auto &ex: simple_examples) {
        EXPECT_EQ(ex, parse_and_put_in_string(ex, p));
    }
    for (int i = 0; i < simple_examples.size(); i++) {
        create_graph("graph" + std::to_string(i) + ".txt", p, simple_examples[i]);
    }
}


std::string simple_token_representation(std::vector<std::string> &vec) {
    std::vector<int> blanks(1, 0);
    for (int i = 0; i < vec.size(); ++i) {
        blanks.push_back(1);
    }
    return blank_concat(vec, blanks);
}

TEST(parser, random_correct_input_tests) {
    parser p;
    const int NUMBER_OF_RUNS = 1000;
    const int MAX_ARGUMENTS_NUMBER = 1000;
    const int MIN_ARGUMENTS_NUMBER = 1;
    const int MAX_NAME_LENGTH = 20;
    const int MIN_NAME_LENGTH = 1;
    const int MAX_SPACE_NUMBER = 15;
    const int MIN_SPACE_NUMBER = 0;

    std::uniform_int_distribution<> args_distribution(MIN_ARGUMENTS_NUMBER, MAX_ARGUMENTS_NUMBER);

    std::mt19937 gen(time(0));
    for (int i = 0; i < NUMBER_OF_RUNS; ++i) {
        std::vector<token> expected_tokens = get_random_correct_tokens(args_distribution(gen));
        auto[strings, blanks, expected_names] = get_random_token_representation(gen, MIN_NAME_LENGTH, MAX_NAME_LENGTH,
                                                                                expected_tokens);
        std::string random_example = blank_concat(gen, MIN_SPACE_NUMBER, MAX_SPACE_NUMBER, strings, blanks);
        EXPECT_EQ(simple_token_representation(strings), parse_and_put_in_string(random_example, p));
    }
}


TEST(parser, incorrect_input_tests) {
    std::vector<std::tuple<std::string, std::string, int>> simple_examples = {
            {"hello ( ) = ",              "def expected at position",                6},
            {"def ( ) = ",                "name of function expected at position",   6},
            {"def hello ) = ",            "\"(\" expected at position",              12},
            {"def hello arg1 ) = ",       "\"(\" expected at position",              15},
            {"def hello ( = ",            "not expected token at position",          14},
            {"def hello ( arg1 = ",       "not expected token at position",          19},
            {"def hello ()  ",            "\"=\" expected at position",              15},
            {"def hello () = smth",       "Expected end of input steam at position", 20},
            {"def hello (,) = ",          "not expected token at position",          13},
            {"def hello (arg1,) = ",      "Name of argument of points expected at position",   18},
            {"def hello (arg1, arg2,) =", "Name of argument of points expected at position",   24},
            {"def hello (arg1) , = ",     "\"=\" expected at position",              19},
            {"def hello (arg1 arg2) = ",  "not expected token at position",          21},
            {"def hello (,arg1,arg2) = ",  "not expected token at position",          13},
            {"def hello ( ... , arg1) = ",  "\")\" expected at position",          17},
            {"def hello  ( arg1) = ",  "\")\" expected at position",          17},
    };


    for (auto &t : simple_examples) {
        try {
            parser p;
            parse_and_put_in_string(std::get<0>(t), p);
            FAIL() << "parse_and_put_in_string(" << std::get<0>(t) << ")  should throw a parser exception\n";
        } catch (parser_exception &exception) {
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
