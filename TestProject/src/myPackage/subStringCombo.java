package myPackage;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class subStringCombo {

	Set<String> found = new HashSet<String>();


	void getListCount(String w1, String w2)
	{
		if(w1.length() > w2.length()) return;
		if(w1.length() == 0 || w2.length()==0) return;
		check(w1, 0, w2, 0, -1);
		for(String s: found)
		{
			System.out.println(s);
		}
	}

	int check(String w1, int s1, String w2, int s2, int matchStart) 
	{
		if(s1>=w1.length()) return s2;
		if(s2>=w2.length()) return -1;

		char let = w1.charAt(s1);
		boolean charFound = false;
		int val = 0;

		for(int i=s2; i<w2.length(); i++)
		{
			if(w2.charAt(i) == let)
			{
				charFound = true;
				if(matchStart == -1) matchStart = i;
				if(s1==w1.length()-1) found.add(w2.substring(matchStart, i+1));
				else
				{
					val = check(w1, s1+1, w2, i+1, matchStart);
					if(val == -1) return -1;
				}
			}
			if(matchStart == i) matchStart = -1;
		}

		if(charFound == false) return -1;
		return val;
	}

	public static void main(String[] args) {

		String w1 ="abc", w2 = "abcdcefc";
		subStringCombo obj = new subStringCombo();
		obj.getListCount(w1, w2);
	}

}
