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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.fsoft.bn.service.http.InvestmentProjectsServiceSoap}.
 *
 * @author    FSOFT
 * @see       com.fsoft.bn.service.http.InvestmentProjectsServiceSoap
 * @generated
 */
public class InvestmentProjectsSoap implements Serializable {
	public static InvestmentProjectsSoap toSoapModel(InvestmentProjects model) {
		InvestmentProjectsSoap soapModel = new InvestmentProjectsSoap();

		soapModel.setProject_id(model.getProject_id());
		soapModel.setProject_name(model.getProject_name());
		soapModel.setTotal_investment_min(model.getTotal_investment_min());
		soapModel.setTotal_investment_max(model.getTotal_investment_max());
		soapModel.setImplementation_location(model.getImplementation_location());
		soapModel.setStart_time(model.getStart_time());
		soapModel.setEnd_time(model.getEnd_time());
		soapModel.setProject_purpose(model.getProject_purpose());
		soapModel.setCharter_capital(model.getCharter_capital());
		soapModel.setProject_category_id(model.getProject_category_id());
		soapModel.setProject_status_id(model.getProject_status_id());
		soapModel.setInvestment_form_id(model.getInvestment_form_id());
		soapModel.setCompetent_organization_id(model.getCompetent_organization_id());
		soapModel.setKey_project(model.getKey_project());
		soapModel.setTechnical_specifications(model.getTechnical_specifications());
		soapModel.setCurrency_type_id(model.getCurrency_type_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static InvestmentProjectsSoap[] toSoapModels(
		InvestmentProjects[] models) {
		InvestmentProjectsSoap[] soapModels = new InvestmentProjectsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InvestmentProjectsSoap[][] toSoapModels(
		InvestmentProjects[][] models) {
		InvestmentProjectsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InvestmentProjectsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InvestmentProjectsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InvestmentProjectsSoap[] toSoapModels(
		List<InvestmentProjects> models) {
		List<InvestmentProjectsSoap> soapModels = new ArrayList<InvestmentProjectsSoap>(models.size());

		for (InvestmentProjects model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InvestmentProjectsSoap[soapModels.size()]);
	}

	public InvestmentProjectsSoap() {
	}

	public String getPrimaryKey() {
		return _project_id;
	}

	public void setPrimaryKey(String pk) {
		setProject_id(pk);
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
}