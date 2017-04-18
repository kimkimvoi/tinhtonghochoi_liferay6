package com.fsoft.bn.portlet.news.hot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.news.HotNewsConfig;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.domain.news.NewsCategory;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
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
	 *
	 */
	public void doView(RenderRequest req, RenderResponse renderResponse) {
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
		
		String numberRecord = null;
		if (req.getPreferences().getMap().containsKey("quantityItemForSlide")) {
			numberRecord = req.getPreferences().getMap().get("quantityItemForSlide")[0];
		} else {
			numberRecord = String.valueOf(CommonConstants.NUM_6);
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
			
			List<News> lstHotNews = new ArrayList<News>();
			
			// get structure and categories is selected from configuration
			String strucId = StringPool.BLANK;
			long groupId = PortalUtil.getGroupId(req);
			List<KeyValuePair> sortsBy = new ArrayList<KeyValuePair>();
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
			
			if (displayMode.equals(CommonConstants.PORTLET.HOT_NEWS.TOP_VIEW)) {
				sortsBy.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(4).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
				lstHotNews = BNJournalArticleLocalServiceUtil.getNewsInCategories(req, groupId, strucId, lstNewsCate, Integer.parseInt(numberRecord), sortsBy, fromDate, toDate);
			} else if (displayMode.equals(CommonConstants.PORTLET.HOT_NEWS.LATEST_NEWS)) {
				sortsBy.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(3).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
				lstHotNews = BNJournalArticleLocalServiceUtil.getNewsInCategories(req, groupId, strucId, lstNewsCate, Integer.parseInt(numberRecord), sortsBy, null, null);
			} else {
				sortsBy.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(3).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
				sortsBy.add(new KeyValuePair(NewsContants.SORTBY_OPTIONS.get(4).getKey(), NewsContants.SORTBY_TYPES.get(1).getKey()));
				lstHotNews = BNJournalArticleLocalServiceUtil.getNewsInCategories(req, groupId, strucId, lstNewsCate, Integer.parseInt(numberRecord), sortsBy, null, null);
			}

			req.setAttribute("lstNews", lstHotNews);
			req.setAttribute("displayMode", displayMode);
			
			super.doView(req, renderResponse);
			
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (PortletException e) {
			log.error(e.getMessage());
		} catch (NumberFormatException e) {
			log.info(e.getMessage());
		} catch (PortalException e) {
			log.error(e.getMessage());
		} catch (SystemException e) {
			log.error(e.getMessage());
		}
	}
}
