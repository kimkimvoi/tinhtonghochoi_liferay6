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

import com.fsoft.bn.model.PrimarySchoolAttachedFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PrimarySchoolAttachedFile in entity cache.
 *
 * @author FSOFT
 * @see PrimarySchoolAttachedFile
 * @generated
 */
public class PrimarySchoolAttachedFileCacheModel implements CacheModel<PrimarySchoolAttachedFile>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{primarySchool_attached_id=");
		sb.append(primarySchool_attached_id);
		sb.append(", primaryStudent_id=");
		sb.append(primaryStudent_id);
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

	public PrimarySchoolAttachedFile toEntityModel() {
		PrimarySchoolAttachedFileImpl primarySchoolAttachedFileImpl = new PrimarySchoolAttachedFileImpl();

		if (primarySchool_attached_id == null) {
			primarySchoolAttachedFileImpl.setPrimarySchool_attached_id(StringPool.BLANK);
		}
		else {
			primarySchoolAttachedFileImpl.setPrimarySchool_attached_id(primarySchool_attached_id);
		}

		if (primaryStudent_id == null) {
			primarySchoolAttachedFileImpl.setPrimaryStudent_id(StringPool.BLANK);
		}
		else {
			primarySchoolAttachedFileImpl.setPrimaryStudent_id(primaryStudent_id);
		}

		if (attached_file_id == null) {
			primarySchoolAttachedFileImpl.setAttached_file_id(StringPool.BLANK);
		}
		else {
			primarySchoolAttachedFileImpl.setAttached_file_id(attached_file_id);
		}

		if (created_date == Long.MIN_VALUE) {
			primarySchoolAttachedFileImpl.setCreated_date(null);
		}
		else {
			primarySchoolAttachedFileImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			primarySchoolAttachedFileImpl.setModified_date(null);
		}
		else {
			primarySchoolAttachedFileImpl.setModified_date(new Date(
					modified_date));
		}

		primarySchoolAttachedFileImpl.setDeleted(deleted);

		primarySchoolAttachedFileImpl.resetOriginalValues();

		return primarySchoolAttachedFileImpl;
	}

	public String primarySchool_attached_id;
	public String primaryStudent_id;
	public String attached_file_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}