package com.fsoft.bn.portlet.schedule;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsoft.bn.domain.ScheduleViewModel;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * Portlet implementation class Schedule
 * @author KienNN
 */
@Controller
@RequestMapping(value = "CONFIG")
public class ScheduleConfiguration implements ConfigurationAction {
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		ScheduleViewModel model = new ScheduleViewModel();
		String portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
        String viewMode = prefs.getValue("ViewMode", "All");
        String searchMode = prefs.getValue("SearchCondtion", "");
        model.setViewMode(viewMode);
        model.setSearchCondition(searchMode);
        renderRequest.setAttribute("schedule", model);
		return "/html/portlet/schedule/schedule-config.jsp";
	}

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 
		String mode = actionRequest.getParameter("ViewMode");
		String allowSearching = actionRequest.getParameter("SearchMode");
        if (mode != null) {
        	PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
            prefs.setValue("ViewMode", mode);
            prefs.store();
            SessionMessages.add(actionRequest, "success");
            SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
        } else {
        	SessionErrors.add(actionRequest, "error");
        	SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
        }
        
        if(allowSearching != null){
        	PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
            prefs.setValue("SearchCondtion", allowSearching);
            prefs.store();
            SessionMessages.add(actionRequest, "success");
            SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
        } else {
        	PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
            prefs.setValue("SearchCondtion", "");
            prefs.store();
            SessionMessages.add(actionRequest, "success");
            SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
        }
	}
}
