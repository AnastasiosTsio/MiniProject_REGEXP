/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2020 */

package export;

public class HTML {

	public static String cell(String content, String options) {
		return "<TD " + options + ">" + content + "</TD>";
	}

	public static String row(String columns, String options) {
		return "<TR " + options + ">" + columns + "</TR>";
	}
	
	public static String table(String rows, String options) {
		return "<TABLE " + options + ">" + rows + "</TABLE>";
	}

	public static void to_html_file(String path, String name, String content) {
		FILE.to_file(path, name, "html", content);
	}

}
