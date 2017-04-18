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
public class BNContactSoap implements Serializable {
	public static BNContactSoap toSoapModel(BNContact model) {
		BNContactSoap soapModel = new BNContactSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setDepartmentKey(model.getDepartmentKey());
		soapModel.setName(model.getName());
		soapModel.setRegency(model.getRegency());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setEmail(model.getEmail());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static BNContactSoap[] toSoapModels(BNContact[] models) {
		BNContactSoap[] soapModels = new BNContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BNContactSoap[][] toSoapModels(BNContact[][] models) {
		BNContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BNContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BNContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BNContactSoap[] toSoapModels(List<BNContact> models) {
		List<BNContactSoap> soapModels = new ArrayList<BNContactSoap>(models.size());

		for (BNContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BNContactSoap[soapModels.size()]);
	}

	public BNContactSoap() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long pk) {
		setContactId(pk);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getDepartmentKey() {
		return _departmentKey;
	}

	public void setDepartmentKey(String departmentKey) {
		_departmentKey = departmentKey;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getRegency() {
		return _regency;
	}

	public void setRegency(String regency) {
		_regency = regency;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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

	private long _contactId;
	private String _departmentKey;
	private String _name;
	private String _regency;
	private String _phoneNumber;
	private String _email;
	private Date _createdDate;
	private Date _modifiedDate;
	private boolean _deleted;
}