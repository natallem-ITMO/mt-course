my $regexp = "cat(.*)cat";
while(<>){
    print if /$regexp/;
}