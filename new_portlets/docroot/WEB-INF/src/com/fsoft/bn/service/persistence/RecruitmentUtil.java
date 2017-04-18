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

import com.fsoft.bn.model.Recruitment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the recruitment service. This utility wraps {@link RecruitmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentPersistence
 * @see RecruitmentPersistenceImpl
 * @generated
 */
public class RecruitmentUtil {
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
	public static void clearCache(Recruitment recruitment) {
		getPersistence().clearCache(recruitment);
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
	public static List<Recruitment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Recruitment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Recruitment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Recruitment update(Recruitment recruitment, boolean merge)
		throws SystemException {
		return getPersistence().update(recruitment, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Recruitment update(Recruitment recruitment, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(recruitment, merge, serviceContext);
	}

	/**
	* Caches the recruitment in the entity cache if it is enabled.
	*
	* @param recruitment the recruitment
	*/
	public static void cacheResult(com.fsoft.bn.model.Recruitment recruitment) {
		getPersistence().cacheResult(recruitment);
	}

	/**
	* Caches the recruitments in the entity cache if it is enabled.
	*
	* @param recruitments the recruitments
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.Recruitment> recruitments) {
		getPersistence().cacheResult(recruitments);
	}

	/**
	* Creates a new recruitment with the primary key. Does not add the recruitment to the database.
	*
	* @param recruitment_id the primary key for the new recruitment
	* @return the new recruitment
	*/
	public static com.fsoft.bn.model.Recruitment create(
		java.lang.String recruitment_id) {
		return getPersistence().create(recruitment_id);
	}

	/**
	* Removes the recruitment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment that was removed
	* @throws com.fsoft.bn.NoSuchRecruitmentException if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment remove(
		java.lang.String recruitment_id)
		throws com.fsoft.bn.NoSuchRecruitmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(recruitment_id);
	}

	public static com.fsoft.bn.model.Recruitment updateImpl(
		com.fsoft.bn.model.Recruitment recruitment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(recruitment, merge);
	}

	/**
	* Returns the recruitment with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentException} if it could not be found.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment
	* @throws com.fsoft.bn.NoSuchRecruitmentException if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment findByPrimaryKey(
		java.lang.String recruitment_id)
		throws com.fsoft.bn.NoSuchRecruitmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(recruitment_id);
	}

	/**
	* Returns the recruitment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitment_id the primary key of the recruitment
	* @return the recruitment, or <code>null</code> if a recruitment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Recruitment fetchByPrimaryKey(
		java.lang.String recruitment_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(recruitment_id);
	}

	/**
	* Returns all the recruitments.
	*
	* @return the recruitments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Recruitment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the recruitments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitments
	* @param end the upper bound of the range of recruitments (not inclusive)
	* @return the range of recruitments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Recruitment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the recruitments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitments
	* @param end the upper bound of the range of recruitments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recruitments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Recruitment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the recruitments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of recruitments.
	*
	* @return the number of recruitments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RecruitmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RecruitmentPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					RecruitmentPersistence.class.getName());

			ReferenceRegistry.registerReference(RecruitmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(RecruitmentPersistence persistence) {
	}

	private static RecruitmentPersistence _persistence;
}