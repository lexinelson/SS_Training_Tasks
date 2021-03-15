/**
 * 
 */
package com.ss.firstwk.fri;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author lexne
 *
 */
public class DateTimeBasicsTest {
	private final BasicDateTime base = new BasicDateTime();
	
	@Test
	public void getPreviousThursdayTest() {
		LocalDate test = LocalDate.of(2021, 3, 15);
		LocalDate expected = LocalDate.of(2021, 3, 11);
		assertEquals(expected, base.getPreviousThursday(test));
	}
	
	@Test
	public void zoneIdConversionTest() {
		ZoneId test = ZoneId.of("US/Central");
		ZoneOffset expected = ZoneOffset.of("-05:00");
		assertEquals(expected, base.convertZoneIDtoOffset(test));
	}
	
	@Test
	public void getMonthLengthsTest() { 
		String[] expected = new String[] {"January: 31 days", "February: 28 days", "March: 31 days",
				"April: 30 days", "May: 31 days", "June: 30 days", "July: 31 days", "August: 31 days",
				"September: 30 days", "October: 31 days", "November: 30 days", "December: 31 days"};
		assertArrayEquals(expected, base.getMonthLengths(2021));
	}
	
	@Test
	public void listMondaysTest() {
		List<Integer> expected = Arrays.asList(1, 8, 15, 22, 29);
		assertEquals(expected, base.listMondays(3));
	}
	
	@Test
	public void isFirdayThirteenTest() {
		LocalDate no = LocalDate.of(2021, 3, 15);
		LocalDate yes = LocalDate.of(2021, 8, 13);
		
		assertNotEquals(true, base.isFridayThirteen(no));
		assertEquals(true, base.isFridayThirteen(yes));
	}
}
