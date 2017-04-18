package com.fsoft.bn.portlet.publicadministrationprocedure;

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
import com.fsoft.bn.domain.PublicAdministrationProcedure;
//import com.fsoft.bn.domain.alfresco.AlfWorkflowDefinition;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.StructureUtil;
//import com.fsoft.bn.util.alfresco.AlfrescoAPIUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PublicAdministrationProcedure
 */
public class PublicAdministrationProcedurePortlet extends MVCPortlet {
	private static Logger logger = Logger.getLogger(PublicAdministrationProcedurePortlet.class);
	private static String PUBLIC_ADMINISTRATION_PROCEDURE = "Danh mục thủ tục hành chính";
	private static String STATUS_FIRST = "FIRST";
	Gson gson = new Gson();
	Map<String, String> searchConditions = new HashMap<String, String>();

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		List<JournalArticle> journalArticlesLastVersion = StructureUtil.getAllArticleLastVersion(renderRequest, PUBLIC_ADMINISTRATION_PROCEDURE);
		
		//get select list in structure	
		Map<String, String> fieldsList = StructureUtil.getStructureXSDSelectionListGlobal(CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_ADMINISTRATION_PROCEDURE), 
				CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.SELECTION_LIST.PUBLIC_ADMINISTRATION_PROCEDURE_FIELD));
		renderRequest.setAttribute("fields", fieldsList);
		
		Map<String, String> organizations = StructureUtil.getStructureXSDSelectionListGlobal(CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_ADMINISTRATION_PROCEDURE), 
				CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.SELECTION_LIST.PUBLIC_ADMINISTRATION_PROCEDURE_ORGANIZATION));
		renderRequest.setAttribute("organizations", organizations);
		
		Map<String, String> levelAdministrationProcedure = StructureUtil.getStructureXSDSelectionListGlobal(CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_ADMINISTRATION_PROCEDURE), 
				CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.SELECTION_LIST.PUBLIC_ADMINISTRATION_PROCEDURE_LEVEL));
		renderRequest.setAttribute("levelAdministrationProcedure", levelAdministrationProcedure);
				
		//data table paging
		List<String> headersList = CommonUtil.getHeaderList(renderRequest, CommonConstants.PublicAdministrationProcedure);
		renderRequest.setAttribute("headersList", headersList);
		List<String> displayedPropertyList = getDisplayedPropertyList();
		renderRequest.setAttribute("displayedPropertyList", displayedPropertyList);
		List<String> hiddenPropertyList = getHiddenPropertyList();
		renderRequest.setAttribute("hiddenPropertyList", hiddenPropertyList);
		String curPageStatusText = CommonUtil.getText(renderRequest, "portlet.public_news.table.page");
		renderRequest.setAttribute("curPageStatusText", curPageStatusText);
		String itemsPerPageText = CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText");
		renderRequest.setAttribute("itemsPerPageText", itemsPerPageText);
		int numPerPage = CommonConstants.PUBLICADMINISTRATIONPROCEDURE_PER_PAGE;
		renderRequest.setAttribute("numPerPage", numPerPage);
		int start = 0;
		int end = start + numPerPage;
		int total = journalArticlesLastVersion.size();
		int numOfPage = getNumOfPage(total, numPerPage );
		renderRequest.setAttribute("numOfPage", numOfPage);
		List<PublicAdministrationProcedure> administrationProcedures = getPublicByTitle(journalArticlesLastVersion,start,end);
		searchConditions.put("status", STATUS_FIRST);
		renderRequest.setAttribute("administrationProcedureList", administrationProcedures);
		
		// get alfresco workflow definitions
