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

import com.fsoft.bn.model.PrimarySchoolStudent;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the primary school student service. This utility wraps {@link PrimarySchoolStudentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolStudentPersistence
 * @see PrimarySchoolStudentPersistenceImpl
 * @generated
 */
public class PrimarySchoolStudentUtil {
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
	public static void clearCache(PrimarySchoolStudent primarySchoolStudent) {
		getPersistence().clearCache(primarySchoolStudent);
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
	public static List<PrimarySchoolStudent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PrimarySchoolStudent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PrimarySchoolStudent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PrimarySchoolStudent update(
		PrimarySchoolStudent primarySchoolStudent, boolean merge)
		throws SystemException {
		return getPersistence().update(primarySchoolStudent, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PrimarySchoolStudent update(
		PrimarySchoolStudent primarySchoolStudent, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(primarySchoolStudent, merge, serviceContext);
	}

	/**
	* Caches the primary school student in the entity cache if it is enabled.
	*
	* @param primarySchoolStudent the primary school student
	*/
	public static void cacheResult(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent) {
		getPersistence().cacheResult(primarySchoolStudent);
	}

	/**
	* Caches the primary school students in the entity cache if it is enabled.
	*
	* @param primarySchoolStudents the primary school students
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> primarySchoolStudents) {
		getPersistence().cacheResult(primarySchoolStudents);
	}

	/**
	* Creates a new primary school student with the primary key. Does not add the primary school student to the database.
	*
	* @param primaryStudent_id the primary key for the new primary school student
	* @return the new primary school student
	*/
	public static com.fsoft.bn.model.PrimarySchoolStudent create(
		java.lang.String primaryStudent_id) {
		return getPersistence().create(primaryStudent_id);
	}

	/**
	* Removes the primary school student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryStudent_id the primary key of the primary school student
	* @return the primary school student that was removed
	* @throws com.fsoft.bn.NoSuchPrimarySchoolStudentException if a primary school student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolStudent remove(
		java.lang.String primaryStudent_id)
		throws com.fsoft.bn.NoSuchPrimarySchoolStudentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(primaryStudent_id);
	}

	public static com.fsoft.bn.model.PrimarySchoolStudent updateImpl(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(primarySchoolStudent, merge);
	}

	/**
	* Returns the primary school student with the primary key or throws a {@link com.fsoft.bn.NoSuchPrimarySchoolStudentException} if it could not be found.
	*
	* @param primaryStudent_id the primary key of the primary school student
	* @return the primary school student
	* @throws com.fsoft.bn.NoSuchPrimarySchoolStudentException if a primary school student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolStudent findByPrimaryKey(
		java.lang.String primaryStudent_id)
		throws com.fsoft.bn.NoSuchPrimarySchoolStudentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(primaryStudent_id);
	}

	/**
	* Returns the primary school student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primaryStudent_id the primary key of the primary school student
	* @return the primary school student, or <code>null</code> if a primary school student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolStudent fetchByPrimaryKey(
		java.lang.String primaryStudent_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(primaryStudent_id);
	}

	/**
	* Returns all the primary school students.
	*
	* @return the primary school students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the primary school students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school students
	* @param end the upper bound of the range of primary school students (not inclusive)
	* @return the range of primary school students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the primary school students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school students
	* @param end the upper bound of the range of primary school students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of primary school students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the primary school students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of primary school students.
	*
	* @return the number of primary school students
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PrimarySchoolStudentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PrimarySchoolStudentPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					PrimarySchoolStudentPersistence.class.getName());

			ReferenceRegistry.registerReference(PrimarySchoolStudentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PrimarySchoolStudentPersistence persistence) {
	}

	private static PrimarySchoolStudentPersistence _persistence;
}