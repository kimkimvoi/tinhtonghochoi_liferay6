package com.fsoft.bn.portlet.news.detail;

import com.liferay.portal.kernel.portlet.ConfigurationAction;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
public class NewsDetailConfigurationAction implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		/* String portletType = ParamUtil.getString(actionRequest, "portletType");
		String res = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, res);

		  //Read, validate, and then set form parameters as portlet preferences
		  prefs.setValue("typePortlet", ParamUtil.get(actionRequest, "typePortlet", portletType));
		  prefs.store();
		  SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");*/
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		return "/html/portlet/news_detail/news-detail-config.jsp";
	}

}