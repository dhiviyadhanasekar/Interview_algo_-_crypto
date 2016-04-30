package myPackage;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import org.junit.Test;

public class TestFileOperations {

	@Test
	public void readInputFile() {
		
		
	}

	@Test
	public void testarrays()
	{
		BitSet b= new BitSet(10);
		b = BitSet.valueOf(new long[]{Long.parseLong("01000011",2)});
		System.out.println(b.toString());
	}
}
