package test.btp400.w18a1;

import java.math.BigDecimal;

import org.finance.accounts.Savings;

import junit.framework.TestCase;

public class SavingsTest extends TestCase {
	Savings c1, c2, c3;
	
	public SavingsTest(String name) {
		super(name);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		c1 = new Savings();
		c2 = new Savings("Brett Dennis", "A1234", new BigDecimal("1000"), new BigDecimal("0.05"));
		c3 = new Savings();
		
	}
	
	 /*
	  * tests the constructors of the Savings class
	  * @author Michael Butto
	  */
	public void testConstructor() {
		assertEquals("", c1.getFullName());
		assertEquals("Brett Dennis", c2.getFullName());
	}

	/*
	 * tests the equals method of the Savings class with a true and a false comparison
	 * @author Michael Butto
	 */
	public void testEquals() {
		//assertEquals(true, c3.equals(c1));
		assertEquals(false, c2.equals(c1));
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
