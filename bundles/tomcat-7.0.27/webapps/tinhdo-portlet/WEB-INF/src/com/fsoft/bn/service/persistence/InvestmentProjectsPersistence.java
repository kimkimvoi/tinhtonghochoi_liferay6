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

import com.fsoft.bn.model.InvestmentProjects;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the investment projects service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see InvestmentProjectsPersistenceImpl
 * @see InvestmentProjectsUtil
 * @generated
 */
public interface InvestmentProjectsPersistence extends BasePersistence<InvestmentProjects> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvestmentProjectsUtil} to access the investment projects persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the investment projects in the entity cache if it is enabled.
	*
	* @param investmentProjects the investment projects
	*/
	public void cacheResult(
		com.fsoft.bn.model.InvestmentProjects investmentProjects);

	/**
	* Caches the investment projectses in the entity cache if it is enabled.
	*
	* @param investmentProjectses the investment projectses
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.InvestmentProjects> investmentProjectses);

	/**
	* Creates a new investment projects with the primary key. Does not add the investment projects to the database.
	*
	* @param project_id the primary key for the new investment projects
	* @return the new investment projects
	*/
	public com.fsoft.bn.model.InvestmentProjects create(
		java.lang.String project_id);

	/**
	* Removes the investment projects with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_id the primary key of the investment projects
	* @return the investment projects that was removed
	* @throws com.fsoft.bn.NoSuchInvestmentProjectsException if a investment projects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects remove(
		java.lang.String project_id)
		throws com.fsoft.bn.NoSuchInvestmentProjectsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.InvestmentProjects updateImpl(
		com.fsoft.bn.model.InvestmentProjects investmentProjects, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the investment projects with the primary key or throws a {@link com.fsoft.bn.NoSuchInvestmentProjectsException} if it could not be found.
	*
	* @param project_id the primary key of the investment projects
	* @return the investment projects
	* @throws com.fsoft.bn.NoSuchInvestmentProjectsException if a investment projects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects findByPrimaryKey(
		java.lang.String project_id)
		throws com.fsoft.bn.NoSuchInvestmentProjectsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the investment projects with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param project_id the primary key of the investment projects
	* @return the investment projects, or <code>null</code> if a investment projects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects fetchByPrimaryKey(
		java.lang.String project_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the investment projectses.
	*
	* @return the investment projectses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.InvestmentProjects> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the investment projectses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of investment projectses
	* @param end the upper bound of the range of investment projectses (not inclusive)
	* @return the range of investment projectses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.InvestmentProjects> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the investment projectses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of investment projectses
	* @param end the upper bound of the range of investment projectses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of investment projectses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.InvestmentProjects> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the investment projectses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of investment projectses.
	*
	* @return the number of investment projectses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}