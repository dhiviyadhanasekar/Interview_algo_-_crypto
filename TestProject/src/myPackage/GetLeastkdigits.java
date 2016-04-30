package myPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//Please get the least number after deleting k digits from the input number. For example, if the input number is 24635, the least number is 23 after deleting 3 digits.
public class GetLeastkdigits {

	int getLeast(int num, int k)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(num == 0) {
			a.add(0); 
			map.put(0, 0);
		}
		int index=0;
		while(num >0)
		{
			a.add(num%10);
			map.put(num%10, index++);
			num/=10;
		}

		int retainCnt = a.size() - k;
		if(retainCnt <= 0) return -1;
		
		ArrayList<Integer> copy = new ArrayList<Integer>(a);
		Collections.sort(a);
		
		int[] pos = new int[retainCnt];
		for(int i= 0; i< retainCnt; i++)
		{
			pos[i] = map.get(a.get(i));
		}
		Arrays.sort(pos);

		StringBuffer s = new StringBuffer();
		for(int i=retainCnt-1; i>=0; i--)
		{
			s.append(copy.get(pos[i]));
		}
		
		return Integer.valueOf(s.toString());
	}
	
	public static void main(String[] args) {
		GetLeastkdigits ob = new GetLeastkdigits();
		System.out.println(ob.getLeast(24635, 3));
	}

}
