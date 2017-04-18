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
 * The utility for the staff info local service. This utility wraps {@link com.fsoft.bn.service.impl.StaffInfoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see StaffInfoLocalService
 * @see com.fsoft.bn.service.base.StaffInfoLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.StaffInfoLocalServiceImpl
 * @generated
 */
public class StaffInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.StaffInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the staff info to the database. Also notifies the appropriate model listeners.
	*
	* @param staffInfo the staff info
	* @return the staff info that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo addStaffInfo(
		com.fsoft.bn.model.StaffInfo staffInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStaffInfo(staffInfo);
	}

	/**
	* Creates a new staff info with the primary key. Does not add the staff info to the database.
	*
	* @param staff_id the primary key for the new staff info
	* @return the new staff info
	*/
	public static com.fsoft.bn.model.StaffInfo createStaffInfo(long staff_id) {
		return getService().createStaffInfo(staff_id);
	}

	/**
	* Deletes the staff info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param staff_id the primary key of the staff info
	* @return the staff info that was removed
	* @throws PortalException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo deleteStaffInfo(long staff_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStaffInfo(staff_id);
	}

	/**
	* Deletes the staff info from the database. Also notifies the appropriate model listeners.
	*
	* @param staffInfo the staff info
	* @return the staff info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo deleteStaffInfo(
		com.fsoft.bn.model.StaffInfo staffInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStaffInfo(staffInfo);
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

	public static com.fsoft.bn.model.StaffInfo fetchStaffInfo(long staff_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStaffInfo(staff_id);
	}

	/**
	* Returns the staff info with the primary key.
	*
	* @param staff_id the primary key of the staff info
	* @return the staff info
	* @throws PortalException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo getStaffInfo(long staff_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaffInfo(staff_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the staff infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @return the range of staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.StaffInfo> getStaffInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaffInfos(start, end);
	}

	/**
	* Returns the number of staff infos.
	*
	* @return the number of staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static int getStaffInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStaffInfosCount();
	}

	/**
	* Updates the staff info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param staffInfo the staff info
	* @return the staff info that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo updateStaffInfo(
		com.fsoft.bn.model.StaffInfo staffInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStaffInfo(staffInfo);
	}

	/**
	* Updates the staff info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param staffInfo the staff info
	* @param merge whether to merge the staff info with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the staff info that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo updateStaffInfo(
		com.fsoft.bn.model.StaffInfo staffInfo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStaffInfo(staffInfo, merge);
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
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.fsoft.bn.service.StaffInfoLocalServiceUtil} to access the staff info local service.
	*
	* @throws SystemException
	* @throws PortalException
	*/
	public static java.util.List<com.fsoft.bn.model.StaffInfo> updateValueOrganizName(
		java.util.List<com.fsoft.bn.model.StaffInfo> staffInfosList)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateValueOrganizName(staffInfosList);
	}

	public static java.util.List<com.fsoft.bn.model.StaffInfo> getAllStaffInfoByDeleted(
		boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllStaffInfoByDeleted(deleted, start, end);
	}

	public static int getAllStaffInfoByDeletedCount(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllStaffInfoByDeletedCount(deleted);
	}

	public static java.util.List<com.fsoft.bn.model.StaffInfo> searchStaffInfo(
		java.lang.String content, java.lang.String typeSearch,
		long organization, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchStaffInfo(content, typeSearch, organization, begin,
			end);
	}

	public static int countResultSearchStaffInfo(java.lang.String content,
		java.lang.String typeSearch, long organization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countResultSearchStaffInfo(content, typeSearch, organization);
	}

	public static void clearService() {
		_service = null;
	}

	public static StaffInfoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StaffInfoLocalService.class.getName());

			if (invokableLocalService instanceof StaffInfoLocalService) {
				_service = (StaffInfoLocalService)invokableLocalService;
			}
			else {
				_service = new StaffInfoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StaffInfoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(StaffInfoLocalService service) {
	}

	private static StaffInfoLocalService _service;
}