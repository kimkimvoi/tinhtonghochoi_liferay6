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

import com.fsoft.bn.model.RecruitmentAttachedFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing RecruitmentAttachedFile in entity cache.
 *
 * @author FSOFT
 * @see RecruitmentAttachedFile
 * @generated
 */
public class RecruitmentAttachedFileCacheModel implements CacheModel<RecruitmentAttachedFile>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{recruitment_attached_id=");
		sb.append(recruitment_attached_id);
		sb.append(", recruitment_id=");
		sb.append(recruitment_id);
		sb.append(", attached_file_id=");
		sb.append(attached_file_id);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public RecruitmentAttachedFile toEntityModel() {
		RecruitmentAttachedFileImpl recruitmentAttachedFileImpl = new RecruitmentAttachedFileImpl();

		if (recruitment_attached_id == null) {
			recruitmentAttachedFileImpl.setRecruitment_attached_id(StringPool.BLANK);
		}
		else {
			recruitmentAttachedFileImpl.setRecruitment_attached_id(recruitment_attached_id);
		}

		if (recruitment_id == null) {
			recruitmentAttachedFileImpl.setRecruitment_id(StringPool.BLANK);
		}
		else {
			recruitmentAttachedFileImpl.setRecruitment_id(recruitment_id);
		}

		if (attached_file_id == null) {
			recruitmentAttachedFileImpl.setAttached_file_id(StringPool.BLANK);
		}
		else {
			recruitmentAttachedFileImpl.setAttached_file_id(attached_file_id);
		}

		if (created_date == Long.MIN_VALUE) {
			recruitmentAttachedFileImpl.setCreated_date(null);
		}
		else {
			recruitmentAttachedFileImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			recruitmentAttachedFileImpl.setModified_date(null);
		}
		else {
			recruitmentAttachedFileImpl.setModified_date(new Date(modified_date));
		}

		recruitmentAttachedFileImpl.setDeleted(deleted);

		recruitmentAttachedFileImpl.resetOriginalValues();

		return recruitmentAttachedFileImpl;
	}

	public String recruitment_attached_id;
	public String recruitment_id;
	public String attached_file_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}