package info3.regexp;

import java.util.ArrayList;

import info3.aef.Aef;

public class Sum extends Regexp implements IRegexp, IRegexpCollection {

	static final Regexp NEUTRAL = new Regexp(); // FIXME

	// FIELDS

	ArrayList<Regexp> regexps;

	// CONSTRUCTOR

	Sum() {
		this.regexps = new ArrayList<Regexp>();
	}

	// BUILDER

	public void add(Regexp re) {
		regexps.add(re);
	}

	// PREDICATE

	public boolean is_simple() {
		return false;
	}

	// CONVERTER

	public Aef toAutomaton() {
		// TODO
		return null;
	}

	// EXPORTER

	public String toREG() {
		StringBuilder sb = new StringBuilder();
		for (Regexp re : regexps) {
			if (!re.is_simple())
				sb.append("(");
			sb.append(re.toREG());
			if (!re.is_simple())
				sb.append(")");
			sb.append("|");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
