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

package com.fsoft.bn.model.impl;

import com.fsoft.bn.model.RecruitmentTrainingCourses;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing RecruitmentTrainingCourses in entity cache.
 *
 * @author FSOFT
 * @see RecruitmentTrainingCourses
 * @generated
 */
public class RecruitmentTrainingCoursesCacheModel implements CacheModel<RecruitmentTrainingCourses>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{recruitment_training_courses_id=");
		sb.append(recruitment_training_courses_id);
		sb.append(", recruitment_id=");
		sb.append(recruitment_id);
		sb.append(", conductedBy=");
		sb.append(conductedBy);
		sb.append(", courseName=");
		sb.append(courseName);
		sb.append(", courseDesc=");
		sb.append(courseDesc);
		sb.append(", courseDate=");
		sb.append(courseDate);
		sb.append(", certificate=");
		sb.append(certificate);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public RecruitmentTrainingCourses toEntityModel() {
		RecruitmentTrainingCoursesImpl recruitmentTrainingCoursesImpl = new RecruitmentTrainingCoursesImpl();

		if (recruitment_training_courses_id == null) {
			recruitmentTrainingCoursesImpl.setRecruitment_training_courses_id(StringPool.BLANK);
		}
		else {
			recruitmentTrainingCoursesImpl.setRecruitment_training_courses_id(recruitment_training_courses_id);
		}

		if (recruitment_id == null) {
			recruitmentTrainingCoursesImpl.setRecruitment_id(StringPool.BLANK);
		}
		else {
			recruitmentTrainingCoursesImpl.setRecruitment_id(recruitment_id);
		}

		if (conductedBy == null) {
			recruitmentTrainingCoursesImpl.setConductedBy(StringPool.BLANK);
		}
		else {
			recruitmentTrainingCoursesImpl.setConductedBy(conductedBy);
		}

		if (courseName == null) {
			recruitmentTrainingCoursesImpl.setCourseName(StringPool.BLANK);
		}
		else {
			recruitmentTrainingCoursesImpl.setCourseName(courseName);
		}

		if (courseDesc == null) {
			recruitmentTrainingCoursesImpl.setCourseDesc(StringPool.BLANK);
		}
		else {
			recruitmentTrainingCoursesImpl.setCourseDesc(courseDesc);
		}

		if (courseDate == null) {
			recruitmentTrainingCoursesImpl.setCourseDate(StringPool.BLANK);
		}
		else {
			recruitmentTrainingCoursesImpl.setCourseDate(courseDate);
		}

		if (certificate == null) {
			recruitmentTrainingCoursesImpl.setCertificate(StringPool.BLANK);
		}
		else {
			recruitmentTrainingCoursesImpl.setCertificate(certificate);
		}

		if (created_date == Long.MIN_VALUE) {
			recruitmentTrainingCoursesImpl.setCreated_date(null);
		}
		else {
			recruitmentTrainingCoursesImpl.setCreated_date(new Date(
					created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			recruitmentTrainingCoursesImpl.setModified_date(null);
		}
		else {
			recruitmentTrainingCoursesImpl.setModified_date(new Date(
					modified_date));
		}

		recruitmentTrainingCoursesImpl.setDeleted(deleted);

		recruitmentTrainingCoursesImpl.resetOriginalValues();

		return recruitmentTrainingCoursesImpl;
	}

	public String recruitment_training_courses_id;
	public String recruitment_id;
	public String conductedBy;
	public String courseName;
	public String courseDesc;
	public String courseDate;
	public String certificate;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}