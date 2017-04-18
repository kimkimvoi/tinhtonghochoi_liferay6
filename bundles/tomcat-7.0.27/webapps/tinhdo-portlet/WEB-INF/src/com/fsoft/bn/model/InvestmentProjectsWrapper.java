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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link InvestmentProjects}.
 * </p>
 *
 * @author    FSOFT
 * @see       InvestmentProjects
 * @generated
 */
public class InvestmentProjectsWrapper implements InvestmentProjects,
	ModelWrapper<InvestmentProjects> {
	public InvestmentProjectsWrapper(InvestmentProjects investmentProjects) {
		_investmentProjects = investmentProjects;
	}

	public Class<?> getModelClass() {
		return InvestmentProjects.class;
	}

	public String getModelClassName() {
		return InvestmentProjects.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("project_id", getProject_id());
		attributes.put("project_name", getProject_name());
		attributes.put("total_investment_min", getTotal_investment_min());
		attributes.put("total_investment_max", getTotal_investment_max());
		attributes.put("implementation_location", getImplementation_location());
		attributes.put("start_time", getStart_time());
		attributes.put("end_time", getEnd_time());
		attributes.put("project_purpose", getProject_purpose());
		attributes.put("charter_capital", getCharter_capital());
		attributes.put("project_category_id", getProject_category_id());
		attributes.put("project_status_id", getProject_status_id());
		attributes.put("investment_form_id", getInvestment_form_id());
		attributes.put("competent_organization_id",
			getCompetent_organization_id());
		attributes.put("key_project", getKey_project());
		attributes.put("technical_specifications", getTechnical_specifications());
		attributes.put("currency_type_id", getCurrency_type_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String project_id = (String)attributes.get("project_id");

		if (project_id != null) {
			setProject_id(project_id);
		}

		String project_name = (String)attributes.get("project_name");

		if (project_name != null) {
			setProject_name(project_name);
		}

		String total_investment_min = (String)attributes.get(
				"total_investment_min");

		if (total_investment_min != null) {
			setTotal_investment_min(total_investment_min);
		}

		String total_investment_max = (String)attributes.get(
				"total_investment_max");

		if (total_investment_max != null) {
			setTotal_investment_max(total_investment_max);
		}

		String implementation_location = (String)attributes.get(
				"implementation_location");

		if (implementation_location != null) {
			setImplementation_location(implementation_location);
		}

		Date start_time = (Date)attributes.get("start_time");

		if (start_time != null) {
			setStart_time(start_time);
		}

		Date end_time = (Date)attributes.get("end_time");

		if (end_time != null) {
			setEnd_time(end_time);
		}

		String project_purpose = (String)attributes.get("project_purpose");

		if (project_purpose != null) {
			setProject_purpose(project_purpose);
		}

		String charter_capital = (String)attributes.get("charter_capital");

		if (charter_capital != null) {
			setCharter_capital(charter_capital);
		}

		String project_category_id = (String)attributes.get(
				"project_category_id");

		if (project_category_id != null) {
			setProject_category_id(project_category_id);
		}

		String project_status_id = (String)attributes.get("project_status_id");

		if (project_status_id != null) {
			setProject_status_id(project_status_id);
		}

		String investment_form_id = (String)attributes.get("investment_form_id");

		if (investment_form_id != null) {
			setInvestment_form_id(investment_form_id);
		}

		String competent_organization_id = (String)attributes.get(
				"competent_organization_id");

		if (competent_organization_id != null) {
			setCompetent_organization_id(competent_organization_id);
		}

		Boolean key_project = (Boolean)attributes.get("key_project");

		if (key_project != null) {
			setKey_project(key_project);
		}

		String technical_specifications = (String)attributes.get(
				"technical_specifications");

		if (technical_specifications != null) {
			setTechnical_specifications(technical_specifications);
		}

		String currency_type_id = (String)attributes.get("currency_type_id");

		if (currency_type_id != null) {
			setCurrency_type_id(currency_type_id);
		}

		Date created_date = (Date)attributes.get("created_date");

		if (created_date != null) {
			setCreated_date(created_date);
		}

		Date modified_date = (Date)attributes.get("modified_date");

		if (modified_date != null) {
			setModified_date(modified_date);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	* Returns the primary key of this investment projects.
	*
	* @return the primary key of this investment projects
	*/
	public java.lang.String getPrimaryKey() {
		return _investmentProjects.getPrimaryKey();
	}

	/**
	* Sets the primary key of this investment projects.
	*
	* @param primaryKey the primary key of this investment projects
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_investmentProjects.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project_id of this investment projects.
	*
	* @return the project_id of this investment projects
	*/
	public java.lang.String getProject_id() {
		return _investmentProjects.getProject_id();
	}

	/**
	* Sets the project_id of this investment projects.
	*
	* @param project_id the project_id of this investment projects
	*/
	public void setProject_id(java.lang.String project_id) {
		_investmentProjects.setProject_id(project_id);
	}

	/**
	* Returns the project_name of this investment projects.
	*
	* @return the project_name of this investment projects
	*/
	public java.lang.String getProject_name() {
		return _investmentProjects.getProject_name();
	}

	/**
	* Sets the project_name of this investment projects.
	*
	* @param project_name the project_name of this investment projects
	*/
	public void setProject_name(java.lang.String project_name) {
		_investmentProjects.setProject_name(project_name);
	}

	/**
	* Returns the total_investment_min of this investment projects.
	*
	* @return the total_investment_min of this investment projects
	*/
	public java.lang.String getTotal_investment_min() {
		return _investmentProjects.getTotal_investment_min();
	}

	/**
	* Sets the total_investment_min of this investment projects.
	*
	* @param total_investment_min the total_investment_min of this investment projects
	*/
	public void setTotal_investment_min(java.lang.String total_investment_min) {
		_investmentProjects.setTotal_investment_min(total_investment_min);
	}

	/**
	* Returns the total_investment_max of this investment projects.
	*
	* @return the total_investment_max of this investment projects
	*/
	public java.lang.String getTotal_investment_max() {
		return _investmentProjects.getTotal_investment_max();
	}

	/**
	* Sets the total_investment_max of this investment projects.
	*
	* @param total_investment_max the total_investment_max of this investment projects
	*/
	public void setTotal_investment_max(java.lang.String total_investment_max) {
		_investmentProjects.setTotal_investment_max(total_investment_max);
	}

	/**
	* Returns the implementation_location of this investment projects.
	*
	* @return the implementation_location of this investment projects
	*/
	public java.lang.String getImplementation_location() {
		return _investmentProjects.getImplementation_location();
	}

	/**
	* Sets the implementation_location of this investment projects.
	*
	* @param implementation_location the implementation_location of this investment projects
	*/
	public void setImplementation_location(
		java.lang.String implementation_location) {
		_investmentProjects.setImplementation_location(implementation_location);
	}

	/**
	* Returns the start_time of this investment projects.
	*
	* @return the start_time of this investment projects
	*/
	public java.util.Date getStart_time() {
		return _investmentProjects.getStart_time();
	}

	/**
	* Sets the start_time of this investment projects.
	*
	* @param start_time the start_time of this investment projects
	*/
	public void setStart_time(java.util.Date start_time) {
		_investmentProjects.setStart_time(start_time);
	}

	/**
	* Returns the end_time of this investment projects.
	*
	* @return the end_time of this investment projects
	*/
	public java.util.Date getEnd_time() {
		return _investmentProjects.getEnd_time();
	}

	/**
	* Sets the end_time of this investment projects.
	*
	* @param end_time the end_time of this investment projects
	*/
	public void setEnd_time(java.util.Date end_time) {
		_investmentProjects.setEnd_time(end_time);
	}

	/**
	* Returns the project_purpose of this investment projects.
	*
	* @return the project_purpose of this investment projects
	*/
	public java.lang.String getProject_purpose() {
		return _investmentProjects.getProject_purpose();
	}

	/**
	* Sets the project_purpose of this investment projects.
	*
	* @param project_purpose the project_purpose of this investment projects
	*/
	public void setProject_purpose(java.lang.String project_purpose) {
		_investmentProjects.setProject_purpose(project_purpose);
	}

	/**
	* Returns the charter_capital of this investment projects.
	*
	* @return the charter_capital of this investment projects
	*/
	public java.lang.String getCharter_capital() {
		return _investmentProjects.getCharter_capital();
	}

	/**
	* Sets the charter_capital of this investment projects.
	*
	* @param charter_capital the charter_capital of this investment projects
	*/
	public void setCharter_capital(java.lang.String charter_capital) {
		_investmentProjects.setCharter_capital(charter_capital);
	}

	/**
	* Returns the project_category_id of this investment projects.
	*
	* @return the project_category_id of this investment projects
	*/
	public java.lang.String getProject_category_id() {
		return _investmentProjects.getProject_category_id();
	}

	/**
	* Sets the project_category_id of this investment projects.
	*
	* @param project_category_id the project_category_id of this investment projects
	*/
	public void setProject_category_id(java.lang.String project_category_id) {
		_investmentProjects.setProject_category_id(project_category_id);
	}

	/**
	* Returns the project_status_id of this investment projects.
	*
	* @return the project_status_id of this investment projects
	*/
	public java.lang.String getProject_status_id() {
		return _investmentProjects.getProject_status_id();
	}

	/**
	* Sets the project_status_id of this investment projects.
	*
	* @param project_status_id the project_status_id of this investment projects
	*/
	public void setProject_status_id(java.lang.String project_status_id) {
		_investmentProjects.setProject_status_id(project_status_id);
	}

	/**
	* Returns the investment_form_id of this investment projects.
	*
	* @return the investment_form_id of this investment projects
	*/
	public java.lang.String getInvestment_form_id() {
		return _investmentProjects.getInvestment_form_id();
	}

	/**
	* Sets the investment_form_id of this investment projects.
	*
	* @param investment_form_id the investment_form_id of this investment projects
	*/
	public void setInvestment_form_id(java.lang.String investment_form_id) {
		_investmentProjects.setInvestment_form_id(investment_form_id);
	}

	/**
	* Returns the competent_organization_id of this investment projects.
	*
	* @return the competent_organization_id of this investment projects
	*/
	public java.lang.String getCompetent_organization_id() {
		return _investmentProjects.getCompetent_organization_id();
	}

	/**
	* Sets the competent_organization_id of this investment projects.
	*
	* @param competent_organization_id the competent_organization_id of this investment projects
	*/
	public void setCompetent_organization_id(
		java.lang.String competent_organization_id) {
		_investmentProjects.setCompetent_organization_id(competent_organization_id);
	}

	/**
	* Returns the key_project of this investment projects.
	*
	* @return the key_project of this investment projects
	*/
	public boolean getKey_project() {
		return _investmentProjects.getKey_project();
	}

	/**
	* Returns <code>true</code> if this investment projects is key_project.
	*
	* @return <code>true</code> if this investment projects is key_project; <code>false</code> otherwise
	*/
	public boolean isKey_project() {
		return _investmentProjects.isKey_project();
	}

	/**
	* Sets whether this investment projects is key_project.
	*
	* @param key_project the key_project of this investment projects
	*/
	public void setKey_project(boolean key_project) {
		_investmentProjects.setKey_project(key_project);
	}

	/**
	* Returns the technical_specifications of this investment projects.
	*
	* @return the technical_specifications of this investment projects
	*/
	public java.lang.String getTechnical_specifications() {
		return _investmentProjects.getTechnical_specifications();
	}

	/**
	* Sets the technical_specifications of this investment projects.
	*
	* @param technical_specifications the technical_specifications of this investment projects
	*/
	public void setTechnical_specifications(
		java.lang.String technical_specifications) {
		_investmentProjects.setTechnical_specifications(technical_specifications);
	}

	/**
	* Returns the currency_type_id of this investment projects.
	*
	* @return the currency_type_id of this investment projects
	*/
	public java.lang.String getCurrency_type_id() {
		return _investmentProjects.getCurrency_type_id();
	}

	/**
	* Sets the currency_type_id of this investment projects.
	*
	* @param currency_type_id the currency_type_id of this investment projects
	*/
	public void setCurrency_type_id(java.lang.String currency_type_id) {
		_investmentProjects.setCurrency_type_id(currency_type_id);
	}

	/**
	* Returns the created_date of this investment projects.
	*
	* @return the created_date of this investment projects
	*/
	public java.util.Date getCreated_date() {
		return _investmentProjects.getCreated_date();
	}

	/**
	* Sets the created_date of this investment projects.
	*
	* @param created_date the created_date of this investment projects
	*/
	public void setCreated_date(java.util.Date created_date) {
		_investmentProjects.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this investment projects.
	*
	* @return the modified_date of this investment projects
	*/
	public java.util.Date getModified_date() {
		return _investmentProjects.getModified_date();
	}

	/**
	* Sets the modified_date of this investment projects.
	*
	* @param modified_date the modified_date of this investment projects
	*/
	public void setModified_date(java.util.Date modified_date) {
		_investmentProjects.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this investment projects.
	*
	* @return the deleted of this investment projects
	*/
	public boolean getDeleted() {
		return _investmentProjects.getDeleted();
	}

	/**
	* Returns <code>true</code> if this investment projects is deleted.
	*
	* @return <code>true</code> if this investment projects is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _investmentProjects.isDeleted();
	}

	/**
	* Sets whether this investment projects is deleted.
	*
	* @param deleted the deleted of this investment projects
	*/
	public void setDeleted(boolean deleted) {
		_investmentProjects.setDeleted(deleted);
	}

	public boolean isNew() {
		return _investmentProjects.isNew();
	}

	public void setNew(boolean n) {
		_investmentProjects.setNew(n);
	}

	public boolean isCachedModel() {
		return _investmentProjects.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_investmentProjects.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _investmentProjects.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _investmentProjects.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_investmentProjects.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _investmentProjects.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_investmentProjects.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InvestmentProjectsWrapper((InvestmentProjects)_investmentProjects.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.InvestmentProjects investmentProjects) {
		return _investmentProjects.compareTo(investmentProjects);
	}

	@Override
	public int hashCode() {
		return _investmentProjects.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.InvestmentProjects> toCacheModel() {
		return _investmentProjects.toCacheModel();
	}

	public com.fsoft.bn.model.InvestmentProjects toEscapedModel() {
		return new InvestmentProjectsWrapper(_investmentProjects.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _investmentProjects.toString();
	}

	public java.lang.String toXmlString() {
		return _investmentProjects.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_investmentProjects.persist();
	}

	/**
	* @return the categoryDisplay
	*/
	public java.lang.String getCategoryDisplay() {
		return _investmentProjects.getCategoryDisplay();
	}

	/**
	* @param categoryDisplay the categoryDisplay to set
	*/
	public void setCategoryDisplay(java.lang.String categoryDisplay) {
		_investmentProjects.setCategoryDisplay(categoryDisplay);
	}

	/**
	* @return the investAmountMinDisplay
	*/
	public java.lang.String getInvestAmountMinDisplay() {
		return _investmentProjects.getInvestAmountMinDisplay();
	}

	/**
	* @param investAmountMinDisplay
	the investAmountMinDisplay to set
	*/
	public void setInvestAmountMinDisplay(
		java.lang.String investAmountMinDisplay) {
		_investmentProjects.setInvestAmountMinDisplay(investAmountMinDisplay);
	}

	/**
	* @return the investAmountMaxDisplay
	*/
	public java.lang.String getInvestAmountMaxDisplay() {
		return _investmentProjects.getInvestAmountMaxDisplay();
	}

	/**
	* @param investAmountMaxDisplay
	the investAmountMaxDisplay to set
	*/
	public void setInvestAmountMaxDisplay(
		java.lang.String investAmountMaxDisplay) {
		_investmentProjects.setInvestAmountMaxDisplay(investAmountMaxDisplay);
	}

	/**
	* @return the charterCapitalDisplay
	*/
	public java.lang.String getCharterCapitalDisplay() {
		return _investmentProjects.getCharterCapitalDisplay();
	}

	/**
	* @param charterCapitalDisplay
	the charterCapitalDisplay to set
	*/
	public void setCharterCapitalDisplay(java.lang.String charterCapitalDisplay) {
		_investmentProjects.setCharterCapitalDisplay(charterCapitalDisplay);
	}

	/**
	* @return the timeStartDisplay
	*/
	public java.lang.String getTimeStartDisplay() {
		return _investmentProjects.getTimeStartDisplay();
	}

	/**
	* @param timeStartDisplay
	the timeStartDisplay to set
	*/
	public void setTimeStartDisplay(java.lang.String timeStartDisplay) {
		_investmentProjects.setTimeStartDisplay(timeStartDisplay);
	}

	/**
	* @return the timeEndDisplay
	*/
	public java.lang.String getTimeEndDisplay() {
		return _investmentProjects.getTimeEndDisplay();
	}

	/**
	* @param timeEndDisplay
	the timeEndDisplay to set
	*/
	public void setTimeEndDisplay(java.lang.String timeEndDisplay) {
		_investmentProjects.setTimeEndDisplay(timeEndDisplay);
	}

	public java.lang.String getEditAction() {
		return _investmentProjects.getEditAction();
	}

	public void setEditAction(java.lang.String editAction) {
		_investmentProjects.setEditAction(editAction);
	}

	public java.lang.String getStartDay() {
		return _investmentProjects.getStartDay();
	}

	public void setStartDay(java.lang.String startDay) {
		_investmentProjects.setStartDay(startDay);
	}

	public java.lang.String getStartMonth() {
		return _investmentProjects.getStartMonth();
	}

	public void setStartMonth(java.lang.String startMonth) {
		_investmentProjects.setStartMonth(startMonth);
	}

	public java.lang.String getStartYear() {
		return _investmentProjects.getStartYear();
	}

	public void setStartYear(java.lang.String startYear) {
		_investmentProjects.setStartYear(startYear);
	}

	public java.lang.String getEndDay() {
		return _investmentProjects.getEndDay();
	}

	public void setEndDay(java.lang.String endDay) {
		_investmentProjects.setEndDay(endDay);
	}

	public java.lang.String getEndMonth() {
		return _investmentProjects.getEndMonth();
	}

	public void setEndMonth(java.lang.String endMonth) {
		_investmentProjects.setEndMonth(endMonth);
	}

	public java.lang.String getEndYear() {
		return _investmentProjects.getEndYear();
	}

	public void setEndYear(java.lang.String endYear) {
		_investmentProjects.setEndYear(endYear);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public InvestmentProjects getWrappedInvestmentProjects() {
		return _investmentProjects;
	}

	public InvestmentProjects getWrappedModel() {
		return _investmentProjects;
	}

	public void resetOriginalValues() {
		_investmentProjects.resetOriginalValues();
	}

	private InvestmentProjects _investmentProjects;
}