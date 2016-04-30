import java.util.ArrayList;


public class NumLetter {

	String[] letters = new String[10];
	
	void prepopulate(){
		letters[0] = "";
		letters[1] = "";
		letters[2] = "ABC";
		letters[3] = "DEF";
		letters[4] = "GHI";
		letters[5] = "JKL";
		letters[6] = "MNO";
		letters[7] = "PQRS";
		letters[8] = "TUV";
		letters[9] = "WXYZ";	
	}
	
	private void findPermutations(int n) {

		int digitCnt = 0, temp = n;
		while(temp != 0){
			temp/=10;
			digitCnt++;
		}
		if(digitCnt == 0) return;
		
		int maxDigits = digitCnt;
		
		ArrayList<String> result = new ArrayList<String>();
		String chars = letters[(int) (n/Math.pow(10, digitCnt-1))];
		n = (int) (n % Math.pow(10, digitCnt-1));digitCnt--;
		for(int j = 0; j< chars.length(); j++){
			result.add(chars.charAt(j) + "");
		}
		
		for(int i=1; i< maxDigits; i++)
		{
			chars = letters[(int) (n/Math.pow(10, digitCnt-1))];
			ArrayList<String> tempRes = new ArrayList<String>();
			for(int j = 0; j< chars.length(); j++)
			{
				for(int k = 0; k< result.size(); k++)
				{
					tempRes.add(result.get(k) + chars.charAt(j));
				}
			}
			result = tempRes;
			n = (int) (n % Math.pow(10, digitCnt-1));digitCnt--;
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		NumLetter ob = new NumLetter();
		ob.prepopulate();
		ob.findPermutations(5465);
	}
}
