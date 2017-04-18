/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.fsoft.bn.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PrimarySchoolStudent}.
 * </p>
 *
 * @author    FSOFT
 * @see       PrimarySchoolStudent
 * @generated
 */
public class PrimarySchoolStudentWrapper implements PrimarySchoolStudent,
	ModelWrapper<PrimarySchoolStudent> {
	public PrimarySchoolStudentWrapper(
		PrimarySchoolStudent primarySchoolStudent) {
		_primarySchoolStudent = primarySchoolStudent;
	}

	public Class<?> getModelClass() {
		return PrimarySchoolStudent.class;
	}

	public String getModelClassName() {
		return PrimarySchoolStudent.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("primaryStudent_id", getPrimaryStudent_id());
		attributes.put("student_name", getStudent_name());
		attributes.put("student_sex", getStudent_sex());
		attributes.put("student_dob", getStudent_dob());
		attributes.put("student_placeOfBirth", getStudent_placeOfBirth());
		attributes.put("student_nationality", getStudent_nationality());
		attributes.put("student_address", getStudent_address());
		attributes.put("student_contactName", getStudent_contactName());
		attributes.put("student_contactRelationship",
			getStudent_contactRelationship());
		attributes.put("student_contactPhoneNumber",
			getStudent_contactPhoneNumber());
		attributes.put("student_contactEmail", getStudent_contactEmail());
		attributes.put("student_schoolName", getStudent_schoolName());
		attributes.put("student_schoolYear", getStudent_schoolYear());
		attributes.put("student_academicLevel", getStudent_academicLevel());
		attributes.put("student_studiedLanguage", getStudent_studiedLanguage());
		attributes.put("student_languageCenter", getStudent_languageCenter());
		attributes.put("student_prizes", getStudent_prizes());
		attributes.put("student_skippedGrade", getStudent_skippedGrade());
		attributes.put("student_penalty", getStudent_penalty());
		attributes.put("student_interests", getStudent_interests());
		attributes.put("student_note", getStudent_note());
		attributes.put("student_registrationClass",
			getStudent_registrationClass());
		attributes.put("student_expectedEnrollTime",
			getStudent_expectedEnrollTime());
		attributes.put("student_userCar", getStudent_userCar());
		attributes.put("student_theLightClub", getStudent_theLightClub());
		attributes.put("student_oversea", getStudent_oversea());
		attributes.put("student_howToKnowBM", getStudent_howToKnowBM());
		attributes.put("student_whoIntroduce", getStudent_whoIntroduce());
		attributes.put("student_anyConfuse", getStudent_anyConfuse());
		attributes.put("status", getStatus());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String primaryStudent_id = (String)attributes.get("primaryStudent_id");

		if (primaryStudent_id != null) {
			setPrimaryStudent_id(primaryStudent_id);
		}

		String student_name = (String)attributes.get("student_name");

		if (student_name != null) {
			setStudent_name(student_name);
		}

		String student_sex = (String)attributes.get("student_sex");

		if (student_sex != null) {
			setStudent_sex(student_sex);
		}

		String student_dob = (String)attributes.get("student_dob");

		if (student_dob != null) {
			setStudent_dob(student_dob);
		}

		String student_placeOfBirth = (String)attributes.get(
				"student_placeOfBirth");

		if (student_placeOfBirth != null) {
			setStudent_placeOfBirth(student_placeOfBirth);
		}

		String student_nationality = (String)attributes.get(
				"student_nationality");

		if (student_nationality != null) {
			setStudent_nationality(student_nationality);
		}

		String student_address = (String)attributes.get("student_address");

		if (student_address != null) {
			setStudent_address(student_address);
		}

		String student_contactName = (String)attributes.get(
				"student_contactName");

		if (student_contactName != null) {
			setStudent_contactName(student_contactName);
		}

		String student_contactRelationship = (String)attributes.get(
				"student_contactRelationship");

		if (student_contactRelationship != null) {
			setStudent_contactRelationship(student_contactRelationship);
		}

		String student_contactPhoneNumber = (String)attributes.get(
				"student_contactPhoneNumber");

		if (student_contactPhoneNumber != null) {
			setStudent_contactPhoneNumber(student_contactPhoneNumber);
		}

		String student_contactEmail = (String)attributes.get(
				"student_contactEmail");

		if (student_contactEmail != null) {
			setStudent_contactEmail(student_contactEmail);
		}

		String student_schoolName = (String)attributes.get("student_schoolName");

		if (student_schoolName != null) {
			setStudent_schoolName(student_schoolName);
		}

		String student_schoolYear = (String)attributes.get("student_schoolYear");

		if (student_schoolYear != null) {
			setStudent_schoolYear(student_schoolYear);
		}

		String student_academicLevel = (String)attributes.get(
				"student_academicLevel");

		if (student_academicLevel != null) {
			setStudent_academicLevel(student_academicLevel);
		}

		String student_studiedLanguage = (String)attributes.get(
				"student_studiedLanguage");

		if (student_studiedLanguage != null) {
			setStudent_studiedLanguage(student_studiedLanguage);
		}

		String student_languageCenter = (String)attributes.get(
				"student_languageCenter");

		if (student_languageCenter != null) {
			setStudent_languageCenter(student_languageCenter);
		}

		String student_prizes = (String)attributes.get("student_prizes");

		if (student_prizes != null) {
			setStudent_prizes(student_prizes);
		}

		String student_skippedGrade = (String)attributes.get(
				"student_skippedGrade");

		if (student_skippedGrade != null) {
			setStudent_skippedGrade(student_skippedGrade);
		}

		String student_penalty = (String)attributes.get("student_penalty");

		if (student_penalty != null) {
			setStudent_penalty(student_penalty);
		}

		String student_interests = (String)attributes.get("student_interests");

		if (student_interests != null) {
			setStudent_interests(student_interests);
		}

		String student_note = (String)attributes.get("student_note");

		if (student_note != null) {
			setStudent_note(student_note);
		}

		String student_registrationClass = (String)attributes.get(
				"student_registrationClass");

		if (student_registrationClass != null) {
			setStudent_registrationClass(student_registrationClass);
		}

		String student_expectedEnrollTime = (String)attributes.get(
				"student_expectedEnrollTime");

		if (student_expectedEnrollTime != null) {
			setStudent_expectedEnrollTime(student_expectedEnrollTime);
		}

		String student_userCar = (String)attributes.get("student_userCar");

		if (student_userCar != null) {
			setStudent_userCar(student_userCar);
		}

		String student_theLightClub = (String)attributes.get(
				"student_theLightClub");

		if (student_theLightClub != null) {
			setStudent_theLightClub(student_theLightClub);
		}

		String student_oversea = (String)attributes.get("student_oversea");

		if (student_oversea != null) {
			setStudent_oversea(student_oversea);
		}

		String student_howToKnowBM = (String)attributes.get(
				"student_howToKnowBM");

		if (student_howToKnowBM != null) {
			setStudent_howToKnowBM(student_howToKnowBM);
		}

		String student_whoIntroduce = (String)attributes.get(
				"student_whoIntroduce");

		if (student_whoIntroduce != null) {
			setStudent_whoIntroduce(student_whoIntroduce);
		}

		String student_anyConfuse = (String)attributes.get("student_anyConfuse");

		if (student_anyConfuse != null) {
			setStudent_anyConfuse(student_anyConfuse);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date created_date = (Date)attributes.get("created_date");

		if (created_date != null) {
			setCreated_date(created_date);
		}

		Date modified_date = (Date)attributes.get("modified_date");

		if (modified_date != null) {
			setModified_date(modified_date);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	* Returns the primary key of this primary school student.
	*
	* @return the primary key of this primary school student
	*/
	public java.lang.String getPrimaryKey() {
		return _primarySchoolStudent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this primary school student.
	*
	* @param primaryKey the primary key of this primary school student
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_primarySchoolStudent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the primary student_id of this primary school student.
	*
	* @return the primary student_id of this primary school student
	*/
	public java.lang.String getPrimaryStudent_id() {
		return _primarySchoolStudent.getPrimaryStudent_id();
	}

	/**
	* Sets the primary student_id of this primary school student.
	*
	* @param primaryStudent_id the primary student_id of this primary school student
	*/
	public void setPrimaryStudent_id(java.lang.String primaryStudent_id) {
		_primarySchoolStudent.setPrimaryStudent_id(primaryStudent_id);
	}

	/**
	* Returns the student_name of this primary school student.
	*
	* @return the student_name of this primary school student
	*/
	public java.lang.String getStudent_name() {
		return _primarySchoolStudent.getStudent_name();
	}

	/**
	* Sets the student_name of this primary school student.
	*
	* @param student_name the student_name of this primary school student
	*/
	public void setStudent_name(java.lang.String student_name) {
		_primarySchoolStudent.setStudent_name(student_name);
	}

	/**
	* Returns the student_sex of this primary school student.
	*
	* @return the student_sex of this primary school student
	*/
	public java.lang.String getStudent_sex() {
		return _primarySchoolStudent.getStudent_sex();
	}

	/**
	* Sets the student_sex of this primary school student.
	*
	* @param student_sex the student_sex of this primary school student
	*/
	public void setStudent_sex(java.lang.String student_sex) {
		_primarySchoolStudent.setStudent_sex(student_sex);
	}

	/**
	* Returns the student_dob of this primary school student.
	*
	* @return the student_dob of this primary school student
	*/
	public java.lang.String getStudent_dob() {
		return _primarySchoolStudent.getStudent_dob();
	}

	/**
	* Sets the student_dob of this primary school student.
	*
	* @param student_dob the student_dob of this primary school student
	*/
	public void setStudent_dob(java.lang.String student_dob) {
		_primarySchoolStudent.setStudent_dob(student_dob);
	}

	/**
	* Returns the student_place of birth of this primary school student.
	*
	* @return the student_place of birth of this primary school student
	*/
	public java.lang.String getStudent_placeOfBirth() {
		return _primarySchoolStudent.getStudent_placeOfBirth();
	}

	/**
	* Sets the student_place of birth of this primary school student.
	*
	* @param student_placeOfBirth the student_place of birth of this primary school student
	*/
	public void setStudent_placeOfBirth(java.lang.String student_placeOfBirth) {
		_primarySchoolStudent.setStudent_placeOfBirth(student_placeOfBirth);
	}

	/**
	* Returns the student_nationality of this primary school student.
	*
	* @return the student_nationality of this primary school student
	*/
	public java.lang.String getStudent_nationality() {
		return _primarySchoolStudent.getStudent_nationality();
	}

	/**
	* Sets the student_nationality of this primary school student.
	*
	* @param student_nationality the student_nationality of this primary school student
	*/
	public void setStudent_nationality(java.lang.String student_nationality) {
		_primarySchoolStudent.setStudent_nationality(student_nationality);
	}

	/**
	* Returns the student_address of this primary school student.
	*
	* @return the student_address of this primary school student
	*/
	public java.lang.String getStudent_address() {
		return _primarySchoolStudent.getStudent_address();
	}

	/**
	* Sets the student_address of this primary school student.
	*
	* @param student_address the student_address of this primary school student
	*/
	public void setStudent_address(java.lang.String student_address) {
		_primarySchoolStudent.setStudent_address(student_address);
	}

	/**
	* Returns the student_contact name of this primary school student.
	*
	* @return the student_contact name of this primary school student
	*/
	public java.lang.String getStudent_contactName() {
		return _primarySchoolStudent.getStudent_contactName();
	}

	/**
	* Sets the student_contact name of this primary school student.
	*
	* @param student_contactName the student_contact name of this primary school student
	*/
	public void setStudent_contactName(java.lang.String student_contactName) {
		_primarySchoolStudent.setStudent_contactName(student_contactName);
	}

	/**
	* Returns the student_contact relationship of this primary school student.
	*
	* @return the student_contact relationship of this primary school student
	*/
	public java.lang.String getStudent_contactRelationship() {
		return _primarySchoolStudent.getStudent_contactRelationship();
	}

	/**
	* Sets the student_contact relationship of this primary school student.
	*
	* @param student_contactRelationship the student_contact relationship of this primary school student
	*/
	public void setStudent_contactRelationship(
		java.lang.String student_contactRelationship) {
		_primarySchoolStudent.setStudent_contactRelationship(student_contactRelationship);
	}

	/**
	* Returns the student_contact phone number of this primary school student.
	*
	* @return the student_contact phone number of this primary school student
	*/
	public java.lang.String getStudent_contactPhoneNumber() {
		return _primarySchoolStudent.getStudent_contactPhoneNumber();
	}

	/**
	* Sets the student_contact phone number of this primary school student.
	*
	* @param student_contactPhoneNumber the student_contact phone number of this primary school student
	*/
	public void setStudent_contactPhoneNumber(
		java.lang.String student_contactPhoneNumber) {
		_primarySchoolStudent.setStudent_contactPhoneNumber(student_contactPhoneNumber);
	}

	/**
	* Returns the student_contact email of this primary school student.
	*
	* @return the student_contact email of this primary school student
	*/
	public java.lang.String getStudent_contactEmail() {
		return _primarySchoolStudent.getStudent_contactEmail();
	}

	/**
	* Sets the student_contact email of this primary school student.
	*
	* @param student_contactEmail the student_contact email of this primary school student
	*/
	public void setStudent_contactEmail(java.lang.String student_contactEmail) {
		_primarySchoolStudent.setStudent_contactEmail(student_contactEmail);
	}

	/**
	* Returns the student_school name of this primary school student.
	*
	* @return the student_school name of this primary school student
	*/
	public java.lang.String getStudent_schoolName() {
		return _primarySchoolStudent.getStudent_schoolName();
	}

	/**
	* Sets the student_school name of this primary school student.
	*
	* @param student_schoolName the student_school name of this primary school student
	*/
	public void setStudent_schoolName(java.lang.String student_schoolName) {
		_primarySchoolStudent.setStudent_schoolName(student_schoolName);
	}

	/**
	* Returns the student_school year of this primary school student.
	*
	* @return the student_school year of this primary school student
	*/
	public java.lang.String getStudent_schoolYear() {
		return _primarySchoolStudent.getStudent_schoolYear();
	}

	/**
	* Sets the student_school year of this primary school student.
	*
	* @param student_schoolYear the student_school year of this primary school student
	*/
	public void setStudent_schoolYear(java.lang.String student_schoolYear) {
		_primarySchoolStudent.setStudent_schoolYear(student_schoolYear);
	}

	/**
	* Returns the student_academic level of this primary school student.
	*
	* @return the student_academic level of this primary school student
	*/
	public java.lang.String getStudent_academicLevel() {
		return _primarySchoolStudent.getStudent_academicLevel();
	}

	/**
	* Sets the student_academic level of this primary school student.
	*
	* @param student_academicLevel the student_academic level of this primary school student
	*/
	public void setStudent_academicLevel(java.lang.String student_academicLevel) {
		_primarySchoolStudent.setStudent_academicLevel(student_academicLevel);
	}

	/**
	* Returns the student_studied language of this primary school student.
	*
	* @return the student_studied language of this primary school student
	*/
	public java.lang.String getStudent_studiedLanguage() {
		return _primarySchoolStudent.getStudent_studiedLanguage();
	}

	/**
	* Sets the student_studied language of this primary school student.
	*
	* @param student_studiedLanguage the student_studied language of this primary school student
	*/
	public void setStudent_studiedLanguage(
		java.lang.String student_studiedLanguage) {
		_primarySchoolStudent.setStudent_studiedLanguage(student_studiedLanguage);
	}

	/**
	* Returns the student_language center of this primary school student.
	*
	* @return the student_language center of this primary school student
	*/
	public java.lang.String getStudent_languageCenter() {
		return _primarySchoolStudent.getStudent_languageCenter();
	}

	/**
	* Sets the student_language center of this primary school student.
	*
	* @param student_languageCenter the student_language center of this primary school student
	*/
	public void setStudent_languageCenter(
		java.lang.String student_languageCenter) {
		_primarySchoolStudent.setStudent_languageCenter(student_languageCenter);
	}

	/**
	* Returns the student_prizes of this primary school student.
	*
	* @return the student_prizes of this primary school student
	*/
	public java.lang.String getStudent_prizes() {
		return _primarySchoolStudent.getStudent_prizes();
	}

	/**
	* Sets the student_prizes of this primary school student.
	*
	* @param student_prizes the student_prizes of this primary school student
	*/
	public void setStudent_prizes(java.lang.String student_prizes) {
		_primarySchoolStudent.setStudent_prizes(student_prizes);
	}

	/**
	* Returns the student_skipped grade of this primary school student.
	*
	* @return the student_skipped grade of this primary school student
	*/
	public java.lang.String getStudent_skippedGrade() {
		return _primarySchoolStudent.getStudent_skippedGrade();
	}

	/**
	* Sets the student_skipped grade of this primary school student.
	*
	* @param student_skippedGrade the student_skipped grade of this primary school student
	*/
	public void setStudent_skippedGrade(java.lang.String student_skippedGrade) {
		_primarySchoolStudent.setStudent_skippedGrade(student_skippedGrade);
	}

	/**
	* Returns the student_penalty of this primary school student.
	*
	* @return the student_penalty of this primary school student
	*/
	public java.lang.String getStudent_penalty() {
		return _primarySchoolStudent.getStudent_penalty();
	}

	/**
	* Sets the student_penalty of this primary school student.
	*
	* @param student_penalty the student_penalty of this primary school student
	*/
	public void setStudent_penalty(java.lang.String student_penalty) {
		_primarySchoolStudent.setStudent_penalty(student_penalty);
	}

	/**
	* Returns the student_interests of this primary school student.
	*
	* @return the student_interests of this primary school student
	*/
	public java.lang.String getStudent_interests() {
		return _primarySchoolStudent.getStudent_interests();
	}

	/**
	* Sets the student_interests of this primary school student.
	*
	* @param student_interests the student_interests of this primary school student
	*/
	public void setStudent_interests(java.lang.String student_interests) {
		_primarySchoolStudent.setStudent_interests(student_interests);
	}

	/**
	* Returns the student_note of this primary school student.
	*
	* @return the student_note of this primary school student
	*/
	public java.lang.String getStudent_note() {
		return _primarySchoolStudent.getStudent_note();
	}

	/**
	* Sets the student_note of this primary school student.
	*
	* @param student_note the student_note of this primary school student
	*/
	public void setStudent_note(java.lang.String student_note) {
		_primarySchoolStudent.setStudent_note(student_note);
	}

	/**
	* Returns the student_registration class of this primary school student.
	*
	* @return the student_registration class of this primary school student
	*/
	public java.lang.String getStudent_registrationClass() {
		return _primarySchoolStudent.getStudent_registrationClass();
	}

	/**
	* Sets the student_registration class of this primary school student.
	*
	* @param student_registrationClass the student_registration class of this primary school student
	*/
	public void setStudent_registrationClass(
		java.lang.String student_registrationClass) {
		_primarySchoolStudent.setStudent_registrationClass(student_registrationClass);
	}

	/**
	* Returns the student_expected enroll time of this primary school student.
	*
	* @return the student_expected enroll time of this primary school student
	*/
	public java.lang.String getStudent_expectedEnrollTime() {
		return _primarySchoolStudent.getStudent_expectedEnrollTime();
	}

	/**
	* Sets the student_expected enroll time of this primary school student.
	*
	* @param student_expectedEnrollTime the student_expected enroll time of this primary school student
	*/
	public void setStudent_expectedEnrollTime(
		java.lang.String student_expectedEnrollTime) {
		_primarySchoolStudent.setStudent_expectedEnrollTime(student_expectedEnrollTime);
	}

	/**
	* Returns the student_user car of this primary school student.
	*
	* @return the student_user car of this primary school student
	*/
	public java.lang.String getStudent_userCar() {
		return _primarySchoolStudent.getStudent_userCar();
	}

	/**
	* Sets the student_user car of this primary school student.
	*
	* @param student_userCar the student_user car of this primary school student
	*/
	public void setStudent_userCar(java.lang.String student_userCar) {
		_primarySchoolStudent.setStudent_userCar(student_userCar);
	}

	/**
	* Returns the student_the light club of this primary school student.
	*
	* @return the student_the light club of this primary school student
	*/
	public java.lang.String getStudent_theLightClub() {
		return _primarySchoolStudent.getStudent_theLightClub();
	}

	/**
	* Sets the student_the light club of this primary school student.
	*
	* @param student_theLightClub the student_the light club of this primary school student
	*/
	public void setStudent_theLightClub(java.lang.String student_theLightClub) {
		_primarySchoolStudent.setStudent_theLightClub(student_theLightClub);
	}

	/**
	* Returns the student_oversea of this primary school student.
	*
	* @return the student_oversea of this primary school student
	*/
	public java.lang.String getStudent_oversea() {
		return _primarySchoolStudent.getStudent_oversea();
	}

	/**
	* Sets the student_oversea of this primary school student.
	*
	* @param student_oversea the student_oversea of this primary school student
	*/
	public void setStudent_oversea(java.lang.String student_oversea) {
		_primarySchoolStudent.setStudent_oversea(student_oversea);
	}

	/**
	* Returns the student_how to know b m of this primary school student.
	*
	* @return the student_how to know b m of this primary school student
	*/
	public java.lang.String getStudent_howToKnowBM() {
		return _primarySchoolStudent.getStudent_howToKnowBM();
	}

	/**
	* Sets the student_how to know b m of this primary school student.
	*
	* @param student_howToKnowBM the student_how to know b m of this primary school student
	*/
	public void setStudent_howToKnowBM(java.lang.String student_howToKnowBM) {
		_primarySchoolStudent.setStudent_howToKnowBM(student_howToKnowBM);
	}

	/**
	* Returns the student_who introduce of this primary school student.
	*
	* @return the student_who introduce of this primary school student
	*/
	public java.lang.String getStudent_whoIntroduce() {
		return _primarySchoolStudent.getStudent_whoIntroduce();
	}

	/**
	* Sets the student_who introduce of this primary school student.
	*
	* @param student_whoIntroduce the student_who introduce of this primary school student
	*/
	public void setStudent_whoIntroduce(java.lang.String student_whoIntroduce) {
		_primarySchoolStudent.setStudent_whoIntroduce(student_whoIntroduce);
	}

	/**
	* Returns the student_any confuse of this primary school student.
	*
	* @return the student_any confuse of this primary school student
	*/
	public java.lang.String getStudent_anyConfuse() {
		return _primarySchoolStudent.getStudent_anyConfuse();
	}

	/**
	* Sets the student_any confuse of this primary school student.
	*
	* @param student_anyConfuse the student_any confuse of this primary school student
	*/
	public void setStudent_anyConfuse(java.lang.String student_anyConfuse) {
		_primarySchoolStudent.setStudent_anyConfuse(student_anyConfuse);
	}

	/**
	* Returns the status of this primary school student.
	*
	* @return the status of this primary school student
	*/
	public java.lang.String getStatus() {
		return _primarySchoolStudent.getStatus();
	}

	/**
	* Sets the status of this primary school student.
	*
	* @param status the status of this primary school student
	*/
	public void setStatus(java.lang.String status) {
		_primarySchoolStudent.setStatus(status);
	}

	/**
	* Returns the created_date of this primary school student.
	*
	* @return the created_date of this primary school student
	*/
	public java.util.Date getCreated_date() {
		return _primarySchoolStudent.getCreated_date();
	}

	/**
	* Sets the created_date of this primary school student.
	*
	* @param created_date the created_date of this primary school student
	*/
	public void setCreated_date(java.util.Date created_date) {
		_primarySchoolStudent.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this primary school student.
	*
	* @return the modified_date of this primary school student
	*/
	public java.util.Date getModified_date() {
		return _primarySchoolStudent.getModified_date();
	}

	/**
	* Sets the modified_date of this primary school student.
	*
	* @param modified_date the modified_date of this primary school student
	*/
	public void setModified_date(java.util.Date modified_date) {
		_primarySchoolStudent.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this primary school student.
	*
	* @return the deleted of this primary school student
	*/
	public boolean getDeleted() {
		return _primarySchoolStudent.getDeleted();
	}

	/**
	* Returns <code>true</code> if this primary school student is deleted.
	*
	* @return <code>true</code> if this primary school student is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _primarySchoolStudent.isDeleted();
	}

	/**
	* Sets whether this primary school student is deleted.
	*
	* @param deleted the deleted of this primary school student
	*/
	public void setDeleted(boolean deleted) {
		_primarySchoolStudent.setDeleted(deleted);
	}

	public boolean isNew() {
		return _primarySchoolStudent.isNew();
	}

	public void setNew(boolean n) {
		_primarySchoolStudent.setNew(n);
	}

	public boolean isCachedModel() {
		return _primarySchoolStudent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_primarySchoolStudent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _primarySchoolStudent.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _primarySchoolStudent.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_primarySchoolStudent.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _primarySchoolStudent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_primarySchoolStudent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PrimarySchoolStudentWrapper((PrimarySchoolStudent)_primarySchoolStudent.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent) {
		return _primarySchoolStudent.compareTo(primarySchoolStudent);
	}

	@Override
	public int hashCode() {
		return _primarySchoolStudent.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.PrimarySchoolStudent> toCacheModel() {
		return _primarySchoolStudent.toCacheModel();
	}

	public com.fsoft.bn.model.PrimarySchoolStudent toEscapedModel() {
		return new PrimarySchoolStudentWrapper(_primarySchoolStudent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _primarySchoolStudent.toString();
	}

	public java.lang.String toXmlString() {
		return _primarySchoolStudent.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_primarySchoolStudent.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PrimarySchoolStudent getWrappedPrimarySchoolStudent() {
		return _primarySchoolStudent;
	}

	public PrimarySchoolStudent getWrappedModel() {
		return _primarySchoolStudent;
	}

	public void resetOriginalValues() {
		_primarySchoolStudent.resetOriginalValues();
	}

	private PrimarySchoolStudent _primarySchoolStudent;
}