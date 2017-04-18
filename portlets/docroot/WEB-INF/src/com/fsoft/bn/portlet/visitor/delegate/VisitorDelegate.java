package com.fsoft.bn.portlet.visitor.delegate;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowStateException;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.Visitor;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.portlet.news.NewsContants.PORTLET_NAME;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.journal.model.JournalArticle;

public class VisitorDelegate {
	
	public List<Visitor> getVisitorNewsArticle(int start , int end, String typeSelected, RenderRequest renderRequest, RenderResponse renderResponse) throws PortalException, SystemException, WindowStateException {

		List<Visitor> lstLatesVisitortNews = new ArrayList<Visitor>();
		Visitor visitor = null;
		String xmlData = StringPool.BLANK;
		String portletURL = "";
		String languageId = LanguageUtil.getLanguageId(renderRequest);
		 // get group id by scope
        long groupId = PortalUtil.getScopeGroupId(renderRequest);
        String structureId = StructureUtil.getStructure(NewsContants.VISITOR_STRUCTURE_NAME).getStructureId();
		List<JournalArticle> listJournalArticle = CommonUtil.getListStructure(
				groupId, structureId, start, end);
		
		for (JournalArticle item : listJournalArticle) {
			xmlData = item.getContent();
			if (typeSelected.equals(StructureUtil.getXsdContentArticleMultiLanguage(xmlData, "type", languageId))) {
				visitor = new Visitor();
				visitor.setTitle(StructureUtil.getXsdTitleArticleMultiLanguage(item.getTitle(), languageId));
				visitor.setImageURL(StructureUtil.getXsdContentArticleMultiLanguage(xmlData, "picture", languageId));
				visitor.setSummary(StructureUtil.getXsdContentArticleMultiLanguage(xmlData, "description", languageId));
				visitor.setContent(StructureUtil.getXsdContentArticleMultiLanguage(xmlData, "content", languageId));
				visitor.setCategoryType(StructureUtil.getXsdContentArticleMultiLanguage(xmlData, "type", languageId));
						
				// create URL and redirect to new detail portlet
				portletURL = NewsUtils.returnPortletURL(renderRequest, "/dukhach-detail", PORTLET_NAME.NEWS_DETAIL, String.valueOf(groupId), structureId, item.getArticleId(), (String) new Double(item.getVersion()).toString());
				
				visitor.setUrlDetail(portletURL.toString());
				
				lstLatesVisitortNews.add(visitor);
			}
		}
		
		return lstLatesVisitortNews;
	}
	
	public int getCountVisitorNewsArticle(RenderRequest renderRequest) throws PortalException, SystemException{
		return CommonUtil.getCountStructure(PortalUtil.getScopeGroupId(renderRequest), StructureUtil.getStructure(NewsContants.VISITOR_STRUCTURE_NAME).getStructureId());
	}
}
