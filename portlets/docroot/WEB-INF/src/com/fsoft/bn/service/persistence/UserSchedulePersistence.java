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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see UserSchedulePersistenceImpl
 * @see UserScheduleUtil
 * @generated
 */
public interface UserSchedulePersistence extends BasePersistence<UserSchedule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserScheduleUtil} to access the user schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user schedule in the entity cache if it is enabled.
	*
	* @param userSchedule the user schedule
	*/
	public void cacheResult(com.fsoft.bn.model.UserSchedule userSchedule);

	/**
	* Caches the user schedules in the entity cache if it is enabled.
	*
	* @param userSchedules the user schedules
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.UserSchedule> userSchedules);

	/**
	* Creates a new user schedule with the primary key. Does not add the user schedule to the database.
	*
	* @param user_schedule_id the primary key for the new user schedule
	* @return the new user schedule
	*/
	public com.fsoft.bn.model.UserSchedule create(
		java.lang.String user_schedule_id);

	/**
	* Removes the user schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule that was removed
	* @throws com.fsoft.bn.NoSuchUserScheduleException if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule remove(
		java.lang.String user_schedule_id)
		throws com.fsoft.bn.NoSuchUserScheduleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.UserSchedule updateImpl(
		com.fsoft.bn.model.UserSchedule userSchedule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user schedule with the primary key or throws a {@link com.fsoft.bn.NoSuchUserScheduleException} if it could not be found.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule
	* @throws com.fsoft.bn.NoSuchUserScheduleException if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule findByPrimaryKey(
		java.lang.String user_schedule_id)
		throws com.fsoft.bn.NoSuchUserScheduleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user schedule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule, or <code>null</code> if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule fetchByPrimaryKey(
		java.lang.String user_schedule_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user schedules.
	*
	* @return the user schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.UserSchedule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.UserSchedule> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.UserSchedule> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user schedules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user schedules.
	*
	* @return the number of user schedules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}