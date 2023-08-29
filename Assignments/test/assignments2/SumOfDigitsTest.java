package assignments2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfDigitsTest {

	@Test
	public void testSumOfDigits() {
		assertEquals(0,SumOfDigits.sumOfDigits(0));
		assertEquals(10,SumOfDigits.sumOfDigits(12340));
		assertEquals(3,SumOfDigits.sumOfDigits(3));
	}

}
