package number_package;

public class Rnum implements Number{
	double value;

	Rnum(double d){
		value = d;
	}

	// eq

	public boolean eq(int i) {
		return (int)value==i;
	}

	public boolean eq(double d) {
		return value==d;
	}

	public boolean eq(Number n) {
	   return n.eq(value);
	}

	// plus

	public Number plus(int i) {
		return new Rnum(value+(double)i);
	}

	public Number plus(double d) {
		value += d;
		return new Rnum(value);
	}

	public Number plus(Number n) {
		return n.plus(value);
	}

	// toString

	public String toString() {
		String s = new String ();
		s += "Fnum(" ;
		s += new Double(value).toString();
		s += ")" ;
		return s;
	}
}
