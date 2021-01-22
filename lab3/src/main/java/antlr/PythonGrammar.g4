grammar PythonGrammar;

tokens { INDENT, DEDENT }

@lexer::members {
  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
  private java.util.Stack<Integer> indents = new java.util.Stack<>();
  private int opened = 0;
  private Token lastToken = null;
  @Override
  public void emit(Token t) {
    super.setToken(t);
    tokens.offer(t);
  }

  @Override
  public Token nextToken() {
    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
      for (int i = tokens.size() - 1; i >= 0; i--) {
        if (tokens.get(i).getType() == EOF) {
          tokens.remove(i);
        }
      }

      this.emit(commonToken(PythonGrammarParser.NEWLINE, "\n"));

      while (!indents.isEmpty()) {
        this.emit(createDedent());
        indents.pop();
      }

      this.emit(commonToken(PythonGrammarParser.EOF, "<EOF>"));
    }

    Token next = super.nextToken();

    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
      this.lastToken = next;
    }

    return tokens.isEmpty() ? next : tokens.poll();
  }

  private Token createDedent() {
    CommonToken dedent = commonToken(PythonGrammarParser.DEDENT, "");
    dedent.setLine(this.lastToken.getLine());
    return dedent;
  }

  private CommonToken commonToken(int type, String text) {
    int stop = this.getCharIndex() - 1;
    int start = text.isEmpty() ? stop : stop - text.length() + 1;
    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
  }

  static int getIndentationCount(String spaces) {
    int count = 0;
    for (char ch : spaces.toCharArray()) {
      switch (ch) {
        case '\t':
          count += 8 - (count % 8);
          break;
        default:
          count++;
      }
    }

    return count;
  }

  boolean atStartOfInput() {
    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
  }
}

program : (stmt | NEWLINE)* EOF;

stmt : simple_stmt | compound_stmt;

simple_stmt : (command | assignment | arithm_expr ) NEWLINE;

compound_stmt : if_stmt | while_stmt | for_stmt ;
if_stmt: 'if' condition ':' suite ('else' ':' suite)?;
while_stmt: 'while' condition ':' suite ;
for_stmt: 'for' ID 'in' 'range' LPAREN range_list RPAREN ':' suite;
range_list
    : (NUMBER | ID)  #rangeOneNumber
    | (NUMBER | ID) ',' (NUMBER | ID) #rangeTwoNumbers
    | (NUMBER | ID) ',' (NUMBER | ID) ',' (NUMBER | ID) #rangeThreeNumbers
    ;

suite: simple_stmt | NEWLINE INDENT stmt+ DEDENT;

command : print_command | read_command;
print_command : 'print' LPAREN arithm_expr RPAREN ;
read_command : name EQ 'int' LPAREN 'input' LPAREN RPAREN RPAREN ;

assignment : name EQ arithm_expr ;

arithm_expr
    : name #variableExpression
    | NUMBER #numberExpression
    | arithm_expr (ADD | MUL | DIV | SUB) arithm_expr #binaryExpression
    | (LPAREN arithm_expr RPAREN) #inBracketExpression ;

condition
    : TRUE #trueCondition
    | FALSE #falseCondition
    | NOT condition #notCondition
    | condition (AND | OR ) condition #binaryCondition
    | arithm_expr (DEQ | NEQ | GT | GTE | LTE | LT) arithm_expr #comparisonCondition
    | LPAREN condition RPAREN #inBracketCondition;

// operators
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

// comparison
NEQ : '!=' ;
GTE : '>=' ;
LTE : '<=' ;
GT  : '>' ;
LT  : '<' ;
DEQ : '==' ;
EQ  : '=' ;

// logical
AND : 'and' ;
OR  : 'or' ;
NOT : 'not' ;

// keywords
FOR     : 'for'     ;
WHILE   : 'while' ;
IF      : 'if' ;
ELSE    : 'else' ;
TRUE    : 'True' ;
FALSE   : 'False' ;

// literals
ID              : [a-zA-Z] [a-zA-Z0-9]*;

NUMBER          : [0-9]+ ('.' [0-9]+)?;

// other
COMMA  : ',' ;
LPAREN : '(' ;
RPAREN : ')' ;
COLON  : ':' ;

name : ID ;

NEWLINE
 : ( {atStartOfInput()}?   SPACES
   | ( '\r'? '\n' | '\r' | '\f' ) SPACES?
   )
   {
     String newLine = getText().replaceAll("[^\r\n\f]+", "");
     String spaces = getText().replaceAll("[\r\n\f]+", "");

     int next = _input.LA(1);
     int nextnext = _input.LA(2);
     if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
       skip();
     }
     else {
       emit(commonToken(NEWLINE, newLine));
       int indent = getIndentationCount(spaces);
       int previous = indents.isEmpty() ? 0 : indents.peek();
       if (indent == previous) {
         skip();
       }
       else if (indent > previous) {
         indents.push(indent);
         emit(commonToken(PythonGrammarParser.INDENT, spaces));
       }
       else {
         while(!indents.isEmpty() && indents.peek() > indent) {
           this.emit(createDedent());
           indents.pop();
         }
       }
     }
   }
 ;

fragment SPACES
 : [ \t]+
 ;

SKIP_ : (SPACES | NEWLINE) -> skip ;

