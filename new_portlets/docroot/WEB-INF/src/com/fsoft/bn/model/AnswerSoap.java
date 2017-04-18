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
public class AnswerSoap implements Serializable {
	public static AnswerSoap toSoapModel(Answer model) {
		AnswerSoap soapModel = new AnswerSoap();

		soapModel.setAnswer_id(model.getAnswer_id());
		soapModel.setAnswer_content(model.getAnswer_content());
		soapModel.setUser_id(model.getUser_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static AnswerSoap[] toSoapModels(Answer[] models) {
		AnswerSoap[] soapModels = new AnswerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnswerSoap[][] toSoapModels(Answer[][] models) {
		AnswerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnswerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnswerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnswerSoap[] toSoapModels(List<Answer> models) {
		List<AnswerSoap> soapModels = new ArrayList<AnswerSoap>(models.size());

		for (Answer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnswerSoap[soapModels.size()]);
	}

	public AnswerSoap() {
	}

	public String getPrimaryKey() {
		return _answer_id;
	}

	public void setPrimaryKey(String pk) {
		setAnswer_id(pk);
	}

	public String getAnswer_id() {
		return _answer_id;
	}

	public void setAnswer_id(String answer_id) {
		_answer_id = answer_id;
	}

	public String getAnswer_content() {
		return _answer_content;
	}

	public void setAnswer_content(String answer_content) {
		_answer_content = answer_content;
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

	private String _answer_id;
	private String _answer_content;
	private String _user_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}