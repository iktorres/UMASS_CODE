package driver;

//Import JAVA IO
import java.io.File;
//Import JAVA IOException
import java.io.IOException;
//Import JAVA Scanner
import java.util.Scanner;
//Import Customized QuickSort
import data_structs_sorting.QuickSort;;

public class TestDict1Alphabetized {
	
	public static void initAndTest() {
		//Catch possible File IOException
		try {
			
			//Get the dict1 file from the dictionaries directory
			String currentDirectory = new File("").getAbsolutePath() + "\\src\\dictionaries\\dict1";
			
			//Initialize Scanner to dict1 file
			Scanner wiz = new Scanner(new File(currentDirectory));
			
			//Variable used to get the current line in the file
			String line = "";
			
			//Loop to get the lines of the file
			while(wiz.hasNextLine()) {
				//Iterator
				line = wiz.nextLine();
				System.out.println(line + "    ,    " + QuickSort.alphabetize(line));
			}
			
		}catch(IOException ex) {
			System.out.println("File IO error");
		}
	}
	
	public static void main(String[] args) {
		initAndTest();
	}

}
