package com.fsoft.bn.portlet.operatorsteering;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.customJSPTags.TableTag;
import com.fsoft.bn.domain.Structure;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OperatorSteeringPortlet
 */
public class OperatorSteeringPortlet extends MVCPortlet {
	
	private static Logger logger = Logger.getLogger(OperatorSteeringPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		logger.info("======= Chi dao dieu hanh =======");
		
		String portletResource = ParamUtil.getString(renderRequest, "portletResource");
		PortletPreferences prefs = renderRequest.getPreferences();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (portletResource == null	|| portletResource.trim().equals("")) {
			portletResource = themeDisplay.getPortletDisplay().getId();
		}
		
		if (!Validator.isBlankOrNull(portletResource)) {
		    try {
				prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
			} catch (PortalException e) {
				logger.info(e.getMessage());
			} catch (SystemException e) {
				logger.info(e.getMessage());
			}
		}
		
		//Get structureId is choosed for display
		String structureId = prefs.getValue("structureId", portletResource);
		Structure operatorSteeringStructure = OperatorSteeringDelegate.getStructureNameById(renderRequest, structureId, CommonConstants.OPERATOR_STEERING_STRUCTURE_NAME);
		renderRequest.setAttribute("portlertHeaderKey", operatorSteeringStructure.getKeyPortletHeaderDisplay());
		
		//data table paging
		List<String> headersList = OperatorSteeringDelegate.getHeaderInViewList(operatorSteeringStructure, renderRequest);
		renderRequest.setAttribute("headersList", headersList);
		
		List<String> displayedPropertyList = getDisplayPropertiesInViewList();
		renderRequest.setAttribute("displayedPropertyList", displayedPropertyList);
		List<String> hiddenPropertyList = getHiddenPropertiesList();
		renderRequest.setAttribute("hiddenPropertyList", hiddenPropertyList);
		String curPageStatusText = CommonUtil.getText(renderRequest, "portlet.common.paging.curPageStatusText");
		renderRequest.setAttribute("curPageStatusText", curPageStatusText);
		String itemsPerPageText = CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText");
		renderRequest.setAttribute("itemsPerPageText", itemsPerPageText);
		int numPerPage = CommonConstants.OPERATOR_STEERING_PER_PAGE;
		renderRequest.setAttribute("numPerPage", numPerPage);
		
		//Get full 
		if(structureId != null){
			List<JournalArticle> journalArticlesLastVersion = StructureUtil.getAllArticleLastVersionByStructureId(renderRequest, structureId);
			int start = 0;
			int end = start + numPerPage;
			
			//convert
			List<Object> operatorSteerings = OperatorSteeringDelegate.getObjectsStartToEnd(renderRequest, structureId, journalArticlesLastVersion, start, end);
			renderRequest.setAttribute("operatorSteerings", operatorSteerings);
			int total = journalArticlesLastVersion.size();
			int numOfPage = getNumOfPage(total, numPerPage );
			renderRequest.setAttribute("numOfPage", numOfPage);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 * Ajax Resource
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String resourceID = resourceRequest.getResourceID();
		logger.info("======= serve Resource =======");
		
		if ("resultOperatorSteeringTable_LoadPage".equals(resourceID)) {
			logger.info("-----Call ajax resultOperatorSteeringTable_LoadPage");
			resultOperatorSteeringTableLoadPage(resourceRequest, resourceResponse);
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	/**
	 * load page ajax
	 */
	private void resultOperatorSteeringTableLoadPage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String pageNumStr = ParamUtil.getString(resourceRequest, "pageNum");
		int numPerPage = ParamUtil.getInteger(resourceRequest, "numPerPage");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;
		
		String portletResource = ParamUtil.getString(resourceRequest, "portletResource");
		PortletPreferences prefs = resourceRequest.getPreferences();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (portletResource == null	|| portletResource.trim().equals("")) {
			portletResource = themeDisplay.getPortletDisplay().getId();
		}
		
		if (!Validator.isBlankOrNull(portletResource)) {
		    try {
				prefs = PortletPreferencesFactoryUtil.getPortletSetup(resourceRequest, portletResource);
			} catch (PortalException e) {
				logger.info(e.getMessage());
			} catch (SystemException e) {
				logger.info(e.getMessage());
			}
		}
		
		//Get structureId is choosed for display
		String structureId = prefs.getValue("structureId", portletResource);
		Structure operatorSteeringStructure = OperatorSteeringDelegate.getStructureNameById(resourceRequest, structureId, CommonConstants.OPERATOR_STEERING_STRUCTURE_NAME);
		
		List<JournalArticle> journalArticlesLastVersion = new ArrayList<JournalArticle>();
		//Get full 
		if(structureId != null){
			journalArticlesLastVersion = StructureUtil.getAllArticleLastVersionByStructureId(resourceRequest, structureId);
		}
		
		//convert
		List<Object> operatorSteerings = OperatorSteeringDelegate.getObjectsStartToEnd(resourceRequest, structureId, journalArticlesLastVersion, start, end);
		int total = journalArticlesLastVersion.size();
		int numOfPage = getNumOfPage(total, numPerPage );
		
		//create json object
		Gson gson = new Gson();
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String jsonPublicNews = gson.toJson(operatorSteerings);
		json.put("items", jsonPublicNews);
		json.put("recordPerPage", numPerPage);
		json.put("numOfPage", numOfPage);
		json.put("isClickRow", true);
		try {
			resourceResponse.getWriter().write(json.toString());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}
	
	/**
	 * 	List display properties in view
	 * */
	private List<String> getDisplayPropertiesInViewList(){
		List<String> propertiesDisplayInViewList = new ArrayList<String>();
		propertiesDisplayInViewList.add(TableTag.STT);
		propertiesDisplayInViewList.add("title");
		
		return propertiesDisplayInViewList;
	}
	
	/**
	 * 	List hidden properties
	 * */
	private List<String> getHiddenPropertiesList(){
		List<String> propertiesDisplayInViewList = new ArrayList<String>();
		propertiesDisplayInViewList.add("id");
		
		return propertiesDisplayInViewList;
	}
	
	/**
	 * get number of page
	 */
	private int getNumOfPage(int total, int numInRow){
		int numOfPage = 0;
		if((total % numInRow) == 0){
			numOfPage = total / numInRow;
		}else{
			numOfPage = total / numInRow + 1;
		}
		return numOfPage;
	}

}
