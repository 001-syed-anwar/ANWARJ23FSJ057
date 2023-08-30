package assignments1;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class PowerTest {

	@Test
	public void testPowerIntInt() {
		assertEquals(1, Power.power(1,0));
		assertEquals(4,  Power.power(2,2));
	}
	//InverseException

	@Test
	public void testPowerBigIntegerInt() {
		assertEquals(new BigInteger("1"),  Power.power(new BigInteger("1"),0));
		assertEquals(new BigInteger("4"),  Power.power(new BigInteger("2"),2));
	}
	
	@Test(expected = InverseException.class)
	public void testPowerIntInt1() {
		assertEquals(1, Power.power(1,-1));
	}
	
	@Test(expected = InverseException.class)
	public void testPowerBigIntegerInt1() {
		assertEquals(new BigInteger("1"),  Power.power(new BigInteger("1"),-4));
	}

}
