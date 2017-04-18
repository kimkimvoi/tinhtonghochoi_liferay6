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

import com.fsoft.bn.model.StaffInfo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the staff info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see StaffInfoPersistenceImpl
 * @see StaffInfoUtil
 * @generated
 */
public interface StaffInfoPersistence extends BasePersistence<StaffInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StaffInfoUtil} to access the staff info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the staff info in the entity cache if it is enabled.
	*
	* @param staffInfo the staff info
	*/
	public void cacheResult(com.fsoft.bn.model.StaffInfo staffInfo);

	/**
	* Caches the staff infos in the entity cache if it is enabled.
	*
	* @param staffInfos the staff infos
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.StaffInfo> staffInfos);

	/**
	* Creates a new staff info with the primary key. Does not add the staff info to the database.
	*
	* @param staff_id the primary key for the new staff info
	* @return the new staff info
	*/
	public com.fsoft.bn.model.StaffInfo create(long staff_id);

	/**
	* Removes the staff info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param staff_id the primary key of the staff info
	* @return the staff info that was removed
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo remove(long staff_id)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.StaffInfo updateImpl(
		com.fsoft.bn.model.StaffInfo staffInfo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff info with the primary key or throws a {@link com.fsoft.bn.NoSuchStaffInfoException} if it could not be found.
	*
	* @param staff_id the primary key of the staff info
	* @return the staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByPrimaryKey(long staff_id)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param staff_id the primary key of the staff info
	* @return the staff info, or <code>null</code> if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByPrimaryKey(long staff_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the staff infos where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByDeleted(
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the staff infos where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @return the range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByDeleted(
		boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the staff infos where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByDeleted(
		boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByDeleted_First(boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByDeleted_First(boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByDeleted_Last(boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByDeleted_Last(boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff infos before and after the current staff info in the ordered set where deleted = &#63;.
	*
	* @param staff_id the primary key of the current staff info
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo[] findByDeleted_PrevAndNext(
		long staff_id, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByName(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @return the range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByName(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByName(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByName_First(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByName_First(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByName_Last(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByName_Last(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff infos before and after the current staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* @param staff_id the primary key of the current staff info
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo[] findByName_PrevAndNext(
		long staff_id, java.lang.String staff_firstname,
		java.lang.String staff_middlename, java.lang.String staff_lastname,
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the staff infos where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByEmail(
		java.lang.String staff_email, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the staff infos where staff_email = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @return the range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByEmail(
		java.lang.String staff_email, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the staff infos where staff_email = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByEmail(
		java.lang.String staff_email, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByEmail_First(
		java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByEmail_First(
		java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByEmail_Last(
		java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByEmail_Last(
		java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff infos before and after the current staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_id the primary key of the current staff info
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo[] findByEmail_PrevAndNext(
		long staff_id, java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the staff infos where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByRole(
		java.lang.String staff_role, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the staff infos where staff_role = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @return the range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByRole(
		java.lang.String staff_role, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the staff infos where staff_role = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByRole(
		java.lang.String staff_role, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByRole_First(
		java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByRole_First(
		java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByRole_Last(
		java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByRole_Last(
		java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff infos before and after the current staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_id the primary key of the current staff info
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo[] findByRole_PrevAndNext(
		long staff_id, java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the staff infos where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByPhone(
		java.lang.String staff_phone, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the staff infos where staff_phone = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @return the range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByPhone(
		java.lang.String staff_phone, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the staff infos where staff_phone = &#63; and deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findByPhone(
		java.lang.String staff_phone, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByPhone_First(
		java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByPhone_First(
		java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo findByPhone_Last(
		java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo fetchByPhone_Last(
		java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the staff infos before and after the current staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_id the primary key of the current staff info
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.StaffInfo[] findByPhone_PrevAndNext(
		long staff_id, java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the staff infos.
	*
	* @return the staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.StaffInfo> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the staff infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of staff infos
	* @param end the upper bound of the range of staff infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of staff infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.StaffInfo> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the staff infos where deleted = &#63; from the database.
	*
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63; from the database.
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String staff_firstname,
		java.lang.String staff_middlename, java.lang.String staff_lastname,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the staff infos where staff_email = &#63; and deleted = &#63; from the database.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmail(java.lang.String staff_email, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the staff infos where staff_role = &#63; and deleted = &#63; from the database.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRole(java.lang.String staff_role, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the staff infos where staff_phone = &#63; and deleted = &#63; from the database.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPhone(java.lang.String staff_phone, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the staff infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of staff infos where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String staff_firstname,
		java.lang.String staff_middlename, java.lang.String staff_lastname,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of staff infos where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String staff_email, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of staff infos where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByRole(java.lang.String staff_role, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of staff infos where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByPhone(java.lang.String staff_phone, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of staff infos.
	*
	* @return the number of staff infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}