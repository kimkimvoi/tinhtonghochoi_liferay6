package com.fsoft.bn.portlet.linkpage.delegate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.LinkModel;
import com.fsoft.bn.domain.LinkPageModel;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.journal.model.JournalArticle;
/**
 * Logic class for link page
 * @author VangND1
 *
 */
public class LinkPageDelegate {
	
	/**
	 * Get all link page
	 * @return {@link List<LinkPageModel>}
	 */
	public List<LinkPageModel> getAllLinkPage() {
		
		List<LinkPageModel> listPageModel = new ArrayList<LinkPageModel>();
		LinkPageModel linkPageModel = null;
		String xmlData = StringPool.BLANK;
		List<JournalArticle> liJournalArticle = CommonUtil.getListStructure(
				CommonConstants.STRUCTURE.LINK_PAGE_GROUP_ID,
				CommonConstants.STRUCTURE.LINK_PAGE_STRUCTURE_ID,
				CommonConstants.NUM_0, CommonUtil.getCountStructure(
						CommonConstants.STRUCTURE.LINK_PAGE_GROUP_ID,
						CommonConstants.STRUCTURE.LINK_PAGE_STRUCTURE_ID));
		
		Map<String, List<LinkModel>> mapLink = new HashMap<String, List<LinkModel>>();
		
		if (!Validator.isBlankOrNull(liJournalArticle)) {
			String linkType = StringPool.BLANK;
			String linkURL = StringPool.BLANK;
			
			List<LinkModel> list = new ArrayList<LinkModel>();
			LinkModel link = new LinkModel();
			for (JournalArticle item : liJournalArticle) {
				
				xmlData = item.getContent();
				linkType = CommonUtil.getXsdContentArticle(xmlData, CommonConstants.PORTLET.LINK_PAGE.TYPE);
				linkURL = CommonUtil.getXsdContentArticle(xmlData, CommonConstants.PORTLET.LINK_PAGE.URL);
				
				list = mapLink.get(linkType);
				if (null == list) {
					list = new ArrayList<LinkModel>();
				}
				link = new LinkModel();
				link.setTitle(CommonUtil.getXsdTitleArticle(item.getTitle()));
				link.setUrl(linkURL);
				list.add(link);
				mapLink.put(linkType, list);
			}
		}
		for (Map.Entry<String, List<LinkModel>> item : mapLink.entrySet()) {
			linkPageModel = new LinkPageModel();
			linkPageModel.setType(item.getKey());
			linkPageModel.setLinks(item.getValue());
			listPageModel.add(linkPageModel);
		}
		
		return listPageModel;
	}
	/**
	 * This method using get list link page by category
	 * @return {@link List<DataDictionary>}
	 */
	public List<DataDictionary> getListLinkPageCategory() {
		return CommonUtil.getSelectionListFromXSDContent(CommonConstants.PORTLET.LINK_PAGE.TYPE,
				CommonConstants.STRUCTURE.LINK_PAGE_STRUCTURE_ID);
	}
}
