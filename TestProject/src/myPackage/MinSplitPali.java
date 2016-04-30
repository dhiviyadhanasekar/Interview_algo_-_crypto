package myPackage;

import java.util.HashSet;
import java.util.Set;

public class MinSplitPali {

	//	No. 43 - Minimal Number of Splits on a String
	//	A string can be partitioned into some substrings, such that each substring is a palindrome. For example, there are a few strategies to split the string “abbab” into palindrome substrings, such as: “abba”|”b”, “a”|”b”|”bab” and “a”|”bb”|”a”|”b”. 
	//
	//	Given a string str, please get the minimal numbers of splits to partition it into palindromes. The minimal number of splits to partition the string “abbab” into a set of palindromes is 1.
	//
	Integer min=Integer.MAX_VALUE;

	boolean pali(String s)
	{
		if(s.length() == 0) return false;
		if(s.length() == 1) return true;;
		for(int i=0; i<s.length()/2; i++)
		{
			if( !(s.charAt(i) == s.charAt(s.length()-1-i)) ) return false;
		}
		return true;
	}

	Set<String> splits = new HashSet<String>();
	Integer getMinSplit(String s, String original)
	{
		System.out.println(s);
		if(s.length() ==0) return 0;
		if(s.length() == 1) return 0;
		if(pali(s)) return 0;

		StringBuffer temp = new StringBuffer();
		int val=0, tempVal =Integer.MAX_VALUE;
		for(int j=0; j<s.length(); j++)
		{
			val =0;
			temp.append(s.charAt(j));
			val = getMinSplit(s.substring(j+1, s.length()), original);
			if(pali(temp.toString())) val+=1;
			else val+= temp.length()-1;
			System.out.println(s + "-" + temp.toString() + ":" + val );
			if(original == s && val < min)
			{
				min = Integer.valueOf(val);
			}
			else if(tempVal > val)
			{
				tempVal = val;
			}
		}
		return tempVal;
	}


	int getMin(String s)
	{
		return getMinSplit(s, s);
	}
	
//	int dynamic(String s)
//	{
//		if(s.length() == 0) return 0;
//		if(pali(s)) return 0;
//		int val = Integer.MAX_VALUE;
//		for(int k=2; k<s.length(); k++)
//		{
//			int part1 = dynamic(s.substring(0,k+1));
//			int part2 = dynamic(s.substring(k+1,s.length()));
//			int min = Math.min(part1,part2);
//			if(min < val)
//				val = min;
//		}
//		return val;
//	}
	
	public static void main(String[] args) {

		String s = "aabcaa";
		MinSplitPali o = new MinSplitPali();
//		System.out.println(o.dynamic(s));
//		String input = "aab";
//				System.out.println(
//		o.getMin(input)
//						);
	}

}
