package com.fsoft.bn.domain;

import com.liferay.portal.kernel.util.StringPool;

public class PreschoolEnrollmentModel {	
	private String student_id;
	private String student_name;
	private String student_sex;
	private String student_dob;
	private String student_placeOfBirth;
	private String student_nationality;
	private String student_phoneNumber;
	private String student_address;
	private String student_healthStatus;
	private String student_height;
	private String student_weight;
	private String student_contactName;
	private String student_contactRelationship;
	private String student_contactPhoneNumber;
	private String student_contactEmail;
	private String student_howToKnowBM;
	private String student_whoIntroduce;
	private String student_anyConfuse;
	private String status;
	private String created_date;
	private String modified_date;
	private boolean deleted;
	private String status_display;
	
	public PreschoolEnrollmentModel() {
		this.setStudent_name(StringPool.BLANK);
		this.setStudent_sex(StringPool.BLANK);
		this.setStudent_dob(StringPool.BLANK);
		this.setStudent_placeOfBirth(StringPool.BLANK);
		this.setStudent_nationality(StringPool.BLANK);
		this.setStudent_phoneNumber(StringPool.BLANK);
		this.setStudent_address(StringPool.BLANK);
		this.setStudent_healthStatus(StringPool.BLANK);
		this.setStudent_height(StringPool.BLANK);
		this.setStudent_weight(StringPool.BLANK);
		this.setStudent_contactName(StringPool.BLANK);
		this.setStudent_contactRelationship(StringPool.BLANK);
		this.setStudent_contactPhoneNumber(StringPool.BLANK);
		this.setStudent_contactEmail(StringPool.BLANK);
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
	 * @return the student_phoneNumber
	 */
	public String getStudent_phoneNumber() {
		return student_phoneNumber;
	}

	/**
	 * @param student_phoneNumber the student_phoneNumber to set
	 */
	public void setStudent_phoneNumber(String student_phoneNumber) {
		this.student_phoneNumber = student_phoneNumber;
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
	 * @return the student_healthStatus
	 */
	public String getStudent_healthStatus() {
		return student_healthStatus;
	}

	/**
	 * @param student_healthStatus the student_healthStatus to set
	 */
	public void setStudent_healthStatus(String student_healthStatus) {
		this.student_healthStatus = student_healthStatus;
	}

	/**
	 * @return the student_height
	 */
	public String getStudent_height() {
		return student_height;
	}

	/**
	 * @param student_height the student_height to set
	 */
	public void setStudent_height(String student_height) {
		this.student_height = student_height;
	}

	/**
	 * @return the student_weight
	 */
	public String getStudent_weight() {
		return student_weight;
	}

	/**
	 * @param student_weight the student_weight to set
	 */
	public void setStudent_weight(String student_weight) {
		this.student_weight = student_weight;
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
	
}
