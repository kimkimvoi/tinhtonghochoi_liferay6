package com.fsoft.bn.portlet.schedule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.ScheduleModel;
import com.fsoft.bn.domain.ScheduleSearchModel;
import com.fsoft.bn.domain.ScheduleViewModel;
import com.fsoft.bn.domain.WeekScheduleModel;
import com.fsoft.bn.service.ScheduleLocalServiceUtil;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalService;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

/**
 * Portlet implementation class Schedule
 * @author KienNN
 */
@Controller
@RequestMapping(value = "VIEW")
public class Schedule {
	/** logger */
	private static Logger logger = Logger.getLogger(Schedule.class);
	Gson gson = new Gson();
	
	/**
	 * init view
	 * @param renderRequest
	 * @param renderResponse
	 * @return
	 * @throws Exception
	 */
	@RenderMapping
	public ModelAndView handleRenderRequest(PortletRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		ScheduleViewModel model = new ScheduleViewModel();
		ScheduleSearchModel searchModel = new ScheduleSearchModel();

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String portletResource = ParamUtil.getString(renderRequest, "portletResource");
		PortletPreferences prefs = renderRequest.getPreferences();
		
		if (portletResource == null	|| portletResource.trim().equals("")) {
			portletResource = themeDisplay.getPortletDisplay().getId();
		}
		
		if (!Validator.isBlankOrNull(portletResource)) {
		    prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		}
		
        String viewMode = prefs.getValue("ViewMode", "All");
        String searchCondition = prefs.getValue("SearchCondtion", "");
        
		Locale locale = themeDisplay.getLocale();
		List<DataDictionary> months = ScheduleLocalServiceUtil.getMounths();
		List<DataDictionary> years = ScheduleLocalServiceUtil.getYears();
		//Get current month
		int currentMonth = ScheduleLocalServiceUtil.getCurrentMonth();
		//Get current year
		int currentYear = ScheduleLocalServiceUtil.getCurrentYear();

		searchModel.setMonths(months);
		searchModel.setYears(years);
		searchModel.setSelectedMonth(String.valueOf(currentMonth));
		searchModel.setSelectedYear(String.valueOf(currentYear));
		
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add("userName");
		displayedPropertyList.add("monday");
		displayedPropertyList.add("tuesday");
		displayedPropertyList.add("wednesday");
		displayedPropertyList.add("thursday");
		displayedPropertyList.add("friday");
		
		//Get weekly schedule 
		List<ScheduleModel> weekScheduleList = new ArrayList<ScheduleModel>();
		if (viewMode.equals("All")) {
			weekScheduleList = ScheduleLocalServiceUtil.getScheduleBy(currentMonth, currentYear, locale);
		} else {
			int currentWeek = DateUtils.getCurrentWeek();
			// new year
			if (CommonConstants.NUM_1 == currentWeek) {
				currentYear++;
			}
			weekScheduleList = ScheduleLocalServiceUtil.getWeekScheduleBy(currentWeek, currentMonth, currentYear, locale);
		}
		prepateScheduleListToDisplay(weekScheduleList);
		
		model.setSearchModel(searchModel);
		model.setWeekScheduleList(weekScheduleList);
		model.setDisplayedPropertyList(displayedPropertyList);
		model.setSearchCondition(searchCondition);
		
		renderRequest.setAttribute("schedule", model);
		if (viewMode.equals("All")) {
			return new ModelAndView("schedule/schedule-view");
		}
		return new ModelAndView("schedule/schedule-view-current-week");
	}

	/**
	 * Search schedule by selected month/year
	 * @param request
	 * @param response
	 * @return json ScheduleViewModel
	 */
	@ResourceMapping("scheduleSearchAjaxAction")
	public void scheduleSearchAjaxAction(PortletRequest request, ResourceResponse response) {
		try {
			ScheduleViewModel model = new ScheduleViewModel();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			int currentMonth = ScheduleLocalServiceUtil.getCurrentMonth();
			int currentYear = ScheduleLocalServiceUtil.getCurrentYear();
			
			String sMonth = ParamUtil.getString(request, "cbx_schedule_month");
			String sYear = ParamUtil.getString(request, "cbx_schedule_year");
			
			if (!Validator.isBlankOrNull(sMonth) && !Validator.isBlankOrNull(sYear)) {
				currentMonth = Integer.parseInt(sMonth);
				currentYear = Integer.parseInt(sYear);
			}
			
			List<ScheduleModel> weekScheduleList = ScheduleLocalServiceUtil.getScheduleBy(currentMonth, currentYear, locale);
			prepateScheduleListToDisplay(weekScheduleList);
			
			model.setWeekScheduleList(weekScheduleList);
			response.getWriter().write(gson.toJson(model));
			
		} catch (IOException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	@ResourceMapping("scheduleSearchByWeekAjaxAction")
	public void scheduleSearchByWeekAjaxAction(PortletRequest request, ResourceResponse response) {
		try {
			ScheduleViewModel model = new ScheduleViewModel();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			
			int currentMonth = ScheduleLocalServiceUtil.getCurrentMonth();
			int currentYear = ScheduleLocalServiceUtil.getCurrentYear();
			int currentWeek = DateUtils.getCurrentWeek();
			
			String sMonth = ParamUtil.getString(request, "monthSelect");
			String sYear = ParamUtil.getString(request, "yearSelect");
			String sDay = ParamUtil.getString(request, "daySelect");
			
			if (!Validator.isBlankOrNull(sMonth) && !Validator.isBlankOrNull(sMonth) && !Validator.isBlankOrNull(sDay)) {
				currentMonth = Integer.parseInt(sMonth);
				currentYear = Integer.parseInt(sYear);
				int dayInt = Integer.parseInt(sDay);
				
				currentWeek = DateUtils.getWeekonYear(dayInt, currentMonth, currentYear);
				
			}
			List<ScheduleModel> weekScheduleList = ScheduleLocalServiceUtil.getWeekScheduleBy(currentWeek, currentMonth, currentYear, locale);
			prepateScheduleListToDisplay(weekScheduleList);
			
			model.setWeekScheduleList(weekScheduleList);
			response.getWriter().write(gson.toJson(model));
		} catch (IOException e) {
			logger.info(e.getMessage());	
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	/**
	 * return list schedule to display on page
	 * @return
	 */
	private void prepateScheduleListToDisplay(List<ScheduleModel> list) {
		for(ScheduleModel scheduleModel : list) {
			for (WeekScheduleModel weekScheduleModel : scheduleModel.getSchedule()) {
				weekScheduleModel.setMonday(getDisplayValue(weekScheduleModel.getMonday()));
				weekScheduleModel.setTuesday(getDisplayValue(weekScheduleModel.getTuesday()));
				weekScheduleModel.setWednesday(getDisplayValue(weekScheduleModel.getWednesday()));
				weekScheduleModel.setThursday(getDisplayValue(weekScheduleModel.getThursday()));
				weekScheduleModel.setFriday(getDisplayValue(weekScheduleModel.getFriday()));
			}
		}
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private String getDisplayValue(String value) {
		if (!Validator.isBlankOrNull(value)) {
			return value.replaceAll("\n", "<br />");
		}
		return StringPool.BLANK;
	}
}
