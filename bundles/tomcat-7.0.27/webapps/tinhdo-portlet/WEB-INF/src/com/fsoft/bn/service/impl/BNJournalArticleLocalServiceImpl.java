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

package com.fsoft.bn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.commons.collections.CollectionUtils;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.domain.news.NewsCategory;
import com.fsoft.bn.domain.news.NewsConfig;
import com.fsoft.bn.domain.news.NewsListConfig;
import com.fsoft.bn.domain.news.NewsPage;
import com.fsoft.bn.portlet.news.NewsContants.CONFIG_DEFAULT_VALUE;
import com.fsoft.bn.service.base.BNJournalArticleLocalServiceBaseImpl;
import com.fsoft.bn.service.persistence.BNJournalArticleFinderUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.Validator;
import com.fsoft.bn.util.transformer.JournalArticle2NewsTransformer;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * The implementation of the b n journal article local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into
 * the {@link com.fsoft.bn.service.BNJournalArticleLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this
 * service can only be accessed from within the same VM.
 * </p>
 * 
 * @author FSOFT
 * @see com.fsoft.bn.service.base.BNJournalArticleLocalServiceBaseImpl
 * @see com.fsoft.bn.service.BNJournalArticleLocalServiceUtil
 */
public class BNJournalArticleLocalServiceImpl extends BNJournalArticleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link com.fsoft.bn.service.BNJournalArticleLocalServiceUtil} to access the b n
	 * journal article local service.
	 */
	public NewsPage getNewsPage(PortletRequest req, NewsConfig config, long categoryid, String cateName, int currentPageNum) {
		return getNews(req, config.getCurrentStruct().getId(), categoryid, cateName, config.getNumPerPage(), currentPageNum,
				config.isIncludePaging(), config.getSortbys());
	}

	public NewsPage getNewsPage(PortletRequest req, NewsListConfig config, int currentPageNum) {
		return getNews(req, config.getCurrentStruct().getId(), config.getCurrentCat().getId(), config.getCurrentCat().getName(), config.getNumPerPage(), currentPageNum,
				config.isIncludePaging(), config.getSortbys());
	}

	@SuppressWarnings("unchecked")
	public NewsPage getNews(PortletRequest req, String structId, long categoryId, int numPerPage, int currentPageNum, boolean paging,
			List<KeyValuePair> sortbys) {
		int totalPageNum = 1;
		if (currentPageNum < 1) {
			currentPageNum = 1;
		}
		if (numPerPage < 1) {
			numPerPage = CONFIG_DEFAULT_VALUE.NUM_PER_PAGE;
		}

		long groupId = PortalUtil.getGroupId(req);
		List<JournalArticle> news;
		if (paging) {
			int newsCount = BNJournalArticleFinderUtil.countNews(groupId, structId, categoryId);
			if (newsCount == 0) {
				return new NewsPage();
			}
			totalPageNum = CommonUtil.getNumberOfPage(newsCount, numPerPage);

			if (currentPageNum > totalPageNum)
				throw new RuntimeException("can not get page number :" + currentPageNum + " exceed total number of page" + totalPageNum);

			news = BNJournalArticleFinderUtil.getNews(groupId, structId, categoryId, (currentPageNum - 1) * numPerPage, currentPageNum
					* numPerPage, sortbys);
		} else {
			news = BNJournalArticleFinderUtil.getNews(groupId, structId, categoryId, 0, numPerPage, sortbys);
		}

		List<News> items = (List<News>) CollectionUtils.collect(news, new JournalArticle2NewsTransformer(req, structId));
		return new NewsPage(req, totalPageNum, currentPageNum, numPerPage, items);
	}
	
	@SuppressWarnings("unchecked")
	public NewsPage getNews(PortletRequest req, String structId, long categoryId, String cateName, int numPerPage, int currentPageNum, boolean paging,
			List<KeyValuePair> sortbys) {
		int totalPageNum = 1;
		if (currentPageNum < 1) {
			currentPageNum = 1;
		}
		if (numPerPage < 1) {
			numPerPage = CONFIG_DEFAULT_VALUE.NUM_PER_PAGE;
		}

		long groupId = PortalUtil.getGroupId(req);
		List<JournalArticle> news;
		if (paging) {
			int newsCount = BNJournalArticleFinderUtil.countNews(groupId, structId, categoryId);
			if (newsCount == 0) {
				return new NewsPage();
			}
			totalPageNum = CommonUtil.getNumberOfPage(newsCount, numPerPage);

			if (currentPageNum > totalPageNum)
				throw new RuntimeException("can not get page number :" + currentPageNum + " exceed total number of page" + totalPageNum);

			news = BNJournalArticleFinderUtil.getNews(groupId, structId, categoryId, (currentPageNum - 1) * numPerPage, currentPageNum
					* numPerPage, sortbys);
		} else {
			news = BNJournalArticleFinderUtil.getNews(groupId, structId, categoryId, 0, numPerPage, sortbys);
		}

		List<News> items = (List<News>) CollectionUtils.collect(news, new JournalArticle2NewsTransformer(req, structId));
		return new NewsPage(req, totalPageNum, currentPageNum, numPerPage, items);
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getNewsInCategories(PortletRequest req, long groupId, String structureId, List<NewsCategory> lstNewsCate, int numberOfRecord,
			List<KeyValuePair> sortbys, Date fromDate, Date toDate) {
		StringBuffer categoriesId = new StringBuffer();
		for (NewsCategory newsCate : lstNewsCate) {
			categoriesId.append(newsCate.getId());
			categoriesId.append(CommonConstants.COMMA);
		}
		
		if (!Validator.isBlankOrNull(categoriesId) && categoriesId.length() > 0) {
			categoriesId.deleteCharAt(categoriesId.length() -1);
		}
		
		List<JournalArticle> news = BNJournalArticleFinderUtil.getNewsInCategories(groupId, structureId, String.valueOf(categoriesId), numberOfRecord, sortbys, fromDate, toDate);
		
		List<News> lstNews = new ArrayList<News>();
		if (news.size() != 0) {
			lstNews = (List<News>) CollectionUtils.collect(news, new JournalArticle2NewsTransformer(req, structureId));
		}
		
		return lstNews;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<News> getListOtherNewsInDetailPage(PortletRequest req, long groupId, String structureId, String articleId,
			String categoriesId, String cateName, List<KeyValuePair> sortbys) {
		List<JournalArticle> news;
		List<JournalArticle> otherLstNews = new ArrayList<JournalArticle>();
		news = BNJournalArticleFinderUtil.getListOtherNewsInDetailPage(groupId, structureId, articleId, categoriesId, sortbys);
		int flag=0;
		for (JournalArticle ja : news) {
			if (flag == 1) {
				otherLstNews.add(ja);
			}
			if (ja.getArticleId().equals(articleId)) {
				flag = 1;
			}
		}
		List<News> lstNews =  (List<News>) CollectionUtils.collect(otherLstNews, new JournalArticle2NewsTransformer(req, structureId));
		return lstNews;
		
	}
}