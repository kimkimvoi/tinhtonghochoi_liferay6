package com.fsoft.bn.domain;

import java.io.Serializable;

public class UserScheduleModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String userName;
	private String jobTitleName;
	private boolean displaySchedule;
	
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJobTitleName() {
		return jobTitleName;
	}
	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isDisplaySchedule() {
		return displaySchedule;
	}
	public void setDisplaySchedule(boolean displaySchedule) {
		this.displaySchedule = displaySchedule;
	}
	
}
