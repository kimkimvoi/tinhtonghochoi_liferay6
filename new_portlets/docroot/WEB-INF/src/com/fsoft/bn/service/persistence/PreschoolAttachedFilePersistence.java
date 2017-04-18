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

import com.fsoft.bn.model.PreschoolAttachedFile;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the preschool attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PreschoolAttachedFilePersistenceImpl
 * @see PreschoolAttachedFileUtil
 * @generated
 */
public interface PreschoolAttachedFilePersistence extends BasePersistence<PreschoolAttachedFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PreschoolAttachedFileUtil} to access the preschool attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the preschool attached file in the entity cache if it is enabled.
	*
	* @param preschoolAttachedFile the preschool attached file
	*/
	public void cacheResult(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile);

	/**
	* Caches the preschool attached files in the entity cache if it is enabled.
	*
	* @param preschoolAttachedFiles the preschool attached files
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> preschoolAttachedFiles);

	/**
	* Creates a new preschool attached file with the primary key. Does not add the preschool attached file to the database.
	*
	* @param preschool_attached_id the primary key for the new preschool attached file
	* @return the new preschool attached file
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile create(
		java.lang.String preschool_attached_id);

	/**
	* Removes the preschool attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preschool_attached_id the primary key of the preschool attached file
	* @return the preschool attached file that was removed
	* @throws com.fsoft.bn.NoSuchPreschoolAttachedFileException if a preschool attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile remove(
		java.lang.String preschool_attached_id)
		throws com.fsoft.bn.NoSuchPreschoolAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.PreschoolAttachedFile updateImpl(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the preschool attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchPreschoolAttachedFileException} if it could not be found.
	*
	* @param preschool_attached_id the primary key of the preschool attached file
	* @return the preschool attached file
	* @throws com.fsoft.bn.NoSuchPreschoolAttachedFileException if a preschool attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile findByPrimaryKey(
		java.lang.String preschool_attached_id)
		throws com.fsoft.bn.NoSuchPreschoolAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the preschool attached file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param preschool_attached_id the primary key of the preschool attached file
	* @return the preschool attached file, or <code>null</code> if a preschool attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile fetchByPrimaryKey(
		java.lang.String preschool_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the preschool attached files.
	*
	* @return the preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the preschool attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool attached files
	* @param end the upper bound of the range of preschool attached files (not inclusive)
	* @return the range of preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the preschool attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool attached files
	* @param end the upper bound of the range of preschool attached files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the preschool attached files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of preschool attached files.
	*
	* @return the number of preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}