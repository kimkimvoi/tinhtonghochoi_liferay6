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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Schedule service. Represents a row in the &quot;BN_Schedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.ScheduleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.ScheduleImpl}.
 * </p>
 *
 * @author FSOFT
 * @see Schedule
 * @see com.fsoft.bn.model.impl.ScheduleImpl
 * @see com.fsoft.bn.model.impl.ScheduleModelImpl
 * @generated
 */
public interface ScheduleModel extends BaseModel<Schedule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a schedule model instance should use the {@link Schedule} interface instead.
	 */

	/**
	 * Returns the primary key of this schedule.
	 *
	 * @return the primary key of this schedule
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this schedule.
	 *
	 * @param primaryKey the primary key of this schedule
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the schedule_id of this schedule.
	 *
	 * @return the schedule_id of this schedule
	 */
	@AutoEscape
	public String getSchedule_id();

	/**
	 * Sets the schedule_id of this schedule.
	 *
	 * @param schedule_id the schedule_id of this schedule
	 */
	public void setSchedule_id(String schedule_id);

	/**
	 * Returns the schedule_date of this schedule.
	 *
	 * @return the schedule_date of this schedule
	 */
	public Date getSchedule_date();

	/**
	 * Sets the schedule_date of this schedule.
	 *
	 * @param schedule_date the schedule_date of this schedule
	 */
	public void setSchedule_date(Date schedule_date);

	/**
	 * Returns the content of this schedule.
	 *
	 * @return the content of this schedule
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this schedule.
	 *
	 * @param content the content of this schedule
	 */
	public void setContent(String content);

	/**
	 * Returns the user_id of this schedule.
	 *
	 * @return the user_id of this schedule
	 */
	@AutoEscape
	public String getUser_id();

	/**
	 * Sets the user_id of this schedule.
	 *
	 * @param user_id the user_id of this schedule
	 */
	public void setUser_id(String user_id);

	/**
	 * Returns the created_date of this schedule.
	 *
	 * @return the created_date of this schedule
	 */
	public Date getCreated_date();

	/**
	 * Sets the created_date of this schedule.
	 *
	 * @param created_date the created_date of this schedule
	 */
	public void setCreated_date(Date created_date);

	/**
	 * Returns the modified_date of this schedule.
	 *
	 * @return the modified_date of this schedule
	 */
	public Date getModified_date();

	/**
	 * Sets the modified_date of this schedule.
	 *
	 * @param modified_date the modified_date of this schedule
	 */
	public void setModified_date(Date modified_date);

	/**
	 * Returns the deleted of this schedule.
	 *
	 * @return the deleted of this schedule
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this schedule is deleted.
	 *
	 * @return <code>true</code> if this schedule is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this schedule is deleted.
	 *
	 * @param deleted the deleted of this schedule
	 */
	public void setDeleted(boolean deleted);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Schedule schedule);

	public int hashCode();

	public CacheModel<Schedule> toCacheModel();

	public Schedule toEscapedModel();

	public String toString();

	public String toXmlString();
}