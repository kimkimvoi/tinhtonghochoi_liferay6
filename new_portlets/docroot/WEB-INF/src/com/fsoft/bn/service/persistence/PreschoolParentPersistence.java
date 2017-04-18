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

import com.fsoft.bn.model.PreschoolParent;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the preschool parent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PreschoolParentPersistenceImpl
 * @see PreschoolParentUtil
 * @generated
 */
public interface PreschoolParentPersistence extends BasePersistence<PreschoolParent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PreschoolParentUtil} to access the preschool parent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the preschool parent in the entity cache if it is enabled.
	*
	* @param preschoolParent the preschool parent
	*/
	public void cacheResult(com.fsoft.bn.model.PreschoolParent preschoolParent);

	/**
	* Caches the preschool parents in the entity cache if it is enabled.
	*
	* @param preschoolParents the preschool parents
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.PreschoolParent> preschoolParents);

	/**
	* Creates a new preschool parent with the primary key. Does not add the preschool parent to the database.
	*
	* @param preschoolParent_id the primary key for the new preschool parent
	* @return the new preschool parent
	*/
	public com.fsoft.bn.model.PreschoolParent create(
		java.lang.String preschoolParent_id);

	/**
	* Removes the preschool parent with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preschoolParent_id the primary key of the preschool parent
	* @return the preschool parent that was removed
	* @throws com.fsoft.bn.NoSuchPreschoolParentException if a preschool parent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolParent remove(
		java.lang.String preschoolParent_id)
		throws com.fsoft.bn.NoSuchPreschoolParentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.PreschoolParent updateImpl(
		com.fsoft.bn.model.PreschoolParent preschoolParent, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the preschool parent with the primary key or throws a {@link com.fsoft.bn.NoSuchPreschoolParentException} if it could not be found.
	*
	* @param preschoolParent_id the primary key of the preschool parent
	* @return the preschool parent
	* @throws com.fsoft.bn.NoSuchPreschoolParentException if a preschool parent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolParent findByPrimaryKey(
		java.lang.String preschoolParent_id)
		throws com.fsoft.bn.NoSuchPreschoolParentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the preschool parent with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param preschoolParent_id the primary key of the preschool parent
	* @return the preschool parent, or <code>null</code> if a preschool parent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.PreschoolParent fetchByPrimaryKey(
		java.lang.String preschoolParent_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the preschool parents.
	*
	* @return the preschool parents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PreschoolParent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the preschool parents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool parents
	* @param end the upper bound of the range of preschool parents (not inclusive)
	* @return the range of preschool parents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PreschoolParent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the preschool parents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool parents
	* @param end the upper bound of the range of preschool parents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of preschool parents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.PreschoolParent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the preschool parents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of preschool parents.
	*
	* @return the number of preschool parents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}