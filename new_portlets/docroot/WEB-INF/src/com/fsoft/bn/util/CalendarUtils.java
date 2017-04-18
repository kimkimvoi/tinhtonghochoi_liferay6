package com.fsoft.bn.util;

import java.util.Calendar;
import java.util.Date;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.Time;

public class CalendarUtils extends CalendarUtil {
	
	public static long getTimeInMillis(Date date) {
		Calendar cal = CalendarFactoryUtil.getCalendar();

		cal.setTime(date);

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		int hour = 0;
		int minute = 0;
		int second = 0;

		cal.set(year, month, day, hour, minute, second);

		long millis = cal.getTimeInMillis() / Time.DAY;

		return millis;
	}
}
