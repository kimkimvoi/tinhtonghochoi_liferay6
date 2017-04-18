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

import com.fsoft.bn.model.EnrolmentAttachedFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing EnrolmentAttachedFile in entity cache.
 *
 * @author FSOFT
 * @see EnrolmentAttachedFile
 * @generated
 */
public class EnrolmentAttachedFileCacheModel implements CacheModel<EnrolmentAttachedFile>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{enrolment_attached_id=");
		sb.append(enrolment_attached_id);
		sb.append(", enrolment_id=");
		sb.append(enrolment_id);
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

	public EnrolmentAttachedFile toEntityModel() {
		EnrolmentAttachedFileImpl enrolmentAttachedFileImpl = new EnrolmentAttachedFileImpl();

		if (enrolment_attached_id == null) {
			enrolmentAttachedFileImpl.setEnrolment_attached_id(StringPool.BLANK);
		}
		else {
			enrolmentAttachedFileImpl.setEnrolment_attached_id(enrolment_attached_id);
		}

		if (enrolment_id == null) {
			enrolmentAttachedFileImpl.setEnrolment_id(StringPool.BLANK);
		}
		else {
			enrolmentAttachedFileImpl.setEnrolment_id(enrolment_id);
		}

		if (attached_file_id == null) {
			enrolmentAttachedFileImpl.setAttached_file_id(StringPool.BLANK);
		}
		else {
			enrolmentAttachedFileImpl.setAttached_file_id(attached_file_id);
		}

		if (created_date == Long.MIN_VALUE) {
			enrolmentAttachedFileImpl.setCreated_date(null);
		}
		else {
			enrolmentAttachedFileImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			enrolmentAttachedFileImpl.setModified_date(null);
		}
		else {
			enrolmentAttachedFileImpl.setModified_date(new Date(modified_date));
		}

		enrolmentAttachedFileImpl.setDeleted(deleted);

		enrolmentAttachedFileImpl.resetOriginalValues();

		return enrolmentAttachedFileImpl;
	}

	public String enrolment_attached_id;
	public String enrolment_id;
	public String attached_file_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}