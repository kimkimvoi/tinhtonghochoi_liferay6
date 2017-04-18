package com.fsoft.bn.domain;

public class BNQuestionTypeModel {
	public String questionTypeStatus;
	public String questionTypeValue;
	public BNQuestionTypeModel() {

	}

	public BNQuestionTypeModel(String questionTypeStatus, String questionTypeValue) {
		this.questionTypeStatus = questionTypeStatus;
		this.questionTypeValue = questionTypeValue;
	}

	/**
	 * @return the questionTypeStatus
	 */
	public String getQuestionTypeStatus() {
		return questionTypeStatus;
	}

	/**
	 * @param questionTypeStatus the questionTypeStatus to set
	 */
	public void setQuestionTypeStatus(String questionTypeStatus) {
		this.questionTypeStatus = questionTypeStatus;
	}

	/**
	 * @return the questionTypeValue
	 */
	public String getQuestionTypeValue() {
		return questionTypeValue;
	}

	/**
	 * @param questionTypeValue the questionTypeValue to set
	 */
	public void setQuestionTypeValue(String questionTypeValue) {
		this.questionTypeValue = questionTypeValue;
	}
}