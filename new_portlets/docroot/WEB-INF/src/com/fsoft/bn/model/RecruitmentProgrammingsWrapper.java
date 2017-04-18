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
 * This class is a wrapper for {@link RecruitmentProgrammings}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentProgrammings
 * @generated
 */
public class RecruitmentProgrammingsWrapper implements RecruitmentProgrammings,
	ModelWrapper<RecruitmentProgrammings> {
	public RecruitmentProgrammingsWrapper(
		RecruitmentProgrammings recruitmentProgrammings) {
		_recruitmentProgrammings = recruitmentProgrammings;
	}

	public Class<?> getModelClass() {
		return RecruitmentProgrammings.class;
	}

	public String getModelClassName() {
		return RecruitmentProgrammings.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_programmings_id",
			getRecruitment_programmings_id());
		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("course", getCourse());
		attributes.put("level", getLevel());
		attributes.put("certificate", getCertificate());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_programmings_id = (String)attributes.get(
				"recruitment_programmings_id");

		if (recruitment_programmings_id != null) {
			setRecruitment_programmings_id(recruitment_programmings_id);
		}

		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
		}

		String course = (String)attributes.get("course");

		if (course != null) {
			setCourse(course);
		}

		String level = (String)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		String certificate = (String)attributes.get("certificate");

		if (certificate != null) {
			setCertificate(certificate);
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
	* Returns the primary key of this recruitment programmings.
	*
	* @return the primary key of this recruitment programmings
	*/
	public java.lang.String getPrimaryKey() {
		return _recruitmentProgrammings.getPrimaryKey();
	}

	/**
	* Sets the primary key of this recruitment programmings.
	*
	* @param primaryKey the primary key of this recruitment programmings
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_recruitmentProgrammings.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the recruitment_programmings_id of this recruitment programmings.
	*
	* @return the recruitment_programmings_id of this recruitment programmings
	*/
	public java.lang.String getRecruitment_programmings_id() {
		return _recruitmentProgrammings.getRecruitment_programmings_id();
	}

	/**
	* Sets the recruitment_programmings_id of this recruitment programmings.
	*
	* @param recruitment_programmings_id the recruitment_programmings_id of this recruitment programmings
	*/
	public void setRecruitment_programmings_id(
		java.lang.String recruitment_programmings_id) {
		_recruitmentProgrammings.setRecruitment_programmings_id(recruitment_programmings_id);
	}

	/**
	* Returns the recruitment_id of this recruitment programmings.
	*
	* @return the recruitment_id of this recruitment programmings
	*/
	public java.lang.String getRecruitment_id() {
		return _recruitmentProgrammings.getRecruitment_id();
	}

	/**
	* Sets the recruitment_id of this recruitment programmings.
	*
	* @param recruitment_id the recruitment_id of this recruitment programmings
	*/
	public void setRecruitment_id(java.lang.String recruitment_id) {
		_recruitmentProgrammings.setRecruitment_id(recruitment_id);
	}

	/**
	* Returns the course of this recruitment programmings.
	*
	* @return the course of this recruitment programmings
	*/
	public java.lang.String getCourse() {
		return _recruitmentProgrammings.getCourse();
	}

	/**
	* Sets the course of this recruitment programmings.
	*
	* @param course the course of this recruitment programmings
	*/
	public void setCourse(java.lang.String course) {
		_recruitmentProgrammings.setCourse(course);
	}

	/**
	* Returns the level of this recruitment programmings.
	*
	* @return the level of this recruitment programmings
	*/
	public java.lang.String getLevel() {
		return _recruitmentProgrammings.getLevel();
	}

	/**
	* Sets the level of this recruitment programmings.
	*
	* @param level the level of this recruitment programmings
	*/
	public void setLevel(java.lang.String level) {
		_recruitmentProgrammings.setLevel(level);
	}

	/**
	* Returns the certificate of this recruitment programmings.
	*
	* @return the certificate of this recruitment programmings
	*/
	public java.lang.String getCertificate() {
		return _recruitmentProgrammings.getCertificate();
	}

	/**
	* Sets the certificate of this recruitment programmings.
	*
	* @param certificate the certificate of this recruitment programmings
	*/
	public void setCertificate(java.lang.String certificate) {
		_recruitmentProgrammings.setCertificate(certificate);
	}

	/**
	* Returns the created_date of this recruitment programmings.
	*
	* @return the created_date of this recruitment programmings
	*/
	public java.util.Date getCreated_date() {
		return _recruitmentProgrammings.getCreated_date();
	}

	/**
	* Sets the created_date of this recruitment programmings.
	*
	* @param created_date the created_date of this recruitment programmings
	*/
	public void setCreated_date(java.util.Date created_date) {
		_recruitmentProgrammings.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this recruitment programmings.
	*
	* @return the modified_date of this recruitment programmings
	*/
	public java.util.Date getModified_date() {
		return _recruitmentProgrammings.getModified_date();
	}

	/**
	* Sets the modified_date of this recruitment programmings.
	*
	* @param modified_date the modified_date of this recruitment programmings
	*/
	public void setModified_date(java.util.Date modified_date) {
		_recruitmentProgrammings.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this recruitment programmings.
	*
	* @return the deleted of this recruitment programmings
	*/
	public boolean getDeleted() {
		return _recruitmentProgrammings.getDeleted();
	}

	/**
	* Returns <code>true</code> if this recruitment programmings is deleted.
	*
	* @return <code>true</code> if this recruitment programmings is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _recruitmentProgrammings.isDeleted();
	}

	/**
	* Sets whether this recruitment programmings is deleted.
	*
	* @param deleted the deleted of this recruitment programmings
	*/
	public void setDeleted(boolean deleted) {
		_recruitmentProgrammings.setDeleted(deleted);
	}

	public boolean isNew() {
		return _recruitmentProgrammings.isNew();
	}

	public void setNew(boolean n) {
		_recruitmentProgrammings.setNew(n);
	}

	public boolean isCachedModel() {
		return _recruitmentProgrammings.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_recruitmentProgrammings.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _recruitmentProgrammings.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _recruitmentProgrammings.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_recruitmentProgrammings.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _recruitmentProgrammings.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_recruitmentProgrammings.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecruitmentProgrammingsWrapper((RecruitmentProgrammings)_recruitmentProgrammings.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings) {
		return _recruitmentProgrammings.compareTo(recruitmentProgrammings);
	}

	@Override
	public int hashCode() {
		return _recruitmentProgrammings.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.RecruitmentProgrammings> toCacheModel() {
		return _recruitmentProgrammings.toCacheModel();
	}

	public com.fsoft.bn.model.RecruitmentProgrammings toEscapedModel() {
		return new RecruitmentProgrammingsWrapper(_recruitmentProgrammings.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _recruitmentProgrammings.toString();
	}

	public java.lang.String toXmlString() {
		return _recruitmentProgrammings.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_recruitmentProgrammings.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RecruitmentProgrammings getWrappedRecruitmentProgrammings() {
		return _recruitmentProgrammings;
	}

	public RecruitmentProgrammings getWrappedModel() {
		return _recruitmentProgrammings;
	}

	public void resetOriginalValues() {
		_recruitmentProgrammings.resetOriginalValues();
	}

	private RecruitmentProgrammings _recruitmentProgrammings;
}