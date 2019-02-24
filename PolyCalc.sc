/*
SuperCollider implementation of Andrew Mead's polyrhythm format calculator (for details http://bit.ly/1PSYIjS).
Returns the possible formats for two polyrhythmic limbs.
*/

PolyCalc {

	*new { |limb1 = 21, limb2 = 25|
		var limb1factors = limb1.factors;
		var limb2factors = limb2.factors;
		var limb1FirstFactor, limb1SecondFactor, limb2FirstFactor, limb2SecondFactor, temp;
		var formatDurations;

		if(limb1factors.size == 1, { limb1factors.add(1) });
		if(limb2factors.size == 1, { limb2factors.add(1) });

		if(limb1factors.size > 2, { temp = limb1factors[0]*limb1factors[1];
			limb1factors.removeAt(0); limb1factors.removeAt(0); limb1factors.add(temp);
		});

		if(limb2factors.size > 2, { temp = limb2factors[0]*limb2factors[1];
			limb2factors.removeAt(0); limb2factors.removeAt(0); limb2factors.add(temp);
		});

		limb1FirstFactor = limb1factors[0];
		limb1SecondFactor = limb1factors[1];

		limb2FirstFactor = limb2factors[0];
		limb2SecondFactor = limb2factors[1];

		formatDurations = [[limb2SecondFactor/limb1SecondFactor, limb1FirstFactor/limb2FirstFactor], [limb2FirstFactor/limb1SecondFactor, 					     limb1FirstFactor/limb2SecondFactor], [limb2FirstFactor/limb1FirstFactor, limb1SecondFactor/limb2SecondFactor], [limb2SecondFactor/limb1FirstFactor, limb1SecondFactor/limb2FirstFactor]];

		("Format A –  "+limb1+":"+limb2SecondFactor+"/"+limb1SecondFactor+"  "+limb2+":"+limb1FirstFactor+"/"+limb2FirstFactor+
			"  Number of duration units: "+((limb2SecondFactor/limb1SecondFactor)*limb1)).postln;
		("Format B –  "+limb1+":"+limb2FirstFactor+"/"+limb1SecondFactor+"  "+limb2+":"+limb1FirstFactor+"/"+limb2SecondFactor+
			"  Number of duration units: "+((limb2FirstFactor/limb1SecondFactor)*limb1)).postln;
		("Format C –  "+limb1+":"+limb2FirstFactor+"/"+limb1FirstFactor+"  "+limb2+":"+limb1SecondFactor+"/"+limb2SecondFactor+
			"  Number of duration units: "+((limb2FirstFactor/limb1FirstFactor)*limb1)).postln;
		("Format D –  "+limb1+":"+limb2SecondFactor+"/"+limb1FirstFactor+"  "+limb2+":"+limb1SecondFactor+"/"+limb2FirstFactor+
			"  Number of duration units: "+((limb2SecondFactor/limb1FirstFactor)*limb1)).postln;

		formatDurations.round(0.001).postln;
		"...".postln;
	}
}
