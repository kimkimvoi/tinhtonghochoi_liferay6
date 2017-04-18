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

import com.fsoft.bn.service.AnswerAttachedFileLocalServiceUtil;

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
public class AnswerAttachedFileClp extends BaseModelImpl<AnswerAttachedFile>
	implements AnswerAttachedFile {
	public AnswerAttachedFileClp() {
	}

	public Class<?> getModelClass() {
		return AnswerAttachedFile.class;
	}

	public String getModelClassName() {
		return AnswerAttachedFile.class.getName();
	}

	public String getPrimaryKey() {
		return _answer_attached_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setAnswer_attached_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _answer_attached_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("answer_attached_id", getAnswer_attached_id());
		attributes.put("answer_id", getAnswer_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String answer_attached_id = (String)attributes.get("answer_attached_id");

		if (answer_attached_id != null) {
			setAnswer_attached_id(answer_attached_id);
		}

		String answer_id = (String)attributes.get("answer_id");

		if (answer_id != null) {
			setAnswer_id(answer_id);
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

	public BaseModel<?> getAnswerAttachedFileRemoteModel() {
		return _answerAttachedFileRemoteModel;
	}

	public void setAnswerAttachedFileRemoteModel(
		BaseModel<?> answerAttachedFileRemoteModel) {
		_answerAttachedFileRemoteModel = answerAttachedFileRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AnswerAttachedFileLocalServiceUtil.addAnswerAttachedFile(this);
		}
		else {
			AnswerAttachedFileLocalServiceUtil.updateAnswerAttachedFile(this);
		}
	}

	@Override
	public AnswerAttachedFile toEscapedModel() {
		return (AnswerAttachedFile)Proxy.newProxyInstance(AnswerAttachedFile.class.getClassLoader(),
			new Class[] { AnswerAttachedFile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnswerAttachedFileClp clone = new AnswerAttachedFileClp();

		clone.setAnswer_attached_id(getAnswer_attached_id());
		clone.setAnswer_id(getAnswer_id());
		clone.setAttached_file_id(getAttached_file_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(AnswerAttachedFile answerAttachedFile) {
		String primaryKey = answerAttachedFile.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		AnswerAttachedFileClp answerAttachedFile = null;

		try {
			answerAttachedFile = (AnswerAttachedFileClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = answerAttachedFile.getPrimaryKey();

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

		sb.append("{answer_attached_id=");
		sb.append(getAnswer_attached_id());
		sb.append(", answer_id=");
		sb.append(getAnswer_id());
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
		sb.append("com.fsoft.bn.model.AnswerAttachedFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>answer_attached_id</column-name><column-value><![CDATA[");
		sb.append(getAnswer_attached_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer_id</column-name><column-value><![CDATA[");
		sb.append(getAnswer_id());
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

	private String _answer_attached_id;
	private String _answer_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _answerAttachedFileRemoteModel;
}