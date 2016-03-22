package data_structs_sorting;

public class Tuple<L,R> {
	private L left;
	private R right;
	
	public Tuple(L left, R right) {
		this.left  = left;
		this.right = right;
	}
	
	public L getLeft() {
		return this.left;
	}
	
	public R getRight() {
		return this.right;
	}
	
	public String toString() {
		return ("" + this.left.toString() + " , " + this.right.toString());
	}
	
}
