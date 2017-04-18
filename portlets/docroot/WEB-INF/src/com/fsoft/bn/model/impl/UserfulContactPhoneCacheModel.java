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

import com.fsoft.bn.model.UserfulContactPhone;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UserfulContactPhone in entity cache.
 *
 * @author FSOFT
 * @see UserfulContactPhone
 * @generated
 */
public class UserfulContactPhoneCacheModel implements CacheModel<UserfulContactPhone>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{userful_contact_phone_id=");
		sb.append(userful_contact_phone_id);
		sb.append(", userful_contact_name=");
		sb.append(userful_contact_name);
		sb.append(", userful_contact_phone=");
		sb.append(userful_contact_phone);
		sb.append(", userful_contact_email=");
		sb.append(userful_contact_email);
		sb.append(", userful_contact_position=");
		sb.append(userful_contact_position);
		sb.append(", userful_contact_address=");
		sb.append(userful_contact_address);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public UserfulContactPhone toEntityModel() {
		UserfulContactPhoneImpl userfulContactPhoneImpl = new UserfulContactPhoneImpl();

		if (userful_contact_phone_id == null) {
			userfulContactPhoneImpl.setUserful_contact_phone_id(StringPool.BLANK);
		}
		else {
			userfulContactPhoneImpl.setUserful_contact_phone_id(userful_contact_phone_id);
		}

		if (userful_contact_name == null) {
			userfulContactPhoneImpl.setUserful_contact_name(StringPool.BLANK);
		}
		else {
			userfulContactPhoneImpl.setUserful_contact_name(userful_contact_name);
		}

		if (userful_contact_phone == null) {
			userfulContactPhoneImpl.setUserful_contact_phone(StringPool.BLANK);
		}
		else {
			userfulContactPhoneImpl.setUserful_contact_phone(userful_contact_phone);
		}

		if (userful_contact_email == null) {
			userfulContactPhoneImpl.setUserful_contact_email(StringPool.BLANK);
		}
		else {
			userfulContactPhoneImpl.setUserful_contact_email(userful_contact_email);
		}

		if (userful_contact_position == null) {
			userfulContactPhoneImpl.setUserful_contact_position(StringPool.BLANK);
		}
		else {
			userfulContactPhoneImpl.setUserful_contact_position(userful_contact_position);
		}

		if (userful_contact_address == null) {
			userfulContactPhoneImpl.setUserful_contact_address(StringPool.BLANK);
		}
		else {
			userfulContactPhoneImpl.setUserful_contact_address(userful_contact_address);
		}

		if (created_date == Long.MIN_VALUE) {
			userfulContactPhoneImpl.setCreated_date(null);
		}
		else {
			userfulContactPhoneImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			userfulContactPhoneImpl.setModified_date(null);
		}
		else {
			userfulContactPhoneImpl.setModified_date(new Date(modified_date));
		}

		userfulContactPhoneImpl.setDeleted(deleted);

		userfulContactPhoneImpl.resetOriginalValues();

		return userfulContactPhoneImpl;
	}

	public String userful_contact_phone_id;
	public String userful_contact_name;
	public String userful_contact_phone;
	public String userful_contact_email;
	public String userful_contact_position;
	public String userful_contact_address;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}