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
public class PreschoolStudentSoap implements Serializable {
	public static PreschoolStudentSoap toSoapModel(PreschoolStudent model) {
		PreschoolStudentSoap soapModel = new PreschoolStudentSoap();

		soapModel.setStudent_id(model.getStudent_id());
		soapModel.setStudent_name(model.getStudent_name());
		soapModel.setStudent_sex(model.getStudent_sex());
		soapModel.setStudent_dob(model.getStudent_dob());
		soapModel.setStudent_placeOfBirth(model.getStudent_placeOfBirth());
		soapModel.setStudent_nationality(model.getStudent_nationality());
		soapModel.setStudent_phoneNumber(model.getStudent_phoneNumber());
		soapModel.setStudent_address(model.getStudent_address());
		soapModel.setStudent_heatlhStatus(model.getStudent_heatlhStatus());
		soapModel.setStudent_height(model.getStudent_height());
		soapModel.setStudent_weight(model.getStudent_weight());
		soapModel.setStudent_contactName(model.getStudent_contactName());
		soapModel.setStudent_contactRelationship(model.getStudent_contactRelationship());
		soapModel.setStudent_contactPhoneNumber(model.getStudent_contactPhoneNumber());
		soapModel.setStudent_contactEmail(model.getStudent_contactEmail());
		soapModel.setStudent_howToKnowBM(model.getStudent_howToKnowBM());
		soapModel.setStudent_whoIntroduce(model.getStudent_whoIntroduce());
		soapModel.setStudent_anyConfuse(model.getStudent_anyConfuse());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static PreschoolStudentSoap[] toSoapModels(PreschoolStudent[] models) {
		PreschoolStudentSoap[] soapModels = new PreschoolStudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PreschoolStudentSoap[][] toSoapModels(
		PreschoolStudent[][] models) {
		PreschoolStudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PreschoolStudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PreschoolStudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PreschoolStudentSoap[] toSoapModels(
		List<PreschoolStudent> models) {
		List<PreschoolStudentSoap> soapModels = new ArrayList<PreschoolStudentSoap>(models.size());

		for (PreschoolStudent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PreschoolStudentSoap[soapModels.size()]);
	}

	public PreschoolStudentSoap() {
	}

	public String getPrimaryKey() {
		return _student_id;
	}

	public void setPrimaryKey(String pk) {
		setStudent_id(pk);
	}

	public String getStudent_id() {
		return _student_id;
	}

	public void setStudent_id(String student_id) {
		_student_id = student_id;
	}

	public String getStudent_name() {
		return _student_name;
	}

	public void setStudent_name(String student_name) {
		_student_name = student_name;
	}

	public String getStudent_sex() {
		return _student_sex;
	}

	public void setStudent_sex(String student_sex) {
		_student_sex = student_sex;
	}

	public String getStudent_dob() {
		return _student_dob;
	}

	public void setStudent_dob(String student_dob) {
		_student_dob = student_dob;
	}

	public String getStudent_placeOfBirth() {
		return _student_placeOfBirth;
	}

	public void setStudent_placeOfBirth(String student_placeOfBirth) {
		_student_placeOfBirth = student_placeOfBirth;
	}

	public String getStudent_nationality() {
		return _student_nationality;
	}

	public void setStudent_nationality(String student_nationality) {
		_student_nationality = student_nationality;
	}

	public String getStudent_phoneNumber() {
		return _student_phoneNumber;
	}

	public void setStudent_phoneNumber(String student_phoneNumber) {
		_student_phoneNumber = student_phoneNumber;
	}

	public String getStudent_address() {
		return _student_address;
	}

	public void setStudent_address(String student_address) {
		_student_address = student_address;
	}

	public String getStudent_heatlhStatus() {
		return _student_heatlhStatus;
	}

	public void setStudent_heatlhStatus(String student_heatlhStatus) {
		_student_heatlhStatus = student_heatlhStatus;
	}

	public String getStudent_height() {
		return _student_height;
	}

	public void setStudent_height(String student_height) {
		_student_height = student_height;
	}

	public String getStudent_weight() {
		return _student_weight;
	}

	public void setStudent_weight(String student_weight) {
		_student_weight = student_weight;
	}

	public String getStudent_contactName() {
		return _student_contactName;
	}

	public void setStudent_contactName(String student_contactName) {
		_student_contactName = student_contactName;
	}

	public String getStudent_contactRelationship() {
		return _student_contactRelationship;
	}

	public void setStudent_contactRelationship(
		String student_contactRelationship) {
		_student_contactRelationship = student_contactRelationship;
	}

	public String getStudent_contactPhoneNumber() {
		return _student_contactPhoneNumber;
	}

	public void setStudent_contactPhoneNumber(String student_contactPhoneNumber) {
		_student_contactPhoneNumber = student_contactPhoneNumber;
	}

	public String getStudent_contactEmail() {
		return _student_contactEmail;
	}

	public void setStudent_contactEmail(String student_contactEmail) {
		_student_contactEmail = student_contactEmail;
	}

	public String getStudent_howToKnowBM() {
		return _student_howToKnowBM;
	}

	public void setStudent_howToKnowBM(String student_howToKnowBM) {
		_student_howToKnowBM = student_howToKnowBM;
	}

	public String getStudent_whoIntroduce() {
		return _student_whoIntroduce;
	}

	public void setStudent_whoIntroduce(String student_whoIntroduce) {
		_student_whoIntroduce = student_whoIntroduce;
	}

	public String getStudent_anyConfuse() {
		return _student_anyConfuse;
	}

	public void setStudent_anyConfuse(String student_anyConfuse) {
		_student_anyConfuse = student_anyConfuse;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	private String _student_id;
	private String _student_name;
	private String _student_sex;
	private String _student_dob;
	private String _student_placeOfBirth;
	private String _student_nationality;
	private String _student_phoneNumber;
	private String _student_address;
	private String _student_heatlhStatus;
	private String _student_height;
	private String _student_weight;
	private String _student_contactName;
	private String _student_contactRelationship;
	private String _student_contactPhoneNumber;
	private String _student_contactEmail;
	private String _student_howToKnowBM;
	private String _student_whoIntroduce;
	private String _student_anyConfuse;
	private String _status;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}