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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Answer service. Represents a row in the &quot;BN_Answer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.AnswerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.AnswerImpl}.
 * </p>
 *
 * @author FSOFT
 * @see Answer
 * @see com.fsoft.bn.model.impl.AnswerImpl
 * @see com.fsoft.bn.model.impl.AnswerModelImpl
 * @generated
 */
public interface AnswerModel extends BaseModel<Answer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a answer model instance should use the {@link Answer} interface instead.
	 */

	/**
	 * Returns the primary key of this answer.
	 *
	 * @return the primary key of this answer
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this answer.
	 *
	 * @param primaryKey the primary key of this answer
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the answer_id of this answer.
	 *
	 * @return the answer_id of this answer
	 */
	@AutoEscape
	public String getAnswer_id();

	/**
	 * Sets the answer_id of this answer.
	 *
	 * @param answer_id the answer_id of this answer
	 */
	public void setAnswer_id(String answer_id);

	/**
	 * Returns the answer_content of this answer.
	 *
	 * @return the answer_content of this answer
	 */
	@AutoEscape
	public String getAnswer_content();

	/**
	 * Sets the answer_content of this answer.
	 *
	 * @param answer_content the answer_content of this answer
	 */
	public void setAnswer_content(String answer_content);

	/**
	 * Returns the user_id of this answer.
	 *
	 * @return the user_id of this answer
	 */
	@AutoEscape
	public String getUser_id();

	/**
	 * Sets the user_id of this answer.
	 *
	 * @param user_id the user_id of this answer
	 */
	public void setUser_id(String user_id);

	/**
	 * Returns the created_date of this answer.
	 *
	 * @return the created_date of this answer
	 */
	public Date getCreated_date();

	/**
	 * Sets the created_date of this answer.
	 *
	 * @param created_date the created_date of this answer
	 */
	public void setCreated_date(Date created_date);

	/**
	 * Returns the modified_date of this answer.
	 *
	 * @return the modified_date of this answer
	 */
	public Date getModified_date();

	/**
	 * Sets the modified_date of this answer.
	 *
	 * @param modified_date the modified_date of this answer
	 */
	public void setModified_date(Date modified_date);

	/**
	 * Returns the deleted of this answer.
	 *
	 * @return the deleted of this answer
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this answer is deleted.
	 *
	 * @return <code>true</code> if this answer is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this answer is deleted.
	 *
	 * @param deleted the deleted of this answer
	 */
	public void setDeleted(boolean deleted);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Answer answer);

	public int hashCode();

	public CacheModel<Answer> toCacheModel();

	public Answer toEscapedModel();

	public String toString();

	public String toXmlString();
}