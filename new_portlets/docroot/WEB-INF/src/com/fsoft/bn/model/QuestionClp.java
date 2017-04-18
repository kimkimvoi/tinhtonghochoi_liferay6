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

import com.fsoft.bn.service.QuestionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FSOFT
 */
public class QuestionClp extends BaseModelImpl<Question> implements Question {
	public QuestionClp() {
	}

	public Class<?> getModelClass() {
		return Question.class;
	}

	public String getModelClassName() {
		return Question.class.getName();
	}

	public String getPrimaryKey() {
		return _question_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setQuestion_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _question_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("question_id", getQuestion_id());
		attributes.put("question_title", getQuestion_title());
		attributes.put("question_type_id", getQuestion_type_id());
		attributes.put("question_content", getQuestion_content());
		attributes.put("citizen_name", getCitizen_name());
		attributes.put("citizen_mail", getCitizen_mail());
		attributes.put("citizen_phone", getCitizen_phone());
		attributes.put("citizen_address", getCitizen_address());
		attributes.put("question_status_id", getQuestion_status_id());
		attributes.put("answer_id", getAnswer_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String question_id = (String)attributes.get("question_id");

		if (question_id != null) {
			setQuestion_id(question_id);
		}

		String question_title = (String)attributes.get("question_title");

		if (question_title != null) {
			setQuestion_title(question_title);
		}

		String question_type_id = (String)attributes.get("question_type_id");

		if (question_type_id != null) {
			setQuestion_type_id(question_type_id);
		}

		String question_content = (String)attributes.get("question_content");

		if (question_content != null) {
			setQuestion_content(question_content);
		}

		String citizen_name = (String)attributes.get("citizen_name");

		if (citizen_name != null) {
			setCitizen_name(citizen_name);
		}

		String citizen_mail = (String)attributes.get("citizen_mail");

		if (citizen_mail != null) {
			setCitizen_mail(citizen_mail);
		}

		String citizen_phone = (String)attributes.get("citizen_phone");

		if (citizen_phone != null) {
			setCitizen_phone(citizen_phone);
		}

		String citizen_address = (String)attributes.get("citizen_address");

		if (citizen_address != null) {
			setCitizen_address(citizen_address);
		}

		String question_status_id = (String)attributes.get("question_status_id");

		if (question_status_id != null) {
			setQuestion_status_id(question_status_id);
		}

		String answer_id = (String)attributes.get("answer_id");

		if (answer_id != null) {
			setAnswer_id(answer_id);
		}

		Date created_date = (Date)attributes.get("created_date");

		if (created_date != null) {
			setCreated_date(created_date);
		}

		Date modified_date = (Date)attributes.get("modified_date");

		if (modified_date != null) {
			setModified_date(modified_date);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
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

	public java.lang.String getDateDisplay() {
		throw new UnsupportedOperationException();
	}

	public void setStatusDisplay(java.lang.String statusDisplay) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getStatusDisplay() {
		throw new UnsupportedOperationException();
	}

	public void setDateDisplay(java.lang.String dateDisplay) {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getQuestionRemoteModel() {
		return _questionRemoteModel;
	}

	public void setQuestionRemoteModel(BaseModel<?> questionRemoteModel) {
		_questionRemoteModel = questionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			QuestionLocalServiceUtil.addQuestion(this);
		}
		else {
			QuestionLocalServiceUtil.updateQuestion(this);
		}
	}

	@Override
	public Question toEscapedModel() {
		return (Question)Proxy.newProxyInstance(Question.class.getClassLoader(),
			new Class[] { Question.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionClp clone = new QuestionClp();

		clone.setQuestion_id(getQuestion_id());
		clone.setQuestion_title(getQuestion_title());
		clone.setQuestion_type_id(getQuestion_type_id());
		clone.setQuestion_content(getQuestion_content());
		clone.setCitizen_name(getCitizen_name());
		clone.setCitizen_mail(getCitizen_mail());
		clone.setCitizen_phone(getCitizen_phone());
		clone.setCitizen_address(getCitizen_address());
		clone.setQuestion_status_id(getQuestion_status_id());
		clone.setAnswer_id(getAnswer_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(Question question) {
		String primaryKey = question.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		QuestionClp question = null;

		try {
			question = (QuestionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = question.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{question_id=");
		sb.append(getQuestion_id());
		sb.append(", question_title=");
		sb.append(getQuestion_title());
		sb.append(", question_type_id=");
		sb.append(getQuestion_type_id());
		sb.append(", question_content=");
		sb.append(getQuestion_content());
		sb.append(", citizen_name=");
		sb.append(getCitizen_name());
		sb.append(", citizen_mail=");
		sb.append(getCitizen_mail());
		sb.append(", citizen_phone=");
		sb.append(getCitizen_phone());
		sb.append(", citizen_address=");
		sb.append(getCitizen_address());
		sb.append(", question_status_id=");
		sb.append(getQuestion_status_id());
		sb.append(", answer_id=");
		sb.append(getAnswer_id());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", modified_date=");
		sb.append(getModified_date());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.Question");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>question_id</column-name><column-value><![CDATA[");
		sb.append(getQuestion_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question_title</column-name><column-value><![CDATA[");
		sb.append(getQuestion_title());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question_type_id</column-name><column-value><![CDATA[");
		sb.append(getQuestion_type_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question_content</column-name><column-value><![CDATA[");
		sb.append(getQuestion_content());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizen_name</column-name><column-value><![CDATA[");
		sb.append(getCitizen_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizen_mail</column-name><column-value><![CDATA[");
		sb.append(getCitizen_mail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizen_phone</column-name><column-value><![CDATA[");
		sb.append(getCitizen_phone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizen_address</column-name><column-value><![CDATA[");
		sb.append(getCitizen_address());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question_status_id</column-name><column-value><![CDATA[");
		sb.append(getQuestion_status_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer_id</column-name><column-value><![CDATA[");
		sb.append(getAnswer_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created_date</column-name><column-value><![CDATA[");
		sb.append(getCreated_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modified_date</column-name><column-value><![CDATA[");
		sb.append(getModified_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _questionRemoteModel;
}