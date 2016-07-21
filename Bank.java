package com.company;

import java.util.Scanner;

public class Bank {
	protected String accountType;
	protected String firstName;
	protected String lastName;
	protected int accountNumber;
	protected double accountBalance;

	// public int setAccountNumber() {
	// return accountNumber;
	//
	// }

	public void createAccount() {
		Scanner input = new Scanner(System.in);
		// if (input.hasNextInt()) {
		// userPinNumber = input.nextInt();
		// } else {
		// System.out.println("Please enter valid Pin");
		// }

		System.out.println("Enter the accountType to Create:(Current/Saving) ");
		// accountType = input.next();
		if (input.hasNext()) {
			accountType = input.next();
		} else {
			System.out.println("Please Enter Current or Saving in the field.");
		}

		System.out.println("Enter the firstName");
		// firstName = input.next();
		if (input.hasNext()) {
			firstName = input.next();
		} else {
			System.out.println("Please Enter First Name");
		}

		System.out.println("Enter the lastName");
		// lastName = input.next();
		if (input.hasNext()) {
			lastName = input.next();
		} else {
			System.out.println("Please Enter Last Name");
		}

		System.out.println("Enter the accountNumber");
		// accountNumber = input.nextInt();
		if (input.hasNextInt()) {
			accountNumber = input.nextInt();
		} else {
			System.out.println("Please Enter Valid account Number");
		}
		System.out.println("Enter the accountBalce:(6 Digit)");
		// accountBalance = input.nextDouble();
		if (input.hasNext()) {
			accountBalance = input.nextInt();
		} else {
			System.out.println("Please Enter valid amount.");
		}
	}

	public void displayAccountDetails() {
		System.out.println("AccountDetails are: ");
		System.out.print("Account Type: ");
		System.out.print(accountType);
		System.out.println();
		System.out.print("FirstName: ");
		System.out.print(firstName);
		System.out.println();
		System.out.print("lastName: ");
		System.out.print(lastName);
		System.out.println();
		System.out.print("AccountNumber: ");
		System.out.print(accountNumber);
		System.out.println();
		System.out.print("AccountBalance: ");
		System.out.print(accountBalance);
		System.out.println();

	}

}
