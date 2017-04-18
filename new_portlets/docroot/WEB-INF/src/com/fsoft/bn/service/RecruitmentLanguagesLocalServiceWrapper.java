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
 * This class is a wrapper for {@link RecruitmentLanguagesLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentLanguagesLocalService
 * @generated
 */
public class RecruitmentLanguagesLocalServiceWrapper
	implements RecruitmentLanguagesLocalService,
		ServiceWrapper<RecruitmentLanguagesLocalService> {
	public RecruitmentLanguagesLocalServiceWrapper(
		RecruitmentLanguagesLocalService recruitmentLanguagesLocalService) {
		_recruitmentLanguagesLocalService = recruitmentLanguagesLocalService;
	}

	/**
	* Adds the recruitment languages to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentLanguages the recruitment languages
	* @return the recruitment languages that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages addRecruitmentLanguages(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.addRecruitmentLanguages(recruitmentLanguages);
	}

	/**
	* Creates a new recruitment languages with the primary key. Does not add the recruitment languages to the database.
	*
	* @param recruitment_languages_id the primary key for the new recruitment languages
	* @return the new recruitment languages
	*/
	public com.fsoft.bn.model.RecruitmentLanguages createRecruitmentLanguages(
		java.lang.String recruitment_languages_id) {
		return _recruitmentLanguagesLocalService.createRecruitmentLanguages(recruitment_languages_id);
	}

	/**
	* Deletes the recruitment languages with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_languages_id the primary key of the recruitment languages
	* @return the recruitment languages that was removed
	* @throws PortalException if a recruitment languages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages deleteRecruitmentLanguages(
		java.lang.String recruitment_languages_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.deleteRecruitmentLanguages(recruitment_languages_id);
	}

	/**
	* Deletes the recruitment languages from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentLanguages the recruitment languages
	* @return the recruitment languages that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages deleteRecruitmentLanguages(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.deleteRecruitmentLanguages(recruitmentLanguages);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recruitmentLanguagesLocalService.dynamicQuery();
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
		return _recruitmentLanguagesLocalService.dynamicQuery(dynamicQuery);
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
		return _recruitmentLanguagesLocalService.dynamicQuery(dynamicQuery,
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
		return _recruitmentLanguagesLocalService.dynamicQuery(dynamicQuery,
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
		return _recruitmentLanguagesLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.RecruitmentLanguages fetchRecruitmentLanguages(
		java.lang.String recruitment_languages_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.fetchRecruitmentLanguages(recruitment_languages_id);
	}

	/**
	* Returns the recruitment languages with the primary key.
	*
	* @param recruitment_languages_id the primary key of the recruitment languages
	* @return the recruitment languages
	* @throws PortalException if a recruitment languages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages getRecruitmentLanguages(
		java.lang.String recruitment_languages_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.getRecruitmentLanguages(recruitment_languages_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the recruitment languageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment languageses
	* @param end the upper bound of the range of recruitment languageses (not inclusive)
	* @return the range of recruitment languageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentLanguages> getRecruitmentLanguageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.getRecruitmentLanguageses(start,
			end);
	}

	/**
	* Returns the number of recruitment languageses.
	*
	* @return the number of recruitment languageses
	* @throws SystemException if a system exception occurred
	*/
	public int getRecruitmentLanguagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.getRecruitmentLanguagesesCount();
	}

	/**
	* Updates the recruitment languages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentLanguages the recruitment languages
	* @return the recruitment languages that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages updateRecruitmentLanguages(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.updateRecruitmentLanguages(recruitmentLanguages);
	}

	/**
	* Updates the recruitment languages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentLanguages the recruitment languages
	* @param merge whether to merge the recruitment languages with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the recruitment languages that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages updateRecruitmentLanguages(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _recruitmentLanguagesLocalService.updateRecruitmentLanguages(recruitmentLanguages,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _recruitmentLanguagesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_recruitmentLanguagesLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _recruitmentLanguagesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RecruitmentLanguagesLocalService getWrappedRecruitmentLanguagesLocalService() {
		return _recruitmentLanguagesLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRecruitmentLanguagesLocalService(
		RecruitmentLanguagesLocalService recruitmentLanguagesLocalService) {
		_recruitmentLanguagesLocalService = recruitmentLanguagesLocalService;
	}

	public RecruitmentLanguagesLocalService getWrappedService() {
		return _recruitmentLanguagesLocalService;
	}

	public void setWrappedService(
		RecruitmentLanguagesLocalService recruitmentLanguagesLocalService) {
		_recruitmentLanguagesLocalService = recruitmentLanguagesLocalService;
	}

	private RecruitmentLanguagesLocalService _recruitmentLanguagesLocalService;
}