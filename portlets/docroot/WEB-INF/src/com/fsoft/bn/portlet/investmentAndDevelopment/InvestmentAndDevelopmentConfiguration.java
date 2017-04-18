package com.fsoft.bn.portlet.investmentAndDevelopment;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.InvestmentAndDevelopmentConfigModel;
import com.fsoft.bn.service.DataDictionaryService;
import com.fsoft.bn.util.CommonUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * Portlet implementation class InvestmentAndDevelopment
 */
@Controller
@RequestMapping(value = "CONFIG")
public class InvestmentAndDevelopmentConfiguration implements ConfigurationAction {
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		InvestmentAndDevelopmentConfigModel viewMode = new InvestmentAndDevelopmentConfigModel();
		viewMode.setListViewModel(initViewMode(renderRequest));
		viewMode.setDefaultCombobox(new DataDictionary(CommonConstants.NUM_0, 
				CommonUtil.getText(renderRequest, "portlet.investmentanddevelopment.combobox.default.value")));
		String portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
        String defaultSelected = prefs.getValue("ViewModeSelect", CommonConstants.STRING_0);
        viewMode.setDefaultModeSelected(defaultSelected);
		renderRequest.setAttribute("investmentViewMode", viewMode);
		
		return "/html/portlet/investment_and_development/investment-and-development-config.jsp";
	}
	
	public List<DataDictionary> initViewMode(RenderRequest renderRequest) {
		return DataDictionaryService.searchListByNameDomain(
				DataDictionaryService.INVESTMENT_AND_DEVELOPMENT_VIEW_MODE, renderRequest).getRecords();
	}

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 
		String mode = actionRequest.getParameter("ViewModeSelect");
        if (mode != null) {
        	PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
            prefs.setValue("ViewModeSelect", mode);
            prefs.store();
            SessionMessages.add(actionRequest, "success");
            SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
        } else {
        	SessionErrors.add(actionRequest, "error");
        	SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
        }
	}
	
}
