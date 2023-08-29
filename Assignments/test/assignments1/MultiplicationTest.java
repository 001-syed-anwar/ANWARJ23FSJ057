package assignments1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplicationTest {

	@Test
	public void testMultiply() {
		assertEquals(0, Multiplication.multiply(0, 0));
//		assertEquals(new java.lang.IllegalArgumentException(), Multiplication.multiply(2, Integer.MAX_VALUE));
	}

	@Test
	public void testMultiply2() {
		assertEquals(Integer.MAX_VALUE, Multiplication.multiply(1, Integer.MAX_VALUE));
	}

	@Test
	public void testMultiply3() {
		assertEquals(-6, Multiplication.multiply(2, -3));
	}

	@Test
	public void testMultiply4() {
		assertEquals(6, Multiplication.multiply(-2, -3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultiply5() {
		Multiplication.multiply(-2, Integer.MAX_VALUE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultiply6() {
		Multiplication.multiply(-2, Integer.MAX_VALUE);
	}
}
