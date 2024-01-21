/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, december 2021 */

package info3.aef;

public interface IState {

	// GETTER
	
	int id();
	
	// SETTER 
	
	void set_initial(boolean b);

	void set_accepting(boolean b);

	// PREDICATE

	boolean is_accepting();

	boolean is_initial();

}
