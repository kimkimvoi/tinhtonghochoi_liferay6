package com.fsoft.bn.portlet.admin.schedule;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AdminScheduleModel;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.Page;
import com.fsoft.bn.domain.ScheduleModel;
import com.fsoft.bn.domain.ScheduleSearchModel;
import com.fsoft.bn.domain.ScheduleViewModel;
import com.fsoft.bn.domain.UserScheduleModel;
import com.fsoft.bn.model.Schedule;
import com.fsoft.bn.model.impl.ScheduleImpl;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION.PARAMETER;
import com.fsoft.bn.service.ScheduleLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.PortletRequestUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Portlet implementation class AdminSchedule
 * 
 * @author KienNN
 */
@Controller
@RequestMapping(value = "VIEW")
public class AdminSchedule {
	/** logger */
	private static Logger logger = Logger.getLogger(AdminSchedule.class);
	Gson gson = new Gson();
	
	@RenderMapping
	public ModelAndView handleRenderRequest(RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		AdminScheduleModel model = initModelView(renderRequest);
		
		renderRequest.setAttribute("admin", model);
		return new ModelAndView("admin_schedule/admin-schedule-view");
	}

	/**
	 * Search schedule by selected month/year
	 * @param request
	 * @param response
	 * @return json ScheduleViewModel
	 */
	@ResourceMapping("scheduleSaveUserAjaxAction")
	public void scheduleSaveUserAjaxAction(PortletRequest request, ResourceResponse response) {
		try {
			String users = ParamUtil.getString(request, "users");
			if (Validator.isBlankOrNull(users)) {
				ScheduleLocalServiceUtil.allowDisplaySchedule(new String[]{});
				response.getWriter().write(gson.toJson(CommonConstants.SUCCESS));
			} else {
				ScheduleLocalServiceUtil.allowDisplaySchedule(users.split(CommonConstants.COMMA));
				response.getWriter().write(gson.toJson(CommonConstants.SUCCESS));
			}
			
		} catch (IOException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	/**
	 * Search Monthly User Schedule
	 * @param request
	 * @param response
	 */
	@ResourceMapping("scheduleSearchUserMonthScheduleAjaxAction")
	public void scheduleSearchUserMonthScheduleAjaxAction(PortletRequest request, ResourceResponse response) {
		try {
			String selectedUserId = ParamUtil.getString(request, "_cbx_users");
			if (Validator.isBlankOrNull(selectedUserId)) {
				response.getWriter().write(gson.toJson(CommonConstants.FAIL));
			} else {
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
				
				List<ScheduleModel> weekScheduleList = ScheduleLocalServiceUtil.getScheduleBy(selectedUserId, currentMonth, currentYear, locale);
				
				ScheduleSearchModel mScheduleSearchModel = new ScheduleSearchModel();
				mScheduleSearchModel.setMonths(ScheduleLocalServiceUtil.getMounths());
				mScheduleSearchModel.setYears(ScheduleLocalServiceUtil.getYears());
				mScheduleSearchModel.setSelectedMonth(String.valueOf(currentMonth));
				mScheduleSearchModel.setSelectedYear(String.valueOf(currentYear));
				
				model.setWeekScheduleList(weekScheduleList);
				model.setSearchModel(mScheduleSearchModel);
				response.getWriter().write(gson.toJson(model));
			}
			
		} catch (IOException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	/**
	 * Save user month schedule
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	@ResourceMapping("saveUserMonthScheduleAjaxAction")
	public void saveUserMonthScheduleAjaxAction(PortletRequest request, ResourceResponse response) {
		try {
			String selectedUserId = ParamUtil.getString(request, "_cbx_users");
			if (Validator.isBlankOrNull(selectedUserId)) {
				response.getWriter().write(gson.toJson(CommonConstants.FAIL));
			} else {
				ScheduleViewModel model = new ScheduleViewModel();
				
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				Locale locale = themeDisplay.getLocale();
				int currentMonth = ScheduleLocalServiceUtil.getCurrentMonth();
				int currentYear = ScheduleLocalServiceUtil.getCurrentYear();
				String sMonth = ParamUtil.getString(request, "monthOfSchedule");
				String sYear = ParamUtil.getString(request, "yearOfSchedule");
				
				if (!Validator.isBlankOrNull(sMonth) && !Validator.isBlankOrNull(sYear)) {
					currentMonth = Integer.parseInt(sMonth);
					currentYear = Integer.parseInt(sYear);
				}
				
				List<ScheduleModel> weekScheduleList = ScheduleLocalServiceUtil.getScheduleBy(selectedUserId, currentMonth, currentYear, locale);
				Schedule schedule;
				String content;
				Calendar cal = Calendar.getInstance();
				// Save schedule
				for (ScheduleModel s : weekScheduleList) {
					Date date = DateUtils.string2Date(s.getStartDate(), LanguageUtil.get(locale, CommonConstants.scheduleTitleDateFormat));
					cal.setTime(date);
					for (int i = Calendar.MONDAY; i < Calendar.SATURDAY; i++) {
						content = ParamUtil.getString(request, s.getWeekOfYear()+CommonConstants.DASK+i);
						//Delete current schedule date
						DynamicQuery dynamicQuery = buildDynamicQuery(selectedUserId, cal.getTime());
						List<Schedule> deletedList = ScheduleLocalServiceUtil.dynamicQuery(dynamicQuery);
						for (Schedule deletedSchedule : deletedList) {
							ScheduleLocalServiceUtil.deleteSchedule(deletedSchedule);
						}
						if (!Validator.isBlankOrNull(content)) {
							schedule = new ScheduleImpl();
							schedule.setSchedule_date(cal.getTime());
							schedule.setContent(content);
							schedule.setUser_id(selectedUserId);
							schedule.setCreated_date(new Date());
							schedule.setModified_date(new Date());
							ScheduleLocalServiceUtil.addSchedule(schedule);
						}
						cal.add(Calendar.DATE, CommonConstants.NUM_1);
					}
				}
				//reload schedule
				weekScheduleList = ScheduleLocalServiceUtil.getScheduleBy(selectedUserId, currentMonth, currentYear, locale);
				model.setWeekScheduleList(weekScheduleList);
				response.getWriter().write(gson.toJson(model));
			}
			
		} catch (IOException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	/**
	 * This method using get list all users
	 * @param request 
	 * @param response 
	 */
	@ResourceMapping("getAllUsers")
	public void getAllUsers(ResourceRequest request, ResourceResponse response) {	
		try {
			int pageNum = PortletRequestUtil.getIntParameter(request, PARAMETER.PAGE_NUM);
			String keyword = PortletRequestUtil.getStringParameter(request, PARAMETER.KEYWORD);
			int start = CommonConstants.NUM_5 * (pageNum - 1);
			int end = start + CommonConstants.NUM_5;

			List<UserScheduleModel> userScheduleModels = ScheduleLocalServiceUtil.getUserSchedules(start, end, keyword);
			int numOfPage = CommonUtil.getNumberOfPage(ScheduleLocalServiceUtil.countUserSchedules(keyword), CommonConstants.NUM_5);
			
			Page<UserScheduleModel> page = new Page<UserScheduleModel>(request , numOfPage , pageNum,
					CommonConstants.NUM_5, userScheduleModels);
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(page));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * This method using get list allow display shcedule users
	 * @param request 
	 * @param response 
	 */
	@ResourceMapping("getUsersSchedule")
	public void getUsersSchedule(ResourceRequest request, ResourceResponse response) {	
		try {
			List<UserScheduleModel> userSchedules = new ArrayList<UserScheduleModel>();
			List<UserScheduleModel> users = ScheduleLocalServiceUtil.getUserSchedules();
			for (UserScheduleModel user : users) {
				if (user.isDisplaySchedule()) {
					userSchedules.add(user);
				}
			}
			Gson gson = new Gson();				
			response.getWriter().write(gson.toJson(userSchedules));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * build DynamicQuery
	 * @param userId
	 * @param date
	 * @return
	 */
	private DynamicQuery buildDynamicQuery(String userId, Date date) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
				.forClass(Schedule.class);
		
		Timestamp time = new Timestamp(date.getTime());
		dynamicQuery.add(PropertyFactoryUtil.forName("user_id").eq(userId));
		dynamicQuery.add(PropertyFactoryUtil.forName("schedule_date").eq(time));

		return dynamicQuery;
	}
	
	/**
	 * @author KienNN
	 * @param renderRequest
	 * @return
	 * @throws Exception
	 */
	private AdminScheduleModel initModelView(RenderRequest renderRequest)
			throws Exception {
		AdminScheduleModel model = new AdminScheduleModel();
		List<UserScheduleModel> userScheduleModels = ScheduleLocalServiceUtil.getUserSchedules();
		ScheduleSearchModel searchModel = new ScheduleSearchModel();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		List<DataDictionary> months = ScheduleLocalServiceUtil.getMounths();
		List<DataDictionary> years = ScheduleLocalServiceUtil.getYears();
		//Get current month
		int currentMonth = ScheduleLocalServiceUtil.getCurrentMonth();
		//Get current year
		int currentYear = ScheduleLocalServiceUtil.getCurrentYear();
		String currentUser = StringPool.BLANK;
		if (null != userScheduleModels && userScheduleModels.size() > 0) {
			for (UserScheduleModel u : userScheduleModels) {
				if (u.isDisplaySchedule()) {
					currentUser = u.getUserId();
					break;
				}
			}
		}

		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add("userName");
		displayedPropertyList.add("jobTitleName");

		searchModel.setMonths(months);
		searchModel.setYears(years);
		searchModel.setUsers(userScheduleModels);
		searchModel.setSelectedMonth(String.valueOf(currentMonth));
		searchModel.setSelectedYear(String.valueOf(currentYear));
		searchModel.setSelectedUser(currentUser);
		//Get month schedule model
		List<ScheduleModel> weekScheduleList = ScheduleLocalServiceUtil.getScheduleBy(currentUser, currentMonth, currentYear, locale);
		//Get weekly schedule 
		model.setUserProperties(displayedPropertyList);
		model.setUsersSchedule(userScheduleModels);
		model.setScheduleSearch(searchModel);
		model.setMonthSchedule(weekScheduleList);
		model.setMonthOfSchedule(currentMonth);
		model.setYearOfSchedule(currentYear);
		return model;
	}
}
