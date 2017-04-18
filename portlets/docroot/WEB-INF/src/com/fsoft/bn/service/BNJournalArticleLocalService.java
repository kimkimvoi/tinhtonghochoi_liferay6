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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The interface for the b n journal article local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see BNJournalArticleLocalServiceUtil
 * @see com.fsoft.bn.service.base.BNJournalArticleLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.BNJournalArticleLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BNJournalArticleLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BNJournalArticleLocalServiceUtil} to access the b n journal article local service. Add custom service methods to {@link com.fsoft.bn.service.impl.BNJournalArticleLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.fsoft.bn.domain.news.NewsPage getNewsPage(
		javax.portlet.PortletRequest req,
		com.fsoft.bn.domain.news.NewsConfig config, long categoryid,
		java.lang.String cateName, int currentPageNum);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.fsoft.bn.domain.news.NewsPage getNewsPage(
		javax.portlet.PortletRequest req,
		com.fsoft.bn.domain.news.NewsListConfig config, int currentPageNum);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.fsoft.bn.domain.news.NewsPage getNews(
		javax.portlet.PortletRequest req, java.lang.String structId,
		long categoryId, int numPerPage, int currentPageNum, boolean paging,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.fsoft.bn.domain.news.NewsPage getNews(
		javax.portlet.PortletRequest req, java.lang.String structId,
		long categoryId, java.lang.String cateName, int numPerPage,
		int currentPageNum, boolean paging,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.fsoft.bn.domain.news.News> getNewsInCategories(
		javax.portlet.PortletRequest req, long groupId,
		java.lang.String structureId,
		java.util.List<com.fsoft.bn.domain.news.NewsCategory> lstNewsCate,
		int numberOfRecord,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys,
		java.util.Date fromDate, java.util.Date toDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.fsoft.bn.domain.news.News> getListOtherNewsInDetailPage(
		javax.portlet.PortletRequest req, long groupId,
		java.lang.String structureId, java.lang.String articleId,
		java.lang.String categoriesId, java.lang.String cateName,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys);
}