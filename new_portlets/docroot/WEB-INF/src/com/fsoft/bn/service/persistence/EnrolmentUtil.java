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

import com.fsoft.bn.model.Enrolment;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the enrolment service. This utility wraps {@link EnrolmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see EnrolmentPersistence
 * @see EnrolmentPersistenceImpl
 * @generated
 */
public class EnrolmentUtil {
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
	public static void clearCache(Enrolment enrolment) {
		getPersistence().clearCache(enrolment);
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
	public static List<Enrolment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Enrolment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Enrolment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Enrolment update(Enrolment enrolment, boolean merge)
		throws SystemException {
		return getPersistence().update(enrolment, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Enrolment update(Enrolment enrolment, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(enrolment, merge, serviceContext);
	}

	/**
	* Caches the enrolment in the entity cache if it is enabled.
	*
	* @param enrolment the enrolment
	*/
	public static void cacheResult(com.fsoft.bn.model.Enrolment enrolment) {
		getPersistence().cacheResult(enrolment);
	}

	/**
	* Caches the enrolments in the entity cache if it is enabled.
	*
	* @param enrolments the enrolments
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.Enrolment> enrolments) {
		getPersistence().cacheResult(enrolments);
	}

	/**
	* Creates a new enrolment with the primary key. Does not add the enrolment to the database.
	*
	* @param enrolment_id the primary key for the new enrolment
	* @return the new enrolment
	*/
	public static com.fsoft.bn.model.Enrolment create(
		java.lang.String enrolment_id) {
		return getPersistence().create(enrolment_id);
	}

	/**
	* Removes the enrolment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enrolment_id the primary key of the enrolment
	* @return the enrolment that was removed
	* @throws com.fsoft.bn.NoSuchEnrolmentException if a enrolment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Enrolment remove(
		java.lang.String enrolment_id)
		throws com.fsoft.bn.NoSuchEnrolmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(enrolment_id);
	}

	public static com.fsoft.bn.model.Enrolment updateImpl(
		com.fsoft.bn.model.Enrolment enrolment, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(enrolment, merge);
	}

	/**
	* Returns the enrolment with the primary key or throws a {@link com.fsoft.bn.NoSuchEnrolmentException} if it could not be found.
	*
	* @param enrolment_id the primary key of the enrolment
	* @return the enrolment
	* @throws com.fsoft.bn.NoSuchEnrolmentException if a enrolment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Enrolment findByPrimaryKey(
		java.lang.String enrolment_id)
		throws com.fsoft.bn.NoSuchEnrolmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(enrolment_id);
	}

	/**
	* Returns the enrolment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enrolment_id the primary key of the enrolment
	* @return the enrolment, or <code>null</code> if a enrolment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.Enrolment fetchByPrimaryKey(
		java.lang.String enrolment_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(enrolment_id);
	}

	/**
	* Returns all the enrolments.
	*
	* @return the enrolments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Enrolment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the enrolments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enrolments
	* @param end the upper bound of the range of enrolments (not inclusive)
	* @return the range of enrolments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Enrolment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the enrolments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enrolments
	* @param end the upper bound of the range of enrolments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enrolments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.Enrolment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the enrolments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of enrolments.
	*
	* @return the number of enrolments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EnrolmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EnrolmentPersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					EnrolmentPersistence.class.getName());

			ReferenceRegistry.registerReference(EnrolmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EnrolmentPersistence persistence) {
	}

	private static EnrolmentPersistence _persistence;
}