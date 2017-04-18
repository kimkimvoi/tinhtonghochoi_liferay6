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
 * This class is a wrapper for {@link AnswerAttachedFile}.
 * </p>
 *
 * @author    FSOFT
 * @see       AnswerAttachedFile
 * @generated
 */
public class AnswerAttachedFileWrapper implements AnswerAttachedFile,
	ModelWrapper<AnswerAttachedFile> {
	public AnswerAttachedFileWrapper(AnswerAttachedFile answerAttachedFile) {
		_answerAttachedFile = answerAttachedFile;
	}

	public Class<?> getModelClass() {
		return AnswerAttachedFile.class;
	}

	public String getModelClassName() {
		return AnswerAttachedFile.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("answer_attached_id", getAnswer_attached_id());
		attributes.put("answer_id", getAnswer_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String answer_attached_id = (String)attributes.get("answer_attached_id");

		if (answer_attached_id != null) {
			setAnswer_attached_id(answer_attached_id);
		}

		String answer_id = (String)attributes.get("answer_id");

		if (answer_id != null) {
			setAnswer_id(answer_id);
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
	* Returns the primary key of this answer attached file.
	*
	* @return the primary key of this answer attached file
	*/
	public java.lang.String getPrimaryKey() {
		return _answerAttachedFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this answer attached file.
	*
	* @param primaryKey the primary key of this answer attached file
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_answerAttachedFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the answer_attached_id of this answer attached file.
	*
	* @return the answer_attached_id of this answer attached file
	*/
	public java.lang.String getAnswer_attached_id() {
		return _answerAttachedFile.getAnswer_attached_id();
	}

	/**
	* Sets the answer_attached_id of this answer attached file.
	*
	* @param answer_attached_id the answer_attached_id of this answer attached file
	*/
	public void setAnswer_attached_id(java.lang.String answer_attached_id) {
		_answerAttachedFile.setAnswer_attached_id(answer_attached_id);
	}

	/**
	* Returns the answer_id of this answer attached file.
	*
	* @return the answer_id of this answer attached file
	*/
	public java.lang.String getAnswer_id() {
		return _answerAttachedFile.getAnswer_id();
	}

	/**
	* Sets the answer_id of this answer attached file.
	*
	* @param answer_id the answer_id of this answer attached file
	*/
	public void setAnswer_id(java.lang.String answer_id) {
		_answerAttachedFile.setAnswer_id(answer_id);
	}

	/**
	* Returns the attached_file_id of this answer attached file.
	*
	* @return the attached_file_id of this answer attached file
	*/
	public java.lang.String getAttached_file_id() {
		return _answerAttachedFile.getAttached_file_id();
	}

	/**
	* Sets the attached_file_id of this answer attached file.
	*
	* @param attached_file_id the attached_file_id of this answer attached file
	*/
	public void setAttached_file_id(java.lang.String attached_file_id) {
		_answerAttachedFile.setAttached_file_id(attached_file_id);
	}

	/**
	* Returns the created_date of this answer attached file.
	*
	* @return the created_date of this answer attached file
	*/
	public java.util.Date getCreated_date() {
		return _answerAttachedFile.getCreated_date();
	}

	/**
	* Sets the created_date of this answer attached file.
	*
	* @param created_date the created_date of this answer attached file
	*/
	public void setCreated_date(java.util.Date created_date) {
		_answerAttachedFile.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this answer attached file.
	*
	* @return the modified_date of this answer attached file
	*/
	public java.util.Date getModified_date() {
		return _answerAttachedFile.getModified_date();
	}

	/**
	* Sets the modified_date of this answer attached file.
	*
	* @param modified_date the modified_date of this answer attached file
	*/
	public void setModified_date(java.util.Date modified_date) {
		_answerAttachedFile.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this answer attached file.
	*
	* @return the deleted of this answer attached file
	*/
	public boolean getDeleted() {
		return _answerAttachedFile.getDeleted();
	}

	/**
	* Returns <code>true</code> if this answer attached file is deleted.
	*
	* @return <code>true</code> if this answer attached file is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _answerAttachedFile.isDeleted();
	}

	/**
	* Sets whether this answer attached file is deleted.
	*
	* @param deleted the deleted of this answer attached file
	*/
	public void setDeleted(boolean deleted) {
		_answerAttachedFile.setDeleted(deleted);
	}

	public boolean isNew() {
		return _answerAttachedFile.isNew();
	}

	public void setNew(boolean n) {
		_answerAttachedFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _answerAttachedFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_answerAttachedFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _answerAttachedFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _answerAttachedFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_answerAttachedFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _answerAttachedFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_answerAttachedFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnswerAttachedFileWrapper((AnswerAttachedFile)_answerAttachedFile.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.AnswerAttachedFile answerAttachedFile) {
		return _answerAttachedFile.compareTo(answerAttachedFile);
	}

	@Override
	public int hashCode() {
		return _answerAttachedFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.AnswerAttachedFile> toCacheModel() {
		return _answerAttachedFile.toCacheModel();
	}

	public com.fsoft.bn.model.AnswerAttachedFile toEscapedModel() {
		return new AnswerAttachedFileWrapper(_answerAttachedFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _answerAttachedFile.toString();
	}

	public java.lang.String toXmlString() {
		return _answerAttachedFile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_answerAttachedFile.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AnswerAttachedFile getWrappedAnswerAttachedFile() {
		return _answerAttachedFile;
	}

	public AnswerAttachedFile getWrappedModel() {
		return _answerAttachedFile;
	}

	public void resetOriginalValues() {
		_answerAttachedFile.resetOriginalValues();
	}

	private AnswerAttachedFile _answerAttachedFile;
}