//		List<AlfWorkflowDefinition> alfWfDefinitions = AlfrescoAPIUtil.getWfDefinitions();
//		renderRequest.setAttribute("alfWfDefinitions", alfWfDefinitions);
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resouceId = resourceRequest.getResourceID();
		
		if("searchPublicAdministrationProcedureAjax".equals(resouceId)){ // search
			searchPublicAdminTableAjax(resourceRequest, resourceResponse);
		} else if("administrationProcedureListTable_LoadPage".equals(resouceId)){ //page
			administrationProcedures_LoadPaging(resourceRequest, resourceResponse);
		} else if("getDetailsAdministrationProcedureAjax".equals(resouceId)){ // detail list
			getDetailsPublicAdministrationProcedure_Ajax(resourceRequest, resourceResponse);
		} else if("searchHccStatusAjaxResource".equalsIgnoreCase(resouceId)){ //check hcc status
			getHccStatusList_Ajax(resourceRequest, resourceResponse);
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
		
	/**
	 * load search page ajax
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	private void searchPublicAdminTableAjax(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		int numPerPage = ParamUtil.getInteger(resourceRequest, "numPerPage");
		int start = 0;
		int end = start + numPerPage;
		
		//get variable ajax
		String fields = ParamUtil.getString(resourceRequest, "fields");
		String organizations = ParamUtil.getString(resourceRequest, "organizations");
		String levelProcedure = ParamUtil.getString(resourceRequest, "levelAdministrationProcedure");
		String txtKeySearch = ParamUtil.getString(resourceRequest, "txtKeySearch");
		
		searchConditions.put("fields", fields);
		searchConditions.put("organizations", organizations);
		searchConditions.put("levelProcedure", levelProcedure);
		searchConditions.put("txtKeySearch", txtKeySearch);
		try {
			// get all article by structure name
			List<JournalArticle> journalArticlesLastVersion = StructureUtil.getAllArticleLastVersion(resourceRequest, 
					CommonUtil.getText(resourceRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_ADMINISTRATION_PROCEDURE));
			
			//convert Article to PublicAdministrationProcedure
			List<PublicAdministrationProcedure> publicAdministrationProcedures = getAllPublicProcedure(journalArticlesLastVersion);
	
			// filter by keys search
			List<PublicAdministrationProcedure> resultSearchPublicAdminstration = new ArrayList<PublicAdministrationProcedure>();
			resultSearchPublicAdminstration = PublicAdministrationProcedureDelegate.searchAllPublicProcedure(publicAdministrationProcedures, fields, organizations, levelProcedure, txtKeySearch);

			// list data for pagingnation
			List<PublicAdministrationProcedure> resultSearchPublicNewsFinal = getPublicProcedure(resultSearchPublicAdminstration, start, end);

			//resultSearchPublicAdminstration = publicAdministrationProcedures;
			int total = resultSearchPublicAdminstration.size();
			int numOfPage = getNumOfPage(total, numPerPage);
			
			//create json object
			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonPublicNews = gson.toJson(resultSearchPublicNewsFinal);
			json.put("items", jsonPublicNews);
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			json.put("isClickRow", true);
			resourceResponse.getWriter().write(json.toString());
		} catch (IOException e) {
			logger.info(e.getMessage());
		} 
	}
		
	/**
	 * load paging ajax
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	private void administrationProcedures_LoadPaging(ResourceRequest resourceRequest,ResourceResponse resourceResponse) {
		String pageNumStr = ParamUtil.getString(resourceRequest, "pageNum");
		int numPerPage = ParamUtil.getInteger(resourceRequest, "numPerPage");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;
		
		//get variable ajax
		String fields = ParamUtil.getString(resourceRequest, "fields");
		String organizations = ParamUtil.getString(resourceRequest, "organizations");
		String levelProcedure = ParamUtil.getString(resourceRequest, "levelAdministrationProcedure");
		String txtKeySearch = ParamUtil.getString(resourceRequest, "txtKeySearch");
		String status = searchConditions.get("status");
		
		try {
			//get full data
			List<JournalArticle> journalArticlesLastVersion = StructureUtil.getAllArticleLastVersion(resourceRequest, 
					CommonUtil.getText(resourceRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_ADMINISTRATION_PROCEDURE));	
			//convert Article to PublicAdministrationProcedure
			List<PublicAdministrationProcedure> publicAdministrationProcedures = getAllPublicProcedure(journalArticlesLastVersion);
			List<PublicAdministrationProcedure> resultSearchPublicNews = new ArrayList<PublicAdministrationProcedure>();
			
			if(!STATUS_FIRST.equals(status)){
				resultSearchPublicNews = PublicAdministrationProcedureDelegate.searchAllPublicProcedure(publicAdministrationProcedures, fields, organizations, levelProcedure, txtKeySearch);
			}else{
				resultSearchPublicNews = publicAdministrationProcedures;
			}
			
			List<PublicAdministrationProcedure> resultSearchPublicNewsFinal = getPublicProcedure(resultSearchPublicNews, start, end);
			
			int total = resultSearchPublicNews.size();
			int numOfPage = getNumOfPage(total, numPerPage);
			
			//create json object
			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonPublicNews = gson.toJson(resultSearchPublicNewsFinal);
			json.put("items", jsonPublicNews);
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			json.put("isClickRow", true);
			resourceResponse.getWriter().write(json.toString());
		} catch (IOException e) {
			logger.info(e.getMessage());
		} 
	}
		
	/**
	 * get PublicAdministrationProcedure start to end
	 * @param publicProcedures
	 * @param start
	 * @param end
	 * @return
	 */
	private static List<PublicAdministrationProcedure> getPublicProcedure(List<PublicAdministrationProcedure> publicProcedures, int start, int end) {
		List<PublicAdministrationProcedure> publicNewsList = new ArrayList<PublicAdministrationProcedure>();
		int maxNumber = publicProcedures.size();
		int number = start;
		while(number < end && number < maxNumber){
			publicNewsList.add(publicProcedures.get(number));
			number ++;
		}
		return publicNewsList;
	}
		
	/**
	 * get data in structure, one field
	 * @param journalArticle
	 * @return
	 */
	private static PublicAdministrationProcedure getTitlePublicProcedure(JournalArticle journalArticle) {
		PublicAdministrationProcedure publicAdministrationProcedure = new PublicAdministrationProcedure();
		publicAdministrationProcedure.setId(journalArticle.getArticleId());
		publicAdministrationProcedure.setTitle(StructureUtil.getXsdTitleArticle(journalArticle.getTitle()));
		publicAdministrationProcedure.setFields(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "field"));
		publicAdministrationProcedure.setOrganizations(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "organizations"));
		publicAdministrationProcedure.setLevel(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "level"));
		publicAdministrationProcedure.setNameOfProcedures(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "nameOfProcedures"));
		publicAdministrationProcedure.setExecution(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "execution"));
		publicAdministrationProcedure.setPerform(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "perform"));
		publicAdministrationProcedure.setProfile(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "profile"));
		publicAdministrationProcedure.setProcessing(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "processing"));
		publicAdministrationProcedure.setObject(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "object"));
		publicAdministrationProcedure.setAgency(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "agency"));
		publicAdministrationProcedure.setResult(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "result"));
		publicAdministrationProcedure.setCost(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "cost"));
		publicAdministrationProcedure.setFormSheets(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "formSheets"));
		publicAdministrationProcedure.setCondition(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "condition"));
		publicAdministrationProcedure.setLegalBases(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "legalBases"));
		publicAdministrationProcedure.setContact(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "contact"));
    	List<String> file_attach = StructureUtil.getXsdContentArticleList(journalArticle.getContent(), "attachment");
		publicAdministrationProcedure.setAttachment(file_attach);
		return publicAdministrationProcedure;
	}
	
	/**
	 * add two field table
	 * @return
	 */
	private List<String> getDisplayedPropertyList(){
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add("title");
		displayedPropertyList.add("organizations");
		displayedPropertyList.add("fields");
		displayedPropertyList.add("level");
		return displayedPropertyList;
	}

	/**
	 * get All PublicAdministrationProcedure
	 * @param publicNewsLastVersionList
	 * @return
	 */
	private List<PublicAdministrationProcedure> getAllPublicProcedure(List<JournalArticle> publicNewsLastVersionList) {
		List<PublicAdministrationProcedure> publicList = new ArrayList<PublicAdministrationProcedure>();
		for (JournalArticle journalArticle : publicNewsLastVersionList) {
			PublicAdministrationProcedure administrationProcedure = getTitlePublicProcedure(journalArticle);
			publicList.add(administrationProcedure);
		}
		return publicList;
	}

	/**
	 * get PublicAdministrationProcedure (paging) start to end
	 * @param publicNewsLastVersionList
	 * @param start
	 * @param end
	 * @return
	 */
	public List<PublicAdministrationProcedure> getPublicByTitle(
			List<JournalArticle> publicNewsLastVersionList, int start, int end) {
		List<PublicAdministrationProcedure> publicNewsList = new ArrayList<PublicAdministrationProcedure>();
		List<JournalArticle> journalArticlesList = new ArrayList<JournalArticle>();
		int maxNumber = publicNewsLastVersionList.size();
		int number = start;

		while (number < end && number < maxNumber) {
			journalArticlesList.add(publicNewsLastVersionList.get(number));
			number++;
		}

		for (JournalArticle journalArticle : journalArticlesList) {
			PublicAdministrationProcedure administrationProcedure = getTitlePublicProcedure(journalArticle);
			publicNewsList.add(administrationProcedure);
		}
		return publicNewsList;
	}
		
	private List<String> getHiddenPropertyList(){
		List<String> hiddenPropertyList = new ArrayList<String>();
		hiddenPropertyList.add("id");
		return hiddenPropertyList;
	}
		
	/**
	 * get number of page
	 * @param total
	 * @param numInRow
	 * @return
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
	
	/**
	 * getHccStatusList_Ajax
	 * @param request
	 * @param response
	 */
	private void getHccStatusList_Ajax(ResourceRequest request, ResourceResponse response){
		logger.info("getHccStatusList_Ajax function");
		String username = request.getParameter("username");
		String tinhtranghoso = request.getParameter("tinhtranghoso");
		System.out.println(username);
		System.out.println(tinhtranghoso);
		try {
			JsonArray jsonArrayReturn = new JsonArray();
			JsonObject jsonObjectReturn = new JsonObject();
			
//			List<String> listUser = AlfrescoAPIUtil.getAllUsername();
			
			JsonArray jsonArray = new JsonArray();
//			for(String item: listUser){
////				jsonArray = AlfrescoAPIUtil.getWfInstCollection(item);
//				jsonArrayReturn.addAll(jsonArray);
//			}
			
			jsonObjectReturn.add("data", jsonArrayReturn);
			
			response.getWriter().write(jsonObjectReturn.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * get Details PublicNews Ajax
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	private void getDetailsPublicAdministrationProcedure_Ajax(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			// get group id by scope
			long groupId = themeDisplay.getScopeGroupId();
			
			String id = ParamUtil.getString(resourceRequest, "publicAdministratrionProcedureId");
			JournalArticle journalArticle = StructureUtil.getArticleByIdAndGroup(id, groupId);
			PublicAdministrationProcedure administrationProcedure = getTitlePublicProcedure(journalArticle);
			
			List<PublicAdministrationProcedure> listOther = getlistPublicAdministrationProcedurByFields(groupId,administrationProcedure.getFields());
			
			//create json object
			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonAdministrationProcedure = gson.toJson(administrationProcedure);
			String strListOther = gson.toJson(listOther);
			json.put("publicAdministratrionProcedure", jsonAdministrationProcedure);
			if(!("Mức 3".equalsIgnoreCase(administrationProcedure.getLevel()))){
				json.put("lisOther", strListOther);
			}
			resourceResponse.getWriter().write(json.toString());
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	private List<PublicAdministrationProcedure> getlistPublicAdministrationProcedurByFields(long groupID, String strField){
	 	List<JournalArticle> lisAllProcedure = 	StructureUtil.getAllArticleLastVersionByGroupId(groupID, PUBLIC_ADMINISTRATION_PROCEDURE);
	 	List<PublicAdministrationProcedure> administrationProcedures = getListOther(lisAllProcedure, strField);
	 	return administrationProcedures;
	}
	
	/**
	 * get list other PublicAdministrationProcedure (paging) 0 to 10
	 * @param publicNewsLastVersionList
	 * @param strFiled
	 * @return
	 */
	private List<PublicAdministrationProcedure>getListOther (List<JournalArticle> publicNewsLastVersionList, String strFiled) {
		List<PublicAdministrationProcedure> publicNewsList = new ArrayList<PublicAdministrationProcedure>();
		
        for (JournalArticle journalArticle : publicNewsLastVersionList) {
        	PublicAdministrationProcedure administrationProcedure = getTitlePublicProcedure(journalArticle);
        	if(strFiled.equalsIgnoreCase(administrationProcedure.getFields())){
        		publicNewsList.add(administrationProcedure);
        	}
    		if(publicNewsList.size() >=5)
    			break;
         }
		return publicNewsList;
	}
}
