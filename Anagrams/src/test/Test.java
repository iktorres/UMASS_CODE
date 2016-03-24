package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

//import data_structs_sorting.*;

public class Test {
	
	//Used as a review for my own purposes to write to a file as well as further testing of LinkedList
	public static void main (String[] args) {
		try {
			PrintWriter printer = new PrintWriter(".\\src\\output\\anagram1");
			printer.println("Hello");
			printer.flush();
			printer.println("World");
			printer.flush();
			printer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		LinkedList<Tuple<String,Long>> myChain = new LinkedList<Tuple<String,Long>>();
//		
//		myChain.add(new Tuple<String,Long>("hello",HashMap.hashCode(QuickSort.alphabetize("hello"))));
//		System.out.println(HashMap.hashCode(QuickSort.alphabetize("hello")));
//		System.out.println(HashMap.hashCode(QuickSort.alphabetize("hello")) % 31);
	}

}
