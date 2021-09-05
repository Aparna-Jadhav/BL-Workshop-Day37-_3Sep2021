package com.Section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook 
{
	//static ArrayList<Person> list;
	public static ArrayList<Person> list;

	public AddressBook(ArrayList<Person> list2) {
		AddressBook.list = list2;
	}
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		ArrayList<Person> list = new ArrayList<Person>();
		int choice; 
		Helper_StreamAPI help = new Helper_StreamAPI();
		boolean status = true;
		while(status)
		{
			System.out.println(" Address Book Management");
			System.out.println("MENU :");
			System.out.println("1: addContactPerson                : ");
			System.out.println("2: editContactPerson               : ");
			System.out.println("3: deleteContactPerson             : ");
			System.out.println("4: addMultiplePersons              : ");
			System.out.println("5: findByFirstname                 : ");
			System.out.println("6: FindCityAndState                : ");
			System.out.println("7: countContactPersonByCityOrState : ");
			System.out.println("8: printAllContactPerson           : ");
			
			System.out.println("9: Exit \n");


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
				status = false;
				break;
			}
		}
//	  AddressBook_StreamIO addressOfStream_IO = new AddressBook_StreamIO();
//	  addressOfStream_IO.writeIOfile(list);
//	  addressOfStream_IO.readIOFile();
//	  addressOfStream_IO.writeCSVFile(list);
//	  addressOfStream_IO.readCSVFile();
////	  addressOfStream_IO.writeAddCSV();
//	  addressOfStream_IO.writeJsonFile(list);
////	 addressOfStream_IO.readJsonFile();
//	
//	
	
	  AddressBook_JDBC addressBookJDBC = new AddressBook_JDBC();
		addressBookJDBC.eshtablishConnection();
		addressBookJDBC.readAddressBook();
		addressBookJDBC.updateAddressBook();
//		addressBookJDBC.showContactsBetweenGivenDates();
		addressBookJDBC.countContactsByCity();
		addressBookJDBC.insertContact();
	
	
	
	}
	
	
	
}
	


