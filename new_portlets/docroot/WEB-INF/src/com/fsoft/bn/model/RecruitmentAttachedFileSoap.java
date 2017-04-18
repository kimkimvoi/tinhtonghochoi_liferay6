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
public class RecruitmentAttachedFileSoap implements Serializable {
	public static RecruitmentAttachedFileSoap toSoapModel(
		RecruitmentAttachedFile model) {
		RecruitmentAttachedFileSoap soapModel = new RecruitmentAttachedFileSoap();

		soapModel.setRecruitment_attached_id(model.getRecruitment_attached_id());
		soapModel.setRecruitment_id(model.getRecruitment_id());
		soapModel.setAttached_file_id(model.getAttached_file_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static RecruitmentAttachedFileSoap[] toSoapModels(
		RecruitmentAttachedFile[] models) {
		RecruitmentAttachedFileSoap[] soapModels = new RecruitmentAttachedFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentAttachedFileSoap[][] toSoapModels(
		RecruitmentAttachedFile[][] models) {
		RecruitmentAttachedFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecruitmentAttachedFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecruitmentAttachedFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentAttachedFileSoap[] toSoapModels(
		List<RecruitmentAttachedFile> models) {
		List<RecruitmentAttachedFileSoap> soapModels = new ArrayList<RecruitmentAttachedFileSoap>(models.size());

		for (RecruitmentAttachedFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecruitmentAttachedFileSoap[soapModels.size()]);
	}

	public RecruitmentAttachedFileSoap() {
	}

	public String getPrimaryKey() {
		return _recruitment_attached_id;
	}

	public void setPrimaryKey(String pk) {
		setRecruitment_attached_id(pk);
	}

	public String getRecruitment_attached_id() {
		return _recruitment_attached_id;
	}

	public void setRecruitment_attached_id(String recruitment_attached_id) {
		_recruitment_attached_id = recruitment_attached_id;
	}

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
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

	private String _recruitment_attached_id;
	private String _recruitment_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}