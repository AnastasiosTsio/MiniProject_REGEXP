package ab_package;

// ASCII ESCAPE CODE for XTERM FONT

public final class AsciiFont {
	
	// set foreground color
	
	public static void reset() {
		System.out.print("\033[0m");
	}
	
	public static void fg_blink() {
		reset();
		System.out.print("\033[5m");
	}
	
	public static void fg_gray() {
		reset();
		System.out.print("\033[2m");
	}
	
	public static void fg_green() {
		reset();
		System.out.print("\033[1;92m");
	}
	
	public static void fg_lightblue(){ 
		reset();
		System.out.print("\033[96m"); 
	}

	public static void fg_red() {
		reset();
		System.out.print("\033[1;91m");
	}
		
	public static void fg_yellow() {
		reset();
		System.out.print("\033[1;93m");
	}
	
	// print in color
	
	public static void blink(String str) {
		fg_blink();
		System.out.print(str);
		reset();
	}
	
	public static void gray(String str) {
		fg_gray();
		System.out.print(str);
		reset();
	}
	
	public static void green(String str) {
		fg_green();
		System.out.print(str);
		reset();
	}
	
	public static void lightblue(String str) {
		fg_lightblue();
		System.out.print(str);
		reset();
	}
		
	public static void red(String str) {
		fg_red();
		System.out.print(str);
		reset();	
	}

	public static void yellow(String str) {
		fg_yellow();
		System.out.print(str);
		reset();
	}
}
