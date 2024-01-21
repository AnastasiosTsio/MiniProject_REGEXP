/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2020 */

package export;

public class AEF {

	// STATE 
	
	public static String initial_state(String name) {
		return newline("->" + name);
	}

	public static String accepting_state(String name) {
		return "(" + name + ")";
	}

	public static String standard_state(String name) {
		return name;
	}

	// TRANSITION
	
	public static String epsilon_transition(String source, String target) {
		return edge(source, "", target);
	}

	public static String edge(String source, String label, String target) {
		return newline(source + " -" + label + "-> " + target);
	}

	private static String newline(String content) {
		return "\n  " + content + " ;";
	}

	// AEF
	
	public static String aef(String name, String body) {
		return "AEF(" + name + "){" + body + "\n}\n";
	}

	public static void to_file(String path, String name, String content) {
		FILE.to_file(path, name, "aef", content);
	}

}
