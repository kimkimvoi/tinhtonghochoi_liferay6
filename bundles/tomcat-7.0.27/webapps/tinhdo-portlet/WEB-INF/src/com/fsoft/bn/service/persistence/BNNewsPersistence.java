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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the b n news service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see BNNewsPersistenceImpl
 * @see BNNewsUtil
 * @generated
 */
public interface BNNewsPersistence extends BasePersistence<BNNews> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BNNewsUtil} to access the b n news persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the b n news in the entity cache if it is enabled.
	*
	* @param bnNews the b n news
	*/
	public void cacheResult(com.fsoft.bn.model.BNNews bnNews);

	/**
	* Caches the b n newses in the entity cache if it is enabled.
	*
	* @param bnNewses the b n newses
	*/
	public void cacheResult(java.util.List<com.fsoft.bn.model.BNNews> bnNewses);

	/**
	* Creates a new b n news with the primary key. Does not add the b n news to the database.
	*
	* @param newsId the primary key for the new b n news
	* @return the new b n news
	*/
	public com.fsoft.bn.model.BNNews create(long newsId);

	/**
	* Removes the b n news with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsId the primary key of the b n news
	* @return the b n news that was removed
	* @throws com.fsoft.bn.NoSuchNewsException if a b n news with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews remove(long newsId)
		throws com.fsoft.bn.NoSuchNewsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.BNNews updateImpl(
		com.fsoft.bn.model.BNNews bnNews, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the b n news with the primary key or throws a {@link com.fsoft.bn.NoSuchNewsException} if it could not be found.
	*
	* @param newsId the primary key of the b n news
	* @return the b n news
	* @throws com.fsoft.bn.NoSuchNewsException if a b n news with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews findByPrimaryKey(long newsId)
		throws com.fsoft.bn.NoSuchNewsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the b n news with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param newsId the primary key of the b n news
	* @return the b n news, or <code>null</code> if a b n news with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews fetchByPrimaryKey(long newsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the b n newses.
	*
	* @return the b n newses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.BNNews> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.BNNews> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.BNNews> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the b n newses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of b n newses.
	*
	* @return the number of b n newses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}