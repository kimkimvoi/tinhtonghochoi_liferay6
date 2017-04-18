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
 * This class is a wrapper for {@link StaffInfo}.
 * </p>
 *
 * @author    FSOFT
 * @see       StaffInfo
 * @generated
 */
public class StaffInfoWrapper implements StaffInfo, ModelWrapper<StaffInfo> {
	public StaffInfoWrapper(StaffInfo staffInfo) {
		_staffInfo = staffInfo;
	}

	public Class<?> getModelClass() {
		return StaffInfo.class;
	}

	public String getModelClassName() {
		return StaffInfo.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("staff_id", getStaff_id());
		attributes.put("staff_firstname", getStaff_firstname());
		attributes.put("staff_middlename", getStaff_middlename());
		attributes.put("staff_lastname", getStaff_lastname());
		attributes.put("staff_birthday", getStaff_birthday());
		attributes.put("staff_phone", getStaff_phone());
		attributes.put("staff_email", getStaff_email());
		attributes.put("staff_sex", getStaff_sex());
		attributes.put("staff_role", getStaff_role());
		attributes.put("deleted", getDeleted());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("organizations_id", getOrganizations_id());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long staff_id = (Long)attributes.get("staff_id");

		if (staff_id != null) {
			setStaff_id(staff_id);
		}

		String staff_firstname = (String)attributes.get("staff_firstname");

		if (staff_firstname != null) {
			setStaff_firstname(staff_firstname);
		}

		String staff_middlename = (String)attributes.get("staff_middlename");

		if (staff_middlename != null) {
			setStaff_middlename(staff_middlename);
		}

		String staff_lastname = (String)attributes.get("staff_lastname");

		if (staff_lastname != null) {
			setStaff_lastname(staff_lastname);
		}

		Date staff_birthday = (Date)attributes.get("staff_birthday");

		if (staff_birthday != null) {
			setStaff_birthday(staff_birthday);
		}

		String staff_phone = (String)attributes.get("staff_phone");

		if (staff_phone != null) {
			setStaff_phone(staff_phone);
		}

		String staff_email = (String)attributes.get("staff_email");

		if (staff_email != null) {
			setStaff_email(staff_email);
		}

		String staff_sex = (String)attributes.get("staff_sex");

		if (staff_sex != null) {
			setStaff_sex(staff_sex);
		}

		String staff_role = (String)attributes.get("staff_role");

		if (staff_role != null) {
			setStaff_role(staff_role);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long organizations_id = (Long)attributes.get("organizations_id");

		if (organizations_id != null) {
			setOrganizations_id(organizations_id);
		}
	}

	/**
	* Returns the primary key of this staff info.
	*
	* @return the primary key of this staff info
	*/
	public long getPrimaryKey() {
		return _staffInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this staff info.
	*
	* @param primaryKey the primary key of this staff info
	*/
	public void setPrimaryKey(long primaryKey) {
		_staffInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the staff_id of this staff info.
	*
	* @return the staff_id of this staff info
	*/
	public long getStaff_id() {
		return _staffInfo.getStaff_id();
	}

	/**
	* Sets the staff_id of this staff info.
	*
	* @param staff_id the staff_id of this staff info
	*/
	public void setStaff_id(long staff_id) {
		_staffInfo.setStaff_id(staff_id);
	}

	/**
	* Returns the staff_firstname of this staff info.
	*
	* @return the staff_firstname of this staff info
	*/
	public java.lang.String getStaff_firstname() {
		return _staffInfo.getStaff_firstname();
	}

	/**
	* Sets the staff_firstname of this staff info.
	*
	* @param staff_firstname the staff_firstname of this staff info
	*/
	public void setStaff_firstname(java.lang.String staff_firstname) {
		_staffInfo.setStaff_firstname(staff_firstname);
	}

	/**
	* Returns the staff_middlename of this staff info.
	*
	* @return the staff_middlename of this staff info
	*/
	public java.lang.String getStaff_middlename() {
		return _staffInfo.getStaff_middlename();
	}

	/**
	* Sets the staff_middlename of this staff info.
	*
	* @param staff_middlename the staff_middlename of this staff info
	*/
	public void setStaff_middlename(java.lang.String staff_middlename) {
		_staffInfo.setStaff_middlename(staff_middlename);
	}

	/**
	* Returns the staff_lastname of this staff info.
	*
	* @return the staff_lastname of this staff info
	*/
	public java.lang.String getStaff_lastname() {
		return _staffInfo.getStaff_lastname();
	}

	/**
	* Sets the staff_lastname of this staff info.
	*
	* @param staff_lastname the staff_lastname of this staff info
	*/
	public void setStaff_lastname(java.lang.String staff_lastname) {
		_staffInfo.setStaff_lastname(staff_lastname);
	}

	/**
	* Returns the staff_birthday of this staff info.
	*
	* @return the staff_birthday of this staff info
	*/
	public java.util.Date getStaff_birthday() {
		return _staffInfo.getStaff_birthday();
	}

	/**
	* Sets the staff_birthday of this staff info.
	*
	* @param staff_birthday the staff_birthday of this staff info
	*/
	public void setStaff_birthday(java.util.Date staff_birthday) {
		_staffInfo.setStaff_birthday(staff_birthday);
	}

	/**
	* Returns the staff_phone of this staff info.
	*
	* @return the staff_phone of this staff info
	*/
	public java.lang.String getStaff_phone() {
		return _staffInfo.getStaff_phone();
	}

	/**
	* Sets the staff_phone of this staff info.
	*
	* @param staff_phone the staff_phone of this staff info
	*/
	public void setStaff_phone(java.lang.String staff_phone) {
		_staffInfo.setStaff_phone(staff_phone);
	}

	/**
	* Returns the staff_email of this staff info.
	*
	* @return the staff_email of this staff info
	*/
	public java.lang.String getStaff_email() {
		return _staffInfo.getStaff_email();
	}

	/**
	* Sets the staff_email of this staff info.
	*
	* @param staff_email the staff_email of this staff info
	*/
	public void setStaff_email(java.lang.String staff_email) {
		_staffInfo.setStaff_email(staff_email);
	}

	/**
	* Returns the staff_sex of this staff info.
	*
	* @return the staff_sex of this staff info
	*/
	public java.lang.String getStaff_sex() {
		return _staffInfo.getStaff_sex();
	}

	/**
	* Sets the staff_sex of this staff info.
	*
	* @param staff_sex the staff_sex of this staff info
	*/
	public void setStaff_sex(java.lang.String staff_sex) {
		_staffInfo.setStaff_sex(staff_sex);
	}

	/**
	* Returns the staff_role of this staff info.
	*
	* @return the staff_role of this staff info
	*/
	public java.lang.String getStaff_role() {
		return _staffInfo.getStaff_role();
	}

	/**
	* Sets the staff_role of this staff info.
	*
	* @param staff_role the staff_role of this staff info
	*/
	public void setStaff_role(java.lang.String staff_role) {
		_staffInfo.setStaff_role(staff_role);
	}

	/**
	* Returns the deleted of this staff info.
	*
	* @return the deleted of this staff info
	*/
	public boolean getDeleted() {
		return _staffInfo.getDeleted();
	}

	/**
	* Returns <code>true</code> if this staff info is deleted.
	*
	* @return <code>true</code> if this staff info is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _staffInfo.isDeleted();
	}

	/**
	* Sets whether this staff info is deleted.
	*
	* @param deleted the deleted of this staff info
	*/
	public void setDeleted(boolean deleted) {
		_staffInfo.setDeleted(deleted);
	}

	/**
	* Returns the create date of this staff info.
	*
	* @return the create date of this staff info
	*/
	public java.util.Date getCreateDate() {
		return _staffInfo.getCreateDate();
	}

	/**
	* Sets the create date of this staff info.
	*
	* @param createDate the create date of this staff info
	*/
	public void setCreateDate(java.util.Date createDate) {
		_staffInfo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this staff info.
	*
	* @return the modified date of this staff info
	*/
	public java.util.Date getModifiedDate() {
		return _staffInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this staff info.
	*
	* @param modifiedDate the modified date of this staff info
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_staffInfo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the organizations_id of this staff info.
	*
	* @return the organizations_id of this staff info
	*/
	public long getOrganizations_id() {
		return _staffInfo.getOrganizations_id();
	}

	/**
	* Sets the organizations_id of this staff info.
	*
	* @param organizations_id the organizations_id of this staff info
	*/
	public void setOrganizations_id(long organizations_id) {
		_staffInfo.setOrganizations_id(organizations_id);
	}

	public boolean isNew() {
		return _staffInfo.isNew();
	}

	public void setNew(boolean n) {
		_staffInfo.setNew(n);
	}

	public boolean isCachedModel() {
		return _staffInfo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_staffInfo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _staffInfo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _staffInfo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_staffInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _staffInfo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_staffInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StaffInfoWrapper((StaffInfo)_staffInfo.clone());
	}

	public int compareTo(com.fsoft.bn.model.StaffInfo staffInfo) {
		return _staffInfo.compareTo(staffInfo);
	}

	@Override
	public int hashCode() {
		return _staffInfo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.StaffInfo> toCacheModel() {
		return _staffInfo.toCacheModel();
	}

	public com.fsoft.bn.model.StaffInfo toEscapedModel() {
		return new StaffInfoWrapper(_staffInfo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _staffInfo.toString();
	}

	public java.lang.String toXmlString() {
		return _staffInfo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_staffInfo.persist();
	}

	public java.lang.String getOrganizations_name() {
		return _staffInfo.getOrganizations_name();
	}

	public void setOrganizations_name(java.lang.String _organizations_name) {
		_staffInfo.setOrganizations_name(_organizations_name);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public StaffInfo getWrappedStaffInfo() {
		return _staffInfo;
	}

	public StaffInfo getWrappedModel() {
		return _staffInfo;
	}

	public void resetOriginalValues() {
		_staffInfo.resetOriginalValues();
	}

	private StaffInfo _staffInfo;
}