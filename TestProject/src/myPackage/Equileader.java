package myPackage;

import java.util.Arrays;
import java.util.HashMap;

public class Equileader {

    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	//count number of each element
    	HashMap<Integer,Integer> counter = new HashMap<Integer, Integer>();
    	Integer temp = 0;
    	for(int i=0; i<A.length; i++)
    	{
    		temp  = counter.get(A[i]);
    		if(temp == null) counter.put(A[i], 1);
    		else counter.put(A[i], temp+1);
    	}
		return temp;
    	
//    	Arrays.binarySearch(a, key)
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
