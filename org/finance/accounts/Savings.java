package org.finance.accounts;

import java.math.BigDecimal;

/*
 * A class designed to represent a savings account
 * @author Brett Dennis
 */
public class Savings extends Account {
	protected BigDecimal interestRate;

	/*
	 * generic constructor with no arguements
	 * 
	 * @author Brett Dennis
	 */
	public Savings() {
		super();
		interestRate = new BigDecimal("0.003");
	}

	/*
	 * Constructor with five values, calls Account constructor
	 * 
	 * @author Brett Dennis
	 * 
	 * @param name name of the account holder
	 * 
	 * @param accountNum account number
	 * 
	 * @param startBal the starting balance of the account
	 * 
	 * @param rate the rate the savings account accrues interest
	 */
	public Savings(String name, String accountNum, BigDecimal startBal, BigDecimal rate) {
		super(name, accountNum, startBal);
		interestRate = rate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lab1.Account#toString() Tostring for savings
	 * 
	 * @author Brett Dennis
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append(super.toString());
		ret.append("\ntype: SAVINGS\n");
		ret.append("annual interest rate: ");
		ret.append(interestRate);
		ret.append("%");
		return ret.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lab1.Account#equals(java.lang.Object) equals for savings, checks to make
	 * sure it is an account and everything account related is equal and then makes
	 * sure it is saving and the interest rate is equal
	 * 
	 * @author Brett Dennis
	 * 
	 * @param comp the object to be compared
	 */
	public boolean equals(Object comp) {
		boolean ret = super.equals(comp);
		boolean ret2 = false;
		if (ret) {

			if (comp instanceof Savings) {
				Savings obj = (Savings) comp;
				if (obj.interestRate == this.interestRate) {
					ret2 = true;
				}
			}
		}
		return ret2;
	}
}
