package myPackage;

public class Solution {

	 public int solution(int[] A) {
		 
		 if(A.length < 1) return -1;    
	       int sum = 0;
			 for(int i=0; i<A.length; i++)
			 {
				 sum+=A[i];
			 }
			 
			 int p= Integer.MAX_VALUE;
			 int leftSum = 0, temp;
			 
			 for(int i=0; i<A.length-1; i++)
			 {
				 leftSum += A[i];
				 temp = Math.abs( (2*leftSum) - sum);
				 if(temp < p)
				 {
					 p = temp;
				 }
			 }
			 return p;
		 	
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = new Solution().solution(new int[]{-1,1});
		System.out.println(i);
	}

}
