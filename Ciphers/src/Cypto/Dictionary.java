package Cypto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {

	ArrayList<String> dict = new ArrayList<String>(); //in sorted order

	
	public int countSubWords(String ciphertext) {
		
		return getSubWords(ciphertext).size();
	}
	
	public ArrayList<String> getSubWords(String ciphertext){
		
		ArrayList<String> wordsFound = new ArrayList<String>();
		if(ciphertext.length() == 0) return wordsFound;
		
		ciphertext = ciphertext.toUpperCase();
		
		for(String word: dict){
			if(word.length() > 3 && ciphertext.contains(word)){
				wordsFound.add(word);
			}
		}
		System.out.println(wordsFound);
		return wordsFound;
	}
	
	public boolean isWord(String word){
//		System.out.println(Collections.binarySearch(dict, word.toUpperCase()));
		return Collections.binarySearch(dict, word.toUpperCase()) >= 0 ? true: false;
	}
	
	public Dictionary()
	{
		FileReader fin = null;
		BufferedReader buf = null;
		
		try {
			fin = new FileReader(new File("dictionary.txt"));
			buf = new BufferedReader(fin);
			String input = "";
			while((input = buf.readLine()) !=null){
//				System.out.println(input);
				dict.add(input.toUpperCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
				try {
					if(fin != null) fin.close();
					if(buf != null) buf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
	}
	
	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		System.out.println(d.isWord("been"));
		System.out.println(d.getSubWords("haHbeenwould"));
	}

}
