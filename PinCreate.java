package com.company;

public class PinCreate extends Bank {
	int pinNumber;
	int accountNumber;
	double accountBalance;

	public void createPin(Bank bank) {
		// Bank bank = new Bank();
		accountNumber = bank.accountNumber;
		accountBalance = bank.accountBalance;
		int randomPIN = (int) (Math.random() * 9000) + 1000;
		pinNumber = randomPIN;

		System.out.println("Pin to account:" + accountNumber + " is "
				+ pinNumber);
	}
}
