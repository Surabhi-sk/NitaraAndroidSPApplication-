package com.nitara.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class GenerateData {
	
	
	public String generateRandomPhoneNo() {
		Faker faker = new Faker(new Locale("en-IND"));
		String number = faker.number().digits(10);
		System.out.println(number);
		return number;	
	}
	
	public String generateRandomNumber(int noOfDigit) {
		Faker faker = new Faker();
		String number = faker.number().digits(noOfDigit);
		System.out.println(number);
		return number;
	}
	
	
	public String getDate(int days) {

		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, (days));
		SimpleDateFormat format = new SimpleDateFormat("ddMMMYYYY");
		String dateValue = format.format(cal.getTime());
		System.out.println(dateValue);
		return dateValue;
	}

	public String addDays(String date,int days) { 
	    
	    // create instance of the SimpleDateFormat that matches the given date  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	      
	    //create instance of the Calendar class and set the date to the given date  
	    Calendar cal = Calendar.getInstance();  
	    try{  
	       cal.setTime(sdf.parse(date));  
	    }catch(ParseException e){  
	        e.printStackTrace();  
	     }  
	         
	    // use add() method to add the days to the given date  
	    cal.add(Calendar.DAY_OF_MONTH, 21);  
	    String dateAfter = sdf.format(cal.getTime());  
	    System.out.println(dateAfter);
	    return dateAfter;
	}

	public String getPastDate(int days) {
	
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -(days));
		SimpleDateFormat format = new SimpleDateFormat("dd MMM YYYY");
		String dateValue = format.format(cal.getTime());
		System.out.println(dateValue);
		return dateValue;
	}

}
