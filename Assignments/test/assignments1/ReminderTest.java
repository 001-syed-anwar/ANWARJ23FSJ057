package assignments1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReminderTest {

	@Test
	public void testModulo() {
		assertEquals(1, Reminder.modulo(3, 2));
	}

}
