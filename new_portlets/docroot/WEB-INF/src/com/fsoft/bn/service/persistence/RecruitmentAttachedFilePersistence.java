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

import com.fsoft.bn.model.RecruitmentAttachedFile;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the recruitment attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentAttachedFilePersistenceImpl
 * @see RecruitmentAttachedFileUtil
 * @generated
 */
public interface RecruitmentAttachedFilePersistence extends BasePersistence<RecruitmentAttachedFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecruitmentAttachedFileUtil} to access the recruitment attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the recruitment attached file in the entity cache if it is enabled.
	*
	* @param recruitmentAttachedFile the recruitment attached file
	*/
	public void cacheResult(
		com.fsoft.bn.model.RecruitmentAttachedFile recruitmentAttachedFile);

	/**
	* Caches the recruitment attached files in the entity cache if it is enabled.
	*
	* @param recruitmentAttachedFiles the recruitment attached files
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.RecruitmentAttachedFile> recruitmentAttachedFiles);

	/**
	* Creates a new recruitment attached file with the primary key. Does not add the recruitment attached file to the database.
	*
	* @param recruitment_attached_id the primary key for the new recruitment attached file
	* @return the new recruitment attached file
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile create(
		java.lang.String recruitment_attached_id);

	/**
	* Removes the recruitment attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_attached_id the primary key of the recruitment attached file
	* @return the recruitment attached file that was removed
	* @throws com.fsoft.bn.NoSuchRecruitmentAttachedFileException if a recruitment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile remove(
		java.lang.String recruitment_attached_id)
		throws com.fsoft.bn.NoSuchRecruitmentAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.RecruitmentAttachedFile updateImpl(
		com.fsoft.bn.model.RecruitmentAttachedFile recruitmentAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentAttachedFileException} if it could not be found.
	*
	* @param recruitment_attached_id the primary key of the recruitment attached file
	* @return the recruitment attached file
	* @throws com.fsoft.bn.NoSuchRecruitmentAttachedFileException if a recruitment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile findByPrimaryKey(
		java.lang.String recruitment_attached_id)
		throws com.fsoft.bn.NoSuchRecruitmentAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment attached file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitment_attached_id the primary key of the recruitment attached file
	* @return the recruitment attached file, or <code>null</code> if a recruitment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile fetchByPrimaryKey(
		java.lang.String recruitment_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the recruitment attached files.
	*
	* @return the recruitment attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentAttachedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the recruitment attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment attached files
	* @param end the upper bound of the range of recruitment attached files (not inclusive)
	* @return the range of recruitment attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentAttachedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the recruitment attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment attached files
	* @param end the upper bound of the range of recruitment attached files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recruitment attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentAttachedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the recruitment attached files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of recruitment attached files.
	*
	* @return the number of recruitment attached files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}