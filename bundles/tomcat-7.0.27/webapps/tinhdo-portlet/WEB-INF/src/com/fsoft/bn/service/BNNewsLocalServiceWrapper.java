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

package com.fsoft.bn.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BNNewsLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       BNNewsLocalService
 * @generated
 */
public class BNNewsLocalServiceWrapper implements BNNewsLocalService,
	ServiceWrapper<BNNewsLocalService> {
	public BNNewsLocalServiceWrapper(BNNewsLocalService bnNewsLocalService) {
		_bnNewsLocalService = bnNewsLocalService;
	}

	/**
	* Adds the b n news to the database. Also notifies the appropriate model listeners.
	*
	* @param bnNews the b n news
	* @return the b n news that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews addBNNews(com.fsoft.bn.model.BNNews bnNews)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.addBNNews(bnNews);
	}

	/**
	* Creates a new b n news with the primary key. Does not add the b n news to the database.
	*
	* @param newsId the primary key for the new b n news
	* @return the new b n news
	*/
	public com.fsoft.bn.model.BNNews createBNNews(long newsId) {
		return _bnNewsLocalService.createBNNews(newsId);
	}

	/**
	* Deletes the b n news with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsId the primary key of the b n news
	* @return the b n news that was removed
	* @throws PortalException if a b n news with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews deleteBNNews(long newsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.deleteBNNews(newsId);
	}

	/**
	* Deletes the b n news from the database. Also notifies the appropriate model listeners.
	*
	* @param bnNews the b n news
	* @return the b n news that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews deleteBNNews(
		com.fsoft.bn.model.BNNews bnNews)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.deleteBNNews(bnNews);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bnNewsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.BNNews fetchBNNews(long newsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.fetchBNNews(newsId);
	}

	/**
	* Returns the b n news with the primary key.
	*
	* @param newsId the primary key of the b n news
	* @return the b n news
	* @throws PortalException if a b n news with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews getBNNews(long newsId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.getBNNews(newsId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the b n newses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of b n newses
	* @param end the upper bound of the range of b n newses (not inclusive)
	* @return the range of b n newses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.BNNews> getBNNewses(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.getBNNewses(start, end);
	}

	/**
	* Returns the number of b n newses.
	*
	* @return the number of b n newses
	* @throws SystemException if a system exception occurred
	*/
	public int getBNNewsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.getBNNewsesCount();
	}

	/**
	* Updates the b n news in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bnNews the b n news
	* @return the b n news that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews updateBNNews(
		com.fsoft.bn.model.BNNews bnNews)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.updateBNNews(bnNews);
	}

	/**
	* Updates the b n news in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bnNews the b n news
	* @param merge whether to merge the b n news with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the b n news that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.BNNews updateBNNews(
		com.fsoft.bn.model.BNNews bnNews, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bnNewsLocalService.updateBNNews(bnNews, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bnNewsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bnNewsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bnNewsLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.util.List<com.fsoft.bn.model.BNNews> getNewsInDay(
		java.util.Date date) {
		return _bnNewsLocalService.getNewsInDay(date);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BNNewsLocalService getWrappedBNNewsLocalService() {
		return _bnNewsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBNNewsLocalService(
		BNNewsLocalService bnNewsLocalService) {
		_bnNewsLocalService = bnNewsLocalService;
	}

	public BNNewsLocalService getWrappedService() {
		return _bnNewsLocalService;
	}

	public void setWrappedService(BNNewsLocalService bnNewsLocalService) {
		_bnNewsLocalService = bnNewsLocalService;
	}

	private BNNewsLocalService _bnNewsLocalService;
}