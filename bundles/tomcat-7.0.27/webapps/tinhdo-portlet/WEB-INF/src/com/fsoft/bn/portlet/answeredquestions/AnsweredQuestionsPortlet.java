package com.fsoft.bn.portlet.answeredquestions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.customJSPTags.TableTag;
import com.fsoft.bn.domain.AttachFileModel;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.DataDictionarySet;
import com.fsoft.bn.model.Answer;
import com.fsoft.bn.model.AnswerAttachedFile;
import com.fsoft.bn.model.Question;
import com.fsoft.bn.model.QuestionAttachedFile;
import com.fsoft.bn.service.AnswerAttachedFileLocalServiceUtil;
import com.fsoft.bn.service.AnswerLocalServiceUtil;
import com.fsoft.bn.service.DataDictionaryService;
import com.fsoft.bn.service.QuestionAttachedFileLocalServiceUtil;
import com.fsoft.bn.service.QuestionLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Portlet implementation class AnsweredQuestionsPortlet
 *
 * @author son
 */
@Controller
@RequestMapping(value="VIEW")
public class AnsweredQuestionsPortlet {
	/** logger */
	private static Logger logger = Logger.getLogger(AnsweredQuestionsPortlet.class);
	Gson gson = new Gson();
	Map<String, String> searchConditions = new HashMap<String, String>();

	@RenderMapping
	public ModelAndView handleRenderRequest(RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		searchConditions = new HashMap<String, String>();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<DataDictionary> questionTypeList = getQuestionTypes(renderRequest);
		renderRequest.setAttribute("questionTypeList", questionTypeList);

		long numOfPage = getAnsweredQuestionsCount(null, null, CommonConstants.QUESTIONS_PER_PAGE);
		renderRequest.setAttribute("numOfPage", numOfPage);
		renderRequest.setAttribute("numPerPage", CommonConstants.QUESTIONS_PER_PAGE);

		List<String> headerList = CommonUtil.getHeaderList(renderRequest, CommonConstants.questionListHeaderKeys);
		renderRequest.setAttribute("headerList", headerList);

		List<String> displayedPropertyList = getDisplayedPropertyList();
		renderRequest.setAttribute("displayedPropertyList", displayedPropertyList);
		
		List<String> hiddenPropertyList = getHiddenPropertyList();
		renderRequest.setAttribute("hiddenPropertyList", hiddenPropertyList);

		List<Question> questionList = findAnsweredQuestions(null, null, 0, CommonConstants.QUESTIONS_PER_PAGE);
		renderQuestionList(questionList);
		renderRequest.setAttribute("questionList", questionList);
		renderRequest.setAttribute("questionListJson", gson.toJson(questionList));
		
		List<Answer> answerList = getAnswerList(questionList, 0, CommonConstants.QUESTIONS_PER_PAGE);
		renderAnswerList(answerList);
		renderRequest.setAttribute("answerList", gson.toJson(answerList));

		String curPageStatusText = CommonUtil.getText(renderRequest, "portlet.common.paging.curPageStatusText");
		renderRequest.setAttribute("curPageStatusText", curPageStatusText);
		
		String itemsPerPageText = CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText");
		renderRequest.setAttribute("itemsPerPageText", itemsPerPageText);
		
		List<Integer> indicatorList = getIndicatorList();
		renderRequest.setAttribute("indicatorList", indicatorList);
		
		List<AttachFileModel> questionAttachedFileList = getlistQuestionAttachedFiles(questionList, themeDisplay);
		renderRequest.setAttribute("questionAttachFiles", gson.toJson(questionAttachedFileList));
		
		List<AttachFileModel> answerAttachedFileList = getlistAttachedFileAnswer(answerList, themeDisplay);
		renderRequest.setAttribute("answerAttachFiles", gson.toJson(answerAttachedFileList));

		return new ModelAndView("answeredquestions/answered-questions-view");
	}

	@ResourceMapping("answeredQuestionTable_LoadPage")
	public void answeredQuestionTableLoadPage(ResourceRequest request, ResourceResponse response) {
		String searchKeyWord = searchConditions.get("searchKeyWord");
		String questionType = searchConditions.get("questionType");
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		
		if (numPerPage == 0) {
			numPerPage = CommonConstants.QUESTIONS_PER_PAGE;
		}
		
		String pageNumStr = ParamUtil.getString(request, "pageNum");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;
		pushDataToJson(response, searchKeyWord, questionType, numPerPage, start, end);
	}

