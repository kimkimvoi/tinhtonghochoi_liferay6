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
 * This class is a wrapper for {@link PrimarySchoolAttachedFileLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       PrimarySchoolAttachedFileLocalService
 * @generated
 */
public class PrimarySchoolAttachedFileLocalServiceWrapper
	implements PrimarySchoolAttachedFileLocalService,
		ServiceWrapper<PrimarySchoolAttachedFileLocalService> {
	public PrimarySchoolAttachedFileLocalServiceWrapper(
		PrimarySchoolAttachedFileLocalService primarySchoolAttachedFileLocalService) {
		_primarySchoolAttachedFileLocalService = primarySchoolAttachedFileLocalService;
	}

	/**
	* Adds the primary school attached file to the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	* @return the primary school attached file that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolAttachedFile addPrimarySchoolAttachedFile(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.addPrimarySchoolAttachedFile(primarySchoolAttachedFile);
	}

	/**
	* Creates a new primary school attached file with the primary key. Does not add the primary school attached file to the database.
	*
	* @param primarySchool_attached_id the primary key for the new primary school attached file
	* @return the new primary school attached file
	*/
	public com.fsoft.bn.model.PrimarySchoolAttachedFile createPrimarySchoolAttachedFile(
		java.lang.String primarySchool_attached_id) {
		return _primarySchoolAttachedFileLocalService.createPrimarySchoolAttachedFile(primarySchool_attached_id);
	}

	/**
	* Deletes the primary school attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchool_attached_id the primary key of the primary school attached file
	* @return the primary school attached file that was removed
	* @throws PortalException if a primary school attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolAttachedFile deletePrimarySchoolAttachedFile(
		java.lang.String primarySchool_attached_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.deletePrimarySchoolAttachedFile(primarySchool_attached_id);
	}

	/**
	* Deletes the primary school attached file from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	* @return the primary school attached file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolAttachedFile deletePrimarySchoolAttachedFile(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.deletePrimarySchoolAttachedFile(primarySchoolAttachedFile);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _primarySchoolAttachedFileLocalService.dynamicQuery();
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
		return _primarySchoolAttachedFileLocalService.dynamicQuery(dynamicQuery);
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
		return _primarySchoolAttachedFileLocalService.dynamicQuery(dynamicQuery,
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
		return _primarySchoolAttachedFileLocalService.dynamicQuery(dynamicQuery,
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
		return _primarySchoolAttachedFileLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.PrimarySchoolAttachedFile fetchPrimarySchoolAttachedFile(
		java.lang.String primarySchool_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.fetchPrimarySchoolAttachedFile(primarySchool_attached_id);
	}

	/**
	* Returns the primary school attached file with the primary key.
	*
	* @param primarySchool_attached_id the primary key of the primary school attached file
	* @return the primary school attached file
	* @throws PortalException if a primary school attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolAttachedFile getPrimarySchoolAttachedFile(
		java.lang.String primarySchool_attached_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.getPrimarySchoolAttachedFile(primarySchool_attached_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the primary school attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school attached files
	* @param end the upper bound of the range of primary school attached files (not inclusive)
	* @return the range of primary school attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PrimarySchoolAttachedFile> getPrimarySchoolAttachedFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.getPrimarySchoolAttachedFiles(start,
			end);
	}

	/**
	* Returns the number of primary school attached files.
	*
	* @return the number of primary school attached files
	* @throws SystemException if a system exception occurred
	*/
	public int getPrimarySchoolAttachedFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.getPrimarySchoolAttachedFilesCount();
	}

	/**
	* Updates the primary school attached file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	* @return the primary school attached file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolAttachedFile updatePrimarySchoolAttachedFile(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.updatePrimarySchoolAttachedFile(primarySchoolAttachedFile);
	}

	/**
	* Updates the primary school attached file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	* @param merge whether to merge the primary school attached file with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the primary school attached file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolAttachedFile updatePrimarySchoolAttachedFile(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolAttachedFileLocalService.updatePrimarySchoolAttachedFile(primarySchoolAttachedFile,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _primarySchoolAttachedFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_primarySchoolAttachedFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _primarySchoolAttachedFileLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PrimarySchoolAttachedFileLocalService getWrappedPrimarySchoolAttachedFileLocalService() {
		return _primarySchoolAttachedFileLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPrimarySchoolAttachedFileLocalService(
		PrimarySchoolAttachedFileLocalService primarySchoolAttachedFileLocalService) {
		_primarySchoolAttachedFileLocalService = primarySchoolAttachedFileLocalService;
	}

	public PrimarySchoolAttachedFileLocalService getWrappedService() {
		return _primarySchoolAttachedFileLocalService;
	}

	public void setWrappedService(
		PrimarySchoolAttachedFileLocalService primarySchoolAttachedFileLocalService) {
		_primarySchoolAttachedFileLocalService = primarySchoolAttachedFileLocalService;
	}

	private PrimarySchoolAttachedFileLocalService _primarySchoolAttachedFileLocalService;
}