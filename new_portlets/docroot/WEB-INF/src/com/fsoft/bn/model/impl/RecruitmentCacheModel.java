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

import com.fsoft.bn.model.Recruitment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Recruitment in entity cache.
 *
 * @author FSOFT
 * @see Recruitment
 * @generated
 */
public class RecruitmentCacheModel implements CacheModel<Recruitment>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{recruitment_id=");
		sb.append(recruitment_id);
		sb.append(", candidate_name=");
		sb.append(candidate_name);
		sb.append(", candidate_sex=");
		sb.append(candidate_sex);
		sb.append(", candidate_dob=");
		sb.append(candidate_dob);
		sb.append(", candidate_placeOfBirth=");
		sb.append(candidate_placeOfBirth);
		sb.append(", candidate_nationality=");
		sb.append(candidate_nationality);
		sb.append(", candidate_race=");
		sb.append(candidate_race);
		sb.append(", candidate_religion=");
		sb.append(candidate_religion);
		sb.append(", candidate_IdCardNumber=");
		sb.append(candidate_IdCardNumber);
		sb.append(", candidate_placeOfIssue=");
		sb.append(candidate_placeOfIssue);
		sb.append(", candidate_permanentPlace=");
		sb.append(candidate_permanentPlace);
		sb.append(", candidate_temporaryPlace=");
		sb.append(candidate_temporaryPlace);
		sb.append(", candidate_phoneNumber=");
		sb.append(candidate_phoneNumber);
		sb.append(", candidate_email=");
		sb.append(candidate_email);
		sb.append(", candidate_position=");
		sb.append(candidate_position);
		sb.append(", candidate_canStartDate=");
		sb.append(candidate_canStartDate);
		sb.append(", candidate_currentSalary=");
		sb.append(candidate_currentSalary);
		sb.append(", candidate_expectedSalary=");
		sb.append(candidate_expectedSalary);
		sb.append(", candidate_howToKnowBM=");
		sb.append(candidate_howToKnowBM);
		sb.append(", candidate_whoIntroduce=");
		sb.append(candidate_whoIntroduce);
		sb.append(", candidate_anyConfuse=");
		sb.append(candidate_anyConfuse);
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

	public Recruitment toEntityModel() {
		RecruitmentImpl recruitmentImpl = new RecruitmentImpl();

		if (recruitment_id == null) {
			recruitmentImpl.setRecruitment_id(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setRecruitment_id(recruitment_id);
		}

		if (candidate_name == null) {
			recruitmentImpl.setCandidate_name(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_name(candidate_name);
		}

		if (candidate_sex == null) {
			recruitmentImpl.setCandidate_sex(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_sex(candidate_sex);
		}

		if (candidate_dob == null) {
			recruitmentImpl.setCandidate_dob(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_dob(candidate_dob);
		}

		if (candidate_placeOfBirth == null) {
			recruitmentImpl.setCandidate_placeOfBirth(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_placeOfBirth(candidate_placeOfBirth);
		}

		if (candidate_nationality == null) {
			recruitmentImpl.setCandidate_nationality(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_nationality(candidate_nationality);
		}

		if (candidate_race == null) {
			recruitmentImpl.setCandidate_race(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_race(candidate_race);
		}

		if (candidate_religion == null) {
			recruitmentImpl.setCandidate_religion(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_religion(candidate_religion);
		}

		if (candidate_IdCardNumber == null) {
			recruitmentImpl.setCandidate_IdCardNumber(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_IdCardNumber(candidate_IdCardNumber);
		}

		if (candidate_placeOfIssue == null) {
			recruitmentImpl.setCandidate_placeOfIssue(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_placeOfIssue(candidate_placeOfIssue);
		}

		if (candidate_permanentPlace == null) {
			recruitmentImpl.setCandidate_permanentPlace(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_permanentPlace(candidate_permanentPlace);
		}

		if (candidate_temporaryPlace == null) {
			recruitmentImpl.setCandidate_temporaryPlace(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_temporaryPlace(candidate_temporaryPlace);
		}

		if (candidate_phoneNumber == null) {
			recruitmentImpl.setCandidate_phoneNumber(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_phoneNumber(candidate_phoneNumber);
		}

		if (candidate_email == null) {
			recruitmentImpl.setCandidate_email(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_email(candidate_email);
		}

		if (candidate_position == null) {
			recruitmentImpl.setCandidate_position(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_position(candidate_position);
		}

		if (candidate_canStartDate == null) {
			recruitmentImpl.setCandidate_canStartDate(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_canStartDate(candidate_canStartDate);
		}

		if (candidate_currentSalary == null) {
			recruitmentImpl.setCandidate_currentSalary(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_currentSalary(candidate_currentSalary);
		}

		if (candidate_expectedSalary == null) {
			recruitmentImpl.setCandidate_expectedSalary(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_expectedSalary(candidate_expectedSalary);
		}

		if (candidate_howToKnowBM == null) {
			recruitmentImpl.setCandidate_howToKnowBM(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_howToKnowBM(candidate_howToKnowBM);
		}

		if (candidate_whoIntroduce == null) {
			recruitmentImpl.setCandidate_whoIntroduce(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_whoIntroduce(candidate_whoIntroduce);
		}

		if (candidate_anyConfuse == null) {
			recruitmentImpl.setCandidate_anyConfuse(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setCandidate_anyConfuse(candidate_anyConfuse);
		}

		if (status == null) {
			recruitmentImpl.setStatus(StringPool.BLANK);
		}
		else {
			recruitmentImpl.setStatus(status);
		}

		if (created_date == Long.MIN_VALUE) {
			recruitmentImpl.setCreated_date(null);
		}
		else {
			recruitmentImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			recruitmentImpl.setModified_date(null);
		}
		else {
			recruitmentImpl.setModified_date(new Date(modified_date));
		}

		recruitmentImpl.setDeleted(deleted);

		recruitmentImpl.resetOriginalValues();

		return recruitmentImpl;
	}

	public String recruitment_id;
	public String candidate_name;
	public String candidate_sex;
	public String candidate_dob;
	public String candidate_placeOfBirth;
	public String candidate_nationality;
	public String candidate_race;
	public String candidate_religion;
	public String candidate_IdCardNumber;
	public String candidate_placeOfIssue;
	public String candidate_permanentPlace;
	public String candidate_temporaryPlace;
	public String candidate_phoneNumber;
	public String candidate_email;
	public String candidate_position;
	public String candidate_canStartDate;
	public String candidate_currentSalary;
	public String candidate_expectedSalary;
	public String candidate_howToKnowBM;
	public String candidate_whoIntroduce;
	public String candidate_anyConfuse;
	public String status;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}