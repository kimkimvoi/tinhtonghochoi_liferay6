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
 * This class is a wrapper for {@link RecruitmentProgrammingsLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentProgrammingsLocalService
 * @generated
 */
public class RecruitmentProgrammingsLocalServiceWrapper
	implements RecruitmentProgrammingsLocalService,
		ServiceWrapper<RecruitmentProgrammingsLocalService> {
	public RecruitmentProgrammingsLocalServiceWrapper(
		RecruitmentProgrammingsLocalService recruitmentProgrammingsLocalService) {
		_recruitmentProgrammingsLocalService = recruitmentProgrammingsLocalService;
	}

	/**
	* Adds the recruitment programmings to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProgrammings the recruitment programmings
	* @return the recruitment programmings that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentProgrammings addRecruitmentProgrammings(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.addRecruitmentProgrammings(recruitmentProgrammings);
	}

	/**
	* Creates a new recruitment programmings with the primary key. Does not add the recruitment programmings to the database.
	*
	* @param recruitment_programmings_id the primary key for the new recruitment programmings
	* @return the new recruitment programmings
	*/
	public com.fsoft.bn.model.RecruitmentProgrammings createRecruitmentProgrammings(
		java.lang.String recruitment_programmings_id) {
		return _recruitmentProgrammingsLocalService.createRecruitmentProgrammings(recruitment_programmings_id);
	}

	/**
	* Deletes the recruitment programmings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_programmings_id the primary key of the recruitment programmings
	* @return the recruitment programmings that was removed
	* @throws PortalException if a recruitment programmings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentProgrammings deleteRecruitmentProgrammings(
		java.lang.String recruitment_programmings_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.deleteRecruitmentProgrammings(recruitment_programmings_id);
	}

	/**
	* Deletes the recruitment programmings from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProgrammings the recruitment programmings
	* @return the recruitment programmings that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentProgrammings deleteRecruitmentProgrammings(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.deleteRecruitmentProgrammings(recruitmentProgrammings);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recruitmentProgrammingsLocalService.dynamicQuery();
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
		return _recruitmentProgrammingsLocalService.dynamicQuery(dynamicQuery);
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
		return _recruitmentProgrammingsLocalService.dynamicQuery(dynamicQuery,
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
		return _recruitmentProgrammingsLocalService.dynamicQuery(dynamicQuery,
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
		return _recruitmentProgrammingsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.RecruitmentProgrammings fetchRecruitmentProgrammings(
		java.lang.String recruitment_programmings_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.fetchRecruitmentProgrammings(recruitment_programmings_id);
	}

	/**
	* Returns the recruitment programmings with the primary key.
	*
	* @param recruitment_programmings_id the primary key of the recruitment programmings
	* @return the recruitment programmings
	* @throws PortalException if a recruitment programmings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentProgrammings getRecruitmentProgrammings(
		java.lang.String recruitment_programmings_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.getRecruitmentProgrammings(recruitment_programmings_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the recruitment programmingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment programmingses
	* @param end the upper bound of the range of recruitment programmingses (not inclusive)
	* @return the range of recruitment programmingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentProgrammings> getRecruitmentProgrammingses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.getRecruitmentProgrammingses(start,
			end);
	}

	/**
	* Returns the number of recruitment programmingses.
	*
	* @return the number of recruitment programmingses
	* @throws SystemException if a system exception occurred
	*/
	public int getRecruitmentProgrammingsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.getRecruitmentProgrammingsesCount();
	}

	/**
	* Updates the recruitment programmings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProgrammings the recruitment programmings
	* @return the recruitment programmings that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentProgrammings updateRecruitmentProgrammings(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.updateRecruitmentProgrammings(recruitmentProgrammings);
	}

	/**
	* Updates the recruitment programmings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProgrammings the recruitment programmings
	* @param merge whether to merge the recruitment programmings with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the recruitment programmings that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentProgrammings updateRecruitmentProgrammings(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentProgrammingsLocalService.updateRecruitmentProgrammings(recruitmentProgrammings,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _recruitmentProgrammingsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recruitmentProgrammingsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recruitmentProgrammingsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RecruitmentProgrammingsLocalService getWrappedRecruitmentProgrammingsLocalService() {
		return _recruitmentProgrammingsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRecruitmentProgrammingsLocalService(
		RecruitmentProgrammingsLocalService recruitmentProgrammingsLocalService) {
		_recruitmentProgrammingsLocalService = recruitmentProgrammingsLocalService;
	}

	public RecruitmentProgrammingsLocalService getWrappedService() {
		return _recruitmentProgrammingsLocalService;
	}

	public void setWrappedService(
		RecruitmentProgrammingsLocalService recruitmentProgrammingsLocalService) {
		_recruitmentProgrammingsLocalService = recruitmentProgrammingsLocalService;
	}

	private RecruitmentProgrammingsLocalService _recruitmentProgrammingsLocalService;
}