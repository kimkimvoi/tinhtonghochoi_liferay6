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
 * The utility for the recruitment local service. This utility wraps {@link com.fsoft.bn.service.impl.RecruitmentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentLocalService
 * @see com.fsoft.bn.service.base.RecruitmentLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.RecruitmentLocalServiceImpl
 * @generated
 */
public class RecruitmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.RecruitmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the recruitment to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment the recruitment
	* @return the recruitment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment addRecruitment(
		com.fsoft.bn.model.Recruitment recruitment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRecruitment(recruitment);
	}

	/**
	* Creates a new recruitment with the primary key. Does not add the recruitment to the database.
	*
	* @param recruitment_id the primary key for the new recruitment
	* @return the new recruitment
	*/
	public static com.fsoft.bn.model.Recruitment createRecruitment(
		java.lang.String recruitment_id) {
		return getService().createRecruitment(recruitment_id);
	}

	/**
	* Deletes the recruitment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment that was removed
	* @throws PortalException if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment deleteRecruitment(
		java.lang.String recruitment_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRecruitment(recruitment_id);
	}

	/**
	* Deletes the recruitment from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment the recruitment
	* @return the recruitment that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment deleteRecruitment(
		com.fsoft.bn.model.Recruitment recruitment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRecruitment(recruitment);
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

	public static com.fsoft.bn.model.Recruitment fetchRecruitment(
		java.lang.String recruitment_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRecruitment(recruitment_id);
	}

	/**
	* Returns the recruitment with the primary key.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment
	* @throws PortalException if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment getRecruitment(
		java.lang.String recruitment_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitment(recruitment_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.fsoft.bn.model.Recruitment> getRecruitments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitments(start, end);
	}

	/**
	* Returns the number of recruitments.
	*
	* @return the number of recruitments
	* @throws SystemException if a system exception occurred
	*/
	public static int getRecruitmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitmentsCount();
	}

	/**
	* Updates the recruitment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitment the recruitment
	* @return the recruitment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment updateRecruitment(
		com.fsoft.bn.model.Recruitment recruitment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRecruitment(recruitment);
	}

	/**
	* Updates the recruitment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitment the recruitment
	* @param merge whether to merge the recruitment with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the recruitment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment updateRecruitment(
		com.fsoft.bn.model.Recruitment recruitment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRecruitment(recruitment, merge);
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

	public static RecruitmentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RecruitmentLocalService.class.getName());

			if (invokableLocalService instanceof RecruitmentLocalService) {
				_service = (RecruitmentLocalService)invokableLocalService;
			}
			else {
				_service = new RecruitmentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RecruitmentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(RecruitmentLocalService service) {
	}

	private static RecruitmentLocalService _service;
}