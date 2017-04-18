package com.fsoft.bn.domain;

import com.liferay.portal.kernel.util.StringPool;

public class PrimarySchoolEnrollmentModel {		
	private String student_id;
	private String student_name;
	private String student_sex;
	private String student_dob;
	private String student_placeOfBirth;
	private String student_nationality;
	private String student_address;
	private String student_contactName;
	private String student_contactRelationship;
	private String student_contactPhoneNumber;
	private String student_contactEmail;
	private String student_schoolName;
	private String student_schoolYear;
	private String student_academicLevel;
	private String student_studiedLanguage;
	private String student_languageCenter;
	private String student_prizes;
	private String student_skippedGrade;
	private String student_penalty;
	private String student_interests;
	private String student_note;
	private String student_registrationClass;
	private String student_expectedEnrollTime;
	private String student_userCar;
	private String student_theLightClub;
	private String student_oversea;
	private String student_howToKnowBM;
	private String student_whoIntroduce;
	private String student_anyConfuse;
	private String status;
	private String created_date;
	private String modified_date;
	private boolean deleted;
	private String status_display;
	
	public PrimarySchoolEnrollmentModel() {
		this.setStudent_name(StringPool.BLANK);
		this.setStudent_sex(StringPool.BLANK);
		this.setStudent_dob(StringPool.BLANK);
		this.setStudent_placeOfBirth(StringPool.BLANK);
		this.setStudent_nationality(StringPool.BLANK);
		this.setStudent_address(StringPool.BLANK);		
		this.setStudent_contactName(StringPool.BLANK);
		this.setStudent_contactRelationship(StringPool.BLANK);
		this.setStudent_contactPhoneNumber(StringPool.BLANK);
		this.setStudent_contactEmail(StringPool.BLANK);
		this.setStudent_schoolName(StringPool.BLANK);
		this.setStudent_schoolYear(StringPool.BLANK);
		this.setStudent_academicLevel(StringPool.BLANK);
		this.setStudent_studiedLanguage(StringPool.BLANK);
		this.setStudent_languageCenter(StringPool.BLANK);		
		this.setStudent_prizes(StringPool.BLANK);
		this.setStudent_skippedGrade(StringPool.BLANK);
		this.setStudent_penalty(StringPool.BLANK);
		this.setStudent_interests(StringPool.BLANK);
		this.setStudent_note(StringPool.BLANK);
		this.setStudent_registrationClass(StringPool.BLANK);		
		this.setStudent_expectedEnrollTime(StringPool.BLANK);
		this.setStudent_userCar(StringPool.BLANK);
		this.setStudent_theLightClub(StringPool.BLANK);
		this.setStudent_oversea(StringPool.BLANK);
		this.setStudent_howToKnowBM(StringPool.BLANK);
		this.setStudent_whoIntroduce(StringPool.BLANK);
		this.setStudent_anyConfuse(StringPool.BLANK);
		this.setStatus(StringPool.BLANK);
		this.setStatus("1");
		this.setCreated_date(StringPool.BLANK);
		this.setModified_date(StringPool.BLANK);
		this.setDeleted(false);
	}

	/**
	 * @return the student_id
	 */
	public String getStudent_id() {
		return student_id;
	}

	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	/**
	 * @return the student_name
	 */
	public String getStudent_name() {
		return student_name;
	}

	/**
	 * @param student_name the student_name to set
	 */
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	/**
	 * @return the student_sex
	 */
	public String getStudent_sex() {
		return student_sex;
	}

