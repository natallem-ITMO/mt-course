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

struct input_node : public node {
    input_node() : node("input") {};

    ~input_node() override = default;
    int val;
};

struct t_node : public node {
    t_node() : node("t") {};

    ~t_node() override = default;
    int val;
};

struct e_node : public node {
    e_node() : node("e") {};

    ~e_node() override = default;
    int val;
};

struct f_node : public node {
    f_node() : node("f") {};

    ~f_node() override = default;
    int val;
};

struct e1_node : public node {
    e1_node() : node("e1") {};

    ~e1_node() override = default;
    int acc;

    int val;
};

struct t1_node : public node {
    t1_node() : node("t1") {};

    ~t1_node() override = default;
    int acc;

    int val;
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
        unique_ptr<input_node> ptr = make_unique<input_node>();
        input(ptr.get());
        delete lex_analyzer;
        lex_analyzer = nullptr;
        input_node * result = ptr.release();
        return result;
    }

    void input(input_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == NUM || lex_analyzer->get_token() == LPAREN || lex_analyzer->get_token() == MINUS) {
                input_node &input_ = *cur_node;
                unique_ptr<e_node> e_ptr = std::make_unique<e_node>();
                e_node &e_ = *e_ptr;
                unique_ptr<node> _1ptr = std::make_unique<node>("EOFT");
                node &_1 = *_1ptr;

                e(&e_);
                e_ptr.release();
                input_.children.push_back(&e_);

                while (true) {
                    if (lex_analyzer->get_token() == EOFT) {
                        _1.value = lex_analyzer->get_value_string();
                        _1ptr.release();
                        input_.children.push_back(&_1);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                {input_.val = e_.val;}
                return;
            }
            check_no_token();
        }

    }

    void t(t_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == NUM || lex_analyzer->get_token() == LPAREN || lex_analyzer->get_token() == MINUS) {
                t_node &t_ = *cur_node;
                unique_ptr<f_node> f_ptr = std::make_unique<f_node>();
                f_node &f_ = *f_ptr;
                unique_ptr<t1_node> t1_ptr = std::make_unique<t1_node>();
                t1_node &t1_ = *t1_ptr;

                f(&f_);
                f_ptr.release();
                t_.children.push_back(&f_);

                {t1_.acc = f_.val;}

                t1(&t1_);
                t1_ptr.release();
                t_.children.push_back(&t1_);

                {t_.val = t1_.val;}
                return;
            }
            check_no_token();
        }

    }

    void e(e_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == NUM || lex_analyzer->get_token() == LPAREN || lex_analyzer->get_token() == MINUS) {
                e_node &e_ = *cur_node;
                unique_ptr<t_node> t_ptr = std::make_unique<t_node>();
                t_node &t_ = *t_ptr;
                unique_ptr<e1_node> e1_ptr = std::make_unique<e1_node>();
                e1_node &e1_ = *e1_ptr;

                t(&t_);
                t_ptr.release();
                e_.children.push_back(&t_);

                {e1_.acc = t_.val;}

                e1(&e1_);
                e1_ptr.release();
                e_.children.push_back(&e1_);

                {e_.val = e1_.val;}
                return;
            }
            check_no_token();
        }

    }

    void f(f_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == NUM) {
                f_node &f_ = *cur_node;
                unique_ptr<node> numptr = std::make_unique<node>("NUM");
                node &num = *numptr;

                while (true) {
                    if (lex_analyzer->get_token() == NUM) {
                        num.value = lex_analyzer->get_value_string();
                        numptr.release();
                        f_.children.push_back(&num);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                {f_.val = std::stoi(num.value);}
                return;
            }

            if (lex_analyzer->get_token() == MINUS) {
                f_node &f_ = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("MINUS");
                node &_0 = *_0ptr;
                unique_ptr<node> numptr = std::make_unique<node>("NUM");
                node &num = *numptr;

                while (true) {
                    if (lex_analyzer->get_token() == MINUS) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        f_.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                while (true) {
                    if (lex_analyzer->get_token() == NUM) {
                        num.value = lex_analyzer->get_value_string();
                        numptr.release();
                        f_.children.push_back(&num);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                {f_.val = -std::stoi(num.value);}
                return;
            }

            if (lex_analyzer->get_token() == LPAREN) {
                f_node &f_ = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("LPAREN");
                node &_0 = *_0ptr;
                unique_ptr<e_node> e_ptr = std::make_unique<e_node>();
                e_node &e_ = *e_ptr;
                unique_ptr<node> _3ptr = std::make_unique<node>("RPAREN");
                node &_3 = *_3ptr;

                while (true) {
                    if (lex_analyzer->get_token() == LPAREN) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        f_.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                e(&e_);
                e_ptr.release();
                f_.children.push_back(&e_);

                {f_.val = e_.val ;}

                while (true) {
                    if (lex_analyzer->get_token() == RPAREN) {
                        _3.value = lex_analyzer->get_value_string();
                        _3ptr.release();
                        f_.children.push_back(&_3);
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

    void e1(e1_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == PLUS) {
                e1_node &e_one = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("PLUS");
                node &_0 = *_0ptr;
                unique_ptr<t_node> t_ptr = std::make_unique<t_node>();
                t_node &t_ = *t_ptr;
                unique_ptr<e1_node> e1_twoptr = std::make_unique<e1_node>();
                e1_node &e1_two = *e1_twoptr;

                while (true) {
                    if (lex_analyzer->get_token() == PLUS) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        e_one.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                t(&t_);
                t_ptr.release();
                e_one.children.push_back(&t_);

                {e1_two.acc = t_.val + e_one.acc;}

                e1(&e1_two);
                e1_twoptr.release();
                e_one.children.push_back(&e1_two);

                { e_one.val = e1_two.val;}
                return;
            }

            if (lex_analyzer->get_token() == MINUS) {
                e1_node &e_one = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("MINUS");
                node &_0 = *_0ptr;
                unique_ptr<t_node> t_ptr = std::make_unique<t_node>();
                t_node &t_ = *t_ptr;
                unique_ptr<e1_node> e1_twoptr = std::make_unique<e1_node>();
                e1_node &e1_two = *e1_twoptr;

                while (true) {
                    if (lex_analyzer->get_token() == MINUS) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        e_one.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                t(&t_);
                t_ptr.release();
                e_one.children.push_back(&t_);

                {e1_two.acc =  e_one.acc - t_.val;}

                e1(&e1_two);
                e1_twoptr.release();
                e_one.children.push_back(&e1_two);

                { e_one.val = e1_two.val;}
                return;
            }

            if (lex_analyzer->get_token() == EOFT || lex_analyzer->get_token() == RPAREN) {
                e1_node &e1_ = *cur_node;


                {e1_.val = e1_.acc;}
                return;
            }
            check_no_token();
        }

    }

    void t1(t1_node *cur_node) {
        while (true) {
            if (lex_analyzer->get_token() == MUL) {
                t1_node &t_one = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("MUL");
                node &_0 = *_0ptr;
                unique_ptr<f_node> f_ptr = std::make_unique<f_node>();
                f_node &f_ = *f_ptr;
                unique_ptr<t1_node> t1_twoptr = std::make_unique<t1_node>();
                t1_node &t1_two = *t1_twoptr;

                while (true) {
                    if (lex_analyzer->get_token() == MUL) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        t_one.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                f(&f_);
                f_ptr.release();
                t_one.children.push_back(&f_);

                {t1_two.acc = f_.val * t_one.acc;}

                t1(&t1_two);
                t1_twoptr.release();
                t_one.children.push_back(&t1_two);

                { t_one.val = t1_two.val;}
                return;
            }

            if (lex_analyzer->get_token() == DIV) {
                t1_node &t_one = *cur_node;
                unique_ptr<node> _0ptr = std::make_unique<node>("DIV");
                node &_0 = *_0ptr;
                unique_ptr<f_node> f_ptr = std::make_unique<f_node>();
                f_node &f_ = *f_ptr;
                unique_ptr<t1_node> t1_twoptr = std::make_unique<t1_node>();
                t1_node &t1_two = *t1_twoptr;

                while (true) {
                    if (lex_analyzer->get_token() == DIV) {
                        _0.value = lex_analyzer->get_value_string();
                        _0ptr.release();
                        t_one.children.push_back(&_0);
                        lex_analyzer->nextToken();
                        break;
                    }
                    check_no_token();
                }

                f(&f_);
                f_ptr.release();
                t_one.children.push_back(&f_);

                {t1_two.acc =  t_one.acc / f_.val;}

                t1(&t1_two);
                t1_twoptr.release();
                t_one.children.push_back(&t1_two);

                { t_one.val = t1_two.val;}
                return;
            }

            if (lex_analyzer->get_token() == EOFT || lex_analyzer->get_token() == RPAREN || lex_analyzer->get_token() == PLUS || lex_analyzer->get_token() == MINUS) {
                t1_node &t1_ = *cur_node;


                {t1_.val = t1_.acc;}
                return;
            }
            check_no_token();
        }

    }
};
