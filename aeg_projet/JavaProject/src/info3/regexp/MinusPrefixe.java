package info3.regexp;

import info3.aef.Aef;

public class MinusPrefixe extends Regexp implements IRegexp {

	// FIELDS

	Regexp re;

	// CONSTRUCTOR

	public MinusPrefixe(Regexp re) {
		this.re = re ;
	}

	// PREDICATE

	public boolean is_simple() {
		// TODO
		return false ;
	}

	// CONVERTER

	public Aef toAutomaton() {
		// TODO
		return null;
	}

	// EXPORTER

	public String toREG() {
		if (!re.is_simple())
			return "-" + "(" + re.toREG() + ")";
		return "-" + re.toREG();
	}

}
