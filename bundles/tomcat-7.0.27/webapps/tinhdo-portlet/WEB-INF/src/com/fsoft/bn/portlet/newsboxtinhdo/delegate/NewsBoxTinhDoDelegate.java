
package com.fsoft.bn.portlet.newsboxtinhdo.delegate;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.portlet.news.NewsContants.PORTLET_NAME;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * 
 * @author VangND1
 *
 */
public class NewsBoxTinhDoDelegate {
	/**
	 * this method using get WritingAbouttinhdoModel from database
	 * @return {@link WritingAbouttinhdoModel}
	 */
	public News getFirstRecordWritingAbouttinhdoModel(PortletRequest request) {
		
		News model = null;
		List<JournalArticle> listJournalArticle = CommonUtil.getListStructure(
				CommonConstants.STRUCTURE.GROUP_ID,
				CommonConstants.STRUCTURE.NEWS_BOX_BN_STRUCTURE_ID, CommonConstants.NUM_0, CommonConstants.NUM_1);
		if (listJournalArticle != null && listJournalArticle.size() > CommonConstants.NUM_0) {
			JournalArticle journalArticle = listJournalArticle.get(CommonConstants.NUM_0);
			if (journalArticle != null) {
				model = new News(journalArticle , CommonConstants.BLANK);
			}
		}
		return model;
	}

	/**
	 * this method using get WritingAbouttinhdoModel from database
	 * @param id 
	 * @return {@link WritingAbouttinhdoModel}
	 */
	public News getBoxNewsById(long id , PortletRequest request , String languageId) {
		News model = null;
		JournalArticle journalArticle = CommonUtil.getStructureById(id);
		if (journalArticle != null) {
			model = new News(journalArticle , getNewsBoxDetailUrl(request, journalArticle) , languageId);
		}
		return model;
	}
	
	public List<News> getListBoxNew(PortletRequest request , int start, int end , String categoryType , String languageId) {
		//get list JournalArticle
		List<JournalArticle> listJournalArticle = CommonUtil.getListStructureByContentFieldValue(
				CommonConstants.STRUCTURE.GROUP_ID, CommonConstants.STRUCTURE.NEWS_BOX_BN_STRUCTURE_ID, start, end,
				NewsContants.XSD_ELEMENT_NAME.CATEGORY, categoryType);
		List<News> listNews = null;
		String urlDetail = CommonConstants.BLANK;
		if (!Validator.isBlankOrNull(listJournalArticle)) {
			listNews = new ArrayList<News>();
			for (JournalArticle bean : listJournalArticle) {
				urlDetail = getNewsBoxDetailUrl(request, bean);
				News model = new News(bean , urlDetail , languageId);
				//add to list model
				listNews.add(model);
			}
		}
		//return list
		return listNews;
	}
	public int getCountWritingAbouttinhdo() {
		return CommonUtil.getCountStructure(CommonConstants.STRUCTURE.GROUP_ID,
				CommonConstants.STRUCTURE.NEWS_BOX_BN_STRUCTURE_ID);
	}
	public List<DataDictionary> getListBoxType() {
		return CommonUtil.getSelectionListFromXSDContent("type", CommonConstants.STRUCTURE.NEWS_BOX_BN_STRUCTURE_ID);
	}
	private String getNewsBoxDetailUrl(PortletRequest request , JournalArticle journalArticle) {
		String groupId = String.valueOf(journalArticle.getGroupId());
		String structureId = journalArticle.getStructureId();
		String articleId = journalArticle.getArticleId();
		String vers = String.valueOf(journalArticle.getVersion());
		String portletURL = NewsUtils.returnPortletURL(request, "/news" ,PORTLET_NAME.NEWS_DETAIL, groupId , structureId, articleId, vers);
		return portletURL;
	}

}
