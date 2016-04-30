package myPackage;

public class RocketFuelProblem {

	public RocketFuelProblem() {
		// TODO Auto-generated constructor stub
	}
	
	int rocketFuelProblem(int n)	{
		int row = n-1, col = 0;
		while(row>=0 && col<n) {
			if(row==col) col++;
			else if(gift(row,col)) row--;
			else col++;
		}
		return row;
	}
	
	 private boolean gift(int row, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	public int solution(int X, int Y, int D) {
	        // write your code in Java SE 8
	        
	        if(X>Y || D<1 || X<1 || Y<1 ) return -1;
	        if(X == Y) return 0;
	        
	        long difference = (Y-X);
	        long numJumps = difference/D;
	        if(difference%D != 0)
	        numJumps++;
	        
	        return (int) numJumps;
	    }
	

	public static void main(String[] args) {

		System.out.println(new RocketFuelProblem().solution(10,10,1));
	}

}