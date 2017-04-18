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

import com.fsoft.bn.model.PreschoolAttachedFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PreschoolAttachedFile in entity cache.
 *
 * @author FSOFT
 * @see PreschoolAttachedFile
 * @generated
 */
public class PreschoolAttachedFileCacheModel implements CacheModel<PreschoolAttachedFile>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{preschool_attached_id=");
		sb.append(preschool_attached_id);
		sb.append(", student_id=");
		sb.append(student_id);
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

	public PreschoolAttachedFile toEntityModel() {
		PreschoolAttachedFileImpl preschoolAttachedFileImpl = new PreschoolAttachedFileImpl();

		if (preschool_attached_id == null) {
			preschoolAttachedFileImpl.setPreschool_attached_id(StringPool.BLANK);
		}
		else {
			preschoolAttachedFileImpl.setPreschool_attached_id(preschool_attached_id);
		}

		if (student_id == null) {
			preschoolAttachedFileImpl.setStudent_id(StringPool.BLANK);
		}
		else {
			preschoolAttachedFileImpl.setStudent_id(student_id);
		}

		if (attached_file_id == null) {
			preschoolAttachedFileImpl.setAttached_file_id(StringPool.BLANK);
		}
		else {
			preschoolAttachedFileImpl.setAttached_file_id(attached_file_id);
		}

		if (created_date == Long.MIN_VALUE) {
			preschoolAttachedFileImpl.setCreated_date(null);
		}
		else {
			preschoolAttachedFileImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			preschoolAttachedFileImpl.setModified_date(null);
		}
		else {
			preschoolAttachedFileImpl.setModified_date(new Date(modified_date));
		}

		preschoolAttachedFileImpl.setDeleted(deleted);

		preschoolAttachedFileImpl.resetOriginalValues();

		return preschoolAttachedFileImpl;
	}

	public String preschool_attached_id;
	public String student_id;
	public String attached_file_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}