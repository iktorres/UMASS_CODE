package test;

import data_structs_sorting.Hashing;

public class HashTest {

	//Used to test the capabilities of the Hashing.hashCode(word) and compare to Java's hashCode
	public static void main(String[] args) {
		System.out.println("Supercalifragilisticxpialidocious".hashCode() + " , " + Hashing.hashCode("Supercalifragilisticxpialidocious"));
	}

}
