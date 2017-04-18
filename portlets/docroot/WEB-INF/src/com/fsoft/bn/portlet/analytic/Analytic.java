package com.fsoft.bn.portlet.analytic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.domain.AnalyticViewMode;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Analytic
 */
public class Analytic extends MVCPortlet {
	private static final String ANALYTIC = "Thống kê";
	/** logger */
	private static Logger logger = Logger.getLogger(Analytic.class);
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// get Article Last Version
		List<JournalArticle> journalArticles = StructureUtil.getAllArticleLastVersion(renderRequest, ANALYTIC);
		List<AnalyticViewMode> analyticViewModes;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String portletResource = ParamUtil.getString(renderRequest, "portletResource");
		PortletPreferences prefs = renderRequest.getPreferences();
		
		if (portletResource == null	|| portletResource.trim().equals("")) {
			portletResource = themeDisplay.getPortletDisplay().getId();
		}
		
		if (!Validator.isBlankOrNull(portletResource)) {
		    try {
				prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		
		String displayMode = prefs.getValue("displayMode", "config_one");
		analyticViewModes = AnalyticDelegate.getAllAnalyticViewModes(journalArticles);
		if(analyticViewModes.size() >= 1){
			if (!Validator.isBlankOrNull(portletResource)) {
				if (displayMode.equals("config_one")) {			
					int index = new Random().nextInt(analyticViewModes.size());
					AnalyticViewMode analyticViewMode = new AnalyticViewMode();
					analyticViewMode = analyticViewModes.get(index);
					renderRequest.setAttribute("analyticViewMode",analyticViewMode);
						
				}else if(displayMode.equals("config_two")){
					String[] arrAnalytic = prefs.getValues("multi", null);			
					List<AnalyticViewMode> list = new ArrayList<AnalyticViewMode>();
					if(arrAnalytic != null){
						for (int i = 0; i < arrAnalytic.length; i++) {
							for (int j = 0; j < analyticViewModes.size(); j++) {			
								if(arrAnalytic[i].equals(analyticViewModes.get(j).getId())){
									list.add(analyticViewModes.get(j));
								}
							}
						}		
					}else{
						list = analyticViewModes;
					}
					renderRequest.setAttribute("list",list);
				}
			}
		} else {
			renderRequest.setAttribute("analyticViewModes", analyticViewModes);
		}
		super.doView(renderRequest, renderResponse);
	}
}