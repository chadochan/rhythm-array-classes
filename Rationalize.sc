// Rationalize converts a list of decimal representations to their closest possible rational expressions,
// returning a new 2D list

Rationalize {

	*new { |decimal_list|

		var rational_list = List();

		decimal_list.do { |item, i|
			rational_list.add(item.asFraction);
		};

		^rational_list
	}
}
