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

package com.fsoft.bn.model.impl;


/**
 * The extended model implementation for the InvestmentProjects service.
 * Represents a row in the &quot;BN_InvestmentProjects&quot; database table,
 * with each column mapped to a property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.fsoft.bn.model.InvestmentProjects} interface.
 * </p>
 * 
 * @author FSOFT
 */
public class InvestmentProjectsImpl extends InvestmentProjectsBaseImpl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this class directly. All methods that expect a investment
	 * projects model instance should use the {@link
	 * com.fsoft.bn.model.InvestmentProjects} interface instead.
	 */
	public InvestmentProjectsImpl() {
	}

	public String investAmountMinDisplay;
	public String investAmountMaxDisplay;
	public String charterCapitalDisplay;
	public String timeStartDisplay;
	public String timeEndDisplay;
	public String editAction;
	public String startDay;
	public String startMonth;
	public String startYear;
	public String endDay;
	public String endMonth;
	public String endYear;
	public String categoryDisplay;
	
	/**
	 * @return the categoryDisplay
	 */
	public String getCategoryDisplay() {
		return categoryDisplay;
	}

	/**
	 * @param categoryDisplay the categoryDisplay to set
	 */
	public void setCategoryDisplay(String categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
	}

	/**
	 * @return the investAmountMinDisplay
	 */
	public String getInvestAmountMinDisplay() {
		return investAmountMinDisplay;
	}

	/**
	 * @param investAmountMinDisplay
	 *            the investAmountMinDisplay to set
	 */
	public void setInvestAmountMinDisplay(String investAmountMinDisplay) {
		this.investAmountMinDisplay = investAmountMinDisplay;
	}

	/**
	 * @return the investAmountMaxDisplay
	 */
	public String getInvestAmountMaxDisplay() {
		return investAmountMaxDisplay;
	}

	/**
	 * @param investAmountMaxDisplay
	 *            the investAmountMaxDisplay to set
	 */
	public void setInvestAmountMaxDisplay(String investAmountMaxDisplay) {
		this.investAmountMaxDisplay = investAmountMaxDisplay;
	}

	/**
	 * @return the charterCapitalDisplay
	 */
	public String getCharterCapitalDisplay() {
		return charterCapitalDisplay;
	}

	/**
	 * @param charterCapitalDisplay
	 *            the charterCapitalDisplay to set
	 */
	public void setCharterCapitalDisplay(String charterCapitalDisplay) {
		this.charterCapitalDisplay = charterCapitalDisplay;
	}

	/**
	 * @return the timeStartDisplay
	 */
	public String getTimeStartDisplay() {
		return timeStartDisplay;
	}

	/**
	 * @param timeStartDisplay
	 *            the timeStartDisplay to set
	 */
	public void setTimeStartDisplay(String timeStartDisplay) {
		this.timeStartDisplay = timeStartDisplay;
	}

	/**
	 * @return the timeEndDisplay
	 */
	public String getTimeEndDisplay() {
		return timeEndDisplay;
	}

	/**
	 * @param timeEndDisplay
	 *            the timeEndDisplay to set
	 */
	public void setTimeEndDisplay(String timeEndDisplay) {
		this.timeEndDisplay = timeEndDisplay;
	}

	public String getEditAction() {
		return editAction;
	}

	public void setEditAction(String editAction) {
		this.editAction = editAction;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

}