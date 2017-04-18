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
 * This class is a wrapper for {@link RecruitmentAttachedFile}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentAttachedFile
 * @generated
 */
public class RecruitmentAttachedFileWrapper implements RecruitmentAttachedFile,
	ModelWrapper<RecruitmentAttachedFile> {
	public RecruitmentAttachedFileWrapper(
		RecruitmentAttachedFile recruitmentAttachedFile) {
		_recruitmentAttachedFile = recruitmentAttachedFile;
	}

	public Class<?> getModelClass() {
		return RecruitmentAttachedFile.class;
	}

	public String getModelClassName() {
		return RecruitmentAttachedFile.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_attached_id", getRecruitment_attached_id());
		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_attached_id = (String)attributes.get(
				"recruitment_attached_id");

		if (recruitment_attached_id != null) {
			setRecruitment_attached_id(recruitment_attached_id);
		}

		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
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
	* Returns the primary key of this recruitment attached file.
	*
	* @return the primary key of this recruitment attached file
	*/
	public java.lang.String getPrimaryKey() {
		return _recruitmentAttachedFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this recruitment attached file.
	*
	* @param primaryKey the primary key of this recruitment attached file
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_recruitmentAttachedFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the recruitment_attached_id of this recruitment attached file.
	*
	* @return the recruitment_attached_id of this recruitment attached file
	*/
	public java.lang.String getRecruitment_attached_id() {
		return _recruitmentAttachedFile.getRecruitment_attached_id();
	}

	/**
	* Sets the recruitment_attached_id of this recruitment attached file.
	*
	* @param recruitment_attached_id the recruitment_attached_id of this recruitment attached file
	*/
	public void setRecruitment_attached_id(
		java.lang.String recruitment_attached_id) {
		_recruitmentAttachedFile.setRecruitment_attached_id(recruitment_attached_id);
	}

	/**
	* Returns the recruitment_id of this recruitment attached file.
	*
	* @return the recruitment_id of this recruitment attached file
	*/
	public java.lang.String getRecruitment_id() {
		return _recruitmentAttachedFile.getRecruitment_id();
	}

	/**
	* Sets the recruitment_id of this recruitment attached file.
	*
	* @param recruitment_id the recruitment_id of this recruitment attached file
	*/
	public void setRecruitment_id(java.lang.String recruitment_id) {
		_recruitmentAttachedFile.setRecruitment_id(recruitment_id);
	}

	/**
	* Returns the attached_file_id of this recruitment attached file.
	*
	* @return the attached_file_id of this recruitment attached file
	*/
	public java.lang.String getAttached_file_id() {
		return _recruitmentAttachedFile.getAttached_file_id();
	}

	/**
	* Sets the attached_file_id of this recruitment attached file.
	*
	* @param attached_file_id the attached_file_id of this recruitment attached file
	*/
	public void setAttached_file_id(java.lang.String attached_file_id) {
		_recruitmentAttachedFile.setAttached_file_id(attached_file_id);
	}

	/**
	* Returns the created_date of this recruitment attached file.
	*
	* @return the created_date of this recruitment attached file
	*/
	public java.util.Date getCreated_date() {
		return _recruitmentAttachedFile.getCreated_date();
	}

	/**
	* Sets the created_date of this recruitment attached file.
	*
	* @param created_date the created_date of this recruitment attached file
	*/
	public void setCreated_date(java.util.Date created_date) {
		_recruitmentAttachedFile.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this recruitment attached file.
	*
	* @return the modified_date of this recruitment attached file
	*/
	public java.util.Date getModified_date() {
		return _recruitmentAttachedFile.getModified_date();
	}

	/**
	* Sets the modified_date of this recruitment attached file.
	*
	* @param modified_date the modified_date of this recruitment attached file
	*/
	public void setModified_date(java.util.Date modified_date) {
		_recruitmentAttachedFile.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this recruitment attached file.
	*
	* @return the deleted of this recruitment attached file
	*/
	public boolean getDeleted() {
		return _recruitmentAttachedFile.getDeleted();
	}

	/**
	* Returns <code>true</code> if this recruitment attached file is deleted.
	*
	* @return <code>true</code> if this recruitment attached file is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _recruitmentAttachedFile.isDeleted();
	}

	/**
	* Sets whether this recruitment attached file is deleted.
	*
	* @param deleted the deleted of this recruitment attached file
	*/
	public void setDeleted(boolean deleted) {
		_recruitmentAttachedFile.setDeleted(deleted);
	}

	public boolean isNew() {
		return _recruitmentAttachedFile.isNew();
	}

	public void setNew(boolean n) {
		_recruitmentAttachedFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _recruitmentAttachedFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_recruitmentAttachedFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _recruitmentAttachedFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _recruitmentAttachedFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_recruitmentAttachedFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _recruitmentAttachedFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_recruitmentAttachedFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecruitmentAttachedFileWrapper((RecruitmentAttachedFile)_recruitmentAttachedFile.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.RecruitmentAttachedFile recruitmentAttachedFile) {
		return _recruitmentAttachedFile.compareTo(recruitmentAttachedFile);
	}

	@Override
	public int hashCode() {
		return _recruitmentAttachedFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.RecruitmentAttachedFile> toCacheModel() {
		return _recruitmentAttachedFile.toCacheModel();
	}

	public com.fsoft.bn.model.RecruitmentAttachedFile toEscapedModel() {
		return new RecruitmentAttachedFileWrapper(_recruitmentAttachedFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _recruitmentAttachedFile.toString();
	}

	public java.lang.String toXmlString() {
		return _recruitmentAttachedFile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_recruitmentAttachedFile.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RecruitmentAttachedFile getWrappedRecruitmentAttachedFile() {
		return _recruitmentAttachedFile;
	}

	public RecruitmentAttachedFile getWrappedModel() {
		return _recruitmentAttachedFile;
	}

	public void resetOriginalValues() {
		_recruitmentAttachedFile.resetOriginalValues();
	}

	private RecruitmentAttachedFile _recruitmentAttachedFile;
}