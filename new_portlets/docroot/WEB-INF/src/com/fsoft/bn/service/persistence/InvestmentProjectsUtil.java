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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the investment projects service. This utility wraps {@link InvestmentProjectsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see InvestmentProjectsPersistence
 * @see InvestmentProjectsPersistenceImpl
 * @generated
 */
public class InvestmentProjectsUtil {
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
	public static void clearCache(InvestmentProjects investmentProjects) {
		getPersistence().clearCache(investmentProjects);
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
	public static List<InvestmentProjects> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InvestmentProjects> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InvestmentProjects> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static InvestmentProjects update(
		InvestmentProjects investmentProjects, boolean merge)
		throws SystemException {
		return getPersistence().update(investmentProjects, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static InvestmentProjects update(
		InvestmentProjects investmentProjects, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(investmentProjects, merge, serviceContext);
	}

	/**
	* Caches the investment projects in the entity cache if it is enabled.
	*
	* @param investmentProjects the investment projects
	*/
	public static void cacheResult(
		com.fsoft.bn.model.InvestmentProjects investmentProjects) {
		getPersistence().cacheResult(investmentProjects);
	}

	/**
	* Caches the investment projectses in the entity cache if it is enabled.
	*
	* @param investmentProjectses the investment projectses
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.InvestmentProjects> investmentProjectses) {
		getPersistence().cacheResult(investmentProjectses);
	}

	/**
	* Creates a new investment projects with the primary key. Does not add the investment projects to the database.
	*
	* @param project_id the primary key for the new investment projects
	* @return the new investment projects
	*/
	public static com.fsoft.bn.model.InvestmentProjects create(
		java.lang.String project_id) {
		return getPersistence().create(project_id);
	}

	/**
	* Removes the investment projects with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_id the primary key of the investment projects
	* @return the investment projects that was removed
	* @throws com.fsoft.bn.NoSuchInvestmentProjectsException if a investment projects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.InvestmentProjects remove(
		java.lang.String project_id)
		throws com.fsoft.bn.NoSuchInvestmentProjectsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(project_id);
	}

	public static com.fsoft.bn.model.InvestmentProjects updateImpl(
		com.fsoft.bn.model.InvestmentProjects investmentProjects, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(investmentProjects, merge);
	}

	/**
	* Returns the investment projects with the primary key or throws a {@link com.fsoft.bn.NoSuchInvestmentProjectsException} if it could not be found.
	*
	* @param project_id the primary key of the investment projects
	* @return the investment projects
	* @throws com.fsoft.bn.NoSuchInvestmentProjectsException if a investment projects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.InvestmentProjects findByPrimaryKey(
		java.lang.String project_id)
		throws com.fsoft.bn.NoSuchInvestmentProjectsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(project_id);
	}

	/**
	* Returns the investment projects with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param project_id the primary key of the investment projects
	* @return the investment projects, or <code>null</code> if a investment projects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.InvestmentProjects fetchByPrimaryKey(
		java.lang.String project_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(project_id);
	}

	/**
	* Returns all the investment projectses.
	*
	* @return the investment projectses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.InvestmentProjects> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.fsoft.bn.model.InvestmentProjects> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.fsoft.bn.model.InvestmentProjects> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the investment projectses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of investment projectses.
	*
	* @return the number of investment projectses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InvestmentProjectsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InvestmentProjectsPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					InvestmentProjectsPersistence.class.getName());

			ReferenceRegistry.registerReference(InvestmentProjectsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(InvestmentProjectsPersistence persistence) {
	}

	private static InvestmentProjectsPersistence _persistence;
}