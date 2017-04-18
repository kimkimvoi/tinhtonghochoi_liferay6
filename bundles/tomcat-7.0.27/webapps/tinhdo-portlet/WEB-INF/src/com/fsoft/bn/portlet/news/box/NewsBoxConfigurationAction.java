package com.fsoft.bn.portlet.news.box;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class NewsBoxConfigurationAction implements ConfigurationAction {
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String newsBoxTitleInput = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"newsBoxTitle", StringPool.BLANK));
		String newsBoxTypeSelect = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"newsBoxTypeSelect", StringPool.BLANK));
		String displayFullSize = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"displayFullSize", StringPool.FALSE));
		String displayImage = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"displayImage", StringPool.FALSE));
		String displaySummary = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"displaySummary", StringPool.FALSE));
		
		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);
		
		preferences.setValue("newsBoxTitle", newsBoxTitleInput);
		preferences.setValue("newsBoxTypeSelect", newsBoxTypeSelect);
		preferences.setValue("displayFullSize", displayFullSize);
		preferences.setValue("displayImage", displayImage);
		preferences.setValue("displaySummary", displaySummary);
		
		try {
			preferences.store();
		} catch (ValidatorException ve) {
			SessionErrors.add(actionRequest,
					ValidatorException.class.getName(), ve);
			return;
		}

//		SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		SessionMessages.add(actionRequest, "success");
	}
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		//
		Map<String, String> listTypes = StructureUtil.getStructureXSDSelectionList(renderRequest,
				"News", "type");
		renderRequest.setAttribute("listTypes", listTypes);
		
		//
		String portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		
		//
		String newsBoxTitle = null;
		if (prefs.getMap().containsKey("newsBoxTitle")) {
			newsBoxTitle = prefs.getMap().get("newsBoxTitle")[0];
		}
		
		if (Validator.isBlankOrNull(newsBoxTitle)) {
			newsBoxTitle = CommonConstants.BLANK;
		}
		renderRequest.setAttribute("newsBoxTitle", newsBoxTitle);
		
		//
		String newsBoxTypeSelect = null;
		if (prefs.getMap().containsKey("newsBoxTypeSelect")) {
			newsBoxTypeSelect = prefs.getMap().get("newsBoxTypeSelect")[0];
		}
		renderRequest.setAttribute("newsBoxTypeSelect", newsBoxTypeSelect);
				
		//
		String displayFullSize = null;
		if (prefs.getMap().containsKey("displayFullSize")) {
			displayFullSize = prefs.getMap().get("displayFullSize")[0];
		}
		renderRequest.setAttribute("displayFullSize", displayFullSize);
		
		//
		String displayImage  = null;
		if (prefs.getMap().containsKey("displayImage")) {
			displayImage = prefs.getMap().get("displayImage")[0];
		}
		renderRequest.setAttribute("displayImage", displayImage);
		
		//
		String displaySummary = null;
		if (prefs.getMap().containsKey("displaySummary")) {
			displaySummary = prefs.getMap().get("displaySummary")[0];
		}
		renderRequest.setAttribute("displaySummary", displaySummary);
		
		return "/html/portlet/news_box/news-box-config.jsp";
	}
}