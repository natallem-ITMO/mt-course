grammar GrammarForGrammar;

grammar_file : (rule)+ EOF;

rule : (non_term_rule | term_rule) NL ;

non_term_rule : not_terminal '->' (terminal | not_terminal)+ ;

term_rule : not_terminal '->' '\'' reg_expr '\''

reg_expr :

terminal : TERMINAL | '^' ;
TERMINAL : [A-Z] [A-Z0-9]* ;
not_terminal : NOT_TERMINAL ;
NOT_TERMINAL : [a-z] [a-z0-9]* ;

NL : '\r'? '\n' ;

