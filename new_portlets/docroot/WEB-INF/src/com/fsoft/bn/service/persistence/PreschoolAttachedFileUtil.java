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

import com.fsoft.bn.model.PreschoolAttachedFile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the preschool attached file service. This utility wraps {@link PreschoolAttachedFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PreschoolAttachedFilePersistence
 * @see PreschoolAttachedFilePersistenceImpl
 * @generated
 */
public class PreschoolAttachedFileUtil {
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
	public static void clearCache(PreschoolAttachedFile preschoolAttachedFile) {
		getPersistence().clearCache(preschoolAttachedFile);
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
	public static List<PreschoolAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PreschoolAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PreschoolAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PreschoolAttachedFile update(
		PreschoolAttachedFile preschoolAttachedFile, boolean merge)
		throws SystemException {
		return getPersistence().update(preschoolAttachedFile, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PreschoolAttachedFile update(
		PreschoolAttachedFile preschoolAttachedFile, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(preschoolAttachedFile, merge, serviceContext);
	}

	/**
	* Caches the preschool attached file in the entity cache if it is enabled.
	*
	* @param preschoolAttachedFile the preschool attached file
	*/
	public static void cacheResult(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile) {
		getPersistence().cacheResult(preschoolAttachedFile);
	}

	/**
	* Caches the preschool attached files in the entity cache if it is enabled.
	*
	* @param preschoolAttachedFiles the preschool attached files
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> preschoolAttachedFiles) {
		getPersistence().cacheResult(preschoolAttachedFiles);
	}

	/**
	* Creates a new preschool attached file with the primary key. Does not add the preschool attached file to the database.
	*
	* @param preschool_attached_id the primary key for the new preschool attached file
	* @return the new preschool attached file
	*/
	public static com.fsoft.bn.model.PreschoolAttachedFile create(
		java.lang.String preschool_attached_id) {
		return getPersistence().create(preschool_attached_id);
	}

	/**
	* Removes the preschool attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preschool_attached_id the primary key of the preschool attached file
	* @return the preschool attached file that was removed
	* @throws com.fsoft.bn.NoSuchPreschoolAttachedFileException if a preschool attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PreschoolAttachedFile remove(
		java.lang.String preschool_attached_id)
		throws com.fsoft.bn.NoSuchPreschoolAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(preschool_attached_id);
	}

	public static com.fsoft.bn.model.PreschoolAttachedFile updateImpl(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(preschoolAttachedFile, merge);
	}

	/**
	* Returns the preschool attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchPreschoolAttachedFileException} if it could not be found.
	*
	* @param preschool_attached_id the primary key of the preschool attached file
	* @return the preschool attached file
	* @throws com.fsoft.bn.NoSuchPreschoolAttachedFileException if a preschool attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PreschoolAttachedFile findByPrimaryKey(
		java.lang.String preschool_attached_id)
		throws com.fsoft.bn.NoSuchPreschoolAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(preschool_attached_id);
	}

	/**
	* Returns the preschool attached file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param preschool_attached_id the primary key of the preschool attached file
	* @return the preschool attached file, or <code>null</code> if a preschool attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.PreschoolAttachedFile fetchByPrimaryKey(
		java.lang.String preschool_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(preschool_attached_id);
	}

	/**
	* Returns all the preschool attached files.
	*
	* @return the preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the preschool attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool attached files
	* @param end the upper bound of the range of preschool attached files (not inclusive)
	* @return the range of preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the preschool attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of preschool attached files
	* @param end the upper bound of the range of preschool attached files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.PreschoolAttachedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the preschool attached files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of preschool attached files.
	*
	* @return the number of preschool attached files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PreschoolAttachedFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PreschoolAttachedFilePersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					PreschoolAttachedFilePersistence.class.getName());

			ReferenceRegistry.registerReference(PreschoolAttachedFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PreschoolAttachedFilePersistence persistence) {
	}

	private static PreschoolAttachedFilePersistence _persistence;
}