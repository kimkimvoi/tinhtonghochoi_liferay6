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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the organizations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see OrganizationsPersistenceImpl
 * @see OrganizationsUtil
 * @generated
 */
public interface OrganizationsPersistence extends BasePersistence<Organizations> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationsUtil} to access the organizations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the organizations in the entity cache if it is enabled.
	*
	* @param organizations the organizations
	*/
	public void cacheResult(com.fsoft.bn.model.Organizations organizations);

	/**
	* Caches the organizationses in the entity cache if it is enabled.
	*
	* @param organizationses the organizationses
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.Organizations> organizationses);

	/**
	* Creates a new organizations with the primary key. Does not add the organizations to the database.
	*
	* @param organizations_id the primary key for the new organizations
	* @return the new organizations
	*/
	public com.fsoft.bn.model.Organizations create(long organizations_id);

	/**
	* Removes the organizations with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param organizations_id the primary key of the organizations
	* @return the organizations that was removed
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations remove(long organizations_id)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.Organizations updateImpl(
		com.fsoft.bn.model.Organizations organizations, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizations with the primary key or throws a {@link com.fsoft.bn.NoSuchOrganizationsException} if it could not be found.
	*
	* @param organizations_id the primary key of the organizations
	* @return the organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations findByPrimaryKey(
		long organizations_id)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organizations with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param organizations_id the primary key of the organizations
	* @return the organizations, or <code>null</code> if a organizations with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations fetchByPrimaryKey(
		long organizations_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the organizationses where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Organizations> findByDeleted(
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.Organizations> findByDeleted(
		boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.Organizations> findByDeleted(
		boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizations in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations findByDeleted_First(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizations in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizations, or <code>null</code> if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations fetchByDeleted_First(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizations in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizations
	* @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations findByDeleted_Last(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizations in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizations, or <code>null</code> if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations fetchByDeleted_Last(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.fsoft.bn.model.Organizations[] findByDeleted_PrevAndNext(
		long organizations_id, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the organizationses where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @return the matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Organizations> findByName(
		java.lang.String organizations_name, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.Organizations> findByName(
		java.lang.String organizations_name, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.Organizations> findByName(
		java.lang.String organizations_name, boolean deleted, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.fsoft.bn.model.Organizations findByName_First(
		java.lang.String organizations_name, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organizations, or <code>null</code> if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations fetchByName_First(
		java.lang.String organizations_name, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.fsoft.bn.model.Organizations findByName_Last(
		java.lang.String organizations_name, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organizations, or <code>null</code> if a matching organizations could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Organizations fetchByName_Last(
		java.lang.String organizations_name, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.fsoft.bn.model.Organizations[] findByName_PrevAndNext(
		long organizations_id, java.lang.String organizations_name,
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchOrganizationsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the organizationses.
	*
	* @return the organizationses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Organizations> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.Organizations> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.Organizations> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organizationses where deleted = &#63; from the database.
	*
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organizationses where organizations_name = &#63; and deleted = &#63; from the database.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String organizations_name,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organizationses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizationses where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the number of matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public int countByDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizationses where organizations_name = &#63; and deleted = &#63;.
	*
	* @param organizations_name the organizations_name
	* @param deleted the deleted
	* @return the number of matching organizationses
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String organizations_name, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organizationses.
	*
	* @return the number of organizationses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}