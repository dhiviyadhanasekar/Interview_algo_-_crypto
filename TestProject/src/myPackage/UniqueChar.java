package myPackage;

import java.util.HashMap;

public class UniqueChar {

//	
//	No. 13 - First Character Appearing Only Once
//	Implement a function to find the first character in a string which only appears once. 
//	For example: It returns ‘b’ when the input is “abaccdeff”.
	
	Character getFirstUnique(char[] w)
	{
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		for(int i=0; i<w.length; i++)
		{
			Integer cnt = m.get(w[i]);
			if(cnt == null) m.put(w[i], 1);
			else m.put(w[i], cnt+1);
		}
		
		for(int i=0; i<w.length; i++)
		{
			if(m.get(w[i]) == 1) return w[i];
		}

		return null;
	}
	
	public Character solnNoMem(char[] w)
	{
		for(int i=0; i<w.length; i++)
		{
			int cnt = 0;
			for(int j=i; j<w.length; j++)
			{
				if(i!=j && w[i] == w[j]) {
					cnt =1; break;
				}
			}
			if(cnt==0) return w[i];
		}
		return null;
	}

	public static void main(String[] args) {
		
		UniqueChar o = new UniqueChar();
		String s = "aabbccdeffd";
		char c = o.getFirstUnique(s.toCharArray());
		System.out.println(c);
		
	}

}
