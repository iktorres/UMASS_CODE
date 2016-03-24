package data_structs_sorting;

//Singleton design pattern used since a Java's sorting algorithm is implemented
//in a similar manner
public final class QuickSort {
	
	/*
	 * Outputs a word in alphabetical order
	 * 
	 * @param word    : a word to be alphabetized
	 * 
	 * @return retWord: alphabetized word
	 *
	 */
	public static String alphabetize(String word) {
		int[][] orderd = order(word);
		int length = word.length();
		String retWord = "";
		sort(orderd, 0,length);
		for(int i = 0; i < length; i++) {
			retWord += word.charAt(orderd[i][0]);
		}
		return retWord;
	}
	
	/*
	 * QuickSort: Implemented from the book using JAVA
	 * 
	 * @param a : the order array
	 * 
	 * @param p : left index
	 * 
	 * @param r : right index
	 * 
	 * @return  : void
	 */
	private static void sort(int[][] a, int p, int r) {
		if(p < r) {
			int q = partition(a,p,r);
			sort(a,p,q);
			sort(a,q+1,r);
		}
	}
	
	/*
	 * Takes the next pivot point and swaps values
	 * 
	 * @param a  :  index array
	 * 
	 * @param p  :  left index
	 * 
	 * @param r  :  right index
	 * 
	 * @return i : the next pivot value
	 */
	private static int partition(int[][] a, int p, int r) {
		int i = p-1;
		for(int j = p; j <= r-1; j++) {
			if(a[j][1] < a[r-1][1]) {
				i++;
				a = swap(a,i,j);
			}
		}
		a = swap(a,i+1,r-1);
		return i + 1;
	}
	
	/*
	 * Determine the ascii values of the characters
	 * putting them in the 2nd column and the original
	 * index of the letters in the 1st column
	 *  
	 * @param word    : the word to be indexed
	 * 
	 * @return wordAI : alphabetized array index
	 */
	private static int[][] order(String word) {
		int length = word.length();
		int wordAI[][] = new int[length][2];
		char wordAC[] = word.toCharArray();
		
		for(int i = 0; i < length; i++) {
			wordAI[i][0] = i;
			wordAI[i][1] = classifyLetter(wordAC[i]);
		}
		return wordAI;
	}
	
	/*
	 * Takes a character and classifies it from 0..25
	 * based on its ascii value
	 * 
	 * @param character : character to be classified
	 * 
	 * @return value    : an integer value of the character
	 */
	private static int classifyLetter(char character) {
		return (character - 97);
	}
	
	/*
	 * Used to swap the rows of an array
	 * 
	 * @param array[][]  : Array of index values
	 * @param i          : first index
	 * @param j          : second index
	 * @return array[][] : swapped array
	 * 
	 */
	private static int[][] swap(int array[][], int i, int j) {
		int temp[] = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
	
	
	/*
	 * Debugging main method to check implementation
	/*
	public static void main(String[] args) {
		String word = QuickSort.alphabetize("egdcfb");
		System.out.println(QuickSort.alphabetize("egcdkjlj"));
		System.out.println(QuickSort.alphabetize("hello"));
		System.out.println(QuickSort.alphabetize("games"));
		System.out.println(QuickSort.alphabetize("sames"));
		System.out.println(QuickSort.alphabetize("lames"));
	}*/
	
}
