package myPackage;


public class PermMissingElement {

	public PermMissingElement() {
		// TODO Auto-generated constructor stub
	}


	public int solution(int[] A) {
		if(A == null) return -1;

		int[] hashMap = new int[(A.length+1)];

		for(int i=0; i<A.length; i++)
		{
			if(A[i] > 0 && A[i] <= A.length)
				hashMap[(A[i]-1)] = 1;
		}

		for(int i =0; i<hashMap.length; i++)
		{
			if(hashMap[i] == 0)
			{
				return (i+1);
			}
		}

		return -1;	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[100000];
		for(int a=1; a<100000; a++)
		{
			arr[a-1] = a;
		}
			
		System.out.println(new PermMissingElement().solution(arr));

	}



}
