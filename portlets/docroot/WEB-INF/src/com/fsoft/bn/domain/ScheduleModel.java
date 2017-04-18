package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScheduleModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int weekOfYear;
	private String startDate;
	private String endDate;
	private String weekScheduleTitle;
	private List<String> weekScheduleHeader;
	private List<WeekScheduleModel> schedule;
	
	public ScheduleModel() {
		this.weekScheduleHeader = new ArrayList<String>();
		this.schedule = new ArrayList<WeekScheduleModel>();
	}
	
	public int getWeekOfYear() {
		return weekOfYear;
	}

	public void setWeekOfYear(int weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<WeekScheduleModel> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<WeekScheduleModel> schedule) {
		this.schedule = schedule;
	}

	public List<String> getWeekScheduleHeader() {
		return weekScheduleHeader;
	}

	public void setWeekScheduleHeader(List<String> weekScheduleTitle) {
		this.weekScheduleHeader = weekScheduleTitle;
	}

	public String getWeekScheduleTitle() {
		return weekScheduleTitle;
	}

	public void setWeekScheduleTitle(String weekScheduleTitle) {
		this.weekScheduleTitle = weekScheduleTitle;
	}

}
