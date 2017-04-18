package com.fsoft.bn.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.customJSPTags.TableTag;
import com.fsoft.bn.model.Answer;
import com.fsoft.bn.model.Question;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;

public class AdminQaManagementModel {
	public String questionTypeSelected;
	public String questionStatusSelected;
	public String questionTextSearch;
	public List<Question> questionList;
	public UploadedFile uploadedFile;
	public List<DataDictionary> listQuestionType;
	public List<DataDictionary> listQuestionStatus;
	public DataDictionary defaultCombobox;
	public String resultUpdate;
	public DataDictionary resultProcess;
	public HashMap<String, String> result;
	public int questionPerPage;
	public long numOfPage;
	public List<String> displayedPropertyList;
	public List<String> hiddenPropertyList;
	public List<Answer> answerList;
	public String curPageStatusText;
	public String itemsPerPageText;
	public List<String> headerList;
	List<AttachFileModel> listAnswerAttach;
	List<AttachFileModel> listQuestionAttach;
	// upload Content
	public String quesId;
	public String answerId;
	public String answerContent; 
	public ActionRequest request; 
	public ThemeDisplay themeDisplay;
	public File []file;
	public String [] fileName;
	public int startNumberOfPage;
	public int endNumberOfPage;
	
	
	public AdminQaManagementModel() {
		this.questionTypeSelected 	= CommonConstants.STRING_0;
		this.questionStatusSelected = CommonConstants.STRING_0;
		this.questionTextSearch 	= StringPool.BLANK;
		this.resultUpdate 			= StringPool.BLANK;
		this.questionPerPage 		= CommonConstants.QUESTIONS_PER_PAGE;
		this.displayedPropertyList 	= getDefaultDisplayedPropertyList();
		this.hiddenPropertyList 	= getDefaultHiddenPropertiesList();
		this.startNumberOfPage  	= 0;
		this.endNumberOfPage 		= CommonConstants.QUESTIONS_PER_PAGE;
	}
	