	@ResourceMapping("answeredQuestionTable_Search")
	public void answeredQuestionTableSearch(ResourceRequest request, ResourceResponse response) {
		String searchKeyWord = ParamUtil.getString(request, "searchKeyWord");
		String questionType = ParamUtil.getString(request, "questionType");
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		searchConditions.put("searchKeyWord", searchKeyWord);
		searchConditions.put("questionType", questionType);
		int start = 0;
		int end = start + numPerPage;
		pushDataToJson(response, searchKeyWord, questionType, numPerPage, start, end);
	}
	
	/*----------------------------------------------------------------------PRIVATE FUNCTIONS SECTION---------------------------------------------------------------------------*/
	
	private void pushDataToJson(ResourceResponse response, String searchKeyWord, String questionType, int numPerPage,
			int start, int end) {
		try {
			long numOfPage = getAnsweredQuestionsCount(questionType, searchKeyWord, numPerPage);
			List<Question> questionList = findAnsweredQuestions(questionType, searchKeyWord, start, end);
			renderQuestionList(questionList);
			List<Answer> answerList = getAnswerList(questionList, 0, numPerPage);
			renderAnswerList(answerList);
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("items", gson.toJson(questionList));
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			json.put("answerList", gson.toJson(answerList));
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			logger.info(e.getMessage());
		} catch (NumberFormatException e) {
			logger.info(e.getMessage());
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
	}
	
	private void renderQuestionList(List<Question> questionList) {
		String formatDate = "";
		for (Question question : questionList) {
			formatDate = CommonUtil.Date2String(question.getCreated_date(), CommonConstants.DATE_FORMAT.YYYY_MM_DD);
			question.setDateDisplay(formatDate);
		}
	}
	
	private void renderAnswerList(List<Answer> answerList) {
		String formatDate = "";
		for (Answer answer : answerList) {
			formatDate = CommonUtil.Date2String(answer.getCreated_date(), CommonConstants.DATE_FORMAT.YYYY_MM_DD);
			answer.setFormatedCreatedDate(formatDate);
		}
	}

	@SuppressWarnings("unchecked")
	private List<Question> findAnsweredQuestions(String questionType, String searchKeyWord, int start, int end) {
		DynamicQuery dynamicQuery = buildDynamicQuery(questionType,searchKeyWord);
		
		try {
			return QuestionLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
		} catch (SystemException e) {
			logger.info(e.getMessage());
			return new ArrayList<Question>();
		}
	}

	private long getAnsweredQuestionsCount(String questionType, String searchKeyWord, int numPerPage) {
		DynamicQuery dynamicQuery = buildDynamicQuery(questionType,searchKeyWord);
		
		try {
			long count = QuestionLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			if (count % numPerPage > 0) {
				return count / numPerPage + 1;
			} else {
				return count / numPerPage ;
			}
		} catch (SystemException e) {
			logger.info(e.getMessage());
			return 0;
		}
	}

	private DynamicQuery buildDynamicQuery(String questionType,String searchKeyWord) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Question.class);
		if (!Validator.isBlankOrNull(questionType) && !"-1".equals(questionType)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("question_type_id").eq(questionType));
		}
		
		dynamicQuery.add(PropertyFactoryUtil.forName("answer_id").ne("''"));
		
		if (!Validator.isBlankOrNull(searchKeyWord)) {
			Junction junction = RestrictionsFactoryUtil.disjunction();
			junction.add(RestrictionsFactoryUtil.ilike("question_title", "%" + searchKeyWord + "%"))
			.add(RestrictionsFactoryUtil.ilike("question_content", "%" + searchKeyWord + "%"));
			dynamicQuery.add(junction);
		}
		
		return dynamicQuery;
	}
	
	@SuppressWarnings("unchecked")
	private List<Answer> getAnswerList(List<Question> questionList, int start, int end) throws NumberFormatException, PortalException {
		if (Validator.isBlankOrNull(questionList)) {
			return new ArrayList<Answer>();
		}
		String [] answerIds = new String[questionList.size()];
		int i = 0;
		for (Question question : questionList) {
			answerIds[i] = question.getAnswer_id();
			i++;
		}
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Answer.class)
				.add(PropertyFactoryUtil.forName("answer_id").in(answerIds));
			
		try {
			List<Answer> answerList = AnswerLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
			String organiztion = "";
			for (Answer answer : answerList) {
				organiztion = getOrganization(answer.getUser_id());
				answer.setOrganizationName(organiztion);
			}
			return answerList;
		} catch (SystemException e) {
			logger.info(e.getMessage());
			return new ArrayList<Answer>();
		}
	}

	private String getOrganization(String userId) throws NumberFormatException, PortalException, SystemException {
		String result = "";
		if (Validator.isBlankOrNull(userId)) {
			return result;
		}
		
		List<Organization> mylist= OrganizationLocalServiceUtil.getUserOrganizations(Long.parseLong(userId));
		if (!Validator.isBlankOrNull(mylist)) {
			result = mylist.get(0).getName();
		}
		return result;
	}

	private List<String> getDisplayedPropertyList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add(TableTag.STT);
		displayedPropertyList.add("_question_title");
		return displayedPropertyList;
	}
	
	private List<String> getHiddenPropertyList() {
		List<String> hiddenPropertyList = new ArrayList<String>();
		hiddenPropertyList.add("_question_id");
		hiddenPropertyList.add("_answer_id");
		return hiddenPropertyList;
	}

	private List<DataDictionary> getQuestionTypes(RenderRequest renderRequest) {
		DataDictionarySet dataDictionary = DataDictionaryService.searchListByNameDomain(
				DataDictionaryService.QUESTION_TYPE, renderRequest);
		return dataDictionary.getRecords();
	}
	
	private List<Integer> getIndicatorList() {
		List<Integer> indicatorList = new ArrayList<Integer>();
		indicatorList.add(1);
		return indicatorList;
	}
	
	@SuppressWarnings("unchecked")
	private List<AttachFileModel> getlistQuestionAttachedFiles(List<Question> questionList, ThemeDisplay themeDisplay) throws SystemException, PortalException{
		if (Validator.isBlankOrNull(questionList)) {
			return new ArrayList<AttachFileModel>();
		}
		int i = 0;
		DynamicQuery dynamicQuery;
		Long [] attachFileIds;
		List<AttachFileModel> listAttachFileModel = new ArrayList<AttachFileModel>(); 
		List<QuestionAttachedFile> listQuestionAttach = new ArrayList<QuestionAttachedFile>();
		String questionId;
		for (Question question : questionList) {
			questionId = question.getQuestion_id();
			dynamicQuery = DynamicQueryFactoryUtil.forClass(QuestionAttachedFile.class)
					.add(PropertyFactoryUtil.forName("question_id").eq(question.getQuestion_id()));
			listQuestionAttach = QuestionAttachedFileLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (!Validator.isBlankOrNull(listQuestionAttach)) {
				i = 0;
				attachFileIds =  new Long[listQuestionAttach.size()];
				for (QuestionAttachedFile questionAttachedFile : listQuestionAttach) {
					attachFileIds[i] = Long.parseLong(questionAttachedFile.getAttached_file_id());
					i++;
				}
				listAttachFileModel.addAll(CommonUtil.getAttachFiles(attachFileIds, questionId, themeDisplay));
			}
		}
		return listAttachFileModel;
	}
	
	@SuppressWarnings("unchecked")
	private List<AttachFileModel> getlistAttachedFileAnswer(List<Answer> answerList, ThemeDisplay themeDisplay) throws SystemException, PortalException{
		if (Validator.isBlankOrNull(answerList)) {
			return new ArrayList<AttachFileModel>();
		}
		int i = 0;
		DynamicQuery dynamicQuery;
		String answerId;
		Long [] attachFileIds;
		List<AttachFileModel> listAttachFileModel = new ArrayList<AttachFileModel>(); 
		List<AnswerAttachedFile> listAnswerAttach = new ArrayList<AnswerAttachedFile>();
		for (Answer answer : answerList) {
			answerId = answer.getAnswer_id();
			dynamicQuery = DynamicQueryFactoryUtil.forClass(AnswerAttachedFile.class)
					.add(PropertyFactoryUtil.forName("answer_id").eq(answerId));
			listAnswerAttach = AnswerAttachedFileLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (!Validator.isBlankOrNull(listAnswerAttach)) {
				i = 0;
				attachFileIds =  new Long[listAnswerAttach.size()];
				for (AnswerAttachedFile answerAttachedFile : listAnswerAttach) {
					attachFileIds[i] = Long.parseLong(answerAttachedFile.getAttached_file_id());
					i++;
				}
				listAttachFileModel.addAll(CommonUtil.getAttachFiles(attachFileIds, answerId, themeDisplay));				
			}
			
		}
		return listAttachFileModel;
	}
}