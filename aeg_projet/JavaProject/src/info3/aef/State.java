/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2022 */

package info3.aef;

public class State implements IState {

	static int counter = 1;
	
	// CONSTRUCTORS

	public State(int id) {
		this.id = id;
		is_initial = false;
		is_accepting = false;
	}

	public State(String name) {
		this.name = name;
		id = counter++;
		is_initial = false;
		is_accepting = false;
	}
	
	// ID

	private int id;

	public int id() {
		return id;
	}

	// NAME
	
	private String name;
	
	public String name() {
		return name;
	}
	
	// INITIAL, ACCEPTING

	private boolean is_initial, is_accepting;

	public void set_initial(boolean b) {
		is_initial = b;
	}

	public boolean is_initial() {
		return is_initial;
	}

	public void set_accepting(boolean b) {
		is_accepting = b;
	}

	public boolean is_accepting() {
		return is_accepting;
	}

	// EQUALITY

	public boolean is_equal(State s) {
		return s == this || s.id == this.id;
	}

	// @Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof State))
			return false;
		return is_equal((State) o);
	}
	
	// EXPORTER

	public String toString() {
		return String.format("%d", id);
	}

}
