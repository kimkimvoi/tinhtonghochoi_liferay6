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

import com.fsoft.bn.model.Answer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Answer in entity cache.
 *
 * @author FSOFT
 * @see Answer
 * @generated
 */
public class AnswerCacheModel implements CacheModel<Answer>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{answer_id=");
		sb.append(answer_id);
		sb.append(", answer_content=");
		sb.append(answer_content);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public Answer toEntityModel() {
		AnswerImpl answerImpl = new AnswerImpl();

		if (answer_id == null) {
			answerImpl.setAnswer_id(StringPool.BLANK);
		}
		else {
			answerImpl.setAnswer_id(answer_id);
		}

		if (answer_content == null) {
			answerImpl.setAnswer_content(StringPool.BLANK);
		}
		else {
			answerImpl.setAnswer_content(answer_content);
		}

		if (user_id == null) {
			answerImpl.setUser_id(StringPool.BLANK);
		}
		else {
			answerImpl.setUser_id(user_id);
		}

		if (created_date == Long.MIN_VALUE) {
			answerImpl.setCreated_date(null);
		}
		else {
			answerImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			answerImpl.setModified_date(null);
		}
		else {
			answerImpl.setModified_date(new Date(modified_date));
		}

		answerImpl.setDeleted(deleted);

		answerImpl.resetOriginalValues();

		return answerImpl;
	}

	public String answer_id;
	public String answer_content;
	public String user_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}