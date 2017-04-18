package com.fsoft.bn.domain.news;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;

import com.fsoft.bn.constant.CommonConstants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

public class HotNewsConfig extends NewsListTabConfig {

	private String displayMode;
	
	public HotNewsConfig(PortletRequest req) {
	
		super(req);
		
		this.displayMode = prefs.getValue("displayMode", CommonConstants.PORTLET.HOT_NEWS.TOP_VIEW);
	}

	/**
	 * update config from request to Preferences object
	 * 
	 * @param actionRequest
	 * @param prefs
	 * @throws ReadOnlyException
	 */
	public void updateConfig̣(ActionRequest actionRequest, PortletPreferences prefs) throws ReadOnlyException {
		
		// get value from parameter and set value to Preferences
		String displayMode = CommonConstants.PORTLET.HOT_NEWS.TOP_VIEW;
		String quantityItemForSlide = HtmlUtil.escape(ParamUtil.getString(actionRequest, "quantityItemForSlide", StringPool.BLANK));
		String displayTypeListNews = HtmlUtil.escape(ParamUtil.getString(actionRequest, "displayTypeListNews", StringPool.BLANK));
		if (null != displayTypeListNews && displayTypeListNews.equals(CommonConstants.STRING_1)) {
			displayMode = CommonConstants.PORTLET.HOT_NEWS.LATEST_NEWS;
		} else if (displayTypeListNews.equals(CommonConstants.STRING_2)) {
			displayMode = CommonConstants.PORTLET.HOT_NEWS.TOP_VIEW;
		} else if (displayTypeListNews.equals(CommonConstants.STRING_3)) {
			displayMode = CommonConstants.PORTLET.HOT_NEWS.HOT_NEWS;
		}
		
		String startDay = ParamUtil.getString(actionRequest, "startDay");
		String startMonth = ParamUtil.getString(actionRequest, "startMonth");
		String startYear = ParamUtil.getString(actionRequest, "startYear");
		String endDay = ParamUtil.getString(actionRequest, "endDay");
		String endMonth = ParamUtil.getString(actionRequest, "endMonth");
		String endYear = ParamUtil.getString(actionRequest, "endYear");
		
		prefs.setValue("startDay", startDay);
		prefs.setValue("startMonth", startMonth);
		prefs.setValue("startYear", startYear);
		prefs.setValue("endDay", endDay);
		prefs.setValue("endMonth", endMonth);
		prefs.setValue("endYear", endYear);
		prefs.setValue("displayMode", displayMode);
		prefs.setValue("quantityItemForSlide", quantityItemForSlide);
		
		super.updateConfig̣(actionRequest, prefs);
	}
	
	public String getDisplayMode() {
		return displayMode;
	}

	public void setDisplayMode(String displayMode) {
		this.displayMode = displayMode;
	}
}
