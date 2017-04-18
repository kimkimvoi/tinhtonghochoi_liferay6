package com.fsoft.bn.portlet.news.detail;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
public class NewsDetailPortlet extends MVCPortlet {
	
	private static Logger log = Logger.getLogger(NewsDetailPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String structureId = ParamUtil.getString(renderRequest, "structId");
		
		//declare delegate
		// get parameters from request of others portlets
		String vers = StringPool.BLANK;
		long groupId = PortalUtil.getGroupId(renderRequest);
		// must replace DASH in parameter to PERIOD to convert into double 
		vers = StringUtil.replace(ParamUtil.getString(renderRequest, "version"), StringPool.DASH, StringPool.PERIOD);
		double version = Double.parseDouble(vers); 
		String articleId = ParamUtil.getString(renderRequest, "articleId");
		String languageId = LanguageUtil.getLanguageId(renderRequest);
		boolean print = ParamUtil.getBoolean(renderRequest,"print");
		
		News newsDetail = this.getNewsDetail(groupId, articleId, version , languageId);
		renderRequest.setAttribute("newsDetail", newsDetail);
		
		PortletURL printPageURL = renderResponse.createRenderURL();
		printPageURL.setWindowState(LiferayWindowState.POP_UP);
		printPageURL.setParameter("articleId", articleId);
		printPageURL.setParameter("version", String.valueOf(version));
		printPageURL.setParameter("languageId", languageId);
		printPageURL.setParameter("viewMode", Constants.PRINT);
		printPageURL.setParameter("print", String.valueOf(true));
		renderRequest.setAttribute("print", print);
		renderRequest.setAttribute("printPageURL", printPageURL.toString());
		
		List<News> lstOtherNews =  BNJournalArticleLocalServiceUtil.getListOtherNewsInDetailPage(renderRequest, groupId, structureId, articleId, StringPool.BLANK, StringPool.BLANK, null);
		int quanOtherNewsShow = 5;
		renderRequest.setAttribute("lstOtherNews", lstOtherNews);
		renderRequest.setAttribute("quanOtherNewsShow", quanOtherNewsShow);

		super.doView(renderRequest, renderResponse);
	}

	
	/**
	 * @author YenMC
	 * @param groupId
	 * @param articleId
	 * @param version
	 * @return newsDetail
	 */
	private News getNewsDetail(long groupId, String articleId, double version, String languageId) {
		News newsDetail = null;
		try {
			JournalArticle ja = JournalArticleLocalServiceUtil.getArticle(groupId, articleId, version);
			
			// get category of Journal Article 
			List<AssetCategory> lstCategories = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), ja.getResourcePrimKey());
			
			newsDetail = new News(ja, null, languageId);
			// set category name to news record
			if (CollectionUtils.isNotEmpty(lstCategories)) {
					newsDetail.setCateName(lstCategories.get(0).getTitle(languageId));
			}
						
			// increment view count
			AssetEntryServiceUtil.incrementViewCounter(JournalArticle.class.getName(), ja.getResourcePrimKey());

		} catch (PortalException e) {
			log.error(e.getMessage());
		} catch (SystemException e) {
			log.error(e.getMessage());
		}

		return newsDetail;
	}
}