package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.List;

public class AdminScheduleModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<UserScheduleModel> usersSchedule;
	private List<String> userProperties;
	private ScheduleSearchModel scheduleSearch;
	private List<ScheduleModel> monthSchedule;
	private int monthOfSchedule;
	private int yearOfSchedule;
	public List<UserScheduleModel> getUsersSchedule() {
		return usersSchedule;
	}

	public void setUsersSchedule(List<UserScheduleModel> usersSchedule) {
		this.usersSchedule = usersSchedule;
	}

	public List<String> getUserProperties() {
		return userProperties;
	}

	public void setUserProperties(List<String> userProperties) {
		this.userProperties = userProperties;
	}

	public ScheduleSearchModel getScheduleSearch() {
		return scheduleSearch;
	}

	public void setScheduleSearch(ScheduleSearchModel scheduleSearch) {
		this.scheduleSearch = scheduleSearch;
	}

	public List<ScheduleModel> getMonthSchedule() {
		return monthSchedule;
	}

	public void setMonthSchedule(List<ScheduleModel> monthSchedule) {
		this.monthSchedule = monthSchedule;
	}

	public int getMonthOfSchedule() {
		return monthOfSchedule;
	}

	public void setMonthOfSchedule(int monthOfSchedule) {
		this.monthOfSchedule = monthOfSchedule;
	}

	public int getYearOfSchedule() {
		return yearOfSchedule;
	}

	public void setYearOfSchedule(int yearOfSchedule) {
		this.yearOfSchedule = yearOfSchedule;
	}

	
}
