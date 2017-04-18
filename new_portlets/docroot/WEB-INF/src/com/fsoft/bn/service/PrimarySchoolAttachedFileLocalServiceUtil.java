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
 * The utility for the primary school attached file local service. This utility wraps {@link com.fsoft.bn.service.impl.PrimarySchoolAttachedFileLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolAttachedFileLocalService
 * @see com.fsoft.bn.service.base.PrimarySchoolAttachedFileLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.PrimarySchoolAttachedFileLocalServiceImpl
 * @generated
 */
public class PrimarySchoolAttachedFileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.PrimarySchoolAttachedFileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the primary school attached file to the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	* @return the primary school attached file that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile addPrimarySchoolAttachedFile(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPrimarySchoolAttachedFile(primarySchoolAttachedFile);
	}

	/**
	* Creates a new primary school attached file with the primary key. Does not add the primary school attached file to the database.
	*
	* @param primarySchool_attached_id the primary key for the new primary school attached file
	* @return the new primary school attached file
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile createPrimarySchoolAttachedFile(
		java.lang.String primarySchool_attached_id) {
		return getService()
				   .createPrimarySchoolAttachedFile(primarySchool_attached_id);
	}

	/**
	* Deletes the primary school attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchool_attached_id the primary key of the primary school attached file
	* @return the primary school attached file that was removed
	* @throws PortalException if a primary school attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile deletePrimarySchoolAttachedFile(
		java.lang.String primarySchool_attached_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deletePrimarySchoolAttachedFile(primarySchool_attached_id);
	}

	/**
	* Deletes the primary school attached file from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	* @return the primary school attached file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile deletePrimarySchoolAttachedFile(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deletePrimarySchoolAttachedFile(primarySchoolAttachedFile);
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

	public static com.fsoft.bn.model.PrimarySchoolAttachedFile fetchPrimarySchoolAttachedFile(
		java.lang.String primarySchool_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchPrimarySchoolAttachedFile(primarySchool_attached_id);
	}

	/**
	* Returns the primary school attached file with the primary key.
	*
	* @param primarySchool_attached_id the primary key of the primary school attached file
	* @return the primary school attached file
	* @throws PortalException if a primary school attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile getPrimarySchoolAttachedFile(
		java.lang.String primarySchool_attached_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPrimarySchoolAttachedFile(primarySchool_attached_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the primary school attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school attached files
	* @param end the upper bound of the range of primary school attached files (not inclusive)
	* @return the range of primary school attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PrimarySchoolAttachedFile> getPrimarySchoolAttachedFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPrimarySchoolAttachedFiles(start, end);
	}

	/**
	* Returns the number of primary school attached files.
	*
	* @return the number of primary school attached files
	* @throws SystemException if a system exception occurred
	*/
	public static int getPrimarySchoolAttachedFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPrimarySchoolAttachedFilesCount();
	}

	/**
	* Updates the primary school attached file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	* @return the primary school attached file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile updatePrimarySchoolAttachedFile(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePrimarySchoolAttachedFile(primarySchoolAttachedFile);
	}

	/**
	* Updates the primary school attached file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	* @param merge whether to merge the primary school attached file with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the primary school attached file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile updatePrimarySchoolAttachedFile(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePrimarySchoolAttachedFile(primarySchoolAttachedFile,
			merge);
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

	public static void clearService() {
		_service = null;
	}

	public static PrimarySchoolAttachedFileLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PrimarySchoolAttachedFileLocalService.class.getName());

			if (invokableLocalService instanceof PrimarySchoolAttachedFileLocalService) {
				_service = (PrimarySchoolAttachedFileLocalService)invokableLocalService;
			}
			else {
				_service = new PrimarySchoolAttachedFileLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PrimarySchoolAttachedFileLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PrimarySchoolAttachedFileLocalService service) {
	}

	private static PrimarySchoolAttachedFileLocalService _service;
}