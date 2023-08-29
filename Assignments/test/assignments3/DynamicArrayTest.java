package assignments3;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynamicArrayTest {

	@Test
	public void testSize() {
		// {10,10,0,15,4}
		assertEquals(5, initialiseArr().size());
	}

	@Test
	public void testGet() {
		// {10,10,0,15,4}
		assertEquals(10, initialiseArr().get(1));
		assertEquals(10, initialiseArr().get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet1() {
		// {10,10,0,15,4}
		initialiseArr().get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet2() {
		// {10,10,0,15,4}
		initialiseArr().get(5);
	}

	@Test
	public void testAdd() {
		DynamicArray arr = initialiseArr();
		arr.add(5);
		assertEquals("[10, 10, 0, 15, 4, 5]", arr.displayArray());
	}

	@Test
	public void testRemove() {
		// {10,10,0,15,4}
		DynamicArray arr = initialiseArr();
		arr.remove(4);
		assertEquals("[10, 10, 0, 15]", arr.displayArray());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove1() {
		// {10,10,0,15,4}
		initialiseArr().remove(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove2() {
		// {10,10,0,15,4}
		initialiseArr().remove(5);
	}

	@Test
	public void testGetFrequency() {
		// {10,10,0,15,4}
		assertEquals(2, initialiseArr().getFrequency(10));
	}

	@Test
	public void testGetSum() {
		// {10,10,0,15,4}
		assertEquals(39, initialiseArr().getSum());
	}

	@Test
	public void testGetAverage() {
		// {10,10,0,15,4}
		assertEquals(7, initialiseArr().getAverage(),0.8);
	}

	@Test
	public void testGetMinimum() {
		// {10,10,0,15,4}
		assertEquals(0, initialiseArr().getMinimum());
	}
	@Test(expected = IllegalAccessError.class)
	public void testGetMinimum1() {
		// {10,10,0,15,4}
		new DynamicArray().getMinimum();
	}

	@Test
	public void testGetMaximum() {
		// {10,10,0,15,4}
		assertEquals(15, initialiseArr().getMaximum());
	}

	@Test(expected = IllegalAccessError.class)
	public void testGetMaximum1() {
		// {10,10,0,15,4}
		new DynamicArray().getMaximum();
	}
	
	@Test
	public void testSet() {
		// {10,10,0,15,4}
		DynamicArray arr = initialiseArr();
		arr.set(5, 4);
		assertEquals("[10, 10, 0, 15, 5]", arr.displayArray());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSet1() {
		// {10,10,0,15,4}
		DynamicArray arr = initialiseArr();
		arr.set(5, -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSet2() {
		// {10,10,0,15,4}
		DynamicArray arr = initialiseArr();
		arr.set(5, 5);
	}
	
	@Test
	public void testFindInt() {
		// {10,10,0,15,4}
		assertEquals(0, initialiseArr().find(10));
	}

	@Test
	public void testFindIntInt() {
		// {10,10,0,15,4}
		assertEquals(1, initialiseArr().find(10, 1));
	}

	@Test
	public void testReverse() {
		// {10,10,0,15,4}
		DynamicArray arr = initialiseArr();
		arr.reverse();
		assertEquals("[4, 15, 0, 10, 10]", arr.displayArray());
	}

	@Test
	public void testDisplayArray() {
		// {10,10,0,15,4}
		assertEquals("[10, 10, 0, 15, 4]", initialiseArr().displayArray());
	}

	@Test
	public void testSort() {
		// {10,10,0,15,4}
		DynamicArray arr = initialiseArr();
		arr.sort();
		assertEquals("[0, 4, 10, 10, 15]", arr.displayArray());
	}

	@Test
	public void testToString() {
		// {10,10,0,15,4}
		DynamicArray arr = initialiseArr();
		assertEquals("[10, 10, 0, 15, 4]", arr.toString());
	}

	private DynamicArray initialiseArr() {
		DynamicArray arr = new DynamicArray();
		arr.add(10);
		arr.add(10);
		arr.add(0);
		arr.add(15);
		arr.add(4);
		return arr;
	}
}
