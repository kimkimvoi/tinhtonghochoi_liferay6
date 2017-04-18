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

package com.fsoft.bn.service.persistence;

/**
 * @author FSOFT
 */
public interface ScheduleFinder {
	public java.util.List<com.liferay.portal.model.User> findUserByUserId(
		java.lang.String jobTitle) throws java.lang.Exception;

	public java.util.List<com.fsoft.bn.domain.UserScheduleModel> findActiveUserSchedule();

	public java.util.List<com.fsoft.bn.domain.UserScheduleModel> findActiveUserSchedule(
		long userId);

	public java.util.List<com.fsoft.bn.model.Schedule> findSchedule(
		java.lang.String userId, java.util.Date date);
}