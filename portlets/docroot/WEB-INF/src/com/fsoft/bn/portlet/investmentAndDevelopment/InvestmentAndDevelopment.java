package com.fsoft.bn.portlet.investmentAndDevelopment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.customJSPTags.TableTag;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.DataDictionarySet;
import com.fsoft.bn.domain.InvestmentAndDevelopmentModel;
import com.fsoft.bn.model.InvestmentProjects;
import com.fsoft.bn.service.DataDictionaryService;
import com.fsoft.bn.service.InvestmentProjectsLocalServiceUtil;
import com.fsoft.bn.service.QuestionLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvestmentAndDevelopment
 */
public class InvestmentAndDevelopment extends MVCPortlet {
	/** logger */
	private static Logger logger = Logger.getLogger(InvestmentAndDevelopment.class);
	InvestmentAndDevelopmentModel investmentAndDevelopmentModel;
	Gson gson = new Gson();
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		investmentAndDevelopmentModel = new InvestmentAndDevelopmentModel();
		try {
			setDefaultValue(renderRequest);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		super.doView(renderRequest, renderResponse);
	}
	
	public void setDefaultValue(RenderRequest renderRequest) throws SystemException, PortalException {
		
		String portletResource = ParamUtil.getString(renderRequest, "portletResource");
		PortletPreferences prefs = renderRequest.getPreferences();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (portletResource == null	|| portletResource.trim().equals("")) {
			portletResource = themeDisplay.getPortletDisplay().getId();
		}
		
		if (!Validator.isBlankOrNull(portletResource)) {
		    prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		}
		
		String keyProject = prefs.getValue("ViewModeSelect", CommonConstants.STRING_0);
		investmentAndDevelopmentModel.setKeyProject(keyProject);
		investmentAndDevelopmentModel.setKeyWordSearch(StringPool.BLANK);
		investmentAndDevelopmentModel.setStrLanguage(getLanguage(renderRequest));
		investmentAndDevelopmentModel.setProjectCategory(getProjectCategory(renderRequest));
		//start set data for table
		investmentAndDevelopmentModel.setInvestmentPropertyDisplay(getDisplayedPropertyList());
		investmentAndDevelopmentModel.setHeaderList(CommonUtil.getHeaderList(renderRequest, CommonConstants.investmentList));		
		investmentAndDevelopmentModel.setListInvestmentProjects(populateInvestmentProjects(
				getListInvestmentAndDevelopment(CommonConstants.NUM_0, CommonConstants.QUESTIONS_PER_PAGE),
				investmentAndDevelopmentModel.getProjectCategory()));		
		
		long numOfPage = getInvestmentAndDevelopmentCount();
		investmentAndDevelopmentModel.setNumOfPage(StringPool.BLANK+numOfPage);
		investmentAndDevelopmentModel.setNumPerPage(StringPool.BLANK+CommonConstants.QUESTIONS_PER_PAGE);
		investmentAndDevelopmentModel.setLanguage(getLanguage(renderRequest));
		
		
		String curPageStatusText = CommonUtil.getText(renderRequest, "portlet.common.paging.curPageStatusText");
		investmentAndDevelopmentModel.setCurPageStatusText(curPageStatusText);
		
		String itemsPerPageText = CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText");
		investmentAndDevelopmentModel.setItemsPerPageText(itemsPerPageText);
		//end set data for table
		renderRequest.setAttribute("investmentAndDevelopmentModel", investmentAndDevelopmentModel);
		renderRequest.setAttribute("investmentAndDevelopmentListJson", 
				gson.toJson(investmentAndDevelopmentModel.getListInvestmentProjects()));
		List<Integer> indicatorList = getIndicatorList();
		renderRequest.setAttribute("indicatorList", indicatorList);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String resourceID = resourceRequest.getResourceID();
		if ("investmentAndDevelopmentTable_LoadPage".equals(resourceID)) {
			//call method get data to render
			try {
				investmentAndDevelopmentLoadPage(resourceRequest, resourceResponse);
			} catch (SystemException e) {
				logger.info(e.getMessage());
			}
		} else if ("investmentAndDevelopment_Search".equals(resourceID)) {
			try {
				investmentAndDevelopmentSearch(resourceRequest, resourceResponse);
			} catch (SystemException e) {
				logger.info(e.getMessage());
			}
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private void investmentAndDevelopmentSearch(ResourceRequest request, ResourceResponse response) throws SystemException {
		String searchKeyWord = ParamUtil.getString(request, "keyword");
		// set and store data
		investmentAndDevelopmentModel.setKeyWordSearch(searchKeyWord);
		investmentAndDevelopmentModel.setStrLanguage(getLanguage(request));
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		int start = 0;
		int end = start + numPerPage;
		List<InvestmentProjects> listInvestmentAndDevelopment;
		try {
			long numOfPage = getInvestmentAndDevelopmentCount();
			listInvestmentAndDevelopment = populateInvestmentProjects(
					getListInvestmentAndDevelopment(start, end),
					investmentAndDevelopmentModel.getProjectCategory());	
			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("items", gson.toJson(listInvestmentAndDevelopment));	
			json.put("investmentAndDevelopmentListJson", 
					gson.toJson(investmentAndDevelopmentModel.getListInvestmentProjects()));
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}
	
	private void investmentAndDevelopmentLoadPage(ResourceRequest request, ResourceResponse response) throws SystemException {
		String pageNumStr = ParamUtil.getString(request, "pageNum");		
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		if (numPerPage == 0) {
			numPerPage = CommonConstants.RECORDS_PER_PAGE;
		}
		int pageNum = Integer.parseInt(pageNumStr);					
		int start = numPerPage * (pageNum - 1);					
		int end = start + numPerPage;
		List<InvestmentProjects> listInvestmentAndDevelopment;	
		long numOfPage;
		try {					
			numOfPage = getInvestmentAndDevelopmentCount();
			listInvestmentAndDevelopment = populateInvestmentProjects(
					getListInvestmentAndDevelopment(start, end),
					investmentAndDevelopmentModel.getProjectCategory());
			Gson gson = new Gson();				
			JSONObject json = JSONFactoryUtil.createJSONObject();				
			json.put("items", gson.toJson(listInvestmentAndDevelopment));				
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	private long getInvestmentAndDevelopmentCount() {
		try {
			return CommonUtil.getNumberOfPage(
					QuestionLocalServiceUtil.dynamicQueryCount(builtQuery()), CommonConstants.QUESTIONS_PER_PAGE);
		} catch (SystemException e) {
			logger.info(e.getMessage());
			return 0;
		}
	}
	@SuppressWarnings("unchecked")
	public List<InvestmentProjects> getListInvestmentAndDevelopment(int startIndex, int endIndex) {
		try {
			return InvestmentProjectsLocalServiceUtil.dynamicQuery(builtQuery(), startIndex, endIndex);
		} catch (SystemException e) {
			logger.info(e.getMessage());
			return new ArrayList<InvestmentProjects>();
		}
	}
	
	public DynamicQuery builtQuery() {
		// get properties
		String keyProject 		= investmentAndDevelopmentModel.getKeyProject();
		String searchKeyWord 	= investmentAndDevelopmentModel.getKeyWordSearch();
		// create query
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(InvestmentProjects.class);
		if (keyProject != null && !keyProject.equals(CommonConstants.STRING_0)) {
			if (CommonConstants.STRING_1.equals(keyProject)) {
				dynamicQuery.add(PropertyFactoryUtil.forName("key_project").eq(false));
			} else {
				dynamicQuery.add(PropertyFactoryUtil.forName("key_project").eq(true));
			}		
		}
		
		if (!Validator.isBlankOrNull(searchKeyWord)) {
			Junction junction = RestrictionsFactoryUtil.disjunction();
			junction.add(RestrictionsFactoryUtil.ilike("project_name", "%" + searchKeyWord + "%"))
					.add(RestrictionsFactoryUtil.ilike("project_purpose", "%" + searchKeyWord + "%"))
					.add(RestrictionsFactoryUtil.ilike("technical_specifications", "%" + searchKeyWord + "%"));
			dynamicQuery.add(junction);
		}
		return dynamicQuery;
	}
	
	
	private List<String> getDisplayedPropertyList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add(TableTag.STT);
		displayedPropertyList.add("_project_name");
		return displayedPropertyList;
	}
	
	
	public List<InvestmentProjects> populateInvestmentProjects(List<InvestmentProjects> listInvestmentAndDevelopment , List<DataDictionary> listDataDictionary) {
		for(InvestmentProjects investmentProjects:listInvestmentAndDevelopment) {
			investmentProjects.setTimeStartDisplay(
					CommonUtil.Date2String(investmentProjects.getCreated_date(), CommonConstants.DATE_FORMAT.YYYY_MM_DD));
			investmentProjects.setTimeEndDisplay(
					CommonUtil.Date2String(investmentProjects.getCreated_date(), CommonConstants.DATE_FORMAT.YYYY_MM_DD));
			investmentProjects.setCharterCapitalDisplay(
					CommonUtil.formatMoney(investmentProjects.getCharter_capital(), CommonConstants.MONEY_FORMAT.XXX_XXX_XXX));
			investmentProjects.setInvestAmountMaxDisplay(
					CommonUtil.formatMoney(investmentProjects.getTotal_investment_max(), CommonConstants.MONEY_FORMAT.XXX_XXX_XXX));
			investmentProjects.setInvestAmountMinDisplay(
					CommonUtil.formatMoney(investmentProjects.getTotal_investment_min(), CommonConstants.MONEY_FORMAT.XXX_XXX_XXX));
			for (DataDictionary dataDictionary : listDataDictionary) {
				if (convertToLong(investmentProjects.getProject_category_id()) == dataDictionary.getKey()) {
					investmentProjects.setCategoryDisplay(dataDictionary.getValue());
					break;
				}
			}
		}
		return listInvestmentAndDevelopment;
	}
	
	public Long convertToLong(Object obj) {
		if (null != obj) {
			if (obj instanceof String && !Validator.isBlankOrNull(obj)) {
				return Long.parseLong(obj.toString());
			} else {
				return -1l;
			}
		} else {
			return -1l;
		}
	}
	
	public List<DataDictionary> getCurrency(RenderRequest renderRequest)  {
		DataDictionarySet currency = DataDictionaryService.searchListByNameDomain(
				DataDictionaryService.CURRENCY_TYPES, renderRequest);
		return currency.getRecords();
	}
	
	public List<DataDictionary> getProjectCategory(RenderRequest renderRequest)  {
		DataDictionarySet projectCategory = DataDictionaryService.searchListByNameDomain(
				DataDictionaryService.PROJECT_CATEGORIES, renderRequest);
		return projectCategory.getRecords();
	}
	
	public String getLanguage(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		return locale.getLanguage();
	}
	
	public String getLanguage(ResourceRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		return locale.getLanguage();
	}
	
	private List<Integer> getIndicatorList() {
		List<Integer> indicatorList = new ArrayList<Integer>();
		indicatorList.add(1);
		return indicatorList;
	}
	
}
