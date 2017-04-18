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
 * This class is a wrapper for {@link JobTitle}.
 * </p>
 *
 * @author    FSOFT
 * @see       JobTitle
 * @generated
 */
public class JobTitleWrapper implements JobTitle, ModelWrapper<JobTitle> {
	public JobTitleWrapper(JobTitle jobTitle) {
		_jobTitle = jobTitle;
	}

	public Class<?> getModelClass() {
		return JobTitle.class;
	}

	public String getModelClassName() {
		return JobTitle.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("job_title_id", getJob_title_id());
		attributes.put("user_id", getUser_id());
		attributes.put("job_id", getJob_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String job_title_id = (String)attributes.get("job_title_id");

		if (job_title_id != null) {
			setJob_title_id(job_title_id);
		}

		String user_id = (String)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		String job_id = (String)attributes.get("job_id");

		if (job_id != null) {
			setJob_id(job_id);
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
	* Returns the primary key of this job title.
	*
	* @return the primary key of this job title
	*/
	public java.lang.String getPrimaryKey() {
		return _jobTitle.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job title.
	*
	* @param primaryKey the primary key of this job title
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_jobTitle.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job_title_id of this job title.
	*
	* @return the job_title_id of this job title
	*/
	public java.lang.String getJob_title_id() {
		return _jobTitle.getJob_title_id();
	}

	/**
	* Sets the job_title_id of this job title.
	*
	* @param job_title_id the job_title_id of this job title
	*/
	public void setJob_title_id(java.lang.String job_title_id) {
		_jobTitle.setJob_title_id(job_title_id);
	}

	/**
	* Returns the user_id of this job title.
	*
	* @return the user_id of this job title
	*/
	public java.lang.String getUser_id() {
		return _jobTitle.getUser_id();
	}

	/**
	* Sets the user_id of this job title.
	*
	* @param user_id the user_id of this job title
	*/
	public void setUser_id(java.lang.String user_id) {
		_jobTitle.setUser_id(user_id);
	}

	/**
	* Returns the job_id of this job title.
	*
	* @return the job_id of this job title
	*/
	public java.lang.String getJob_id() {
		return _jobTitle.getJob_id();
	}

	/**
	* Sets the job_id of this job title.
	*
	* @param job_id the job_id of this job title
	*/
	public void setJob_id(java.lang.String job_id) {
		_jobTitle.setJob_id(job_id);
	}

	/**
	* Returns the created_date of this job title.
	*
	* @return the created_date of this job title
	*/
	public java.util.Date getCreated_date() {
		return _jobTitle.getCreated_date();
	}

	/**
	* Sets the created_date of this job title.
	*
	* @param created_date the created_date of this job title
	*/
	public void setCreated_date(java.util.Date created_date) {
		_jobTitle.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this job title.
	*
	* @return the modified_date of this job title
	*/
	public java.util.Date getModified_date() {
		return _jobTitle.getModified_date();
	}

	/**
	* Sets the modified_date of this job title.
	*
	* @param modified_date the modified_date of this job title
	*/
	public void setModified_date(java.util.Date modified_date) {
		_jobTitle.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this job title.
	*
	* @return the deleted of this job title
	*/
	public boolean getDeleted() {
		return _jobTitle.getDeleted();
	}

	/**
	* Returns <code>true</code> if this job title is deleted.
	*
	* @return <code>true</code> if this job title is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _jobTitle.isDeleted();
	}

	/**
	* Sets whether this job title is deleted.
	*
	* @param deleted the deleted of this job title
	*/
	public void setDeleted(boolean deleted) {
		_jobTitle.setDeleted(deleted);
	}

	public boolean isNew() {
		return _jobTitle.isNew();
	}

	public void setNew(boolean n) {
		_jobTitle.setNew(n);
	}

	public boolean isCachedModel() {
		return _jobTitle.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_jobTitle.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _jobTitle.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _jobTitle.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jobTitle.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jobTitle.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jobTitle.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobTitleWrapper((JobTitle)_jobTitle.clone());
	}

	public int compareTo(com.fsoft.bn.model.JobTitle jobTitle) {
		return _jobTitle.compareTo(jobTitle);
	}

	@Override
	public int hashCode() {
		return _jobTitle.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.JobTitle> toCacheModel() {
		return _jobTitle.toCacheModel();
	}

	public com.fsoft.bn.model.JobTitle toEscapedModel() {
		return new JobTitleWrapper(_jobTitle.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jobTitle.toString();
	}

	public java.lang.String toXmlString() {
		return _jobTitle.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobTitle.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public JobTitle getWrappedJobTitle() {
		return _jobTitle;
	}

	public JobTitle getWrappedModel() {
		return _jobTitle;
	}

	public void resetOriginalValues() {
		_jobTitle.resetOriginalValues();
	}

	private JobTitle _jobTitle;
}