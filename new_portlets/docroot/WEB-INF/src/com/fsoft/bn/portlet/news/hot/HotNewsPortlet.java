package com.fsoft.bn.portlet.news.hot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.news.HotNewsConfig;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.domain.news.NewsCategory;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.transformer.JournalArticle2NewsTransformer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author YenMC
 * Portlet implementation class NewsPortlet
 *
 */
public class HotNewsPortlet extends MVCPortlet {
	
	private static Logger log = Logger.getLogger(HotNewsPortlet.class);
	private AssetCategory asset;
	private NewsCategory newsCategory;
	private List<NewsCategory> lstNewsCate;
	/**
	 * @author YenMC
	 * handle render request when in VIEW mode
	 * @throws PortletException 
	 * @throws IOException 
	 *
	 */
	public void doView(RenderRequest req, RenderResponse renderResponse) throws IOException, PortletException {
		// get initial config from req  
		HotNewsConfig config = new HotNewsConfig(req);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);
		//
		String displayMode = null;
		if (req.getPreferences().getMap().containsKey("displayMode")) {
			displayMode = config.getPrefs().getValue("displayMode",  CommonConstants.PORTLET.HOT_NEWS.TOP_VIEW);
		}
		String startDay = null;
		if (req.getPreferences().getMap().containsKey("startDay")) {
			startDay = req.getPreferences().getMap().get("startDay")[0];
		} else {
			startDay = String.valueOf(currentDay);
		}
		
		String startMonth = null;
		if (req.getPreferences().getMap().containsKey("startMonth")) {
			startMonth = req.getPreferences().getMap().get("startMonth")[0];
			startMonth = String.valueOf((Integer.parseInt(startMonth) - 1));
		} else {
			startMonth = String.valueOf(currentMonth);
		}
		
		String startYear = null;
		if (req.getPreferences().getMap().containsKey("startYear")) {
			startYear = req.getPreferences().getMap().get("startYear")[0];
		} else {
			startYear = String.valueOf(1950);
		}
		
		//
		String endDay = null;
		if (req.getPreferences().getMap().containsKey("endDay")) {
			endDay = req.getPreferences().getMap().get("endDay")[0];
		} else {
			endDay = String.valueOf(currentDay);
		}
		
		//
		String endMonth = null;
		if (req.getPreferences().getMap().containsKey("endMonth")) {
			endMonth = req.getPreferences().getMap().get("endMonth")[0];
			endMonth = String.valueOf((Integer.parseInt(endMonth) - 1));
		} else {
			endMonth = String.valueOf(currentMonth);
		}
		
		String endYear = null;
		if (req.getPreferences().getMap().containsKey("endYear")) {
			endYear = req.getPreferences().getMap().get("endYear")[0];
		} else {
			endYear = String.valueOf(currentYear);
		}
		
