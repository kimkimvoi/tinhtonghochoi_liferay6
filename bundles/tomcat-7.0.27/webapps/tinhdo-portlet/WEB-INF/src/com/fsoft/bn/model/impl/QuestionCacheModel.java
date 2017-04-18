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

import com.fsoft.bn.model.Question;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Question in entity cache.
 *
 * @author FSOFT
 * @see Question
 * @generated
 */
public class QuestionCacheModel implements CacheModel<Question>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{question_id=");
		sb.append(question_id);
		sb.append(", question_title=");
		sb.append(question_title);
		sb.append(", question_type_id=");
		sb.append(question_type_id);
		sb.append(", question_content=");
		sb.append(question_content);
		sb.append(", citizen_name=");
		sb.append(citizen_name);
		sb.append(", citizen_mail=");
		sb.append(citizen_mail);
		sb.append(", citizen_phone=");
		sb.append(citizen_phone);
		sb.append(", citizen_address=");
		sb.append(citizen_address);
		sb.append(", question_status_id=");
		sb.append(question_status_id);
		sb.append(", answer_id=");
		sb.append(answer_id);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public Question toEntityModel() {
		QuestionImpl questionImpl = new QuestionImpl();

		if (question_id == null) {
			questionImpl.setQuestion_id(StringPool.BLANK);
		}
		else {
			questionImpl.setQuestion_id(question_id);
		}

		if (question_title == null) {
			questionImpl.setQuestion_title(StringPool.BLANK);
		}
		else {
			questionImpl.setQuestion_title(question_title);
		}

		if (question_type_id == null) {
			questionImpl.setQuestion_type_id(StringPool.BLANK);
		}
		else {
			questionImpl.setQuestion_type_id(question_type_id);
		}

		if (question_content == null) {
			questionImpl.setQuestion_content(StringPool.BLANK);
		}
		else {
			questionImpl.setQuestion_content(question_content);
		}

		if (citizen_name == null) {
			questionImpl.setCitizen_name(StringPool.BLANK);
		}
		else {
			questionImpl.setCitizen_name(citizen_name);
		}

		if (citizen_mail == null) {
			questionImpl.setCitizen_mail(StringPool.BLANK);
		}
		else {
			questionImpl.setCitizen_mail(citizen_mail);
		}

		if (citizen_phone == null) {
			questionImpl.setCitizen_phone(StringPool.BLANK);
		}
		else {
			questionImpl.setCitizen_phone(citizen_phone);
		}

		if (citizen_address == null) {
			questionImpl.setCitizen_address(StringPool.BLANK);
		}
		else {
			questionImpl.setCitizen_address(citizen_address);
		}

		if (question_status_id == null) {
			questionImpl.setQuestion_status_id(StringPool.BLANK);
		}
		else {
			questionImpl.setQuestion_status_id(question_status_id);
		}

		if (answer_id == null) {
			questionImpl.setAnswer_id(StringPool.BLANK);
		}
		else {
			questionImpl.setAnswer_id(answer_id);
		}

		if (created_date == Long.MIN_VALUE) {
			questionImpl.setCreated_date(null);
		}
		else {
			questionImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			questionImpl.setModified_date(null);
		}
		else {
			questionImpl.setModified_date(new Date(modified_date));
		}

		questionImpl.setDeleted(deleted);

		questionImpl.resetOriginalValues();

		return questionImpl;
	}

	public String question_id;
	public String question_title;
	public String question_type_id;
	public String question_content;
	public String citizen_name;
	public String citizen_mail;
	public String citizen_phone;
	public String citizen_address;
	public String question_status_id;
	public String answer_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}