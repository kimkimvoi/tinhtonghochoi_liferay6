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
 * The utility for the organizations local service. This utility wraps {@link com.fsoft.bn.service.impl.OrganizationsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see OrganizationsLocalService
 * @see com.fsoft.bn.service.base.OrganizationsLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.OrganizationsLocalServiceImpl
 * @generated
 */
public class OrganizationsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.OrganizationsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the organizations to the database. Also notifies the appropriate model listeners.
	*
	* @param organizations the organizations
	* @return the organizations that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations addOrganizations(
		com.fsoft.bn.model.Organizations organizations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOrganizations(organizations);
	}

	/**
	* Creates a new organizations with the primary key. Does not add the organizations to the database.
	*
	* @param organizations_id the primary key for the new organizations
	* @return the new organizations
	*/
	public static com.fsoft.bn.model.Organizations createOrganizations(
		long organizations_id) {
		return getService().createOrganizations(organizations_id);
	}

	/**
	* Deletes the organizations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizations_id the primary key of the organizations
	* @return the organizations that was removed
	* @throws PortalException if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations deleteOrganizations(
		long organizations_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOrganizations(organizations_id);
	}

	/**
	* Deletes the organizations from the database. Also notifies the appropriate model listeners.
	*
	* @param organizations the organizations
	* @return the organizations that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations deleteOrganizations(
		com.fsoft.bn.model.Organizations organizations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOrganizations(organizations);
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

	public static com.fsoft.bn.model.Organizations fetchOrganizations(
		long organizations_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOrganizations(organizations_id);
	}

	/**
	* Returns the organizations with the primary key.
	*
	* @param organizations_id the primary key of the organizations
	* @return the organizations
	* @throws PortalException if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations getOrganizations(
		long organizations_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizations(organizations_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the organizationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of organizationses
	* @param end the upper bound of the range of organizationses (not inclusive)
	* @return the range of organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> getOrganizationses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizationses(start, end);
	}

	/**
	* Returns the number of organizationses.
	*
	* @return the number of organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static int getOrganizationsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrganizationsesCount();
	}

	/**
	* Updates the organizations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organizations the organizations
	* @return the organizations that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations updateOrganizations(
		com.fsoft.bn.model.Organizations organizations)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOrganizations(organizations);
	}

	/**
	* Updates the organizations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organizations the organizations
	* @param merge whether to merge the organizations with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the organizations that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations updateOrganizations(
		com.fsoft.bn.model.Organizations organizations, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOrganizations(organizations, merge);
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
	* Never reference this interface directly. Always use {@link com.fsoft.bn.service.OrganizationsLocalServiceUtil} to access the organizations local service.
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> getAllOrganization()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllOrganization();
	}

	public static void clearService() {
		_service = null;
	}

	public static OrganizationsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OrganizationsLocalService.class.getName());

			if (invokableLocalService instanceof OrganizationsLocalService) {
				_service = (OrganizationsLocalService)invokableLocalService;
			}
			else {
				_service = new OrganizationsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OrganizationsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(OrganizationsLocalService service) {
	}

	private static OrganizationsLocalService _service;
}