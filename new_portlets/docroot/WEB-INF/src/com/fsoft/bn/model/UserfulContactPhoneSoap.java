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
public class UserfulContactPhoneSoap implements Serializable {
	public static UserfulContactPhoneSoap toSoapModel(UserfulContactPhone model) {
		UserfulContactPhoneSoap soapModel = new UserfulContactPhoneSoap();

		soapModel.setUserful_contact_phone_id(model.getUserful_contact_phone_id());
		soapModel.setUserful_contact_name(model.getUserful_contact_name());
		soapModel.setUserful_contact_phone(model.getUserful_contact_phone());
		soapModel.setUserful_contact_email(model.getUserful_contact_email());
		soapModel.setUserful_contact_position(model.getUserful_contact_position());
		soapModel.setUserful_contact_address(model.getUserful_contact_address());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static UserfulContactPhoneSoap[] toSoapModels(
		UserfulContactPhone[] models) {
		UserfulContactPhoneSoap[] soapModels = new UserfulContactPhoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserfulContactPhoneSoap[][] toSoapModels(
		UserfulContactPhone[][] models) {
		UserfulContactPhoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserfulContactPhoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserfulContactPhoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserfulContactPhoneSoap[] toSoapModels(
		List<UserfulContactPhone> models) {
		List<UserfulContactPhoneSoap> soapModels = new ArrayList<UserfulContactPhoneSoap>(models.size());

		for (UserfulContactPhone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserfulContactPhoneSoap[soapModels.size()]);
	}

	public UserfulContactPhoneSoap() {
	}

	public String getPrimaryKey() {
		return _userful_contact_phone_id;
	}

	public void setPrimaryKey(String pk) {
		setUserful_contact_phone_id(pk);
	}

	public String getUserful_contact_phone_id() {
		return _userful_contact_phone_id;
	}

	public void setUserful_contact_phone_id(String userful_contact_phone_id) {
		_userful_contact_phone_id = userful_contact_phone_id;
	}

	public String getUserful_contact_name() {
		return _userful_contact_name;
	}

	public void setUserful_contact_name(String userful_contact_name) {
		_userful_contact_name = userful_contact_name;
	}

	public String getUserful_contact_phone() {
		return _userful_contact_phone;
	}

	public void setUserful_contact_phone(String userful_contact_phone) {
		_userful_contact_phone = userful_contact_phone;
	}

	public String getUserful_contact_email() {
		return _userful_contact_email;
	}

	public void setUserful_contact_email(String userful_contact_email) {
		_userful_contact_email = userful_contact_email;
	}

	public String getUserful_contact_position() {
		return _userful_contact_position;
	}

	public void setUserful_contact_position(String userful_contact_position) {
		_userful_contact_position = userful_contact_position;
	}

	public String getUserful_contact_address() {
		return _userful_contact_address;
	}

	public void setUserful_contact_address(String userful_contact_address) {
		_userful_contact_address = userful_contact_address;
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

	private String _userful_contact_phone_id;
	private String _userful_contact_name;
	private String _userful_contact_phone;
	private String _userful_contact_email;
	private String _userful_contact_position;
	private String _userful_contact_address;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}