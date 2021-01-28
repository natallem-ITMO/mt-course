while($str = <>){
    print $str if ($str =~ /\b([\w]+)\1\b/)
}
