package com.Section;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddressBook 
{
	public static void main(String[] args) throws SQLException 
	{
		Scanner s = new Scanner(System.in);
		ArrayList<Person> list = new ArrayList<Person>();
		int choice; 
		
		Helper_StreamAPI help = new Helper_StreamAPI();
		AddressBook_StreamIO addressOfStream_IO = new AddressBook_StreamIO(list);
		AddressBook_JDBC addressBook_JDBC =new AddressBook_JDBC();
		boolean status = true;
		while(status)
		{
			System.out.println(" Address Book Management");
			System.out.println("MENU :");
			System.out.println("1: Add Contact          : ");
			System.out.println("2: Edit Contact         : ");
			System.out.println("3: Delete Contact       : ");
			System.out.println("4: Add Multiple Contact : ");
			System.out.println("5: find Contact         : ");
			System.out.println("6: Find Contact City    : ");
			System.out.println("7: Count Contact        : ");
			System.out.println("8: Print Contact        : ");
			System.out.println("9: File Operation       : ");
			System.out.println("10: DataBase Operations  : ");
			System.out.println("11: Exit \n");


			System.out.println("--- Enter Your Choice ---");
			choice=s.nextInt();
			switch (choice) {
			case 1:
				help.addContactPerson();
				break;
			case 2:
				help.editContactPerson();
				break;
			case 3:
				help.deleteContactPerson();
				break;
			case 4:
				help.addMultiplePersons();
				break;
			case 5:
				help.findByFirstname();
				break;
			case 6:
				help.FindCityAndState();
				break;
			case 7:
				help.countContactPersonByCityOrState();
				break;
			case 8:
				help.printAllContactPerson();
				break;
			case 9:
				addressOfStream_IO.showMenu();
				break;
			case 10:
				addressBook_JDBC.showMenu();
				break;
			case 11:
				status = false;
				break;
			}
		}
	 
	}
}
	


