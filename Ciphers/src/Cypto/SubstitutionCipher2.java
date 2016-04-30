package Cypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstitutionCipher2 {

	BufferedReader reader;
	String ciphertext;
	String plaintext;
	String guessed;
	String cipherLetterFreq = "";
	Map<Character, Character> currentMapping;


	static String letterFreqOrder ="";

	public SubstitutionCipher2(){
		storeOneLetterCounts();
		//		reset();
	}

	void printEnglishLetterFrequency()
	{
		System.out.println("English letter frequency counts");	
		System.out.println("E - 1202 | T - 910 | A - 812 | O - 768 | I - 731");
		System.out.println("N - 695 | S - 628 | R - 602 | H - 592 | D - 432");
		System.out.println("L - 398 | U - 288 | C - 271 | M - 261 | F - 230 | Y - 211 | W - 209 | G - 203");
		System.out.println("B - 182 | P - 149 | V - 111 | K - 69 | X - 17 | Q - 11 | J - 10 | Z - 7");	
	}

	void storeOneLetterCounts() {
		StringBuffer temp = new StringBuffer();
		temp.append("E"); temp.append("T"); temp.append("A"); temp.append("O"); temp.append("I");
		temp.append("N"); temp.append("S"); temp.append("R"); temp.append("H"); temp.append("D");
		temp.append("L"); temp.append("U"); temp.append("C"); temp.append("M"); temp.append("F");
		temp.append("Y"); temp.append("W"); temp.append("G"); temp.append("");
		temp.append("B"); temp.append("P"); temp.append("V"); temp.append("K"); temp.append("X");
		temp.append("Q"); temp.append("J"); temp.append("Z");
		letterFreqOrder = temp.toString();
		//		System.out.println(letterFreqOrder.length());
	}

	private void reset(){
		currentMapping = new LinkedHashMap<Character, Character>();
		for(int i = 'A'; i <= 'Z'; i++){
			currentMapping.put((char)i, '-');
		}
		plaintext = ciphertext;
		StringBuffer temp = new StringBuffer();
		for(int i=0; i< ciphertext.length(); i++){
			temp.append("-");
		}
		guessed = temp.toString();
	}

	private void createInputBuffer(){
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	private void closeInputBufer() throws Exception{
		if(reader!=null)
			try {
				reader.close();
			} catch (IOException e) {

				e.printStackTrace();
				throw new Exception("Error while trying to close the input stream");
			}
	}

	private void getCipherText() throws Exception {
		System.out.println("***** Substitution Cipher Cracker *****");
		System.out.print("Enter ciphertext: ");

		reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			ciphertext = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Error while reading the ciphertext");
		}

//				ciphertext = "MXDXBVTZWVMXNSPBQXLIMSCCSGXSCJXBOVQXCJZMOJZCVC"
//						+ "TVWJCZAAXZBCSSCJXBQCJZCOJZCNSPOXBXSBTVWJC"
//						+ "JZDXGXXMOZQMSCSCJXBOVQXCJZMOJZCNSPJZHGXXMOSPLH"
//						+ "JZDXZAAXZBXHCSCJXTCSGXSCJXBOVQX";

		//		ciphertext = "LTKHNMEVKGKECVHVRTMHECCVKNBKNCVHWXTFMCXHAGFRKNKCENXCEXQHCVKNBYXPFHRTNKNEZVXXFOPCKLYXPVRIHNCFHRTNHMCVHQHRNKNBXLLTKHNMEVKGYXPTHRFFYVRIHNCFHRTNHMRNYCVKNBQPVRQQRMRFK";
		ciphertext = ciphertext.toUpperCase();
		reset();
		System.out.println("Ciphertext (in upper case) entered is '" + ciphertext + "'");
	}

	private void getCurrentOneLetterCounts(){
		printEnglishLetterFrequency();
		getnLetterCounts(1);
	}

	private boolean isCapLetter(char c){
		return (c >= 'A' && c <= 'Z');
	}


	public void problem13() {
		try {
			createInputBuffer();
			getCipherText();
			computeLetterFreq();
			provideOptions();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				closeInputBufer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void provideOptions() {
		int input = 0;
		do {
			System.out.println("**** Possible Operations: ****");
			System.out.println("1. Print monogram frequencies");
			System.out.println("2. Try auto solve");
			System.out.println("3. Map letters & replace");
			System.out.println("4. Guess a key");
			System.out.println("5. See current mappings");
			System.out.println("6. Reset to beginning");
			System.out.println("7. Print possible shift cipher plaintexts");
			System.out.println("8. Exit");
			System.out.println("9. Print trigram frequencies");
			System.out.println("10. Print bigram frequencies");
			System.out.println("11. Print quad letter frequencies");
			System.out.println("12. Print 5 gram frequencies");
			System.out.println("13. Print n gram frequencies ");
			System.out.println("14. Show what's been guessed so far");
			System.out.println("*********************************");
			System.out.println("Choose an operation by providing the number for it:");
			try {
				String temp = reader.readLine();
				if(temp.length() == 0) continue;
				input = Integer.valueOf(temp);
				if(input!= 8) processInput(input);
				else break;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Invalid input. Print enter to continue");
			}
		} while(input != 8);
		System.out.println("Exiting Program");
	}

	private void processInput(int input) throws Exception {

		switch(input) {
		case 1:  getCurrentOneLetterCounts(); break;
		case 2: autoSolve(); break;
		case 3: mapLetter(); break;
		case 4: guessAKey(); break;
		case 6: reset(); break;
		case 5: System.out.println(currentMapping); break;
		case 7: AlphaShift as = new AlphaShift();
		as.possibleDecryptions(plaintext.toLowerCase());
		break;
		case 9: getCurrentThreeLetterCounts(); break;
		case 10: getCurrentTwoLetterCounts(); break;
		case 11: getQaudFreq(); break;
		case 12: getFiveGramFreq(); break;
		case 13: getnGramFreq(); break;
		case 14: showGuessed(); break;

		default: System.out.println("Invalid Input. Try again!"); break;
		}

	}

	private void showGuessed() {

		System.out.println("What's been guessed so far: " + guessed);
		System.out.println("Partially decoded text: " + plaintext);
		System.out.println(currentMapping);
	}

	private void getnGramFreq() {

		System.out.println("Enter n: ");
		try {
			String temp = reader.readLine();
			int n = Integer.valueOf(temp);
			getnLetterCounts(n);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid input!!!! ");
		}

	}

	private void getFiveGramFreq() {

		System.out.println("English Five gram frequencies:");
		System.out.println("OFTHE :  0.18        ANDTH :  0.07        CTION :  0.05"
				+"ATION :  0.17        NDTHE :  0.07        WHICH :  0.05"
				+"INTHE :  0.16        ONTHE :  0.07        THESE :  0.05"
				+"THERE :  0.09        EDTHE :  0.06        AFTER :  0.05"
				+"INGTH :  0.09        THEIR :  0.06        EOFTH :  0.05"
				+"TOTHE :  0.08        TIONA :  0.06        ABOUT :  0.04"
				+"NGTHE :  0.08        ORTHE :  0.06        ERTHE :  0.04"
				+"OTHER :  0.07        FORTH :  0.06        IONAL :  0.04"
				+"ATTHE :  0.07        INGTO :  0.06        FIRST :  0.04"
				+"TIONS :  0.07        THECO :  0.05        WOULD :  0.04");
		getnLetterCounts(5);
	}

	private void autoSolve() {

		char[] reverseKey = initializeAutoKey();
		Dictionary dict = new Dictionary();
		String in;
		do {
			String decodedText = decode(reverseKey);
			System.out.println(decodedText + " =>  ");
			int score = dict.countSubWords(decodedText);

			score = autoUpdateKey(reverseKey, dict, score);

			System.out.println("Repeat using the above key?(0 for no, 1 for yes)");
			in ="";
			try {
				in = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while("1".equals(in));
	}

	private int autoUpdateKey(char[] reverseKey, Dictionary dict, int score) {
		boolean swap;
		do 
		{
			swap = false;
			for(int i=0; i<reverseKey.length-1; i++) {
				//			for(int i=0; i<reverseKey.length; i++) {
				System.out.println("i=" + i);
				char cur = (char) (i+'A');
				if(currentMapping.get(cur) != '-') continue;

				int j=i+1;
				//				for(int j=0; j<reverseKey.length; j++)
				{
					//					if(j==i) continue;

					cur = (char) (j+'A');
					if(currentMapping.get(cur) != '-') continue;

					swap(reverseKey, i, j);
					System.out.println(Arrays.toString(reverseKey));

					String newDecodedtext = decode(reverseKey);
					System.out.println(newDecodedtext + " =>  ");
					int newScore = dict.countSubWords(newDecodedtext);

					if(newScore > score) {
						swap = true;
						score = newScore; 
					}
					else swap(reverseKey, i, j);
				}
			}
		}while (swap ==  true);

		char[] key = printKey(reverseKey);

		System.out.println("Putative Key that maps ciphertext letters to plaintext = " + Arrays.toString(key));
		System.out.println("Decoded Text = " + decode(reverseKey));
		System.out.println("Cipher text =  " + ciphertext);
		return score;
	}

	private char[] printKey(char[] reverseKey) {
		char[] key = new char[26];
		for(int i=0; i<reverseKey.length; i++){
			int index = reverseKey[i] - 'A';
			key[index] = (char) ('A'+i);
			//			System.out.print("i=" + i + ", " + reverseKey[i] + " - " + key[index] + ", ");
		}
		//		System.out.println();
		return key;
	}


	private void swap(char[] reverseKey, int i, int j) {

		char temp = reverseKey[i];
		reverseKey[i] = reverseKey[j];
		reverseKey[j] = temp;	
	}

	private String decode(char[] reverseKey) {

		String temp = ciphertext;
		for(int i =0; i< reverseKey.length;  i++){
			char charToReplace = (char) (i+'A');
			char replacewith  = reverseKey[i];

			temp =  temp.replace(charToReplace , Character.toLowerCase(replacewith) );
			//			System.out.println("Replace " + charToReplace + " with " + replacewith + " = " + temp);
		}
		return temp;
	}

	private char[] initializeAutoKey() {

		char[] reverseKey = new char[26];
		Arrays.fill(reverseKey, '-');
		HashMap<Character, Boolean> added = new HashMap<Character, Boolean>();
		int i=0;
		for(int j=0; i < letterFreqOrder.length() && j < cipherLetterFreq.length();j++) {

			char curCipherLetter = cipherLetterFreq.charAt(j);
			int pos = curCipherLetter - 'A';
			//			System.out.println(curCipherLetter);
			if(currentMapping.get(curCipherLetter) != '-' && !added.containsKey(currentMapping.get(curCipherLetter))){
				reverseKey[pos] = currentMapping.get(curCipherLetter);

			} else {
				while(added.containsKey(letterFreqOrder.charAt(i)) && i < letterFreqOrder.length()) i++;
				if(i< letterFreqOrder.length()) reverseKey[pos] = letterFreqOrder.charAt(i++);
			}

			added.put(reverseKey[pos], true);
			//			System.out.println("currentCipherchar = " + curCipherLetter 
			//					+ ", Pos = " + pos + ", plainchar = " + reverseKey[pos]);
		}


		for(int j=0; j < reverseKey.length; j++){
			if(reverseKey[j] == '-'){
				while(added.containsKey(letterFreqOrder.charAt(i)) && i < letterFreqOrder.length()) i++;
				if(i< letterFreqOrder.length()) reverseKey[j] = letterFreqOrder.charAt(i++);
			}
		}

		printKey(reverseKey);
		System.out.println(Arrays.toString(reverseKey));
		return reverseKey;
	}

	private void getCurrentTwoLetterCounts() {

		System.out.println("English Bigram frequencies");
		System.out.println("TH :  2.71        EN :  1.13        NG :  0.89"
				+" HE :  2.33        AT :  1.12        AL :  0.88"
				+"IN :  2.03        ED :  1.08        IT :  0.88"
				+"ER :  1.78        ND :  1.07        AS :  0.87"
				+"AN :  1.61        TO :  1.07        IS :  0.86"
				+"RE :  1.41        OR :  1.06        HA :  0.83"
				+"ES :  1.32        EA :  1.00        ET :  0.76"
				+"ON :  1.32        TI :  0.99        SE :  0.73"
				+"ST :  1.25        AR :  0.98        OU :  0.72"
				+"NT :  1.17        TE :  0.98        OF :  0.71");

		getnLetterCounts(2);

	}

	private Map<String, Integer> getnLetterCounts(int n) {
		HashMap<String, Integer> mapCounts = new HashMap<String, Integer>();
		for(int i=0; i < plaintext.length(); i++){
			if((i+n-1) >= plaintext.length()) break;
			String s = plaintext.substring(i, i+n);
			Integer cnt = mapCounts.get(s);
			if(cnt == null) mapCounts.put(s, 1);
			else mapCounts.put(s, cnt+1);
		}
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Integer> sortedMapCount = sortByValue(mapCounts);
		System.out.println(sortedMapCount);
		return sortedMapCount;
	}

	private void computeLetterFreq(){

		Map<String, Integer> temp = getnLetterCounts(1);
		for (String s : temp.keySet()) {
			cipherLetterFreq += s;
		}
		//		System.out.println(cipherLetterFreq.length());
	}
	private void guessAKey() throws Exception {

		System.out.print("Guess a key for abcdefghijklmnopqrstuvwxyz: ");
		String putativeKey = "";

		try {
			putativeKey = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Error while reading the putative key");
		} 

		createKeyMap(putativeKey);
	}

	private void getPlaintext(Map<Character, Character> key) {
		StringBuffer plaintextBuf = new StringBuffer();
		for(int i = 0; i < ciphertext.length(); i++) {
			Character c = key.get(ciphertext.charAt(i));
			if(c == null) {
				System.out.println("Error: Character " + ciphertext.charAt(i)
						+ " in ciphertext is not mapped to any alphabet");
				plaintextBuf.append(ciphertext.charAt(i));
			}
			else plaintextBuf.append(c);
		}
		System.out.println("Putative Plaintext is: " + plaintextBuf.toString());
		System.out.println("Note: Mapping not updated");
	}

	private void createKeyMap(String putativeKey) {
		Map<Character, Character> key = new HashMap<Character, Character>();
		if(putativeKey.length() < 26) {
			System.out.println("Key input is less than 26 characters. Invalid Key!");
			return;
		}
		putativeKey = putativeKey.toUpperCase();

		for(int i=0; i <putativeKey.length(); i++){
			key.put(putativeKey.charAt(i), (char)(i+'A'));
		}
		getPlaintext(key);
	}

	private void getQaudFreq(){
		System.out.println("English quad frequencies");
		System.out.println("TION :  0.31        OTHE :  0.16        THEM :  0.12 "
				+"NTHE :  0.27        TTHE :  0.16        RTHE :  0.12 "
				+"THER :  0.24        DTHE :  0.15        THEP :  0.11 "
				+"THAT :  0.21        INGT :  0.15        FROM :  0.10 "
				+"OFTH :  0.19        ETHE :  0.15        THIS :  0.10 "
				+"FTHE :  0.19        SAND :  0.14        TING :  0.10 "
				+"THES :  0.18        STHE :  0.14        THEI :  0.10 "
				+"WITH :  0.18        HERE :  0.13        NGTH :  0.10 "
				+"INTH :  0.17        THEC :  0.13        IONS :  0.10 "
				+"ATIO :  0.17        MENT :  0.12        ANDT :  0.10 ");
		getnLetterCounts(4);
	}
	private void mapLetter() throws IOException{

		System.out.println("Enter CipherLetter-Plainletter pair (like ax bt xz): ");
		String input = reader.readLine();
		if(input.length() < 2) {
			System.out.println("No character pairs entered");
			return;
		}
		input = input.toUpperCase();
		for(int i = 0 ; i < input.length(); i++){

			if(input.charAt(i) == ' ') continue;
			char c = input.charAt(i++);
			if(!isCapLetter(c)){
				System.out.println("Invalid character entered for cipherletter");
				return;
			}

			if(i >= input.length()){
				System.out.println("No character entered for cipherLetter:" + c
						+ ". No changes made");
			}
			char p = input.charAt(i);
			if(!isCapLetter(p)){
				System.out.println("Invalid character entered for cipherletter");
				return;
			}

			currentMapping.put(c, p);
		}

		guessed =  ciphertext;
		plaintext = ciphertext;
		for(int i='A'; i <= 'Z'; i++){
			char c = currentMapping.get((char)i);
			guessed = guessed.replace((char)i, Character.toLowerCase(c));
			if(c != '-') plaintext = plaintext.replace((char)i, Character.toLowerCase(c));
		}

		showGuessed();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static LinkedHashMap sortByValue(Map unsortMap) {	 
		List list = new LinkedList(unsortMap.entrySet());

		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
			}
		});

		LinkedHashMap sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	private void getCurrentThreeLetterCounts(){
		printTrigramFreq();
		getnLetterCounts(3);
	}

	private void printTrigramFreq() {

		System.out.println("English Trigram counts:");
		System.out.println("THE: 1.81   ERE:  0.31        HES :  0.24"
				+ "AND :  0.73        TIO :  0.31        VER :  0.24"
				+ "ING :  0.72        TER :  0.30        HIS :  0.24"
				+ "ENT :  0.42        EST :  0.28        OFT :  0.22"
				+ "ION :  0.42        ERS :  0.28        ITH :  0.21"
				+ "HER :  0.36        ATI :  0.26        FTH :  0.21"
				+ "FOR :  0.34        HAT :  0.26        STH :  0.21"
				+ "THA :  0.33        ATE :  0.25        OTH :  0.21"
				+ "NTH :  0.33        ALL :  0.25        RES :  0.21"
				+ "INT :  0.32        ETH :  0.24        ONT :  0.20"
				+ "");
		System.out.println("******************");

	}

	public static void main(String[] args) {

		SubstitutionCipher2 sc = new SubstitutionCipher2();
		sc.problem13();

	}

}
