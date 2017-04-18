package com.fsoft.bn.domain;

public class BNQuestionStatusModel {
	private String quesStatus;
	private String quesValue;
	/**
	 * constructor
	 */
	public BNQuestionStatusModel() {

	}

	public BNQuestionStatusModel(String quesStatus, String quesValue) {
		this.quesStatus = quesStatus;
		this.quesValue = quesValue;
	}

	/**
	 * @return the quesStatus
	 */
	public String getQuesStatus() {
		return quesStatus;
	}

	/**
	 * @param quesStatus the quesStatus to set
	 */
	public void setQuesStatus(String quesStatus) {
		this.quesStatus = quesStatus;
	}

	/**
	 * @return the quesValue
	 */
	public String getQuesValue() {
		return quesValue;
	}

	/**
	 * @param quesValue the quesValue to set
	 */
	public void setQuesValue(String quesValue) {
		this.quesValue = quesValue;
	}

}