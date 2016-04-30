package myPackage;

public class NestedParanthesis {

	public int solution(String A)
	{
		long sqResult = 0;
		long cirResult = 0;
		long curResult = 0;
		for(int i=0; i<A.length(); i++)
		{
			switch(A.charAt(i)) {
				case '(': cirResult++; break;
				case ')': cirResult--; break;
				case '{': curResult++; break;
				case '}': curResult--; break;
				case '[': sqResult++; break;
				case ']': sqResult--; break;
				default: break;
			}
		}
		
		long temp = cirResult + sqResult + curResult;
		return (temp==0)?0:1;
	}

	public static void main(String[] args) {
		
		String A = "{}(dkn(jen[))";
		
		int output = new NestedParanthesis().solution(A);
		System.out.println(output);

	}

}
