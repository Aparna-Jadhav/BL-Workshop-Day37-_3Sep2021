package com.Section;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBook_StreamIO 
{
	 List<Person> list;
	
	
	 public AddressBook_StreamIO(ArrayList<Person> list) {
		
		this.list = list;
	}
	 
	 public void showMenu() {
			
			Scanner sc= new Scanner(System.in);
			System.out.print("\n");
	        System.out.print("\nFile Operation Menu ");
	        System.out.print("\n");
	        System.out.print("\n1.Write into File \n2.Write into CSV File \n3.Write into JSON File");
	        System.out.print("\n\nChoose your option for File Operation : ");
	        int fileOption = sc.nextInt();
	        
	        switch(fileOption) {
				case 1 : 
					writeIOfile(list);
		            break;
				case 2 : 
					writeJsonFile(list);
		            break;
				case 3 : 
					writeJsonFile(list);
		            break;
				default :
					System.out.print("\nInvalid option");
	        }	
		}
	
	
	private static final CharSequence CSV_HEADER = "FNAME,LNAME,STREET,CITY,STATE,COUNTRY,PHONE,ZIP";
	public String iOFileName = "File_IO.txt";
	public static String csvFileName = "File_CSV.csv";
	public String jsonFileName = "File_json.json";
	
	
	public void writeIOfile(List<Person> list) {
		StringBuffer empBuffer = new StringBuffer();
		list.forEach(Person -> {
			String data = list.toString().concat("\n");
			empBuffer.append(data);
		});
		try {
			Files.write(Paths.get(iOFileName), empBuffer.toString().getBytes());
			System.out.print("\nDetails written into file");
		} catch (IOException e) {
			System.out.print("Unable to write contact into file" + e.getMessage());
		}	
		
	}

	public void writeCSVFile(List<Person> list) {
		try (Writer writer = Files.newBufferedWriter(Paths.get(csvFileName));) {
			StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder<Person>(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			try {
				beanToCsv.write(list);
			} catch (CsvDataTypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	public void readCSVFile() {
		System.out.println("Reading csv data");
		Path path = Paths.get(csvFileName);
		try (Reader reader = Files.newBufferedReader(path); 
				CSVReader csvReader = new CSVReader(reader);) {
			ArrayList<String[]> list = (ArrayList<String[]>) csvReader.readAll();

			for (String[] record : list) {

				System.out.println("FirstName :" + record[0]);
				System.out.println("LastName :" + record[1]);
				System.out.println("City :" + record[2]);
				System.out.println("State :" + record[3]);
				System.out.println(" email :" + record[4]);
				System.out.println("phoneNumber :" + record[5]);
				System.out.println("zip :" + record[6]);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}

	}

	public void writeJsonFile(List<Person> list) {
		Gson gson = new Gson();
		String jsonRead = gson.toJson(list);
		try {
			FileWriter writer = new FileWriter(jsonFileName);
			writer.write(jsonRead);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	public void readJsonFile() {
//		JSONParser parser = new JSONParser();
//
//        try {     
//            Object obj = parser.parse(new FileReader(jsonFileName));
//
//            JSONObject jsonObject =  (JSONObject) obj;
//
//            String name1 = (String) jsonObject.get("fname");
//            System.out.println(name1);
//
//            String name2 = (String) jsonObject.get("lname");
//            System.out.println(name2);
//            
//            String address = (String) jsonObject.get("address");
//            System.out.println(address);
//                      
//            String city = (String) jsonObject.get("city");
//            System.out.println(city);
//
//            String state = (String) jsonObject.get("state");
//            System.out.println(state);
//            
//            String email = (String) jsonObject.get("email");
//            System.out.println(email);
//            
//
//            String phone = (String) jsonObject.get("phone");
//            System.out.println(phone);
//
//            String zip = (String) jsonObject.get("zip");
//            System.out.println(zip);
//
////            // loop array
////            JSONArray cars = (JSONArray) jsonObject.get("cars");
////            Iterator<String> iterator = cars.iterator();
////            while (iterator.hasNext()) {
////             System.out.println(iterator.next());
////            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
   	
}
