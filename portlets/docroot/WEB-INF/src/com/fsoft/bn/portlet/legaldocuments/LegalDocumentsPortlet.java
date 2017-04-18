package com.fsoft.bn.portlet.legaldocuments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.LegalDocumentModel;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.StructureUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LegalDocuments
 */
public class LegalDocumentsPortlet extends MVCPortlet {
	private static Logger logger = Logger.getLogger(LegalDocumentsPortlet.class);
	private static String LEGAL_DOCUMENT_STRUCTURE = "Văn bản pháp quy";
	private static String LEGAL_DOCUMENT_STRUCTURE_ITEM_DOMAIN = "document_domain";
	private static String LEGAL_DOCUMENT_STRUCTURE_ITEM_CATEGORY = "document_form";
	private long groupId = 0l;
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		logger.info("======= Van ban phap quy START=======");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// get group id by scope
		groupId = themeDisplay.getScopeGroupId();
		
		//list document detail
		Map<String, String> lisDataDictionaries = StructureUtil.getStructureXSDSelectionList(renderRequest,
				LEGAL_DOCUMENT_STRUCTURE, LEGAL_DOCUMENT_STRUCTURE_ITEM_DOMAIN);
		renderRequest.setAttribute("legalDocsDomailList", lisDataDictionaries);
		
		// list category search documents 	
		Map<String, String> lisLegalDoucumentCategory = StructureUtil.getStructureXSDSelectionList(renderRequest,
				LEGAL_DOCUMENT_STRUCTURE, LEGAL_DOCUMENT_STRUCTURE_ITEM_CATEGORY);
		
		renderRequest.setAttribute("legalDocsCategoryList", lisLegalDoucumentCategory);
		//selection year
		List<Integer> yearPublishList = new ArrayList<Integer>();
		Date dateCunrent = new Date();
		@SuppressWarnings("deprecation")
		int yearCunrent = 1900 + dateCunrent.getYear();
		for(int i = yearCunrent; i > 1990; i--){
			yearPublishList.add(i);
		}		
		renderRequest.setAttribute("yearPublishList", yearPublishList);
		
		//data table paging
		List<String> headersList = CommonUtil.getHeaderList(renderRequest, CommonConstants.legalDocumentsListHeaderKeys);
		renderRequest.setAttribute("headersList", headersList);
		List<String> displayedPropertyList = getDisplayedPropertyList();
		renderRequest.setAttribute("displayedPropertyList", displayedPropertyList);
		List<String> hiddenPropertyList = getHiddenPropertyList();
		renderRequest.setAttribute("hiddenPropertyList", hiddenPropertyList);
		String curPageStatusText = CommonUtil.getText(renderRequest, "portlet.public_news.table.page");
		renderRequest.setAttribute("curPageStatusText", curPageStatusText);
		String itemsPerPageText = CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText");
		renderRequest.setAttribute("itemsPerPageText", itemsPerPageText);
		int numPerPage = CommonConstants.LEGAL_DOCUMENT_PER_PAGE;
		renderRequest.setAttribute("numPerPage", numPerPage);
		
		//get full data
		List<LegalDocumentModel> allLegalDocumentModels = LegalDocumentsDelegate.getAllLegalDocuments(groupId);
		int end = 0 + numPerPage;
		List<LegalDocumentModel> listLegalDocumentOnPage = LegalDocumentsUtil.
				getLegalDocumentListPaging(allLegalDocumentModels, 0, end);
		
		int total = allLegalDocumentModels.size();
		int numOfPage = getNumOfPage(total, numPerPage );
		renderRequest.setAttribute("legalDocumentsList", listLegalDocumentOnPage);
		renderRequest.setAttribute("numOfPage", numOfPage);
		
		logger.info("======= Van ban phap quy END =======");
		super.doView(renderRequest, renderResponse);
		
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String resourceID = resourceRequest.getResourceID();
		logger.info("======= serve Resource =======: " + resourceID);
		
