package com.Section;

import java.util.Comparator;
import java.util.Scanner;

public class Person
{
public String fname, lname, address, city, state, email, phone, zip;
	

	public Person(String fname, String lname, String address, String city, String state, String email, String phone, String zip) {
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone = phone;
		this.zip = zip;
	}

	public String getFname()
	{
		return fname;
	}
	
	public void setFname(String fname)
	{
		this.fname = fname;
	}
	
	public String getLname()
	{
		return lname;
	}
	
	public void setLname(String lname)
	{
		this.lname = lname;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getZip()
	{
		return zip;
	}
	
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	
	
	@Override
	public String toString() {
		return "Person [ fname=" + fname + "   lname=" + lname + "   address=" + address + "   city=" + city + "   state="
				+ state + "   email=" + email + "   phone=" + phone + "   zip=" + zip + " ]";
	}
	
	
	
	public void userInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter person first name : ");
		fname= sc.nextLine();
		
		System.out.println("Enter person last name : ");
		lname= sc.nextLine();
		
		System.out.println("Enter person address : ");
		address= sc.nextLine();
		
		System.out.println("Enter person city : ");
		city= sc.nextLine();
		
		System.out.println("Enter person state : ");
		state= sc.nextLine();
		
		System.out.println("Enter person zip code: ");
		zip= sc.nextLine();
		
		System.out.println("Enter person phone num : ");
		phone= sc.nextLine();
		
		System.out.println("Enter person email: ");
		email= sc.nextLine();
	}
	
	
//	public void display()
//	{
//		System.out.println();
//		System.out.println("Person contact information : ");
//		System.out.println("First name :"+ fname);
//		System.out.println("Last name :"+ lname);
//		System.out.println("Address :"+ address);
//		System.out.println("City :"+ city);
//		System.out.println("State :"+ state);
//		System.out.println("Zip :"+ zip);
//		System.out.println("Phone no :"+ phone);
//		System.out.println("Email Id :"+ email);
//	}
}
