package com.fsoft.bn.portlet.news;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants.REQUEST.STATUS;
import com.fsoft.bn.domain.news.NewsListTableConfig;
import com.fsoft.bn.portlet.DefaultConfigurationAction;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;

public class NewsByCategoriesTableConfiguration extends DefaultConfigurationAction {

	private NewsListTableConfig config;
	private boolean justUpdateConfig;

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest req, ActionResponse res) throws Exception {
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		config.updateConfig̣(req, prefs);
		prefs.store();

		SessionMessages.add(req, STATUS.SUCCESS);
		justUpdateConfig = true;

		super.processAction(portletConfig, req, res);
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest req, RenderResponse renderResponse) throws Exception {
		super.render(portletConfig, req, renderResponse);

		if (justUpdateConfig) {
			justUpdateConfig = false;
		} else {
			config = new NewsListTableConfig(req);
			config.setStructures(NewsUtils.getChildrenOfNewsStruct(req));
			config.validateConfig();
		}

		req.setAttribute("config", config);
		return configJsp;
	}
}