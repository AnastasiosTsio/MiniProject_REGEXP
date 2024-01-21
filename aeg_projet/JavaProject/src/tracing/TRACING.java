/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, december 2021 */

package tracing;

public final class TRACING {

	// OPTIONS
	
	public static boolean TRACING = true;
	
	// Instrumentation of the parser (for teaching and debugging)

	// XTERM FONT

	static final String BOLD = "1";

	static final String RESET_FONT = xterm_font("0");

	private static String xterm_font(String font) {
		return "\033[" + font + "m";
	}

	public static String font(String font, String text) {
		return xterm_font(font) + text + RESET_FONT;
	}

	// == Show

	public static void show(String string) {
		if (TRACING)
			System.out.print(" " + string);
	}

	// == Trace

	public static void trace(String string) {
		show(font("96", string));
	}
	
	// == Info

	public static void info(String string) {
		show(font("3;90", string + "\n"));
	}


	// == Fixme

	public static void fixme(String string) {
		show(font("5;91", string));
	}

	// == Tracing the recursive calls of non terminal functions

	public static void call(int depth, String function_name) {
		if (TRACING && depth > 0) {
			String spaces = "";
			depth--;
			for (int i = 0; i < depth * 2; i++)
				if (i % 2 == 0)
					spaces += ".";
				else
					spaces += " ";
			System.out.print("\n" + spaces + "> " + font(BOLD, function_name));
		}
	}

	// == Tracing the consumption of tokens

	static String epsilon = "";

	public static void consumed(int depth, String token) {
		if (TRACING && depth > 0) {
			String spaces = "\n. ";
			for (int i = 0; i < depth * 2; i++)
				if (i % 2 == 0)
					spaces += ".";
				else
					spaces += " ";
			spaces = font("2", spaces);

			if (token.equals(epsilon))
				System.out.print(spaces + font("2", "|") + spaces + font("2", "\"\""));
			else
				System.out.print(spaces + font("91", "|") + spaces + font("1;92", token));
		}
	}

}
