package myPackage;

public class GoogleCodility2 {

	class Tree {
		public int x;
		public Tree l;
		public Tree r;
	}

	private int count(Tree t)
	{
		if(t== null) return 0;
		int l =1;
		l+=count(t.l);
		l+=count(t.r);
		return l;
	}

	private boolean inorder(Tree t, int A, int B)
	{
		if(t!= null && t.x>=A && t.x<=B) 
		{
			return(inorder(t.l, A,B) && inorder(t.r, A, B));
			
		}
		else return false;
		
	}

	public int solution(int A, int B, Tree T) {
		// write your code in Java SE 8
		if(T == null) return 0;
		if( inorder(T, A, B)) return count(T);
		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
