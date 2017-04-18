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
 * The base model interface for the RecruitmentTrainingCourses service. Represents a row in the &quot;BN_RecruitmentTrainingCourses&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.RecruitmentTrainingCoursesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.RecruitmentTrainingCoursesImpl}.
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentTrainingCourses
 * @see com.fsoft.bn.model.impl.RecruitmentTrainingCoursesImpl
 * @see com.fsoft.bn.model.impl.RecruitmentTrainingCoursesModelImpl
 * @generated
 */
public interface RecruitmentTrainingCoursesModel extends BaseModel<RecruitmentTrainingCourses> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a recruitment training courses model instance should use the {@link RecruitmentTrainingCourses} interface instead.
	 */

	/**
	 * Returns the primary key of this recruitment training courses.
	 *
	 * @return the primary key of this recruitment training courses
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this recruitment training courses.
	 *
	 * @param primaryKey the primary key of this recruitment training courses
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the recruitment_training_courses_id of this recruitment training courses.
	 *
	 * @return the recruitment_training_courses_id of this recruitment training courses
	 */
	@AutoEscape
	public String getRecruitment_training_courses_id();

	/**
	 * Sets the recruitment_training_courses_id of this recruitment training courses.
	 *
	 * @param recruitment_training_courses_id the recruitment_training_courses_id of this recruitment training courses
	 */
	public void setRecruitment_training_courses_id(
		String recruitment_training_courses_id);

	/**
	 * Returns the recruitment_id of this recruitment training courses.
	 *
	 * @return the recruitment_id of this recruitment training courses
	 */
	@AutoEscape
	public String getRecruitment_id();

	/**
	 * Sets the recruitment_id of this recruitment training courses.
	 *
	 * @param recruitment_id the recruitment_id of this recruitment training courses
	 */
	public void setRecruitment_id(String recruitment_id);

	/**
	 * Returns the conducted by of this recruitment training courses.
	 *
	 * @return the conducted by of this recruitment training courses
	 */
	@AutoEscape
	public String getConductedBy();

	/**
	 * Sets the conducted by of this recruitment training courses.
	 *
	 * @param conductedBy the conducted by of this recruitment training courses
	 */
	public void setConductedBy(String conductedBy);

	/**
	 * Returns the course name of this recruitment training courses.
	 *
	 * @return the course name of this recruitment training courses
	 */
	@AutoEscape
	public String getCourseName();

	/**
	 * Sets the course name of this recruitment training courses.
	 *
	 * @param courseName the course name of this recruitment training courses
	 */
	public void setCourseName(String courseName);

	/**
	 * Returns the course desc of this recruitment training courses.
	 *
	 * @return the course desc of this recruitment training courses
	 */
	@AutoEscape
	public String getCourseDesc();

	/**
	 * Sets the course desc of this recruitment training courses.
	 *
	 * @param courseDesc the course desc of this recruitment training courses
	 */
	public void setCourseDesc(String courseDesc);

	/**
	 * Returns the course date of this recruitment training courses.
	 *
	 * @return the course date of this recruitment training courses
	 */
	@AutoEscape
	public String getCourseDate();

	/**
	 * Sets the course date of this recruitment training courses.
	 *
	 * @param courseDate the course date of this recruitment training courses
	 */
	public void setCourseDate(String courseDate);

	/**
	 * Returns the certificate of this recruitment training courses.
	 *
	 * @return the certificate of this recruitment training courses
	 */
	@AutoEscape
	public String getCertificate();

	/**
	 * Sets the certificate of this recruitment training courses.
	 *
	 * @param certificate the certificate of this recruitment training courses
	 */
	public void setCertificate(String certificate);

	/**
	 * Returns the created_date of this recruitment training courses.
	 *
	 * @return the created_date of this recruitment training courses
	 */
	public Date getCreated_date();

	/**
	 * Sets the created_date of this recruitment training courses.
	 *
	 * @param created_date the created_date of this recruitment training courses
	 */
	public void setCreated_date(Date created_date);

	/**
	 * Returns the modified_date of this recruitment training courses.
	 *
	 * @return the modified_date of this recruitment training courses
	 */
	public Date getModified_date();

	/**
	 * Sets the modified_date of this recruitment training courses.
	 *
	 * @param modified_date the modified_date of this recruitment training courses
	 */
	public void setModified_date(Date modified_date);

	/**
	 * Returns the deleted of this recruitment training courses.
	 *
	 * @return the deleted of this recruitment training courses
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this recruitment training courses is deleted.
	 *
	 * @return <code>true</code> if this recruitment training courses is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this recruitment training courses is deleted.
	 *
	 * @param deleted the deleted of this recruitment training courses
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

	public int compareTo(RecruitmentTrainingCourses recruitmentTrainingCourses);

	public int hashCode();

	public CacheModel<RecruitmentTrainingCourses> toCacheModel();

	public RecruitmentTrainingCourses toEscapedModel();

	public String toString();

	public String toXmlString();
}