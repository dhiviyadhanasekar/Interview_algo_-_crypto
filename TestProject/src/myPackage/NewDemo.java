package myPackage;


public class NewDemo {

	public int solution(int[] A) {
        // write your code in Java SE 8
		int n=A.length;
		
		boolean[] elemExists = new boolean[n];
		boolean[] nowSeen = new boolean[n];
		int distinct = 0;
			
		for(int i=0; i<n; i++)
		{
			if(A[i]>=0 && A[i]<n)
			{
				if(elemExists[A[i]] == false) 
					{
						distinct++;
						elemExists[A[i]] = true;
					}
			}
		}
		
		for(int i=0; i<n; i++)
		{
			if(A[i]>=0 && A[i]<n)
			if(elemExists[A[i]] && nowSeen[A[i]]==false)
			{
				nowSeen[A[i]] = true;
				distinct--;
				if(distinct==0) return i;
			}
		}
		
		return (n-1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {2,2,1,0,1};
		int output= new NewDemo().solution(A);
		System.out.println(output);

	}

}
