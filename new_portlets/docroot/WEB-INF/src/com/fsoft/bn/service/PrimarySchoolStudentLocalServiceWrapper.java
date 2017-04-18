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
 * This class is a wrapper for {@link PrimarySchoolStudentLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       PrimarySchoolStudentLocalService
 * @generated
 */
public class PrimarySchoolStudentLocalServiceWrapper
	implements PrimarySchoolStudentLocalService,
		ServiceWrapper<PrimarySchoolStudentLocalService> {
	public PrimarySchoolStudentLocalServiceWrapper(
		PrimarySchoolStudentLocalService primarySchoolStudentLocalService) {
		_primarySchoolStudentLocalService = primarySchoolStudentLocalService;
	}

	/**
	* Adds the primary school student to the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolStudent the primary school student
	* @return the primary school student that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent addPrimarySchoolStudent(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.addPrimarySchoolStudent(primarySchoolStudent);
	}

	/**
	* Creates a new primary school student with the primary key. Does not add the primary school student to the database.
	*
	* @param primaryStudent_id the primary key for the new primary school student
	* @return the new primary school student
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent createPrimarySchoolStudent(
		java.lang.String primaryStudent_id) {
		return _primarySchoolStudentLocalService.createPrimarySchoolStudent(primaryStudent_id);
	}

	/**
	* Deletes the primary school student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primaryStudent_id the primary key of the primary school student
	* @return the primary school student that was removed
	* @throws PortalException if a primary school student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent deletePrimarySchoolStudent(
		java.lang.String primaryStudent_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.deletePrimarySchoolStudent(primaryStudent_id);
	}

	/**
	* Deletes the primary school student from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolStudent the primary school student
	* @return the primary school student that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent deletePrimarySchoolStudent(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.deletePrimarySchoolStudent(primarySchoolStudent);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _primarySchoolStudentLocalService.dynamicQuery();
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
		return _primarySchoolStudentLocalService.dynamicQuery(dynamicQuery);
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
		return _primarySchoolStudentLocalService.dynamicQuery(dynamicQuery,
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
		return _primarySchoolStudentLocalService.dynamicQuery(dynamicQuery,
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
		return _primarySchoolStudentLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.PrimarySchoolStudent fetchPrimarySchoolStudent(
		java.lang.String primaryStudent_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.fetchPrimarySchoolStudent(primaryStudent_id);
	}

	/**
	* Returns the primary school student with the primary key.
	*
	* @param primaryStudent_id the primary key of the primary school student
	* @return the primary school student
	* @throws PortalException if a primary school student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent getPrimarySchoolStudent(
		java.lang.String primaryStudent_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.getPrimarySchoolStudent(primaryStudent_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the primary school students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school students
	* @param end the upper bound of the range of primary school students (not inclusive)
	* @return the range of primary school students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PrimarySchoolStudent> getPrimarySchoolStudents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.getPrimarySchoolStudents(start,
			end);
	}

	/**
	* Returns the number of primary school students.
	*
	* @return the number of primary school students
	* @throws SystemException if a system exception occurred
	*/
	public int getPrimarySchoolStudentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.getPrimarySchoolStudentsCount();
	}

	/**
	* Updates the primary school student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolStudent the primary school student
	* @return the primary school student that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent updatePrimarySchoolStudent(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.updatePrimarySchoolStudent(primarySchoolStudent);
	}

	/**
	* Updates the primary school student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolStudent the primary school student
	* @param merge whether to merge the primary school student with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the primary school student that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolStudent updatePrimarySchoolStudent(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolStudentLocalService.updatePrimarySchoolStudent(primarySchoolStudent,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _primarySchoolStudentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_primarySchoolStudentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _primarySchoolStudentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PrimarySchoolStudentLocalService getWrappedPrimarySchoolStudentLocalService() {
		return _primarySchoolStudentLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPrimarySchoolStudentLocalService(
		PrimarySchoolStudentLocalService primarySchoolStudentLocalService) {
		_primarySchoolStudentLocalService = primarySchoolStudentLocalService;
	}

	public PrimarySchoolStudentLocalService getWrappedService() {
		return _primarySchoolStudentLocalService;
	}

	public void setWrappedService(
		PrimarySchoolStudentLocalService primarySchoolStudentLocalService) {
		_primarySchoolStudentLocalService = primarySchoolStudentLocalService;
	}

	private PrimarySchoolStudentLocalService _primarySchoolStudentLocalService;
}