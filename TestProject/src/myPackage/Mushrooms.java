package myPackage;

public class Mushrooms {

	public int solution(int[] A, int k, int m)
	{
		boolean[] traverse = new boolean[A.length];
		return recursive(A,k,m+1, traverse);
	}

	public int recursive(int[] A, int k, int m, boolean[] traverse) {
		
		if(m==0) return 0;
		int mushrooms = 0;
		
		if(k>=0 && k<A.length && !traverse[k])
		{
			traverse[k] = true;
			mushrooms = A[k];
		}
		int left=0, right=0;
		if((k-1)>=0) left = recursive(A, k-1, m-1, traverse);
		if((k+1)<A.length) right = recursive(A, k+1, m-1, traverse);
		return (mushrooms+ Math.max(left, right));
	}

	public static void main(String[] args) {
		
		int[] A = {2,3,7,5,1,3,9};
		int k=4;
		int m=6;
		
		int output = new Mushrooms().solution(A, k, m);
		System.out.println(output);

	}

}
