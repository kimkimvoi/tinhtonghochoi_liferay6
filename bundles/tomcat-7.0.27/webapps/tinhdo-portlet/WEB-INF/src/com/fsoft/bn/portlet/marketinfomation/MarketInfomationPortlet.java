package com.fsoft.bn.portlet.marketinfomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.MarketInfo;
import com.fsoft.bn.portlet.news.NewsContants.FRIENDLY_URL;
import com.fsoft.bn.portlet.news.NewsContants.PORTLET_NAME;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.CommonUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MarketInfomation
 */

public class MarketInfomationPortlet extends MVCPortlet {
	/** logger */
	private static Logger logger = Logger.getLogger(MarketInfoCommonUntils.class);
	public String sortBy;
	public int quantity;
	public long groupId=0l;
	public String structureId;
	public String categoryType = "economy";
	private static String NEWS_STRUCTURE = "Thông tin thị trường";
	MarketInfoCommonUntils marketInfoCommonUtilsNews = new MarketInfoCommonUntils();

	private static Log logging = LogFactoryUtil.getLog(MarketInfomationPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		logging.info("=======START MARKET INFO PORTLET========");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// get group id by scope
		groupId = themeDisplay.getScopeGroupId();
		// get structure id by name or title
		structureId = getStructureByName(NEWS_STRUCTURE);

		sortBy = "modifiedDate";
		quantity = 6;

		List<MarketInfo> listNewsByCategory = getListNewsByCategory(renderRequest, groupId, structureId, sortBy, categoryType);
		logging.info("LIST NEWS SIZE: " + listNewsByCategory.size());

		//paging
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
		int numPerPage = CommonConstants.MARKET_INFO_PER_PAGE;
		renderRequest.setAttribute("numPerPage", numPerPage);

		int start = 0;
		int end = start + numPerPage;
		List<MarketInfo> listLegalDocumentOnPage = getMarketInfoListPaging(listNewsByCategory, start, end);
		renderRequest.setAttribute("lstMarketInfos", listLegalDocumentOnPage);

		int total = listNewsByCategory.size();
		int numOfPage = getNumOfPage(total, numPerPage );
		renderRequest.setAttribute("numOfPage", numOfPage);
		logging.info("=======END MARKET INFO PORTLET========");
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// get resourceID
		String resourceID = resourceRequest.getResourceID();

		// navigate by resourceID
		if ("listMaketInfoContent_LoadPage".equals(resourceID)) {
			logging.info("-----Call ajax listMaketInfoContentLoadPage");
			listMaketInfoContentLoadPage(resourceRequest, resourceResponse);
		}else if ("getDetailMarketInfoUrl".equals(resourceID)) {
			loadDetailMarketInfo(resourceRequest, resourceResponse);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	public void loadDetailMarketInfo(ResourceRequest request, ResourceResponse response) {
		String newsID = ParamUtil.getString(request, "newsID");
		logging.info("newsID : " + newsID);
		try {
			MarketInfo marketInfo = getMarketDetail(groupId, structureId, sortBy, categoryType, newsID);
			Gson gson = new Gson();
			String strReturn = gson.toJson(marketInfo);
			logging.info("json tttt: " + marketInfo.getTitle());
			logging.info("json mmmm: " + strReturn);
			response.getWriter().write(strReturn);
		}catch (Exception e) {
			logger.info(e.getMessage());
			logging.info("exception");
		}
	}

	//phan trang
	public void listMaketInfoContentLoadPage(ResourceRequest request, ResourceResponse response) {
		List<MarketInfo> listAllMarketInfos = new ArrayList<MarketInfo>();
		List<MarketInfo> listInfosPaginator = new ArrayList<MarketInfo>();
		listAllMarketInfos = getListNewsByCategory(request, groupId, structureId, sortBy, categoryType);

		String pageNumStr = ParamUtil.getString(request, "pageNum");
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;

		try {
			listInfosPaginator = MarketInfoCommonUntils.getListPaginatorInfo(listAllMarketInfos, start, end);
			int total = listAllMarketInfos.size();
			int numOfPage = getNumOfPage(total, numPerPage);

			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("items", gson.toJson(listInfosPaginator));
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);

			logging.info("json ssss: " + json.toString());
			response.getWriter().write(json.toString());
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public List<String> getHiddenPropertyList() {
		List<String> hiddenPropertyList = new ArrayList<String>();
		hiddenPropertyList.add("id");
		return hiddenPropertyList;
	}

	public List<MarketInfo> getListNewsByCategory(PortletRequest request, long groupId, String structureId, String sortBy, String categoryType) {
		List<MarketInfo> listOtherNews = new ArrayList<MarketInfo>();
		MarketInfo lastVersionNews;
		OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
		try {
			List<JournalArticle> listNews = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
			for (JournalArticle ja : listNews) {
				lastVersionNews = new MarketInfo();
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				if (marketInfoCommonUtilsNews.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)
						&& categoryType.equals(this.categoryType)) {
					lastVersionNews = marketInfoCommonUtilsNews.setNewsArticle(ja);
					// create URL and redirect to new detail portlet
					String portletURL = NewsUtils.returnPortletURL(request, FRIENDLY_URL.NEWS_VIEW_DETAIL, PORTLET_NAME.NEWS_DETAIL,
							String.valueOf(groupId), structureId, articleIdCheck, String.valueOf(articleVersion));
					lastVersionNews.setDetailUrl(portletURL);
					listOtherNews.add(lastVersionNews);
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return listOtherNews;
	}

	public MarketInfo getMarketDetail(long groupId, String structureId, String sortBy, String categoryType, String newsID) {
		MarketInfo lastVersionNews = null;
		OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
		try {
			List<JournalArticle> listNews = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
			for (JournalArticle ja : listNews) {
				lastVersionNews = new MarketInfo();
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				if (marketInfoCommonUtilsNews.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)
						&& categoryType.equals(this.categoryType)) {
					if (newsID.equals(articleIdCheck)) {
						lastVersionNews = marketInfoCommonUtilsNews.setNewsArticle(ja);
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return lastVersionNews;
	}

	//get number of page
	public int getNumOfPage(int total, int numInRow) {
		int numOfPage = 0;
		if ((total % numInRow) == 0) {
			numOfPage = total / numInRow;
		}else {
			numOfPage = total / numInRow + 1;
		}

		return numOfPage;
	}

	// function get structure id by name
	private static String getStructureByName(String name) {

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(JournalStructure.class).
								add(PropertyFactoryUtil.forName("name"). like("%" + name + "%"));

		try {
			@SuppressWarnings("unchecked")
			List<JournalStructure> lstStructure = JournalStructureLocalServiceUtil.dynamicQuery(dq, 0, 1);

			if (null != lstStructure && lstStructure.size() > 0) {
				return lstStructure.get(0).getStructureId();
			} else {
				logging.info("No structure found!");
				return null;
			}

		} catch (SystemException e) {
			logging.error("Exception when get structure: " + e.getMessage());
		}

		return null;
	}

	/**
	 * getDisplayedPropertyList for data table paging
	 */
	public List<String> getDisplayedPropertyList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add("title");
		displayedPropertyList.add("summary");
		displayedPropertyList.add("content");
		return displayedPropertyList;
	}

	private List<MarketInfo> getMarketInfoListPaging(List<MarketInfo> listAllMarketInfo, int start, int end) {
		List<MarketInfo> mListMarketInfoPaging = new ArrayList<MarketInfo>();
		if (listAllMarketInfo.size() > 0 && listAllMarketInfo.size() > start) {
			for (int i = start; i < end; i++) {
				if (i < listAllMarketInfo.size()) {
					mListMarketInfoPaging.add(listAllMarketInfo.get(i));
				}else {
					break;
				}
			}
		}

		return mListMarketInfoPaging;
	}
}