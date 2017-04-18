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
public class RecruitmentSoap implements Serializable {
	public static RecruitmentSoap toSoapModel(Recruitment model) {
		RecruitmentSoap soapModel = new RecruitmentSoap();

		soapModel.setRecruitment_id(model.getRecruitment_id());
		soapModel.setCandidate_name(model.getCandidate_name());
		soapModel.setCandidate_sex(model.getCandidate_sex());
		soapModel.setCandidate_dob(model.getCandidate_dob());
		soapModel.setCandidate_placeOfBirth(model.getCandidate_placeOfBirth());
		soapModel.setCandidate_nationality(model.getCandidate_nationality());
		soapModel.setCandidate_race(model.getCandidate_race());
		soapModel.setCandidate_religion(model.getCandidate_religion());
		soapModel.setCandidate_IdCardNumber(model.getCandidate_IdCardNumber());
		soapModel.setCandidate_placeOfIssue(model.getCandidate_placeOfIssue());
		soapModel.setCandidate_permanentPlace(model.getCandidate_permanentPlace());
		soapModel.setCandidate_temporaryPlace(model.getCandidate_temporaryPlace());
		soapModel.setCandidate_phoneNumber(model.getCandidate_phoneNumber());
		soapModel.setCandidate_email(model.getCandidate_email());
		soapModel.setCandidate_position(model.getCandidate_position());
		soapModel.setCandidate_canStartDate(model.getCandidate_canStartDate());
		soapModel.setCandidate_currentSalary(model.getCandidate_currentSalary());
		soapModel.setCandidate_expectedSalary(model.getCandidate_expectedSalary());
		soapModel.setCandidate_howToKnowBM(model.getCandidate_howToKnowBM());
		soapModel.setCandidate_whoIntroduce(model.getCandidate_whoIntroduce());
		soapModel.setCandidate_anyConfuse(model.getCandidate_anyConfuse());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static RecruitmentSoap[] toSoapModels(Recruitment[] models) {
		RecruitmentSoap[] soapModels = new RecruitmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentSoap[][] toSoapModels(Recruitment[][] models) {
		RecruitmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecruitmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecruitmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentSoap[] toSoapModels(List<Recruitment> models) {
		List<RecruitmentSoap> soapModels = new ArrayList<RecruitmentSoap>(models.size());

		for (Recruitment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecruitmentSoap[soapModels.size()]);
	}

	public RecruitmentSoap() {
	}

	public String getPrimaryKey() {
		return _recruitment_id;
	}

	public void setPrimaryKey(String pk) {
		setRecruitment_id(pk);
	}

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getCandidate_name() {
		return _candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		_candidate_name = candidate_name;
	}

	public String getCandidate_sex() {
		return _candidate_sex;
	}

	public void setCandidate_sex(String candidate_sex) {
		_candidate_sex = candidate_sex;
	}

	public String getCandidate_dob() {
		return _candidate_dob;
	}

	public void setCandidate_dob(String candidate_dob) {
		_candidate_dob = candidate_dob;
	}

	public String getCandidate_placeOfBirth() {
		return _candidate_placeOfBirth;
	}

	public void setCandidate_placeOfBirth(String candidate_placeOfBirth) {
		_candidate_placeOfBirth = candidate_placeOfBirth;
	}

	public String getCandidate_nationality() {
		return _candidate_nationality;
	}

	public void setCandidate_nationality(String candidate_nationality) {
		_candidate_nationality = candidate_nationality;
	}

	public String getCandidate_race() {
		return _candidate_race;
	}

	public void setCandidate_race(String candidate_race) {
		_candidate_race = candidate_race;
	}

	public String getCandidate_religion() {
		return _candidate_religion;
	}

	public void setCandidate_religion(String candidate_religion) {
		_candidate_religion = candidate_religion;
	}

	public String getCandidate_IdCardNumber() {
		return _candidate_IdCardNumber;
	}

	public void setCandidate_IdCardNumber(String candidate_IdCardNumber) {
		_candidate_IdCardNumber = candidate_IdCardNumber;
	}

	public String getCandidate_placeOfIssue() {
		return _candidate_placeOfIssue;
	}

	public void setCandidate_placeOfIssue(String candidate_placeOfIssue) {
		_candidate_placeOfIssue = candidate_placeOfIssue;
	}

	public String getCandidate_permanentPlace() {
		return _candidate_permanentPlace;
	}

	public void setCandidate_permanentPlace(String candidate_permanentPlace) {
		_candidate_permanentPlace = candidate_permanentPlace;
	}

	public String getCandidate_temporaryPlace() {
		return _candidate_temporaryPlace;
	}

	public void setCandidate_temporaryPlace(String candidate_temporaryPlace) {
		_candidate_temporaryPlace = candidate_temporaryPlace;
	}

	public String getCandidate_phoneNumber() {
		return _candidate_phoneNumber;
	}

	public void setCandidate_phoneNumber(String candidate_phoneNumber) {
		_candidate_phoneNumber = candidate_phoneNumber;
	}

	public String getCandidate_email() {
		return _candidate_email;
	}

	public void setCandidate_email(String candidate_email) {
		_candidate_email = candidate_email;
	}

	public String getCandidate_position() {
		return _candidate_position;
	}

	public void setCandidate_position(String candidate_position) {
		_candidate_position = candidate_position;
	}

	public String getCandidate_canStartDate() {
		return _candidate_canStartDate;
	}

	public void setCandidate_canStartDate(String candidate_canStartDate) {
		_candidate_canStartDate = candidate_canStartDate;
	}

	public String getCandidate_currentSalary() {
		return _candidate_currentSalary;
	}

	public void setCandidate_currentSalary(String candidate_currentSalary) {
		_candidate_currentSalary = candidate_currentSalary;
	}

	public String getCandidate_expectedSalary() {
		return _candidate_expectedSalary;
	}

	public void setCandidate_expectedSalary(String candidate_expectedSalary) {
		_candidate_expectedSalary = candidate_expectedSalary;
	}

	public String getCandidate_howToKnowBM() {
		return _candidate_howToKnowBM;
	}

	public void setCandidate_howToKnowBM(String candidate_howToKnowBM) {
		_candidate_howToKnowBM = candidate_howToKnowBM;
	}

	public String getCandidate_whoIntroduce() {
		return _candidate_whoIntroduce;
	}

	public void setCandidate_whoIntroduce(String candidate_whoIntroduce) {
		_candidate_whoIntroduce = candidate_whoIntroduce;
	}

	public String getCandidate_anyConfuse() {
		return _candidate_anyConfuse;
	}

	public void setCandidate_anyConfuse(String candidate_anyConfuse) {
		_candidate_anyConfuse = candidate_anyConfuse;
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

	private String _recruitment_id;
	private String _candidate_name;
	private String _candidate_sex;
	private String _candidate_dob;
	private String _candidate_placeOfBirth;
	private String _candidate_nationality;
	private String _candidate_race;
	private String _candidate_religion;
	private String _candidate_IdCardNumber;
	private String _candidate_placeOfIssue;
	private String _candidate_permanentPlace;
	private String _candidate_temporaryPlace;
	private String _candidate_phoneNumber;
	private String _candidate_email;
	private String _candidate_position;
	private String _candidate_canStartDate;
	private String _candidate_currentSalary;
	private String _candidate_expectedSalary;
	private String _candidate_howToKnowBM;
	private String _candidate_whoIntroduce;
	private String _candidate_anyConfuse;
	private String _status;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}