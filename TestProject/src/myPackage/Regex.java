package myPackage;

public class Regex {

	boolean match(String r, String in)
	{
		int j= 0;
		for(int i= 0; i< r.length(); i++)
		{
			if(j >= in.length()) return false;
			if(r.charAt(i) != '.' && r.charAt(i) != '+' 
					&& r.charAt(i) != '*' 
					&& r.charAt(i) != '?')
			{
				int k = i+1;
				if((k< r.length() && r.charAt(k) != '.' 
						&& r.charAt(k) != '+' 
						&& r.charAt(k) != '*' 
						&& r.charAt(k) != '?') 
						|| k == r.length())
				{
					if(j< in.length() 
						&& in.charAt(j)==r.charAt(i)) 
						j++;
					else return false;
					i--;
				}
				else if(r.charAt(k) == '*') 
					while(j< in.length() 
							&& r.charAt(i) == in.charAt(j))
					{j++;}
				else if(r.charAt(k) == '?') 
					if(r.charAt(i) == in.charAt(j)) 
					{j++;}
				else if(r.charAt(k) == '+') 
					if(r.charAt(i) == in.charAt(j)) 
					{j++;} 
					else return false;
				else if(r.charAt(k) == '.') {
						if(r.charAt(i) == in.charAt(j)) 
						{j++;} 
						else return false;
						while(j< in.length() 
							&& (r.charAt(i) == in.charAt(j)))
						{j++;}
					}
				i++;
			}
			else {
				int k = i;
				if(r.charAt(k) == '*') 
					while(j< in.length())
					{j++;}
				else if(r.charAt(k) == '?') 
						if(j< in.length()) 
							j++;
				else if(r.charAt(k) == '+') 
				{
					if(j< in.length()) j++; 
					else return false;
				}
				else if(r.charAt(k) == '.') 
				{
					if(j< in.length()) j++; 
					else return false;
					while(j< in.length()){j++;}
				}
			}
		}
		if(j< in.length()) return false;
		return true;
	}


	public static void main(String[] args) {

		Regex ob = new Regex();
		System.out.println(ob.match("aab*d*c*a*b*aa*", "aabbbcbbbaa"));
	}

}
