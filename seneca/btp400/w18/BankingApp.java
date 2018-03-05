package seneca.btp400.w18;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.finance.accounts.Account;
import org.finance.accounts.Chequing;
import org.finance.accounts.GIC;
import org.finance.accounts.Savings;

import com.little.bank.Bank;

public class BankingApp {

	public static void main(String args[]) {
		Scanner menu = new Scanner(System.in);
		Bank bank = new Bank("Brett Dennis");
		loadBank(bank);
		int n = -1;
		StringBuffer name = new StringBuffer();
		name.append("### Welcome to the bank of ");
		name.append(bank.getName());
		name.append(" ###");
		System.out.println(name.toString());
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("hh:mm a MMMM d, u")));
		System.out.println();
		while (n != 6) {
			displayMenu(bank.getName());
			Scanner reader = new Scanner(System.in);
			System.out.print("Please enter your choice: ");
			n = menu.nextInt();
			System.out.println();
			// reader.close();
			if (n == 1) {
				openAccount(bank, reader);
			} else if (n == 2) {
				closeAccount(bank, reader);
			} else if (n == 3) {
				updateAccount(bank, reader);
			}

			else if (n == 4) {
				searchAccount(bank, reader);
			} else if (n == 5) {
				Account[] arr = new Account[bank.getAccounts().size()];
				bank.getAccounts().toArray(arr);
				listAccounts(arr);
			} else if (n == 6) {
				System.out.println("Thank you!");
				reader.close();
			}

		}
		menu.close();
	}

	/*
	 * Loads a test set of accounts
	 * 
	 * @author Brett Dennis
	 * 
	 * @param bank the bank to add the accounts to
	 */
	static void loadBank(Bank bank) {
		Savings add1 = new Savings("John Doe", "F9801", new BigDecimal("8000.00"), new BigDecimal("0.15"));
		Savings add2 = new Savings("Mary Ryan", "C9012", new BigDecimal("8000.00"), new BigDecimal("0.15"));
		Chequing add3 = new Chequing("John Doe", "E5678", new BigDecimal("15000.00"), new BigDecimal("0.75"));
		Chequing add4 = new Chequing("Mary Ryan", "B5678", new BigDecimal("15000.00"), new BigDecimal("0.75"));
		GIC add5 = new GIC("John Doe", "D1234", new BigDecimal("6000.00"), 2, new BigDecimal("1.5"));
		GIC add6 = new GIC("Mary Ryan", "A1234", new BigDecimal("15000.00"), 4, new BigDecimal("2.5"));
		bank.addAccount(add1);
		bank.addAccount(add2);
		bank.addAccount(add3);
		bank.addAccount(add4);
		bank.addAccount(add5);
		bank.addAccount(add6);
	}

	/*
	 * displays the menu
	 * 
	 * @author Brett Dennis
	 */
	static void displayMenu(String bankName) {
		System.out.println(
				"1. Open an Account\n2. Close an account\n3. Update an account\n4. Search\n5. List all accounts\n6. Exit\n");
	}

	/*
	 * displays the account passed in
	 * 
	 * @author Brett Dennis
	 */
	static void displayAccount(Account account) {
		System.out.println(account);
	}

	/*
	 * List the accounts within the passed array
	 * 
	 * @author Brett Dennis
	 * 
	 * @param listOfAccounts The Array of accounts to be iterated through
	 */
	static void listAccounts(Account[] listOfAccounts) {
		for (int i = 0; i < listOfAccounts.length; i++) {
			System.out.println(listOfAccounts[i]);
			System.out.println();
		}
	}

	/*
	 * opens an account with given information
	 * 
	 * @author Brett Dennis
	 * 
	 * @param bank the bank to open an account with
	 * 
	 * @param reader the scanner to read with
	 */
	static void openAccount(Bank bank, Scanner reader) {
		int length = 0;
		boolean valid = false;
		Account add = null;
		System.out.println("Please enter information(e.g. account type (SAV, CHE, GIC), name, account number, balance, interest rate (and if GIC) number of Periods) separated by commas, all on the next line: ");
		String toParse = reader.nextLine();
		System.out.println();
		String arr[] = toParse.split(",");
		String type = arr[0].trim();
		String nameAdd = arr[1].trim();
		String aNum = arr[2].trim();
		BigDecimal initBalance = new BigDecimal(arr[3].trim());
		initBalance = initBalance.setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal rate = new BigDecimal(arr[4].trim());
		rate = rate.setScale(2, BigDecimal.ROUND_HALF_UP);
		if (type.equals("GIC")) {
			length = Integer.parseInt(arr[5].trim());
		}
		if (type.equals("SAV")) {
			add = new Savings(nameAdd, aNum, initBalance, rate);
			valid = true;
		} else if (type.equals("CHE")) {
			add = new Chequing(nameAdd, aNum, initBalance, rate);
			valid = true;
		} else if (type.equals("GIC")) {
			add = new GIC(nameAdd, aNum, initBalance, length, rate);
			valid = true;
		}
		if (valid) {
			boolean existCheck = bank.addAccount(add);
			if(existCheck) {
			System.out.println("+ Account Opened: ");
			System.out.println(add);
			System.out.println();
			}
			else {
				System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***");
				System.out.println();
			}
		} else {
			System.out.println("*** FAILED: ACCOUNT CANNOT BE OPENED! ***");
			System.out.println();
		}
	}

	/*
	 * close an account in a bank with user input
	 * 
	 * @author Brett Dennis
	 * 
	 * @param bank the bank to have an account closed
	 * 
	 * @param reader the scanner to read user input
	 */
	static void closeAccount(Bank bank, Scanner reader) {
		System.out.print("Please enter the account number of the account to be deleted: ");
		String num = reader.next();
		System.out.println();
		Account del = bank.removeAccount(num);
		if (del != null) {
			System.out.println("+ Account Closed: ");
			System.out.println(del);
			System.out.println();
		} else {
			System.out.println("*** FAILED: ACCOUNT COULD NOT BE DELETED! ***");
		}
	}

	/*
	 * update an account with user input
	 * 
	 * @author Brett Dennis
	 * 
	 * @param bank the bank to update accounts within
	 * 
	 * @param reader the Scanner to get user input with
	 */
	static void updateAccount(Bank bank, Scanner reader) {
		boolean valid = false;
		boolean success = false;
		System.out.println("Please select from the following options:\n\na. Deposit Money\nb. Withdraw Money\n");
		System.out.print("Please enter your choice: ");
		String subChoice = reader.nextLine();
		System.out.println();
		System.out.print("Please enter the Account Number, and amount of money to be exchanged on one line, separated by a comma: ");
		String tempS = reader.nextLine();
		System.out.println();
		String arr[] = tempS.split(",");
		String tempNum = arr[0].trim();
		String amount = arr[1].trim();

		if (subChoice.equals("a")) {
			Account temp = bank.searchByAccountNumber(tempNum);
			if (temp != null) {
				success = bank.searchByAccountNumber(tempNum).deposit(new BigDecimal(amount));
				valid = true;
			}
		} else if (subChoice.equals("b")) {
			Account temp = bank.searchByAccountNumber(tempNum);
			if (temp != null) {
				success = bank.searchByAccountNumber(tempNum).withdraw(new BigDecimal(amount));
				valid = true;
			}
		}
		if (valid && success) {
			Account temp = bank.searchByAccountNumber(tempNum);
			System.out.println("+ Account Updated: ");
			System.out.println(temp);
			System.out.println();
		} else {
			System.out.println("*** FAILED: ACCOUNT CANNOT BE UPDATED! ***");
			System.out.println();
		}
	}

	/*
	 * search for accounts within a bank with a variety of methods
	 * 
	 * @author Brett Dennis
	 * 
	 * @param bank the bank to search within
	 * 
	 * @param reader the scanner with which to get user input`
	 */
	static void searchAccount(Bank bank, Scanner reader) {
		Account arr[] = null;
		System.out.println(
				"Please select from the following options:\n\na. Search by account balance.\nb. Search by account name.\nc. Search by account number.\n");
		System.out.print("Please enter your choice: ");
		String subChoice = reader.nextLine();
		System.out.println();
		if (subChoice.equals("a")) {
			System.out.print("Please enter the Balance to be searched for: $");
			double bal = reader.nextDouble();
			System.out.println();
			arr = bank.searchbyBalance(new BigDecimal(bal));
		} else if (subChoice.equals("b")) {
			System.out.print("Please enter the Name to be searched for: ");
			String nam = reader.nextLine();
			System.out.println();
			arr = bank.searchByAccountName(nam);

		} else if (subChoice.equals("c")) {
			System.out.print("Please enter the Account Number to be searched for: ");
			String number = reader.next();
			System.out.println();
			Account temp = bank.searchByAccountNumber(number);
			if (temp != null) {
				System.out.println("+ Account Retrieved: ");
				System.out.println(temp);
				System.out.println();
			} else {
				System.out.println("*** FAILED: ACCOUNT CANNOT BE FOUND! ***");
				System.out.println();
			}
		}
		if (arr != null) {
			System.out.println("+ Account Retrieved: ");
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
				System.out.println();
			}
		} else if (arr == null && !subChoice.equals("c")) {
			System.out.println("*** FAILED: ACCOUNT CANNOT BE FOUND! ***");
			System.out.println();
		}
	}
}
