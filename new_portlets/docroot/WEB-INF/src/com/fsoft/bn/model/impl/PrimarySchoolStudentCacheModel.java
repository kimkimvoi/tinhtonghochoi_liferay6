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

package com.fsoft.bn.model.impl;

import com.fsoft.bn.model.PrimarySchoolStudent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PrimarySchoolStudent in entity cache.
 *
 * @author FSOFT
 * @see PrimarySchoolStudent
 * @generated
 */
public class PrimarySchoolStudentCacheModel implements CacheModel<PrimarySchoolStudent>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{primaryStudent_id=");
		sb.append(primaryStudent_id);
		sb.append(", student_name=");
		sb.append(student_name);
		sb.append(", student_sex=");
		sb.append(student_sex);
		sb.append(", student_dob=");
		sb.append(student_dob);
		sb.append(", student_placeOfBirth=");
		sb.append(student_placeOfBirth);
		sb.append(", student_nationality=");
		sb.append(student_nationality);
		sb.append(", student_address=");
		sb.append(student_address);
		sb.append(", student_contactName=");
		sb.append(student_contactName);
		sb.append(", student_contactRelationship=");
		sb.append(student_contactRelationship);
		sb.append(", student_contactPhoneNumber=");
		sb.append(student_contactPhoneNumber);
		sb.append(", student_contactEmail=");
		sb.append(student_contactEmail);
		sb.append(", student_schoolName=");
		sb.append(student_schoolName);
		sb.append(", student_schoolYear=");
		sb.append(student_schoolYear);
		sb.append(", student_academicLevel=");
		sb.append(student_academicLevel);
		sb.append(", student_studiedLanguage=");
		sb.append(student_studiedLanguage);
		sb.append(", student_languageCenter=");
		sb.append(student_languageCenter);
		sb.append(", student_prizes=");
		sb.append(student_prizes);
		sb.append(", student_skippedGrade=");
		sb.append(student_skippedGrade);
		sb.append(", student_penalty=");
		sb.append(student_penalty);
		sb.append(", student_interests=");
		sb.append(student_interests);
		sb.append(", student_note=");
		sb.append(student_note);
		sb.append(", student_registrationClass=");
		sb.append(student_registrationClass);
		sb.append(", student_expectedEnrollTime=");
		sb.append(student_expectedEnrollTime);
		sb.append(", student_userCar=");
		sb.append(student_userCar);
		sb.append(", student_theLightClub=");
		sb.append(student_theLightClub);
		sb.append(", student_oversea=");
		sb.append(student_oversea);
		sb.append(", student_howToKnowBM=");
		sb.append(student_howToKnowBM);
		sb.append(", student_whoIntroduce=");
		sb.append(student_whoIntroduce);
		sb.append(", student_anyConfuse=");
		sb.append(student_anyConfuse);
		sb.append(", status=");
		sb.append(status);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public PrimarySchoolStudent toEntityModel() {
		PrimarySchoolStudentImpl primarySchoolStudentImpl = new PrimarySchoolStudentImpl();

		if (primaryStudent_id == null) {
			primarySchoolStudentImpl.setPrimaryStudent_id(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setPrimaryStudent_id(primaryStudent_id);
		}

		if (student_name == null) {
			primarySchoolStudentImpl.setStudent_name(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_name(student_name);
		}

		if (student_sex == null) {
			primarySchoolStudentImpl.setStudent_sex(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_sex(student_sex);
		}

		if (student_dob == null) {
			primarySchoolStudentImpl.setStudent_dob(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_dob(student_dob);
		}

		if (student_placeOfBirth == null) {
			primarySchoolStudentImpl.setStudent_placeOfBirth(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_placeOfBirth(student_placeOfBirth);
		}

		if (student_nationality == null) {
			primarySchoolStudentImpl.setStudent_nationality(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_nationality(student_nationality);
		}

		if (student_address == null) {
			primarySchoolStudentImpl.setStudent_address(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_address(student_address);
		}

		if (student_contactName == null) {
			primarySchoolStudentImpl.setStudent_contactName(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_contactName(student_contactName);
		}

		if (student_contactRelationship == null) {
			primarySchoolStudentImpl.setStudent_contactRelationship(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_contactRelationship(student_contactRelationship);
		}

		if (student_contactPhoneNumber == null) {
			primarySchoolStudentImpl.setStudent_contactPhoneNumber(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_contactPhoneNumber(student_contactPhoneNumber);
		}

		if (student_contactEmail == null) {
			primarySchoolStudentImpl.setStudent_contactEmail(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_contactEmail(student_contactEmail);
		}

		if (student_schoolName == null) {
			primarySchoolStudentImpl.setStudent_schoolName(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_schoolName(student_schoolName);
		}

		if (student_schoolYear == null) {
			primarySchoolStudentImpl.setStudent_schoolYear(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_schoolYear(student_schoolYear);
		}

		if (student_academicLevel == null) {
			primarySchoolStudentImpl.setStudent_academicLevel(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_academicLevel(student_academicLevel);
		}

		if (student_studiedLanguage == null) {
			primarySchoolStudentImpl.setStudent_studiedLanguage(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_studiedLanguage(student_studiedLanguage);
		}

		if (student_languageCenter == null) {
			primarySchoolStudentImpl.setStudent_languageCenter(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_languageCenter(student_languageCenter);
		}

		if (student_prizes == null) {
			primarySchoolStudentImpl.setStudent_prizes(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_prizes(student_prizes);
		}

		if (student_skippedGrade == null) {
			primarySchoolStudentImpl.setStudent_skippedGrade(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_skippedGrade(student_skippedGrade);
		}

		if (student_penalty == null) {
			primarySchoolStudentImpl.setStudent_penalty(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_penalty(student_penalty);
		}

		if (student_interests == null) {
			primarySchoolStudentImpl.setStudent_interests(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_interests(student_interests);
		}

		if (student_note == null) {
			primarySchoolStudentImpl.setStudent_note(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_note(student_note);
		}

		if (student_registrationClass == null) {
			primarySchoolStudentImpl.setStudent_registrationClass(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_registrationClass(student_registrationClass);
		}

		if (student_expectedEnrollTime == null) {
			primarySchoolStudentImpl.setStudent_expectedEnrollTime(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_expectedEnrollTime(student_expectedEnrollTime);
		}

		if (student_userCar == null) {
			primarySchoolStudentImpl.setStudent_userCar(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_userCar(student_userCar);
		}

		if (student_theLightClub == null) {
			primarySchoolStudentImpl.setStudent_theLightClub(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_theLightClub(student_theLightClub);
		}

		if (student_oversea == null) {
			primarySchoolStudentImpl.setStudent_oversea(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_oversea(student_oversea);
		}

		if (student_howToKnowBM == null) {
			primarySchoolStudentImpl.setStudent_howToKnowBM(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_howToKnowBM(student_howToKnowBM);
		}

		if (student_whoIntroduce == null) {
			primarySchoolStudentImpl.setStudent_whoIntroduce(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_whoIntroduce(student_whoIntroduce);
		}

		if (student_anyConfuse == null) {
			primarySchoolStudentImpl.setStudent_anyConfuse(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStudent_anyConfuse(student_anyConfuse);
		}

		if (status == null) {
			primarySchoolStudentImpl.setStatus(StringPool.BLANK);
		}
		else {
			primarySchoolStudentImpl.setStatus(status);
		}

		if (created_date == Long.MIN_VALUE) {
			primarySchoolStudentImpl.setCreated_date(null);
		}
		else {
			primarySchoolStudentImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			primarySchoolStudentImpl.setModified_date(null);
		}
		else {
			primarySchoolStudentImpl.setModified_date(new Date(modified_date));
		}

		primarySchoolStudentImpl.setDeleted(deleted);

		primarySchoolStudentImpl.resetOriginalValues();

		return primarySchoolStudentImpl;
	}

	public String primaryStudent_id;
	public String student_name;
	public String student_sex;
	public String student_dob;
	public String student_placeOfBirth;
	public String student_nationality;
	public String student_address;
	public String student_contactName;
	public String student_contactRelationship;
	public String student_contactPhoneNumber;
	public String student_contactEmail;
	public String student_schoolName;
	public String student_schoolYear;
	public String student_academicLevel;
	public String student_studiedLanguage;
	public String student_languageCenter;
	public String student_prizes;
	public String student_skippedGrade;
	public String student_penalty;
	public String student_interests;
	public String student_note;
	public String student_registrationClass;
	public String student_expectedEnrollTime;
	public String student_userCar;
	public String student_theLightClub;
	public String student_oversea;
	public String student_howToKnowBM;
	public String student_whoIntroduce;
	public String student_anyConfuse;
	public String status;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}