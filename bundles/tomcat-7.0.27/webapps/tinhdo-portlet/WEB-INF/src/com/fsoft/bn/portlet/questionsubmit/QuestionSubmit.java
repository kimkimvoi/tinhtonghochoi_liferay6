package com.fsoft.bn.portlet.questionsubmit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionarySet;
import com.fsoft.bn.domain.QuestionModel;
import com.fsoft.bn.model.Question;
import com.fsoft.bn.model.impl.QuestionImpl;
import com.fsoft.bn.portlet.questionsubmit.delegate.QuestionSubmitDelegate;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class QuestionSubmit
 */
public class QuestionSubmit extends MVCPortlet {
	/** logger */
	private static Logger log = Logger.getLogger(QuestionSubmit.class);
	private QuestionModel questionModel;
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(
					resourceRequest, resourceResponse);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
	
	/**
	 * this method call when render view
	 * @param request 
	 * @param response 
	 * @throws IOException  ,PortletException
	 * @author VangND1
	 */
	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		QuestionSubmitDelegate questionSubmitDelegate = new QuestionSubmitDelegate();
		
		DataDictionarySet dataDictionarySet = questionSubmitDelegate.getListQuestionType(
				CommonConstants.PORTLET.QUESTION_SUBMIT.QUESTION_TYPE, request);
		request.setAttribute(CommonConstants.PORTLET.QUESTION_SUBMIT.DATA_DICTIONARY_SET, dataDictionarySet);
		if (Validator.isBlankOrNull(request.getAttribute("responServer"))) {
			questionModel = new QuestionModel();
		}
		request.setAttribute("questionModel", questionModel);
		super.doView(request, response);
	}
	
	/**
	 * This method using add new question
	 * @param request 
	 * @param response 
	 * @throws IOException 
	 * @throws PortletException 
	 * @author VangND1
	 */
	public void addNewQuestion(ActionRequest request, ActionResponse response) 
			throws IOException, PortletException {
		try {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
			if (!CommonUtil.isValidCaptcha(uploadRequest , request)) {
//				JSONObject json = JSONFactoryUtil.createJSONObject();
				request.setAttribute(CommonConstants.REQUEST.RESULT, CommonConstants.REQUEST.STATUS.INVALID_CAPTCHA);
				setQuestionSubmitData(questionModel, uploadRequest);
				request.setAttribute("questionModel", questionModel);
				request.setAttribute("responServer", CommonConstants.FAIL);
//				json.put("responServer",CommonConstants.FAIL);
				return;
			}
			QuestionSubmitDelegate questionSubmitDelegate = new QuestionSubmitDelegate();
			//prepare bean to insert
			Question model = prepareQuestionModel(uploadRequest);
			//call logic class to insert question
			Question result = questionSubmitDelegate.addNewQuestion(model);
			if (!Validator.isBlankOrNull(result)) {
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				File[] file = removeNullFile(uploadRequest
						.getFiles(CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE));
				String[] fileName = removeNullString(ParamUtil.getParameterValues(uploadRequest,
						CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE_NAME));
				if (file != null && file.length > 0 && file[0] != null) {
					int i = 0;
					for (File item : file) {
						if (item != null) {
							boolean isEmptyFileUpload = (item.length() == 0);
							if (!isEmptyFileUpload) {
								request.setAttribute(CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE_NAME,
										fileName[i]);
								if (questionSubmitDelegate.addAttachedFile(result, item , String.valueOf(i++)
										, themeDisplay, request) != null) {
									request.setAttribute(CommonConstants.REQUEST.RESULT,
											CommonConstants.REQUEST.STATUS.SUCCESS);
								} else {
									request.setAttribute(CommonConstants.REQUEST.RESULT,
											CommonConstants.REQUEST.STATUS.ERROR);
								}
							} else {
								request.setAttribute(CommonConstants.REQUEST.RESULT, 
										CommonConstants.REQUEST.STATUS.SUCCESS);
							}
						}
					}
				} else {
					request.setAttribute(CommonConstants.REQUEST.RESULT,
							CommonConstants.REQUEST.STATUS.SUCCESS);
				}
			} else {
				request.setAttribute(CommonConstants.REQUEST.RESULT, CommonConstants.REQUEST.STATUS.ERROR);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			request.setAttribute(CommonConstants.REQUEST.RESULT, CommonConstants.REQUEST.STATUS.ERROR);
		}
	}
	
	/**
	 * method using create new question model when user submit form 
	 * @param uploadRequest 
	 * @return {@link Question}
	 * @author VangND1
	 */
	private Question prepareQuestionModel(UploadPortletRequest uploadRequest) {
		Question model = new QuestionImpl();
		model.setCitizen_name(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.CITIZEN_NAME));
		model.setQuestion_status_id(CommonConstants.STRING_1);
		model.setCitizen_address(ParamUtil.getString(uploadRequest,
				CommonConstants.QUESTION_MODEL_FIELD.CITIZEN_ADDRESS));
		model.setCitizen_phone(ParamUtil.getString(uploadRequest,
				CommonConstants.QUESTION_MODEL_FIELD.CITIZEN_PHONE_NUMBER));
		model.setQuestion_type_id(ParamUtil.getString(uploadRequest,
				CommonConstants.QUESTION_MODEL_FIELD.QUESTION_TYPES));
		model.setCitizen_mail(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.CITIZEN_EMAIL));
		model.setQuestion_title(ParamUtil.getString(uploadRequest, 
				CommonConstants.QUESTION_MODEL_FIELD.QUESTION_TITLE));
		model.setQuestion_content(ParamUtil.getString(uploadRequest,
				CommonConstants.QUESTION_MODEL_FIELD.QUESTION_CONTENT));
		model.setCreated_date(new Date());
		model.setModified_date(new Date());
		return model;
	}
	
	/**
	 * 
	 * @param array 
	 * @return {@link File[]}
	 */
	private File[] removeNullFile(File[] array) {
		List<File> result = new ArrayList<File>();
		
		for (int i = 0; i < array.length; i++) {
			if (!Validator.isBlankOrNull(array[i])) {
				result.add(array[i]);
			}
		}
		return (File[]) result.toArray(new File[result.size()]);
	}
	
	/**
	 * @param array 
	 * @return {@link String[]}
	 */
	private String[] removeNullString(String[] array) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			if (!Validator.isBlankOrNull(array[i])) {
				result.add(array[i]);
			}
		}
		return (String[]) result.toArray(new String[result.size()]);
	}
	
	private void setQuestionSubmitData(QuestionModel questionModel, UploadPortletRequest uploadRequest) {
		questionModel.setCitizenName(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.CITIZEN_NAME));
		questionModel.setCitizenAddress(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.CITIZEN_ADDRESS));
		questionModel.setCitizenPhone(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.CITIZEN_PHONE_NUMBER));
		questionModel.setCitizenQuestionType(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.QUESTION_TYPES));
		questionModel.setCitizenEmail(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.CITIZEN_EMAIL));
		questionModel.setCitizenQuestionTitle(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.QUESTION_TITLE));
		questionModel.setCitizenQuestionContent(ParamUtil.getString(uploadRequest, CommonConstants.QUESTION_MODEL_FIELD.QUESTION_CONTENT));
	}
	
}
