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

import com.fsoft.bn.model.RecruitmentTrainingCourses;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the recruitment training courses service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentTrainingCoursesPersistenceImpl
 * @see RecruitmentTrainingCoursesUtil
 * @generated
 */
public interface RecruitmentTrainingCoursesPersistence extends BasePersistence<RecruitmentTrainingCourses> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecruitmentTrainingCoursesUtil} to access the recruitment training courses persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the recruitment training courses in the entity cache if it is enabled.
	*
	* @param recruitmentTrainingCourses the recruitment training courses
	*/
	public void cacheResult(
		com.fsoft.bn.model.RecruitmentTrainingCourses recruitmentTrainingCourses);

	/**
	* Caches the recruitment training courseses in the entity cache if it is enabled.
	*
	* @param recruitmentTrainingCourseses the recruitment training courseses
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.RecruitmentTrainingCourses> recruitmentTrainingCourseses);

	/**
	* Creates a new recruitment training courses with the primary key. Does not add the recruitment training courses to the database.
	*
	* @param recruitment_training_courses_id the primary key for the new recruitment training courses
	* @return the new recruitment training courses
	*/
	public com.fsoft.bn.model.RecruitmentTrainingCourses create(
		java.lang.String recruitment_training_courses_id);

	/**
	* Removes the recruitment training courses with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_training_courses_id the primary key of the recruitment training courses
	* @return the recruitment training courses that was removed
	* @throws com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException if a recruitment training courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentTrainingCourses remove(
		java.lang.String recruitment_training_courses_id)
		throws com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.RecruitmentTrainingCourses updateImpl(
		com.fsoft.bn.model.RecruitmentTrainingCourses recruitmentTrainingCourses,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment training courses with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException} if it could not be found.
	*
	* @param recruitment_training_courses_id the primary key of the recruitment training courses
	* @return the recruitment training courses
	* @throws com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException if a recruitment training courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentTrainingCourses findByPrimaryKey(
		java.lang.String recruitment_training_courses_id)
		throws com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment training courses with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitment_training_courses_id the primary key of the recruitment training courses
	* @return the recruitment training courses, or <code>null</code> if a recruitment training courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentTrainingCourses fetchByPrimaryKey(
		java.lang.String recruitment_training_courses_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the recruitment training courseses.
	*
	* @return the recruitment training courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentTrainingCourses> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the recruitment training courseses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment training courseses
	* @param end the upper bound of the range of recruitment training courseses (not inclusive)
	* @return the range of recruitment training courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentTrainingCourses> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the recruitment training courseses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment training courseses
	* @param end the upper bound of the range of recruitment training courseses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recruitment training courseses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentTrainingCourses> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the recruitment training courseses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of recruitment training courseses.
	*
	* @return the number of recruitment training courseses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}