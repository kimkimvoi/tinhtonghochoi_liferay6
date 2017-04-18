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

import com.fsoft.bn.model.AnswerAttachedFile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the answer attached file service. This utility wraps {@link AnswerAttachedFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see AnswerAttachedFilePersistence
 * @see AnswerAttachedFilePersistenceImpl
 * @generated
 */
public class AnswerAttachedFileUtil {
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
	public static void clearCache(AnswerAttachedFile answerAttachedFile) {
		getPersistence().clearCache(answerAttachedFile);
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
	public static List<AnswerAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnswerAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnswerAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AnswerAttachedFile update(
		AnswerAttachedFile answerAttachedFile, boolean merge)
		throws SystemException {
		return getPersistence().update(answerAttachedFile, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AnswerAttachedFile update(
		AnswerAttachedFile answerAttachedFile, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(answerAttachedFile, merge, serviceContext);
	}

	/**
	* Caches the answer attached file in the entity cache if it is enabled.
	*
	* @param answerAttachedFile the answer attached file
	*/
	public static void cacheResult(
		com.fsoft.bn.model.AnswerAttachedFile answerAttachedFile) {
		getPersistence().cacheResult(answerAttachedFile);
	}

	/**
	* Caches the answer attached files in the entity cache if it is enabled.
	*
	* @param answerAttachedFiles the answer attached files
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.AnswerAttachedFile> answerAttachedFiles) {
		getPersistence().cacheResult(answerAttachedFiles);
	}

	/**
	* Creates a new answer attached file with the primary key. Does not add the answer attached file to the database.
	*
	* @param answer_attached_id the primary key for the new answer attached file
	* @return the new answer attached file
	*/
	public static com.fsoft.bn.model.AnswerAttachedFile create(
		java.lang.String answer_attached_id) {
		return getPersistence().create(answer_attached_id);
	}

	/**
	* Removes the answer attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param answer_attached_id the primary key of the answer attached file
	* @return the answer attached file that was removed
	* @throws com.fsoft.bn.NoSuchAnswerAttachedFileException if a answer attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.AnswerAttachedFile remove(
		java.lang.String answer_attached_id)
		throws com.fsoft.bn.NoSuchAnswerAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(answer_attached_id);
	}

	public static com.fsoft.bn.model.AnswerAttachedFile updateImpl(
		com.fsoft.bn.model.AnswerAttachedFile answerAttachedFile, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(answerAttachedFile, merge);
	}

	/**
	* Returns the answer attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchAnswerAttachedFileException} if it could not be found.
	*
	* @param answer_attached_id the primary key of the answer attached file
	* @return the answer attached file
	* @throws com.fsoft.bn.NoSuchAnswerAttachedFileException if a answer attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.AnswerAttachedFile findByPrimaryKey(
		java.lang.String answer_attached_id)
		throws com.fsoft.bn.NoSuchAnswerAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(answer_attached_id);
	}

	/**
	* Returns the answer attached file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param answer_attached_id the primary key of the answer attached file
	* @return the answer attached file, or <code>null</code> if a answer attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.AnswerAttachedFile fetchByPrimaryKey(
		java.lang.String answer_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(answer_attached_id);
	}

	/**
	* Returns all the answer attached files.
	*
	* @return the answer attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.AnswerAttachedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the answer attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of answer attached files
	* @param end the upper bound of the range of answer attached files (not inclusive)
	* @return the range of answer attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.AnswerAttachedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the answer attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of answer attached files
	* @param end the upper bound of the range of answer attached files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of answer attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.AnswerAttachedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the answer attached files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of answer attached files.
	*
	* @return the number of answer attached files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AnswerAttachedFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AnswerAttachedFilePersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					AnswerAttachedFilePersistence.class.getName());

			ReferenceRegistry.registerReference(AnswerAttachedFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AnswerAttachedFilePersistence persistence) {
	}

	private static AnswerAttachedFilePersistence _persistence;
}