/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2022 */

package info3.regexp;

import export.REG;
import info3.aef.Aef;

public class Symbol extends Regexp implements IRegexp, ISymbol {

	// CONSTANT

	public static final Symbol EMPTY = new Symbol(REG.EMPTY);
	public static final Symbol EPSILON = new Symbol(REG.EPSILON);
	public static final Symbol EPSILON_REGEXP = new Symbol(REG.EPSILON_REGEXP);

	// FIELDS

	String name;

	// CONSTRUCTOR

	public Symbol(String name) {
		this.name = name;
	}

	// NAME

	public String name() {
		return name;
	}

	// PREDICATE

	public boolean is_epsilon() {
		// FIXME
		return false;
	}

	public boolean is_simple() {
		// FIXME
		return true;
	}

	public boolean is_equal(Symbol symbol) {
		// FIXME
		return false;
	}

	// @Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Symbol))
			return false;
		return is_equal((Symbol) o);
	}

	// CONVERTER

	public Aef toAutomaton() {
		//Aef automaton = new ();
		//automaton.set_name(name);
		
		//automaton.add_initial_state("hagrid");
		
		//automaton.add_initial_state("nonhagrid");
		
		//automaton.add_transition(initialState.name(), name, acceptingState.name());
		
		return null;
	}

	// EXPORTER

	public String toREG() {
		return name;
	}
}
