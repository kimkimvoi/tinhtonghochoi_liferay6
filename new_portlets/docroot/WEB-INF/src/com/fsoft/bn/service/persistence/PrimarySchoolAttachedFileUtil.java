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

import com.fsoft.bn.model.PrimarySchoolAttachedFile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the primary school attached file service. This utility wraps {@link PrimarySchoolAttachedFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolAttachedFilePersistence
 * @see PrimarySchoolAttachedFilePersistenceImpl
 * @generated
 */
public class PrimarySchoolAttachedFileUtil {
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
	public static void clearCache(
		PrimarySchoolAttachedFile primarySchoolAttachedFile) {
		getPersistence().clearCache(primarySchoolAttachedFile);
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
	public static List<PrimarySchoolAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PrimarySchoolAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PrimarySchoolAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PrimarySchoolAttachedFile update(
		PrimarySchoolAttachedFile primarySchoolAttachedFile, boolean merge)
		throws SystemException {
		return getPersistence().update(primarySchoolAttachedFile, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PrimarySchoolAttachedFile update(
		PrimarySchoolAttachedFile primarySchoolAttachedFile, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(primarySchoolAttachedFile, merge, serviceContext);
	}

	/**
	* Caches the primary school attached file in the entity cache if it is enabled.
	*
	* @param primarySchoolAttachedFile the primary school attached file
	*/
	public static void cacheResult(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile) {
		getPersistence().cacheResult(primarySchoolAttachedFile);
	}

	/**
	* Caches the primary school attached files in the entity cache if it is enabled.
	*
	* @param primarySchoolAttachedFiles the primary school attached files
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.PrimarySchoolAttachedFile> primarySchoolAttachedFiles) {
		getPersistence().cacheResult(primarySchoolAttachedFiles);
	}

	/**
	* Creates a new primary school attached file with the primary key. Does not add the primary school attached file to the database.
	*
	* @param primarySchool_attached_id the primary key for the new primary school attached file
	* @return the new primary school attached file
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile create(
		java.lang.String primarySchool_attached_id) {
		return getPersistence().create(primarySchool_attached_id);
	}

	/**
	* Removes the primary school attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param primarySchool_attached_id the primary key of the primary school attached file
	* @return the primary school attached file that was removed
	* @throws com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException if a primary school attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile remove(
		java.lang.String primarySchool_attached_id)
		throws com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(primarySchool_attached_id);
	}

	public static com.fsoft.bn.model.PrimarySchoolAttachedFile updateImpl(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(primarySchoolAttachedFile, merge);
	}

	/**
	* Returns the primary school attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException} if it could not be found.
	*
	* @param primarySchool_attached_id the primary key of the primary school attached file
	* @return the primary school attached file
	* @throws com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException if a primary school attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile findByPrimaryKey(
		java.lang.String primarySchool_attached_id)
		throws com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(primarySchool_attached_id);
	}

	/**
	* Returns the primary school attached file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param primarySchool_attached_id the primary key of the primary school attached file
	* @return the primary school attached file, or <code>null</code> if a primary school attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PrimarySchoolAttachedFile fetchByPrimaryKey(
		java.lang.String primarySchool_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(primarySchool_attached_id);
	}

	/**
	* Returns all the primary school attached files.
	*
	* @return the primary school attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PrimarySchoolAttachedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the primary school attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school attached files
	* @param end the upper bound of the range of primary school attached files (not inclusive)
	* @return the range of primary school attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PrimarySchoolAttachedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the primary school attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of primary school attached files
	* @param end the upper bound of the range of primary school attached files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of primary school attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PrimarySchoolAttachedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the primary school attached files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of primary school attached files.
	*
	* @return the number of primary school attached files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PrimarySchoolAttachedFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PrimarySchoolAttachedFilePersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					PrimarySchoolAttachedFilePersistence.class.getName());

			ReferenceRegistry.registerReference(PrimarySchoolAttachedFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PrimarySchoolAttachedFilePersistence persistence) {
	}

	private static PrimarySchoolAttachedFilePersistence _persistence;
}