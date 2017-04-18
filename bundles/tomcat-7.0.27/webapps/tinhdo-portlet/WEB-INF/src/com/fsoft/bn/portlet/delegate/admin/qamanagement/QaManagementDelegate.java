package com.fsoft.bn.portlet.delegate.admin.qamanagement;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AdminQaManagementModel;
import com.fsoft.bn.domain.AttachFileModel;
import com.fsoft.bn.exception.BNException;
import com.fsoft.bn.model.Answer;
import com.fsoft.bn.model.AnswerAttachedFile;
import com.fsoft.bn.model.Question;
import com.fsoft.bn.model.QuestionAttachedFile;
import com.fsoft.bn.model.impl.AnswerAttachedFileImpl;
import com.fsoft.bn.model.impl.AnswerImpl;
import com.fsoft.bn.service.AnswerAttachedFileLocalServiceUtil;
import com.fsoft.bn.service.AnswerLocalServiceUtil;
import com.fsoft.bn.service.QuestionAttachedFileLocalServiceUtil;
import com.fsoft.bn.service.QuestionLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
/**
 * 
 * @author QuangTN3
 *
 */
public class QaManagementDelegate {
	
	private static Log logging = LogFactoryUtil.getLog(QaManagementDelegate.class);
	/**
	 * @author QuangTN3
	 * @param adminQaManaModel
	 * @param themeDisplay
	 * @throws SystemException
	 * @throws PortalException
	 * set data to adminqamodel
	 */
	public void getQuestionData(AdminQaManagementModel adminQaManaModel, ThemeDisplay themeDisplay) 
			throws SystemException, PortalException {
		adminQaManaModel.setQuestionList(findQuestionList(adminQaManaModel));
		adminQaManaModel.setAnswerList(getAnswerList(adminQaManaModel));
		adminQaManaModel.setListAnswerAttach(getlistAttachedFileAnswer(adminQaManaModel, themeDisplay));
		adminQaManaModel.setListQuestionAttach(getlistQuestionAttachedFiles(adminQaManaModel, themeDisplay));
		adminQaManaModel.setNumOfPage(getQuestionCount(adminQaManaModel));
	}
	
	/**
	 * @author QuangTN3
	 * @param adminQaManaModel
	 * @param start
	 * @param end
	 * @return question list
	 */
	@SuppressWarnings("unchecked")
	private List<Question> findQuestionList(AdminQaManagementModel adminQaManaModel) {
		DynamicQuery dynamicQuery = builtQuery(adminQaManaModel);
		try {
			// get question list
			return QuestionLocalServiceUtil.dynamicQuery(dynamicQuery, 
					adminQaManaModel.getStartNumberOfPage(), adminQaManaModel.getEndNumberOfPage());
		} catch (SystemException e) {
			logging.error(e.getMessage());
			return new ArrayList<Question>();
		}
	}
	
	/**
	 * @author QuangTN3
	 * @param adminQaManaModel
	 * @return number of question with search input
	 */
	private long getQuestionCount(AdminQaManagementModel adminQaManaModel) {
		DynamicQuery dynamicQuery = builtQuery(adminQaManaModel);
		try {
			// count number of pages
			long count = QuestionLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			if (count % adminQaManaModel.getQuestionPerPage() > 0) {
				return count / adminQaManaModel.getQuestionPerPage() + 1;
			} else {
				return count / adminQaManaModel.getQuestionPerPage() ;
			}
		} catch (SystemException e) {
			logging.error(e.getMessage());
			return 0;
		}
	}
	
