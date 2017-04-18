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
 * This class is a wrapper for {@link QuestionAttachedFile}.
 * </p>
 *
 * @author    FSOFT
 * @see       QuestionAttachedFile
 * @generated
 */
public class QuestionAttachedFileWrapper implements QuestionAttachedFile,
	ModelWrapper<QuestionAttachedFile> {
	public QuestionAttachedFileWrapper(
		QuestionAttachedFile questionAttachedFile) {
		_questionAttachedFile = questionAttachedFile;
	}

	public Class<?> getModelClass() {
		return QuestionAttachedFile.class;
	}

	public String getModelClassName() {
		return QuestionAttachedFile.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("question_attached_id", getQuestion_attached_id());
		attributes.put("question_id", getQuestion_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String question_attached_id = (String)attributes.get(
				"question_attached_id");

		if (question_attached_id != null) {
			setQuestion_attached_id(question_attached_id);
		}

		String question_id = (String)attributes.get("question_id");

		if (question_id != null) {
			setQuestion_id(question_id);
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
	* Returns the primary key of this question attached file.
	*
	* @return the primary key of this question attached file
	*/
	public java.lang.String getPrimaryKey() {
		return _questionAttachedFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this question attached file.
	*
	* @param primaryKey the primary key of this question attached file
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_questionAttachedFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the question_attached_id of this question attached file.
	*
	* @return the question_attached_id of this question attached file
	*/
	public java.lang.String getQuestion_attached_id() {
		return _questionAttachedFile.getQuestion_attached_id();
	}

	/**
	* Sets the question_attached_id of this question attached file.
	*
	* @param question_attached_id the question_attached_id of this question attached file
	*/
	public void setQuestion_attached_id(java.lang.String question_attached_id) {
		_questionAttachedFile.setQuestion_attached_id(question_attached_id);
	}

	/**
	* Returns the question_id of this question attached file.
	*
	* @return the question_id of this question attached file
	*/
	public java.lang.String getQuestion_id() {
		return _questionAttachedFile.getQuestion_id();
	}

	/**
	* Sets the question_id of this question attached file.
	*
	* @param question_id the question_id of this question attached file
	*/
	public void setQuestion_id(java.lang.String question_id) {
		_questionAttachedFile.setQuestion_id(question_id);
	}

	/**
	* Returns the attached_file_id of this question attached file.
	*
	* @return the attached_file_id of this question attached file
	*/
	public java.lang.String getAttached_file_id() {
		return _questionAttachedFile.getAttached_file_id();
	}

	/**
	* Sets the attached_file_id of this question attached file.
	*
	* @param attached_file_id the attached_file_id of this question attached file
	*/
	public void setAttached_file_id(java.lang.String attached_file_id) {
		_questionAttachedFile.setAttached_file_id(attached_file_id);
	}

	/**
	* Returns the created_date of this question attached file.
	*
	* @return the created_date of this question attached file
	*/
	public java.util.Date getCreated_date() {
		return _questionAttachedFile.getCreated_date();
	}

	/**
	* Sets the created_date of this question attached file.
	*
	* @param created_date the created_date of this question attached file
	*/
	public void setCreated_date(java.util.Date created_date) {
		_questionAttachedFile.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this question attached file.
	*
	* @return the modified_date of this question attached file
	*/
	public java.util.Date getModified_date() {
		return _questionAttachedFile.getModified_date();
	}

	/**
	* Sets the modified_date of this question attached file.
	*
	* @param modified_date the modified_date of this question attached file
	*/
	public void setModified_date(java.util.Date modified_date) {
		_questionAttachedFile.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this question attached file.
	*
	* @return the deleted of this question attached file
	*/
	public boolean getDeleted() {
		return _questionAttachedFile.getDeleted();
	}

	/**
	* Returns <code>true</code> if this question attached file is deleted.
	*
	* @return <code>true</code> if this question attached file is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _questionAttachedFile.isDeleted();
	}

	/**
	* Sets whether this question attached file is deleted.
	*
	* @param deleted the deleted of this question attached file
	*/
	public void setDeleted(boolean deleted) {
		_questionAttachedFile.setDeleted(deleted);
	}

	public boolean isNew() {
		return _questionAttachedFile.isNew();
	}

	public void setNew(boolean n) {
		_questionAttachedFile.setNew(n);
	}

	public boolean isCachedModel() {
		return _questionAttachedFile.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_questionAttachedFile.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _questionAttachedFile.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _questionAttachedFile.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_questionAttachedFile.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _questionAttachedFile.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_questionAttachedFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionAttachedFileWrapper((QuestionAttachedFile)_questionAttachedFile.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.QuestionAttachedFile questionAttachedFile) {
		return _questionAttachedFile.compareTo(questionAttachedFile);
	}

	@Override
	public int hashCode() {
		return _questionAttachedFile.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.QuestionAttachedFile> toCacheModel() {
		return _questionAttachedFile.toCacheModel();
	}

	public com.fsoft.bn.model.QuestionAttachedFile toEscapedModel() {
		return new QuestionAttachedFileWrapper(_questionAttachedFile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _questionAttachedFile.toString();
	}

	public java.lang.String toXmlString() {
		return _questionAttachedFile.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_questionAttachedFile.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public QuestionAttachedFile getWrappedQuestionAttachedFile() {
		return _questionAttachedFile;
	}

	public QuestionAttachedFile getWrappedModel() {
		return _questionAttachedFile;
	}

	public void resetOriginalValues() {
		_questionAttachedFile.resetOriginalValues();
	}

	private QuestionAttachedFile _questionAttachedFile;
}