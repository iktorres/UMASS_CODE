package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import data_structs_sorting.*;

public class Testing {
	
	public static int revHash(long hash) {
		int index = 0;
		int length = (int)Math.ceil(Math.log10(hash));
		for(int i = 0; i < length; i++) {
			index += hash % Math.pow(31, length - (length - i));
			hash /= 31;
		}
		return index;
	}
	
	public static void main(String[] args) {
		String currentDirectory = new File("").getAbsolutePath() + "\\src\\dictionaries\\dict1";
		String currentDirectory2= new File("").getAbsolutePath() + "\\src\\dictionaries\\dict2";
		String line = "";

		try {
			Scanner wiz = new Scanner(new File(currentDirectory));
			HashMap myMap = new HashMap();
			long start = System.currentTimeMillis();
	
			//int count = 0;
	
			while(wiz.hasNextLine()) {
				line = wiz.nextLine();
				myMap.put(Hashing.hashCode(QuickSort.alphabetize(line)), line);
				//System.out.println("Count -> " + count);
				//count++;
			}	
			myMap.printMap("anagram1");
			long end = System.currentTimeMillis();
			System.out.println("time (ms) -> " + (end-start));
			
			wiz = new Scanner(new File(currentDirectory2));
			myMap = new HashMap();
			start = System.currentTimeMillis();
			//count = 0;
			while(wiz.hasNextLine()) {
				line = wiz.nextLine();
				myMap.put(Hashing.hashCode(QuickSort.alphabetize(line)), line);
				//System.out.println("Count -> " + count);
				//count++;
			}
			myMap.printMap("anagram2");
			end = System.currentTimeMillis();
			System.out.println("time2(ms) -> " + (end-start));	
			wiz.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
