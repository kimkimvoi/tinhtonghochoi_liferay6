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
 * This class is a wrapper for {@link RecruitmentLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentLocalService
 * @generated
 */
public class RecruitmentLocalServiceWrapper implements RecruitmentLocalService,
	ServiceWrapper<RecruitmentLocalService> {
	public RecruitmentLocalServiceWrapper(
		RecruitmentLocalService recruitmentLocalService) {
		_recruitmentLocalService = recruitmentLocalService;
	}

	/**
	* Adds the recruitment to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment the recruitment
	* @return the recruitment that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment addRecruitment(
		com.fsoft.bn.model.Recruitment recruitment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.addRecruitment(recruitment);
	}

	/**
	* Creates a new recruitment with the primary key. Does not add the recruitment to the database.
	*
	* @param recruitment_id the primary key for the new recruitment
	* @return the new recruitment
	*/
	public com.fsoft.bn.model.Recruitment createRecruitment(
		java.lang.String recruitment_id) {
		return _recruitmentLocalService.createRecruitment(recruitment_id);
	}

	/**
	* Deletes the recruitment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment that was removed
	* @throws PortalException if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment deleteRecruitment(
		java.lang.String recruitment_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.deleteRecruitment(recruitment_id);
	}

	/**
	* Deletes the recruitment from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment the recruitment
	* @return the recruitment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment deleteRecruitment(
		com.fsoft.bn.model.Recruitment recruitment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.deleteRecruitment(recruitment);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recruitmentLocalService.dynamicQuery();
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
		return _recruitmentLocalService.dynamicQuery(dynamicQuery);
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
		return _recruitmentLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _recruitmentLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _recruitmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.Recruitment fetchRecruitment(
		java.lang.String recruitment_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.fetchRecruitment(recruitment_id);
	}

	/**
	* Returns the recruitment with the primary key.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment
	* @throws PortalException if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment getRecruitment(
		java.lang.String recruitment_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.getRecruitment(recruitment_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.fsoft.bn.model.Recruitment> getRecruitments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.getRecruitments(start, end);
	}

	/**
	* Returns the number of recruitments.
	*
	* @return the number of recruitments
	* @throws SystemException if a system exception occurred
	*/
	public int getRecruitmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.getRecruitmentsCount();
	}

	/**
	* Updates the recruitment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitment the recruitment
	* @return the recruitment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment updateRecruitment(
		com.fsoft.bn.model.Recruitment recruitment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.updateRecruitment(recruitment);
	}

	/**
	* Updates the recruitment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitment the recruitment
	* @param merge whether to merge the recruitment with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the recruitment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Recruitment updateRecruitment(
		com.fsoft.bn.model.Recruitment recruitment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLocalService.updateRecruitment(recruitment, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _recruitmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recruitmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recruitmentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RecruitmentLocalService getWrappedRecruitmentLocalService() {
		return _recruitmentLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRecruitmentLocalService(
		RecruitmentLocalService recruitmentLocalService) {
		_recruitmentLocalService = recruitmentLocalService;
	}

	public RecruitmentLocalService getWrappedService() {
		return _recruitmentLocalService;
	}

	public void setWrappedService(
		RecruitmentLocalService recruitmentLocalService) {
		_recruitmentLocalService = recruitmentLocalService;
	}

	private RecruitmentLocalService _recruitmentLocalService;
}