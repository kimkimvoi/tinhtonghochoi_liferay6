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
public class UserScheduleSoap implements Serializable {
	public static UserScheduleSoap toSoapModel(UserSchedule model) {
		UserScheduleSoap soapModel = new UserScheduleSoap();

		soapModel.setUser_schedule_id(model.getUser_schedule_id());
		soapModel.setUser_id(model.getUser_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static UserScheduleSoap[] toSoapModels(UserSchedule[] models) {
		UserScheduleSoap[] soapModels = new UserScheduleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserScheduleSoap[][] toSoapModels(UserSchedule[][] models) {
		UserScheduleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserScheduleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserScheduleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserScheduleSoap[] toSoapModels(List<UserSchedule> models) {
		List<UserScheduleSoap> soapModels = new ArrayList<UserScheduleSoap>(models.size());

		for (UserSchedule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserScheduleSoap[soapModels.size()]);
	}

	public UserScheduleSoap() {
	}

	public String getPrimaryKey() {
		return _user_schedule_id;
	}

	public void setPrimaryKey(String pk) {
		setUser_schedule_id(pk);
	}

	public String getUser_schedule_id() {
		return _user_schedule_id;
	}

	public void setUser_schedule_id(String user_schedule_id) {
		_user_schedule_id = user_schedule_id;
	}

	public String getUser_id() {
		return _user_id;
	}

	public void setUser_id(String user_id) {
		_user_id = user_id;
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

	private String _user_schedule_id;
	private String _user_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}