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

import com.fsoft.bn.model.PreschoolStudent;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the preschool student service. This utility wraps {@link PreschoolStudentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PreschoolStudentPersistence
 * @see PreschoolStudentPersistenceImpl
 * @generated
 */
public class PreschoolStudentUtil {
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
	public static void clearCache(PreschoolStudent preschoolStudent) {
		getPersistence().clearCache(preschoolStudent);
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
	public static List<PreschoolStudent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PreschoolStudent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PreschoolStudent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PreschoolStudent update(PreschoolStudent preschoolStudent,
		boolean merge) throws SystemException {
		return getPersistence().update(preschoolStudent, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PreschoolStudent update(PreschoolStudent preschoolStudent,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(preschoolStudent, merge, serviceContext);
	}

	/**
	* Caches the preschool student in the entity cache if it is enabled.
	*
	* @param preschoolStudent the preschool student
	*/
	public static void cacheResult(
		com.fsoft.bn.model.PreschoolStudent preschoolStudent) {
		getPersistence().cacheResult(preschoolStudent);
	}

	/**
	* Caches the preschool students in the entity cache if it is enabled.
	*
	* @param preschoolStudents the preschool students
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.PreschoolStudent> preschoolStudents) {
		getPersistence().cacheResult(preschoolStudents);
	}

	/**
	* Creates a new preschool student with the primary key. Does not add the preschool student to the database.
	*
	* @param student_id the primary key for the new preschool student
	* @return the new preschool student
	*/
	public static com.fsoft.bn.model.PreschoolStudent create(
		java.lang.String student_id) {
		return getPersistence().create(student_id);
	}

	/**
	* Removes the preschool student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param student_id the primary key of the preschool student
	* @return the preschool student that was removed
	* @throws com.fsoft.bn.NoSuchPreschoolStudentException if a preschool student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PreschoolStudent remove(
		java.lang.String student_id)
		throws com.fsoft.bn.NoSuchPreschoolStudentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(student_id);
	}

	public static com.fsoft.bn.model.PreschoolStudent updateImpl(
		com.fsoft.bn.model.PreschoolStudent preschoolStudent, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(preschoolStudent, merge);
	}

	/**
	* Returns the preschool student with the primary key or throws a {@link com.fsoft.bn.NoSuchPreschoolStudentException} if it could not be found.
	*
	* @param student_id the primary key of the preschool student
	* @return the preschool student
	* @throws com.fsoft.bn.NoSuchPreschoolStudentException if a preschool student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PreschoolStudent findByPrimaryKey(
		java.lang.String student_id)
		throws com.fsoft.bn.NoSuchPreschoolStudentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(student_id);
	}

	/**
	* Returns the preschool student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param student_id the primary key of the preschool student
	* @return the preschool student, or <code>null</code> if a preschool student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PreschoolStudent fetchByPrimaryKey(
		java.lang.String student_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(student_id);
	}

	/**
	* Returns all the preschool students.
	*
	* @return the preschool students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PreschoolStudent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the preschool students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool students
	* @param end the upper bound of the range of preschool students (not inclusive)
	* @return the range of preschool students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PreschoolStudent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the preschool students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool students
	* @param end the upper bound of the range of preschool students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of preschool students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PreschoolStudent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the preschool students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of preschool students.
	*
	* @return the number of preschool students
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PreschoolStudentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PreschoolStudentPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					PreschoolStudentPersistence.class.getName());

			ReferenceRegistry.registerReference(PreschoolStudentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PreschoolStudentPersistence persistence) {
	}

	private static PreschoolStudentPersistence _persistence;
}