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
 * This class is a wrapper for {@link UserfulContactPhoneLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       UserfulContactPhoneLocalService
 * @generated
 */
public class UserfulContactPhoneLocalServiceWrapper
	implements UserfulContactPhoneLocalService,
		ServiceWrapper<UserfulContactPhoneLocalService> {
	public UserfulContactPhoneLocalServiceWrapper(
		UserfulContactPhoneLocalService userfulContactPhoneLocalService) {
		_userfulContactPhoneLocalService = userfulContactPhoneLocalService;
	}

	/**
	* Adds the userful contact phone to the database. Also notifies the appropriate model listeners.
	*
	* @param userfulContactPhone the userful contact phone
	* @return the userful contact phone that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone addUserfulContactPhone(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.addUserfulContactPhone(userfulContactPhone);
	}

	/**
	* Creates a new userful contact phone with the primary key. Does not add the userful contact phone to the database.
	*
	* @param userful_contact_phone_id the primary key for the new userful contact phone
	* @return the new userful contact phone
	*/
	public com.fsoft.bn.model.UserfulContactPhone createUserfulContactPhone(
		java.lang.String userful_contact_phone_id) {
		return _userfulContactPhoneLocalService.createUserfulContactPhone(userful_contact_phone_id);
	}

	/**
	* Deletes the userful contact phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userful_contact_phone_id the primary key of the userful contact phone
	* @return the userful contact phone that was removed
	* @throws PortalException if a userful contact phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone deleteUserfulContactPhone(
		java.lang.String userful_contact_phone_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.deleteUserfulContactPhone(userful_contact_phone_id);
	}

	/**
	* Deletes the userful contact phone from the database. Also notifies the appropriate model listeners.
	*
	* @param userfulContactPhone the userful contact phone
	* @return the userful contact phone that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone deleteUserfulContactPhone(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.deleteUserfulContactPhone(userfulContactPhone);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userfulContactPhoneLocalService.dynamicQuery();
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
		return _userfulContactPhoneLocalService.dynamicQuery(dynamicQuery);
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
		return _userfulContactPhoneLocalService.dynamicQuery(dynamicQuery,
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
		return _userfulContactPhoneLocalService.dynamicQuery(dynamicQuery,
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
		return _userfulContactPhoneLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.UserfulContactPhone fetchUserfulContactPhone(
		java.lang.String userful_contact_phone_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.fetchUserfulContactPhone(userful_contact_phone_id);
	}

	/**
	* Returns the userful contact phone with the primary key.
	*
	* @param userful_contact_phone_id the primary key of the userful contact phone
	* @return the userful contact phone
	* @throws PortalException if a userful contact phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone getUserfulContactPhone(
		java.lang.String userful_contact_phone_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.getUserfulContactPhone(userful_contact_phone_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the userful contact phones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of userful contact phones
	* @param end the upper bound of the range of userful contact phones (not inclusive)
	* @return the range of userful contact phones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.UserfulContactPhone> getUserfulContactPhones(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.getUserfulContactPhones(start,
			end);
	}

	/**
	* Returns the number of userful contact phones.
	*
	* @return the number of userful contact phones
	* @throws SystemException if a system exception occurred
	*/
	public int getUserfulContactPhonesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.getUserfulContactPhonesCount();
	}

	/**
	* Updates the userful contact phone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userfulContactPhone the userful contact phone
	* @return the userful contact phone that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone updateUserfulContactPhone(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.updateUserfulContactPhone(userfulContactPhone);
	}

	/**
	* Updates the userful contact phone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userfulContactPhone the userful contact phone
	* @param merge whether to merge the userful contact phone with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the userful contact phone that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone updateUserfulContactPhone(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userfulContactPhoneLocalService.updateUserfulContactPhone(userfulContactPhone,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userfulContactPhoneLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userfulContactPhoneLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userfulContactPhoneLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserfulContactPhoneLocalService getWrappedUserfulContactPhoneLocalService() {
		return _userfulContactPhoneLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserfulContactPhoneLocalService(
		UserfulContactPhoneLocalService userfulContactPhoneLocalService) {
		_userfulContactPhoneLocalService = userfulContactPhoneLocalService;
	}

	public UserfulContactPhoneLocalService getWrappedService() {
		return _userfulContactPhoneLocalService;
	}

	public void setWrappedService(
		UserfulContactPhoneLocalService userfulContactPhoneLocalService) {
		_userfulContactPhoneLocalService = userfulContactPhoneLocalService;
	}

	private UserfulContactPhoneLocalService _userfulContactPhoneLocalService;
}