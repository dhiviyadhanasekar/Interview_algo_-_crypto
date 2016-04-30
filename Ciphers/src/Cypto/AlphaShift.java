package Cypto;

import java.util.ArrayList;
import java.util.HashMap;

public class AlphaShift {

	char[] alphabets = new char[26];
	ArrayList<HashMap<Character, Character>> mapList 
	= new ArrayList<HashMap <Character, Character> >();
	
	public AlphaShift(){
		initAlphabet();
		storePermutations();
	}

	public void initAlphabet() {
		for(int i = 0; i < 26; i++){
			alphabets[i] = (char)('A' + i); 
		}
//		System.out.println(alphabets);
	}


	public void storePermutations()
	{
		int increment = 1;
		while(increment<= 25){
			HashMap<Character, Character> map =  new HashMap<Character, Character>();
			for(int i=0; i< alphabets.length; i++)
			{
				int newAlpha = (alphabets[i] - alphabets[0] + increment)%alphabets.length;
				map.put(alphabets[i], (char) alphabets[newAlpha]);
			}
//			System.out.println(map);
			mapList.add(map);
			increment++;
		}
	}

	public void possibleDecryptions(String input)
	{
		for(int i=0; i < mapList.size(); i++) {
			System.out.print(i + "= ");
			for(int j = 0; j < input.length(); j++) {
				System.out.print(mapList.get(i).get(input.charAt(j)));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		AlphaShift ob =  new AlphaShift();
//		ob.initAlphabet();
//		ob.storePermutations();
//		ob.possibleDecryptions("MXDXBVTZWVMXNSPBQXLIMSCCSGXSC");
		ob.possibleDecryptions("VSRQJHEREVTXDUHSDQWV");	
	}
}
