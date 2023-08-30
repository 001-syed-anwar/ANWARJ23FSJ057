package assignments2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testFind() {
		int[] arr= {1,2,3,4,5};
		assertEquals(0,BinarySearch.find(arr, 1));
		assertEquals(1,BinarySearch.find(arr, 2));
		assertEquals(2,BinarySearch.find(arr, 3));
		assertEquals(3,BinarySearch.find(arr, 4));
		assertEquals(4,BinarySearch.find(arr, 5));
	}

}
