package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.List;

public class ScheduleSearchModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<DataDictionary> months;
	private List<DataDictionary> years;
	private List<UserScheduleModel> users;
	private String selectedMonth;
	private String selectedYear;
	private String selectedUser;
	
	public List<DataDictionary> getMonths() {
		return months;
	}
	public void setMonths(List<DataDictionary> months) {
		this.months = months;
	}
	public List<DataDictionary> getYears() {
		return years;
	}
	public void setYears(List<DataDictionary> years) {
		this.years = years;
	}
	public String getSelectedMonth() {
		return selectedMonth;
	}
	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}
	public String getSelectedYear() {
		return selectedYear;
	}
	public void setSelectedYear(String selectedYear) {
		this.selectedYear = selectedYear;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<UserScheduleModel> getUsers() {
		return users;
	}
	public void setUsers(List<UserScheduleModel> users) {
		this.users = users;
	}
	public String getSelectedUser() {
		return selectedUser;
	}
	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}
}
