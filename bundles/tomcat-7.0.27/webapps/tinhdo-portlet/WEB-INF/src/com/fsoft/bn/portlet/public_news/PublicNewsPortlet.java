package com.fsoft.bn.portlet.public_news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.fsoft.bn.domain.PublicNews;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.GsonUtils;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class PublicNewsPortlet extends MVCPortlet {

	private static Logger logger = Logger.getLogger(PublicNewsPortlet.class);
	private static String STATUS_FIRST = "FIRST";
	private static String STATUS_NOT_FIRST = "NOT_FIRST";
	
	private Map<String, String> searchConditions = new HashMap<String, String>();
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		logger.info("======= Cong bao tinh =======");
		
		List<Integer> yearPublishList = new ArrayList<Integer>();
		int yearCunrent = Calendar.getInstance().get(Calendar.YEAR);
		for(int i = yearCunrent; i > 1990; i--) {
			yearPublishList.add(i);
		}
		renderRequest.setAttribute("yearPublishList", yearPublishList);
		
		Map<String, String> publisherList = StructureUtil.getStructureXSDSelectionListGlobal(CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_NEWS), 
				CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.SELECTION_LIST.PUBLIC_NEWS_PUBLISHER));
		renderRequest.setAttribute("publisherList", publisherList);
		
		Map<String, String> typePublicNewsList = StructureUtil.getStructureXSDSelectionListGlobal(CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_NEWS), 
				CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.SELECTION_LIST.PUBLIC_NEWS_TYPE));
		renderRequest.setAttribute("typePublicNewsList", typePublicNewsList);
		
		Map<String, String> fieldPublicNewsList = StructureUtil.getStructureXSDSelectionListGlobal(CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_NEWS), 
				CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.SELECTION_LIST.PUBLIC_NEWS_FIELDS));
		renderRequest.setAttribute("fieldPublicNewsList", fieldPublicNewsList);
		
		//data table paging
		List<String> headersList = CommonUtil.getHeaderList(renderRequest, CommonConstants.publicNewsListHeaderKeys);
		renderRequest.setAttribute("headersList", headersList);
		List<String> displayedPropertyList = getDisplayedPropertyList();
		renderRequest.setAttribute("displayedPropertyList", displayedPropertyList);
		List<String> hiddenPropertyList = getHiddenPropertyList();
		renderRequest.setAttribute("hiddenPropertyList", hiddenPropertyList);
		String curPageStatusText = CommonUtil.getText(renderRequest, "portlet.common.paging.curPageStatusText");
		renderRequest.setAttribute("curPageStatusText", curPageStatusText);
		String itemsPerPageText = CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText");
		renderRequest.setAttribute("itemsPerPageText", itemsPerPageText);
		int numPerPage = CommonConstants.PUBLIC_NEWS_PER_PAGE;
		renderRequest.setAttribute("numPerPage", numPerPage);
		
		//get full data
		List<JournalArticle> journalArticlesLastVersion = StructureUtil.getAllArticleLastVersion(renderRequest, 
				CommonUtil.getText(renderRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_NEWS));
		int start = 0;
		int end = start + numPerPage;
		List<PublicNews> publicNewsList = PublicNewsDelegate.getPublicNewsStartToEnd(journalArticlesLastVersion, start,end);
		int total = journalArticlesLastVersion.size();
		int numOfPage = getNumOfPage(total, numPerPage );
		renderRequest.setAttribute("publicNewsList", publicNewsList);
		renderRequest.setAttribute("numOfPage", numOfPage);
		
		//get list number
		int maxNumber = PublicNewsDelegate.getMaxPublicNewsNumber(journalArticlesLastVersion);
		renderRequest.setAttribute("maxNumber", maxNumber);
		
		searchConditions.put("status", STATUS_FIRST);
		
		logger.info("Cong bao tinh : " + "---" + publicNewsList.size());
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 * get displayed Property List
	 */
	public List<String> getDisplayedPropertyList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add(TableTag.STT);
		displayedPropertyList.add("key");
		displayedPropertyList.add("publisher_date");
		displayedPropertyList.add("publisher");
		return displayedPropertyList;
	}
	
	/**
	 * get Hidden Property List
	 */
	private List<String> getHiddenPropertyList() {
		List<String> hiddenPropertyList = new ArrayList<String>();
		hiddenPropertyList.add("id");
		return hiddenPropertyList;
	}
	
	/**
	 * get number of page
	 */
	private int getNumOfPage(int total, int numInRow) {
		int numOfPage = 0;
		if((total % numInRow) == 0) {
			numOfPage = total / numInRow;
		}else{
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
		String resourceID = resourceRequest.getResourceID();
		logger.info("======= serve Resource =======");
		
		if("searchPublicNewsAjax".equals(resourceID)) {
			logger.info("-----Call ajax searchPublicNewsAjax");
			searchPublicNewsTableAjax(resourceRequest, resourceResponse);
		}
		
		if ("resultSearchPublicNewsTable_LoadPage".equals(resourceID)) {
			logger.info("-----Call ajax resultSearchPublicNewsTable_LoadPage");
			resultSearchPublicNewsTableLoadPage(resourceRequest, resourceResponse);
		}
		
		if("getDetailsPublicNewsAjax".equals(resourceID)) {
			logger.info("-----Call ajax getDetailsPublicNewsAjax");
			getDetailsPublicNewsAjax(resourceRequest, resourceResponse);
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	/**
	 * load page ajax
	 */
	private void resultSearchPublicNewsTableLoadPage(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String pageNumStr = ParamUtil.getString(resourceRequest, "pageNum");
		int numPerPage = ParamUtil.getInteger(resourceRequest, "numPerPage");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;
		
		
		String status = searchConditions.get("status");
		
		try {
			//get full data
			List<JournalArticle> journalArticlesLastVersion = StructureUtil.getAllArticleLastVersion(resourceRequest, 
					CommonUtil.getText(resourceRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_NEWS));
			
			//convert Article to PublicNews
			List<PublicNews> publicNewsAllList = PublicNewsDelegate.getAllPublicNews(journalArticlesLastVersion);
			
			List<PublicNews> resultSearchPublicNews = new ArrayList<PublicNews>();
			
			if(!STATUS_FIRST.equals(status)) {
				resultSearchPublicNews = PublicNewsDelegate.searchAllPublicNew(publicNewsAllList, searchConditions);
			}else{
				resultSearchPublicNews = publicNewsAllList;
			}
			List<PublicNews> resultSearchPublicNewsFinal = PublicNewsDelegate.searchPublicNewsStartToEnd(resultSearchPublicNews, start, end);
			
			int total = resultSearchPublicNews.size();
			int numOfPage = getNumOfPage(total, numPerPage);
			
			//create json object
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonPublicNews = GsonUtils.toJson(resultSearchPublicNewsFinal);
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
	 * load page ajax
	 */
	private void searchPublicNewsTableAjax(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		int numPerPage = ParamUtil.getInteger(resourceRequest, "numPerPage");
		int end = 0 + numPerPage;
		
		searchConditions.put("numberPublicNews", 	ParamUtil.getString(resourceRequest, "numberPublicNews"));
		searchConditions.put("keyPublicNews", 		ParamUtil.getString(resourceRequest, "keyPublicNews"));
		searchConditions.put("yearPublish", 		ParamUtil.getString(resourceRequest, "yearPublish"));
		searchConditions.put("signer", 				ParamUtil.getString(resourceRequest, "signer"));
		searchConditions.put("typePublicNews", 		ParamUtil.getString(resourceRequest, "typePublicNews"));
		searchConditions.put("fieldsPublicNews", 	ParamUtil.getString(resourceRequest, "fieldsPublicNews"));
		searchConditions.put("quote", 				ParamUtil.getString(resourceRequest, "quote"));
		searchConditions.put("publisher", 			ParamUtil.getString(resourceRequest, "publisher"));
		searchConditions.put("status", 				STATUS_NOT_FIRST);
		try {
			//get full data
			List<JournalArticle> journalArticlesLastVersion = StructureUtil.getAllArticleLastVersion(resourceRequest, 
					CommonUtil.getText(resourceRequest, CommonConstants.PORTAL_STRUCTURE.NAME.PUBLIC_NEWS));
			
			//convert Article to PublicNews
			List<PublicNews> publicNewsAllList = PublicNewsDelegate.getAllPublicNews(journalArticlesLastVersion);
			
			//search
			List<PublicNews> resultSearchPublicNews = PublicNewsDelegate.searchAllPublicNew(publicNewsAllList, searchConditions);
			
			List<PublicNews> resultSearchPublicNewsFinal = PublicNewsDelegate.searchPublicNewsStartToEnd(resultSearchPublicNews, 0, end);
			
			int total = resultSearchPublicNews.size();
			int numOfPage = getNumOfPage(total, numPerPage);
			
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonPublicNews = GsonUtils.toJson(resultSearchPublicNewsFinal);
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
	 * get Details PublicNews Ajax
	 */
	private void getDetailsPublicNewsAjax(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			// get group id by scope
			long groupId = themeDisplay.getScopeGroupId();
			
			String id = ParamUtil.getString(resourceRequest, "public_news_id");
			JournalArticle journalArticle = StructureUtil.getArticleByIdAndGroup(id, groupId);
			PublicNews publicNews = PublicNewsDelegate.convertArticleToPublicNews(journalArticle);
			
			//create json object
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonPublicNews = GsonUtils.toJson(publicNews);
			json.put("publicNews", jsonPublicNews);
			resourceResponse.getWriter().write(json.toString());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
