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

import com.fsoft.bn.model.BNContact;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the b n contact service. This utility wraps {@link BNContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see BNContactPersistence
 * @see BNContactPersistenceImpl
 * @generated
 */
public class BNContactUtil {
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
	public static void clearCache(BNContact bnContact) {
		getPersistence().clearCache(bnContact);
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
	public static List<BNContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BNContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BNContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static BNContact update(BNContact bnContact, boolean merge)
		throws SystemException {
		return getPersistence().update(bnContact, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static BNContact update(BNContact bnContact, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bnContact, merge, serviceContext);
	}

	/**
	* Caches the b n contact in the entity cache if it is enabled.
	*
	* @param bnContact the b n contact
	*/
	public static void cacheResult(com.fsoft.bn.model.BNContact bnContact) {
		getPersistence().cacheResult(bnContact);
	}

	/**
	* Caches the b n contacts in the entity cache if it is enabled.
	*
	* @param bnContacts the b n contacts
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.BNContact> bnContacts) {
		getPersistence().cacheResult(bnContacts);
	}

	/**
	* Creates a new b n contact with the primary key. Does not add the b n contact to the database.
	*
	* @param contactId the primary key for the new b n contact
	* @return the new b n contact
	*/
	public static com.fsoft.bn.model.BNContact create(long contactId) {
		return getPersistence().create(contactId);
	}

	/**
	* Removes the b n contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the b n contact
	* @return the b n contact that was removed
	* @throws com.fsoft.bn.NoSuchContactException if a b n contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.BNContact remove(long contactId)
		throws com.fsoft.bn.NoSuchContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(contactId);
	}

	public static com.fsoft.bn.model.BNContact updateImpl(
		com.fsoft.bn.model.BNContact bnContact, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bnContact, merge);
	}

	/**
	* Returns the b n contact with the primary key or throws a {@link com.fsoft.bn.NoSuchContactException} if it could not be found.
	*
	* @param contactId the primary key of the b n contact
	* @return the b n contact
	* @throws com.fsoft.bn.NoSuchContactException if a b n contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.BNContact findByPrimaryKey(long contactId)
		throws com.fsoft.bn.NoSuchContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(contactId);
	}

	/**
	* Returns the b n contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactId the primary key of the b n contact
	* @return the b n contact, or <code>null</code> if a b n contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.BNContact fetchByPrimaryKey(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contactId);
	}

	/**
	* Returns all the b n contacts.
	*
	* @return the b n contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.BNContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.fsoft.bn.model.BNContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the b n contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of b n contacts
	* @param end the upper bound of the range of b n contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of b n contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.BNContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the b n contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of b n contacts.
	*
	* @return the number of b n contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BNContactPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BNContactPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					BNContactPersistence.class.getName());

			ReferenceRegistry.registerReference(BNContactUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BNContactPersistence persistence) {
	}

	private static BNContactPersistence _persistence;
}