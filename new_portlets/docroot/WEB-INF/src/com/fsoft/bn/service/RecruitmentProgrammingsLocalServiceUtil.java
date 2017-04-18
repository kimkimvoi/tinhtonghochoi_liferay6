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
 * The utility for the recruitment programmings local service. This utility wraps {@link com.fsoft.bn.service.impl.RecruitmentProgrammingsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentProgrammingsLocalService
 * @see com.fsoft.bn.service.base.RecruitmentProgrammingsLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.RecruitmentProgrammingsLocalServiceImpl
 * @generated
 */
public class RecruitmentProgrammingsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.RecruitmentProgrammingsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the recruitment programmings to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProgrammings the recruitment programmings
	* @return the recruitment programmings that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentProgrammings addRecruitmentProgrammings(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRecruitmentProgrammings(recruitmentProgrammings);
	}

	/**
	* Creates a new recruitment programmings with the primary key. Does not add the recruitment programmings to the database.
	*
	* @param recruitment_programmings_id the primary key for the new recruitment programmings
	* @return the new recruitment programmings
	*/
	public static com.fsoft.bn.model.RecruitmentProgrammings createRecruitmentProgrammings(
		java.lang.String recruitment_programmings_id) {
		return getService()
				   .createRecruitmentProgrammings(recruitment_programmings_id);
	}

	/**
	* Deletes the recruitment programmings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_programmings_id the primary key of the recruitment programmings
	* @return the recruitment programmings that was removed
	* @throws PortalException if a recruitment programmings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentProgrammings deleteRecruitmentProgrammings(
		java.lang.String recruitment_programmings_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteRecruitmentProgrammings(recruitment_programmings_id);
	}

	/**
	* Deletes the recruitment programmings from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProgrammings the recruitment programmings
	* @return the recruitment programmings that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentProgrammings deleteRecruitmentProgrammings(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteRecruitmentProgrammings(recruitmentProgrammings);
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

	public static com.fsoft.bn.model.RecruitmentProgrammings fetchRecruitmentProgrammings(
		java.lang.String recruitment_programmings_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchRecruitmentProgrammings(recruitment_programmings_id);
	}

	/**
	* Returns the recruitment programmings with the primary key.
	*
	* @param recruitment_programmings_id the primary key of the recruitment programmings
	* @return the recruitment programmings
	* @throws PortalException if a recruitment programmings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentProgrammings getRecruitmentProgrammings(
		java.lang.String recruitment_programmings_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getRecruitmentProgrammings(recruitment_programmings_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.fsoft.bn.model.RecruitmentProgrammings> getRecruitmentProgrammingses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitmentProgrammingses(start, end);
	}

	/**
	* Returns the number of recruitment programmingses.
	*
	* @return the number of recruitment programmingses
	* @throws SystemException if a system exception occurred
	*/
	public static int getRecruitmentProgrammingsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitmentProgrammingsesCount();
	}

	/**
	* Updates the recruitment programmings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProgrammings the recruitment programmings
	* @return the recruitment programmings that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentProgrammings updateRecruitmentProgrammings(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRecruitmentProgrammings(recruitmentProgrammings);
	}

	/**
	* Updates the recruitment programmings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentProgrammings the recruitment programmings
	* @param merge whether to merge the recruitment programmings with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the recruitment programmings that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentProgrammings updateRecruitmentProgrammings(
		com.fsoft.bn.model.RecruitmentProgrammings recruitmentProgrammings,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRecruitmentProgrammings(recruitmentProgrammings, merge);
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

	public static RecruitmentProgrammingsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RecruitmentProgrammingsLocalService.class.getName());

			if (invokableLocalService instanceof RecruitmentProgrammingsLocalService) {
				_service = (RecruitmentProgrammingsLocalService)invokableLocalService;
			}
			else {
				_service = new RecruitmentProgrammingsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RecruitmentProgrammingsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(RecruitmentProgrammingsLocalService service) {
	}

	private static RecruitmentProgrammingsLocalService _service;
}