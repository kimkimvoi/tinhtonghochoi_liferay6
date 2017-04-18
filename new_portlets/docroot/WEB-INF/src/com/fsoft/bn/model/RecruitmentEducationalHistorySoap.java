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
 * This class is used by SOAP remote services.
 *
 * @author    FSOFT
 * @generated
 */
public class RecruitmentEducationalHistorySoap implements Serializable {
	public static RecruitmentEducationalHistorySoap toSoapModel(
		RecruitmentEducationalHistory model) {
		RecruitmentEducationalHistorySoap soapModel = new RecruitmentEducationalHistorySoap();

		soapModel.setRecruitment_educational_history_id(model.getRecruitment_educational_history_id());
		soapModel.setRecruitment_id(model.getRecruitment_id());
		soapModel.setSchool(model.getSchool());
		soapModel.setTypeOfTraining(model.getTypeOfTraining());
		soapModel.setSpeciality(model.getSpeciality());
		soapModel.setTypeOfDegree(model.getTypeOfDegree());
		soapModel.setGraduatedYear(model.getGraduatedYear());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static RecruitmentEducationalHistorySoap[] toSoapModels(
		RecruitmentEducationalHistory[] models) {
		RecruitmentEducationalHistorySoap[] soapModels = new RecruitmentEducationalHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentEducationalHistorySoap[][] toSoapModels(
		RecruitmentEducationalHistory[][] models) {
		RecruitmentEducationalHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecruitmentEducationalHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecruitmentEducationalHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentEducationalHistorySoap[] toSoapModels(
		List<RecruitmentEducationalHistory> models) {
		List<RecruitmentEducationalHistorySoap> soapModels = new ArrayList<RecruitmentEducationalHistorySoap>(models.size());

		for (RecruitmentEducationalHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecruitmentEducationalHistorySoap[soapModels.size()]);
	}

	public RecruitmentEducationalHistorySoap() {
	}

	public String getPrimaryKey() {
		return _recruitment_educational_history_id;
	}

	public void setPrimaryKey(String pk) {
		setRecruitment_educational_history_id(pk);
	}

	public String getRecruitment_educational_history_id() {
		return _recruitment_educational_history_id;
	}

	public void setRecruitment_educational_history_id(
		String recruitment_educational_history_id) {
		_recruitment_educational_history_id = recruitment_educational_history_id;
	}

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getSchool() {
		return _school;
	}

	public void setSchool(String school) {
		_school = school;
	}

	public String getTypeOfTraining() {
		return _typeOfTraining;
	}

	public void setTypeOfTraining(String typeOfTraining) {
		_typeOfTraining = typeOfTraining;
	}

	public String getSpeciality() {
		return _speciality;
	}

	public void setSpeciality(String speciality) {
		_speciality = speciality;
	}

	public String getTypeOfDegree() {
		return _typeOfDegree;
	}

	public void setTypeOfDegree(String typeOfDegree) {
		_typeOfDegree = typeOfDegree;
	}

	public String getGraduatedYear() {
		return _graduatedYear;
	}

	public void setGraduatedYear(String graduatedYear) {
		_graduatedYear = graduatedYear;
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

	private String _recruitment_educational_history_id;
	private String _recruitment_id;
	private String _school;
	private String _typeOfTraining;
	private String _speciality;
	private String _typeOfDegree;
	private String _graduatedYear;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}