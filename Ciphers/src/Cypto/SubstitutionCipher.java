package Cypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubstitutionCipher {

	Map<Character, Integer> letterFreqMap;
	Map<Character, Character> key;
	String ciphertext;
	String plaintext;
	BufferedReader reader;
	

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
		ciphertext = ciphertext.toUpperCase();
		System.out.println("Ciphertext (in upper case) entered is '" + ciphertext + "'");
	}

	private void displayLetterFreq(){
		letterFreqMap = new LinkedHashMap<Character, Integer>();

		for(int i = 0; i < ciphertext.length(); i++){
			Character c = ciphertext.charAt(i);
			if (!(c >= 'A' && c <= 'Z')) continue;
			Integer count = letterFreqMap.get(c);
			if(count == null){
				letterFreqMap.put(c, 1);
			} else {
				letterFreqMap.put(c, count+1);
			}
		}
		System.out.println(letterFreqMap);
	}


	private void guessAKey() throws Exception {

		System.out.print("Guess a key for abcdefghijklmnopqrstuvwxyz: ");
		String putativeKey = "";

		try {
			putativeKey = reader.readLine();
//			System.out.println(putativeKey);
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Error while reading the putative key");
		} 

		createKeyMap(putativeKey);
	}

	private void getPlaintext() {
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
		plaintext = plaintextBuf.toString();
		System.out.println("Plaintext is: " + plaintext);
	}


	private void createKeyMap(String putativeKey) {
		if(putativeKey.length() < 26) {
			System.out.println("Key input is less than 26 characters. Invalid Key!");
			return;
		}
		key = new HashMap<Character, Character>();
		putativeKey = putativeKey.toUpperCase();

		for(int i=0; i <putativeKey.length(); i++){
			key.put(putativeKey.charAt(i), (char)(i+'A'));
		}
	}

	public void problem12() {
		try {
			createInputBuffer();
			getCipherText();
			displayLetterFreq();
			guessAKey();
			getPlaintext();
		} 
		catch (Exception e) {
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

	public static void main(String[] args) {

		SubstitutionCipher sc = new SubstitutionCipher();
		sc.problem12();
	}
}
