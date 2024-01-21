package number_package;

public class Inum implements Number{
	int value;

	Inum(int i){
		value = i;
	}

	// eq

	public boolean eq(int i) {
		return value==i;
	}

	public boolean eq(double d) {
		return (double)value==d;
	}

	public boolean eq(Number n) {
		return n.eq(value);
	}

	// plus

	public Number plus(double d) {
		return new Rnum((double)value+d);
	}

	public Number plus(int i) {
		value +=i;
		return new Inum(value);
	}

	public Number plus(Number n) {
		return n.plus(value);
	}

	// toString

	public String toString() {
		String s = new String ();
		s += "Inum(" ;
		s += value;
		s += ")" ;
		return s;
	}
}
