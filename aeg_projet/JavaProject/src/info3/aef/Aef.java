/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2022 */

package info3.aef;

import export.DOT;
import info3.regexp.Alphabet;
import info3.regexp.Symbol;

public class Aef {

	// OPTIONS

	static boolean DOT_EXPORT = false;
	static boolean REFORMAT = false;

	// CONSTRUCTOR

	Aef() {
		alphabet = new Alphabet();
		all_states = new Set<State>();
		transitions = new Set<Transition>();
	}

	// CLONE

	public Aef clone() {
		Aef clone = new Aef();
		clone.alphabet = alphabet.clone();
		clone.all_states = all_states.clone();
		clone.transitions = transitions.clone();
		return clone;
	}

	// NAMING

	String name;

	public void set_name(String name) {
		this.name = name;
	}

	// ALPHABET

	Alphabet alphabet;

	public Symbol symbol(String s) {
		return alphabet.symbol(s);
	}

	// STATE

	Set<State> all_states;

	// if a state with id=i already exists in all_states
	// then return the existing state
	// otherwise create a new one.

	public State state(int i) {
		{
			for (State state : all_states) {
				if (state.id() == i)
					return state;
			}
			State state = new State(i);
			all_states.add(state);
			return state;
		}
	}

	public State state(String name) {
		{
			for (State state : all_states) {
				if (state.name().equals(name))
					return state;
			}
			State state = new State(name);
			all_states.add(state);
			return state;
		}
	}

	public void add_initial_state(String name) {
		state(name).set_initial(true);
	}

	public void add_accepting_state(String name) {
		state(name).set_accepting(true);
	}

	// TRANSITIONS

	Set<Transition> transitions;

	public void add_transition(String source, String symb, String target) {
		Transition transition = new Transition(state(source), symbol(symb), state(target));
		transitions.add(transition);
	}

	// REACHABILITY / CO-REACHABILITY

	// Reachability : accumulates forward from a state along the transitions of an
	// automaton

	private void accumulate_reachable_from(State state, Set<State> set_of_states) {
	}

	// Co-reachability : accumulates backward from a state along the reversed
	// transitions of an automaton

	private void accumulate_coreachable_from(State state, Set<State> set_of_states) {
	}

	// CLASSIFICATION OF STATES

	private void compute_reachable(Set<State> reachable) {
	}

	private void compute_holes(Set<State> holes) {
	}

	public void classify_states(Set<State> holes, Set<State> reachable, Set<State> unreachable) {
	}

	// EXPORTER

	public void export(String path, String filename) {
		if (REFORMAT)
			toAefFile(path, filename);
		if (DOT_EXPORT)
			toDotFile(path, filename);
	}

	// == AEF export
	
	public void toAefFile(String path, String filename) {
		System.out.println("\n*** Aef.toAefFile not implemented : PAS DEMANDÉ pour le PROJET A&G 2022");
	}
	
	// == DOT export
	
	public void toDotFile(String path, String file_name) {
		DOT.to_file(path, file_name, this.toDot());
	}

	public String toDot() {

		String dot_body = new String();

		dot_body += DOT.comment("AUTOMATON NAME");
		dot_body += DOT.node_decl(name, "shape=plaintext, fontname=comic, fontsize=18, fontcolor=blue");

		dot_body += DOT.comment("ACCEPTING STATES");
		dot_body += DOT.node_style("shape=circle, peripheries=2, fontname=Georgia, fontsize=14, fontcolor=black");

		for (State state : all_states) {
			if (state.is_accepting())
				dot_body += DOT.node_decl(state.id(), "");
		}

		dot_body += DOT.comment("UNREACHABLE STATES");
		dot_body += DOT.node_style("peripheries=0, style=filled, color=gray, fontcolor=white");

		// TODO

		dot_body += DOT.comment("HOLE STATES");
		dot_body += DOT.node_style("peripheries=0, style=filled, color=black, fontcolor=white");

		// TODO

		dot_body += DOT.comment("STANDARD (default) STATES");
		dot_body += DOT.node_style("peripheries=1, style=solid, color=black, fontcolor=black");

		for (State state : all_states) {
			if (!state.is_accepting())
				dot_body += DOT.node_decl(state.id(), "");
		}

		dot_body += DOT.comment("TRANSITIONS");
		dot_body += DOT.edge_style("fontname=Courier");

		for (State state : all_states) {
			if (state.is_initial())
				dot_body += DOT.edge(name, null, state.id(), "color=blue");
		}

		for (Transition transition : transitions)
			dot_body += transition.toDot();

		return DOT.dot("aef", dot_body);
	}


}
