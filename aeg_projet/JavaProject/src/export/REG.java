/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2022 */

package export;

public class REG {

	// NOTATION

	public static final String EPSILON_REGEXP = "$";
	public static final String EMPTY = "{}";

	public static final String OPT = "?";
	public static final String STAR = "*";
	public static final String PLUS = "+";

	public static final String CONCAT = ".";
	public static final String SUM = "|";
	public static final String INTER = " & ";

	public static final String MINUS = "-";
	public static final String NEG = "-";

	public static final String EPSILON = "";
	
	// PRETTY PRINTING

	public static String parenthesis(String string) {
		return "(" + string + ")";
	}

	public static String optional(String e) {
		return e + OPT;
	}

	public static String star(String e) {
		return e + STAR;
	}

	public static String plus(String e) {
		return e + PLUS;
	}

	public static String neg(String e) {
		return NEG + e;
	}

	public static String minus(String e1, String e2) {
		return e1 + MINUS + e2;
	}
	
	public static String inter(String e1, String e2) {
		return e1 + INTER + e2;
	}

	// REG

	public static String reg(String filename, String body) {
		return "REGEXP(" + filename + "){\n  " + body + "\n}\n";
	}

	public static void to_file(String path, String filename, String content) {
		FILE.to_file(path, filename, "reg", reg(filename, content));
	}
}
