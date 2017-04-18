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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the primary school student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolStudentPersistenceImpl
 * @see PrimarySchoolStudentUtil
 * @generated
 */
public interface PrimarySchoolStudentPersistence extends BasePersistence<PrimarySchoolStudent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PrimarySchoolStudentUtil} to access the primary school student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the primary school student in the entity cache if it is enabled.
	*
	* @param primarySchoolStudent the primary school student
	*/
	public void cacheResult(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent);

	/**
	* Caches the primary school students in the entity cache if it is enabled.
	*
	* @param primarySchoolStudents the primary school students
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> primarySchoolStudents);

	/**
	* Creates a new primary school student with the primary key. Does not add the primary school student to the database.
	*
	* @param primaryStudent_id the primary key for the new primary school student
	* @return the new primary school student
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent create(
		java.lang.String primaryStudent_id);

	/**
	* Removes the primary school student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryStudent_id the primary key of the primary school student
	* @return the primary school student that was removed
	* @throws com.fsoft.bn.NoSuchPrimarySchoolStudentException if a primary school student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent remove(
		java.lang.String primaryStudent_id)
		throws com.fsoft.bn.NoSuchPrimarySchoolStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.PrimarySchoolStudent updateImpl(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the primary school student with the primary key or throws a {@link com.fsoft.bn.NoSuchPrimarySchoolStudentException} if it could not be found.
	*
	* @param primaryStudent_id the primary key of the primary school student
	* @return the primary school student
	* @throws com.fsoft.bn.NoSuchPrimarySchoolStudentException if a primary school student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent findByPrimaryKey(
		java.lang.String primaryStudent_id)
		throws com.fsoft.bn.NoSuchPrimarySchoolStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the primary school student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primaryStudent_id the primary key of the primary school student
	* @return the primary school student, or <code>null</code> if a primary school student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent fetchByPrimaryKey(
		java.lang.String primaryStudent_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the primary school students.
	*
	* @return the primary school students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the primary school students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of primary school students.
	*
	* @return the number of primary school students
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}