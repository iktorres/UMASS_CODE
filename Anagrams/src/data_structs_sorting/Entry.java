package data_structs_sorting;

public class Entry<E,F> {
	
	private E key;
	private F contents;
	
	public Entry(E key, F contents) {
		this.key = key;
		this.contents = contents;
	}
	
	public E getKey() {
		return key;
	}
	
	public F getContents() {
		return contents;
	}

}
