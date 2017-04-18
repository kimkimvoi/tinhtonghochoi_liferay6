package com.fsoft.bn.portlet.delegate.investmentanddevelopment;

import java.util.ArrayList;
import java.util.List;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AttachFileModel;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

public class InvestmentAndDevelopmentDelegate {
	
	/*@SuppressWarnings("unchecked")
	public List<AttachFileModel> getlistInvestmentAndDevelopmentAttachedFiles(
			List<InvestmentProjects> investmentProjectsList, ThemeDisplay themeDisplay) throws SystemException, PortalException{
		if (Validator.isBlankOrNull(investmentProjectsList)) {
			return new ArrayList<AttachFileModel>();
		}
		int i = 0;
		DynamicQuery dynamicQuery;
		Long [] attachFileIds;
		List<AttachFileModel> listAttachFileModel = new ArrayList<AttachFileModel>(); 
		List<QuestionAttachedFile> listQuestionAttach = new ArrayList<QuestionAttachedFile>();
		String questionId;
		// get answerIds
		for (InvestmentProjects investment : investmentProjectsList) {
			questionId = investment.getQuestion_id();
			dynamicQuery = DynamicQueryFactoryUtil.forClass(QuestionAttachedFile.class)
					.add(PropertyFactoryUtil.forName("question_id").eq(question.getQuestion_id()));
			listQuestionAttach = QuestionAttachedFileLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (listQuestionAttach != null && listQuestionAttach.size() > CommonConstants.NUM_0) {
				i = 0;
				attachFileIds =  new Long[listQuestionAttach.size()];
				for (QuestionAttachedFile questionAttachedFile : listQuestionAttach) {
					attachFileIds[i] = Long.parseLong(questionAttachedFile.getAttached_file_id());
					i++;
				}
				listAttachFileModel.addAll(getAttachFiles(attachFileIds, questionId, themeDisplay));
			}
		}
		return listAttachFileModel;
	}*/
	
	
	@SuppressWarnings("unchecked")
	private List<AttachFileModel> getAttachFiles(Long [] attachFileIds, String documentId, ThemeDisplay themeDisplay) throws SystemException, PortalException {
		String urlDocument;
		List<AttachFileModel> listAttachFileModel = new ArrayList<AttachFileModel>(); 
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileEntry.class)
				.add(PropertyFactoryUtil.forName("fileEntryId").in(attachFileIds));
		List<DLFileEntry> dlFileEntry = new ArrayList<DLFileEntry>();
		FileEntry tempFile = null ;
		dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		if (dlFileEntry != null && dlFileEntry.size() > CommonConstants.NUM_0) {
			for (DLFileEntry dLFileEntry : dlFileEntry) {
				tempFile = DLAppLocalServiceUtil.getFileEntry(dLFileEntry.getFileEntryId());
				urlDocument = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
				listAttachFileModel.add(new AttachFileModel(dLFileEntry.getFileEntryId(), dLFileEntry.getTitle(), dLFileEntry.getDescription(), urlDocument, documentId));
			}
		}
		return listAttachFileModel;
	}
	
	
	
	
}
