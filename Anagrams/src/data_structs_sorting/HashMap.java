package data_structs_sorting;

public final class HashMap {
	
	public static long hashCode(String word) {
		int prime = 31;
		long hash  = 0;
		int length = word.length();
		for(int i = 0; i < length; i++) {
			hash += (long)word.charAt(i)*Math.pow(prime,(length - (i + 1)));
		}
		//System.out.println("Hash -> " + hash);
		return hash;
	}
	

}
