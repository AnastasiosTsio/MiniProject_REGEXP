/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2022 */

package info3.aef;

import export.DOT;
import info3.regexp.Symbol;

public class Transition {

	State source;
	Symbol symbol;
	State target;

	Transition(State source, Symbol symbol, State target) {
		this.source = source;
		this.symbol = symbol;
		this.target = target;
	}

	// EXPORTER	
	
	public String toDot() {
		if (symbol.is_epsilon()) 
			return DOT.edge(source.id(), "&epsilon;", target.id(), "color=orange, fontcolor=orange");
		else
			return DOT.edge(source.id(), symbol.name(), target.id(), null);
	}
	
}
