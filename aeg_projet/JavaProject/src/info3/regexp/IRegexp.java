package info3.regexp;

import info3.aef.Aef;

public interface IRegexp {
		
	// PREDICATE
	
	boolean is_simple();
	
	// CONVERTER
	
	Aef toAutomaton();
	
	// EXPORTER
	
	String toREG();

}
