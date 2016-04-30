package myPackage;

import java.util.ArrayList;

public class InterviewPractice {

	public static void main(String[] args) {

		ArrayList<String> strArr = new ArrayList<String>();
		strArr.add("test");
		strArr.set(0, "a");
		System.out.println(strArr);
		
		StringBuffer s = new StringBuffer();
		s.append('c');
		
		System.out.println("ab".compareTo("ba"));
		
	}

}
