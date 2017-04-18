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
 * This class is a wrapper for {@link BNContact}.
 * </p>
 *
 * @author    FSOFT
 * @see       BNContact
 * @generated
 */
public class BNContactWrapper implements BNContact, ModelWrapper<BNContact> {
	public BNContactWrapper(BNContact bnContact) {
		_bnContact = bnContact;
	}

	public Class<?> getModelClass() {
		return BNContact.class;
	}

	public String getModelClassName() {
		return BNContact.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("departmentKey", getDepartmentKey());
		attributes.put("name", getName());
		attributes.put("regency", getRegency());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("email", getEmail());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		String departmentKey = (String)attributes.get("departmentKey");

		if (departmentKey != null) {
			setDepartmentKey(departmentKey);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String regency = (String)attributes.get("regency");

		if (regency != null) {
			setRegency(regency);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	* Returns the primary key of this b n contact.
	*
	* @return the primary key of this b n contact
	*/
	public long getPrimaryKey() {
		return _bnContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this b n contact.
	*
	* @param primaryKey the primary key of this b n contact
	*/
	public void setPrimaryKey(long primaryKey) {
		_bnContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact ID of this b n contact.
	*
	* @return the contact ID of this b n contact
	*/
	public long getContactId() {
		return _bnContact.getContactId();
	}

	/**
	* Sets the contact ID of this b n contact.
	*
	* @param contactId the contact ID of this b n contact
	*/
	public void setContactId(long contactId) {
		_bnContact.setContactId(contactId);
	}

	/**
	* Returns the department key of this b n contact.
	*
	* @return the department key of this b n contact
	*/
	public java.lang.String getDepartmentKey() {
		return _bnContact.getDepartmentKey();
	}

	/**
	* Sets the department key of this b n contact.
	*
	* @param departmentKey the department key of this b n contact
	*/
	public void setDepartmentKey(java.lang.String departmentKey) {
		_bnContact.setDepartmentKey(departmentKey);
	}

	/**
	* Returns the name of this b n contact.
	*
	* @return the name of this b n contact
	*/
	public java.lang.String getName() {
		return _bnContact.getName();
	}

	/**
	* Sets the name of this b n contact.
	*
	* @param name the name of this b n contact
	*/
	public void setName(java.lang.String name) {
		_bnContact.setName(name);
	}

	/**
	* Returns the regency of this b n contact.
	*
	* @return the regency of this b n contact
	*/
	public java.lang.String getRegency() {
		return _bnContact.getRegency();
	}

	/**
	* Sets the regency of this b n contact.
	*
	* @param regency the regency of this b n contact
	*/
	public void setRegency(java.lang.String regency) {
		_bnContact.setRegency(regency);
	}

	/**
	* Returns the phone number of this b n contact.
	*
	* @return the phone number of this b n contact
	*/
	public java.lang.String getPhoneNumber() {
		return _bnContact.getPhoneNumber();
	}

	/**
	* Sets the phone number of this b n contact.
	*
	* @param phoneNumber the phone number of this b n contact
	*/
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_bnContact.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the email of this b n contact.
	*
	* @return the email of this b n contact
	*/
	public java.lang.String getEmail() {
		return _bnContact.getEmail();
	}

	/**
	* Sets the email of this b n contact.
	*
	* @param email the email of this b n contact
	*/
	public void setEmail(java.lang.String email) {
		_bnContact.setEmail(email);
	}

	/**
	* Returns the created date of this b n contact.
	*
	* @return the created date of this b n contact
	*/
	public java.util.Date getCreatedDate() {
		return _bnContact.getCreatedDate();
	}

	/**
	* Sets the created date of this b n contact.
	*
	* @param createdDate the created date of this b n contact
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_bnContact.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this b n contact.
	*
	* @return the modified date of this b n contact
	*/
	public java.util.Date getModifiedDate() {
		return _bnContact.getModifiedDate();
	}

	/**
	* Sets the modified date of this b n contact.
	*
	* @param modifiedDate the modified date of this b n contact
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_bnContact.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this b n contact.
	*
	* @return the deleted of this b n contact
	*/
	public boolean getDeleted() {
		return _bnContact.getDeleted();
	}

	/**
	* Returns <code>true</code> if this b n contact is deleted.
	*
	* @return <code>true</code> if this b n contact is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _bnContact.isDeleted();
	}

	/**
	* Sets whether this b n contact is deleted.
	*
	* @param deleted the deleted of this b n contact
	*/
	public void setDeleted(boolean deleted) {
		_bnContact.setDeleted(deleted);
	}

	public boolean isNew() {
		return _bnContact.isNew();
	}

	public void setNew(boolean n) {
		_bnContact.setNew(n);
	}

	public boolean isCachedModel() {
		return _bnContact.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bnContact.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bnContact.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bnContact.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bnContact.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bnContact.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bnContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BNContactWrapper((BNContact)_bnContact.clone());
	}

	public int compareTo(com.fsoft.bn.model.BNContact bnContact) {
		return _bnContact.compareTo(bnContact);
	}

	@Override
	public int hashCode() {
		return _bnContact.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.BNContact> toCacheModel() {
		return _bnContact.toCacheModel();
	}

	public com.fsoft.bn.model.BNContact toEscapedModel() {
		return new BNContactWrapper(_bnContact.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bnContact.toString();
	}

	public java.lang.String toXmlString() {
		return _bnContact.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bnContact.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public BNContact getWrappedBNContact() {
		return _bnContact;
	}

	public BNContact getWrappedModel() {
		return _bnContact;
	}

	public void resetOriginalValues() {
		_bnContact.resetOriginalValues();
	}

	private BNContact _bnContact;
}