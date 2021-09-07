package com.Section;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddressBook_JDBC 
{
	
public void showMenu() throws SQLException {
		
		Scanner sc= new Scanner(System.in);
		System.out.print("\n");
        System.out.print("\nDataBase Operation Menu ###");
        System.out.print("\n");
        System.out.print("\n1.Connection to contacts \n2.Read Contacts \n3.Update contacts  \n4.Count contacts \n5.Add new contact");
        System.out.print("\n\nChoose your option for DataBase Operation : ");
        int dbOption = sc.nextInt();
        
        switch(dbOption) {
			case 1 : 
				eshtablishConnection();
				break;
			case 2 : 
				readAddressBook();
				break;
			case 3 : 
				updateAddressBook();
				break;
			case 4 : 
				countContactsByCity();
				break;
			case 5 : 
				insertContact();
				break;
			default :
				System.out.print("\nInvalid option");
        }	
	}
	
	
	public void eshtablishConnection() {
		Connection conn = getSqlConnection();
		if (conn != null) {
			System.out.println("Connection is eshtablished ");
		}

	}

	private Connection getSqlConnection() {
		Connection conn = null;
		String dbHostUrl = "jdbc:mysql://localhost:3306/AddressBook_service";
		String userName = "root";
		String password = "root";
		try {
			conn = DriverManager.getConnection(dbHostUrl, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void readAddressBook() {
		System.out.println("Displaying all data of AddressBook_service table");
		Connection conn = getSqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT * FROM AddressBook_service";
				
				java.sql.Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {
					String firstName = resultSet.getString(1);
					String lastName = resultSet.getString(2);
					String adress = resultSet.getString(3);
					String city = resultSet.getString(4);
					String state = resultSet.getString(5);
					Integer zip = resultSet.getInt(6);
					String phoneNumber = resultSet.getString(7);
					String email = resultSet.getString(8);
				
					String row = String.format(
							"User record:\n FirstName: %s,\n LastName: %s, \n Address: %s,  \n City: %s,\n State: %s \n ",
							firstName, lastName, adress, city, state, zip, phoneNumber, email);
					System.out.println(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());

				}
			}
		}

	}

	public void updateAddressBook() {
		System.out.println("Updating address ");
		Connection conn = getSqlConnection();
		if (conn != null) {
			String updateEmpPayroll = "UPDATE AddressBook_service SET address = ? WHERE lastName ='Shinde'";
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(updateEmpPayroll);
				preparedStatement.setString(1, "Jadhav");
				int rowUpdated = preparedStatement.executeUpdate();
				if (rowUpdated > 0) {
					System.out.println("Data is Updated");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException sqlException) {
						System.out.println(sqlException.getMessage());

					}
				}
			}
		}

	}

	
	public void countContactsByCity() {
		System.out.println("Counting number of contact by city");
		Connection conn = getSqlConnection();

		try {
			if (conn != null) {
				String readEmpPayroll = "SELECT count(lastName) FROM AddressBook_service WHERE city = 'Solapur' or state ='Maharashtra'";

				java.sql.Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(readEmpPayroll);
				while (resultSet.next()) {

					int countContacts = resultSet.getInt(1);

					String row = String.format("User record: \n Number of Contacts: %d", countContacts);
					System.out.println(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());

				}
			}
		}

	}

	public void insertContact() {
		System.out.println("Inserting a new contact to AddressBook_service table");
		Connection conn = getSqlConnection();
		if (conn != null) {
			String insertEmp = "INSERT INTO AddressBook_service (FirstName,LastName,Address,City,State,Zip,PhoneNum,EmailId) values(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement preparedStatement = conn.prepareStatement(insertEmp);
				preparedStatement.setString(1, "Madhuri");
				preparedStatement.setString(2, "Mete");
				preparedStatement.setString(3, "Vijayapura");
				preparedStatement.setString(4, "Vijayapura");
				preparedStatement.setString(5, "Karnataka");
				preparedStatement.setInt(6, 382870);
				preparedStatement.setString(7, "9012345678");
				preparedStatement.setString(8, "madhuri@gmail.com");
				
				int rowUpdated = preparedStatement.executeUpdate();
				if (rowUpdated > 0) {
					System.out.println("Data is Updated");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException sqlException) {
						System.out.println(sqlException.getMessage());

					}
				}
			}
		}

	}
}
