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
 * This class is a wrapper for {@link BNJournalArticleLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       BNJournalArticleLocalService
 * @generated
 */
public class BNJournalArticleLocalServiceWrapper
	implements BNJournalArticleLocalService,
		ServiceWrapper<BNJournalArticleLocalService> {
	public BNJournalArticleLocalServiceWrapper(
		BNJournalArticleLocalService bnJournalArticleLocalService) {
		_bnJournalArticleLocalService = bnJournalArticleLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bnJournalArticleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bnJournalArticleLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bnJournalArticleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.fsoft.bn.domain.news.NewsPage getNewsPage(
		javax.portlet.PortletRequest req,
		com.fsoft.bn.domain.news.NewsConfig config, long categoryid,
		java.lang.String cateName, int currentPageNum) {
		return _bnJournalArticleLocalService.getNewsPage(req, config,
			categoryid, cateName, currentPageNum);
	}

	public com.fsoft.bn.domain.news.NewsPage getNewsPage(
		javax.portlet.PortletRequest req,
		com.fsoft.bn.domain.news.NewsListConfig config, int currentPageNum) {
		return _bnJournalArticleLocalService.getNewsPage(req, config,
			currentPageNum);
	}

	public com.fsoft.bn.domain.news.NewsPage getNews(
		javax.portlet.PortletRequest req, java.lang.String structId,
		long categoryId, int numPerPage, int currentPageNum, boolean paging,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		return _bnJournalArticleLocalService.getNews(req, structId, categoryId,
			numPerPage, currentPageNum, paging, sortbys);
	}

	public com.fsoft.bn.domain.news.NewsPage getNews(
		javax.portlet.PortletRequest req, java.lang.String structId,
		long categoryId, java.lang.String cateName, int numPerPage,
		int currentPageNum, boolean paging,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		return _bnJournalArticleLocalService.getNews(req, structId, categoryId,
			cateName, numPerPage, currentPageNum, paging, sortbys);
	}

	public java.util.List<com.fsoft.bn.domain.news.News> getNewsInCategories(
		javax.portlet.PortletRequest req, long groupId,
		java.lang.String structureId,
		java.util.List<com.fsoft.bn.domain.news.NewsCategory> lstNewsCate,
		int numberOfRecord,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys,
		java.util.Date fromDate, java.util.Date toDate) {
		return _bnJournalArticleLocalService.getNewsInCategories(req, groupId,
			structureId, lstNewsCate, numberOfRecord, sortbys, fromDate, toDate);
	}

	public java.util.List<com.fsoft.bn.domain.news.News> getListOtherNewsInDetailPage(
		javax.portlet.PortletRequest req, long groupId,
		java.lang.String structureId, java.lang.String articleId,
		java.lang.String categoriesId, java.lang.String cateName,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		return _bnJournalArticleLocalService.getListOtherNewsInDetailPage(req,
			groupId, structureId, articleId, categoriesId, cateName, sortbys);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BNJournalArticleLocalService getWrappedBNJournalArticleLocalService() {
		return _bnJournalArticleLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBNJournalArticleLocalService(
		BNJournalArticleLocalService bnJournalArticleLocalService) {
		_bnJournalArticleLocalService = bnJournalArticleLocalService;
	}

	public BNJournalArticleLocalService getWrappedService() {
		return _bnJournalArticleLocalService;
	}

	public void setWrappedService(
		BNJournalArticleLocalService bnJournalArticleLocalService) {
		_bnJournalArticleLocalService = bnJournalArticleLocalService;
	}

	private BNJournalArticleLocalService _bnJournalArticleLocalService;
}