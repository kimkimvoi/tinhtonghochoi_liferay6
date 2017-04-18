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

import com.fsoft.bn.model.UserSchedule;
import com.fsoft.bn.model.UserScheduleModel;

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
 * The base model implementation for the UserSchedule service. Represents a row in the &quot;BN_UserSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsoft.bn.model.UserScheduleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserScheduleImpl}.
 * </p>
 *
 * @author FSOFT
 * @see UserScheduleImpl
 * @see com.fsoft.bn.model.UserSchedule
 * @see com.fsoft.bn.model.UserScheduleModel
 * @generated
 */
public class UserScheduleModelImpl extends BaseModelImpl<UserSchedule>
	implements UserScheduleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user schedule model instance should use the {@link com.fsoft.bn.model.UserSchedule} interface instead.
	 */
	public static final String TABLE_NAME = "BN_UserSchedule";
	public static final Object[][] TABLE_COLUMNS = {
			{ "user_schedule_id", Types.VARCHAR },
			{ "user_id", Types.VARCHAR },
			{ "created_date", Types.TIMESTAMP },
			{ "modified_date", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table BN_UserSchedule (user_schedule_id VARCHAR(75) not null primary key,user_id VARCHAR(75) null,created_date DATE null,modified_date DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table BN_UserSchedule";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fsoft.bn.model.UserSchedule"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fsoft.bn.model.UserSchedule"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.fsoft.bn.model.UserSchedule"));

	public UserScheduleModelImpl() {
	}

	public String getPrimaryKey() {
		return _user_schedule_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setUser_schedule_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _user_schedule_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return UserSchedule.class;
	}

	public String getModelClassName() {
		return UserSchedule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("user_schedule_id", getUser_schedule_id());
		attributes.put("user_id", getUser_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String user_schedule_id = (String)attributes.get("user_schedule_id");

		if (user_schedule_id != null) {
			setUser_schedule_id(user_schedule_id);
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

	public String getUser_schedule_id() {
		if (_user_schedule_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _user_schedule_id;
		}
	}

	public void setUser_schedule_id(String user_schedule_id) {
		_user_schedule_id = user_schedule_id;
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
	public UserSchedule toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (UserSchedule)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		UserScheduleImpl userScheduleImpl = new UserScheduleImpl();

		userScheduleImpl.setUser_schedule_id(getUser_schedule_id());
		userScheduleImpl.setUser_id(getUser_id());
		userScheduleImpl.setCreated_date(getCreated_date());
		userScheduleImpl.setModified_date(getModified_date());
		userScheduleImpl.setDeleted(getDeleted());

		userScheduleImpl.resetOriginalValues();

		return userScheduleImpl;
	}

	public int compareTo(UserSchedule userSchedule) {
		String primaryKey = userSchedule.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserSchedule userSchedule = null;

		try {
			userSchedule = (UserSchedule)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = userSchedule.getPrimaryKey();

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
	public CacheModel<UserSchedule> toCacheModel() {
		UserScheduleCacheModel userScheduleCacheModel = new UserScheduleCacheModel();

		userScheduleCacheModel.user_schedule_id = getUser_schedule_id();

		String user_schedule_id = userScheduleCacheModel.user_schedule_id;

		if ((user_schedule_id != null) && (user_schedule_id.length() == 0)) {
			userScheduleCacheModel.user_schedule_id = null;
		}

		userScheduleCacheModel.user_id = getUser_id();

		String user_id = userScheduleCacheModel.user_id;

		if ((user_id != null) && (user_id.length() == 0)) {
			userScheduleCacheModel.user_id = null;
		}

		Date created_date = getCreated_date();

		if (created_date != null) {
			userScheduleCacheModel.created_date = created_date.getTime();
		}
		else {
			userScheduleCacheModel.created_date = Long.MIN_VALUE;
		}

		Date modified_date = getModified_date();

		if (modified_date != null) {
			userScheduleCacheModel.modified_date = modified_date.getTime();
		}
		else {
			userScheduleCacheModel.modified_date = Long.MIN_VALUE;
		}

		userScheduleCacheModel.deleted = getDeleted();

		return userScheduleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{user_schedule_id=");
		sb.append(getUser_schedule_id());
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
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.UserSchedule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>user_schedule_id</column-name><column-value><![CDATA[");
		sb.append(getUser_schedule_id());
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

	private static ClassLoader _classLoader = UserSchedule.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			UserSchedule.class
		};
	private String _user_schedule_id;
	private String _user_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private UserSchedule _escapedModelProxy;
}