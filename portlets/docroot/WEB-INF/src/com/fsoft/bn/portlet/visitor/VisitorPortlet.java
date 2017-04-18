package com.fsoft.bn.portlet.visitor;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.Visitor;
import com.fsoft.bn.portlet.visitor.delegate.VisitorDelegate;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Visitor
 */
public class VisitorPortlet extends MVCPortlet {
		
	// handle render request when in VIEW mode
	public void doView(RenderRequest request, RenderResponse response) {
		VisitorDelegate visitorDelegate = new VisitorDelegate();
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			String portletResource = ParamUtil.getString(request, "portletResource");
			if (portletResource == null	|| portletResource.trim().equals("")) {
				portletResource = themeDisplay.getPortletDisplay().getId();
			}
			//
			String portletTypeSelect = "";
			if (request.getPreferences().getMap().containsKey("portletTypeSelect")) {
				portletTypeSelect = request.getPreferences().getMap().get("portletTypeSelect")[0];
			}
			if (Validator.isBlankOrNull(portletTypeSelect)) {
				portletTypeSelect = "am-thuc";	
			}
			
			List<Visitor> lstVisitorNews = visitorDelegate
					.getVisitorNewsArticle(CommonConstants.NUM_0,
							visitorDelegate.getCountVisitorNewsArticle(request), portletTypeSelect, request, response);
			
			request.setAttribute("portletTitle", portletTypeSelect);
			
			request.setAttribute("lstVisitorNews", lstVisitorNews);
						
			super.doView(request, response);
			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PortletException e) {
			e.printStackTrace();
		}
	}

}
