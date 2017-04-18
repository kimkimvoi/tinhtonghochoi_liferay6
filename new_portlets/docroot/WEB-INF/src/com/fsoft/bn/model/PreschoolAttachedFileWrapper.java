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
 * This class is a wrapper for {@link PreschoolAttachedFile}.
 * </p>
 *
 * @author    FSOFT
 * @see       PreschoolAttachedFile
 * @generated
 */
public class PreschoolAttachedFileWrapper implements PreschoolAttachedFile,
	ModelWrapper<PreschoolAttachedFile> {
	public PreschoolAttachedFileWrapper(
		PreschoolAttachedFile preschoolAttachedFile) {
		_preschoolAttachedFile = preschoolAttachedFile;
	}

	public Class<?> getModelClass() {
		return PreschoolAttachedFile.class;
	}

	public String getModelClassName() {
		return PreschoolAttachedFile.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("preschool_attached_id", getPreschool_attached_id());
		attributes.put("student_id", getStudent_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String preschool_attached_id = (String)attributes.get(
				"preschool_attached_id");

		if (preschool_attached_id != null) {
			setPreschool_attached_id(preschool_attached_id);
		}

		String student_id = (String)attributes.get("student_id");

		if (student_id != null) {
			setStudent_id(student_id);
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
	* Returns the primary key of this preschool attached file.
	*
	* @return the primary key of this preschool attached file
	*/
	public java.lang.String getPrimaryKey() {
		return _preschoolAttachedFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this preschool attached file.
	*
	* @param primaryKey the primary key of this preschool attached file
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_preschoolAttachedFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the preschool_attached_id of this preschool attached file.
	*
	* @return the preschool_attached_id of this preschool attached file
	*/
	public java.lang.String getPreschool_attached_id() {
		return _preschoolAttachedFile.getPreschool_attached_id();
	}

	/**
	* Sets the preschool_attached_id of this preschool attached file.
	*
	* @param preschool_attached_id the preschool_attached_id of this preschool attached file
	*/
	public void setPreschool_attached_id(java.lang.String preschool_attached_id) {
		_preschoolAttachedFile.setPreschool_attached_id(preschool_attached_id);
	}

	/**
	* Returns the student_id of this preschool attached file.
	*
	* @return the student_id of this preschool attached file
	*/
	public java.lang.String getStudent_id() {
		return _preschoolAttachedFile.getStudent_id();
	}

	/**
	* Sets the student_id of this preschool attached file.
	*
	* @param student_id the student_id of this preschool attached file
	*/
	public void setStudent_id(java.lang.String student_id) {
		_preschoolAttachedFile.setStudent_id(student_id);
	}

	/**
	* Returns the attached_file_id of this preschool attached file.
	*
	* @return the attached_file_id of this preschool attached file
	*/
	public java.lang.String getAttached_file_id() {
		return _preschoolAttachedFile.getAttached_file_id();
	}

	/**
	* Sets the attached_file_id of this preschool attached file.
	*
	* @param attached_file_id the attached_file_id of this preschool attached file
	*/
	public void setAttached_file_id(java.lang.String attached_file_id) {
		_preschoolAttachedFile.setAttached_file_id(attached_file_id);
	}

	/**
	* Returns the created_date of this preschool attached file.
	*
	* @return the created_date of this preschool attached file
	*/
	public java.util.Date getCreated_date() {
		return _preschoolAttachedFile.getCreated_date();
	}

	/**
	* Sets the created_date of this preschool attached file.
	*
	* @param created_date the created_date of this preschool attached file
	*/
	public void setCreated_date(java.util.Date created_date) {
		_preschoolAttachedFile.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this preschool attached file.
	*
	* @return the modified_date of this preschool attached file
	*/
	public java.util.Date getModified_date() {
		return _preschoolAttachedFile.getModified_date();
	}

	/**
	* Sets the modified_date of this preschool attached file.
	*
	* @param modified_date the modified_date of this preschool attached file
	*/
	public void setModified_date(java.util.Date modified_date) {
		_preschoolAttachedFile.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this preschool attached file.
	*
	* @return the deleted of this preschool attached file
	*/
	public boolean getDeleted() {
		return _preschoolAttachedFile.getDeleted();
	}

	/**
	* Returns <code>true</code> if this preschool attached file is deleted.
	*
	* @return <code>true</code> if this preschool attached file is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _preschoolAttachedFile.isDeleted();
	}

	/**
	* Sets whether this preschool attached file is deleted.
	*
	* @param deleted the deleted of this preschool attached file
	*/
	public void setDeleted(boolean deleted) {
		_preschoolAttachedFile.setDeleted(deleted);
	}

	public boolean isNew() {
		return _preschoolAttachedFile.isNew();
	}

	public void setNew(boolean n) {
		_preschoolAttachedFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _preschoolAttachedFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_preschoolAttachedFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _preschoolAttachedFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _preschoolAttachedFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_preschoolAttachedFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _preschoolAttachedFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_preschoolAttachedFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PreschoolAttachedFileWrapper((PreschoolAttachedFile)_preschoolAttachedFile.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile) {
		return _preschoolAttachedFile.compareTo(preschoolAttachedFile);
	}

	@Override
	public int hashCode() {
		return _preschoolAttachedFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.PreschoolAttachedFile> toCacheModel() {
		return _preschoolAttachedFile.toCacheModel();
	}

	public com.fsoft.bn.model.PreschoolAttachedFile toEscapedModel() {
		return new PreschoolAttachedFileWrapper(_preschoolAttachedFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _preschoolAttachedFile.toString();
	}

	public java.lang.String toXmlString() {
		return _preschoolAttachedFile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_preschoolAttachedFile.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PreschoolAttachedFile getWrappedPreschoolAttachedFile() {
		return _preschoolAttachedFile;
	}

	public PreschoolAttachedFile getWrappedModel() {
		return _preschoolAttachedFile;
	}

	public void resetOriginalValues() {
		_preschoolAttachedFile.resetOriginalValues();
	}

	private PreschoolAttachedFile _preschoolAttachedFile;
}