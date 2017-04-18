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

import com.fsoft.bn.model.Organizations;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the organizations service. This utility wraps {@link OrganizationsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see OrganizationsPersistence
 * @see OrganizationsPersistenceImpl
 * @generated
 */
public class OrganizationsUtil {
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
	public static void clearCache(Organizations organizations) {
		getPersistence().clearCache(organizations);
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
	public static List<Organizations> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Organizations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Organizations> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Organizations update(Organizations organizations,
		boolean merge) throws SystemException {
		return getPersistence().update(organizations, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Organizations update(Organizations organizations,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(organizations, merge, serviceContext);
	}

	/**
	* Caches the organizations in the entity cache if it is enabled.
	*
	* @param organizations the organizations
	*/
	public static void cacheResult(
		com.fsoft.bn.model.Organizations organizations) {
		getPersistence().cacheResult(organizations);
	}

	/**
	* Caches the organizationses in the entity cache if it is enabled.
	*
	* @param organizationses the organizationses
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.Organizations> organizationses) {
		getPersistence().cacheResult(organizationses);
	}

	/**
	* Creates a new organizations with the primary key. Does not add the organizations to the database.
	*
	* @param organizations_id the primary key for the new organizations
	* @return the new organizations
	*/
	public static com.fsoft.bn.model.Organizations create(long organizations_id) {
		return getPersistence().create(organizations_id);
	}

	/**
	* Removes the organizations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizations_id the primary key of the organizations
	* @return the organizations that was removed
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations remove(long organizations_id)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(organizations_id);
	}

	public static com.fsoft.bn.model.Organizations updateImpl(
		com.fsoft.bn.model.Organizations organizations, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(organizations, merge);
	}

	/**
	* Returns the organizations with the primary key or throws a {@link com.fsoft.bn.NoSuchOrganizationsException} if it could not be found.
	*
	* @param organizations_id the primary key of the organizations
	* @return the organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations findByPrimaryKey(
		long organizations_id)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(organizations_id);
	}

	/**
	* Returns the organizations with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param organizations_id the primary key of the organizations
	* @return the organizations, or <code>null</code> if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations fetchByPrimaryKey(
		long organizations_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(organizations_id);
	}

	/**
	* Returns all the organizationses where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> findByDeleted(
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeleted(deleted);
	}

	/**
	* Returns a range of all the organizationses where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of organizationses
	* @param end the upper bound of the range of organizationses (not inclusive)
	* @return the range of matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> findByDeleted(
		boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeleted(deleted, start, end);
	}

	/**
	* Returns an ordered range of all the organizationses where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of organizationses
	* @param end the upper bound of the range of organizationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> findByDeleted(
		boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeleted(deleted, start, end, orderByComparator);
	}

	/**
	* Returns the first organizations in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations findByDeleted_First(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeleted_First(deleted, orderByComparator);
	}

	/**
	* Returns the first organizations in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizations, or <code>null</code> if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations fetchByDeleted_First(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDeleted_First(deleted, orderByComparator);
	}

	/**
	* Returns the last organizations in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations findByDeleted_Last(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeleted_Last(deleted, orderByComparator);
	}

	/**
	* Returns the last organizations in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizations, or <code>null</code> if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations fetchByDeleted_Last(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDeleted_Last(deleted, orderByComparator);
	}

	/**
	* Returns the organizationses before and after the current organizations in the ordered set where deleted = &#63;.
	*
	* @param organizations_id the primary key of the current organizations
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations[] findByDeleted_PrevAndNext(
		long organizations_id, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeleted_PrevAndNext(organizations_id, deleted,
			orderByComparator);
	}

	/**
	* Returns all the organizationses where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @return the matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> findByName(
		java.lang.String organizations_name, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(organizations_name, deleted);
	}

	/**
	* Returns a range of all the organizationses where organizations_name = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param start the lower bound of the range of organizationses
	* @param end the upper bound of the range of organizationses (not inclusive)
	* @return the range of matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> findByName(
		java.lang.String organizations_name, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName(organizations_name, deleted, start, end);
	}

	/**
	* Returns an ordered range of all the organizationses where organizations_name = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param start the lower bound of the range of organizationses
	* @param end the upper bound of the range of organizationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> findByName(
		java.lang.String organizations_name, boolean deleted, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName(organizations_name, deleted, start, end,
			orderByComparator);
	}

	/**
	* Returns the first organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations findByName_First(
		java.lang.String organizations_name, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName_First(organizations_name, deleted,
			orderByComparator);
	}

	/**
	* Returns the first organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizations, or <code>null</code> if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations fetchByName_First(
		java.lang.String organizations_name, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByName_First(organizations_name, deleted,
			orderByComparator);
	}

	/**
	* Returns the last organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations findByName_Last(
		java.lang.String organizations_name, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName_Last(organizations_name, deleted,
			orderByComparator);
	}

	/**
	* Returns the last organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizations, or <code>null</code> if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations fetchByName_Last(
		java.lang.String organizations_name, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByName_Last(organizations_name, deleted,
			orderByComparator);
	}

	/**
	* Returns the organizationses before and after the current organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_id the primary key of the current organizations
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Organizations[] findByName_PrevAndNext(
		long organizations_id, java.lang.String organizations_name,
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName_PrevAndNext(organizations_id,
			organizations_name, deleted, orderByComparator);
	}

	/**
	* Returns all the organizationses.
	*
	* @return the organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.fsoft.bn.model.Organizations> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the organizationses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of organizationses
	* @param end the upper bound of the range of organizationses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Organizations> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the organizationses where deleted = &#63; from the database.
	*
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDeleted(deleted);
	}

	/**
	* Removes all the organizationses where organizations_name = &#63; and deleted = &#63; from the database.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String organizations_name,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(organizations_name, deleted);
	}

	/**
	* Removes all the organizationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of organizationses where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the number of matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDeleted(deleted);
	}

	/**
	* Returns the number of organizationses where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @return the number of matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String organizations_name,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(organizations_name, deleted);
	}

	/**
	* Returns the number of organizationses.
	*
	* @return the number of organizationses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrganizationsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrganizationsPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					OrganizationsPersistence.class.getName());

			ReferenceRegistry.registerReference(OrganizationsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OrganizationsPersistence persistence) {
	}

	private static OrganizationsPersistence _persistence;
}