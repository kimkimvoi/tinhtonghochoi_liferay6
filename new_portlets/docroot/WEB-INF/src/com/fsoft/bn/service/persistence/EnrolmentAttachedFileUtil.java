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

import com.fsoft.bn.model.EnrolmentAttachedFile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the enrolment attached file service. This utility wraps {@link EnrolmentAttachedFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see EnrolmentAttachedFilePersistence
 * @see EnrolmentAttachedFilePersistenceImpl
 * @generated
 */
public class EnrolmentAttachedFileUtil {
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
	public static void clearCache(EnrolmentAttachedFile enrolmentAttachedFile) {
		getPersistence().clearCache(enrolmentAttachedFile);
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
	public static List<EnrolmentAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EnrolmentAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EnrolmentAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static EnrolmentAttachedFile update(
		EnrolmentAttachedFile enrolmentAttachedFile, boolean merge)
		throws SystemException {
		return getPersistence().update(enrolmentAttachedFile, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static EnrolmentAttachedFile update(
		EnrolmentAttachedFile enrolmentAttachedFile, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(enrolmentAttachedFile, merge, serviceContext);
	}

	/**
	* Caches the enrolment attached file in the entity cache if it is enabled.
	*
	* @param enrolmentAttachedFile the enrolment attached file
	*/
	public static void cacheResult(
		com.fsoft.bn.model.EnrolmentAttachedFile enrolmentAttachedFile) {
		getPersistence().cacheResult(enrolmentAttachedFile);
	}

	/**
	* Caches the enrolment attached files in the entity cache if it is enabled.
	*
	* @param enrolmentAttachedFiles the enrolment attached files
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.EnrolmentAttachedFile> enrolmentAttachedFiles) {
		getPersistence().cacheResult(enrolmentAttachedFiles);
	}

	/**
	* Creates a new enrolment attached file with the primary key. Does not add the enrolment attached file to the database.
	*
	* @param enrolment_attached_id the primary key for the new enrolment attached file
	* @return the new enrolment attached file
	*/
	public static com.fsoft.bn.model.EnrolmentAttachedFile create(
		java.lang.String enrolment_attached_id) {
		return getPersistence().create(enrolment_attached_id);
	}

	/**
	* Removes the enrolment attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param enrolment_attached_id the primary key of the enrolment attached file
	* @return the enrolment attached file that was removed
	* @throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException if a enrolment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.EnrolmentAttachedFile remove(
		java.lang.String enrolment_attached_id)
		throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(enrolment_attached_id);
	}

	public static com.fsoft.bn.model.EnrolmentAttachedFile updateImpl(
		com.fsoft.bn.model.EnrolmentAttachedFile enrolmentAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(enrolmentAttachedFile, merge);
	}

	/**
	* Returns the enrolment attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchEnrolmentAttachedFileException} if it could not be found.
	*
	* @param enrolment_attached_id the primary key of the enrolment attached file
	* @return the enrolment attached file
	* @throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException if a enrolment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.EnrolmentAttachedFile findByPrimaryKey(
		java.lang.String enrolment_attached_id)
		throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(enrolment_attached_id);
	}

	/**
	* Returns the enrolment attached file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param enrolment_attached_id the primary key of the enrolment attached file
	* @return the enrolment attached file, or <code>null</code> if a enrolment attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.EnrolmentAttachedFile fetchByPrimaryKey(
		java.lang.String enrolment_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(enrolment_attached_id);
	}

	/**
	* Returns all the enrolment attached files.
	*
	* @return the enrolment attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.EnrolmentAttachedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the enrolment attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enrolment attached files
	* @param end the upper bound of the range of enrolment attached files (not inclusive)
	* @return the range of enrolment attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.EnrolmentAttachedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the enrolment attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of enrolment attached files
	* @param end the upper bound of the range of enrolment attached files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of enrolment attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.EnrolmentAttachedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the enrolment attached files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of enrolment attached files.
	*
	* @return the number of enrolment attached files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EnrolmentAttachedFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EnrolmentAttachedFilePersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					EnrolmentAttachedFilePersistence.class.getName());

			ReferenceRegistry.registerReference(EnrolmentAttachedFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EnrolmentAttachedFilePersistence persistence) {
	}

	private static EnrolmentAttachedFilePersistence _persistence;
}