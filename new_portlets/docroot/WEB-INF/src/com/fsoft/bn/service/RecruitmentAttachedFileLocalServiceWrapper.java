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
 * This class is a wrapper for {@link RecruitmentAttachedFileLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentAttachedFileLocalService
 * @generated
 */
public class RecruitmentAttachedFileLocalServiceWrapper
	implements RecruitmentAttachedFileLocalService,
		ServiceWrapper<RecruitmentAttachedFileLocalService> {
	public RecruitmentAttachedFileLocalServiceWrapper(
		RecruitmentAttachedFileLocalService recruitmentAttachedFileLocalService) {
		_recruitmentAttachedFileLocalService = recruitmentAttachedFileLocalService;
	}

	/**
	* Adds the recruitment attached file to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentAttachedFile the recruitment attached file
	* @return the recruitment attached file that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile addRecruitmentAttachedFile(
		com.fsoft.bn.model.RecruitmentAttachedFile recruitmentAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.addRecruitmentAttachedFile(recruitmentAttachedFile);
	}

	/**
	* Creates a new recruitment attached file with the primary key. Does not add the recruitment attached file to the database.
	*
	* @param recruitment_attached_id the primary key for the new recruitment attached file
	* @return the new recruitment attached file
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile createRecruitmentAttachedFile(
		java.lang.String recruitment_attached_id) {
		return _recruitmentAttachedFileLocalService.createRecruitmentAttachedFile(recruitment_attached_id);
	}

	/**
	* Deletes the recruitment attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_attached_id the primary key of the recruitment attached file
	* @return the recruitment attached file that was removed
	* @throws PortalException if a recruitment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile deleteRecruitmentAttachedFile(
		java.lang.String recruitment_attached_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.deleteRecruitmentAttachedFile(recruitment_attached_id);
	}

	/**
	* Deletes the recruitment attached file from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentAttachedFile the recruitment attached file
	* @return the recruitment attached file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile deleteRecruitmentAttachedFile(
		com.fsoft.bn.model.RecruitmentAttachedFile recruitmentAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.deleteRecruitmentAttachedFile(recruitmentAttachedFile);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recruitmentAttachedFileLocalService.dynamicQuery();
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
		return _recruitmentAttachedFileLocalService.dynamicQuery(dynamicQuery);
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
		return _recruitmentAttachedFileLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _recruitmentAttachedFileLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _recruitmentAttachedFileLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.RecruitmentAttachedFile fetchRecruitmentAttachedFile(
		java.lang.String recruitment_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.fetchRecruitmentAttachedFile(recruitment_attached_id);
	}

	/**
	* Returns the recruitment attached file with the primary key.
	*
	* @param recruitment_attached_id the primary key of the recruitment attached file
	* @return the recruitment attached file
	* @throws PortalException if a recruitment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile getRecruitmentAttachedFile(
		java.lang.String recruitment_attached_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.getRecruitmentAttachedFile(recruitment_attached_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.fsoft.bn.model.RecruitmentAttachedFile> getRecruitmentAttachedFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.getRecruitmentAttachedFiles(start,
			end);
	}

	/**
	* Returns the number of recruitment attached files.
	*
	* @return the number of recruitment attached files
	* @throws SystemException if a system exception occurred
	*/
	public int getRecruitmentAttachedFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.getRecruitmentAttachedFilesCount();
	}

	/**
	* Updates the recruitment attached file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentAttachedFile the recruitment attached file
	* @return the recruitment attached file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile updateRecruitmentAttachedFile(
		com.fsoft.bn.model.RecruitmentAttachedFile recruitmentAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.updateRecruitmentAttachedFile(recruitmentAttachedFile);
	}

	/**
	* Updates the recruitment attached file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentAttachedFile the recruitment attached file
	* @param merge whether to merge the recruitment attached file with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the recruitment attached file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentAttachedFile updateRecruitmentAttachedFile(
		com.fsoft.bn.model.RecruitmentAttachedFile recruitmentAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentAttachedFileLocalService.updateRecruitmentAttachedFile(recruitmentAttachedFile,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _recruitmentAttachedFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recruitmentAttachedFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recruitmentAttachedFileLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RecruitmentAttachedFileLocalService getWrappedRecruitmentAttachedFileLocalService() {
		return _recruitmentAttachedFileLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRecruitmentAttachedFileLocalService(
		RecruitmentAttachedFileLocalService recruitmentAttachedFileLocalService) {
		_recruitmentAttachedFileLocalService = recruitmentAttachedFileLocalService;
	}

	public RecruitmentAttachedFileLocalService getWrappedService() {
		return _recruitmentAttachedFileLocalService;
	}

	public void setWrappedService(
		RecruitmentAttachedFileLocalService recruitmentAttachedFileLocalService) {
		_recruitmentAttachedFileLocalService = recruitmentAttachedFileLocalService;
	}

	private RecruitmentAttachedFileLocalService _recruitmentAttachedFileLocalService;
}