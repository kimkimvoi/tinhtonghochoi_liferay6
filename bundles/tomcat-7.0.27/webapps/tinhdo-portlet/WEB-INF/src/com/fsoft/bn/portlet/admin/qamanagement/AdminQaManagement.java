package com.fsoft.bn.portlet.admin.qamanagement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AdminQaManagementModel;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.DataDictionarySet;
import com.fsoft.bn.model.Question;
import com.fsoft.bn.model.impl.QuestionImpl;
import com.fsoft.bn.portlet.delegate.admin.qamanagement.QaManagementDelegate;
import com.fsoft.bn.service.DataDictionaryService;
import com.fsoft.bn.service.QuestionLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.GsonUtils;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AdminQaManagement
 * @author QuangTN3
 */
public class AdminQaManagement extends MVCPortlet{
	private static Log logging = LogFactoryUtil.getLog(AdminQaManagement.class);
	private QaManagementDelegate qaDelegate = new QaManagementDelegate();
	private AdminQaManagementModel adminQaManaModel;
	// this function call by init screen
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			setDefaultValue(renderRequest);
		} catch (SystemException e) {
			logging.error(e.getMessage());
		} catch (PortalException e) {
			logging.error(e.getMessage());
		}
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 * @author QuangTN3
	 * @param renderRequest RenderRequest
	 * @throws SystemException
	 * @throws PortalException
	 * set value for property in screen
	 */
	public void setDefaultValue(RenderRequest renderRequest) throws SystemException, PortalException {
		//set default value
		if (Validator.isBlankOrNull(renderRequest.getAttribute("responServer"))) {
			adminQaManaModel = new AdminQaManagementModel();
			adminQaManaModel.setDefaultCombobox(new DataDictionary(0, 
					CommonUtil.getText(renderRequest, "portlet.investmentanddevelopment.combobox.default.value")));
			adminQaManaModel.setListQuestionStatus(getQuesStatus(renderRequest));
			adminQaManaModel.setListQuestionType(getQuesType(renderRequest));
			adminQaManaModel.setHeaderList(CommonUtil.getHeaderList(renderRequest, CommonConstants.questionList));
			adminQaManaModel.setCurPageStatusText(CommonUtil.getText(renderRequest, "portlet.answeredquestions.curPageStatusText"));
			adminQaManaModel.setItemsPerPageText(CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText"));
		}
		
		qaDelegate.getQuestionData(adminQaManaModel, PortalUtil.getThemeDisplay(renderRequest));		
		renderQuestionList(adminQaManaModel.getQuestionList());
		renderRequest.setAttribute("questionListJson", GsonUtils.toJson(adminQaManaModel.getQuestionList()));
		renderRequest.setAttribute("answerList", GsonUtils.toJson(adminQaManaModel.getAnswerList()));
		renderRequest.setAttribute("answerAttachFiles", GsonUtils.toJson(adminQaManaModel.getListAnswerAttach()));
		renderRequest.setAttribute("questionAttachFiles", GsonUtils.toJson(adminQaManaModel.getListQuestionAttach()));
		renderRequest.setAttribute("adminQaManaModel", adminQaManaModel);
	}
	
	/**
	 * @author QuangTN3
	 * catch action 
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		
		String resourceID = resourceRequest.getResourceID();
		
		if ("answeredQuestionTable_LoadPage".equals(resourceID)) {
			answeredQuestionTableLoadPage(resourceRequest, resourceResponse);
		} else if ("answeredQuestionTable_Search".equals(resourceID)) {
			questionListSearch(resourceRequest, resourceResponse);
		} else if ("rejectQuestion".equals(resourceID)) {
			rejectQuestion(resourceRequest, resourceResponse);
		} else if ("revertQuestion".equals(resourceID)) {
			revertQuestion(resourceRequest, resourceResponse);
		}
		
		try {
			super.serveResource(resourceRequest, resourceResponse);
		} catch (IOException e) {
			logging.error(e.getMessage());
		} catch (PortletException e) {
			logging.error(e.getMessage());
		}
	}
	
	/**
	 * @author QuangTN3
	 * @param resourceRequest
	 * @param resourceResponse
	 * reject question
	 */
	private void rejectQuestion(ResourceRequest request,
			ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		int numPerPage = (ParamUtil.getInteger(request, "numPerPage") == 0) ? 0 : CommonConstants.QUESTIONS_PER_PAGE;
		setNumberOfPage(0, numPerPage);
		Question questionBean;
		
		try {
			// check question exists
			questionBean = QuestionLocalServiceUtil.getQuestion(ParamUtil.getString(request, "questionIdProcess"));	
			
			if (null != questionBean) {
				// update question info
				questionBean.setQuestion_status_id(CommonConstants.STRING_3);
				QuestionLocalServiceUtil.updateQuestion(questionBean);
				loadData(request, json);
				resourceResponse.getWriter().write(json.toString());
				json.put("responServer",CommonConstants.SUCCESS);
			} else {
				json.put("responServer",CommonConstants.FAIL);
			}
		} catch (Exception e) {
			json.put("responServer",CommonConstants.FAIL);
			logging.error(e.getMessage());
		}		
	}

	
	/**
	 * @author QuangTN3
	 * @param resourceRequest
	 * @param resourceResponse
	 * re-open question
	 */
	private void revertQuestion(ResourceRequest request,
			ResourceResponse resourceResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		int numPerPage = (ParamUtil.getInteger(request, "numPerPage") == 0) ? 0 : CommonConstants.QUESTIONS_PER_PAGE;
		setNumberOfPage(0, numPerPage);
		Question questionBean = new QuestionImpl();
		try {
			// check question exists
			questionBean = QuestionLocalServiceUtil.getQuestion(
					ParamUtil.getString(request, "questionIdProcess"));	
			
			if (null != questionBean) {
				// update question info
				questionBean.setQuestion_status_id(CommonConstants.STRING_1);
				QuestionLocalServiceUtil.updateQuestion(questionBean);
				loadData(request, json);
				resourceResponse.getWriter().write(json.toString());
				json.put("responServer",CommonConstants.SUCCESS);
			} else {
				json.put("responServer",CommonConstants.FAIL);
			}
		} catch (Exception e) {
			json.put("responServer",CommonConstants.FAIL);
			logging.error(e.getMessage());
		}		
	}

	
	/**
	 * @author QuangTN3
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortalException
	 * @throws SystemException
	 * update answer for question
	 */
	public void updateAnswer(ActionRequest request, ActionResponse response) throws IOException, PortalException, SystemException {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		String questionId = ParamUtil.getString(uploadRequest, "questionIdProcess");
		String answerId = ParamUtil.getString(uploadRequest, "answerIdProcess");
		String answerContent = ParamUtil.getString(uploadRequest, "answerContent");
		
		if (Validator.isBlankOrNull(answerContent)) {
			request.setAttribute("responServer", CommonConstants.WARNING);
			request.setAttribute("responServerContent", CommonUtil.getText(request, "portlet.answeredquestions.lengnull"));
			return;
		} else {
			if (answerContent.length() >= 4000) {
				request.setAttribute("responServer", CommonConstants.WARNING);
				request.setAttribute("responServerContent", CommonUtil.getText(request, "portlet.answeredquestions.leng4k"));
				return;
			}
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		File[] file = uploadRequest.getFiles(CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE);
		String[] fileName = ParamUtil.getParameterValues(uploadRequest,
				CommonConstants.QUESTION_MODEL_FIELD.QUESTION_ATTACHED_FILE_NAME);
		// set answer content
		setAnswerContent(request, questionId, answerId, answerContent,
				themeDisplay, file, fileName);
		try {
			qaDelegate.updateAnswer(adminQaManaModel);
		} catch (Exception e) {
			logging.error(e.getMessage());
			request.setAttribute("responServer", "ERROR");
			request.setAttribute("responServerContent", e.getMessage());
			return;
		}		
		request.setAttribute("responServer", CommonConstants.SUCCESS);
	}

		
	/**
	 * @author QuangTN3
	 * @param request
	 * @param response
	 * render data when load page (next page, previous  page, change number of row of table)
	 */
	public void answeredQuestionTableLoadPage(ResourceRequest request, ResourceResponse response) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		int numPerPage = (ParamUtil.getInteger(request, "numPerPage") == 0) ? 0 : CommonConstants.QUESTIONS_PER_PAGE;
		int pageNum = Integer.parseInt(ParamUtil.getString(request, "pageNum"));
		setNumberOfPage(numPerPage * (pageNum - 1), numPerPage);
		
		try {
			loadData(request, json);
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			logging.error(e.getMessage());
		} catch (Exception e) {
			logging.error(e.getMessage());
		}
	}
	
	/**
	 * @author QuangTN3
	 * @param request
	 * @param response
	 * process search 
	 */
	public void questionListSearch(ResourceRequest request, ResourceResponse response) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		adminQaManaModel.setQuestionTypeSelected(ParamUtil.getString(request, "questionType"));
		adminQaManaModel.setQuestionStatusSelected(ParamUtil.getString(request, "questionStatus"));
		adminQaManaModel.setQuestionTextSearch(ParamUtil.getString(request, "searchKeyWord"));
		adminQaManaModel.setResultUpdate(StringPool.BLANK);
		setNumberOfPage(0, ParamUtil.getInteger(request, "numPerPage"));
		
		try {
			loadData(request, json);
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			logging.error(e.getMessage());
		} catch (Exception e) {
			logging.error(e.getMessage());
		}
	}

	private void loadData(ResourceRequest request, JSONObject json)
			throws SystemException, PortalException {
		qaDelegate.getQuestionData(adminQaManaModel,PortalUtil.getThemeDisplay(request));
		renderQuestionList(adminQaManaModel.getQuestionList());
		json.put("items", GsonUtils.toJson(adminQaManaModel.getQuestionList()));
		
		if (!adminQaManaModel.getAnswerList().isEmpty()) {
			json.put("answer", GsonUtils.toJson(adminQaManaModel.getAnswerList()));
			json.put("answerAttachs", GsonUtils.toJson(adminQaManaModel.getListAnswerAttach()));
		} else {
			json.put("answer", GsonUtils.toJson(StringPool.BLANK));
			json.put("answerAttachs", GsonUtils.toJson(StringPool.BLANK));
		}
		
		if (!adminQaManaModel.getListQuestionAttach().isEmpty()) {
			json.put("questionAttachFiles", GsonUtils.toJson(adminQaManaModel.getListQuestionAttach()));
		} else {
			json.put("questionAttachFiles", GsonUtils.toJson(StringPool.BLANK));
		}
		
		json.put("recordPerPage", adminQaManaModel.getQuestionPerPage());
		json.put("numOfPage", adminQaManaModel.getNumOfPage());
	}
	
	
	private List<DataDictionary> getQuesStatus(RenderRequest renderRequest)  {
		DataDictionarySet dataDictionary = DataDictionaryService.searchListByNameDomain(
				DataDictionaryService.QUESTION_STATUS, renderRequest);
		return dataDictionary.getRecords();
	}
	
	private List<DataDictionary> getQuesType(RenderRequest renderRequest)  {
		DataDictionarySet dataDictionary = DataDictionaryService.searchListByNameDomain(
				DataDictionaryService.QUESTION_TYPE, renderRequest);
		return dataDictionary.getRecords();
	}
	
	private void setAnswerContent(ActionRequest request, String questionId,
			String answerId, String answerContent, ThemeDisplay themeDisplay,
			File[] file, String[] fileName) {
		adminQaManaModel.setQuesId(questionId);
		adminQaManaModel.setAnswerId(answerId);
		adminQaManaModel.setAnswerContent(answerContent);
		adminQaManaModel.setFile(file);
		adminQaManaModel.setRequest(request);
		adminQaManaModel.setThemeDisplay(themeDisplay);
		adminQaManaModel.setFileName(fileName);
	}
	
	private void setNumberOfPage(int statNumberOfPage, int numPerPage) {
		adminQaManaModel.setQuestionPerPage(numPerPage);
		adminQaManaModel.setStartNumberOfPage(statNumberOfPage);
		adminQaManaModel.setEndNumberOfPage(statNumberOfPage + numPerPage);
	}
	
	private void renderQuestionList(List<Question> questionList) {
		for (Question ques : questionList) {
			ques.setStatusDisplay(getDisplayQuesionStatus(ques.getQuestion_status_id()));			
			ques.setDateDisplay(CommonUtil.Date2String(ques.getCreated_date(), CommonConstants.DATE_FORMAT.YYYY_MM_DD));
		}
	}
	
	private String getDisplayQuesionStatus(String key) {
		for (DataDictionary dataDictionary : adminQaManaModel.getListQuestionStatus()) {
			if (key.equals(StringPool.BLANK + dataDictionary.getKey())) {
				return dataDictionary.getValue();
			}
		}
		return StringPool.BLANK;
	}	
}
