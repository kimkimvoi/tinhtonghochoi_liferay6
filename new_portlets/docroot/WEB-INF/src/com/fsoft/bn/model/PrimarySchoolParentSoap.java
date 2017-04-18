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
public class PrimarySchoolParentSoap implements Serializable {
	public static PrimarySchoolParentSoap toSoapModel(PrimarySchoolParent model) {
		PrimarySchoolParentSoap soapModel = new PrimarySchoolParentSoap();

		soapModel.setPrimarySchoolParent_id(model.getPrimarySchoolParent_id());
		soapModel.setPrimaryStudent_id(model.getPrimaryStudent_id());
		soapModel.setName(model.getName());
		soapModel.setNationality(model.getNationality());
		soapModel.setIdCardNumber(model.getIdCardNumber());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setJob(model.getJob());
		soapModel.setJob_position(model.getJob_position());
		soapModel.setWorkplace(model.getWorkplace());
		soapModel.setIsMother(model.getIsMother());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static PrimarySchoolParentSoap[] toSoapModels(
		PrimarySchoolParent[] models) {
		PrimarySchoolParentSoap[] soapModels = new PrimarySchoolParentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PrimarySchoolParentSoap[][] toSoapModels(
		PrimarySchoolParent[][] models) {
		PrimarySchoolParentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PrimarySchoolParentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PrimarySchoolParentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PrimarySchoolParentSoap[] toSoapModels(
		List<PrimarySchoolParent> models) {
		List<PrimarySchoolParentSoap> soapModels = new ArrayList<PrimarySchoolParentSoap>(models.size());

		for (PrimarySchoolParent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PrimarySchoolParentSoap[soapModels.size()]);
	}

	public PrimarySchoolParentSoap() {
	}

	public String getPrimaryKey() {
		return _primarySchoolParent_id;
	}

	public void setPrimaryKey(String pk) {
		setPrimarySchoolParent_id(pk);
	}

	public String getPrimarySchoolParent_id() {
		return _primarySchoolParent_id;
	}

	public void setPrimarySchoolParent_id(String primarySchoolParent_id) {
		_primarySchoolParent_id = primarySchoolParent_id;
	}

	public String getPrimaryStudent_id() {
		return _primaryStudent_id;
	}

	public void setPrimaryStudent_id(String primaryStudent_id) {
		_primaryStudent_id = primaryStudent_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public String getJob() {
		return _job;
	}

	public void setJob(String job) {
		_job = job;
	}

	public String getJob_position() {
		return _job_position;
	}

	public void setJob_position(String job_position) {
		_job_position = job_position;
	}

	public String getWorkplace() {
		return _workplace;
	}

	public void setWorkplace(String workplace) {
		_workplace = workplace;
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

	private String _primarySchoolParent_id;
	private String _primaryStudent_id;
	private String _name;
	private String _nationality;
	private String _idCardNumber;
	private String _phoneNumber;
	private String _Email;
	private String _job;
	private String _job_position;
	private String _workplace;
	private boolean _isMother;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}