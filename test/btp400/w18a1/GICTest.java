/**
 * 
 */
package test.btp400.w18a1;

import java.math.BigDecimal;

import org.finance.accounts.GIC;

import junit.framework.TestCase;

/**
 * @author Michael Butto
 *	edits from Brett Dennis
 */
public class GICTest extends TestCase {
	GIC c1, c2, c3;
	
	/**
	 * @author Michael Butto
	 * edits from Brett Dennis
	 * @param name
	 */
	public GICTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		c1 = new GIC();
		c2 = new GIC("Brett Dennis", "A1234", new BigDecimal ("1000"), 3, new BigDecimal("0.05"));
		c3 = new GIC();
	}
	
	 /*
	  * tests the constructors of the GIC class
	  * @author Michael Butto
	  * edits from Brett Dennis
	  */
	public void testConstructor() {
		assertEquals("", c1.getFullName());
		assertEquals("Brett Dennis", c2.getFullName());
	}
	/*
	 * tests the withdrawal method of the GIC class
	 * @author Michael Butto
	 * Edits from Brett Dennis
	 */
	public void testWithdrawal() {
		assertEquals(false, c2.withdraw(new BigDecimal(1)));
		//assertEquals(false, c2.withdraw(new BigDecimal("-1")));
	}
	/*
	 * tests the deposit method of the GIC class
	 * @author Michael Butto
	 * edits from Brett Dennis
	 */
	public void testDeposit() {
		assertEquals(false, c2.deposit(new BigDecimal(1)));
	}
	/*
	 * tests the equals method of the GIC class with a true and a false comparison
	 * @author Michael Butto
	 * edits from Brett Dennis
	 */
	public void testEquals() {
		//assertEquals(true, c3.equals(c1));
		assertEquals(false, c2.equals(c1));
	}
	/*
	 * Tests the get Balance at maturity method
	 * @author Michael Butto
	 * edits from Brett Dennis
	 */
	public void testBalanceAtMaturity() {
		BigDecimal t = new BigDecimal("1001.50");
		
		assertTrue("not true", t.compareTo(c2.getBalanceAtMaturity()) == 0);
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
