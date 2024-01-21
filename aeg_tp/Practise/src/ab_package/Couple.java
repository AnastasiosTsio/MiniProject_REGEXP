package ab_package;

public class Couple{

  public int left;
  public int right;

  public Couple(int l, int r){
    this.left  = l;
    this.right = r ;
  }

  public String toString(){
    return "(" + left + "," + right + ")";
  }

  public Couple plus(int l, int r){
	 
    this.left  += l;
    this.right +=r;
    return this;
  }

}
