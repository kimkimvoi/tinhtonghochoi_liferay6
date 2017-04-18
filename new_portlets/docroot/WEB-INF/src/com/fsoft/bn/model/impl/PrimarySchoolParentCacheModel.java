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

import com.fsoft.bn.model.PrimarySchoolParent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PrimarySchoolParent in entity cache.
 *
 * @author FSOFT
 * @see PrimarySchoolParent
 * @generated
 */
public class PrimarySchoolParentCacheModel implements CacheModel<PrimarySchoolParent>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{primarySchoolParent_id=");
		sb.append(primarySchoolParent_id);
		sb.append(", primaryStudent_id=");
		sb.append(primaryStudent_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", idCardNumber=");
		sb.append(idCardNumber);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", job=");
		sb.append(job);
		sb.append(", job_position=");
		sb.append(job_position);
		sb.append(", workplace=");
		sb.append(workplace);
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

	public PrimarySchoolParent toEntityModel() {
		PrimarySchoolParentImpl primarySchoolParentImpl = new PrimarySchoolParentImpl();

		if (primarySchoolParent_id == null) {
			primarySchoolParentImpl.setPrimarySchoolParent_id(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setPrimarySchoolParent_id(primarySchoolParent_id);
		}

		if (primaryStudent_id == null) {
			primarySchoolParentImpl.setPrimaryStudent_id(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setPrimaryStudent_id(primaryStudent_id);
		}

		if (name == null) {
			primarySchoolParentImpl.setName(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setName(name);
		}

		if (nationality == null) {
			primarySchoolParentImpl.setNationality(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setNationality(nationality);
		}

		if (idCardNumber == null) {
			primarySchoolParentImpl.setIdCardNumber(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setIdCardNumber(idCardNumber);
		}

		if (phoneNumber == null) {
			primarySchoolParentImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setPhoneNumber(phoneNumber);
		}

		if (Email == null) {
			primarySchoolParentImpl.setEmail(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setEmail(Email);
		}

		if (job == null) {
			primarySchoolParentImpl.setJob(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setJob(job);
		}

		if (job_position == null) {
			primarySchoolParentImpl.setJob_position(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setJob_position(job_position);
		}

		if (workplace == null) {
			primarySchoolParentImpl.setWorkplace(StringPool.BLANK);
		}
		else {
			primarySchoolParentImpl.setWorkplace(workplace);
		}

		primarySchoolParentImpl.setIsMother(isMother);

		if (created_date == Long.MIN_VALUE) {
			primarySchoolParentImpl.setCreated_date(null);
		}
		else {
			primarySchoolParentImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			primarySchoolParentImpl.setModified_date(null);
		}
		else {
			primarySchoolParentImpl.setModified_date(new Date(modified_date));
		}

		primarySchoolParentImpl.setDeleted(deleted);

		primarySchoolParentImpl.resetOriginalValues();

		return primarySchoolParentImpl;
	}

	public String primarySchoolParent_id;
	public String primaryStudent_id;
	public String name;
	public String nationality;
	public String idCardNumber;
	public String phoneNumber;
	public String Email;
	public String job;
	public String job_position;
	public String workplace;
	public boolean isMother;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}