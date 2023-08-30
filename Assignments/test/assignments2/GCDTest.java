package assignments2;

import static org.junit.Assert.*;

import org.junit.Test;

public class GCDTest {

	@Test
	public void testGcd() {
		assertEquals(1,GCD.gcd(1, 6));
		assertEquals(10,GCD.gcd(10, 20));
		assertEquals(3,GCD.gcd(3, 6));
		assertEquals(12,GCD.gcd(36, 24));
	}

}
