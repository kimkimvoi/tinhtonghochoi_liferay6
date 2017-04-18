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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the userful contact phone service. This utility wraps {@link UserfulContactPhonePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see UserfulContactPhonePersistence
 * @see UserfulContactPhonePersistenceImpl
 * @generated
 */
public class UserfulContactPhoneUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserfulContactPhone userfulContactPhone) {
		getPersistence().clearCache(userfulContactPhone);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserfulContactPhone> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserfulContactPhone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserfulContactPhone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserfulContactPhone update(
		UserfulContactPhone userfulContactPhone, boolean merge)
		throws SystemException {
		return getPersistence().update(userfulContactPhone, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserfulContactPhone update(
		UserfulContactPhone userfulContactPhone, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(userfulContactPhone, merge, serviceContext);
	}

	/**
	* Caches the userful contact phone in the entity cache if it is enabled.
	*
	* @param userfulContactPhone the userful contact phone
	*/
	public static void cacheResult(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone) {
		getPersistence().cacheResult(userfulContactPhone);
	}

	/**
	* Caches the userful contact phones in the entity cache if it is enabled.
	*
	* @param userfulContactPhones the userful contact phones
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.UserfulContactPhone> userfulContactPhones) {
		getPersistence().cacheResult(userfulContactPhones);
	}

	/**
	* Creates a new userful contact phone with the primary key. Does not add the userful contact phone to the database.
	*
	* @param userful_contact_phone_id the primary key for the new userful contact phone
	* @return the new userful contact phone
	*/
	public static com.fsoft.bn.model.UserfulContactPhone create(
		java.lang.String userful_contact_phone_id) {
		return getPersistence().create(userful_contact_phone_id);
	}

	/**
	* Removes the userful contact phone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userful_contact_phone_id the primary key of the userful contact phone
	* @return the userful contact phone that was removed
	* @throws com.fsoft.bn.NoSuchUserfulContactPhoneException if a userful contact phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserfulContactPhone remove(
		java.lang.String userful_contact_phone_id)
		throws com.fsoft.bn.NoSuchUserfulContactPhoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userful_contact_phone_id);
	}

	public static com.fsoft.bn.model.UserfulContactPhone updateImpl(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userfulContactPhone, merge);
	}

	/**
	* Returns the userful contact phone with the primary key or throws a {@link com.fsoft.bn.NoSuchUserfulContactPhoneException} if it could not be found.
	*
	* @param userful_contact_phone_id the primary key of the userful contact phone
	* @return the userful contact phone
	* @throws com.fsoft.bn.NoSuchUserfulContactPhoneException if a userful contact phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserfulContactPhone findByPrimaryKey(
		java.lang.String userful_contact_phone_id)
		throws com.fsoft.bn.NoSuchUserfulContactPhoneException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userful_contact_phone_id);
	}

	/**
	* Returns the userful contact phone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userful_contact_phone_id the primary key of the userful contact phone
	* @return the userful contact phone, or <code>null</code> if a userful contact phone with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.UserfulContactPhone fetchByPrimaryKey(
		java.lang.String userful_contact_phone_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userful_contact_phone_id);
	}

	/**
	* Returns all the userful contact phones.
	*
	* @return the userful contact phones
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.UserfulContactPhone> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.fsoft.bn.model.UserfulContactPhone> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.UserfulContactPhone> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the userful contact phones from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of userful contact phones.
	*
	* @return the number of userful contact phones
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserfulContactPhonePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserfulContactPhonePersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					UserfulContactPhonePersistence.class.getName());

			ReferenceRegistry.registerReference(UserfulContactPhoneUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UserfulContactPhonePersistence persistence) {
	}

	private static UserfulContactPhonePersistence _persistence;
}