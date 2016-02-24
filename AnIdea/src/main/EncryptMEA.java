package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class EncryptMEA {
	
	private String[]            repCharacter = {"$", "!", "?", "^", "/", "{", "+", "="};
	private ArrayList<ListPair> alphaIndex   = initializeAlpha();

	private String[][]          polybius     = new String[8][8];
	private String[]            impArray     = null;
	private String[][]          encrypted1   = null;
	private String[][]          encrypted2   = null;
	private int[]               indices      = null;
	private String              message      = "";
	private String              key          = "";
	private String              enMessage    = "";
	
	
	public EncryptMEA(String key, String message) {
		mutatePolybius();
		setMessage(message);
		setKey(key);
		this.enMessage = repMessageCharacter();
		System.out.println(this.enMessage + " , " + this.enMessage.length());
		useKey();
		sortTheList();
		System.out.println(getEncodedMessage());
	}
	
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
		String res    = "";
		String temp   = "";
		int    length = key.length();
		for(int i = 0; i < length; i++) {
			temp = "" + key.charAt(i);
			if(isIllegalSymbol(temp))
				res += "";
			else
				res += temp;
		}
		this.key = eliminateSpaces(res);
	}
	
	private void setMessage(String message) {
		String mess   = "";
		String temp   = "";
		int    length = message.length();
		for(int i = 0; i < length; i++) {
			temp = "" + message.charAt(i);
			if(isIllegalSymbol(temp)) {
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
	
	private ArrayList<ListPair> initializeAlpha() {
		ArrayList<ListPair> myList = new ArrayList<ListPair>();
		String              s      = "\\u";
		String              temp   = "";
		char                c      = ' ';        
		for (int i = 65; i <= 90; i++) {
			temp = s + temp + i;
			c    = (char) Integer.parseInt(temp.substring(2), 10);
			myList.add(new ListPair<String, Integer>("" + c, i - 65));
			temp = "";
		}
		
		for(int i = 48; i <= 57; i++) {
			temp = s + temp + i;
			c    = (char) Integer.parseInt(temp.substring(2), 10);
			myList.add(new ListPair<String, Integer>("" + c, i - 22));
			temp = "";
		}
		
		myList.add(new ListPair<String, Integer>("`",35));
		myList.add(new ListPair<String, Integer>("~",36));
		myList.add(new ListPair<String, Integer>("!",37));
		myList.add(new ListPair<String, Integer>("@",38));
		myList.add(new ListPair<String, Integer>("#",39));
		myList.add(new ListPair<String, Integer>("$",40));
		myList.add(new ListPair<String, Integer>("%",41));
		myList.add(new ListPair<String, Integer>("^",42));
		myList.add(new ListPair<String, Integer>("&",43));
		myList.add(new ListPair<String, Integer>("*",44));
		myList.add(new ListPair<String, Integer>("(",45));
		myList.add(new ListPair<String, Integer>(")",46));
		myList.add(new ListPair<String, Integer>("-",47));
		myList.add(new ListPair<String, Integer>("_",48));
		myList.add(new ListPair<String, Integer>("=",49));
		myList.add(new ListPair<String, Integer>("+",50));
		myList.add(new ListPair<String, Integer>("[",51));
		myList.add(new ListPair<String, Integer>("{",52));
		myList.add(new ListPair<String, Integer>("]",53));
		myList.add(new ListPair<String, Integer>("}",54));
		myList.add(new ListPair<String, Integer>(";",55));
		myList.add(new ListPair<String, Integer>(":",56));
		myList.add(new ListPair<String, Integer>(",",57));
		myList.add(new ListPair<String, Integer>("<",58));
		myList.add(new ListPair<String, Integer>(",",59));
		myList.add(new ListPair<String, Integer>(".",60));
		myList.add(new ListPair<String, Integer>(">",61));
		myList.add(new ListPair<String, Integer>("/",62));
		myList.add(new ListPair<String, Integer>("?",63));
		
//		for (int i = 0; i < myList.size(); i++) {
//			System.out.println(myList.get(i));
//		}
		return myList;
	}
	
	private void mutatePolybius() {
		String[][] hey = new String[8][8];
//		try {
//			Calendar            cal              = Calendar.getInstance();
//			SimpleDateFormat    sdf              = new SimpleDateFormat("M d H");
//			String              time             = sdf.format(cal.getTime()).toString();
//			String[]            date             = time.split(" ");
//			String              month            = getMonth(Integer.parseInt(date[0]) - 1);
//			int                 day              = Integer.parseInt(date[1]) - 1;
//			int                 hour             = Integer.parseInt(date[2]) - 1;
//			String              extent           = "\\src\\polybius\\" + month + "\\" + month + "-" + day + ".txt";
//			String              currentDirectory = new File("").getAbsolutePath() + extent;
//			Scanner             wiz              = new Scanner(new File(currentDirectory));
			int                 count            = 0;
			String   poly                   = "(f20>a]<=_y+/)`3&t5c}dlxipqo[#48*6vs$hu;!k.b@?%{1:nmj-,w^9ez7rg~";
//			while(wiz.hasNextLine()) {
//				poly = wiz.nextLine();
//				if(count == hour) {
//					System.out.println(poly);
//					break;
//				}
//				count++;
//			}
//			wiz.close();
			
			count = 0;
			for(int i = 0; i < polybius.length; i++) {
				for(int j = 0; j < polybius[0].length; j++) {
					hey[i][j] = "" + poly.charAt(count);
					count++;
				}
			}
//			for(int i = 0; i < hey.length; i++) {
//				for(int j = 0; j < hey[0].length; j++) {
//					System.out.print(hey[i][j]);
//				}
//				System.out.println();
//			}
		//}catch(FileNotFoundException ex) {
		//	ex.printStackTrace();
		//}
		this.polybius = hey;
	}

	
	private int rowOrColumnIndex(String character) {
		int index = 0;
		switch(character) {
			case "$" :
				index = 0;
				break;
			case "!" :
				index = 1;
				break;
			case "?" :
				index = 2;
				break;
			case "^" :
				index = 3;
				break;
			case "/" :
				index = 4;
				break;
			case "{" :
				index = 5;
				break;
			case "+" :
				index = 6;
				break;
			case "=" :
				index = 7;
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
		    		//System.out.println(count + " , " + enMessage.charAt(count));
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
//		System.out.println();
	}
	
	private boolean isLetter(String letter) {
		try {
			Integer.parseInt(letter);
			return false;
		}catch(NumberFormatException ex) {
			return true;
		}
	}
	
	private boolean isIllegalSymbol(String symbol) {
		boolean result = false;
		switch(symbol) {
			case "|" :
				result = true;
				break;
			case "\\" :
				result = true;
				break;
			case "\"":
				result = true;
				break;
			case "\'":
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
		int    messL     = message.length();
		int    polyL     = polybius.length;
		int    polyR     = polybius[0].length;
		if(this.key != "") {
			impArray = new String[messL];
			for(int i = 0; i < messL; i++) {
				temp = "" + message.charAt(i);
				for(int j = 0; j < polyL;j++) {
					for(int k = 0; k < polyR; k++) {
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
	
	private void sortTheList() {
		if(this.key != "" ) {
			int[] order = alphaOrder();
//			for(int i = 0; i < order.length; i++) {
//				System.out.println(order[i]);
//			}
			encrypted2  = new String[key.length()][];
			for(int i = 0; i < key.length(); i++) {
				encrypted2[i] = getColumn(i);
			}
			//()()()()()()()()()()()()()()()()()()()()()()
//			for(int i = 0; i < encrypted2.length; i++) {
//				for(int j = 0; j < encrypted2[i].length; j++) {
//					System.out.print(encrypted2[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			//()()()()()()()()()()()()()()()()()()()()()()
			for(int i = 0; i < key.length(); i++) {
				encrypted2[i] = getColumn(order[i]);
			}
			//()()()()()()()()()()()()()()()()()()()()()()
//			for(int i = 0; i < encrypted2.length; i++) {
//				for(int j = 0; j < encrypted2[i].length; j++) {
//					System.out.print(encrypted2[i][j]);
//				}
//				System.out.println();
//			}
			//()()()()()()()()()()()()()()()()()()()()()()
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
		String   comptroller = "";

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
