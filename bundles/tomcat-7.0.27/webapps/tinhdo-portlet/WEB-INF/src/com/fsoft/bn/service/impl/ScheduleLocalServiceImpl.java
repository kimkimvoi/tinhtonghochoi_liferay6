/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.fsoft.bn.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.ScheduleModel;
import com.fsoft.bn.domain.UserScheduleModel;
import com.fsoft.bn.domain.WeekScheduleModel;
import com.fsoft.bn.model.Schedule;
import com.fsoft.bn.model.UserSchedule;
import com.fsoft.bn.model.impl.UserScheduleImpl;
import com.fsoft.bn.service.ScheduleLocalServiceUtil;
import com.fsoft.bn.service.UserScheduleLocalServiceUtil;
import com.fsoft.bn.service.base.ScheduleLocalServiceBaseImpl;
import com.fsoft.bn.service.persistence.ScheduleFinderUtil;
import com.fsoft.bn.service.persistence.ScheduleUtil;
import com.fsoft.bn.service.persistence.UserScheduleUtil;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;

/**
 * The implementation of the schedule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsoft.bn.service.ScheduleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see com.fsoft.bn.service.base.ScheduleLocalServiceBaseImpl
 * @see com.fsoft.bn.service.ScheduleLocalServiceUtil
 */
public class ScheduleLocalServiceImpl extends ScheduleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.fsoft.bn.service.ScheduleLocalServiceUtil} to access the schedule local service.
	 */
	/**
	 * Get schedules
	 * @author KienNN
	 */
	public List<ScheduleModel> getScheduleBy(int month, int year, Locale locale) throws Exception {
		
		String startDate = DateUtils.getStartDateOfMonth(month, year);
		String endDate = DateUtils.getEndDateOfMonth(month, year);

		List<ScheduleModel> calendar = buildWeekSchedule(startDate, endDate, year, locale, month);
		List<UserScheduleModel> users = ScheduleFinderUtil.findActiveUserSchedule();
		List<Schedule> schedules = ScheduleUtil.findAll();
		
		bindScheduleToCalendar(users, calendar, schedules, locale);
		return calendar;
	}
	
	/**
	 * Get month schedules by user
	 * @author KienNN
	 */
	public List<ScheduleModel> getScheduleBy(String userId, int month, int year, Locale locale) throws Exception {
		
		String startDate = DateUtils.getStartDateOfMonth(month, year);
		String endDate = DateUtils.getEndDateOfMonth(month, year);

		List<ScheduleModel> calendar = buildWeekSchedule(startDate, endDate, year, locale, month);
		List<UserScheduleModel> users = new ArrayList<UserScheduleModel>();
		if (Validator.isBlankOrNull(userId)) {
			users = ScheduleFinderUtil.findActiveUserSchedule();
		} else {
			users = ScheduleFinderUtil.findActiveUserSchedule(Long.parseLong(userId));
		}
		List<Schedule> schedules = ScheduleUtil.findAll();
		
		bindScheduleToCalendar(users, calendar, schedules, locale);
		return calendar;
	}
	
	/**
	 * Get Schedules by weekOfYear
	 * Support Schedulel portlet: View by Current Week
	 * @author KienNN
	 */
	public List<ScheduleModel> getWeekScheduleBy(int weekOfYear, int month, int year, Locale locale) throws Exception {
		
		String startDate = DateUtils.getStartDateOfWeek(weekOfYear, year);
		String endDate = DateUtils.getEndDateOfWeek(weekOfYear, year);

		List<ScheduleModel> calendar = buildWeekSchedule(startDate, endDate, year, locale, month);
		List<UserScheduleModel> users = ScheduleFinderUtil.findActiveUserSchedule();
		List<Schedule> schedules = ScheduleUtil.findAll();
		
		bindScheduleToCalendar(users, calendar, schedules, locale);
		return calendar;
	}
	
	/**
	 * get list schedule by userId and date
	 * @param userId
	 * @param date
	 * @return
	 * @throws SystemException 
	 */
	public void deleteSchedule(String userId, Date date) throws SystemException {
		List<Schedule> lst = ScheduleFinderUtil.findSchedule(userId, date);
		for (Schedule s : lst) {
			ScheduleLocalServiceUtil.deleteSchedule(s);
		}
	}
	
	/**
	 * Build weekly schedule
	 * @param startDate
	 * @param endDate
	 * @param year
	 * @param locale
	 * @param month
	 * @return
	 */
	private List<ScheduleModel> buildWeekSchedule(String startDate, String endDate, int year, Locale locale, int month) {
		List<ScheduleModel> retVal = new ArrayList<ScheduleModel>();
		List<ScheduleModel> weekList = new ArrayList<ScheduleModel>();
		ScheduleModel schedule;
		
		Date weekStartDate = DateUtils.getStartDateOfWeek(startDate, CommonConstants.DATE_FORMET_EN);
		Date weekEndDate = DateUtils.getStartDateOfWeek(endDate, CommonConstants.DATE_FORMET_EN);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(weekStartDate);
		
		while (true) {
			
			if (cal.getTime().after(weekEndDate)) {
				break;
			}
			
			schedule = new ScheduleModel();
			schedule.setWeekOfYear(cal.get(Calendar.WEEK_OF_YEAR));
			schedule.setStartDate(DateUtils.date2String(cal.getTime(), LanguageUtil.get(locale, CommonConstants.scheduleTitleDateFormat)));
			// User name column header
			schedule.getWeekScheduleHeader().add(StringPool.BLANK);
			// Monday column header
			schedule.getWeekScheduleHeader().add(LanguageUtil.get(locale, CommonConstants.scheduleListHeaderKeys[1]) + CommonConstants.HTML_NEW_LINE + DateUtils.date2String(cal.getTime(), LanguageUtil.get(locale, CommonConstants.scheduleHeaderDateFormat)));
			// Schedule for: TUE, WED, THU, FRI
			for (int i = 0; i < CommonConstants.NUM_4; i++) {
				cal.add(Calendar.DATE, CommonConstants.NUM_1);
				schedule.getWeekScheduleHeader().add(LanguageUtil.get(locale, CommonConstants.scheduleListHeaderKeys[i + 2]) + CommonConstants.HTML_NEW_LINE + DateUtils.date2String(cal.getTime(), LanguageUtil.get(locale, CommonConstants.scheduleHeaderDateFormat)));
			}
			schedule.setEndDate(DateUtils.date2String(cal.getTime(), LanguageUtil.get(locale, CommonConstants.scheduleTitleDateFormat)));
			schedule.setSchedule(new ArrayList<WeekScheduleModel>());
			// Set weekly schedule title
			StringBuffer title = new StringBuffer();
			title.append(LanguageUtil.get(locale, "portlet.schedule.weektitle") + CommonConstants.SPACE);
			title.append(schedule.getWeekOfYear());
			title.append(LanguageUtil.get(locale, "portlet.schedule.weeksuffix") + CommonConstants.SPACE);
			title.append("(" + LanguageUtil.get(locale, "portlet.schedule.weekstart") + CommonConstants.SPACE);
			title.append(schedule.getStartDate() + " - ");
			title.append(schedule.getEndDate() + "):");
			schedule.setWeekScheduleTitle(title.toString());
			
			weekList.add(schedule);
			//Add more for SAT, SUN
			cal.add(Calendar.DATE, CommonConstants.NUM_3);
		}
		
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		Date startDateOfWeek = new Date();
		Date endDateOfWeek = new Date();
		
		startCal.setTime(weekStartDate);
		endCal.setTime(weekEndDate);
		// Sort EST and remove week that does not in month
		for (int i = weekList.size(); i > 0; i--) {
			startDateOfWeek = DateUtils.string2Date(weekList.get(i - 1).getStartDate(), LanguageUtil.get(locale, CommonConstants.scheduleTitleDateFormat), locale);
			endDateOfWeek = DateUtils.string2Date(weekList.get(i - 1).getEndDate(), LanguageUtil.get(locale, CommonConstants.scheduleTitleDateFormat), locale);
			startCal.setTime(startDateOfWeek);
			endCal.setTime(endDateOfWeek);
			if (startCal.get(Calendar.MONTH) != month && endCal.get(Calendar.MONTH) != month) {
				continue;
			}
			retVal.add(weekList.get(i - 1));
		}
		
		return retVal;
 	}

	public int getCurrentMonth(){
		return DateUtils.getCurrentMonth();
	}
	
	public int getCurrentYear(){
		return DateUtils.getCurrentYear();
	}
	
	/**
	 * get 12 months value
	 * @return
	 */
	public List<DataDictionary> getMounths(){
		List<DataDictionary> retVal = new ArrayList<DataDictionary>();
		DataDictionary m;
		for(int i = 1; i <= 12; i++) {
			m = new DataDictionary(i - CommonConstants.NUM_1, String.valueOf(i));
			retVal.add(m);
		}
		return retVal;
	}
	
	/**
	 * get last 10 years
	 * @return
	 */
	public List<DataDictionary> getYears(){
		List<DataDictionary> retVal = new ArrayList<DataDictionary>();
		int currentYear = DateUtils.getCurrentYear();
		
		DataDictionary m;
		for(int i = 0; i < 10; i++) {
			m = new DataDictionary(currentYear, String.valueOf(currentYear));
			currentYear--;
			retVal.add(m);
		}
		return retVal;
	}
	
	/**
	 * 
	 * @param users
	 * @param calendar
	 * @param schedules
	 */
	private void bindScheduleToCalendar(List<UserScheduleModel> users,
			List<ScheduleModel> calendar, List<Schedule> schedules, Locale locale) {
		
		WeekScheduleModel scheduleModel;
		for (ScheduleModel cal : calendar) {
			if (null == cal.getSchedule()) {
				cal.setSchedule(new ArrayList<WeekScheduleModel>());
			}
			
			for (UserScheduleModel userSchedule : users) {
				scheduleModel = new WeekScheduleModel();
				scheduleModel.setUserName(userSchedule.getJobTitleName() + "<br>" + userSchedule.getUserName());
				
				Calendar c = Calendar.getInstance();
				Date date = DateUtils.string2Date(cal.getStartDate(), LanguageUtil.get(locale, CommonConstants.scheduleTitleDateFormat));
				c.setTime(date);
				
				scheduleModel.setMonday(getSchedule(userSchedule.getUserId(), c.getTime(), schedules));
				c.add(Calendar.DATE, CommonConstants.NUM_1);
				scheduleModel.setTuesday(getSchedule(userSchedule.getUserId(), c.getTime(), schedules));
				c.add(Calendar.DATE, CommonConstants.NUM_1);
				scheduleModel.setWednesday(getSchedule(userSchedule.getUserId(), c.getTime(), schedules));
				c.add(Calendar.DATE, CommonConstants.NUM_1);
				scheduleModel.setThursday(getSchedule(userSchedule.getUserId(), c.getTime(), schedules));
				c.add(Calendar.DATE, CommonConstants.NUM_1);
				scheduleModel.setFriday(getSchedule(userSchedule.getUserId(), c.getTime(), schedules));
				c.add(Calendar.DATE, CommonConstants.NUM_1);
				
				cal.getSchedule().add(scheduleModel);
			}
			
		}
		
	}

	/**
	 * 
	 * @param userId
	 * @param time
	 * @param schedules
	 * @return
	 */
	private String getSchedule(String userId, Date time, List<Schedule> schedules) {
		if (Validator.isBlankOrNull(userId)) {
			return StringPool.BLANK;
		}
		String retVal = StringPool.BLANK;
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		Calendar sche = Calendar.getInstance();
		
		for (Schedule s : schedules) {
			sche.setTime(s.getSchedule_date());
			if (userId.equalsIgnoreCase(s.getUser_id()) && 
					DateUtils.date2String(cal.getTime(), CommonConstants.DATE_FORMET_EN).equalsIgnoreCase(DateUtils.date2String(sche.getTime(), CommonConstants.DATE_FORMET_EN))) {

				retVal = s.getContent();
				break;
			}
		}
		
		return retVal;
	}
	
	/**
	 * Get active users for schedule - admin
	 * @return
	 * @throws Exception
	 */
	public List<UserScheduleModel> getUserSchedules() throws Exception {
		OrderByComparator order = OrderByComparatorFactoryUtil.create("USER_", "firstName", "middleName", "lastName" ,true);
		List<User> allUsers = UserUtil.findAll(-1, -1, order);
		List<UserSchedule> userScheduleList = UserScheduleUtil.findAll();
		
		List<UserScheduleModel> retVal = new ArrayList<UserScheduleModel>();
		UserScheduleModel us;
		for(User user : allUsers) {
				us = new UserScheduleModel();
				us.setUserId(String.valueOf(user.getUserId()));
				us.setJobTitleName(user.getJobTitle());
				us.setUserName(user.getFirstName() + CommonConstants.SPACE + user.getMiddleName() + CommonConstants.SPACE + user.getLastName());
				us.setDisplaySchedule(false);
				for (UserSchedule s : userScheduleList) {
					if (s.getUser_id().equalsIgnoreCase(us.getUserId())) {
						us.setDisplaySchedule(true);
						break;
					}
				}
				retVal.add(us);
		}
		return retVal;
	}
	
	/**
	 * Get active users for schedule from @start to @end
	 * @author Kien
	 * @return List<UserScheduleModel>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UserScheduleModel> getUserSchedules(int start, int end, String keyword) throws Exception {
		//get all users
		List<User> allUsers = getAllUsersOrderBy(start, end, keyword);
		
		//get schedule users
		List<UserSchedule> userScheduleList = UserScheduleUtil.findAll();
		
		List<UserScheduleModel> retVal = new ArrayList<UserScheduleModel>();
		UserScheduleModel us;
		for(User user : allUsers) {
				us = new UserScheduleModel();
				us.setUserId(String.valueOf(user.getUserId()));
				us.setJobTitleName(user.getJobTitle());
				us.setUserName(user.getFirstName() + CommonConstants.SPACE + user.getMiddleName() + CommonConstants.SPACE + user.getLastName());
				us.setDisplaySchedule(false);
				for (UserSchedule s : userScheduleList) {
					if (s.getUser_id().equalsIgnoreCase(us.getUserId())) {
						us.setDisplaySchedule(true);
						break;
					}
				}
				retVal.add(us);
		}
		return retVal;
	}

	/**
	 * @param start
	 * @param end
	 * @param keyword
	 * @return
	 * @throws SystemException
	 */
	@SuppressWarnings("unchecked")
	private List<User> getAllUsersOrderBy(int start, int end, String keyword)
			throws SystemException {
		List<User> allUsers = new ArrayList<User>();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
		OrderByComparator order = OrderByComparatorFactoryUtil.create("USER_", "firstName", "middleName", "lastName" ,true);

		if (null != keyword && !StringUtils.isBlank(keyword)) {
			String key = "%"+keyword.trim()+"%";
			Junction junction = RestrictionsFactoryUtil.disjunction();
			junction.add(RestrictionsFactoryUtil.ilike("firstName", key))
					.add(RestrictionsFactoryUtil.ilike("lastName", key))
					.add(RestrictionsFactoryUtil.ilike("middleName", key))
					.add(RestrictionsFactoryUtil.ilike("jobTitle", key));
			dynamicQuery.add(junction);
			allUsers.addAll(UserLocalServiceUtil.dynamicQuery(dynamicQuery, start, end, order));
			Set<User> set = new HashSet<User>(allUsers);
			allUsers =  new ArrayList<User>(set);
		} else {
			allUsers = UserLocalServiceUtil.dynamicQuery(dynamicQuery, start, end, order);
		}
		return allUsers;
	}
	
	/**
	 * Count total users for schedule
	 * @author Kien
	 * @return int
	 * @throws Exception
	 */
	public int countUserSchedules(String keyword) throws Exception {
		//get all users
		List<User> allUsers = getAllUsersOrderBy(-1, -1, keyword);
		return allUsers.size();
	}
	
	/**
	 * Update user schedule
	 * @param userIDs
	 * @throws Exception
	 */
	public void allowDisplaySchedule(String[] userIDs) throws Exception {
		List<UserSchedule> allUsers = UserScheduleUtil.findAll();
		for (UserSchedule userSchedule : allUsers) {
			UserScheduleLocalServiceUtil.deleteUserSchedule(userSchedule);
		}
		
		for (String userId : userIDs) {
			if (!StringUtils.isNumeric(userId)) {
				continue;
			}
			UserSchedule userSchedule = new UserScheduleImpl();
			userSchedule.setUser_id(userId);
			userSchedule.setCreated_date(new Date());
			userSchedule.setDeleted(false);
			UserScheduleLocalServiceUtil.addUserSchedule(userSchedule);
		}
	}
	
}


