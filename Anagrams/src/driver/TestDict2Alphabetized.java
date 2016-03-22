package driver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data_structs_sorting.*;

public class TestDict2Alphabetized {
//	static LinkedList<Long> list  = new LinkedList<Long>();
//	static LinkedList<String>  slist = new LinkedList<String>();
//	
//	static LinkedList<String> lList = new LinkedList<String>();
//	
//	static ArrayList<LinkedList<String>> lOLists = new ArrayList<LinkedList<String>>();
//	static Node<String> ret = null;
//	
//	public static void initAndTest() {
//		//Catch possible File IOException
//		try {
//			
//			//Get the dict1 file from the dictionaries directory
//			String currentDirectory = new File("").getAbsolutePath() + "\\src\\dictionaries\\dict2";
//			
//			
//			
//			//Initialize Scanner to dict1 file
//			Scanner wiz = new Scanner(new File(currentDirectory));
//			
//			//Variable used to get the current line in the file
//			String line   = "";
//			String sorted = "";
//			int i     = 0;
//			int index = 0;
//			//Loop to get the lines of the file
//			while(wiz.hasNextLine()) {
//				//Iterator
//				line = wiz.nextLine();
//				sorted = QuickSort.alphabetize(line);
//				slist.add(line);
//				//list.add(sorted.hashCode());
//				list.add(Hashing.hashCode(sorted));
//				//index = slist.get(slist.lastIndexOf(line));
//				index = slist.lastIndexOf(line);
//				ret = (index != -1) ? slist.remove(index):null;
//				if(list.contains(Hashing.hashCode(sorted))) {
//					while(i < lOLists.size()) {
//						if(lOLists.get(i).contains(ret.getElement())) {
//							lOLists.get(i).add(ret.getElement());
//							break;
//						}
//						i++;
//					}
//				}else {
//					lOLists.add(new LinkedList<String>());
//					lOLists.get(lOLists.size()-1).add(ret.getElement());
//				}
//				
//				//System.out.println(line + "    ,    " + sorted + "    ,    " + HashMap.hashCode(sorted));
//			}
//			for(int j = 0; j < lOLists.size(); j++) {
//				if(lOLists.get(j).size() > 1)
//				lOLists.get(j).printList();
//			}
//			
//		}catch(IOException ex) {
//			System.err.println("File IO error");
//		}
//	}
//	
//	public static void main(String[] args) {
//		initAndTest();
//	}
}
