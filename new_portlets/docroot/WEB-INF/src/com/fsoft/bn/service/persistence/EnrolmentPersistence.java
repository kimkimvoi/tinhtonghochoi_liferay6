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

import com.fsoft.bn.model.Enrolment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the enrolment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see EnrolmentPersistenceImpl
 * @see EnrolmentUtil
 * @generated
 */
public interface EnrolmentPersistence extends BasePersistence<Enrolment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnrolmentUtil} to access the enrolment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the enrolment in the entity cache if it is enabled.
	*
	* @param enrolment the enrolment
	*/
	public void cacheResult(com.fsoft.bn.model.Enrolment enrolment);

	/**
	* Caches the enrolments in the entity cache if it is enabled.
	*
	* @param enrolments the enrolments
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.Enrolment> enrolments);

	/**
	* Creates a new enrolment with the primary key. Does not add the enrolment to the database.
	*
	* @param enrolment_id the primary key for the new enrolment
	* @return the new enrolment
	*/
	public com.fsoft.bn.model.Enrolment create(java.lang.String enrolment_id);

	/**
	* Removes the enrolment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enrolment_id the primary key of the enrolment
	* @return the enrolment that was removed
	* @throws com.fsoft.bn.NoSuchEnrolmentException if a enrolment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Enrolment remove(java.lang.String enrolment_id)
		throws com.fsoft.bn.NoSuchEnrolmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.Enrolment updateImpl(
		com.fsoft.bn.model.Enrolment enrolment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrolment with the primary key or throws a {@link com.fsoft.bn.NoSuchEnrolmentException} if it could not be found.
	*
	* @param enrolment_id the primary key of the enrolment
	* @return the enrolment
	* @throws com.fsoft.bn.NoSuchEnrolmentException if a enrolment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Enrolment findByPrimaryKey(
		java.lang.String enrolment_id)
		throws com.fsoft.bn.NoSuchEnrolmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrolment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enrolment_id the primary key of the enrolment
	* @return the enrolment, or <code>null</code> if a enrolment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Enrolment fetchByPrimaryKey(
		java.lang.String enrolment_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enrolments.
	*
	* @return the enrolments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Enrolment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enrolments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enrolments
	* @param end the upper bound of the range of enrolments (not inclusive)
	* @return the range of enrolments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Enrolment> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enrolments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enrolments
	* @param end the upper bound of the range of enrolments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enrolments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Enrolment> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enrolments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enrolments.
	*
	* @return the number of enrolments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}