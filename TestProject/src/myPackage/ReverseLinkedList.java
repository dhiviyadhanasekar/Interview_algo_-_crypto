package myPackage;



class ReverseLinkedList {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int sum =0, N = A.length;
        
        for(int i=0; i<N; i++)
        {
        	sum+=A[i];
        }
        System.out.println("sum:" + sum);
        
        if(sum == 0) return (N-1);
        
        int newSum =0;
        for(int i=0; i<N; i++)
        {
        	newSum += A[i];
        	System.out.println((sum-newSum) + ":" +newSum);
        	System.out.println("Sum  ai" + i + ":"  );
        	if((sum-newSum) == newSum)
        	{
        		return (i);
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {

		int i = solution(new int[]{1,-1});
		
		System.out.println(i);
	}

}
