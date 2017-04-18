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
 * The utility for the recruitment training courses local service. This utility wraps {@link com.fsoft.bn.service.impl.RecruitmentTrainingCoursesLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentTrainingCoursesLocalService
 * @see com.fsoft.bn.service.base.RecruitmentTrainingCoursesLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.RecruitmentTrainingCoursesLocalServiceImpl
 * @generated
 */
public class RecruitmentTrainingCoursesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.RecruitmentTrainingCoursesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the recruitment training courses to the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentTrainingCourses the recruitment training courses
	* @return the recruitment training courses that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentTrainingCourses addRecruitmentTrainingCourses(
		com.fsoft.bn.model.RecruitmentTrainingCourses recruitmentTrainingCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addRecruitmentTrainingCourses(recruitmentTrainingCourses);
	}

	/**
	* Creates a new recruitment training courses with the primary key. Does not add the recruitment training courses to the database.
	*
	* @param recruitment_training_courses_id the primary key for the new recruitment training courses
	* @return the new recruitment training courses
	*/
	public static com.fsoft.bn.model.RecruitmentTrainingCourses createRecruitmentTrainingCourses(
		java.lang.String recruitment_training_courses_id) {
		return getService()
				   .createRecruitmentTrainingCourses(recruitment_training_courses_id);
	}

	/**
	* Deletes the recruitment training courses with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_training_courses_id the primary key of the recruitment training courses
	* @return the recruitment training courses that was removed
	* @throws PortalException if a recruitment training courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentTrainingCourses deleteRecruitmentTrainingCourses(
		java.lang.String recruitment_training_courses_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteRecruitmentTrainingCourses(recruitment_training_courses_id);
	}

	/**
	* Deletes the recruitment training courses from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitmentTrainingCourses the recruitment training courses
	* @return the recruitment training courses that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentTrainingCourses deleteRecruitmentTrainingCourses(
		com.fsoft.bn.model.RecruitmentTrainingCourses recruitmentTrainingCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteRecruitmentTrainingCourses(recruitmentTrainingCourses);
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

	public static com.fsoft.bn.model.RecruitmentTrainingCourses fetchRecruitmentTrainingCourses(
		java.lang.String recruitment_training_courses_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchRecruitmentTrainingCourses(recruitment_training_courses_id);
	}

	/**
	* Returns the recruitment training courses with the primary key.
	*
	* @param recruitment_training_courses_id the primary key of the recruitment training courses
	* @return the recruitment training courses
	* @throws PortalException if a recruitment training courses with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentTrainingCourses getRecruitmentTrainingCourses(
		java.lang.String recruitment_training_courses_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getRecruitmentTrainingCourses(recruitment_training_courses_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the recruitment training courseses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment training courseses
	* @param end the upper bound of the range of recruitment training courseses (not inclusive)
	* @return the range of recruitment training courseses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.RecruitmentTrainingCourses> getRecruitmentTrainingCourseses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitmentTrainingCourseses(start, end);
	}

	/**
	* Returns the number of recruitment training courseses.
	*
	* @return the number of recruitment training courseses
	* @throws SystemException if a system exception occurred
	*/
	public static int getRecruitmentTrainingCoursesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRecruitmentTrainingCoursesesCount();
	}

	/**
	* Updates the recruitment training courses in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentTrainingCourses the recruitment training courses
	* @return the recruitment training courses that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentTrainingCourses updateRecruitmentTrainingCourses(
		com.fsoft.bn.model.RecruitmentTrainingCourses recruitmentTrainingCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRecruitmentTrainingCourses(recruitmentTrainingCourses);
	}

	/**
	* Updates the recruitment training courses in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param recruitmentTrainingCourses the recruitment training courses
	* @param merge whether to merge the recruitment training courses with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the recruitment training courses that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.RecruitmentTrainingCourses updateRecruitmentTrainingCourses(
		com.fsoft.bn.model.RecruitmentTrainingCourses recruitmentTrainingCourses,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateRecruitmentTrainingCourses(recruitmentTrainingCourses,
			merge);
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

	public static RecruitmentTrainingCoursesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RecruitmentTrainingCoursesLocalService.class.getName());

			if (invokableLocalService instanceof RecruitmentTrainingCoursesLocalService) {
				_service = (RecruitmentTrainingCoursesLocalService)invokableLocalService;
			}
			else {
				_service = new RecruitmentTrainingCoursesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RecruitmentTrainingCoursesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(RecruitmentTrainingCoursesLocalService service) {
	}

	private static RecruitmentTrainingCoursesLocalService _service;
}