	/**
	 * @author QuangTN3
	 * @return display property in question list
	 */
	private static List<String> getDefaultDisplayedPropertyList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add(TableTag.STT);
		displayedPropertyList.add("_question_title");
		displayedPropertyList.add("_citizen_name");
		displayedPropertyList.add("dateDisplay");
		displayedPropertyList.add("statusDisplay");
		return displayedPropertyList;
	}
	/**
	 * @author QuangTN3
	 * @return hidden property in question list
	 */
	private static List<String> getDefaultHiddenPropertiesList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add("_question_id");
		displayedPropertyList.add("_question_content");
		displayedPropertyList.add("_citizen_address");
		displayedPropertyList.add("_answer_id");
		displayedPropertyList.add("_question_status_id");
		return displayedPropertyList;
	}
	
	/**
	 * @return the file
	 */
	public File[] getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(File[] file) {
		this.file = file;
	}
	/**
	 * @return the fileName
	 */
	public String[] getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String[] fileName) {
		this.fileName = fileName;
	}
	public String getQuesId() {
		return quesId;
	}
	/**
	 * @param quesId the quesId to set
	 */
	public void setQuesId(String quesId) {
		this.quesId = quesId;
	}
	/**
	 * @return the answerId
	 */
	public String getAnswerId() {
		return answerId;
	}
	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	/**
	 * @return the answerContent
	 */
	public String getAnswerContent() {
		return answerContent;
	}
	/**
	 * @param answerContent the answerContent to set
	 */
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	
	/**
	 * @return the request
	 */
	public ActionRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(ActionRequest request) {
		this.request = request;
	}
	/**
	 * @return the themeDisplay
	 */
	public ThemeDisplay getThemeDisplay() {
		return themeDisplay;
	}
	/**
	 * @param themeDisplay the themeDisplay to set
	 */
	public void setThemeDisplay(ThemeDisplay themeDisplay) {
		this.themeDisplay = themeDisplay;
	}
	/**
	 * @return the listAnswerAttach
	 */
	public List<AttachFileModel> getListAnswerAttach() {
		return listAnswerAttach;
	}
	/**
	 * @param listAnswerAttach the listAnswerAttach to set
	 */
	public void setListAnswerAttach(List<AttachFileModel> listAnswerAttach) {
		this.listAnswerAttach = listAnswerAttach;
	}
	/**
	 * @return the listQuestionAttach
	 */
	public List<AttachFileModel> getListQuestionAttach() {
		return listQuestionAttach;
	}
	/**
	 * @param listQuestionAttach the listQuestionAttach to set
	 */
	public void setListQuestionAttach(List<AttachFileModel> listQuestionAttach) {
		this.listQuestionAttach = listQuestionAttach;
	}
	/**
	 * @return the headerList
	 */
	public List<String> getHeaderList() {
		return headerList;
	}
	/**
	 * @param headerList the headerList to set
	 */
	public void setHeaderList(List<String> headerList) {
		this.headerList = headerList;
	}
	/**
	 * @return the displayedPropertyList
	 */
	public List<String> getDisplayedPropertyList() {
		return displayedPropertyList;
	}
	/**
	 * @param displayedPropertyList the displayedPropertyList to set
	 */
	public void setDisplayedPropertyList(List<String> displayedPropertyList) {
		this.displayedPropertyList = displayedPropertyList;
	}
	/**
	 * @return the hiddenPropertyList
	 */
	public List<String> getHiddenPropertyList() {
		return hiddenPropertyList;
	}
	/**
	 * @param hiddenPropertyList the hiddenPropertyList to set
	 */
	public void setHiddenPropertyList(List<String> hiddenPropertyList) {
		this.hiddenPropertyList = hiddenPropertyList;
	}
	/**
	 * @return the answerList
	 */
	public List<Answer> getAnswerList() {
		return answerList;
	}
	/**
	 * @param answerList the answerList to set
	 */
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	/**
	 * @return the curPageStatusText
	 */
	public String getCurPageStatusText() {
		return curPageStatusText;
	}
	/**
	 * @param curPageStatusText the curPageStatusText to set
	 */
	public void setCurPageStatusText(String curPageStatusText) {
		this.curPageStatusText = curPageStatusText;
	}
	/**
	 * @return the itemsPerPageText
	 */
	public String getItemsPerPageText() {
		return itemsPerPageText;
	}
	/**
	 * @param itemsPerPageText the itemsPerPageText to set
	 */
	public void setItemsPerPageText(String itemsPerPageText) {
		this.itemsPerPageText = itemsPerPageText;
	}
	/**
	 * @return the numOfPage
	 */
	public long getNumOfPage() {
		return numOfPage;
	}
	/**
	 * @param numOfPage the numOfPage to set
	 */
	public void setNumOfPage(long numOfPage) {
		this.numOfPage = numOfPage;
	}
	/**
	 * @return the questionPerPage
	 */
	public int getQuestionPerPage() {
		return questionPerPage;
	}
	/**
	 * @param questionPerPage the questionPerPage to set
	 */
	public void setQuestionPerPage(int questionPerPage) {
		this.questionPerPage = questionPerPage;
	}
	/**
	 * @return the result
	 */
	public HashMap<String, String> getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(HashMap<String, String> result) {
		this.result = result;
	}
	/**
	 * @return the resultProcess
	 */
	public DataDictionary getResultProcess() {
		return resultProcess;
	}
	/**
	 * @param resultProcess the resultProcess to set
	 */
	public void setResultProcess(DataDictionary resultProcess) {
		this.resultProcess = resultProcess;
	}
	/**
	 * @return the resultUpdate
	 */
	public String getResultUpdate() {
		return resultUpdate;
	}
	/**
	 * @param resultUpdate the resultUpdate to set
	 */
	public void setResultUpdate(String resultUpdate) {
		this.resultUpdate = resultUpdate;
	}
	/**
	 * @return the defaultCombobox
	 */
	public DataDictionary getDefaultCombobox() {
		return defaultCombobox;
	}
	/**
	 * @param defaultCombobox the defaultCombobox to set
	 */
	public void setDefaultCombobox(DataDictionary defaultCombobox) {
		this.defaultCombobox = defaultCombobox;
	}
	/**
	 * @return the listQuestionType
	 */
	public List<DataDictionary> getListQuestionType() {
		return listQuestionType;
	}
	/**
	 * @param listQuestionType the listQuestionType to set
	 */
	public void setListQuestionType(List<DataDictionary> listQuestionType) {
		this.listQuestionType = listQuestionType;
	}
	/**
	 * @return the listQuestionStatus
	 */
	public List<DataDictionary> getListQuestionStatus() {
		return listQuestionStatus;
	}
	/**
	 * @param listQuestionStatus the listQuestionStatus to set
	 */
	public void setListQuestionStatus(List<DataDictionary> listQuestionStatus) {
		this.listQuestionStatus = listQuestionStatus;
	}
	/**
	 * @return the questionTypeSelected
	 */
	public String getQuestionTypeSelected() {
		return questionTypeSelected;
	}
	/**
	 * @param questionTypeSelected the questionTypeSelected to set
	 */
	public void setQuestionTypeSelected(String questionTypeSelected) {
		this.questionTypeSelected = questionTypeSelected;
	}
	/**
	 * @return the questionStatusSelected
	 */
	public String getQuestionStatusSelected() {
		return questionStatusSelected;
	}
	/**
	 * @param questionStatusSelected the questionStatusSelected to set
	 */
	public void setQuestionStatusSelected(String questionStatusSelected) {
		this.questionStatusSelected = questionStatusSelected;
	}
	/**
	 * @return the questionTextSearch
	 */
	public String getQuestionTextSearch() {
		return questionTextSearch;
	}
	/**
	 * @param questionTextSearch the questionTextSearch to set
	 */
	public void setQuestionTextSearch(String questionTextSearch) {
		this.questionTextSearch = questionTextSearch;
	}
	/**
	 * @return the questionList
	 */
	public List<Question> getQuestionList() {
		return questionList;
	}
	/**
	 * @param questionList the questionList to set
	 */
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	/**
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	/**
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	/**
	 * @return the startNumberOfPage
	 */
	public int getStartNumberOfPage() {
		return startNumberOfPage;
	}
	/**
	 * @param startNumberOfPage the startNumberOfPage to set
	 */
	public void setStartNumberOfPage(int startNumberOfPage) {
		this.startNumberOfPage = startNumberOfPage;
	}
	/**
	 * @return the endNumberOfPage
	 */
	public int getEndNumberOfPage() {
		return endNumberOfPage;
	}
	/**
	 * @param endNumberOfPage the endNumberOfPage to set
	 */
	public void setEndNumberOfPage(int endNumberOfPage) {
		this.endNumberOfPage = endNumberOfPage;
	}
	
}
