/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2020 */

package export;

public class DOT {

	public static String comment(String string) {
		return "\n/* " + string + " */";
	}

	public static String node_style(String options) {
		return "\n node [" + options + "]";
	}

	public static String node_decl(int node_id, String options) {
		return "\n" + node_id + options(options) + ";";
	}

	public static String node_decl(String name, String options) {
		return "\n" + node(name) + options(options) + ";";
	}

	public static String node_decl(int node_id, String node_label, String options) {
		return "\n" + node_id + options(left_option(options) + label(node_label)) + ";";
	}

	public static String edge_style(String options) {
		return "\n edge [" + options + "]";
	}

	public static String edge(String source, String label, String target, String options) {
		return "\n" + node(source) + " -> " + node(target) + options(left_option(options) + label(label)) + ";";
	}

	public static String edge(int source, String label, int target, String options) {
		return "\n" + source + " -> " + target + options(left_option(options) + label(label) ) + ";";
	}

	public static String edge(String source, String label, int target, String options) {
		return "\n" + node(source) + " -> " + target + options(left_option(options) + label(label)) + ";";
	}

	private static String node(String node_id) {
		return protect(node_id);
	}

	private static String protect(String string) {
		return "\"" + string + "\"";
	}

	private static String html(String string) {
		return "<" + string + ">";
	}

	private static String options(String options) {
		if (!options.isEmpty())
			return " [" + options + "]";
		else
			return "";
	}

	public static String left_option(String option) {
		if (option == null)
			return "";
		else
			return option + ", 	" ;
	}
	
	public static String option(String option) {
		if (option == null)
			return "";
		else
			return ", " + option;
	}

	public static String label(String label) {
		if (label == null)
			return "";
		else
			return "label=" + protect(label);
	}

	public static String label_html(String label) {
		if (label == null)
			return "";
		else
			return "label=" + html(label);
	}

	public static String dot(String name, String dot_body) {
		String options = "/* HORIZONTAL */ rankdir=LR;";
		return "digraph " + name + "{" + options + "\n" + dot_body + "\n}\n";
	}

	public static void to_file(String path, String name, String content) {
		FILE.to_file(path, name, "dot", content);
	}
}
