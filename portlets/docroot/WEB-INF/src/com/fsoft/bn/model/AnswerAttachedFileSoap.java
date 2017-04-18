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
public class AnswerAttachedFileSoap implements Serializable {
	public static AnswerAttachedFileSoap toSoapModel(AnswerAttachedFile model) {
		AnswerAttachedFileSoap soapModel = new AnswerAttachedFileSoap();

		soapModel.setAnswer_attached_id(model.getAnswer_attached_id());
		soapModel.setAnswer_id(model.getAnswer_id());
		soapModel.setAttached_file_id(model.getAttached_file_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static AnswerAttachedFileSoap[] toSoapModels(
		AnswerAttachedFile[] models) {
		AnswerAttachedFileSoap[] soapModels = new AnswerAttachedFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnswerAttachedFileSoap[][] toSoapModels(
		AnswerAttachedFile[][] models) {
		AnswerAttachedFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnswerAttachedFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnswerAttachedFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnswerAttachedFileSoap[] toSoapModels(
		List<AnswerAttachedFile> models) {
		List<AnswerAttachedFileSoap> soapModels = new ArrayList<AnswerAttachedFileSoap>(models.size());

		for (AnswerAttachedFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnswerAttachedFileSoap[soapModels.size()]);
	}

	public AnswerAttachedFileSoap() {
	}

	public String getPrimaryKey() {
		return _answer_attached_id;
	}

	public void setPrimaryKey(String pk) {
		setAnswer_attached_id(pk);
	}

	public String getAnswer_attached_id() {
		return _answer_attached_id;
	}

	public void setAnswer_attached_id(String answer_attached_id) {
		_answer_attached_id = answer_attached_id;
	}

	public String getAnswer_id() {
		return _answer_id;
	}

	public void setAnswer_id(String answer_id) {
		_answer_id = answer_id;
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

	private String _answer_attached_id;
	private String _answer_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}