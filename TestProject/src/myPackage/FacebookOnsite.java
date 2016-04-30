package myPackage;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class FacebookOnsite {

	
	BigInteger perm(BigInteger big)
	{
		BigInteger cnt = BigInteger.ZERO;
		if(big.equals(BigInteger.ZERO)) return cnt;
		BigInteger modTen = big.mod(BigInteger.TEN);
		BigInteger divTen = big.divide(BigInteger.TEN);

		if(modTen.intValue() > 0 && divTen.equals(BigInteger.ZERO)  )
		{
			return valid(modTen)? BigInteger.ONE: BigInteger.ZERO; 
		}

		BigInteger mod100 = big.mod(bigInt(100));
		BigInteger div100 = big.divide(bigInt(100));

		if(mod100.intValue() > 0 && div100.equals(bigInt(0)))
		{
			if(valid(big)) cnt  = cnt.add(bigInt(1));
			if(valid(modTen) && valid(divTen)) cnt = cnt.add(bigInt(1));
						
			return cnt;
		}

		if(valid(modTen)) cnt = cnt.add(perm(divTen));
		if(valid(mod100)) cnt = cnt.add(perm(div100));
		return cnt;
	}

	private BigInteger bigInt(int smallVal)
	{
		return BigInteger.valueOf(smallVal);
	}

	private boolean valid(BigInteger big) {

		if(big.compareTo(bigInt(0)) == 1 && big.compareTo(bigInt(27)) == -1)
			return true;
		return false;
	}

	public static void main(String[] args)
	{
		FacebookOnsite obj = new FacebookOnsite();
		BigInteger input = BigInteger.valueOf(1234);

		BigInteger output = obj.perm(input);
		System.out.println(output);
//		obj.testMapKeys();
	}
}
