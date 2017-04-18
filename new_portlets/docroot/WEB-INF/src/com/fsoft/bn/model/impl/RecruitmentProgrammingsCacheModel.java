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

import com.fsoft.bn.model.RecruitmentProgrammings;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing RecruitmentProgrammings in entity cache.
 *
 * @author FSOFT
 * @see RecruitmentProgrammings
 * @generated
 */
public class RecruitmentProgrammingsCacheModel implements CacheModel<RecruitmentProgrammings>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{recruitment_programmings_id=");
		sb.append(recruitment_programmings_id);
		sb.append(", recruitment_id=");
		sb.append(recruitment_id);
		sb.append(", course=");
		sb.append(course);
		sb.append(", level=");
		sb.append(level);
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

	public RecruitmentProgrammings toEntityModel() {
		RecruitmentProgrammingsImpl recruitmentProgrammingsImpl = new RecruitmentProgrammingsImpl();

		if (recruitment_programmings_id == null) {
			recruitmentProgrammingsImpl.setRecruitment_programmings_id(StringPool.BLANK);
		}
		else {
			recruitmentProgrammingsImpl.setRecruitment_programmings_id(recruitment_programmings_id);
		}

		if (recruitment_id == null) {
			recruitmentProgrammingsImpl.setRecruitment_id(StringPool.BLANK);
		}
		else {
			recruitmentProgrammingsImpl.setRecruitment_id(recruitment_id);
		}

		if (course == null) {
			recruitmentProgrammingsImpl.setCourse(StringPool.BLANK);
		}
		else {
			recruitmentProgrammingsImpl.setCourse(course);
		}

		if (level == null) {
			recruitmentProgrammingsImpl.setLevel(StringPool.BLANK);
		}
		else {
			recruitmentProgrammingsImpl.setLevel(level);
		}

		if (certificate == null) {
			recruitmentProgrammingsImpl.setCertificate(StringPool.BLANK);
		}
		else {
			recruitmentProgrammingsImpl.setCertificate(certificate);
		}

		if (created_date == Long.MIN_VALUE) {
			recruitmentProgrammingsImpl.setCreated_date(null);
		}
		else {
			recruitmentProgrammingsImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			recruitmentProgrammingsImpl.setModified_date(null);
		}
		else {
			recruitmentProgrammingsImpl.setModified_date(new Date(modified_date));
		}

		recruitmentProgrammingsImpl.setDeleted(deleted);

		recruitmentProgrammingsImpl.resetOriginalValues();

		return recruitmentProgrammingsImpl;
	}

	public String recruitment_programmings_id;
	public String recruitment_id;
	public String course;
	public String level;
	public String certificate;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}