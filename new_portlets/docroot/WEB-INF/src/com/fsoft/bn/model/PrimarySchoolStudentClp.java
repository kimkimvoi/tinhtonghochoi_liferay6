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

import com.fsoft.bn.service.PrimarySchoolStudentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FSOFT
 */
public class PrimarySchoolStudentClp extends BaseModelImpl<PrimarySchoolStudent>
	implements PrimarySchoolStudent {
	public PrimarySchoolStudentClp() {
	}

	public Class<?> getModelClass() {
		return PrimarySchoolStudent.class;
	}

	public String getModelClassName() {
		return PrimarySchoolStudent.class.getName();
	}

	public String getPrimaryKey() {
		return _primaryStudent_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setPrimaryStudent_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _primaryStudent_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
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

	@Override
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

	public BaseModel<?> getPrimarySchoolStudentRemoteModel() {
		return _primarySchoolStudentRemoteModel;
	}

	public void setPrimarySchoolStudentRemoteModel(
		BaseModel<?> primarySchoolStudentRemoteModel) {
		_primarySchoolStudentRemoteModel = primarySchoolStudentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PrimarySchoolStudentLocalServiceUtil.addPrimarySchoolStudent(this);
		}
		else {
			PrimarySchoolStudentLocalServiceUtil.updatePrimarySchoolStudent(this);
		}
	}

	@Override
	public PrimarySchoolStudent toEscapedModel() {
		return (PrimarySchoolStudent)Proxy.newProxyInstance(PrimarySchoolStudent.class.getClassLoader(),
			new Class[] { PrimarySchoolStudent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PrimarySchoolStudentClp clone = new PrimarySchoolStudentClp();

		clone.setPrimaryStudent_id(getPrimaryStudent_id());
		clone.setStudent_name(getStudent_name());
		clone.setStudent_sex(getStudent_sex());
		clone.setStudent_dob(getStudent_dob());
		clone.setStudent_placeOfBirth(getStudent_placeOfBirth());
		clone.setStudent_nationality(getStudent_nationality());
		clone.setStudent_address(getStudent_address());
		clone.setStudent_contactName(getStudent_contactName());
		clone.setStudent_contactRelationship(getStudent_contactRelationship());
		clone.setStudent_contactPhoneNumber(getStudent_contactPhoneNumber());
		clone.setStudent_contactEmail(getStudent_contactEmail());
		clone.setStudent_schoolName(getStudent_schoolName());
		clone.setStudent_schoolYear(getStudent_schoolYear());
		clone.setStudent_academicLevel(getStudent_academicLevel());
		clone.setStudent_studiedLanguage(getStudent_studiedLanguage());
		clone.setStudent_languageCenter(getStudent_languageCenter());
		clone.setStudent_prizes(getStudent_prizes());
		clone.setStudent_skippedGrade(getStudent_skippedGrade());
		clone.setStudent_penalty(getStudent_penalty());
		clone.setStudent_interests(getStudent_interests());
		clone.setStudent_note(getStudent_note());
		clone.setStudent_registrationClass(getStudent_registrationClass());
		clone.setStudent_expectedEnrollTime(getStudent_expectedEnrollTime());
		clone.setStudent_userCar(getStudent_userCar());
		clone.setStudent_theLightClub(getStudent_theLightClub());
		clone.setStudent_oversea(getStudent_oversea());
		clone.setStudent_howToKnowBM(getStudent_howToKnowBM());
		clone.setStudent_whoIntroduce(getStudent_whoIntroduce());
		clone.setStudent_anyConfuse(getStudent_anyConfuse());
		clone.setStatus(getStatus());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(PrimarySchoolStudent primarySchoolStudent) {
		String primaryKey = primarySchoolStudent.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PrimarySchoolStudentClp primarySchoolStudent = null;

		try {
			primarySchoolStudent = (PrimarySchoolStudentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = primarySchoolStudent.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{primaryStudent_id=");
		sb.append(getPrimaryStudent_id());
		sb.append(", student_name=");
		sb.append(getStudent_name());
		sb.append(", student_sex=");
		sb.append(getStudent_sex());
		sb.append(", student_dob=");
		sb.append(getStudent_dob());
		sb.append(", student_placeOfBirth=");
		sb.append(getStudent_placeOfBirth());
		sb.append(", student_nationality=");
		sb.append(getStudent_nationality());
		sb.append(", student_address=");
		sb.append(getStudent_address());
		sb.append(", student_contactName=");
		sb.append(getStudent_contactName());
		sb.append(", student_contactRelationship=");
		sb.append(getStudent_contactRelationship());
		sb.append(", student_contactPhoneNumber=");
		sb.append(getStudent_contactPhoneNumber());
		sb.append(", student_contactEmail=");
		sb.append(getStudent_contactEmail());
		sb.append(", student_schoolName=");
		sb.append(getStudent_schoolName());
		sb.append(", student_schoolYear=");
		sb.append(getStudent_schoolYear());
		sb.append(", student_academicLevel=");
		sb.append(getStudent_academicLevel());
		sb.append(", student_studiedLanguage=");
		sb.append(getStudent_studiedLanguage());
		sb.append(", student_languageCenter=");
		sb.append(getStudent_languageCenter());
		sb.append(", student_prizes=");
		sb.append(getStudent_prizes());
		sb.append(", student_skippedGrade=");
		sb.append(getStudent_skippedGrade());
		sb.append(", student_penalty=");
		sb.append(getStudent_penalty());
		sb.append(", student_interests=");
		sb.append(getStudent_interests());
		sb.append(", student_note=");
		sb.append(getStudent_note());
		sb.append(", student_registrationClass=");
		sb.append(getStudent_registrationClass());
		sb.append(", student_expectedEnrollTime=");
		sb.append(getStudent_expectedEnrollTime());
		sb.append(", student_userCar=");
		sb.append(getStudent_userCar());
		sb.append(", student_theLightClub=");
		sb.append(getStudent_theLightClub());
		sb.append(", student_oversea=");
		sb.append(getStudent_oversea());
		sb.append(", student_howToKnowBM=");
		sb.append(getStudent_howToKnowBM());
		sb.append(", student_whoIntroduce=");
		sb.append(getStudent_whoIntroduce());
		sb.append(", student_anyConfuse=");
		sb.append(getStudent_anyConfuse());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", modified_date=");
		sb.append(getModified_date());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(103);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.PrimarySchoolStudent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>primaryStudent_id</column-name><column-value><![CDATA[");
		sb.append(getPrimaryStudent_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_name</column-name><column-value><![CDATA[");
		sb.append(getStudent_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_sex</column-name><column-value><![CDATA[");
		sb.append(getStudent_sex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_dob</column-name><column-value><![CDATA[");
		sb.append(getStudent_dob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_placeOfBirth</column-name><column-value><![CDATA[");
		sb.append(getStudent_placeOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_nationality</column-name><column-value><![CDATA[");
		sb.append(getStudent_nationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_address</column-name><column-value><![CDATA[");
		sb.append(getStudent_address());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_contactName</column-name><column-value><![CDATA[");
		sb.append(getStudent_contactName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_contactRelationship</column-name><column-value><![CDATA[");
		sb.append(getStudent_contactRelationship());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_contactPhoneNumber</column-name><column-value><![CDATA[");
		sb.append(getStudent_contactPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_contactEmail</column-name><column-value><![CDATA[");
		sb.append(getStudent_contactEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_schoolName</column-name><column-value><![CDATA[");
		sb.append(getStudent_schoolName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_schoolYear</column-name><column-value><![CDATA[");
		sb.append(getStudent_schoolYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_academicLevel</column-name><column-value><![CDATA[");
		sb.append(getStudent_academicLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_studiedLanguage</column-name><column-value><![CDATA[");
		sb.append(getStudent_studiedLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_languageCenter</column-name><column-value><![CDATA[");
		sb.append(getStudent_languageCenter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_prizes</column-name><column-value><![CDATA[");
		sb.append(getStudent_prizes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_skippedGrade</column-name><column-value><![CDATA[");
		sb.append(getStudent_skippedGrade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_penalty</column-name><column-value><![CDATA[");
		sb.append(getStudent_penalty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_interests</column-name><column-value><![CDATA[");
		sb.append(getStudent_interests());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_note</column-name><column-value><![CDATA[");
		sb.append(getStudent_note());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_registrationClass</column-name><column-value><![CDATA[");
		sb.append(getStudent_registrationClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_expectedEnrollTime</column-name><column-value><![CDATA[");
		sb.append(getStudent_expectedEnrollTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_userCar</column-name><column-value><![CDATA[");
		sb.append(getStudent_userCar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_theLightClub</column-name><column-value><![CDATA[");
		sb.append(getStudent_theLightClub());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_oversea</column-name><column-value><![CDATA[");
		sb.append(getStudent_oversea());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_howToKnowBM</column-name><column-value><![CDATA[");
		sb.append(getStudent_howToKnowBM());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_whoIntroduce</column-name><column-value><![CDATA[");
		sb.append(getStudent_whoIntroduce());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_anyConfuse</column-name><column-value><![CDATA[");
		sb.append(getStudent_anyConfuse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created_date</column-name><column-value><![CDATA[");
		sb.append(getCreated_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modified_date</column-name><column-value><![CDATA[");
		sb.append(getModified_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _primarySchoolStudentRemoteModel;
}