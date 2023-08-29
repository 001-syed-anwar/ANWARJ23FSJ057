package assignments1;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testFactorial() {
		
		assertEquals(new BigInteger("1"), Factorial.factorial((byte)0));
		assertEquals(new BigInteger("2"), Factorial.factorial((byte)2));
		assertEquals(new BigInteger("6"), Factorial.factorial((byte)3));
//		assertEquals(new IllegalArgumentException(), Factorial.factorial((byte)-2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFactorial1() {
		Factorial.factorial((byte)-2);
	}

}
