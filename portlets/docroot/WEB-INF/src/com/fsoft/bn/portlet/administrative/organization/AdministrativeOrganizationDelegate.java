package com.fsoft.bn.portlet.administrative.organization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AdministrativeOrganizationModel;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.portlet.legaldocuments.LegalDocumentsUtil;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.portlet.news.NewsContants.FRIENDLY_URL;
import com.fsoft.bn.portlet.news.NewsContants.PORTLET_NAME;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class AdministrativeOrganizationDelegate {
	private static Log logger = LogFactoryUtil.getLog(AdministrativeOrganizationDelegate.class);
	
	public static List<AdministrativeOrganizationModel> getAllAdministrativeOrganizationArtical(long groupId, String structureName){
		logger.info("*****get all legal documents*****");
		String structureId = StructureUtil.getStructureId(structureName);
		String sortBy = "modifiedDate";
		List<AdministrativeOrganizationModel> adminOrganizationsArticalList = new ArrayList<AdministrativeOrganizationModel>();
		
		try {
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	}else {
        		allArticles = null;
        	}
        	
        	AdministrativeOrganizationModel lastVersionAdminOrginazationArticle;
			for (JournalArticle ja : allArticles) {
				lastVersionAdminOrginazationArticle = new AdministrativeOrganizationModel();
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				LegalDocumentsUtil  mDocumentsUtil = new LegalDocumentsUtil();
				if(mDocumentsUtil.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)){
					lastVersionAdminOrginazationArticle = convertArticleToAdminOrganizationObject(ja);
					adminOrganizationsArticalList.add(lastVersionAdminOrginazationArticle);
				}
			}
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return adminOrganizationsArticalList;
	}
	
	
	public static List<AdministrativeOrganizationModel> getListAdminOrganization(PortletRequest request, long groupId, String structureName,
			String organName, String articleCategory){
		logger.info("*****getListAdminOrganization " + articleCategory +"*****");
		List<AdministrativeOrganizationModel> listAdminOrganizationModel = new ArrayList<AdministrativeOrganizationModel>();
		String structureId = StructureUtil.getStructureId(structureName);
		String sortBy = "modifiedDate";
		
		try {
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	}
        	
        	String typeOrginazation = "";
        	String typeArticle = "";
        	
			for (JournalArticle ja : allArticles) {
				AdministrativeOrganizationModel adminOrganizationModel = new AdministrativeOrganizationModel();
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				typeOrginazation = StructureUtil.getXsdContentArticle(ja.getContent(), "organization");
				typeArticle = StructureUtil.getXsdContentArticle(ja.getContent(), "category");
				
				if( (organName.equalsIgnoreCase(typeOrginazation)) 
						&& (articleCategory.equalsIgnoreCase(typeArticle))){
					if(checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)){
							adminOrganizationModel = convertArticleToAdminOrganizationObject(ja);
							// create URL and redirect to new detail portlet
							String portletURL = NewsUtils.returnPortletURL(request, FRIENDLY_URL.NEWS_VIEW_DETAIL, PORTLET_NAME.NEWS_DETAIL, 
									String.valueOf(groupId), structureId, articleIdCheck, String.valueOf(articleVersion));
							adminOrganizationModel.setUrlDetail(portletURL);
							listAdminOrganizationModel.add(adminOrganizationModel);
					}
				}
        	}
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return listAdminOrganizationModel;
	}
	/**
	 * get introduce and functional article
	 */
	public static AdministrativeOrganizationModel getIntroduceArticel(PortletRequest request, long groupId, String structureName, 
			String ogranIntroduce, String articleCategory){
		AdministrativeOrganizationModel adminOrganizationModel = null;
		String structureId = StructureUtil.getStructureId(structureName);
		String sortBy = "modifiedDate";
		try {
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	}else {
        		allArticles = null;
        	}
        	
        	Date dateCreate = null;
        	String typeOrginazation = "";
        	String typeArticle = "";
        	adminOrganizationModel = new AdministrativeOrganizationModel();
			for (JournalArticle ja : allArticles) {
				
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				Date articleCreateDate = ja.getModifiedDate();
				typeOrginazation = StructureUtil.getXsdContentArticle(ja.getContent(), "organization");
				typeArticle = StructureUtil.getXsdContentArticle(ja.getContent(), "category");
				if( (ogranIntroduce.equalsIgnoreCase(typeOrginazation)) 
						&& (articleCategory.equalsIgnoreCase(typeArticle))){
					if(checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)){
						if(null == dateCreate || dateCreate.before(articleCreateDate)){
							adminOrganizationModel = convertArticleToAdminOrganizationObject(ja);
							// create URL and redirect to new detail portlet
							String portletURL = NewsUtils.returnPortletURL(request, FRIENDLY_URL.NEWS_VIEW_DETAIL,PORTLET_NAME.NEWS_DETAIL, 
									String.valueOf(groupId), structureId, articleIdCheck, String.valueOf(articleVersion));
							adminOrganizationModel.setUrlDetail(portletURL);
							dateCreate = articleCreateDate;
						}
					}
				}
			}
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
		return adminOrganizationModel;
	}
	
	/**
	 * 
	 */
	public static List<News> getListNewsByCategory(PortletRequest request, String sortBy, String structureId, String organizationName, String category) {
		List<News> news = new ArrayList<News>();
		long groupId = PortalUtil.getGroupId(request);
		
		if (StringUtils.isEmpty(sortBy)) {
			sortBy = NewsContants.DEFAULT_SORT_FIELD;
		}
		
		List<JournalArticle> articles = NewsUtils.getJournalArticles(groupId, structureId, sortBy);
		
		for (JournalArticle article : articles) {
			String categoryType = StructureUtil.getXsdContentArticle(article.getContent(), "category");
			String typeOrginazation = StructureUtil.getXsdContentArticle(article.getContent(), "organization");
			
			if (checkIsArticleLastVersion(groupId, article.getArticleId(), article.getVersion()) && organizationName.equals(typeOrginazation)
					&& category.equals(categoryType) && article.isApproved()) {
				News newsItem = new News();
				String content = article.getContent();
				newsItem.setTitle(StructureUtil.getXsdTitleArticle(article.getTitle()));
				newsItem.setCreatedDate(DateUtils.date2String(article.getCreateDate(), CommonConstants.DATE_FORMAT.DD_MM_YYYY_HHMMSS));
				newsItem.setSummary(StructureUtil.getXsdContentArticle(content, "text_description"));
				newsItem.setImageURL(StructureUtil.getXsdContentArticle(content, "img_description"));
				newsItem.setContent(StructureUtil.getXsdContentArticle(content, "content"));
//				newsItem.setCategoryType(StructureUtil.getXsdContentArticle(content, "category"));
				newsItem.setUrlDetail(getNewsBoxDetailUrl(request, article));
				news.add(newsItem);
			}
		}
		return news;
	}
	/**
	 * this method using get getBoxNewsOganizationDetailById
	 * @param id 
	 * @return {}
	 */
	public static News getBoxNewsOganizationDetailById(long id , PortletRequest request , String languageId) {
		News model = null;
		JournalArticle journalArticle = CommonUtil.getStructureById(id);
		if (journalArticle != null) {
			//model = new News(journalArticle , getNewsBoxDetailUrl(request, journalArticle) , languageId);
			model = convertOrganizationArticleToNews(request, journalArticle, languageId);
		}
		return model;
	}
	
	private static String getNewsBoxDetailUrl(PortletRequest request , JournalArticle journalArticle) {
		String groupId = String.valueOf(journalArticle.getGroupId());
		String structureId = journalArticle.getStructureId();
		String articleId = journalArticle.getArticleId();
		String vers = String.valueOf(journalArticle.getVersion());
		String portletURL = NewsUtils.returnPortletURL(request, FRIENDLY_URL.NEWS_VIEW_DETAIL ,PORTLET_NAME.NEWS_DETAIL, groupId , structureId, articleId, vers);
		return portletURL;
	}
	
	private static News convertOrganizationArticleToNews(PortletRequest request , JournalArticle journalArticle, String languageId){
		News news = new News();
		String content = journalArticle.getContent();
		news.setTitle(StructureUtil.getXsdTitleArticleMultiLanguage(journalArticle.getTitle(), languageId));
		news.setCreatedDate(DateUtils.date2String(journalArticle.getCreateDate(), CommonConstants.DATE_FORMAT.DD_MM_YYYY_HHMMSS));
		news.setSummary(StructureUtil.getXsdContentArticleMultiLanguage(content, "text_description", languageId));
		news.setImageURL(StructureUtil.getXsdContentArticleMultiLanguage(content, "img_description", languageId));
		news.setContent(StructureUtil.getXsdContentArticleMultiLanguage(content, "content", languageId));
//		news.setCategoryType(StructureUtil.getXsdContentArticleMultiLanguage(content, "category", languageId));
		news.setUrlDetail(getNewsBoxDetailUrl(request, journalArticle));
		return news;
	}
	
	/**
	 * Convert Article informations to AdministrativeOrginazatin object
	 */
	public static AdministrativeOrganizationModel convertArticleToAdminOrganizationObject(JournalArticle journalArticle){
		AdministrativeOrganizationModel aminOrganizationModel = new AdministrativeOrganizationModel();
		
		aminOrganizationModel.setId(journalArticle.getArticleId());
		aminOrganizationModel.setTitle(StructureUtil.getXsdTitleArticle(journalArticle.getTitle()));
		aminOrganizationModel.setOrganizationName(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "organization"));
		aminOrganizationModel.setContentCategory(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "category"));
		aminOrganizationModel.setImageURL(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "img_description"));
		aminOrganizationModel.setContentDescription(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "text_description"));
		aminOrganizationModel.setContent(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "content"));
		return aminOrganizationModel;
	}
	
	/**
	 * check latest version
	 */
	public static boolean checkIsArticleLastVersion(long groupId,
			String articleIdCheck, double articleVersion) {
		boolean isLastVersion = false;
		try {
			isLastVersion = JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleIdCheck, articleVersion);
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}

		return isLastVersion;
	}
}
