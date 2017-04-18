package com.fsoft.bn.portlet.news;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.news.NewsListConfig;
import com.fsoft.bn.domain.news.NewsPage;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION.PARAMETER;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.PortletRequestUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class NewsByCategoryPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest req, RenderResponse res) throws IOException, PortletException {
		
		String structureId = ParamUtil.getString(req, "structId");
		String categoryId = ParamUtil.getString(req, "cateId");

		// TODO:get category name from id or added value to request params
		NewsListConfig config = new NewsListConfig(req);
		if (StringUtils.isNotBlank(structureId) && StringUtils.isNotBlank(categoryId)) {
			config.getCurrentCat().setId(Long.valueOf(categoryId));
			config.getCurrentStruct().setId(structureId);
			config.setConfigured(true);
		} else if (StringUtils.isBlank(config.getCurrentStruct().getId()) && config.getCurrentCat().getId() <= 0) {
			SessionMessages.add(req, CommonConstants.MSG_ERROR);
			super.doView(req, res);
			return;
		}
		NewsPage newsPage = BNJournalArticleLocalServiceUtil.getNewsPage(req, config, 1);
		newsPage.updateConfig(config);

		req.setAttribute("newsPage", newsPage);
		req.setAttribute("config", config);
		super.doView(req, res);
	}

	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException, PortletException {
		if (!req.getResourceID().equals(RESOURCE_ACTION.LOAD_PAGE)) {
			return;
		}

		NewsListConfig config = new NewsListConfig(req);
		int pageNum = PortletRequestUtil.getIntParameter(req, PARAMETER.PAGE_NUM, 1);

		NewsPage newsPage = BNJournalArticleLocalServiceUtil.getNewsPage(req, config, pageNum);
		newsPage.updateConfig(config);

		super.serveResource(req, PortalUtil.toJson(res, newsPage));
	}
}