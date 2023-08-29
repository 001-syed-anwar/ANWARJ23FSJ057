package assignments1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubtractionTest {

	@Test
	public void testSubtract() {
		assertEquals(0, Subtraction.subtract(10, 10));
	}

	@Test
	public void testSubtract2() {
		assertEquals(-5, Subtraction.subtract(10, 15));
	}
	@Test
	public void testSubtract3() {
		assertEquals(0, Subtraction.subtract(-10, -10));
	}
}
