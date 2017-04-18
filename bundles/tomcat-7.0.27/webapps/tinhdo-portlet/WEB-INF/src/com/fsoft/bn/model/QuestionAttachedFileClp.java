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

import com.fsoft.bn.service.QuestionAttachedFileLocalServiceUtil;

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
public class QuestionAttachedFileClp extends BaseModelImpl<QuestionAttachedFile>
	implements QuestionAttachedFile {
	public QuestionAttachedFileClp() {
	}

	public Class<?> getModelClass() {
		return QuestionAttachedFile.class;
	}

	public String getModelClassName() {
		return QuestionAttachedFile.class.getName();
	}

	public String getPrimaryKey() {
		return _question_attached_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setQuestion_attached_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _question_attached_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("question_attached_id", getQuestion_attached_id());
		attributes.put("question_id", getQuestion_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String question_attached_id = (String)attributes.get(
				"question_attached_id");

		if (question_attached_id != null) {
			setQuestion_attached_id(question_attached_id);
		}

		String question_id = (String)attributes.get("question_id");

		if (question_id != null) {
			setQuestion_id(question_id);
		}

		String attached_file_id = (String)attributes.get("attached_file_id");

		if (attached_file_id != null) {
			setAttached_file_id(attached_file_id);
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

	public String getQuestion_attached_id() {
		return _question_attached_id;
	}

	public void setQuestion_attached_id(String question_attached_id) {
		_question_attached_id = question_attached_id;
	}

	public String getQuestion_id() {
		return _question_id;
	}

	public void setQuestion_id(String question_id) {
		_question_id = question_id;
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

	public BaseModel<?> getQuestionAttachedFileRemoteModel() {
		return _questionAttachedFileRemoteModel;
	}

	public void setQuestionAttachedFileRemoteModel(
		BaseModel<?> questionAttachedFileRemoteModel) {
		_questionAttachedFileRemoteModel = questionAttachedFileRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			QuestionAttachedFileLocalServiceUtil.addQuestionAttachedFile(this);
		}
		else {
			QuestionAttachedFileLocalServiceUtil.updateQuestionAttachedFile(this);
		}
	}

	@Override
	public QuestionAttachedFile toEscapedModel() {
		return (QuestionAttachedFile)Proxy.newProxyInstance(QuestionAttachedFile.class.getClassLoader(),
			new Class[] { QuestionAttachedFile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionAttachedFileClp clone = new QuestionAttachedFileClp();

		clone.setQuestion_attached_id(getQuestion_attached_id());
		clone.setQuestion_id(getQuestion_id());
		clone.setAttached_file_id(getAttached_file_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(QuestionAttachedFile questionAttachedFile) {
		String primaryKey = questionAttachedFile.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		QuestionAttachedFileClp questionAttachedFile = null;

		try {
			questionAttachedFile = (QuestionAttachedFileClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = questionAttachedFile.getPrimaryKey();

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

		sb.append("{question_attached_id=");
		sb.append(getQuestion_attached_id());
		sb.append(", question_id=");
		sb.append(getQuestion_id());
		sb.append(", attached_file_id=");
		sb.append(getAttached_file_id());
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
		sb.append("com.fsoft.bn.model.QuestionAttachedFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>question_attached_id</column-name><column-value><![CDATA[");
		sb.append(getQuestion_attached_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question_id</column-name><column-value><![CDATA[");
		sb.append(getQuestion_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attached_file_id</column-name><column-value><![CDATA[");
		sb.append(getAttached_file_id());
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

	private String _question_attached_id;
	private String _question_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _questionAttachedFileRemoteModel;
}