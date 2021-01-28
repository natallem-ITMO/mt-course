grammar GrammarForGrammar;

grammar_file : (grammar_rule NL | NL)+ EOF;

grammar_rule : (non_term_rule | term_rule | non_term_description);

non_term_rule : non_terminal '->' (non_term_right_part)+ ;

non_term_right_part
    : terminal #terminalRule
    | non_terminal #nonTerminalRule
    | ANY_CODE #attributeRule;

term_rule : TERMINAL '->' ANY_CODE ('#' 'skip')? ;


synth_attr_desc : '[' 'return' ((TERMINAL | NOT_TERMINAL | ANY_NAME) (TERMINAL | NOT_TERMINAL | ANY_NAME) ';' )+ ']' ;
inherit_attr_desc : '[[' ((TERMINAL | NOT_TERMINAL | ANY_NAME) (TERMINAL | NOT_TERMINAL | ANY_NAME) ';' )+ ']]' ;

non_terminal
    : NOT_TERMINAL #simple_non_terminal
    | NAME '=' NOT_TERMINAL #assignment_non_terminal ;

terminal
    : NAME '=' TERMINAL #assignment_terminal
    | TERMINAL #simple_terminal
    | '^' #epsilon ;

non_term_description : NOT_TERMINAL (synth_attr_desc)? (inherit_attr_desc)? ;

TERMINAL : [A-Z] [A-Z0-9_]* ;
NOT_TERMINAL : [a-z] [a-z0-9_]* ;
ANY_NAME : [A-Za-z_] [A-Za-z0-9_]* ;
NAME : '$' ANY_NAME ;
WS : [ \t]+ -> skip ;
NL : '\r'? '\n';
ANY_CODE : '{' ~[}]+? '}' ;

