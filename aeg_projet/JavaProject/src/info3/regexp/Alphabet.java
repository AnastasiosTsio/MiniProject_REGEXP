/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2022 */

package info3.regexp;

import java.util.Iterator;

import info3.aef.Set;

public class Alphabet implements IAlphabet {

	// CONSTRUCTOR
	
	public Alphabet() {
		symbols = new Set<Symbol>();
	}	
	
	// CLONE
	
	public Alphabet clone() {
		Alphabet clone = new Alphabet();
		clone.symbols = symbols.clone();
		return clone;
	}
	
	// SHARING SYMBOLS
	
	Set<Symbol> symbols;

	public Symbol symbol(String s) {
		for (Symbol symbol : symbols) {
			if (symbol.name().equals(s))
				return symbol;
		}
		Symbol new_symbol = new Symbol(s);
		symbols.add(new_symbol);
		return new_symbol;
	}

	public Symbol symbol(char c) {
		String s = String.format("%c", c);
		return symbol(s);	
	}
	
	// ITERATOR

	public Iterator<Symbol> iterator() {
		return symbols.iterator();
	}
}
