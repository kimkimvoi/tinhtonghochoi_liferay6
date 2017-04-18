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

import com.fsoft.bn.model.QuestionAttachedFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing QuestionAttachedFile in entity cache.
 *
 * @author FSOFT
 * @see QuestionAttachedFile
 * @generated
 */
public class QuestionAttachedFileCacheModel implements CacheModel<QuestionAttachedFile>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{question_attached_id=");
		sb.append(question_attached_id);
		sb.append(", question_id=");
		sb.append(question_id);
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

	public QuestionAttachedFile toEntityModel() {
		QuestionAttachedFileImpl questionAttachedFileImpl = new QuestionAttachedFileImpl();

		if (question_attached_id == null) {
			questionAttachedFileImpl.setQuestion_attached_id(StringPool.BLANK);
		}
		else {
			questionAttachedFileImpl.setQuestion_attached_id(question_attached_id);
		}

		if (question_id == null) {
			questionAttachedFileImpl.setQuestion_id(StringPool.BLANK);
		}
		else {
			questionAttachedFileImpl.setQuestion_id(question_id);
		}

		if (attached_file_id == null) {
			questionAttachedFileImpl.setAttached_file_id(StringPool.BLANK);
		}
		else {
			questionAttachedFileImpl.setAttached_file_id(attached_file_id);
		}

		if (created_date == Long.MIN_VALUE) {
			questionAttachedFileImpl.setCreated_date(null);
		}
		else {
			questionAttachedFileImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			questionAttachedFileImpl.setModified_date(null);
		}
		else {
			questionAttachedFileImpl.setModified_date(new Date(modified_date));
		}

		questionAttachedFileImpl.setDeleted(deleted);

		questionAttachedFileImpl.resetOriginalValues();

		return questionAttachedFileImpl;
	}

	public String question_attached_id;
	public String question_id;
	public String attached_file_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}