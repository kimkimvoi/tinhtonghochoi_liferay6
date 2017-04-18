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

import com.fsoft.bn.model.AnswerAttachedFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AnswerAttachedFile in entity cache.
 *
 * @author FSOFT
 * @see AnswerAttachedFile
 * @generated
 */
public class AnswerAttachedFileCacheModel implements CacheModel<AnswerAttachedFile>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{answer_attached_id=");
		sb.append(answer_attached_id);
		sb.append(", answer_id=");
		sb.append(answer_id);
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

	public AnswerAttachedFile toEntityModel() {
		AnswerAttachedFileImpl answerAttachedFileImpl = new AnswerAttachedFileImpl();

		if (answer_attached_id == null) {
			answerAttachedFileImpl.setAnswer_attached_id(StringPool.BLANK);
		}
		else {
			answerAttachedFileImpl.setAnswer_attached_id(answer_attached_id);
		}

		if (answer_id == null) {
			answerAttachedFileImpl.setAnswer_id(StringPool.BLANK);
		}
		else {
			answerAttachedFileImpl.setAnswer_id(answer_id);
		}

		if (attached_file_id == null) {
			answerAttachedFileImpl.setAttached_file_id(StringPool.BLANK);
		}
		else {
			answerAttachedFileImpl.setAttached_file_id(attached_file_id);
		}

		if (created_date == Long.MIN_VALUE) {
			answerAttachedFileImpl.setCreated_date(null);
		}
		else {
			answerAttachedFileImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			answerAttachedFileImpl.setModified_date(null);
		}
		else {
			answerAttachedFileImpl.setModified_date(new Date(modified_date));
		}

		answerAttachedFileImpl.setDeleted(deleted);

		answerAttachedFileImpl.resetOriginalValues();

		return answerAttachedFileImpl;
	}

	public String answer_attached_id;
	public String answer_id;
	public String attached_file_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}