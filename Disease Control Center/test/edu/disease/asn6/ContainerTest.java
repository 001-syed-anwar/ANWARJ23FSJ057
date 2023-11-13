package edu.disease.asn6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContainerTest {
	private Container<Integer> c;

	@Test(expected = IllegalArgumentException.class)
	public void testContainer() {
		c = new Container<>();
	}

	@Test
	public void testGet() {
		c = new Container<>(1, 2);
		int result1 = c.get(0);
		assertEquals(result1, 1);
		int result2 = c.get(1);
		assertEquals(result2, 2);
	}
	
	@Test
	public void testSize() {
		c = new Container<>(1, 2);
		assertEquals(c.size(), 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetException1() {
		c = new Container<>(1, 2);
		int result1 = c.get(0);
		assertEquals(result1, 1);
		int result2 = c.get(1);
		assertEquals(result2, 2);
		c.get(-1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetException2() {
		c = new Container<>(1, 2);
		int result1 = c.get(0);
		assertEquals(result1, 1);
		int result2 = c.get(1);
		assertEquals(result2, 2);
		c.get(3);
	}
	

}
