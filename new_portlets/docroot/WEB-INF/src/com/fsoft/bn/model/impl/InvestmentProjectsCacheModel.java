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

import com.fsoft.bn.model.InvestmentProjects;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing InvestmentProjects in entity cache.
 *
 * @author FSOFT
 * @see InvestmentProjects
 * @generated
 */
public class InvestmentProjectsCacheModel implements CacheModel<InvestmentProjects>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{project_id=");
		sb.append(project_id);
		sb.append(", project_name=");
		sb.append(project_name);
		sb.append(", total_investment_min=");
		sb.append(total_investment_min);
		sb.append(", total_investment_max=");
		sb.append(total_investment_max);
		sb.append(", implementation_location=");
		sb.append(implementation_location);
		sb.append(", start_time=");
		sb.append(start_time);
		sb.append(", end_time=");
		sb.append(end_time);
		sb.append(", project_purpose=");
		sb.append(project_purpose);
		sb.append(", charter_capital=");
		sb.append(charter_capital);
		sb.append(", project_category_id=");
		sb.append(project_category_id);
		sb.append(", project_status_id=");
		sb.append(project_status_id);
		sb.append(", investment_form_id=");
		sb.append(investment_form_id);
		sb.append(", competent_organization_id=");
		sb.append(competent_organization_id);
		sb.append(", key_project=");
		sb.append(key_project);
		sb.append(", technical_specifications=");
		sb.append(technical_specifications);
		sb.append(", currency_type_id=");
		sb.append(currency_type_id);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public InvestmentProjects toEntityModel() {
		InvestmentProjectsImpl investmentProjectsImpl = new InvestmentProjectsImpl();

		if (project_id == null) {
			investmentProjectsImpl.setProject_id(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setProject_id(project_id);
		}

		if (project_name == null) {
			investmentProjectsImpl.setProject_name(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setProject_name(project_name);
		}

		if (total_investment_min == null) {
			investmentProjectsImpl.setTotal_investment_min(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setTotal_investment_min(total_investment_min);
		}

		if (total_investment_max == null) {
			investmentProjectsImpl.setTotal_investment_max(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setTotal_investment_max(total_investment_max);
		}

		if (implementation_location == null) {
			investmentProjectsImpl.setImplementation_location(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setImplementation_location(implementation_location);
		}

		if (start_time == Long.MIN_VALUE) {
			investmentProjectsImpl.setStart_time(null);
		}
		else {
			investmentProjectsImpl.setStart_time(new Date(start_time));
		}

		if (end_time == Long.MIN_VALUE) {
			investmentProjectsImpl.setEnd_time(null);
		}
		else {
			investmentProjectsImpl.setEnd_time(new Date(end_time));
		}

		if (project_purpose == null) {
			investmentProjectsImpl.setProject_purpose(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setProject_purpose(project_purpose);
		}

		if (charter_capital == null) {
			investmentProjectsImpl.setCharter_capital(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setCharter_capital(charter_capital);
		}

		if (project_category_id == null) {
			investmentProjectsImpl.setProject_category_id(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setProject_category_id(project_category_id);
		}

		if (project_status_id == null) {
			investmentProjectsImpl.setProject_status_id(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setProject_status_id(project_status_id);
		}

		if (investment_form_id == null) {
			investmentProjectsImpl.setInvestment_form_id(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setInvestment_form_id(investment_form_id);
		}

		if (competent_organization_id == null) {
			investmentProjectsImpl.setCompetent_organization_id(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setCompetent_organization_id(competent_organization_id);
		}

		investmentProjectsImpl.setKey_project(key_project);

		if (technical_specifications == null) {
			investmentProjectsImpl.setTechnical_specifications(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setTechnical_specifications(technical_specifications);
		}

		if (currency_type_id == null) {
			investmentProjectsImpl.setCurrency_type_id(StringPool.BLANK);
		}
		else {
			investmentProjectsImpl.setCurrency_type_id(currency_type_id);
		}

		if (created_date == Long.MIN_VALUE) {
			investmentProjectsImpl.setCreated_date(null);
		}
		else {
			investmentProjectsImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			investmentProjectsImpl.setModified_date(null);
		}
		else {
			investmentProjectsImpl.setModified_date(new Date(modified_date));
		}

		investmentProjectsImpl.setDeleted(deleted);

		investmentProjectsImpl.resetOriginalValues();

		return investmentProjectsImpl;
	}

	public String project_id;
	public String project_name;
	public String total_investment_min;
	public String total_investment_max;
	public String implementation_location;
	public long start_time;
	public long end_time;
	public String project_purpose;
	public String charter_capital;
	public String project_category_id;
	public String project_status_id;
	public String investment_form_id;
	public String competent_organization_id;
	public boolean key_project;
	public String technical_specifications;
	public String currency_type_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}