package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.List;

public class ScheduleViewModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ScheduleModel> weekScheduleList;
	private ScheduleSearchModel searchModel;
	private List<String> displayedPropertyList;
	private String viewMode;
	private String searchCondition;
	
	public List<ScheduleModel> getWeekScheduleList() {
		return weekScheduleList;
	}
	public void setWeekScheduleList(List<ScheduleModel> weekScheduleList) {
		this.weekScheduleList = weekScheduleList;
	}
	public ScheduleSearchModel getSearchModel() {
		return searchModel;
	}
	public List<String> getDisplayedPropertyList() {
		return displayedPropertyList;
	}
	public void setDisplayedPropertyList(List<String> displayedPropertyList) {
		this.displayedPropertyList = displayedPropertyList;
	}
	public void setSearchModel(ScheduleSearchModel searchModel) {
		this.searchModel = searchModel;
	}
	public String getViewMode() {
		return viewMode;
	}
	public void setViewMode(String viewMode) {
		this.viewMode = viewMode;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
}
