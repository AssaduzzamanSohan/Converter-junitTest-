package Sohan_Class_10.Sohan_Class_10;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class ConverterTest {

	Calendar cal = Calendar.getInstance();
	Calendar cal_set = Calendar.getInstance();

	Date date = cal.getTime();
	LocalDate localdate = LocalDate.now();

	@Test
	public void testConvertDateToLocalDateFromCalender() {
		cal_set.set(2010, 0, 2);
		LocalDate localDate1 = LocalDate.of(2010, Month.JANUARY, 2);
		assertEquals(localDate1, new Converter().ConvertDateToLocalDateFromCalender(cal_set));
	}

	@Test
	public void testConvertLocalDateToDateFromCalender() {
		cal_set.set(2010, 0, 2);
		Date date2 = cal_set.getTime();
		assertEquals(date2, new Converter().ConvertLocalDateToDateFromCalender(cal_set));
	}

	@Test
	public void testConvertLocalDateToDate() {

		cal_set.set(2010, 0, 2);
		Date date2 = cal_set.getTime();
		LocalDate localDate1 = LocalDate.of(2010, Month.JANUARY, 2);

		String str1 = new Converter().ConvertDateToString(date2);
		String str2 = new Converter().ConvertDateToString(new Converter().ConvertLocalDateToDate(localDate1));

		assertEquals(str1, str2);
	}

	@Test
	public void testConvertDateToLocalDate() {
		cal_set.set(2010, 0, 2);
		Date date2 = cal_set.getTime();
		LocalDate localDate1 = LocalDate.of(2010, Month.JANUARY, 2);

		assertEquals(localDate1, new Converter().ConvertDateToLocalDate(date2));
	}

	@Test
	public void testConvertDateToString() {
		cal_set.set(2019, 0, 16);
		Date date2 = cal_set.getTime();

		assertEquals("January 16, 2019", new Converter().ConvertDateToString(date2));
	}

	@Test
	public void testConvertLocalDateToString() {
		LocalDate localDate1 = LocalDate.of(2019, Month.JANUARY, 16);
		assertEquals("January 16, 2019", new Converter().ConvertLocalDateToString(localDate1));
	}

	@Test
	public void testConvertStringToDate() throws Exception {

		Calendar calen = Calendar.getInstance();
		calen.set(2010, 0, 2); // yyyy-mm-dd

		Date date1 = calen.getTime();
		Date date2 = new Converter().ConvertStringToDate("January 2, 2010");

		String str1 = new Converter().ConvertDateToString(date1);
		String str2 = new Converter().ConvertDateToString(date2);

		assertEquals(str1, str2);
	}

	@Test
	public void testConvertStringToLocalDate() {

		LocalDate localDate1 = LocalDate.of(2010, Month.JANUARY, 2);
		LocalDate localDate2 = new Converter().ConvertStringToLocalDate("January 2, 2010");

		assertEquals(localDate1, localDate2);
	}

	@Test
	public void testDateToCalendar() {

		Calendar calen = Calendar.getInstance();
		calen.set(2010, 0, 2); // yyyy-mm-dd

		Date date1 = calen.getTime();
		Calendar calender = new Converter().DateToCalendar(date1);

		int year = 2010;
		int month = 0;
		int day = 2;

		int year2 = calender.get(Calendar.YEAR);
		int month2 = calender.get(Calendar.MONTH);
		int day2 = calender.get(Calendar.DAY_OF_MONTH);

		assertEquals(year, year2);
		assertEquals(month, month2);
		assertEquals(day, day2);
	}

	@Test
	public void testLocalDateToCalendar() {
		LocalDate localDate1 = LocalDate.of(2010, Month.JANUARY, 2);
		Calendar calender = new Converter().LocalDateToCalendar(localDate1);
		Calendar calen = Calendar.getInstance();
		calen.set(2010, 0, 2); // yyyy-mm-dd

		int year = localDate1.getYear();
		int month = localDate1.getMonthValue();
		int day = localDate1.getDayOfMonth();

		int year2 = calender.get(Calendar.YEAR);
		int month2 = calender.get(Calendar.MONTH) + 1;
		int day2 = calender.get(Calendar.DAY_OF_MONTH);

		assertEquals(year, year2);
		assertEquals(month, month2);
		assertEquals(day, day2);

//		LocalDateTime localdate2 = LocalDateTime.now();
//		int hour = localdate2.getHour();
//		int minute = localdate2.getMinute();
//		int second = localdate2.getSecond();
	}

	@Test
	public void testCheckLeapYear() {

		LocalDate localDate1 = LocalDate.of(2012, Month.JANUARY, 2);
		LocalDate localDate2 = LocalDate.of(2015, Month.JANUARY, 2);

		assertTrue(new Converter().checkLeapYear(localDate1));
		;
		assertFalse(new Converter().checkLeapYear(localDate2));
	}
	@Test
	public void testConvertCalendertoZone() {
		String zstr = "Asia/Dhaka";
		ZoneId zone = ZoneId.of(zstr);
		assertEquals(zone, Converter.ConvertCalendarToZoneID(cal));
	}
	
	@Test
	public void testConvertCalendertoOffset() {
		String zstr = "+06:00"; //use your current zoneid
		ZoneOffset zoneOff = ZoneOffset.of(zstr);
		assertEquals(zoneOff, Converter.ConvertCalendarToZoneOffset(cal));
	}
	// Not working ......


	
	
	


}
