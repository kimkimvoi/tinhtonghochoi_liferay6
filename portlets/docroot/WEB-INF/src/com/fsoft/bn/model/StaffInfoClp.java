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

import com.fsoft.bn.service.StaffInfoLocalServiceUtil;

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
public class StaffInfoClp extends BaseModelImpl<StaffInfo> implements StaffInfo {
	public StaffInfoClp() {
	}

	public Class<?> getModelClass() {
		return StaffInfo.class;
	}

	public String getModelClassName() {
		return StaffInfo.class.getName();
	}

	public long getPrimaryKey() {
		return _staff_id;
	}

	public void setPrimaryKey(long primaryKey) {
		setStaff_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_staff_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("staff_id", getStaff_id());
		attributes.put("staff_firstname", getStaff_firstname());
		attributes.put("staff_middlename", getStaff_middlename());
		attributes.put("staff_lastname", getStaff_lastname());
		attributes.put("staff_birthday", getStaff_birthday());
		attributes.put("staff_phone", getStaff_phone());
		attributes.put("staff_email", getStaff_email());
		attributes.put("staff_sex", getStaff_sex());
		attributes.put("staff_role", getStaff_role());
		attributes.put("deleted", getDeleted());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("organizations_id", getOrganizations_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long staff_id = (Long)attributes.get("staff_id");

		if (staff_id != null) {
			setStaff_id(staff_id);
		}

		String staff_firstname = (String)attributes.get("staff_firstname");

		if (staff_firstname != null) {
			setStaff_firstname(staff_firstname);
		}

		String staff_middlename = (String)attributes.get("staff_middlename");

		if (staff_middlename != null) {
			setStaff_middlename(staff_middlename);
		}

		String staff_lastname = (String)attributes.get("staff_lastname");

		if (staff_lastname != null) {
			setStaff_lastname(staff_lastname);
		}

		Date staff_birthday = (Date)attributes.get("staff_birthday");

		if (staff_birthday != null) {
			setStaff_birthday(staff_birthday);
		}

		String staff_phone = (String)attributes.get("staff_phone");

		if (staff_phone != null) {
			setStaff_phone(staff_phone);
		}

		String staff_email = (String)attributes.get("staff_email");

		if (staff_email != null) {
			setStaff_email(staff_email);
		}

		String staff_sex = (String)attributes.get("staff_sex");

		if (staff_sex != null) {
			setStaff_sex(staff_sex);
		}

		String staff_role = (String)attributes.get("staff_role");

		if (staff_role != null) {
			setStaff_role(staff_role);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long organizations_id = (Long)attributes.get("organizations_id");

		if (organizations_id != null) {
			setOrganizations_id(organizations_id);
		}
	}

	public long getStaff_id() {
		return _staff_id;
	}

	public void setStaff_id(long staff_id) {
		_staff_id = staff_id;
	}

	public String getStaff_firstname() {
		return _staff_firstname;
	}

	public void setStaff_firstname(String staff_firstname) {
		_staff_firstname = staff_firstname;
	}

	public String getStaff_middlename() {
		return _staff_middlename;
	}

	public void setStaff_middlename(String staff_middlename) {
		_staff_middlename = staff_middlename;
	}

	public String getStaff_lastname() {
		return _staff_lastname;
	}

	public void setStaff_lastname(String staff_lastname) {
		_staff_lastname = staff_lastname;
	}

	public Date getStaff_birthday() {
		return _staff_birthday;
	}

	public void setStaff_birthday(Date staff_birthday) {
		_staff_birthday = staff_birthday;
	}

	public String getStaff_phone() {
		return _staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		_staff_phone = staff_phone;
	}

	public String getStaff_email() {
		return _staff_email;
	}

	public void setStaff_email(String staff_email) {
		_staff_email = staff_email;
	}

	public String getStaff_sex() {
		return _staff_sex;
	}

	public void setStaff_sex(String staff_sex) {
		_staff_sex = staff_sex;
	}

	public String getStaff_role() {
		return _staff_role;
	}

	public void setStaff_role(String staff_role) {
		_staff_role = staff_role;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getOrganizations_id() {
		return _organizations_id;
	}

	public void setOrganizations_id(long organizations_id) {
		_organizations_id = organizations_id;
	}

	public java.lang.String getOrganizations_name() {
		throw new UnsupportedOperationException();
	}

	public void setOrganizations_name(java.lang.String _organizations_name) {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getStaffInfoRemoteModel() {
		return _staffInfoRemoteModel;
	}

	public void setStaffInfoRemoteModel(BaseModel<?> staffInfoRemoteModel) {
		_staffInfoRemoteModel = staffInfoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			StaffInfoLocalServiceUtil.addStaffInfo(this);
		}
		else {
			StaffInfoLocalServiceUtil.updateStaffInfo(this);
		}
	}

	@Override
	public StaffInfo toEscapedModel() {
		return (StaffInfo)Proxy.newProxyInstance(StaffInfo.class.getClassLoader(),
			new Class[] { StaffInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StaffInfoClp clone = new StaffInfoClp();

		clone.setStaff_id(getStaff_id());
		clone.setStaff_firstname(getStaff_firstname());
		clone.setStaff_middlename(getStaff_middlename());
		clone.setStaff_lastname(getStaff_lastname());
		clone.setStaff_birthday(getStaff_birthday());
		clone.setStaff_phone(getStaff_phone());
		clone.setStaff_email(getStaff_email());
		clone.setStaff_sex(getStaff_sex());
		clone.setStaff_role(getStaff_role());
		clone.setDeleted(getDeleted());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setOrganizations_id(getOrganizations_id());

		return clone;
	}

	public int compareTo(StaffInfo staffInfo) {
		int value = 0;

		if (getStaff_id() < staffInfo.getStaff_id()) {
			value = -1;
		}
		else if (getStaff_id() > staffInfo.getStaff_id()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		StaffInfoClp staffInfo = null;

		try {
			staffInfo = (StaffInfoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = staffInfo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{staff_id=");
		sb.append(getStaff_id());
		sb.append(", staff_firstname=");
		sb.append(getStaff_firstname());
		sb.append(", staff_middlename=");
		sb.append(getStaff_middlename());
		sb.append(", staff_lastname=");
		sb.append(getStaff_lastname());
		sb.append(", staff_birthday=");
		sb.append(getStaff_birthday());
		sb.append(", staff_phone=");
		sb.append(getStaff_phone());
		sb.append(", staff_email=");
		sb.append(getStaff_email());
		sb.append(", staff_sex=");
		sb.append(getStaff_sex());
		sb.append(", staff_role=");
		sb.append(getStaff_role());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", organizations_id=");
		sb.append(getOrganizations_id());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.StaffInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>staff_id</column-name><column-value><![CDATA[");
		sb.append(getStaff_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staff_firstname</column-name><column-value><![CDATA[");
		sb.append(getStaff_firstname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staff_middlename</column-name><column-value><![CDATA[");
		sb.append(getStaff_middlename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staff_lastname</column-name><column-value><![CDATA[");
		sb.append(getStaff_lastname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staff_birthday</column-name><column-value><![CDATA[");
		sb.append(getStaff_birthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staff_phone</column-name><column-value><![CDATA[");
		sb.append(getStaff_phone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staff_email</column-name><column-value><![CDATA[");
		sb.append(getStaff_email());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staff_sex</column-name><column-value><![CDATA[");
		sb.append(getStaff_sex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staff_role</column-name><column-value><![CDATA[");
		sb.append(getStaff_role());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizations_id</column-name><column-value><![CDATA[");
		sb.append(getOrganizations_id());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _staff_id;
	private String _staff_firstname;
	private String _staff_middlename;
	private String _staff_lastname;
	private Date _staff_birthday;
	private String _staff_phone;
	private String _staff_email;
	private String _staff_sex;
	private String _staff_role;
	private boolean _deleted;
	private Date _createDate;
	private Date _modifiedDate;
	private long _organizations_id;
	private BaseModel<?> _staffInfoRemoteModel;
}