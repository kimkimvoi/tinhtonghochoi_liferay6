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

import com.fsoft.bn.model.Schedule;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see SchedulePersistenceImpl
 * @see ScheduleUtil
 * @generated
 */
public interface SchedulePersistence extends BasePersistence<Schedule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScheduleUtil} to access the schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the schedule in the entity cache if it is enabled.
	*
	* @param schedule the schedule
	*/
	public void cacheResult(com.fsoft.bn.model.Schedule schedule);

	/**
	* Caches the schedules in the entity cache if it is enabled.
	*
	* @param schedules the schedules
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.Schedule> schedules);

	/**
	* Creates a new schedule with the primary key. Does not add the schedule to the database.
	*
	* @param schedule_id the primary key for the new schedule
	* @return the new schedule
	*/
	public com.fsoft.bn.model.Schedule create(java.lang.String schedule_id);

	/**
	* Removes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedule_id the primary key of the schedule
	* @return the schedule that was removed
	* @throws com.fsoft.bn.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule remove(java.lang.String schedule_id)
		throws com.fsoft.bn.NoSuchScheduleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.Schedule updateImpl(
		com.fsoft.bn.model.Schedule schedule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the schedule with the primary key or throws a {@link com.fsoft.bn.NoSuchScheduleException} if it could not be found.
	*
	* @param schedule_id the primary key of the schedule
	* @return the schedule
	* @throws com.fsoft.bn.NoSuchScheduleException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule findByPrimaryKey(
		java.lang.String schedule_id)
		throws com.fsoft.bn.NoSuchScheduleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the schedule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schedule_id the primary key of the schedule
	* @return the schedule, or <code>null</code> if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule fetchByPrimaryKey(
		java.lang.String schedule_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the schedules.
	*
	* @return the schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Schedule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @return the range of schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Schedule> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of schedules
	* @param end the upper bound of the range of schedules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schedules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Schedule> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the schedules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of schedules.
	*
	* @return the number of schedules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}