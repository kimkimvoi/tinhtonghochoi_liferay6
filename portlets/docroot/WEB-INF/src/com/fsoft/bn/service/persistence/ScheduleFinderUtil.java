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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author FSOFT
 */
public class ScheduleFinderUtil {
	public static java.util.List<com.liferay.portal.model.User> findUserByUserId(
		java.lang.String jobTitle) throws java.lang.Exception {
		return getFinder().findUserByUserId(jobTitle);
	}

	public static java.util.List<com.fsoft.bn.domain.UserScheduleModel> findActiveUserSchedule() {
		return getFinder().findActiveUserSchedule();
	}

	public static java.util.List<com.fsoft.bn.domain.UserScheduleModel> findActiveUserSchedule(
		long userId) {
		return getFinder().findActiveUserSchedule(userId);
	}

	public static java.util.List<com.fsoft.bn.model.Schedule> findSchedule(
		java.lang.String userId, java.util.Date date) {
		return getFinder().findSchedule(userId, date);
	}

	public static ScheduleFinder getFinder() {
		if (_finder == null) {
			_finder = (ScheduleFinder)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					ScheduleFinder.class.getName());

			ReferenceRegistry.registerReference(ScheduleFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ScheduleFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ScheduleFinderUtil.class, "_finder");
	}

	private static ScheduleFinder _finder;
}