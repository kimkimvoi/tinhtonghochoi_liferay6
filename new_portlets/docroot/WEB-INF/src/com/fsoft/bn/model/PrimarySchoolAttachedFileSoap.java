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
public class PrimarySchoolAttachedFileSoap implements Serializable {
	public static PrimarySchoolAttachedFileSoap toSoapModel(
		PrimarySchoolAttachedFile model) {
		PrimarySchoolAttachedFileSoap soapModel = new PrimarySchoolAttachedFileSoap();

		soapModel.setPrimarySchool_attached_id(model.getPrimarySchool_attached_id());
		soapModel.setPrimaryStudent_id(model.getPrimaryStudent_id());
		soapModel.setAttached_file_id(model.getAttached_file_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static PrimarySchoolAttachedFileSoap[] toSoapModels(
		PrimarySchoolAttachedFile[] models) {
		PrimarySchoolAttachedFileSoap[] soapModels = new PrimarySchoolAttachedFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PrimarySchoolAttachedFileSoap[][] toSoapModels(
		PrimarySchoolAttachedFile[][] models) {
		PrimarySchoolAttachedFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PrimarySchoolAttachedFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PrimarySchoolAttachedFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PrimarySchoolAttachedFileSoap[] toSoapModels(
		List<PrimarySchoolAttachedFile> models) {
		List<PrimarySchoolAttachedFileSoap> soapModels = new ArrayList<PrimarySchoolAttachedFileSoap>(models.size());

		for (PrimarySchoolAttachedFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PrimarySchoolAttachedFileSoap[soapModels.size()]);
	}

	public PrimarySchoolAttachedFileSoap() {
	}

	public String getPrimaryKey() {
		return _primarySchool_attached_id;
	}

	public void setPrimaryKey(String pk) {
		setPrimarySchool_attached_id(pk);
	}

	public String getPrimarySchool_attached_id() {
		return _primarySchool_attached_id;
	}

	public void setPrimarySchool_attached_id(String primarySchool_attached_id) {
		_primarySchool_attached_id = primarySchool_attached_id;
	}

	public String getPrimaryStudent_id() {
		return _primaryStudent_id;
	}

	public void setPrimaryStudent_id(String primaryStudent_id) {
		_primaryStudent_id = primaryStudent_id;
	}

	public String getAttached_file_id() {
		return _attached_file_id;
	}

	public void setAttached_file_id(String attached_file_id) {
		_attached_file_id = attached_file_id;
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

	private String _primarySchool_attached_id;
	private String _primaryStudent_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}