package com.Section;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Helper_StreamAPI 
{
	Scanner s = new Scanner(System.in);
	ArrayList<Person> list = new ArrayList<Person>();
	AddressBook address;
	
	
	
	public void addContactPerson() {
		System.out.println("Adding a new Person-list to Addressbook");
		
		System.out.println("Enter the First name:");
		String fname = s.next();
		
		System.out.println("Enter the Last name:");
		String lname = s.next();
		
		System.out.println("Enter the Address:");
		String address = s.next();
		
		System.out.println("Enter the City:");
		String city = s.next();
		
		System.out.println("Enter the State:");
		String state = s.next();
		
		System.out.println("Enter the Phone Number:");
		String phone = s.next();
		
		System.out.println("Enter the Email:");
		String email = s.next();
		
		System.out.println("Enter the Zip:");
		String zip = s.next();
	
		Person p = new Person(fname, lname, address, city, state, email, phone, zip);
		list.add(p);
	
		System.out.println();
	}

	
	public void editContactPerson() {
		System.out.println("Editing Person-list by name : ");
		System.out.println("Enter your First name:");
		String fname = s.next();

		Iterator<Person> iterator = list.listIterator();

		while (iterator.hasNext()) {
			Person person = iterator.next();

			if (fname.equals(person.getFname())) {
				String address = person.getAddress();
				System.out.println("Choose field you want to add:");
				System.out.println("1.First Name\n  2.Last Name\n  3.Address\n 4.City\n 5.State\n 6.Phone\n 7.Zip\n 8.Email\n");
				switch (s.nextInt()) {
				case 1:
					System.out.println("Re-Correct your firstname");
					person.setFname(s.next());
					break;
				case 2:
					System.out.println("Re-Correct your lastname");
					person.setLname(s.next());
					break;
				case 3:
					System.out.println("Re-Correct your Address");
					person.setAddress(s.next());
					break;
				case 4:
					System.out.println("Re-Correct your City");
					person.setCity(s.next());
					break;
				case 5:
					System.out.println("Re-Correct your State");
					person.setState(s.next());
					break;
				case 6:
					System.out.println("Re-Correct your Phone");
					person.setPhone(s.next());
					break;
				case 7:
					System.out.println("Re-Correct your Zip");
					person.setZip(s.next());
					break;
				case 8:
					System.out.println("Re-Correct your Email");
					person.setEmail(s.next());
					break;
				}
			}
		}
	}

	
	public void deleteContactPerson() {
		 System.out.println("Deleting Person-list by name : ");
		System.out.println("Enter your First name:");
		String name = s.next();

		Iterator<Person> iterator = list.listIterator();
		while (iterator.hasNext()) {
			Person person = iterator.next();

			if (name.equals(person.getFname())) {
				list.remove(person);
			}
		}
		System.out.println();
	}
	
	
	public void addMultiplePersons()
	{
		System.out.println("Adding multiple Person-list to AddressBook : ");
		//Scanner s = new Scanner(System.in);
		System.out.println("Enter how many persons want to add?");
		int numOfContacts = s.nextInt();
		for (int i = 0; i < numOfContacts; i++) 
		{
			addContactPerson();
		}
		System.out.println();
	}

	
	public void findByFirstname() 
	{
		 System.out.println("Find Person-list by name : ");
		 System.out.println("Enter first name : ");
		 String name = s.next();
         for (Person p : list) {
			if (name.equals(p.fname))
			{
				System.out.println("List found :" + list);
			}
        	}
        System.out.println();
	}
	

	public void FindCityAndState() 
	{
		 System.out.println("Find city and state of Person-list by name : ");
		 System.out.println("find Person name : ");
		 String name = s.next();
		 for (Person p : list) {
				if (name.equals(p.fname))
				{
					System.out.println("Name of the city found :" + p.city);
					System.out.println("Name of the state found :" + p.state);
				}
	        }
		 System.out.println();
	}

	
	public void countContactPersonByCityOrState() 
	{
		System.out.println("Count the Person-list by city :");
		int count = 0;
		for (Person i : list) {
			if (i.getCity().equals(i.city) || i.getState().equals(i.state)) {
				count++;
			} else {
				System.out.println("No City or State found ");
			}
		}
		System.out.println("Total counts of contacts :" + count);
		System.out.println();
	}

	
	public void printAllContactPerson() 
	{
		System.out.println("Here AddressBook Person-list : ");
		Iterator<Person> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			}
		System.out.println();
	}
	
}
