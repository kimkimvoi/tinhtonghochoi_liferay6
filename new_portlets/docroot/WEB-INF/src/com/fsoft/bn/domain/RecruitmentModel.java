package com.fsoft.bn.domain;

import com.liferay.portal.kernel.util.StringPool;

public class RecruitmentModel {
	private String recruitment_id;
	private String candidate_name;
	private String candidate_sex;
	private String candidate_dob;
	private String candidate_placeOfBirth;
	private String candidate_nationality;
	private String candidate_race;
	private String candidate_religion;
	private String candidate_IdCardNumber;
	private String candidate_placeOfIssue;
	private String candidate_permanentAddr;
	private String candidate_temporaryAddr;
	private String candidate_phoneNumber;
	private String candidate_email;
	private String candidate_position;
	private String candidate_canStartDate;
	private String candidate_currentSalary;
	private String candidate_expectedSalary;
	private String candidate_howToKnowBM;
	private String candidate_whoIntroduce;
	private String candidate_anyConfuse;
	private String status;
	private String created_date;
	private String modified_date;
	private boolean deleted;
	private String status_display;
	
	public RecruitmentModel() {
		this.setCandidate_name(StringPool.BLANK);
		this.setCandidate_sex(StringPool.BLANK);
		this.setCandidate_dob(StringPool.BLANK);
		this.setCandidate_placeOfBirth(StringPool.BLANK);
		this.setCandidate_nationality(StringPool.BLANK);
		this.setCandidate_race(StringPool.BLANK);
		this.setCandidate_religion(StringPool.BLANK);
		this.setCandidate_IdCardNumber(StringPool.BLANK);
		this.setCandidate_placeOfIssue(StringPool.BLANK);
		this.setCandidate_permanentAddr(StringPool.BLANK);
		this.setCandidate_temporaryAddr(StringPool.BLANK);
		this.setCandidate_phoneNumber(StringPool.BLANK);
		this.setCandidate_email(StringPool.BLANK);
		this.setCandidate_position(StringPool.BLANK);
		this.setCandidate_canStartDate(StringPool.BLANK);
		this.setCandidate_currentSalary(StringPool.BLANK);
		this.setCandidate_expectedSalary(StringPool.BLANK);
		this.setCandidate_howToKnowBM(StringPool.BLANK);
		this.setCandidate_whoIntroduce(StringPool.BLANK);
		this.setCandidate_anyConfuse(StringPool.BLANK);
		this.setStatus("1");
		this.setCreated_date(StringPool.BLANK);
		this.setModified_date(StringPool.BLANK);
		this.setDeleted(false);
	}

	/**
	 * @return the recruitment_id
	 */
	public String getRecruitment_id() {
		return recruitment_id;
	}

	/**
	 * @param recruitment_id the recruitment_id to set
	 */
	public void setRecruitment_id(String recruitment_id) {
		this.recruitment_id = recruitment_id;
	}

	/**
	 * @return the candidate_name
	 */
	public String getCandidate_name() {
		return candidate_name;
	}

