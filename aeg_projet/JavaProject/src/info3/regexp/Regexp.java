/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2022 */

package info3.regexp;

import export.REG;
import info3.aef.Aef;

public class Regexp {

	// FIELD

	Aef automaton;
	int priority;

	// OPTIONS

	static boolean AUTOMATON = false;
	static boolean REFORMAT = false;
	static boolean THOMPSON_OPTIMISATION = false;
	
	// CONSTRUCTOR

	public Regexp() {
	}

	// CONVERTER

	public Aef toAutomaton() { // GIVEN
		System.out.println("toAutomaton must be redefined in each subclasses");
		return null;
	}

	// EXPORTER

	public void export(String path, String filename) { // GIVEN
		show();
		if (REFORMAT)
			toRegFile(path, filename);
		if (AUTOMATON)
			toDotFile(path, filename);
	}

	private void toRegFile(String path, String filename) { // GIVEN
		REG.to_file(path, filename, toREG());
	}

	private void toDotFile(String path, String filename) { // GIVEN
		if (THOMPSON_OPTIMISATION)
			toAutomaton().toDotFile(path, filename + "_opt");
		else
			toAutomaton().toDotFile(path, filename);
	}

	public String toREG() { // GIVEN
		System.out.println("toREG must be redefined in each subclasses using export/REG.java");
		return null;
	}

	public void show() { // GIVEN
		System.out.println(toREG());
	}

	public boolean is_simple() {
		return false;
	}

}
