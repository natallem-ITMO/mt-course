input [return int val; ]
e [ return int val ;]
t [ return int val ;]
e1 [ return int val;] [[ int acc; ]]
t1 [ return int val ;] [[ int acc ;]]
f [return int val ;]

$input_ = input -> $e_ = e EOF {input_.val = e_.val;}

$e_ = e -> $t_ = t {e1_.acc = t_.val;} $e1_ = e1 {e_.val = e1_.val;}
$e_one = e1 -> PLUS  $t_ = t {e1_two.acc = t_.val + e_one.acc;} $e1_two = e1 { e_one.val = e1_two.val;}
$e_one = e1 -> MINUS  $t_ = t {e1_two.acc =  e_one.acc - t_.val;} $e1_two = e1 { e_one.val = e1_two.val;}
$e1_ = e1 -> ^ {e1_.val = e1_.acc;}


$t_ = t -> $f_ = f {t1_.acc = f_.val;} $t1_ = t1 {t_.val = t1_.val;}
$t_one = t1 -> MUL  $f_ = f {t1_two.acc = f_.val * t_one.acc;} $t1_two = t1 { t_one.val = t1_two.val;}
$t_one = t1 -> DIV  $f_ = f {t1_two.acc =  t_one.acc / f_.val;} $t1_two = t1 { t_one.val = t1_two.val;}
$t1_ = t1 -> ^ {t1_.val = t1_.acc;}

$f_ = f -> $num = NUM {f_.val = std::stoi(num.value);}
$f_ = f -> MINUS $num = NUM {f_.val = -std::stoi(num.value);}
$f_ = f -> LPAREN $e_ = e {f_.val = e_.val ;} RPAREN

PLUS -> {\+}
MINUS -> {\-}
LPAREN -> {\(}
RPAREN -> {\)}
NUM -> {[0-9]+}
MUL -> {\*}
DIV -> {\/}
WS -> {[ \t]+} #skip
