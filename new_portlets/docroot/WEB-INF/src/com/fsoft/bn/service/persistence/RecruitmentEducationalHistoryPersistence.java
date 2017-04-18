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

import com.fsoft.bn.model.RecruitmentEducationalHistory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the recruitment educational history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentEducationalHistoryPersistenceImpl
 * @see RecruitmentEducationalHistoryUtil
 * @generated
 */
public interface RecruitmentEducationalHistoryPersistence
	extends BasePersistence<RecruitmentEducationalHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecruitmentEducationalHistoryUtil} to access the recruitment educational history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the recruitment educational history in the entity cache if it is enabled.
	*
	* @param recruitmentEducationalHistory the recruitment educational history
	*/
	public void cacheResult(
		com.fsoft.bn.model.RecruitmentEducationalHistory recruitmentEducationalHistory);

	/**
	* Caches the recruitment educational histories in the entity cache if it is enabled.
	*
	* @param recruitmentEducationalHistories the recruitment educational histories
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.RecruitmentEducationalHistory> recruitmentEducationalHistories);

	/**
	* Creates a new recruitment educational history with the primary key. Does not add the recruitment educational history to the database.
	*
	* @param recruitment_educational_history_id the primary key for the new recruitment educational history
	* @return the new recruitment educational history
	*/
	public com.fsoft.bn.model.RecruitmentEducationalHistory create(
		java.lang.String recruitment_educational_history_id);

	/**
	* Removes the recruitment educational history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_educational_history_id the primary key of the recruitment educational history
	* @return the recruitment educational history that was removed
	* @throws com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException if a recruitment educational history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentEducationalHistory remove(
		java.lang.String recruitment_educational_history_id)
		throws com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.RecruitmentEducationalHistory updateImpl(
		com.fsoft.bn.model.RecruitmentEducationalHistory recruitmentEducationalHistory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment educational history with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException} if it could not be found.
	*
	* @param recruitment_educational_history_id the primary key of the recruitment educational history
	* @return the recruitment educational history
	* @throws com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException if a recruitment educational history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentEducationalHistory findByPrimaryKey(
		java.lang.String recruitment_educational_history_id)
		throws com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment educational history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitment_educational_history_id the primary key of the recruitment educational history
	* @return the recruitment educational history, or <code>null</code> if a recruitment educational history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentEducationalHistory fetchByPrimaryKey(
		java.lang.String recruitment_educational_history_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the recruitment educational histories.
	*
	* @return the recruitment educational histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentEducationalHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the recruitment educational histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment educational histories
	* @param end the upper bound of the range of recruitment educational histories (not inclusive)
	* @return the range of recruitment educational histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentEducationalHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the recruitment educational histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment educational histories
	* @param end the upper bound of the range of recruitment educational histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recruitment educational histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentEducationalHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the recruitment educational histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of recruitment educational histories.
	*
	* @return the number of recruitment educational histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}