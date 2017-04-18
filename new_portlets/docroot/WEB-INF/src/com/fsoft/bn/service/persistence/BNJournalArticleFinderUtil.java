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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author FSOFT
 */
public class BNJournalArticleFinderUtil {
	public static int countNews(long groupId, java.lang.String structureId,
		long categoryId) {
		return getFinder().countNews(groupId, structureId, categoryId);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> getNews(
		long groupId, java.lang.String structureId, long categoryId, int start,
		int end,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		return getFinder()
				   .getNews(groupId, structureId, categoryId, start, end,
			sortbys);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> getNewsInCategories(
		long groupId, java.lang.String structureId,
		java.lang.String categoriesId, int numberRecord,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys,
		java.util.Date fromDate, java.util.Date toDate) {
		return getFinder()
				   .getNewsInCategories(groupId, structureId, categoriesId,
			numberRecord, sortbys, fromDate, toDate);
	}

	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> getListOtherNewsInDetailPage(
		long groupId, java.lang.String structureId, java.lang.String articleId,
		java.lang.String categoriesId,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		return getFinder()
				   .getListOtherNewsInDetailPage(groupId, structureId,
			articleId, categoriesId, sortbys);
	}

	public static BNJournalArticleFinder getFinder() {
		if (_finder == null) {
			_finder = (BNJournalArticleFinder)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					BNJournalArticleFinder.class.getName());

			ReferenceRegistry.registerReference(BNJournalArticleFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BNJournalArticleFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BNJournalArticleFinderUtil.class,
			"_finder");
	}

	private static BNJournalArticleFinder _finder;
}