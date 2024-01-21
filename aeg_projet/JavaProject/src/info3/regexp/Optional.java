package info3.regexp;

import info3.aef.Aef;

public class Optional extends Regexp implements IRegexp {

	// FIELDS

	Regexp re;

	// CONSTRUCTOR

	public Optional(Regexp re) {
		this.re = re ;
	}

	// PREDICATE

	public boolean is_simple() {
		// TODO
		return true ;
	}

	// CONVERTER

	public Aef toAutomaton() {
		// TODO
		return null;
	}

	// EXPORTER

	public String toREG() {
		if (!re.is_simple())
			return "(" + re.toREG() + ")" + "?";
		return re.toREG() + "?";
	}

}
