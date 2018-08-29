package datetime;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateToLocalDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * The code below is how to convert Date to Local Date
		 */
		ZoneId defaultZoneId = ZoneId.systemDefault();
		System.out.println("System Default TimeZone : " + defaultZoneId);

		// toString() append +8 automatically.
		String dateToPass = "08/11/2013";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		// Date date = new Date();
		Date date = null;
		try {
			date = formatter.parse(dateToPass);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("date : " + date);

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

	}

}
