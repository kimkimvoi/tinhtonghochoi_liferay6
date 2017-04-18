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

package com.fsoft.bn.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the InvestmentProjects service. Represents a row in the &quot;BN_InvestmentProjects&quot; database table, with each column mapped to a property of this class.
 *
 * @author FSOFT
 * @see InvestmentProjectsModel
 * @see com.fsoft.bn.model.impl.InvestmentProjectsImpl
 * @see com.fsoft.bn.model.impl.InvestmentProjectsModelImpl
 * @generated
 */
public interface InvestmentProjects extends InvestmentProjectsModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.fsoft.bn.model.impl.InvestmentProjectsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* @return the categoryDisplay
	*/
	public java.lang.String getCategoryDisplay();

	/**
	* @param categoryDisplay the categoryDisplay to set
	*/
	public void setCategoryDisplay(java.lang.String categoryDisplay);

	/**
	* @return the investAmountMinDisplay
	*/
	public java.lang.String getInvestAmountMinDisplay();

	/**
	* @param investAmountMinDisplay
	the investAmountMinDisplay to set
	*/
	public void setInvestAmountMinDisplay(
		java.lang.String investAmountMinDisplay);

	/**
	* @return the investAmountMaxDisplay
	*/
	public java.lang.String getInvestAmountMaxDisplay();

	/**
	* @param investAmountMaxDisplay
	the investAmountMaxDisplay to set
	*/
	public void setInvestAmountMaxDisplay(
		java.lang.String investAmountMaxDisplay);

	/**
	* @return the charterCapitalDisplay
	*/
	public java.lang.String getCharterCapitalDisplay();

	/**
	* @param charterCapitalDisplay
	the charterCapitalDisplay to set
	*/
	public void setCharterCapitalDisplay(java.lang.String charterCapitalDisplay);

	/**
	* @return the timeStartDisplay
	*/
	public java.lang.String getTimeStartDisplay();

	/**
	* @param timeStartDisplay
	the timeStartDisplay to set
	*/
	public void setTimeStartDisplay(java.lang.String timeStartDisplay);

	/**
	* @return the timeEndDisplay
	*/
	public java.lang.String getTimeEndDisplay();

	/**
	* @param timeEndDisplay
	the timeEndDisplay to set
	*/
	public void setTimeEndDisplay(java.lang.String timeEndDisplay);

	public java.lang.String getEditAction();

	public void setEditAction(java.lang.String editAction);

	public java.lang.String getStartDay();

	public void setStartDay(java.lang.String startDay);

	public java.lang.String getStartMonth();

	public void setStartMonth(java.lang.String startMonth);

	public java.lang.String getStartYear();

	public void setStartYear(java.lang.String startYear);

	public java.lang.String getEndDay();

	public void setEndDay(java.lang.String endDay);

	public java.lang.String getEndMonth();

	public void setEndMonth(java.lang.String endMonth);

	public java.lang.String getEndYear();

	public void setEndYear(java.lang.String endYear);
}