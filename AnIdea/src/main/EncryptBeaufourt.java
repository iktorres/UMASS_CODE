package main;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class EncryptBeaufourt {

	// Variables
	// ______________________________________________________________________

	private String				beaufort[]	= new String[26];
	//private String              messArray[] = null;
	//private String[]            numInMess   = null;
	private String				message		= "hey you guys ill meet you at 6 oclock";
	private String				encrypted	= "";
	private String				key			= "hey";
	private ArrayList<ListPair>	alphaIndex	= new ArrayList<ListPair>();
	private int					indices[]	= null;

	// ______________________________________________________________________
	// Constructors
	//
	// ______________________________________________________________________

	public EncryptBeaufourt() {
		cipher_Initialize();
		setMessage(eliminateSpaces(message));
		setKeyEncryption(key_Initializer(eliminateSpaces(key)));
		System.out.println(this.encrypted);
		//System.out.println(getDecryptedMessage(getKey("bastard")));
	}

	public EncryptBeaufourt(String key, String message) {
		cipher_Initialize();
		setMessage(eliminateSpaces(message));
		setKeyEncryption(key_Initializer(eliminateSpaces(key)));
		System.out.println(getEncryptedMessage());
		//System.out.println(getDecryptedMessage(getKey("bastard")));
	}

	// ______________________________________________________________________
	// Getters & Setters
	//
	// ______________________________________________________________________

	private void setKeyEncryption(String key) {
		if(isWord(key)) {
			this.key = key_Initializer(key);
			this.indices = findRow();
			this.encrypted = encrypt();
		}else {
			System.err.println("This is not a valid key!\n");
		}
	}

	private String getKey(String password) {
		if(password.equals("hello"))
			return this.key;
		else
			return "No key for you!!!";
	}

	public String getEncryptedMessage() {
		if(this.encrypted.equals(""))
			return "No key was set";
		else
			return this.encrypted;
	}
	
	private String getDecryptedMessage(String key) {
		try {
			int length       = this.message.length();
			int alphaS       = this.alphaIndex.size();
			int beaufL       = this.beaufort.length;
			int rowInd[]     = new int[length];
			int colInd[]     = new int[length];
			String keyC      = "";
			String enC       = "";
			String decrypt   = "";
			String getIndex  = "";
			String getIndex2 = "";
		
			for (int j = 0; j < length; j++) {
				enC      = "" + this.encrypted.charAt(j);
				keyC     = "" + key.charAt(j);
				for (int i = 0; i < alphaS; i++) {
					getIndex = (String) alphaIndex.get(i).getLeft();
					if (enC.equalsIgnoreCase(getIndex)) {
						rowInd[j] = (int) alphaIndex.get(i).getRight();
						for(int k = 0; k < beaufL; k++) {
							getIndex2 = "" + this.beaufort[rowInd[j]].charAt(k);
							if (getIndex2.equalsIgnoreCase(keyC)) {
								colInd[j] = k;
							}
						}
					}
				}
			}
		
			for (int i = 0; i < length; i++) {			
				//System.out.print(rowInd[i] + " , " + colInd[i] + " / ");
				decrypt += this.beaufort[0].charAt(colInd[i]);
			}
			
			return decrypt;
		
		}catch(Exception ex) {
			System.err.println("The message could not be sent");
			return "Message Unable to Send";
		}
	}

	private void setMessage(String message) {
		String result = "";
		String   myChar;
		for (int i = 0; i < message.length(); i++) {
			myChar = "" + message.charAt(i);
			if(isLetter(myChar)) {
				if(isSymbol(myChar)) {
					result += "";
				}else {
					result += myChar;
				}
			}else {
				result += encodeNumber(Integer.parseInt(myChar));
			}
		}	
		this.message = result;
	}

	// ______________________________________________________________________
	// Methods
	//
	// ______________________________________________________________________
	
	private String encodeNumber(int number) {
		String result = "";
		switch(number) {
		
			case 0:
				result = "zero";
				break;	

			case 1:
				result = "one";
				break;	

			case 2:
				result = "two";
				break;

			case 3:
				result = "three";
				break;
	
			case 4:
				result = "four";
				break;
	
			case 5:
				result = "five";
				break;
	
			case 6:
				result = "six";
				break;
	
			case 7:
				result = "seven";
				break;
	
			case 8:
				result = "eight";
				break;
	
			case 9:
				result = "nine";
				break;
		
		}
		return result;
	}
	
	private boolean isLetter(String letter) {
		try {
			Integer.parseInt(letter);
			return false;
		}catch(NumberFormatException ex) {
			return true;
		}
	}
	
	private boolean isLetter(char letter) {
		try {
				Integer.parseInt("" + letter);
			return false;
		}catch(NumberFormatException ex) {
			return true;
		}
	}
	
	private boolean isWord(String key) {
		int count  = 0;
		int length = key.length();
		for (int i = 0; i < length; i++) {
			if(isLetter(key.charAt(i))) {
				count++;
			}
		}
		if (count == length)
			return true;
		else
			return false;
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
	
	private String encrypt() {
		int number = 0;
		int size   = alphaIndex.size();
		String encryptedMessage = "";
		for (int j = 0; j < this.message.length(); j++) {
			for (int i = 0; i < size; i++) {
				number = (int) alphaIndex.get(i).getRight();
				if (indices[j] == number) {
					encryptedMessage += (String) alphaIndex.get(i).getLeft();
					//System.out.println(alphaIndex.get(i).getLeft());
				}
			}
		}
		return encryptedMessage;
	}

	private int[] findColumn() {
		int length = this.message.length();
		int size = this.alphaIndex.size();
		int columnI[] = new int[length];
		String messC = "";

		for (int i = 0; i < length; i++) {
			messC = "" + this.message.charAt(i);
			for (int j = 0; j < size; j++) {
				if (messC.equalsIgnoreCase((String) alphaIndex.get(j).getLeft())) {
					columnI[i] = j;
					break;
				}
			}
		}
		return columnI;
	}

	private int[] findRow() {
		int column[] = findColumn();
		int messL = this.message.length();
		int length = this.beaufort.length;
		int row[] = new int[messL];
		String test = "";
		String testM = "";

		for (int i = 0; i < messL; i++) {
			test = "" + this.key.charAt(i);
			for (int j = 0; j < length; j++) {
				testM = "" + this.beaufort[j].charAt(column[i]);
				if (test.equalsIgnoreCase(testM)) {
					row[i] = j;
				}
			}
		}
		return row;
	}

	private String[] delimitSpaces(String message) {
		String[] local = message.split(" ");
		return local;
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

	private String key_Initializer(String key) {
		String rep = "";
		int length = key.length();
		int length2 = this.message.length();
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

	private void cipher_Initialize() {
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

	// ______________________________________________________________________
	//
	//
}
