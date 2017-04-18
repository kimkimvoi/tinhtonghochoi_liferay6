package com.fsoft.bn.portlet.news.hot;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.news.HotNewsConfig;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class HotNewsConfigurationAction extends com.fsoft.bn.portlet.DefaultConfigurationAction {
	
	private HotNewsConfig config;
	private boolean justUpdateConfig;
	
	public String render(PortletConfig portletConfig, RenderRequest req, RenderResponse renderResponse) throws Exception {

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(new Date());
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);

		String portletResource = ParamUtil.getString(req, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil .getPortletSetup(req, portletResource);

		// get displayMode
		String displayMode = null;
		if (prefs.getMap().containsKey("displayMode")) {
			displayMode = prefs.getMap().get("displayMode")[0];
		}
		if (!Validator.isBlankOrNull(displayMode)) {
			if (displayMode.equals(CommonConstants.PORTLET.HOT_NEWS.HOT_NEWS) || displayMode.equals(CommonConstants.PORTLET.HOT_NEWS.LATEST_NEWS)) {
				req.setAttribute("hideRangeDate", StringPool.TRUE);
			} else {
				req.setAttribute("hideRangeDate", StringPool.FALSE);
			}
		} else {
			req.setAttribute("hideRangeDate", StringPool.TRUE);
		}
		
		// get quatityItem
		String numberRecord = null;
		if (prefs.getMap().containsKey("quantityItemForSlide")) {
			numberRecord = prefs.getMap().get("quantityItemForSlide")[0];
		} else {
			numberRecord = String.valueOf(CommonConstants.NUM_6);
		}
		req.setAttribute("quantityItemForSlide", numberRecord);
		
		// set startDay
		String startDay = null;
		if (prefs.getMap().containsKey("startDay")) {
			startDay = prefs.getMap().get("startDay")[0];
		} else {
			startDay = String.valueOf(currentDay);
		}
		req.setAttribute("startDay", startDay);
		
		String startMonth = null;
		if (prefs.getMap().containsKey("startMonth")) {
			startMonth = prefs.getMap().get("startMonth")[0];
		} else {
			startMonth =  String.valueOf(currentMonth);
		}
		req.setAttribute("startMonth", startMonth);
		
		String startYear = null;
		if (prefs.getMap().containsKey("startYear")) {
			startYear = prefs.getMap().get("startYear")[0];
		} else {
			startYear = String.valueOf(1950);
		}
		req.setAttribute("startYear", startYear);		

		String endDay = null;
		if (prefs.getMap().containsKey("endDay")) {
			endDay = prefs.getMap().get("endDay")[0];
		} else {
			endDay = String.valueOf(currentDay);
		}
		req.setAttribute("endDay", endDay);
		
		String endMonth = null;
		if (prefs.getMap().containsKey("endMonth")) {
			endMonth = prefs.getMap().get("endMonth")[0];
		} else {
			endMonth = String.valueOf(currentMonth);
		}
		req.setAttribute("endMonth", endMonth);
		
		String endYear = null;
		if (prefs.getMap().containsKey("endYear")) {
			endYear = prefs.getMap().get("endYear")[0];
		} else {
			endYear = String.valueOf(currentYear);
		}
		req.setAttribute("endYear", endYear);
		
		if (justUpdateConfig) {
			justUpdateConfig = false;
		} else {
			config = new HotNewsConfig(req);
			config.setStructures(NewsUtils.getChildrenOfNewsStruct(req));
			config.validateConfig();
		}
		req.setAttribute("config", config);
		
		return "/html/portlet/hot_news/hot-news-configuration.jsp";
	}
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest req, ActionResponse actionResponse) throws Exception {
		
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		
		config.updateConfig̣(req, prefs);
		prefs.store();
		
		justUpdateConfig = true;
		
		SessionMessages.add(req, "success");
		super.processAction(portletConfig, req, actionResponse);
	}
}