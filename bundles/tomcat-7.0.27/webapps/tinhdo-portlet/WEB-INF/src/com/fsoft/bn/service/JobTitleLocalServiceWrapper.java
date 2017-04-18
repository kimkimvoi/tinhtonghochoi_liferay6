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

package com.fsoft.bn.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link JobTitleLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       JobTitleLocalService
 * @generated
 */
public class JobTitleLocalServiceWrapper implements JobTitleLocalService,
	ServiceWrapper<JobTitleLocalService> {
	public JobTitleLocalServiceWrapper(
		JobTitleLocalService jobTitleLocalService) {
		_jobTitleLocalService = jobTitleLocalService;
	}

	/**
	* Adds the job title to the database. Also notifies the appropriate model listeners.
	*
	* @param jobTitle the job title
	* @return the job title that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle addJobTitle(
		com.fsoft.bn.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.addJobTitle(jobTitle);
	}

	/**
	* Creates a new job title with the primary key. Does not add the job title to the database.
	*
	* @param job_title_id the primary key for the new job title
	* @return the new job title
	*/
	public com.fsoft.bn.model.JobTitle createJobTitle(
		java.lang.String job_title_id) {
		return _jobTitleLocalService.createJobTitle(job_title_id);
	}

	/**
	* Deletes the job title with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param job_title_id the primary key of the job title
	* @return the job title that was removed
	* @throws PortalException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle deleteJobTitle(
		java.lang.String job_title_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.deleteJobTitle(job_title_id);
	}

	/**
	* Deletes the job title from the database. Also notifies the appropriate model listeners.
	*
	* @param jobTitle the job title
	* @return the job title that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle deleteJobTitle(
		com.fsoft.bn.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.deleteJobTitle(jobTitle);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobTitleLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.JobTitle fetchJobTitle(
		java.lang.String job_title_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.fetchJobTitle(job_title_id);
	}

	/**
	* Returns the job title with the primary key.
	*
	* @param job_title_id the primary key of the job title
	* @return the job title
	* @throws PortalException if a job title with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle getJobTitle(
		java.lang.String job_title_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.getJobTitle(job_title_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.fsoft.bn.model.JobTitle> getJobTitles(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.getJobTitles(start, end);
	}

	/**
	* Returns the number of job titles.
	*
	* @return the number of job titles
	* @throws SystemException if a system exception occurred
	*/
	public int getJobTitlesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.getJobTitlesCount();
	}

	/**
	* Updates the job title in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobTitle the job title
	* @return the job title that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle updateJobTitle(
		com.fsoft.bn.model.JobTitle jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.updateJobTitle(jobTitle);
	}

	/**
	* Updates the job title in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobTitle the job title
	* @param merge whether to merge the job title with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the job title that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.JobTitle updateJobTitle(
		com.fsoft.bn.model.JobTitle jobTitle, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitleLocalService.updateJobTitle(jobTitle, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _jobTitleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jobTitleLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jobTitleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public JobTitleLocalService getWrappedJobTitleLocalService() {
		return _jobTitleLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedJobTitleLocalService(
		JobTitleLocalService jobTitleLocalService) {
		_jobTitleLocalService = jobTitleLocalService;
	}

	public JobTitleLocalService getWrappedService() {
		return _jobTitleLocalService;
	}

	public void setWrappedService(JobTitleLocalService jobTitleLocalService) {
		_jobTitleLocalService = jobTitleLocalService;
	}

	private JobTitleLocalService _jobTitleLocalService;
}