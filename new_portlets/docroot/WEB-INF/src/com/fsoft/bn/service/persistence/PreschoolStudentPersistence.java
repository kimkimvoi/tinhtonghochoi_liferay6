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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the preschool student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PreschoolStudentPersistenceImpl
 * @see PreschoolStudentUtil
 * @generated
 */
public interface PreschoolStudentPersistence extends BasePersistence<PreschoolStudent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PreschoolStudentUtil} to access the preschool student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the preschool student in the entity cache if it is enabled.
	*
	* @param preschoolStudent the preschool student
	*/
	public void cacheResult(
		com.fsoft.bn.model.PreschoolStudent preschoolStudent);

	/**
	* Caches the preschool students in the entity cache if it is enabled.
	*
	* @param preschoolStudents the preschool students
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.PreschoolStudent> preschoolStudents);

	/**
	* Creates a new preschool student with the primary key. Does not add the preschool student to the database.
	*
	* @param student_id the primary key for the new preschool student
	* @return the new preschool student
	*/
	public com.fsoft.bn.model.PreschoolStudent create(
		java.lang.String student_id);

	/**
	* Removes the preschool student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param student_id the primary key of the preschool student
	* @return the preschool student that was removed
	* @throws com.fsoft.bn.NoSuchPreschoolStudentException if a preschool student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolStudent remove(
		java.lang.String student_id)
		throws com.fsoft.bn.NoSuchPreschoolStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.PreschoolStudent updateImpl(
		com.fsoft.bn.model.PreschoolStudent preschoolStudent, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the preschool student with the primary key or throws a {@link com.fsoft.bn.NoSuchPreschoolStudentException} if it could not be found.
	*
	* @param student_id the primary key of the preschool student
	* @return the preschool student
	* @throws com.fsoft.bn.NoSuchPreschoolStudentException if a preschool student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolStudent findByPrimaryKey(
		java.lang.String student_id)
		throws com.fsoft.bn.NoSuchPreschoolStudentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the preschool student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param student_id the primary key of the preschool student
	* @return the preschool student, or <code>null</code> if a preschool student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolStudent fetchByPrimaryKey(
		java.lang.String student_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the preschool students.
	*
	* @return the preschool students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PreschoolStudent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.PreschoolStudent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.PreschoolStudent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the preschool students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of preschool students.
	*
	* @return the number of preschool students
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}