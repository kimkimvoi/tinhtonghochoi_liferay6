package com.fsoft.bn.portlet.visitor;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * Portlet implementation class Visitor
 * @author HieuDM
 */
@Controller
@RequestMapping(value = "CONFIG")

public class VisitorConfiguration implements ConfigurationAction {

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		Map<String, String> typeVisitor = StructureUtil.getStructureXSDSelectionListGlobal(NewsContants.VISITOR_STRUCTURE_NAME, "type");
		//

		renderRequest.setAttribute("listType", typeVisitor);
		String portletTypeSelect = null;
		if (prefs.getMap().containsKey("portletTypeSelect")) {
			portletTypeSelect = prefs.getMap().get("portletTypeSelect")[0];
		}
		if (!Validator.isBlankOrNull(portletTypeSelect)) {
			renderRequest.setAttribute("portletTypeSelect", portletTypeSelect);
		} else {
			renderRequest.setAttribute("portletTypeSelect", "am-thuc");
		}
		
		return "/html/portlet/visitor/visitor-config.jsp";
	}

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");
		String portletTypeSelect = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"portletTypeSelect", StringPool.BLANK));
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);
		
		preferences.setValue("portletTypeSelect", portletTypeSelect);
		
		try {
			preferences.store();
		} catch (ValidatorException ve) {
			SessionErrors.add(actionRequest,
					ValidatorException.class.getName(), ve);
			return;
		}

		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		SessionMessages.add(actionRequest, "success");
		}

}
