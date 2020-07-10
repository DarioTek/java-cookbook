package datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateArtithmetic {

	public static void main(String[] args) {
		// Subtract 1 month from current date
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date result = cal.getTime();
		
		/* Starting from Java 8, the suggested way is to use the Date-Time API rather than Calendar.
		 * https://stackoverflow.com/questions/16392892/how-to-reduce-one-month-from-current-date-and-stored-in-date-variable-using-java
		 * 
		 */
		Date date = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
		ZonedDateTime dateInUTC = ZonedDateTime.now(ZoneId.of("Pacific/Auckland")).minusMonths(1);
		
		// Best Answer
	    java.util.Date da = new Date();
	    Calendar cal2 = Calendar.getInstance();
	    cal2.setTime(da);
	    cal2.add(Calendar.MONTH, -1);
	    da = cal2.getTime();
	    System.out.print("date = " + da);
	}

}
