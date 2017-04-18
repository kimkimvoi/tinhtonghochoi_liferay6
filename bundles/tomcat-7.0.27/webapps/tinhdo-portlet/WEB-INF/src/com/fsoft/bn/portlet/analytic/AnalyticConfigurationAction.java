package com.fsoft.bn.portlet.analytic;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.domain.AnalyticViewMode;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class AnalyticConfigurationAction implements ConfigurationAction{
	private static String ANALYTIC = "Thống kê";
	/** logger */
	private static Logger logger = Logger.getLogger(AnalyticConfigurationAction.class);
	@Override
	public String render(PortletConfig arg0, RenderRequest renderRequest,RenderResponse arg2) throws Exception {				
		//get list content in structure
		List<JournalArticle> journalArticles = StructureUtil.getAllArticleLastVersion(renderRequest, ANALYTIC);
		List<AnalyticViewMode> analyticViewModes;
		analyticViewModes = AnalyticDelegate.getAllAnalyticViewModes(journalArticles);
		renderRequest.setAttribute("analyticViewModes",analyticViewModes);
		
		String portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		
		//get state of radio and set first runtime
		String displayMode = prefs.getValue("displayMode", "config_one");
		renderRequest.setAttribute("displayMode", displayMode);
		
		//get state o check box
		String[] multi = prefs.getMap().get("multi");
		List<String> listStore = convertArrayToList(multi);
		renderRequest.setAttribute("multi", listStore);
		
		return "/html/portlet/analytic/analytic_box_config.jsp";
	}
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String displayMode = ParamUtil.getString(actionRequest, "displayMode");
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);	
		
		//send list checkbox
		String[] multi = actionRequest.getParameterValues("analyticMulti");
		prefs.setValues("multi",multi);
		
		prefs.setValue("displayMode", displayMode);
		prefs.store();
		
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
	}	
	
	//put state checked into checkbox
	public List<String> convertArrayToList(String[] input){
		List<String> listStore = new ArrayList<String>();
		String store = null;
		if(input != null){
			for(int i = 0; i < input.length; i++){
				try {
					store = input[i];
					listStore.add(store);
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
			}
		}
		return listStore;
	}
}
