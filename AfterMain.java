package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class AfterMain {
	public static void getCompile() throws SQLException {
		while (true) {
			System.out.println();
			System.out.println(" Which door do you want to Enter?");
			System.out.println("1. Admin Panel");
			System.out.println("2. User Panel");

			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			if (num == 1) {
				// Used by Admin Panel
				Bank bank = new Bank();
				bank.createAccount();

				PinCreate pinCreate = new PinCreate();
				pinCreate.createPin(bank);

				DbPreparedStatement db = new DbPreparedStatement();
				db.insertAccountDetails(bank);
				db.insertAccountPin(pinCreate);
			} else if (num == 2) {
				// Used by user panel
				UserPanel userPanel = new UserPanel();
				userPanel.userInput();

				DbPreparedStatement db = new DbPreparedStatement();
				db.selectAccountPin(userPanel);
			} else {
				System.out.println("Please choose 1 or 2 for Entry.");
			}
		}
	}
}