package myPackage;

public class FizzBuzz {

	public void printFizzBuzz(){
		
		String temp;
		for(int i=1; i< 100; i++)
		{
			temp = "";
			if(i%3 == 0) temp = "Fizz";
			if(i%5 == 0) temp += "Buzz";
			if(temp.length() == 0) temp = i + ""; 
			
			System.out.println(temp);
		}
		
	}
	public static void main(String[] args) {

		FizzBuzz fb = new FizzBuzz();
		fb.printFizzBuzz();
	}

}
