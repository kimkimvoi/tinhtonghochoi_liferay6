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
 * This class is a wrapper for {@link Question}.
 * </p>
 *
 * @author    FSOFT
 * @see       Question
 * @generated
 */
public class QuestionWrapper implements Question, ModelWrapper<Question> {
	public QuestionWrapper(Question question) {
		_question = question;
	}

	public Class<?> getModelClass() {
		return Question.class;
	}

	public String getModelClassName() {
		return Question.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("question_id", getQuestion_id());
		attributes.put("question_title", getQuestion_title());
		attributes.put("question_type_id", getQuestion_type_id());
		attributes.put("question_content", getQuestion_content());
		attributes.put("citizen_name", getCitizen_name());
		attributes.put("citizen_mail", getCitizen_mail());
		attributes.put("citizen_phone", getCitizen_phone());
		attributes.put("citizen_address", getCitizen_address());
		attributes.put("question_status_id", getQuestion_status_id());
		attributes.put("answer_id", getAnswer_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String question_id = (String)attributes.get("question_id");

		if (question_id != null) {
			setQuestion_id(question_id);
		}

		String question_title = (String)attributes.get("question_title");

		if (question_title != null) {
			setQuestion_title(question_title);
		}

		String question_type_id = (String)attributes.get("question_type_id");

		if (question_type_id != null) {
			setQuestion_type_id(question_type_id);
		}

		String question_content = (String)attributes.get("question_content");

		if (question_content != null) {
			setQuestion_content(question_content);
		}

		String citizen_name = (String)attributes.get("citizen_name");

		if (citizen_name != null) {
			setCitizen_name(citizen_name);
		}

		String citizen_mail = (String)attributes.get("citizen_mail");

		if (citizen_mail != null) {
			setCitizen_mail(citizen_mail);
		}

		String citizen_phone = (String)attributes.get("citizen_phone");

		if (citizen_phone != null) {
			setCitizen_phone(citizen_phone);
		}

		String citizen_address = (String)attributes.get("citizen_address");

		if (citizen_address != null) {
			setCitizen_address(citizen_address);
		}

		String question_status_id = (String)attributes.get("question_status_id");

		if (question_status_id != null) {
			setQuestion_status_id(question_status_id);
		}

		String answer_id = (String)attributes.get("answer_id");

		if (answer_id != null) {
			setAnswer_id(answer_id);
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
	* Returns the primary key of this question.
	*
	* @return the primary key of this question
	*/
	public java.lang.String getPrimaryKey() {
		return _question.getPrimaryKey();
	}

	/**
	* Sets the primary key of this question.
	*
	* @param primaryKey the primary key of this question
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_question.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the question_id of this question.
	*
	* @return the question_id of this question
	*/
	public java.lang.String getQuestion_id() {
		return _question.getQuestion_id();
	}

	/**
	* Sets the question_id of this question.
	*
	* @param question_id the question_id of this question
	*/
	public void setQuestion_id(java.lang.String question_id) {
		_question.setQuestion_id(question_id);
	}

	/**
	* Returns the question_title of this question.
	*
	* @return the question_title of this question
	*/
	public java.lang.String getQuestion_title() {
		return _question.getQuestion_title();
	}

	/**
	* Sets the question_title of this question.
	*
	* @param question_title the question_title of this question
	*/
	public void setQuestion_title(java.lang.String question_title) {
		_question.setQuestion_title(question_title);
	}

	/**
	* Returns the question_type_id of this question.
	*
	* @return the question_type_id of this question
	*/
	public java.lang.String getQuestion_type_id() {
		return _question.getQuestion_type_id();
	}

	/**
	* Sets the question_type_id of this question.
	*
	* @param question_type_id the question_type_id of this question
	*/
	public void setQuestion_type_id(java.lang.String question_type_id) {
		_question.setQuestion_type_id(question_type_id);
	}

	/**
	* Returns the question_content of this question.
	*
	* @return the question_content of this question
	*/
	public java.lang.String getQuestion_content() {
		return _question.getQuestion_content();
	}

	/**
	* Sets the question_content of this question.
	*
	* @param question_content the question_content of this question
	*/
	public void setQuestion_content(java.lang.String question_content) {
		_question.setQuestion_content(question_content);
	}

	/**
	* Returns the citizen_name of this question.
	*
	* @return the citizen_name of this question
	*/
	public java.lang.String getCitizen_name() {
		return _question.getCitizen_name();
	}

	/**
	* Sets the citizen_name of this question.
	*
	* @param citizen_name the citizen_name of this question
	*/
	public void setCitizen_name(java.lang.String citizen_name) {
		_question.setCitizen_name(citizen_name);
	}

	/**
	* Returns the citizen_mail of this question.
	*
	* @return the citizen_mail of this question
	*/
	public java.lang.String getCitizen_mail() {
		return _question.getCitizen_mail();
	}

	/**
	* Sets the citizen_mail of this question.
	*
	* @param citizen_mail the citizen_mail of this question
	*/
	public void setCitizen_mail(java.lang.String citizen_mail) {
		_question.setCitizen_mail(citizen_mail);
	}

	/**
	* Returns the citizen_phone of this question.
	*
	* @return the citizen_phone of this question
	*/
	public java.lang.String getCitizen_phone() {
		return _question.getCitizen_phone();
	}

	/**
	* Sets the citizen_phone of this question.
	*
	* @param citizen_phone the citizen_phone of this question
	*/
	public void setCitizen_phone(java.lang.String citizen_phone) {
		_question.setCitizen_phone(citizen_phone);
	}

	/**
	* Returns the citizen_address of this question.
	*
	* @return the citizen_address of this question
	*/
	public java.lang.String getCitizen_address() {
		return _question.getCitizen_address();
	}

	/**
	* Sets the citizen_address of this question.
	*
	* @param citizen_address the citizen_address of this question
	*/
	public void setCitizen_address(java.lang.String citizen_address) {
		_question.setCitizen_address(citizen_address);
	}

	/**
	* Returns the question_status_id of this question.
	*
	* @return the question_status_id of this question
	*/
	public java.lang.String getQuestion_status_id() {
		return _question.getQuestion_status_id();
	}

	/**
	* Sets the question_status_id of this question.
	*
	* @param question_status_id the question_status_id of this question
	*/
	public void setQuestion_status_id(java.lang.String question_status_id) {
		_question.setQuestion_status_id(question_status_id);
	}

	/**
	* Returns the answer_id of this question.
	*
	* @return the answer_id of this question
	*/
	public java.lang.String getAnswer_id() {
		return _question.getAnswer_id();
	}

	/**
	* Sets the answer_id of this question.
	*
	* @param answer_id the answer_id of this question
	*/
	public void setAnswer_id(java.lang.String answer_id) {
		_question.setAnswer_id(answer_id);
	}

	/**
	* Returns the created_date of this question.
	*
	* @return the created_date of this question
	*/
	public java.util.Date getCreated_date() {
		return _question.getCreated_date();
	}

	/**
	* Sets the created_date of this question.
	*
	* @param created_date the created_date of this question
	*/
	public void setCreated_date(java.util.Date created_date) {
		_question.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this question.
	*
	* @return the modified_date of this question
	*/
	public java.util.Date getModified_date() {
		return _question.getModified_date();
	}

	/**
	* Sets the modified_date of this question.
	*
	* @param modified_date the modified_date of this question
	*/
	public void setModified_date(java.util.Date modified_date) {
		_question.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this question.
	*
	* @return the deleted of this question
	*/
	public boolean getDeleted() {
		return _question.getDeleted();
	}

	/**
	* Returns <code>true</code> if this question is deleted.
	*
	* @return <code>true</code> if this question is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _question.isDeleted();
	}

	/**
	* Sets whether this question is deleted.
	*
	* @param deleted the deleted of this question
	*/
	public void setDeleted(boolean deleted) {
		_question.setDeleted(deleted);
	}

	public boolean isNew() {
		return _question.isNew();
	}

	public void setNew(boolean n) {
		_question.setNew(n);
	}

	public boolean isCachedModel() {
		return _question.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_question.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _question.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _question.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_question.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _question.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_question.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionWrapper((Question)_question.clone());
	}

	public int compareTo(com.fsoft.bn.model.Question question) {
		return _question.compareTo(question);
	}

	@Override
	public int hashCode() {
		return _question.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.Question> toCacheModel() {
		return _question.toCacheModel();
	}

	public com.fsoft.bn.model.Question toEscapedModel() {
		return new QuestionWrapper(_question.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _question.toString();
	}

	public java.lang.String toXmlString() {
		return _question.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_question.persist();
	}

	/**
	* @return the statusDisplay
	*/
	public java.lang.String getStatusDisplay() {
		return _question.getStatusDisplay();
	}

	/**
	* @param statusDisplay the statusDisplay to set
	*/
	public void setStatusDisplay(java.lang.String statusDisplay) {
		_question.setStatusDisplay(statusDisplay);
	}

	/**
	* @return the dateDisplay
	*/
	public java.lang.String getDateDisplay() {
		return _question.getDateDisplay();
	}

	/**
	* @param dateDisplay the dateDisplay to set
	*/
	public void setDateDisplay(java.lang.String dateDisplay) {
		_question.setDateDisplay(dateDisplay);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Question getWrappedQuestion() {
		return _question;
	}

	public Question getWrappedModel() {
		return _question;
	}

	public void resetOriginalValues() {
		_question.resetOriginalValues();
	}

	private Question _question;
}