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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Schedule}.
 * </p>
 *
 * @author    FSOFT
 * @see       Schedule
 * @generated
 */
public class ScheduleWrapper implements Schedule, ModelWrapper<Schedule> {
	public ScheduleWrapper(Schedule schedule) {
		_schedule = schedule;
	}

	public Class<?> getModelClass() {
		return Schedule.class;
	}

	public String getModelClassName() {
		return Schedule.class.getName();
	}

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

	/**
	* Returns the primary key of this schedule.
	*
	* @return the primary key of this schedule
	*/
	public java.lang.String getPrimaryKey() {
		return _schedule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this schedule.
	*
	* @param primaryKey the primary key of this schedule
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_schedule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the schedule_id of this schedule.
	*
	* @return the schedule_id of this schedule
	*/
	public java.lang.String getSchedule_id() {
		return _schedule.getSchedule_id();
	}

	/**
	* Sets the schedule_id of this schedule.
	*
	* @param schedule_id the schedule_id of this schedule
	*/
	public void setSchedule_id(java.lang.String schedule_id) {
		_schedule.setSchedule_id(schedule_id);
	}

	/**
	* Returns the schedule_date of this schedule.
	*
	* @return the schedule_date of this schedule
	*/
	public java.util.Date getSchedule_date() {
		return _schedule.getSchedule_date();
	}

	/**
	* Sets the schedule_date of this schedule.
	*
	* @param schedule_date the schedule_date of this schedule
	*/
	public void setSchedule_date(java.util.Date schedule_date) {
		_schedule.setSchedule_date(schedule_date);
	}

	/**
	* Returns the content of this schedule.
	*
	* @return the content of this schedule
	*/
	public java.lang.String getContent() {
		return _schedule.getContent();
	}

	/**
	* Sets the content of this schedule.
	*
	* @param content the content of this schedule
	*/
	public void setContent(java.lang.String content) {
		_schedule.setContent(content);
	}

	/**
	* Returns the user_id of this schedule.
	*
	* @return the user_id of this schedule
	*/
	public java.lang.String getUser_id() {
		return _schedule.getUser_id();
	}

	/**
	* Sets the user_id of this schedule.
	*
	* @param user_id the user_id of this schedule
	*/
	public void setUser_id(java.lang.String user_id) {
		_schedule.setUser_id(user_id);
	}

	/**
	* Returns the created_date of this schedule.
	*
	* @return the created_date of this schedule
	*/
	public java.util.Date getCreated_date() {
		return _schedule.getCreated_date();
	}

	/**
	* Sets the created_date of this schedule.
	*
	* @param created_date the created_date of this schedule
	*/
	public void setCreated_date(java.util.Date created_date) {
		_schedule.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this schedule.
	*
	* @return the modified_date of this schedule
	*/
	public java.util.Date getModified_date() {
		return _schedule.getModified_date();
	}

	/**
	* Sets the modified_date of this schedule.
	*
	* @param modified_date the modified_date of this schedule
	*/
	public void setModified_date(java.util.Date modified_date) {
		_schedule.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this schedule.
	*
	* @return the deleted of this schedule
	*/
	public boolean getDeleted() {
		return _schedule.getDeleted();
	}

	/**
	* Returns <code>true</code> if this schedule is deleted.
	*
	* @return <code>true</code> if this schedule is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _schedule.isDeleted();
	}

	/**
	* Sets whether this schedule is deleted.
	*
	* @param deleted the deleted of this schedule
	*/
	public void setDeleted(boolean deleted) {
		_schedule.setDeleted(deleted);
	}

	public boolean isNew() {
		return _schedule.isNew();
	}

	public void setNew(boolean n) {
		_schedule.setNew(n);
	}

	public boolean isCachedModel() {
		return _schedule.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_schedule.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _schedule.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _schedule.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_schedule.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _schedule.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_schedule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScheduleWrapper((Schedule)_schedule.clone());
	}

	public int compareTo(com.fsoft.bn.model.Schedule schedule) {
		return _schedule.compareTo(schedule);
	}

	@Override
	public int hashCode() {
		return _schedule.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.Schedule> toCacheModel() {
		return _schedule.toCacheModel();
	}

	public com.fsoft.bn.model.Schedule toEscapedModel() {
		return new ScheduleWrapper(_schedule.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _schedule.toString();
	}

	public java.lang.String toXmlString() {
		return _schedule.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_schedule.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Schedule getWrappedSchedule() {
		return _schedule;
	}

	public Schedule getWrappedModel() {
		return _schedule;
	}

	public void resetOriginalValues() {
		_schedule.resetOriginalValues();
	}

	private Schedule _schedule;
}