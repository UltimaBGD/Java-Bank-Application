package org.finance.accounts;

import java.math.BigDecimal;

//Name:Brett Dennis
public class Account {
	protected String name;
	protected String accountNumber;
	protected BigDecimal balance;
	protected BigDecimal startingBalance;

	/*
	 * no argument constructor
	 * 
	 * @author Brett Dennis
	 */
	public Account() {
		this.name = "";
		this.accountNumber = "";
		this.balance = new BigDecimal("0");
		balance = balance.setScale(2, BigDecimal.ROUND_HALF_UP);
		startingBalance = balance;
	}

	/*
	 * three argument constructor
	 * 
	 * @author Brett Dennis
	 * 
	 * @param gname Name of the account
	 * 
	 * @param gaccountNumber account number of the new account
	 * 
	 * @param bal balance of the new account.
	 *
	 */
	public Account(String gname, String gaccountNumber, BigDecimal bal) {
		// calls upon each of the setters which have the code for nulls and negatives
		setFullName(gname);
		setAccountNumber(gaccountNumber);
		setAccountBalance(bal);
		this.startingBalance = bal;
		this.startingBalance = startingBalance.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/*
	 * to string with formatting (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @author Brett Dennis
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("number: ");
		ret.append(this.getAccountNumber());
		ret.append(", name: ");
		ret.append(this.getFullName());
		ret.append('\n');
		ret.append("starting balance: $");
		ret.append(this.getStartingBalance());
		ret.append(", current balance: $");
		ret.append(this.getAccountBalance());
		return ret.toString();
	}

	/*
	 * setter for the name
	 * 
	 * @author Brett Dennis
	 * 
	 * @param setName The name to be set for the account
	 */
	public void setFullName(String setName) {
		if (setName == null) {
			this.name = "";
		} else {
			this.name = setName;
		}
	}

	/*
	 * setter for the account number
	 * 
	 * @author Brett Dennis
	 * 
	 * @param setAccountNumber The number to be set for the account.
	 */
	public void setAccountNumber(String setAccountNumber) {
		if (setAccountNumber == null) {
			this.accountNumber = "";
		} else {
			this.accountNumber = setAccountNumber;
		}
	}

	/*
	 * setter for the account balance
	 * 
	 * @author Brett Dennis
	 * 
	 * @param setBalance The Balance to be set
	 */
	public void setAccountBalance(BigDecimal setBalance) {
		BigDecimal zero = new BigDecimal("0");
		if (setBalance.compareTo(zero) == -1) {
			this.balance = new BigDecimal("0");
			balance = balance.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			this.balance = setBalance;
			balance = balance.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
	}

	/*
	 * getter for the name
	 * 
	 * @author Brett Dennis
	 */
	public String getFullName() {
		return this.name;
	}

	/*
	 * getter for the accountNumber
	 * 
	 * @author Brett Dennis
	 */
	public String getAccountNumber() {
		return this.accountNumber;
	}

	/*
	 * getter for the accountBalance
	 * 
	 * @author Brett Dennis
	 */
	public BigDecimal getAccountBalance() {
		return this.balance;
	}

	/*
	 * Account objects are equivalent if they have the same Account Name, Account
	 * Number, and Account Balance (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * @author Brett Dennis
	 * 
	 * @param comp The object to be compared
	 */
	public boolean equals(Object comp) {

		// default to false
		boolean result = false;

		// make sure it is an account
		if (comp instanceof Account) {

			Account acc = (Account) comp;
			if (acc.accountNumber.equals(this.accountNumber) && acc.name.equals(this.name)
					&& acc.balance == this.balance) {
				result = true;
			}
		}
		return result;
	}

	/*
	 * insert money into an account
	 * 
	 * @author Brett Dennis
	 * 
	 * @param amount amount to be deposited
	 */
	public boolean deposit(BigDecimal amount) {
		boolean change = false;
		if(amount !=  null) {
		BigDecimal zero = new BigDecimal("0");
		if (amount.compareTo(zero) != -1) {
			balance = balance.add(amount);
			change = true;
		}
		}
		return change;
	}

	/*
	 * take out money from an account
	 * 
	 * @author Brett Dennis
	 * 
	 * @param amount amount to be withdrawn
	 */
	public boolean withdraw(BigDecimal amount) {
		boolean change = false;
		BigDecimal zero = new BigDecimal("0");
		if (amount.compareTo(zero) != -1 && balance.subtract(amount).compareTo(zero) != -1) {
			balance = balance.subtract(amount);
			change = true;
		}
		return change;
	}

	/*
	 * gets starting balance
	 * 
	 * @author Brett Dennis
	 */
	public BigDecimal getStartingBalance() {
		return startingBalance;
	}

}
