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
 * This class is a wrapper for {@link RecruitmentTrainingCourses}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentTrainingCourses
 * @generated
 */
public class RecruitmentTrainingCoursesWrapper
	implements RecruitmentTrainingCourses,
		ModelWrapper<RecruitmentTrainingCourses> {
	public RecruitmentTrainingCoursesWrapper(
		RecruitmentTrainingCourses recruitmentTrainingCourses) {
		_recruitmentTrainingCourses = recruitmentTrainingCourses;
	}

	public Class<?> getModelClass() {
		return RecruitmentTrainingCourses.class;
	}

	public String getModelClassName() {
		return RecruitmentTrainingCourses.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_training_courses_id",
			getRecruitment_training_courses_id());
		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("conductedBy", getConductedBy());
		attributes.put("courseName", getCourseName());
		attributes.put("courseDesc", getCourseDesc());
		attributes.put("courseDate", getCourseDate());
		attributes.put("certificate", getCertificate());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_training_courses_id = (String)attributes.get(
				"recruitment_training_courses_id");

		if (recruitment_training_courses_id != null) {
			setRecruitment_training_courses_id(recruitment_training_courses_id);
		}

		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
		}

		String conductedBy = (String)attributes.get("conductedBy");

		if (conductedBy != null) {
			setConductedBy(conductedBy);
		}

		String courseName = (String)attributes.get("courseName");

		if (courseName != null) {
			setCourseName(courseName);
		}

		String courseDesc = (String)attributes.get("courseDesc");

		if (courseDesc != null) {
			setCourseDesc(courseDesc);
		}

		String courseDate = (String)attributes.get("courseDate");

		if (courseDate != null) {
			setCourseDate(courseDate);
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
	* Returns the primary key of this recruitment training courses.
	*
	* @return the primary key of this recruitment training courses
	*/
	public java.lang.String getPrimaryKey() {
		return _recruitmentTrainingCourses.getPrimaryKey();
	}

	/**
	* Sets the primary key of this recruitment training courses.
	*
	* @param primaryKey the primary key of this recruitment training courses
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_recruitmentTrainingCourses.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the recruitment_training_courses_id of this recruitment training courses.
	*
	* @return the recruitment_training_courses_id of this recruitment training courses
	*/
	public java.lang.String getRecruitment_training_courses_id() {
		return _recruitmentTrainingCourses.getRecruitment_training_courses_id();
	}

	/**
	* Sets the recruitment_training_courses_id of this recruitment training courses.
	*
	* @param recruitment_training_courses_id the recruitment_training_courses_id of this recruitment training courses
	*/
	public void setRecruitment_training_courses_id(
		java.lang.String recruitment_training_courses_id) {
		_recruitmentTrainingCourses.setRecruitment_training_courses_id(recruitment_training_courses_id);
	}

	/**
	* Returns the recruitment_id of this recruitment training courses.
	*
	* @return the recruitment_id of this recruitment training courses
	*/
	public java.lang.String getRecruitment_id() {
		return _recruitmentTrainingCourses.getRecruitment_id();
	}

	/**
	* Sets the recruitment_id of this recruitment training courses.
	*
	* @param recruitment_id the recruitment_id of this recruitment training courses
	*/
	public void setRecruitment_id(java.lang.String recruitment_id) {
		_recruitmentTrainingCourses.setRecruitment_id(recruitment_id);
	}

	/**
	* Returns the conducted by of this recruitment training courses.
	*
	* @return the conducted by of this recruitment training courses
	*/
	public java.lang.String getConductedBy() {
		return _recruitmentTrainingCourses.getConductedBy();
	}

	/**
	* Sets the conducted by of this recruitment training courses.
	*
	* @param conductedBy the conducted by of this recruitment training courses
	*/
	public void setConductedBy(java.lang.String conductedBy) {
		_recruitmentTrainingCourses.setConductedBy(conductedBy);
	}

	/**
	* Returns the course name of this recruitment training courses.
	*
	* @return the course name of this recruitment training courses
	*/
	public java.lang.String getCourseName() {
		return _recruitmentTrainingCourses.getCourseName();
	}

	/**
	* Sets the course name of this recruitment training courses.
	*
	* @param courseName the course name of this recruitment training courses
	*/
	public void setCourseName(java.lang.String courseName) {
		_recruitmentTrainingCourses.setCourseName(courseName);
	}

	/**
	* Returns the course desc of this recruitment training courses.
	*
	* @return the course desc of this recruitment training courses
	*/
	public java.lang.String getCourseDesc() {
		return _recruitmentTrainingCourses.getCourseDesc();
	}

	/**
	* Sets the course desc of this recruitment training courses.
	*
	* @param courseDesc the course desc of this recruitment training courses
	*/
	public void setCourseDesc(java.lang.String courseDesc) {
		_recruitmentTrainingCourses.setCourseDesc(courseDesc);
	}

	/**
	* Returns the course date of this recruitment training courses.
	*
	* @return the course date of this recruitment training courses
	*/
	public java.lang.String getCourseDate() {
		return _recruitmentTrainingCourses.getCourseDate();
	}

	/**
	* Sets the course date of this recruitment training courses.
	*
	* @param courseDate the course date of this recruitment training courses
	*/
	public void setCourseDate(java.lang.String courseDate) {
		_recruitmentTrainingCourses.setCourseDate(courseDate);
	}

	/**
	* Returns the certificate of this recruitment training courses.
	*
	* @return the certificate of this recruitment training courses
	*/
	public java.lang.String getCertificate() {
		return _recruitmentTrainingCourses.getCertificate();
	}

	/**
	* Sets the certificate of this recruitment training courses.
	*
	* @param certificate the certificate of this recruitment training courses
	*/
	public void setCertificate(java.lang.String certificate) {
		_recruitmentTrainingCourses.setCertificate(certificate);
	}

	/**
	* Returns the created_date of this recruitment training courses.
	*
	* @return the created_date of this recruitment training courses
	*/
	public java.util.Date getCreated_date() {
		return _recruitmentTrainingCourses.getCreated_date();
	}

	/**
	* Sets the created_date of this recruitment training courses.
	*
	* @param created_date the created_date of this recruitment training courses
	*/
	public void setCreated_date(java.util.Date created_date) {
		_recruitmentTrainingCourses.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this recruitment training courses.
	*
	* @return the modified_date of this recruitment training courses
	*/
	public java.util.Date getModified_date() {
		return _recruitmentTrainingCourses.getModified_date();
	}

	/**
	* Sets the modified_date of this recruitment training courses.
	*
	* @param modified_date the modified_date of this recruitment training courses
	*/
	public void setModified_date(java.util.Date modified_date) {
		_recruitmentTrainingCourses.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this recruitment training courses.
	*
	* @return the deleted of this recruitment training courses
	*/
	public boolean getDeleted() {
		return _recruitmentTrainingCourses.getDeleted();
	}

	/**
	* Returns <code>true</code> if this recruitment training courses is deleted.
	*
	* @return <code>true</code> if this recruitment training courses is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _recruitmentTrainingCourses.isDeleted();
	}

	/**
	* Sets whether this recruitment training courses is deleted.
	*
	* @param deleted the deleted of this recruitment training courses
	*/
	public void setDeleted(boolean deleted) {
		_recruitmentTrainingCourses.setDeleted(deleted);
	}

	public boolean isNew() {
		return _recruitmentTrainingCourses.isNew();
	}

	public void setNew(boolean n) {
		_recruitmentTrainingCourses.setNew(n);
	}

	public boolean isCachedModel() {
		return _recruitmentTrainingCourses.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_recruitmentTrainingCourses.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _recruitmentTrainingCourses.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _recruitmentTrainingCourses.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_recruitmentTrainingCourses.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _recruitmentTrainingCourses.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_recruitmentTrainingCourses.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecruitmentTrainingCoursesWrapper((RecruitmentTrainingCourses)_recruitmentTrainingCourses.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.RecruitmentTrainingCourses recruitmentTrainingCourses) {
		return _recruitmentTrainingCourses.compareTo(recruitmentTrainingCourses);
	}

	@Override
	public int hashCode() {
		return _recruitmentTrainingCourses.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.RecruitmentTrainingCourses> toCacheModel() {
		return _recruitmentTrainingCourses.toCacheModel();
	}

	public com.fsoft.bn.model.RecruitmentTrainingCourses toEscapedModel() {
		return new RecruitmentTrainingCoursesWrapper(_recruitmentTrainingCourses.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _recruitmentTrainingCourses.toString();
	}

	public java.lang.String toXmlString() {
		return _recruitmentTrainingCourses.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_recruitmentTrainingCourses.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RecruitmentTrainingCourses getWrappedRecruitmentTrainingCourses() {
		return _recruitmentTrainingCourses;
	}

	public RecruitmentTrainingCourses getWrappedModel() {
		return _recruitmentTrainingCourses;
	}

	public void resetOriginalValues() {
		_recruitmentTrainingCourses.resetOriginalValues();
	}

	private RecruitmentTrainingCourses _recruitmentTrainingCourses;
}