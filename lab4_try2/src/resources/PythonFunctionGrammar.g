s -> DEF WS NAME L_PARENT p R_PARENT EQ EOF
p -> ^
p -> POINTS
p -> NAME t
t -> COMMA g
t -> ^
g -> NAME t
g -> POINTS

DEF -> {def}
L_PAREN -> {\(}
R_PAREN -> {\)}
COMMA -> {,}
POINTS -> {\.\.\.}
EQ -> {=}
NAME -> {(?!def)[a-zA-Z_][a-zA-Z_0-9]*}
WS -> {[ \t]+} #skip
