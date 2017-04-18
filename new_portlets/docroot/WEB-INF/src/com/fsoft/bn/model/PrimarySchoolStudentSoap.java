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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    FSOFT
 * @generated
 */
public class PrimarySchoolStudentSoap implements Serializable {
	public static PrimarySchoolStudentSoap toSoapModel(
		PrimarySchoolStudent model) {
		PrimarySchoolStudentSoap soapModel = new PrimarySchoolStudentSoap();

		soapModel.setPrimaryStudent_id(model.getPrimaryStudent_id());
		soapModel.setStudent_name(model.getStudent_name());
		soapModel.setStudent_sex(model.getStudent_sex());
		soapModel.setStudent_dob(model.getStudent_dob());
		soapModel.setStudent_placeOfBirth(model.getStudent_placeOfBirth());
		soapModel.setStudent_nationality(model.getStudent_nationality());
		soapModel.setStudent_address(model.getStudent_address());
		soapModel.setStudent_contactName(model.getStudent_contactName());
		soapModel.setStudent_contactRelationship(model.getStudent_contactRelationship());
		soapModel.setStudent_contactPhoneNumber(model.getStudent_contactPhoneNumber());
		soapModel.setStudent_contactEmail(model.getStudent_contactEmail());
		soapModel.setStudent_schoolName(model.getStudent_schoolName());
		soapModel.setStudent_schoolYear(model.getStudent_schoolYear());
		soapModel.setStudent_academicLevel(model.getStudent_academicLevel());
		soapModel.setStudent_studiedLanguage(model.getStudent_studiedLanguage());
		soapModel.setStudent_languageCenter(model.getStudent_languageCenter());
		soapModel.setStudent_prizes(model.getStudent_prizes());
		soapModel.setStudent_skippedGrade(model.getStudent_skippedGrade());
		soapModel.setStudent_penalty(model.getStudent_penalty());
		soapModel.setStudent_interests(model.getStudent_interests());
		soapModel.setStudent_note(model.getStudent_note());
		soapModel.setStudent_registrationClass(model.getStudent_registrationClass());
		soapModel.setStudent_expectedEnrollTime(model.getStudent_expectedEnrollTime());
		soapModel.setStudent_userCar(model.getStudent_userCar());
		soapModel.setStudent_theLightClub(model.getStudent_theLightClub());
		soapModel.setStudent_oversea(model.getStudent_oversea());
		soapModel.setStudent_howToKnowBM(model.getStudent_howToKnowBM());
		soapModel.setStudent_whoIntroduce(model.getStudent_whoIntroduce());
		soapModel.setStudent_anyConfuse(model.getStudent_anyConfuse());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static PrimarySchoolStudentSoap[] toSoapModels(
		PrimarySchoolStudent[] models) {
		PrimarySchoolStudentSoap[] soapModels = new PrimarySchoolStudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PrimarySchoolStudentSoap[][] toSoapModels(
		PrimarySchoolStudent[][] models) {
		PrimarySchoolStudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PrimarySchoolStudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PrimarySchoolStudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PrimarySchoolStudentSoap[] toSoapModels(
		List<PrimarySchoolStudent> models) {
		List<PrimarySchoolStudentSoap> soapModels = new ArrayList<PrimarySchoolStudentSoap>(models.size());

		for (PrimarySchoolStudent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PrimarySchoolStudentSoap[soapModels.size()]);
	}

	public PrimarySchoolStudentSoap() {
	}

	public String getPrimaryKey() {
		return _primaryStudent_id;
	}

	public void setPrimaryKey(String pk) {
		setPrimaryStudent_id(pk);
	}

	public String getPrimaryStudent_id() {
		return _primaryStudent_id;
	}

	public void setPrimaryStudent_id(String primaryStudent_id) {
		_primaryStudent_id = primaryStudent_id;
	}

	public String getStudent_name() {
		return _student_name;
	}

	public void setStudent_name(String student_name) {
		_student_name = student_name;
	}

	public String getStudent_sex() {
		return _student_sex;
	}

	public void setStudent_sex(String student_sex) {
		_student_sex = student_sex;
	}

	public String getStudent_dob() {
		return _student_dob;
	}

	public void setStudent_dob(String student_dob) {
		_student_dob = student_dob;
	}

	public String getStudent_placeOfBirth() {
		return _student_placeOfBirth;
	}

	public void setStudent_placeOfBirth(String student_placeOfBirth) {
		_student_placeOfBirth = student_placeOfBirth;
	}

	public String getStudent_nationality() {
		return _student_nationality;
	}

	public void setStudent_nationality(String student_nationality) {
		_student_nationality = student_nationality;
	}

	public String getStudent_address() {
		return _student_address;
	}

	public void setStudent_address(String student_address) {
		_student_address = student_address;
	}

	public String getStudent_contactName() {
		return _student_contactName;
	}

	public void setStudent_contactName(String student_contactName) {
		_student_contactName = student_contactName;
	}

	public String getStudent_contactRelationship() {
		return _student_contactRelationship;
	}

	public void setStudent_contactRelationship(
		String student_contactRelationship) {
		_student_contactRelationship = student_contactRelationship;
	}

	public String getStudent_contactPhoneNumber() {
		return _student_contactPhoneNumber;
	}

	public void setStudent_contactPhoneNumber(String student_contactPhoneNumber) {
		_student_contactPhoneNumber = student_contactPhoneNumber;
	}

	public String getStudent_contactEmail() {
		return _student_contactEmail;
	}

	public void setStudent_contactEmail(String student_contactEmail) {
		_student_contactEmail = student_contactEmail;
	}

	public String getStudent_schoolName() {
		return _student_schoolName;
	}

	public void setStudent_schoolName(String student_schoolName) {
		_student_schoolName = student_schoolName;
	}

	public String getStudent_schoolYear() {
		return _student_schoolYear;
	}

	public void setStudent_schoolYear(String student_schoolYear) {
		_student_schoolYear = student_schoolYear;
	}

	public String getStudent_academicLevel() {
		return _student_academicLevel;
	}

	public void setStudent_academicLevel(String student_academicLevel) {
		_student_academicLevel = student_academicLevel;
	}

	public String getStudent_studiedLanguage() {
		return _student_studiedLanguage;
	}

	public void setStudent_studiedLanguage(String student_studiedLanguage) {
		_student_studiedLanguage = student_studiedLanguage;
	}

	public String getStudent_languageCenter() {
		return _student_languageCenter;
	}

	public void setStudent_languageCenter(String student_languageCenter) {
		_student_languageCenter = student_languageCenter;
	}

	public String getStudent_prizes() {
		return _student_prizes;
	}

	public void setStudent_prizes(String student_prizes) {
		_student_prizes = student_prizes;
	}

	public String getStudent_skippedGrade() {
		return _student_skippedGrade;
	}

	public void setStudent_skippedGrade(String student_skippedGrade) {
		_student_skippedGrade = student_skippedGrade;
	}

	public String getStudent_penalty() {
		return _student_penalty;
	}

	public void setStudent_penalty(String student_penalty) {
		_student_penalty = student_penalty;
	}

	public String getStudent_interests() {
		return _student_interests;
	}

	public void setStudent_interests(String student_interests) {
		_student_interests = student_interests;
	}

	public String getStudent_note() {
		return _student_note;
	}

	public void setStudent_note(String student_note) {
		_student_note = student_note;
	}

	public String getStudent_registrationClass() {
		return _student_registrationClass;
	}

	public void setStudent_registrationClass(String student_registrationClass) {
		_student_registrationClass = student_registrationClass;
	}

	public String getStudent_expectedEnrollTime() {
		return _student_expectedEnrollTime;
	}

	public void setStudent_expectedEnrollTime(String student_expectedEnrollTime) {
		_student_expectedEnrollTime = student_expectedEnrollTime;
	}

	public String getStudent_userCar() {
		return _student_userCar;
	}

	public void setStudent_userCar(String student_userCar) {
		_student_userCar = student_userCar;
	}

	public String getStudent_theLightClub() {
		return _student_theLightClub;
	}

	public void setStudent_theLightClub(String student_theLightClub) {
		_student_theLightClub = student_theLightClub;
	}

	public String getStudent_oversea() {
		return _student_oversea;
	}

	public void setStudent_oversea(String student_oversea) {
		_student_oversea = student_oversea;
	}

	public String getStudent_howToKnowBM() {
		return _student_howToKnowBM;
	}

	public void setStudent_howToKnowBM(String student_howToKnowBM) {
		_student_howToKnowBM = student_howToKnowBM;
	}

	public String getStudent_whoIntroduce() {
		return _student_whoIntroduce;
	}

	public void setStudent_whoIntroduce(String student_whoIntroduce) {
		_student_whoIntroduce = student_whoIntroduce;
	}

	public String getStudent_anyConfuse() {
		return _student_anyConfuse;
	}

	public void setStudent_anyConfuse(String student_anyConfuse) {
		_student_anyConfuse = student_anyConfuse;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getCreated_date() {
		return _created_date;
	}

	public void setCreated_date(Date created_date) {
		_created_date = created_date;
	}

	public Date getModified_date() {
		return _modified_date;
	}

	public void setModified_date(Date modified_date) {
		_modified_date = modified_date;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	private String _primaryStudent_id;
	private String _student_name;
	private String _student_sex;
	private String _student_dob;
	private String _student_placeOfBirth;
	private String _student_nationality;
	private String _student_address;
	private String _student_contactName;
	private String _student_contactRelationship;
	private String _student_contactPhoneNumber;
	private String _student_contactEmail;
	private String _student_schoolName;
	private String _student_schoolYear;
	private String _student_academicLevel;
	private String _student_studiedLanguage;
	private String _student_languageCenter;
	private String _student_prizes;
	private String _student_skippedGrade;
	private String _student_penalty;
	private String _student_interests;
	private String _student_note;
	private String _student_registrationClass;
	private String _student_expectedEnrollTime;
	private String _student_userCar;
	private String _student_theLightClub;
	private String _student_oversea;
	private String _student_howToKnowBM;
	private String _student_whoIntroduce;
	private String _student_anyConfuse;
	private String _status;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}