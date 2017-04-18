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
 * This class is a wrapper for {@link PreschoolParent}.
 * </p>
 *
 * @author    FSOFT
 * @see       PreschoolParent
 * @generated
 */
public class PreschoolParentWrapper implements PreschoolParent,
	ModelWrapper<PreschoolParent> {
	public PreschoolParentWrapper(PreschoolParent preschoolParent) {
		_preschoolParent = preschoolParent;
	}

	public Class<?> getModelClass() {
		return PreschoolParent.class;
	}

	public String getModelClassName() {
		return PreschoolParent.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("preschoolParent_id", getPreschoolParent_id());
		attributes.put("student_id", getStudent_id());
		attributes.put("name", getName());
		attributes.put("dob", getDob());
		attributes.put("placeOfBirth", getPlaceOfBirth());
		attributes.put("nationality", getNationality());
		attributes.put("idCardNumber", getIdCardNumber());
		attributes.put("job", getJob());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("Email", getEmail());
		attributes.put("isMother", getIsMother());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String preschoolParent_id = (String)attributes.get("preschoolParent_id");

		if (preschoolParent_id != null) {
			setPreschoolParent_id(preschoolParent_id);
		}

		String student_id = (String)attributes.get("student_id");

		if (student_id != null) {
			setStudent_id(student_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String dob = (String)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String placeOfBirth = (String)attributes.get("placeOfBirth");

		if (placeOfBirth != null) {
			setPlaceOfBirth(placeOfBirth);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String idCardNumber = (String)attributes.get("idCardNumber");

		if (idCardNumber != null) {
			setIdCardNumber(idCardNumber);
		}

		String job = (String)attributes.get("job");

		if (job != null) {
			setJob(job);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
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
	* Returns the primary key of this preschool parent.
	*
	* @return the primary key of this preschool parent
	*/
	public java.lang.String getPrimaryKey() {
		return _preschoolParent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this preschool parent.
	*
	* @param primaryKey the primary key of this preschool parent
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_preschoolParent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the preschool parent_id of this preschool parent.
	*
	* @return the preschool parent_id of this preschool parent
	*/
	public java.lang.String getPreschoolParent_id() {
		return _preschoolParent.getPreschoolParent_id();
	}

	/**
	* Sets the preschool parent_id of this preschool parent.
	*
	* @param preschoolParent_id the preschool parent_id of this preschool parent
	*/
	public void setPreschoolParent_id(java.lang.String preschoolParent_id) {
		_preschoolParent.setPreschoolParent_id(preschoolParent_id);
	}

	/**
	* Returns the student_id of this preschool parent.
	*
	* @return the student_id of this preschool parent
	*/
	public java.lang.String getStudent_id() {
		return _preschoolParent.getStudent_id();
	}

	/**
	* Sets the student_id of this preschool parent.
	*
	* @param student_id the student_id of this preschool parent
	*/
	public void setStudent_id(java.lang.String student_id) {
		_preschoolParent.setStudent_id(student_id);
	}

	/**
	* Returns the name of this preschool parent.
	*
	* @return the name of this preschool parent
	*/
	public java.lang.String getName() {
		return _preschoolParent.getName();
	}

	/**
	* Sets the name of this preschool parent.
	*
	* @param name the name of this preschool parent
	*/
	public void setName(java.lang.String name) {
		_preschoolParent.setName(name);
	}

	/**
	* Returns the dob of this preschool parent.
	*
	* @return the dob of this preschool parent
	*/
	public java.lang.String getDob() {
		return _preschoolParent.getDob();
	}

	/**
	* Sets the dob of this preschool parent.
	*
	* @param dob the dob of this preschool parent
	*/
	public void setDob(java.lang.String dob) {
		_preschoolParent.setDob(dob);
	}

	/**
	* Returns the place of birth of this preschool parent.
	*
	* @return the place of birth of this preschool parent
	*/
	public java.lang.String getPlaceOfBirth() {
		return _preschoolParent.getPlaceOfBirth();
	}

	/**
	* Sets the place of birth of this preschool parent.
	*
	* @param placeOfBirth the place of birth of this preschool parent
	*/
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		_preschoolParent.setPlaceOfBirth(placeOfBirth);
	}

	/**
	* Returns the nationality of this preschool parent.
	*
	* @return the nationality of this preschool parent
	*/
	public java.lang.String getNationality() {
		return _preschoolParent.getNationality();
	}

	/**
	* Sets the nationality of this preschool parent.
	*
	* @param nationality the nationality of this preschool parent
	*/
	public void setNationality(java.lang.String nationality) {
		_preschoolParent.setNationality(nationality);
	}

	/**
	* Returns the id card number of this preschool parent.
	*
	* @return the id card number of this preschool parent
	*/
	public java.lang.String getIdCardNumber() {
		return _preschoolParent.getIdCardNumber();
	}

	/**
	* Sets the id card number of this preschool parent.
	*
	* @param idCardNumber the id card number of this preschool parent
	*/
	public void setIdCardNumber(java.lang.String idCardNumber) {
		_preschoolParent.setIdCardNumber(idCardNumber);
	}

	/**
	* Returns the job of this preschool parent.
	*
	* @return the job of this preschool parent
	*/
	public java.lang.String getJob() {
		return _preschoolParent.getJob();
	}

	/**
	* Sets the job of this preschool parent.
	*
	* @param job the job of this preschool parent
	*/
	public void setJob(java.lang.String job) {
		_preschoolParent.setJob(job);
	}

	/**
	* Returns the phone number of this preschool parent.
	*
	* @return the phone number of this preschool parent
	*/
	public java.lang.String getPhoneNumber() {
		return _preschoolParent.getPhoneNumber();
	}

	/**
	* Sets the phone number of this preschool parent.
	*
	* @param phoneNumber the phone number of this preschool parent
	*/
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_preschoolParent.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the email of this preschool parent.
	*
	* @return the email of this preschool parent
	*/
	public java.lang.String getEmail() {
		return _preschoolParent.getEmail();
	}

	/**
	* Sets the email of this preschool parent.
	*
	* @param Email the email of this preschool parent
	*/
	public void setEmail(java.lang.String Email) {
		_preschoolParent.setEmail(Email);
	}

	/**
	* Returns the is mother of this preschool parent.
	*
	* @return the is mother of this preschool parent
	*/
	public boolean getIsMother() {
		return _preschoolParent.getIsMother();
	}

	/**
	* Returns <code>true</code> if this preschool parent is is mother.
	*
	* @return <code>true</code> if this preschool parent is is mother; <code>false</code> otherwise
	*/
	public boolean isIsMother() {
		return _preschoolParent.isIsMother();
	}

	/**
	* Sets whether this preschool parent is is mother.
	*
	* @param isMother the is mother of this preschool parent
	*/
	public void setIsMother(boolean isMother) {
		_preschoolParent.setIsMother(isMother);
	}

	/**
	* Returns the created_date of this preschool parent.
	*
	* @return the created_date of this preschool parent
	*/
	public java.util.Date getCreated_date() {
		return _preschoolParent.getCreated_date();
	}

	/**
	* Sets the created_date of this preschool parent.
	*
	* @param created_date the created_date of this preschool parent
	*/
	public void setCreated_date(java.util.Date created_date) {
		_preschoolParent.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this preschool parent.
	*
	* @return the modified_date of this preschool parent
	*/
	public java.util.Date getModified_date() {
		return _preschoolParent.getModified_date();
	}

	/**
	* Sets the modified_date of this preschool parent.
	*
	* @param modified_date the modified_date of this preschool parent
	*/
	public void setModified_date(java.util.Date modified_date) {
		_preschoolParent.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this preschool parent.
	*
	* @return the deleted of this preschool parent
	*/
	public boolean getDeleted() {
		return _preschoolParent.getDeleted();
	}

	/**
	* Returns <code>true</code> if this preschool parent is deleted.
	*
	* @return <code>true</code> if this preschool parent is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _preschoolParent.isDeleted();
	}

	/**
	* Sets whether this preschool parent is deleted.
	*
	* @param deleted the deleted of this preschool parent
	*/
	public void setDeleted(boolean deleted) {
		_preschoolParent.setDeleted(deleted);
	}

	public boolean isNew() {
		return _preschoolParent.isNew();
	}

	public void setNew(boolean n) {
		_preschoolParent.setNew(n);
	}

	public boolean isCachedModel() {
		return _preschoolParent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_preschoolParent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _preschoolParent.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _preschoolParent.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_preschoolParent.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _preschoolParent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_preschoolParent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PreschoolParentWrapper((PreschoolParent)_preschoolParent.clone());
	}

	public int compareTo(com.fsoft.bn.model.PreschoolParent preschoolParent) {
		return _preschoolParent.compareTo(preschoolParent);
	}

	@Override
	public int hashCode() {
		return _preschoolParent.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.PreschoolParent> toCacheModel() {
		return _preschoolParent.toCacheModel();
	}

	public com.fsoft.bn.model.PreschoolParent toEscapedModel() {
		return new PreschoolParentWrapper(_preschoolParent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _preschoolParent.toString();
	}

	public java.lang.String toXmlString() {
		return _preschoolParent.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_preschoolParent.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PreschoolParent getWrappedPreschoolParent() {
		return _preschoolParent;
	}

	public PreschoolParent getWrappedModel() {
		return _preschoolParent;
	}

	public void resetOriginalValues() {
		_preschoolParent.resetOriginalValues();
	}

	private PreschoolParent _preschoolParent;
}