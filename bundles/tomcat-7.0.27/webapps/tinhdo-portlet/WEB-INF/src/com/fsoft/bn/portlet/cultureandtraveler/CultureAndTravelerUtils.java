package com.fsoft.bn.portlet.cultureandtraveler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.portlet.news.NewsContants.PORTLET_NAME;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class CultureAndTravelerUtils {
	
	/**
	 * @author DucNH1 
	 * @param renderRequest
	 * @return
	 */
	public static Map<String, String> getCategories(RenderRequest renderRequest) {
		return StructureUtil.getStructureXSDSelectionListGlobal(CultureAndTravelerConstants.CULTURE_AND_TRAVELER_STRUCTURE_NAME,
				CultureAndTravelerConstants.CULTURE_AND_TRAVELER_CATEGORY_XSD_ELEMENT_NAME);
	}
	
	/**
	 * @author DucNH1
	 * @return
	 */
	public static String getCultureAndTravelerStructureId() {
		return StructureUtil.getStructureId(CultureAndTravelerConstants.CULTURE_AND_TRAVELER_STRUCTURE_NAME);
	}

	/**
	 * @author DucNH1
	 * @param groupId
	 * @param structureId
	 * @param sortBy
	 * @return this function get all journal article by groupId and StructureId
	 */
	public static List<JournalArticle> getJournalArticles(long groupId, String structureId, String sortBy) {
		try {
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy, false);
			return JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * @author DucNH1
	 * @param groupId
	 * @param articleId
	 * @param version
	 * @return This function check last version of article
	 */
	public static boolean isLatest(long groupId, String articleId, double version) {
		try {
			return JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleId, version);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	/**
	 * @author DucNH1
	 * @param request
	 * @param sortBy
	 * @param categoryName
	 * @return
	 */
	public static List<News> getCultureAndTravelerByCategory(PortletRequest request, String sortBy, String categoryName) {
		List<News> listNews = new ArrayList<News>();
		String structureId = CultureAndTravelerUtils.getCultureAndTravelerStructureId();
		long groupId = PortalUtil.getGroupId(request);
		String languageId = LanguageUtil.getLanguageId(request);
		if(StringUtils.isEmpty(sortBy)){
			sortBy = CultureAndTravelerConstants.DEFAULT_SORT_FIELD;
		}

		List<JournalArticle> articles = getJournalArticles(groupId, structureId, sortBy);
		String portletURL = "";
		for (JournalArticle article : articles) {;
			String categoryType = StructureUtil.getXsdContentArticleMultiLanguage(article.getContent(), CultureAndTravelerConstants.CULTURE_AND_TRAVELER_CATEGORY_XSD_ELEMENT_NAME, languageId);
			if (isLatest(groupId, article.getArticleId(), article.getVersion()) && categoryName.equals(categoryType)
					&& article.isApproved()) {

				portletURL = NewsUtils.returnPortletURL(request, "/dukhach-detail", PORTLET_NAME.NEWS_DETAIL, String.valueOf(groupId), structureId, article.getArticleId(), String.valueOf(article.getVersion()));

				listNews.add(new News(article, portletURL.toString(), languageId));
			}
		}

		return listNews;
	}
}
