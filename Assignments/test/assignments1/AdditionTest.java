package assignments1;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdditionTest {

	@Test
	public void testAdd() {
		assertEquals(3, Addition.add(1, 2));
	}

	@Test
	public void testAdd2() {
		assertEquals(3, Addition.add(9, -6));
	}
	
	@Test
	public void testAdd3() {
		assertEquals(-3, Addition.add(-1, -2));
	}
	
	@Test
	public void testAdd4() {
		assertEquals(3, Addition.add(-9, 12));
	}
	
}
