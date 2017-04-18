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
public class QuestionSoap implements Serializable {
	public static QuestionSoap toSoapModel(Question model) {
		QuestionSoap soapModel = new QuestionSoap();

		soapModel.setQuestion_id(model.getQuestion_id());
		soapModel.setQuestion_title(model.getQuestion_title());
		soapModel.setQuestion_type_id(model.getQuestion_type_id());
		soapModel.setQuestion_content(model.getQuestion_content());
		soapModel.setCitizen_name(model.getCitizen_name());
		soapModel.setCitizen_mail(model.getCitizen_mail());
		soapModel.setCitizen_phone(model.getCitizen_phone());
		soapModel.setCitizen_address(model.getCitizen_address());
		soapModel.setQuestion_status_id(model.getQuestion_status_id());
		soapModel.setAnswer_id(model.getAnswer_id());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static QuestionSoap[] toSoapModels(Question[] models) {
		QuestionSoap[] soapModels = new QuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionSoap[][] toSoapModels(Question[][] models) {
		QuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionSoap[] toSoapModels(List<Question> models) {
		List<QuestionSoap> soapModels = new ArrayList<QuestionSoap>(models.size());

		for (Question model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionSoap[soapModels.size()]);
	}

	public QuestionSoap() {
	}

	public String getPrimaryKey() {
		return _question_id;
	}

	public void setPrimaryKey(String pk) {
		setQuestion_id(pk);
	}

	public String getQuestion_id() {
		return _question_id;
	}

	public void setQuestion_id(String question_id) {
		_question_id = question_id;
	}

	public String getQuestion_title() {
		return _question_title;
	}

	public void setQuestion_title(String question_title) {
		_question_title = question_title;
	}

	public String getQuestion_type_id() {
		return _question_type_id;
	}

	public void setQuestion_type_id(String question_type_id) {
		_question_type_id = question_type_id;
	}

	public String getQuestion_content() {
		return _question_content;
	}

	public void setQuestion_content(String question_content) {
		_question_content = question_content;
	}

	public String getCitizen_name() {
		return _citizen_name;
	}

	public void setCitizen_name(String citizen_name) {
		_citizen_name = citizen_name;
	}

	public String getCitizen_mail() {
		return _citizen_mail;
	}

	public void setCitizen_mail(String citizen_mail) {
		_citizen_mail = citizen_mail;
	}

	public String getCitizen_phone() {
		return _citizen_phone;
	}

	public void setCitizen_phone(String citizen_phone) {
		_citizen_phone = citizen_phone;
	}

	public String getCitizen_address() {
		return _citizen_address;
	}

	public void setCitizen_address(String citizen_address) {
		_citizen_address = citizen_address;
	}

	public String getQuestion_status_id() {
		return _question_status_id;
	}

	public void setQuestion_status_id(String question_status_id) {
		_question_status_id = question_status_id;
	}

	public String getAnswer_id() {
		return _answer_id;
	}

	public void setAnswer_id(String answer_id) {
		_answer_id = answer_id;
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

	private String _question_id;
	private String _question_title;
	private String _question_type_id;
	private String _question_content;
	private String _citizen_name;
	private String _citizen_mail;
	private String _citizen_phone;
	private String _citizen_address;
	private String _question_status_id;
	private String _answer_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}