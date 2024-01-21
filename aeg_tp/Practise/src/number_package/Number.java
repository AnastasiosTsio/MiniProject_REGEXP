package number_package;

public interface Number {
	
	public boolean eq(int i);
	public boolean eq(double d);
	public boolean eq(Number n);
	
	public Number plus(int i);
	public Number plus(double d);
	public Number plus(Number n);
	
	public String toString();
}
