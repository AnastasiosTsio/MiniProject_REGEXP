/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2021 */

package export;

import java.util.LinkedList;

import tracing.TRACING;;

public class GRM {

	private static String newline(String content) {
		return "\n  " + content;
	}

	public static String symbol(String string) {
		return "\"" + string + "\"";
	}

	public static String non_terminal(String string) {
		return " " + string + " ";
	}

	public static String language_def(String name, LinkedList<String> strings) {
		TRACING.fixme("GRM.language_def");
		return null;
	}

	public static String choice(LinkedList<String> strings) {
		TRACING.fixme("GRM.choices");
		return null;
	}

	public static String sequence(LinkedList<String> strings) {
		TRACING.fixme("GRM.sequence");
		return null;
	}

	public static String grm(String name, String body) {
		return "Grammar(" + name + "){" + body + "\n}\n";
	}

	public static void to_grm_file(String path, String name, String body) {
		FILE.to_file(path, name, "grm", body);
	}
}
