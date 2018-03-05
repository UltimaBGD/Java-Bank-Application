package test.btp400.w18a1;

import java.math.BigDecimal;

import org.finance.accounts.Chequing;

import junit.framework.TestCase;

public class ChequingTest extends TestCase {
	
	Chequing c1, c2, c3;
	public ChequingTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		c1 = new Chequing();
		c2 = new Chequing("Brett Dennis", "A1234", new BigDecimal("1000"), new BigDecimal("0.5"));
		c3 = new Chequing();
	}
	 /*
	  * tests the constructors of the Chequing class
	  * @author Brett Dennis
	  */
	public void testConstructor() {
		assertEquals("", c1.getFullName());
		assertEquals("Brett Dennis", c2.getFullName());
	}
	/*
	 * tests the withdrawal method of the Chequing class with negatives, nulls, and a valid value
	 * @author Brett Dennis
	 */
	public void testWithdrawal() {
		BigDecimal test = new BigDecimal("999");
		c2.withdraw(new BigDecimal("0.5"));
		assertTrue("Withdraw does not work", c2.getAccountBalance().compareTo(test) == 0);
		assertEquals(false, c2.withdraw(null));
		assertEquals(false, c2.withdraw(new BigDecimal("-1")));
	}
	/*
	 * tests the deposit method of the Chequing class with negatives, nulls, and a valid value
	 * @author Brett Dennis
	 */
	public void testDeposit() {
		assertEquals(false, c2.deposit(null));
		assertEquals(false, c2.deposit(new BigDecimal("-1")));
		BigDecimal test = new BigDecimal("1001");
		c2.deposit(new BigDecimal("1"));
		assertTrue("Deposit does not work", c2.getAccountBalance().compareTo(test) == 0);
	}
	/*
	 * tests the equals method of the chequing class with a true and a false comparison
	 * @author Brett Dennis
	 */
	public void testEquals() {
		assertEquals(true, c3.equals(c1));
		assertEquals(false, c2.equals(c1));
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
