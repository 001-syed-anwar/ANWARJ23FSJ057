package assignments2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void testIsPalindrome() {
		assertEquals(true,Palindrome.isPalindrome("madam"));
		assertEquals(false,Palindrome.isPalindrome("sir"));
		assertEquals(false,Palindrome.isPalindrome("anwar"));
		assertEquals(true,Palindrome.isPalindrome("anwarrawna"));
	}

}
