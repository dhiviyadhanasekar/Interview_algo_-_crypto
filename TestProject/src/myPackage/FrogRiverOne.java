package myPackage;

import java.util.Arrays;

public class FrogRiverOne {

	public int solution(int X, int[] A) {
        
		 int cantCross = -1;
	        if(X==0) return cantCross;
	        int len = A.length;
			
			int[] timeAtPos = new int[X];
			int[] timeAtposX = new int[len]; 
			Arrays.fill(timeAtPos, -1);
			int j=0, biggest = Integer.MIN_VALUE;
			
			for(int i=0; i<len; i++)
			{
				if(A[i]>=0 && A[i]<X && timeAtPos[A[i]] == -1)
				{
					timeAtPos[A[i]] = i;
				}
				if(X == A[i])
				{
					timeAtposX[j++] = i;
				}
			}
			
			for(int i=1; i<X; i++)
			{
				if(timeAtPos[i] == cantCross) return cantCross;
				if(biggest < timeAtPos[i])
					biggest = timeAtPos[i];
			}
			
			System.out.println(Arrays.toString(timeAtposX));
			for(int k=0; k<j; k++)
			{
				
				if(biggest < timeAtposX[k])
					return timeAtposX[k];
			}
			return cantCross;
}
	
	 public int frog(int X, int[] A) {
	        int steps = X;
	        boolean[] bitmap = new boolean[steps+1];
	        for(int i = 0; i < A.length; i++){
	            if(!bitmap[A[i]]){
	                bitmap[A[i]] = true;
	                steps--;
	            }
	            if(steps == 0) return i;
	        }
	        return -1;
	    }
	 
	public static void main(String[] args) {
		
		int[] A = {1,3,1,1,2,3,5,4,5};
		
		int output =  new FrogRiverOne().frog(5, A);
		System.out.print(output);
	}
}

//int[] dist = new int[X+1];
//List<Integer> posX = new ArrayList<Integer>();
//Arrays.fill(dist, -1);
//
//for(int i=0; i<A.length; i++)
//{
//	if(A[i] == X)
//	{
//		posX.add(i);
//	}
//	else if(A[i]>0 && A[i]<=X && dist[A[i]]==-1)
//	{
//		dist[A[i]] = i;
//	}
//}

//System.out.println("dist=" + Arrays.toString(dist));
//System.out.println("posX=" + posX);
//
//int biggest = Integer.MIN_VALUE;
//for(int i=1; i<X; i++)
//{
//	if(biggest < dist[i]) biggest =dist[i]; 
//}
//
//for(int i : posX)
//{
//	if(i >= biggest)
//	{
//		return i;
//	}
//}
//	
//return -1;