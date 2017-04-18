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

package com.fsoft.bn.service.impl;

import java.util.List;

import com.fsoft.bn.model.UserSchedule;
import com.fsoft.bn.service.base.UserScheduleLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

/**
 * The implementation of the user schedule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsoft.bn.service.UserScheduleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see com.fsoft.bn.service.base.UserScheduleLocalServiceBaseImpl
 * @see com.fsoft.bn.service.UserScheduleLocalServiceUtil
 */
public class UserScheduleLocalServiceImpl
	extends UserScheduleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.fsoft.bn.service.UserScheduleLocalServiceUtil} to access the user schedule local service.
	 */
	/**
	 * Get active users for schedule
	 * @return
	 * @throws Exception
	 */
	public List<UserSchedule> getActiveUsers() throws Exception {
		DynamicQuery dQuery = DynamicQueryFactoryUtil.forClass(UserSchedule.class,"userschedule")
				.add(PropertyFactoryUtil.forName("userschedule.deleted").ne(new Long(1)));
		
		List<UserSchedule> userSchedules = userSchedulePersistence.findWithDynamicQuery(dQuery);
		return userSchedules;
	}
}