	/**
	 * @param candidate_name the candidate_name to set
	 */
	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}

	/**
	 * @return the candidate_sex
	 */
	public String getCandidate_sex() {
		return candidate_sex;
	}

	/**
	 * @param candidate_sex the candidate_sex to set
	 */
	public void setCandidate_sex(String candidate_sex) {
		this.candidate_sex = candidate_sex;
	}

	/**
	 * @return the candidate_dob
	 */
	public String getCandidate_dob() {
		return candidate_dob;
	}

	/**
	 * @param candidate_dob the candidate_dob to set
	 */
	public void setCandidate_dob(String candidate_dob) {
		this.candidate_dob = candidate_dob;
	}

	/**
	 * @return the candidate_placeOfBirth
	 */
	public String getCandidate_placeOfBirth() {
		return candidate_placeOfBirth;
	}

	/**
	 * @param candidate_placeOfBirth the candidate_placeOfBirth to set
	 */
	public void setCandidate_placeOfBirth(String candidate_placeOfBirth) {
		this.candidate_placeOfBirth = candidate_placeOfBirth;
	}

	/**
	 * @return the candidate_nationality
	 */
	public String getCandidate_nationality() {
		return candidate_nationality;
	}

	/**
	 * @param candidate_nationality the candidate_nationality to set
	 */
	public void setCandidate_nationality(String candidate_nationality) {
		this.candidate_nationality = candidate_nationality;
	}

	/**
	 * @return the candidate_race
	 */
	public String getCandidate_race() {
		return candidate_race;
	}

	/**
	 * @param candidate_race the candidate_race to set
	 */
	public void setCandidate_race(String candidate_race) {
		this.candidate_race = candidate_race;
	}

	/**
	 * @return the candidate_religion
	 */
	public String getCandidate_religion() {
		return candidate_religion;
	}

	/**
	 * @param candidate_religion the candidate_religion to set
	 */
	public void setCandidate_religion(String candidate_religion) {
		this.candidate_religion = candidate_religion;
	}

	/**
	 * @return the candidate_IdCardNumber
	 */
	public String getCandidate_IdCardNumber() {
		return candidate_IdCardNumber;
	}

	/**
	 * @param candidate_IdCardNumber the candidate_IdCardNumber to set
	 */
	public void setCandidate_IdCardNumber(String candidate_IdCardNumber) {
		this.candidate_IdCardNumber = candidate_IdCardNumber;
	}

	/**
	 * @return the candidate_placeOfIssue
	 */
	public String getCandidate_placeOfIssue() {
		return candidate_placeOfIssue;
	}

	/**
	 * @param candidate_placeOfIssue the candidate_placeOfIssue to set
	 */
	public void setCandidate_placeOfIssue(String candidate_placeOfIssue) {
		this.candidate_placeOfIssue = candidate_placeOfIssue;
	}

	/**
	 * @return the candidate_permanentAddr
	 */
	public String getCandidate_permanentAddr() {
		return candidate_permanentAddr;
	}

	/**
	 * @param candidate_permanentAddr the candidate_permanentAddr to set
	 */
	public void setCandidate_permanentAddr(String candidate_permanentAddr) {
		this.candidate_permanentAddr = candidate_permanentAddr;
	}

	/**
	 * @return the candidate_temporaryAddr
	 */
	public String getCandidate_temporaryAddr() {
		return candidate_temporaryAddr;
	}

	/**
	 * @param candidate_temporaryAddr the candidate_temporaryAddr to set
	 */
	public void setCandidate_temporaryAddr(String candidate_temporaryAddr) {
		this.candidate_temporaryAddr = candidate_temporaryAddr;
	}

	/**
	 * @return the candidate_phoneNumber
	 */
	public String getCandidate_phoneNumber() {
		return candidate_phoneNumber;
	}

	/**
	 * @param candidate_phoneNumber the candidate_phoneNumber to set
	 */
	public void setCandidate_phoneNumber(String candidate_phoneNumber) {
		this.candidate_phoneNumber = candidate_phoneNumber;
	}

	/**
	 * @return the candidate_email
	 */
	public String getCandidate_email() {
		return candidate_email;
	}

	/**
	 * @param candidate_email the candidate_email to set
	 */
	public void setCandidate_email(String candidate_email) {
		this.candidate_email = candidate_email;
	}

	/**
	 * @return the candidate_position
	 */
	public String getCandidate_position() {
		return candidate_position;
	}

	/**
	 * @param candidate_position the candidate_position to set
	 */
	public void setCandidate_position(String candidate_position) {
		this.candidate_position = candidate_position;
	}

	/**
	 * @return the candidate_canStartDate
	 */
	public String getCandidate_canStartDate() {
		return candidate_canStartDate;
	}

	/**
	 * @param candidate_canStartDate the candidate_canStartDate to set
	 */
	public void setCandidate_canStartDate(String candidate_canStartDate) {
		this.candidate_canStartDate = candidate_canStartDate;
	}

	/**
	 * @return the candidate_currentSalary
	 */
	public String getCandidate_currentSalary() {
		return candidate_currentSalary;
	}

	/**
	 * @param candidate_currentSalary the candidate_currentSalary to set
	 */
	public void setCandidate_currentSalary(String candidate_currentSalary) {
		this.candidate_currentSalary = candidate_currentSalary;
	}

	/**
	 * @return the candidate_expectedSalary
	 */
	public String getCandidate_expectedSalary() {
		return candidate_expectedSalary;
	}

	/**
	 * @param candidate_expectedSalary the candidate_expectedSalary to set
	 */
	public void setCandidate_expectedSalary(String candidate_expectedSalary) {
		this.candidate_expectedSalary = candidate_expectedSalary;
	}

	/**
	 * @return the candidate_howToKnowBM
	 */
	public String getCandidate_howToKnowBM() {
		return candidate_howToKnowBM;
	}

	/**
	 * @param candidate_howToKnowBM the candidate_howToKnowBM to set
	 */
	public void setCandidate_howToKnowBM(String candidate_howToKnowBM) {
		this.candidate_howToKnowBM = candidate_howToKnowBM;
	}

	/**
	 * @return the candidate_whoIntroduce
	 */
	public String getCandidate_whoIntroduce() {
		return candidate_whoIntroduce;
	}

	/**
	 * @param candidate_whoIntroduce the candidate_whoIntroduce to set
	 */
	public void setCandidate_whoIntroduce(String candidate_whoIntroduce) {
		this.candidate_whoIntroduce = candidate_whoIntroduce;
	}

	/**
	 * @return the candidate_anyConfuse
	 */
	public String getCandidate_anyConfuse() {
		return candidate_anyConfuse;
	}

	/**
	 * @param candidate_anyConfuse the candidate_anyConfuse to set
	 */
	public void setCandidate_anyConfuse(String candidate_anyConfuse) {
		this.candidate_anyConfuse = candidate_anyConfuse;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the created_date
	 */
	public String getCreated_date() {
		return created_date;
	}

	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	/**
	 * @return the modified_date
	 */
	public String getModified_date() {
		return modified_date;
	}

	/**
	 * @param modified_date the modified_date to set
	 */
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the status_display
	 */
	public String getStatus_display() {
		return status_display;
	}

	/**
	 * @param status_display the status_display to set
	 */
	public void setStatus_display(String status_display) {
		this.status_display = status_display;
	}	
}
