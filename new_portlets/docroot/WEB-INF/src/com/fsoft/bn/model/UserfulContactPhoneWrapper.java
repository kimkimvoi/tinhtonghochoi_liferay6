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
 * This class is a wrapper for {@link UserfulContactPhone}.
 * </p>
 *
 * @author    FSOFT
 * @see       UserfulContactPhone
 * @generated
 */
public class UserfulContactPhoneWrapper implements UserfulContactPhone,
	ModelWrapper<UserfulContactPhone> {
	public UserfulContactPhoneWrapper(UserfulContactPhone userfulContactPhone) {
		_userfulContactPhone = userfulContactPhone;
	}

	public Class<?> getModelClass() {
		return UserfulContactPhone.class;
	}

	public String getModelClassName() {
		return UserfulContactPhone.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userful_contact_phone_id", getUserful_contact_phone_id());
		attributes.put("userful_contact_name", getUserful_contact_name());
		attributes.put("userful_contact_phone", getUserful_contact_phone());
		attributes.put("userful_contact_email", getUserful_contact_email());
		attributes.put("userful_contact_position", getUserful_contact_position());
		attributes.put("userful_contact_address", getUserful_contact_address());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String userful_contact_phone_id = (String)attributes.get(
				"userful_contact_phone_id");

		if (userful_contact_phone_id != null) {
			setUserful_contact_phone_id(userful_contact_phone_id);
		}

		String userful_contact_name = (String)attributes.get(
				"userful_contact_name");

		if (userful_contact_name != null) {
			setUserful_contact_name(userful_contact_name);
		}

		String userful_contact_phone = (String)attributes.get(
				"userful_contact_phone");

		if (userful_contact_phone != null) {
			setUserful_contact_phone(userful_contact_phone);
		}

		String userful_contact_email = (String)attributes.get(
				"userful_contact_email");

		if (userful_contact_email != null) {
			setUserful_contact_email(userful_contact_email);
		}

		String userful_contact_position = (String)attributes.get(
				"userful_contact_position");

		if (userful_contact_position != null) {
			setUserful_contact_position(userful_contact_position);
		}

		String userful_contact_address = (String)attributes.get(
				"userful_contact_address");

		if (userful_contact_address != null) {
			setUserful_contact_address(userful_contact_address);
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
	* Returns the primary key of this userful contact phone.
	*
	* @return the primary key of this userful contact phone
	*/
	public java.lang.String getPrimaryKey() {
		return _userfulContactPhone.getPrimaryKey();
	}

	/**
	* Sets the primary key of this userful contact phone.
	*
	* @param primaryKey the primary key of this userful contact phone
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_userfulContactPhone.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the userful_contact_phone_id of this userful contact phone.
	*
	* @return the userful_contact_phone_id of this userful contact phone
	*/
	public java.lang.String getUserful_contact_phone_id() {
		return _userfulContactPhone.getUserful_contact_phone_id();
	}

	/**
	* Sets the userful_contact_phone_id of this userful contact phone.
	*
	* @param userful_contact_phone_id the userful_contact_phone_id of this userful contact phone
	*/
	public void setUserful_contact_phone_id(
		java.lang.String userful_contact_phone_id) {
		_userfulContactPhone.setUserful_contact_phone_id(userful_contact_phone_id);
	}

	/**
	* Returns the userful_contact_name of this userful contact phone.
	*
	* @return the userful_contact_name of this userful contact phone
	*/
	public java.lang.String getUserful_contact_name() {
		return _userfulContactPhone.getUserful_contact_name();
	}

	/**
	* Sets the userful_contact_name of this userful contact phone.
	*
	* @param userful_contact_name the userful_contact_name of this userful contact phone
	*/
	public void setUserful_contact_name(java.lang.String userful_contact_name) {
		_userfulContactPhone.setUserful_contact_name(userful_contact_name);
	}

	/**
	* Returns the userful_contact_phone of this userful contact phone.
	*
	* @return the userful_contact_phone of this userful contact phone
	*/
	public java.lang.String getUserful_contact_phone() {
		return _userfulContactPhone.getUserful_contact_phone();
	}

	/**
	* Sets the userful_contact_phone of this userful contact phone.
	*
	* @param userful_contact_phone the userful_contact_phone of this userful contact phone
	*/
	public void setUserful_contact_phone(java.lang.String userful_contact_phone) {
		_userfulContactPhone.setUserful_contact_phone(userful_contact_phone);
	}

	/**
	* Returns the userful_contact_email of this userful contact phone.
	*
	* @return the userful_contact_email of this userful contact phone
	*/
	public java.lang.String getUserful_contact_email() {
		return _userfulContactPhone.getUserful_contact_email();
	}

	/**
	* Sets the userful_contact_email of this userful contact phone.
	*
	* @param userful_contact_email the userful_contact_email of this userful contact phone
	*/
	public void setUserful_contact_email(java.lang.String userful_contact_email) {
		_userfulContactPhone.setUserful_contact_email(userful_contact_email);
	}

	/**
	* Returns the userful_contact_position of this userful contact phone.
	*
	* @return the userful_contact_position of this userful contact phone
	*/
	public java.lang.String getUserful_contact_position() {
		return _userfulContactPhone.getUserful_contact_position();
	}

	/**
	* Sets the userful_contact_position of this userful contact phone.
	*
	* @param userful_contact_position the userful_contact_position of this userful contact phone
	*/
	public void setUserful_contact_position(
		java.lang.String userful_contact_position) {
		_userfulContactPhone.setUserful_contact_position(userful_contact_position);
	}

	/**
	* Returns the userful_contact_address of this userful contact phone.
	*
	* @return the userful_contact_address of this userful contact phone
	*/
	public java.lang.String getUserful_contact_address() {
		return _userfulContactPhone.getUserful_contact_address();
	}

	/**
	* Sets the userful_contact_address of this userful contact phone.
	*
	* @param userful_contact_address the userful_contact_address of this userful contact phone
	*/
	public void setUserful_contact_address(
		java.lang.String userful_contact_address) {
		_userfulContactPhone.setUserful_contact_address(userful_contact_address);
	}

	/**
	* Returns the created_date of this userful contact phone.
	*
	* @return the created_date of this userful contact phone
	*/
	public java.util.Date getCreated_date() {
		return _userfulContactPhone.getCreated_date();
	}

	/**
	* Sets the created_date of this userful contact phone.
	*
	* @param created_date the created_date of this userful contact phone
	*/
	public void setCreated_date(java.util.Date created_date) {
		_userfulContactPhone.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this userful contact phone.
	*
	* @return the modified_date of this userful contact phone
	*/
	public java.util.Date getModified_date() {
		return _userfulContactPhone.getModified_date();
	}

	/**
	* Sets the modified_date of this userful contact phone.
	*
	* @param modified_date the modified_date of this userful contact phone
	*/
	public void setModified_date(java.util.Date modified_date) {
		_userfulContactPhone.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this userful contact phone.
	*
	* @return the deleted of this userful contact phone
	*/
	public boolean getDeleted() {
		return _userfulContactPhone.getDeleted();
	}

	/**
	* Returns <code>true</code> if this userful contact phone is deleted.
	*
	* @return <code>true</code> if this userful contact phone is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _userfulContactPhone.isDeleted();
	}

	/**
	* Sets whether this userful contact phone is deleted.
	*
	* @param deleted the deleted of this userful contact phone
	*/
	public void setDeleted(boolean deleted) {
		_userfulContactPhone.setDeleted(deleted);
	}

	public boolean isNew() {
		return _userfulContactPhone.isNew();
	}

	public void setNew(boolean n) {
		_userfulContactPhone.setNew(n);
	}

	public boolean isCachedModel() {
		return _userfulContactPhone.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userfulContactPhone.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userfulContactPhone.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userfulContactPhone.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userfulContactPhone.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userfulContactPhone.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userfulContactPhone.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserfulContactPhoneWrapper((UserfulContactPhone)_userfulContactPhone.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone) {
		return _userfulContactPhone.compareTo(userfulContactPhone);
	}

	@Override
	public int hashCode() {
		return _userfulContactPhone.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.UserfulContactPhone> toCacheModel() {
		return _userfulContactPhone.toCacheModel();
	}

	public com.fsoft.bn.model.UserfulContactPhone toEscapedModel() {
		return new UserfulContactPhoneWrapper(_userfulContactPhone.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userfulContactPhone.toString();
	}

	public java.lang.String toXmlString() {
		return _userfulContactPhone.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userfulContactPhone.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserfulContactPhone getWrappedUserfulContactPhone() {
		return _userfulContactPhone;
	}

	public UserfulContactPhone getWrappedModel() {
		return _userfulContactPhone;
	}

	public void resetOriginalValues() {
		_userfulContactPhone.resetOriginalValues();
	}

	private UserfulContactPhone _userfulContactPhone;
}