package assignments2;

import java.util.ArrayList;

import org.junit.Test;

public class PermutationTest {

	@Test
	public void testGeneratePermutation() {
		ArrayList<ArrayList<Character>> expected = new ArrayList<>();
		ArrayList<Character> perm1 = new ArrayList<>();
		perm1.add('1');
		perm1.add('1');
		perm1.add('2');
		ArrayList<Character> perm2 = new ArrayList<>();
		perm2.add('1');
		perm2.add('2');
		perm2.add('1');
		ArrayList<Character> perm3 = new ArrayList<>();
		perm3.add('2');
		perm3.add('1');
		perm3.add('1');
		expected.add(perm1);
		expected.add(perm2);
		expected.add(perm3);
//		assertEquals(expected, Permutation.generatePermutation(new char[] { '1', '1', '2' }));
	}

}
