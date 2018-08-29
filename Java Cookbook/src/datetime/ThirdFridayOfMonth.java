package datetime;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.springframework.expression.ParseException;

public class ThirdFridayOfMonth {

	public static void main(String[] args) {
		
		String jan2018 = "01/01/2018";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		Date date = null;				
		try {
			date = formatter.parse(jan2018);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		System.out.println("System Default TimeZone : " + defaultZoneId);

		// 1. Convert Date -> Instant
		Instant instant = date.toInstant();
		System.out.println("instant : " + instant); // Zone : UTC+0

		// 2. Instant + system default time zone + toLocalDate() = LocalDate
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		System.out.println("localDate : " + localDate);

		// 3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
		LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
		System.out.println("localDateTime : " + localDateTime);

		// 4. Instant + system default time zone = ZonedDateTime
		ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
		System.out.println("zonedDateTime : " + zonedDateTime);

		/*********************************************/
		//LocalDate d = LocalDate.now();
		LocalDate d = localDate;
		
		d = d.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY));
		System.out.println(d); 
		
		

	}

}
