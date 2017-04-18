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
 * This class is a wrapper for {@link ScheduleLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       ScheduleLocalService
 * @generated
 */
public class ScheduleLocalServiceWrapper implements ScheduleLocalService,
	ServiceWrapper<ScheduleLocalService> {
	public ScheduleLocalServiceWrapper(
		ScheduleLocalService scheduleLocalService) {
		_scheduleLocalService = scheduleLocalService;
	}

	/**
	* Adds the schedule to the database. Also notifies the appropriate model listeners.
	*
	* @param schedule the schedule
	* @return the schedule that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule addSchedule(
		com.fsoft.bn.model.Schedule schedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.addSchedule(schedule);
	}

	/**
	* Creates a new schedule with the primary key. Does not add the schedule to the database.
	*
	* @param schedule_id the primary key for the new schedule
	* @return the new schedule
	*/
	public com.fsoft.bn.model.Schedule createSchedule(
		java.lang.String schedule_id) {
		return _scheduleLocalService.createSchedule(schedule_id);
	}

	/**
	* Deletes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schedule_id the primary key of the schedule
	* @return the schedule that was removed
	* @throws PortalException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule deleteSchedule(
		java.lang.String schedule_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.deleteSchedule(schedule_id);
	}

	/**
	* Deletes the schedule from the database. Also notifies the appropriate model listeners.
	*
	* @param schedule the schedule
	* @return the schedule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule deleteSchedule(
		com.fsoft.bn.model.Schedule schedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.deleteSchedule(schedule);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scheduleLocalService.dynamicQuery();
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
		return _scheduleLocalService.dynamicQuery(dynamicQuery);
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
		return _scheduleLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _scheduleLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _scheduleLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.Schedule fetchSchedule(
		java.lang.String schedule_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.fetchSchedule(schedule_id);
	}

	/**
	* Returns the schedule with the primary key.
	*
	* @param schedule_id the primary key of the schedule
	* @return the schedule
	* @throws PortalException if a schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule getSchedule(java.lang.String schedule_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getSchedule(schedule_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.fsoft.bn.model.Schedule> getSchedules(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getSchedules(start, end);
	}

	/**
	* Returns the number of schedules.
	*
	* @return the number of schedules
	* @throws SystemException if a system exception occurred
	*/
	public int getSchedulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.getSchedulesCount();
	}

	/**
	* Updates the schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param schedule the schedule
	* @return the schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule updateSchedule(
		com.fsoft.bn.model.Schedule schedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.updateSchedule(schedule);
	}

	/**
	* Updates the schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param schedule the schedule
	* @param merge whether to merge the schedule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Schedule updateSchedule(
		com.fsoft.bn.model.Schedule schedule, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scheduleLocalService.updateSchedule(schedule, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _scheduleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scheduleLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scheduleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Get schedules
	*
	* @author KienNN
	*/
	public java.util.List<com.fsoft.bn.domain.ScheduleModel> getScheduleBy(
		int month, int year, java.util.Locale locale)
		throws java.lang.Exception {
		return _scheduleLocalService.getScheduleBy(month, year, locale);
	}

	/**
	* Get month schedules by user
	*
	* @author KienNN
	*/
	public java.util.List<com.fsoft.bn.domain.ScheduleModel> getScheduleBy(
		java.lang.String userId, int month, int year, java.util.Locale locale)
		throws java.lang.Exception {
		return _scheduleLocalService.getScheduleBy(userId, month, year, locale);
	}

	/**
	* Get Schedules by weekOfYear
	* Support Schedulel portlet: View by Current Week
	*
	* @author KienNN
	*/
	public java.util.List<com.fsoft.bn.domain.ScheduleModel> getWeekScheduleBy(
		int weekOfYear, int month, int year, java.util.Locale locale)
		throws java.lang.Exception {
		return _scheduleLocalService.getWeekScheduleBy(weekOfYear, month, year,
			locale);
	}

	/**
	* get list schedule by userId and date
	*
	* @param userId
	* @param date
	* @return
	* @throws SystemException
	*/
	public void deleteSchedule(java.lang.String userId, java.util.Date date)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scheduleLocalService.deleteSchedule(userId, date);
	}

	public int getCurrentMonth() {
		return _scheduleLocalService.getCurrentMonth();
	}

	public int getCurrentYear() {
		return _scheduleLocalService.getCurrentYear();
	}

	/**
	* get 12 months value
	*
	* @return
	*/
	public java.util.List<com.fsoft.bn.domain.DataDictionary> getMounths() {
		return _scheduleLocalService.getMounths();
	}

	/**
	* get last 10 years
	*
	* @return
	*/
	public java.util.List<com.fsoft.bn.domain.DataDictionary> getYears() {
		return _scheduleLocalService.getYears();
	}

	/**
	* Get active users for schedule - admin
	*
	* @return
	* @throws Exception
	*/
	public java.util.List<com.fsoft.bn.domain.UserScheduleModel> getUserSchedules()
		throws java.lang.Exception {
		return _scheduleLocalService.getUserSchedules();
	}

	/**
	* Get active users for schedule from @start to @end
	*
	* @author Kien
	* @return List<UserScheduleModel>
	* @throws Exception
	*/
	public java.util.List<com.fsoft.bn.domain.UserScheduleModel> getUserSchedules(
		int start, int end, java.lang.String keyword)
		throws java.lang.Exception {
		return _scheduleLocalService.getUserSchedules(start, end, keyword);
	}

	/**
	* Count total users for schedule
	*
	* @author Kien
	* @return int
	* @throws Exception
	*/
	public int countUserSchedules(java.lang.String keyword)
		throws java.lang.Exception {
		return _scheduleLocalService.countUserSchedules(keyword);
	}

	/**
	* Update user schedule
	*
	* @param userIDs
	* @throws Exception
	*/
	public void allowDisplaySchedule(java.lang.String[] userIDs)
		throws java.lang.Exception {
		_scheduleLocalService.allowDisplaySchedule(userIDs);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ScheduleLocalService getWrappedScheduleLocalService() {
		return _scheduleLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedScheduleLocalService(
		ScheduleLocalService scheduleLocalService) {
		_scheduleLocalService = scheduleLocalService;
	}

	public ScheduleLocalService getWrappedService() {
		return _scheduleLocalService;
	}

	public void setWrappedService(ScheduleLocalService scheduleLocalService) {
		_scheduleLocalService = scheduleLocalService;
	}

	private ScheduleLocalService _scheduleLocalService;
}