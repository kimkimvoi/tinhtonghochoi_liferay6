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
 * This class is a wrapper for {@link PrimarySchoolParentLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       PrimarySchoolParentLocalService
 * @generated
 */
public class PrimarySchoolParentLocalServiceWrapper
	implements PrimarySchoolParentLocalService,
		ServiceWrapper<PrimarySchoolParentLocalService> {
	public PrimarySchoolParentLocalServiceWrapper(
		PrimarySchoolParentLocalService primarySchoolParentLocalService) {
		_primarySchoolParentLocalService = primarySchoolParentLocalService;
	}

	/**
	* Adds the primary school parent to the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolParent the primary school parent
	* @return the primary school parent that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent addPrimarySchoolParent(
		com.fsoft.bn.model.PrimarySchoolParent primarySchoolParent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.addPrimarySchoolParent(primarySchoolParent);
	}

	/**
	* Creates a new primary school parent with the primary key. Does not add the primary school parent to the database.
	*
	* @param primarySchoolParent_id the primary key for the new primary school parent
	* @return the new primary school parent
	*/
	public com.fsoft.bn.model.PrimarySchoolParent createPrimarySchoolParent(
		java.lang.String primarySchoolParent_id) {
		return _primarySchoolParentLocalService.createPrimarySchoolParent(primarySchoolParent_id);
	}

	/**
	* Deletes the primary school parent with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolParent_id the primary key of the primary school parent
	* @return the primary school parent that was removed
	* @throws PortalException if a primary school parent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent deletePrimarySchoolParent(
		java.lang.String primarySchoolParent_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.deletePrimarySchoolParent(primarySchoolParent_id);
	}

	/**
	* Deletes the primary school parent from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolParent the primary school parent
	* @return the primary school parent that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent deletePrimarySchoolParent(
		com.fsoft.bn.model.PrimarySchoolParent primarySchoolParent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.deletePrimarySchoolParent(primarySchoolParent);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _primarySchoolParentLocalService.dynamicQuery();
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
		return _primarySchoolParentLocalService.dynamicQuery(dynamicQuery);
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
		return _primarySchoolParentLocalService.dynamicQuery(dynamicQuery,
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
		return _primarySchoolParentLocalService.dynamicQuery(dynamicQuery,
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
		return _primarySchoolParentLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.PrimarySchoolParent fetchPrimarySchoolParent(
		java.lang.String primarySchoolParent_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.fetchPrimarySchoolParent(primarySchoolParent_id);
	}

	/**
	* Returns the primary school parent with the primary key.
	*
	* @param primarySchoolParent_id the primary key of the primary school parent
	* @return the primary school parent
	* @throws PortalException if a primary school parent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent getPrimarySchoolParent(
		java.lang.String primarySchoolParent_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.getPrimarySchoolParent(primarySchoolParent_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the primary school parents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school parents
	* @param end the upper bound of the range of primary school parents (not inclusive)
	* @return the range of primary school parents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PrimarySchoolParent> getPrimarySchoolParents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.getPrimarySchoolParents(start,
			end);
	}

	/**
	* Returns the number of primary school parents.
	*
	* @return the number of primary school parents
	* @throws SystemException if a system exception occurred
	*/
	public int getPrimarySchoolParentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.getPrimarySchoolParentsCount();
	}

	/**
	* Updates the primary school parent in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolParent the primary school parent
	* @return the primary school parent that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent updatePrimarySchoolParent(
		com.fsoft.bn.model.PrimarySchoolParent primarySchoolParent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.updatePrimarySchoolParent(primarySchoolParent);
	}

	/**
	* Updates the primary school parent in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolParent the primary school parent
	* @param merge whether to merge the primary school parent with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the primary school parent that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent updatePrimarySchoolParent(
		com.fsoft.bn.model.PrimarySchoolParent primarySchoolParent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _primarySchoolParentLocalService.updatePrimarySchoolParent(primarySchoolParent,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _primarySchoolParentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_primarySchoolParentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _primarySchoolParentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PrimarySchoolParentLocalService getWrappedPrimarySchoolParentLocalService() {
		return _primarySchoolParentLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPrimarySchoolParentLocalService(
		PrimarySchoolParentLocalService primarySchoolParentLocalService) {
		_primarySchoolParentLocalService = primarySchoolParentLocalService;
	}

	public PrimarySchoolParentLocalService getWrappedService() {
		return _primarySchoolParentLocalService;
	}

	public void setWrappedService(
		PrimarySchoolParentLocalService primarySchoolParentLocalService) {
		_primarySchoolParentLocalService = primarySchoolParentLocalService;
	}

	private PrimarySchoolParentLocalService _primarySchoolParentLocalService;
}