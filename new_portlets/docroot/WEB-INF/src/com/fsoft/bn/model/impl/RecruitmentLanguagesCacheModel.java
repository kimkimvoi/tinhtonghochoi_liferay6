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

import com.fsoft.bn.model.RecruitmentLanguages;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing RecruitmentLanguages in entity cache.
 *
 * @author FSOFT
 * @see RecruitmentLanguages
 * @generated
 */
public class RecruitmentLanguagesCacheModel implements CacheModel<RecruitmentLanguages>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{recruitment_languages_id=");
		sb.append(recruitment_languages_id);
		sb.append(", recruitment_id=");
		sb.append(recruitment_id);
		sb.append(", language=");
		sb.append(language);
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

	public RecruitmentLanguages toEntityModel() {
		RecruitmentLanguagesImpl recruitmentLanguagesImpl = new RecruitmentLanguagesImpl();

		if (recruitment_languages_id == null) {
			recruitmentLanguagesImpl.setRecruitment_languages_id(StringPool.BLANK);
		}
		else {
			recruitmentLanguagesImpl.setRecruitment_languages_id(recruitment_languages_id);
		}

		if (recruitment_id == null) {
			recruitmentLanguagesImpl.setRecruitment_id(StringPool.BLANK);
		}
		else {
			recruitmentLanguagesImpl.setRecruitment_id(recruitment_id);
		}

		if (language == null) {
			recruitmentLanguagesImpl.setLanguage(StringPool.BLANK);
		}
		else {
			recruitmentLanguagesImpl.setLanguage(language);
		}

		if (level == null) {
			recruitmentLanguagesImpl.setLevel(StringPool.BLANK);
		}
		else {
			recruitmentLanguagesImpl.setLevel(level);
		}

		if (certificate == null) {
			recruitmentLanguagesImpl.setCertificate(StringPool.BLANK);
		}
		else {
			recruitmentLanguagesImpl.setCertificate(certificate);
		}

		if (created_date == Long.MIN_VALUE) {
			recruitmentLanguagesImpl.setCreated_date(null);
		}
		else {
			recruitmentLanguagesImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			recruitmentLanguagesImpl.setModified_date(null);
		}
		else {
			recruitmentLanguagesImpl.setModified_date(new Date(modified_date));
		}

		recruitmentLanguagesImpl.setDeleted(deleted);

		recruitmentLanguagesImpl.resetOriginalValues();

		return recruitmentLanguagesImpl;
	}

	public String recruitment_languages_id;
	public String recruitment_id;
	public String language;
	public String level;
	public String certificate;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}