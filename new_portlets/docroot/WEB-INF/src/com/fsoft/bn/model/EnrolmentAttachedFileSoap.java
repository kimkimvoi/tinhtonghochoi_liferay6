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
public class EnrolmentAttachedFileSoap implements Serializable {
	public static EnrolmentAttachedFileSoap toSoapModel(
		EnrolmentAttachedFile model) {
		EnrolmentAttachedFileSoap soapModel = new EnrolmentAttachedFileSoap();

		soapModel.setEnrolment_attached_id(model.getEnrolment_attached_id());
		soapModel.setEnrolment_id(model.getEnrolment_id());
		soapModel.setAttached_file_id(model.getAttached_file_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static EnrolmentAttachedFileSoap[] toSoapModels(
		EnrolmentAttachedFile[] models) {
		EnrolmentAttachedFileSoap[] soapModels = new EnrolmentAttachedFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnrolmentAttachedFileSoap[][] toSoapModels(
		EnrolmentAttachedFile[][] models) {
		EnrolmentAttachedFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnrolmentAttachedFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnrolmentAttachedFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnrolmentAttachedFileSoap[] toSoapModels(
		List<EnrolmentAttachedFile> models) {
		List<EnrolmentAttachedFileSoap> soapModels = new ArrayList<EnrolmentAttachedFileSoap>(models.size());

		for (EnrolmentAttachedFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnrolmentAttachedFileSoap[soapModels.size()]);
	}

	public EnrolmentAttachedFileSoap() {
	}

	public String getPrimaryKey() {
		return _enrolment_attached_id;
	}

	public void setPrimaryKey(String pk) {
		setEnrolment_attached_id(pk);
	}

	public String getEnrolment_attached_id() {
		return _enrolment_attached_id;
	}

	public void setEnrolment_attached_id(String enrolment_attached_id) {
		_enrolment_attached_id = enrolment_attached_id;
	}

	public String getEnrolment_id() {
		return _enrolment_id;
	}

	public void setEnrolment_id(String enrolment_id) {
		_enrolment_id = enrolment_id;
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

	private String _enrolment_attached_id;
	private String _enrolment_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}