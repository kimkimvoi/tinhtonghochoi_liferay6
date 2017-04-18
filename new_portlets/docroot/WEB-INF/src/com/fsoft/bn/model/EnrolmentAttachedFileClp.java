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

import com.fsoft.bn.service.EnrolmentAttachedFileLocalServiceUtil;

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
public class EnrolmentAttachedFileClp extends BaseModelImpl<EnrolmentAttachedFile>
	implements EnrolmentAttachedFile {
	public EnrolmentAttachedFileClp() {
	}

	public Class<?> getModelClass() {
		return EnrolmentAttachedFile.class;
	}

	public String getModelClassName() {
		return EnrolmentAttachedFile.class.getName();
	}

	public String getPrimaryKey() {
		return _enrolment_attached_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setEnrolment_attached_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _enrolment_attached_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("enrolment_attached_id", getEnrolment_attached_id());
		attributes.put("enrolment_id", getEnrolment_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String enrolment_attached_id = (String)attributes.get(
				"enrolment_attached_id");

		if (enrolment_attached_id != null) {
			setEnrolment_attached_id(enrolment_attached_id);
		}

		String enrolment_id = (String)attributes.get("enrolment_id");

		if (enrolment_id != null) {
			setEnrolment_id(enrolment_id);
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

	public BaseModel<?> getEnrolmentAttachedFileRemoteModel() {
		return _enrolmentAttachedFileRemoteModel;
	}

	public void setEnrolmentAttachedFileRemoteModel(
		BaseModel<?> enrolmentAttachedFileRemoteModel) {
		_enrolmentAttachedFileRemoteModel = enrolmentAttachedFileRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EnrolmentAttachedFileLocalServiceUtil.addEnrolmentAttachedFile(this);
		}
		else {
			EnrolmentAttachedFileLocalServiceUtil.updateEnrolmentAttachedFile(this);
		}
	}

	@Override
	public EnrolmentAttachedFile toEscapedModel() {
		return (EnrolmentAttachedFile)Proxy.newProxyInstance(EnrolmentAttachedFile.class.getClassLoader(),
			new Class[] { EnrolmentAttachedFile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EnrolmentAttachedFileClp clone = new EnrolmentAttachedFileClp();

		clone.setEnrolment_attached_id(getEnrolment_attached_id());
		clone.setEnrolment_id(getEnrolment_id());
		clone.setAttached_file_id(getAttached_file_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(EnrolmentAttachedFile enrolmentAttachedFile) {
		String primaryKey = enrolmentAttachedFile.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EnrolmentAttachedFileClp enrolmentAttachedFile = null;

		try {
			enrolmentAttachedFile = (EnrolmentAttachedFileClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = enrolmentAttachedFile.getPrimaryKey();

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

		sb.append("{enrolment_attached_id=");
		sb.append(getEnrolment_attached_id());
		sb.append(", enrolment_id=");
		sb.append(getEnrolment_id());
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
		sb.append("com.fsoft.bn.model.EnrolmentAttachedFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>enrolment_attached_id</column-name><column-value><![CDATA[");
		sb.append(getEnrolment_attached_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enrolment_id</column-name><column-value><![CDATA[");
		sb.append(getEnrolment_id());
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

	private String _enrolment_attached_id;
	private String _enrolment_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _enrolmentAttachedFileRemoteModel;
}