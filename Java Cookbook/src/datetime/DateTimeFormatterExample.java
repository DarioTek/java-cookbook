package datetime;

import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;

/*
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 */
public class DateTimeFormatterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate localDate = LocalDate.now();//For reference
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String formattedString = localDate.format(formatter);
		System.out.println(formattedString);
		
		formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(localDate.format(formatter));
		

	}

}
