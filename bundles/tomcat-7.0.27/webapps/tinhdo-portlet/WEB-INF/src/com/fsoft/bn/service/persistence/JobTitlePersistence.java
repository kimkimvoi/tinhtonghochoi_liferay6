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

import com.fsoft.bn.model.JobTitle;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the job title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see JobTitlePersistenceImpl
 * @see JobTitleUtil
 * @generated
 */
public interface JobTitlePersistence extends BasePersistence<JobTitle> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobTitleUtil} to access the job title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the job title in the entity cache if it is enabled.
	*
	* @param jobTitle the job title
	*/
	public void cacheResult(com.fsoft.bn.model.JobTitle jobTitle);

	/**
	* Caches the job titles in the entity cache if it is enabled.
	*
	* @param jobTitles the job titles
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.JobTitle> jobTitles);

	/**
	* Creates a new job title with the primary key. Does not add the job title to the database.
	*
	* @param job_title_id the primary key for the new job title
	* @return the new job title
	*/
	public com.fsoft.bn.model.JobTitle create(java.lang.String job_title_id);

	/**
	* Removes the job title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param job_title_id the primary key of the job title
	* @return the job title that was removed
	* @throws com.fsoft.bn.NoSuchJobTitleException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle remove(java.lang.String job_title_id)
		throws com.fsoft.bn.NoSuchJobTitleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.JobTitle updateImpl(
		com.fsoft.bn.model.JobTitle jobTitle, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job title with the primary key or throws a {@link com.fsoft.bn.NoSuchJobTitleException} if it could not be found.
	*
	* @param job_title_id the primary key of the job title
	* @return the job title
	* @throws com.fsoft.bn.NoSuchJobTitleException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle findByPrimaryKey(
		java.lang.String job_title_id)
		throws com.fsoft.bn.NoSuchJobTitleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the job title with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param job_title_id the primary key of the job title
	* @return the job title, or <code>null</code> if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle fetchByPrimaryKey(
		java.lang.String job_title_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the job titles.
	*
	* @return the job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.JobTitle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the job titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of job titles
	* @param end the upper bound of the range of job titles (not inclusive)
	* @return the range of job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.JobTitle> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the job titles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of job titles
	* @param end the upper bound of the range of job titles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of job titles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.JobTitle> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the job titles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of job titles.
	*
	* @return the number of job titles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}