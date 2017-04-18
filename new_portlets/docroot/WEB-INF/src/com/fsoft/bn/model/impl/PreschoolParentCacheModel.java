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

import com.fsoft.bn.model.PreschoolParent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PreschoolParent in entity cache.
 *
 * @author FSOFT
 * @see PreschoolParent
 * @generated
 */
public class PreschoolParentCacheModel implements CacheModel<PreschoolParent>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{preschoolParent_id=");
		sb.append(preschoolParent_id);
		sb.append(", student_id=");
		sb.append(student_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", placeOfBirth=");
		sb.append(placeOfBirth);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", idCardNumber=");
		sb.append(idCardNumber);
		sb.append(", job=");
		sb.append(job);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", isMother=");
		sb.append(isMother);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public PreschoolParent toEntityModel() {
		PreschoolParentImpl preschoolParentImpl = new PreschoolParentImpl();

		if (preschoolParent_id == null) {
			preschoolParentImpl.setPreschoolParent_id(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setPreschoolParent_id(preschoolParent_id);
		}

		if (student_id == null) {
			preschoolParentImpl.setStudent_id(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setStudent_id(student_id);
		}

		if (name == null) {
			preschoolParentImpl.setName(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setName(name);
		}

		if (dob == null) {
			preschoolParentImpl.setDob(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setDob(dob);
		}

		if (placeOfBirth == null) {
			preschoolParentImpl.setPlaceOfBirth(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setPlaceOfBirth(placeOfBirth);
		}

		if (nationality == null) {
			preschoolParentImpl.setNationality(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setNationality(nationality);
		}

		if (idCardNumber == null) {
			preschoolParentImpl.setIdCardNumber(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setIdCardNumber(idCardNumber);
		}

		if (job == null) {
			preschoolParentImpl.setJob(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setJob(job);
		}

		if (phoneNumber == null) {
			preschoolParentImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setPhoneNumber(phoneNumber);
		}

		if (Email == null) {
			preschoolParentImpl.setEmail(StringPool.BLANK);
		}
		else {
			preschoolParentImpl.setEmail(Email);
		}

		preschoolParentImpl.setIsMother(isMother);

		if (created_date == Long.MIN_VALUE) {
			preschoolParentImpl.setCreated_date(null);
		}
		else {
			preschoolParentImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			preschoolParentImpl.setModified_date(null);
		}
		else {
			preschoolParentImpl.setModified_date(new Date(modified_date));
		}

		preschoolParentImpl.setDeleted(deleted);

		preschoolParentImpl.resetOriginalValues();

		return preschoolParentImpl;
	}

	public String preschoolParent_id;
	public String student_id;
	public String name;
	public String dob;
	public String placeOfBirth;
	public String nationality;
	public String idCardNumber;
	public String job;
	public String phoneNumber;
	public String Email;
	public boolean isMother;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}