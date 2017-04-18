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

import com.fsoft.bn.model.PreschoolStudent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PreschoolStudent in entity cache.
 *
 * @author FSOFT
 * @see PreschoolStudent
 * @generated
 */
public class PreschoolStudentCacheModel implements CacheModel<PreschoolStudent>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{student_id=");
		sb.append(student_id);
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
		sb.append(", student_phoneNumber=");
		sb.append(student_phoneNumber);
		sb.append(", student_address=");
		sb.append(student_address);
		sb.append(", student_heatlhStatus=");
		sb.append(student_heatlhStatus);
		sb.append(", student_height=");
		sb.append(student_height);
		sb.append(", student_weight=");
		sb.append(student_weight);
		sb.append(", student_contactName=");
		sb.append(student_contactName);
		sb.append(", student_contactRelationship=");
		sb.append(student_contactRelationship);
		sb.append(", student_contactPhoneNumber=");
		sb.append(student_contactPhoneNumber);
		sb.append(", student_contactEmail=");
		sb.append(student_contactEmail);
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

	public PreschoolStudent toEntityModel() {
		PreschoolStudentImpl preschoolStudentImpl = new PreschoolStudentImpl();

		if (student_id == null) {
			preschoolStudentImpl.setStudent_id(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_id(student_id);
		}

		if (student_name == null) {
			preschoolStudentImpl.setStudent_name(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_name(student_name);
		}

		if (student_sex == null) {
			preschoolStudentImpl.setStudent_sex(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_sex(student_sex);
		}

		if (student_dob == null) {
			preschoolStudentImpl.setStudent_dob(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_dob(student_dob);
		}

		if (student_placeOfBirth == null) {
			preschoolStudentImpl.setStudent_placeOfBirth(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_placeOfBirth(student_placeOfBirth);
		}

		if (student_nationality == null) {
			preschoolStudentImpl.setStudent_nationality(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_nationality(student_nationality);
		}

		if (student_phoneNumber == null) {
			preschoolStudentImpl.setStudent_phoneNumber(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_phoneNumber(student_phoneNumber);
		}

		if (student_address == null) {
			preschoolStudentImpl.setStudent_address(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_address(student_address);
		}

		if (student_heatlhStatus == null) {
			preschoolStudentImpl.setStudent_heatlhStatus(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_heatlhStatus(student_heatlhStatus);
		}

		if (student_height == null) {
			preschoolStudentImpl.setStudent_height(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_height(student_height);
		}

		if (student_weight == null) {
			preschoolStudentImpl.setStudent_weight(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_weight(student_weight);
		}

		if (student_contactName == null) {
			preschoolStudentImpl.setStudent_contactName(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_contactName(student_contactName);
		}

		if (student_contactRelationship == null) {
			preschoolStudentImpl.setStudent_contactRelationship(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_contactRelationship(student_contactRelationship);
		}

		if (student_contactPhoneNumber == null) {
			preschoolStudentImpl.setStudent_contactPhoneNumber(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_contactPhoneNumber(student_contactPhoneNumber);
		}

		if (student_contactEmail == null) {
			preschoolStudentImpl.setStudent_contactEmail(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_contactEmail(student_contactEmail);
		}

		if (student_howToKnowBM == null) {
			preschoolStudentImpl.setStudent_howToKnowBM(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_howToKnowBM(student_howToKnowBM);
		}

		if (student_whoIntroduce == null) {
			preschoolStudentImpl.setStudent_whoIntroduce(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_whoIntroduce(student_whoIntroduce);
		}

		if (student_anyConfuse == null) {
			preschoolStudentImpl.setStudent_anyConfuse(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStudent_anyConfuse(student_anyConfuse);
		}

		if (status == null) {
			preschoolStudentImpl.setStatus(StringPool.BLANK);
		}
		else {
			preschoolStudentImpl.setStatus(status);
		}

		if (created_date == Long.MIN_VALUE) {
			preschoolStudentImpl.setCreated_date(null);
		}
		else {
			preschoolStudentImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			preschoolStudentImpl.setModified_date(null);
		}
		else {
			preschoolStudentImpl.setModified_date(new Date(modified_date));
		}

		preschoolStudentImpl.setDeleted(deleted);

		preschoolStudentImpl.resetOriginalValues();

		return preschoolStudentImpl;
	}

	public String student_id;
	public String student_name;
	public String student_sex;
	public String student_dob;
	public String student_placeOfBirth;
	public String student_nationality;
	public String student_phoneNumber;
	public String student_address;
	public String student_heatlhStatus;
	public String student_height;
	public String student_weight;
	public String student_contactName;
	public String student_contactRelationship;
	public String student_contactPhoneNumber;
	public String student_contactEmail;
	public String student_howToKnowBM;
	public String student_whoIntroduce;
	public String student_anyConfuse;
	public String status;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}