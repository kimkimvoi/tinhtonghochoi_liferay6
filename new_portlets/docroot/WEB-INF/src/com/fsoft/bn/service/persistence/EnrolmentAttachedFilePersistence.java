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

import com.fsoft.bn.model.EnrolmentAttachedFile;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the enrolment attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see EnrolmentAttachedFilePersistenceImpl
 * @see EnrolmentAttachedFileUtil
 * @generated
 */
public interface EnrolmentAttachedFilePersistence extends BasePersistence<EnrolmentAttachedFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EnrolmentAttachedFileUtil} to access the enrolment attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the enrolment attached file in the entity cache if it is enabled.
	*
	* @param enrolmentAttachedFile the enrolment attached file
	*/
	public void cacheResult(
		com.fsoft.bn.model.EnrolmentAttachedFile enrolmentAttachedFile);

	/**
	* Caches the enrolment attached files in the entity cache if it is enabled.
	*
	* @param enrolmentAttachedFiles the enrolment attached files
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.EnrolmentAttachedFile> enrolmentAttachedFiles);

	/**
	* Creates a new enrolment attached file with the primary key. Does not add the enrolment attached file to the database.
	*
	* @param enrolment_attached_id the primary key for the new enrolment attached file
	* @return the new enrolment attached file
	*/
	public com.fsoft.bn.model.EnrolmentAttachedFile create(
		java.lang.String enrolment_attached_id);

	/**
	* Removes the enrolment attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enrolment_attached_id the primary key of the enrolment attached file
	* @return the enrolment attached file that was removed
	* @throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException if a enrolment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.EnrolmentAttachedFile remove(
		java.lang.String enrolment_attached_id)
		throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.EnrolmentAttachedFile updateImpl(
		com.fsoft.bn.model.EnrolmentAttachedFile enrolmentAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrolment attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchEnrolmentAttachedFileException} if it could not be found.
	*
	* @param enrolment_attached_id the primary key of the enrolment attached file
	* @return the enrolment attached file
	* @throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException if a enrolment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.EnrolmentAttachedFile findByPrimaryKey(
		java.lang.String enrolment_attached_id)
		throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the enrolment attached file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enrolment_attached_id the primary key of the enrolment attached file
	* @return the enrolment attached file, or <code>null</code> if a enrolment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.EnrolmentAttachedFile fetchByPrimaryKey(
		java.lang.String enrolment_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the enrolment attached files.
	*
	* @return the enrolment attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.EnrolmentAttachedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the enrolment attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enrolment attached files
	* @param end the upper bound of the range of enrolment attached files (not inclusive)
	* @return the range of enrolment attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.EnrolmentAttachedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the enrolment attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enrolment attached files
	* @param end the upper bound of the range of enrolment attached files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enrolment attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.EnrolmentAttachedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the enrolment attached files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of enrolment attached files.
	*
	* @return the number of enrolment attached files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}