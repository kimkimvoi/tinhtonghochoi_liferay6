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
 * This class is a wrapper for {@link PrimarySchoolParent}.
 * </p>
 *
 * @author    FSOFT
 * @see       PrimarySchoolParent
 * @generated
 */
public class PrimarySchoolParentWrapper implements PrimarySchoolParent,
	ModelWrapper<PrimarySchoolParent> {
	public PrimarySchoolParentWrapper(PrimarySchoolParent primarySchoolParent) {
		_primarySchoolParent = primarySchoolParent;
	}

	public Class<?> getModelClass() {
		return PrimarySchoolParent.class;
	}

	public String getModelClassName() {
		return PrimarySchoolParent.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("primarySchoolParent_id", getPrimarySchoolParent_id());
		attributes.put("primaryStudent_id", getPrimaryStudent_id());
		attributes.put("name", getName());
		attributes.put("nationality", getNationality());
		attributes.put("idCardNumber", getIdCardNumber());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("Email", getEmail());
		attributes.put("job", getJob());
		attributes.put("job_position", getJob_position());
		attributes.put("workplace", getWorkplace());
		attributes.put("isMother", getIsMother());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String primarySchoolParent_id = (String)attributes.get(
				"primarySchoolParent_id");

		if (primarySchoolParent_id != null) {
			setPrimarySchoolParent_id(primarySchoolParent_id);
		}

		String primaryStudent_id = (String)attributes.get("primaryStudent_id");

		if (primaryStudent_id != null) {
			setPrimaryStudent_id(primaryStudent_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String idCardNumber = (String)attributes.get("idCardNumber");

		if (idCardNumber != null) {
			setIdCardNumber(idCardNumber);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String job = (String)attributes.get("job");

		if (job != null) {
			setJob(job);
		}

		String job_position = (String)attributes.get("job_position");

		if (job_position != null) {
			setJob_position(job_position);
		}

		String workplace = (String)attributes.get("workplace");

		if (workplace != null) {
			setWorkplace(workplace);
		}

		Boolean isMother = (Boolean)attributes.get("isMother");

		if (isMother != null) {
			setIsMother(isMother);
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
	* Returns the primary key of this primary school parent.
	*
	* @return the primary key of this primary school parent
	*/
	public java.lang.String getPrimaryKey() {
		return _primarySchoolParent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this primary school parent.
	*
	* @param primaryKey the primary key of this primary school parent
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_primarySchoolParent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the primary school parent_id of this primary school parent.
	*
	* @return the primary school parent_id of this primary school parent
	*/
	public java.lang.String getPrimarySchoolParent_id() {
		return _primarySchoolParent.getPrimarySchoolParent_id();
	}

	/**
	* Sets the primary school parent_id of this primary school parent.
	*
	* @param primarySchoolParent_id the primary school parent_id of this primary school parent
	*/
	public void setPrimarySchoolParent_id(
		java.lang.String primarySchoolParent_id) {
		_primarySchoolParent.setPrimarySchoolParent_id(primarySchoolParent_id);
	}

	/**
	* Returns the primary student_id of this primary school parent.
	*
	* @return the primary student_id of this primary school parent
	*/
	public java.lang.String getPrimaryStudent_id() {
		return _primarySchoolParent.getPrimaryStudent_id();
	}

	/**
	* Sets the primary student_id of this primary school parent.
	*
	* @param primaryStudent_id the primary student_id of this primary school parent
	*/
	public void setPrimaryStudent_id(java.lang.String primaryStudent_id) {
		_primarySchoolParent.setPrimaryStudent_id(primaryStudent_id);
	}

	/**
	* Returns the name of this primary school parent.
	*
	* @return the name of this primary school parent
	*/
	public java.lang.String getName() {
		return _primarySchoolParent.getName();
	}

	/**
	* Sets the name of this primary school parent.
	*
	* @param name the name of this primary school parent
	*/
	public void setName(java.lang.String name) {
		_primarySchoolParent.setName(name);
	}

	/**
	* Returns the nationality of this primary school parent.
	*
	* @return the nationality of this primary school parent
	*/
	public java.lang.String getNationality() {
		return _primarySchoolParent.getNationality();
	}

	/**
	* Sets the nationality of this primary school parent.
	*
	* @param nationality the nationality of this primary school parent
	*/
	public void setNationality(java.lang.String nationality) {
		_primarySchoolParent.setNationality(nationality);
	}

	/**
	* Returns the id card number of this primary school parent.
	*
	* @return the id card number of this primary school parent
	*/
	public java.lang.String getIdCardNumber() {
		return _primarySchoolParent.getIdCardNumber();
	}

	/**
	* Sets the id card number of this primary school parent.
	*
	* @param idCardNumber the id card number of this primary school parent
	*/
	public void setIdCardNumber(java.lang.String idCardNumber) {
		_primarySchoolParent.setIdCardNumber(idCardNumber);
	}

	/**
	* Returns the phone number of this primary school parent.
	*
	* @return the phone number of this primary school parent
	*/
	public java.lang.String getPhoneNumber() {
		return _primarySchoolParent.getPhoneNumber();
	}

	/**
	* Sets the phone number of this primary school parent.
	*
	* @param phoneNumber the phone number of this primary school parent
	*/
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_primarySchoolParent.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the email of this primary school parent.
	*
	* @return the email of this primary school parent
	*/
	public java.lang.String getEmail() {
		return _primarySchoolParent.getEmail();
	}

	/**
	* Sets the email of this primary school parent.
	*
	* @param Email the email of this primary school parent
	*/
	public void setEmail(java.lang.String Email) {
		_primarySchoolParent.setEmail(Email);
	}

	/**
	* Returns the job of this primary school parent.
	*
	* @return the job of this primary school parent
	*/
	public java.lang.String getJob() {
		return _primarySchoolParent.getJob();
	}

	/**
	* Sets the job of this primary school parent.
	*
	* @param job the job of this primary school parent
	*/
	public void setJob(java.lang.String job) {
		_primarySchoolParent.setJob(job);
	}

	/**
	* Returns the job_position of this primary school parent.
	*
	* @return the job_position of this primary school parent
	*/
	public java.lang.String getJob_position() {
		return _primarySchoolParent.getJob_position();
	}

	/**
	* Sets the job_position of this primary school parent.
	*
	* @param job_position the job_position of this primary school parent
	*/
	public void setJob_position(java.lang.String job_position) {
		_primarySchoolParent.setJob_position(job_position);
	}

	/**
	* Returns the workplace of this primary school parent.
	*
	* @return the workplace of this primary school parent
	*/
	public java.lang.String getWorkplace() {
		return _primarySchoolParent.getWorkplace();
	}

	/**
	* Sets the workplace of this primary school parent.
	*
	* @param workplace the workplace of this primary school parent
	*/
	public void setWorkplace(java.lang.String workplace) {
		_primarySchoolParent.setWorkplace(workplace);
	}

	/**
	* Returns the is mother of this primary school parent.
	*
	* @return the is mother of this primary school parent
	*/
	public boolean getIsMother() {
		return _primarySchoolParent.getIsMother();
	}

	/**
	* Returns <code>true</code> if this primary school parent is is mother.
	*
	* @return <code>true</code> if this primary school parent is is mother; <code>false</code> otherwise
	*/
	public boolean isIsMother() {
		return _primarySchoolParent.isIsMother();
	}

	/**
	* Sets whether this primary school parent is is mother.
	*
	* @param isMother the is mother of this primary school parent
	*/
	public void setIsMother(boolean isMother) {
		_primarySchoolParent.setIsMother(isMother);
	}

	/**
	* Returns the created_date of this primary school parent.
	*
	* @return the created_date of this primary school parent
	*/
	public java.util.Date getCreated_date() {
		return _primarySchoolParent.getCreated_date();
	}

	/**
	* Sets the created_date of this primary school parent.
	*
	* @param created_date the created_date of this primary school parent
	*/
	public void setCreated_date(java.util.Date created_date) {
		_primarySchoolParent.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this primary school parent.
	*
	* @return the modified_date of this primary school parent
	*/
	public java.util.Date getModified_date() {
		return _primarySchoolParent.getModified_date();
	}

	/**
	* Sets the modified_date of this primary school parent.
	*
	* @param modified_date the modified_date of this primary school parent
	*/
	public void setModified_date(java.util.Date modified_date) {
		_primarySchoolParent.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this primary school parent.
	*
	* @return the deleted of this primary school parent
	*/
	public boolean getDeleted() {
		return _primarySchoolParent.getDeleted();
	}

	/**
	* Returns <code>true</code> if this primary school parent is deleted.
	*
	* @return <code>true</code> if this primary school parent is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _primarySchoolParent.isDeleted();
	}

	/**
	* Sets whether this primary school parent is deleted.
	*
	* @param deleted the deleted of this primary school parent
	*/
	public void setDeleted(boolean deleted) {
		_primarySchoolParent.setDeleted(deleted);
	}

	public boolean isNew() {
		return _primarySchoolParent.isNew();
	}

	public void setNew(boolean n) {
		_primarySchoolParent.setNew(n);
	}

	public boolean isCachedModel() {
		return _primarySchoolParent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_primarySchoolParent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _primarySchoolParent.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _primarySchoolParent.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_primarySchoolParent.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _primarySchoolParent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_primarySchoolParent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PrimarySchoolParentWrapper((PrimarySchoolParent)_primarySchoolParent.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.PrimarySchoolParent primarySchoolParent) {
		return _primarySchoolParent.compareTo(primarySchoolParent);
	}

	@Override
	public int hashCode() {
		return _primarySchoolParent.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.PrimarySchoolParent> toCacheModel() {
		return _primarySchoolParent.toCacheModel();
	}

	public com.fsoft.bn.model.PrimarySchoolParent toEscapedModel() {
		return new PrimarySchoolParentWrapper(_primarySchoolParent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _primarySchoolParent.toString();
	}

	public java.lang.String toXmlString() {
		return _primarySchoolParent.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_primarySchoolParent.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PrimarySchoolParent getWrappedPrimarySchoolParent() {
		return _primarySchoolParent;
	}

	public PrimarySchoolParent getWrappedModel() {
		return _primarySchoolParent;
	}

	public void resetOriginalValues() {
		_primarySchoolParent.resetOriginalValues();
	}

	private PrimarySchoolParent _primarySchoolParent;
}