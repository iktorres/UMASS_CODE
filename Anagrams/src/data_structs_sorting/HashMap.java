package data_structs_sorting;

import java.io.FileWriter;
import java.io.IOException;

public class HashMap {
	
	private Vector<Entry<Long,LinkedList<String>>> vec;
	
	public HashMap() {
		vec = new Vector<Entry<Long,LinkedList<String>>>();
		for(int i = 0; i < vec.size(); i++) {
			vec.set(i, null);
		}
	}
	
	public LinkedList<String> get(long key) {
		int hash = (int)(key % vec.size());
		while(vec.get(hash) != null && vec.get(hash).getKey() != key) {
			hash = (hash + 1) % vec.size();
		}
		if(vec.get(hash) == null) {
			return null;
		}else {
			return vec.get(hash).getContents();
		}
	}
	
	public void put(long key, String contents) {
		int hash = (int)(key % vec.size());
		if(vec.get(hash) == null) {
			vec.set(hash, new Entry<Long,LinkedList<String>>(key,new LinkedList<String>(contents)));
			//System.out.println("Here1 -> " + contents);
		}else if(vec.get(hash).getKey().equals(key) && 
				QuickSort.alphabetize(vec.get(hash).getContents().get(0)).equals(QuickSort.alphabetize(contents))) {
			vec.get(hash).getContents().add(contents);
			//System.out.println("Here2 -> " + contents);
		}else {
			while(vec.get(hash) != null && vec.get(hash).getKey() != key) {
				hash = (hash + 1) % vec.size();
			}
			if(vec.get(hash) == null) {
				vec.set(hash, new Entry<Long,LinkedList<String>>(key,new LinkedList<String>(contents)));
				//System.out.println("Here1 -> " + contents);
			}else if(vec.get(hash).getKey().equals(key) && 
					QuickSort.alphabetize(vec.get(hash).getContents().get(0)).equals(QuickSort.alphabetize(contents))) {
				vec.get(hash).getContents().add(contents);
				//System.out.println("Here2_2 -> " + contents);
			}else {
				//System.out.println("Here3 -> " + contents);
				vec.set(hash, new Entry<Long,LinkedList<String>>(key,new LinkedList<String>(contents)));
			}
		}
	}
	
	public void printMap(String file) {
		FileWriter printer = null;
		try {
			printer = new FileWriter(".\\src\\output\\"+file,true);
			int size = this.vec.size();
			for(int i = 0; i < size; i++) {
				if(vec.get(i) != null) {
					vec.get(i).getContents().printList(printer);
				}	
			}
			printer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findMoreThanFive() {
		int size = this.vec.size();
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(vec.get(i) != null) {
				if(vec.get(i).getContents().size() > 5) {
					vec.get(i).getContents().printList2();
					count++;
				}
			}	
		}
		System.out.println("Count -> " + count);
	}
	
	public void printMap2() {
		int size = this.vec.size();
		for(int i = 0; i < size; i++) {
			if(vec.get(i) != null) {
				vec.get(i).getContents().printList2();
			}	
		}
	}
	
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
//		//myMap.get(Hashing.hashCode(QuickSort.alphabetize("hello"))).printList();
//		//myMap.get(Hashing.hashCode(QuickSort.alphabetize("world"))).printList();
//		//myMap.get(Hashing.hashCode(QuickSort.alphabetize("my"))).printList();
//	}

}
