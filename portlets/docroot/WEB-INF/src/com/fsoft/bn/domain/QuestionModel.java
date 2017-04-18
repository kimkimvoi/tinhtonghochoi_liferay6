package com.fsoft.bn.domain;

import com.liferay.portal.kernel.util.StringPool;

public class QuestionModel {
	public String citizenName;
	public String citizenAddress;
	public String citizenPhone;
	public String citizenEmail;
	public String citizenQuestionType;
	public String citizenQuestionTitle;
	public String citizenQuestionAttachFile;
	public String citizenQuestionContent;
	public String citizenQuestionCaptchaGen;
	public String citizenQuestionCaptchaInput;
	
	public QuestionModel() {
		this.citizenName 				= StringPool.BLANK;
		this.citizenAddress 			= StringPool.BLANK;
		this.citizenPhone 				= StringPool.BLANK;
		this.citizenEmail 				= StringPool.BLANK;
		this.citizenQuestionType 		= StringPool.BLANK;
		this.citizenQuestionTitle 		= StringPool.BLANK;
		this.citizenQuestionAttachFile 	= StringPool.BLANK;
		this.citizenQuestionContent 	= StringPool.BLANK;
		this.citizenQuestionCaptchaGen 	= StringPool.BLANK;
		this.citizenQuestionCaptchaInput = StringPool.BLANK;
	}
	
	public QuestionModel(String citizenName, String citizenAddress, String citizenPhone, String citizenEmail,
			String citizenQuestionType,String citizenQuestionTitle,String citizenQuestionContent) {
		this.citizenName 				= citizenName;
		this.citizenAddress 			= citizenAddress;
		this.citizenPhone 				= citizenPhone;
		this.citizenEmail 				= citizenEmail;
		this.citizenQuestionType 		= citizenQuestionType;
		this.citizenQuestionTitle 		= citizenQuestionTitle;
		this.citizenQuestionContent 	= citizenQuestionContent;
	}
	
	/**
	 * @return the citizenName
	 */
	public String getCitizenName() {
		return citizenName;
	}
	/**
	 * @param citizenName the citizenName to set
	 */
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	/**
	 * @return the citizenAddress
	 */
	public String getCitizenAddress() {
		return citizenAddress;
	}
	/**
	 * @param citizenAddress the citizenAddress to set
	 */
	public void setCitizenAddress(String citizenAddress) {
		this.citizenAddress = citizenAddress;
	}
	/**
	 * @return the citizenPhone
	 */
	public String getCitizenPhone() {
		return citizenPhone;
	}
	/**
	 * @param citizenPhone the citizenPhone to set
	 */
	public void setCitizenPhone(String citizenPhone) {
		this.citizenPhone = citizenPhone;
	}
	/**
	 * @return the citizenEmail
	 */
	public String getCitizenEmail() {
		return citizenEmail;
	}
	/**
	 * @param citizenEmail the citizenEmail to set
	 */
	public void setCitizenEmail(String citizenEmail) {
		this.citizenEmail = citizenEmail;
	}
	/**
	 * @return the citizenQuestionType
	 */
	public String getCitizenQuestionType() {
		return citizenQuestionType;
	}
	/**
	 * @param citizenQuestionType the citizenQuestionType to set
	 */
	public void setCitizenQuestionType(String citizenQuestionType) {
		this.citizenQuestionType = citizenQuestionType;
	}
	/**
	 * @return the citizenQuestionTitle
	 */
	public String getCitizenQuestionTitle() {
		return citizenQuestionTitle;
	}
	/**
	 * @param citizenQuestionTitle the citizenQuestionTitle to set
	 */
	public void setCitizenQuestionTitle(String citizenQuestionTitle) {
		this.citizenQuestionTitle = citizenQuestionTitle;
	}
	/**
	 * @return the citizenQuestionAttachFile
	 */
	public String getCitizenQuestionAttachFile() {
		return citizenQuestionAttachFile;
	}
	/**
	 * @param citizenQuestionAttachFile the citizenQuestionAttachFile to set
	 */
	public void setCitizenQuestionAttachFile(String citizenQuestionAttachFile) {
		this.citizenQuestionAttachFile = citizenQuestionAttachFile;
	}
	/**
	 * @return the citizenQuestionContent
	 */
	public String getCitizenQuestionContent() {
		return citizenQuestionContent;
	}
	/**
	 * @param citizenQuestionContent the citizenQuestionContent to set
	 */
	public void setCitizenQuestionContent(String citizenQuestionContent) {
		this.citizenQuestionContent = citizenQuestionContent;
	}
	/**
	 * @return the citizenQuestionCaptchaGen
	 */
	public String getCitizenQuestionCaptchaGen() {
		return citizenQuestionCaptchaGen;
	}
	/**
	 * @param citizenQuestionCaptchaGen the citizenQuestionCaptchaGen to set
	 */
	public void setCitizenQuestionCaptchaGen(String citizenQuestionCaptchaGen) {
		this.citizenQuestionCaptchaGen = citizenQuestionCaptchaGen;
	}
	/**
	 * @return the citizenQuestionCaptchaInput
	 */
	public String getCitizenQuestionCaptchaInput() {
		return citizenQuestionCaptchaInput;
	}
	/**
	 * @param citizenQuestionCaptchaInput the citizenQuestionCaptchaInput to set
	 */
	public void setCitizenQuestionCaptchaInput(String citizenQuestionCaptchaInput) {
		this.citizenQuestionCaptchaInput = citizenQuestionCaptchaInput;
	}
	
	
}
