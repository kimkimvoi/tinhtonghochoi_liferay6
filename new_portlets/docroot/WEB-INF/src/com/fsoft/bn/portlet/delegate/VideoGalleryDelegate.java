package com.fsoft.bn.portlet.delegate;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.BNVideoModel;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.domain.news.NewsCategory;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.journal.model.JournalArticle;
/**
 * Logic class for video gallery
 * @author VangND1
 *
 */
public class VideoGalleryDelegate {
	/** logger */
	private static Logger logger = Logger.getLogger(VideoGalleryDelegate.class);
	/**
	 * 
	 * @param folderId 
	 * @param themeDisplay 
	 * @param start 
	 * @param end 
	 * @return {@link List<BNVideoModel>}
	 */
	public List<BNVideoModel> getListVideo(PortletRequest request) {
		List<BNVideoModel> listVideoModel = new ArrayList<BNVideoModel>();
		try {
			List<JournalArticle> items= StructureUtil.getAllArticleLastVersionByStructureId(request, CommonConstants.STRUCTURE.VIDEO_STRUCTURE_ID);
			//add video to list
			for (JournalArticle item : items) {
				listVideoModel.add(new BNVideoModel(item));
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return listVideoModel;
	}
	public List<BNVideoModel> getListVideo(PortletRequest request ,List<NewsCategory> listCategorySelected, List<KeyValuePair> sortbys) {
		List<BNVideoModel> listVideoModel = new ArrayList<BNVideoModel>();
		//NewsPage newsPage = BNJournalArticleLocalServiceUtil.getNews(request, CommonConstants.STRUCTURE.VIDEO_STRUCTURE_ID, categoryId, 9999, 0, false, sortbys);
		List<News> listNews = BNJournalArticleLocalServiceUtil
				.getNewsInCategories(request,
						CommonConstants.STRUCTURE.GROUP_ID,
						CommonConstants.STRUCTURE.VIDEO_STRUCTURE_ID,
						listCategorySelected,15, sortbys, null, null);
		//TODO: need get count video .
		if(!Validator.isBlankOrNull(listNews)) {
			for (News item : listNews) {
				listVideoModel.add(new BNVideoModel(StringUtil.shorten(item.getTitle(), 100, " ..."),
						item.getOtherProps().get("ID Youtube")));
			}
		}
		return listVideoModel;
	}
}
