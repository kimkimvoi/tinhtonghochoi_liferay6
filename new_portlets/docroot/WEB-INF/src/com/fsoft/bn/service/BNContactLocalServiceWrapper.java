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
 * This class is a wrapper for {@link BNContactLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       BNContactLocalService
 * @generated
 */
public class BNContactLocalServiceWrapper implements BNContactLocalService,
	ServiceWrapper<BNContactLocalService> {
	public BNContactLocalServiceWrapper(
		BNContactLocalService bnContactLocalService) {
		_bnContactLocalService = bnContactLocalService;
	}

	/**
	* Adds the b n contact to the database. Also notifies the appropriate model listeners.
	*
	* @param bnContact the b n contact
	* @return the b n contact that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNContact addBNContact(
		com.fsoft.bn.model.BNContact bnContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.addBNContact(bnContact);
	}

	/**
	* Creates a new b n contact with the primary key. Does not add the b n contact to the database.
	*
	* @param contactId the primary key for the new b n contact
	* @return the new b n contact
	*/
	public com.fsoft.bn.model.BNContact createBNContact(long contactId) {
		return _bnContactLocalService.createBNContact(contactId);
	}

	/**
	* Deletes the b n contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the b n contact
	* @return the b n contact that was removed
	* @throws PortalException if a b n contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNContact deleteBNContact(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.deleteBNContact(contactId);
	}

	/**
	* Deletes the b n contact from the database. Also notifies the appropriate model listeners.
	*
	* @param bnContact the b n contact
	* @return the b n contact that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNContact deleteBNContact(
		com.fsoft.bn.model.BNContact bnContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.deleteBNContact(bnContact);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bnContactLocalService.dynamicQuery();
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
		return _bnContactLocalService.dynamicQuery(dynamicQuery);
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
		return _bnContactLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _bnContactLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _bnContactLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.BNContact fetchBNContact(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.fetchBNContact(contactId);
	}

	/**
	* Returns the b n contact with the primary key.
	*
	* @param contactId the primary key of the b n contact
	* @return the b n contact
	* @throws PortalException if a b n contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNContact getBNContact(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.getBNContact(contactId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the b n contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of b n contacts
	* @param end the upper bound of the range of b n contacts (not inclusive)
	* @return the range of b n contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.BNContact> getBNContacts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.getBNContacts(start, end);
	}

	/**
	* Returns the number of b n contacts.
	*
	* @return the number of b n contacts
	* @throws SystemException if a system exception occurred
	*/
	public int getBNContactsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.getBNContactsCount();
	}

	/**
	* Updates the b n contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bnContact the b n contact
	* @return the b n contact that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNContact updateBNContact(
		com.fsoft.bn.model.BNContact bnContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.updateBNContact(bnContact);
	}

	/**
	* Updates the b n contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bnContact the b n contact
	* @param merge whether to merge the b n contact with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the b n contact that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNContact updateBNContact(
		com.fsoft.bn.model.BNContact bnContact, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnContactLocalService.updateBNContact(bnContact, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bnContactLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bnContactLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bnContactLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BNContactLocalService getWrappedBNContactLocalService() {
		return _bnContactLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBNContactLocalService(
		BNContactLocalService bnContactLocalService) {
		_bnContactLocalService = bnContactLocalService;
	}

	public BNContactLocalService getWrappedService() {
		return _bnContactLocalService;
	}

	public void setWrappedService(BNContactLocalService bnContactLocalService) {
		_bnContactLocalService = bnContactLocalService;
	}

	private BNContactLocalService _bnContactLocalService;
}