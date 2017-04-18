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

import com.fsoft.bn.service.InvestmentProjectsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FSOFT
 */
public class InvestmentProjectsClp extends BaseModelImpl<InvestmentProjects>
	implements InvestmentProjects {
	public InvestmentProjectsClp() {
	}

	public Class<?> getModelClass() {
		return InvestmentProjects.class;
	}

	public String getModelClassName() {
		return InvestmentProjects.class.getName();
	}

	public String getPrimaryKey() {
		return _project_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setProject_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _project_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
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

	@Override
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

	public String getProject_id() {
		return _project_id;
	}

	public void setProject_id(String project_id) {
		_project_id = project_id;
	}

	public String getProject_name() {
		return _project_name;
	}

	public void setProject_name(String project_name) {
		_project_name = project_name;
	}

	public String getTotal_investment_min() {
		return _total_investment_min;
	}

	public void setTotal_investment_min(String total_investment_min) {
		_total_investment_min = total_investment_min;
	}

	public String getTotal_investment_max() {
		return _total_investment_max;
	}

	public void setTotal_investment_max(String total_investment_max) {
		_total_investment_max = total_investment_max;
	}

	public String getImplementation_location() {
		return _implementation_location;
	}

	public void setImplementation_location(String implementation_location) {
		_implementation_location = implementation_location;
	}

	public Date getStart_time() {
		return _start_time;
	}

	public void setStart_time(Date start_time) {
		_start_time = start_time;
	}

	public Date getEnd_time() {
		return _end_time;
	}

	public void setEnd_time(Date end_time) {
		_end_time = end_time;
	}

	public String getProject_purpose() {
		return _project_purpose;
	}

	public void setProject_purpose(String project_purpose) {
		_project_purpose = project_purpose;
	}

	public String getCharter_capital() {
		return _charter_capital;
	}

	public void setCharter_capital(String charter_capital) {
		_charter_capital = charter_capital;
	}

	public String getProject_category_id() {
		return _project_category_id;
	}

	public void setProject_category_id(String project_category_id) {
		_project_category_id = project_category_id;
	}

	public String getProject_status_id() {
		return _project_status_id;
	}

	public void setProject_status_id(String project_status_id) {
		_project_status_id = project_status_id;
	}

	public String getInvestment_form_id() {
		return _investment_form_id;
	}

	public void setInvestment_form_id(String investment_form_id) {
		_investment_form_id = investment_form_id;
	}

	public String getCompetent_organization_id() {
		return _competent_organization_id;
	}

	public void setCompetent_organization_id(String competent_organization_id) {
		_competent_organization_id = competent_organization_id;
	}

	public boolean getKey_project() {
		return _key_project;
	}

	public boolean isKey_project() {
		return _key_project;
	}

	public void setKey_project(boolean key_project) {
		_key_project = key_project;
	}

	public String getTechnical_specifications() {
		return _technical_specifications;
	}

	public void setTechnical_specifications(String technical_specifications) {
		_technical_specifications = technical_specifications;
	}

	public String getCurrency_type_id() {
		return _currency_type_id;
	}

	public void setCurrency_type_id(String currency_type_id) {
		_currency_type_id = currency_type_id;
	}

	public Date getCreated_date() {
		return _created_date;
	}

	public void setCreated_date(Date created_date) {
		_created_date = created_date;
	}

	public Date getModified_date() {
		return _modified_date;
	}

	public void setModified_date(Date modified_date) {
		_modified_date = modified_date;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public void setEditAction(java.lang.String editAction) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getEndDay() {
		throw new UnsupportedOperationException();
	}

	public void setCharterCapitalDisplay(java.lang.String charterCapitalDisplay) {
		throw new UnsupportedOperationException();
	}

	public void setEndYear(java.lang.String endYear) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getStartDay() {
		throw new UnsupportedOperationException();
	}

	public void setStartYear(java.lang.String startYear) {
		throw new UnsupportedOperationException();
	}

	public void setStartDay(java.lang.String startDay) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getInvestAmountMaxDisplay() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getStartMonth() {
		throw new UnsupportedOperationException();
	}

	public void setInvestAmountMinDisplay(
		java.lang.String investAmountMinDisplay) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getInvestAmountMinDisplay() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getCategoryDisplay() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getEditAction() {
		throw new UnsupportedOperationException();
	}

	public void setInvestAmountMaxDisplay(
		java.lang.String investAmountMaxDisplay) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getCharterCapitalDisplay() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getTimeStartDisplay() {
		throw new UnsupportedOperationException();
	}

	public void setCategoryDisplay(java.lang.String categoryDisplay) {
		throw new UnsupportedOperationException();
	}

	public void setTimeEndDisplay(java.lang.String timeEndDisplay) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getEndYear() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getStartYear() {
		throw new UnsupportedOperationException();
	}

	public void setTimeStartDisplay(java.lang.String timeStartDisplay) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getEndMonth() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getTimeEndDisplay() {
		throw new UnsupportedOperationException();
	}

	public void setStartMonth(java.lang.String startMonth) {
		throw new UnsupportedOperationException();
	}

	public void setEndMonth(java.lang.String endMonth) {
		throw new UnsupportedOperationException();
	}

	public void setEndDay(java.lang.String endDay) {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getInvestmentProjectsRemoteModel() {
		return _investmentProjectsRemoteModel;
	}

	public void setInvestmentProjectsRemoteModel(
		BaseModel<?> investmentProjectsRemoteModel) {
		_investmentProjectsRemoteModel = investmentProjectsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			InvestmentProjectsLocalServiceUtil.addInvestmentProjects(this);
		}
		else {
			InvestmentProjectsLocalServiceUtil.updateInvestmentProjects(this);
		}
	}

	@Override
	public InvestmentProjects toEscapedModel() {
		return (InvestmentProjects)Proxy.newProxyInstance(InvestmentProjects.class.getClassLoader(),
			new Class[] { InvestmentProjects.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InvestmentProjectsClp clone = new InvestmentProjectsClp();

		clone.setProject_id(getProject_id());
		clone.setProject_name(getProject_name());
		clone.setTotal_investment_min(getTotal_investment_min());
		clone.setTotal_investment_max(getTotal_investment_max());
		clone.setImplementation_location(getImplementation_location());
		clone.setStart_time(getStart_time());
		clone.setEnd_time(getEnd_time());
		clone.setProject_purpose(getProject_purpose());
		clone.setCharter_capital(getCharter_capital());
		clone.setProject_category_id(getProject_category_id());
		clone.setProject_status_id(getProject_status_id());
		clone.setInvestment_form_id(getInvestment_form_id());
		clone.setCompetent_organization_id(getCompetent_organization_id());
		clone.setKey_project(getKey_project());
		clone.setTechnical_specifications(getTechnical_specifications());
		clone.setCurrency_type_id(getCurrency_type_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(InvestmentProjects investmentProjects) {
		String primaryKey = investmentProjects.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		InvestmentProjectsClp investmentProjects = null;

		try {
			investmentProjects = (InvestmentProjectsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = investmentProjects.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{project_id=");
		sb.append(getProject_id());
		sb.append(", project_name=");
		sb.append(getProject_name());
		sb.append(", total_investment_min=");
		sb.append(getTotal_investment_min());
		sb.append(", total_investment_max=");
		sb.append(getTotal_investment_max());
		sb.append(", implementation_location=");
		sb.append(getImplementation_location());
		sb.append(", start_time=");
		sb.append(getStart_time());
		sb.append(", end_time=");
		sb.append(getEnd_time());
		sb.append(", project_purpose=");
		sb.append(getProject_purpose());
		sb.append(", charter_capital=");
		sb.append(getCharter_capital());
		sb.append(", project_category_id=");
		sb.append(getProject_category_id());
		sb.append(", project_status_id=");
		sb.append(getProject_status_id());
		sb.append(", investment_form_id=");
		sb.append(getInvestment_form_id());
		sb.append(", competent_organization_id=");
		sb.append(getCompetent_organization_id());
		sb.append(", key_project=");
		sb.append(getKey_project());
		sb.append(", technical_specifications=");
		sb.append(getTechnical_specifications());
		sb.append(", currency_type_id=");
		sb.append(getCurrency_type_id());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", modified_date=");
		sb.append(getModified_date());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.InvestmentProjects");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>project_id</column-name><column-value><![CDATA[");
		sb.append(getProject_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>project_name</column-name><column-value><![CDATA[");
		sb.append(getProject_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>total_investment_min</column-name><column-value><![CDATA[");
		sb.append(getTotal_investment_min());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>total_investment_max</column-name><column-value><![CDATA[");
		sb.append(getTotal_investment_max());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>implementation_location</column-name><column-value><![CDATA[");
		sb.append(getImplementation_location());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>start_time</column-name><column-value><![CDATA[");
		sb.append(getStart_time());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>end_time</column-name><column-value><![CDATA[");
		sb.append(getEnd_time());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>project_purpose</column-name><column-value><![CDATA[");
		sb.append(getProject_purpose());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>charter_capital</column-name><column-value><![CDATA[");
		sb.append(getCharter_capital());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>project_category_id</column-name><column-value><![CDATA[");
		sb.append(getProject_category_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>project_status_id</column-name><column-value><![CDATA[");
		sb.append(getProject_status_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>investment_form_id</column-name><column-value><![CDATA[");
		sb.append(getInvestment_form_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competent_organization_id</column-name><column-value><![CDATA[");
		sb.append(getCompetent_organization_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key_project</column-name><column-value><![CDATA[");
		sb.append(getKey_project());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>technical_specifications</column-name><column-value><![CDATA[");
		sb.append(getTechnical_specifications());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency_type_id</column-name><column-value><![CDATA[");
		sb.append(getCurrency_type_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created_date</column-name><column-value><![CDATA[");
		sb.append(getCreated_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modified_date</column-name><column-value><![CDATA[");
		sb.append(getModified_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _project_id;
	private String _project_name;
	private String _total_investment_min;
	private String _total_investment_max;
	private String _implementation_location;
	private Date _start_time;
	private Date _end_time;
	private String _project_purpose;
	private String _charter_capital;
	private String _project_category_id;
	private String _project_status_id;
	private String _investment_form_id;
	private String _competent_organization_id;
	private boolean _key_project;
	private String _technical_specifications;
	private String _currency_type_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _investmentProjectsRemoteModel;
}