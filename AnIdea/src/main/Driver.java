package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	static ArrayList<ListPair> alphaIndex = new ArrayList<ListPair>();

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}

	public static void initializeAlpha() {
		String s       = "\\u";
		String temp    = "";
		String product = "";
		String inter   = "";
		for (int i = 65; i <= 90; i++) {
			temp = s + temp + i;
			char c = (char) Integer.parseInt(temp.substring(2), 10);
			alphaIndex.add(new ListPair<String, Integer>("" + c, i - 65));
			product += c;
			temp = "";
		}
//		for (int i = 0; i < alphaIndex.size(); i++) {
//			System.out.println(alphaIndex.get(i));
//		}
	}

	public static String alphaOrder(String word) {
		String temp   = "";
		int[] indices = new int[word.length()];
		for (int i = 0; i < word.length(); i++) {
			temp = "" + word.charAt(i);
			for (int j = 0; j < alphaIndex.size(); j++) {
				if(temp.equalsIgnoreCase((String)alphaIndex.get(j).getLeft())) {
					indices[i] = (int) alphaIndex.get(j).getRight();
				}
			}
		}
		temp = "";
		quickSort(indices,0,indices.length - 1);
		for (int i = 0; i < indices.length; i++) {
			temp += alphaIndex.get(indices[i]).getLeft();
		}
		return temp;
	}

	private static int[] alphabatize(String word) {
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


//	public static String[][] wrapAround(String key) {
//		String temp = "";
//		while()
//		while(temp.length() < key.length()) {
//
//		}
//		return new String[0][0];
//	}

	private static String progress(int percentage) {
		String progress = "";
		int    perc     = percentage * 100;
		for(int i = 0; i < perc; i++) {
			progress += "/";
		}
		return progress;
	}

	private static String getMonth(int month) {
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

	public static void main(String[] args) throws FileNotFoundException {
//		initializeAlpha();
//		String test = "";
//		int[] my = alphabatize("wegotthefunk");
//		for(int i = 0; i < my.length; i++) {
//			test += "wegotthefunk".charAt(my[i]);
//			System.out.println(my[i]);
//		}
		//System.out.println("wegotthefunk".length());
		//EncryptADFGVX mines = new EncryptADFGVX("wegotthefunkdadadadada","helloworldiprogrammedthisinjava");
		//System.out.println(Polybius.polybiusGenerator("MEA"));
		//System.out.println("y109*:alc5jus{7hx!#`;@.,-63=[]~_o^ep4>+fz2(r$dk)in}q%<gtwb?8&m/v".length());
		//EncryptADFGX camp = new EncryptADFGX("fire up","rain again 8 o'clock");
		//System.out.println(Cipher.decryptADFGX(19, "fireup", "GGXXAFDGFAXXFFGXGGADDXXXXXXAAGGGDGGXFXDD"));
		//EncryptADFGX bob = new EncryptADFGX("helloworld","iprogrammedthisinjava");



		EncryptMEA hello = new EncryptMEA("hey", "my name is ian torres");
		EncryptMEA    remember   = new EncryptMEA("remember","stop it now");
		//System.out.println("hey1");


//		System.out.println(Cipher.decryptADFGVX("17/8/26", "helloworld", ""));
//		System.out.println(Cipher.decryptADFGX("17/8/26", "deputysheriff", ""));
		//System.out.println(Cipher.decryptADFGX(18, "helloworld", "GDGADXXDXDAGDDDDFFAXFDFXGXAXDGAXDDDFDXXFFD"));
		//System.out.println(Cipher.decryptADFGX(18,"fireup","XXDDFXAAFDXDAAXDXDFGGDGDGDDDDDDFXFDFFFAA"));
		//System.out.println(Cipher.decryptADFGVX("23/8/20","helo","ADXXAAVFXVFGAAAFGGADAFAFVDXFDVVVAF"));
		//System.out.println(Cipher.decryptADFGX(15,"fireup","GGAADFAXAFAAGGDFGGXFFAGFGXXFFGGADDGDADXX"));
		//System.out.println(Cipher.decryptADFGVX(16, "wegotfunk", "VFAFFDAVFFGDFFXAFXVFXFXXGAXVVXXVFDFFFGADVF"));
		//System.out.println(Cipher.decryptADFGVX(17,"wegotthefunk","VAXFXXVXXGFDGAFAVFDVGGVFVDVAFGAVGGGXFXAFGGGVVGVVAXXAGXVXFDFGDA"));
		//System.out.println(Cipher.decryptADFGVX(17,"wegotthefunkdadadadada","AFXXFAVFXXXGGDGAFGXGVAVVGVVAVVAGDFGVFGGVGVXFVADFXGGDDVAXAXXFGF"));
//		long start = System.currentTimeMillis();
		//System.out.println(Cipher.decryptBeaufort("xyui", "QUJXJCGRMVMTGKORXMIEUFNAFWMTQUDAKPUNXYBQPBGVTTMNT"));
		//System.out.println(Cipher.decryptADFGVX(1, "fire up", "VVAAXVAAXXXVXVVFFGAXXADAAVAFVAVGAAAFVFAAVDXFXDXVFVFVDVGV"));
		//System.out.println(Cipher.decryptADFGVX(2, "fire up", "GGXGFFXGFAAGGGGXDAXFFXVXXFXXGXFAXXGDVDXXGGAXVGAGXDDGGGXG"));

		//long end   = System.currentTimeMillis();
//		long total = end - start;
//		System.out.println("Time - > " + total);


//		String testString = "FXDFFVDFFFFXXGADDFDFDGVAXGVGDGFAFAFGFVXGADDFGVDGVAXGFADF";
//		String testKey    = "german";
//		int numOfRows     = testString.length()/testKey.length();
//		int lastRow       = testString.length() % testKey.length();
//		String[][] array;
//		if(lastRow != 0)
//			array  = new String[numOfRows + 1][];
//		else
//			array  = new String[numOfRows][];
//		for(int i = 0; i < array.length; i++) {
//			if(i < array.length - 1)
//				array[i] = new String[testKey.length()];
//			else
//				array[i] = new String[lastRow];
//		}
//		int count = 0;
//		for(int i = 0; i < array.length; i++) {
//			for(int j = 0; j < array[i].length; j++) {
//				array[i][j] = "" + testString.charAt(count);
//				count++;
//			}
//		}
//
//		for(int i = 0; i < array.length; i++) {
//			System.out.println(array[i].length);
//			for(int j = 0; j < array[i].length; j++) {
//				System.out.print(array[i][j]);
//			}
//			System.out.println();
//		}




//		String[][] ultimate = new String[3][];
//		String[] temp  = {"0","1","2","3","4","5"};
//		String[] temp2 = {"0","1","2","3","4"};
//		String[] temp3 = {"0","1","2","3"};
//
//		ultimate[0] = temp;
//		ultimate[1] = temp2;
//		ultimate[2] = temp3;
//
//		for(int i = 0; i < ultimate.length; i++) {
//			for(int j = 0; j < ultimate[i].length; j++) {
//				System.out.print(ultimate[i][j]);
//			}
//			System.out.println();
//		}

//		String[][] minen = {{"0","1"}};
//		String[][] mine  = {{"1","2"}};
//		ArrayList<String[][]> list = new ArrayList<String[][]>();
//		list.add(minen);
//		list.add(mine);
//		Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH");
//        System.out.println(sdf.format(cal.getTime()).toString());
//        for(int k = 0; k < list.size(); k++)
//        	for(int i = 0; i < list.get(k).length; i++) {
//        		for(int j = 0; j < list.get(k)[i].length; j++) {
//        			System.out.println(list.get(k)[i][j]);
//        		}
//        	}
//		int number = (int)(10 * Math.random());
//		System.out.println(number);

//		String poly    = "ph0qg64mea1yl2nofdxkr3cvs5zw7bj9uti8";
//		String[][] hey = new String[6][6];
//		int count = 0;
//		for(int i = 0; i < hey.length; i++) {
//			for(int j = 0; j < hey[0].length; j++) {
//				hey[i][j] = "" + poly.charAt(count);
//				count++;
//			}
//		}
//		String tit = "";
//		for(int i = poly.length()-1; i >= 0; i--) {
//			tit += poly.charAt(i);
//		}
//		System.out.println(tit);
//		for(int i = 0; i < hey.length; i++) {
//			for(int j = 0; j < hey[0].length; j++) {
//				System.out.print(hey[i][j]);
//
//			}
//			System.out.println();
//		}




		//long start = System.currentTimeMillis();
		//String message = Cipher.decryptADFGVX(2,"fireup", "GGXGFFXGFAAGGGGXDAXFFXVXXFXXGXFAXXGDVDXXGGAXVGAGXDDGGGXG");
		//long end   = System.currentTimeMillis();
		//String message2 = Cipher.decryptADFGVX(4, "fireup" , "GGXGFFXGFAAGGGGXDAXFFXVXXFXXGXFAXXGDVDXXGGAXVGAGXDDGGGXG");
		//String message3 = Cipher.decryptADFGVX(0, "fire up", "VVAAXVAAXXXVXVVFFGAXXADAAVAFVAVGAAAFVFAAVDXFXDXVFVFVDVGV");
		//String message3 = Cipher.decryptADFGVX(06, "fireup" , "DDFAGFGAGXXDXDDGGXAGGFFFFFDVDFFDDFAVXVAADVXGFVXDGDGDVGVG");
		//System.out.println(message);
		//System.out.println(message2);
		//System.out.println(message3);
		//System.out.println(end-start);
		//System.out.println(message3);

//		long start = System.nanoTime();
////		Polybius.polybiusGenerator("ADFGX");
//		long end   = System.nanoTime();
//		System.out.println(end - start);
//		Random randoms = new Random();
		//ArrayList<String> polybius = new ArrayList<String>();
		//String temp = "";
//
		//for(int i = 0; i < 9766; i++) {
		//	temp = Polybius.polybiusGenerator("ADFGX");
		//	if(polybius.contains(temp))
		//		temp = Polybius.polybiusGenerator("ADFGX");
		//	else
		//		polybius.add(temp);
		//}
//
		//try {
		//	String filename = "";
		//	File myfile = null;
		//	PrintWriter myPrinter = null;
		//	int iYear = 2015;
		//	int iMonth = Calendar.JANUARY;
		//	int iDay = 1;
			//System.out.println(iMonth);
		//	Calendar mycal = null;
////
//////			// Get the number of days in that month
			//int daysInMonth = 0;
			//int count = 0;
//			Calendar            cal         = Calendar.getInstance();
//			SimpleDateFormat    sdf         = new SimpleDateFormat("M d H y");
//			String              time        = sdf.format(cal.getTime()).toString();
//			String[]            date        = time.split(" ");
//			String              month       = getMonth(Integer.parseInt(date[0]) - 1);
//			int                 day         = Integer.parseInt(date[1]) - 1;
//			String currentDirectory = new File("").getAbsolutePath() + "\\src\\polybius\\" + month + "\\" + month + "-" + day + ".txt";
//			File myfile1 = new File(currentDirectory);
//			Scanner wiz = new Scanner(myfile1);
//			while(wiz.hasNextLine()) {
//				System.out.println(wiz.nextLine());
//			}
//			wiz.close();
			//for(;iMonth < 12; iMonth++){
			//	filename = getMonth(iMonth);
			//	mycal = new GregorianCalendar(iYear, iMonth, iDay);
			//	daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
			//	for(int i = 0; i < daysInMonth; i++) {
			//		myfile    = new File("C:\\Users\\Ian\\Desktop\\polybius_2\\"+filename+"\\",filename + "-" + i +  ".txt");
			//		myPrinter = new PrintWriter(myfile);
			//		for(int j = 0; j < 24; j++) {
			//			myPrinter.println(polybius.get(count));
			//			myPrinter.flush();
			//			count++;
						//myPrinter.println();
						//myPrinter.flush();
//
			//		}
			//	}
//
			//	myPrinter.close();
//
			//}





			//*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(
//			String currentDirectory = new File("").getAbsolutePath() + "\\src\\polybius\\August\\August-1.txt";
//			System.out.println(currentDirectory);
//			File heineken = new File(currentDirectory);
//			Scanner wiz = new Scanner(heineken);
//			while(wiz.hasNextLine()) {
//				System.out.println(wiz.nextLine());
//			}
			//*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(*(




		//}catch(FileNotFoundException ex) {
		//	ex.printStackTrace();
		//}
		// Create a calendar object and set year and month

		//System.out.println(daysInMonth);


//		for(int i = 0; i < polybius.size(); i++) {
//			System.out.println(polybius.get(i));
//		}
		//try {
//			PrintWriter myPrinter = new PrintWriter(myfile);
//			Scanner     wiz       = new Scanner(myfile);
//			for(int i = 0; i < 365; i++) {
//				myPrinter.print(Polybius.polybiusGenerator("ADFGVX"));
//				myPrinter.flush();
//				myPrinter.println();
//				myPrinter.flush();
//			}
//			myPrinter.close();
//			wiz.close();
		//} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}

		//polybius generator
//		String poly = "abcdefghijklmnopqrstuvwxyz";
//		String poly2 = "";
//		ArrayList<Integer> numbers = new ArrayList<Integer>();
//		Random randomGenerator = new Random();
//		while (numbers.size() < 25) {
//
//		    int random = randomGenerator .nextInt(25);
//		    if (!numbers.contains(random)) {
//		        numbers.add(random);
//		    }
//		}
////
////
//		for(int i = 0; i < numbers.size(); i++) {
//			poly2 += poly.charAt(numbers.get(i));
//		}
//		System.out.println(poly2);

		//System.out.println(mines.decodeMessage(19,"fireup", "AAVXFDFXFAAGAGGVFAXFFVGVVDXDAVDXXVXGGGXXGDAVFDAGVGFGDGDG"));


//		initializeAlpha();
//		System.out.println(alphaOrder("German"));


//		String minen = "Hello";
//		String sen[] = minen.split(" ");
//
//		System.out.println("Length - > " + sen.length);
//
//		for(int i = 0; i < sen.length - 1; i++) {
//			if(sen[i].equals("")) {
//				sen[i] = sen[i + 1].trim();
//			}
//		}
//
//		for(int i = 0; i < sen.length; i++) {
//			System.out.println(sen[i]);
//		}

//		ArrayList<ListPair>	alphaIndex	= new ArrayList<ListPair>();
//
//
//		String s = "\\u";
//		String temp = "";
//		String product = "";
//		String inter = "";
//		for (int i = 65; i <= 90; i++) {
//			temp = s + temp + i;
//			char c = (char) Integer.parseInt(temp.substring(2), 10);
//			alphaIndex.add(new ListPair<String, Integer>("" + c, i - 65));
//			product += c;
//			temp = "";
//		}
//
//		for (int j = 0; j < alphaIndex.size(); j++) {
//			System.out.println(alphaIndex.get(j));
//		}


//		String str = "I     am a JAVA programmer 1010";
//		String[] splited = str.split("\\b+"); //split on word boundries
//		Arrays.asList(splited).contains("ram"); //search array for word
//
//		for (int i = 0; i < splited.length; i++) {
//			System.out.println(splited[i]);
//		}


//		String key  = "key";
//		String rep  = "";
//		int length  = key.length();
//		int loopL   = length2 / length;
//		int i = 0;
//
//		for (i = 0; i < loopL; i++) {
//			rep += key.substring(0, length);
//		}
//		int number = rep.length();
//		rep += key.substring(0, length2 - number);
//		System.out.println(rep);
//		String temp    = "key";
//		String messRef = "";
//		int arrow      = 0;
//		message += " ";
//		int length     = message.length();
//		for(int i = 0; i < length; i++) {
//			boolean isSpace = ("" + message.charAt(i)).equals(" ");
//
//			if(isSpace){
//				messRef += message.substring(arrow, i);
//				arrow = i + 1;
//			}
//
//
//
//
//		}
//		System.out.println(length);
//		System.out.println(messRef);







//		String cipher[] = new String[25];
//		String s = "\\u";
//		String temp = "";
//		String product = "";
//		String inter = "";
//		for (int i = 65; i <= 90; i++) {
//			temp = s + temp + i;
//			char c = (char) Integer.parseInt(temp.substring(2), 10);
//			product += c;
//			// System.out.print(c);
//			temp = "";
//		}
//		System.out.println(product);
//		int length = product.length();
//		for (int k = 0; k < 25; k++) {
//			for (int i = k+1; i < length; i++) {
//				temp = "" + product.substring(0,k + 1);
//				inter = product.substring(1 + k, length) + temp;
//			}
//			cipher[k] = inter;
//			//System.out.println(inter);
//		}
//		for (int j = 0; j < cipher.length; j++) {
//			System.out.println(cipher[j]);
//		}
	}

}
