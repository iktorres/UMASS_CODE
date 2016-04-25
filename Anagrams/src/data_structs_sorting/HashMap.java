package data_structs_sorting;

//Import File library
import java.io.File;

//Import FileWriter library for output
import java.io.FileWriter;

//Import IOException to handle exception
import java.io.IOException;

public class HashMap {
	
	//Implemented a vector in the unlikely event that the array
	//has no more space
	private Vector<Entry<Long,LinkedList<String>>> vec;
	
	
	/*
	 * Default HashMap constructor
	 */
	public HashMap() {
		vec = new Vector<Entry<Long,LinkedList<String>>>();
		for(int i = 0; i < vec.size(); i++) {
			vec.set(i, null);
		}
	}
	
	/*
	 * Default LinkedList constructor
	 * 
	 * @param key : long number used to find index
	 * in HashMap
	 * 
	 */
	public LinkedList<String> get(long key) {
		
		//Hash used to find index in Vector
		int hash = (int)(key % vec.size());
		
		//Iterate through the Vector
		//If it has encountered a null element use linear probing to
		//continue the search for the element
		//If the hash does not give the proper key use linear probing
		//to continue the search for the element
		while(vec.get(hash) != null && vec.get(hash).getKey() != key) {
			
			//Linear probe
			hash = (hash + 1) % vec.size();
		}
		
		//If the iteration has gone through the vector and still finds
		//a null element return null
		if(vec.get(hash) == null) {
			return null;
		}else {
			
			//Element has been found return the contents of the Vector location
			return vec.get(hash).getContents();
		}
	}
	
	/*
	 * Place the word into the Vector using the given key
	 * 
	 * @param key     : hash used to place contents in the Vector
	 * 
	 * @param contents: word to be input into the Vector
	 * 
	 */
	public void put(long key, String contents) {
		
		//Hash used to find index in Vector
		int hash = (int)(key % vec.size());
		
		//If the location in Vector is null make a new Entry in the Vector
		//of type LinkedList<String>
		if(vec.get(hash) == null) {
			vec.set(hash, new Entry<Long,LinkedList<String>>(key,new LinkedList<String>(contents)));
		}else if(vec.get(hash).getKey().equals(key) && 
				QuickSort.alphabetize(vec.get(hash).getContents().get(0)).equals(QuickSort.alphabetize(contents))) {
			
			//If the location in the Vector matches a hash with a current Entry in the HashMap then a desired
			//anagram collision has occurred so add the contents as a new Node in the LinkedList
			vec.get(hash).getContents().add(contents);
		}else {
			
			//If the Hash gives an improper index use linear probing to find the desired location in the Vector
			while(vec.get(hash) != null && vec.get(hash).getKey() != key) {
				hash = (hash + 1) % vec.size();
			}
			
			//If the location in Vector is null make a new Entry in the Vector
			//of type LinkedList<String>
			if(vec.get(hash) == null) {
				vec.set(hash, new Entry<Long,LinkedList<String>>(key,new LinkedList<String>(contents)));
			}else if(vec.get(hash).getKey().equals(key) && 
					QuickSort.alphabetize(vec.get(hash).getContents().get(0)).equals(QuickSort.alphabetize(contents))) {
				
				//If the location in the Vector matches a hash with a current Entry in the HashMap then a desired
				//anagram collision has occurred so add the contents as a new Node in the LinkedList
				vec.get(hash).getContents().add(contents);
			}else {
				
				//If the Hash gives an improper index use linear probing to find the desired location in the Vector
				vec.set(hash, new Entry<Long,LinkedList<String>>(key,new LinkedList<String>(contents)));
			}
		}
	}
	
	/*
	 * Print the contents of the HashMap
	 * 
	 * @param file    : the file to write the contents of the map to
	 * 
	 */
	public void printMap(String file) {
		
		//Object used to write to a file
		FileWriter printer = null;
		
		//Establish a file object to determine the existence of the file
		File mine = null;
		try {
			
			//Initialize file object to file
			mine = new File("./"+file);
			
			//If the file already exists delete it so additional content is
			//not appended to it
			if(mine.exists())
				mine.delete();
			
			//Initialize file writing object to the file location
			printer = new FileWriter("./"+file,true);
			
			//Initialize the size of the Vector
			int size = this.vec.size();
			
			//Iterate through the HashMap
			for(int i = 0; i < size; i++) {
				
				//If the Vector element does not have a null element
				if(vec.get(i) != null) {
					
					//Access the LinkedList printer for the Vector element
					vec.get(i).getContents().printList(printer);
				}	
			}
			
			//Close the printer once finished
			printer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Used to find LinkedList with more than five elements
	 */
	public void findMoreThanFive() {
		
		//Establish size of the Vector
		int size = this.vec.size();
		
		//Initialize the counter
		int count = 0;
		
		//Iterate through the Vector
		for(int i = 0; i < size; i++) {
			
			//If the element of the Vector is not null
			if(vec.get(i) != null) {
				
				//If the LinkedList has a size larger than five
				//print the contents of the LinkedList and increment
				//the counter
				if(vec.get(i).getContents().size() > 5) {
					vec.get(i).getContents().printList2();
					count++;
				}
			}	
		}
		
		//Print the number of times the LinkedLists in the HashMap had
		//a size greater than five
		System.out.println("Count -> " + count);
	}
	
	/*
	 * Used to print the contents of the HashMap to standard output
	 */
	public void printMap2() {
		int size = this.vec.size();
		for(int i = 0; i < size; i++) {
			if(vec.get(i) != null) {
				vec.get(i).getContents().printList2();
			}	
		}
	}
	
	//Debugging main method: Used to troubleshoot HashMap
//	public static void main(String[] args) {
//		HashMap myMap = new HashMap();
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("hello")), "hello");
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("hello")), "ehllo");
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("hello")), "elhlo");
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("world")), "world");
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("world")), "owrld");
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("world")), "orwld");
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("world")), "orlwd");
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("my")), "my");
//		myMap.put(Hashing.hashCode(QuickSort.alphabetize("my")), "ym");
//		myMap.printMap();
//		//myMap.get(Hashing.hashCode(QuickSort.alphabetize("hello"))).printList2();
//		//myMap.get(Hashing.hashCode(QuickSort.alphabetize("world"))).printList2();
//		//myMap.get(Hashing.hashCode(QuickSort.alphabetize("my"))).printList2();
//	}

}
