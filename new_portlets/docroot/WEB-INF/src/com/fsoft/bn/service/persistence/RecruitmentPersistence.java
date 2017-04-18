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

import com.fsoft.bn.model.Recruitment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the recruitment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentPersistenceImpl
 * @see RecruitmentUtil
 * @generated
 */
public interface RecruitmentPersistence extends BasePersistence<Recruitment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecruitmentUtil} to access the recruitment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the recruitment in the entity cache if it is enabled.
	*
	* @param recruitment the recruitment
	*/
	public void cacheResult(com.fsoft.bn.model.Recruitment recruitment);

	/**
	* Caches the recruitments in the entity cache if it is enabled.
	*
	* @param recruitments the recruitments
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.Recruitment> recruitments);

	/**
	* Creates a new recruitment with the primary key. Does not add the recruitment to the database.
	*
	* @param recruitment_id the primary key for the new recruitment
	* @return the new recruitment
	*/
	public com.fsoft.bn.model.Recruitment create(
		java.lang.String recruitment_id);

	/**
	* Removes the recruitment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment that was removed
	* @throws com.fsoft.bn.NoSuchRecruitmentException if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment remove(
		java.lang.String recruitment_id)
		throws com.fsoft.bn.NoSuchRecruitmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.Recruitment updateImpl(
		com.fsoft.bn.model.Recruitment recruitment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentException} if it could not be found.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment
	* @throws com.fsoft.bn.NoSuchRecruitmentException if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment findByPrimaryKey(
		java.lang.String recruitment_id)
		throws com.fsoft.bn.NoSuchRecruitmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment, or <code>null</code> if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment fetchByPrimaryKey(
		java.lang.String recruitment_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the recruitments.
	*
	* @return the recruitments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Recruitment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the recruitments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitments
	* @param end the upper bound of the range of recruitments (not inclusive)
	* @return the range of recruitments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Recruitment> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the recruitments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitments
	* @param end the upper bound of the range of recruitments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recruitments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Recruitment> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the recruitments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of recruitments.
	*
	* @return the number of recruitments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}