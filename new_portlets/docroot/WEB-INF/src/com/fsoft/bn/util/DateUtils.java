package com.fsoft.bn.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.fsoft.bn.constant.CommonConstants;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;

public class DateUtils extends DateUtil {

	/**
	 * Get list date within startDate ~ endDate , number of date is less or
	 * equals numCount
	 *
	 * @param startDate
	 * @param endDate
	 * @param numDays
	 * @param format
	 *            of date (yyyy/MM/dd or yyyyMMdd)
	 * @return
	 */
	public static List<String> getListByDay(String startDate, String endDate,
			int numDays, String format) {

		List<String> listDate = new ArrayList<String>();
		// parse string to date
		Date startD = string2Date(startDate, format);
		Date endD = string2Date(endDate, format);
		// loop to add date string to list
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i < numDays; i++) {
			cal.setTime(startD);
			cal.add(Calendar.DATE, i);
			d = cal.getTime();
			if (d.getTime() <= endD.getTime())
				listDate.add(date2String(d, format));
			else
				break;
		}
		return listDate;
	}

	/**
	 * Get list date within startDate ~ endDate , number of week is less or
	 * equals numCount
	 *
	 * @param startDate
	 * @param endDate
	 * @param numWeeks
	 * @param format
	 *            of date (yyyy/MM/dd or yyyyMMdd)
	 * @return
	 */
	public static List<String> getListByWeek(String startDate, String endDate, int numWeeks,
			String format) {
		List<String> listDate = new ArrayList<String>();
		// parse string to date
		Date startD = string2Date(startDate, format);
		Date endD = string2Date(endDate, format);
		// loop to add date string to list
		Date d = new Date();
		Calendar cal = Calendar.getInstance();

		// set first day is monday, not sunday
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(startD);

		int numCount = 0;
		int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
		int cntWeek = numWeeks;
		while (true) {
			cal.setTime(startD);
			cal.add(Calendar.DATE, numCount);
			d = cal.getTime();
			
			// range in numWeeks and <= endDate
			if (d.getTime() <= endD.getTime()) {
				if (weekOfYear != cal.get(Calendar.WEEK_OF_YEAR)) {
					weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
					cntWeek--;
				}
				if (cntWeek > 0) {
					listDate.add(date2String(d, format));
				}
			} else {
				break;
			}

			numCount++;
		}
		return listDate;
	}

	/**
	 * get date in range startDate ~ endDate
	 *
	 * @param startDate
	 * @param endDate
	 * @param weekDay
	 *            array of 8 elemen in accordingly with Sun, Mon, Tue, Wen, Thi,
	 *            Fri, Sat, Holiday
	 * @param weekDay
	 *            value is {1,0}
	 * @param format
	 *            yyyy/MM/dd or yyyyMMdd
	 * @return
	 */
	public static List<String> getListByWeekday(String startDate, String endDate, int[] weekDay,
			String format) {
		List<String> listDate = new ArrayList<String>();
		// parse string to date
		Date startD = string2Date(startDate, format);
		Date endD = string2Date(endDate, format);
		// loop to add date string to list
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		int numCount = 0;
		while (true) {
			cal.setTime(startD);
			cal.add(Calendar.DATE, numCount);
			d = cal.getTime();
			// range in numWeeks and <= endDate
			if (d.getTime() <= endD.getTime()) {
				if (weekDay[cal.get(Calendar.DAY_OF_WEEK) - 1] == 1)
					listDate.add(date2String(d, format));
			} else {
				break;
			}

			numCount++;
		}
		return listDate;
	}

	/**
	 * getlist of date within range
	 *
	 * @param startDate
	 * @param endDate
	 * @param numMonths
	 *            number of month in above range
	 * @param monthDay
	 *            day of month (from 1 to 31)
	 * @param format
	 *            yyyy/MM/dd or yyyyMMdd
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<String> getListByMonthDay(String startDate, String endDate, int numMonths,
			int monthDay, String format) {
		List<String> listDate = new ArrayList<String>();
		// parse string to date
		Date startD = string2Date(startDate, format);
		Date endD = string2Date(endDate, format);
		// loop to add date string to list
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startD);
		// get first month of range
		int monthOfYear = cal.get(Calendar.MONTH);
		int tempMonth;
		int numCount = 0;
		while (true) {
			cal.setTime(startD);
			cal.add(Calendar.DATE, numCount);
			d = cal.getTime();
			// range in numMonths and <= endDate
			if (d.getTime() <= endD.getTime()) {
				tempMonth = cal.get(Calendar.MONTH) - monthOfYear;
				// if d is date of next year
				if (tempMonth < 0) {
					tempMonth += 12 * (cal.getTime().getYear() - startD.getYear());
				}

				if ((tempMonth < numMonths) && cal.get(Calendar.DAY_OF_MONTH) == monthDay) {
					listDate.add(date2String(d, format));
				}
			} else {
				break;
			}

			numCount++;
		}
		return listDate;
	}

	/**
	 * get list of date within range startDate ~ endDate
	 *
	 * @param startDate
	 * @param endDate
	 * @param numMonths
	 * @param monthWeek
	 *            value is one from {1, 2, 3, 4, 5}
	 * @param dayOfWeek
	 *            value from 0 ~ 6 accordding Sundays ~ Saturday
	 * @param format
	 *            yyyy/MM/dd or yyyyMMdd
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<String> getListByMonthWeekDay(String startDate, String endDate, int numMonths,
			int monthWeek, int dayOfWeek, String format) {
		List<String> listDate = new ArrayList<String>();
		// parse string to date
		Date startD = string2Date(startDate, format);
		Date endD = string2Date(endDate, format);
		// loop to add date string to list
		Date d = new Date();
		Calendar cal = Calendar.getInstance();

		cal.setTime(startD);
		// get first month of range
		int monthOfYear = cal.get(Calendar.MONTH);
		int numCount = 0;
		int tempMonth;
		while (true) {
			cal.setTime(startD);
			cal.add(Calendar.DATE, numCount);
			// set start of week is Monday, not Sunday as default
			cal.setFirstDayOfWeek(Calendar.MONDAY);
			d = cal.getTime();
			// range in numWeeks and <= endDate
			if (d.getTime() <= endD.getTime()) {
				if ((cal.get(Calendar.WEEK_OF_MONTH) == monthWeek)
						&& (dayOfWeek == (cal.get(Calendar.DAY_OF_WEEK) - 1))) {
					tempMonth = cal.get(Calendar.MONTH) - monthOfYear;
					// if d is date of next year
					if (tempMonth < 0) {
						tempMonth += 12 * (cal.getTime().getYear() - startD.getYear());
					}

					if (tempMonth < numMonths) {
						listDate.add(date2String(d, format));
					}
				}
			} else {
				break;
			}

			numCount++;
		}
		return listDate;
	}

	/**
	 * This method used to create String with 8 number form date.
	 * 
	 * @param date
	 * @return
	 */
	public static String date2Long(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		StringBuffer buf = new StringBuffer();
		buf.append(String.valueOf(cal.get(Calendar.YEAR)));

		int currentMonth = cal.get(Calendar.MONTH) + 1;
		if (1 <= currentMonth && currentMonth <= 9) {
			buf.append(CommonConstants.STRING_0);
		}
		buf.append(String.valueOf(currentMonth));
		int currentDay = cal.get(Calendar.DAY_OF_MONTH);
		if (1 <= currentDay && currentDay <= 9) {
			buf.append(CommonConstants.STRING_0);
		}
		buf.append(currentDay);
		return buf.toString();
	}

	/**
	 * Create Date Object form year/month/day
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return Date
	 */
	public static Date createDate(int year, int month, int day) {
		Date returnDate = null;

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);

		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, day);

		returnDate = cal.getTime();

		return returnDate;
	}


	/**
	 * Create Date object from date,time.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @return Date
	 */
	public static Date createDateTime(int year, int month, int day, int hour, int minute) {
		Date returnDate = null;

		Calendar cal = Calendar.getInstance();

		cal.clear();

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, day);
		cal.set(Calendar.HOUR, hour);
		cal.set(Calendar.MINUTE, minute);

		returnDate = cal.getTime();

		return returnDate;
	}

	/**
	 * Get system date.
	 * 
	 * @param pattern
	 * @return String system date
	 */
	public static String getSystemDate(String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getSystemDate(String pattern, Locale locale) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * year is leaf or not
	 * 
	 * @param year
	 * @return
	 */
	public static boolean isLeafYear(int year) {
		GregorianCalendar cal = new GregorianCalendar();
		return cal.isLeapYear(year);
	}

	/**
	 * Convert TimeZone from UTC to LTC
	 * 
	 * @param date
	 *            the date time to be converted
	 * @param timeZone
	 *            the local time zone to display in
	 * @param pattern
	 *            the date time format to display in
	 * @param locale
	 *            the local setting of the pattern
	 * @return the string to be displayed
	 */
	public static String convertUTCToLTCTime(Calendar date, String timeZone, String pattern,
			Locale locale) {
		DateFormat dateFormat = new SimpleDateFormat(pattern, locale);
		if (!Validator.isBlankOrNull(timeZone)) {
			dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		}
		return dateFormat.format(date.getTime());
	}

	/**
	 * Convert TimeZone from UTC to LTC
	 * 
	 * @param date
	 *            the date time to be converted
	 * @param timeZone
	 *            the local time zone to display in
	 * @param pattern
	 *            the date time format to display in
	 * @return the string to be displayed
	 */
	public static String convertUTCToLTCTime(Calendar date, TimeZone timeZone, String pattern,
			Locale locale) {
		DateFormat dateFormat = new SimpleDateFormat(pattern, locale);
		dateFormat.setTimeZone(timeZone);
		return dateFormat.format(date.getTime());
	}

	/**
	 * Convert TimeZone from the inputed date's TimeZone to the specified
	 * timeZone.<br>
	 * NOTE: the date generated by this method should be used strictly for
	 * displaying only, not for calculation
	 * 
	 * @param date
	 *            the date time to be converted
	 * @param timeZone
	 *            the local time zone to display in
	 * @return the date to be displayed
	 * @since 2012/03/02
	 */
	public static Date convertTimeZone(final Calendar date, final String timeZone) {
		Calendar ret = Calendar.getInstance();
		if (Validator.isBlankOrNull(timeZone)) {
			ret.setTimeInMillis(date.getTimeInMillis()
					- TimeZone.getDefault().getOffset(date.getTimeInMillis()) + 2
					* date.getTimeZone().getOffset(date.getTimeInMillis()));
		} else {
			ret.setTimeInMillis(date.getTimeInMillis()
					- TimeZone.getDefault().getOffset(date.getTimeInMillis())
					+ TimeZone.getTimeZone(timeZone).getOffset(date.getTimeInMillis()));
		}
		return ret.getTime();
	}

	/**
	 * Adapt calendar to client time zone.
	 * 
	 * @param calendar
	 *            - adapting calendar
	 * @param timeZone
	 *            - client time zone
	 * @return adapt calendar to client time zone
	 */
	public static Calendar convertToLocalTime(final Calendar calendar, final TimeZone timeZone) {
		Calendar ret = new GregorianCalendar(timeZone);
		ret.setTimeInMillis(calendar.getTimeInMillis()
				+ -timeZone.getOffset(calendar.getTimeInMillis())
				+ TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
		ret.getTime();
		return ret;
	}

	/**
	 * Convert to Local TimeZone
	 * 
	 * @param cal
	 * @return Calendar
	 */
	public static Calendar convertToLocalTimeZoner(final Calendar cal) {
		Date date = cal.getTime();
		TimeZone tz = cal.getTimeZone();

		// Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
		long msFromEpochGmt = date.getTime();

		// gives you the current offset in ms from GMT at the current date
		int offsetFromUTC = tz.getOffset(msFromEpochGmt);

		// create a new calendar in GMT timezone, set to this date and add the offset
		Calendar gmtCal = Calendar.getInstance(TimeZone.getDefault());
		gmtCal.setTime(date);
		gmtCal.add(Calendar.MILLISECOND, offsetFromUTC);
		gmtCal.getTime();

		return gmtCal;

	}

	/**
	 * NOTE: this method may cause locale conflict since this always use
	 * server's local settings. Please use method dateToString(Date, String,
	 * Locale) instead when format contains element that is locally sensitive
	 * (for example: E, MMM, etc).
	 * 
	 * @param date
	 *            type Date
	 * @format format. Ex: yyyy/mm/dd; HH:mm:ss
	 * @return String
	 */
	public static String date2String(Date date, String format) {
		SimpleDateFormat simpleDateFormat = null;

		if (null == date) {
			return StringPool.BLANK;
		}
		simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * 
	 * @param date
	 *            type Date
	 * @format format. Ex: yyyy/mm/dd; HH:mm:ss
	 * @param locale
	 *            the local setting of the format
	 * @return String
	 */
	public static String date2String(Date date, String format, Locale locale) {
		return date2String(date, format, Locale.getDefault());
	}

	/**
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static Date string2Date(String str, String pattern) {
		return string2Date(str, pattern, Locale.getDefault());
	}

	/**
	 * @param str
	 * @param pattern
	 * @param locale
	 * @return
	 */
	public static Date string2Date(String str, String pattern, Locale locale) {

		if (null == str || null == pattern || null == locale) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		Date date;
		ParsePosition pos = new ParsePosition(0);
		date = sdf.parse(str, pos);
		return date;
	}

	public static int getCurrentYear() {
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.MONTH);
	}

	public static String getStartDateOfMonth(int month, int year) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DATE, 1);

		date = cal.getTime();
		return DateUtils.date2String(date, CommonConstants.DATE_FORMET_EN);
	}

	public static String getEndDateOfMonth(int month, int year) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

		date = cal.getTime();
		return DateUtils.date2String(date, CommonConstants.DATE_FORMET_EN);
	}

	public static Date getStartDateOfWeek(String startDate, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(string2Date(startDate, format));
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	
	public static Date getEndDateOfWeek(String endDate, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(string2Date(endDate, format));
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		return cal.getTime();
	}
	
	/**
	 * Get start date of week of year
	 * @param weekOfYear
	 * @param year
	 * @return
	 */
	public static String getStartDateOfWeek(int weekOfYear, int year) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		date = cal.getTime();
		return DateUtils.date2String(date, CommonConstants.DATE_FORMET_EN);
	}
	
	/**
	 * Get end date of week of year
	 * @param weekOfYear
	 * @param year
	 * @return
	 */
	public static String getEndDateOfWeek(int weekOfYear, int year) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

		date = cal.getTime();
		return DateUtils.date2String(date, CommonConstants.DATE_FORMET_EN);
	}
	
	/**
	 * Get current week
	 * @return
	 */
	public static int getCurrentWeek() {
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * Get current week
	 * @return
	 */
	public static int getWeekonYear(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @param format
	 * @return
	 */
	public static String date2String(int day, int month, int year, String format) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
		date = cal.getTime();
		return DateUtils.date2String(date, format);
	}
	
	/**
	 * 
	 * @param dayStr
	 * @param monthStr
	 * @param yearStr
	 * @param format
	 * @return
	 */
	public static String date2String(String dayStr, String monthStr, String yearStr, String format) {
		int day = Integer.parseInt(dayStr);
		int month = Integer.parseInt(monthStr) + 1;
		int year = Integer.parseInt(yearStr);
		return date2String(day, month, year, format);
	}
	
	/**
	 * 
	 * @param dayStr
	 * @param monthStr
	 * @param yearStr
	 * @return
	 */
	public static Date convert2Date(String dayStr, String monthStr, String yearStr) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		int day = Integer.parseInt(dayStr);
		int month = Integer.parseInt(monthStr) + 1;
		int year = Integer.parseInt(yearStr);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
		date = cal.getTime();
		return date;
	}
}
