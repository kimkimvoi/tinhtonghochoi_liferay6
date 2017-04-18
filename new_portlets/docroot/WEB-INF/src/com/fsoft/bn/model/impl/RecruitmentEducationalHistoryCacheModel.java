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

import com.fsoft.bn.model.RecruitmentEducationalHistory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing RecruitmentEducationalHistory in entity cache.
 *
 * @author FSOFT
 * @see RecruitmentEducationalHistory
 * @generated
 */
public class RecruitmentEducationalHistoryCacheModel implements CacheModel<RecruitmentEducationalHistory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{recruitment_educational_history_id=");
		sb.append(recruitment_educational_history_id);
		sb.append(", recruitment_id=");
		sb.append(recruitment_id);
		sb.append(", school=");
		sb.append(school);
		sb.append(", typeOfTraining=");
		sb.append(typeOfTraining);
		sb.append(", speciality=");
		sb.append(speciality);
		sb.append(", typeOfDegree=");
		sb.append(typeOfDegree);
		sb.append(", graduatedYear=");
		sb.append(graduatedYear);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public RecruitmentEducationalHistory toEntityModel() {
		RecruitmentEducationalHistoryImpl recruitmentEducationalHistoryImpl = new RecruitmentEducationalHistoryImpl();

		if (recruitment_educational_history_id == null) {
			recruitmentEducationalHistoryImpl.setRecruitment_educational_history_id(StringPool.BLANK);
		}
		else {
			recruitmentEducationalHistoryImpl.setRecruitment_educational_history_id(recruitment_educational_history_id);
		}

		if (recruitment_id == null) {
			recruitmentEducationalHistoryImpl.setRecruitment_id(StringPool.BLANK);
		}
		else {
			recruitmentEducationalHistoryImpl.setRecruitment_id(recruitment_id);
		}

		if (school == null) {
			recruitmentEducationalHistoryImpl.setSchool(StringPool.BLANK);
		}
		else {
			recruitmentEducationalHistoryImpl.setSchool(school);
		}

		if (typeOfTraining == null) {
			recruitmentEducationalHistoryImpl.setTypeOfTraining(StringPool.BLANK);
		}
		else {
			recruitmentEducationalHistoryImpl.setTypeOfTraining(typeOfTraining);
		}

		if (speciality == null) {
			recruitmentEducationalHistoryImpl.setSpeciality(StringPool.BLANK);
		}
		else {
			recruitmentEducationalHistoryImpl.setSpeciality(speciality);
		}

		if (typeOfDegree == null) {
			recruitmentEducationalHistoryImpl.setTypeOfDegree(StringPool.BLANK);
		}
		else {
			recruitmentEducationalHistoryImpl.setTypeOfDegree(typeOfDegree);
		}

		if (graduatedYear == null) {
			recruitmentEducationalHistoryImpl.setGraduatedYear(StringPool.BLANK);
		}
		else {
			recruitmentEducationalHistoryImpl.setGraduatedYear(graduatedYear);
		}

		if (created_date == Long.MIN_VALUE) {
			recruitmentEducationalHistoryImpl.setCreated_date(null);
		}
		else {
			recruitmentEducationalHistoryImpl.setCreated_date(new Date(
					created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			recruitmentEducationalHistoryImpl.setModified_date(null);
		}
		else {
			recruitmentEducationalHistoryImpl.setModified_date(new Date(
					modified_date));
		}

		recruitmentEducationalHistoryImpl.setDeleted(deleted);

		recruitmentEducationalHistoryImpl.resetOriginalValues();

		return recruitmentEducationalHistoryImpl;
	}

	public String recruitment_educational_history_id;
	public String recruitment_id;
	public String school;
	public String typeOfTraining;
	public String speciality;
	public String typeOfDegree;
	public String graduatedYear;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}