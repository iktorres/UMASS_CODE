package data_structs_sorting;

//A singleton design pattern is used to find the Hash of a given String
public final class Hashing {
	
	/*
	 * Find the hashCode of a given word
	 * 
	 * @param word : word to be input into the Singleton object
	 * 
	 * @return hash
	 * 
	 */
	public static long hashCode(String word) {
		
		//Research shows that the prime number 31 is used in many hash functions
		int prime = 31;
		
		//The resultant hash
		long hash  = 0;
		
		//Establish the length of the word
		int length = word.length();
		
		//Iterate through every character of the word
		for(int i = 0; i < length; i++) {
			
			//Generate the hash function using this formula
			hash += (long)word.charAt(i)*Math.pow(prime,(length - (i + 1)));
		}
		
		//Return the resultant value of the hash
		return hash;
	}
	

}
