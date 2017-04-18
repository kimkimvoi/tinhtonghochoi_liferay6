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

import com.fsoft.bn.model.RecruitmentLanguages;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the recruitment languages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentLanguagesPersistenceImpl
 * @see RecruitmentLanguagesUtil
 * @generated
 */
public interface RecruitmentLanguagesPersistence extends BasePersistence<RecruitmentLanguages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecruitmentLanguagesUtil} to access the recruitment languages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the recruitment languages in the entity cache if it is enabled.
	*
	* @param recruitmentLanguages the recruitment languages
	*/
	public void cacheResult(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages);

	/**
	* Caches the recruitment languageses in the entity cache if it is enabled.
	*
	* @param recruitmentLanguageses the recruitment languageses
	*/
	public void cacheResult(
		java.util.List<com.fsoft.bn.model.RecruitmentLanguages> recruitmentLanguageses);

	/**
	* Creates a new recruitment languages with the primary key. Does not add the recruitment languages to the database.
	*
	* @param recruitment_languages_id the primary key for the new recruitment languages
	* @return the new recruitment languages
	*/
	public com.fsoft.bn.model.RecruitmentLanguages create(
		java.lang.String recruitment_languages_id);

	/**
	* Removes the recruitment languages with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recruitment_languages_id the primary key of the recruitment languages
	* @return the recruitment languages that was removed
	* @throws com.fsoft.bn.NoSuchRecruitmentLanguagesException if a recruitment languages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages remove(
		java.lang.String recruitment_languages_id)
		throws com.fsoft.bn.NoSuchRecruitmentLanguagesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.fsoft.bn.model.RecruitmentLanguages updateImpl(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment languages with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentLanguagesException} if it could not be found.
	*
	* @param recruitment_languages_id the primary key of the recruitment languages
	* @return the recruitment languages
	* @throws com.fsoft.bn.NoSuchRecruitmentLanguagesException if a recruitment languages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages findByPrimaryKey(
		java.lang.String recruitment_languages_id)
		throws com.fsoft.bn.NoSuchRecruitmentLanguagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the recruitment languages with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recruitment_languages_id the primary key of the recruitment languages
	* @return the recruitment languages, or <code>null</code> if a recruitment languages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.RecruitmentLanguages fetchByPrimaryKey(
		java.lang.String recruitment_languages_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the recruitment languageses.
	*
	* @return the recruitment languageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentLanguages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the recruitment languageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment languageses
	* @param end the upper bound of the range of recruitment languageses (not inclusive)
	* @return the range of recruitment languageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentLanguages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the recruitment languageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of recruitment languageses
	* @param end the upper bound of the range of recruitment languageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of recruitment languageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.RecruitmentLanguages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the recruitment languageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of recruitment languageses.
	*
	* @return the number of recruitment languageses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}