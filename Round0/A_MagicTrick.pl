use Array::Utils qw(:all);
my $file = $ARGV[0];
open my $info, $file or die "Could not open $file: $!";
$h=0;
$lineNo=1;
$cases = 0;
@lines;
while( my $line = <$info>)  { 
    if($lineNo == 1)
    {
        $cases = $line;
        $lineNo++;
    }
    else
    {
       push(@lines,$line);
    }
   
}
$j=0;
while($#lines>0)
{
    $j++;
    $numA = shift(@lines);
    $#first=-1;
    for($i=0;$i<$numA;$i++)
    {
        $line = shift(@lines);
        @vals=split(" ",$line);
        $#first=-1;
        push(@first,@vals);
    }
    for($i=0;$i<(4-$numA);$i++)
    {shift(@lines);}

    $numB = shift(@lines);
    $#second=-1;
    for($i=0;$i<$numB;$i++)
    {
        $line = shift(@lines);
        @vals=split(" ",$line);
        $#second=-1;
        push(@second,@vals);
    }
    for($i=0;$i<(4-$numB);$i++)
    {shift(@lines);}
    
    my @isect = intersect(@first, @second);
    if($#isect==0)
    {
       print "Case #$j: ".@isect[0]."\n";
    }
    elsif($#isect>0)
    {
        print "Case #$j: Bad magician!\n";
    }
    else
    {
        print "Case #$j: Volunteer cheated!\n";
    }
}
