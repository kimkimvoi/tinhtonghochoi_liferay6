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

import com.fsoft.bn.service.RecruitmentAttachedFileLocalServiceUtil;

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
public class RecruitmentAttachedFileClp extends BaseModelImpl<RecruitmentAttachedFile>
	implements RecruitmentAttachedFile {
	public RecruitmentAttachedFileClp() {
	}

	public Class<?> getModelClass() {
		return RecruitmentAttachedFile.class;
	}

	public String getModelClassName() {
		return RecruitmentAttachedFile.class.getName();
	}

	public String getPrimaryKey() {
		return _recruitment_attached_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setRecruitment_attached_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _recruitment_attached_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_attached_id", getRecruitment_attached_id());
		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_attached_id = (String)attributes.get(
				"recruitment_attached_id");

		if (recruitment_attached_id != null) {
			setRecruitment_attached_id(recruitment_attached_id);
		}

		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
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

	public BaseModel<?> getRecruitmentAttachedFileRemoteModel() {
		return _recruitmentAttachedFileRemoteModel;
	}

	public void setRecruitmentAttachedFileRemoteModel(
		BaseModel<?> recruitmentAttachedFileRemoteModel) {
		_recruitmentAttachedFileRemoteModel = recruitmentAttachedFileRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			RecruitmentAttachedFileLocalServiceUtil.addRecruitmentAttachedFile(this);
		}
		else {
			RecruitmentAttachedFileLocalServiceUtil.updateRecruitmentAttachedFile(this);
		}
	}

	@Override
	public RecruitmentAttachedFile toEscapedModel() {
		return (RecruitmentAttachedFile)Proxy.newProxyInstance(RecruitmentAttachedFile.class.getClassLoader(),
			new Class[] { RecruitmentAttachedFile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RecruitmentAttachedFileClp clone = new RecruitmentAttachedFileClp();

		clone.setRecruitment_attached_id(getRecruitment_attached_id());
		clone.setRecruitment_id(getRecruitment_id());
		clone.setAttached_file_id(getAttached_file_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(RecruitmentAttachedFile recruitmentAttachedFile) {
		String primaryKey = recruitmentAttachedFile.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RecruitmentAttachedFileClp recruitmentAttachedFile = null;

		try {
			recruitmentAttachedFile = (RecruitmentAttachedFileClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = recruitmentAttachedFile.getPrimaryKey();

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

		sb.append("{recruitment_attached_id=");
		sb.append(getRecruitment_attached_id());
		sb.append(", recruitment_id=");
		sb.append(getRecruitment_id());
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
		sb.append("com.fsoft.bn.model.RecruitmentAttachedFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recruitment_attached_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_attached_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recruitment_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_id());
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

	private String _recruitment_attached_id;
	private String _recruitment_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _recruitmentAttachedFileRemoteModel;
}