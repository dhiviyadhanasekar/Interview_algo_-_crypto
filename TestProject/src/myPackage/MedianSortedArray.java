package myPackage;

import java.util.Arrays;

public class MedianSortedArray {

	
	public int getMedian1(int a1[], int a2[])
	{
		String a;
		if(a1.length == 2 || a2.length == 2)
		{
			int num1 = Math.max(a1[0], a2[0]);
			int num2 =  Math.min(a1[1], a2[1]);
			return (num1+num2)/2;
		}
		
		int m1 = a1[a1.length/2];
//		int m2 = a
//		
//		int b1[] = Arrays.copyOfRange(a1, , arg2);
//		return getMedian()
		return 0;
	}
	
	public static void main(String[] args) {

		int ar1[] = {1, 12, 15, 26, 38};
		int ar2[] = {2, 13, 17, 30, 45};
	}

}
