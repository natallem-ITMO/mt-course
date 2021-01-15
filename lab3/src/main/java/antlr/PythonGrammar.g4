grammar PythonGrammar;

// All comments that start with "///" are copy-pasted from
// The Python Language Reference

tokens { INDENT, DEDENT }

@lexer::members {
  // A queue where extra tokens are pushed on (see the NEWLINE lexer rule).
  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
  // The stack that keeps track of the indentation level.
  private java.util.Stack<Integer> indents = new java.util.Stack<>();
  // The amount of opened braces, brackets and parenthesis.
  private int opened = 0;
  // The most recently produced token.
  private Token lastToken = null;
  @Override
  public void emit(Token t) {
    super.setToken(t);
    tokens.offer(t);
  }

  @Override
  public Token nextToken() {
    // Check if the end-of-file is ahead and there are still some DEDENTS expected.
    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
      // Remove any trailing EOF tokens from our buffer.
      for (int i = tokens.size() - 1; i >= 0; i--) {
        if (tokens.get(i).getType() == EOF) {
          tokens.remove(i);
        }
      }

      // First emit an extra line break that serves as the end of the statement.
      this.emit(commonToken(PythonGrammarParser.NEWLINE, "\n"));

      // Now emit as much DEDENT tokens as needed.
      while (!indents.isEmpty()) {
        this.emit(createDedent());
        indents.pop();
      }

      // Put the EOF back on the token stream.
      this.emit(commonToken(PythonGrammarParser.EOF, "<EOF>"));
    }

    Token next = super.nextToken();

    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
      // Keep track of the last token on the default channel.
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
          // A normal space char.
          count++;
      }
    }

    return count;
  }

  boolean atStartOfInput() {
    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
  }
}

program : (NEWLINE | stmt)* EOF;

stmt : simple_stmt | compound_stmt;

simple_stmt : (command | assignment | arithm_expr ) NEWLINE;
compound_stmt : if_stmt | while_stmt | for_stmt ;

if_stmt: 'if' condition ':' suite ('else' ':' suite)?;
while_stmt: 'while' condition ':' suite ;
for_stmt: 'for' ID 'in' 'range' LPAREN range_list RPAREN ':' suite;

range_list
    : (NUMBER | ID)  #rangeOneNumber
    | (NUMBER | ID) ',' (NUMBER | ID) #rangeTwoNumbers ;

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

comparison : arithm_expr (DEQ | NEQ | GT | GTE | LTE | LT) arithm_expr;

condition
    : TRUE #trueCondition
    | FALSE #falseCondition
    | NOT condition #notCondition
    | condition (AND | OR ) condition #binaryCondition
    | comparison #comparisonCondition
    | LPAREN condition RPAREN #inBracketCondition; // todo add more

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

     // Strip newlines inside open clauses except if we are near EOF. We keep NEWLINEs near EOF to
     // satisfy the final newline needed by the single_put rule used by the REPL.
     int next = _input.LA(1);
     int nextnext = _input.LA(2);
     if (opened > 0 || (nextnext != -1 && (next == '\r' || next == '\n' || next == '\f' || next == '#'))) {
       // If we're inside a list or on a blank line, ignore all indents,
       // dedents and line breaks.
       skip();
     }
     else {
       emit(commonToken(NEWLINE, newLine));
       int indent = getIndentationCount(spaces);
       int previous = indents.isEmpty() ? 0 : indents.peek();
       if (indent == previous) {
         // skip indents of the same size as the present indent-size
         skip();
       }
       else if (indent > previous) {
         indents.push(indent);
         emit(commonToken(PythonGrammarParser.INDENT, spaces));
       }
       else {
         // Possibly emit more than 1 DEDENT token.
         while(!indents.isEmpty() && indents.peek() > indent) {
           this.emit(createDedent());
           indents.pop();
         }
       }
     }
   }
 ;

//NEWLINE : [ \t]+ -> skip;
fragment SPACES
 : [ \t]+
 ;

SKIP_ : (SPACES | NEWLINE) -> skip ;

