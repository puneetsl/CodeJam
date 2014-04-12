my $file = $ARGV[0];
open my $info, $file or die "Could not open $file: $!";
$h=0;
while( my $line = <$info>)  { 
	@vals = split(" ",$line);
	if($#vals>1)
	{
		$time = getTime(@vals[0],@vals[1],@vals[2]);
		$h+=1;
		print "Case #$h: ".$time."\n";
	}
}
sub getTime()
{
	$C= shift;$F= shift;$X= shift;
	$K=2;
	$sum=0;
	for($i=0;$i<$X;)
	{
		$i +=($C/$K);
		$K+=$F;
		if(($i+$X/$K)<($i+$C/($K+$F))+$X/($K+$F))
		{
			$sum=$i-($C/($K-$F));
			$sum+=$X/($K-$F);
			$i=$X;
		}
	}
	$roundedSum = sprintf("%.7f", $sum);
	return $roundedSum;
}