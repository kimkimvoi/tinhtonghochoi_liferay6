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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the recruitment languages local service. This utility wraps {@link com.fsoft.bn.service.impl.RecruitmentLanguagesLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentLanguagesLocalService
 * @see com.fsoft.bn.service.base.RecruitmentLanguagesLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.RecruitmentLanguagesLocalServiceImpl
 * @generated
 */
public class RecruitmentLanguagesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.RecruitmentLanguagesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the recruitment languages to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentLanguages the recruitment languages
	* @return the recruitment languages that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentLanguages addRecruitmentLanguages(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRecruitmentLanguages(recruitmentLanguages);
	}

	/**
	* Creates a new recruitment languages with the primary key. Does not add the recruitment languages to the database.
	*
	* @param recruitment_languages_id the primary key for the new recruitment languages
	* @return the new recruitment languages
	*/
	public static com.fsoft.bn.model.RecruitmentLanguages createRecruitmentLanguages(
		java.lang.String recruitment_languages_id) {
		return getService().createRecruitmentLanguages(recruitment_languages_id);
	}

	/**
	* Deletes the recruitment languages with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_languages_id the primary key of the recruitment languages
	* @return the recruitment languages that was removed
	* @throws PortalException if a recruitment languages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentLanguages deleteRecruitmentLanguages(
		java.lang.String recruitment_languages_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRecruitmentLanguages(recruitment_languages_id);
	}

	/**
	* Deletes the recruitment languages from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentLanguages the recruitment languages
	* @return the recruitment languages that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentLanguages deleteRecruitmentLanguages(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRecruitmentLanguages(recruitmentLanguages);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.fsoft.bn.model.RecruitmentLanguages fetchRecruitmentLanguages(
		java.lang.String recruitment_languages_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRecruitmentLanguages(recruitment_languages_id);
	}

	/**
	* Returns the recruitment languages with the primary key.
	*
	* @param recruitment_languages_id the primary key of the recruitment languages
	* @return the recruitment languages
	* @throws PortalException if a recruitment languages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentLanguages getRecruitmentLanguages(
		java.lang.String recruitment_languages_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitmentLanguages(recruitment_languages_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.fsoft.bn.model.RecruitmentLanguages> getRecruitmentLanguageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitmentLanguageses(start, end);
	}

	/**
	* Returns the number of recruitment languageses.
	*
	* @return the number of recruitment languageses
	* @throws SystemException if a system exception occurred
	*/
	public static int getRecruitmentLanguagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitmentLanguagesesCount();
	}

	/**
	* Updates the recruitment languages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentLanguages the recruitment languages
	* @return the recruitment languages that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentLanguages updateRecruitmentLanguages(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRecruitmentLanguages(recruitmentLanguages);
	}

	/**
	* Updates the recruitment languages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentLanguages the recruitment languages
	* @param merge whether to merge the recruitment languages with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the recruitment languages that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentLanguages updateRecruitmentLanguages(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRecruitmentLanguages(recruitmentLanguages, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static RecruitmentLanguagesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RecruitmentLanguagesLocalService.class.getName());

			if (invokableLocalService instanceof RecruitmentLanguagesLocalService) {
				_service = (RecruitmentLanguagesLocalService)invokableLocalService;
			}
			else {
				_service = new RecruitmentLanguagesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RecruitmentLanguagesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(RecruitmentLanguagesLocalService service) {
	}

	private static RecruitmentLanguagesLocalService _service;
}