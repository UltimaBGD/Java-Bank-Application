package org.finance.accounts;

import java.math.BigDecimal;
import java.util.ArrayList;

/*
 * Class designed to mimic a Chequing account
 * @author Brett Dennis
 */
public class Chequing extends Account {
	protected BigDecimal serviceCharge;
	ArrayList<BigDecimal> transactions;
	private int negCount;

	/*
	 * Chequing default constructor
	 * 
	 * @author Brett Dennis
	 */
	public Chequing() {
		super();
		serviceCharge = new BigDecimal("0.25");
		serviceCharge = serviceCharge.setScale(2, BigDecimal.ROUND_HALF_UP);
		transactions = new ArrayList<BigDecimal>();
	}

	/*
	 * Constructor with 4 parameters
	 * 
	 * @author Brett Dennis
	 * 
	 * @param name name of the account holder
	 * 
	 * @param accountNum Account Number
	 * 
	 * @param startBal The starting Balance
	 * 
	 * @param serviceCharge The service Charge to be applied.
	 */
	public Chequing(String name, String accountNum, BigDecimal startBal, BigDecimal serviceCharge) {
		super(name, accountNum, startBal);
		this.serviceCharge = serviceCharge;
		serviceCharge = serviceCharge.setScale(2, BigDecimal.ROUND_HALF_UP);
		transactions = new ArrayList<BigDecimal>();
	}

	/*
	 * deposits money into an account (non-Javadoc)
	 * 
	 * @see lab1.Account#deposit(java.math.BigDecimal)
	 * 
	 * @author Brett Dennis
	 * 
	 * @param amount amount to be deposited
	 */
	public boolean deposit(BigDecimal amount) {
		boolean change = super.deposit(amount);
		if (change)
			transactions.add(amount);
		return change;
	}

	/*
	 * take out money from an account
	 * 
	 * @author Brett Dennis
	 * 
	 * @param amount amount to be withdrawn
	 * 
	 * @override from account
	 */
	public boolean withdraw(BigDecimal amount) {
		boolean change = false;
		if(amount != null) {
		BigDecimal zero = new BigDecimal("0");
		BigDecimal neg = new BigDecimal("-1");
		if (amount.compareTo(zero) != -1 && balance.subtract((amount.add(serviceCharge))).compareTo(zero) != -1) {
			balance = balance.subtract(amount.add(serviceCharge));
			change = true;
			transactions.add(amount.multiply(neg));
			negCount++;
		}
		}
		return change;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lab1.Account#toString() to string for Chequing
	 * 
	 * @author Brett Dennis
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append(super.toString());
		ret.append("\ntype: CHEQUING\n");
		ret.append("service charge: $");
		ret.append(serviceCharge);
		ret.append("\nnumber of transactions: ");
		ret.append(transactions.size());
		ret.append("\ntotal amount of service charge: $");
		ret.append(serviceCharge.multiply(new BigDecimal(negCount)));
		return ret.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lab1.Account#equals(java.lang.Object) equals for Chequing
	 * 
	 * @author Brett Dennis
	 */
	public boolean equals(Object comp) {
		boolean ret = super.equals(comp);
		boolean ret2 = false;
		if (ret) {

			if (comp instanceof Chequing) {
				Chequing obj = (Chequing) comp;
				if (obj.serviceCharge.compareTo(this.serviceCharge) == 0 && obj.transactions.equals(this.transactions)
						&& this.negCount == obj.negCount) {
					ret2 = true;
				}
			}
		}
		return ret2;
	}

}
