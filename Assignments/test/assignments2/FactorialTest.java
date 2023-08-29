package assignments2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testCalculateFactorial() {
		assertEquals(6, Factorial.factorial(3));
		assertEquals(2, Factorial.factorial(2));
	}

	@Test
	public void testFactorial() {
		assertEquals(6, Factorial.factorial(3));
		assertEquals(2, Factorial.factorial(2));
	}
	// IllegalArgumentException

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateFactorial1() {
		Factorial.factorial(-3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFactorial1() {
		Factorial.factorial(-2);
	}
}
