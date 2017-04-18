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

import com.fsoft.bn.model.Answer;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see AnswerPersistenceImpl
 * @see AnswerUtil
 * @generated
 */
public interface AnswerPersistence extends BasePersistence<Answer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnswerUtil} to access the answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the answer in the entity cache if it is enabled.
	*
	* @param answer the answer
	*/
	public void cacheResult(com.fsoft.bn.model.Answer answer);

	/**
	* Caches the answers in the entity cache if it is enabled.
	*
	* @param answers the answers
	*/
	public void cacheResult(java.util.List<com.fsoft.bn.model.Answer> answers);

	/**
	* Creates a new answer with the primary key. Does not add the answer to the database.
	*
	* @param answer_id the primary key for the new answer
	* @return the new answer
	*/
	public com.fsoft.bn.model.Answer create(java.lang.String answer_id);

	/**
	* Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param answer_id the primary key of the answer
	* @return the answer that was removed
	* @throws com.fsoft.bn.NoSuchAnswerException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Answer remove(java.lang.String answer_id)
		throws com.fsoft.bn.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.Answer updateImpl(
		com.fsoft.bn.model.Answer answer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the answer with the primary key or throws a {@link com.fsoft.bn.NoSuchAnswerException} if it could not be found.
	*
	* @param answer_id the primary key of the answer
	* @return the answer
	* @throws com.fsoft.bn.NoSuchAnswerException if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Answer findByPrimaryKey(
		java.lang.String answer_id)
		throws com.fsoft.bn.NoSuchAnswerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param answer_id the primary key of the answer
	* @return the answer, or <code>null</code> if a answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.Answer fetchByPrimaryKey(
		java.lang.String answer_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the answers.
	*
	* @return the answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Answer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @return the range of answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Answer> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of answers
	* @param end the upper bound of the range of answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.Answer> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the answers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of answers.
	*
	* @return the number of answers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}