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

import com.fsoft.bn.model.StaffInfo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing StaffInfo in entity cache.
 *
 * @author FSOFT
 * @see StaffInfo
 * @generated
 */
public class StaffInfoCacheModel implements CacheModel<StaffInfo>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{staff_id=");
		sb.append(staff_id);
		sb.append(", staff_firstname=");
		sb.append(staff_firstname);
		sb.append(", staff_middlename=");
		sb.append(staff_middlename);
		sb.append(", staff_lastname=");
		sb.append(staff_lastname);
		sb.append(", staff_birthday=");
		sb.append(staff_birthday);
		sb.append(", staff_phone=");
		sb.append(staff_phone);
		sb.append(", staff_email=");
		sb.append(staff_email);
		sb.append(", staff_sex=");
		sb.append(staff_sex);
		sb.append(", staff_role=");
		sb.append(staff_role);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", organizations_id=");
		sb.append(organizations_id);
		sb.append("}");

		return sb.toString();
	}

	public StaffInfo toEntityModel() {
		StaffInfoImpl staffInfoImpl = new StaffInfoImpl();

		staffInfoImpl.setStaff_id(staff_id);

		if (staff_firstname == null) {
			staffInfoImpl.setStaff_firstname(StringPool.BLANK);
		}
		else {
			staffInfoImpl.setStaff_firstname(staff_firstname);
		}

		if (staff_middlename == null) {
			staffInfoImpl.setStaff_middlename(StringPool.BLANK);
		}
		else {
			staffInfoImpl.setStaff_middlename(staff_middlename);
		}

		if (staff_lastname == null) {
			staffInfoImpl.setStaff_lastname(StringPool.BLANK);
		}
		else {
			staffInfoImpl.setStaff_lastname(staff_lastname);
		}

		if (staff_birthday == Long.MIN_VALUE) {
			staffInfoImpl.setStaff_birthday(null);
		}
		else {
			staffInfoImpl.setStaff_birthday(new Date(staff_birthday));
		}

		if (staff_phone == null) {
			staffInfoImpl.setStaff_phone(StringPool.BLANK);
		}
		else {
			staffInfoImpl.setStaff_phone(staff_phone);
		}

		if (staff_email == null) {
			staffInfoImpl.setStaff_email(StringPool.BLANK);
		}
		else {
			staffInfoImpl.setStaff_email(staff_email);
		}

		if (staff_sex == null) {
			staffInfoImpl.setStaff_sex(StringPool.BLANK);
		}
		else {
			staffInfoImpl.setStaff_sex(staff_sex);
		}

		if (staff_role == null) {
			staffInfoImpl.setStaff_role(StringPool.BLANK);
		}
		else {
			staffInfoImpl.setStaff_role(staff_role);
		}

		staffInfoImpl.setDeleted(deleted);

		if (createDate == Long.MIN_VALUE) {
			staffInfoImpl.setCreateDate(null);
		}
		else {
			staffInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			staffInfoImpl.setModifiedDate(null);
		}
		else {
			staffInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		staffInfoImpl.setOrganizations_id(organizations_id);

		staffInfoImpl.resetOriginalValues();

		return staffInfoImpl;
	}

	public long staff_id;
	public String staff_firstname;
	public String staff_middlename;
	public String staff_lastname;
	public long staff_birthday;
	public String staff_phone;
	public String staff_email;
	public String staff_sex;
	public String staff_role;
	public boolean deleted;
	public long createDate;
	public long modifiedDate;
	public long organizations_id;
}