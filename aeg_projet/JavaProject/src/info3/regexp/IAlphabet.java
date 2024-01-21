package info3.regexp;

public interface IAlphabet extends Iterable<Symbol>{
	
	// BUILDER FOR SHARING
	
	Symbol symbol(char c);
	
	Symbol symbol(String s);
	
}
