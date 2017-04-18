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

import com.fsoft.bn.model.PrimarySchoolParent;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the primary school parent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolParentPersistenceImpl
 * @see PrimarySchoolParentUtil
 * @generated
 */
public interface PrimarySchoolParentPersistence extends BasePersistence<PrimarySchoolParent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PrimarySchoolParentUtil} to access the primary school parent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the primary school parent in the entity cache if it is enabled.
	*
	* @param primarySchoolParent the primary school parent
	*/
	public void cacheResult(
		com.fsoft.bn.model.PrimarySchoolParent primarySchoolParent);

	/**
	* Caches the primary school parents in the entity cache if it is enabled.
	*
	* @param primarySchoolParents the primary school parents
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.PrimarySchoolParent> primarySchoolParents);

	/**
	* Creates a new primary school parent with the primary key. Does not add the primary school parent to the database.
	*
	* @param primarySchoolParent_id the primary key for the new primary school parent
	* @return the new primary school parent
	*/
	public com.fsoft.bn.model.PrimarySchoolParent create(
		java.lang.String primarySchoolParent_id);

	/**
	* Removes the primary school parent with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchoolParent_id the primary key of the primary school parent
	* @return the primary school parent that was removed
	* @throws com.fsoft.bn.NoSuchPrimarySchoolParentException if a primary school parent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent remove(
		java.lang.String primarySchoolParent_id)
		throws com.fsoft.bn.NoSuchPrimarySchoolParentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.PrimarySchoolParent updateImpl(
		com.fsoft.bn.model.PrimarySchoolParent primarySchoolParent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the primary school parent with the primary key or throws a {@link com.fsoft.bn.NoSuchPrimarySchoolParentException} if it could not be found.
	*
	* @param primarySchoolParent_id the primary key of the primary school parent
	* @return the primary school parent
	* @throws com.fsoft.bn.NoSuchPrimarySchoolParentException if a primary school parent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent findByPrimaryKey(
		java.lang.String primarySchoolParent_id)
		throws com.fsoft.bn.NoSuchPrimarySchoolParentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the primary school parent with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primarySchoolParent_id the primary key of the primary school parent
	* @return the primary school parent, or <code>null</code> if a primary school parent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PrimarySchoolParent fetchByPrimaryKey(
		java.lang.String primarySchoolParent_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the primary school parents.
	*
	* @return the primary school parents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PrimarySchoolParent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.fsoft.bn.model.PrimarySchoolParent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the primary school parents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school parents
	* @param end the upper bound of the range of primary school parents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of primary school parents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PrimarySchoolParent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the primary school parents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of primary school parents.
	*
	* @return the number of primary school parents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}