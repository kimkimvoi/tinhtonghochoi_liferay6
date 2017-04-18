package com.fsoft.bn.portlet.questionsubmit.delegate;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletRequest;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionarySet;
import com.fsoft.bn.model.Question;
import com.fsoft.bn.model.QuestionAttachedFile;
import com.fsoft.bn.model.impl.QuestionAttachedFileImpl;
import com.fsoft.bn.service.DataDictionaryService;
import com.fsoft.bn.service.QuestionAttachedFileLocalServiceUtil;
import com.fsoft.bn.service.QuestionLocalServiceUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
/**
 * 
 * @author VangND1
 *
 */
public class QuestionSubmitDelegate {
	/** logger */
	private static Logger logger = Logger.getLogger(QuestionSubmitDelegate.class);
	/**
	 * This method using add new question
	 * @param questionDaoBean 
	 * @return {@link Question} 
	 */
	public Question addNewQuestion(Question questionDaoBean) {
		Question result = null;
		try {
			//insert new question
			result = QuestionLocalServiceUtil.addQuestion(questionDaoBean);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	/**
	 * This method using add attached file
	 * @param question 
	 * @param file 
	 * @param themeDisplay 
	 * @param request 
	 * @return {@link QuestionAttachedFile}
	 * @author VangND1 
	 */
	public QuestionAttachedFile addAttachedFile(Question question, File file , String fileIndex, ThemeDisplay themeDisplay,
			PortletRequest request) {
		QuestionAttachedFile result = null;
		QuestionAttachedFile questionAttachedFile = null;
		DLFileEntry fileEntry = null;
		try {
			boolean isEmptyFileUpload =  file.length() == 0;
			if (!isEmptyFileUpload) {
				String ext = FileUtil.getExtension(file.getName());
				String dat = new SimpleDateFormat(CommonConstants.DATE_FORMAT.YYYY_MM_DD_DASH).format(new Date());
				String title = fileIndex + CommonConstants.DASH + question.getQuestion_id() + CommonConstants.DASH
						+ dat + CommonConstants.DOT + ext;
				byte[] imageBytes = FileUtil.getBytes(file);
				InputStream is = new ByteArrayInputStream(imageBytes);
				// get service context
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
						request);
				// add file entry
				fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay
						.getScopeGroupId(), themeDisplay.getScopeGroupId(), CommonConstants.NUM_0, file.getName(),
						MimeTypesUtil.getContentType(file), title, String.valueOf(request
								.getAttribute(CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE_NAME)),
						StringPool.BLANK, CommonConstants.NUM_0, null, file, is, file.getTotalSpace(),
						serviceContext);
				questionAttachedFile = new QuestionAttachedFileImpl();
				if (!Validator.isBlankOrNull(fileEntry)) {
					questionAttachedFile.setAttached_file_id(String.valueOf(fileEntry.getFileEntryId()));
					questionAttachedFile.setQuestion_id(question.getQuestion_id());
					questionAttachedFile.setCreated_date(new Date());
					questionAttachedFile.setModified_date(new Date());
					result = QuestionAttachedFileLocalServiceUtil.addQuestionAttachedFile(questionAttachedFile);
				}
			}
		} catch (Exception e) {
			//error
			logger.info(e.getMessage());
		}
		
		return result;
	}
	/**
	 * Get question list
	 * @param name 
	 * @param request 
	 * @return {@link DataDictionarySet}
	 * @author VangND1 
	 */
	public DataDictionarySet getListQuestionType(String name, PortletRequest request) {
		return DataDictionaryService.searchListByNameDomain(name, request);
	}

}

