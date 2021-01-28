#open(, "<file1.txt");
#open(, ">file2.txt");

my $start = 1;
my $prevempty = 0;

while (my $str = <>) {
    $str =~  s/[<]+?[^<]+?[>]+?//g;
    if ($str =~ /^[ ]*$/) {
        if ($start) {
        } else {
            $prevempty = 1;
        }

    } else {

        if ($start){
            $start = 0;
        } else {
            print  "\n"
        }
        if ($prevempty){
            $prevempty = 0;
            print  "\n";
        }
        $str =~  s/( )+/ /g;
        $str =~  s/^ //;
        $str =~  s/[\s]*$//g;
        print  "$str";
    }
}


close(  );
close(  );