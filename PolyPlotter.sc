// PolyPlotter plots an array of sine waves with optional superposed view for comparision.

PolyPlotter {

	*plot {|limbArray = #[9, 17, 21], phaseoffset = 0, superpose = true|
		var sinusplot;
    
		sinusplot = { SinOsc.ar(limbArray, phaseoffset) }.plot(1, bounds: Rect(20, 780, 1370, 70));
		sinusplot.superpose = superpose;
	}

}
