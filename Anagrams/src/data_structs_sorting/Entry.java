package data_structs_sorting;

//Used as the contents of a HashMap
public class Entry<E,F> {
	
	//Used to identify the contents of the HashMap with a particular key
	private E key;
	
	//Used to store the value of the HashMap Entry
	private F contents;
	
	/*
	 * Constructor for Entry
	 * 
	 * @param key     : key of the Entry
	 * 
	 * @param contents: contents of the Entry
	 * 
	 */
	public Entry(E key, F contents) {
		
		//Initialize the Entry with the key
		this.key = key;
		
		//Initialize the Entry with the contents
		this.contents = contents;
	}
	
	/*
	 * Getter for the Entry's key
	 */
	public E getKey() {
		return key;
	}
	
	/*
	 * Getter for the Entry's contents
	 */
	public F getContents() {
		return contents;
	}

}
