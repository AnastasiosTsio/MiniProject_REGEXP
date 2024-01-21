/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, 2020 */

package export;

import java.io.FileWriter;
import java.io.IOException;

public class FILE {

	public static void to_file(String path, String name, String ext, String content) {
		String filename = path + name + "." + ext ;
		try {
			FileWriter myFileWriter = new FileWriter(filename);
			myFileWriter.write(content);
			myFileWriter.close();
			System.out.println("... exported to: " + filename);
		} catch (IOException e) {
			System.out.println("error in FILE.to_file trying to export to " + filename);
			e.printStackTrace();
		}
	}
}
