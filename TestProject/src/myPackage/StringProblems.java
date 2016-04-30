package myPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StringProblems {

	//	Implement an algorithm to determine if a string has all unique characters. What
	//	if you cannot use additional data structures?

	public boolean uniqueString2(String s)
	{
		if(s.length() > 256) return false;

		int checker=0, val;
		for(int i =0;i<s.length();i++)
		{
			val = s.charAt(i) - 'a';
			if((checker & (1<<val)) > 0) return false;
			checker |= (1<<val);
		}
		return true;
	}

	public boolean uniqueString1(String s)
	{
		HashMap<Character,Boolean> map = new HashMap<Character, Boolean>();
		for(int i=0; i<s.length(); i++)
		{
			if(map.get(s.charAt(i))== null)
			{
				map.put(s.charAt(i), true);
			}
			else return false;
		}
		return true;
	}

	public String reverseString(String s)
	{
		char[] stack = new char[s.length()];
		int i = 0;
		for(i=0; i<s.length(); i++)
		{
			stack[i] = s.charAt(i);
		}

		StringBuffer reverse = new StringBuffer();
		for(i=s.length()-1; i>=0; i--)
		{
			reverse.append(stack[i]);
		}
		return reverse.toString();
	}

	public boolean subset(String s1, String s2)
	{
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		int i;
		Integer mapVal;
		for(i=0; i<s1.length(); i++)
		{
			mapVal = map1.get(s1.charAt(i));
			if(mapVal == null) map1.put(s1.charAt(i), 1);
			else map1.put(s1.charAt(i), mapVal+1);
		}
		for(i=0; i<s2.length(); i++)
		{
			mapVal = map2.get(s2.charAt(i));
			if(mapVal == null) map2.put(s2.charAt(i), 1);
			else map2.put(s2.charAt(i), mapVal+1);
		}

		boolean ret1 = true;
		for(Character c: map1.keySet())
		{
			System.out.println();
			System.out.print(c + " ");
			mapVal = map2.get(c);
			if(mapVal == null){ ret1 = false; break;}
			else if(mapVal < map1.get(c)) {ret1 = false; break;}
			System.out.print( ret1);
		}

		boolean ret2 = true;
		for(Character c: map2.keySet())
		{
			System.out.println();
			System.out.print(c + " ");
			mapVal = map1.get(c);
			if(mapVal == null) {ret2 =  false;break;}
			else if(mapVal < map2.get(c)) {ret2 = false;break;}
			System.out.print( ret2);
		}

		System.out.println();
		System.out.println( ret1 + "||" + ret2 );
		return (ret1||ret2);
	}

	private String replaceSpaces1(char[] s)
	{
		int count=0, i;
		int oldlen = s.length;

		for(i=0; i< oldlen; i++)
		{
			if(s[i] == ' ') count++;
		}


		int newlen = oldlen + count*2;
		s =  Arrays.copyOf(s, newlen);
		int pos = newlen-1;

		for(i= oldlen-1; i>= 0; i--)
		{
			if(s[i]==' ')
			{
				s[pos--] = '0';
				s[pos--] = '2';
				s[pos--] = '%';
			}
			else s[pos--] = s[i];
		}
		return Arrays.toString(s);
	}

	private Collection<String> generateRandomStrings(int numberOfStrings)
	{
		Random r = new Random();
		int range = 26, len;
		Character alphabet;
		StringBuffer word;

		List<String> wordList = new ArrayList<String>();
		for(int i=0; i< numberOfStrings; i++)
		{
			len = r.nextInt(5) +1;
			word = new StringBuffer();
			for(int j=0; j<len; j++)
			{
				alphabet = (char) ('a' + r.nextInt(range));
				word.append(alphabet);
			}
			wordList.add(word.toString());
		}
		return wordList;
	}

	private boolean returnTrueOrFalse()
	{
		Random r = new Random();
		int number = r.nextInt(100);
		boolean retValue = true;
		if(number < 10) retValue = false;
		System.out.println(retValue);
		return retValue;
	}

	private List<String> removeIfTest()
	{

		List<String> wordList = (List<String>) generateRandomStrings(10);
		System.out.println(wordList);
		int i=0;
		for(String word: wordList)
		{
			word += i; 
			wordList.set(i++, word);
		}

		wordList.removeIf(p -> returnTrueOrFalse());
		return wordList;
	}

	private String replaceSpaces(char[] s)
	{
		StringBuffer res = new StringBuffer();
		for(int i=0; i<s.length; i++)
		{
			if(s[i] == ' ')  res.append("%20");
			else res.append(s[i]);
		}

		return res.toString();
	}


	private String compress(String s)
	{
		if(s.length()==0) return s;

		StringBuffer temp = new StringBuffer();
		Character lastChar = null;
		char currentChar = s.charAt(0);
		int count =1;
		for(int i=1; i<s.length(); i++)
		{
			if(s.charAt(i)==currentChar)
			{
				count++;
			}
			else 
			{
				temp.append(currentChar);
				temp.append(count);
				lastChar = currentChar;
				count = 1;
				currentChar = s.charAt(i);
			}
			System.out.println(temp.toString());
		}
		if(lastChar != currentChar) 
		{
			temp.append(currentChar);
			temp.append(count);
		}
		System.out.println(temp.toString());

		if(temp.length() < s.length())  return temp.toString();
		return s;
	}


	private HashMap<Character, Integer> convertStringToMap(String s)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		Integer mapValue;
		Character c;
		for(int i=0; i<s.length(); i++)
		{
			c = s.charAt(i);
			mapValue = map.get(c);
			if(mapValue == null) map.put(c, 1);
			else map.put(c, mapValue+1);
		}
		return map;
	}

	//	private boolean mapsEqual()
	private boolean permutation(String string1, String string2) {

		if(string1.length() != string2.length()) return false;

		HashMap<Character, Integer> map1 = convertStringToMap(string1);
		HashMap<Character, Integer>	map2 = convertStringToMap(string2);

		return map1.equals(map2);
	}

	public int lengthOfLongestSubstring(String s) {

		int len=0; 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {

			if(map.containsKey(s.charAt(i)))
			{
				if(map.size() > len) len = map.size();
				int pos = map.get(s.charAt(i));
				map.entrySet().removeIf(p->p.getValue() < pos);
			} 
			map.put(s.charAt(i),i);   
		}
		if(map.size() > len) len = map.size();
		return len;
	}
	
	public boolean isRotation(String s1, String s2){
		if(s1.length() != s2.length() || s2.length() == 0) return false;
		return isSubString(s1 + s1, s2);
	}
	
	private boolean isSubString(String string, String s2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		StringProblems obj = new StringProblems();
//		System.out.println(obj.removeIfTest());
		String s; 
		System.out.println(obj.lengthOfLongestSubstring("abcbad"));
	}

}