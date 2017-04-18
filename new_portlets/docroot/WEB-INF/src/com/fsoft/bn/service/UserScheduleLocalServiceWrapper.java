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

package com.fsoft.bn.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UserScheduleLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       UserScheduleLocalService
 * @generated
 */
public class UserScheduleLocalServiceWrapper implements UserScheduleLocalService,
	ServiceWrapper<UserScheduleLocalService> {
	public UserScheduleLocalServiceWrapper(
		UserScheduleLocalService userScheduleLocalService) {
		_userScheduleLocalService = userScheduleLocalService;
	}

	/**
	* Adds the user schedule to the database. Also notifies the appropriate model listeners.
	*
	* @param userSchedule the user schedule
	* @return the user schedule that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule addUserSchedule(
		com.fsoft.bn.model.UserSchedule userSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.addUserSchedule(userSchedule);
	}

	/**
	* Creates a new user schedule with the primary key. Does not add the user schedule to the database.
	*
	* @param user_schedule_id the primary key for the new user schedule
	* @return the new user schedule
	*/
	public com.fsoft.bn.model.UserSchedule createUserSchedule(
		java.lang.String user_schedule_id) {
		return _userScheduleLocalService.createUserSchedule(user_schedule_id);
	}

	/**
	* Deletes the user schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule that was removed
	* @throws PortalException if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule deleteUserSchedule(
		java.lang.String user_schedule_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.deleteUserSchedule(user_schedule_id);
	}

	/**
	* Deletes the user schedule from the database. Also notifies the appropriate model listeners.
	*
	* @param userSchedule the user schedule
	* @return the user schedule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule deleteUserSchedule(
		com.fsoft.bn.model.UserSchedule userSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.deleteUserSchedule(userSchedule);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userScheduleLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.UserSchedule fetchUserSchedule(
		java.lang.String user_schedule_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.fetchUserSchedule(user_schedule_id);
	}

	/**
	* Returns the user schedule with the primary key.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule
	* @throws PortalException if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule getUserSchedule(
		java.lang.String user_schedule_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.getUserSchedule(user_schedule_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.fsoft.bn.model.UserSchedule> getUserSchedules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.getUserSchedules(start, end);
	}

	/**
	* Returns the number of user schedules.
	*
	* @return the number of user schedules
	* @throws SystemException if a system exception occurred
	*/
	public int getUserSchedulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.getUserSchedulesCount();
	}

	/**
	* Updates the user schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSchedule the user schedule
	* @return the user schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule updateUserSchedule(
		com.fsoft.bn.model.UserSchedule userSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.updateUserSchedule(userSchedule);
	}

	/**
	* Updates the user schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSchedule the user schedule
	* @param merge whether to merge the user schedule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserSchedule updateUserSchedule(
		com.fsoft.bn.model.UserSchedule userSchedule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userScheduleLocalService.updateUserSchedule(userSchedule, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userScheduleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userScheduleLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userScheduleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Get active users for schedule
	*
	* @return
	* @throws Exception
	*/
	public java.util.List<com.fsoft.bn.model.UserSchedule> getActiveUsers()
		throws java.lang.Exception {
		return _userScheduleLocalService.getActiveUsers();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserScheduleLocalService getWrappedUserScheduleLocalService() {
		return _userScheduleLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserScheduleLocalService(
		UserScheduleLocalService userScheduleLocalService) {
		_userScheduleLocalService = userScheduleLocalService;
	}

	public UserScheduleLocalService getWrappedService() {
		return _userScheduleLocalService;
	}

	public void setWrappedService(
		UserScheduleLocalService userScheduleLocalService) {
		_userScheduleLocalService = userScheduleLocalService;
	}

	private UserScheduleLocalService _userScheduleLocalService;
}