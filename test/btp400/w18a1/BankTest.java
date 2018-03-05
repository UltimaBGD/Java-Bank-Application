package test.btp400.w18a1;

import java.math.BigDecimal;
import java.util.Arrays;

import org.finance.accounts.Account;
import org.finance.accounts.Savings;

import com.little.bank.Bank;

import junit.framework.TestCase;

public class BankTest extends TestCase {
	
	private Bank b1, b2, b3, b4, b5;
	
	public BankTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		b1 = new Bank();
		b2 = new Bank("");
		b3 = new Bank("Test");
		b4 = new Bank("With spaces now");
		b5 = new Bank();
	}
	/*
	 * 
	 * Tests the constructor of the Bank Classes
	 * @author Brett Dennis
	 */
	public void testConstructor(){
		assertEquals("Seneca@York", b1.getName());
		assertEquals("",b2.getName());
		assertEquals("Test", b3.getName());
		assertEquals("With spaces now", b4.getName());
	}
	/*
	 * Tests the equals method of the Bank class, with a true and false test.
	 * @author Brett Dennis
	 */
	public void testEquals(){
		assertEquals(false, b1.equals(b3));
		assertEquals(true, b5.equals(b1));
		assertEquals(false, b2.equals(null));
	}
	
	/*
	 * Test the search by balance method of Bank with nulls and negatives, ensuring no false returns are made for no matches
	 * @author Brett Dennis
	 */
	public void testSearchByBalance() {
		Savings s1 = new Savings();
		b1.addAccount(s1);
		Account arr[] = new Account[1];
		arr[0] = s1;
		assertEquals(null, b1.searchbyBalance(null));
		assertEquals(null, b1.searchbyBalance(new BigDecimal("-1")));
		assertTrue("Is not true.", Arrays.equals(arr, b1.searchbyBalance(s1.getStartingBalance())));
	}
	/*
	 * Test the search by account number method of Bank with nulls and not found values, ensuring no false returns are made for no matches
	 * @author Brett Dennis
	 */
	public void testSearchByAccountNumber() {
		Account s1 = new Savings();
		b1.addAccount(s1);
		assertEquals(null, b1.searchByAccountNumber(null));
		assertEquals(null, b1.searchByAccountNumber("aaaaaaaaaaaaaaaa"));
		assertTrue("Is not true", s1.equals(b1.searchByAccountNumber(s1.getAccountNumber())));
		
	}
	/*
	 * Test the search by name method of Bank with nulls and false values, ensuring no false returns are made for no matches
	 * @author Brett Dennis
	 */
	public void testSearchByName() {
		Account s1 = new Savings();
		b1.addAccount(s1);
		Account arr[] = new Account[1];
		arr[0] = s1;
		assertEquals(null, b1.searchByAccountName(null));
		assertEquals(null, b1.searchByAccountName("aaaaaaaaaaaaaaaaa"));
		assertTrue("Is not true.", Arrays.equals(arr, b1.searchByAccountName(s1.getFullName())));
	}
	/*
	 * Tests remove account to ensure it can remove an account and deal with a null being passed to it.
	 */
	public void testRemoveAccount() {
		Account s1 = new Savings();
		b1.addAccount(s1);
		assertEquals(s1, b1.removeAccount(s1.getAccountNumber()));
		assertEquals(null, b1.removeAccount(null));
		
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	

}
