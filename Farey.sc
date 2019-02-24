/*
Farey creates an ordered List containing decimal representations of a full Farey sequence up to F(n).
You can use the Rationalize class for conversion back to a rational list.
(translated from the Python example on Wikipedia)
*/

Farey {

	*new { |n = 5|

		var farey = List();
		var a, b, c, d, k;

		#a, b, c, d = [0, 1, 1, n];

		while ({ c <= n },
			{
				k = floor((n + b) / d);
				#a, b, c, d = [c, d, (k * c - a), (k * d - b)];

				/*convert to decimals and put in the list.
				at least six-decimal precision is required for .asFraction to convert back to rationals*/
				farey.add((a/b).round(0.000001));

				postf("%/%",a,b);  // post the rationals
				post("  ");
			};
		);

		postln("************");

		// return the decimal list
		^farey
	}

}
