package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbPreparedStatement {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static int newAccountBalance;

	// static int updateAccountNumber;

	public static Connection getConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/atm";
		String username = "root";
		String password = "";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public void insertAccountDetails(Bank bank) throws SQLException {

		try {
			conn = getConnection();

			String query = "insert into userAccountDetail(accountType,firstName,lastName,accountNumber,accountBalance) values(?, ?, ?,?,?)";

			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setString(1, bank.accountType); // set input parameter 1
			pstmt.setString(2, bank.firstName);
			pstmt.setString(3, bank.lastName);
			pstmt.setInt(4, bank.accountNumber);
			pstmt.setDouble(5, bank.accountBalance);
			pstmt.executeUpdate(); // execute insert statement
			System.out.println("Inserted into AccountDetails congrats");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}

	public void insertAccountPin(PinCreate pin) throws SQLException {

		try {
			conn = getConnection();
			String query = "insert into pinDetails(accountNumber,pinNumber,accountBalance) values(?, ?, ?)";

			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, pin.accountNumber); // set input parameter 1
			pstmt.setInt(2, pin.pinNumber);
			pstmt.setDouble(3, pin.accountBalance);
			pstmt.executeUpdate(); // execute insert statement
			System.out.println("Inserted into table pinDetails congrats");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}

	public void selectAccountPin(UserPanel userPanel) {
		try {
			int accountNumber = 0;
			int pinNumber = 0;
			int accountBalance = 0;
			conn = getConnection();
			String query = "select accountNumber, pinNumber ,accountBalance from pinDetails where accountNumber=?";

			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, userPanel.userAccountNumber); // set input parameter
			rs = pstmt.executeQuery();
			// extract data from the ResultSet
			while (rs.next()) {
				accountNumber = rs.getInt(1);
				pinNumber = rs.getInt(2);
				accountBalance = rs.getInt(3);
				if (accountNumber == userPanel.userAccountNumber
						&& pinNumber == userPanel.userPinNumber) {
					System.out.println("Account Validated");

					System.out.println("Your current account Balance is: "
							+ accountBalance);
					if (true) {
						UserPanel user = new UserPanel();
						user.userInputAmount();

						if (user.userAccountBalance < accountBalance) {
							System.out
									.println("Cashing out check the opening of the vault");

							accountBalance = accountBalance
									- user.userAccountBalance;
							newAccountBalance = accountBalance;
							// Database update
							updateAccountDetails(accountBalance,
									userPanel.userAccountNumber);
							updatePinDetails(accountBalance,
									userPanel.userAccountNumber);

							try {
								Thread.sleep(5000); // 5 seconds delay for
													// cashing with sound

							} catch (InterruptedException ex) {
								Thread.currentThread().interrupt();
							}
							System.out
									.println("Your new amount in your account "
											+ accountNumber + " is "
											+ accountBalance);
						} else {
							System.out
									.println("Sorry, You have insufficient Amount to withdraw");
						}

					}

				} else {
					System.out.println("Conform your account number and pin");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateAccountDetails(int accountbl, int accountNo)
			throws SQLException {
		try {
			conn = getConnection();
			String query = "UPDATE userAccountDetail SET  accountBalance= ? Where accountNumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, accountbl); // set input parameter 1
			pstmt.setInt(2, accountNo); // set input parameter 2
			pstmt.executeUpdate(); // execute update statement
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}

	public void updatePinDetails(int accountbl, int accountNo)
			throws SQLException {
		try {
			conn = getConnection();
			String query = "UPDATE pinDetails SET  accountBalance= ? Where accountNumber = ?";
			pstmt = conn.prepareStatement(query); // create a statement
			pstmt.setInt(1, accountbl); // set input parameter 1
			pstmt.setInt(2, accountNo); // set input parameter 2
			pstmt.executeUpdate(); // execute update statement
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}
}