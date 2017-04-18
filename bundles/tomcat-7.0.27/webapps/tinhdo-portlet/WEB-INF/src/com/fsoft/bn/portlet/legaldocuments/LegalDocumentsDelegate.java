package com.fsoft.bn.portlet.legaldocuments;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.hsqldb.lib.StringUtil;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.LegalDocumentModel;
import com.fsoft.bn.util.CommonUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class LegalDocumentsDelegate {
	private static Log log = LogFactoryUtil.getLog(LegalDocumentsDelegate.class);
	private static String LEGAL_DOCUMENT_STRUCTURE = "Văn bản pháp quy";
	private static String LEGAL_DOMAIN_STRUCTURE = "Lĩnh vực tài liệu";
	private static String LEGAL_CATEGORY_STRUCTURE = "Loại văn bản pháp quy";
	
	//private static List<PublicNews> getListSearchLegalDocument(String)
	public static List<LegalDocumentModel> getAllLegalDocuments(long groupId){
		log.info("*****get all legal documents*****");
		List<LegalDocumentModel> legalDocumentList = new ArrayList<LegalDocumentModel>();
		try {
			
			// get structure id by name or title
			String structureId = LegalDocumentsUtil.getStructureByName(LEGAL_DOCUMENT_STRUCTURE);
			String sortBy = "modifiedDate";
			
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	} else {
        		allArticles = null;
        	}
        	
        	LegalDocumentModel lastVersionLegalDocument;
			for (JournalArticle ja : allArticles) {
				// 2014/02/27: PhuongLH fix bug FIBIXBP-117
				// > If status == 3 (expired) do not display legal document on screen
				if (ja.getStatus() == 3) {
					continue;
				}
				lastVersionLegalDocument = new LegalDocumentModel();
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				LegalDocumentsUtil  mDocumentsUtil = new LegalDocumentsUtil();
				
				if (mDocumentsUtil.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)) {
					lastVersionLegalDocument = LegalDocumentsUtil.setLegalDocumentArticle(ja);
					legalDocumentList.add(lastVersionLegalDocument);
				}
			}
		}catch (Exception e) {
			log.info(e.getMessage());
		}
		return legalDocumentList;
	}
	
	
	/**
	 * search legal documents
	 */
	public static List<LegalDocumentModel> searchLegalDocumens(ResourceRequest resourceRequest, ResourceResponse response){
		log.info("*****searchLegalDocumens*****");
		List<LegalDocumentModel> legalDocumentSearchList = new ArrayList<LegalDocumentModel>();	
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// get group id by scope
		long groupId = themeDisplay.getScopeGroupId();
		
		String strLegalDomail = ParamUtil.getString(resourceRequest, "legalDomain");
		String strLegalCategory = ParamUtil.getString(resourceRequest, "legalCategory");
		String strLegalAbstract = ParamUtil.getString(resourceRequest, "legalAbstract");
		String strYearPublish = ParamUtil.getString(resourceRequest, "yearPublish");
		String strLegalTextSymbol = ParamUtil.getString(resourceRequest, "legalTextSymbol");
		String strStartDate = ParamUtil.getString(resourceRequest, "startDate");
		String strEndDate = ParamUtil.getString(resourceRequest, "endDate");
		
		HashMap<String, String> keySearch = new HashMap<String, String>();
		keySearch.put("legalDocDomain", strLegalDomail);
		keySearch.put("documentForm", strLegalCategory);
		keySearch.put("descriptionDoc", strLegalAbstract);
		keySearch.put("yearPublish", strYearPublish);
		keySearch.put("legalDocSymbol", strLegalTextSymbol);
		keySearch.put("startDateSearch", strStartDate);
		keySearch.put("endDateSearch", strEndDate);
		
		log.info("======= param info =======: ");
		log.info("**" + strLegalDomail + "**" + strLegalCategory + "**" +
				strLegalAbstract + "**" + strYearPublish + "**" + strStartDate + "**" + strEndDate);
		log.info("======= ********** =======: ");
		//search function
		try{
			// get structure id by name or title
			String structureId = LegalDocumentsUtil.getStructureByName(LEGAL_DOCUMENT_STRUCTURE);
			String sortBy = "modifiedDate";
			
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	}else {
        		allArticles = null;
        	}
        	
        	LegalDocumentModel lastVersionLegalDocument;
			for (JournalArticle ja : allArticles) {
				lastVersionLegalDocument = new LegalDocumentModel();
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				LegalDocumentsUtil  mDocumentsUtil = new LegalDocumentsUtil();
				if(mDocumentsUtil.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)){
					lastVersionLegalDocument = LegalDocumentsUtil.setLegalDocumentArticle(ja);
					if(checkSearchLegalDocuments(lastVersionLegalDocument, keySearch)){
						legalDocumentSearchList.add(lastVersionLegalDocument);
					}
				}
			}
		}catch (Exception e) {
			log.info(e.getMessage());
		}
		
		return legalDocumentSearchList;
	}
	
	/**
	 * get detail document
	 * @param groupId
	 * @return
	 */
	public static LegalDocumentModel getDetailLegalDocument(long groupId, String documentId){
		LegalDocumentModel documentModel = null;
		log.info("*****get legal documents detail*****");
		try {
			
			// get structure id by name or title
			String structureId = LegalDocumentsUtil.getStructureByName(LEGAL_DOCUMENT_STRUCTURE);
			String sortBy = "modifiedDate";
			
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	}else {
        		allArticles = null;
        	}
        	
			for (JournalArticle ja : allArticles) {
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				LegalDocumentsUtil  mDocumentsUtil = new LegalDocumentsUtil();
				if(mDocumentsUtil.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)){
					log.info("****==" + documentId + "*****==" + articleIdCheck);
					if(documentId.equals(articleIdCheck)){
						documentModel = LegalDocumentsUtil.setLegalDocumentArticle(ja);
					}
				}
			}
		}catch (Exception e) {
			log.info(e.getMessage());
		}
		return documentModel;
	}
	
	public static List<DataDictionary> getAllLegalDocumentsDomainByGroup(long groupId){
		log.info("*****get all legal documents domain*****");
		List<DataDictionary> legalDomainList = new ArrayList<DataDictionary>();
		
		try {
			// get structure id by name or title
			String structureId = LegalDocumentsUtil.getStructureByName(LEGAL_DOMAIN_STRUCTURE);
			String sortBy = "modifiedDate";
			
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	}else {
        		allArticles = null;
        	}
        	
        	if(allArticles != null){
        		DataDictionary mLegalDomain;
    			for (JournalArticle ja : allArticles) {
    				mLegalDomain = new DataDictionary();
    				double articleVersion = ja.getVersion();
    				String articleIdCheck = ja.getArticleId();
    				LegalDocumentsUtil  mDocumentsUtil = new LegalDocumentsUtil();
    				if(mDocumentsUtil.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)){
    					mLegalDomain = LegalDocumentsUtil.setLegalDomainArticle(ja);
    					legalDomainList.add(mLegalDomain);
    				}
    			}
        	}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
		log.info("***** legal domain size:" + legalDomainList.size());
		for(DataDictionary lgData: legalDomainList){
			log.info("category== key: " + lgData.getKey() + "** value:" + lgData.getValue());
		}
		log.info("==============================================");
		return legalDomainList;
	}
	
	public static List<DataDictionary> getAllLegalDocumentDomain(RenderRequest request){
		log.info("*****get all legal documents domain*****");
		List<DataDictionary> legalDomainList = new ArrayList<DataDictionary>();
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			// get group id by scope
			long groupId = themeDisplay.getScopeGroupId();
			// get structure id by name or title
			String structureId = LegalDocumentsUtil.getStructureByName(LEGAL_DOMAIN_STRUCTURE);
			String sortBy = "modifiedDate";
			
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	}else {
        		allArticles = null;
        	}
        	
        	if(allArticles != null){
        		DataDictionary mLegalDomain;
    			for (JournalArticle ja : allArticles) {
    				mLegalDomain = new DataDictionary();
    				double articleVersion = ja.getVersion();
    				String articleIdCheck = ja.getArticleId();
    				LegalDocumentsUtil  mDocumentsUtil = new LegalDocumentsUtil();
    				if(mDocumentsUtil.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)){
    					mLegalDomain = LegalDocumentsUtil.setLegalDomainArticle(ja);
    					legalDomainList.add(mLegalDomain);
    				}
    			}
        	}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
		log.info("***** legal domain size:" + legalDomainList.size());
		for(DataDictionary lgData: legalDomainList){
			log.info("category== key: " + lgData.getKey() + "** value:" + lgData.getValue());
		}
		log.info("==============================================");
		return legalDomainList;
	}
	
	public static List<DataDictionary> getAllLegalDocumentCategory(RenderRequest request){
		log.info("*****get all legal documents category*****");
		List<DataDictionary> legalCategorysList = new ArrayList<DataDictionary>();
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			// get group id by scope
			long groupId = themeDisplay.getScopeGroupId();
			// get structure id by name or title
			String structureId = LegalDocumentsUtil.getStructureByName(LEGAL_CATEGORY_STRUCTURE);
			String sortBy = "modifiedDate";
			
			List<JournalArticle> allArticles = null;
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
			
			// get all articles by group id and structure id 
        	if (null != structureId) {
        		allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
        	}else {
        		allArticles = null;
        	}
        	
        	if(allArticles != null){
        		DataDictionary mLegalCategory;
    			for (JournalArticle ja : allArticles) {
    				mLegalCategory = new DataDictionary();
    				double articleVersion = ja.getVersion();
    				String articleIdCheck = ja.getArticleId();
    				LegalDocumentsUtil  mDocumentsUtil = new LegalDocumentsUtil();
    				if(mDocumentsUtil.checkIsArticleLastVersion(groupId, articleIdCheck, articleVersion)){
    					mLegalCategory = LegalDocumentsUtil.setLegalCategoryArticle(ja);
    					legalCategorysList.add(mLegalCategory);
    				}
    			}
        	}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
		log.info("***** legal category size:" + legalCategorysList.size());
		for(DataDictionary lgData: legalCategorysList){
			log.info("category== key: " + lgData.getKey() + "** value:" + lgData.getValue());
		}
		log.info("==============================================");
		return legalCategorysList;
	}
	
	/**
	 * checking object 'LegalDocument' with keySearch
	 * @param publicNews
	 * @param keySearch
	 * @return
	 */
	public static boolean checkSearchLegalDocuments(LegalDocumentModel mDocumentModel, HashMap<String, String> keySearch){
		
		String legalDocDomain 	= keySearch.get("legalDocDomain");
		String documentForm 	= keySearch.get("documentForm");
		String descriptionDoc	= keySearch.get("descriptionDoc");
		String yearPublish 		= keySearch.get("yearPublish");
		String legalDocSymbol	= keySearch.get("legalDocSymbol");
		String startDateSearch	= keySearch.get("startDateSearch");
		String endDateSearch	= keySearch.get("endDateSearch");
		
		//Check domain
		log.info("legal domain: key-" + legalDocDomain + "**value-" + mDocumentModel.getDocument_domain());
		if (!CommonConstants.STRING_0.equalsIgnoreCase(legalDocDomain) 
				&& !legalDocDomain.equalsIgnoreCase(mDocumentModel.getDocument_domain())){
				return false;
		}
		
		if (!CommonConstants.STRING_0.equalsIgnoreCase(documentForm) 
				&& !legalDocDomain.equalsIgnoreCase(mDocumentModel.getDocument_form())){
				return false;
		}
		
		if (!CommonUtil.searchWithSubText(mDocumentModel.getDocument_description(), descriptionDoc)){
			return false;
		}
		
		if (!StringUtil.isEmpty(yearPublish) 
				&& !CommonConstants.STRING_0.equalsIgnoreCase(yearPublish)){
			Date date = mDocumentModel.getPublish_date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			if (!yearPublish.equals(String.valueOf(year))) {
				return false;
			}
		} 
		
		if (!CommonUtil.searchWithSubText(mDocumentModel.getDocument_symbol(), legalDocSymbol)) {
			return false;
		}
		
		if (!StringPool.BLANK.equals(keySearch.get("startDateSearch"))) {
			
			Date startDate = null;
			Date datePublicCompare = null;
			DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
			try {
				startDate = df.parse(startDateSearch);
			} catch (ParseException e) {
				log.info(e.getMessage());
			}			
			Date datePublic = mDocumentModel.getPublish_date();
			String datecompate = df.format(datePublic);
			try {
				datePublicCompare = df.parse(datecompate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				log.info(e.getMessage());
			}
			
			if(null != startDate && null != datePublicCompare){
				if(startDate.after(datePublicCompare)){
					return false;
				}
			}
		}
		
		if(!StringPool.BLANK.equals(keySearch.get("endDateSearch"))){
			Date endDate = null;
			Date datePublicCompare = null;
			DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
			try {
				endDate = df.parse(endDateSearch);
			} catch (ParseException e) {
				log.info(e.getMessage());
			}			
			Date datePublic = mDocumentModel.getPublish_date();
			String datecompate = df.format(datePublic);
			
			try {
				datePublicCompare = df.parse(datecompate);
			} catch (ParseException e) {
				log.info(e.getMessage());
			}	
			
			if(null != endDate && null != datePublicCompare){
				if(endDate.before(datePublicCompare)){
					return false;
				}
			}
		}
		return true;
	}
}
