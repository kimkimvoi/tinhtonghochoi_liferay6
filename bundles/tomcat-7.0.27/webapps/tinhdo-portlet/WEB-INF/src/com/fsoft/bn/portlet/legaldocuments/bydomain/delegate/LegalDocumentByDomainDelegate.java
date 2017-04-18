package com.fsoft.bn.portlet.legaldocuments.bydomain.delegate;

import java.util.ArrayList;
import java.util.List;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.LegalDocumentByDomainModel;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * delegate class for legal document
 * @author VangND1
 *
 */
public class LegalDocumentByDomainDelegate {
	
	/**
	 * This method using get list legal document
	 * @param start 
	 * @param end 
	 * @param categoryType 
	 * @param languageId 
	 * @return {@link List<LegalDocumentByDomainModel>}
	 */
	public List<LegalDocumentByDomainModel> getLegalDocumentByDomainModel(int start, int end, String categoryType,
			String languageId) {
		List<LegalDocumentByDomainModel> result = null;
		//get list JournalArticle
		List<JournalArticle> listJournalArticle = CommonUtil.getListStructureByContentFieldValue(
				CommonConstants.STRUCTURE.GROUP_ID, CommonConstants.STRUCTURE.LEGAL_DOCUMENT_STRUCTURE_ID, start, end,
				"document_domain", categoryType);
		if (!Validator.isBlankOrNull(listJournalArticle)) {
			result = new ArrayList<LegalDocumentByDomainModel>();
			LegalDocumentByDomainModel model = null;
			int i = CommonConstants.NUM_1;
			for (JournalArticle article : listJournalArticle) {
				model = new LegalDocumentByDomainModel(article, languageId);
				model.setNo(String.valueOf(i));
				i++;
				result.add(model);
			}
		}
		return result;
	}
	/**
	 * 
	 * @param categoryType 
	 * @param languageId 
	 * @return {@link Integer}
	 */
	public int getCountLegalDocumentByDomainModel(String categoryType,
			String languageId) {
		//get count
		return CommonUtil.getCountStructureContentFieldValue(
				CommonConstants.STRUCTURE.GROUP_ID, CommonConstants.STRUCTURE.LEGAL_DOCUMENT_STRUCTURE_ID,
				"document_domain", categoryType);
	}
	

}
