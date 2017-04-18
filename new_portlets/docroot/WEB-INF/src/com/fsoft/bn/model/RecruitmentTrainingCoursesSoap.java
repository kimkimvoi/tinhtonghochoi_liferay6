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
public class RecruitmentTrainingCoursesSoap implements Serializable {
	public static RecruitmentTrainingCoursesSoap toSoapModel(
		RecruitmentTrainingCourses model) {
		RecruitmentTrainingCoursesSoap soapModel = new RecruitmentTrainingCoursesSoap();

		soapModel.setRecruitment_training_courses_id(model.getRecruitment_training_courses_id());
		soapModel.setRecruitment_id(model.getRecruitment_id());
		soapModel.setConductedBy(model.getConductedBy());
		soapModel.setCourseName(model.getCourseName());
		soapModel.setCourseDesc(model.getCourseDesc());
		soapModel.setCourseDate(model.getCourseDate());
		soapModel.setCertificate(model.getCertificate());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static RecruitmentTrainingCoursesSoap[] toSoapModels(
		RecruitmentTrainingCourses[] models) {
		RecruitmentTrainingCoursesSoap[] soapModels = new RecruitmentTrainingCoursesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentTrainingCoursesSoap[][] toSoapModels(
		RecruitmentTrainingCourses[][] models) {
		RecruitmentTrainingCoursesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecruitmentTrainingCoursesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecruitmentTrainingCoursesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentTrainingCoursesSoap[] toSoapModels(
		List<RecruitmentTrainingCourses> models) {
		List<RecruitmentTrainingCoursesSoap> soapModels = new ArrayList<RecruitmentTrainingCoursesSoap>(models.size());

		for (RecruitmentTrainingCourses model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecruitmentTrainingCoursesSoap[soapModels.size()]);
	}

	public RecruitmentTrainingCoursesSoap() {
	}

	public String getPrimaryKey() {
		return _recruitment_training_courses_id;
	}

	public void setPrimaryKey(String pk) {
		setRecruitment_training_courses_id(pk);
	}

	public String getRecruitment_training_courses_id() {
		return _recruitment_training_courses_id;
	}

	public void setRecruitment_training_courses_id(
		String recruitment_training_courses_id) {
		_recruitment_training_courses_id = recruitment_training_courses_id;
	}

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getConductedBy() {
		return _conductedBy;
	}

	public void setConductedBy(String conductedBy) {
		_conductedBy = conductedBy;
	}

	public String getCourseName() {
		return _courseName;
	}

	public void setCourseName(String courseName) {
		_courseName = courseName;
	}

	public String getCourseDesc() {
		return _courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		_courseDesc = courseDesc;
	}

	public String getCourseDate() {
		return _courseDate;
	}

	public void setCourseDate(String courseDate) {
		_courseDate = courseDate;
	}

	public String getCertificate() {
		return _certificate;
	}

	public void setCertificate(String certificate) {
		_certificate = certificate;
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

	private String _recruitment_training_courses_id;
	private String _recruitment_id;
	private String _conductedBy;
	private String _courseName;
	private String _courseDesc;
	private String _courseDate;
	private String _certificate;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}