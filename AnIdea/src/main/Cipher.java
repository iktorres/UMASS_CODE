package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

@SuppressWarnings({ "rawtypes", "unused" })
public final class Cipher {
	
	private static String              beaufort[]  = new String[26];
	private static ArrayList<ListPair> alphaIndex  = initializeAlpha();
	private static ArrayList<ListPair> alphaIndex2 = initializeAlpha2();
	private final static String                    getMonth                    (int month) {
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
	
	private final static String[][]                polybius(int hour, int mon, int day, String directory) {
		String     poly    = ""      ;
		String[][] hey               ;
		String     dir               ;
		int        hr      = hour - 1;
		int        dy      = day - 1 ;
		if(directory.equalsIgnoreCase("polybiusADFGVX")) {
			hey = new String[6][6];
			dir = "polybius";
		}else if(directory.equalsIgnoreCase("polybiusADFGX")) {
			hey = new String[5][5];
			dir = "polybius";
		}else {
			hey = new String[8][8];
			dir = "polybius_3";
		}
		try {
			
//			Calendar            cal              = Calendar.getInstance();
//			SimpleDateFormat    sdf              = new SimpleDateFormat("M d");
//			String              time             = sdf.format(cal.getTime()).toString();
			String              month            = getMonth(mon - 1);
			//System.out.println(month + "/" + dy + "/" + hr);
			String              extent           = "\\src\\" + dir + "\\" + month + "\\" + month + "-" + dy + ".txt";
			String              currentDirectory = new File("").getAbsolutePath() + extent;
			Scanner             wiz              = new Scanner(new File(currentDirectory));
			int                 count            = 0;
			
			while(wiz.hasNextLine()) {
				poly = wiz.nextLine();
				if(count == hr) {
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
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return hey;
	}
	
	private final static String[][]                thePolybius                 (int hour, int mon, int day) {
		String poly    = "";
		String[][] hey = new String[6][6];
		int        hr  = hour - 1;
		int        dy  = day - 1;
		try {
			
//			Calendar            cal              = Calendar.getInstance();
//			SimpleDateFormat    sdf              = new SimpleDateFormat("M d");
//			String              time             = sdf.format(cal.getTime()).toString();
			String              month            = getMonth(mon - 1);
			//System.out.println(month + "/" + dy + "/" + hr);
			String              extent           = "\\src\\polybius\\" + month + "\\" + month + "-" + dy + ".txt";
			String              currentDirectory = new File("").getAbsolutePath() + extent;
			Scanner             wiz              = new Scanner(new File(currentDirectory));
			int                 count            = 0;
			
			while(wiz.hasNextLine()) {
				poly = wiz.nextLine();
				if(count == hr) {
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
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return hey;
	}
	
	private final static String[][]                thePolybius2                (int hour) {
		String poly    = "";
		String[][] hey = new String[5][5];
		int        hr  = hour - 1;
		try {
			
			Calendar            cal              = Calendar.getInstance();
			SimpleDateFormat    sdf              = new SimpleDateFormat("M d");
			String              time             = sdf.format(cal.getTime()).toString();
			String[]            date             = time.split(" ");
			String              month            = getMonth(Integer.parseInt(date[0]) - 1);
			int                 day              = Integer.parseInt(date[1]) - 1;
			String              extent           = "\\src\\polybius_2\\" + month + "\\" + month + "-" + day + ".txt";
			String              currentDirectory = new File("").getAbsolutePath() + extent;
			Scanner             wiz              = new Scanner(new File(currentDirectory));
			int                 count            = 0;
			
			while(wiz.hasNextLine()) {
				poly = wiz.nextLine();
				if(count == hr) {
					break;
				}
				count++;
			}

			count = 0;
			for(int i = 0; i < hey.length; i++) {
				for(int j = 0; j < hey[0].length; j++) {
					hey[i][j] = "" + poly.charAt(count);
					count++;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return hey;
	}
	
	private final static String                    reverse                     (String poly) {
		String ret = "";
		for(int i = poly.length()-1; i >= 0; i--) {
			ret += poly.charAt(i);
		}
		return ret;
	}
	
	private final static int                       rowOrColumnIndex            (String character) {
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

	private final static int                       rowOrColumnIndex2           (String character) {
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
			case "X" :
				index = 4;
				break;
		}
		return index;
	}
	
	private final static int[]                     alphabatize                 (String word) {
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
	
	private final static int[]                     alphabatize2                (String word) {
		int      length      = word.length();
		int[][]  posIndex    = new int[length][2];
		int[][]  swap        = new int[1][2];
		int[]    supersed    = new int[length];
		String comptroller = "";
		//String returnStr   = "";
		for(int i = 0; i < length; i++) {
			comptroller = "" + word.charAt(i);
			for(int j = 0; j < alphaIndex2.size(); j++) {
				if(comptroller.equalsIgnoreCase((String)alphaIndex2.get(j).getLeft())) {
					posIndex[i][0] = (int)alphaIndex2.get(j).getRight();
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

	private final static ArrayList<ListPair>       initializeAlpha             () {
		String s       = "\\u";
		String temp    = "";
		ArrayList<ListPair> myList = new ArrayList<ListPair>();
		for (int i = 65; i <= 90; i++) {
			temp = s + temp + i;
			char c = (char) Integer.parseInt(temp.substring(2), 10);
			myList.add(new ListPair<String, Integer>("" + c, i - 65));
			temp = "";
		}
//		for (int i = 0; i < alphaIndex.size(); i++) {
//			System.out.println(alphaIndex.get(i));
//		}
		return myList;
	}
	
	private final static ArrayList<ListPair>       initializeAlpha2() {
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
	
	private final static String                    eliminateSpaces             (String message) {
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

	private final static boolean                   isLetter                    (String letter) {
		try {
			Integer.parseInt(letter);
			return false;
		}catch(NumberFormatException ex) {
			return true;
		}
	}
	
	private final static boolean                   isSymbol                    (String symbol) {
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
	
	private final static boolean                   isValidKey                  (String key) {
		int length = key.length();
		boolean result = true;
		String temp = "";
		for(int i = 0; i < length; i++) {
			temp = "" + key.charAt(i);
			if(!isLetter(temp)||isSymbol(temp)) {
				result = false;
			}
		}
		return result;
	}

	private final static String                    beaufort_Key_Initializer    (String key, String message) {
		String rep = "";
		int length = key.length();
		int length2 = message.length();
		int loopL = 0;
		int i = 0;

		if (length2 < length || length >= length2 ) {
			rep = key.substring(0, length2);
		} else {

			loopL = length2 / length;
			i = 0;

			for (; i < loopL; i++) {
				rep += key.substring(0, length);
			}
			int number = rep.length();
			rep += key.substring(0, length2 - number);
		}
		return rep;
	}
	
	private final static void                      beaufort_Cipher_Initialize () {
		String s = "\\u";
		String temp = "";
		String product = "";
		String inter = "";
		for (int i = 65; i <= 90; i++) {
			temp = s + temp + i;
			char c = (char) Integer.parseInt(temp.substring(2), 10);
			alphaIndex.add(new ListPair<String, Integer>("" + c, i - 65));
			product += c;
			temp = "";
		}
		int length = product.length();
		beaufort[0] = product;
		for (int k = 1; k < 26; k++) {
			for (int i = k; i < length; i++) {
				temp = "" + product.substring(0, k);
				inter = product.substring(k, length) + temp;
			}
			beaufort[k] = inter;
		}
		// for (int i = 0; i < 26; i++)
		// System.out.println(beaufort[i]);
	}
	
	private final static void					   decryptMEA				   (String hourMonthDate, String key, String message) {
		
	}
	
	public  final static String                    decryptADFGVX              (String hourMonthDate, String key, String message) {
		String mess         = "";
		if(isValidKey(eliminateSpaces(key))) {
			initializeAlpha();
			String     indexOfRem   = "";
			String[]   decryptDat   = hourMonthDate.split("/");
			System.out.println(decryptDat[0] + " , " + decryptDat[1] + " , " + decryptDat[2]);
			int        hour         = Integer.parseInt(decryptDat[0]);
			int        month        = Integer.parseInt(decryptDat[1]);
			int        day          = Integer.parseInt(decryptDat[2]);
			int        count        = 0;
			int        messLength   = message.length();
			int        keyLength    = eliminateSpaces(key).length();
			int        columnOfInt  = 0;
			int        rowlengthCst = messLength/keyLength;
			int        remainder    = messLength % keyLength;
			int[]      columnLen    = new int[keyLength];
			int[]      alpha        = alphabatize(eliminateSpaces(key));
			String[][] messMat      = new String[rowlengthCst + 1][keyLength];
			String[][] finaMat      = new String[rowlengthCst + 1][keyLength];
			int        alphaLen     = alpha.length;
			int        finaMatL     = finaMat.length;
			int        finaMatI     = finaMat[0].length;
			int        ior          = 0;
			int        colL         = 0;
			int        temp         = 0;
			int        temp2        = 0;
			String[][] polybius     = polybius(hour,month,day,"polybiusADFGVX");
			//System.out.println(remainder);
			//()()()()()()()()()()()()()()()()()()
//			System.out.println("Remainder,rowlen -> " + remainder + " , " + rowlengthCst);
//			for(int i = 0; i < alpha.length; i++) {
//				System.out.println(alpha[i]);
//			}
			
			//()()()()()()()()()()()()()()()()()()
			
			
			for(int i = 0; i < alphaLen; i++) {
				if(alpha[i] <= remainder - 1 && remainder != 0) {
					columnLen[i] = rowlengthCst + 1;
				}else
					columnLen[i] = rowlengthCst;
			}
			
			for(int i = 0; i < keyLength; i++) {
				colL = columnLen[i];
				for(int j = 0; j < colL; j++) {
					messMat[j][i] = "" + message.charAt(count);
					count++;
				}
			}
			
			for(int j = 0; j < keyLength; j++) {
				columnOfInt = alpha[j];
				for(int i = 0; i < columnLen[j]; i++) {
					if(messMat[i][j] != null)
						finaMat[i][columnOfInt] = messMat[i][j];
					else
						finaMat[i][j] = "";
				}
			}
			
			for(int i = 0; i < finaMatL; i++) {
				for(int j = 0; j < finaMatI; j++) {
					if(finaMat[i][j] != null)
						indexOfRem += finaMat[i][j];
				}
			}
			//System.out.println(indexOfRem);
			count = 0;
			ior   = indexOfRem.length()/2;
			for(int i = 0; i < ior; i++) {
				temp   = rowOrColumnIndex("" + indexOfRem.charAt(count));
				temp2  = rowOrColumnIndex("" + indexOfRem.charAt(count+1));
				mess  += polybius[temp][temp2];
				count += 2;
			} 
		}else {
			System.err.println("Not a valid key!");
			mess = "";
		}
			return mess;
	}

	public  final static String                    decryptADFGX               (String hourMonthDate, String key, String message) {
		String mess         = "";
		if(isValidKey(eliminateSpaces(key))) {
			initializeAlpha();
			String     indexOfRem   = "";
			String[]   decryptDat   = hourMonthDate.split("/");
			System.out.println(decryptDat[0] + " , " + decryptDat[1] + " , " + decryptDat[2]);
			int        hour         = Integer.parseInt(decryptDat[0]);
			int        month        = Integer.parseInt(decryptDat[1]);
			int        day          = Integer.parseInt(decryptDat[2]);
			int        count        = 0;
			int        messLength   = message.length();
			int        keyLength    = eliminateSpaces(key).length();
			int        columnOfInt  = 0;
			int        rowlengthCst = messLength/keyLength;
			int        remainder    = messLength % keyLength;
			int[]      columnLen    = new int[keyLength];
			int[]      alpha        = alphabatize(eliminateSpaces(key));
			String[][] messMat      = new String[rowlengthCst + 1][keyLength];
			String[][] finaMat      = new String[rowlengthCst + 1][keyLength];
			int        alphaLen     = alpha.length;
			int        finaMatL     = finaMat.length;
			int        finaMatI     = finaMat[0].length;
			int        ior          = 0;
			int        colL         = 0;
			int        temp         = 0;
			int        temp2        = 0;
			String[][] polybius     = polybius(hour,month,day,"polybiusADFGX");
			//System.out.println(remainder);
			for(int i = 0; i < alphaLen; i++) {
				if(alpha[i] <= remainder - 1 && remainder != 0) {
					columnLen[i] = rowlengthCst + 1;
				}else
					columnLen[i] = rowlengthCst;
			}
			
			for(int i = 0; i < keyLength; i++) {
				colL = columnLen[i];
				for(int j = 0; j < colL; j++) {
					messMat[j][i] = "" + message.charAt(count);
					count++;
				}
			}
			
			for(int j = 0; j < keyLength; j++) {
				columnOfInt = alpha[j];
				for(int i = 0; i < columnLen[j]; i++) {
					if(messMat[i][j] != null)
						finaMat[i][columnOfInt] = messMat[i][j];
					else
						finaMat[i][j] = "";
				}
			}
			
			for(int i = 0; i < finaMatL; i++) {
				for(int j = 0; j < finaMatI; j++) {
					if(finaMat[i][j] != null)
						indexOfRem += finaMat[i][j];
				}
			}
			//System.out.println(indexOfRem);
			count = 0;
			ior   = indexOfRem.length()/2;
			for(int i = 0; i < ior; i++) {
				temp   = rowOrColumnIndex2("" + indexOfRem.charAt(count));
				temp2  = rowOrColumnIndex2("" + indexOfRem.charAt(count+1));
				mess  += polybius[temp][temp2];
				count += 2;
			} 
		}else {
			System.err.println("Not a valid key!");
			mess = "";
		}
			return mess;
	}
	
	public  final static String                    decryptBeaufort            (String key, String message) {
		String decrypt   = "";	
		if(isValidKey(key)) {
				beaufort_Cipher_Initialize();
				int length       = message.length();
				int alphaS       = alphaIndex.size();
				int beaufL       = beaufort.length;
				int rowInd[]     = new int[length];
				int colInd[]     = new int[length];
				String keyC      = "";
				String enC       = "";
				String getIndex  = "";
				String getIndex2 = "";
				String keyN = beaufort_Key_Initializer(key,message);
			
				for (int j = 0; j < length; j++) {
					enC      = "" + message.charAt(j);
					keyC     = "" + keyN.charAt(j);
					for (int i = 0; i < alphaS; i++) {
						getIndex = (String) alphaIndex.get(i).getLeft();
						if (enC.equalsIgnoreCase(getIndex)) {
							rowInd[j] = (int) alphaIndex.get(i).getRight();
							for(int k = 0; k < beaufL; k++) {
								getIndex2 = "" + beaufort[rowInd[j]].charAt(k);
								if (getIndex2.equalsIgnoreCase(keyC)) {
									colInd[j] = k;
								}
							}
						}
					}
				}
			
				for (int i = 0; i < length; i++) {			
					//System.out.print(rowInd[i] + " , " + colInd[i] + " / ");
					decrypt += beaufort[0].charAt(colInd[i]);
				}
			}else {
				System.err.println("Not a valid key!");
				decrypt = "";
			}
			
			return decrypt;
		
		//}catch(Exception ex) {
		//	System.err.println("Decryption unsuccesful");
		//	return "Key Was insufficient";
		//}
	}
}
