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
 * This class is a wrapper for {@link PreschoolAttachedFileLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       PreschoolAttachedFileLocalService
 * @generated
 */
public class PreschoolAttachedFileLocalServiceWrapper
	implements PreschoolAttachedFileLocalService,
		ServiceWrapper<PreschoolAttachedFileLocalService> {
	public PreschoolAttachedFileLocalServiceWrapper(
		PreschoolAttachedFileLocalService preschoolAttachedFileLocalService) {
		_preschoolAttachedFileLocalService = preschoolAttachedFileLocalService;
	}

	/**
	* Adds the preschool attached file to the database. Also notifies the appropriate model listeners.
	*
	* @param preschoolAttachedFile the preschool attached file
	* @return the preschool attached file that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile addPreschoolAttachedFile(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.addPreschoolAttachedFile(preschoolAttachedFile);
	}

	/**
	* Creates a new preschool attached file with the primary key. Does not add the preschool attached file to the database.
	*
	* @param preschool_attached_id the primary key for the new preschool attached file
	* @return the new preschool attached file
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile createPreschoolAttachedFile(
		java.lang.String preschool_attached_id) {
		return _preschoolAttachedFileLocalService.createPreschoolAttachedFile(preschool_attached_id);
	}

	/**
	* Deletes the preschool attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preschool_attached_id the primary key of the preschool attached file
	* @return the preschool attached file that was removed
	* @throws PortalException if a preschool attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile deletePreschoolAttachedFile(
		java.lang.String preschool_attached_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.deletePreschoolAttachedFile(preschool_attached_id);
	}

	/**
	* Deletes the preschool attached file from the database. Also notifies the appropriate model listeners.
	*
	* @param preschoolAttachedFile the preschool attached file
	* @return the preschool attached file that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile deletePreschoolAttachedFile(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.deletePreschoolAttachedFile(preschoolAttachedFile);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _preschoolAttachedFileLocalService.dynamicQuery();
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
		return _preschoolAttachedFileLocalService.dynamicQuery(dynamicQuery);
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
		return _preschoolAttachedFileLocalService.dynamicQuery(dynamicQuery,
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
		return _preschoolAttachedFileLocalService.dynamicQuery(dynamicQuery,
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
		return _preschoolAttachedFileLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.PreschoolAttachedFile fetchPreschoolAttachedFile(
		java.lang.String preschool_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.fetchPreschoolAttachedFile(preschool_attached_id);
	}

	/**
	* Returns the preschool attached file with the primary key.
	*
	* @param preschool_attached_id the primary key of the preschool attached file
	* @return the preschool attached file
	* @throws PortalException if a preschool attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile getPreschoolAttachedFile(
		java.lang.String preschool_attached_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.getPreschoolAttachedFile(preschool_attached_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the preschool attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool attached files
	* @param end the upper bound of the range of preschool attached files (not inclusive)
	* @return the range of preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> getPreschoolAttachedFiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.getPreschoolAttachedFiles(start,
			end);
	}

	/**
	* Returns the number of preschool attached files.
	*
	* @return the number of preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public int getPreschoolAttachedFilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.getPreschoolAttachedFilesCount();
	}

	/**
	* Updates the preschool attached file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param preschoolAttachedFile the preschool attached file
	* @return the preschool attached file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile updatePreschoolAttachedFile(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.updatePreschoolAttachedFile(preschoolAttachedFile);
	}

	/**
	* Updates the preschool attached file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param preschoolAttachedFile the preschool attached file
	* @param merge whether to merge the preschool attached file with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the preschool attached file that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolAttachedFile updatePreschoolAttachedFile(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preschoolAttachedFileLocalService.updatePreschoolAttachedFile(preschoolAttachedFile,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _preschoolAttachedFileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_preschoolAttachedFileLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _preschoolAttachedFileLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PreschoolAttachedFileLocalService getWrappedPreschoolAttachedFileLocalService() {
		return _preschoolAttachedFileLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPreschoolAttachedFileLocalService(
		PreschoolAttachedFileLocalService preschoolAttachedFileLocalService) {
		_preschoolAttachedFileLocalService = preschoolAttachedFileLocalService;
	}

	public PreschoolAttachedFileLocalService getWrappedService() {
		return _preschoolAttachedFileLocalService;
	}

	public void setWrappedService(
		PreschoolAttachedFileLocalService preschoolAttachedFileLocalService) {
		_preschoolAttachedFileLocalService = preschoolAttachedFileLocalService;
	}

	private PreschoolAttachedFileLocalService _preschoolAttachedFileLocalService;
}