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
 * This class is a wrapper for {@link EnrolmentAttachedFile}.
 * </p>
 *
 * @author    FSOFT
 * @see       EnrolmentAttachedFile
 * @generated
 */
public class EnrolmentAttachedFileWrapper implements EnrolmentAttachedFile,
	ModelWrapper<EnrolmentAttachedFile> {
	public EnrolmentAttachedFileWrapper(
		EnrolmentAttachedFile enrolmentAttachedFile) {
		_enrolmentAttachedFile = enrolmentAttachedFile;
	}

	public Class<?> getModelClass() {
		return EnrolmentAttachedFile.class;
	}

	public String getModelClassName() {
		return EnrolmentAttachedFile.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("enrolment_attached_id", getEnrolment_attached_id());
		attributes.put("enrolment_id", getEnrolment_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String enrolment_attached_id = (String)attributes.get(
				"enrolment_attached_id");

		if (enrolment_attached_id != null) {
			setEnrolment_attached_id(enrolment_attached_id);
		}

		String enrolment_id = (String)attributes.get("enrolment_id");

		if (enrolment_id != null) {
			setEnrolment_id(enrolment_id);
		}

		String attached_file_id = (String)attributes.get("attached_file_id");

		if (attached_file_id != null) {
			setAttached_file_id(attached_file_id);
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
	* Returns the primary key of this enrolment attached file.
	*
	* @return the primary key of this enrolment attached file
	*/
	public java.lang.String getPrimaryKey() {
		return _enrolmentAttachedFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this enrolment attached file.
	*
	* @param primaryKey the primary key of this enrolment attached file
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_enrolmentAttachedFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the enrolment_attached_id of this enrolment attached file.
	*
	* @return the enrolment_attached_id of this enrolment attached file
	*/
	public java.lang.String getEnrolment_attached_id() {
		return _enrolmentAttachedFile.getEnrolment_attached_id();
	}

	/**
	* Sets the enrolment_attached_id of this enrolment attached file.
	*
	* @param enrolment_attached_id the enrolment_attached_id of this enrolment attached file
	*/
	public void setEnrolment_attached_id(java.lang.String enrolment_attached_id) {
		_enrolmentAttachedFile.setEnrolment_attached_id(enrolment_attached_id);
	}

	/**
	* Returns the enrolment_id of this enrolment attached file.
	*
	* @return the enrolment_id of this enrolment attached file
	*/
	public java.lang.String getEnrolment_id() {
		return _enrolmentAttachedFile.getEnrolment_id();
	}

	/**
	* Sets the enrolment_id of this enrolment attached file.
	*
	* @param enrolment_id the enrolment_id of this enrolment attached file
	*/
	public void setEnrolment_id(java.lang.String enrolment_id) {
		_enrolmentAttachedFile.setEnrolment_id(enrolment_id);
	}

	/**
	* Returns the attached_file_id of this enrolment attached file.
	*
	* @return the attached_file_id of this enrolment attached file
	*/
	public java.lang.String getAttached_file_id() {
		return _enrolmentAttachedFile.getAttached_file_id();
	}

	/**
	* Sets the attached_file_id of this enrolment attached file.
	*
	* @param attached_file_id the attached_file_id of this enrolment attached file
	*/
	public void setAttached_file_id(java.lang.String attached_file_id) {
		_enrolmentAttachedFile.setAttached_file_id(attached_file_id);
	}

	/**
	* Returns the created_date of this enrolment attached file.
	*
	* @return the created_date of this enrolment attached file
	*/
	public java.util.Date getCreated_date() {
		return _enrolmentAttachedFile.getCreated_date();
	}

	/**
	* Sets the created_date of this enrolment attached file.
	*
	* @param created_date the created_date of this enrolment attached file
	*/
	public void setCreated_date(java.util.Date created_date) {
		_enrolmentAttachedFile.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this enrolment attached file.
	*
	* @return the modified_date of this enrolment attached file
	*/
	public java.util.Date getModified_date() {
		return _enrolmentAttachedFile.getModified_date();
	}

	/**
	* Sets the modified_date of this enrolment attached file.
	*
	* @param modified_date the modified_date of this enrolment attached file
	*/
	public void setModified_date(java.util.Date modified_date) {
		_enrolmentAttachedFile.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this enrolment attached file.
	*
	* @return the deleted of this enrolment attached file
	*/
	public boolean getDeleted() {
		return _enrolmentAttachedFile.getDeleted();
	}

	/**
	* Returns <code>true</code> if this enrolment attached file is deleted.
	*
	* @return <code>true</code> if this enrolment attached file is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _enrolmentAttachedFile.isDeleted();
	}

	/**
	* Sets whether this enrolment attached file is deleted.
	*
	* @param deleted the deleted of this enrolment attached file
	*/
	public void setDeleted(boolean deleted) {
		_enrolmentAttachedFile.setDeleted(deleted);
	}

	public boolean isNew() {
		return _enrolmentAttachedFile.isNew();
	}

	public void setNew(boolean n) {
		_enrolmentAttachedFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _enrolmentAttachedFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_enrolmentAttachedFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _enrolmentAttachedFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _enrolmentAttachedFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_enrolmentAttachedFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _enrolmentAttachedFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_enrolmentAttachedFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnrolmentAttachedFileWrapper((EnrolmentAttachedFile)_enrolmentAttachedFile.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.EnrolmentAttachedFile enrolmentAttachedFile) {
		return _enrolmentAttachedFile.compareTo(enrolmentAttachedFile);
	}

	@Override
	public int hashCode() {
		return _enrolmentAttachedFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.EnrolmentAttachedFile> toCacheModel() {
		return _enrolmentAttachedFile.toCacheModel();
	}

	public com.fsoft.bn.model.EnrolmentAttachedFile toEscapedModel() {
		return new EnrolmentAttachedFileWrapper(_enrolmentAttachedFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _enrolmentAttachedFile.toString();
	}

	public java.lang.String toXmlString() {
		return _enrolmentAttachedFile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_enrolmentAttachedFile.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EnrolmentAttachedFile getWrappedEnrolmentAttachedFile() {
		return _enrolmentAttachedFile;
	}

	public EnrolmentAttachedFile getWrappedModel() {
		return _enrolmentAttachedFile;
	}

	public void resetOriginalValues() {
		_enrolmentAttachedFile.resetOriginalValues();
	}

	private EnrolmentAttachedFile _enrolmentAttachedFile;
}