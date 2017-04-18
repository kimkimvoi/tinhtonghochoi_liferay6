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

import com.fsoft.bn.service.UserfulContactPhoneLocalServiceUtil;

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
public class UserfulContactPhoneClp extends BaseModelImpl<UserfulContactPhone>
	implements UserfulContactPhone {
	public UserfulContactPhoneClp() {
	}

	public Class<?> getModelClass() {
		return UserfulContactPhone.class;
	}

	public String getModelClassName() {
		return UserfulContactPhone.class.getName();
	}

	public String getPrimaryKey() {
		return _userful_contact_phone_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setUserful_contact_phone_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _userful_contact_phone_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userful_contact_phone_id", getUserful_contact_phone_id());
		attributes.put("userful_contact_name", getUserful_contact_name());
		attributes.put("userful_contact_phone", getUserful_contact_phone());
		attributes.put("userful_contact_email", getUserful_contact_email());
		attributes.put("userful_contact_position", getUserful_contact_position());
		attributes.put("userful_contact_address", getUserful_contact_address());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String userful_contact_phone_id = (String)attributes.get(
				"userful_contact_phone_id");

		if (userful_contact_phone_id != null) {
			setUserful_contact_phone_id(userful_contact_phone_id);
		}

		String userful_contact_name = (String)attributes.get(
				"userful_contact_name");

		if (userful_contact_name != null) {
			setUserful_contact_name(userful_contact_name);
		}

		String userful_contact_phone = (String)attributes.get(
				"userful_contact_phone");

		if (userful_contact_phone != null) {
			setUserful_contact_phone(userful_contact_phone);
		}

		String userful_contact_email = (String)attributes.get(
				"userful_contact_email");

		if (userful_contact_email != null) {
			setUserful_contact_email(userful_contact_email);
		}

		String userful_contact_position = (String)attributes.get(
				"userful_contact_position");

		if (userful_contact_position != null) {
			setUserful_contact_position(userful_contact_position);
		}

		String userful_contact_address = (String)attributes.get(
				"userful_contact_address");

		if (userful_contact_address != null) {
			setUserful_contact_address(userful_contact_address);
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

	public String getUserful_contact_phone_id() {
		return _userful_contact_phone_id;
	}

	public void setUserful_contact_phone_id(String userful_contact_phone_id) {
		_userful_contact_phone_id = userful_contact_phone_id;
	}

	public String getUserful_contact_name() {
		return _userful_contact_name;
	}

	public void setUserful_contact_name(String userful_contact_name) {
		_userful_contact_name = userful_contact_name;
	}

	public String getUserful_contact_phone() {
		return _userful_contact_phone;
	}

	public void setUserful_contact_phone(String userful_contact_phone) {
		_userful_contact_phone = userful_contact_phone;
	}

	public String getUserful_contact_email() {
		return _userful_contact_email;
	}

	public void setUserful_contact_email(String userful_contact_email) {
		_userful_contact_email = userful_contact_email;
	}

	public String getUserful_contact_position() {
		return _userful_contact_position;
	}

	public void setUserful_contact_position(String userful_contact_position) {
		_userful_contact_position = userful_contact_position;
	}

	public String getUserful_contact_address() {
		return _userful_contact_address;
	}

	public void setUserful_contact_address(String userful_contact_address) {
		_userful_contact_address = userful_contact_address;
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

	public BaseModel<?> getUserfulContactPhoneRemoteModel() {
		return _userfulContactPhoneRemoteModel;
	}

	public void setUserfulContactPhoneRemoteModel(
		BaseModel<?> userfulContactPhoneRemoteModel) {
		_userfulContactPhoneRemoteModel = userfulContactPhoneRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UserfulContactPhoneLocalServiceUtil.addUserfulContactPhone(this);
		}
		else {
			UserfulContactPhoneLocalServiceUtil.updateUserfulContactPhone(this);
		}
	}

	@Override
	public UserfulContactPhone toEscapedModel() {
		return (UserfulContactPhone)Proxy.newProxyInstance(UserfulContactPhone.class.getClassLoader(),
			new Class[] { UserfulContactPhone.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserfulContactPhoneClp clone = new UserfulContactPhoneClp();

		clone.setUserful_contact_phone_id(getUserful_contact_phone_id());
		clone.setUserful_contact_name(getUserful_contact_name());
		clone.setUserful_contact_phone(getUserful_contact_phone());
		clone.setUserful_contact_email(getUserful_contact_email());
		clone.setUserful_contact_position(getUserful_contact_position());
		clone.setUserful_contact_address(getUserful_contact_address());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(UserfulContactPhone userfulContactPhone) {
		String primaryKey = userfulContactPhone.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserfulContactPhoneClp userfulContactPhone = null;

		try {
			userfulContactPhone = (UserfulContactPhoneClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = userfulContactPhone.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{userful_contact_phone_id=");
		sb.append(getUserful_contact_phone_id());
		sb.append(", userful_contact_name=");
		sb.append(getUserful_contact_name());
		sb.append(", userful_contact_phone=");
		sb.append(getUserful_contact_phone());
		sb.append(", userful_contact_email=");
		sb.append(getUserful_contact_email());
		sb.append(", userful_contact_position=");
		sb.append(getUserful_contact_position());
		sb.append(", userful_contact_address=");
		sb.append(getUserful_contact_address());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.UserfulContactPhone");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userful_contact_phone_id</column-name><column-value><![CDATA[");
		sb.append(getUserful_contact_phone_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userful_contact_name</column-name><column-value><![CDATA[");
		sb.append(getUserful_contact_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userful_contact_phone</column-name><column-value><![CDATA[");
		sb.append(getUserful_contact_phone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userful_contact_email</column-name><column-value><![CDATA[");
		sb.append(getUserful_contact_email());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userful_contact_position</column-name><column-value><![CDATA[");
		sb.append(getUserful_contact_position());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userful_contact_address</column-name><column-value><![CDATA[");
		sb.append(getUserful_contact_address());
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

	private String _userful_contact_phone_id;
	private String _userful_contact_name;
	private String _userful_contact_phone;
	private String _userful_contact_email;
	private String _userful_contact_position;
	private String _userful_contact_address;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _userfulContactPhoneRemoteModel;
}