	/**
	 * @author QuangTN3
	 * @param adminQaManaModel
	 * @return dynamic query with input parameter
	 */
	private DynamicQuery builtQuery(AdminQaManagementModel adminQaManaModel) {
		String questionType 	= adminQaManaModel.getQuestionTypeSelected();
		String questionStatus 	= adminQaManaModel.getQuestionStatusSelected();
		String searchKeyWord 	= adminQaManaModel.getQuestionTextSearch();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Question.class);
		// check question type
		if (!CommonConstants.STRING_0.equals(questionType)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("question_type_id").eq(questionType));
		}
		
		// check question status
		if (!CommonConstants.STRING_0.equals(questionStatus)) {
			if (CommonConstants.STRING_1.equals(questionStatus)) {
				dynamicQuery.add(PropertyFactoryUtil.forName("question_status_id").eq(CommonConstants.STRING_1));
			} else if (CommonConstants.STRING_2.equals(questionStatus)) {
				dynamicQuery.add(PropertyFactoryUtil.forName("question_status_id").eq(CommonConstants.STRING_2));
			} else if (CommonConstants.STRING_3.equals(questionStatus)) {
				dynamicQuery.add(PropertyFactoryUtil.forName("question_status_id").eq(CommonConstants.STRING_3));
			}
		}
		
		// add condition with key word has been enter
		if (!Validator.isBlankOrNull(searchKeyWord)) {
			Junction junction = RestrictionsFactoryUtil.disjunction();
			junction.add(RestrictionsFactoryUtil.ilike("question_title", "%" + searchKeyWord + "%"))
					.add(RestrictionsFactoryUtil.ilike("citizen_name", "%" + searchKeyWord + "%"))
					.add(RestrictionsFactoryUtil.ilike("question_content", "%" + searchKeyWord + "%"));
			dynamicQuery.add(junction);
		}
		//++QuangTN3 - fix FIBIXBP-150
		dynamicQuery.addOrder(PropertyFactoryUtil.forName("created_date").desc());
		dynamicQuery.addOrder(PropertyFactoryUtil.forName("question_status_id").asc());
		//--QuangTN3 - fix FIBIXBP-150
		
		return dynamicQuery;
	}
	
	/**
	 * @author QuangTN3
	 * @param answer
	 * @param file
	 * @param themeDisplay
	 * @param request
	 * @param fileName
	 * @return result attach file
	 * add file attach to DlEntry
	 * @throws IOException 
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	private AnswerAttachedFile addAttachedFile(Answer answer, File file, ThemeDisplay themeDisplay,
			PortletRequest request,String fileName) throws BNException {
		AnswerAttachedFile result = null;
		AnswerAttachedFile answerAttachedFile = null;
		DLFileEntry fileEntry = null;
		try {
			boolean isEmptyFileUpload =  (file.length() == 0);
			// check upload file data
			if (!isEmptyFileUpload) {
				String dat = new SimpleDateFormat(CommonConstants.DATE_FORMAT.YYYY_MM_DD_DASH).format(new Date());
				String description = answer.getAnswer_id() + StringPool.DASH + dat + StringPool.DASH + fileName;
				byte[] imageBytes = FileUtil.getBytes(file);
				InputStream is = new ByteArrayInputStream(imageBytes);
				// get service context
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
						request);
				fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), 0,
						file.getName(), MimeTypesUtil.getContentType(file), fileName, description,
						StringPool.BLANK, 0, null, file, is, file.getTotalSpace(),
						serviceContext);
				answerAttachedFile = new AnswerAttachedFileImpl();
				// insert data to database
				if (!Validator.isBlankOrNull(fileEntry)) {
					answerAttachedFile.setAttached_file_id(String.valueOf(fileEntry.getFileEntryId()));
					answerAttachedFile.setAnswer_id(answer.getAnswer_id());
					answerAttachedFile.setCreated_date(new Date());
					answerAttachedFile.setModified_date(new Date());
					result = AnswerAttachedFileLocalServiceUtil.addAnswerAttachedFile(answerAttachedFile);
				}
				
			}
		} catch (Exception e) {
			throw new BNException(CommonUtil.getText(request, "portlet.questionLists.msg.error.attachfile"));
		}
		
		return result;
	}
	
	/**
	 * @author QuangTN3
	 * @param adminQaManaModel
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 * 
	 */
	public void updateAnswer(AdminQaManagementModel adminQaManaModel) throws BNException {
		File [] files = adminQaManaModel.getFile();
		String [] fileNames = adminQaManaModel.getFileName();
		Answer answerBean = new AnswerImpl();
		Answer result;
		Question questionBean;
		int count = 0;
		
		try {
			// get question info
			questionBean = QuestionLocalServiceUtil.getQuestion(adminQaManaModel.getQuesId());	
		} catch (Exception ex) {
			throw new BNException(CommonUtil.getText(adminQaManaModel.getRequest(), "portlet.questionLists.msg.error.updateQuestionContent"));
		}
		
		// check question's exists before process
		if (questionBean != null) {
			if (Validator.isBlankOrNull(adminQaManaModel.getAnswerId())) {
				// create new answer 
				answerBean = new AnswerImpl();
				answerBean.setAnswer_content(adminQaManaModel.getAnswerContent());
				answerBean.setDeleted(CommonConstants.FALSE);
				answerBean.setCreated_date(new Date());
				answerBean.setModified_date(new Date());
				String userId = String.valueOf(PortalUtil.getUserId(adminQaManaModel.getRequest()));
				answerBean.setUser_id(userId);
				
				// insert new answer if not exists before
				try {
					result = AnswerLocalServiceUtil.addAnswer(answerBean);
				} catch (Exception ex) {
					throw new BNException(CommonUtil.getText(adminQaManaModel.getRequest(), "portlet.questionLists.msg.error.updateAnswerContent"));
				}
				
				if (null != result) {
					for (File file : files) {
						if(null != file && file.length() != 0) {
							addAttachedFile(result, file, adminQaManaModel.getThemeDisplay(), adminQaManaModel.getRequest(), fileNames[count]);
							count++;
						}
					}
					
					// update answer id into question table
					questionBean.setAnswer_id(result.getAnswer_id());
					questionBean.setQuestion_status_id(CommonConstants.STRING_2);
					try {
						QuestionLocalServiceUtil.updateQuestion(questionBean);
					} catch (Exception ex) {
						throw new BNException(CommonUtil.getText(adminQaManaModel.getRequest(), "portlet.questionLists.msg.error.updateQuestionContent"));
					}
				} else {
					throw new BNException(CommonUtil.getText(adminQaManaModel.getRequest(), "portlet.questionLists.msg.error.answerChange"));
				}
				
			} else {
				// update answer if exists before
				try {
					answerBean = AnswerLocalServiceUtil.getAnswer(adminQaManaModel.getAnswerId());
					answerBean.setAnswer_content(adminQaManaModel.getAnswerContent());
					answerBean.setModified_date(new Date());
					result = AnswerLocalServiceUtil.updateAnswer(answerBean);
				} catch (Exception ex) {
					throw new BNException(CommonUtil.getText(adminQaManaModel.getRequest(), "portlet.questionLists.msg.error.updateAnswerContent"));
				}
				
				if (null != result) {
					for (File file : files) {
						if (null != file && file.length() != 0) {
							addAttachedFile(result, file, adminQaManaModel.getThemeDisplay(), adminQaManaModel.getRequest(), fileNames[count]);
							count++;
						}
					}
				} else {
					throw new BNException(CommonUtil.getText(adminQaManaModel.getRequest(), "portlet.questionLists.msg.error.answerChange"));
				}
			} 
			
		} else {
			throw new BNException(CommonUtil.getText(adminQaManaModel.getRequest(), "portlet.questionLists.msg.error.questionChange"));
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private List<Answer> getAnswerList(AdminQaManagementModel adminQaManaModel) throws SystemException{
		List<Question> questionList = adminQaManaModel.getQuestionList();
		
		if (Validator.isBlankOrNull(questionList)) {
			return new ArrayList<Answer>();
		}
		
		String [] answerIds = new String[questionList.size()];
		int i = 0;
		
		for (Question question : questionList) {
			if (!Validator.isBlankOrNull(question.getAnswer_id())) {
				answerIds[i] = question.getAnswer_id();
				i++;
			}
		}
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Answer.class)
				.add(PropertyFactoryUtil.forName("answer_id").in(answerIds));
			
		return AnswerLocalServiceUtil.dynamicQuery(dynamicQuery, 
				adminQaManaModel.getStartNumberOfPage(), adminQaManaModel.getEndNumberOfPage());
	}
	
	@SuppressWarnings("unchecked")
	private List<AttachFileModel> getlistAttachedFileAnswer(
			AdminQaManagementModel adminQaManaModel, ThemeDisplay themeDisplay) throws SystemException, PortalException{
		List<Answer> answerList = adminQaManaModel.getAnswerList();
		if (Validator.isBlankOrNull(answerList)) {
			return new ArrayList<AttachFileModel>();
		}
		
		int i;
		DynamicQuery dynamicQuery;
		String answerId;
		Long [] attachFileIds;
		List<AnswerAttachedFile> listAnswerAttach;
		List<AttachFileModel> listAttachFileModel = new ArrayList<AttachFileModel>(); 
		// get attach files each answer
		for (Answer answer : answerList) {
			answerId = answer.getAnswer_id();
			dynamicQuery = DynamicQueryFactoryUtil.forClass(AnswerAttachedFile.class)
					.add(PropertyFactoryUtil.forName("answer_id").eq(answerId));
			listAnswerAttach = AnswerAttachedFileLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			if (null != listAnswerAttach && listAnswerAttach.size() > 0) {
				i = 0;
				attachFileIds =  new Long[listAnswerAttach.size()];
				for (AnswerAttachedFile answerAttachedFile : listAnswerAttach) {
					attachFileIds[i] = Long.parseLong(answerAttachedFile.getAttached_file_id());
					i++;
				}
				listAttachFileModel.addAll(getAttachFiles(attachFileIds, answerId, themeDisplay));				
			}
			
		}
		return listAttachFileModel;
	}
	
	
	@SuppressWarnings("unchecked")
	private List<AttachFileModel> getlistQuestionAttachedFiles(
			AdminQaManagementModel adminQaManaModel, ThemeDisplay themeDisplay) throws SystemException, PortalException{
		List<Question> questionList = adminQaManaModel.getQuestionList();
		if (Validator.isBlankOrNull(questionList)) {
			return new ArrayList<AttachFileModel>();
		}
		
		int i;
		DynamicQuery dynamicQuery;
		Long [] attachFileIds;
		List<QuestionAttachedFile> listQuestionAttach;
		List<AttachFileModel> listAttachFileModel = new ArrayList<AttachFileModel>(); 
		String questionId;
		// get answerIds
		for (Question question : questionList) {
			questionId = question.getQuestion_id();
			dynamicQuery = DynamicQueryFactoryUtil.forClass(QuestionAttachedFile.class)
					.add(PropertyFactoryUtil.forName("question_id").eq(question.getQuestion_id()));
			listQuestionAttach = QuestionAttachedFileLocalServiceUtil.dynamicQuery(dynamicQuery);
			// check null before process
			if (null != listQuestionAttach && listQuestionAttach.size() > 0) {
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
	}
	
	@SuppressWarnings("unchecked")
	private List<AttachFileModel> getAttachFiles(Long [] attachFileIds, String documentId, ThemeDisplay themeDisplay) throws SystemException, PortalException {
		String urlDocument;
		List<AttachFileModel> listAttachFileModel = new ArrayList<AttachFileModel>();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileEntry.class)
			.add(PropertyFactoryUtil.forName("fileEntryId").in(attachFileIds));
		
		List<DLFileEntry> dlFileEntry =  DLFileEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
		FileEntry tempFile;
		
		if (null != dlFileEntry && dlFileEntry.size() > 0) {
			for (DLFileEntry dLFileEntry : dlFileEntry) {
				tempFile = DLAppLocalServiceUtil.getFileEntry(dLFileEntry.getFileEntryId());
				urlDocument = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
				listAttachFileModel.add(new AttachFileModel(dLFileEntry.getFileEntryId(), 
						dLFileEntry.getTitle(), dLFileEntry.getDescription(), urlDocument, documentId));
			}
		}
		
		return listAttachFileModel;
	}
}