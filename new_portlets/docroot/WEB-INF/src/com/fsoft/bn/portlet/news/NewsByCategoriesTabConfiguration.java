package com.fsoft.bn.portlet.news;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants.REQUEST.STATUS;
import com.fsoft.bn.domain.news.NewsListTabConfig;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;

public class NewsByCategoriesTabConfiguration extends com.fsoft.bn.portlet.DefaultConfigurationAction {

	private NewsListTabConfig config;
	private boolean justUpdateConfig;

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest req, ActionResponse actionResponse) throws Exception {
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		config.updateConfig̣(req, prefs);
		prefs.store();

		justUpdateConfig = true;
		SessionMessages.add(req, STATUS.SUCCESS);
		super.processAction(portletConfig, req, actionResponse);
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest req, RenderResponse renderResponse) throws Exception {
		super.render(portletConfig, req, renderResponse);

		if (justUpdateConfig) {
			justUpdateConfig = false;
		} else {
			config = new NewsListTabConfig(req);
			config.setStructures(NewsUtils.getChildrenOfNewsStruct(req));
			config.validateConfig();
		}

		req.setAttribute("config", config);
		return configJsp;
	}
}
