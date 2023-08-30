package assignments1;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareRootTest {

	@Test
	public void testSquareRoot() {
		assertEquals(2,SquareRoot.squareRoot(4),0);
		assertEquals(1,SquareRoot.squareRoot(2),4);
	}

	//IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void testSquareRoot1() {
		assertEquals(2,SquareRoot.squareRoot(-4),0);
	}
}
