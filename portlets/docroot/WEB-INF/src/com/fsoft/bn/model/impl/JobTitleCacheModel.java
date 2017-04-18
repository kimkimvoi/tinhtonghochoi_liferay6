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

import com.fsoft.bn.model.JobTitle;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing JobTitle in entity cache.
 *
 * @author FSOFT
 * @see JobTitle
 * @generated
 */
public class JobTitleCacheModel implements CacheModel<JobTitle>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{job_title_id=");
		sb.append(job_title_id);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", job_id=");
		sb.append(job_id);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public JobTitle toEntityModel() {
		JobTitleImpl jobTitleImpl = new JobTitleImpl();

		if (job_title_id == null) {
			jobTitleImpl.setJob_title_id(StringPool.BLANK);
		}
		else {
			jobTitleImpl.setJob_title_id(job_title_id);
		}

		if (user_id == null) {
			jobTitleImpl.setUser_id(StringPool.BLANK);
		}
		else {
			jobTitleImpl.setUser_id(user_id);
		}

		if (job_id == null) {
			jobTitleImpl.setJob_id(StringPool.BLANK);
		}
		else {
			jobTitleImpl.setJob_id(job_id);
		}

		if (created_date == Long.MIN_VALUE) {
			jobTitleImpl.setCreated_date(null);
		}
		else {
			jobTitleImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			jobTitleImpl.setModified_date(null);
		}
		else {
			jobTitleImpl.setModified_date(new Date(modified_date));
		}

		jobTitleImpl.setDeleted(deleted);

		jobTitleImpl.resetOriginalValues();

		return jobTitleImpl;
	}

	public String job_title_id;
	public String user_id;
	public String job_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}