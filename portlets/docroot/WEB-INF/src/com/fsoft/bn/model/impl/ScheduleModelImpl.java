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

import com.fsoft.bn.model.Schedule;
import com.fsoft.bn.model.ScheduleModel;

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
 * The base model implementation for the Schedule service. Represents a row in the &quot;BN_Schedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsoft.bn.model.ScheduleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScheduleImpl}.
 * </p>
 *
 * @author FSOFT
 * @see ScheduleImpl
 * @see com.fsoft.bn.model.Schedule
 * @see com.fsoft.bn.model.ScheduleModel
 * @generated
 */
public class ScheduleModelImpl extends BaseModelImpl<Schedule>
	implements ScheduleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a schedule model instance should use the {@link com.fsoft.bn.model.Schedule} interface instead.
	 */
	public static final String TABLE_NAME = "BN_Schedule";
	public static final Object[][] TABLE_COLUMNS = {
			{ "schedule_id", Types.VARCHAR },
			{ "schedule_date", Types.TIMESTAMP },
			{ "content", Types.VARCHAR },
			{ "user_id", Types.VARCHAR },
			{ "created_date", Types.TIMESTAMP },
			{ "modified_date", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table BN_Schedule (schedule_id VARCHAR(75) not null primary key,schedule_date DATE null,content STRING null,user_id VARCHAR(75) null,created_date DATE null,modified_date DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table BN_Schedule";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fsoft.bn.model.Schedule"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fsoft.bn.model.Schedule"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.fsoft.bn.model.Schedule"));

	public ScheduleModelImpl() {
	}

	public String getPrimaryKey() {
		return _schedule_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setSchedule_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _schedule_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return Schedule.class;
	}

	public String getModelClassName() {
		return Schedule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("schedule_id", getSchedule_id());
		attributes.put("schedule_date", getSchedule_date());
		attributes.put("content", getContent());
		attributes.put("user_id", getUser_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String schedule_id = (String)attributes.get("schedule_id");

		if (schedule_id != null) {
			setSchedule_id(schedule_id);
		}

		Date schedule_date = (Date)attributes.get("schedule_date");

		if (schedule_date != null) {
			setSchedule_date(schedule_date);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
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

	public String getSchedule_id() {
		if (_schedule_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _schedule_id;
		}
	}

	public void setSchedule_id(String schedule_id) {
		_schedule_id = schedule_id;
	}

	public Date getSchedule_date() {
		return _schedule_date;
	}

	public void setSchedule_date(Date schedule_date) {
		_schedule_date = schedule_date;
	}

	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	public void setContent(String content) {
		_content = content;
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
	public Schedule toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Schedule)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ScheduleImpl scheduleImpl = new ScheduleImpl();

		scheduleImpl.setSchedule_id(getSchedule_id());
		scheduleImpl.setSchedule_date(getSchedule_date());
		scheduleImpl.setContent(getContent());
		scheduleImpl.setUser_id(getUser_id());
		scheduleImpl.setCreated_date(getCreated_date());
		scheduleImpl.setModified_date(getModified_date());
		scheduleImpl.setDeleted(getDeleted());

		scheduleImpl.resetOriginalValues();

		return scheduleImpl;
	}

	public int compareTo(Schedule schedule) {
		String primaryKey = schedule.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Schedule schedule = null;

		try {
			schedule = (Schedule)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = schedule.getPrimaryKey();

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
	public CacheModel<Schedule> toCacheModel() {
		ScheduleCacheModel scheduleCacheModel = new ScheduleCacheModel();

		scheduleCacheModel.schedule_id = getSchedule_id();

		String schedule_id = scheduleCacheModel.schedule_id;

		if ((schedule_id != null) && (schedule_id.length() == 0)) {
			scheduleCacheModel.schedule_id = null;
		}

		Date schedule_date = getSchedule_date();

		if (schedule_date != null) {
			scheduleCacheModel.schedule_date = schedule_date.getTime();
		}
		else {
			scheduleCacheModel.schedule_date = Long.MIN_VALUE;
		}

		scheduleCacheModel.content = getContent();

		String content = scheduleCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			scheduleCacheModel.content = null;
		}

		scheduleCacheModel.user_id = getUser_id();

		String user_id = scheduleCacheModel.user_id;

		if ((user_id != null) && (user_id.length() == 0)) {
			scheduleCacheModel.user_id = null;
		}

		Date created_date = getCreated_date();

		if (created_date != null) {
			scheduleCacheModel.created_date = created_date.getTime();
		}
		else {
			scheduleCacheModel.created_date = Long.MIN_VALUE;
		}

		Date modified_date = getModified_date();

		if (modified_date != null) {
			scheduleCacheModel.modified_date = modified_date.getTime();
		}
		else {
			scheduleCacheModel.modified_date = Long.MIN_VALUE;
		}

		scheduleCacheModel.deleted = getDeleted();

		return scheduleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{schedule_id=");
		sb.append(getSchedule_id());
		sb.append(", schedule_date=");
		sb.append(getSchedule_date());
		sb.append(", content=");
		sb.append(getContent());
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
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.Schedule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>schedule_id</column-name><column-value><![CDATA[");
		sb.append(getSchedule_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schedule_date</column-name><column-value><![CDATA[");
		sb.append(getSchedule_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
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

	private static ClassLoader _classLoader = Schedule.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Schedule.class
		};
	private String _schedule_id;
	private Date _schedule_date;
	private String _content;
	private String _user_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private Schedule _escapedModelProxy;
}