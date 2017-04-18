package com.fsoft.bn.portlet.legaldocuments;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.LegalDocumentModel;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;

public class LegalDocumentsUtil {
	private static Log log = LogFactoryUtil.getLog(LegalDocumentsUtil.class);
	
	public static String getXsdTitleArticle(String articleTitle) {
		Document document = null;
		String result = "";
		try {
			if (null != articleTitle && articleTitle.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleTitle));
				Node node = document.selectSingleNode("/root/Title");
				if (node.getText().length() > 0) {
					result = node.getText();
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		return result;
	}

	public static String getXsdContentArticle(String articleContent, String itemName) {
		Document document = null;
		String result = "";
		try {
			if (null != articleContent && articleContent.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleContent));
				Node node = document
						.selectSingleNode("/root/dynamic-element[@name='"
								+ itemName + "']/dynamic-content");
				if (node.getText().length() > 0) {
					result = node.getText();
				}
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}

		return result;
	}
	// function get structure id by name
	public static String getStructureByName(String name) {

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(
				JournalStructure.class).add(
				PropertyFactoryUtil.forName("name").like("%" + name + "%"));

		try {
			@SuppressWarnings("unchecked")
			List<JournalStructure> lstStructure = JournalStructureLocalServiceUtil
					.dynamicQuery(dq, 0, 1);

			if (null != lstStructure && lstStructure.size() > 0) {
				return lstStructure.get(0).getStructureId();
			} else {
				log.info("No structure found!");
				return null;
			}

		} catch (SystemException e) {
			log.error("Exception when get structure: " + e.getMessage());
		}
		return null;
	}
	
	public static List<LegalDocumentModel> getLegalDocumentListPaging(List<LegalDocumentModel> legalDocumentModels,
			int start, int end){
		List<LegalDocumentModel> mListLegalDocPaging = new ArrayList<LegalDocumentModel>();
		if(legalDocumentModels.size() > 0 && legalDocumentModels.size() > start){
			for (int i = start; i < end; i++) {
				if(i < legalDocumentModels.size()){
					mListLegalDocPaging.add(legalDocumentModels.get(i));
				}else {
					break;
				}
			}
		}
		
		return mListLegalDocPaging;
	}
	
	/**
	 * @author DucNH1
	 * @param groupId
	 * @param articleId
	 * @param version
	 * @return
	 * This function check last version of article
	 */
	
	public boolean checkIsArticleLastVersion(long groupId,
			String articleIdCheck, double articleVersion) {
		boolean isLastVersion = false;
		try {
			isLastVersion = JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleIdCheck, articleVersion);
		} catch (PortalException e) {
			log.info(e.getMessage());
		} catch (SystemException e) {
			log.info(e.getMessage());
		}

		return isLastVersion;
	}
	
	//Get content for Repeatable node 
	public static List<String> getXsdContentArticleList(String articleContent, String itemName) {
		Document document = null;
		List<String> resultList = new ArrayList<String>();
		try {
			if (null != articleContent && articleContent.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleContent));
				List<Node> nodeList = document.selectNodes("/root/dynamic-element[@name='"+ itemName + "']/dynamic-content");
				if(nodeList != null){
					for(int i = 0; i < nodeList.size(); i++){
						Node node = nodeList.get(i);
						
						if (node.getText().length() > 0) {
							String result = node.getText();
							resultList.add(result);
						}
					}
				}
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}

		return resultList;
	}
	
	/**
	 * 
	 * @param ja
	 * @return
	 */
	public static LegalDocumentModel setLegalDocumentArticle(JournalArticle ja) {
		LegalDocumentModel mDocumentModel = new LegalDocumentModel();
		String jaContent = ja.getContent();
		String jaID =  ja.getArticleId();
		
		//set object
		mDocumentModel.setId(jaID);
		mDocumentModel.setDocument_symbol(getXsdContentArticle(jaContent, "document_symbol"));
		mDocumentModel.setDocument_domain(getXsdContentArticle(jaContent, "document_domain"));
		mDocumentModel.setDocument_form(getXsdContentArticle(jaContent, "document_form"));
		mDocumentModel.setDocument_description(getXsdContentArticle(jaContent, "document_description"));
		mDocumentModel.setPublish_date(ja.getCreateDate());
		mDocumentModel.setEffect_date(getXsdContentArticle(jaContent, "effect_date"));
		mDocumentModel.setGrade_publisher(getXsdContentArticle(jaContent, "grade_publisher"));
		mDocumentModel.setOrgan_publisher(getXsdContentArticle(jaContent,"organ_publisher"));
		mDocumentModel.setSigner(getXsdContentArticle(jaContent, "signer"));
		mDocumentModel.setFile_attach(getXsdContentArticleList(jaContent, "file_attach"));
		return mDocumentModel;
	}
	
	/**
	 * setLegalDomainArticle
	 * @param ja
	 * @return
	 */
	public static DataDictionary setLegalDomainArticle(JournalArticle ja){
		DataDictionary mLegalDomain = new DataDictionary();
		String jaContent = ja.getContent();
		String jaID =  ja.getArticleId();
		
		//set object
		mLegalDomain.setKey(Long.parseLong(jaID));
		mLegalDomain.setValue(getXsdContentArticle(jaContent, "name"));
		return mLegalDomain;
	}
	/**
	 * setLegalCategoryArticle
	 * @param ja
	 * @return
	 */
	public static DataDictionary setLegalCategoryArticle(JournalArticle ja){
		DataDictionary mLegalDomain = new DataDictionary();
		String jaContent = ja.getTitle();
		String jaID =  ja.getArticleId();
		
		//set object
		mLegalDomain.setKey(Long.parseLong(jaID));
		mLegalDomain.setValue(jaContent);
		return mLegalDomain;
	}
	
	/**
	 * function search text in string
	 * @param fullText 
	 * @param keyWord
	 * @return
	 *//*
	public static boolean searchWithSubText(String fullText, String keyWord){
		if(!StringUtil.isEmpty(keyWord) && !StringUtil.isEmpty(fullText)){
			String[] keyPublicNewsArray = keyWord.split(" ");
			for(int i = 0; i < keyPublicNewsArray.length; i++){
				String subKey = keyPublicNewsArray[i];
				if(fullText.toLowerCase().contains(subKey.toLowerCase())){
					return true;
				}
			}
		}else{
			return true;
		}
		return false;
	}*/
}
