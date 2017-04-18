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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the job title service. This utility wraps {@link JobTitlePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see JobTitlePersistence
 * @see JobTitlePersistenceImpl
 * @generated
 */
public class JobTitleUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(JobTitle jobTitle) {
		getPersistence().clearCache(jobTitle);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JobTitle> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static JobTitle update(JobTitle jobTitle, boolean merge)
		throws SystemException {
		return getPersistence().update(jobTitle, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static JobTitle update(JobTitle jobTitle, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(jobTitle, merge, serviceContext);
	}

	/**
	* Caches the job title in the entity cache if it is enabled.
	*
	* @param jobTitle the job title
	*/
	public static void cacheResult(com.fsoft.bn.model.JobTitle jobTitle) {
		getPersistence().cacheResult(jobTitle);
	}

	/**
	* Caches the job titles in the entity cache if it is enabled.
	*
	* @param jobTitles the job titles
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.JobTitle> jobTitles) {
		getPersistence().cacheResult(jobTitles);
	}

	/**
	* Creates a new job title with the primary key. Does not add the job title to the database.
	*
	* @param job_title_id the primary key for the new job title
	* @return the new job title
	*/
	public static com.fsoft.bn.model.JobTitle create(
		java.lang.String job_title_id) {
		return getPersistence().create(job_title_id);
	}

	/**
	* Removes the job title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param job_title_id the primary key of the job title
	* @return the job title that was removed
	* @throws com.fsoft.bn.NoSuchJobTitleException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.JobTitle remove(
		java.lang.String job_title_id)
		throws com.fsoft.bn.NoSuchJobTitleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(job_title_id);
	}

	public static com.fsoft.bn.model.JobTitle updateImpl(
		com.fsoft.bn.model.JobTitle jobTitle, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(jobTitle, merge);
	}

	/**
	* Returns the job title with the primary key or throws a {@link com.fsoft.bn.NoSuchJobTitleException} if it could not be found.
	*
	* @param job_title_id the primary key of the job title
	* @return the job title
	* @throws com.fsoft.bn.NoSuchJobTitleException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.JobTitle findByPrimaryKey(
		java.lang.String job_title_id)
		throws com.fsoft.bn.NoSuchJobTitleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(job_title_id);
	}

	/**
	* Returns the job title with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param job_title_id the primary key of the job title
	* @return the job title, or <code>null</code> if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.JobTitle fetchByPrimaryKey(
		java.lang.String job_title_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(job_title_id);
	}

	/**
	* Returns all the job titles.
	*
	* @return the job titles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.JobTitle> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.fsoft.bn.model.JobTitle> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.JobTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the job titles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of job titles.
	*
	* @return the number of job titles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static JobTitlePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (JobTitlePersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					JobTitlePersistence.class.getName());

			ReferenceRegistry.registerReference(JobTitleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(JobTitlePersistence persistence) {
	}

	private static JobTitlePersistence _persistence;
}