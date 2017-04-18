package com.fsoft.bn.portlet.video.gallerycollection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.constant.CommonConstants.REQUEST.STATUS;
import com.fsoft.bn.portlet.DefaultConfigurationAction;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

public class VideoGalleryCollectionConfiguration extends DefaultConfigurationAction {
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest req, ActionResponse res) throws Exception {
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		String numberOfItemsPerPage = ParamUtil.getString(req, "numberOfItemsPerPage");
		int configurationValue = CommonConstants.NUMBER_OF_ITEMS_IN_VIDEO_PAGE;
		try {
			configurationValue = Integer.parseInt(numberOfItemsPerPage);
		} catch (Exception ex) {
			configurationValue = CommonConstants.NUMBER_OF_ITEMS_IN_VIDEO_PAGE;
		}
		
		prefs.setValue("numberOfItemsPerPage", String.valueOf(configurationValue));
		
		//save configuration to DB
		prefs.store();

		SessionMessages.add(req, STATUS.SUCCESS);

		super.processAction(portletConfig, req, res);
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest req, RenderResponse renderResponse) throws Exception {
		super.render(portletConfig, req, renderResponse);
		
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		String numberOfItemsPerPage = prefs.getValue("numberOfItemsPerPage","");
		
		req.setAttribute("numberOfItemsPerPage", numberOfItemsPerPage);
		
		return configJsp;
	}
}