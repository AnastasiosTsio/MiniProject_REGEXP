/* Michaël PÉRIN, VERIMAG / Univ. Grenoble-Alpes / Polytech Grenoble, december 2020
 *
 * USAGE: java -cp ./bin ab_parser.Main
 */

package ab_package;
import ab_package.AsciiFont;
import java.util.Scanner;

public class Main {

	// for reading from the standard input

	static Scanner scanner = new Scanner(System.in);

  // for pretty printing

	static void request(){ AsciiFont.blink(">"); }

	static void begin_parsing(){ AsciiFont.fg_gray(); }

	static void begin_answer(){ AsciiFont.fg_lightblue(); System.out.print("\n"); }

	static void end(){ AsciiFont.reset(); }

	static String get_line(){
		request();
	  String line = scanner.nextLine();
	  return line;
	}

  // main

	public static void main(String[] args) {
		while(true){
			System.out.println("Enter a word made of a and b, then press ENTER.");

			String input_line = get_line();

			/* PARSER 1: try to recognize the word as a member of { a^n.b^n | n in nat } */
			int n = 0;
			
			begin_parsing();
			    AsciiFont.lightblue("\nParser a^n.b^n:\n");
				n = AnBn_parser.parse_string(input_line);
			end();
			begin_answer();
			 	System.out.print("Parser a^n.b^n ");
			 	if (n>=0)
			 		System.out.println("succeeds with n = " + n);
			 	else
			 		System.out.println("fails");
			end();
			

			/* PARSER 2: try to recognize the word as a member of { w in {a,b}* | #a(w)<=#b(w) } */
			Couple c = new Couple(0,0);
			
			begin_parsing();
   		    	    AsciiFont.lightblue("\nParser #a<=#b:\n");
				c = Any_ab_parser.parse_string(input_line);
			end();
			begin_answer();
			 	System.out.print("Parser #a<=#b ");
			 	if (c.left<=c.right)
			 		System.out.println("succeeds with (#a,#b) =" + c);
			 	else
			 		System.out.println("fails");
			end();
			

		 	/* QUITE if no a, no b */
			if (c.left==0 && c.right==0) break;
		}

		scanner.close();
	}


}
