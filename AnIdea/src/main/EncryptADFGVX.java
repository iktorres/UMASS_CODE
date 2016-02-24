package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class EncryptADFGVX {
	
	// Variables
	// ______________________________________________________________________
	
	private ArrayList<ListPair> alphaIndex  = new ArrayList<ListPair>();
	private String[][]          polybius    = new String[6][6];
//	private String[][]          polybius    = {{"p","h","0","q","g","6"},
//											   {"4","m","e","a","1","y"},
//											   {"l","2","n","o","f","d"},
//											   {"x","k","r","3","c","v"},
//											   {"s","5","z","w","7","b"},
//											   {"j","9","u","t","i","8"}};
	private String[]           repCharacter = {"A","D","F","G","V","X"};
	private String[]           impArray     = null;
	private String[][]         encrypted1   = null;
	private String[][]         encrypted2   = null;
	private int[]              indices      = null;
	private String             message      = "";
	private String             key          = "";
	private String             enMessage    = "";
	// ______________________________________________________________________
	// Constructors
	//
	// ______________________________________________________________________
	
	public EncryptADFGVX() {
		
	}
	
	public EncryptADFGVX(String key,String message) {
		initializeAlpha();
		mutatePolybius();
		setMessage(message);
		setKey(key);
		this.enMessage = repMessageCharacter();
		//System.out.println(this.enMessage + " , " + this.enMessage.length());
		useKey();
		sortTheList();
		System.out.println(getEncodedMessage());
	}
	
	// ______________________________________________________________________
	// Getters & Setters
	//
	// ______________________________________________________________________
	private final static String getMonth(int month) {
		String mon = "";
		switch(month) {
			case  0:
				mon = "January";
				break;
			case  1:
				mon = "February";
				break;
			case  2:
				mon = "March";
				break;
			case  3:
				mon = "April";
				break;
			case  4:
				mon = "May";
				break;
			case  5:
				mon = "June";
				break;
			case  6:
				mon = "July";
				break;
			case  7:
				mon = "August";
				break;
			case 8:
				mon = "September";
				break;
			case 9:
				mon = "October";
				break;
			case 10:
				mon = "November";
				break;
			case 11:
				mon = "December";
				break;
		}
		return mon;
	}
	
	
	private void setKey(String key) {
		String temp   = "";
		String det    = "";
		int    length = key.length();
		for(int i = 0; i < length; i++) {
			temp = "" + key.charAt(i);
			if(isSymbol(temp)||!isLetter(temp)) {
				det = "";
				System.err.println("This is not a valid key");
				break;
			}else {
				det = "y";
			}
		}
		if(det == "") {
			this.key = "";
		}else {
			this.key = eliminateSpaces(key);
		}
	}
	
	private void setMessage(String message) {
		String mess   = "";
		String temp   = "";
		int    length = message.length();
		for(int i = 0; i < length; i++) {
			temp = "" + message.charAt(i);
			if(isSymbol(temp)) {
				mess += "";
			}else {
				mess += temp;
			}
		}
		this.message = eliminateSpaces(mess);
	}

	private String getEncodedMessage() {
		String concat = "";
		if(this.key != "") {
			int    length = encrypted2.length;
			int    colL   = 0;
			for(int i = 0; i < length; i++) {
				colL = encrypted2[i].length;
				for(int j = 0; j < colL; j++) {
					concat += encrypted2[i][j];
				}
			}
		}else {
			concat = "No message can be sent without a key!";
		}
		return concat;
	}
	
	// ______________________________________________________________________
	// Methods
	//
	// ______________________________________________________________________
	
//	private String decodeMessage(int hour, String key, String message) {
//		String     indexOfRem   = "";
//		String     mess         = "";
//		int        count        = 0;
//		int        messLength   = message.length();
//		int        keyLength    = key.length();
//		int        columnOfInt  = 0;
//		int        rowlengthCst = messLength/keyLength;
//		int        remainder    = messLength % keyLength;
//		int[]      columnLen    = new int[keyLength];
//		int[]      alpha        = alphabatize(key);
//		String[][] messMat      = new String[rowlengthCst + 1][keyLength];
//		String[][] finaMat      = new String[rowlengthCst + 1][keyLength];
//		int        alphaLen     = alpha.length;
//		int        finaMatL     = finaMat.length;
//		int        finaMatI     = finaMat[0].length;
//		int        ior          = 0;
//		int        colL         = 0;
//		int        temp         = 0;
//		int        temp2        = 0;
//		String[][] polybius     = thePolybius(hour);
//		//System.out.println(remainder);
//		for(int i = 0; i < alphaLen; i++) {
//			if(alpha[i] <= remainder - 1 && remainder != 0) {
//				columnLen[i] = rowlengthCst + 1;
//			}else
//				columnLen[i] = rowlengthCst;
//		}
//		
//		for(int i = 0; i < keyLength; i++) {
//			colL = columnLen[i];
//			for(int j = 0; j < colL; j++) {
//				messMat[j][i] = "" + message.charAt(count);
//				count++;
//			}
//		}
//		
//		for(int j = 0; j < keyLength; j++) {
//			columnOfInt = alpha[j];
//			for(int i = 0; i < columnLen[j]; i++) {
//				if(messMat[i][j] != null)
//					finaMat[i][columnOfInt] = messMat[i][j];
//				else
//					finaMat[i][j] = "";
//			}
//		}
//		
//		for(int i = 0; i < finaMatL; i++) {
//			for(int j = 0; j < finaMatI; j++) {
//				if(finaMat[i][j] != null)
//					indexOfRem += finaMat[i][j];
//			}
//		}
//		//System.out.println(indexOfRem);
//		count = 0;
//		ior   = indexOfRem.length()/2;
//		for(int i = 0; i < ior; i++) {
//			temp   = rowOrColumnIndex("" + indexOfRem.charAt(count));
//			temp2  = rowOrColumnIndex("" + indexOfRem.charAt(count+1));
//			mess  += polybius[temp][temp2];
//			count += 2;
//		} 
//		return mess;
//	}

	private void mutatePolybius() {
		String[][] hey = new String[6][6];
		try {
			Calendar            cal              = Calendar.getInstance();
			SimpleDateFormat    sdf              = new SimpleDateFormat("M d H");
			String              time             = sdf.format(cal.getTime()).toString();
			String[]            date             = time.split(" ");
			String              month            = getMonth(Integer.parseInt(date[0]) - 1);
			int                 day              = Integer.parseInt(date[1]) - 1;
			int                 hour             = Integer.parseInt(date[2]) - 1;
			String              extent           = "\\src\\polybius\\" + month + "\\" + month + "-" + day + ".txt";
			String              currentDirectory = new File("").getAbsolutePath() + extent;
			Scanner             wiz              = new Scanner(new File(currentDirectory));
			int                 count            = 0;
			String   poly                   = "";
			while(wiz.hasNextLine()) {
				poly = wiz.nextLine();
				if(count == hour) {
					System.out.println(poly);
					break;
				}
				count++;
			}
			wiz.close();
			
			count = 0;
			for(int i = 0; i < hey.length; i++) {
				for(int j = 0; j < hey[0].length; j++) {
					hey[i][j] = "" + poly.charAt(count);
					count++;
				}
			}
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		this.polybius = hey;
	}
	
	private String reverse(String poly) {
		String ret = "";
		for(int i = poly.length()-1; i >= 0; i--) {
			ret += poly.charAt(i);
		}
		return ret;
	}
	
	private int rowOrColumnIndex(String character) {
		int index = 0;
		switch(character) {
			case "A" :
				index = 0;
				break;
			case "D" :
				index = 1;
				break;
			case "F" :
				index = 2;
				break;
			case "G" :
				index = 3;
				break;
			case "V" :
				index = 4;
				break;
			case "X" :
				index = 5;
				break;
		}
		return index;
	}
	
	private String[] getColumn(int column) {
		String[] temp = new String[columnCount(column)];
		int      numC = columnCount(column);
		for(int i = 0; i < numC; i++) {
			temp[i] = encrypted1[i][column];
		}
		return temp;
	}
	
	private int columnCount(int column) {
		int count  = 0;
		int length = encrypted1.length; 
		try {
		String temp = "";
			for(int i = 0; i < length; i++) {
				temp = encrypted1[i][column];
				count++;
			}
		}catch(IndexOutOfBoundsException ex) {
		}
		return count;
	}
	
	private void useKey() {
		if(this.key == "") {
			System.err.println("No key was set!");
		}else {
			int numOfRows     = enMessage.length()/key.length();
			int lastRow       = enMessage.length() % key.length();
			int length        = 0;
			int colL          = 0;
			//String[][] array;
			if(lastRow != 0)
				encrypted1  = new String[numOfRows + 1][];
			else
				encrypted1  = new String[numOfRows][];
			for(int i = 0; i < encrypted1.length; i++) {
				if(i < encrypted1.length - 1)
					encrypted1[i] = new String[key.length()];
				else
					encrypted1[i] = new String[lastRow];
			}
			int count  = 0;
		    	length = encrypted1.length;
		    	for(int i = 0; i < length; i++) {
		    		colL = encrypted1[i].length;
		    		for(int j = 0; j < colL; j++) {
		    			encrypted1[i][j] = "" + enMessage.charAt(count);
		    			count++;
		    		}
		    	}
		}
		
		//Prints the array created
//		for(int i = 0; i < encrypted1.length; i++) {
//			//System.out.println(encrypted1[i].length);
//			for(int j = 0; j < encrypted1[i].length; j++) {
//				System.out.print(encrypted1[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	private boolean isLetter(String letter) {
		try {
			Integer.parseInt(letter);
			return false;
		}catch(NumberFormatException ex) {
			return true;
		}
	}
	
	private boolean isSymbol(String symbol) {
		boolean result = false;
		switch(symbol) {
			case "~" :
				result = true;
				break;
			case "`" :
				result = true;
				break;
			case "!" :
				result = true;
				break;
			case "@" :
				result = true;
				break;
			case "#" :
				result = true;
				break;
			case "$" :
				result = true;
				break;
			case "%" :
				result = true;
				break;
			case "^" :
				result = true;
				break;
			case "&" :
				result = true;
				break;
			case "*" :
				result = true;
				break;
			case "(" :
				result = true;
				break;
			case ")" :
				result = true;
				break;
			case "_" :
				result = true;
				break;
			case "-" :
				result = true;
				break;
			case "+" :
				result = true;
				break;
			case "=" :
				result = true;
				break;
			case "{" :
				result = true;
				break;
			case "}" :
				result = true;
				break;
			case "|" :
				result = true;
				break;
			case "\\" :
				result = true;
				break;
			case ":" :
				result = true;
				break;
			case ";" :
				result = true;
				break;
			case "\"":
				result = true;
				break;
			case "\'":
				result = true;
				break;
			case "<" :
				result = true;
				break;
			case "," :
				result = true;
				break;
			case ">" :
				result = true;
				break;
			case "." :
				result = true;
				break;
			case "?" :
				result = true;
				break;
			case "/" :
				result = true;
				break;
			case "[" :
				result = true;
				break;
			case "]" :
				result = true;
				break;
		}
		return result;
	}
	
	private String columnRowIndex(int row, int column) {
		String temp = "";
		temp = repCharacter[row] + repCharacter[column];
		return temp;
	}
	
	//This replaces the message characters with the ADFGVX characters
	private String repMessageCharacter() {
		String temp      = "";
		String interpret = "";
		if(this.key != "") {
			impArray = new String[message.length()];
			for(int i = 0; i < message.length(); i++) {
				temp = "" + message.charAt(i);
				for(int j = 0; j < polybius.length;j++) {
					for(int k = 0; k < polybius[0].length; k++) {
						if(temp.equalsIgnoreCase(polybius[j][k])) {
							impArray[i] = columnRowIndex(j,k);
						}
					}
				}
			}
			for(int i = 0; i < message.length(); i++) {
				interpret += impArray[i];
			}
		}else {
			interpret = "";
		}
		//System.out.println(interpret);
		return interpret;
	}
	
	private void initializeAlpha() {
		String s       = "\\u";
		String temp    = "";
		for (int i = 65; i <= 90; i++) {
			temp = s + temp + i;
			char c = (char) Integer.parseInt(temp.substring(2), 10);
			alphaIndex.add(new ListPair<String, Integer>("" + c, i - 65));
			temp = "";
		}
//		for (int i = 0; i < alphaIndex.size(); i++) {
//			System.out.println(alphaIndex.get(i));
//		}
	}
	
	private void sortTheList() {
		if(this.key != "" ) {
			int[] order = alphaOrder();
			encrypted2 = new String[key.length()][];
			for(int i = 0; i < key.length(); i++) {
				encrypted2[i] = getColumn(i);
			}
			for(int i = 0; i < key.length(); i++) {
				encrypted2[i] = getColumn(order[i]);
			}
		}
	}
	
	private int[] alphaOrder() {
		String temp = "";
		int[] order = new int[key.length()];
		for(int i = 0; i < order.length; i++) {
			order[i] = i;
		}
		indices = new int[key.length()];
		for (int i = 0; i < key.length(); i++) {
			temp = "" + key.charAt(i);
			for (int j = 0; j < alphaIndex.size(); j++) {
				if(temp.equalsIgnoreCase((String)alphaIndex.get(j).getLeft())) {
					indices[i] = (int) alphaIndex.get(j).getRight();
					//indices[i] = j;
				}
			}
		}
		int tent = 0;
		int swap = 0;
		for(int i = 0; i < indices.length - 1; i++) {
			for(int j = 0; j < indices.length - i - 1; j++)
				if(indices[j] > indices[j+1]) {
					tent         = indices[j];
					swap         = order[j];
					indices[j]   = indices[j+1];
					order[j]     = order[j+1];
					indices[j+1] = tent;
					order[j+1]   = swap;
				}
		}
		return order;
	}
	
	private int[] alphabatize(String word) {
		int      length      = word.length();
		int[][]  posIndex    = new int[length][2];
		int[][]  swap        = new int[1][2];
		int[]    supersed    = new int[length];
		String comptroller = "";
		//String returnStr   = "";
		for(int i = 0; i < length; i++) {
			comptroller = "" + word.charAt(i);
			for(int j = 0; j < alphaIndex.size(); j++) {
				if(comptroller.equalsIgnoreCase((String)alphaIndex.get(j).getLeft())) {
					posIndex[i][0] = (int)alphaIndex.get(j).getRight();
					posIndex[i][1] = i;
				}
			}
		}
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < length - i - 1; j++) {
				if(posIndex[j][0] > posIndex[j+1][0]) {
					swap[0]          = posIndex[j];
					posIndex[j]   = posIndex[j+1];
					posIndex[j+1] = swap[0];
				}
			}
		}
		for(int i = 0; i < length; i++) {
			//returnStr += word.charAt(posIndex[i][1]);
			supersed[i] = posIndex[i][1];
		}
		return supersed;
	}

	private String eliminateSpaces(String message) {
		String messRef = "";

		message += " ";
		int arrow = 0;
		int length = message.length();
		boolean isSpace = false;

		for (int i = 0; i < length; i++) {
			isSpace = ("" + message.charAt(i)).equals(" ");
			if (isSpace) {
				messRef += message.substring(arrow, i);
				arrow = i + 1;
			}
		}
		return messRef;
	}

	
}
