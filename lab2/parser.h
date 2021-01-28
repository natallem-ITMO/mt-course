#pragma once

#include <initializer_list>
#include <vector>
#include <string>
#include "lexical_analyzer.h"

struct tree {

    tree(std::string &&mode) :
            node(std::move(mode)) {}

    tree(std::string &&mode, std::initializer_list<tree *> inputs) :
            node(std::move(mode)), children(inputs) {}

    tree(std::string &&mode, std::string &&name, std::initializer_list<tree *> inputs) :
            node(std::move(mode)), children(inputs), name(std::move(name)) {}

    tree(std::string &&mode, std::string &&name) :
            node(std::move(mode)), name(std::move(name)) {}


    ~tree() {
        for (auto t : children) {
            delete t;
        }
    }

    void create_graph(std::ofstream & fout){
        fout <<(size_t) this << " [label=\""<< node;
        if (!name.empty()){
            fout << "\\n{" << name << "}";
        }
        fout << "\"];\n";
        for (auto t : children){
            fout << (size_t) this<< " -> " <<(size_t) t << ";\n";
            t -> create_graph(fout);
        }
    }

    friend bool operator==(const tree &, const tree &);

private:
    std::string node;
    std::vector<tree *> children;
    std::string name;

    friend std::ostream &operator<<(std::ostream &os, const tree &dt);
};

std::ostream &operator<<(std::ostream &os, const tree &dt) {
    if (dt.children.empty()) {
        if (dt.name.empty()) {
            if (dt.node != "P" && dt.node!="T")
                os << dt.node << " ";
        } else {
            os << dt.name << " ";
        }
    } else {
        for (auto i : dt.children) {
            os << *i;
        }
    }
    return os;
}

inline bool operator==(const tree &lhs, const tree &rhs) {
    return lhs.name == rhs.name && lhs.children == rhs.children && lhs.node == rhs.node;
}

inline bool operator!=(const tree &lhs, const tree &rhs) {
    return !(lhs == rhs);
}

struct parser {
    lexical_analyzer *lex_analyzer = nullptr;

    ~parser() {
        if (lex_analyzer != nullptr){
            delete lex_analyzer;
        }
    }

    tree *S() noexcept(false) {
        if (lex_analyzer->get_token() != DEF) {
            throw parser_exception("def expected at position", lex_analyzer->cur_position);
        }
        lex_analyzer->nextToken();
        if (lex_analyzer->get_token() != NAME) {
            throw parser_exception("name of function expected at position", lex_analyzer->cur_position);
        }
        std::string function_name = std::move(lex_analyzer->get_name());
        lex_analyzer->nextToken();
        if (lex_analyzer->get_token() != L_PAREN) {
            throw parser_exception("\"(\" expected at position", lex_analyzer->cur_position);
        }
        lex_analyzer->nextToken();
        tree *sub_p = P();
        if (lex_analyzer->get_token() != R_PAREN) {
            delete sub_p;
            throw parser_exception("\")\" expected at position", lex_analyzer->cur_position);
        }
        lex_analyzer->nextToken();
        if (lex_analyzer->get_token() != EQ) {
            delete sub_p;
            throw parser_exception("\"=\" expected at position", lex_analyzer->cur_position);
        }
        lex_analyzer->nextToken();
        if (lex_analyzer->get_token() != END) {
            delete sub_p;
            throw parser_exception("Expected end of input steam at position", lex_analyzer->cur_position);
        }
        return new tree("S", {new tree("def"), new tree("name", std::move(function_name)), new tree("("), sub_p,
                              new tree(")"), new tree("=")});

    }

    tree *P() {
        switch (lex_analyzer->get_token()) {
            case R_PAREN: {
                return new tree("P");
            }
            case NAME: {
                std::string cur_name = lex_analyzer->get_name();
                lex_analyzer->nextToken();
                tree *sub_t = T();
                return new tree("P", {new tree("name", std::move(cur_name)), sub_t});
            }
            case POINTS:{
                lex_analyzer -> nextToken();
                return new tree("P", {new tree("...")});
            }
            default: {
                throw parser_exception("not expected token at position", lex_analyzer->cur_position);
            }
        }
    }

    tree *T() {
        switch (lex_analyzer->get_token()) {
            case R_PAREN: {
                return new tree("T");
            }
            case COMMA: {
                lex_analyzer->nextToken();
                switch (lex_analyzer->get_token()){
                    case NAME: {
                        std::string cur_name = lex_analyzer->get_name();
                        lex_analyzer->nextToken();
                        tree *sub_t = T();
                        return new tree("T", {new tree(","), new tree("name", std::move(cur_name)), sub_t});

                    }
                    case POINTS:{
                        lex_analyzer -> nextToken();
                        return new tree("T", {new tree(","), new tree("...")});
                    }
                    default:
                        throw parser_exception("Name of argument of points expected at position", lex_analyzer->cur_position);
                }
            }

            default: {
                throw parser_exception("not expected token at position", lex_analyzer->cur_position);
            }
        }
    }

    tree *parse(std::istream &source) noexcept(false) {
        lex_analyzer = new lexical_analyzer(source);
        lex_analyzer->nextToken();
        tree * res = S();
        delete lex_analyzer;
        lex_analyzer = nullptr;
        return res;
    }
};
