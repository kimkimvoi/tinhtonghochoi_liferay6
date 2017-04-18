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
 * This class is a wrapper for {@link Answer}.
 * </p>
 *
 * @author    FSOFT
 * @see       Answer
 * @generated
 */
public class AnswerWrapper implements Answer, ModelWrapper<Answer> {
	public AnswerWrapper(Answer answer) {
		_answer = answer;
	}

	public Class<?> getModelClass() {
		return Answer.class;
	}

	public String getModelClassName() {
		return Answer.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("answer_id", getAnswer_id());
		attributes.put("answer_content", getAnswer_content());
		attributes.put("user_id", getUser_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String answer_id = (String)attributes.get("answer_id");

		if (answer_id != null) {
			setAnswer_id(answer_id);
		}

		String answer_content = (String)attributes.get("answer_content");

		if (answer_content != null) {
			setAnswer_content(answer_content);
		}

		String user_id = (String)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
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
	* Returns the primary key of this answer.
	*
	* @return the primary key of this answer
	*/
	public java.lang.String getPrimaryKey() {
		return _answer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this answer.
	*
	* @param primaryKey the primary key of this answer
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_answer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the answer_id of this answer.
	*
	* @return the answer_id of this answer
	*/
	public java.lang.String getAnswer_id() {
		return _answer.getAnswer_id();
	}

	/**
	* Sets the answer_id of this answer.
	*
	* @param answer_id the answer_id of this answer
	*/
	public void setAnswer_id(java.lang.String answer_id) {
		_answer.setAnswer_id(answer_id);
	}

	/**
	* Returns the answer_content of this answer.
	*
	* @return the answer_content of this answer
	*/
	public java.lang.String getAnswer_content() {
		return _answer.getAnswer_content();
	}

	/**
	* Sets the answer_content of this answer.
	*
	* @param answer_content the answer_content of this answer
	*/
	public void setAnswer_content(java.lang.String answer_content) {
		_answer.setAnswer_content(answer_content);
	}

	/**
	* Returns the user_id of this answer.
	*
	* @return the user_id of this answer
	*/
	public java.lang.String getUser_id() {
		return _answer.getUser_id();
	}

	/**
	* Sets the user_id of this answer.
	*
	* @param user_id the user_id of this answer
	*/
	public void setUser_id(java.lang.String user_id) {
		_answer.setUser_id(user_id);
	}

	/**
	* Returns the created_date of this answer.
	*
	* @return the created_date of this answer
	*/
	public java.util.Date getCreated_date() {
		return _answer.getCreated_date();
	}

	/**
	* Sets the created_date of this answer.
	*
	* @param created_date the created_date of this answer
	*/
	public void setCreated_date(java.util.Date created_date) {
		_answer.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this answer.
	*
	* @return the modified_date of this answer
	*/
	public java.util.Date getModified_date() {
		return _answer.getModified_date();
	}

	/**
	* Sets the modified_date of this answer.
	*
	* @param modified_date the modified_date of this answer
	*/
	public void setModified_date(java.util.Date modified_date) {
		_answer.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this answer.
	*
	* @return the deleted of this answer
	*/
	public boolean getDeleted() {
		return _answer.getDeleted();
	}

	/**
	* Returns <code>true</code> if this answer is deleted.
	*
	* @return <code>true</code> if this answer is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _answer.isDeleted();
	}

	/**
	* Sets whether this answer is deleted.
	*
	* @param deleted the deleted of this answer
	*/
	public void setDeleted(boolean deleted) {
		_answer.setDeleted(deleted);
	}

	public boolean isNew() {
		return _answer.isNew();
	}

	public void setNew(boolean n) {
		_answer.setNew(n);
	}

	public boolean isCachedModel() {
		return _answer.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_answer.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _answer.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _answer.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_answer.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _answer.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_answer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnswerWrapper((Answer)_answer.clone());
	}

	public int compareTo(com.fsoft.bn.model.Answer answer) {
		return _answer.compareTo(answer);
	}

	@Override
	public int hashCode() {
		return _answer.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.Answer> toCacheModel() {
		return _answer.toCacheModel();
	}

	public com.fsoft.bn.model.Answer toEscapedModel() {
		return new AnswerWrapper(_answer.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _answer.toString();
	}

	public java.lang.String toXmlString() {
		return _answer.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_answer.persist();
	}

	public java.lang.String getOrganizationName() {
		return _answer.getOrganizationName();
	}

	public void setOrganizationName(java.lang.String organizationName) {
		_answer.setOrganizationName(organizationName);
	}

	public java.lang.String getFormatedCreatedDate() {
		return _answer.getFormatedCreatedDate();
	}

	public void setFormatedCreatedDate(java.lang.String formatedCreatedDate) {
		_answer.setFormatedCreatedDate(formatedCreatedDate);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Answer getWrappedAnswer() {
		return _answer;
	}

	public Answer getWrappedModel() {
		return _answer;
	}

	public void resetOriginalValues() {
		_answer.resetOriginalValues();
	}

	private Answer _answer;
}