package com.little.bank;

//Name: Brett Dennis

import java.math.BigDecimal;
import java.util.ArrayList;

import org.finance.accounts.Account;

/*
 * A class designed to represent an instance of a bank, holding accounts and having a name
 * @author Brett Dennis 
 */
public class Bank {
	// Array List of type Account
	ArrayList<Account> accounts;
	String name;

	/*
	 * The default constructor for the Bank
	 * 
	 * @author Brett Dennis
	 */
	public Bank() {
		this.name = "Seneca@York";
		// instantiating the account
		this.accounts = new ArrayList<Account>();
	}

	/*
	 * The constructor to specify the name the bank has
	 * 
	 * @author Brett Dennis
	 * 
	 * @param name the Name of the bank
	 */
	public Bank(String name) {
		this.name = name;
		this.accounts = new ArrayList<Account>();
	}

	/*
	 * A method to add an account to the arraylist
	 * 
	 * @author Brett Dennis
	 * 
	 * @param newAccount The account to be added to the arraylist.
	 */
	public boolean addAccount(Account newAccount) {
		// good until proven otherwise
		boolean good = true;
		// for each loop through accounts

		// check for null, if found, not good
		if (newAccount == null) {
			good = false;
		}

		// no need to check if already false
		if (good == true) {
			for (Account x : accounts) {
				// check the account number with the received number
				if (x.getAccountNumber().equals(newAccount.getAccountNumber())) {
					// if found, no longer good
					good = false;
				}
			}
		}
		// if object was not found and is not null, add to account
		if (good == true) {
			accounts.add(newAccount);
		}
		return good;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() The override of the toString method for the
	 * Bank Class
	 * 
	 * @author Brett Dennis
	 */
	public String toString() {
		// create the return string
		String ret = "";
		// add to it
		ret += "*** Welcome to the bank of " + this.getName() + " ***\n";
		ret += ("It has " + this.accounts.size() + " accounts.\n");
		int i = 0;
		// loop through each item and add to the string
		for (Account x : this.getAccounts()) {
			ret += ((i + 1) + ". number: " + x.getAccountNumber() + ", name: " + x.getFullName() + ", balance: "
					+ x.getAccountBalance() + "\n");
			i++;
		}
		// return the string
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object) The override of the equals
	 * method, comparing the arraylist and name
	 * 
	 * @author Brett Dennis
	 * 
	 * @param comp The object to be compared to the bank
	 */
	public boolean equals(Object comp) {
		// assume false
		boolean ret = false;
		// check the instance
		if (comp instanceof Bank) {
			// cast to Bank
			Bank bank = (Bank) comp;
			// check the name and arraylist equality
			if (bank.name.equals(this.name)) {
				if (bank.accounts.equals(this.accounts)) {
					// set to true if they are both equal
					ret = true;
				}
			}
		}
		return ret;
	}

	/*
	 * Search through the arraylist for accounts matching the searchBalance
	 * 
	 * @author Brett Dennis
	 * 
	 * @param searchBal the balance to be searched for
	 */
	public Account[] searchbyBalance(BigDecimal searchBal) {
		// create the array to be returned
		Account[] ret = null;
		// set a count for the length of the array
		int count = 0;
		if(searchBal != null) {
		for (Account x : this.accounts) {
			if (x.getAccountBalance().compareTo(searchBal) == 0) {
				// add to the account
				count++;
			}
		}
		if (count > 0) {
			ret = new Account[count];
			count = 0;
			// second loop to put things in the array
			for (Account x : this.accounts) {
				if (x.getAccountBalance().compareTo(searchBal) == 0) {
					// must use count here, using .length will crash it, tried.
					ret[count] = x;
					// increase count
					count++;
				}
			}
		}
		}
		// return the array
		return ret;
	}

	/*
	 * returns the accounts
	 * 
	 * @author Brett Dennis
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	/*
	 * returns the name of the Bank
	 * 
	 * @author Brett Dennis
	 */
	public String getName() {
		return name;
	}

	/*
	 * sets the accounts to a given arrayList
	 * 
	 * @author Brett Dennis
	 * 
	 * @param accounts the arrayList of accounts to be set to this object.
	 */
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	/*
	 * sets the name of the bank to the argument given
	 * 
	 * @author Brett Dennis
	 * 
	 * @param name the name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * searches through the arraylist for accounts that have matching account names
	 * from the ones given in the parameter
	 * 
	 * @author Brett Dennis
	 * 
	 * @param AccountName the account name to check for matches in the Arraylist.
	 */
	public Account[] searchByAccountName(String AccountName) {

		// create the array to be returned
		Account[] ret = null;
		// set a count for the length of the array
		int count = 0;
		if(AccountName != null) {
		for (Account x : this.accounts) {
			if (x.getFullName().equals(AccountName)) {
				// add to the account
				count++;
			}
		}
		if (count > 0) {
			ret = new Account[count];
			count = 0;
			// second loop to put things in the array
			for (Account x : this.accounts) {
				if (x.getFullName().equals(AccountName)) {
					// must use count here, using .length will crash it, tried.
					ret[count] = x;
					// increase count
					count++;
				}
			}
		}
		}
		// return the array
		return ret;
	}

	/*
	 * searches through the array for the account with the specified account number
	 * 
	 * @author Brett Dennis
	 * 
	 * @param accountNumber the account number to be searched for
	 */
	public Account searchByAccountNumber(String accountNumber) {
		Account ret = null;
		if (accountNumber != null) {
			for (Account x : this.accounts) {
				if (x.getAccountNumber().equals(accountNumber)) {
					ret = x;
				}
			}
		}
		return ret;
	}

	/*
	 * Removes an account from the arraylist matched by the given account number
	 * 
	 * @author Brett Dennis
	 * 
	 * @param accountNumber the account number of the account to be deleted
	 */
	public Account removeAccount(String accountNumber) {
		Account ret = null;
		int counter = 0;
		int element = 0;
		if (accountNumber != null) {
			for (Account x : this.accounts) {
				if (x.getAccountNumber().equals(accountNumber)) {
					ret = x;
					element = counter;

				}
				counter++;
			}
		}
		if (ret != null) {
			accounts.remove(element);
		}
		return ret;
	}
}
