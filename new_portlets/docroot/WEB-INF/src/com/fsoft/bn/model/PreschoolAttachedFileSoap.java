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
public class PreschoolAttachedFileSoap implements Serializable {
	public static PreschoolAttachedFileSoap toSoapModel(
		PreschoolAttachedFile model) {
		PreschoolAttachedFileSoap soapModel = new PreschoolAttachedFileSoap();

		soapModel.setPreschool_attached_id(model.getPreschool_attached_id());
		soapModel.setStudent_id(model.getStudent_id());
		soapModel.setAttached_file_id(model.getAttached_file_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static PreschoolAttachedFileSoap[] toSoapModels(
		PreschoolAttachedFile[] models) {
		PreschoolAttachedFileSoap[] soapModels = new PreschoolAttachedFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PreschoolAttachedFileSoap[][] toSoapModels(
		PreschoolAttachedFile[][] models) {
		PreschoolAttachedFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PreschoolAttachedFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PreschoolAttachedFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PreschoolAttachedFileSoap[] toSoapModels(
		List<PreschoolAttachedFile> models) {
		List<PreschoolAttachedFileSoap> soapModels = new ArrayList<PreschoolAttachedFileSoap>(models.size());

		for (PreschoolAttachedFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PreschoolAttachedFileSoap[soapModels.size()]);
	}

	public PreschoolAttachedFileSoap() {
	}

	public String getPrimaryKey() {
		return _preschool_attached_id;
	}

	public void setPrimaryKey(String pk) {
		setPreschool_attached_id(pk);
	}

	public String getPreschool_attached_id() {
		return _preschool_attached_id;
	}

	public void setPreschool_attached_id(String preschool_attached_id) {
		_preschool_attached_id = preschool_attached_id;
	}

	public String getStudent_id() {
		return _student_id;
	}

	public void setStudent_id(String student_id) {
		_student_id = student_id;
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

	private String _preschool_attached_id;
	private String _student_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}