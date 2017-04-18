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

import com.fsoft.bn.model.UserSchedule;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user schedule service. This utility wraps {@link UserSchedulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see UserSchedulePersistence
 * @see UserSchedulePersistenceImpl
 * @generated
 */
public class UserScheduleUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserSchedule userSchedule) {
		getPersistence().clearCache(userSchedule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserSchedule update(UserSchedule userSchedule, boolean merge)
		throws SystemException {
		return getPersistence().update(userSchedule, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserSchedule update(UserSchedule userSchedule, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userSchedule, merge, serviceContext);
	}

	/**
	* Caches the user schedule in the entity cache if it is enabled.
	*
	* @param userSchedule the user schedule
	*/
	public static void cacheResult(com.fsoft.bn.model.UserSchedule userSchedule) {
		getPersistence().cacheResult(userSchedule);
	}

	/**
	* Caches the user schedules in the entity cache if it is enabled.
	*
	* @param userSchedules the user schedules
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.UserSchedule> userSchedules) {
		getPersistence().cacheResult(userSchedules);
	}

	/**
	* Creates a new user schedule with the primary key. Does not add the user schedule to the database.
	*
	* @param user_schedule_id the primary key for the new user schedule
	* @return the new user schedule
	*/
	public static com.fsoft.bn.model.UserSchedule create(
		java.lang.String user_schedule_id) {
		return getPersistence().create(user_schedule_id);
	}

	/**
	* Removes the user schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule that was removed
	* @throws com.fsoft.bn.NoSuchUserScheduleException if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule remove(
		java.lang.String user_schedule_id)
		throws com.fsoft.bn.NoSuchUserScheduleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(user_schedule_id);
	}

	public static com.fsoft.bn.model.UserSchedule updateImpl(
		com.fsoft.bn.model.UserSchedule userSchedule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userSchedule, merge);
	}

	/**
	* Returns the user schedule with the primary key or throws a {@link com.fsoft.bn.NoSuchUserScheduleException} if it could not be found.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule
	* @throws com.fsoft.bn.NoSuchUserScheduleException if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule findByPrimaryKey(
		java.lang.String user_schedule_id)
		throws com.fsoft.bn.NoSuchUserScheduleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(user_schedule_id);
	}

	/**
	* Returns the user schedule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule, or <code>null</code> if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule fetchByPrimaryKey(
		java.lang.String user_schedule_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(user_schedule_id);
	}

	/**
	* Returns all the user schedules.
	*
	* @return the user schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.UserSchedule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user schedules
	* @param end the upper bound of the range of user schedules (not inclusive)
	* @return the range of user schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.UserSchedule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user schedules
	* @param end the upper bound of the range of user schedules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user schedules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.UserSchedule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user schedules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user schedules.
	*
	* @return the number of user schedules
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserSchedulePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserSchedulePersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					UserSchedulePersistence.class.getName());

			ReferenceRegistry.registerReference(UserScheduleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UserSchedulePersistence persistence) {
	}

	private static UserSchedulePersistence _persistence;
}