package com.java.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeTest {

	public static void main(String[] args) {
		LocalDate today=LocalDate.now();
		LocalDate dob=LocalDate.of(2015, 11, 20);
		System.out.println("Today is: "+today);
		System.out.println("It'll be "+today.plus(1,ChronoUnit.DAYS)+" tomorrow");
		
		System.out.println("Day: "+today.getDayOfMonth());
		System.out.println("Month: "+today.getMonth());
		System.out.println("Year: "+today.getYear());
		
		
		if(dob.equals(today))
			System.out.println("Happy B'day");
		else if(dob.getMonthValue()<today.getMonthValue())
			System.out.println("It's been "+
					(today.getMonthValue()-dob.getMonthValue())+
					" month(s) from your birthday");
		else if(dob.getMonthValue()>today.getMonthValue())
			System.out.println("Just "+
					(dob.getMonthValue()-today.getMonthValue())+
					" more month(s) to your birthday");
		else if(dob.getDayOfMonth()>today.getDayOfMonth())
			System.out.println("Just "+
					(dob.getDayOfMonth()-today.getDayOfMonth())+
					" more day(s) to your birthday");
		else
			System.out.println("It's been "+
					(today.getDayOfMonth()-dob.getDayOfMonth())+
					" day(s) from your birthday");
		
		
		MonthDay dobMonthDay=MonthDay.of(dob.getMonth(), dob.getDayOfMonth());
		MonthDay todayMonthDay=MonthDay.from(today);
		if(dobMonthDay.equals(todayMonthDay))
			System.out.println("Using MonthDay.Happy B'day");
		else{ 
			System.out.println("Using Month Day");
			Period diff=Period.between(today, dob);
			if(diff.getMonths()>0)
				System.out.println("Just "+diff.getMonths()+" more month(s) to your birthday");
			else
				System.out.println("Just "+diff.getDays()+" more day(s) to your birthday");
		}
		
		LocalTime localTime=LocalTime.now();
		System.out.println("Its "+localTime+" now");
		System.out.println("It'll be "+localTime.plusMinutes(30)+" after 30 minutes");
		
		System.out.println("Is 2015 a leap year? :"+today.isLeapYear());
		
		
		ZoneId zoneId=ZoneId.of("Asia/Kolkata");
		LocalDateTime dateTime=LocalDateTime.now();
		ZonedDateTime zoneDateTime=ZonedDateTime.of(dateTime, zoneId);
		System.out.println("Zoned Date Time: "+zoneDateTime);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MMM-YYYY hh:mm:ss");
		System.out.println("Formatted Zone: "+zoneDateTime.format(formatter));
		
		String date="1991-11-20";
		LocalDate formatted=LocalDate.parse(date,DateTimeFormatter.ISO_DATE);
		System.out.println("Formatted Date: "+formatted);
		formatter=DateTimeFormatter.ofPattern("dd-MMM-YYYY");
		System.out.println(dob.format(formatter));
		
	}
}