#pragma once
#include <initializer_list>
#include <set>
#include <memory>
#include "lexical_analyzer.h"

using namespace std;

struct node {
    node() = default;;

    explicit node(std::string &&node_) :
            node_name(std::move(node_)) {}

    virtual  ~node() {
        for (auto t : children) {
            delete t;
        }
    }

    friend bool operator==(const node &, const node &);

    std::string value;
    std::string node_name;
    std::vector<node *> children;
};

inline bool operator==(const node &lhs, const node &rhs) {
    return lhs.value == rhs.value && lhs.children == rhs.children && lhs.node_name == rhs.node_name;
}

inline bool operator!=(const node &lhs, const node &rhs) {
    return !(lhs == rhs);
}
std::ostream &operator<<(std::ostream &os, const node &dt) {
    if (dt.children.empty()) {
        os << dt.value;
    } else {
        for (auto i : dt.children) {
            os << *i;
        }
    }
    return os;
}

struct p_node : public node {
    p_node() : node("p") {};

    ~p_node() override = default;
};

struct s_node : public node {
    s_node() : node("s") {};

    ~s_node() override = default;
};

struct t_node : public node {
    t_node() : node("t") {};

    ~t_node() override = default;
};

struct g_node : public node {
    g_node() : node("g") {};

    ~g_node() override = default;
};
set<token> skipped_tokens = {WS};

struct parser {
    lexical_analyzer *lex_analyzer = nullptr;

    ~parser() {
        if (lex_analyzer != nullptr) {
            delete lex_analyzer;
        }
    }

    void check_no_token() noexcept(false) {
        if (skipped_tokens.contains(lex_analyzer->get_token())) {
            lex_analyzer->nextToken();
            return;
        }
        throw parser_exception("not expected token " + token_string_map[lex_analyzer->get_token()] + " at position",
                               lex_analyzer->get_cur_position());
    }

    node *parse(std::istream &source) noexcept(false) {
        lex_analyzer = new lexical_analyzer(source);
        lex_analyzer->nextToken();
        unique_ptr<s_node> ptr = make_unique<s_node>();
        s(ptr.get());
        delete lex_analyzer;
        lex_analyzer = nullptr;
        s_node * result = ptr.release();
        return result;
    }

    void p(p_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == R_PAREN) {
                p_node &_ = *cur_node;

                return;
            }

            if (lex_analyzer->get_token() == POINTS) {
                p_node &_ = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("POINTS");
                node &_0 = *_0ptr;

                while (true) {
                    if (lex_analyzer->get_token() == POINTS) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        _.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }
                return;
            }

            if (lex_analyzer->get_token() == NAME) {
                p_node &_ = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("NAME");
                node &_0 = *_0ptr;
                unique_ptr<t_node> _1ptr = std::make_unique<t_node>();
                t_node &_1 = *_1ptr;

                while (true) {
                    if (lex_analyzer->get_token() == NAME) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        _.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                t(&_1);
                _1ptr.release();
                _.children.push_back(&_1);
                return;
            }
            check_no_token();
        }

    }

    void s(s_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == DEF) {
                s_node &_ = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("DEF");
                node &_0 = *_0ptr;
                unique_ptr<node> _1ptr = std::make_unique<node>("WS");
                node &_1 = *_1ptr;
                unique_ptr<node> _2ptr = std::make_unique<node>("NAME");
                node &_2 = *_2ptr;
                unique_ptr<node> _3ptr = std::make_unique<node>("L_PAREN");
                node &_3 = *_3ptr;
                unique_ptr<p_node> _4ptr = std::make_unique<p_node>();
                p_node &_4 = *_4ptr;
                unique_ptr<node> _5ptr = std::make_unique<node>("R_PAREN");
                node &_5 = *_5ptr;
                unique_ptr<node> _6ptr = std::make_unique<node>("EQ");
                node &_6 = *_6ptr;
                unique_ptr<node> _7ptr = std::make_unique<node>("EOFT");
                node &_7 = *_7ptr;

                while (true) {
                    if (lex_analyzer->get_token() == DEF) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        _.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                while (true) {
                    if (lex_analyzer->get_token() == WS) {
                        _1.value = lex_analyzer->get_value_string();
                        _1ptr.release();
                        _.children.push_back(&_1);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                while (true) {
                    if (lex_analyzer->get_token() == NAME) {
                        _2.value = lex_analyzer->get_value_string();
                        _2ptr.release();
                        _.children.push_back(&_2);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                while (true) {
                    if (lex_analyzer->get_token() == L_PAREN) {
                        _3.value = lex_analyzer->get_value_string();
                        _3ptr.release();
                        _.children.push_back(&_3);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                p(&_4);
                _4ptr.release();
                _.children.push_back(&_4);

                while (true) {
                    if (lex_analyzer->get_token() == R_PAREN) {
                        _5.value = lex_analyzer->get_value_string();
                        _5ptr.release();
                        _.children.push_back(&_5);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                while (true) {
                    if (lex_analyzer->get_token() == EQ) {
                        _6.value = lex_analyzer->get_value_string();
                        _6ptr.release();
                        _.children.push_back(&_6);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                while (true) {
                    if (lex_analyzer->get_token() == EOFT) {
                        _7.value = lex_analyzer->get_value_string();
                        _7ptr.release();
                        _.children.push_back(&_7);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }
                return;
            }
            check_no_token();
        }

    }

    void t(t_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == COMMA) {
                t_node &_ = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("COMMA");
                node &_0 = *_0ptr;
                unique_ptr<g_node> _1ptr = std::make_unique<g_node>();
                g_node &_1 = *_1ptr;

                while (true) {
                    if (lex_analyzer->get_token() == COMMA) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        _.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                g(&_1);
                _1ptr.release();
                _.children.push_back(&_1);
                return;
            }

            if (lex_analyzer->get_token() == R_PAREN) {
                t_node &_ = *cur_node;

                return;
            }
            check_no_token();
        }

    }

    void g(g_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == NAME) {
                g_node &_ = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("NAME");
                node &_0 = *_0ptr;
                unique_ptr<t_node> _1ptr = std::make_unique<t_node>();
                t_node &_1 = *_1ptr;

                while (true) {
                    if (lex_analyzer->get_token() == NAME) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        _.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                t(&_1);
                _1ptr.release();
                _.children.push_back(&_1);
                return;
            }

            if (lex_analyzer->get_token() == POINTS) {
                g_node &_ = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("POINTS");
                node &_0 = *_0ptr;

                while (true) {
                    if (lex_analyzer->get_token() == POINTS) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        _.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }
                return;
            }
            check_no_token();
        }

    }
};
