#pragma once

#include <regex>
#include <map>
#include <string>

enum token {
    DIV, MUL, NUM, LPAREN, RPAREN, WS, PLUS, MINUS, EOFT
};

std::map<token, std::string> reg_expr_map = {
        {DIV, "^\\/"},
        {MUL, "^\\*"},
        {NUM, "^[0-9]+"},
        {LPAREN, "^\\("},
        {RPAREN, "^\\)"},
        {WS, "^[ \\t]+"},
        {PLUS, "^\\+"},
        {MINUS, "^\\-"}};

std::map<token, std::string> token_string_map = {
        {DIV, "DIV"},
        {MUL, "MUL"},
        {NUM, "NUM"},
        {LPAREN, "LPAREN"},
        {RPAREN, "RPAREN"},
        {WS, "WS"},
        {PLUS, "PLUS"},
        {MINUS, "MINUS"},
        {EOFT, "EOFT"}
};


struct parser_exception : std::exception {
    explicit parser_exception(std::string message, size_t pos)
            : msg_(std::move(message)), pos(pos) {}

    virtual ~parser_exception() noexcept {}

    virtual const char *what() const noexcept { return msg_.c_str(); }

    size_t getPos() const {
        return pos;
    }

private:
    std::string msg_;
    size_t pos;
};

struct lexical_analyzer {

    lexical_analyzer(std::istream &source) noexcept(false)
            : source(source), cur_position(0) {
        nextChar();
    }

    void nextToken() noexcept(false) {
        if (cur_read_part.empty() && cur_char == EOF) {
            cur_token = EOFT;
            cur_value_string = "";
            return;
        }
        if (cur_read_part.size() < max_token_size) {
            complete_cur_read_part();
        }
        if (cur_read_part.empty()) {
            throw parser_exception("Cannot get char from input stream", cur_position);
        }
        size_t max_prefix = 0;
        token max_token;
        for (std::pair<const token, std::string> &reg_expr_pair : reg_expr_map) {
            auto cur_regex = std::regex(reg_expr_pair.second);
            std::smatch sm;
            regex_search(cur_read_part, sm, cur_regex);
            if (sm.length() == 0)
                continue;
            size_t cur_match_size = sm[0].length();
            if (cur_match_size != 0 && cur_match_size == max_prefix) {
                throw parser_exception("Two regexp suits one prefix : reg_expr1="
                                       + reg_expr_map[max_token] + " reg_expr2=" + reg_expr_pair.second +
                                       " on string " + sm[0].str(), get_cur_position());
            } else if (cur_match_size > max_prefix) {
                max_token = reg_expr_pair.first;
                max_prefix = cur_match_size;
            }
        }
        if (max_prefix == 0) {
            throw parser_exception("Illegal character " + std::string(1, cur_read_part[0]),
                                   get_cur_position());
        } else {
            cur_value_string = cur_read_part.substr(0, max_prefix);
            cur_read_part.erase(0, cur_value_string.size());
            cur_token = max_token;
        }
    }

    char get_char() { return cur_char; }

    token get_token() { return cur_token; }

    std::string get_value_string() { return cur_value_string; }

    size_t get_cur_position() {
        return cur_position - cur_read_part.length();
    }

private:
    void nextChar() noexcept(false) {
        ++cur_position;
        try {
            cur_char = source.get();
            if (cur_char == EOF){
                --cur_position;
            }
        } catch (std::ios_base::failure &fail) {
            throw parser_exception(fail.what(), cur_position);
        }
    }

    void complete_cur_read_part() {
        while (cur_char != EOF && cur_read_part.size() < max_token_size) {
            cur_read_part += cur_char;
            nextChar();
        }
    }

    std::istream &source;
    char cur_char;
    token cur_token;
    std::string cur_value_string;
    std::string cur_read_part;
    size_t max_token_size = 100;
public:
    size_t cur_position;
};