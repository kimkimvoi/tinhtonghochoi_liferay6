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
public class PreschoolParentSoap implements Serializable {
	public static PreschoolParentSoap toSoapModel(PreschoolParent model) {
		PreschoolParentSoap soapModel = new PreschoolParentSoap();

		soapModel.setPreschoolParent_id(model.getPreschoolParent_id());
		soapModel.setStudent_id(model.getStudent_id());
		soapModel.setName(model.getName());
		soapModel.setDob(model.getDob());
		soapModel.setPlaceOfBirth(model.getPlaceOfBirth());
		soapModel.setNationality(model.getNationality());
		soapModel.setIdCardNumber(model.getIdCardNumber());
		soapModel.setJob(model.getJob());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setIsMother(model.getIsMother());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static PreschoolParentSoap[] toSoapModels(PreschoolParent[] models) {
		PreschoolParentSoap[] soapModels = new PreschoolParentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PreschoolParentSoap[][] toSoapModels(
		PreschoolParent[][] models) {
		PreschoolParentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PreschoolParentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PreschoolParentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PreschoolParentSoap[] toSoapModels(
		List<PreschoolParent> models) {
		List<PreschoolParentSoap> soapModels = new ArrayList<PreschoolParentSoap>(models.size());

		for (PreschoolParent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PreschoolParentSoap[soapModels.size()]);
	}

	public PreschoolParentSoap() {
	}

	public String getPrimaryKey() {
		return _preschoolParent_id;
	}

	public void setPrimaryKey(String pk) {
		setPreschoolParent_id(pk);
	}

	public String getPreschoolParent_id() {
		return _preschoolParent_id;
	}

	public void setPreschoolParent_id(String preschoolParent_id) {
		_preschoolParent_id = preschoolParent_id;
	}

	public String getStudent_id() {
		return _student_id;
	}

	public void setStudent_id(String student_id) {
		_student_id = student_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDob() {
		return _dob;
	}

	public void setDob(String dob) {
		_dob = dob;
	}

	public String getPlaceOfBirth() {
		return _placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		_placeOfBirth = placeOfBirth;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getIdCardNumber() {
		return _idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		_idCardNumber = idCardNumber;
	}

	public String getJob() {
		return _job;
	}

	public void setJob(String job) {
		_job = job;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public boolean getIsMother() {
		return _isMother;
	}

	public boolean isIsMother() {
		return _isMother;
	}

	public void setIsMother(boolean isMother) {
		_isMother = isMother;
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

	private String _preschoolParent_id;
	private String _student_id;
	private String _name;
	private String _dob;
	private String _placeOfBirth;
	private String _nationality;
	private String _idCardNumber;
	private String _job;
	private String _phoneNumber;
	private String _Email;
	private boolean _isMother;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}