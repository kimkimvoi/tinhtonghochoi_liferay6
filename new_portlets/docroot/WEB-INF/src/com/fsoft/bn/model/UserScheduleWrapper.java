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
 * This class is a wrapper for {@link UserSchedule}.
 * </p>
 *
 * @author    FSOFT
 * @see       UserSchedule
 * @generated
 */
public class UserScheduleWrapper implements UserSchedule,
	ModelWrapper<UserSchedule> {
	public UserScheduleWrapper(UserSchedule userSchedule) {
		_userSchedule = userSchedule;
	}

	public Class<?> getModelClass() {
		return UserSchedule.class;
	}

	public String getModelClassName() {
		return UserSchedule.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("user_schedule_id", getUser_schedule_id());
		attributes.put("user_id", getUser_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

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

	/**
	* Returns the primary key of this user schedule.
	*
	* @return the primary key of this user schedule
	*/
	public java.lang.String getPrimaryKey() {
		return _userSchedule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user schedule.
	*
	* @param primaryKey the primary key of this user schedule
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_userSchedule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user_schedule_id of this user schedule.
	*
	* @return the user_schedule_id of this user schedule
	*/
	public java.lang.String getUser_schedule_id() {
		return _userSchedule.getUser_schedule_id();
	}

	/**
	* Sets the user_schedule_id of this user schedule.
	*
	* @param user_schedule_id the user_schedule_id of this user schedule
	*/
	public void setUser_schedule_id(java.lang.String user_schedule_id) {
		_userSchedule.setUser_schedule_id(user_schedule_id);
	}

	/**
	* Returns the user_id of this user schedule.
	*
	* @return the user_id of this user schedule
	*/
	public java.lang.String getUser_id() {
		return _userSchedule.getUser_id();
	}

	/**
	* Sets the user_id of this user schedule.
	*
	* @param user_id the user_id of this user schedule
	*/
	public void setUser_id(java.lang.String user_id) {
		_userSchedule.setUser_id(user_id);
	}

	/**
	* Returns the created_date of this user schedule.
	*
	* @return the created_date of this user schedule
	*/
	public java.util.Date getCreated_date() {
		return _userSchedule.getCreated_date();
	}

	/**
	* Sets the created_date of this user schedule.
	*
	* @param created_date the created_date of this user schedule
	*/
	public void setCreated_date(java.util.Date created_date) {
		_userSchedule.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this user schedule.
	*
	* @return the modified_date of this user schedule
	*/
	public java.util.Date getModified_date() {
		return _userSchedule.getModified_date();
	}

	/**
	* Sets the modified_date of this user schedule.
	*
	* @param modified_date the modified_date of this user schedule
	*/
	public void setModified_date(java.util.Date modified_date) {
		_userSchedule.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this user schedule.
	*
	* @return the deleted of this user schedule
	*/
	public boolean getDeleted() {
		return _userSchedule.getDeleted();
	}

	/**
	* Returns <code>true</code> if this user schedule is deleted.
	*
	* @return <code>true</code> if this user schedule is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _userSchedule.isDeleted();
	}

	/**
	* Sets whether this user schedule is deleted.
	*
	* @param deleted the deleted of this user schedule
	*/
	public void setDeleted(boolean deleted) {
		_userSchedule.setDeleted(deleted);
	}

	public boolean isNew() {
		return _userSchedule.isNew();
	}

	public void setNew(boolean n) {
		_userSchedule.setNew(n);
	}

	public boolean isCachedModel() {
		return _userSchedule.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userSchedule.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userSchedule.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userSchedule.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userSchedule.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userSchedule.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userSchedule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserScheduleWrapper((UserSchedule)_userSchedule.clone());
	}

	public int compareTo(com.fsoft.bn.model.UserSchedule userSchedule) {
		return _userSchedule.compareTo(userSchedule);
	}

	@Override
	public int hashCode() {
		return _userSchedule.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.UserSchedule> toCacheModel() {
		return _userSchedule.toCacheModel();
	}

	public com.fsoft.bn.model.UserSchedule toEscapedModel() {
		return new UserScheduleWrapper(_userSchedule.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userSchedule.toString();
	}

	public java.lang.String toXmlString() {
		return _userSchedule.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userSchedule.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserSchedule getWrappedUserSchedule() {
		return _userSchedule;
	}

	public UserSchedule getWrappedModel() {
		return _userSchedule;
	}

	public void resetOriginalValues() {
		_userSchedule.resetOriginalValues();
	}

	private UserSchedule _userSchedule;
}