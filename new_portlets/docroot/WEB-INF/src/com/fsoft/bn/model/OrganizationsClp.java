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

import com.fsoft.bn.service.OrganizationsLocalServiceUtil;

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
public class OrganizationsClp extends BaseModelImpl<Organizations>
	implements Organizations {
	public OrganizationsClp() {
	}

	public Class<?> getModelClass() {
		return Organizations.class;
	}

	public String getModelClassName() {
		return Organizations.class.getName();
	}

	public long getPrimaryKey() {
		return _organizations_id;
	}

	public void setPrimaryKey(long primaryKey) {
		setOrganizations_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_organizations_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizations_id", getOrganizations_id());
		attributes.put("organizations_name", getOrganizations_name());
		attributes.put("organizations_description",
			getOrganizations_description());
		attributes.put("organizations_address", getOrganizations_address());
		attributes.put("deleted", getDeleted());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizations_id = (Long)attributes.get("organizations_id");

		if (organizations_id != null) {
			setOrganizations_id(organizations_id);
		}

		String organizations_name = (String)attributes.get("organizations_name");

		if (organizations_name != null) {
			setOrganizations_name(organizations_name);
		}

		String organizations_description = (String)attributes.get(
				"organizations_description");

		if (organizations_description != null) {
			setOrganizations_description(organizations_description);
		}

		String organizations_address = (String)attributes.get(
				"organizations_address");

		if (organizations_address != null) {
			setOrganizations_address(organizations_address);
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
	}

	public long getOrganizations_id() {
		return _organizations_id;
	}

	public void setOrganizations_id(long organizations_id) {
		_organizations_id = organizations_id;
	}

	public String getOrganizations_name() {
		return _organizations_name;
	}

	public void setOrganizations_name(String organizations_name) {
		_organizations_name = organizations_name;
	}

	public String getOrganizations_description() {
		return _organizations_description;
	}

	public void setOrganizations_description(String organizations_description) {
		_organizations_description = organizations_description;
	}

	public String getOrganizations_address() {
		return _organizations_address;
	}

	public void setOrganizations_address(String organizations_address) {
		_organizations_address = organizations_address;
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

	public BaseModel<?> getOrganizationsRemoteModel() {
		return _organizationsRemoteModel;
	}

	public void setOrganizationsRemoteModel(
		BaseModel<?> organizationsRemoteModel) {
		_organizationsRemoteModel = organizationsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			OrganizationsLocalServiceUtil.addOrganizations(this);
		}
		else {
			OrganizationsLocalServiceUtil.updateOrganizations(this);
		}
	}

	@Override
	public Organizations toEscapedModel() {
		return (Organizations)Proxy.newProxyInstance(Organizations.class.getClassLoader(),
			new Class[] { Organizations.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrganizationsClp clone = new OrganizationsClp();

		clone.setOrganizations_id(getOrganizations_id());
		clone.setOrganizations_name(getOrganizations_name());
		clone.setOrganizations_description(getOrganizations_description());
		clone.setOrganizations_address(getOrganizations_address());
		clone.setDeleted(getDeleted());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(Organizations organizations) {
		int value = 0;

		if (getOrganizations_id() < organizations.getOrganizations_id()) {
			value = -1;
		}
		else if (getOrganizations_id() > organizations.getOrganizations_id()) {
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

		OrganizationsClp organizations = null;

		try {
			organizations = (OrganizationsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = organizations.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{organizations_id=");
		sb.append(getOrganizations_id());
		sb.append(", organizations_name=");
		sb.append(getOrganizations_name());
		sb.append(", organizations_description=");
		sb.append(getOrganizations_description());
		sb.append(", organizations_address=");
		sb.append(getOrganizations_address());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.Organizations");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>organizations_id</column-name><column-value><![CDATA[");
		sb.append(getOrganizations_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizations_name</column-name><column-value><![CDATA[");
		sb.append(getOrganizations_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizations_description</column-name><column-value><![CDATA[");
		sb.append(getOrganizations_description());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizations_address</column-name><column-value><![CDATA[");
		sb.append(getOrganizations_address());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _organizations_id;
	private String _organizations_name;
	private String _organizations_description;
	private String _organizations_address;
	private boolean _deleted;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _organizationsRemoteModel;
}