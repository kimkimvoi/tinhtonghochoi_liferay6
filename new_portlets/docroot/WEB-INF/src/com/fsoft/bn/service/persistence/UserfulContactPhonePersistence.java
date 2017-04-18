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

package com.fsoft.bn.service.persistence;

import com.fsoft.bn.model.UserfulContactPhone;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the userful contact phone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see UserfulContactPhonePersistenceImpl
 * @see UserfulContactPhoneUtil
 * @generated
 */
public interface UserfulContactPhonePersistence extends BasePersistence<UserfulContactPhone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserfulContactPhoneUtil} to access the userful contact phone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the userful contact phone in the entity cache if it is enabled.
	*
	* @param userfulContactPhone the userful contact phone
	*/
	public void cacheResult(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone);

	/**
	* Caches the userful contact phones in the entity cache if it is enabled.
	*
	* @param userfulContactPhones the userful contact phones
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.UserfulContactPhone> userfulContactPhones);

	/**
	* Creates a new userful contact phone with the primary key. Does not add the userful contact phone to the database.
	*
	* @param userful_contact_phone_id the primary key for the new userful contact phone
	* @return the new userful contact phone
	*/
	public com.fsoft.bn.model.UserfulContactPhone create(
		java.lang.String userful_contact_phone_id);

	/**
	* Removes the userful contact phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userful_contact_phone_id the primary key of the userful contact phone
	* @return the userful contact phone that was removed
	* @throws com.fsoft.bn.NoSuchUserfulContactPhoneException if a userful contact phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone remove(
		java.lang.String userful_contact_phone_id)
		throws com.fsoft.bn.NoSuchUserfulContactPhoneException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.UserfulContactPhone updateImpl(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the userful contact phone with the primary key or throws a {@link com.fsoft.bn.NoSuchUserfulContactPhoneException} if it could not be found.
	*
	* @param userful_contact_phone_id the primary key of the userful contact phone
	* @return the userful contact phone
	* @throws com.fsoft.bn.NoSuchUserfulContactPhoneException if a userful contact phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone findByPrimaryKey(
		java.lang.String userful_contact_phone_id)
		throws com.fsoft.bn.NoSuchUserfulContactPhoneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the userful contact phone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userful_contact_phone_id the primary key of the userful contact phone
	* @return the userful contact phone, or <code>null</code> if a userful contact phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.UserfulContactPhone fetchByPrimaryKey(
		java.lang.String userful_contact_phone_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the userful contact phones.
	*
	* @return the userful contact phones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.UserfulContactPhone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.UserfulContactPhone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the userful contact phones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of userful contact phones
	* @param end the upper bound of the range of userful contact phones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of userful contact phones
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.UserfulContactPhone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the userful contact phones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of userful contact phones.
	*
	* @return the number of userful contact phones
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}