		try {
			 
			Date fromDate = null;
			Date toDate = null;
			
			fromDate = DateUtils.convert2Date(startDay, startMonth , startYear); 
			toDate = DateUtils.convert2Date(endDay, endMonth, endYear); 
			
			List<News> latestNews = new ArrayList<News>();
			List<News> mostViewNews = new ArrayList<News>();
			
			// get structure and categories is selected from configuration
			String strucId = StringPool.BLANK;
			long groupId = PortalUtil.getGroupId(req);
			long cateId = 0l;
			lstNewsCate = new ArrayList<NewsCategory>();
			if (config.isConfigured()) {
				if (null != config.getCatOrders() && 0 < config.getCatOrders().size()) {
					for (KeyValuePair i : config.getCatOrders()) {
						newsCategory = new NewsCategory();
						cateId = Long.parseLong(i.getKey());
						asset = AssetCategoryLocalServiceUtil.getAssetCategory(cateId);
						
						newsCategory.setId(cateId);
						newsCategory.setName(asset.getName());
						lstNewsCate.add(newsCategory);
					}
				}
			}
			
			// get current structure from configuration
			strucId = config.getCurrentStruct().getId();
			
			/*if (displayMode.equals(CommonConstants.PORTLET.HOT_NEWS.TOP_VIEW)) {
				sortsBy.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(4).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
				lstHotNews = BNJournalArticleLocalServiceUtil.getNewsInCategories(req, groupId, strucId, lstNewsCate, Integer.parseInt(numberRecord), sortsBy, fromDate, toDate);
			} else if (displayMode.equals(CommonConstants.PORTLET.HOT_NEWS.LATEST_NEWS)) {
				sortsBy.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(3).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
				lstHotNews = BNJournalArticleLocalServiceUtil.getNewsInCategories(req, groupId, strucId, lstNewsCate, Integer.parseInt(numberRecord), sortsBy, null, null);
			} else {
				sortsBy.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(3).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
				sortsBy.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(4).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
				lstHotNews = BNJournalArticleLocalServiceUtil.getNewsInCategories(req, groupId, strucId, lstNewsCate, Integer.parseInt(numberRecord), sortsBy, null, null);
			}*/
			//get most view news
			List<KeyValuePair> sortsByMostView = new ArrayList<KeyValuePair>();
			sortsByMostView.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(4).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
			mostViewNews = BNJournalArticleLocalServiceUtil.getNewsInCategories(req, groupId, strucId, lstNewsCate, 6, sortsByMostView, fromDate, toDate);
			//trim news
			for (News item : mostViewNews) {
				item.setTitle(StringUtil.shorten(item.getTitle(), 60, "..."));
			}
			req.setAttribute("mostViewNews", mostViewNews);
			//get latest news
			List<KeyValuePair> sortsByLatestNews = new ArrayList<KeyValuePair>();
			sortsByLatestNews.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(3).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
			latestNews = BNJournalArticleLocalServiceUtil.getNewsInCategories(req, groupId, strucId, lstNewsCate, 7, sortsByLatestNews, null, null);
			for (News item : latestNews) {
				item.setTitle(StringUtil.shorten(item.getTitle(), 60, "..."));
				item.setSummary(StringUtil.shorten(item.getSummary(), 100, "..."));
			}
			if(latestNews !=null && latestNews.size() >0) {
				
				req.setAttribute("pinNews", latestNews.get(0));
				latestNews.remove(0);
			}
			req.setAttribute("latestNews", latestNews);
			
			//get list pin news
			List<News> listPinNews = getNewsByTags(groupId, "tin tiêu điểm", req, strucId);
			if(listPinNews != null && listPinNews.size() > 0) {
				for (News item : listPinNews) {
					item.setTitle(StringUtil.shorten(item.getTitle(), 50, "..."));
					item.setSummary(StringUtil.shorten(item.getSummary(), 100, "..."));
				}
				if(listPinNews.size() > 3) {
					req.setAttribute("listPinNews",listPinNews.subList(0, 4));
				} else {
					req.setAttribute("listPinNews",listPinNews);
				}
			}
			
			req.setAttribute("displayMode", displayMode);
			
		} catch (NumberFormatException e) {
			log.info(e.getMessage());
		} catch (PortalException e) {
			log.error(e.getMessage());
		} catch (SystemException e) {
			log.error(e.getMessage());
		}
		
		super.doView(req, renderResponse);
	}

	@SuppressWarnings("unchecked")
	private List<News> getNewsByTags(long groupId, String tagName , RenderRequest req , String structureId)
			throws PortalException, SystemException {
		AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
		long[] anyTagIds = AssetTagLocalServiceUtil.getTagIds(groupId,
				new String[] { "alllocation", tagName });
		assetEntryQuery.setAnyTagIds(anyTagIds);
		List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil
				.getEntries(assetEntryQuery);
		List<JournalArticle> journalArticleList = new ArrayList<JournalArticle>();
		for (AssetEntry ae : assetEntryList) {
			JournalArticleResource journalArticleResourceObj = JournalArticleResourceLocalServiceUtil
					.getJournalArticleResource(ae.getClassPK());
			if(JournalArticleLocalServiceUtil.hasArticle(groupId, journalArticleResourceObj.getArticleId())) {
				JournalArticle journalArticleObj = JournalArticleLocalServiceUtil
						.getArticle(groupId,
								journalArticleResourceObj.getArticleId());
				journalArticleList.add(journalArticleObj);
			}
		}
		List<News> lstNews = new ArrayList<News>();
		if (journalArticleList.size() != 0) {
			lstNews = (List<News>) CollectionUtils.collect(journalArticleList, new JournalArticle2NewsTransformer(req, structureId));
		}
		return lstNews;
	}
}
