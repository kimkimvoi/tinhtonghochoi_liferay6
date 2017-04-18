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

import com.fsoft.bn.service.JobTitleLocalServiceUtil;

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
public class JobTitleClp extends BaseModelImpl<JobTitle> implements JobTitle {
	public JobTitleClp() {
	}

	public Class<?> getModelClass() {
		return JobTitle.class;
	}

	public String getModelClassName() {
		return JobTitle.class.getName();
	}

	public String getPrimaryKey() {
		return _job_title_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setJob_title_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _job_title_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("job_title_id", getJob_title_id());
		attributes.put("user_id", getUser_id());
		attributes.put("job_id", getJob_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String job_title_id = (String)attributes.get("job_title_id");

		if (job_title_id != null) {
			setJob_title_id(job_title_id);
		}

		String user_id = (String)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		String job_id = (String)attributes.get("job_id");

		if (job_id != null) {
			setJob_id(job_id);
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

	public String getJob_title_id() {
		return _job_title_id;
	}

	public void setJob_title_id(String job_title_id) {
		_job_title_id = job_title_id;
	}

	public String getUser_id() {
		return _user_id;
	}

	public void setUser_id(String user_id) {
		_user_id = user_id;
	}

	public String getJob_id() {
		return _job_id;
	}

	public void setJob_id(String job_id) {
		_job_id = job_id;
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

	public BaseModel<?> getJobTitleRemoteModel() {
		return _jobTitleRemoteModel;
	}

	public void setJobTitleRemoteModel(BaseModel<?> jobTitleRemoteModel) {
		_jobTitleRemoteModel = jobTitleRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			JobTitleLocalServiceUtil.addJobTitle(this);
		}
		else {
			JobTitleLocalServiceUtil.updateJobTitle(this);
		}
	}

	@Override
	public JobTitle toEscapedModel() {
		return (JobTitle)Proxy.newProxyInstance(JobTitle.class.getClassLoader(),
			new Class[] { JobTitle.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JobTitleClp clone = new JobTitleClp();

		clone.setJob_title_id(getJob_title_id());
		clone.setUser_id(getUser_id());
		clone.setJob_id(getJob_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(JobTitle jobTitle) {
		String primaryKey = jobTitle.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		JobTitleClp jobTitle = null;

		try {
			jobTitle = (JobTitleClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = jobTitle.getPrimaryKey();

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

		sb.append("{job_title_id=");
		sb.append(getJob_title_id());
		sb.append(", user_id=");
		sb.append(getUser_id());
		sb.append(", job_id=");
		sb.append(getJob_id());
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
		sb.append("com.fsoft.bn.model.JobTitle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>job_title_id</column-name><column-value><![CDATA[");
		sb.append(getJob_title_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>user_id</column-name><column-value><![CDATA[");
		sb.append(getUser_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>job_id</column-name><column-value><![CDATA[");
		sb.append(getJob_id());
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

	private String _job_title_id;
	private String _user_id;
	private String _job_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _jobTitleRemoteModel;
}