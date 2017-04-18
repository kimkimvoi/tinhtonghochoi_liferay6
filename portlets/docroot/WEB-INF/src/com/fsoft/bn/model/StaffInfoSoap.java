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
public class StaffInfoSoap implements Serializable {
	public static StaffInfoSoap toSoapModel(StaffInfo model) {
		StaffInfoSoap soapModel = new StaffInfoSoap();

		soapModel.setStaff_id(model.getStaff_id());
		soapModel.setStaff_firstname(model.getStaff_firstname());
		soapModel.setStaff_middlename(model.getStaff_middlename());
		soapModel.setStaff_lastname(model.getStaff_lastname());
		soapModel.setStaff_birthday(model.getStaff_birthday());
		soapModel.setStaff_phone(model.getStaff_phone());
		soapModel.setStaff_email(model.getStaff_email());
		soapModel.setStaff_sex(model.getStaff_sex());
		soapModel.setStaff_role(model.getStaff_role());
		soapModel.setDeleted(model.getDeleted());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOrganizations_id(model.getOrganizations_id());

		return soapModel;
	}

	public static StaffInfoSoap[] toSoapModels(StaffInfo[] models) {
		StaffInfoSoap[] soapModels = new StaffInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StaffInfoSoap[][] toSoapModels(StaffInfo[][] models) {
		StaffInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StaffInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StaffInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StaffInfoSoap[] toSoapModels(List<StaffInfo> models) {
		List<StaffInfoSoap> soapModels = new ArrayList<StaffInfoSoap>(models.size());

		for (StaffInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StaffInfoSoap[soapModels.size()]);
	}

	public StaffInfoSoap() {
	}

	public long getPrimaryKey() {
		return _staff_id;
	}

	public void setPrimaryKey(long pk) {
		setStaff_id(pk);
	}

	public long getStaff_id() {
		return _staff_id;
	}

	public void setStaff_id(long staff_id) {
		_staff_id = staff_id;
	}

	public String getStaff_firstname() {
		return _staff_firstname;
	}

	public void setStaff_firstname(String staff_firstname) {
		_staff_firstname = staff_firstname;
	}

	public String getStaff_middlename() {
		return _staff_middlename;
	}

	public void setStaff_middlename(String staff_middlename) {
		_staff_middlename = staff_middlename;
	}

	public String getStaff_lastname() {
		return _staff_lastname;
	}

	public void setStaff_lastname(String staff_lastname) {
		_staff_lastname = staff_lastname;
	}

	public Date getStaff_birthday() {
		return _staff_birthday;
	}

	public void setStaff_birthday(Date staff_birthday) {
		_staff_birthday = staff_birthday;
	}

	public String getStaff_phone() {
		return _staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		_staff_phone = staff_phone;
	}

	public String getStaff_email() {
		return _staff_email;
	}

	public void setStaff_email(String staff_email) {
		_staff_email = staff_email;
	}

	public String getStaff_sex() {
		return _staff_sex;
	}

	public void setStaff_sex(String staff_sex) {
		_staff_sex = staff_sex;
	}

	public String getStaff_role() {
		return _staff_role;
	}

	public void setStaff_role(String staff_role) {
		_staff_role = staff_role;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getOrganizations_id() {
		return _organizations_id;
	}

	public void setOrganizations_id(long organizations_id) {
		_organizations_id = organizations_id;
	}

	private long _staff_id;
	private String _staff_firstname;
	private String _staff_middlename;
	private String _staff_lastname;
	private Date _staff_birthday;
	private String _staff_phone;
	private String _staff_email;
	private String _staff_sex;
	private String _staff_role;
	private boolean _deleted;
	private Date _createDate;
	private Date _modifiedDate;
	private long _organizations_id;
}