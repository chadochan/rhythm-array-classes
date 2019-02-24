// Nbit creates a rhythmic array a specified beatdivision, of length numbeats, with adjustable event density

Nbit {
	var beatdiv, numbeats, density;

	*new { | beatdiv = 5, numbeats = 2, density = 0.5 |
		var pulse = 1 / beatdiv;
		var array = Array.fill(beatdiv*numbeats, { (density.coin).binaryValue });

		while(
			{ array.includes(1).not }, { array = Array.fill(beatdiv*numbeats, { (density.coin).binaryValue }) }
		);

		^array;
	}

}



// Similar to Nbit, but for use with Patterns; replaces any 0 with Rest().

NbitPat {
	var beatdiv, numbeats, density;

	*new { | beatdiv = 5, numbeats = 2, density = 0.5 |
		var pulse = 1 / beatdiv;
		var array = Array.fill(beatdiv*numbeats, { (density.coin).binaryValue });

		while(
			{ array.includes(1).not }, { array = Array.fill(beatdiv*numbeats, { (density.coin).binaryValue }) }
		);

		array.do({ |item, i|
			if(item == 0, { array.put(i, Rest()) })
		})

		^array;
	}

}
