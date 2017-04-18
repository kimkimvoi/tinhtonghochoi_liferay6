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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the staff info service. This utility wraps {@link StaffInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see StaffInfoPersistence
 * @see StaffInfoPersistenceImpl
 * @generated
 */
public class StaffInfoUtil {
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
	public static void clearCache(StaffInfo staffInfo) {
		getPersistence().clearCache(staffInfo);
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
	public static List<StaffInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StaffInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StaffInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static StaffInfo update(StaffInfo staffInfo, boolean merge)
		throws SystemException {
		return getPersistence().update(staffInfo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static StaffInfo update(StaffInfo staffInfo, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(staffInfo, merge, serviceContext);
	}

	/**
	* Caches the staff info in the entity cache if it is enabled.
	*
	* @param staffInfo the staff info
	*/
	public static void cacheResult(com.fsoft.bn.model.StaffInfo staffInfo) {
		getPersistence().cacheResult(staffInfo);
	}

	/**
	* Caches the staff infos in the entity cache if it is enabled.
	*
	* @param staffInfos the staff infos
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.StaffInfo> staffInfos) {
		getPersistence().cacheResult(staffInfos);
	}

	/**
	* Creates a new staff info with the primary key. Does not add the staff info to the database.
	*
	* @param staff_id the primary key for the new staff info
	* @return the new staff info
	*/
	public static com.fsoft.bn.model.StaffInfo create(long staff_id) {
		return getPersistence().create(staff_id);
	}

	/**
	* Removes the staff info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param staff_id the primary key of the staff info
	* @return the staff info that was removed
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo remove(long staff_id)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(staff_id);
	}

	public static com.fsoft.bn.model.StaffInfo updateImpl(
		com.fsoft.bn.model.StaffInfo staffInfo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(staffInfo, merge);
	}

	/**
	* Returns the staff info with the primary key or throws a {@link com.fsoft.bn.NoSuchStaffInfoException} if it could not be found.
	*
	* @param staff_id the primary key of the staff info
	* @return the staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo findByPrimaryKey(long staff_id)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(staff_id);
	}

	/**
	* Returns the staff info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param staff_id the primary key of the staff info
	* @return the staff info, or <code>null</code> if a staff info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByPrimaryKey(long staff_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(staff_id);
	}

	/**
	* Returns all the staff infos where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByDeleted(
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeleted(deleted);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByDeleted(
		boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeleted(deleted, start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByDeleted(
		boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeleted(deleted, start, end, orderByComparator);
	}

	/**
	* Returns the first staff info in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo findByDeleted_First(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeleted_First(deleted, orderByComparator);
	}

	/**
	* Returns the first staff info in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByDeleted_First(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDeleted_First(deleted, orderByComparator);
	}

	/**
	* Returns the last staff info in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info
	* @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo findByDeleted_Last(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeleted_Last(deleted, orderByComparator);
	}

	/**
	* Returns the last staff info in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByDeleted_Last(
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDeleted_Last(deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo[] findByDeleted_PrevAndNext(
		long staff_id, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeleted_PrevAndNext(staff_id, deleted,
			orderByComparator);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByName(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName(staff_firstname, staff_middlename,
			staff_lastname, deleted);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByName(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName(staff_firstname, staff_middlename,
			staff_lastname, deleted, start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByName(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName(staff_firstname, staff_middlename,
			staff_lastname, deleted, start, end, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo findByName_First(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName_First(staff_firstname, staff_middlename,
			staff_lastname, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo fetchByName_First(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByName_First(staff_firstname, staff_middlename,
			staff_lastname, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo findByName_Last(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName_Last(staff_firstname, staff_middlename,
			staff_lastname, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo fetchByName_Last(
		java.lang.String staff_firstname, java.lang.String staff_middlename,
		java.lang.String staff_lastname, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByName_Last(staff_firstname, staff_middlename,
			staff_lastname, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo[] findByName_PrevAndNext(
		long staff_id, java.lang.String staff_firstname,
		java.lang.String staff_middlename, java.lang.String staff_lastname,
		boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByName_PrevAndNext(staff_id, staff_firstname,
			staff_middlename, staff_lastname, deleted, orderByComparator);
	}

	/**
	* Returns all the staff infos where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByEmail(
		java.lang.String staff_email, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(staff_email, deleted);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByEmail(
		java.lang.String staff_email, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(staff_email, deleted, start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByEmail(
		java.lang.String staff_email, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmail(staff_email, deleted, start, end,
			orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo findByEmail_First(
		java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmail_First(staff_email, deleted, orderByComparator);
	}

	/**
	* Returns the first staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByEmail_First(
		java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmail_First(staff_email, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo findByEmail_Last(
		java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmail_Last(staff_email, deleted, orderByComparator);
	}

	/**
	* Returns the last staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByEmail_Last(
		java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmail_Last(staff_email, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo[] findByEmail_PrevAndNext(
		long staff_id, java.lang.String staff_email, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmail_PrevAndNext(staff_id, staff_email, deleted,
			orderByComparator);
	}

	/**
	* Returns all the staff infos where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByRole(
		java.lang.String staff_role, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRole(staff_role, deleted);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByRole(
		java.lang.String staff_role, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRole(staff_role, deleted, start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByRole(
		java.lang.String staff_role, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRole(staff_role, deleted, start, end,
			orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo findByRole_First(
		java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRole_First(staff_role, deleted, orderByComparator);
	}

	/**
	* Returns the first staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByRole_First(
		java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRole_First(staff_role, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo findByRole_Last(
		java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRole_Last(staff_role, deleted, orderByComparator);
	}

	/**
	* Returns the last staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByRole_Last(
		java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRole_Last(staff_role, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo[] findByRole_PrevAndNext(
		long staff_id, java.lang.String staff_role, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRole_PrevAndNext(staff_id, staff_role, deleted,
			orderByComparator);
	}

	/**
	* Returns all the staff infos where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @return the matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByPhone(
		java.lang.String staff_phone, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPhone(staff_phone, deleted);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByPhone(
		java.lang.String staff_phone, boolean deleted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPhone(staff_phone, deleted, start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findByPhone(
		java.lang.String staff_phone, boolean deleted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhone(staff_phone, deleted, start, end,
			orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo findByPhone_First(
		java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhone_First(staff_phone, deleted, orderByComparator);
	}

	/**
	* Returns the first staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByPhone_First(
		java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPhone_First(staff_phone, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo findByPhone_Last(
		java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhone_Last(staff_phone, deleted, orderByComparator);
	}

	/**
	* Returns the last staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.StaffInfo fetchByPhone_Last(
		java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPhone_Last(staff_phone, deleted, orderByComparator);
	}

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
	public static com.fsoft.bn.model.StaffInfo[] findByPhone_PrevAndNext(
		long staff_id, java.lang.String staff_phone, boolean deleted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.fsoft.bn.NoSuchStaffInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPhone_PrevAndNext(staff_id, staff_phone, deleted,
			orderByComparator);
	}

	/**
	* Returns all the staff infos.
	*
	* @return the staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.StaffInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the staff infos where deleted = &#63; from the database.
	*
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDeleted(deleted);
	}

	/**
	* Removes all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63; from the database.
	*
	* @param staff_firstname the staff_firstname
	* @param staff_middlename the staff_middlename
	* @param staff_lastname the staff_lastname
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String staff_firstname,
		java.lang.String staff_middlename, java.lang.String staff_lastname,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByName(staff_firstname, staff_middlename, staff_lastname,
			deleted);
	}

	/**
	* Removes all the staff infos where staff_email = &#63; and deleted = &#63; from the database.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmail(java.lang.String staff_email,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmail(staff_email, deleted);
	}

	/**
	* Removes all the staff infos where staff_role = &#63; and deleted = &#63; from the database.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRole(java.lang.String staff_role, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRole(staff_role, deleted);
	}

	/**
	* Removes all the staff infos where staff_phone = &#63; and deleted = &#63; from the database.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPhone(java.lang.String staff_phone,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPhone(staff_phone, deleted);
	}

	/**
	* Removes all the staff infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of staff infos where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDeleted(boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDeleted(deleted);
	}

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
	public static int countByName(java.lang.String staff_firstname,
		java.lang.String staff_middlename, java.lang.String staff_lastname,
		boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByName(staff_firstname, staff_middlename,
			staff_lastname, deleted);
	}

	/**
	* Returns the number of staff infos where staff_email = &#63; and deleted = &#63;.
	*
	* @param staff_email the staff_email
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmail(java.lang.String staff_email, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmail(staff_email, deleted);
	}

	/**
	* Returns the number of staff infos where staff_role = &#63; and deleted = &#63;.
	*
	* @param staff_role the staff_role
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRole(java.lang.String staff_role, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRole(staff_role, deleted);
	}

	/**
	* Returns the number of staff infos where staff_phone = &#63; and deleted = &#63;.
	*
	* @param staff_phone the staff_phone
	* @param deleted the deleted
	* @return the number of matching staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPhone(java.lang.String staff_phone, boolean deleted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPhone(staff_phone, deleted);
	}

	/**
	* Returns the number of staff infos.
	*
	* @return the number of staff infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StaffInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StaffInfoPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					StaffInfoPersistence.class.getName());

			ReferenceRegistry.registerReference(StaffInfoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(StaffInfoPersistence persistence) {
	}

	private static StaffInfoPersistence _persistence;
}