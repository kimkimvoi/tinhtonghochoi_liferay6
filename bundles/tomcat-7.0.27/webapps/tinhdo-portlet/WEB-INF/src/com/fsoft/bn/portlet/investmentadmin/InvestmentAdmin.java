package com.fsoft.bn.portlet.investmentadmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.customJSPTags.TableTag;
import com.fsoft.bn.domain.DataDictionarySet;
import com.fsoft.bn.model.InvestmentProjects;
import com.fsoft.bn.model.impl.InvestmentProjectsImpl;
import com.fsoft.bn.service.DataDictionaryService;
import com.fsoft.bn.service.InvestmentProjectsLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.DateUtils;
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
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class InvestmentAdmin
 */
public class InvestmentAdmin extends MVCPortlet {
	/** logger */
	private static Logger logger = Logger.getLogger(InvestmentAdmin.class);
	Gson gson = new Gson();
	Map<String, String> searchConditions = new HashMap<String, String>();
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			initForm(renderRequest);
			initTableData(renderRequest);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		super.doView(renderRequest, renderResponse);
	}

	public void addNewInvestmentProject(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		InvestmentProjects project = new InvestmentProjectsImpl();
		String selectedProjectId= ParamUtil.getString(request, "selectedProjectId");
		String projectName= ParamUtil.getString(request, "projectName");
		String totalInvestmentMin= ParamUtil.getString(request, "totalInvestmentMin");
		String totalInvestmentMax= ParamUtil.getString(request, "totalInvestmentMax");
		String implementationLocation= ParamUtil.getString(request, "implementationLocation");
		String startDay = ParamUtil.getString(request, "startDay");
		String startMonth = ParamUtil.getString(request, "startMonth");
		String startYear = ParamUtil.getString(request, "startYear");
		Date startTime = DateUtils.convert2Date(startDay, startMonth, startYear);
		String endDay = ParamUtil.getString(request, "endDay");
		String endMonth = ParamUtil.getString(request, "endMonth");
		String endYear = ParamUtil.getString(request, "endYear");
		Date endTime = DateUtils.convert2Date(endDay, endMonth, endYear);
		String projectPurpose = ParamUtil.getString(request, "projectPurpose");
		String charterCapital = ParamUtil.getString(request, "charterCapital");
		String projectCategoryId = ParamUtil.getString(request, "projectCategoryId");
		String investmentFormId = ParamUtil.getString(request, "investmentFormId");
		String competentOrganizationId = ParamUtil.getString(request, "competentOrganizationId");
		boolean keyProject = ParamUtil.getBoolean(request, "keyProject");
		String technicalSpecifications = ParamUtil.getString(request, "technicalSpecifications");
		String currencyTypeId = ParamUtil.getString(request, "currencyTypeId");
		
		project.setProject_name(projectName);
		project.setTotal_investment_min(totalInvestmentMin);
		project.setTotal_investment_max(totalInvestmentMax);
		project.setImplementation_location(implementationLocation);
		project.setStart_time(startTime);
		project.setEnd_time(endTime);
		project.setProject_purpose(projectPurpose);
		project.setCharter_capital(charterCapital);
		project.setProject_category_id(projectCategoryId);
		project.setInvestment_form_id(investmentFormId);
		project.setCompetent_organization_id(competentOrganizationId);
		project.setKey_project(keyProject);
		project.setTechnical_specifications(technicalSpecifications);
		project.setCurrency_type_id(currencyTypeId);
		project.setCreated_date(new Date());
		project.setModified_date(new Date());
		
		try {
			if (Validator.isBlankOrNull(selectedProjectId)) {
				InvestmentProjectsLocalServiceUtil.addInvestmentProjects(project);
			} else {
				project.setProject_id(selectedProjectId);
				InvestmentProjectsLocalServiceUtil.updateInvestmentProjects(project);
			}
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
			throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		
		if ("investmentProjectTable_LoadPage".equals(resourceID)) {
			investmentProjectTableLoadPage(resourceRequest, resourceResponse);
		} else if ("investmentProjectTable_Search".equals(resourceID)) {
			investmentProjectTableSearch(resourceRequest, resourceResponse);
		} else if ("investmentProject_LoadDetail".equals(resourceID)) {
			String selectedProjectId = ParamUtil.getString(resourceRequest, "selectedProjectId");
			getProjectDetails(resourceResponse, selectedProjectId);
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	/*----------------------------------------------------------------------PRIVATE FUNCTIONS SECTION---------------------------------------------------------------------------*/

	private void getProjectDetails(ResourceResponse resourceResponse, String selectedProjectId) throws IOException {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		try {
			InvestmentProjects selectedProject = InvestmentProjectsLocalServiceUtil.getInvestmentProjects(selectedProjectId);
			Calendar c = Calendar.getInstance();
			
			Date startTime = selectedProject.getStart_time();
			c.setTime(startTime);
			selectedProject.setStartDay(String.valueOf(c.get(Calendar.DATE)));
			selectedProject.setStartMonth(String.valueOf(c.get(Calendar.MONTH) - 1));
			selectedProject.setStartYear(String.valueOf(c.get(Calendar.YEAR)));
			
			Date endTime = selectedProject.getEnd_time();
			c.setTime(endTime);
			selectedProject.setEndDay(String.valueOf(c.get(Calendar.DATE)));
			selectedProject.setEndMonth(String.valueOf(c.get(Calendar.MONTH) - 1));
			selectedProject.setEndYear(String.valueOf(c.get(Calendar.YEAR)));
			
			json.put("selectedProject", gson.toJson(selectedProject));
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		
		resourceResponse.getWriter().write(json.toString());
	}

	private void investmentProjectTableSearch(ResourceRequest request, ResourceResponse response) {
		updateSearchConditions(request);
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		
		if (numPerPage == 0) {
			numPerPage = CommonConstants.PROJECTS_PER_PAGE;
		}
		
		int start = 0;
		int end = start + numPerPage;
		List<InvestmentProjects> projectList;
		
		try {
			long numOfPage = getInvestmentProjectsCount(numPerPage);
			projectList = findInvestmentProjects(start, end);
			addEditActionForProjects(request, projectList);
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("items", gson.toJson(projectList));
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}
	
	private void updateSearchConditions(PortletRequest request) {
		String searchKeyWord = ParamUtil.getString(request, "investmentProjectSearchKeyWord");
		searchConditions.put("investmentProjectSearchKeyWord", searchKeyWord);
		
		String totalInvestmentMin =  ParamUtil.getString(request, "searchTotalInvestmentMin");
		searchConditions.put("searchTotalInvestmentMin", totalInvestmentMin);
		
		String totalInvestmentMax =  ParamUtil.getString(request, "searchTotalInvestmentMax");
		searchConditions.put("searchTotalInvestmentMax", totalInvestmentMax);
		
		String currencyTypeId = ParamUtil.getString(request, "searchCurrencyTypeId");
		if ("-1".equals(currencyTypeId)) {
			currencyTypeId = "";
		}
		searchConditions.put("searchCurrencyTypeId", currencyTypeId);
	}

	private void investmentProjectTableLoadPage(ResourceRequest request, ResourceResponse response) {
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		
		if (numPerPage == 0) {
			numPerPage = CommonConstants.PROJECTS_PER_PAGE;
		}
		
		String pageNumStr = ParamUtil.getString(request, "pageNum");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;
		List<InvestmentProjects> projectList;
		
		try {
			long numOfPage = getInvestmentProjectsCount(numPerPage);
			projectList = findInvestmentProjects(start, end);
			addEditActionForProjects(request, projectList);
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("items", gson.toJson(projectList));
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<InvestmentProjects> findInvestmentProjects(int start, int end) {
		try {
			DynamicQuery dynamicQuery = buildDynamicQuery();
			return InvestmentProjectsLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
		} catch (SystemException e) {
			logger.info(e.getMessage());
			return new ArrayList<InvestmentProjects>();
		}
		
	}

	private long getInvestmentProjectsCount(int numPerPage) {
		try {
			DynamicQuery dynamicQuery = buildDynamicQuery();
			long count = InvestmentProjectsLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			return CommonUtil.getNumberOfPage(count, numPerPage);
		} catch (SystemException e) {
			logger.info(e.getMessage());
			return 0;
		}
	}
	
	private DynamicQuery buildDynamicQuery() {
		String searchKeyWord = searchConditions.get("investmentProjectSearchKeyWord");
		String totalInvestmentMin = searchConditions.get("searchTotalInvestmentMin");
		String totalInvestmentMax = searchConditions.get("searchTotalInvestmentMax");
		String currencyTypeId = searchConditions.get("searchCurrencyTypeId");
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(InvestmentProjects.class);
		
		if (!Validator.isBlankOrNull(searchKeyWord)) {
			Junction junction = RestrictionsFactoryUtil.disjunction();
			junction.add(RestrictionsFactoryUtil.ilike("project_name", "%" + searchKeyWord + "%"))
					.add(RestrictionsFactoryUtil.ilike("project_purpose", "%" + searchKeyWord + "%"))
					.add(RestrictionsFactoryUtil.ilike("technical_specifications", "%" + searchKeyWord + "%"));
			dynamicQuery.add(junction);
		}
		
		if (!Validator.isBlankOrNull(totalInvestmentMin)) {
				dynamicQuery.add(PropertyFactoryUtil.forName("total_investment_min").ge(totalInvestmentMin));
		}
		
		if (!Validator.isBlankOrNull(totalInvestmentMax)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("total_investment_max").le(totalInvestmentMax));
		}
		
		if (!Validator.isBlankOrNull(currencyTypeId)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("currency_type_id").eq(currencyTypeId));
		}
		
		return dynamicQuery;
	}

	private void initTableData(RenderRequest renderRequest) throws Exception {
		searchConditions = new HashMap<String, String>();

		int numOfPage = CommonUtil.getNumberOfPage(InvestmentProjectsLocalServiceUtil.getInvestmentProjectsesCount(), CommonConstants.PROJECTS_PER_PAGE);
		renderRequest.setAttribute("numOfPage", numOfPage);
		renderRequest.setAttribute("numPerPage", CommonConstants.PROJECTS_PER_PAGE);

		List<String> headerList = CommonUtil.getHeaderList(renderRequest, CommonConstants.investmentAdminHeaderKeys);
		renderRequest.setAttribute("headerList", headerList);

		List<String> displayedPropertyList = getDisplayedPropertyList();
		renderRequest.setAttribute("displayedPropertyList", displayedPropertyList);
		
		List<String> hiddenPropertyList = getHiddenPropertyList();
		renderRequest.setAttribute("hiddenPropertyList", hiddenPropertyList);

		List<InvestmentProjects> projectList = InvestmentProjectsLocalServiceUtil.getInvestmentProjectses(0, CommonConstants.PROJECTS_PER_PAGE);
		addEditActionForProjects(renderRequest, projectList);
		renderRequest.setAttribute("projectList", projectList);
		
		String curPageStatusText = CommonUtil.getText(renderRequest, "portlet.common.paging.curPageStatusText");
		renderRequest.setAttribute("curPageStatusText", curPageStatusText);
		
		String itemsPerPageText = CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText");
		renderRequest.setAttribute("itemsPerPageText", itemsPerPageText);
	}
	
	private List<String> getHiddenPropertyList() {
		List<String> hiddenPropertyList = new ArrayList<String>();
		hiddenPropertyList.add("_project_id");
		return hiddenPropertyList;
	}

	private void addEditActionForProjects(PortletRequest request, List<InvestmentProjects> projectList) {
		String actionText = CommonUtil.getText(request, "portlet.investmentadmin.table.action");
		for (InvestmentProjects project : projectList) {
			project.setEditAction("<input type=\"button\" value=\""+actionText+"\" onClick=\"updateProject(this)\"/>" );
		}
	}

	private List<String> getDisplayedPropertyList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add(TableTag.STT);
		displayedPropertyList.add("_project_name");
		displayedPropertyList.add("editAction");
		return displayedPropertyList;
	}

	private void initForm(RenderRequest renderRequest) {
		DataDictionarySet currency = DataDictionaryService.searchListByNameDomain(DataDictionaryService.CURRENCY_TYPES, renderRequest);
		renderRequest.setAttribute("currency", currency.getRecords());
		
		DataDictionarySet projectCategory = DataDictionaryService.searchListByNameDomain(DataDictionaryService.PROJECT_CATEGORIES, renderRequest);
		renderRequest.setAttribute("projectCategory", projectCategory.getRecords());
		
		DataDictionarySet investmentForm = DataDictionaryService.searchListByNameDomain(DataDictionaryService.INVESTMENT_FORMS, renderRequest);
		renderRequest.setAttribute("investmentForm", investmentForm.getRecords());
		
		DataDictionarySet competentOrganization = DataDictionaryService.searchListByNameDomain(DataDictionaryService.PROVINCIAL_DEPARTMENTS, renderRequest);
		renderRequest.setAttribute("competentOrganization", competentOrganization.getRecords());
	}
}
