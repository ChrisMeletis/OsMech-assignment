package paradoxprograming.org;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdminTest {

	@Test
	public void testAdmin() {
	
		MainSystem tester = new MainSystem();
		assertEquals("{administrator}",tester.askDB("SELECT property FROM employees WHERE username = 'admin' and password = 'admin';",2,"property","","","","",""));
	}

}
