package Sohan_Class_10.Sohan_Class_10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Converter {

	// Taking Calendar returning LocalDate
	public static LocalDate ConvertDateToLocalDateFromCalender(Calendar cal) {
		Date date = cal.getTime();
		LocalDate datee = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return datee;
	}

	// Taking Calendar returning Date
	public static Date ConvertLocalDateToDateFromCalender(Calendar cal) {
		TimeZone tz = cal.getTimeZone();
		ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		LocalDateTime localdate = LocalDateTime.ofInstant(cal.toInstant(), zid);
		Date date = java.util.Date.from(localdate.atZone(ZoneId.systemDefault()).toInstant());
		return date;
	}

	// Taking LocalDate returning Date
	public static Date ConvertLocalDateToDate(LocalDate localdate) {
		return java.util.Date.from(localdate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	// Taking Date returning LocalDate
	public static LocalDate ConvertDateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	// Taking Date returning String
	public static String ConvertDateToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
		String datee = dateFormat.format(date);
		return datee;
	}

	// Taking String returning Date
	public static Date ConvertStringToDate(String S_date) throws Exception {
		Date datee = new SimpleDateFormat("MMMM d, yyyy").parse(S_date);
		return datee;
	}

	// Taking LocalDate returning String
	public static String ConvertLocalDateToString(LocalDate localdate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		String datee = dateFormat.format(localdate);
		return datee;
	}

	// Taking String returning LocalDate
	public static LocalDate ConvertStringToLocalDate(String date) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		LocalDate datee = LocalDate.parse(date, dateFormat);
		return datee;
	}

	// Taking Date returning Calendar
	public static Calendar DateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	// Taking LocalDate returning Calendar
	public static Calendar LocalDateToCalendar(LocalDate localdate) {
		GregorianCalendar gc = GregorianCalendar.from(localdate.atStartOfDay(ZoneId.systemDefault()));
		return gc;

	}

	// Taking LocalDate returning isLeapYear or not
	public static boolean checkLeapYear(LocalDate localdate) {
		if (localdate.isLeapYear()) {
			return true;
		} else {
			return false;
		}
	}

	// Taking calendar returning ZoneID
	public static ZoneId ConvertCalendarToZoneID(Calendar cal) {
		LocalDateTime dateTime = LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
		ZoneId id = ZoneId.systemDefault();
		return id;
	}

	// Taking calendar returning ZoneOffset
	public static ZoneOffset ConvertCalendarToZoneOffset(Calendar cal) {
		LocalDateTime dateTime = LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
		ZoneId id = ZoneId.systemDefault();
		ZoneOffset zoneOff = id.getRules().getOffset(dateTime);
		return zoneOff;
	}

	// Not working ......

}
