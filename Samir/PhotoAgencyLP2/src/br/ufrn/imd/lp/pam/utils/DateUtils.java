package br.ufrn.imd.lp.pam.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	public static Date convertStringToDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;

		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return d;
	}
	
	public static int calcAge(Date itemDate) {
		
		LocalDate now = LocalDate.now();
		LocalDate old = convertDateToLocalDate(itemDate);
		Period p = Period.between(old, now);
		int age = p.getYears();
		
		return age;
	}
	
	private static LocalDate convertDateToLocalDate(Date dateToConvert) {
		
		return  Instant.ofEpochMilli(dateToConvert.getTime())
				.atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
}
