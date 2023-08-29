package assignments2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciSeriesTest {

	@Test
	public void testCalculateFibonacci() {
		assertEquals(0, FibonacciSeries.calculateFibonacci(0));
		assertEquals(1, FibonacciSeries.calculateFibonacci(1));
		assertEquals(1, FibonacciSeries.calculateFibonacci(2));
		assertEquals(2, FibonacciSeries.calculateFibonacci(3));
	}

	@Test
	public void testFibonacci() {
		assertEquals(0, FibonacciSeries.calculateFibonacci(0));
		assertEquals(1, FibonacciSeries.calculateFibonacci(1));
		assertEquals(1, FibonacciSeries.calculateFibonacci(2));
		assertEquals(2, FibonacciSeries.calculateFibonacci(3));
	}
	//IllegalArgumentException

	@Test(expected=IllegalArgumentException.class)
	public void testCalculateFibonacci1() {
		assertEquals(0, FibonacciSeries.calculateFibonacci(-1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFibonacci1() {
		assertEquals(1, FibonacciSeries.calculateFibonacci(-2));
	}
}
