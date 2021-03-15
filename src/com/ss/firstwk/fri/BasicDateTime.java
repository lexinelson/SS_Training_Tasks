/**
 * Week 1 - Day 5 - DateTime API tasks
 */
package com.ss.firstwk.fri;

import java.time.*;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * DateTime question answer - in class form
 * @author Lexi Nelson
 *
 */
public class BasicDateTime {

	// 1. Which class would you use to store your birthday in years,
	//		months, days, seconds, and nanoseconds
	private ZonedDateTime birthday = ZonedDateTime.of(
			LocalDateTime.parse("1994-01-21T16:47:28"), ZoneId.of("US/Central"));
	
	
	// 2. Given a random date, how would you find the date of the
	//		previous Thursday?
	public LocalDate getPreviousThursday(LocalDate input) {
		do {
			input = input.minusDays(1);
		} while (input.getDayOfWeek().getValue() != DayOfWeek.THURSDAY.getValue());
		return input;
	}
	
	
	// 3. What is the difference between a ZoneID and a ZoneOffset?
	/**
	 * A ZoneID can have a ZoneOffset as a component, but may also be in
	 * the form of a string abiding by the ZoneRules (see birthday above). Every valid idea
	 * has a corresponding ZoneOffset, but all ZoneOffsets are particular in
	 * the format of +00:00 (where the number represents the offset from UTC/Greenwich)
	 * Both are used by different types
	 * Example ZoneID: "US/Central", "CST6DT"
	 * Example ZoneOffset: -06:00
	 */
	public ZoneOffset convertZoneIDtoOffset(ZoneId id) {
		return id.getRules().getOffset(Instant.now());
	}
	
	
	
	// 4. How would you convert an Instant to a ZonedDateTime?
	//		How would you convert a ZonedDateTime to an Instant?
	
	public ZonedDateTime convert(Instant in) {
		return in.atZone(ZoneId.systemDefault());
	}
	public Instant convert(ZonedDateTime zdt) {
		return Instant.from(zdt);
	}
	
	
	
	// 5. Write an example that, for a given year, reports the length
	//		of each month within that year.
	
	public String[] getMonthLengths(Year year) {
		String[] months = new String[12];
		for (int i = 1; i <= 12; i++) {
			months[i-1] = year.atMonth(i).getMonth().getDisplayName(TextStyle.FULL, Locale.US);
			months[i-1] += ": " + year.atMonth(i).lengthOfMonth() + " days";
		}
		return months;
	}
	public String[] getMonthLengths(int year) throws DateTimeException {
		return getMonthLengths(Year.of(year));
	}
	public String[] getMonthLengths(String year) throws DateTimeException, NumberFormatException {
		return getMonthLengths(Integer.parseInt(year));
	}
	
	
	
	// 6. Write an example that, for a given month of the current year,
	//		lists all of the Mondays in that month.
	
	public List<Integer> listMondays(Month m) {
		List<Integer> result = new ArrayList<Integer>();
		LocalDate month = LocalDate.of(Year.now().getValue(), m, 1);
		
		while (m.equals(month.getMonth())) {
			if (DayOfWeek.MONDAY.equals(month.getDayOfWeek()))
				result.add(month.getDayOfMonth());
			month = month.plusDays(1);
		}
		return result;
	}
	public List<Integer> listMondays(int month) throws DateTimeException {
		return listMondays(Month.of(month));
	}
	
	
	
	// 7. Write an example that tests whether the given date occurs on
	//		Friday the 13th
	
	public boolean isFridayThirteen(LocalDate date) {
		return DayOfWeek.FRIDAY.equals(date.getDayOfWeek()) && date.getDayOfMonth() == 13;
	}
	public boolean isFridayThirteen(LocalDateTime date) {
		return isFridayThirteen(date.toLocalDate());
	}
	public boolean isFridayThirteen(OffsetDateTime date) {
		return isFridayThirteen(date.toLocalDate());
	}
	public boolean isFridayThirteen(ZonedDateTime date) {
		return isFridayThirteen(date.toLocalDate());
	}
}