		if ("legalDocsSearchID".equals(resourceID)) {
			searchLegalDocumentAjax(resourceRequest, resourceResponse);
		}else if("legalDocsGetDetailID".equals(resourceID)){
			getDetailLegalDocument(resourceRequest, resourceResponse);
		}else if ("resultSearchLegalDocumentsTable_LoadPage".equals(resourceID)) {
			logger.info("-----Call ajax resultSearchLegalDocumentsTable_loadPageURL");
			resultSearchLegalDocumentTableLoadPage(resourceRequest, resourceResponse);
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private void searchLegalDocumentAjax(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		
		List<LegalDocumentModel> listSearchDocumentModels = LegalDocumentsDelegate.
				searchLegalDocumens(resourceRequest, resourceResponse);
		try {
			int numPerPage = CommonConstants.LEGAL_DOCUMENT_PER_PAGE;
			int end = 0 + numPerPage;

			int total = listSearchDocumentModels.size();
			int numOfPage = getNumOfPage(total, numPerPage);

			List<LegalDocumentModel> listLegalDocumentOnPage = LegalDocumentsUtil
					.getLegalDocumentListPaging(listSearchDocumentModels, 0, end);

			// create json object
			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonLegalDoc = gson.toJson(listLegalDocumentOnPage);
			json.put("items", jsonLegalDoc);
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			json.put("isClickRow", true);
			resourceResponse.getWriter().write(json.toString());
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info("You check exception in server");
		}
	}

	private void resultSearchLegalDocumentTableLoadPage(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// get group id by scope
		long groupId = themeDisplay.getScopeGroupId();
		
		String pageNumStr = ParamUtil.getString(resourceRequest, "pageNum");
		int numPerPage = ParamUtil.getInteger(resourceRequest, "numPerPage");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;
		
		try {
			//get full data
			List<LegalDocumentModel> allLegalDocumentModels = LegalDocumentsDelegate.getAllLegalDocuments(groupId);
			List<LegalDocumentModel> listLegalDocumentOnPage = LegalDocumentsUtil.
					getLegalDocumentListPaging(allLegalDocumentModels, start, end);
		
			int total = allLegalDocumentModels.size();
			int numOfPage = getNumOfPage(total, numPerPage);
			
			//create json object
			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonLegalDoc = gson.toJson(listLegalDocumentOnPage);
			json.put("items", jsonLegalDoc);
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			json.put("isClickRow", true);
			resourceResponse.getWriter().write(json.toString());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	/**
	 * get detail of legal document 
	 */
	private void getDetailLegalDocument(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// get group id by scope
		long groupIdDetail = themeDisplay.getScopeGroupId();
		
		String legalDocID = ParamUtil.getString(resourceRequest, "legalDocID");
		logger.info("param: groupId: " + groupIdDetail + " **docId: " + legalDocID );
		
		if(null == legalDocID){
			return;
		}
		
		try{
			LegalDocumentModel mDocumentModel = LegalDocumentsDelegate
					.getDetailLegalDocument(groupIdDetail, legalDocID);
			if(mDocumentModel != null){
				Gson gson = new Gson();				
				String strReturn = gson.toJson(mDocumentModel);
				//json.put("isClickRow", true);
				resourceResponse.getWriter().write(strReturn);
			}
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	/**
	 * getDisplayedPropertyList for data table paging
	 */
	public List<String> getDisplayedPropertyList(){
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add("document_symbol");
		displayedPropertyList.add("publish_date");
		displayedPropertyList.add("document_description");
		displayedPropertyList.add("document_domain");
		return displayedPropertyList;
	}
	
	/**
	 * get Hidden Property List
	 * @return
	 */
	public List<String> getHiddenPropertyList(){
		List<String> hiddenPropertyList = new ArrayList<String>();
		hiddenPropertyList.add("id");
		return hiddenPropertyList;
	}
	
	//get number of page
	public int getNumOfPage(int total, int numInRow){
		int numOfPage = 0;
		if((total % numInRow) == 0){
			numOfPage = total / numInRow;
		}else{
			numOfPage = total / numInRow + 1;
		}
		return numOfPage;
	}
}
