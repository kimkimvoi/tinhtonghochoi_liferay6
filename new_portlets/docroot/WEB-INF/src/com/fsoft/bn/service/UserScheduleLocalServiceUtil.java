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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the user schedule local service. This utility wraps {@link com.fsoft.bn.service.impl.UserScheduleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see UserScheduleLocalService
 * @see com.fsoft.bn.service.base.UserScheduleLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.UserScheduleLocalServiceImpl
 * @generated
 */
public class UserScheduleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.UserScheduleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user schedule to the database. Also notifies the appropriate model listeners.
	*
	* @param userSchedule the user schedule
	* @return the user schedule that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule addUserSchedule(
		com.fsoft.bn.model.UserSchedule userSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserSchedule(userSchedule);
	}

	/**
	* Creates a new user schedule with the primary key. Does not add the user schedule to the database.
	*
	* @param user_schedule_id the primary key for the new user schedule
	* @return the new user schedule
	*/
	public static com.fsoft.bn.model.UserSchedule createUserSchedule(
		java.lang.String user_schedule_id) {
		return getService().createUserSchedule(user_schedule_id);
	}

	/**
	* Deletes the user schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule that was removed
	* @throws PortalException if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule deleteUserSchedule(
		java.lang.String user_schedule_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserSchedule(user_schedule_id);
	}

	/**
	* Deletes the user schedule from the database. Also notifies the appropriate model listeners.
	*
	* @param userSchedule the user schedule
	* @return the user schedule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule deleteUserSchedule(
		com.fsoft.bn.model.UserSchedule userSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserSchedule(userSchedule);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.fsoft.bn.model.UserSchedule fetchUserSchedule(
		java.lang.String user_schedule_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserSchedule(user_schedule_id);
	}

	/**
	* Returns the user schedule with the primary key.
	*
	* @param user_schedule_id the primary key of the user schedule
	* @return the user schedule
	* @throws PortalException if a user schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule getUserSchedule(
		java.lang.String user_schedule_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSchedule(user_schedule_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.fsoft.bn.model.UserSchedule> getUserSchedules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSchedules(start, end);
	}

	/**
	* Returns the number of user schedules.
	*
	* @return the number of user schedules
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserSchedulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserSchedulesCount();
	}

	/**
	* Updates the user schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSchedule the user schedule
	* @return the user schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule updateUserSchedule(
		com.fsoft.bn.model.UserSchedule userSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserSchedule(userSchedule);
	}

	/**
	* Updates the user schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSchedule the user schedule
	* @param merge whether to merge the user schedule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserSchedule updateUserSchedule(
		com.fsoft.bn.model.UserSchedule userSchedule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserSchedule(userSchedule, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Get active users for schedule
	*
	* @return
	* @throws Exception
	*/
	public static java.util.List<com.fsoft.bn.model.UserSchedule> getActiveUsers()
		throws java.lang.Exception {
		return getService().getActiveUsers();
	}

	public static void clearService() {
		_service = null;
	}

	public static UserScheduleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserScheduleLocalService.class.getName());

			if (invokableLocalService instanceof UserScheduleLocalService) {
				_service = (UserScheduleLocalService)invokableLocalService;
			}
			else {
				_service = new UserScheduleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserScheduleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(UserScheduleLocalService service) {
	}

	private static UserScheduleLocalService _service;
}