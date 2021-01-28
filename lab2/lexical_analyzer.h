#pragma once

#include <fstream>
#include <iostream>
#include <utility>
#include <vector>
#include <map>
#include <sstream>
#include <string>

enum token {
    DEF, NAME, L_PAREN, R_PAREN, COMMA, POINTS, EQ, END, size = 8
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
        while (is_blank(cur_char)) {
            nextChar();
        }
        if (cur_char == EOF) {
            cur_token = END;
            return;
        }

        if (is_name_or_def())
            return;

        switch (cur_char) {
            case '(':
                nextChar();
                cur_token = L_PAREN;
                break;
            case ')':
                nextChar();
                cur_token = R_PAREN;
                break;
            case ',':
                nextChar();
                cur_token = COMMA;
                break;
            case '=':
                nextChar();
                cur_token = EQ;
                break;
            case '.':
                if (check_multipoints()){
                    cur_token = POINTS;
                    break;
                }

            default:
                throw parser_exception("Illegal character " + std::string(1, cur_char), cur_position);
        }
    }

    char get_char() { return cur_char; }

    token get_token() { return cur_token; }

    std::string get_name() { return cur_name; }

private:
    void nextChar() noexcept(false) {
        ++cur_position;
        try {
            cur_char = source.get();
        } catch (std::ios_base::failure &fail) {
            throw parser_exception(fail.what(), cur_position);
        }
    }

    bool is_blank(char ch) {
        return ch == ' ' || ch == '\r' || ch == '\t' || ch == '\n';
    }

    bool is_name_or_def() {
        std::string name;
        if (isalpha(cur_char) || cur_char == '_') {
            name += cur_char;
            nextChar();
            while (isalpha(cur_char) || cur_char == '_' || isdigit(cur_char)) {
                name += cur_char;
                nextChar();
            }
            if (name == "def") {
                cur_token = DEF;
                return true;
            }
            cur_name = name;
            cur_token = NAME;
            return true;
        }
        return false;
    }

    bool check_multipoints(){
        nextChar();
        if (cur_char == '.'){
            nextChar();
            if (cur_char=='.'){
                nextChar();
                return true;
            }
            return false;
        }
        return false;
    }

    std::istream &source;
    char cur_char;
    token cur_token;
    std::string cur_name;
public:
    size_t cur_position;
};
