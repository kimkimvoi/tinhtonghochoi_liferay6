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

import com.fsoft.bn.model.Schedule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Schedule in entity cache.
 *
 * @author FSOFT
 * @see Schedule
 * @generated
 */
public class ScheduleCacheModel implements CacheModel<Schedule>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{schedule_id=");
		sb.append(schedule_id);
		sb.append(", schedule_date=");
		sb.append(schedule_date);
		sb.append(", content=");
		sb.append(content);
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

	public Schedule toEntityModel() {
		ScheduleImpl scheduleImpl = new ScheduleImpl();

		if (schedule_id == null) {
			scheduleImpl.setSchedule_id(StringPool.BLANK);
		}
		else {
			scheduleImpl.setSchedule_id(schedule_id);
		}

		if (schedule_date == Long.MIN_VALUE) {
			scheduleImpl.setSchedule_date(null);
		}
		else {
			scheduleImpl.setSchedule_date(new Date(schedule_date));
		}

		if (content == null) {
			scheduleImpl.setContent(StringPool.BLANK);
		}
		else {
			scheduleImpl.setContent(content);
		}

		if (user_id == null) {
			scheduleImpl.setUser_id(StringPool.BLANK);
		}
		else {
			scheduleImpl.setUser_id(user_id);
		}

		if (created_date == Long.MIN_VALUE) {
			scheduleImpl.setCreated_date(null);
		}
		else {
			scheduleImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			scheduleImpl.setModified_date(null);
		}
		else {
			scheduleImpl.setModified_date(new Date(modified_date));
		}

		scheduleImpl.setDeleted(deleted);

		scheduleImpl.resetOriginalValues();

		return scheduleImpl;
	}

	public String schedule_id;
	public long schedule_date;
	public String content;
	public String user_id;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}