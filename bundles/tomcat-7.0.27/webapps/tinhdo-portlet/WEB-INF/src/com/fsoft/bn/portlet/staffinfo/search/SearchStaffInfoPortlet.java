package com.fsoft.bn.portlet.staffinfo.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.customJSPTags.TableTag;
import com.fsoft.bn.model.Organizations;
import com.fsoft.bn.model.StaffInfo;
import com.fsoft.bn.service.OrganizationsLocalServiceUtil;
import com.fsoft.bn.service.StaffInfoLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class SearchStaffInfoPortlet extends MVCPortlet {
	private static Logger logger = Logger
			.getLogger(SearchStaffInfoPortlet.class);
	
	private Map<String, String> searchConditions = new HashMap<String, String>();
	private static String STATUS_FIRST = "FIRST";
	private static String STATUS_NOT_FIRST = "NOT_FIRST";
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		logger.info("************* Search Staff Info Doview ************** ");
		List<Organizations> organizationsList = null;
		try {
			organizationsList = OrganizationsLocalServiceUtil.getAllOrganization();
		} catch (SystemException e) {
			logger.error(e);
		}
		renderRequest.setAttribute("organizationsList", organizationsList);

		// data table paging
		List<String> headersList = CommonUtil.getHeaderList(renderRequest,CommonConstants.staffInfoListHeaderKeys);
		renderRequest.setAttribute("headersList", headersList);
		List<String> displayedPropertyList = getDisplayedPropertyList();
		renderRequest.setAttribute("displayedPropertyList",displayedPropertyList);
		List<String> hiddenPropertyList = getHiddenPropertyList();
		renderRequest.setAttribute("hiddenPropertyList", hiddenPropertyList);
		String curPageStatusText = CommonUtil.getText(renderRequest,"portlet.search-staff.search.curPageStatusText");
		renderRequest.setAttribute("curPageStatusText", curPageStatusText);
		String itemsPerPageText = CommonUtil.getText(renderRequest,"portlet.common.paging.itemsPerPageText");
		renderRequest.setAttribute("itemsPerPageText", itemsPerPageText);
		int numPerPage = CommonConstants.SEARCH_STAFFINFO_PER_PAGE;
		renderRequest.setAttribute("numPerPage", numPerPage);

		searchConditions.put("status", STATUS_FIRST);
		try {
			List<StaffInfo> staffInfosList = StaffInfoLocalServiceUtil.getAllStaffInfoByDeleted(false, 0, numPerPage);
			staffInfosList = StaffInfoLocalServiceUtil.updateValueOrganizName(staffInfosList);
			renderRequest.setAttribute("staffsList", staffInfosList);
			int total = StaffInfoLocalServiceUtil.getAllStaffInfoByDeletedCount(false);
			int numOfPage = getNumOfPage(total, numPerPage);
			renderRequest.setAttribute("numOfPage", numOfPage);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 * get displayed Property List
	 */	
	private List<String> getDisplayedPropertyList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add(TableTag.STT);
		displayedPropertyList.add("_staff_firstname"
				+ TableTag.AND_PROPERTY_KEY + "_staff_middlename"
				+ TableTag.AND_PROPERTY_KEY + "_staff_lastname");
		displayedPropertyList.add("_staff_role");
		displayedPropertyList.add("_staff_phone");
		displayedPropertyList.add("_staff_email");
		displayedPropertyList.add("_organizations_name");
		return displayedPropertyList;
	}
	
	/**
	 * get Hidden Property List
	 */
	private List<String> getHiddenPropertyList() {
		List<String> hiddenPropertyList = new ArrayList<String>();
		hiddenPropertyList.add("_staff_id");
		return hiddenPropertyList;
	}

	/**
	 * get Data search
	 */	
	private List<StaffInfo> getResultSearchStaff(String contentSearch,
			String typeSearch, long organizationsNumber, int begin, int end) {
		List<StaffInfo> staffInfosList = null;
		try {
			staffInfosList = StaffInfoLocalServiceUtil.searchStaffInfo(contentSearch, typeSearch, organizationsNumber, begin, end);
			staffInfosList = StaffInfoLocalServiceUtil.updateValueOrganizName(staffInfosList);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		return staffInfosList;
	}

	/**
	 * get count Data search
	 */	
	private int getResultSearchStaffCount(String contentSearch,
			String typeSearch, long organizationsNumber) {
		int count = 0;
		try {
			count = StaffInfoLocalServiceUtil.countResultSearchStaffInfo(contentSearch, typeSearch, organizationsNumber);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}

		return count;
	}

	/**
	 * get number of page
	 */
	private int getNumOfPage(int total, int numInRow) {
		int numOfPage = 0;
		if ((total % numInRow) == 0) {
			numOfPage = total / numInRow;
		} else {
			numOfPage = total / numInRow + 1;
		}
		return numOfPage;
	}

	/**
	 * Ajax Resource
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		// get resourceID
		String resourceID = resourceRequest.getResourceID();
		logger.info("resourceID : " + resourceID);

		// navigate by resourceID
		if ("resultSearchStaffTable_LoadPage".equals(resourceID)) {
			logger.info("-----Call ajax resultSearchStaffTable_LoadPage");
			resultSearchStaffTableLoadPage(resourceRequest, resourceResponse);
		}

		if ("staffSearchAjax".equals(resourceID)) {
			logger.info("-----Call ajax staffSearchAjax");
			staffSearchAjax(resourceRequest, resourceResponse);
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	/**
	 * Ajax load page
	 */
	private void resultSearchStaffTableLoadPage(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String pageNumStr = resourceRequest.getParameter("pageNum");
		int numPerPage = ParamUtil.getInteger(resourceRequest, "numPerPage");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;

		String typeSearch = searchConditions.get("typeSearch");
		String contentSearch = searchConditions.get("contentSearch");
		String organizations = searchConditions.get("organizations");
		String status = searchConditions.get("status");
		long organizationsNumber = 0;
		try {
			if (organizations != null) {
				organizationsNumber = Long.parseLong(organizations);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		List<StaffInfo> staffList = new ArrayList<StaffInfo>();
		int total = 0;
		try {
			if(STATUS_FIRST.equals(status)){
				staffList = StaffInfoLocalServiceUtil.getAllStaffInfoByDeleted(false, 0, numPerPage);
				staffList = StaffInfoLocalServiceUtil.updateValueOrganizName(staffList);
				total = StaffInfoLocalServiceUtil.getAllStaffInfoByDeletedCount(false);
			}else{
				if (typeSearch == null) {
					staffList = StaffInfoLocalServiceUtil.getAllStaffInfoByDeleted(false, start, end);
					staffList = StaffInfoLocalServiceUtil.updateValueOrganizName(staffList);
					total = StaffInfoLocalServiceUtil.getAllStaffInfoByDeletedCount(false);
				} else {
					staffList = getResultSearchStaff(contentSearch, typeSearch, organizationsNumber, start, end);
					total = getResultSearchStaffCount(contentSearch, typeSearch, organizationsNumber);
				}
			}
			int numOfPage = getNumOfPage(total, numPerPage);
			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonStaff = gson.toJson(staffList);
			json.put("items", jsonStaff);
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			resourceResponse.getWriter().write(json.toString());
		}catch (SystemException e) {
			logger.info(e.getMessage());
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	/**
	 * Ajax search
	 */
	private void staffSearchAjax(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		int numPerPage = ParamUtil.getInteger(resourceRequest, "numPerPage");
		int start = 0;
		int end = start + numPerPage;

		// get data
		String typeSearch = ParamUtil.getString(resourceRequest, "typeSearch");
		String contentSearch = ParamUtil.getString(resourceRequest,
				"contentSearch");
		String organizations = ParamUtil.getString(resourceRequest,
				"organizations");
		
		searchConditions.put("typeSearch", typeSearch);
		searchConditions.put("contentSearch", contentSearch);
		searchConditions.put("organizations", organizations);
		searchConditions.put("status", STATUS_NOT_FIRST);
		
		long organizationsNumber = 0;
		List<StaffInfo> staffInfosList = null;
		try {
			if (organizations != null) {
				organizationsNumber = Long.parseLong(organizations);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		try {
			staffInfosList = getResultSearchStaff(contentSearch, typeSearch,
					organizationsNumber, start, end);
			int total = getResultSearchStaffCount(contentSearch, typeSearch,
					organizationsNumber);
			int numOfPage = getNumOfPage(total, end);
			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonStaff = gson.toJson(staffInfosList);
			json.put("items", jsonStaff);
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			resourceResponse.getWriter().write(json.toString());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}
}