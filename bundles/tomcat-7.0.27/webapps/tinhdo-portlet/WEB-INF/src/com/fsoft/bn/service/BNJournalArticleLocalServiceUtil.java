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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the b n journal article local service. This utility wraps {@link com.fsoft.bn.service.impl.BNJournalArticleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see BNJournalArticleLocalService
 * @see com.fsoft.bn.service.base.BNJournalArticleLocalServiceBaseImpl
 * @see com.fsoft.bn.service.impl.BNJournalArticleLocalServiceImpl
 * @generated
 */
public class BNJournalArticleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.fsoft.bn.service.impl.BNJournalArticleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.fsoft.bn.domain.news.NewsPage getNewsPage(
		javax.portlet.PortletRequest req,
		com.fsoft.bn.domain.news.NewsConfig config, long categoryid,
		java.lang.String cateName, int currentPageNum) {
		return getService()
				   .getNewsPage(req, config, categoryid, cateName,
			currentPageNum);
	}

	public static com.fsoft.bn.domain.news.NewsPage getNewsPage(
		javax.portlet.PortletRequest req,
		com.fsoft.bn.domain.news.NewsListConfig config, int currentPageNum) {
		return getService().getNewsPage(req, config, currentPageNum);
	}

	public static com.fsoft.bn.domain.news.NewsPage getNews(
		javax.portlet.PortletRequest req, java.lang.String structId,
		long categoryId, int numPerPage, int currentPageNum, boolean paging,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		return getService()
				   .getNews(req, structId, categoryId, numPerPage,
			currentPageNum, paging, sortbys);
	}

	public static com.fsoft.bn.domain.news.NewsPage getNews(
		javax.portlet.PortletRequest req, java.lang.String structId,
		long categoryId, java.lang.String cateName, int numPerPage,
		int currentPageNum, boolean paging,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		return getService()
				   .getNews(req, structId, categoryId, cateName, numPerPage,
			currentPageNum, paging, sortbys);
	}

	public static java.util.List<com.fsoft.bn.domain.news.News> getNewsInCategories(
		javax.portlet.PortletRequest req, long groupId,
		java.lang.String structureId,
		java.util.List<com.fsoft.bn.domain.news.NewsCategory> lstNewsCate,
		int numberOfRecord,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys,
		java.util.Date fromDate, java.util.Date toDate) {
		return getService()
				   .getNewsInCategories(req, groupId, structureId, lstNewsCate,
			numberOfRecord, sortbys, fromDate, toDate);
	}

	public static java.util.List<com.fsoft.bn.domain.news.News> getListOtherNewsInDetailPage(
		javax.portlet.PortletRequest req, long groupId,
		java.lang.String structureId, java.lang.String articleId,
		java.lang.String categoriesId, java.lang.String cateName,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		return getService()
				   .getListOtherNewsInDetailPage(req, groupId, structureId,
			articleId, categoriesId, cateName, sortbys);
	}

	public static void clearService() {
		_service = null;
	}

	public static BNJournalArticleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BNJournalArticleLocalService.class.getName());

			if (invokableLocalService instanceof BNJournalArticleLocalService) {
				_service = (BNJournalArticleLocalService)invokableLocalService;
			}
			else {
				_service = new BNJournalArticleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BNJournalArticleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(BNJournalArticleLocalService service) {
	}

	private static BNJournalArticleLocalService _service;
}