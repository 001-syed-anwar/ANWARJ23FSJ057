package assignments1;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivisionTest {

	@Test
	public void testDivide() {
		assertEquals(2, Division.divide(4, 2),0);
		assertEquals(Double.POSITIVE_INFINITY, Division.divide(4, 0),0);
	}

}
