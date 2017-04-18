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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the InvestmentProjects service. Represents a row in the &quot;BN_InvestmentProjects&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.InvestmentProjectsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.InvestmentProjectsImpl}.
 * </p>
 *
 * @author FSOFT
 * @see InvestmentProjects
 * @see com.fsoft.bn.model.impl.InvestmentProjectsImpl
 * @see com.fsoft.bn.model.impl.InvestmentProjectsModelImpl
 * @generated
 */
public interface InvestmentProjectsModel extends BaseModel<InvestmentProjects> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a investment projects model instance should use the {@link InvestmentProjects} interface instead.
	 */

	/**
	 * Returns the primary key of this investment projects.
	 *
	 * @return the primary key of this investment projects
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this investment projects.
	 *
	 * @param primaryKey the primary key of this investment projects
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the project_id of this investment projects.
	 *
	 * @return the project_id of this investment projects
	 */
	@AutoEscape
	public String getProject_id();

	/**
	 * Sets the project_id of this investment projects.
	 *
	 * @param project_id the project_id of this investment projects
	 */
	public void setProject_id(String project_id);

	/**
	 * Returns the project_name of this investment projects.
	 *
	 * @return the project_name of this investment projects
	 */
	@AutoEscape
	public String getProject_name();

	/**
	 * Sets the project_name of this investment projects.
	 *
	 * @param project_name the project_name of this investment projects
	 */
	public void setProject_name(String project_name);

	/**
	 * Returns the total_investment_min of this investment projects.
	 *
	 * @return the total_investment_min of this investment projects
	 */
	@AutoEscape
	public String getTotal_investment_min();

	/**
	 * Sets the total_investment_min of this investment projects.
	 *
	 * @param total_investment_min the total_investment_min of this investment projects
	 */
	public void setTotal_investment_min(String total_investment_min);

	/**
	 * Returns the total_investment_max of this investment projects.
	 *
	 * @return the total_investment_max of this investment projects
	 */
	@AutoEscape
	public String getTotal_investment_max();

	/**
	 * Sets the total_investment_max of this investment projects.
	 *
	 * @param total_investment_max the total_investment_max of this investment projects
	 */
	public void setTotal_investment_max(String total_investment_max);

	/**
	 * Returns the implementation_location of this investment projects.
	 *
	 * @return the implementation_location of this investment projects
	 */
	@AutoEscape
	public String getImplementation_location();

	/**
	 * Sets the implementation_location of this investment projects.
	 *
	 * @param implementation_location the implementation_location of this investment projects
	 */
	public void setImplementation_location(String implementation_location);

	/**
	 * Returns the start_time of this investment projects.
	 *
	 * @return the start_time of this investment projects
	 */
	public Date getStart_time();

	/**
	 * Sets the start_time of this investment projects.
	 *
	 * @param start_time the start_time of this investment projects
	 */
	public void setStart_time(Date start_time);

	/**
	 * Returns the end_time of this investment projects.
	 *
	 * @return the end_time of this investment projects
	 */
	public Date getEnd_time();

	/**
	 * Sets the end_time of this investment projects.
	 *
	 * @param end_time the end_time of this investment projects
	 */
	public void setEnd_time(Date end_time);

	/**
	 * Returns the project_purpose of this investment projects.
	 *
	 * @return the project_purpose of this investment projects
	 */
	@AutoEscape
	public String getProject_purpose();

	/**
	 * Sets the project_purpose of this investment projects.
	 *
	 * @param project_purpose the project_purpose of this investment projects
	 */
	public void setProject_purpose(String project_purpose);

	/**
	 * Returns the charter_capital of this investment projects.
	 *
	 * @return the charter_capital of this investment projects
	 */
	@AutoEscape
	public String getCharter_capital();

	/**
	 * Sets the charter_capital of this investment projects.
	 *
	 * @param charter_capital the charter_capital of this investment projects
	 */
	public void setCharter_capital(String charter_capital);

	/**
	 * Returns the project_category_id of this investment projects.
	 *
	 * @return the project_category_id of this investment projects
	 */
	@AutoEscape
	public String getProject_category_id();

	/**
	 * Sets the project_category_id of this investment projects.
	 *
	 * @param project_category_id the project_category_id of this investment projects
	 */
	public void setProject_category_id(String project_category_id);

	/**
	 * Returns the project_status_id of this investment projects.
	 *
	 * @return the project_status_id of this investment projects
	 */
	@AutoEscape
	public String getProject_status_id();

	/**
	 * Sets the project_status_id of this investment projects.
	 *
	 * @param project_status_id the project_status_id of this investment projects
	 */
	public void setProject_status_id(String project_status_id);

	/**
	 * Returns the investment_form_id of this investment projects.
	 *
	 * @return the investment_form_id of this investment projects
	 */
	@AutoEscape
	public String getInvestment_form_id();

	/**
	 * Sets the investment_form_id of this investment projects.
	 *
	 * @param investment_form_id the investment_form_id of this investment projects
	 */
	public void setInvestment_form_id(String investment_form_id);

	/**
	 * Returns the competent_organization_id of this investment projects.
	 *
	 * @return the competent_organization_id of this investment projects
	 */
	@AutoEscape
	public String getCompetent_organization_id();

	/**
	 * Sets the competent_organization_id of this investment projects.
	 *
	 * @param competent_organization_id the competent_organization_id of this investment projects
	 */
	public void setCompetent_organization_id(String competent_organization_id);

	/**
	 * Returns the key_project of this investment projects.
	 *
	 * @return the key_project of this investment projects
	 */
	public boolean getKey_project();

	/**
	 * Returns <code>true</code> if this investment projects is key_project.
	 *
	 * @return <code>true</code> if this investment projects is key_project; <code>false</code> otherwise
	 */
	public boolean isKey_project();

	/**
	 * Sets whether this investment projects is key_project.
	 *
	 * @param key_project the key_project of this investment projects
	 */
	public void setKey_project(boolean key_project);

	/**
	 * Returns the technical_specifications of this investment projects.
	 *
	 * @return the technical_specifications of this investment projects
	 */
	@AutoEscape
	public String getTechnical_specifications();

	/**
	 * Sets the technical_specifications of this investment projects.
	 *
	 * @param technical_specifications the technical_specifications of this investment projects
	 */
	public void setTechnical_specifications(String technical_specifications);

	/**
	 * Returns the currency_type_id of this investment projects.
	 *
	 * @return the currency_type_id of this investment projects
	 */
	@AutoEscape
	public String getCurrency_type_id();

	/**
	 * Sets the currency_type_id of this investment projects.
	 *
	 * @param currency_type_id the currency_type_id of this investment projects
	 */
	public void setCurrency_type_id(String currency_type_id);

	/**
	 * Returns the created_date of this investment projects.
	 *
	 * @return the created_date of this investment projects
	 */
	public Date getCreated_date();

	/**
	 * Sets the created_date of this investment projects.
	 *
	 * @param created_date the created_date of this investment projects
	 */
	public void setCreated_date(Date created_date);

	/**
	 * Returns the modified_date of this investment projects.
	 *
	 * @return the modified_date of this investment projects
	 */
	public Date getModified_date();

	/**
	 * Sets the modified_date of this investment projects.
	 *
	 * @param modified_date the modified_date of this investment projects
	 */
	public void setModified_date(Date modified_date);

	/**
	 * Returns the deleted of this investment projects.
	 *
	 * @return the deleted of this investment projects
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this investment projects is deleted.
	 *
	 * @return <code>true</code> if this investment projects is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this investment projects is deleted.
	 *
	 * @param deleted the deleted of this investment projects
	 */
	public void setDeleted(boolean deleted);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(InvestmentProjects investmentProjects);

	public int hashCode();

	public CacheModel<InvestmentProjects> toCacheModel();

	public InvestmentProjects toEscapedModel();

	public String toString();

	public String toXmlString();
}