	/**
	 * @param student_sex the student_sex to set
	 */
	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}

	/**
	 * @return the student_dob
	 */
	public String getStudent_dob() {
		return student_dob;
	}

	/**
	 * @param student_dob the student_dob to set
	 */
	public void setStudent_dob(String student_dob) {
		this.student_dob = student_dob;
	}

	/**
	 * @return the student_placeOfBirth
	 */
	public String getStudent_placeOfBirth() {
		return student_placeOfBirth;
	}

	/**
	 * @param student_placeOfBirth the student_placeOfBirth to set
	 */
	public void setStudent_placeOfBirth(String student_placeOfBirth) {
		this.student_placeOfBirth = student_placeOfBirth;
	}

	/**
	 * @return the student_nationality
	 */
	public String getStudent_nationality() {
		return student_nationality;
	}

	/**
	 * @param student_nationality the student_nationality to set
	 */
	public void setStudent_nationality(String student_nationality) {
		this.student_nationality = student_nationality;
	}

	/**
	 * @return the student_address
	 */
	public String getStudent_address() {
		return student_address;
	}

	/**
	 * @param student_address the student_address to set
	 */
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	/**
	 * @return the student_contactName
	 */
	public String getStudent_contactName() {
		return student_contactName;
	}

	/**
	 * @param student_contactName the student_contactName to set
	 */
	public void setStudent_contactName(String student_contactName) {
		this.student_contactName = student_contactName;
	}

	/**
	 * @return the student_contactRelationship
	 */
	public String getStudent_contactRelationship() {
		return student_contactRelationship;
	}

	/**
	 * @param student_contactRelationship the student_contactRelationship to set
	 */
	public void setStudent_contactRelationship(
			String student_contactRelationship) {
		this.student_contactRelationship = student_contactRelationship;
	}

	/**
	 * @return the student_contactPhoneNumber
	 */
	public String getStudent_contactPhoneNumber() {
		return student_contactPhoneNumber;
	}

	/**
	 * @param student_contactPhoneNumber the student_contactPhoneNumber to set
	 */
	public void setStudent_contactPhoneNumber(String student_contactPhoneNumber) {
		this.student_contactPhoneNumber = student_contactPhoneNumber;
	}

	/**
	 * @return the student_contactEmail
	 */
	public String getStudent_contactEmail() {
		return student_contactEmail;
	}

	/**
	 * @param student_contactEmail the student_contactEmail to set
	 */
	public void setStudent_contactEmail(String student_contactEmail) {
		this.student_contactEmail = student_contactEmail;
	}

	/**
	 * @return the student_howToKnowBM
	 */
	public String getStudent_howToKnowBM() {
		return student_howToKnowBM;
	}

	/**
	 * @param student_howToKnowBM the student_howToKnowBM to set
	 */
	public void setStudent_howToKnowBM(String student_howToKnowBM) {
		this.student_howToKnowBM = student_howToKnowBM;
	}

	/**
	 * @return the student_whoIntroduce
	 */
	public String getStudent_whoIntroduce() {
		return student_whoIntroduce;
	}

	/**
	 * @param student_whoIntroduce the student_whoIntroduce to set
	 */
	public void setStudent_whoIntroduce(String student_whoIntroduce) {
		this.student_whoIntroduce = student_whoIntroduce;
	}

	/**
	 * @return the student_anyConfuse
	 */
	public String getStudent_anyConfuse() {
		return student_anyConfuse;
	}

	/**
	 * @param student_anyConfuse the student_anyConfuse to set
	 */
	public void setStudent_anyConfuse(String student_anyConfuse) {
		this.student_anyConfuse = student_anyConfuse;
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

	/**
	 * @return the student_schoolName
	 */
	public String getStudent_schoolName() {
		return student_schoolName;
	}

	/**
	 * @param student_schoolName the student_schoolName to set
	 */
	public void setStudent_schoolName(String student_schoolName) {
		this.student_schoolName = student_schoolName;
	}

	/**
	 * @return the student_schoolYear
	 */
	public String getStudent_schoolYear() {
		return student_schoolYear;
	}

	/**
	 * @param student_schoolYear the student_schoolYear to set
	 */
	public void setStudent_schoolYear(String student_schoolYear) {
		this.student_schoolYear = student_schoolYear;
	}

	/**
	 * @return the student_academicLevel
	 */
	public String getStudent_academicLevel() {
		return student_academicLevel;
	}

	/**
	 * @param student_academicLevel the student_academicLevel to set
	 */
	public void setStudent_academicLevel(String student_academicLevel) {
		this.student_academicLevel = student_academicLevel;
	}

	/**
	 * @return the student_studiedLanguage
	 */
	public String getStudent_studiedLanguage() {
		return student_studiedLanguage;
	}

	/**
	 * @param student_studiedLanguage the student_studiedLanguage to set
	 */
	public void setStudent_studiedLanguage(String student_studiedLanguage) {
		this.student_studiedLanguage = student_studiedLanguage;
	}

	/**
	 * @return the student_languageCenter
	 */
	public String getStudent_languageCenter() {
		return student_languageCenter;
	}

	/**
	 * @param student_languageCenter the student_languageCenter to set
	 */
	public void setStudent_languageCenter(String student_languageCenter) {
		this.student_languageCenter = student_languageCenter;
	}

	/**
	 * @return the student_prizes
	 */
	public String getStudent_prizes() {
		return student_prizes;
	}

	/**
	 * @param student_prizes the student_prizes to set
	 */
	public void setStudent_prizes(String student_prizes) {
		this.student_prizes = student_prizes;
	}

	/**
	 * @return the student_skippedGrade
	 */
	public String getStudent_skippedGrade() {
		return student_skippedGrade;
	}

	/**
	 * @param student_skippedGrade the student_skippedGrade to set
	 */
	public void setStudent_skippedGrade(String student_skippedGrade) {
		this.student_skippedGrade = student_skippedGrade;
	}

	/**
	 * @return the student_penalty
	 */
	public String getStudent_penalty() {
		return student_penalty;
	}

	/**
	 * @param student_penalty the student_penalty to set
	 */
	public void setStudent_penalty(String student_penalty) {
		this.student_penalty = student_penalty;
	}

	/**
	 * @return the student_interests
	 */
	public String getStudent_interests() {
		return student_interests;
	}

	/**
	 * @param student_interests the student_interests to set
	 */
	public void setStudent_interests(String student_interests) {
		this.student_interests = student_interests;
	}

	/**
	 * @return the student_note
	 */
	public String getStudent_note() {
		return student_note;
	}

	/**
	 * @param student_note the student_note to set
	 */
	public void setStudent_note(String student_note) {
		this.student_note = student_note;
	}

	/**
	 * @return the student_registrationClass
	 */
	public String getStudent_registrationClass() {
		return student_registrationClass;
	}

	/**
	 * @param student_registrationClass the student_registrationClass to set
	 */
	public void setStudent_registrationClass(String student_registrationClass) {
		this.student_registrationClass = student_registrationClass;
	}

	/**
	 * @return the student_expectedEnrollTime
	 */
	public String getStudent_expectedEnrollTime() {
		return student_expectedEnrollTime;
	}

	/**
	 * @param student_expectedEnrollTime the student_expectedEnrollTime to set
	 */
	public void setStudent_expectedEnrollTime(String student_expectedEnrollTime) {
		this.student_expectedEnrollTime = student_expectedEnrollTime;
	}

	/**
	 * @return the student_userCar
	 */
	public String getStudent_userCar() {
		return student_userCar;
	}

	/**
	 * @param student_userCar the student_userCar to set
	 */
	public void setStudent_userCar(String student_userCar) {
		this.student_userCar = student_userCar;
	}

	/**
	 * @return the student_theLightClub
	 */
	public String getStudent_theLightClub() {
		return student_theLightClub;
	}

	/**
	 * @param student_theLightClub the student_theLightClub to set
	 */
	public void setStudent_theLightClub(String student_theLightClub) {
		this.student_theLightClub = student_theLightClub;
	}

	/**
	 * @return the student_oversea
	 */
	public String getStudent_oversea() {
		return student_oversea;
	}

	/**
	 * @param student_oversea the student_oversea to set
	 */
	public void setStudent_oversea(String student_oversea) {
		this.student_oversea = student_oversea;
	}
	
}
