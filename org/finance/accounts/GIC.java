package org.finance.accounts;

import java.math.BigDecimal;

/*
 * Class made to represent a return on investment account
 * @author Brett Dennis
 */
public class GIC extends Account {
	protected int periodOfInvestment;
	protected BigDecimal annualInterest;

	/*
	 * constructor for GIC with no parameters
	 * 
	 * @author Brett Dennis
	 */
	public GIC() {
		super();
		this.periodOfInvestment = 1;
		this.annualInterest = new BigDecimal("1.25");
		this.annualInterest = annualInterest.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/*
	 * Constructor for GIC with 5 parameters
	 * 
	 * @author Brett Dennis
	 * 
	 * @param name name of account holder
	 * 
	 * @param accountNum account number of the account
	 * 
	 * @param startBal the starting balance of the account
	 * 
	 * @param pOI the number of periods of investments
	 * 
	 * @param annualInterest the percentage of interest annually
	 */
	public GIC(String name, String accountNum, BigDecimal startBal, int pOI, BigDecimal annualInterest) {
		super(name, accountNum, startBal);
		this.periodOfInvestment = pOI;
		this.annualInterest = annualInterest;
		this.annualInterest = this.annualInterest.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lab1.Account#deposit(java.math.BigDecimal) deposit just returns false as
	 * it canno be done
	 * 
	 * @author Brett Dennis
	 * 
	 * @param amount unneeded
	 */
	public boolean deposit(BigDecimal amount) {
		return false;
	}

	/*
	 * take out money from an account
	 * 
	 * @author Brett Dennis
	 * 
	 * @param amount amount to be withdrawn
	 */
	public boolean withdraw(BigDecimal amount) {
		return false;
	}

	/*
	 * a method that calculates the value of the account when the account is mature
	 * (after the period of time is up)
	 */
	public BigDecimal getBalanceAtMaturity() {
		return (this.getStartingBalance().multiply(
				(((annualInterest.divide(new BigDecimal("100"))).add(new BigDecimal("1")).pow(periodOfInvestment)))))
						.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lab1.Account#toString() toString for GIC
	 * 
	 * @author Brett Dennis
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append(super.toString());
		ret.append("\ntype: GIC\n");
		ret.append("annual interest rate: ");
		ret.append(annualInterest);
		ret.append("%\nperiod of investment: ");
		ret.append(periodOfInvestment);
		ret.append(" years\nnew balance at maturity: ");
		ret.append(this.getBalanceAtMaturity());
		return ret.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lab1.Account#equals(java.lang.Object) Equals for GIC, checks interest
	 * and periods
	 * 
	 * @author Brett Dennis
	 */
	public boolean equals(Object comp) {
		boolean ret = super.equals(comp);
		boolean ret2 = false;
		if (ret) {

			if (comp instanceof GIC) {
				GIC obj = (GIC) comp;
				if (obj.annualInterest == this.annualInterest && this.periodOfInvestment == obj.periodOfInvestment) {
					ret2 = true;
				}
			}
		}
		return ret2;
	}

}
