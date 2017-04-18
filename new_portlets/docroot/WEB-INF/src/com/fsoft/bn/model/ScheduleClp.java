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

import com.fsoft.bn.service.ScheduleLocalServiceUtil;

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
public class ScheduleClp extends BaseModelImpl<Schedule> implements Schedule {
	public ScheduleClp() {
	}

	public Class<?> getModelClass() {
		return Schedule.class;
	}

	public String getModelClassName() {
		return Schedule.class.getName();
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
		return _schedule_id;
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
		return _content;
	}

	public void setContent(String content) {
		_content = content;
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

	public BaseModel<?> getScheduleRemoteModel() {
		return _scheduleRemoteModel;
	}

	public void setScheduleRemoteModel(BaseModel<?> scheduleRemoteModel) {
		_scheduleRemoteModel = scheduleRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ScheduleLocalServiceUtil.addSchedule(this);
		}
		else {
			ScheduleLocalServiceUtil.updateSchedule(this);
		}
	}

	@Override
	public Schedule toEscapedModel() {
		return (Schedule)Proxy.newProxyInstance(Schedule.class.getClassLoader(),
			new Class[] { Schedule.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScheduleClp clone = new ScheduleClp();

		clone.setSchedule_id(getSchedule_id());
		clone.setSchedule_date(getSchedule_date());
		clone.setContent(getContent());
		clone.setUser_id(getUser_id());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
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

		ScheduleClp schedule = null;

		try {
			schedule = (ScheduleClp)obj;
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

	private String _schedule_id;
	private Date _schedule_date;
	private String _content;
	private String _user_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _scheduleRemoteModel;
}