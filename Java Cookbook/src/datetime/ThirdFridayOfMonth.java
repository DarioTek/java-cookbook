package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class ThirdFridayOfMonth {

	public static void main(String[] args) {
		
		LocalDate d = LocalDate.now();
		d = d.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY));
		System.out.println(d); 
	}

}
