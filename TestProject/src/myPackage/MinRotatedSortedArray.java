package myPackage;

public class MinRotatedSortedArray {

	
	public int returnMin(int[] a, int start,int end)
	{
		
		int mid = (start+end)/2;
		int minVal = a[mid];
		if((start-end) == 0) return a[mid]; 
		if(minVal > a[end])
		{
			return returnMin(a, mid+1, end);
		}
		else //if(minVal > a[start])
		{
			return returnMin(a, start, mid);
		}
//		return a[mid];
	}
	
	public static void main(String[] args) {

		int[] a = {4,3,2,8,7,6,5};
		int output = new MinRotatedSortedArray().returnMin(a, 0, 6);
		System.out.println(output);
		
	}

}
