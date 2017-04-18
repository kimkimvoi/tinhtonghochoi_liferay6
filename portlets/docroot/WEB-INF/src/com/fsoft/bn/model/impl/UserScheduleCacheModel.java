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

import com.fsoft.bn.model.UserSchedule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UserSchedule in entity cache.
 *
 * @author FSOFT
 * @see UserSchedule
 * @generated
 */
public class UserScheduleCacheModel implements CacheModel<UserSchedule>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{user_schedule_id=");
		sb.append(user_schedule_id);
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

	public UserSchedule toEntityModel() {
		UserScheduleImpl userScheduleImpl = new UserScheduleImpl();

		if (user_schedule_id == null) {
			userScheduleImpl.setUser_schedule_id(StringPool.BLANK);
		}
		else {
			userScheduleImpl.setUser_schedule_id(user_schedule_id);
		}

		if (user_id == null) {
			userScheduleImpl.setUser_id(StringPool.BLANK);
		}
		else {
			userScheduleImpl.setUser_id(user_id);
		}

		if (created_date == Long.MIN_VALUE) {
			userScheduleImpl.setCreated_date(null);
		}
		else {
			userScheduleImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			userScheduleImpl.setModified_date(null);
		}
		else {
			userScheduleImpl.setModified_date(new Date(modified_date));
		}

		userScheduleImpl.setDeleted(deleted);

		userScheduleImpl.resetOriginalValues();

		return userScheduleImpl;
	}

	public String user_schedule_id;
	public String user_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}