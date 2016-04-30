package myPackage;

import java.util.regex.Pattern;

public class GoogleCodility1 {

//	Given: a string s, with the character - in it. An int k
//	dashes have been inserted at the wrong places to generate an incorrect string s.
//	you need to correct the string such that a dash will be inserted after every k characters
//	 and make the string uppercase
//	complexity O(n)
	String solution(String a, int k)
	{
		StringBuffer res = new StringBuffer();
		int i, counter=0;
		for(i=0; i<a.length(); i++)
		{
			if(a.charAt(i) != '-') 
			{
				counter++;
				if((counter%k) == 1 && res.length() >0) 
					{
						res.append("-");
						counter = 1;
					}
				res.append(Character.toUpperCase(a.charAt(i)));
			}
		}
		return res.toString();
	}
	public static void main(String[] args) {

		String a ="-adefe-efwe";
		String output = new GoogleCodility1().solution(a, 4);
		System.out.println(output);
		
	}

}
