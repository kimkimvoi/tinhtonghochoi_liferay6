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

import com.fsoft.bn.service.AnswerLocalServiceUtil;

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
public class AnswerClp extends BaseModelImpl<Answer> implements Answer {
	public AnswerClp() {
	}

	public Class<?> getModelClass() {
		return Answer.class;
	}

	public String getModelClassName() {
		return Answer.class.getName();
	}

	public String getPrimaryKey() {
		return _answer_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setAnswer_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _answer_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("answer_id", getAnswer_id());
		attributes.put("answer_content", getAnswer_content());
		attributes.put("user_id", getUser_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String answer_id = (String)attributes.get("answer_id");

		if (answer_id != null) {
			setAnswer_id(answer_id);
		}

		String answer_content = (String)attributes.get("answer_content");

		if (answer_content != null) {
			setAnswer_content(answer_content);
		}

		String user_id = (String)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
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

	public void setFormatedCreatedDate(java.lang.String formatedCreatedDate) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getFormatedCreatedDate() {
		throw new UnsupportedOperationException();
	}

	public void setOrganizationName(java.lang.String organizationName) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getOrganizationName() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getAnswerRemoteModel() {
		return _answerRemoteModel;
	}

	public void setAnswerRemoteModel(BaseModel<?> answerRemoteModel) {
		_answerRemoteModel = answerRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AnswerLocalServiceUtil.addAnswer(this);
		}
		else {
			AnswerLocalServiceUtil.updateAnswer(this);
		}
	}

	@Override
	public Answer toEscapedModel() {
		return (Answer)Proxy.newProxyInstance(Answer.class.getClassLoader(),
			new Class[] { Answer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnswerClp clone = new AnswerClp();

		clone.setAnswer_id(getAnswer_id());
		clone.setAnswer_content(getAnswer_content());
		clone.setUser_id(getUser_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(Answer answer) {
		String primaryKey = answer.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		AnswerClp answer = null;

		try {
			answer = (AnswerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = answer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{answer_id=");
		sb.append(getAnswer_id());
		sb.append(", answer_content=");
		sb.append(getAnswer_content());
		sb.append(", user_id=");
		sb.append(getUser_id());
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
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.Answer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>answer_id</column-name><column-value><![CDATA[");
		sb.append(getAnswer_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer_content</column-name><column-value><![CDATA[");
		sb.append(getAnswer_content());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id</column-name><column-value><![CDATA[");
		sb.append(getUser_id());
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

	private String _answer_id;
	private String _answer_content;
	private String _user_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _answerRemoteModel;
}