package main;

import java.util.ArrayList;
import java.util.Random;

public final class Polybius {
	
	private static String alphabetADFGVX = "abcdefghijklmnopqrstuvwxyz0123456789";
	private static String alphabetADFGX  = "abcdefghijklmnopqrstuvwxyz";
	private static String alphabetMEA    = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()_-+=:;<,>.?/{}[]";
	
	public static String polybiusGenerator(String choice) {
		//System.out.println(alphabetMEA.length());
		//polybius generator
		String             poly            = "";
		String             choiceCipher    = "";
		int                alphabetLength      ;
		int                size                ;
		ArrayList<Integer> numbers         = new ArrayList<Integer>();   
		Random             randomGenerator = new Random();
		
		if(choice.equals("ADFGVX")) {
			alphabetLength = 36;
			choiceCipher   = alphabetADFGVX;
		}else if(choice.equals("MEA")) {
			alphabetLength = 64;
			choiceCipher   = alphabetMEA;
		}else{
			alphabetLength = 26;
			choiceCipher   = alphabetADFGX;
		}
		
		while (numbers.size() < alphabetLength) {

		    int random = randomGenerator .nextInt(alphabetLength);
		    if (!numbers.contains(random)) {
		        numbers.add(random);
		    }
		}
		
		size = numbers.size();
		for(int i = 0; i < size; i++) {
			poly += choiceCipher.charAt(numbers.get(i));
		}
		//System.out.println(poly2);
		return poly;
	}

}
