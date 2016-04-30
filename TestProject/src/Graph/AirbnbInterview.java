//package Graph;
//
//public class AirbnbInterview {
//
//	import java.io.*;
//	import java.util.*;
//
//	/*
//	 * To execute Java, please define "static void main" on a class
//	 * named Solution.
//	 *
//	 * If you need more classes, simply define them inline.
//	 */
//
//	 
//
//
//	private boolean valid(int x, int y, char[][] map){
//	  if(x < map.length && x>=0 && y < map[x].length && y >=0) return true;
//	  return false;
//	}
//
//	void changeToOcean(char[][] map, int x, int y){
//	    
//	    if(!valid(x,y, map)) return;
//	    if(map[x][y] != 'O') return;
//	     Queue<Coord> q = new Queue<Coord>();
//	     Coord c = new Coord(x, y);
//	      q.enqueue(c);
//
//	    while(!q.isEmpty()){
//	      
//	      c = q.deque(); 
//	       if(!valid(c.x,c.y) || map[c.x][c.y] != 'W') continue;
//	        map[c.x][c.y] = 'O';
//	        q.enqueue(new Coord(c.x-1, c.y));
//	         q.enqueue(new Coord(c.x+1, c.y));
//	         q.enqueue(new Coord(c.x, c.y-1));
//	         q.enqueue(new Coord(c.x, c.y+1));
//	    }
//	    
//	}
//	  
//	  public static void main(String[] args) {
//	    Solution s = new Solution();
//	    //s.changetoOcean()
//	  
//	  }
//	}
//
//	// LLLLLLLLLLLLLLLLLLLL
//	// LLLLLLLLLLLLLLWLLLLL
//	// LLWWLLLLLLLLLLLLLLLL
//	// LLWWLLLLLLLLLLLLLLLL
//	// LLLLLLLLLLLLLLLLLLLL
//	// LLLLLLLWWLLLLLLLLLLL
//	// LLLLLLLLWWLLLLLLLLLL
//	// LLLLLLLLLWWWLLLLLLLL
//	// LLLLLLLLLLWWWWWWLLLL
//	// LLLLLLLLLLWWWWWWLLLL
//	// LLLLLLLLLLWWWWWWLLLL
//	// LLLLWWLLLLWWWWWWLLLL
//	// LLLLWWWLLLWWWWWWWWWW
//	// LLLLLWWWWWWWWWWWLLLL
//	// LLLLLLLLLLLLLLWWWWLL
//	// LLLLLLLLLLLLLLWLLLLL
//	// LLLLWLLLLLLLLLLLLWLL
//	// LLLLLLLLLLLLLLLLLLWL
//
//	//N*N
//
//	//O(N*M)
//
//	// row = 10
//	// col = 12
//
//	// O = ocean
//	// L = land
//	// W = water
//
//
//	// OUTPUT
//
//	// LLLLLLLLLLLLLLLLLLLL
//	// LLLLLLLLLLLLLLWLLLLL
//	// LLWWLLLLLLLLLLLLLLLL
//	// LLWWLLLLLLLLLLLLLLLL
//	// LLLLLLLLLLLLLLLLLLLL
//	// LLLLLLLWLLLLLLLLLLLL
//	// LLLLLLLLOOLLLLLLLLLL
//	// LLLLLLLLLOOOLLLLLLLL
//	// LLLLLLLLLLOOOOOOLLLL
//	// LLLLLLLLLLOOOOOOLLLL
//	// LLLLLLLLLLOOOOOOLLLL
//	// LLLLOOLLLLOOOOOOLLLL
//	// LLLLOOOLLLOOOOOOOOOO
//	// LLLLLOOOOOOOOOOOLLLL
//	// LLLLLLLLLLLLLLOOOOLL
//	// LLLLLLLLLLLLLLOLLLLL
//	// LLLLWLLLLLLLLLLLLWLL
//	// LLLLLLLLLLLLLLLLLLWL
//
