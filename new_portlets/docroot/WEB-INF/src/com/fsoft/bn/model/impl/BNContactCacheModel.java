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

import com.fsoft.bn.model.BNContact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing BNContact in entity cache.
 *
 * @author FSOFT
 * @see BNContact
 * @generated
 */
public class BNContactCacheModel implements CacheModel<BNContact>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{contactId=");
		sb.append(contactId);
		sb.append(", departmentKey=");
		sb.append(departmentKey);
		sb.append(", name=");
		sb.append(name);
		sb.append(", regency=");
		sb.append(regency);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public BNContact toEntityModel() {
		BNContactImpl bnContactImpl = new BNContactImpl();

		bnContactImpl.setContactId(contactId);

		if (departmentKey == null) {
			bnContactImpl.setDepartmentKey(StringPool.BLANK);
		}
		else {
			bnContactImpl.setDepartmentKey(departmentKey);
		}

		if (name == null) {
			bnContactImpl.setName(StringPool.BLANK);
		}
		else {
			bnContactImpl.setName(name);
		}

		if (regency == null) {
			bnContactImpl.setRegency(StringPool.BLANK);
		}
		else {
			bnContactImpl.setRegency(regency);
		}

		if (phoneNumber == null) {
			bnContactImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			bnContactImpl.setPhoneNumber(phoneNumber);
		}

		if (email == null) {
			bnContactImpl.setEmail(StringPool.BLANK);
		}
		else {
			bnContactImpl.setEmail(email);
		}

		if (createdDate == Long.MIN_VALUE) {
			bnContactImpl.setCreatedDate(null);
		}
		else {
			bnContactImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bnContactImpl.setModifiedDate(null);
		}
		else {
			bnContactImpl.setModifiedDate(new Date(modifiedDate));
		}

		bnContactImpl.setDeleted(deleted);

		bnContactImpl.resetOriginalValues();

		return bnContactImpl;
	}

	public long contactId;
	public String departmentKey;
	public String name;
	public String regency;
	public String phoneNumber;
	public String email;
	public long createdDate;
	public long modifiedDate;
	public boolean deleted;
}