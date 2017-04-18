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

package com.fsoft.bn.model.impl;

import com.fsoft.bn.model.JobTitle;
import com.fsoft.bn.model.JobTitleModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the JobTitle service. Represents a row in the &quot;BN_JobTitle&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsoft.bn.model.JobTitleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobTitleImpl}.
 * </p>
 *
 * @author FSOFT
 * @see JobTitleImpl
 * @see com.fsoft.bn.model.JobTitle
 * @see com.fsoft.bn.model.JobTitleModel
 * @generated
 */
public class JobTitleModelImpl extends BaseModelImpl<JobTitle>
	implements JobTitleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a job title model instance should use the {@link com.fsoft.bn.model.JobTitle} interface instead.
	 */
	public static final String TABLE_NAME = "BN_JobTitle";
	public static final Object[][] TABLE_COLUMNS = {
			{ "job_title_id", Types.VARCHAR },
			{ "user_id", Types.VARCHAR },
			{ "job_id", Types.VARCHAR },
			{ "created_date", Types.TIMESTAMP },
			{ "modified_date", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table BN_JobTitle (job_title_id VARCHAR(75) not null primary key,user_id VARCHAR(75) null,job_id VARCHAR(75) null,created_date DATE null,modified_date DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table BN_JobTitle";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fsoft.bn.model.JobTitle"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fsoft.bn.model.JobTitle"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.fsoft.bn.model.JobTitle"));

	public JobTitleModelImpl() {
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

	public Class<?> getModelClass() {
		return JobTitle.class;
	}

	public String getModelClassName() {
		return JobTitle.class.getName();
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
		if (_job_title_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _job_title_id;
		}
	}

	public void setJob_title_id(String job_title_id) {
		_job_title_id = job_title_id;
	}

	public String getUser_id() {
		if (_user_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _user_id;
		}
	}

	public void setUser_id(String user_id) {
		_user_id = user_id;
	}

	public String getJob_id() {
		if (_job_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _job_id;
		}
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

	@Override
	public JobTitle toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (JobTitle)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		JobTitleImpl jobTitleImpl = new JobTitleImpl();

		jobTitleImpl.setJob_title_id(getJob_title_id());
		jobTitleImpl.setUser_id(getUser_id());
		jobTitleImpl.setJob_id(getJob_id());
		jobTitleImpl.setCreated_date(getCreated_date());
		jobTitleImpl.setModified_date(getModified_date());
		jobTitleImpl.setDeleted(getDeleted());

		jobTitleImpl.resetOriginalValues();

		return jobTitleImpl;
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

		JobTitle jobTitle = null;

		try {
			jobTitle = (JobTitle)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<JobTitle> toCacheModel() {
		JobTitleCacheModel jobTitleCacheModel = new JobTitleCacheModel();

		jobTitleCacheModel.job_title_id = getJob_title_id();

		String job_title_id = jobTitleCacheModel.job_title_id;

		if ((job_title_id != null) && (job_title_id.length() == 0)) {
			jobTitleCacheModel.job_title_id = null;
		}

		jobTitleCacheModel.user_id = getUser_id();

		String user_id = jobTitleCacheModel.user_id;

		if ((user_id != null) && (user_id.length() == 0)) {
			jobTitleCacheModel.user_id = null;
		}

		jobTitleCacheModel.job_id = getJob_id();

		String job_id = jobTitleCacheModel.job_id;

		if ((job_id != null) && (job_id.length() == 0)) {
			jobTitleCacheModel.job_id = null;
		}

		Date created_date = getCreated_date();

		if (created_date != null) {
			jobTitleCacheModel.created_date = created_date.getTime();
		}
		else {
			jobTitleCacheModel.created_date = Long.MIN_VALUE;
		}

		Date modified_date = getModified_date();

		if (modified_date != null) {
			jobTitleCacheModel.modified_date = modified_date.getTime();
		}
		else {
			jobTitleCacheModel.modified_date = Long.MIN_VALUE;
		}

		jobTitleCacheModel.deleted = getDeleted();

		return jobTitleCacheModel;
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

	private static ClassLoader _classLoader = JobTitle.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			JobTitle.class
		};
	private String _job_title_id;
	private String _user_id;
	private String _job_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private JobTitle _escapedModelProxy;
}