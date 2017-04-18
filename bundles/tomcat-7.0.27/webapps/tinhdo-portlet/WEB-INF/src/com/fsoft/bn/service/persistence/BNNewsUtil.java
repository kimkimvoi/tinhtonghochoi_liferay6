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

import com.fsoft.bn.model.BNNews;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the b n news service. This utility wraps {@link BNNewsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see BNNewsPersistence
 * @see BNNewsPersistenceImpl
 * @generated
 */
public class BNNewsUtil {
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
	public static void clearCache(BNNews bnNews) {
		getPersistence().clearCache(bnNews);
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
	public static List<BNNews> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BNNews> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BNNews> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static BNNews update(BNNews bnNews, boolean merge)
		throws SystemException {
		return getPersistence().update(bnNews, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static BNNews update(BNNews bnNews, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bnNews, merge, serviceContext);
	}

	/**
	* Caches the b n news in the entity cache if it is enabled.
	*
	* @param bnNews the b n news
	*/
	public static void cacheResult(com.fsoft.bn.model.BNNews bnNews) {
		getPersistence().cacheResult(bnNews);
	}

	/**
	* Caches the b n newses in the entity cache if it is enabled.
	*
	* @param bnNewses the b n newses
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.BNNews> bnNewses) {
		getPersistence().cacheResult(bnNewses);
	}

	/**
	* Creates a new b n news with the primary key. Does not add the b n news to the database.
	*
	* @param newsId the primary key for the new b n news
	* @return the new b n news
	*/
	public static com.fsoft.bn.model.BNNews create(long newsId) {
		return getPersistence().create(newsId);
	}

	/**
	* Removes the b n news with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsId the primary key of the b n news
	* @return the b n news that was removed
	* @throws com.fsoft.bn.NoSuchNewsException if a b n news with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.BNNews remove(long newsId)
		throws com.fsoft.bn.NoSuchNewsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(newsId);
	}

	public static com.fsoft.bn.model.BNNews updateImpl(
		com.fsoft.bn.model.BNNews bnNews, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bnNews, merge);
	}

	/**
	* Returns the b n news with the primary key or throws a {@link com.fsoft.bn.NoSuchNewsException} if it could not be found.
	*
	* @param newsId the primary key of the b n news
	* @return the b n news
	* @throws com.fsoft.bn.NoSuchNewsException if a b n news with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.BNNews findByPrimaryKey(long newsId)
		throws com.fsoft.bn.NoSuchNewsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(newsId);
	}

	/**
	* Returns the b n news with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param newsId the primary key of the b n news
	* @return the b n news, or <code>null</code> if a b n news with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.BNNews fetchByPrimaryKey(long newsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(newsId);
	}

	/**
	* Returns all the b n newses.
	*
	* @return the b n newses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.BNNews> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the b n newses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of b n newses
	* @param end the upper bound of the range of b n newses (not inclusive)
	* @return the range of b n newses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.BNNews> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the b n newses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of b n newses
	* @param end the upper bound of the range of b n newses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of b n newses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.BNNews> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the b n newses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of b n newses.
	*
	* @return the number of b n newses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BNNewsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BNNewsPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					BNNewsPersistence.class.getName());

			ReferenceRegistry.registerReference(BNNewsUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BNNewsPersistence persistence) {
	}

	private static BNNewsPersistence _persistence;
}