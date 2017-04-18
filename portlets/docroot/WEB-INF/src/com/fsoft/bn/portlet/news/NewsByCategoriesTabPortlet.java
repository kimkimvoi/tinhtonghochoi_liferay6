package com.fsoft.bn.portlet.news;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import com.fsoft.bn.domain.news.NewsListTabConfig;
import com.fsoft.bn.domain.news.NewsPage;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION.PARAMETER;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.util.GsonUtils;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class NewsByCategoriesTabPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest req, RenderResponse renderResponse) throws IOException, PortletException {
		NewsListTabConfig config = new NewsListTabConfig(req);

		req.setAttribute("config", config);
		super.doView(req, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException, PortletException {
		NewsListTabConfig config = new NewsListTabConfig(req);
		long currentCatId = 0;
		
		if (config.isConfigured()) {
			if (null != config.getCatOrders() && 0 < config.getCatOrders().size()) {
				currentCatId = Long.parseLong(config.getCatOrders().get(0).getKey());
			}
		}
		
		if (!req.getResourceID().equals(RESOURCE_ACTION.LOAD_PAGE)) {
			return;
		}
		
		int pageNum = ParamUtil.get(req, PARAMETER.PAGE_NUM, 1);
		currentCatId = ParamUtil.get(req, PARAMETER.PARAMETER_CATEGORY_ID, currentCatId);
		
		String cateName = StringPool.BLANK;
		for (KeyValuePair cat : config.getCatOrders()) {
			if (cat.getKey().equals(String.valueOf(currentCatId))) {
				cateName = cat.getValue();
			}
		}
		
		NewsPage newsPage = BNJournalArticleLocalServiceUtil.getNewsPage(req, config, currentCatId, cateName, pageNum);
		newsPage.setDisplayType(config.getDisplayType());
		newsPage.trimSummary(config.getSummaryMaxLength());

		ResourceURL resourceURL = res.createResourceURL();
		resourceURL.setResourceID(RESOURCE_ACTION.LOAD_PAGE);
		resourceURL.setParameter(PARAMETER.PARAMETER_CATEGORY_ID, String.valueOf(currentCatId));
		String pageLoadURL = resourceURL.toString();
		newsPage.setLoadPageURL(pageLoadURL);

		super.serveResource(req, PortalUtil.toJSON(res, GsonUtils.toJson(newsPage)));
	}
}