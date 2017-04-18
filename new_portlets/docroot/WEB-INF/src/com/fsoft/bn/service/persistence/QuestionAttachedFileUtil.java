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

import com.fsoft.bn.model.QuestionAttachedFile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the question attached file service. This utility wraps {@link QuestionAttachedFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see QuestionAttachedFilePersistence
 * @see QuestionAttachedFilePersistenceImpl
 * @generated
 */
public class QuestionAttachedFileUtil {
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
	public static void clearCache(QuestionAttachedFile questionAttachedFile) {
		getPersistence().clearCache(questionAttachedFile);
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
	public static List<QuestionAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuestionAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuestionAttachedFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static QuestionAttachedFile update(
		QuestionAttachedFile questionAttachedFile, boolean merge)
		throws SystemException {
		return getPersistence().update(questionAttachedFile, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static QuestionAttachedFile update(
		QuestionAttachedFile questionAttachedFile, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(questionAttachedFile, merge, serviceContext);
	}

	/**
	* Caches the question attached file in the entity cache if it is enabled.
	*
	* @param questionAttachedFile the question attached file
	*/
	public static void cacheResult(
		com.fsoft.bn.model.QuestionAttachedFile questionAttachedFile) {
		getPersistence().cacheResult(questionAttachedFile);
	}

	/**
	* Caches the question attached files in the entity cache if it is enabled.
	*
	* @param questionAttachedFiles the question attached files
	*/
	public static void cacheResult(
		java.util.List<com.fsoft.bn.model.QuestionAttachedFile> questionAttachedFiles) {
		getPersistence().cacheResult(questionAttachedFiles);
	}

	/**
	* Creates a new question attached file with the primary key. Does not add the question attached file to the database.
	*
	* @param question_attached_id the primary key for the new question attached file
	* @return the new question attached file
	*/
	public static com.fsoft.bn.model.QuestionAttachedFile create(
		java.lang.String question_attached_id) {
		return getPersistence().create(question_attached_id);
	}

	/**
	* Removes the question attached file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param question_attached_id the primary key of the question attached file
	* @return the question attached file that was removed
	* @throws com.fsoft.bn.NoSuchQuestionAttachedFileException if a question attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.QuestionAttachedFile remove(
		java.lang.String question_attached_id)
		throws com.fsoft.bn.NoSuchQuestionAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(question_attached_id);
	}

	public static com.fsoft.bn.model.QuestionAttachedFile updateImpl(
		com.fsoft.bn.model.QuestionAttachedFile questionAttachedFile,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(questionAttachedFile, merge);
	}

	/**
	* Returns the question attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchQuestionAttachedFileException} if it could not be found.
	*
	* @param question_attached_id the primary key of the question attached file
	* @return the question attached file
	* @throws com.fsoft.bn.NoSuchQuestionAttachedFileException if a question attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.QuestionAttachedFile findByPrimaryKey(
		java.lang.String question_attached_id)
		throws com.fsoft.bn.NoSuchQuestionAttachedFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(question_attached_id);
	}

	/**
	* Returns the question attached file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param question_attached_id the primary key of the question attached file
	* @return the question attached file, or <code>null</code> if a question attached file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fsoft.bn.model.QuestionAttachedFile fetchByPrimaryKey(
		java.lang.String question_attached_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(question_attached_id);
	}

	/**
	* Returns all the question attached files.
	*
	* @return the question attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.QuestionAttachedFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the question attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of question attached files
	* @param end the upper bound of the range of question attached files (not inclusive)
	* @return the range of question attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.QuestionAttachedFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the question attached files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of question attached files
	* @param end the upper bound of the range of question attached files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of question attached files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fsoft.bn.model.QuestionAttachedFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the question attached files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of question attached files.
	*
	* @return the number of question attached files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static QuestionAttachedFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QuestionAttachedFilePersistence)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					QuestionAttachedFilePersistence.class.getName());

			ReferenceRegistry.registerReference(QuestionAttachedFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(QuestionAttachedFilePersistence persistence) {
	}

	private static QuestionAttachedFilePersistence _persistence;
}