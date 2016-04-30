package myPackage;


public class MatrixMove {

	boolean valid(int[][]m, int x, int y)
	{
		if(x < m.length && y< m[0].length && x >= 0 && y>= 0 ) return true;
		return false;
	}

	boolean move(int[][] m, int sx, int sy, int ex, int ey)
	{
		if(!valid(m,sx, sy) ||  !valid(m,ex, ey)) return false;
		if(m[sx][sy] == 1 || m[ex][ey]==1) return false;
		if(sx == ex && sy == ey) return true;
		
		m[sx][sy] = 1;
		
		return  move(m,sx-1,sy,ex,ey) || move(m,sx+1,sy,ex,ey) 
				|| move(m, sx, sy-1, ex,ey) || move(m,sx,sy+1, ex, ey);
	}
	
	public static void main(String[] args) {
		int[][] m = {{0,0,1,0,1}, {0,0,0,0,0}, {0,1,1,1,1}, {0,0,0,0,0}, {0,1,1,1,0}};
		int sx=1, sy =1, ex=4, ey=4;
		MatrixMove ob = new MatrixMove();
		System.out.println(ob.move(m, sx, sy, ex, ey));
		
	}

}
