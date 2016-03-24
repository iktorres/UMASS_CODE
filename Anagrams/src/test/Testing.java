package test;

//Import File library
import java.io.File;

//Import FileNotFoundException for handling exception
import java.io.FileNotFoundException;

//Import Scanner for reading values of dict1 and dict2
import java.util.Scanner;

//Import all objects from Custom Data Structure and Sorting library: Ian Torres's Library
import data_structs_sorting.*;

public class Testing {

	//Method used to run executable
	public static void main(String[] args) {
		
		//Object used to find dict1
		String currentDirectory = new File("").getAbsolutePath() + "\\src\\dictionaries\\dict1";
		
		//Object used to find dict2
		String currentDirectory2= new File("").getAbsolutePath() + "\\src\\dictionaries\\dict2";
		
		//Temporary object used to read in the lines of the file
		String line = "";

		try {
			
			//Establish connection with dict1 from the Scanner object
			Scanner wiz = new Scanner(new File(currentDirectory));
			
			//Make a HashMap object to store all of the anagram classes
			HashMap myMap = new HashMap();
			
			//A timer used to keep track of the run-time: beginning time
			long start = System.currentTimeMillis();
	
			//Iterator used to iterate through the file
			while(wiz.hasNextLine()) {
				
				//Initialize the temporary object to the current line
				line = wiz.nextLine();
				
				//Store the contents of the line in the HashMap object along
				//along with its corresponding key
				myMap.put(Hashing.hashCode(QuickSort.alphabetize(line)), line);
			}
			
			//Print the contents of the HashMap to the anagram1 file
			//located in ./Anagrams/src/output/ directory
			myMap.printMap("anagram1");
			
			//A timer used to keep track of the run-time: ending time
			long end = System.currentTimeMillis();
			
			//Print how long it took to find all Anagrams input into the HashMap
			//and print the Anagram classes to anagram1
			System.out.println("time (ms) -> " + (end-start));
			
			//Print how many Anagram classes exist in anagram1 that have more than
			//five anagrams
			myMap.findMoreThanFive();
			
			//Establish connection with dict1 from the Scanner object
			wiz = new Scanner(new File(currentDirectory2));
			
			//Make a HashMap object to store all of the anagram classes
			myMap = new HashMap();
			
			//A timer used to keep track of the run-time: beginning time
			start = System.currentTimeMillis();
			
			//Iterator used to iterate through the file
			while(wiz.hasNextLine()) {
				
				//Initialize the temporary object to the current line
				line = wiz.nextLine();
				
				//Store the contents of the line in the HashMap object along
				//along with its corresponding key
				myMap.put(Hashing.hashCode(QuickSort.alphabetize(line)), line);
			}
			
			//Print the contents of the HashMap to the anagram1 file
			//located in ./Anagrams/src/output/ directory
			myMap.printMap("anagram2");
			
			//A timer used to keep track of the run-time: ending time
			end = System.currentTimeMillis();
			
			//Print how long it took to find all Anagrams input into the HashMap
			//and print the Anagram classes to anagram1
			System.out.println("time2(ms) -> " + (end-start));
			
			//Close the Scanner
			wiz.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
