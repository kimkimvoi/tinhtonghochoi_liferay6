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
 * This class is a wrapper for {@link PrimarySchoolAttachedFile}.
 * </p>
 *
 * @author    FSOFT
 * @see       PrimarySchoolAttachedFile
 * @generated
 */
public class PrimarySchoolAttachedFileWrapper
	implements PrimarySchoolAttachedFile,
		ModelWrapper<PrimarySchoolAttachedFile> {
	public PrimarySchoolAttachedFileWrapper(
		PrimarySchoolAttachedFile primarySchoolAttachedFile) {
		_primarySchoolAttachedFile = primarySchoolAttachedFile;
	}

	public Class<?> getModelClass() {
		return PrimarySchoolAttachedFile.class;
	}

	public String getModelClassName() {
		return PrimarySchoolAttachedFile.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("primarySchool_attached_id",
			getPrimarySchool_attached_id());
		attributes.put("primaryStudent_id", getPrimaryStudent_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String primarySchool_attached_id = (String)attributes.get(
				"primarySchool_attached_id");

		if (primarySchool_attached_id != null) {
			setPrimarySchool_attached_id(primarySchool_attached_id);
		}

		String primaryStudent_id = (String)attributes.get("primaryStudent_id");

		if (primaryStudent_id != null) {
			setPrimaryStudent_id(primaryStudent_id);
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
	* Returns the primary key of this primary school attached file.
	*
	* @return the primary key of this primary school attached file
	*/
	public java.lang.String getPrimaryKey() {
		return _primarySchoolAttachedFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this primary school attached file.
	*
	* @param primaryKey the primary key of this primary school attached file
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_primarySchoolAttachedFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the primary school_attached_id of this primary school attached file.
	*
	* @return the primary school_attached_id of this primary school attached file
	*/
	public java.lang.String getPrimarySchool_attached_id() {
		return _primarySchoolAttachedFile.getPrimarySchool_attached_id();
	}

	/**
	* Sets the primary school_attached_id of this primary school attached file.
	*
	* @param primarySchool_attached_id the primary school_attached_id of this primary school attached file
	*/
	public void setPrimarySchool_attached_id(
		java.lang.String primarySchool_attached_id) {
		_primarySchoolAttachedFile.setPrimarySchool_attached_id(primarySchool_attached_id);
	}

	/**
	* Returns the primary student_id of this primary school attached file.
	*
	* @return the primary student_id of this primary school attached file
	*/
	public java.lang.String getPrimaryStudent_id() {
		return _primarySchoolAttachedFile.getPrimaryStudent_id();
	}

	/**
	* Sets the primary student_id of this primary school attached file.
	*
	* @param primaryStudent_id the primary student_id of this primary school attached file
	*/
	public void setPrimaryStudent_id(java.lang.String primaryStudent_id) {
		_primarySchoolAttachedFile.setPrimaryStudent_id(primaryStudent_id);
	}

	/**
	* Returns the attached_file_id of this primary school attached file.
	*
	* @return the attached_file_id of this primary school attached file
	*/
	public java.lang.String getAttached_file_id() {
		return _primarySchoolAttachedFile.getAttached_file_id();
	}

	/**
	* Sets the attached_file_id of this primary school attached file.
	*
	* @param attached_file_id the attached_file_id of this primary school attached file
	*/
	public void setAttached_file_id(java.lang.String attached_file_id) {
		_primarySchoolAttachedFile.setAttached_file_id(attached_file_id);
	}

	/**
	* Returns the created_date of this primary school attached file.
	*
	* @return the created_date of this primary school attached file
	*/
	public java.util.Date getCreated_date() {
		return _primarySchoolAttachedFile.getCreated_date();
	}

	/**
	* Sets the created_date of this primary school attached file.
	*
	* @param created_date the created_date of this primary school attached file
	*/
	public void setCreated_date(java.util.Date created_date) {
		_primarySchoolAttachedFile.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this primary school attached file.
	*
	* @return the modified_date of this primary school attached file
	*/
	public java.util.Date getModified_date() {
		return _primarySchoolAttachedFile.getModified_date();
	}

	/**
	* Sets the modified_date of this primary school attached file.
	*
	* @param modified_date the modified_date of this primary school attached file
	*/
	public void setModified_date(java.util.Date modified_date) {
		_primarySchoolAttachedFile.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this primary school attached file.
	*
	* @return the deleted of this primary school attached file
	*/
	public boolean getDeleted() {
		return _primarySchoolAttachedFile.getDeleted();
	}

	/**
	* Returns <code>true</code> if this primary school attached file is deleted.
	*
	* @return <code>true</code> if this primary school attached file is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _primarySchoolAttachedFile.isDeleted();
	}

	/**
	* Sets whether this primary school attached file is deleted.
	*
	* @param deleted the deleted of this primary school attached file
	*/
	public void setDeleted(boolean deleted) {
		_primarySchoolAttachedFile.setDeleted(deleted);
	}

	public boolean isNew() {
		return _primarySchoolAttachedFile.isNew();
	}

	public void setNew(boolean n) {
		_primarySchoolAttachedFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _primarySchoolAttachedFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_primarySchoolAttachedFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _primarySchoolAttachedFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _primarySchoolAttachedFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_primarySchoolAttachedFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _primarySchoolAttachedFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_primarySchoolAttachedFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PrimarySchoolAttachedFileWrapper((PrimarySchoolAttachedFile)_primarySchoolAttachedFile.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile) {
		return _primarySchoolAttachedFile.compareTo(primarySchoolAttachedFile);
	}

	@Override
	public int hashCode() {
		return _primarySchoolAttachedFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.PrimarySchoolAttachedFile> toCacheModel() {
		return _primarySchoolAttachedFile.toCacheModel();
	}

	public com.fsoft.bn.model.PrimarySchoolAttachedFile toEscapedModel() {
		return new PrimarySchoolAttachedFileWrapper(_primarySchoolAttachedFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _primarySchoolAttachedFile.toString();
	}

	public java.lang.String toXmlString() {
		return _primarySchoolAttachedFile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_primarySchoolAttachedFile.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PrimarySchoolAttachedFile getWrappedPrimarySchoolAttachedFile() {
		return _primarySchoolAttachedFile;
	}

	public PrimarySchoolAttachedFile getWrappedModel() {
		return _primarySchoolAttachedFile;
	}

	public void resetOriginalValues() {
		_primarySchoolAttachedFile.resetOriginalValues();
	}

	private PrimarySchoolAttachedFile _primarySchoolAttachedFile;
}