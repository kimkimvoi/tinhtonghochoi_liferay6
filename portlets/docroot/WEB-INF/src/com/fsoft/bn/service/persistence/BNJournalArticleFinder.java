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

/**
 * @author FSOFT
 */
public interface BNJournalArticleFinder {
	public int countNews(long groupId, java.lang.String structureId,
		long categoryId);

	public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getNews(
		long groupId, java.lang.String structureId, long categoryId, int start,
		int end,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys);

	public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getNewsInCategories(
		long groupId, java.lang.String structureId,
		java.lang.String categoriesId, int numberRecord,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys,
		java.util.Date fromDate, java.util.Date toDate);

	public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getListOtherNewsInDetailPage(
		long groupId, java.lang.String structureId, java.lang.String articleId,
		java.lang.String categoriesId,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys);
}