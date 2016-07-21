package com.company;

import java.util.Scanner;

public class UserPanel {
	protected int userAccountNumber;
	protected int userPinNumber;
	protected int userAccountBalance;

	public void userInput() {
		Scanner input = new Scanner(System.in);

		System.out.println("User Please Enter your Account Number:");
		if (input.hasNextInt()) {
			userAccountNumber = input.nextInt();
		} else {
			System.out.println("Please enter Account Number");
		}

		System.out.println("Enter your 4 digit Pin Number");
		if (input.hasNextInt()) {
			userPinNumber = input.nextInt();
		} else {
			System.out.println("Please enter valid Pin");
		}
	}

	public void userInputAmount() {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter amount to Withdraw:");
		if (input.hasNextInt()) {
			userAccountBalance = input.nextInt();
		} else {
			System.out.println("User Valid Amount");
		}

	}
}
